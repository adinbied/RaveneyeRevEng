package org.bouncycastle.est;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Map;

public class ESTRequest
{
  final byte[] data;
  final ESTClient estClient;
  HttpUtil.Headers headers = new HttpUtil.Headers();
  final ESTHijacker hijacker;
  final ESTSourceConnectionListener listener;
  final String method;
  final URL url;
  
  ESTRequest(String paramString, URL paramURL, byte[] paramArrayOfByte, ESTHijacker paramESTHijacker, ESTSourceConnectionListener paramESTSourceConnectionListener, HttpUtil.Headers paramHeaders, ESTClient paramESTClient)
  {
    this.method = paramString;
    this.url = paramURL;
    this.data = paramArrayOfByte;
    this.hijacker = paramESTHijacker;
    this.listener = paramESTSourceConnectionListener;
    this.headers = paramHeaders;
    this.estClient = paramESTClient;
  }
  
  public ESTClient getClient()
  {
    return this.estClient;
  }
  
  public Map<String, String[]> getHeaders()
  {
    return (Map)this.headers.clone();
  }
  
  public ESTHijacker getHijacker()
  {
    return this.hijacker;
  }
  
  public ESTSourceConnectionListener getListener()
  {
    return this.listener;
  }
  
  public String getMethod()
  {
    return this.method;
  }
  
  public URL getURL()
  {
    return this.url;
  }
  
  public void writeData(OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = this.data;
    if (arrayOfByte != null) {
      paramOutputStream.write(arrayOfByte);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\est\ESTRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */