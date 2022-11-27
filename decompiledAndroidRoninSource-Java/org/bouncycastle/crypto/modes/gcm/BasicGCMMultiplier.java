package org.bouncycastle.crypto.modes.gcm;

public class BasicGCMMultiplier
  implements GCMMultiplier
{
  private int[] H;
  
  public void init(byte[] paramArrayOfByte)
  {
    this.H = GCMUtil.asInts(paramArrayOfByte);
  }
  
  public void multiplyH(byte[] paramArrayOfByte)
  {
    int[] arrayOfInt = GCMUtil.asInts(paramArrayOfByte);
    GCMUtil.multiply(arrayOfInt, this.H);
    GCMUtil.asBytes(arrayOfInt, paramArrayOfByte);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\modes\gcm\BasicGCMMultiplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */