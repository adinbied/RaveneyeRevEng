package dji.thirdparty.okhttp3.internal.framed;

public enum HeadersMode
{
  static
  {
    SPDY_REPLY = new HeadersMode("SPDY_REPLY", 1);
    SPDY_HEADERS = new HeadersMode("SPDY_HEADERS", 2);
    HeadersMode localHeadersMode = new HeadersMode("HTTP_20_HEADERS", 3);
    HTTP_20_HEADERS = localHeadersMode;
    $VALUES = new HeadersMode[] { SPDY_SYN_STREAM, SPDY_REPLY, SPDY_HEADERS, localHeadersMode };
  }
  
  private HeadersMode() {}
  
  public boolean failIfHeadersAbsent()
  {
    return this == SPDY_HEADERS;
  }
  
  public boolean failIfHeadersPresent()
  {
    return this == SPDY_REPLY;
  }
  
  public boolean failIfStreamAbsent()
  {
    return (this == SPDY_REPLY) || (this == SPDY_HEADERS);
  }
  
  public boolean failIfStreamPresent()
  {
    return this == SPDY_SYN_STREAM;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\framed\HeadersMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */