package dji.thirdparty.retrofit2;

import dji.thirdparty.okhttp3.RequestBody;
import dji.thirdparty.okhttp3.ResponseBody;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public abstract interface Converter<F, T>
{
  public abstract T convert(F paramF)
    throws IOException;
  
  public static abstract class Factory
  {
    public Converter<?, RequestBody> requestBodyConverter(Type paramType, Annotation[] paramArrayOfAnnotation1, Annotation[] paramArrayOfAnnotation2, Retrofit paramRetrofit)
    {
      return null;
    }
    
    public Converter<ResponseBody, ?> responseBodyConverter(Type paramType, Annotation[] paramArrayOfAnnotation, Retrofit paramRetrofit)
    {
      return null;
    }
    
    public Converter<?, String> stringConverter(Type paramType, Annotation[] paramArrayOfAnnotation, Retrofit paramRetrofit)
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\retrofit2\Converter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */