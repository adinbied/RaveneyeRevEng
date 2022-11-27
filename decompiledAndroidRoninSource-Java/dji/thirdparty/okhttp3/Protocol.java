package dji.thirdparty.okhttp3;

import java.io.IOException;

public enum Protocol
{
  private final String protocol;
  
  static
  {
    Protocol localProtocol = new Protocol("HTTP_2", 3, "h2");
    HTTP_2 = localProtocol;
    $VALUES = new Protocol[] { HTTP_1_0, HTTP_1_1, SPDY_3, localProtocol };
  }
  
  private Protocol(String paramString)
  {
    this.protocol = paramString;
  }
  
  public static Protocol get(String paramString)
    throws IOException
  {
    if (paramString.equals(HTTP_1_0.protocol)) {
      return HTTP_1_0;
    }
    if (paramString.equals(HTTP_1_1.protocol)) {
      return HTTP_1_1;
    }
    if (paramString.equals(HTTP_2.protocol)) {
      return HTTP_2;
    }
    if (paramString.equals(SPDY_3.protocol)) {
      return SPDY_3;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unexpected protocol: ");
    localStringBuilder.append(paramString);
    throw new IOException(localStringBuilder.toString());
  }
  
  public String toString()
  {
    return this.protocol;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\Protocol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */