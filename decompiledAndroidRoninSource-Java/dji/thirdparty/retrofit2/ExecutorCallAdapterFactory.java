package dji.thirdparty.retrofit2;

import dji.thirdparty.okhttp3.Request;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;

final class ExecutorCallAdapterFactory
  extends CallAdapter.Factory
{
  final Executor callbackExecutor;
  
  ExecutorCallAdapterFactory(Executor paramExecutor)
  {
    this.callbackExecutor = paramExecutor;
  }
  
  public CallAdapter<Call<?>> get(Type paramType, Annotation[] paramArrayOfAnnotation, Retrofit paramRetrofit)
  {
    if (getRawType(paramType) != Call.class) {
      return null;
    }
    new CallAdapter()
    {
      public <R> Call<R> adapt(Call<R> paramAnonymousCall)
      {
        return null;
      }
      
      public Type responseType()
      {
        return this.val$responseType;
      }
    };
  }
  
  static final class ExecutorCallbackCall<T>
    implements Call<T>
  {
    final Executor callbackExecutor;
    final Call<T> delegate;
    
    ExecutorCallbackCall(Executor paramExecutor, Call<T> paramCall)
    {
      this.callbackExecutor = paramExecutor;
      this.delegate = paramCall;
    }
    
    public void cancel()
    {
      this.delegate.cancel();
    }
    
    public Call<T> clone()
    {
      return null;
    }
    
    /* Error */
    public void enqueue(Callback<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public Response<T> execute()
      throws IOException
    {
      return this.delegate.execute();
    }
    
    public boolean isCanceled()
    {
      return this.delegate.isCanceled();
    }
    
    public boolean isExecuted()
    {
      return this.delegate.isExecuted();
    }
    
    public Request request()
    {
      return this.delegate.request();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\retrofit2\ExecutorCallAdapterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */