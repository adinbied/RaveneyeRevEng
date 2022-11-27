package retrofit2;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody;

abstract class ParameterHandler<T>
{
  abstract void apply(RequestBuilder paramRequestBuilder, @Nullable T paramT)
    throws IOException;
  
  final ParameterHandler<Object> array()
  {
    new ParameterHandler()
    {
      void apply(RequestBuilder paramAnonymousRequestBuilder, @Nullable Object paramAnonymousObject)
        throws IOException
      {
        if (paramAnonymousObject == null) {
          return;
        }
        int i = 0;
        int j = Array.getLength(paramAnonymousObject);
        while (i < j)
        {
          ParameterHandler.this.apply(paramAnonymousRequestBuilder, Array.get(paramAnonymousObject, i));
          i += 1;
        }
      }
    };
  }
  
  final ParameterHandler<Iterable<T>> iterable()
  {
    new ParameterHandler()
    {
      void apply(RequestBuilder paramAnonymousRequestBuilder, @Nullable Iterable<T> paramAnonymousIterable)
        throws IOException
      {
        if (paramAnonymousIterable == null) {
          return;
        }
        paramAnonymousIterable = paramAnonymousIterable.iterator();
        while (paramAnonymousIterable.hasNext())
        {
          Object localObject = paramAnonymousIterable.next();
          ParameterHandler.this.apply(paramAnonymousRequestBuilder, localObject);
        }
      }
    };
  }
  
  static final class Body<T>
    extends ParameterHandler<T>
  {
    private final Converter<T, RequestBody> converter;
    private final Method method;
    private final int p;
    
    Body(Method paramMethod, int paramInt, Converter<T, RequestBody> paramConverter)
    {
      this.method = paramMethod;
      this.p = paramInt;
      this.converter = paramConverter;
    }
    
    void apply(RequestBuilder paramRequestBuilder, @Nullable T paramT)
    {
      if (paramT != null) {
        try
        {
          localObject = (RequestBody)this.converter.convert(paramT);
          paramRequestBuilder.setBody((RequestBody)localObject);
          return;
        }
        catch (IOException paramRequestBuilder)
        {
          Object localObject = this.method;
          int i = this.p;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unable to convert ");
          localStringBuilder.append(paramT);
          localStringBuilder.append(" to RequestBody");
          throw Utils.parameterError((Method)localObject, paramRequestBuilder, i, localStringBuilder.toString(), new Object[0]);
        }
      }
      throw Utils.parameterError(this.method, this.p, "Body parameter value must not be null.", new Object[0]);
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
      this.name = ((String)Objects.requireNonNull(paramString, "name == null"));
      this.valueConverter = paramConverter;
      this.encoded = paramBoolean;
    }
    
    void apply(RequestBuilder paramRequestBuilder, @Nullable T paramT)
      throws IOException
    {
      if (paramT == null) {
        return;
      }
      paramT = (String)this.valueConverter.convert(paramT);
      if (paramT == null) {
        return;
      }
      paramRequestBuilder.addFormField(this.name, paramT, this.encoded);
    }
  }
  
  static final class FieldMap<T>
    extends ParameterHandler<Map<String, T>>
  {
    private final boolean encoded;
    private final Method method;
    private final int p;
    private final Converter<T, String> valueConverter;
    
    FieldMap(Method paramMethod, int paramInt, Converter<T, String> paramConverter, boolean paramBoolean)
    {
      this.method = paramMethod;
      this.p = paramInt;
      this.valueConverter = paramConverter;
      this.encoded = paramBoolean;
    }
    
    void apply(RequestBuilder paramRequestBuilder, @Nullable Map<String, T> paramMap)
      throws IOException
    {
      if (paramMap != null)
      {
        Object localObject2 = paramMap.entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject1 = (Map.Entry)((Iterator)localObject2).next();
          paramMap = (String)((Map.Entry)localObject1).getKey();
          if (paramMap != null)
          {
            localObject1 = ((Map.Entry)localObject1).getValue();
            int i;
            if (localObject1 != null)
            {
              String str = (String)this.valueConverter.convert(localObject1);
              if (str != null)
              {
                paramRequestBuilder.addFormField(paramMap, str, this.encoded);
              }
              else
              {
                paramRequestBuilder = this.method;
                i = this.p;
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("Field map value '");
                ((StringBuilder)localObject2).append(localObject1);
                ((StringBuilder)localObject2).append("' converted to null by ");
                ((StringBuilder)localObject2).append(this.valueConverter.getClass().getName());
                ((StringBuilder)localObject2).append(" for key '");
                ((StringBuilder)localObject2).append(paramMap);
                ((StringBuilder)localObject2).append("'.");
                throw Utils.parameterError(paramRequestBuilder, i, ((StringBuilder)localObject2).toString(), new Object[0]);
              }
            }
            else
            {
              paramRequestBuilder = this.method;
              i = this.p;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Field map contained null value for key '");
              ((StringBuilder)localObject1).append(paramMap);
              ((StringBuilder)localObject1).append("'.");
              throw Utils.parameterError(paramRequestBuilder, i, ((StringBuilder)localObject1).toString(), new Object[0]);
            }
          }
          else
          {
            throw Utils.parameterError(this.method, this.p, "Field map contained null key.", new Object[0]);
          }
        }
        return;
      }
      throw Utils.parameterError(this.method, this.p, "Field map was null.", new Object[0]);
    }
  }
  
  static final class Header<T>
    extends ParameterHandler<T>
  {
    private final String name;
    private final Converter<T, String> valueConverter;
    
    Header(String paramString, Converter<T, String> paramConverter)
    {
      this.name = ((String)Objects.requireNonNull(paramString, "name == null"));
      this.valueConverter = paramConverter;
    }
    
    void apply(RequestBuilder paramRequestBuilder, @Nullable T paramT)
      throws IOException
    {
      if (paramT == null) {
        return;
      }
      paramT = (String)this.valueConverter.convert(paramT);
      if (paramT == null) {
        return;
      }
      paramRequestBuilder.addHeader(this.name, paramT);
    }
  }
  
  static final class HeaderMap<T>
    extends ParameterHandler<Map<String, T>>
  {
    private final Method method;
    private final int p;
    private final Converter<T, String> valueConverter;
    
    HeaderMap(Method paramMethod, int paramInt, Converter<T, String> paramConverter)
    {
      this.method = paramMethod;
      this.p = paramInt;
      this.valueConverter = paramConverter;
    }
    
    void apply(RequestBuilder paramRequestBuilder, @Nullable Map<String, T> paramMap)
      throws IOException
    {
      if (paramMap != null)
      {
        Object localObject1 = paramMap.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
          paramMap = (String)((Map.Entry)localObject2).getKey();
          if (paramMap != null)
          {
            localObject2 = ((Map.Entry)localObject2).getValue();
            if (localObject2 != null)
            {
              paramRequestBuilder.addHeader(paramMap, (String)this.valueConverter.convert(localObject2));
            }
            else
            {
              paramRequestBuilder = this.method;
              int i = this.p;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Header map contained null value for key '");
              ((StringBuilder)localObject1).append(paramMap);
              ((StringBuilder)localObject1).append("'.");
              throw Utils.parameterError(paramRequestBuilder, i, ((StringBuilder)localObject1).toString(), new Object[0]);
            }
          }
          else
          {
            throw Utils.parameterError(this.method, this.p, "Header map contained null key.", new Object[0]);
          }
        }
        return;
      }
      throw Utils.parameterError(this.method, this.p, "Header map was null.", new Object[0]);
    }
  }
  
  static final class Headers
    extends ParameterHandler<Headers>
  {
    private final Method method;
    private final int p;
    
    Headers(Method paramMethod, int paramInt)
    {
      this.method = paramMethod;
      this.p = paramInt;
    }
    
    void apply(RequestBuilder paramRequestBuilder, @Nullable Headers paramHeaders)
    {
      if (paramHeaders != null)
      {
        paramRequestBuilder.addHeaders(paramHeaders);
        return;
      }
      throw Utils.parameterError(this.method, this.p, "Headers parameter must not be null.", new Object[0]);
    }
  }
  
  static final class Part<T>
    extends ParameterHandler<T>
  {
    private final Converter<T, RequestBody> converter;
    private final Headers headers;
    private final Method method;
    private final int p;
    
    Part(Method paramMethod, int paramInt, Headers paramHeaders, Converter<T, RequestBody> paramConverter)
    {
      this.method = paramMethod;
      this.p = paramInt;
      this.headers = paramHeaders;
      this.converter = paramConverter;
    }
    
    void apply(RequestBuilder paramRequestBuilder, @Nullable T paramT)
    {
      if (paramT == null) {
        return;
      }
      try
      {
        localObject = (RequestBody)this.converter.convert(paramT);
        paramRequestBuilder.addPart(this.headers, (RequestBody)localObject);
        return;
      }
      catch (IOException paramRequestBuilder)
      {
        Object localObject = this.method;
        int i = this.p;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unable to convert ");
        localStringBuilder.append(paramT);
        localStringBuilder.append(" to RequestBody");
        throw Utils.parameterError((Method)localObject, i, localStringBuilder.toString(), new Object[] { paramRequestBuilder });
      }
    }
  }
  
  static final class PartMap<T>
    extends ParameterHandler<Map<String, T>>
  {
    private final Method method;
    private final int p;
    private final String transferEncoding;
    private final Converter<T, RequestBody> valueConverter;
    
    PartMap(Method paramMethod, int paramInt, Converter<T, RequestBody> paramConverter, String paramString)
    {
      this.method = paramMethod;
      this.p = paramInt;
      this.valueConverter = paramConverter;
      this.transferEncoding = paramString;
    }
    
    void apply(RequestBuilder paramRequestBuilder, @Nullable Map<String, T> paramMap)
      throws IOException
    {
      if (paramMap != null)
      {
        Object localObject1 = paramMap.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
          paramMap = (String)((Map.Entry)localObject2).getKey();
          if (paramMap != null)
          {
            localObject2 = ((Map.Entry)localObject2).getValue();
            if (localObject2 != null)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("form-data; name=\"");
              localStringBuilder.append(paramMap);
              localStringBuilder.append("\"");
              paramRequestBuilder.addPart(Headers.of(new String[] { "Content-Disposition", localStringBuilder.toString(), "Content-Transfer-Encoding", this.transferEncoding }), (RequestBody)this.valueConverter.convert(localObject2));
            }
            else
            {
              paramRequestBuilder = this.method;
              int i = this.p;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Part map contained null value for key '");
              ((StringBuilder)localObject1).append(paramMap);
              ((StringBuilder)localObject1).append("'.");
              throw Utils.parameterError(paramRequestBuilder, i, ((StringBuilder)localObject1).toString(), new Object[0]);
            }
          }
          else
          {
            throw Utils.parameterError(this.method, this.p, "Part map contained null key.", new Object[0]);
          }
        }
        return;
      }
      throw Utils.parameterError(this.method, this.p, "Part map was null.", new Object[0]);
    }
  }
  
  static final class Path<T>
    extends ParameterHandler<T>
  {
    private final boolean encoded;
    private final Method method;
    private final String name;
    private final int p;
    private final Converter<T, String> valueConverter;
    
    Path(Method paramMethod, int paramInt, String paramString, Converter<T, String> paramConverter, boolean paramBoolean)
    {
      this.method = paramMethod;
      this.p = paramInt;
      this.name = ((String)Objects.requireNonNull(paramString, "name == null"));
      this.valueConverter = paramConverter;
      this.encoded = paramBoolean;
    }
    
    void apply(RequestBuilder paramRequestBuilder, @Nullable T paramT)
      throws IOException
    {
      if (paramT != null)
      {
        paramRequestBuilder.addPathParam(this.name, (String)this.valueConverter.convert(paramT), this.encoded);
        return;
      }
      paramRequestBuilder = this.method;
      int i = this.p;
      paramT = new StringBuilder();
      paramT.append("Path parameter \"");
      paramT.append(this.name);
      paramT.append("\" value must not be null.");
      throw Utils.parameterError(paramRequestBuilder, i, paramT.toString(), new Object[0]);
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
      this.name = ((String)Objects.requireNonNull(paramString, "name == null"));
      this.valueConverter = paramConverter;
      this.encoded = paramBoolean;
    }
    
    void apply(RequestBuilder paramRequestBuilder, @Nullable T paramT)
      throws IOException
    {
      if (paramT == null) {
        return;
      }
      paramT = (String)this.valueConverter.convert(paramT);
      if (paramT == null) {
        return;
      }
      paramRequestBuilder.addQueryParam(this.name, paramT, this.encoded);
    }
  }
  
  static final class QueryMap<T>
    extends ParameterHandler<Map<String, T>>
  {
    private final boolean encoded;
    private final Method method;
    private final int p;
    private final Converter<T, String> valueConverter;
    
    QueryMap(Method paramMethod, int paramInt, Converter<T, String> paramConverter, boolean paramBoolean)
    {
      this.method = paramMethod;
      this.p = paramInt;
      this.valueConverter = paramConverter;
      this.encoded = paramBoolean;
    }
    
    void apply(RequestBuilder paramRequestBuilder, @Nullable Map<String, T> paramMap)
      throws IOException
    {
      if (paramMap != null)
      {
        Object localObject2 = paramMap.entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject1 = (Map.Entry)((Iterator)localObject2).next();
          paramMap = (String)((Map.Entry)localObject1).getKey();
          if (paramMap != null)
          {
            localObject1 = ((Map.Entry)localObject1).getValue();
            int i;
            if (localObject1 != null)
            {
              String str = (String)this.valueConverter.convert(localObject1);
              if (str != null)
              {
                paramRequestBuilder.addQueryParam(paramMap, str, this.encoded);
              }
              else
              {
                paramRequestBuilder = this.method;
                i = this.p;
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("Query map value '");
                ((StringBuilder)localObject2).append(localObject1);
                ((StringBuilder)localObject2).append("' converted to null by ");
                ((StringBuilder)localObject2).append(this.valueConverter.getClass().getName());
                ((StringBuilder)localObject2).append(" for key '");
                ((StringBuilder)localObject2).append(paramMap);
                ((StringBuilder)localObject2).append("'.");
                throw Utils.parameterError(paramRequestBuilder, i, ((StringBuilder)localObject2).toString(), new Object[0]);
              }
            }
            else
            {
              paramRequestBuilder = this.method;
              i = this.p;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Query map contained null value for key '");
              ((StringBuilder)localObject1).append(paramMap);
              ((StringBuilder)localObject1).append("'.");
              throw Utils.parameterError(paramRequestBuilder, i, ((StringBuilder)localObject1).toString(), new Object[0]);
            }
          }
          else
          {
            throw Utils.parameterError(this.method, this.p, "Query map contained null key.", new Object[0]);
          }
        }
        return;
      }
      throw Utils.parameterError(this.method, this.p, "Query map was null", new Object[0]);
    }
  }
  
  static final class QueryName<T>
    extends ParameterHandler<T>
  {
    private final boolean encoded;
    private final Converter<T, String> nameConverter;
    
    QueryName(Converter<T, String> paramConverter, boolean paramBoolean)
    {
      this.nameConverter = paramConverter;
      this.encoded = paramBoolean;
    }
    
    void apply(RequestBuilder paramRequestBuilder, @Nullable T paramT)
      throws IOException
    {
      if (paramT == null) {
        return;
      }
      paramRequestBuilder.addQueryParam((String)this.nameConverter.convert(paramT), null, this.encoded);
    }
  }
  
  static final class RawPart
    extends ParameterHandler<MultipartBody.Part>
  {
    static final RawPart INSTANCE = new RawPart();
    
    void apply(RequestBuilder paramRequestBuilder, @Nullable MultipartBody.Part paramPart)
    {
      if (paramPart != null) {
        paramRequestBuilder.addPart(paramPart);
      }
    }
  }
  
  static final class RelativeUrl
    extends ParameterHandler<Object>
  {
    private final Method method;
    private final int p;
    
    RelativeUrl(Method paramMethod, int paramInt)
    {
      this.method = paramMethod;
      this.p = paramInt;
    }
    
    void apply(RequestBuilder paramRequestBuilder, @Nullable Object paramObject)
    {
      if (paramObject != null)
      {
        paramRequestBuilder.setRelativeUrl(paramObject);
        return;
      }
      throw Utils.parameterError(this.method, this.p, "@Url parameter is null.", new Object[0]);
    }
  }
  
  static final class Tag<T>
    extends ParameterHandler<T>
  {
    final Class<T> cls;
    
    Tag(Class<T> paramClass)
    {
      this.cls = paramClass;
    }
    
    void apply(RequestBuilder paramRequestBuilder, @Nullable T paramT)
    {
      paramRequestBuilder.addTag(this.cls, paramT);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\retrofit2\ParameterHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */