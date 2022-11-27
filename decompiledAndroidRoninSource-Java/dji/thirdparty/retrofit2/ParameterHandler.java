package dji.thirdparty.retrofit2;

import dji.thirdparty.okhttp3.Headers;
import dji.thirdparty.okhttp3.MultipartBody.Part;
import dji.thirdparty.okhttp3.RequestBody;
import java.io.IOException;
import java.util.Map;

abstract class ParameterHandler<T>
{
  abstract void apply(RequestBuilder paramRequestBuilder, T paramT)
    throws IOException;
  
  final ParameterHandler<Object> array()
  {
    new ParameterHandler()
    {
      /* Error */
      void apply(RequestBuilder arg1, Object arg2)
        throws IOException
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    };
  }
  
  final ParameterHandler<Iterable<T>> iterable()
  {
    new ParameterHandler()
    {
      /* Error */
      void apply(RequestBuilder arg1, Iterable<T> arg2)
        throws IOException
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    };
  }
  
  static final class Body<T>
    extends ParameterHandler<T>
  {
    private final Converter<T, RequestBody> converter;
    
    Body(Converter<T, RequestBody> paramConverter)
    {
      this.converter = paramConverter;
    }
    
    /* Error */
    void apply(RequestBuilder arg1, T arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  static final class Field<T>
    extends ParameterHandler<T>
  {
    private final boolean encoded;
    private final String name;
    private final Converter<T, String> valueConverter;
    
    Field(String paramString, Converter<T, String> paramConverter, boolean paramBoolean)
    {
      this.name = ((String)Utils.checkNotNull(paramString, "name == null"));
      this.valueConverter = paramConverter;
      this.encoded = paramBoolean;
    }
    
    /* Error */
    void apply(RequestBuilder arg1, T arg2)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class FieldMap<T>
    extends ParameterHandler<Map<String, T>>
  {
    private final boolean encoded;
    private final Converter<T, String> valueConverter;
    
    FieldMap(Converter<T, String> paramConverter, boolean paramBoolean)
    {
      this.valueConverter = paramConverter;
      this.encoded = paramBoolean;
    }
    
    /* Error */
    void apply(RequestBuilder arg1, Map<String, T> arg2)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class Header<T>
    extends ParameterHandler<T>
  {
    private final String name;
    private final Converter<T, String> valueConverter;
    
    Header(String paramString, Converter<T, String> paramConverter)
    {
      this.name = ((String)Utils.checkNotNull(paramString, "name == null"));
      this.valueConverter = paramConverter;
    }
    
    /* Error */
    void apply(RequestBuilder arg1, T arg2)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class Part<T>
    extends ParameterHandler<T>
  {
    private final Converter<T, RequestBody> converter;
    private final Headers headers;
    
    Part(Headers paramHeaders, Converter<T, RequestBody> paramConverter)
    {
      this.headers = paramHeaders;
      this.converter = paramConverter;
    }
    
    /* Error */
    void apply(RequestBuilder arg1, T arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  static final class PartMap<T>
    extends ParameterHandler<Map<String, T>>
  {
    private final String transferEncoding;
    private final Converter<T, RequestBody> valueConverter;
    
    PartMap(Converter<T, RequestBody> paramConverter, String paramString)
    {
      this.valueConverter = paramConverter;
      this.transferEncoding = paramString;
    }
    
    /* Error */
    void apply(RequestBuilder arg1, Map<String, T> arg2)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class Path<T>
    extends ParameterHandler<T>
  {
    private final boolean encoded;
    private final String name;
    private final Converter<T, String> valueConverter;
    
    Path(String paramString, Converter<T, String> paramConverter, boolean paramBoolean)
    {
      this.name = ((String)Utils.checkNotNull(paramString, "name == null"));
      this.valueConverter = paramConverter;
      this.encoded = paramBoolean;
    }
    
    /* Error */
    void apply(RequestBuilder arg1, T arg2)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class Query<T>
    extends ParameterHandler<T>
  {
    private final boolean encoded;
    private final String name;
    private final Converter<T, String> valueConverter;
    
    Query(String paramString, Converter<T, String> paramConverter, boolean paramBoolean)
    {
      this.name = ((String)Utils.checkNotNull(paramString, "name == null"));
      this.valueConverter = paramConverter;
      this.encoded = paramBoolean;
    }
    
    /* Error */
    void apply(RequestBuilder arg1, T arg2)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class QueryMap<T>
    extends ParameterHandler<Map<String, T>>
  {
    private final boolean encoded;
    private final Converter<T, String> valueConverter;
    
    QueryMap(Converter<T, String> paramConverter, boolean paramBoolean)
    {
      this.valueConverter = paramConverter;
      this.encoded = paramBoolean;
    }
    
    /* Error */
    void apply(RequestBuilder arg1, Map<String, T> arg2)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class RawPart
    extends ParameterHandler<MultipartBody.Part>
  {
    static final RawPart INSTANCE = new RawPart();
    
    void apply(RequestBuilder paramRequestBuilder, MultipartBody.Part paramPart)
      throws IOException
    {
      if (paramPart != null) {
        paramRequestBuilder.addPart(paramPart);
      }
    }
  }
  
  static final class RelativeUrl
    extends ParameterHandler<Object>
  {
    void apply(RequestBuilder paramRequestBuilder, Object paramObject)
    {
      paramRequestBuilder.setRelativeUrl(paramObject);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\retrofit2\ParameterHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */