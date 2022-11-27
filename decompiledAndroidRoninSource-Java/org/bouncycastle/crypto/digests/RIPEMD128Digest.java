package org.bouncycastle.crypto.digests;

import org.bouncycastle.util.Memoable;

public class RIPEMD128Digest
  extends GeneralDigest
{
  private static final int DIGEST_LENGTH = 16;
  private int H0;
  private int H1;
  private int H2;
  private int H3;
  private int[] X = new int[16];
  private int xOff;
  
  public RIPEMD128Digest()
  {
    reset();
  }
  
  public RIPEMD128Digest(RIPEMD128Digest paramRIPEMD128Digest)
  {
    super(paramRIPEMD128Digest);
    copyIn(paramRIPEMD128Digest);
  }
  
  private int F1(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return RL(paramInt1 + f1(paramInt2, paramInt3, paramInt4) + paramInt5, paramInt6);
  }
  
  private int F2(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return RL(paramInt1 + f2(paramInt2, paramInt3, paramInt4) + paramInt5 + 1518500249, paramInt6);
  }
  
  private int F3(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return RL(paramInt1 + f3(paramInt2, paramInt3, paramInt4) + paramInt5 + 1859775393, paramInt6);
  }
  
  private int F4(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return RL(paramInt1 + f4(paramInt2, paramInt3, paramInt4) + paramInt5 - 1894007588, paramInt6);
  }
  
  private int FF1(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return RL(paramInt1 + f1(paramInt2, paramInt3, paramInt4) + paramInt5, paramInt6);
  }
  
  private int FF2(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return RL(paramInt1 + f2(paramInt2, paramInt3, paramInt4) + paramInt5 + 1836072691, paramInt6);
  }
  
  private int FF3(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return RL(paramInt1 + f3(paramInt2, paramInt3, paramInt4) + paramInt5 + 1548603684, paramInt6);
  }
  
  private int FF4(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return RL(paramInt1 + f4(paramInt2, paramInt3, paramInt4) + paramInt5 + 1352829926, paramInt6);
  }
  
  private int RL(int paramInt1, int paramInt2)
  {
    return paramInt1 >>> 32 - paramInt2 | paramInt1 << paramInt2;
  }
  
  private void copyIn(RIPEMD128Digest paramRIPEMD128Digest)
  {
    super.copyIn(paramRIPEMD128Digest);
    this.H0 = paramRIPEMD128Digest.H0;
    this.H1 = paramRIPEMD128Digest.H1;
    this.H2 = paramRIPEMD128Digest.H2;
    this.H3 = paramRIPEMD128Digest.H3;
    int[] arrayOfInt = paramRIPEMD128Digest.X;
    System.arraycopy(arrayOfInt, 0, this.X, 0, arrayOfInt.length);
    this.xOff = paramRIPEMD128Digest.xOff;
  }
  
  private int f1(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 ^ paramInt2 ^ paramInt3;
  }
  
  private int f2(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt3 | paramInt2 & paramInt1;
  }
  
  private int f3(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 | paramInt2) ^ paramInt3;
  }
  
  private int f4(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt3 | paramInt2 & paramInt3;
  }
  
  private void unpackWord(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[paramInt2] = ((byte)paramInt1);
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >>> 8));
    paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 >>> 16));
    paramArrayOfByte[(paramInt2 + 3)] = ((byte)(paramInt1 >>> 24));
  }
  
  public Memoable copy()
  {
    return new RIPEMD128Digest(this);
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    finish();
    unpackWord(this.H0, paramArrayOfByte, paramInt);
    unpackWord(this.H1, paramArrayOfByte, paramInt + 4);
    unpackWord(this.H2, paramArrayOfByte, paramInt + 8);
    unpackWord(this.H3, paramArrayOfByte, paramInt + 12);
    reset();
    return 16;
  }
  
  public String getAlgorithmName()
  {
    return "RIPEMD128";
  }
  
  public int getDigestSize()
  {
    return 16;
  }
  
  protected void processBlock()
  {
    int i3 = this.H0;
    int n = this.H1;
    int i1 = this.H2;
    int i2 = this.H3;
    int j = F1(i3, n, i1, i2, this.X[0], 11);
    int k = F1(i2, j, n, i1, this.X[1], 14);
    int m = F1(i1, k, j, n, this.X[2], 15);
    int i = F1(n, m, k, j, this.X[3], 12);
    j = F1(j, i, m, k, this.X[4], 5);
    k = F1(k, j, i, m, this.X[5], 8);
    m = F1(m, k, j, i, this.X[6], 7);
    i = F1(i, m, k, j, this.X[7], 9);
    j = F1(j, i, m, k, this.X[8], 11);
    k = F1(k, j, i, m, this.X[9], 13);
    m = F1(m, k, j, i, this.X[10], 14);
    i = F1(i, m, k, j, this.X[11], 15);
    j = F1(j, i, m, k, this.X[12], 6);
    k = F1(k, j, i, m, this.X[13], 7);
    m = F1(m, k, j, i, this.X[14], 9);
    i = F1(i, m, k, j, this.X[15], 8);
    j = F2(j, i, m, k, this.X[7], 7);
    k = F2(k, j, i, m, this.X[4], 6);
    m = F2(m, k, j, i, this.X[13], 8);
    i = F2(i, m, k, j, this.X[1], 13);
    j = F2(j, i, m, k, this.X[10], 11);
    k = F2(k, j, i, m, this.X[6], 9);
    m = F2(m, k, j, i, this.X[15], 7);
    i = F2(i, m, k, j, this.X[3], 15);
    j = F2(j, i, m, k, this.X[12], 7);
    k = F2(k, j, i, m, this.X[0], 12);
    m = F2(m, k, j, i, this.X[9], 15);
    i = F2(i, m, k, j, this.X[5], 9);
    j = F2(j, i, m, k, this.X[2], 11);
    k = F2(k, j, i, m, this.X[14], 7);
    m = F2(m, k, j, i, this.X[11], 13);
    i = F2(i, m, k, j, this.X[8], 12);
    j = F3(j, i, m, k, this.X[3], 11);
    k = F3(k, j, i, m, this.X[10], 13);
    m = F3(m, k, j, i, this.X[14], 6);
    i = F3(i, m, k, j, this.X[4], 7);
    j = F3(j, i, m, k, this.X[9], 14);
    k = F3(k, j, i, m, this.X[15], 9);
    m = F3(m, k, j, i, this.X[8], 13);
    i = F3(i, m, k, j, this.X[1], 15);
    j = F3(j, i, m, k, this.X[2], 14);
    k = F3(k, j, i, m, this.X[7], 8);
    m = F3(m, k, j, i, this.X[0], 13);
    i = F3(i, m, k, j, this.X[6], 6);
    j = F3(j, i, m, k, this.X[13], 5);
    k = F3(k, j, i, m, this.X[11], 12);
    m = F3(m, k, j, i, this.X[5], 7);
    i = F3(i, m, k, j, this.X[12], 5);
    j = F4(j, i, m, k, this.X[1], 11);
    k = F4(k, j, i, m, this.X[9], 12);
    m = F4(m, k, j, i, this.X[11], 14);
    i = F4(i, m, k, j, this.X[10], 15);
    j = F4(j, i, m, k, this.X[0], 14);
    k = F4(k, j, i, m, this.X[8], 15);
    m = F4(m, k, j, i, this.X[12], 9);
    i = F4(i, m, k, j, this.X[4], 8);
    j = F4(j, i, m, k, this.X[13], 9);
    k = F4(k, j, i, m, this.X[3], 14);
    m = F4(m, k, j, i, this.X[7], 5);
    int i4 = F4(i, m, k, j, this.X[15], 6);
    i = F4(j, i4, m, k, this.X[14], 8);
    j = F4(k, i, i4, m, this.X[5], 6);
    k = F4(m, j, i, i4, this.X[6], 5);
    m = F4(i4, k, j, i, this.X[2], 12);
    i3 = FF4(i3, n, i1, i2, this.X[5], 8);
    i2 = FF4(i2, i3, n, i1, this.X[14], 9);
    i1 = FF4(i1, i2, i3, n, this.X[7], 9);
    n = FF4(n, i1, i2, i3, this.X[0], 11);
    i3 = FF4(i3, n, i1, i2, this.X[9], 13);
    i2 = FF4(i2, i3, n, i1, this.X[2], 15);
    i1 = FF4(i1, i2, i3, n, this.X[11], 15);
    n = FF4(n, i1, i2, i3, this.X[4], 5);
    i3 = FF4(i3, n, i1, i2, this.X[13], 7);
    i2 = FF4(i2, i3, n, i1, this.X[6], 7);
    i1 = FF4(i1, i2, i3, n, this.X[15], 8);
    n = FF4(n, i1, i2, i3, this.X[8], 11);
    i3 = FF4(i3, n, i1, i2, this.X[1], 14);
    i2 = FF4(i2, i3, n, i1, this.X[10], 14);
    i1 = FF4(i1, i2, i3, n, this.X[3], 12);
    n = FF4(n, i1, i2, i3, this.X[12], 6);
    i3 = FF3(i3, n, i1, i2, this.X[6], 9);
    i2 = FF3(i2, i3, n, i1, this.X[11], 13);
    i1 = FF3(i1, i2, i3, n, this.X[3], 15);
    n = FF3(n, i1, i2, i3, this.X[7], 7);
    i3 = FF3(i3, n, i1, i2, this.X[0], 12);
    i2 = FF3(i2, i3, n, i1, this.X[13], 8);
    i1 = FF3(i1, i2, i3, n, this.X[5], 9);
    n = FF3(n, i1, i2, i3, this.X[10], 11);
    i3 = FF3(i3, n, i1, i2, this.X[14], 7);
    i2 = FF3(i2, i3, n, i1, this.X[15], 7);
    i1 = FF3(i1, i2, i3, n, this.X[8], 12);
    n = FF3(n, i1, i2, i3, this.X[12], 7);
    i3 = FF3(i3, n, i1, i2, this.X[4], 6);
    i2 = FF3(i2, i3, n, i1, this.X[9], 15);
    i1 = FF3(i1, i2, i3, n, this.X[1], 13);
    n = FF3(n, i1, i2, i3, this.X[2], 11);
    i3 = FF2(i3, n, i1, i2, this.X[15], 9);
    i2 = FF2(i2, i3, n, i1, this.X[5], 7);
    i1 = FF2(i1, i2, i3, n, this.X[1], 15);
    n = FF2(n, i1, i2, i3, this.X[3], 11);
    i3 = FF2(i3, n, i1, i2, this.X[7], 8);
    i2 = FF2(i2, i3, n, i1, this.X[14], 6);
    i1 = FF2(i1, i2, i3, n, this.X[6], 6);
    n = FF2(n, i1, i2, i3, this.X[9], 14);
    i3 = FF2(i3, n, i1, i2, this.X[11], 12);
    i2 = FF2(i2, i3, n, i1, this.X[8], 13);
    i1 = FF2(i1, i2, i3, n, this.X[12], 5);
    n = FF2(n, i1, i2, i3, this.X[2], 14);
    i3 = FF2(i3, n, i1, i2, this.X[10], 13);
    i2 = FF2(i2, i3, n, i1, this.X[0], 13);
    i1 = FF2(i1, i2, i3, n, this.X[4], 7);
    n = FF2(n, i1, i2, i3, this.X[13], 5);
    i3 = FF1(i3, n, i1, i2, this.X[8], 15);
    i2 = FF1(i2, i3, n, i1, this.X[6], 5);
    i1 = FF1(i1, i2, i3, n, this.X[4], 8);
    n = FF1(n, i1, i2, i3, this.X[1], 11);
    i3 = FF1(i3, n, i1, i2, this.X[3], 14);
    i2 = FF1(i2, i3, n, i1, this.X[11], 14);
    i1 = FF1(i1, i2, i3, n, this.X[15], 6);
    n = FF1(n, i1, i2, i3, this.X[0], 14);
    i3 = FF1(i3, n, i1, i2, this.X[5], 6);
    i2 = FF1(i2, i3, n, i1, this.X[12], 9);
    i1 = FF1(i1, i2, i3, n, this.X[2], 12);
    i4 = FF1(n, i1, i2, i3, this.X[13], 9);
    n = FF1(i3, i4, i1, i2, this.X[9], 12);
    i2 = FF1(i2, n, i4, i1, this.X[7], 5);
    i1 = FF1(i1, i2, n, i4, this.X[10], 15);
    i3 = FF1(i4, i1, i2, n, this.X[14], 8);
    i4 = this.H1;
    this.H1 = (this.H2 + j + n);
    this.H2 = (this.H3 + i + i3);
    this.H3 = (this.H0 + m + i1);
    this.H0 = (i2 + (k + i4));
    this.xOff = 0;
    i = 0;
    for (;;)
    {
      int[] arrayOfInt = this.X;
      if (i == arrayOfInt.length) {
        break;
      }
      arrayOfInt[i] = 0;
      i += 1;
    }
  }
  
  protected void processLength(long paramLong)
  {
    if (this.xOff > 14) {
      processBlock();
    }
    int[] arrayOfInt = this.X;
    arrayOfInt[14] = ((int)(0xFFFFFFFFFFFFFFFF & paramLong));
    arrayOfInt[15] = ((int)(paramLong >>> 32));
  }
  
  protected void processWord(byte[] paramArrayOfByte, int paramInt)
  {
    int[] arrayOfInt = this.X;
    int i = this.xOff;
    int j = i + 1;
    this.xOff = j;
    int k = paramArrayOfByte[paramInt];
    int m = paramArrayOfByte[(paramInt + 1)];
    int n = paramArrayOfByte[(paramInt + 2)];
    arrayOfInt[i] = ((paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24 | k & 0xFF | (m & 0xFF) << 8 | (n & 0xFF) << 16);
    if (j == 16) {
      processBlock();
    }
  }
  
  public void reset()
  {
    super.reset();
    this.H0 = 1732584193;
    this.H1 = -271733879;
    this.H2 = -1732584194;
    this.H3 = 271733878;
    this.xOff = 0;
    int i = 0;
    for (;;)
    {
      int[] arrayOfInt = this.X;
      if (i == arrayOfInt.length) {
        break;
      }
      arrayOfInt[i] = 0;
      i += 1;
    }
  }
  
  public void reset(Memoable paramMemoable)
  {
    copyIn((RIPEMD128Digest)paramMemoable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\digests\RIPEMD128Digest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */