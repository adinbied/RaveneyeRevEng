package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import javax.annotation.Nullable;
import okhttp3.ResponseBody;

final class OptionalConverterFactory
  extends Converter.Factory
{
  static final Converter.Factory INSTANCE = new OptionalConverterFactory();
  
  @Nullable
  public Converter<ResponseBody, ?> responseBodyConverter(Type paramType, Annotation[] paramArrayOfAnnotation, Retrofit paramRetrofit)
  {
    if (getRawType(paramType) != Optional.class) {
      return null;
    }
    return new OptionalConverter(paramRetrofit.responseBodyConverter(getParameterUpperBound(0, (ParameterizedType)paramType), paramArrayOfAnnotation));
  }
  
  static final class OptionalConverter<T>
    implements Converter<ResponseBody, Optional<T>>
  {
    final Converter<ResponseBody, T> delegate;
    
    OptionalConverter(Converter<ResponseBody, T> paramConverter)
    {
      this.delegate = paramConverter;
    }
    
    public Optional<T> convert(ResponseBody paramResponseBody)
      throws IOException
    {
      return Optional.ofNullable(this.delegate.convert(paramResponseBody));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\retrofit2\OptionalConverterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */