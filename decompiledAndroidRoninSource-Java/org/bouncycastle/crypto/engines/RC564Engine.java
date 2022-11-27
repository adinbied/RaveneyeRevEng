package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.RC5Parameters;

public class RC564Engine
  implements BlockCipher
{
  private static final long P64 = -5196783011329398165L;
  private static final long Q64 = -7046029254386353131L;
  private static final int bytesPerWord = 8;
  private static final int wordSize = 64;
  private long[] _S = null;
  private int _noRounds = 12;
  private boolean forEncryption;
  
  private long bytesToWord(byte[] paramArrayOfByte, int paramInt)
  {
    long l = 0L;
    int i = 7;
    while (i >= 0)
    {
      l = (l << 8) + (paramArrayOfByte[(i + paramInt)] & 0xFF);
      i -= 1;
    }
    return l;
  }
  
  private int decryptBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    long l1 = bytesToWord(paramArrayOfByte1, paramInt1);
    long l2 = bytesToWord(paramArrayOfByte1, paramInt1 + 8);
    paramInt1 = this._noRounds;
    while (paramInt1 >= 1)
    {
      paramArrayOfByte1 = this._S;
      int i = paramInt1 * 2;
      l2 = rotateRight(l2 - paramArrayOfByte1[(i + 1)], l1) ^ l1;
      l1 = rotateRight(l1 - this._S[i], l2) ^ l2;
      paramInt1 -= 1;
    }
    wordToBytes(l1 - this._S[0], paramArrayOfByte2, paramInt2);
    wordToBytes(l2 - this._S[1], paramArrayOfByte2, paramInt2 + 8);
    return 16;
  }
  
  private int encryptBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    long l2 = bytesToWord(paramArrayOfByte1, paramInt1) + this._S[0];
    long l1 = bytesToWord(paramArrayOfByte1, paramInt1 + 8) + this._S[1];
    paramInt1 = 1;
    while (paramInt1 <= this._noRounds)
    {
      l2 = rotateLeft(l2 ^ l1, l1);
      paramArrayOfByte1 = this._S;
      int i = paramInt1 * 2;
      l2 += paramArrayOfByte1[i];
      l1 = rotateLeft(l1 ^ l2, l2) + this._S[(i + 1)];
      paramInt1 += 1;
    }
    wordToBytes(l2, paramArrayOfByte2, paramInt2);
    wordToBytes(l1, paramArrayOfByte2, paramInt2 + 8);
    return 16;
  }
  
  private long rotateLeft(long paramLong1, long paramLong2)
  {
    paramLong2 &= 0x3F;
    int i = (int)paramLong2;
    return paramLong1 >>> (int)(64L - paramLong2) | paramLong1 << i;
  }
  
  private long rotateRight(long paramLong1, long paramLong2)
  {
    paramLong2 &= 0x3F;
    int i = (int)paramLong2;
    return paramLong1 << (int)(64L - paramLong2) | paramLong1 >>> i;
  }
  
  private void setKey(byte[] paramArrayOfByte)
  {
    int n = (paramArrayOfByte.length + 7) / 8;
    long[] arrayOfLong = new long[n];
    int k = 0;
    int i = 0;
    while (i != paramArrayOfByte.length)
    {
      j = i / 8;
      arrayOfLong[j] += ((paramArrayOfByte[i] & 0xFF) << i % 8 * 8);
      i += 1;
    }
    paramArrayOfByte = new long[(this._noRounds + 1) * 2];
    this._S = paramArrayOfByte;
    paramArrayOfByte[0] = -5196783011329398165L;
    i = 1;
    for (;;)
    {
      paramArrayOfByte = this._S;
      if (i >= paramArrayOfByte.length) {
        break;
      }
      paramArrayOfByte[i] = (paramArrayOfByte[(i - 1)] - 7046029254386353131L);
      i += 1;
    }
    if (n > paramArrayOfByte.length) {
      i = n * 3;
    } else {
      i = paramArrayOfByte.length * 3;
    }
    long l2 = 0L;
    long l1 = l2;
    int m = 0;
    int j = 0;
    while (k < i)
    {
      paramArrayOfByte = this._S;
      l2 = rotateLeft(paramArrayOfByte[m] + l2 + l1, 3L);
      paramArrayOfByte[m] = l2;
      l1 = rotateLeft(arrayOfLong[j] + l2 + l1, l1 + l2);
      arrayOfLong[j] = l1;
      m = (m + 1) % this._S.length;
      j = (j + 1) % n;
      k += 1;
    }
  }
  
  private void wordToBytes(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    while (i < 8)
    {
      paramArrayOfByte[(i + paramInt)] = ((byte)(int)paramLong);
      paramLong >>>= 8;
      i += 1;
    }
  }
  
  public String getAlgorithmName()
  {
    return "RC5-64";
  }
  
  public int getBlockSize()
  {
    return 16;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    if ((paramCipherParameters instanceof RC5Parameters))
    {
      paramCipherParameters = (RC5Parameters)paramCipherParameters;
      this.forEncryption = paramBoolean;
      this._noRounds = paramCipherParameters.getRounds();
      setKey(paramCipherParameters.getKey());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invalid parameter passed to RC564 init - ");
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\RC564Engine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */