package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.RC5Parameters;

public class RC532Engine
  implements BlockCipher
{
  private static final int P32 = -1209970333;
  private static final int Q32 = -1640531527;
  private int[] _S = null;
  private int _noRounds = 12;
  private boolean forEncryption;
  
  private int bytesToWord(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    int j = paramArrayOfByte[(paramInt + 1)];
    int k = paramArrayOfByte[(paramInt + 2)];
    return (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
  }
  
  private int decryptBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int i = bytesToWord(paramArrayOfByte1, paramInt1);
    int j = bytesToWord(paramArrayOfByte1, paramInt1 + 4);
    paramInt1 = this._noRounds;
    while (paramInt1 >= 1)
    {
      paramArrayOfByte1 = this._S;
      int k = paramInt1 * 2;
      j = rotateRight(j - paramArrayOfByte1[(k + 1)], i) ^ i;
      i = rotateRight(i - this._S[k], j) ^ j;
      paramInt1 -= 1;
    }
    wordToBytes(i - this._S[0], paramArrayOfByte2, paramInt2);
    wordToBytes(j - this._S[1], paramArrayOfByte2, paramInt2 + 4);
    return 8;
  }
  
  private int encryptBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int j = bytesToWord(paramArrayOfByte1, paramInt1) + this._S[0];
    int i = bytesToWord(paramArrayOfByte1, paramInt1 + 4) + this._S[1];
    paramInt1 = 1;
    while (paramInt1 <= this._noRounds)
    {
      j = rotateLeft(j ^ i, i);
      paramArrayOfByte1 = this._S;
      int k = paramInt1 * 2;
      j += paramArrayOfByte1[k];
      i = rotateLeft(i ^ j, j) + this._S[(k + 1)];
      paramInt1 += 1;
    }
    wordToBytes(j, paramArrayOfByte2, paramInt2);
    wordToBytes(i, paramArrayOfByte2, paramInt2 + 4);
    return 8;
  }
  
  private int rotateLeft(int paramInt1, int paramInt2)
  {
    paramInt2 &= 0x1F;
    return paramInt1 >>> 32 - paramInt2 | paramInt1 << paramInt2;
  }
  
  private int rotateRight(int paramInt1, int paramInt2)
  {
    paramInt2 &= 0x1F;
    return paramInt1 << 32 - paramInt2 | paramInt1 >>> paramInt2;
  }
  
  private void setKey(byte[] paramArrayOfByte)
  {
    int i2 = (paramArrayOfByte.length + 3) / 4;
    int[] arrayOfInt = new int[i2];
    int m = 0;
    int i = 0;
    while (i != paramArrayOfByte.length)
    {
      j = i / 4;
      arrayOfInt[j] += ((paramArrayOfByte[i] & 0xFF) << i % 4 * 8);
      i += 1;
    }
    paramArrayOfByte = new int[(this._noRounds + 1) * 2];
    this._S = paramArrayOfByte;
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
    int k = 0;
    int j = 0;
    while (m < i)
    {
      paramArrayOfByte = this._S;
      i1 = rotateLeft(paramArrayOfByte[n] + i1 + k, 3);
      paramArrayOfByte[n] = i1;
      k = rotateLeft(arrayOfInt[j] + i1 + k, k + i1);
      arrayOfInt[j] = k;
      n = (n + 1) % this._S.length;
      j = (j + 1) % i2;
      m += 1;
    }
  }
  
  private void wordToBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[paramInt2] = ((byte)paramInt1);
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 8));
    paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 >> 16));
    paramArrayOfByte[(paramInt2 + 3)] = ((byte)(paramInt1 >> 24));
  }
  
  public String getAlgorithmName()
  {
    return "RC5-32";
  }
  
  public int getBlockSize()
  {
    return 8;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    if ((paramCipherParameters instanceof RC5Parameters))
    {
      paramCipherParameters = (RC5Parameters)paramCipherParameters;
      this._noRounds = paramCipherParameters.getRounds();
      setKey(paramCipherParameters.getKey());
    }
    else
    {
      if (!(paramCipherParameters instanceof KeyParameter)) {
        break label55;
      }
      setKey(((KeyParameter)paramCipherParameters).getKey());
    }
    this.forEncryption = paramBoolean;
    return;
    label55:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invalid parameter passed to RC532 init - ");
    localStringBuilder.append(paramCipherParameters.getClass().getName());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public int processBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    if (this.forEncryption) {
      return encryptBlock(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
    }
    return decryptBlock(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
  }
  
  public void reset() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\RC532Engine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */