package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.util.Memoable;

public class MD2Digest
  implements ExtendedDigest, Memoable
{
  private static final int DIGEST_LENGTH = 16;
  private static final byte[] S = { 41, 46, 67, -55, -94, -40, 124, 1, 61, 54, 84, -95, -20, -16, 6, 19, 98, -89, 5, -13, -64, -57, 115, -116, -104, -109, 43, -39, -68, 76, -126, -54, 30, -101, 87, 60, -3, -44, -32, 22, 103, 66, 111, 24, -118, 23, -27, 18, -66, 78, -60, -42, -38, -98, -34, 73, -96, -5, -11, -114, -69, 47, -18, 122, -87, 104, 121, -111, 21, -78, 7, 63, -108, -62, 16, -119, 11, 34, 95, 33, -128, 127, 93, -102, 90, -112, 50, 39, 53, 62, -52, -25, -65, -9, -105, 3, -1, 25, 48, -77, 72, -91, -75, -47, -41, 94, -110, 42, -84, 86, -86, -58, 79, -72, 56, -46, -106, -92, 125, -74, 118, -4, 107, -30, -100, 116, 4, -15, 69, -99, 112, 89, 100, 113, -121, 32, -122, 91, -49, 101, -26, 45, -88, 2, 27, 96, 37, -83, -82, -80, -71, -10, 28, 70, 97, 105, 52, 64, 126, 15, 85, 71, -93, 35, -35, 81, -81, 58, -61, 92, -7, -50, -70, -59, -22, 38, 44, 83, 13, 110, -123, 40, -124, 9, -45, -33, -51, -12, 65, -127, 77, 82, 106, -36, 55, -56, 108, -63, -85, -6, 36, -31, 123, 8, 12, -67, -79, 74, 120, -120, -107, -117, -29, 99, -24, 109, -23, -53, -43, -2, 59, 0, 29, 57, -14, -17, -73, 14, 102, 88, -48, -28, -90, 119, 114, -8, -21, 117, 75, 10, 49, 68, 80, -76, -113, -19, 31, 26, -37, -103, -115, 51, -97, 17, -125, 20 };
  private byte[] C = new byte[16];
  private int COff;
  private byte[] M = new byte[16];
  private byte[] X = new byte[48];
  private int mOff;
  private int xOff;
  
  public MD2Digest()
  {
    reset();
  }
  
  public MD2Digest(MD2Digest paramMD2Digest)
  {
    copyIn(paramMD2Digest);
  }
  
  private void copyIn(MD2Digest paramMD2Digest)
  {
    byte[] arrayOfByte = paramMD2Digest.X;
    System.arraycopy(arrayOfByte, 0, this.X, 0, arrayOfByte.length);
    this.xOff = paramMD2Digest.xOff;
    arrayOfByte = paramMD2Digest.M;
    System.arraycopy(arrayOfByte, 0, this.M, 0, arrayOfByte.length);
    this.mOff = paramMD2Digest.mOff;
    arrayOfByte = paramMD2Digest.C;
    System.arraycopy(arrayOfByte, 0, this.C, 0, arrayOfByte.length);
    this.COff = paramMD2Digest.COff;
  }
  
  public Memoable copy()
  {
    return new MD2Digest(this);
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    int k = this.M.length;
    int j = this.mOff;
    int i = (byte)(k - j);
    byte[] arrayOfByte;
    for (;;)
    {
      arrayOfByte = this.M;
      if (j >= arrayOfByte.length) {
        break;
      }
      arrayOfByte[j] = i;
      j += 1;
    }
    processCheckSum(arrayOfByte);
    processBlock(this.M);
    processBlock(this.C);
    System.arraycopy(this.X, this.xOff, paramArrayOfByte, paramInt, 16);
    reset();
    return 16;
  }
  
  public String getAlgorithmName()
  {
    return "MD2";
  }
  
  public int getByteLength()
  {
    return 16;
  }
  
  public int getDigestSize()
  {
    return 16;
  }
  
  protected void processBlock(byte[] paramArrayOfByte)
  {
    int j = 0;
    while (j < 16)
    {
      byte[] arrayOfByte = this.X;
      arrayOfByte[(j + 16)] = paramArrayOfByte[j];
      arrayOfByte[(j + 32)] = ((byte)(paramArrayOfByte[j] ^ arrayOfByte[j]));
      j += 1;
    }
    int k = 0;
    j = 0;
    while (k < 18)
    {
      int m = 0;
      while (m < 48)
      {
        paramArrayOfByte = this.X;
        int n = paramArrayOfByte[m];
        int i = (byte)(S[j] ^ n);
        paramArrayOfByte[m] = i;
        j = i & 0xFF;
        m += 1;
      }
      j = (j + k) % 256;
      k += 1;
    }
  }
  
  protected void processCheckSum(byte[] paramArrayOfByte)
  {
    int j = this.C[15];
    int i = 0;
    while (i < 16)
    {
      byte[] arrayOfByte = this.C;
      int k = arrayOfByte[i];
      arrayOfByte[i] = ((byte)(S[((j ^ paramArrayOfByte[i]) & 0xFF)] ^ k));
      j = arrayOfByte[i];
      i += 1;
    }
  }
  
  public void reset()
  {
    this.xOff = 0;
    int i = 0;
    byte[] arrayOfByte;
    for (;;)
    {
      arrayOfByte = this.X;
      if (i == arrayOfByte.length) {
        break;
      }
      arrayOfByte[i] = 0;
      i += 1;
    }
    this.mOff = 0;
    i = 0;
    for (;;)
    {
      arrayOfByte = this.M;
      if (i == arrayOfByte.length) {
        break;
      }
      arrayOfByte[i] = 0;
      i += 1;
    }
    this.COff = 0;
    i = 0;
    for (;;)
    {
      arrayOfByte = this.C;
      if (i == arrayOfByte.length) {
        break;
      }
      arrayOfByte[i] = 0;
      i += 1;
    }
  }
  
  public void reset(Memoable paramMemoable)
  {
    copyIn((MD2Digest)paramMemoable);
  }
  
  public void update(byte paramByte)
  {
    byte[] arrayOfByte = this.M;
    int i = this.mOff;
    int j = i + 1;
    this.mOff = j;
    arrayOfByte[i] = paramByte;
    if (j == 16)
    {
      processCheckSum(arrayOfByte);
      processBlock(this.M);
      this.mOff = 0;
    }
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = paramInt1;
    int i;
    for (;;)
    {
      paramInt1 = j;
      i = paramInt2;
      if (this.mOff == 0) {
        break;
      }
      paramInt1 = j;
      i = paramInt2;
      if (paramInt2 <= 0) {
        break;
      }
      update(paramArrayOfByte[j]);
      j += 1;
      paramInt2 -= 1;
    }
    for (;;)
    {
      paramInt2 = paramInt1;
      j = i;
      if (i <= 16) {
        break;
      }
      System.arraycopy(paramArrayOfByte, paramInt1, this.M, 0, 16);
      processCheckSum(this.M);
      processBlock(this.M);
      i -= 16;
      paramInt1 += 16;
    }
    while (j > 0)
    {
      update(paramArrayOfByte[paramInt2]);
      paramInt2 += 1;
      j -= 1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\digests\MD2Digest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */