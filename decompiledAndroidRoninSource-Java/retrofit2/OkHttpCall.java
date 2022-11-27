package retrofit2;

import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.Call.Factory;
import okhttp3.MediaType;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

final class OkHttpCall<T>
  implements Call<T>
{
  private final Object[] args;
  private final Call.Factory callFactory;
  private volatile boolean canceled;
  @Nullable
  private Throwable creationFailure;
  private boolean executed;
  @Nullable
  private okhttp3.Call rawCall;
  private final RequestFactory requestFactory;
  private final Converter<ResponseBody, T> responseConverter;
  
  OkHttpCall(RequestFactory paramRequestFactory, Object[] paramArrayOfObject, Call.Factory paramFactory, Converter<ResponseBody, T> paramConverter)
  {
    this.requestFactory = paramRequestFactory;
    this.args = paramArrayOfObject;
    this.callFactory = paramFactory;
    this.responseConverter = paramConverter;
  }
  
  private okhttp3.Call createRawCall()
    throws IOException
  {
    okhttp3.Call localCall = this.callFactory.newCall(this.requestFactory.create(this.args));
    if (localCall != null) {
      return localCall;
    }
    throw new NullPointerException("Call.Factory returned null.");
  }
  
  private okhttp3.Call getRawCall()
    throws IOException
  {
    Object localObject = this.rawCall;
    if (localObject != null) {
      return (okhttp3.Call)localObject;
    }
    localObject = this.creationFailure;
    if (localObject != null)
    {
      if (!(localObject instanceof IOException))
      {
        if ((localObject instanceof RuntimeException)) {
          throw ((RuntimeException)localObject);
        }
        throw ((Error)localObject);
      }
      throw ((IOException)localObject);
    }
    try
    {
      localObject = createRawCall();
      this.rawCall = ((okhttp3.Call)localObject);
      return (okhttp3.Call)localObject;
    }
    catch (IOException localIOException) {}catch (Error localError) {}catch (RuntimeException localRuntimeException) {}
    Utils.throwIfFatal(localRuntimeException);
    this.creationFailure = localRuntimeException;
    throw localRuntimeException;
  }
  
  public void cancel()
  {
    this.canceled = true;
    try
    {
      okhttp3.Call localCall = this.rawCall;
      if (localCall != null) {
        localCall.cancel();
      }
      return;
    }
    finally {}
  }
  
  public OkHttpCall<T> clone()
  {
    return new OkHttpCall(this.requestFactory, this.args, this.callFactory, this.responseConverter);
  }
  
  /* Error */
  public void enqueue(final Callback<T> paramCallback)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 113
    //   3: invokestatic 119	java/util/Objects:requireNonNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 121	retrofit2/OkHttpCall:executed	Z
    //   13: ifne +115 -> 128
    //   16: aload_0
    //   17: iconst_1
    //   18: putfield 121	retrofit2/OkHttpCall:executed	Z
    //   21: aload_0
    //   22: getfield 81	retrofit2/OkHttpCall:rawCall	Lokhttp3/Call;
    //   25: astore 4
    //   27: aload_0
    //   28: getfield 83	retrofit2/OkHttpCall:creationFailure	Ljava/lang/Throwable;
    //   31: astore 5
    //   33: aload 4
    //   35: astore_2
    //   36: aload 5
    //   38: astore_3
    //   39: aload 4
    //   41: ifnonnull +43 -> 84
    //   44: aload 4
    //   46: astore_2
    //   47: aload 5
    //   49: astore_3
    //   50: aload 5
    //   52: ifnonnull +32 -> 84
    //   55: aload_0
    //   56: invokespecial 85	retrofit2/OkHttpCall:createRawCall	()Lokhttp3/Call;
    //   59: astore_2
    //   60: aload_0
    //   61: aload_2
    //   62: putfield 81	retrofit2/OkHttpCall:rawCall	Lokhttp3/Call;
    //   65: aload 5
    //   67: astore_3
    //   68: goto +16 -> 84
    //   71: astore_3
    //   72: aload_3
    //   73: invokestatic 91	retrofit2/Utils:throwIfFatal	(Ljava/lang/Throwable;)V
    //   76: aload_0
    //   77: aload_3
    //   78: putfield 83	retrofit2/OkHttpCall:creationFailure	Ljava/lang/Throwable;
    //   81: aload 4
    //   83: astore_2
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_3
    //   87: ifnull +12 -> 99
    //   90: aload_1
    //   91: aload_0
    //   92: aload_3
    //   93: invokeinterface 127 3 0
    //   98: return
    //   99: aload_0
    //   100: getfield 94	retrofit2/OkHttpCall:canceled	Z
    //   103: ifeq +9 -> 112
    //   106: aload_2
    //   107: invokeinterface 98 1 0
    //   112: aload_2
    //   113: new 9	retrofit2/OkHttpCall$1
    //   116: dup
    //   117: aload_0
    //   118: aload_1
    //   119: invokespecial 130	retrofit2/OkHttpCall$1:<init>	(Lretrofit2/OkHttpCall;Lretrofit2/Callback;)V
    //   122: invokeinterface 133 2 0
    //   127: return
    //   128: new 135	java/lang/IllegalStateException
    //   131: dup
    //   132: ldc -119
    //   134: invokespecial 138	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   137: athrow
    //   138: astore_1
    //   139: aload_0
    //   140: monitorexit
    //   141: aload_1
    //   142: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	OkHttpCall
    //   0	143	1	paramCallback	Callback<T>
    //   35	78	2	localCall1	okhttp3.Call
    //   38	30	3	localThrowable1	Throwable
    //   71	22	3	localThrowable2	Throwable
    //   25	57	4	localCall2	okhttp3.Call
    //   31	35	5	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   55	65	71	finally
    //   9	33	138	finally
    //   72	81	138	finally
    //   84	86	138	finally
    //   128	138	138	finally
    //   139	141	138	finally
  }
  
  public Response<T> execute()
    throws IOException
  {
    try
    {
      if (!this.executed)
      {
        this.executed = true;
        okhttp3.Call localCall = getRawCall();
        if (this.canceled) {
          localCall.cancel();
        }
        return parseResponse(localCall.execute());
      }
      throw new IllegalStateException("Already executed.");
    }
    finally {}
  }
  
  public boolean isCanceled()
  {
    boolean bool2 = this.canceled;
    boolean bool1 = true;
    if (bool2) {
      return true;
    }
    for (;;)
    {
      try
      {
        if ((this.rawCall != null) && (this.rawCall.isCanceled())) {
          return bool1;
        }
      }
      finally {}
      bool1 = false;
    }
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
  
  Response<T> parseResponse(okhttp3.Response paramResponse)
    throws IOException
  {
    Object localObject = paramResponse.body();
    okhttp3.Response localResponse = paramResponse.newBuilder().body(new NoContentResponseBody(((ResponseBody)localObject).contentType(), ((ResponseBody)localObject).contentLength())).build();
    int i = localResponse.code();
    if ((i >= 200) && (i < 300))
    {
      if ((i != 204) && (i != 205))
      {
        paramResponse = new ExceptionCatchingResponseBody((ResponseBody)localObject);
        try
        {
          localObject = Response.success(this.responseConverter.convert(paramResponse), localResponse);
          return (Response<T>)localObject;
        }
        catch (RuntimeException localRuntimeException)
        {
          paramResponse.throwIfCaught();
          throw localRuntimeException;
        }
      }
      localRuntimeException.close();
      return Response.success(null, localResponse);
    }
    try
    {
      paramResponse = Response.error(Utils.buffer(localRuntimeException), localResponse);
      return paramResponse;
    }
    finally
    {
      localRuntimeException.close();
    }
  }
  
  /* Error */
  public okhttp3.Request request()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 143	retrofit2/OkHttpCall:getRawCall	()Lokhttp3/Call;
    //   6: invokeinterface 225 1 0
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: areturn
    //   16: astore_1
    //   17: goto +15 -> 32
    //   20: astore_1
    //   21: new 77	java/lang/RuntimeException
    //   24: dup
    //   25: ldc -29
    //   27: aload_1
    //   28: invokespecial 230	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   31: athrow
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	OkHttpCall
    //   11	4	1	localRequest	okhttp3.Request
    //   16	1	1	localObject	Object
    //   20	15	1	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   2	12	16	finally
    //   21	32	16	finally
    //   2	12	20	java/io/IOException
  }
  
  /* Error */
  public okio.Timeout timeout()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 143	retrofit2/OkHttpCall:getRawCall	()Lokhttp3/Call;
    //   6: invokeinterface 234 1 0
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: areturn
    //   16: astore_1
    //   17: goto +15 -> 32
    //   20: astore_1
    //   21: new 77	java/lang/RuntimeException
    //   24: dup
    //   25: ldc -20
    //   27: aload_1
    //   28: invokespecial 230	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   31: athrow
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	OkHttpCall
    //   11	4	1	localTimeout	okio.Timeout
    //   16	1	1	localObject	Object
    //   20	15	1	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   2	12	16	finally
    //   21	32	16	finally
    //   2	12	20	java/io/IOException
  }
  
  static final class ExceptionCatchingResponseBody
    extends ResponseBody
  {
    private final ResponseBody delegate;
    private final BufferedSource delegateSource;
    @Nullable
    IOException thrownException;
    
    ExceptionCatchingResponseBody(ResponseBody paramResponseBody)
    {
      this.delegate = paramResponseBody;
      this.delegateSource = Okio.buffer(new ForwardingSource(paramResponseBody.source())
      {
        public long read(Buffer paramAnonymousBuffer, long paramAnonymousLong)
          throws IOException
        {
          try
          {
            paramAnonymousLong = super.read(paramAnonymousBuffer, paramAnonymousLong);
            return paramAnonymousLong;
          }
          catch (IOException paramAnonymousBuffer)
          {
            OkHttpCall.ExceptionCatchingResponseBody.this.thrownException = paramAnonymousBuffer;
            throw paramAnonymousBuffer;
          }
        }
      });
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
      return this.delegateSource;
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
    @Nullable
    private final MediaType contentType;
    
    NoContentResponseBody(@Nullable MediaType paramMediaType, long paramLong)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\retrofit2\OkHttpCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */