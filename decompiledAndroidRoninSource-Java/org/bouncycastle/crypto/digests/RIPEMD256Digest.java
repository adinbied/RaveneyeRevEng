package org.bouncycastle.crypto.digests;

import org.bouncycastle.util.Memoable;

public class RIPEMD256Digest
  extends GeneralDigest
{
  private static final int DIGEST_LENGTH = 32;
  private int H0;
  private int H1;
  private int H2;
  private int H3;
  private int H4;
  private int H5;
  private int H6;
  private int H7;
  private int[] X = new int[16];
  private int xOff;
  
  public RIPEMD256Digest()
  {
    reset();
  }
  
  public RIPEMD256Digest(RIPEMD256Digest paramRIPEMD256Digest)
  {
    super(paramRIPEMD256Digest);
    copyIn(paramRIPEMD256Digest);
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
  
  private void copyIn(RIPEMD256Digest paramRIPEMD256Digest)
  {
    super.copyIn(paramRIPEMD256Digest);
    this.H0 = paramRIPEMD256Digest.H0;
    this.H1 = paramRIPEMD256Digest.H1;
    this.H2 = paramRIPEMD256Digest.H2;
    this.H3 = paramRIPEMD256Digest.H3;
    this.H4 = paramRIPEMD256Digest.H4;
    this.H5 = paramRIPEMD256Digest.H5;
    this.H6 = paramRIPEMD256Digest.H6;
    this.H7 = paramRIPEMD256Digest.H7;
    int[] arrayOfInt = paramRIPEMD256Digest.X;
    System.arraycopy(arrayOfInt, 0, this.X, 0, arrayOfInt.length);
    this.xOff = paramRIPEMD256Digest.xOff;
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
    return new RIPEMD256Digest(this);
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    finish();
    unpackWord(this.H0, paramArrayOfByte, paramInt);
    unpackWord(this.H1, paramArrayOfByte, paramInt + 4);
    unpackWord(this.H2, paramArrayOfByte, paramInt + 8);
    unpackWord(this.H3, paramArrayOfByte, paramInt + 12);
    unpackWord(this.H4, paramArrayOfByte, paramInt + 16);
    unpackWord(this.H5, paramArrayOfByte, paramInt + 20);
    unpackWord(this.H6, paramArrayOfByte, paramInt + 24);
    unpackWord(this.H7, paramArrayOfByte, paramInt + 28);
    reset();
    return 32;
  }
  
  public String getAlgorithmName()
  {
    return "RIPEMD256";
  }
  
  public int getDigestSize()
  {
    return 32;
  }
  
  protected void processBlock()
  {
    int k = this.H0;
    int i = this.H1;
    int n = this.H2;
    int m = this.H3;
    int i3 = this.H4;
    int j = this.H5;
    int i1 = this.H6;
    int i2 = this.H7;
    k = F1(k, i, n, m, this.X[0], 11);
    m = F1(m, k, i, n, this.X[1], 14);
    n = F1(n, m, k, i, this.X[2], 15);
    i = F1(i, n, m, k, this.X[3], 12);
    k = F1(k, i, n, m, this.X[4], 5);
    m = F1(m, k, i, n, this.X[5], 8);
    n = F1(n, m, k, i, this.X[6], 7);
    i = F1(i, n, m, k, this.X[7], 9);
    k = F1(k, i, n, m, this.X[8], 11);
    m = F1(m, k, i, n, this.X[9], 13);
    n = F1(n, m, k, i, this.X[10], 14);
    int i4 = F1(i, n, m, k, this.X[11], 15);
    i = F1(k, i4, n, m, this.X[12], 6);
    k = F1(m, i, i4, n, this.X[13], 7);
    m = F1(n, k, i, i4, this.X[14], 9);
    n = F1(i4, m, k, i, this.X[15], 8);
    i3 = FF4(i3, j, i1, i2, this.X[5], 8);
    i2 = FF4(i2, i3, j, i1, this.X[14], 9);
    i1 = FF4(i1, i2, i3, j, this.X[7], 9);
    j = FF4(j, i1, i2, i3, this.X[0], 11);
    i3 = FF4(i3, j, i1, i2, this.X[9], 13);
    i2 = FF4(i2, i3, j, i1, this.X[2], 15);
    i1 = FF4(i1, i2, i3, j, this.X[11], 15);
    j = FF4(j, i1, i2, i3, this.X[4], 5);
    i3 = FF4(i3, j, i1, i2, this.X[13], 7);
    i2 = FF4(i2, i3, j, i1, this.X[6], 7);
    i4 = FF4(i1, i2, i3, j, this.X[15], 8);
    j = FF4(j, i4, i2, i3, this.X[8], 11);
    int i5 = FF4(i3, j, i4, i2, this.X[1], 14);
    i1 = FF4(i2, i5, j, i4, this.X[10], 14);
    i2 = FF4(i4, i1, i5, j, this.X[3], 12);
    i3 = FF4(j, i2, i1, i5, this.X[12], 6);
    j = F2(i5, n, m, k, this.X[7], 7);
    k = F2(k, j, n, m, this.X[4], 6);
    m = F2(m, k, j, n, this.X[13], 8);
    n = F2(n, m, k, j, this.X[1], 13);
    j = F2(j, n, m, k, this.X[10], 11);
    k = F2(k, j, n, m, this.X[6], 9);
    m = F2(m, k, j, n, this.X[15], 7);
    n = F2(n, m, k, j, this.X[3], 15);
    j = F2(j, n, m, k, this.X[12], 7);
    i4 = F2(k, j, n, m, this.X[0], 12);
    i5 = F2(m, i4, j, n, this.X[9], 15);
    int i6 = F2(n, i5, i4, j, this.X[5], 9);
    k = F2(j, i6, i5, i4, this.X[2], 11);
    m = F2(i4, k, i6, i5, this.X[14], 7);
    n = F2(i5, m, k, i6, this.X[11], 13);
    j = F2(i6, n, m, k, this.X[8], 12);
    i = FF3(i, i3, i2, i1, this.X[6], 9);
    i1 = FF3(i1, i, i3, i2, this.X[11], 13);
    i2 = FF3(i2, i1, i, i3, this.X[3], 15);
    i3 = FF3(i3, i2, i1, i, this.X[7], 7);
    i = FF3(i, i3, i2, i1, this.X[0], 12);
    i1 = FF3(i1, i, i3, i2, this.X[13], 8);
    i2 = FF3(i2, i1, i, i3, this.X[5], 9);
    i3 = FF3(i3, i2, i1, i, this.X[10], 11);
    i = FF3(i, i3, i2, i1, this.X[14], 7);
    i4 = FF3(i1, i, i3, i2, this.X[15], 7);
    i5 = FF3(i2, i4, i, i3, this.X[8], 12);
    i6 = FF3(i3, i5, i4, i, this.X[12], 7);
    i1 = FF3(i, i6, i5, i4, this.X[4], 6);
    i2 = FF3(i4, i1, i6, i5, this.X[9], 15);
    i3 = FF3(i5, i2, i1, i6, this.X[1], 13);
    i = FF3(i6, i3, i2, i1, this.X[2], 11);
    k = F3(k, i, n, m, this.X[3], 11);
    m = F3(m, k, i, n, this.X[10], 13);
    n = F3(n, m, k, i, this.X[14], 6);
    i = F3(i, n, m, k, this.X[4], 7);
    k = F3(k, i, n, m, this.X[9], 14);
    m = F3(m, k, i, n, this.X[15], 9);
    n = F3(n, m, k, i, this.X[8], 13);
    i = F3(i, n, m, k, this.X[1], 15);
    k = F3(k, i, n, m, this.X[2], 14);
    m = F3(m, k, i, n, this.X[7], 8);
    n = F3(n, m, k, i, this.X[0], 13);
    i4 = F3(i, n, m, k, this.X[6], 6);
    k = F3(k, i4, n, m, this.X[13], 5);
    m = F3(m, k, i4, n, this.X[11], 12);
    i = F3(n, m, k, i4, this.X[5], 7);
    n = F3(i4, i, m, k, this.X[12], 5);
    i1 = FF2(i1, j, i3, i2, this.X[15], 9);
    i2 = FF2(i2, i1, j, i3, this.X[5], 7);
    i3 = FF2(i3, i2, i1, j, this.X[1], 15);
    j = FF2(j, i3, i2, i1, this.X[3], 11);
    i1 = FF2(i1, j, i3, i2, this.X[7], 8);
    i2 = FF2(i2, i1, j, i3, this.X[14], 6);
    i3 = FF2(i3, i2, i1, j, this.X[6], 6);
    j = FF2(j, i3, i2, i1, this.X[9], 14);
    i1 = FF2(i1, j, i3, i2, this.X[11], 12);
    i2 = FF2(i2, i1, j, i3, this.X[8], 13);
    i3 = FF2(i3, i2, i1, j, this.X[12], 5);
    i4 = FF2(j, i3, i2, i1, this.X[2], 14);
    j = FF2(i1, i4, i3, i2, this.X[10], 13);
    i1 = FF2(i2, j, i4, i3, this.X[0], 13);
    i3 = FF2(i3, i1, j, i4, this.X[4], 7);
    i2 = FF2(i4, i3, i1, j, this.X[13], 5);
    k = F4(k, n, i3, m, this.X[1], 11);
    m = F4(m, k, n, i3, this.X[9], 12);
    i3 = F4(i3, m, k, n, this.X[11], 14);
    n = F4(n, i3, m, k, this.X[10], 15);
    k = F4(k, n, i3, m, this.X[0], 14);
    m = F4(m, k, n, i3, this.X[8], 15);
    i3 = F4(i3, m, k, n, this.X[12], 9);
    n = F4(n, i3, m, k, this.X[4], 8);
    k = F4(k, n, i3, m, this.X[13], 9);
    m = F4(m, k, n, i3, this.X[3], 14);
    i3 = F4(i3, m, k, n, this.X[7], 5);
    i4 = F4(n, i3, m, k, this.X[15], 6);
    k = F4(k, i4, i3, m, this.X[14], 8);
    m = F4(m, k, i4, i3, this.X[5], 6);
    n = F4(i3, m, k, i4, this.X[6], 5);
    i3 = F4(i4, n, m, k, this.X[2], 12);
    j = FF1(j, i2, i, i1, this.X[8], 15);
    i1 = FF1(i1, j, i2, i, this.X[6], 5);
    i = FF1(i, i1, j, i2, this.X[4], 8);
    i2 = FF1(i2, i, i1, j, this.X[1], 11);
    j = FF1(j, i2, i, i1, this.X[3], 14);
    i1 = FF1(i1, j, i2, i, this.X[11], 14);
    i = FF1(i, i1, j, i2, this.X[15], 6);
    i2 = FF1(i2, i, i1, j, this.X[0], 14);
    j = FF1(j, i2, i, i1, this.X[5], 6);
    i1 = FF1(i1, j, i2, i, this.X[12], 9);
    i = FF1(i, i1, j, i2, this.X[2], 12);
    i2 = FF1(i2, i, i1, j, this.X[13], 9);
    j = FF1(j, i2, i, i1, this.X[9], 12);
    i1 = FF1(i1, j, i2, i, this.X[7], 5);
    i = FF1(i, i1, j, i2, this.X[10], 15);
    i2 = FF1(i2, i, i1, j, this.X[14], 8);
    this.H0 += k;
    this.H1 += i3;
    this.H2 += n;
    this.H3 += i1;
    this.H4 += j;
    this.H5 += i2;
    this.H6 += i;
    this.H7 += m;
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
    this.H4 = 1985229328;
    this.H5 = -19088744;
    this.H6 = -1985229329;
    this.H7 = 19088743;
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
    copyIn((RIPEMD256Digest)paramMemoable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\digests\RIPEMD256Digest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */