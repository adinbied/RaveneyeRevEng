package dji.thirdparty.retrofit2;

import dji.thirdparty.okhttp3.MediaType;
import dji.thirdparty.okhttp3.Request;
import dji.thirdparty.okhttp3.ResponseBody;
import dji.thirdparty.okio.Buffer;
import dji.thirdparty.okio.BufferedSource;
import dji.thirdparty.okio.ForwardingSource;
import dji.thirdparty.okio.Source;
import java.io.IOException;

final class OkHttpCall<T>
  implements Call<T>
{
  private final Object[] args;
  private volatile boolean canceled;
  private Throwable creationFailure;
  private boolean executed;
  private dji.thirdparty.okhttp3.Call rawCall;
  private final ServiceMethod<T> serviceMethod;
  
  OkHttpCall(ServiceMethod<T> paramServiceMethod, Object[] paramArrayOfObject)
  {
    this.serviceMethod = paramServiceMethod;
    this.args = paramArrayOfObject;
  }
  
  private dji.thirdparty.okhttp3.Call createRawCall()
    throws IOException
  {
    return null;
  }
  
  /* Error */
  public void cancel()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public OkHttpCall<T> clone()
  {
    return null;
  }
  
  /* Error */
  public void enqueue(Callback<T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public Response<T> execute()
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
  
  Response<T> parseResponse(dji.thirdparty.okhttp3.Response paramResponse)
    throws IOException
  {
    return null;
  }
  
  public Request request()
  {
    return null;
  }
  
  static final class ExceptionCatchingRequestBody
    extends ResponseBody
  {
    private final ResponseBody delegate;
    IOException thrownException;
    
    ExceptionCatchingRequestBody(ResponseBody paramResponseBody)
    {
      this.delegate = paramResponseBody;
    }
    
    public void close()
    {
      this.delegate.close();
    }
    
    public long contentLength()
    {
      return this.delegate.contentLength();
    }
    
    public MediaType contentType()
    {
      return this.delegate.contentType();
    }
    
    public BufferedSource source()
    {
      return null;
    }
    
    void throwIfCaught()
      throws IOException
    {
      IOException localIOException = this.thrownException;
      if (localIOException == null) {
        return;
      }
      throw localIOException;
    }
  }
  
  static final class NoContentResponseBody
    extends ResponseBody
  {
    private final long contentLength;
    private final MediaType contentType;
    
    NoContentResponseBody(MediaType paramMediaType, long paramLong)
    {
      this.contentType = paramMediaType;
      this.contentLength = paramLong;
    }
    
    public long contentLength()
    {
      return this.contentLength;
    }
    
    public MediaType contentType()
    {
      return this.contentType;
    }
    
    public BufferedSource source()
    {
      throw new IllegalStateException("Cannot read raw response body of a converted body.");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\retrofit2\OkHttpCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */