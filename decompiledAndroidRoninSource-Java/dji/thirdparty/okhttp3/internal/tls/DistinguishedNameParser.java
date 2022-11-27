package dji.thirdparty.okhttp3.internal.tls;

import javax.security.auth.x500.X500Principal;

final class DistinguishedNameParser
{
  private int beg;
  private char[] chars;
  private int cur;
  private final String dn;
  private int end;
  private final int length;
  private int pos;
  
  public DistinguishedNameParser(X500Principal paramX500Principal)
  {
    paramX500Principal = paramX500Principal.getName("RFC2253");
    this.dn = paramX500Principal;
    this.length = paramX500Principal.length();
  }
  
  private String escapedAV()
  {
    return null;
  }
  
  private int getByte(int paramInt)
  {
    return 0;
  }
  
  private char getEscaped()
  {
    return '\000';
  }
  
  private char getUTF8()
  {
    return '\000';
  }
  
  private String hexAV()
  {
    return null;
  }
  
  private String nextAT()
  {
    return null;
  }
  
  private String quotedAV()
  {
    return null;
  }
  
  public String findMostSpecific(String paramString)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\tls\DistinguishedNameParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */