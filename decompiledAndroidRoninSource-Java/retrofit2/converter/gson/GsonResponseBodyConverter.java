package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

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
    Object localObject3 = this.gson.newJsonReader(paramResponseBody.charStream());
    try
    {
      Object localObject1 = this.adapter.read((JsonReader)localObject3);
      localObject3 = ((JsonReader)localObject3).peek();
      JsonToken localJsonToken = JsonToken.END_DOCUMENT;
      if (localObject3 == localJsonToken) {
        return (T)localObject1;
      }
      throw new JsonIOException("JSON document was not fully consumed.");
    }
    finally
    {
      paramResponseBody.close();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\retrofit2\converter\gson\GsonResponseBodyConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */