package org.bouncycastle.crypto.digests;

import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.MemoableResetException;
import org.bouncycastle.util.Pack;

public class SHA512tDigest
  extends LongDigest
{
  private long H1t;
  private long H2t;
  private long H3t;
  private long H4t;
  private long H5t;
  private long H6t;
  private long H7t;
  private long H8t;
  private int digestLength;
  
  public SHA512tDigest(int paramInt)
  {
    if (paramInt < 512)
    {
      if (paramInt % 8 == 0)
      {
        if (paramInt != 384)
        {
          paramInt /= 8;
          this.digestLength = paramInt;
          tIvGenerate(paramInt * 8);
          reset();
          return;
        }
        throw new IllegalArgumentException("bitLength cannot be 384 use SHA384 instead");
      }
      throw new IllegalArgumentException("bitLength needs to be a multiple of 8");
    }
    throw new IllegalArgumentException("bitLength cannot be >= 512");
  }
  
  public SHA512tDigest(SHA512tDigest paramSHA512tDigest)
  {
    super(paramSHA512tDigest);
    this.digestLength = paramSHA512tDigest.digestLength;
    reset(paramSHA512tDigest);
  }
  
  public SHA512tDigest(byte[] paramArrayOfByte)
  {
    this(readDigestLength(paramArrayOfByte));
    restoreState(paramArrayOfByte);
  }
  
  private static void intToBigEndian(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    paramInt3 = Math.min(4, paramInt3);
    for (;;)
    {
      paramInt3 -= 1;
      if (paramInt3 < 0) {
        break;
      }
      paramArrayOfByte[(paramInt2 + paramInt3)] = ((byte)(paramInt1 >>> (3 - paramInt3) * 8));
    }
  }
  
  private static void longToBigEndian(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0)
    {
      intToBigEndian((int)(paramLong >>> 32), paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt2 > 4) {
        intToBigEndian((int)(paramLong & 0xFFFFFFFF), paramArrayOfByte, paramInt1 + 4, paramInt2 - 4);
      }
    }
  }
  
  private static int readDigestLength(byte[] paramArrayOfByte)
  {
    return Pack.bigEndianToInt(paramArrayOfByte, paramArrayOfByte.length - 4);
  }
  
  private void tIvGenerate(int paramInt)
  {
    this.H1 = -3482333909917012819L;
    this.H2 = 2216346199247487646L;
    this.H3 = -7364697282686394994L;
    this.H4 = 65953792586715988L;
    this.H5 = -816286391624063116L;
    this.H6 = 4512832404995164602L;
    this.H7 = -5033199132376557362L;
    this.H8 = -124578254951840548L;
    update((byte)83);
    update((byte)72);
    update((byte)65);
    update((byte)45);
    update((byte)53);
    update((byte)49);
    update((byte)50);
    update((byte)47);
    if (paramInt > 100)
    {
      update((byte)(paramInt / 100 + 48));
      paramInt %= 100;
    }
    for (;;)
    {
      update((byte)(paramInt / 10 + 48));
      int i = paramInt % 10;
      do
      {
        update((byte)(i + 48));
        break;
        i = paramInt;
      } while (paramInt <= 10);
    }
    finish();
    this.H1t = this.H1;
    this.H2t = this.H2;
    this.H3t = this.H3;
    this.H4t = this.H4;
    this.H5t = this.H5;
    this.H6t = this.H6;
    this.H7t = this.H7;
    this.H8t = this.H8;
  }
  
  public Memoable copy()
  {
    return new SHA512tDigest(this);
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    finish();
    longToBigEndian(this.H1, paramArrayOfByte, paramInt, this.digestLength);
    longToBigEndian(this.H2, paramArrayOfByte, paramInt + 8, this.digestLength - 8);
    longToBigEndian(this.H3, paramArrayOfByte, paramInt + 16, this.digestLength - 16);
    longToBigEndian(this.H4, paramArrayOfByte, paramInt + 24, this.digestLength - 24);
    longToBigEndian(this.H5, paramArrayOfByte, paramInt + 32, this.digestLength - 32);
    longToBigEndian(this.H6, paramArrayOfByte, paramInt + 40, this.digestLength - 40);
    longToBigEndian(this.H7, paramArrayOfByte, paramInt + 48, this.digestLength - 48);
    longToBigEndian(this.H8, paramArrayOfByte, paramInt + 56, this.digestLength - 56);
    reset();
    return this.digestLength;
  }
  
  public String getAlgorithmName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SHA-512/");
    localStringBuilder.append(Integer.toString(this.digestLength * 8));
    return localStringBuilder.toString();
  }
  
  public int getDigestSize()
  {
    return this.digestLength;
  }
  
  public byte[] getEncodedState()
  {
    int i = getEncodedStateSize();
    byte[] arrayOfByte = new byte[i + 4];
    populateState(arrayOfByte);
    Pack.intToBigEndian(this.digestLength * 8, arrayOfByte, i);
    return arrayOfByte;
  }
  
  public void reset()
  {
    super.reset();
    this.H1 = this.H1t;
    this.H2 = this.H2t;
    this.H3 = this.H3t;
    this.H4 = this.H4t;
    this.H5 = this.H5t;
    this.H6 = this.H6t;
    this.H7 = this.H7t;
    this.H8 = this.H8t;
  }
  
  public void reset(Memoable paramMemoable)
  {
    paramMemoable = (SHA512tDigest)paramMemoable;
    if (this.digestLength == paramMemoable.digestLength)
    {
      super.copyIn(paramMemoable);
      this.H1t = paramMemoable.H1t;
      this.H2t = paramMemoable.H2t;
      this.H3t = paramMemoable.H3t;
      this.H4t = paramMemoable.H4t;
      this.H5t = paramMemoable.H5t;
      this.H6t = paramMemoable.H6t;
      this.H7t = paramMemoable.H7t;
      this.H8t = paramMemoable.H8t;
      return;
    }
    throw new MemoableResetException("digestLength inappropriate in other");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\digests\SHA512tDigest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */