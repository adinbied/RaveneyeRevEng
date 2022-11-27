package org.bouncycastle.crypto.modes.gcm;

import java.lang.reflect.Array;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

public class Tables64kGCMMultiplier
  implements GCMMultiplier
{
  private byte[] H;
  private int[][][] M;
  
  public void init(byte[] paramArrayOfByte)
  {
    if (this.M == null) {
      this.M = ((int[][][])Array.newInstance(Integer.TYPE, new int[] { 16, 256, 4 }));
    } else if (Arrays.areEqual(this.H, paramArrayOfByte)) {
      return;
    }
    this.H = Arrays.clone(paramArrayOfByte);
    int[][][] arrayOfInt = this.M;
    int k = 0;
    GCMUtil.asInts(paramArrayOfByte, arrayOfInt[0]['']);
    int j = 64;
    int i;
    for (;;)
    {
      i = k;
      if (j < 1) {
        break;
      }
      paramArrayOfByte = this.M;
      GCMUtil.multiplyP(paramArrayOfByte[0][(j + j)], paramArrayOfByte[0][j]);
      j >>= 1;
    }
    j = 2;
    while (j < 256)
    {
      k = 1;
      while (k < j)
      {
        paramArrayOfByte = this.M;
        GCMUtil.xor(paramArrayOfByte[i][j], paramArrayOfByte[i][k], paramArrayOfByte[i][(j + k)]);
        k += 1;
      }
      j += j;
    }
    k = i + 1;
    if (k == 16) {
      return;
    }
    j = 128;
    for (;;)
    {
      i = k;
      if (j <= 0) {
        break;
      }
      paramArrayOfByte = this.M;
      GCMUtil.multiplyP8(paramArrayOfByte[(k - 1)][j], paramArrayOfByte[k][j]);
      j >>= 1;
    }
  }
  
  public void multiplyH(byte[] paramArrayOfByte)
  {
    int[] arrayOfInt1 = new int[4];
    int i = 15;
    while (i >= 0)
    {
      int[] arrayOfInt2 = this.M[i][(paramArrayOfByte[i] & 0xFF)];
      arrayOfInt1[0] ^= arrayOfInt2[0];
      arrayOfInt1[1] ^= arrayOfInt2[1];
      arrayOfInt1[2] ^= arrayOfInt2[2];
      int j = arrayOfInt1[3];
      arrayOfInt2[3] ^= j;
      i -= 1;
    }
    Pack.intToBigEndian(arrayOfInt1, paramArrayOfByte, 0);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\modes\gcm\Tables64kGCMMultiplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */