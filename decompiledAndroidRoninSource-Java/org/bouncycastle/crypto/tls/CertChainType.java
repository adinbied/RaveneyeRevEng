package org.bouncycastle.crypto.tls;

public class CertChainType
{
  public static final short individual_certs = 0;
  public static final short pkipath = 1;
  
  public static boolean isValid(short paramShort)
  {
    return (paramShort >= 0) && (paramShort <= 1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\CertChainType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */