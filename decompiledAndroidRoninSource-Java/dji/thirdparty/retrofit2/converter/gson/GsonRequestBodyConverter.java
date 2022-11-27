package dji.thirdparty.retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import dji.thirdparty.okhttp3.MediaType;
import dji.thirdparty.okhttp3.RequestBody;
import dji.thirdparty.retrofit2.Converter;
import java.io.IOException;
import java.nio.charset.Charset;

final class GsonRequestBodyConverter<T>
  implements Converter<T, RequestBody>
{
  private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
  private static final Charset UTF_8 = Charset.forName("UTF-8");
  private final TypeAdapter<T> adapter;
  private final Gson gson;
  
  GsonRequestBodyConverter(Gson paramGson, TypeAdapter<T> paramTypeAdapter)
  {
    this.gson = paramGson;
    this.adapter = paramTypeAdapter;
  }
  
  public RequestBody convert(T paramT)
    throws IOException
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\retrofit2\converter\gson\GsonRequestBodyConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */