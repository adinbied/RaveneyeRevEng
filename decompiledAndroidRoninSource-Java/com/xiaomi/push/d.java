package com.xiaomi.push;

import java.io.IOException;

public class d
  extends IOException
{
  public d(String paramString)
  {
    super(paramString);
  }
  
  static d a()
  {
    return new d("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
  }
  
  static d b()
  {
    return new d("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
  
  static d c()
  {
    return new d("CodedInputStream encountered a malformed varint.");
  }
  
  static d d()
  {
    return new d("Protocol message contained an invalid tag (zero).");
  }
  
  static d e()
  {
    return new d("Protocol message end-group tag did not match expected tag.");
  }
  
  static d f()
  {
    return new d("Protocol message tag had invalid wire type.");
  }
  
  static d g()
  {
    return new d("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
  }
  
  static d h()
  {
    return new d("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */