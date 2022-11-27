package okhttp3;

import java.net.URL;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;

@Metadata(bv={1, 0, 3}, d1={"\000N\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020$\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\013\n\002\b\013\n\002\020 \n\002\b\002\n\002\030\002\n\002\b\b\030\0002\0020\001:\001*BA\b\000\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007\022\b\020\b\032\004\030\0010\t\022\026\020\n\032\022\022\b\022\006\022\002\b\0030\f\022\004\022\0020\0010\013¢\006\002\020\rJ\017\020\b\032\004\030\0010\tH\007¢\006\002\b\033J\r\020\017\032\0020\020H\007¢\006\002\b\034J\020\020\035\032\004\030\0010\0052\006\020\036\032\0020\005J\r\020\006\032\0020\007H\007¢\006\002\b\037J\024\020\006\032\b\022\004\022\0020\0050 2\006\020\036\032\0020\005J\r\020\004\032\0020\005H\007¢\006\002\b!J\006\020\"\032\0020#J\b\020$\032\004\030\0010\001J#\020$\032\004\030\001H%\"\004\b\000\020%2\016\020&\032\n\022\006\b\001\022\002H%0\f¢\006\002\020'J\b\020(\032\0020\005H\026J\r\020\002\032\0020\003H\007¢\006\002\b)R\025\020\b\032\004\030\0010\t8\007¢\006\b\n\000\032\004\b\b\020\016R\021\020\017\032\0020\0208G¢\006\006\032\004\b\017\020\021R\023\020\006\032\0020\0078\007¢\006\b\n\000\032\004\b\006\020\022R\021\020\023\032\0020\0248F¢\006\006\032\004\b\023\020\025R\020\020\026\032\004\030\0010\020X\016¢\006\002\n\000R\023\020\004\032\0020\0058\007¢\006\b\n\000\032\004\b\004\020\027R$\020\n\032\022\022\b\022\006\022\002\b\0030\f\022\004\022\0020\0010\013X\004¢\006\b\n\000\032\004\b\030\020\031R\023\020\002\032\0020\0038\007¢\006\b\n\000\032\004\b\002\020\032¨\006+"}, d2={"Lokhttp3/Request;", "", "url", "Lokhttp3/HttpUrl;", "method", "", "headers", "Lokhttp3/Headers;", "body", "Lokhttp3/RequestBody;", "tags", "", "Ljava/lang/Class;", "(Lokhttp3/HttpUrl;Ljava/lang/String;Lokhttp3/Headers;Lokhttp3/RequestBody;Ljava/util/Map;)V", "()Lokhttp3/RequestBody;", "cacheControl", "Lokhttp3/CacheControl;", "()Lokhttp3/CacheControl;", "()Lokhttp3/Headers;", "isHttps", "", "()Z", "lazyCacheControl", "()Ljava/lang/String;", "getTags$okhttp", "()Ljava/util/Map;", "()Lokhttp3/HttpUrl;", "-deprecated_body", "-deprecated_cacheControl", "header", "name", "-deprecated_headers", "", "-deprecated_method", "newBuilder", "Lokhttp3/Request$Builder;", "tag", "T", "type", "(Ljava/lang/Class;)Ljava/lang/Object;", "toString", "-deprecated_url", "Builder", "okhttp"}, k=1, mv={1, 1, 16})
public final class Request
{
  private final RequestBody body;
  private final Headers headers;
  private CacheControl lazyCacheControl;
  private final String method;
  private final Map<Class<?>, Object> tags;
  private final HttpUrl url;
  
  public Request(HttpUrl paramHttpUrl, String paramString, Headers paramHeaders, RequestBody paramRequestBody, Map<Class<?>, ? extends Object> paramMap)
  {
    this.url = paramHttpUrl;
    this.method = paramString;
    this.headers = paramHeaders;
    this.body = paramRequestBody;
    this.tags = paramMap;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="body", imports={}))
  public final RequestBody -deprecated_body()
  {
    return this.body;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="cacheControl", imports={}))
  public final CacheControl -deprecated_cacheControl()
  {
    return cacheControl();
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="headers", imports={}))
  public final Headers -deprecated_headers()
  {
    return this.headers;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="method", imports={}))
  public final String -deprecated_method()
  {
    return this.method;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="url", imports={}))
  public final HttpUrl -deprecated_url()
  {
    return this.url;
  }
  
  public final RequestBody body()
  {
    return this.body;
  }
  
  public final CacheControl cacheControl()
  {
    CacheControl localCacheControl2 = this.lazyCacheControl;
    CacheControl localCacheControl1 = localCacheControl2;
    if (localCacheControl2 == null)
    {
      localCacheControl1 = CacheControl.Companion.parse(this.headers);
      this.lazyCacheControl = localCacheControl1;
    }
    return localCacheControl1;
  }
  
  public final Map<Class<?>, Object> getTags$okhttp()
  {
    return this.tags;
  }
  
  public final String header(String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    return this.headers.get(paramString);
  }
  
  public final List<String> headers(String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    return this.headers.values(paramString);
  }
  
  public final Headers headers()
  {
    return this.headers;
  }
  
  public final boolean isHttps()
  {
    return this.url.isHttps();
  }
  
  public final String method()
  {
    return this.method;
  }
  
  public final Builder newBuilder()
  {
    return new Builder(this);
  }
  
  public final Object tag()
  {
    return tag(Object.class);
  }
  
  public final <T> T tag(Class<? extends T> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "type");
    return (T)paramClass.cast(this.tags.get(paramClass));
  }
  
  public String toString()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Request{method=");
    ((StringBuilder)localObject1).append(this.method);
    ((StringBuilder)localObject1).append(", url=");
    ((StringBuilder)localObject1).append(this.url);
    if (this.headers.size() != 0)
    {
      ((StringBuilder)localObject1).append(", headers=[");
      Object localObject2 = (Iterable)this.headers;
      int i = 0;
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (i < 0) {
          CollectionsKt.throwIndexOverflow();
        }
        Object localObject4 = (Pair)localObject3;
        localObject3 = (String)((Pair)localObject4).component1();
        localObject4 = (String)((Pair)localObject4).component2();
        if (i > 0) {
          ((StringBuilder)localObject1).append(", ");
        }
        ((StringBuilder)localObject1).append((String)localObject3);
        ((StringBuilder)localObject1).append(':');
        ((StringBuilder)localObject1).append((String)localObject4);
        i += 1;
      }
      ((StringBuilder)localObject1).append(']');
    }
    if ((this.tags.isEmpty() ^ true))
    {
      ((StringBuilder)localObject1).append(", tags=");
      ((StringBuilder)localObject1).append(this.tags);
    }
    ((StringBuilder)localObject1).append('}');
    localObject1 = ((StringBuilder)localObject1).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "StringBuilder().apply(builderAction).toString()");
    return (String)localObject1;
  }
  
  public final HttpUrl url()
  {
    return this.url;
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000V\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\005\n\002\020\016\n\002\b\005\n\002\020%\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\t\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\b\n\002\030\002\n\000\b\026\030\0002\0020\001B\007\b\026¢\006\002\020\002B\017\b\020\022\006\020\003\032\0020\004¢\006\002\020\005J\030\020%\032\0020\0002\006\020&\032\0020\0232\006\020'\032\0020\023H\026J\b\020(\032\0020\004H\026J\020\020)\032\0020\0002\006\020)\032\0020*H\026J\024\020+\032\0020\0002\n\b\002\020\006\032\004\030\0010\007H\027J\b\020,\032\0020\000H\026J\b\020-\032\0020\000H\026J\030\020.\032\0020\0002\006\020&\032\0020\0232\006\020'\032\0020\023H\026J\020\020\f\032\0020\0002\006\020\f\032\0020/H\026J\032\020\022\032\0020\0002\006\020\022\032\0020\0232\b\020\006\032\004\030\0010\007H\026J\020\0200\032\0020\0002\006\020\006\032\0020\007H\026J\020\0201\032\0020\0002\006\020\006\032\0020\007H\026J\020\0202\032\0020\0002\006\020\006\032\0020\007H\026J\020\0203\032\0020\0002\006\020&\032\0020\023H\026J-\0204\032\0020\000\"\004\b\000\02052\016\0206\032\n\022\006\b\000\022\002H50\0322\b\0204\032\004\030\001H5H\026¢\006\002\0207J\022\0204\032\0020\0002\b\0204\032\004\030\0010\001H\026J\020\020\037\032\0020\0002\006\020\037\032\00208H\026J\020\020\037\032\0020\0002\006\020\037\032\0020\023H\026J\020\020\037\032\0020\0002\006\020\037\032\0020 H\026R\034\020\006\032\004\030\0010\007X\016¢\006\016\n\000\032\004\b\b\020\t\"\004\b\n\020\013R\032\020\f\032\0020\rX\016¢\006\016\n\000\032\004\b\016\020\017\"\004\b\020\020\021R\032\020\022\032\0020\023X\016¢\006\016\n\000\032\004\b\024\020\025\"\004\b\026\020\027R*\020\030\032\022\022\b\022\006\022\002\b\0030\032\022\004\022\0020\0010\031X\016¢\006\016\n\000\032\004\b\033\020\034\"\004\b\035\020\036R\034\020\037\032\004\030\0010 X\016¢\006\016\n\000\032\004\b!\020\"\"\004\b#\020$¨\0069"}, d2={"Lokhttp3/Request$Builder;", "", "()V", "request", "Lokhttp3/Request;", "(Lokhttp3/Request;)V", "body", "Lokhttp3/RequestBody;", "getBody$okhttp", "()Lokhttp3/RequestBody;", "setBody$okhttp", "(Lokhttp3/RequestBody;)V", "headers", "Lokhttp3/Headers$Builder;", "getHeaders$okhttp", "()Lokhttp3/Headers$Builder;", "setHeaders$okhttp", "(Lokhttp3/Headers$Builder;)V", "method", "", "getMethod$okhttp", "()Ljava/lang/String;", "setMethod$okhttp", "(Ljava/lang/String;)V", "tags", "", "Ljava/lang/Class;", "getTags$okhttp", "()Ljava/util/Map;", "setTags$okhttp", "(Ljava/util/Map;)V", "url", "Lokhttp3/HttpUrl;", "getUrl$okhttp", "()Lokhttp3/HttpUrl;", "setUrl$okhttp", "(Lokhttp3/HttpUrl;)V", "addHeader", "name", "value", "build", "cacheControl", "Lokhttp3/CacheControl;", "delete", "get", "head", "header", "Lokhttp3/Headers;", "patch", "post", "put", "removeHeader", "tag", "T", "type", "(Ljava/lang/Class;Ljava/lang/Object;)Lokhttp3/Request$Builder;", "Ljava/net/URL;", "okhttp"}, k=1, mv={1, 1, 16})
  public static class Builder
  {
    private RequestBody body;
    private Headers.Builder headers;
    private String method;
    private Map<Class<?>, Object> tags = (Map)new LinkedHashMap();
    private HttpUrl url;
    
    public Builder()
    {
      this.method = "GET";
      this.headers = new Headers.Builder();
    }
    
    public Builder(Request paramRequest)
    {
      this.url = paramRequest.url();
      this.method = paramRequest.method();
      this.body = paramRequest.body();
      Map localMap;
      if (paramRequest.getTags$okhttp().isEmpty()) {
        localMap = (Map)new LinkedHashMap();
      } else {
        localMap = MapsKt.toMutableMap(paramRequest.getTags$okhttp());
      }
      this.tags = localMap;
      this.headers = paramRequest.headers().newBuilder();
    }
    
    public Builder addHeader(String paramString1, String paramString2)
    {
      Intrinsics.checkParameterIsNotNull(paramString1, "name");
      Intrinsics.checkParameterIsNotNull(paramString2, "value");
      Builder localBuilder = (Builder)this;
      localBuilder.headers.add(paramString1, paramString2);
      return localBuilder;
    }
    
    public Request build()
    {
      HttpUrl localHttpUrl = this.url;
      if (localHttpUrl != null) {
        return new Request(localHttpUrl, this.method, this.headers.build(), this.body, Util.toImmutableMap(this.tags));
      }
      throw ((Throwable)new IllegalStateException("url == null".toString()));
    }
    
    public Builder cacheControl(CacheControl paramCacheControl)
    {
      Intrinsics.checkParameterIsNotNull(paramCacheControl, "cacheControl");
      paramCacheControl = paramCacheControl.toString();
      int i;
      if (((CharSequence)paramCacheControl).length() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return removeHeader("Cache-Control");
      }
      return header("Cache-Control", paramCacheControl);
    }
    
    public Builder delete()
    {
      return delete$default(this, null, 1, null);
    }
    
    public Builder delete(RequestBody paramRequestBody)
    {
      return method("DELETE", paramRequestBody);
    }
    
    public Builder get()
    {
      return method("GET", null);
    }
    
    public final RequestBody getBody$okhttp()
    {
      return this.body;
    }
    
    public final Headers.Builder getHeaders$okhttp()
    {
      return this.headers;
    }
    
    public final String getMethod$okhttp()
    {
      return this.method;
    }
    
    public final Map<Class<?>, Object> getTags$okhttp()
    {
      return this.tags;
    }
    
    public final HttpUrl getUrl$okhttp()
    {
      return this.url;
    }
    
    public Builder head()
    {
      return method("HEAD", null);
    }
    
    public Builder header(String paramString1, String paramString2)
    {
      Intrinsics.checkParameterIsNotNull(paramString1, "name");
      Intrinsics.checkParameterIsNotNull(paramString2, "value");
      Builder localBuilder = (Builder)this;
      localBuilder.headers.set(paramString1, paramString2);
      return localBuilder;
    }
    
    public Builder headers(Headers paramHeaders)
    {
      Intrinsics.checkParameterIsNotNull(paramHeaders, "headers");
      Builder localBuilder = (Builder)this;
      localBuilder.headers = paramHeaders.newBuilder();
      return localBuilder;
    }
    
    public Builder method(String paramString, RequestBody paramRequestBody)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "method");
      Builder localBuilder = (Builder)this;
      int i;
      if (((CharSequence)paramString).length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (paramRequestBody == null)
        {
          if (!(true ^ HttpMethod.requiresRequestBody(paramString)))
          {
            paramRequestBody = new StringBuilder();
            paramRequestBody.append("method ");
            paramRequestBody.append(paramString);
            paramRequestBody.append(" must have a request body.");
            throw ((Throwable)new IllegalArgumentException(paramRequestBody.toString().toString()));
          }
        }
        else {
          if (!HttpMethod.permitsRequestBody(paramString)) {
            break label119;
          }
        }
        localBuilder.method = paramString;
        localBuilder.body = paramRequestBody;
        return localBuilder;
        label119:
        paramRequestBody = new StringBuilder();
        paramRequestBody.append("method ");
        paramRequestBody.append(paramString);
        paramRequestBody.append(" must not have a request body.");
        throw ((Throwable)new IllegalArgumentException(paramRequestBody.toString().toString()));
      }
      throw ((Throwable)new IllegalArgumentException("method.isEmpty() == true".toString()));
    }
    
    public Builder patch(RequestBody paramRequestBody)
    {
      Intrinsics.checkParameterIsNotNull(paramRequestBody, "body");
      return method("PATCH", paramRequestBody);
    }
    
    public Builder post(RequestBody paramRequestBody)
    {
      Intrinsics.checkParameterIsNotNull(paramRequestBody, "body");
      return method("POST", paramRequestBody);
    }
    
    public Builder put(RequestBody paramRequestBody)
    {
      Intrinsics.checkParameterIsNotNull(paramRequestBody, "body");
      return method("PUT", paramRequestBody);
    }
    
    public Builder removeHeader(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "name");
      Builder localBuilder = (Builder)this;
      localBuilder.headers.removeAll(paramString);
      return localBuilder;
    }
    
    public final void setBody$okhttp(RequestBody paramRequestBody)
    {
      this.body = paramRequestBody;
    }
    
    public final void setHeaders$okhttp(Headers.Builder paramBuilder)
    {
      Intrinsics.checkParameterIsNotNull(paramBuilder, "<set-?>");
      this.headers = paramBuilder;
    }
    
    public final void setMethod$okhttp(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
      this.method = paramString;
    }
    
    public final void setTags$okhttp(Map<Class<?>, Object> paramMap)
    {
      Intrinsics.checkParameterIsNotNull(paramMap, "<set-?>");
      this.tags = paramMap;
    }
    
    public final void setUrl$okhttp(HttpUrl paramHttpUrl)
    {
      this.url = paramHttpUrl;
    }
    
    public <T> Builder tag(Class<? super T> paramClass, T paramT)
    {
      Intrinsics.checkParameterIsNotNull(paramClass, "type");
      Builder localBuilder = (Builder)this;
      if (paramT == null)
      {
        localBuilder.tags.remove(paramClass);
        return localBuilder;
      }
      if (localBuilder.tags.isEmpty()) {
        localBuilder.tags = ((Map)new LinkedHashMap());
      }
      Map localMap = localBuilder.tags;
      paramT = paramClass.cast(paramT);
      if (paramT == null) {
        Intrinsics.throwNpe();
      }
      localMap.put(paramClass, paramT);
      return localBuilder;
    }
    
    public Builder tag(Object paramObject)
    {
      return tag(Object.class, paramObject);
    }
    
    public Builder url(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "url");
      Object localObject;
      if (StringsKt.startsWith(paramString, "ws:", true))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("http:");
        paramString = paramString.substring(3);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = paramString;
        if (StringsKt.startsWith(paramString, "wss:", true))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("https:");
          paramString = paramString.substring(4);
          Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
          ((StringBuilder)localObject).append(paramString);
          localObject = ((StringBuilder)localObject).toString();
        }
      }
      return url(HttpUrl.Companion.get((String)localObject));
    }
    
    public Builder url(URL paramURL)
    {
      Intrinsics.checkParameterIsNotNull(paramURL, "url");
      HttpUrl.Companion localCompanion = HttpUrl.Companion;
      paramURL = paramURL.toString();
      Intrinsics.checkExpressionValueIsNotNull(paramURL, "url.toString()");
      return url(localCompanion.get(paramURL));
    }
    
    public Builder url(HttpUrl paramHttpUrl)
    {
      Intrinsics.checkParameterIsNotNull(paramHttpUrl, "url");
      Builder localBuilder = (Builder)this;
      localBuilder.url = paramHttpUrl;
      return localBuilder;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\Request.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */