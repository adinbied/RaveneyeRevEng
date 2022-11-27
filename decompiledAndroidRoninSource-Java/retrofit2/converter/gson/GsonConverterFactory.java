package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;

public final class GsonConverterFactory
  extends Converter.Factory
{
  private final Gson gson;
  
  private GsonConverterFactory(Gson paramGson)
  {
    this.gson = paramGson;
  }
  
  public static GsonConverterFactory create()
  {
    return create(new Gson());
  }
  
  public static GsonConverterFactory create(Gson paramGson)
  {
    if (paramGson != null) {
      return new GsonConverterFactory(paramGson);
    }
    throw new NullPointerException("gson == null");
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\retrofit2\converter\gson\GsonConverterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */