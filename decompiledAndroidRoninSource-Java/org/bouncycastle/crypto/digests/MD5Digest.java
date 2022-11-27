package org.bouncycastle.crypto.digests;

import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

public class MD5Digest
  extends GeneralDigest
  implements EncodableDigest
{
  private static final int DIGEST_LENGTH = 16;
  private static final int S11 = 7;
  private static final int S12 = 12;
  private static final int S13 = 17;
  private static final int S14 = 22;
  private static final int S21 = 5;
  private static final int S22 = 9;
  private static final int S23 = 14;
  private static final int S24 = 20;
  private static final int S31 = 4;
  private static final int S32 = 11;
  private static final int S33 = 16;
  private static final int S34 = 23;
  private static final int S41 = 6;
  private static final int S42 = 10;
  private static final int S43 = 15;
  private static final int S44 = 21;
  private int H1;
  private int H2;
  private int H3;
  private int H4;
  private int[] X = new int[16];
  private int xOff;
  
  public MD5Digest()
  {
    reset();
  }
  
  public MD5Digest(MD5Digest paramMD5Digest)
  {
    super(paramMD5Digest);
    copyIn(paramMD5Digest);
  }
  
  public MD5Digest(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
    this.H1 = Pack.bigEndianToInt(paramArrayOfByte, 16);
    this.H2 = Pack.bigEndianToInt(paramArrayOfByte, 20);
    this.H3 = Pack.bigEndianToInt(paramArrayOfByte, 24);
    this.H4 = Pack.bigEndianToInt(paramArrayOfByte, 28);
    this.xOff = Pack.bigEndianToInt(paramArrayOfByte, 32);
    int i = 0;
    while (i != this.xOff)
    {
      this.X[i] = Pack.bigEndianToInt(paramArrayOfByte, i * 4 + 36);
      i += 1;
    }
  }
  
  private int F(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt3 | paramInt2 & paramInt1;
  }
  
  private int G(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt3 | paramInt2 & paramInt3;
  }
  
  private int H(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 ^ paramInt2 ^ paramInt3;
  }
  
  private int K(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 | paramInt3) ^ paramInt2;
  }
  
  private void copyIn(MD5Digest paramMD5Digest)
  {
    super.copyIn(paramMD5Digest);
    this.H1 = paramMD5Digest.H1;
    this.H2 = paramMD5Digest.H2;
    this.H3 = paramMD5Digest.H3;
    this.H4 = paramMD5Digest.H4;
    int[] arrayOfInt = paramMD5Digest.X;
    System.arraycopy(arrayOfInt, 0, this.X, 0, arrayOfInt.length);
    this.xOff = paramMD5Digest.xOff;
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
    return new MD5Digest(this);
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
    return "MD5";
  }
  
  public int getDigestSize()
  {
    return 16;
  }
  
  public byte[] getEncodedState()
  {
    byte[] arrayOfByte = new byte[this.xOff * 4 + 36];
    super.populateState(arrayOfByte);
    Pack.intToBigEndian(this.H1, arrayOfByte, 16);
    Pack.intToBigEndian(this.H2, arrayOfByte, 20);
    Pack.intToBigEndian(this.H3, arrayOfByte, 24);
    Pack.intToBigEndian(this.H4, arrayOfByte, 28);
    Pack.intToBigEndian(this.xOff, arrayOfByte, 32);
    int i = 0;
    while (i != this.xOff)
    {
      Pack.intToBigEndian(this.X[i], arrayOfByte, i * 4 + 36);
      i += 1;
    }
    return arrayOfByte;
  }
  
  protected void processBlock()
  {
    int j = this.H1;
    int i = this.H2;
    int m = this.H3;
    int k = this.H4;
    j = rotateLeft(j + F(i, m, k) + this.X[0] - 680876936, 7) + i;
    k = rotateLeft(k + F(j, i, m) + this.X[1] - 389564586, 12) + j;
    m = rotateLeft(m + F(k, j, i) + this.X[2] + 606105819, 17) + k;
    i = rotateLeft(i + F(m, k, j) + this.X[3] - 1044525330, 22) + m;
    j = rotateLeft(j + F(i, m, k) + this.X[4] - 176418897, 7) + i;
    k = rotateLeft(k + F(j, i, m) + this.X[5] + 1200080426, 12) + j;
    m = rotateLeft(m + F(k, j, i) + this.X[6] - 1473231341, 17) + k;
    i = rotateLeft(i + F(m, k, j) + this.X[7] - 45705983, 22) + m;
    j = rotateLeft(j + F(i, m, k) + this.X[8] + 1770035416, 7) + i;
    k = rotateLeft(k + F(j, i, m) + this.X[9] - 1958414417, 12) + j;
    m = rotateLeft(m + F(k, j, i) + this.X[10] - 42063, 17) + k;
    i = rotateLeft(i + F(m, k, j) + this.X[11] - 1990404162, 22) + m;
    j = rotateLeft(j + F(i, m, k) + this.X[12] + 1804603682, 7) + i;
    k = rotateLeft(k + F(j, i, m) + this.X[13] - 40341101, 12) + j;
    m = rotateLeft(m + F(k, j, i) + this.X[14] - 1502002290, 17) + k;
    i = rotateLeft(i + F(m, k, j) + this.X[15] + 1236535329, 22) + m;
    j = rotateLeft(j + G(i, m, k) + this.X[1] - 165796510, 5) + i;
    k = rotateLeft(k + G(j, i, m) + this.X[6] - 1069501632, 9) + j;
    m = rotateLeft(m + G(k, j, i) + this.X[11] + 643717713, 14) + k;
    i = rotateLeft(i + G(m, k, j) + this.X[0] - 373897302, 20) + m;
    j = rotateLeft(j + G(i, m, k) + this.X[5] - 701558691, 5) + i;
    k = rotateLeft(k + G(j, i, m) + this.X[10] + 38016083, 9) + j;
    m = rotateLeft(m + G(k, j, i) + this.X[15] - 660478335, 14) + k;
    i = rotateLeft(i + G(m, k, j) + this.X[4] - 405537848, 20) + m;
    j = rotateLeft(j + G(i, m, k) + this.X[9] + 568446438, 5) + i;
    k = rotateLeft(k + G(j, i, m) + this.X[14] - 1019803690, 9) + j;
    m = rotateLeft(m + G(k, j, i) + this.X[3] - 187363961, 14) + k;
    i = rotateLeft(i + G(m, k, j) + this.X[8] + 1163531501, 20) + m;
    j = rotateLeft(j + G(i, m, k) + this.X[13] - 1444681467, 5) + i;
    k = rotateLeft(k + G(j, i, m) + this.X[2] - 51403784, 9) + j;
    m = rotateLeft(m + G(k, j, i) + this.X[7] + 1735328473, 14) + k;
    i = rotateLeft(i + G(m, k, j) + this.X[12] - 1926607734, 20) + m;
    j = rotateLeft(j + H(i, m, k) + this.X[5] - 378558, 4) + i;
    k = rotateLeft(k + H(j, i, m) + this.X[8] - 2022574463, 11) + j;
    m = rotateLeft(m + H(k, j, i) + this.X[11] + 1839030562, 16) + k;
    i = rotateLeft(i + H(m, k, j) + this.X[14] - 35309556, 23) + m;
    j = rotateLeft(j + H(i, m, k) + this.X[1] - 1530992060, 4) + i;
    k = rotateLeft(k + H(j, i, m) + this.X[4] + 1272893353, 11) + j;
    m = rotateLeft(m + H(k, j, i) + this.X[7] - 155497632, 16) + k;
    i = rotateLeft(i + H(m, k, j) + this.X[10] - 1094730640, 23) + m;
    j = rotateLeft(j + H(i, m, k) + this.X[13] + 681279174, 4) + i;
    k = rotateLeft(k + H(j, i, m) + this.X[0] - 358537222, 11) + j;
    m = rotateLeft(m + H(k, j, i) + this.X[3] - 722521979, 16) + k;
    i = rotateLeft(i + H(m, k, j) + this.X[6] + 76029189, 23) + m;
    j = rotateLeft(j + H(i, m, k) + this.X[9] - 640364487, 4) + i;
    k = rotateLeft(k + H(j, i, m) + this.X[12] - 421815835, 11) + j;
    m = rotateLeft(m + H(k, j, i) + this.X[15] + 530742520, 16) + k;
    i = rotateLeft(i + H(m, k, j) + this.X[2] - 995338651, 23) + m;
    j = rotateLeft(j + K(i, m, k) + this.X[0] - 198630844, 6) + i;
    k = rotateLeft(k + K(j, i, m) + this.X[7] + 1126891415, 10) + j;
    m = rotateLeft(m + K(k, j, i) + this.X[14] - 1416354905, 15) + k;
    i = rotateLeft(i + K(m, k, j) + this.X[5] - 57434055, 21) + m;
    j = rotateLeft(j + K(i, m, k) + this.X[12] + 1700485571, 6) + i;
    k = rotateLeft(k + K(j, i, m) + this.X[3] - 1894986606, 10) + j;
    m = rotateLeft(m + K(k, j, i) + this.X[10] - 1051523, 15) + k;
    i = rotateLeft(i + K(m, k, j) + this.X[1] - 2054922799, 21) + m;
    j = rotateLeft(j + K(i, m, k) + this.X[8] + 1873313359, 6) + i;
    k = rotateLeft(k + K(j, i, m) + this.X[15] - 30611744, 10) + j;
    m = rotateLeft(m + K(k, j, i) + this.X[6] - 1560198380, 15) + k;
    i = rotateLeft(i + K(m, k, j) + this.X[13] + 1309151649, 21) + m;
    j = rotateLeft(j + K(i, m, k) + this.X[4] - 145523070, 6) + i;
    k = rotateLeft(k + K(j, i, m) + this.X[11] - 1120210379, 10) + j;
    m = rotateLeft(m + K(k, j, i) + this.X[2] + 718787259, 15) + k;
    i = rotateLeft(i + K(m, k, j) + this.X[9] - 343485551, 21);
    this.H1 += j;
    this.H2 += i + m;
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
    copyIn((MD5Digest)paramMemoable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\digests\MD5Digest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */