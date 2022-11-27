package dji.thirdparty.okhttp3;

import dji.thirdparty.okhttp3.internal.NamedRunnable;
import dji.thirdparty.okhttp3.internal.http.HttpEngine;
import java.io.IOException;

final class RealCall
  implements Call
{
  volatile boolean canceled;
  private final OkHttpClient client;
  HttpEngine engine;
  private boolean executed;
  Request originalRequest;
  
  protected RealCall(OkHttpClient paramOkHttpClient, Request paramRequest)
  {
    this.client = paramOkHttpClient;
    this.originalRequest = paramRequest;
  }
  
  private Response getResponseWithInterceptorChain(boolean paramBoolean)
    throws IOException
  {
    return null;
  }
  
  private String toLoggableString()
  {
    return null;
  }
  
  /* Error */
  public void cancel()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void enqueue(Callback paramCallback)
  {
    enqueue(paramCallback, false);
  }
  
  /* Error */
  void enqueue(Callback arg1, boolean arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public Response execute()
    throws IOException
  {
    return null;
  }
  
  Response getResponse(Request paramRequest, boolean paramBoolean)
    throws IOException
  {
    return null;
  }
  
  public boolean isCanceled()
  {
    return this.canceled;
  }
  
  public boolean isExecuted()
  {
    try
    {
      boolean bool = this.executed;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Request request()
  {
    return this.originalRequest;
  }
  
  Object tag()
  {
    return this.originalRequest.tag();
  }
  
  class ApplicationInterceptorChain
    implements Interceptor.Chain
  {
    private final boolean forWebSocket;
    private final int index;
    private final Request request;
    
    ApplicationInterceptorChain(int paramInt, Request paramRequest, boolean paramBoolean)
    {
      this.index = paramInt;
      this.request = paramRequest;
      this.forWebSocket = paramBoolean;
    }
    
    public Connection connection()
    {
      return null;
    }
    
    public Response proceed(Request paramRequest)
      throws IOException
    {
      return null;
    }
    
    public Request request()
    {
      return this.request;
    }
  }
  
  final class AsyncCall
    extends NamedRunnable
  {
    private final boolean forWebSocket;
    private final Callback responseCallback;
    
    private AsyncCall(Callback paramCallback, boolean paramBoolean)
    {
      super(new Object[] { RealCall.this.originalRequest.url().toString() });
      this.responseCallback = paramCallback;
      this.forWebSocket = paramBoolean;
    }
    
    void cancel()
    {
      RealCall.this.cancel();
    }
    
    /* Error */
    protected void execute()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    RealCall get()
    {
      return RealCall.this;
    }
    
    String host()
    {
      return null;
    }
    
    Request request()
    {
      return RealCall.this.originalRequest;
    }
    
    Object tag()
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\RealCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */