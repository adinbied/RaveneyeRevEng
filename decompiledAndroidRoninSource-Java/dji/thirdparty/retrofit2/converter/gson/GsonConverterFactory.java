package dji.thirdparty.retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dji.thirdparty.okhttp3.RequestBody;
import dji.thirdparty.okhttp3.ResponseBody;
import dji.thirdparty.retrofit2.Converter;
import dji.thirdparty.retrofit2.Converter.Factory;
import dji.thirdparty.retrofit2.Retrofit;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public final class GsonConverterFactory
  extends Converter.Factory
{
  private final Gson gson;
  
  private GsonConverterFactory(Gson paramGson)
  {
    if (paramGson != null)
    {
      this.gson = paramGson;
      return;
    }
    throw new NullPointerException("gson == null");
  }
  
  public static GsonConverterFactory create()
  {
    return create(new Gson());
  }
  
  public static GsonConverterFactory create(Gson paramGson)
  {
    return new GsonConverterFactory(paramGson);
  }
  
  public Converter<?, RequestBody> requestBodyConverter(Type paramType, Annotation[] paramArrayOfAnnotation1, Annotation[] paramArrayOfAnnotation2, Retrofit paramRetrofit)
  {
    paramType = this.gson.getAdapter(TypeToken.get(paramType));
    return new GsonRequestBodyConverter(this.gson, paramType);
  }
  
  public Converter<ResponseBody, ?> responseBodyConverter(Type paramType, Annotation[] paramArrayOfAnnotation, Retrofit paramRetrofit)
  {
    paramType = this.gson.getAdapter(TypeToken.get(paramType));
    return new GsonResponseBodyConverter(this.gson, paramType);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\retrofit2\converter\gson\GsonConverterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */