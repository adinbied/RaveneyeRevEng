package dji.thirdparty.afinal.http;

import dji.thirdparty.afinal.http.entityhandler.StringEntityHandler;
import java.io.IOException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public class SyncRequestHandler
{
  private String charset;
  private final AbstractHttpClient client;
  private final HttpContext context;
  private final StringEntityHandler entityHandler = new StringEntityHandler();
  private int executionCount = 0;
  
  public SyncRequestHandler(AbstractHttpClient paramAbstractHttpClient, HttpContext paramHttpContext, String paramString)
  {
    this.client = paramAbstractHttpClient;
    this.context = paramHttpContext;
    this.charset = paramString;
  }
  
  private Object makeRequestWithRetries(HttpUriRequest paramHttpUriRequest)
    throws IOException
  {
    return null;
  }
  
  public Object sendRequest(HttpUriRequest... paramVarArgs)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\http\SyncRequestHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */