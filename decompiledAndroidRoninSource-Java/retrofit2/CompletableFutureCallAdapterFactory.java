package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;

final class CompletableFutureCallAdapterFactory
  extends CallAdapter.Factory
{
  static final CallAdapter.Factory INSTANCE = new CompletableFutureCallAdapterFactory();
  
  @Nullable
  public CallAdapter<?, ?> get(Type paramType, Annotation[] paramArrayOfAnnotation, Retrofit paramRetrofit)
  {
    if (getRawType(paramType) != CompletableFuture.class) {
      return null;
    }
    if ((paramType instanceof ParameterizedType))
    {
      paramType = getParameterUpperBound(0, (ParameterizedType)paramType);
      if (getRawType(paramType) != Response.class) {
        return new BodyCallAdapter(paramType);
      }
      if ((paramType instanceof ParameterizedType)) {
        return new ResponseCallAdapter(getParameterUpperBound(0, (ParameterizedType)paramType));
      }
      throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
    }
    throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
  }
  
  private static final class BodyCallAdapter<R>
    implements CallAdapter<R, CompletableFuture<R>>
  {
    private final Type responseType;
    
    BodyCallAdapter(Type paramType)
    {
      this.responseType = paramType;
    }
    
    public CompletableFuture<R> adapt(Call<R> paramCall)
    {
      CompletableFutureCallAdapterFactory.CallCancelCompletableFuture localCallCancelCompletableFuture = new CompletableFutureCallAdapterFactory.CallCancelCompletableFuture(paramCall);
      paramCall.enqueue(new BodyCallback(localCallCancelCompletableFuture));
      return localCallCancelCompletableFuture;
    }
    
    public Type responseType()
    {
      return this.responseType;
    }
    
    private class BodyCallback
      implements Callback<R>
    {
      private final CompletableFuture<R> future;
      
      public BodyCallback()
      {
        CompletableFuture localCompletableFuture;
        this.future = localCompletableFuture;
      }
      
      public void onFailure(Call<R> paramCall, Throwable paramThrowable)
      {
        this.future.completeExceptionally(paramThrowable);
      }
      
      public void onResponse(Call<R> paramCall, Response<R> paramResponse)
      {
        if (paramResponse.isSuccessful())
        {
          this.future.complete(paramResponse.body());
          return;
        }
        this.future.completeExceptionally(new HttpException(paramResponse));
      }
    }
  }
  
  private static final class CallCancelCompletableFuture<T>
    extends CompletableFuture<T>
  {
    private final Call<?> call;
    
    CallCancelCompletableFuture(Call<?> paramCall)
    {
      this.call = paramCall;
    }
    
    public boolean cancel(boolean paramBoolean)
    {
      if (paramBoolean) {
        this.call.cancel();
      }
      return super.cancel(paramBoolean);
    }
  }
  
  private static final class ResponseCallAdapter<R>
    implements CallAdapter<R, CompletableFuture<Response<R>>>
  {
    private final Type responseType;
    
    ResponseCallAdapter(Type paramType)
    {
      this.responseType = paramType;
    }
    
    public CompletableFuture<Response<R>> adapt(Call<R> paramCall)
    {
      CompletableFutureCallAdapterFactory.CallCancelCompletableFuture localCallCancelCompletableFuture = new CompletableFutureCallAdapterFactory.CallCancelCompletableFuture(paramCall);
      paramCall.enqueue(new ResponseCallback(localCallCancelCompletableFuture));
      return localCallCancelCompletableFuture;
    }
    
    public Type responseType()
    {
      return this.responseType;
    }
    
    private class ResponseCallback
      implements Callback<R>
    {
      private final CompletableFuture<Response<R>> future;
      
      public ResponseCallback()
      {
        CompletableFuture localCompletableFuture;
        this.future = localCompletableFuture;
      }
      
      public void onFailure(Call<R> paramCall, Throwable paramThrowable)
      {
        this.future.completeExceptionally(paramThrowable);
      }
      
      public void onResponse(Call<R> paramCall, Response<R> paramResponse)
      {
        this.future.complete(paramResponse);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\retrofit2\CompletableFutureCallAdapterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */