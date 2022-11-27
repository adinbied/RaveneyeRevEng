package org.bouncycastle.crypto.digests;

import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

public class SHA224Digest
  extends GeneralDigest
  implements EncodableDigest
{
  private static final int DIGEST_LENGTH = 28;
  static final int[] K = { 1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998 };
  private int H1;
  private int H2;
  private int H3;
  private int H4;
  private int H5;
  private int H6;
  private int H7;
  private int H8;
  private int[] X = new int[64];
  private int xOff;
  
  public SHA224Digest()
  {
    reset();
  }
  
  public SHA224Digest(SHA224Digest paramSHA224Digest)
  {
    super(paramSHA224Digest);
    doCopy(paramSHA224Digest);
  }
  
  public SHA224Digest(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
    this.H1 = Pack.bigEndianToInt(paramArrayOfByte, 16);
    this.H2 = Pack.bigEndianToInt(paramArrayOfByte, 20);
    this.H3 = Pack.bigEndianToInt(paramArrayOfByte, 24);
    this.H4 = Pack.bigEndianToInt(paramArrayOfByte, 28);
    this.H5 = Pack.bigEndianToInt(paramArrayOfByte, 32);
    this.H6 = Pack.bigEndianToInt(paramArrayOfByte, 36);
    this.H7 = Pack.bigEndianToInt(paramArrayOfByte, 40);
    this.H8 = Pack.bigEndianToInt(paramArrayOfByte, 44);
    this.xOff = Pack.bigEndianToInt(paramArrayOfByte, 48);
    int i = 0;
    while (i != this.xOff)
    {
      this.X[i] = Pack.bigEndianToInt(paramArrayOfByte, i * 4 + 52);
      i += 1;
    }
  }
  
  private int Ch(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt3 ^ paramInt2 & paramInt1;
  }
  
  private int Maj(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt3 ^ paramInt1 & paramInt2 ^ paramInt2 & paramInt3;
  }
  
  private int Sum0(int paramInt)
  {
    return (paramInt << 10 | paramInt >>> 22) ^ (paramInt >>> 2 | paramInt << 30) ^ (paramInt >>> 13 | paramInt << 19);
  }
  
  private int Sum1(int paramInt)
  {
    return (paramInt << 7 | paramInt >>> 25) ^ (paramInt >>> 6 | paramInt << 26) ^ (paramInt >>> 11 | paramInt << 21);
  }
  
  private int Theta0(int paramInt)
  {
    return paramInt >>> 3 ^ (paramInt >>> 7 | paramInt << 25) ^ (paramInt >>> 18 | paramInt << 14);
  }
  
  private int Theta1(int paramInt)
  {
    return paramInt >>> 10 ^ (paramInt >>> 17 | paramInt << 15) ^ (paramInt >>> 19 | paramInt << 13);
  }
  
  private void doCopy(SHA224Digest paramSHA224Digest)
  {
    super.copyIn(paramSHA224Digest);
    this.H1 = paramSHA224Digest.H1;
    this.H2 = paramSHA224Digest.H2;
    this.H3 = paramSHA224Digest.H3;
    this.H4 = paramSHA224Digest.H4;
    this.H5 = paramSHA224Digest.H5;
    this.H6 = paramSHA224Digest.H6;
    this.H7 = paramSHA224Digest.H7;
    this.H8 = paramSHA224Digest.H8;
    int[] arrayOfInt = paramSHA224Digest.X;
    System.arraycopy(arrayOfInt, 0, this.X, 0, arrayOfInt.length);
    this.xOff = paramSHA224Digest.xOff;
  }
  
  public Memoable copy()
  {
    return new SHA224Digest(this);
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    finish();
    Pack.intToBigEndian(this.H1, paramArrayOfByte, paramInt);
    Pack.intToBigEndian(this.H2, paramArrayOfByte, paramInt + 4);
    Pack.intToBigEndian(this.H3, paramArrayOfByte, paramInt + 8);
    Pack.intToBigEndian(this.H4, paramArrayOfByte, paramInt + 12);
    Pack.intToBigEndian(this.H5, paramArrayOfByte, paramInt + 16);
    Pack.intToBigEndian(this.H6, paramArrayOfByte, paramInt + 20);
    Pack.intToBigEndian(this.H7, paramArrayOfByte, paramInt + 24);
    reset();
    return 28;
  }
  
  public String getAlgorithmName()
  {
    return "SHA-224";
  }
  
  public int getDigestSize()
  {
    return 28;
  }
  
  public byte[] getEncodedState()
  {
    byte[] arrayOfByte = new byte[this.xOff * 4 + 52];
    super.populateState(arrayOfByte);
    Pack.intToBigEndian(this.H1, arrayOfByte, 16);
    Pack.intToBigEndian(this.H2, arrayOfByte, 20);
    Pack.intToBigEndian(this.H3, arrayOfByte, 24);
    Pack.intToBigEndian(this.H4, arrayOfByte, 28);
    Pack.intToBigEndian(this.H5, arrayOfByte, 32);
    Pack.intToBigEndian(this.H6, arrayOfByte, 36);
    Pack.intToBigEndian(this.H7, arrayOfByte, 40);
    Pack.intToBigEndian(this.H8, arrayOfByte, 44);
    Pack.intToBigEndian(this.xOff, arrayOfByte, 48);
    int i = 0;
    while (i != this.xOff)
    {
      Pack.intToBigEndian(this.X[i], arrayOfByte, i * 4 + 52);
      i += 1;
    }
    return arrayOfByte;
  }
  
  protected void processBlock()
  {
    int i = 16;
    while (i <= 63)
    {
      int[] arrayOfInt1 = this.X;
      j = Theta1(arrayOfInt1[(i - 2)]);
      int[] arrayOfInt2 = this.X;
      arrayOfInt1[i] = (j + arrayOfInt2[(i - 7)] + Theta0(arrayOfInt2[(i - 15)]) + this.X[(i - 16)]);
      i += 1;
    }
    int j = this.H1;
    int m = this.H2;
    int i1 = this.H3;
    int i4 = this.H4;
    int k = this.H5;
    int n = this.H6;
    int i2 = this.H7;
    int i5 = this.H8;
    i = 0;
    int i3 = 0;
    while (i < 8)
    {
      i5 += Sum1(k) + Ch(k, n, i2) + K[i3] + this.X[i3];
      i4 += i5;
      i5 += Sum0(j) + Maj(j, m, i1);
      i3 += 1;
      i2 += Sum1(i4) + Ch(i4, k, n) + K[i3] + this.X[i3];
      i1 += i2;
      i2 += Sum0(i5) + Maj(i5, j, m);
      i3 += 1;
      n += Sum1(i1) + Ch(i1, i4, k) + K[i3] + this.X[i3];
      m += n;
      n += Sum0(i2) + Maj(i2, i5, j);
      i3 += 1;
      k += Sum1(m) + Ch(m, i1, i4) + K[i3] + this.X[i3];
      j += k;
      k += Sum0(n) + Maj(n, i2, i5);
      i3 += 1;
      i4 += Sum1(j) + Ch(j, m, i1) + K[i3] + this.X[i3];
      i5 += i4;
      i4 += Sum0(k) + Maj(k, n, i2);
      i3 += 1;
      i1 += Sum1(i5) + Ch(i5, j, m) + K[i3] + this.X[i3];
      i2 += i1;
      i1 += Sum0(i4) + Maj(i4, k, n);
      i3 += 1;
      m += Sum1(i2) + Ch(i2, i5, j) + K[i3] + this.X[i3];
      n += m;
      m += Sum0(i1) + Maj(i1, i4, k);
      i3 += 1;
      j += Sum1(n) + Ch(n, i2, i5) + K[i3] + this.X[i3];
      k += j;
      j += Sum0(m) + Maj(m, i1, i4);
      i3 += 1;
      i += 1;
    }
    this.H1 += j;
    this.H2 += m;
    this.H3 += i1;
    this.H4 += i4;
    this.H5 += k;
    this.H6 += n;
    this.H7 += i2;
    this.H8 += i5;
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
    this.H1 = -1056596264;
    this.H2 = 914150663;
    this.H3 = 812702999;
    this.H4 = -150054599;
    this.H5 = -4191439;
    this.H6 = 1750603025;
    this.H7 = 1694076839;
    this.H8 = -1090891868;
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
    doCopy((SHA224Digest)paramMemoable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\digests\SHA224Digest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */