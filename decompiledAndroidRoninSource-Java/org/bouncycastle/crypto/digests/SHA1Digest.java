package org.bouncycastle.crypto.digests;

import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

public class SHA1Digest
  extends GeneralDigest
  implements EncodableDigest
{
  private static final int DIGEST_LENGTH = 20;
  private static final int Y1 = 1518500249;
  private static final int Y2 = 1859775393;
  private static final int Y3 = -1894007588;
  private static final int Y4 = -899497514;
  private int H1;
  private int H2;
  private int H3;
  private int H4;
  private int H5;
  private int[] X = new int[80];
  private int xOff;
  
  public SHA1Digest()
  {
    reset();
  }
  
  public SHA1Digest(SHA1Digest paramSHA1Digest)
  {
    super(paramSHA1Digest);
    copyIn(paramSHA1Digest);
  }
  
  public SHA1Digest(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
    this.H1 = Pack.bigEndianToInt(paramArrayOfByte, 16);
    this.H2 = Pack.bigEndianToInt(paramArrayOfByte, 20);
    this.H3 = Pack.bigEndianToInt(paramArrayOfByte, 24);
    this.H4 = Pack.bigEndianToInt(paramArrayOfByte, 28);
    this.H5 = Pack.bigEndianToInt(paramArrayOfByte, 32);
    this.xOff = Pack.bigEndianToInt(paramArrayOfByte, 36);
    int i = 0;
    while (i != this.xOff)
    {
      this.X[i] = Pack.bigEndianToInt(paramArrayOfByte, i * 4 + 40);
      i += 1;
    }
  }
  
  private void copyIn(SHA1Digest paramSHA1Digest)
  {
    this.H1 = paramSHA1Digest.H1;
    this.H2 = paramSHA1Digest.H2;
    this.H3 = paramSHA1Digest.H3;
    this.H4 = paramSHA1Digest.H4;
    this.H5 = paramSHA1Digest.H5;
    int[] arrayOfInt = paramSHA1Digest.X;
    System.arraycopy(arrayOfInt, 0, this.X, 0, arrayOfInt.length);
    this.xOff = paramSHA1Digest.xOff;
  }
  
  private int f(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt3 | paramInt2 & paramInt1;
  }
  
  private int g(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt3 | paramInt1 & paramInt2 | paramInt2 & paramInt3;
  }
  
  private int h(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 ^ paramInt2 ^ paramInt3;
  }
  
  public Memoable copy()
  {
    return new SHA1Digest(this);
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    finish();
    Pack.intToBigEndian(this.H1, paramArrayOfByte, paramInt);
    Pack.intToBigEndian(this.H2, paramArrayOfByte, paramInt + 4);
    Pack.intToBigEndian(this.H3, paramArrayOfByte, paramInt + 8);
    Pack.intToBigEndian(this.H4, paramArrayOfByte, paramInt + 12);
    Pack.intToBigEndian(this.H5, paramArrayOfByte, paramInt + 16);
    reset();
    return 20;
  }
  
  public String getAlgorithmName()
  {
    return "SHA-1";
  }
  
  public int getDigestSize()
  {
    return 20;
  }
  
  public byte[] getEncodedState()
  {
    byte[] arrayOfByte = new byte[this.xOff * 4 + 40];
    super.populateState(arrayOfByte);
    Pack.intToBigEndian(this.H1, arrayOfByte, 16);
    Pack.intToBigEndian(this.H2, arrayOfByte, 20);
    Pack.intToBigEndian(this.H3, arrayOfByte, 24);
    Pack.intToBigEndian(this.H4, arrayOfByte, 28);
    Pack.intToBigEndian(this.H5, arrayOfByte, 32);
    Pack.intToBigEndian(this.xOff, arrayOfByte, 36);
    int i = 0;
    while (i != this.xOff)
    {
      Pack.intToBigEndian(this.X[i], arrayOfByte, i * 4 + 40);
      i += 1;
    }
    return arrayOfByte;
  }
  
  protected void processBlock()
  {
    int i = 16;
    int[] arrayOfInt;
    while (i < 80)
    {
      arrayOfInt = this.X;
      j = arrayOfInt[(i - 3)] ^ arrayOfInt[(i - 8)] ^ arrayOfInt[(i - 14)] ^ arrayOfInt[(i - 16)];
      arrayOfInt[i] = (j >>> 31 | j << 1);
      i += 1;
    }
    int j = this.H1;
    int m = this.H2;
    i = this.H3;
    int k = this.H4;
    int n = this.H5;
    int i2 = 0;
    int i1 = 0;
    int i4;
    while (i2 < 4)
    {
      i4 = f(m, i, k);
      arrayOfInt = this.X;
      i3 = i1 + 1;
      n += (j << 5 | j >>> 27) + i4 + arrayOfInt[i1] + 1518500249;
      m = m >>> 2 | m << 30;
      i4 = f(j, m, i);
      arrayOfInt = this.X;
      i1 = i3 + 1;
      k += (n << 5 | n >>> 27) + i4 + arrayOfInt[i3] + 1518500249;
      j = j >>> 2 | j << 30;
      i4 = f(n, j, m);
      arrayOfInt = this.X;
      i3 = i1 + 1;
      i += (k << 5 | k >>> 27) + i4 + arrayOfInt[i1] + 1518500249;
      n = n >>> 2 | n << 30;
      i4 = f(k, n, j);
      arrayOfInt = this.X;
      i1 = i3 + 1;
      m += (i << 5 | i >>> 27) + i4 + arrayOfInt[i3] + 1518500249;
      k = k >>> 2 | k << 30;
      j += (m << 5 | m >>> 27) + f(i, k, n) + this.X[i1] + 1518500249;
      i = i >>> 2 | i << 30;
      i2 += 1;
      i1 += 1;
    }
    i2 = 0;
    while (i2 < 4)
    {
      i4 = h(m, i, k);
      arrayOfInt = this.X;
      i3 = i1 + 1;
      n += (j << 5 | j >>> 27) + i4 + arrayOfInt[i1] + 1859775393;
      m = m >>> 2 | m << 30;
      i4 = h(j, m, i);
      arrayOfInt = this.X;
      i1 = i3 + 1;
      k += (n << 5 | n >>> 27) + i4 + arrayOfInt[i3] + 1859775393;
      j = j >>> 2 | j << 30;
      i4 = h(n, j, m);
      arrayOfInt = this.X;
      i3 = i1 + 1;
      i += (k << 5 | k >>> 27) + i4 + arrayOfInt[i1] + 1859775393;
      n = n >>> 2 | n << 30;
      i4 = h(k, n, j);
      arrayOfInt = this.X;
      i1 = i3 + 1;
      m += (i << 5 | i >>> 27) + i4 + arrayOfInt[i3] + 1859775393;
      k = k >>> 2 | k << 30;
      j += (m << 5 | m >>> 27) + h(i, k, n) + this.X[i1] + 1859775393;
      i = i >>> 2 | i << 30;
      i2 += 1;
      i1 += 1;
    }
    i2 = 0;
    while (i2 < 4)
    {
      i4 = g(m, i, k);
      arrayOfInt = this.X;
      i3 = i1 + 1;
      n += (j << 5 | j >>> 27) + i4 + arrayOfInt[i1] - 1894007588;
      m = m >>> 2 | m << 30;
      i4 = g(j, m, i);
      arrayOfInt = this.X;
      i1 = i3 + 1;
      k += (n << 5 | n >>> 27) + i4 + arrayOfInt[i3] - 1894007588;
      j = j >>> 2 | j << 30;
      i4 = g(n, j, m);
      arrayOfInt = this.X;
      i3 = i1 + 1;
      i += (k << 5 | k >>> 27) + i4 + arrayOfInt[i1] - 1894007588;
      n = n >>> 2 | n << 30;
      i4 = g(k, n, j);
      arrayOfInt = this.X;
      i1 = i3 + 1;
      m += (i << 5 | i >>> 27) + i4 + arrayOfInt[i3] - 1894007588;
      k = k >>> 2 | k << 30;
      j += (m << 5 | m >>> 27) + g(i, k, n) + this.X[i1] - 1894007588;
      i = i >>> 2 | i << 30;
      i2 += 1;
      i1 += 1;
    }
    int i3 = 0;
    i2 = i1;
    i1 = i3;
    while (i1 <= 3)
    {
      i4 = h(m, i, k);
      arrayOfInt = this.X;
      i3 = i2 + 1;
      n += (j << 5 | j >>> 27) + i4 + arrayOfInt[i2] - 899497514;
      m = m >>> 2 | m << 30;
      i4 = h(j, m, i);
      arrayOfInt = this.X;
      i2 = i3 + 1;
      k += (n << 5 | n >>> 27) + i4 + arrayOfInt[i3] - 899497514;
      j = j >>> 2 | j << 30;
      i4 = h(n, j, m);
      arrayOfInt = this.X;
      i3 = i2 + 1;
      i += (k << 5 | k >>> 27) + i4 + arrayOfInt[i2] - 899497514;
      n = n >>> 2 | n << 30;
      i4 = h(k, n, j);
      arrayOfInt = this.X;
      i2 = i3 + 1;
      m += (i << 5 | i >>> 27) + i4 + arrayOfInt[i3] - 899497514;
      k = k >>> 2 | k << 30;
      j += (m << 5 | m >>> 27) + h(i, k, n) + this.X[i2] - 899497514;
      i = i >>> 2 | i << 30;
      i1 += 1;
      i2 += 1;
    }
    this.H1 += j;
    this.H2 += m;
    this.H3 += i;
    this.H4 += k;
    this.H5 += n;
    this.xOff = 0;
    i = 0;
    while (i < 16)
    {
      this.X[i] = 0;
      i += 1;
    }
  }
  
  protected void processLength(long paramLong)
  {
    if (this.xOff > 14) {
      processBlock();
    }
    int[] arrayOfInt = this.X;
    arrayOfInt[14] = ((int)(paramLong >>> 32));
    arrayOfInt[15] = ((int)(paramLong & 0xFFFFFFFFFFFFFFFF));
  }
  
  protected void processWord(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    int j = paramInt + 1;
    paramInt = paramArrayOfByte[j];
    int k = j + 1;
    j = paramArrayOfByte[k];
    k = paramArrayOfByte[(k + 1)];
    paramArrayOfByte = this.X;
    int m = this.xOff;
    paramArrayOfByte[m] = (k & 0xFF | i << 24 | (paramInt & 0xFF) << 16 | (j & 0xFF) << 8);
    paramInt = m + 1;
    this.xOff = paramInt;
    if (paramInt == 16) {
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
    this.H5 = -1009589776;
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
    paramMemoable = (SHA1Digest)paramMemoable;
    super.copyIn(paramMemoable);
    copyIn(paramMemoable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\digests\SHA1Digest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */