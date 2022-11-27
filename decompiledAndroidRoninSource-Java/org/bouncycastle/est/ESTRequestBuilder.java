package org.bouncycastle.est;

import java.net.URL;
import org.bouncycastle.util.Arrays;

public class ESTRequestBuilder
{
  ESTClient client;
  private byte[] data;
  private HttpUtil.Headers headers;
  ESTHijacker hijacker;
  ESTSourceConnectionListener listener;
  private final String method;
  private URL url;
  
  public ESTRequestBuilder(String paramString, URL paramURL)
  {
    this.method = paramString;
    this.url = paramURL;
    this.headers = new HttpUtil.Headers();
  }
  
  public ESTRequestBuilder(ESTRequest paramESTRequest)
  {
    this.method = paramESTRequest.method;
    this.url = paramESTRequest.url;
    this.listener = paramESTRequest.listener;
    this.data = paramESTRequest.data;
    this.hijacker = paramESTRequest.hijacker;
    this.headers = ((HttpUtil.Headers)paramESTRequest.headers.clone());
    this.client = paramESTRequest.getClient();
  }
  
  public ESTRequestBuilder addHeader(String paramString1, String paramString2)
  {
    this.headers.add(paramString1, paramString2);
    return this;
  }
  
  public ESTRequest build()
  {
    return new ESTRequest(this.method, this.url, this.data, this.hijacker, this.listener, this.headers, this.client);
  }
  
  public ESTRequestBuilder setHeader(String paramString1, String paramString2)
  {
    this.headers.set(paramString1, paramString2);
    return this;
  }
  
  public ESTRequestBuilder withClient(ESTClient paramESTClient)
  {
    this.client = paramESTClient;
    return this;
  }
  
  public ESTRequestBuilder withConnectionListener(ESTSourceConnectionListener paramESTSourceConnectionListener)
  {
    this.listener = paramESTSourceConnectionListener;
    return this;
  }
  
  public ESTRequestBuilder withData(byte[] paramArrayOfByte)
  {
    this.data = Arrays.clone(paramArrayOfByte);
    return this;
  }
  
  public ESTRequestBuilder withHijacker(ESTHijacker paramESTHijacker)
  {
    this.hijacker = paramESTHijacker;
    return this;
  }
  
  public ESTRequestBuilder withURL(URL paramURL)
  {
    this.url = paramURL;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\est\ESTRequestBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */