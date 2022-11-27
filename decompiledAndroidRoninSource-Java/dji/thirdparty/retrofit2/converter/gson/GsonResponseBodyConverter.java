package dji.thirdparty.retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import dji.thirdparty.okhttp3.ResponseBody;
import dji.thirdparty.retrofit2.Converter;
import java.io.IOException;

final class GsonResponseBodyConverter<T>
  implements Converter<ResponseBody, T>
{
  private final TypeAdapter<T> adapter;
  private final Gson gson;
  
  GsonResponseBodyConverter(Gson paramGson, TypeAdapter<T> paramTypeAdapter)
  {
    this.gson = paramGson;
    this.adapter = paramTypeAdapter;
  }
  
  public T convert(ResponseBody paramResponseBody)
    throws IOException
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\retrofit2\converter\gson\GsonResponseBodyConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */