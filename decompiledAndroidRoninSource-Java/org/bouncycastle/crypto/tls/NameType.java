package org.bouncycastle.crypto.tls;

public class NameType
{
  public static final short host_name = 0;
  
  public static boolean isValid(short paramShort)
  {
    return paramShort == 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\NameType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */