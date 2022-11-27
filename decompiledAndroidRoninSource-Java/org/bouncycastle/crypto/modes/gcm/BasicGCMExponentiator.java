package org.bouncycastle.crypto.modes.gcm;

import org.bouncycastle.util.Arrays;

public class BasicGCMExponentiator
  implements GCMExponentiator
{
  private int[] x;
  
  public void exponentiateX(long paramLong, byte[] paramArrayOfByte)
  {
    int[] arrayOfInt1 = GCMUtil.oneAsInts();
    if (paramLong > 0L)
    {
      int[] arrayOfInt2 = Arrays.clone(this.x);
      long l;
      do
      {
        if ((1L & paramLong) != 0L) {
          GCMUtil.multiply(arrayOfInt1, arrayOfInt2);
        }
        GCMUtil.multiply(arrayOfInt2, arrayOfInt2);
        l = paramLong >>> 1;
        paramLong = l;
      } while (l > 0L);
    }
    GCMUtil.asBytes(arrayOfInt1, paramArrayOfByte);
  }
  
  public void init(byte[] paramArrayOfByte)
  {
    this.x = GCMUtil.asInts(paramArrayOfByte);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\modes\gcm\BasicGCMExponentiator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */