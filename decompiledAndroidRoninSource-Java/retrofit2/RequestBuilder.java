package retrofit2;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.FormBody.Builder;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.HttpUrl.Builder;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody.Builder;
import okhttp3.MultipartBody.Part;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;

final class RequestBuilder
{
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private static final String PATH_SEGMENT_ALWAYS_ENCODE_SET = " \"<>^`{}|\\?#";
  private static final Pattern PATH_TRAVERSAL = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");
  private final HttpUrl baseUrl;
  @Nullable
  private RequestBody body;
  @Nullable
  private MediaType contentType;
  @Nullable
  private FormBody.Builder formBuilder;
  private final boolean hasBody;
  private final Headers.Builder headersBuilder;
  private final String method;
  @Nullable
  private MultipartBody.Builder multipartBuilder;
  @Nullable
  private String relativeUrl;
  private final Request.Builder requestBuilder;
  @Nullable
  private HttpUrl.Builder urlBuilder;
  
  RequestBuilder(String paramString1, HttpUrl paramHttpUrl, @Nullable String paramString2, @Nullable Headers paramHeaders, @Nullable MediaType paramMediaType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.method = paramString1;
    this.baseUrl = paramHttpUrl;
    this.relativeUrl = paramString2;
    this.requestBuilder = new Request.Builder();
    this.contentType = paramMediaType;
    this.hasBody = paramBoolean1;
    if (paramHeaders != null) {
      this.headersBuilder = paramHeaders.newBuilder();
    } else {
      this.headersBuilder = new Headers.Builder();
    }
    if (paramBoolean2)
    {
      this.formBuilder = new FormBody.Builder();
      return;
    }
    if (paramBoolean3)
    {
      paramString1 = new MultipartBody.Builder();
      this.multipartBuilder = paramString1;
      paramString1.setType(MultipartBody.FORM);
    }
  }
  
  private static String canonicalizeForPath(String paramString, boolean paramBoolean)
  {
    int j = paramString.length();
    int i = 0;
    for (;;)
    {
      localObject = paramString;
      if (i >= j) {
        break label113;
      }
      int k = paramString.codePointAt(i);
      if ((k < 32) || (k >= 127) || (" \"<>^`{}|\\?#".indexOf(k) != -1) || ((!paramBoolean) && ((k == 47) || (k == 37)))) {
        break;
      }
      i += Character.charCount(k);
    }
    Object localObject = new Buffer();
    ((Buffer)localObject).writeUtf8(paramString, 0, i);
    canonicalizeForPath((Buffer)localObject, paramString, i, j, paramBoolean);
    localObject = ((Buffer)localObject).readUtf8();
    label113:
    return (String)localObject;
  }
  
  private static void canonicalizeForPath(Buffer paramBuffer, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject3;
    for (Object localObject1 = null; paramInt1 < paramInt2; localObject1 = localObject3)
    {
      int i = paramString.codePointAt(paramInt1);
      if (paramBoolean)
      {
        localObject3 = localObject1;
        if (i == 9) {
          break label217;
        }
        localObject3 = localObject1;
        if (i == 10) {
          break label217;
        }
        localObject3 = localObject1;
        if (i == 12) {
          break label217;
        }
        if (i == 13)
        {
          localObject3 = localObject1;
          break label217;
        }
      }
      if ((i >= 32) && (i < 127) && (" \"<>^`{}|\\?#".indexOf(i) == -1) && ((paramBoolean) || ((i != 47) && (i != 37))))
      {
        paramBuffer.writeUtf8CodePoint(i);
        localObject3 = localObject1;
      }
      else
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new Buffer();
        }
        ((Buffer)localObject2).writeUtf8CodePoint(i);
        for (;;)
        {
          localObject3 = localObject2;
          if (((Buffer)localObject2).exhausted()) {
            break;
          }
          int j = ((Buffer)localObject2).readByte() & 0xFF;
          paramBuffer.writeByte(37);
          paramBuffer.writeByte(HEX_DIGITS[(j >> 4 & 0xF)]);
          paramBuffer.writeByte(HEX_DIGITS[(j & 0xF)]);
        }
      }
      label217:
      paramInt1 += Character.charCount(i);
    }
  }
  
  void addFormField(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.formBuilder.addEncoded(paramString1, paramString2);
      return;
    }
    this.formBuilder.add(paramString1, paramString2);
  }
  
  void addHeader(String paramString1, String paramString2)
  {
    if ("Content-Type".equalsIgnoreCase(paramString1)) {
      try
      {
        this.contentType = MediaType.get(paramString2);
        return;
      }
      catch (IllegalArgumentException paramString1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Malformed content type: ");
        localStringBuilder.append(paramString2);
        throw new IllegalArgumentException(localStringBuilder.toString(), paramString1);
      }
    }
    this.headersBuilder.add(paramString1, paramString2);
  }
  
  void addHeaders(Headers paramHeaders)
  {
    this.headersBuilder.addAll(paramHeaders);
  }
  
  void addPart(Headers paramHeaders, RequestBody paramRequestBody)
  {
    this.multipartBuilder.addPart(paramHeaders, paramRequestBody);
  }
  
  void addPart(MultipartBody.Part paramPart)
  {
    this.multipartBuilder.addPart(paramPart);
  }
  
  void addPathParam(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (this.relativeUrl != null)
    {
      String str1 = canonicalizeForPath(paramString2, paramBoolean);
      String str2 = this.relativeUrl;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("}");
      paramString1 = str2.replace(localStringBuilder.toString(), str1);
      if (!PATH_TRAVERSAL.matcher(paramString1).matches())
      {
        this.relativeUrl = paramString1;
        return;
      }
      paramString1 = new StringBuilder();
      paramString1.append("@Path parameters shouldn't perform path traversal ('.' or '..'): ");
      paramString1.append(paramString2);
      throw new IllegalArgumentException(paramString1.toString());
    }
    throw new AssertionError();
  }
  
  void addQueryParam(String paramString1, @Nullable String paramString2, boolean paramBoolean)
  {
    Object localObject = this.relativeUrl;
    if (localObject != null)
    {
      localObject = this.baseUrl.newBuilder((String)localObject);
      this.urlBuilder = ((HttpUrl.Builder)localObject);
      if (localObject != null)
      {
        this.relativeUrl = null;
      }
      else
      {
        paramString1 = new StringBuilder();
        paramString1.append("Malformed URL. Base: ");
        paramString1.append(this.baseUrl);
        paramString1.append(", Relative: ");
        paramString1.append(this.relativeUrl);
        throw new IllegalArgumentException(paramString1.toString());
      }
    }
    if (paramBoolean)
    {
      this.urlBuilder.addEncodedQueryParameter(paramString1, paramString2);
      return;
    }
    this.urlBuilder.addQueryParameter(paramString1, paramString2);
  }
  
  <T> void addTag(Class<T> paramClass, @Nullable T paramT)
  {
    this.requestBuilder.tag(paramClass, paramT);
  }
  
  Request.Builder get()
  {
    Object localObject1 = this.urlBuilder;
    HttpUrl localHttpUrl;
    if (localObject1 != null)
    {
      localHttpUrl = ((HttpUrl.Builder)localObject1).build();
    }
    else
    {
      localHttpUrl = this.baseUrl.resolve(this.relativeUrl);
      if (localHttpUrl == null) {
        break label170;
      }
    }
    Object localObject2 = this.body;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.formBuilder;
      if (localObject1 != null)
      {
        localObject1 = ((FormBody.Builder)localObject1).build();
      }
      else
      {
        localObject1 = this.multipartBuilder;
        if (localObject1 != null)
        {
          localObject1 = ((MultipartBody.Builder)localObject1).build();
        }
        else
        {
          localObject1 = localObject2;
          if (this.hasBody) {
            localObject1 = RequestBody.create(null, new byte[0]);
          }
        }
      }
    }
    MediaType localMediaType = this.contentType;
    localObject2 = localObject1;
    if (localMediaType != null) {
      if (localObject1 != null)
      {
        localObject2 = new ContentTypeOverridingRequestBody((RequestBody)localObject1, localMediaType);
      }
      else
      {
        this.headersBuilder.add("Content-Type", localMediaType.toString());
        localObject2 = localObject1;
      }
    }
    return this.requestBuilder.url(localHttpUrl).headers(this.headersBuilder.build()).method(this.method, (RequestBody)localObject2);
    label170:
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Malformed URL. Base: ");
    ((StringBuilder)localObject1).append(this.baseUrl);
    ((StringBuilder)localObject1).append(", Relative: ");
    ((StringBuilder)localObject1).append(this.relativeUrl);
    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
  }
  
  void setBody(RequestBody paramRequestBody)
  {
    this.body = paramRequestBody;
  }
  
  void setRelativeUrl(Object paramObject)
  {
    this.relativeUrl = paramObject.toString();
  }
  
  private static class ContentTypeOverridingRequestBody
    extends RequestBody
  {
    private final MediaType contentType;
    private final RequestBody delegate;
    
    ContentTypeOverridingRequestBody(RequestBody paramRequestBody, MediaType paramMediaType)
    {
      this.delegate = paramRequestBody;
      this.contentType = paramMediaType;
    }
    
    public long contentLength()
      throws IOException
    {
      return this.delegate.contentLength();
    }
    
    public MediaType contentType()
    {
      return this.contentType;
    }
    
    public void writeTo(BufferedSink paramBufferedSink)
      throws IOException
    {
      this.delegate.writeTo(paramBufferedSink);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\retrofit2\RequestBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */