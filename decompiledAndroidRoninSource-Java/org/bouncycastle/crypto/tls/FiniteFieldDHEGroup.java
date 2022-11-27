package org.bouncycastle.crypto.tls;

public class FiniteFieldDHEGroup
{
  public static final short ffdhe2432 = 0;
  public static final short ffdhe3072 = 1;
  public static final short ffdhe4096 = 2;
  public static final short ffdhe6144 = 3;
  public static final short ffdhe8192 = 4;
  
  public static boolean isValid(short paramShort)
  {
    return (paramShort >= 0) && (paramShort <= 4);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\FiniteFieldDHEGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */