package org.bouncycastle.crypto.digests;

import org.bouncycastle.util.Memoable;

public class RIPEMD320Digest
  extends GeneralDigest
{
  private static final int DIGEST_LENGTH = 40;
  private int H0;
  private int H1;
  private int H2;
  private int H3;
  private int H4;
  private int H5;
  private int H6;
  private int H7;
  private int H8;
  private int H9;
  private int[] X = new int[16];
  private int xOff;
  
  public RIPEMD320Digest()
  {
    reset();
  }
  
  public RIPEMD320Digest(RIPEMD320Digest paramRIPEMD320Digest)
  {
    super(paramRIPEMD320Digest);
    doCopy(paramRIPEMD320Digest);
  }
  
  private int RL(int paramInt1, int paramInt2)
  {
    return paramInt1 >>> 32 - paramInt2 | paramInt1 << paramInt2;
  }
  
  private void doCopy(RIPEMD320Digest paramRIPEMD320Digest)
  {
    super.copyIn(paramRIPEMD320Digest);
    this.H0 = paramRIPEMD320Digest.H0;
    this.H1 = paramRIPEMD320Digest.H1;
    this.H2 = paramRIPEMD320Digest.H2;
    this.H3 = paramRIPEMD320Digest.H3;
    this.H4 = paramRIPEMD320Digest.H4;
    this.H5 = paramRIPEMD320Digest.H5;
    this.H6 = paramRIPEMD320Digest.H6;
    this.H7 = paramRIPEMD320Digest.H7;
    this.H8 = paramRIPEMD320Digest.H8;
    this.H9 = paramRIPEMD320Digest.H9;
    int[] arrayOfInt = paramRIPEMD320Digest.X;
    System.arraycopy(arrayOfInt, 0, this.X, 0, arrayOfInt.length);
    this.xOff = paramRIPEMD320Digest.xOff;
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
  
  private int f5(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 ^ (paramInt2 | paramInt3);
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
    return new RIPEMD320Digest(this);
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
    unpackWord(this.H8, paramArrayOfByte, paramInt + 32);
    unpackWord(this.H9, paramArrayOfByte, paramInt + 36);
    reset();
    return 40;
  }
  
  public String getAlgorithmName()
  {
    return "RIPEMD320";
  }
  
  public int getDigestSize()
  {
    return 40;
  }
  
  protected void processBlock()
  {
    int k = this.H0;
    int i1 = this.H1;
    int m = this.H2;
    int i = this.H3;
    int n = this.H4;
    int i5 = this.H5;
    int i2 = this.H6;
    int i4 = this.H7;
    int j = this.H8;
    int i3 = this.H9;
    k = RL(k + f1(i1, m, i) + this.X[0], 11) + n;
    m = RL(m, 10);
    n = RL(n + f1(k, i1, m) + this.X[1], 14) + i;
    i1 = RL(i1, 10);
    i = RL(i + f1(n, k, i1) + this.X[2], 15) + m;
    k = RL(k, 10);
    m = RL(m + f1(i, n, k) + this.X[3], 12) + i1;
    n = RL(n, 10);
    i1 = RL(i1 + f1(m, i, n) + this.X[4], 5) + k;
    i = RL(i, 10);
    k = RL(k + f1(i1, m, i) + this.X[5], 8) + n;
    m = RL(m, 10);
    n = RL(n + f1(k, i1, m) + this.X[6], 7) + i;
    i1 = RL(i1, 10);
    i = RL(i + f1(n, k, i1) + this.X[7], 9) + m;
    k = RL(k, 10);
    m = RL(m + f1(i, n, k) + this.X[8], 11) + i1;
    n = RL(n, 10);
    i1 = RL(i1 + f1(m, i, n) + this.X[9], 13) + k;
    i = RL(i, 10);
    k = RL(k + f1(i1, m, i) + this.X[10], 14) + n;
    m = RL(m, 10);
    n = RL(n + f1(k, i1, m) + this.X[11], 15) + i;
    i1 = RL(i1, 10);
    i = RL(i + f1(n, k, i1) + this.X[12], 6) + m;
    int i6 = RL(k, 10);
    int i7 = RL(m + f1(i, n, i6) + this.X[13], 7) + i1;
    k = RL(n, 10);
    m = RL(i1 + f1(i7, i, k) + this.X[14], 9) + i6;
    n = RL(i, 10);
    i = RL(i6 + f1(m, i7, n) + this.X[15], 8) + k;
    i1 = RL(i7, 10);
    i5 = RL(i5 + f5(i2, i4, j) + this.X[5] + 1352829926, 8) + i3;
    i4 = RL(i4, 10);
    i3 = RL(i3 + f5(i5, i2, i4) + this.X[14] + 1352829926, 9) + j;
    i2 = RL(i2, 10);
    j = RL(j + f5(i3, i5, i2) + this.X[7] + 1352829926, 9) + i4;
    i5 = RL(i5, 10);
    i4 = RL(i4 + f5(j, i3, i5) + this.X[0] + 1352829926, 11) + i2;
    i3 = RL(i3, 10);
    i2 = RL(i2 + f5(i4, j, i3) + this.X[9] + 1352829926, 13) + i5;
    j = RL(j, 10);
    i5 = RL(i5 + f5(i2, i4, j) + this.X[2] + 1352829926, 15) + i3;
    i4 = RL(i4, 10);
    i3 = RL(i3 + f5(i5, i2, i4) + this.X[11] + 1352829926, 15) + j;
    i2 = RL(i2, 10);
    j = RL(j + f5(i3, i5, i2) + this.X[4] + 1352829926, 5) + i4;
    i5 = RL(i5, 10);
    i4 = RL(i4 + f5(j, i3, i5) + this.X[13] + 1352829926, 7) + i2;
    i3 = RL(i3, 10);
    i2 = RL(i2 + f5(i4, j, i3) + this.X[6] + 1352829926, 7) + i5;
    j = RL(j, 10);
    i5 = RL(i5 + f5(i2, i4, j) + this.X[15] + 1352829926, 8) + i3;
    i4 = RL(i4, 10);
    i3 = RL(i3 + f5(i5, i2, i4) + this.X[8] + 1352829926, 11) + j;
    i6 = RL(i2, 10);
    j = RL(j + f5(i3, i5, i6) + this.X[1] + 1352829926, 14) + i4;
    i5 = RL(i5, 10);
    i7 = RL(i4 + f5(j, i3, i5) + this.X[10] + 1352829926, 14) + i6;
    i2 = RL(i3, 10);
    i3 = RL(i6 + f5(i7, j, i2) + this.X[3] + 1352829926, 12) + i5;
    i4 = RL(j, 10);
    j = RL(i5 + f5(i3, i7, i4) + this.X[12] + 1352829926, 6) + i2;
    i5 = RL(i7, 10);
    k = RL(k + f2(j, m, i1) + this.X[7] + 1518500249, 7) + n;
    m = RL(m, 10);
    n = RL(n + f2(k, j, m) + this.X[4] + 1518500249, 6) + i1;
    j = RL(j, 10);
    i1 = RL(i1 + f2(n, k, j) + this.X[13] + 1518500249, 8) + m;
    k = RL(k, 10);
    m = RL(m + f2(i1, n, k) + this.X[1] + 1518500249, 13) + j;
    n = RL(n, 10);
    j = RL(j + f2(m, i1, n) + this.X[10] + 1518500249, 11) + k;
    i1 = RL(i1, 10);
    k = RL(k + f2(j, m, i1) + this.X[6] + 1518500249, 9) + n;
    m = RL(m, 10);
    n = RL(n + f2(k, j, m) + this.X[15] + 1518500249, 7) + i1;
    j = RL(j, 10);
    i1 = RL(i1 + f2(n, k, j) + this.X[3] + 1518500249, 15) + m;
    k = RL(k, 10);
    m = RL(m + f2(i1, n, k) + this.X[12] + 1518500249, 7) + j;
    n = RL(n, 10);
    j = RL(j + f2(m, i1, n) + this.X[0] + 1518500249, 12) + k;
    i1 = RL(i1, 10);
    k = RL(k + f2(j, m, i1) + this.X[9] + 1518500249, 15) + n;
    m = RL(m, 10);
    n = RL(n + f2(k, j, m) + this.X[5] + 1518500249, 9) + i1;
    j = RL(j, 10);
    i1 = RL(i1 + f2(n, k, j) + this.X[2] + 1518500249, 11) + m;
    i6 = RL(k, 10);
    i7 = RL(m + f2(i1, n, i6) + this.X[14] + 1518500249, 7) + j;
    k = RL(n, 10);
    m = RL(j + f2(i7, i1, k) + this.X[11] + 1518500249, 13) + i6;
    n = RL(i1, 10);
    i1 = RL(i6 + f2(m, i7, n) + this.X[8] + 1518500249, 12) + k;
    j = RL(i7, 10);
    i2 = RL(i2 + f4(i, i3, i5) + this.X[6] + 1548603684, 9) + i4;
    i3 = RL(i3, 10);
    i4 = RL(i4 + f4(i2, i, i3) + this.X[11] + 1548603684, 13) + i5;
    i = RL(i, 10);
    i5 = RL(i5 + f4(i4, i2, i) + this.X[3] + 1548603684, 15) + i3;
    i2 = RL(i2, 10);
    i3 = RL(i3 + f4(i5, i4, i2) + this.X[7] + 1548603684, 7) + i;
    i4 = RL(i4, 10);
    i = RL(i + f4(i3, i5, i4) + this.X[0] + 1548603684, 12) + i2;
    i5 = RL(i5, 10);
    i2 = RL(i2 + f4(i, i3, i5) + this.X[13] + 1548603684, 8) + i4;
    i3 = RL(i3, 10);
    i4 = RL(i4 + f4(i2, i, i3) + this.X[5] + 1548603684, 9) + i5;
    i = RL(i, 10);
    i5 = RL(i5 + f4(i4, i2, i) + this.X[10] + 1548603684, 11) + i3;
    i2 = RL(i2, 10);
    i3 = RL(i3 + f4(i5, i4, i2) + this.X[14] + 1548603684, 7) + i;
    i4 = RL(i4, 10);
    i = RL(i + f4(i3, i5, i4) + this.X[15] + 1548603684, 7) + i2;
    i5 = RL(i5, 10);
    i2 = RL(i2 + f4(i, i3, i5) + this.X[8] + 1548603684, 12) + i4;
    i3 = RL(i3, 10);
    i4 = RL(i4 + f4(i2, i, i3) + this.X[12] + 1548603684, 7) + i5;
    i = RL(i, 10);
    i5 = RL(i5 + f4(i4, i2, i) + this.X[4] + 1548603684, 6) + i3;
    i6 = RL(i2, 10);
    i7 = RL(i3 + f4(i5, i4, i6) + this.X[9] + 1548603684, 15) + i;
    i2 = RL(i4, 10);
    i3 = RL(i + f4(i7, i5, i2) + this.X[1] + 1548603684, 13) + i6;
    i4 = RL(i5, 10);
    i5 = RL(i6 + f4(i3, i7, i4) + this.X[2] + 1548603684, 11) + i2;
    i = RL(i7, 10);
    k = RL(k + f3(i1, m, i) + this.X[3] + 1859775393, 11) + n;
    m = RL(m, 10);
    n = RL(n + f3(k, i1, m) + this.X[10] + 1859775393, 13) + i;
    i1 = RL(i1, 10);
    i = RL(i + f3(n, k, i1) + this.X[14] + 1859775393, 6) + m;
    k = RL(k, 10);
    m = RL(m + f3(i, n, k) + this.X[4] + 1859775393, 7) + i1;
    n = RL(n, 10);
    i1 = RL(i1 + f3(m, i, n) + this.X[9] + 1859775393, 14) + k;
    i = RL(i, 10);
    k = RL(k + f3(i1, m, i) + this.X[15] + 1859775393, 9) + n;
    m = RL(m, 10);
    n = RL(n + f3(k, i1, m) + this.X[8] + 1859775393, 13) + i;
    i1 = RL(i1, 10);
    i = RL(i + f3(n, k, i1) + this.X[1] + 1859775393, 15) + m;
    k = RL(k, 10);
    m = RL(m + f3(i, n, k) + this.X[2] + 1859775393, 14) + i1;
    n = RL(n, 10);
    i1 = RL(i1 + f3(m, i, n) + this.X[7] + 1859775393, 8) + k;
    i = RL(i, 10);
    k = RL(k + f3(i1, m, i) + this.X[0] + 1859775393, 13) + n;
    m = RL(m, 10);
    n = RL(n + f3(k, i1, m) + this.X[6] + 1859775393, 6) + i;
    i1 = RL(i1, 10);
    i6 = RL(i + f3(n, k, i1) + this.X[13] + 1859775393, 5) + m;
    i7 = RL(k, 10);
    int i8 = RL(m + f3(i6, n, i7) + this.X[11] + 1859775393, 12) + i1;
    i = RL(n, 10);
    k = RL(i1 + f3(i8, i6, i) + this.X[5] + 1859775393, 7) + i7;
    m = RL(i6, 10);
    n = RL(i7 + f3(k, i8, m) + this.X[12] + 1859775393, 5) + i;
    i1 = RL(i8, 10);
    i2 = RL(i2 + f3(i5, i3, j) + this.X[15] + 1836072691, 9) + i4;
    i3 = RL(i3, 10);
    i4 = RL(i4 + f3(i2, i5, i3) + this.X[5] + 1836072691, 7) + j;
    i5 = RL(i5, 10);
    j = RL(j + f3(i4, i2, i5) + this.X[1] + 1836072691, 15) + i3;
    i2 = RL(i2, 10);
    i3 = RL(i3 + f3(j, i4, i2) + this.X[3] + 1836072691, 11) + i5;
    i4 = RL(i4, 10);
    i5 = RL(i5 + f3(i3, j, i4) + this.X[7] + 1836072691, 8) + i2;
    j = RL(j, 10);
    i2 = RL(i2 + f3(i5, i3, j) + this.X[14] + 1836072691, 6) + i4;
    i3 = RL(i3, 10);
    i4 = RL(i4 + f3(i2, i5, i3) + this.X[6] + 1836072691, 6) + j;
    i5 = RL(i5, 10);
    j = RL(j + f3(i4, i2, i5) + this.X[9] + 1836072691, 14) + i3;
    i2 = RL(i2, 10);
    i3 = RL(i3 + f3(j, i4, i2) + this.X[11] + 1836072691, 12) + i5;
    i4 = RL(i4, 10);
    i5 = RL(i5 + f3(i3, j, i4) + this.X[8] + 1836072691, 13) + i2;
    j = RL(j, 10);
    i2 = RL(i2 + f3(i5, i3, j) + this.X[12] + 1836072691, 5) + i4;
    i3 = RL(i3, 10);
    i4 = RL(i4 + f3(i2, i5, i3) + this.X[2] + 1836072691, 14) + j;
    i5 = RL(i5, 10);
    j = RL(j + f3(i4, i2, i5) + this.X[10] + 1836072691, 13) + i3;
    i6 = RL(i2, 10);
    i7 = RL(i3 + f3(j, i4, i6) + this.X[0] + 1836072691, 13) + i5;
    i8 = RL(i4, 10);
    i2 = RL(i5 + f3(i7, j, i8) + this.X[4] + 1836072691, 7) + i6;
    i3 = RL(j, 10);
    i4 = RL(i6 + f3(i2, i7, i3) + this.X[13] + 1836072691, 5) + i8;
    i5 = RL(i7, 10);
    j = RL(i8 + f4(n, k, i1) + this.X[1] - 1894007588, 11) + m;
    k = RL(k, 10);
    m = RL(m + f4(j, n, k) + this.X[9] - 1894007588, 12) + i1;
    n = RL(n, 10);
    i1 = RL(i1 + f4(m, j, n) + this.X[11] - 1894007588, 14) + k;
    j = RL(j, 10);
    k = RL(k + f4(i1, m, j) + this.X[10] - 1894007588, 15) + n;
    m = RL(m, 10);
    n = RL(n + f4(k, i1, m) + this.X[0] - 1894007588, 14) + j;
    i1 = RL(i1, 10);
    j = RL(j + f4(n, k, i1) + this.X[8] - 1894007588, 15) + m;
    k = RL(k, 10);
    m = RL(m + f4(j, n, k) + this.X[12] - 1894007588, 9) + i1;
    n = RL(n, 10);
    i1 = RL(i1 + f4(m, j, n) + this.X[4] - 1894007588, 8) + k;
    j = RL(j, 10);
    k = RL(k + f4(i1, m, j) + this.X[13] - 1894007588, 9) + n;
    m = RL(m, 10);
    n = RL(n + f4(k, i1, m) + this.X[3] - 1894007588, 14) + j;
    i1 = RL(i1, 10);
    j = RL(j + f4(n, k, i1) + this.X[7] - 1894007588, 5) + m;
    k = RL(k, 10);
    m = RL(m + f4(j, n, k) + this.X[15] - 1894007588, 6) + i1;
    n = RL(n, 10);
    i1 = RL(i1 + f4(m, j, n) + this.X[14] - 1894007588, 8) + k;
    i6 = RL(j, 10);
    i7 = RL(k + f4(i1, m, i6) + this.X[5] - 1894007588, 6) + n;
    k = RL(m, 10);
    j = RL(n + f4(i7, i1, k) + this.X[6] - 1894007588, 5) + i6;
    m = RL(i1, 10);
    n = RL(i6 + f4(j, i7, m) + this.X[2] - 1894007588, 12) + k;
    i1 = RL(i7, 10);
    i = RL(i + f2(i4, i2, i5) + this.X[8] + 2053994217, 15) + i3;
    i2 = RL(i2, 10);
    i3 = RL(i3 + f2(i, i4, i2) + this.X[6] + 2053994217, 5) + i5;
    i4 = RL(i4, 10);
    i5 = RL(i5 + f2(i3, i, i4) + this.X[4] + 2053994217, 8) + i2;
    i = RL(i, 10);
    i2 = RL(i2 + f2(i5, i3, i) + this.X[1] + 2053994217, 11) + i4;
    i3 = RL(i3, 10);
    i4 = RL(i4 + f2(i2, i5, i3) + this.X[3] + 2053994217, 14) + i;
    i5 = RL(i5, 10);
    i = RL(i + f2(i4, i2, i5) + this.X[11] + 2053994217, 14) + i3;
    i2 = RL(i2, 10);
    i3 = RL(i3 + f2(i, i4, i2) + this.X[15] + 2053994217, 6) + i5;
    i4 = RL(i4, 10);
    i5 = RL(i5 + f2(i3, i, i4) + this.X[0] + 2053994217, 14) + i2;
    i = RL(i, 10);
    i2 = RL(i2 + f2(i5, i3, i) + this.X[5] + 2053994217, 6) + i4;
    i3 = RL(i3, 10);
    i4 = RL(i4 + f2(i2, i5, i3) + this.X[12] + 2053994217, 9) + i;
    i5 = RL(i5, 10);
    i = RL(i + f2(i4, i2, i5) + this.X[2] + 2053994217, 12) + i3;
    i2 = RL(i2, 10);
    i3 = RL(i3 + f2(i, i4, i2) + this.X[13] + 2053994217, 9) + i5;
    i4 = RL(i4, 10);
    i5 = RL(i5 + f2(i3, i, i4) + this.X[9] + 2053994217, 12) + i2;
    i6 = RL(i, 10);
    i7 = RL(i2 + f2(i5, i3, i6) + this.X[7] + 2053994217, 5) + i4;
    i = RL(i3, 10);
    i8 = RL(i4 + f2(i7, i5, i) + this.X[10] + 2053994217, 15) + i6;
    i2 = RL(i5, 10);
    i3 = RL(i6 + f2(i8, i7, i2) + this.X[14] + 2053994217, 8) + i;
    i4 = RL(i7, 10);
    k = RL(k + f5(n, i8, i1) + this.X[4] - 1454113458, 9) + m;
    i5 = RL(i8, 10);
    m = RL(m + f5(k, n, i5) + this.X[0] - 1454113458, 15) + i1;
    n = RL(n, 10);
    i1 = RL(i1 + f5(m, k, n) + this.X[5] - 1454113458, 5) + i5;
    k = RL(k, 10);
    i5 = RL(i5 + f5(i1, m, k) + this.X[9] - 1454113458, 11) + n;
    m = RL(m, 10);
    n = RL(n + f5(i5, i1, m) + this.X[7] - 1454113458, 6) + k;
    i1 = RL(i1, 10);
    k = RL(k + f5(n, i5, i1) + this.X[12] - 1454113458, 8) + m;
    i5 = RL(i5, 10);
    m = RL(m + f5(k, n, i5) + this.X[2] - 1454113458, 13) + i1;
    n = RL(n, 10);
    i1 = RL(i1 + f5(m, k, n) + this.X[10] - 1454113458, 12) + i5;
    k = RL(k, 10);
    i5 = RL(i5 + f5(i1, m, k) + this.X[14] - 1454113458, 5) + n;
    m = RL(m, 10);
    n = RL(n + f5(i5, i1, m) + this.X[1] - 1454113458, 12) + k;
    i1 = RL(i1, 10);
    k = RL(k + f5(n, i5, i1) + this.X[3] - 1454113458, 13) + m;
    i5 = RL(i5, 10);
    m = RL(m + f5(k, n, i5) + this.X[8] - 1454113458, 14) + i1;
    n = RL(n, 10);
    i1 = RL(i1 + f5(m, k, n) + this.X[11] - 1454113458, 11) + i5;
    i6 = RL(k, 10);
    i5 = RL(i5 + f5(i1, m, i6) + this.X[6] - 1454113458, 8) + n;
    k = RL(m, 10);
    m = RL(n + f5(i5, i1, k) + this.X[15] - 1454113458, 5) + i6;
    n = RL(i1, 10);
    i1 = RL(i6 + f5(m, i5, n) + this.X[13] - 1454113458, 6);
    i5 = RL(i5, 10);
    i = RL(i + f1(i3, j, i4) + this.X[12], 8) + i2;
    j = RL(j, 10);
    i2 = RL(i2 + f1(i, i3, j) + this.X[15], 5) + i4;
    i3 = RL(i3, 10);
    i4 = RL(i4 + f1(i2, i, i3) + this.X[10], 12) + j;
    i = RL(i, 10);
    j = RL(j + f1(i4, i2, i) + this.X[4], 9) + i3;
    i2 = RL(i2, 10);
    i3 = RL(i3 + f1(j, i4, i2) + this.X[1], 12) + i;
    i4 = RL(i4, 10);
    i = RL(i + f1(i3, j, i4) + this.X[5], 5) + i2;
    j = RL(j, 10);
    i2 = RL(i2 + f1(i, i3, j) + this.X[8], 14) + i4;
    i3 = RL(i3, 10);
    i4 = RL(i4 + f1(i2, i, i3) + this.X[7], 6) + j;
    i = RL(i, 10);
    j = RL(j + f1(i4, i2, i) + this.X[6], 8) + i3;
    i2 = RL(i2, 10);
    i3 = RL(i3 + f1(j, i4, i2) + this.X[2], 13) + i;
    i4 = RL(i4, 10);
    i = RL(i + f1(i3, j, i4) + this.X[13], 6) + i2;
    j = RL(j, 10);
    i2 = RL(i2 + f1(i, i3, j) + this.X[14], 5) + i4;
    i3 = RL(i3, 10);
    i4 = RL(i4 + f1(i2, i, i3) + this.X[0], 15) + j;
    i = RL(i, 10);
    j = RL(j + f1(i4, i2, i) + this.X[3], 13) + i3;
    i2 = RL(i2, 10);
    i3 = RL(i3 + f1(j, i4, i2) + this.X[9], 11) + i;
    i4 = RL(i4, 10);
    i = RL(i + f1(i3, j, i4) + this.X[11], 11);
    j = RL(j, 10);
    this.H0 += k;
    this.H1 += i1 + k;
    this.H2 += m;
    this.H3 += i5;
    this.H4 += i4;
    this.H5 += i2;
    this.H6 += i + i2;
    this.H7 += i3;
    this.H8 += j;
    this.H9 += n;
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
    this.H4 = -1009589776;
    this.H5 = 1985229328;
    this.H6 = -19088744;
    this.H7 = -1985229329;
    this.H8 = 19088743;
    this.H9 = 1009589775;
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
    doCopy((RIPEMD320Digest)paramMemoable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\digests\RIPEMD320Digest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */