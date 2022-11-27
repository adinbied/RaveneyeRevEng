package dji.thirdparty.retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

final class DefaultCallAdapterFactory
  extends CallAdapter.Factory
{
  static final CallAdapter.Factory INSTANCE = new DefaultCallAdapterFactory();
  
  public CallAdapter<?> get(Type paramType, Annotation[] paramArrayOfAnnotation, Retrofit paramRetrofit)
  {
    if (getRawType(paramType) != Call.class) {
      return null;
    }
    new CallAdapter()
    {
      public <R> Call<R> adapt(Call<R> paramAnonymousCall)
      {
        return paramAnonymousCall;
      }
      
      public Type responseType()
      {
        return this.val$responseType;
      }
    };
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\retrofit2\DefaultCallAdapterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */