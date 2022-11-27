package org.bouncycastle.crypto.digests;

import org.bouncycastle.util.Memoable;

public class MD4Digest
  extends GeneralDigest
{
  private static final int DIGEST_LENGTH = 16;
  private static final int S11 = 3;
  private static final int S12 = 7;
  private static final int S13 = 11;
  private static final int S14 = 19;
  private static final int S21 = 3;
  private static final int S22 = 5;
  private static final int S23 = 9;
  private static final int S24 = 13;
  private static final int S31 = 3;
  private static final int S32 = 9;
  private static final int S33 = 11;
  private static final int S34 = 15;
  private int H1;
  private int H2;
  private int H3;
  private int H4;
  private int[] X = new int[16];
  private int xOff;
  
  public MD4Digest()
  {
    reset();
  }
  
  public MD4Digest(MD4Digest paramMD4Digest)
  {
    super(paramMD4Digest);
    copyIn(paramMD4Digest);
  }
  
  private int F(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt3 | paramInt2 & paramInt1;
  }
  
  private int G(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt3 | paramInt1 & paramInt2 | paramInt2 & paramInt3;
  }
  
  private int H(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 ^ paramInt2 ^ paramInt3;
  }
  
  private void copyIn(MD4Digest paramMD4Digest)
  {
    super.copyIn(paramMD4Digest);
    this.H1 = paramMD4Digest.H1;
    this.H2 = paramMD4Digest.H2;
    this.H3 = paramMD4Digest.H3;
    this.H4 = paramMD4Digest.H4;
    int[] arrayOfInt = paramMD4Digest.X;
    System.arraycopy(arrayOfInt, 0, this.X, 0, arrayOfInt.length);
    this.xOff = paramMD4Digest.xOff;
  }
  
  private int rotateLeft(int paramInt1, int paramInt2)
  {
    return paramInt1 >>> 32 - paramInt2 | paramInt1 << paramInt2;
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
    return new MD4Digest(this);
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    finish();
    unpackWord(this.H1, paramArrayOfByte, paramInt);
    unpackWord(this.H2, paramArrayOfByte, paramInt + 4);
    unpackWord(this.H3, paramArrayOfByte, paramInt + 8);
    unpackWord(this.H4, paramArrayOfByte, paramInt + 12);
    reset();
    return 16;
  }
  
  public String getAlgorithmName()
  {
    return "MD4";
  }
  
  public int getDigestSize()
  {
    return 16;
  }
  
  protected void processBlock()
  {
    int j = this.H1;
    int i = this.H2;
    int m = this.H3;
    int k = this.H4;
    j = rotateLeft(j + F(i, m, k) + this.X[0], 3);
    k = rotateLeft(k + F(j, i, m) + this.X[1], 7);
    m = rotateLeft(m + F(k, j, i) + this.X[2], 11);
    i = rotateLeft(i + F(m, k, j) + this.X[3], 19);
    j = rotateLeft(j + F(i, m, k) + this.X[4], 3);
    k = rotateLeft(k + F(j, i, m) + this.X[5], 7);
    m = rotateLeft(m + F(k, j, i) + this.X[6], 11);
    i = rotateLeft(i + F(m, k, j) + this.X[7], 19);
    j = rotateLeft(j + F(i, m, k) + this.X[8], 3);
    k = rotateLeft(k + F(j, i, m) + this.X[9], 7);
    m = rotateLeft(m + F(k, j, i) + this.X[10], 11);
    i = rotateLeft(i + F(m, k, j) + this.X[11], 19);
    j = rotateLeft(j + F(i, m, k) + this.X[12], 3);
    k = rotateLeft(k + F(j, i, m) + this.X[13], 7);
    m = rotateLeft(m + F(k, j, i) + this.X[14], 11);
    i = rotateLeft(i + F(m, k, j) + this.X[15], 19);
    j = rotateLeft(j + G(i, m, k) + this.X[0] + 1518500249, 3);
    k = rotateLeft(k + G(j, i, m) + this.X[4] + 1518500249, 5);
    m = rotateLeft(m + G(k, j, i) + this.X[8] + 1518500249, 9);
    i = rotateLeft(i + G(m, k, j) + this.X[12] + 1518500249, 13);
    j = rotateLeft(j + G(i, m, k) + this.X[1] + 1518500249, 3);
    k = rotateLeft(k + G(j, i, m) + this.X[5] + 1518500249, 5);
    m = rotateLeft(m + G(k, j, i) + this.X[9] + 1518500249, 9);
    i = rotateLeft(i + G(m, k, j) + this.X[13] + 1518500249, 13);
    j = rotateLeft(j + G(i, m, k) + this.X[2] + 1518500249, 3);
    k = rotateLeft(k + G(j, i, m) + this.X[6] + 1518500249, 5);
    m = rotateLeft(m + G(k, j, i) + this.X[10] + 1518500249, 9);
    i = rotateLeft(i + G(m, k, j) + this.X[14] + 1518500249, 13);
    j = rotateLeft(j + G(i, m, k) + this.X[3] + 1518500249, 3);
    k = rotateLeft(k + G(j, i, m) + this.X[7] + 1518500249, 5);
    m = rotateLeft(m + G(k, j, i) + this.X[11] + 1518500249, 9);
    i = rotateLeft(i + G(m, k, j) + this.X[15] + 1518500249, 13);
    j = rotateLeft(j + H(i, m, k) + this.X[0] + 1859775393, 3);
    k = rotateLeft(k + H(j, i, m) + this.X[8] + 1859775393, 9);
    m = rotateLeft(m + H(k, j, i) + this.X[4] + 1859775393, 11);
    i = rotateLeft(i + H(m, k, j) + this.X[12] + 1859775393, 15);
    j = rotateLeft(j + H(i, m, k) + this.X[2] + 1859775393, 3);
    k = rotateLeft(k + H(j, i, m) + this.X[10] + 1859775393, 9);
    m = rotateLeft(m + H(k, j, i) + this.X[6] + 1859775393, 11);
    i = rotateLeft(i + H(m, k, j) + this.X[14] + 1859775393, 15);
    j = rotateLeft(j + H(i, m, k) + this.X[1] + 1859775393, 3);
    k = rotateLeft(k + H(j, i, m) + this.X[9] + 1859775393, 9);
    m = rotateLeft(m + H(k, j, i) + this.X[5] + 1859775393, 11);
    i = rotateLeft(i + H(m, k, j) + this.X[13] + 1859775393, 15);
    j = rotateLeft(j + H(i, m, k) + this.X[3] + 1859775393, 3);
    k = rotateLeft(k + H(j, i, m) + this.X[11] + 1859775393, 9);
    m = rotateLeft(m + H(k, j, i) + this.X[7] + 1859775393, 11);
    i = rotateLeft(i + H(m, k, j) + this.X[15] + 1859775393, 15);
    this.H1 += j;
    this.H2 += i;
    this.H3 += m;
    this.H4 += k;
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
    this.H1 = 1732584193;
    this.H2 = -271733879;
    this.H3 = -1732584194;
    this.H4 = 271733878;
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
    copyIn((MD4Digest)paramMemoable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\digests\MD4Digest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */