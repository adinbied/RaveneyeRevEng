package dji.thirdparty.okhttp3;

public enum TlsVersion
{
  final String javaName;
  
  static
  {
    TLS_1_1 = new TlsVersion("TLS_1_1", 1, "TLSv1.1");
    TLS_1_0 = new TlsVersion("TLS_1_0", 2, "TLSv1");
    TlsVersion localTlsVersion = new TlsVersion("SSL_3_0", 3, "SSLv3");
    SSL_3_0 = localTlsVersion;
    $VALUES = new TlsVersion[] { TLS_1_2, TLS_1_1, TLS_1_0, localTlsVersion };
  }
  
  private TlsVersion(String paramString)
  {
    this.javaName = paramString;
  }
  
  public static TlsVersion forJavaName(String paramString)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 79923350: 
      if (paramString.equals("TLSv1")) {
        i = 2;
      }
      break;
    case 79201641: 
      if (paramString.equals("SSLv3")) {
        i = 3;
      }
      break;
    case -503070502: 
      if (paramString.equals("TLSv1.2")) {
        i = 0;
      }
      break;
    case -503070503: 
      if (paramString.equals("TLSv1.1")) {
        i = 1;
      }
      break;
    }
    int i = -1;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            return SSL_3_0;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unexpected TLS version: ");
          localStringBuilder.append(paramString);
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
        return TLS_1_0;
      }
      return TLS_1_1;
    }
    return TLS_1_2;
  }
  
  public String javaName()
  {
    return this.javaName;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\TlsVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */