package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;

public class RC6Engine
  implements BlockCipher
{
  private static final int LGW = 5;
  private static final int P32 = -1209970333;
  private static final int Q32 = -1640531527;
  private static final int _noRounds = 20;
  private static final int bytesPerWord = 4;
  private static final int wordSize = 32;
  private int[] _S = null;
  private boolean forEncryption;
  
  private int bytesToWord(byte[] paramArrayOfByte, int paramInt)
  {
    int j = 0;
    int i = 3;
    while (i >= 0)
    {
      j = (j << 8) + (paramArrayOfByte[(i + paramInt)] & 0xFF);
      i -= 1;
    }
    return j;
  }
  
  private int decryptBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int i = bytesToWord(paramArrayOfByte1, paramInt1);
    int k = bytesToWord(paramArrayOfByte1, paramInt1 + 4);
    int m = bytesToWord(paramArrayOfByte1, paramInt1 + 8);
    int j = bytesToWord(paramArrayOfByte1, paramInt1 + 12);
    paramArrayOfByte1 = this._S;
    paramInt1 = m - paramArrayOfByte1[43];
    i -= paramArrayOfByte1[42];
    m = 20;
    while (m >= 1)
    {
      n = rotateLeft((i * 2 + 1) * i, 5);
      int i1 = rotateLeft((paramInt1 * 2 + 1) * paramInt1, 5);
      paramArrayOfByte1 = this._S;
      int i2 = m * 2;
      k = rotateRight(k - paramArrayOfByte1[(i2 + 1)], n);
      j = rotateRight(j - this._S[i2], i1);
      m -= 1;
      n = j ^ n;
      j = paramInt1;
      paramInt1 = k ^ i1;
      k = i;
      i = n;
    }
    paramArrayOfByte1 = this._S;
    m = paramArrayOfByte1[1];
    int n = paramArrayOfByte1[0];
    wordToBytes(i, paramArrayOfByte2, paramInt2);
    wordToBytes(k - n, paramArrayOfByte2, paramInt2 + 4);
    wordToBytes(paramInt1, paramArrayOfByte2, paramInt2 + 8);
    wordToBytes(j - m, paramArrayOfByte2, paramInt2 + 12);
    return 16;
  }
  
  private int encryptBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int m = bytesToWord(paramArrayOfByte1, paramInt1);
    int i = bytesToWord(paramArrayOfByte1, paramInt1 + 4);
    int j = bytesToWord(paramArrayOfByte1, paramInt1 + 8);
    int k = bytesToWord(paramArrayOfByte1, paramInt1 + 12);
    paramArrayOfByte1 = this._S;
    paramInt1 = i + paramArrayOfByte1[0];
    i = k + paramArrayOfByte1[1];
    k = 1;
    while (k <= 20)
    {
      int i1 = rotateLeft((paramInt1 * 2 + 1) * paramInt1, 5);
      int i2 = rotateLeft((i * 2 + 1) * i, 5);
      m = rotateLeft(m ^ i1, i2);
      paramArrayOfByte1 = this._S;
      int i3 = k * 2;
      n = paramArrayOfByte1[i3];
      j = rotateLeft(j ^ i2, i1);
      i1 = this._S[(i3 + 1)];
      k += 1;
      n = m + n;
      j += i1;
      m = paramInt1;
      paramInt1 = j;
      j = i;
      i = n;
    }
    paramArrayOfByte1 = this._S;
    k = paramArrayOfByte1[42];
    int n = paramArrayOfByte1[43];
    wordToBytes(m + k, paramArrayOfByte2, paramInt2);
    wordToBytes(paramInt1, paramArrayOfByte2, paramInt2 + 4);
    wordToBytes(j + n, paramArrayOfByte2, paramInt2 + 8);
    wordToBytes(i, paramArrayOfByte2, paramInt2 + 12);
    return 16;
  }
  
  private int rotateLeft(int paramInt1, int paramInt2)
  {
    return paramInt1 >>> -paramInt2 | paramInt1 << paramInt2;
  }
  
  private int rotateRight(int paramInt1, int paramInt2)
  {
    return paramInt1 << -paramInt2 | paramInt1 >>> paramInt2;
  }
  
  private void setKey(byte[] paramArrayOfByte)
  {
    int i = (paramArrayOfByte.length + 3) / 4;
    int i2 = (paramArrayOfByte.length + 4 - 1) / 4;
    int[] arrayOfInt = new int[i2];
    i = paramArrayOfByte.length - 1;
    while (i >= 0)
    {
      j = i / 4;
      arrayOfInt[j] = ((arrayOfInt[j] << 8) + (paramArrayOfByte[i] & 0xFF));
      i -= 1;
    }
    paramArrayOfByte = new int[44];
    this._S = paramArrayOfByte;
    int k = 0;
    paramArrayOfByte[0] = -1209970333;
    i = 1;
    for (;;)
    {
      paramArrayOfByte = this._S;
      if (i >= paramArrayOfByte.length) {
        break;
      }
      paramArrayOfByte[i] = (paramArrayOfByte[(i - 1)] - 1640531527);
      i += 1;
    }
    if (i2 > paramArrayOfByte.length) {
      i = i2 * 3;
    } else {
      i = paramArrayOfByte.length * 3;
    }
    int n = 0;
    int i1 = 0;
    int m = 0;
    int j = 0;
    while (k < i)
    {
      paramArrayOfByte = this._S;
      i1 = rotateLeft(paramArrayOfByte[n] + i1 + m, 3);
      paramArrayOfByte[n] = i1;
      m = rotateLeft(arrayOfInt[j] + i1 + m, m + i1);
      arrayOfInt[j] = m;
      n = (n + 1) % this._S.length;
      j = (j + 1) % i2;
      k += 1;
    }
  }
  
  private void wordToBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int j = 0;
    int i = paramInt1;
    paramInt1 = j;
    while (paramInt1 < 4)
    {
      paramArrayOfByte[(paramInt1 + paramInt2)] = ((byte)i);
      i >>>= 8;
      paramInt1 += 1;
    }
  }
  
  public String getAlgorithmName()
  {
    return "RC6";
  }
  
  public int getBlockSize()
  {
    return 16;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    if ((paramCipherParameters instanceof KeyParameter))
    {
      paramCipherParameters = (KeyParameter)paramCipherParameters;
      this.forEncryption = paramBoolean;
      setKey(paramCipherParameters.getKey());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invalid parameter passed to RC6 init - ");
    localStringBuilder.append(paramCipherParameters.getClass().getName());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public int processBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int i = getBlockSize();
    if (this._S != null)
    {
      if (paramInt1 + i <= paramArrayOfByte1.length)
      {
        if (i + paramInt2 <= paramArrayOfByte2.length)
        {
          if (this.forEncryption) {
            return encryptBlock(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
          }
          return decryptBlock(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
        }
        throw new OutputLengthException("output buffer too short");
      }
      throw new DataLengthException("input buffer too short");
    }
    throw new IllegalStateException("RC6 engine not initialised");
  }
  
  public void reset() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\RC6Engine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */