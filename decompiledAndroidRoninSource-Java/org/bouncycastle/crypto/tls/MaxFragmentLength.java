package org.bouncycastle.crypto.tls;

public class MaxFragmentLength
{
  public static final short pow2_10 = 2;
  public static final short pow2_11 = 3;
  public static final short pow2_12 = 4;
  public static final short pow2_9 = 1;
  
  public static boolean isValid(short paramShort)
  {
    return (paramShort >= 1) && (paramShort <= 4);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\MaxFragmentLength.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */