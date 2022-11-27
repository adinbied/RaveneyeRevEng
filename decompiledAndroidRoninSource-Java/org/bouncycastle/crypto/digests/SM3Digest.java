package org.bouncycastle.crypto.digests;

import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

public class SM3Digest
  extends GeneralDigest
{
  private static final int BLOCK_SIZE = 16;
  private static final int DIGEST_LENGTH = 32;
  private static final int[] T = new int[64];
  private int[] V = new int[8];
  private int[] W = new int[68];
  private int[] W1 = new int[64];
  private int[] inwords = new int[16];
  private int xOff;
  
  static
  {
    int i = 0;
    int j;
    for (;;)
    {
      j = 16;
      if (i >= 16) {
        break;
      }
      T[i] = (2043430169 >>> 32 - i | 2043430169 << i);
      i += 1;
    }
    while (j < 64)
    {
      i = j % 32;
      T[j] = (2055708042 >>> 32 - i | 2055708042 << i);
      j += 1;
    }
  }
  
  public SM3Digest()
  {
    reset();
  }
  
  public SM3Digest(SM3Digest paramSM3Digest)
  {
    super(paramSM3Digest);
    copyIn(paramSM3Digest);
  }
  
  private int FF0(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 ^ paramInt2 ^ paramInt3;
  }
  
  private int FF1(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt3 | paramInt1 & paramInt2 | paramInt2 & paramInt3;
  }
  
  private int GG0(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 ^ paramInt2 ^ paramInt3;
  }
  
  private int GG1(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt3 | paramInt2 & paramInt1;
  }
  
  private int P0(int paramInt)
  {
    return paramInt ^ (paramInt << 9 | paramInt >>> 23) ^ (paramInt << 17 | paramInt >>> 15);
  }
  
  private int P1(int paramInt)
  {
    return paramInt ^ (paramInt << 15 | paramInt >>> 17) ^ (paramInt << 23 | paramInt >>> 9);
  }
  
  private void copyIn(SM3Digest paramSM3Digest)
  {
    int[] arrayOfInt1 = paramSM3Digest.V;
    int[] arrayOfInt2 = this.V;
    System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, arrayOfInt2.length);
    arrayOfInt1 = paramSM3Digest.inwords;
    arrayOfInt2 = this.inwords;
    System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, arrayOfInt2.length);
    this.xOff = paramSM3Digest.xOff;
  }
  
  public Memoable copy()
  {
    return new SM3Digest(this);
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    finish();
    Pack.intToBigEndian(this.V[0], paramArrayOfByte, paramInt + 0);
    Pack.intToBigEndian(this.V[1], paramArrayOfByte, paramInt + 4);
    Pack.intToBigEndian(this.V[2], paramArrayOfByte, paramInt + 8);
    Pack.intToBigEndian(this.V[3], paramArrayOfByte, paramInt + 12);
    Pack.intToBigEndian(this.V[4], paramArrayOfByte, paramInt + 16);
    Pack.intToBigEndian(this.V[5], paramArrayOfByte, paramInt + 20);
    Pack.intToBigEndian(this.V[6], paramArrayOfByte, paramInt + 24);
    Pack.intToBigEndian(this.V[7], paramArrayOfByte, paramInt + 28);
    reset();
    return 32;
  }
  
  public String getAlgorithmName()
  {
    return "SM3";
  }
  
  public int getDigestSize()
  {
    return 32;
  }
  
  protected void processBlock()
  {
    int i = 0;
    while (i < 16)
    {
      this.W[i] = this.inwords[i];
      i += 1;
    }
    i = 16;
    while (i < 68)
    {
      arrayOfInt1 = this.W;
      j = arrayOfInt1[(i - 3)];
      k = arrayOfInt1[(i - 13)];
      arrayOfInt1[i] = (P1((j >>> 17 | j << 15) ^ arrayOfInt1[(i - 16)] ^ arrayOfInt1[(i - 9)]) ^ (k >>> 25 | k << 7) ^ this.W[(i - 6)]);
      i += 1;
    }
    i = 0;
    while (i < 64)
    {
      arrayOfInt1 = this.W1;
      int[] arrayOfInt2 = this.W;
      j = arrayOfInt2[i];
      arrayOfInt1[i] = (arrayOfInt2[(i + 4)] ^ j);
      i += 1;
    }
    int[] arrayOfInt1 = this.V;
    i = arrayOfInt1[0];
    int i3 = arrayOfInt1[1];
    int j = arrayOfInt1[2];
    int n = arrayOfInt1[3];
    int i1 = arrayOfInt1[4];
    int m = arrayOfInt1[5];
    int k = arrayOfInt1[6];
    int i2 = arrayOfInt1[7];
    int i4 = 0;
    int i7;
    int i8;
    int i9;
    int i10;
    while (i4 < 16)
    {
      i7 = i << 12 | i >>> 20;
      i5 = i7 + i1 + T[i4];
      i8 = i5 << 7 | i5 >>> 25;
      i9 = FF0(i, i3, j);
      i10 = this.W1[i4];
      i5 = P0(GG0(i1, m, k) + i2 + i8 + this.W[i4]);
      i4 += 1;
      i6 = m << 19 | m >>> 13;
      m = i1;
      i1 = i;
      i = i9 + n + (i8 ^ i7) + i10;
      n = j;
      j = i3 << 9 | i3 >>> 23;
      i2 = k;
      i3 = i1;
      i1 = i5;
      k = i6;
    }
    i4 = i2;
    i2 = n;
    int i5 = i;
    int i6 = 16;
    n = m;
    i = j;
    m = i3;
    j = i5;
    i3 = i6;
    for (;;)
    {
      i6 = n;
      i5 = m;
      if (i3 >= 64) {
        break;
      }
      i7 = j << 12 | j >>> 20;
      m = i7 + i1 + T[i3];
      i8 = m << 7 | m >>> 25;
      i9 = FF1(j, i5, i);
      i10 = this.W1[i3];
      m = P0(GG1(i1, i6, k) + i4 + i8 + this.W[i3]);
      i3 += 1;
      n = i1;
      i1 = m;
      i4 = k;
      k = i6 << 19 | i6 >>> 13;
      m = j;
      j = i9 + i2 + (i8 ^ i7) + i10;
      i2 = i;
      i = i5 >>> 23 | i5 << 9;
    }
    arrayOfInt1 = this.V;
    arrayOfInt1[0] ^= j;
    arrayOfInt1[1] ^= i5;
    arrayOfInt1[2] ^= i;
    arrayOfInt1[3] ^= i2;
    arrayOfInt1[4] ^= i1;
    arrayOfInt1[5] ^= i6;
    arrayOfInt1[6] = (k ^ arrayOfInt1[6]);
    arrayOfInt1[7] ^= i4;
    this.xOff = 0;
  }
  
  protected void processLength(long paramLong)
  {
    int i = this.xOff;
    if (i > 14)
    {
      this.inwords[i] = 0;
      this.xOff = (i + 1);
      processBlock();
    }
    for (;;)
    {
      i = this.xOff;
      if (i >= 14) {
        break;
      }
      this.inwords[i] = 0;
      this.xOff = (i + 1);
    }
    int[] arrayOfInt = this.inwords;
    int j = i + 1;
    this.xOff = j;
    arrayOfInt[i] = ((int)(paramLong >>> 32));
    this.xOff = (j + 1);
    arrayOfInt[j] = ((int)paramLong);
  }
  
  protected void processWord(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    int j = paramInt + 1;
    paramInt = paramArrayOfByte[j];
    int k = j + 1;
    j = paramArrayOfByte[k];
    k = paramArrayOfByte[(k + 1)];
    paramArrayOfByte = this.inwords;
    int m = this.xOff;
    paramArrayOfByte[m] = (k & 0xFF | (i & 0xFF) << 24 | (paramInt & 0xFF) << 16 | (j & 0xFF) << 8);
    paramInt = m + 1;
    this.xOff = paramInt;
    if (paramInt >= 16) {
      processBlock();
    }
  }
  
  public void reset()
  {
    super.reset();
    int[] arrayOfInt = this.V;
    arrayOfInt[0] = 1937774191;
    arrayOfInt[1] = 1226093241;
    arrayOfInt[2] = 388252375;
    arrayOfInt[3] = -628488704;
    arrayOfInt[4] = -1452330820;
    arrayOfInt[5] = 372324522;
    arrayOfInt[6] = -477237683;
    arrayOfInt[7] = -1325724082;
    this.xOff = 0;
  }
  
  public void reset(Memoable paramMemoable)
  {
    paramMemoable = (SM3Digest)paramMemoable;
    super.copyIn(paramMemoable);
    copyIn(paramMemoable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\digests\SM3Digest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */