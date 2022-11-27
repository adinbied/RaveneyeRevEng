package dji.thirdparty.retrofit2;

import dji.thirdparty.okhttp3.FormBody.Builder;
import dji.thirdparty.okhttp3.Headers;
import dji.thirdparty.okhttp3.HttpUrl;
import dji.thirdparty.okhttp3.HttpUrl.Builder;
import dji.thirdparty.okhttp3.MediaType;
import dji.thirdparty.okhttp3.MultipartBody;
import dji.thirdparty.okhttp3.MultipartBody.Builder;
import dji.thirdparty.okhttp3.MultipartBody.Part;
import dji.thirdparty.okhttp3.Request;
import dji.thirdparty.okhttp3.Request.Builder;
import dji.thirdparty.okhttp3.RequestBody;
import dji.thirdparty.okio.Buffer;
import dji.thirdparty.okio.BufferedSink;
import java.io.IOException;

final class RequestBuilder
{
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private static final String PATH_SEGMENT_ALWAYS_ENCODE_SET = " \"<>^`{}|\\?#";
  private final HttpUrl baseUrl;
  private RequestBody body;
  private MediaType contentType;
  private FormBody.Builder formBuilder;
  private final boolean hasBody;
  private final String method;
  private MultipartBody.Builder multipartBuilder;
  private String relativeUrl;
  private final Request.Builder requestBuilder;
  private HttpUrl.Builder urlBuilder;
  
  RequestBuilder(String paramString1, HttpUrl paramHttpUrl, String paramString2, Headers paramHeaders, MediaType paramMediaType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.method = paramString1;
    this.baseUrl = paramHttpUrl;
    this.relativeUrl = paramString2;
    paramString1 = new Request.Builder();
    this.requestBuilder = paramString1;
    this.contentType = paramMediaType;
    this.hasBody = paramBoolean1;
    if (paramHeaders != null) {
      paramString1.headers(paramHeaders);
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
  
  /* Error */
  void addHeader(String arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  void addPart(Headers paramHeaders, RequestBody paramRequestBody)
  {
    this.multipartBuilder.addPart(paramHeaders, paramRequestBody);
  }
  
  void addPart(MultipartBody.Part paramPart)
  {
    this.multipartBuilder.addPart(paramPart);
  }
  
  /* Error */
  void addPathParam(String arg1, String arg2, boolean arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void addQueryParam(String arg1, String arg2, boolean arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  Request build()
  {
    return null;
  }
  
  void setBody(RequestBody paramRequestBody)
  {
    this.body = paramRequestBody;
  }
  
  /* Error */
  void setRelativeUrl(Object arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\retrofit2\RequestBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */