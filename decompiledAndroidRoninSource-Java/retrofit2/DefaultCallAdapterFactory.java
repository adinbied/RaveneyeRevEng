package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.Request;
import okio.Timeout;

final class DefaultCallAdapterFactory
  extends CallAdapter.Factory
{
  @Nullable
  private final Executor callbackExecutor;
  
  DefaultCallAdapterFactory(@Nullable Executor paramExecutor)
  {
    this.callbackExecutor = paramExecutor;
  }
  
  @Nullable
  public CallAdapter<?, ?> get(final Type paramType, Annotation[] paramArrayOfAnnotation, Retrofit paramRetrofit)
  {
    final Object localObject = getRawType(paramType);
    paramRetrofit = null;
    if (localObject != Call.class) {
      return null;
    }
    if ((paramType instanceof ParameterizedType))
    {
      localObject = Utils.getParameterUpperBound(0, (ParameterizedType)paramType);
      if (Utils.isAnnotationPresent(paramArrayOfAnnotation, SkipCallbackExecutor.class)) {
        paramType = paramRetrofit;
      } else {
        paramType = this.callbackExecutor;
      }
      new CallAdapter()
      {
        public Call<Object> adapt(Call<Object> paramAnonymousCall)
        {
          Executor localExecutor = paramType;
          if (localExecutor == null) {
            return paramAnonymousCall;
          }
          return new DefaultCallAdapterFactory.ExecutorCallbackCall(localExecutor, paramAnonymousCall);
        }
        
        public Type responseType()
        {
          return localObject;
        }
      };
    }
    throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
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
      return new ExecutorCallbackCall(this.callbackExecutor, this.delegate.clone());
    }
    
    public void enqueue(final Callback<T> paramCallback)
    {
      Objects.requireNonNull(paramCallback, "callback == null");
      this.delegate.enqueue(new Callback()
      {
        public void onFailure(Call<T> paramAnonymousCall, Throwable paramAnonymousThrowable)
        {
          this.this$0.callbackExecutor.execute(new -..Lambda.DefaultCallAdapterFactory.ExecutorCallbackCall.1.7JZMXmGMmuA6QMd5UmiN1rIhtW0(this, paramCallback, paramAnonymousThrowable));
        }
        
        public void onResponse(Call<T> paramAnonymousCall, Response<T> paramAnonymousResponse)
        {
          this.this$0.callbackExecutor.execute(new -..Lambda.DefaultCallAdapterFactory.ExecutorCallbackCall.1.3wC8FyV4pyjrzrYL5U0mlYiviZw(this, paramCallback, paramAnonymousResponse));
        }
      });
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
    
    public Timeout timeout()
    {
      return this.delegate.timeout();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\retrofit2\DefaultCallAdapterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */