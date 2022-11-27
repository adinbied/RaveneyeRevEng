package dji.thirdparty.retrofit2;

import dji.thirdparty.okhttp3.RequestBody;
import dji.thirdparty.okhttp3.ResponseBody;
import dji.thirdparty.retrofit2.http.Streaming;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

final class BuiltInConverters
  extends Converter.Factory
{
  public Converter<?, RequestBody> requestBodyConverter(Type paramType, Annotation[] paramArrayOfAnnotation1, Annotation[] paramArrayOfAnnotation2, Retrofit paramRetrofit)
  {
    if (RequestBody.class.isAssignableFrom(Utils.getRawType(paramType))) {
      return RequestBodyConverter.INSTANCE;
    }
    return null;
  }
  
  public Converter<ResponseBody, ?> responseBodyConverter(Type paramType, Annotation[] paramArrayOfAnnotation, Retrofit paramRetrofit)
  {
    if (paramType == ResponseBody.class)
    {
      if (Utils.isAnnotationPresent(paramArrayOfAnnotation, Streaming.class)) {
        return StreamingResponseBodyConverter.INSTANCE;
      }
      return BufferingResponseBodyConverter.INSTANCE;
    }
    if (paramType == Void.class) {
      return VoidResponseBodyConverter.INSTANCE;
    }
    return null;
  }
  
  public Converter<?, String> stringConverter(Type paramType, Annotation[] paramArrayOfAnnotation, Retrofit paramRetrofit)
  {
    if (paramType == String.class) {
      return StringConverter.INSTANCE;
    }
    return null;
  }
  
  static final class BufferingResponseBodyConverter
    implements Converter<ResponseBody, ResponseBody>
  {
    static final BufferingResponseBodyConverter INSTANCE = new BufferingResponseBodyConverter();
    
    public ResponseBody convert(ResponseBody paramResponseBody)
      throws IOException
    {
      return null;
    }
  }
  
  static final class RequestBodyConverter
    implements Converter<RequestBody, RequestBody>
  {
    static final RequestBodyConverter INSTANCE = new RequestBodyConverter();
    
    public RequestBody convert(RequestBody paramRequestBody)
      throws IOException
    {
      return paramRequestBody;
    }
  }
  
  static final class StreamingResponseBodyConverter
    implements Converter<ResponseBody, ResponseBody>
  {
    static final StreamingResponseBodyConverter INSTANCE = new StreamingResponseBodyConverter();
    
    public ResponseBody convert(ResponseBody paramResponseBody)
      throws IOException
    {
      return paramResponseBody;
    }
  }
  
  static final class StringConverter
    implements Converter<String, String>
  {
    static final StringConverter INSTANCE = new StringConverter();
    
    public String convert(String paramString)
      throws IOException
    {
      return paramString;
    }
  }
  
  static final class ToStringConverter
    implements Converter<Object, String>
  {
    static final ToStringConverter INSTANCE = new ToStringConverter();
    
    public String convert(Object paramObject)
    {
      return paramObject.toString();
    }
  }
  
  static final class VoidResponseBodyConverter
    implements Converter<ResponseBody, Void>
  {
    static final VoidResponseBodyConverter INSTANCE = new VoidResponseBodyConverter();
    
    public Void convert(ResponseBody paramResponseBody)
      throws IOException
    {
      paramResponseBody.close();
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\retrofit2\BuiltInConverters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */