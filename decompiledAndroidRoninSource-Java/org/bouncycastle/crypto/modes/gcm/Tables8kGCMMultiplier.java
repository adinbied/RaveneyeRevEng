package org.bouncycastle.crypto.modes.gcm;

import java.lang.reflect.Array;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

public class Tables8kGCMMultiplier
  implements GCMMultiplier
{
  private byte[] H;
  private int[][][] M;
  
  public void init(byte[] paramArrayOfByte)
  {
    if (this.M == null) {
      this.M = ((int[][][])Array.newInstance(Integer.TYPE, new int[] { 32, 16, 4 }));
    } else if (Arrays.areEqual(this.H, paramArrayOfByte)) {
      return;
    }
    this.H = Arrays.clone(paramArrayOfByte);
    GCMUtil.asInts(paramArrayOfByte, this.M[1][8]);
    int j = 4;
    int i = 4;
    while (i >= 1)
    {
      paramArrayOfByte = this.M;
      GCMUtil.multiplyP(paramArrayOfByte[1][(i + i)], paramArrayOfByte[1][i]);
      i >>= 1;
    }
    paramArrayOfByte = this.M;
    int[] arrayOfInt = paramArrayOfByte[1][1];
    int k = 0;
    GCMUtil.multiplyP(arrayOfInt, paramArrayOfByte[0][8]);
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
    do
    {
      j = 2;
      while (j < 16)
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
      if (k == 32) {
        return;
      }
      i = k;
    } while (k <= 1);
    j = 8;
    for (;;)
    {
      i = k;
      if (j <= 0) {
        break;
      }
      paramArrayOfByte = this.M;
      GCMUtil.multiplyP8(paramArrayOfByte[(k - 2)][j], paramArrayOfByte[k][j]);
      j >>= 1;
    }
  }
  
  public void multiplyH(byte[] paramArrayOfByte)
  {
    int[] arrayOfInt = new int[4];
    int i = 15;
    while (i >= 0)
    {
      Object localObject1 = this.M;
      int j = i + i;
      Object localObject2 = localObject1[j][(paramArrayOfByte[i] & 0xF)];
      arrayOfInt[0] ^= localObject2[0];
      arrayOfInt[1] ^= localObject2[1];
      arrayOfInt[2] ^= localObject2[2];
      int k = arrayOfInt[3];
      localObject2[3] ^= k;
      localObject1 = localObject1[(j + 1)][((paramArrayOfByte[i] & 0xF0) >>> 4)];
      arrayOfInt[0] ^= localObject1[0];
      arrayOfInt[1] ^= localObject1[1];
      arrayOfInt[2] ^= localObject1[2];
      arrayOfInt[3] ^= localObject1[3];
      i -= 1;
    }
    Pack.intToBigEndian(arrayOfInt, paramArrayOfByte, 0);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\modes\gcm\Tables8kGCMMultiplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */