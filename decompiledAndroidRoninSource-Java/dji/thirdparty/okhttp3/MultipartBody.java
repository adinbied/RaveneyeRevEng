package dji.thirdparty.okhttp3;

import dji.thirdparty.okhttp3.internal.Util;
import dji.thirdparty.okio.BufferedSink;
import dji.thirdparty.okio.ByteString;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class MultipartBody
  extends RequestBody
{
  public static final MediaType ALTERNATIVE;
  private static final byte[] COLONSPACE = { 58, 32 };
  private static final byte[] CRLF = { 13, 10 };
  private static final byte[] DASHDASH = { 45, 45 };
  public static final MediaType DIGEST;
  public static final MediaType FORM;
  public static final MediaType MIXED = MediaType.parse("multipart/mixed");
  public static final MediaType PARALLEL;
  private final ByteString boundary;
  private long contentLength = -1L;
  private final MediaType contentType;
  private final MediaType originalType;
  private final List<Part> parts;
  
  static
  {
    ALTERNATIVE = MediaType.parse("multipart/alternative");
    DIGEST = MediaType.parse("multipart/digest");
    PARALLEL = MediaType.parse("multipart/parallel");
    FORM = MediaType.parse("multipart/form-data");
  }
  
  MultipartBody(ByteString paramByteString, MediaType paramMediaType, List<Part> paramList)
  {
    this.boundary = paramByteString;
    this.originalType = paramMediaType;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMediaType);
    localStringBuilder.append("; boundary=");
    localStringBuilder.append(paramByteString.utf8());
    this.contentType = MediaType.parse(localStringBuilder.toString());
    this.parts = Util.immutableList(paramList);
  }
  
  static StringBuilder appendQuotedString(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append('"');
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      char c = paramString.charAt(i);
      if (c != '\n')
      {
        if (c != '\r')
        {
          if (c != '"') {
            paramStringBuilder.append(c);
          } else {
            paramStringBuilder.append("%22");
          }
        }
        else {
          paramStringBuilder.append("%0D");
        }
      }
      else {
        paramStringBuilder.append("%0A");
      }
      i += 1;
    }
    paramStringBuilder.append('"');
    return paramStringBuilder;
  }
  
  private long writeOrCountBytes(BufferedSink paramBufferedSink, boolean paramBoolean)
    throws IOException
  {
    return 277865784L;
  }
  
  public String boundary()
  {
    return this.boundary.utf8();
  }
  
  public long contentLength()
    throws IOException
  {
    return 277865824L;
  }
  
  public MediaType contentType()
  {
    return this.contentType;
  }
  
  public Part part(int paramInt)
  {
    return null;
  }
  
  public List<Part> parts()
  {
    return this.parts;
  }
  
  public int size()
  {
    return this.parts.size();
  }
  
  public MediaType type()
  {
    return this.originalType;
  }
  
  public void writeTo(BufferedSink paramBufferedSink)
    throws IOException
  {
    writeOrCountBytes(paramBufferedSink, false);
  }
  
  public static final class Builder
  {
    private final ByteString boundary;
    private final List<MultipartBody.Part> parts = new ArrayList();
    private MediaType type = MultipartBody.MIXED;
    
    public Builder()
    {
      this(UUID.randomUUID().toString());
    }
    
    public Builder(String paramString)
    {
      this.boundary = ByteString.encodeUtf8(paramString);
    }
    
    public Builder addFormDataPart(String paramString1, String paramString2)
    {
      return addPart(MultipartBody.Part.createFormData(paramString1, paramString2));
    }
    
    public Builder addFormDataPart(String paramString1, String paramString2, RequestBody paramRequestBody)
    {
      return addPart(MultipartBody.Part.createFormData(paramString1, paramString2, paramRequestBody));
    }
    
    public Builder addPart(Headers paramHeaders, RequestBody paramRequestBody)
    {
      return addPart(MultipartBody.Part.create(paramHeaders, paramRequestBody));
    }
    
    public Builder addPart(MultipartBody.Part paramPart)
    {
      return null;
    }
    
    public Builder addPart(RequestBody paramRequestBody)
    {
      return addPart(MultipartBody.Part.create(paramRequestBody));
    }
    
    public MultipartBody build()
    {
      return null;
    }
    
    public Builder setType(MediaType paramMediaType)
    {
      return null;
    }
  }
  
  public static final class Part
  {
    private final RequestBody body;
    private final Headers headers;
    
    private Part(Headers paramHeaders, RequestBody paramRequestBody)
    {
      this.headers = paramHeaders;
      this.body = paramRequestBody;
    }
    
    public static Part create(Headers paramHeaders, RequestBody paramRequestBody)
    {
      if (paramRequestBody != null)
      {
        if ((paramHeaders != null) && (paramHeaders.get("Content-Type") != null)) {
          throw new IllegalArgumentException("Unexpected header: Content-Type");
        }
        if ((paramHeaders != null) && (paramHeaders.get("Content-Length") != null)) {
          throw new IllegalArgumentException("Unexpected header: Content-Length");
        }
        return new Part(paramHeaders, paramRequestBody);
      }
      throw new NullPointerException("body == null");
    }
    
    public static Part create(RequestBody paramRequestBody)
    {
      return create(null, paramRequestBody);
    }
    
    public static Part createFormData(String paramString1, String paramString2)
    {
      return createFormData(paramString1, null, RequestBody.create(null, paramString2));
    }
    
    public static Part createFormData(String paramString1, String paramString2, RequestBody paramRequestBody)
    {
      if (paramString1 != null)
      {
        StringBuilder localStringBuilder = new StringBuilder("form-data; name=");
        MultipartBody.appendQuotedString(localStringBuilder, paramString1);
        if (paramString2 != null)
        {
          localStringBuilder.append("; filename=");
          MultipartBody.appendQuotedString(localStringBuilder, paramString2);
        }
        return create(Headers.of(new String[] { "Content-Disposition", localStringBuilder.toString() }), paramRequestBody);
      }
      throw new NullPointerException("name == null");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\MultipartBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */