package okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.ByteString.Companion;

@Metadata(bv={1, 0, 3}, d1={"\000N\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020 \n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\002\n\002\020\t\n\002\b\003\n\002\020\b\n\002\b\n\n\002\030\002\n\000\n\002\020\013\n\000\n\002\020\002\n\002\b\004\030\000 #2\0020\001:\003\"#$B%\b\000\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\f\020\006\032\b\022\004\022\0020\b0\007¢\006\002\020\tJ\r\020\n\032\0020\013H\007¢\006\002\b\025J\b\020\r\032\0020\016H\026J\b\020\017\032\0020\005H\026J\016\020\026\032\0020\b2\006\020\027\032\0020\022J\023\020\006\032\b\022\004\022\0020\b0\007H\007¢\006\002\b\030J\r\020\021\032\0020\022H\007¢\006\002\b\031J\r\020\004\032\0020\005H\007¢\006\002\b\032J\032\020\033\032\0020\0162\b\020\034\032\004\030\0010\0352\006\020\036\032\0020\037H\002J\020\020 \032\0020!2\006\020\034\032\0020\035H\026R\021\020\n\032\0020\0138G¢\006\006\032\004\b\n\020\fR\016\020\002\032\0020\003X\004¢\006\002\n\000R\016\020\r\032\0020\016X\016¢\006\002\n\000R\016\020\017\032\0020\005X\004¢\006\002\n\000R\031\020\006\032\b\022\004\022\0020\b0\0078\007¢\006\b\n\000\032\004\b\006\020\020R\021\020\021\032\0020\0228G¢\006\006\032\004\b\021\020\023R\023\020\004\032\0020\0058\007¢\006\b\n\000\032\004\b\004\020\024¨\006%"}, d2={"Lokhttp3/MultipartBody;", "Lokhttp3/RequestBody;", "boundaryByteString", "Lokio/ByteString;", "type", "Lokhttp3/MediaType;", "parts", "", "Lokhttp3/MultipartBody$Part;", "(Lokio/ByteString;Lokhttp3/MediaType;Ljava/util/List;)V", "boundary", "", "()Ljava/lang/String;", "contentLength", "", "contentType", "()Ljava/util/List;", "size", "", "()I", "()Lokhttp3/MediaType;", "-deprecated_boundary", "part", "index", "-deprecated_parts", "-deprecated_size", "-deprecated_type", "writeOrCountBytes", "sink", "Lokio/BufferedSink;", "countBytes", "", "writeTo", "", "Builder", "Companion", "Part", "okhttp"}, k=1, mv={1, 1, 16})
public final class MultipartBody
  extends RequestBody
{
  public static final MediaType ALTERNATIVE;
  private static final byte[] COLONSPACE;
  private static final byte[] CRLF;
  public static final Companion Companion = new Companion(null);
  private static final byte[] DASHDASH;
  public static final MediaType DIGEST;
  public static final MediaType FORM;
  public static final MediaType MIXED = MediaType.Companion.get("multipart/mixed");
  public static final MediaType PARALLEL;
  private final ByteString boundaryByteString;
  private long contentLength;
  private final MediaType contentType;
  private final List<Part> parts;
  private final MediaType type;
  
  static
  {
    ALTERNATIVE = MediaType.Companion.get("multipart/alternative");
    DIGEST = MediaType.Companion.get("multipart/digest");
    PARALLEL = MediaType.Companion.get("multipart/parallel");
    FORM = MediaType.Companion.get("multipart/form-data");
    COLONSPACE = new byte[] { (byte)58, (byte)32 };
    CRLF = new byte[] { (byte)13, (byte)10 };
    int i = (byte)45;
    DASHDASH = new byte[] { i, i };
  }
  
  public MultipartBody(ByteString paramByteString, MediaType paramMediaType, List<Part> paramList)
  {
    this.boundaryByteString = paramByteString;
    this.type = paramMediaType;
    this.parts = paramList;
    paramByteString = MediaType.Companion;
    paramMediaType = new StringBuilder();
    paramMediaType.append(this.type);
    paramMediaType.append("; boundary=");
    paramMediaType.append(boundary());
    this.contentType = paramByteString.get(paramMediaType.toString());
    this.contentLength = -1L;
  }
  
  private final long writeOrCountBytes(BufferedSink paramBufferedSink, boolean paramBoolean)
    throws IOException
  {
    Buffer localBuffer = (Buffer)null;
    if (paramBoolean)
    {
      localBuffer = new Buffer();
      paramBufferedSink = (BufferedSink)localBuffer;
    }
    int k = this.parts.size();
    long l1 = 0L;
    int i = 0;
    while (i < k)
    {
      Object localObject2 = (Part)this.parts.get(i);
      Object localObject1 = ((Part)localObject2).headers();
      localObject2 = ((Part)localObject2).body();
      if (paramBufferedSink == null) {
        Intrinsics.throwNpe();
      }
      paramBufferedSink.write(DASHDASH);
      paramBufferedSink.write(this.boundaryByteString);
      paramBufferedSink.write(CRLF);
      if (localObject1 != null)
      {
        int m = ((Headers)localObject1).size();
        int j = 0;
        while (j < m)
        {
          paramBufferedSink.writeUtf8(((Headers)localObject1).name(j)).write(COLONSPACE).writeUtf8(((Headers)localObject1).value(j)).write(CRLF);
          j += 1;
        }
      }
      localObject1 = ((RequestBody)localObject2).contentType();
      if (localObject1 != null) {
        paramBufferedSink.writeUtf8("Content-Type: ").writeUtf8(((MediaType)localObject1).toString()).write(CRLF);
      }
      l2 = ((RequestBody)localObject2).contentLength();
      if (l2 != -1L)
      {
        paramBufferedSink.writeUtf8("Content-Length: ").writeDecimalLong(l2).write(CRLF);
      }
      else if (paramBoolean)
      {
        if (localBuffer == null) {
          Intrinsics.throwNpe();
        }
        localBuffer.clear();
        return -1L;
      }
      paramBufferedSink.write(CRLF);
      if (paramBoolean) {
        l1 += l2;
      } else {
        ((RequestBody)localObject2).writeTo(paramBufferedSink);
      }
      paramBufferedSink.write(CRLF);
      i += 1;
    }
    if (paramBufferedSink == null) {
      Intrinsics.throwNpe();
    }
    paramBufferedSink.write(DASHDASH);
    paramBufferedSink.write(this.boundaryByteString);
    paramBufferedSink.write(DASHDASH);
    paramBufferedSink.write(CRLF);
    long l2 = l1;
    if (paramBoolean)
    {
      if (localBuffer == null) {
        Intrinsics.throwNpe();
      }
      l2 = l1 + localBuffer.size();
      localBuffer.clear();
    }
    return l2;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="boundary", imports={}))
  public final String -deprecated_boundary()
  {
    return boundary();
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="parts", imports={}))
  public final List<Part> -deprecated_parts()
  {
    return this.parts;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="size", imports={}))
  public final int -deprecated_size()
  {
    return size();
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="type", imports={}))
  public final MediaType -deprecated_type()
  {
    return this.type;
  }
  
  public final String boundary()
  {
    return this.boundaryByteString.utf8();
  }
  
  public long contentLength()
    throws IOException
  {
    long l2 = this.contentLength;
    long l1 = l2;
    if (l2 == -1L)
    {
      l1 = writeOrCountBytes(null, true);
      this.contentLength = l1;
    }
    return l1;
  }
  
  public MediaType contentType()
  {
    return this.contentType;
  }
  
  public final Part part(int paramInt)
  {
    return (Part)this.parts.get(paramInt);
  }
  
  public final List<Part> parts()
  {
    return this.parts;
  }
  
  public final int size()
  {
    return this.parts.size();
  }
  
  public final MediaType type()
  {
    return this.type;
  }
  
  public void writeTo(BufferedSink paramBufferedSink)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramBufferedSink, "sink");
    writeOrCountBytes(paramBufferedSink, false);
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000@\n\002\030\002\n\002\020\000\n\000\n\002\020\016\n\000\n\002\030\002\n\000\n\002\020!\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\030\0002\0020\001B\021\b\007\022\b\b\002\020\002\032\0020\003¢\006\002\020\004J\026\020\013\032\0020\0002\006\020\f\032\0020\0032\006\020\r\032\0020\003J \020\013\032\0020\0002\006\020\f\032\0020\0032\b\020\016\032\004\030\0010\0032\006\020\017\032\0020\020J\030\020\021\032\0020\0002\b\020\022\032\004\030\0010\0232\006\020\017\032\0020\020J\016\020\021\032\0020\0002\006\020\024\032\0020\bJ\016\020\021\032\0020\0002\006\020\017\032\0020\020J\006\020\025\032\0020\026J\016\020\027\032\0020\0002\006\020\t\032\0020\nR\016\020\002\032\0020\005X\004¢\006\002\n\000R\024\020\006\032\b\022\004\022\0020\b0\007X\004¢\006\002\n\000R\016\020\t\032\0020\nX\016¢\006\002\n\000¨\006\030"}, d2={"Lokhttp3/MultipartBody$Builder;", "", "boundary", "", "(Ljava/lang/String;)V", "Lokio/ByteString;", "parts", "", "Lokhttp3/MultipartBody$Part;", "type", "Lokhttp3/MediaType;", "addFormDataPart", "name", "value", "filename", "body", "Lokhttp3/RequestBody;", "addPart", "headers", "Lokhttp3/Headers;", "part", "build", "Lokhttp3/MultipartBody;", "setType", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Builder
  {
    private final ByteString boundary;
    private final List<MultipartBody.Part> parts;
    private MediaType type;
    
    public Builder()
    {
      this(null, 1, null);
    }
    
    public Builder(String paramString)
    {
      this.boundary = ByteString.Companion.encodeUtf8(paramString);
      this.type = MultipartBody.MIXED;
      this.parts = ((List)new ArrayList());
    }
    
    public final Builder addFormDataPart(String paramString1, String paramString2)
    {
      Intrinsics.checkParameterIsNotNull(paramString1, "name");
      Intrinsics.checkParameterIsNotNull(paramString2, "value");
      Builder localBuilder = (Builder)this;
      localBuilder.addPart(MultipartBody.Part.Companion.createFormData(paramString1, paramString2));
      return localBuilder;
    }
    
    public final Builder addFormDataPart(String paramString1, String paramString2, RequestBody paramRequestBody)
    {
      Intrinsics.checkParameterIsNotNull(paramString1, "name");
      Intrinsics.checkParameterIsNotNull(paramRequestBody, "body");
      Builder localBuilder = (Builder)this;
      localBuilder.addPart(MultipartBody.Part.Companion.createFormData(paramString1, paramString2, paramRequestBody));
      return localBuilder;
    }
    
    public final Builder addPart(Headers paramHeaders, RequestBody paramRequestBody)
    {
      Intrinsics.checkParameterIsNotNull(paramRequestBody, "body");
      Builder localBuilder = (Builder)this;
      localBuilder.addPart(MultipartBody.Part.Companion.create(paramHeaders, paramRequestBody));
      return localBuilder;
    }
    
    public final Builder addPart(MultipartBody.Part paramPart)
    {
      Intrinsics.checkParameterIsNotNull(paramPart, "part");
      Builder localBuilder = (Builder)this;
      ((Collection)localBuilder.parts).add(paramPart);
      return localBuilder;
    }
    
    public final Builder addPart(RequestBody paramRequestBody)
    {
      Intrinsics.checkParameterIsNotNull(paramRequestBody, "body");
      Builder localBuilder = (Builder)this;
      localBuilder.addPart(MultipartBody.Part.Companion.create(paramRequestBody));
      return localBuilder;
    }
    
    public final MultipartBody build()
    {
      if ((((Collection)this.parts).isEmpty() ^ true)) {
        return new MultipartBody(this.boundary, this.type, Util.toImmutableList(this.parts));
      }
      throw ((Throwable)new IllegalStateException("Multipart body must have at least one part.".toString()));
    }
    
    public final Builder setType(MediaType paramMediaType)
    {
      Intrinsics.checkParameterIsNotNull(paramMediaType, "type");
      Object localObject = (Builder)this;
      if (Intrinsics.areEqual(paramMediaType.type(), "multipart"))
      {
        ((Builder)localObject).type = paramMediaType;
        return (Builder)localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("multipart != ");
      ((StringBuilder)localObject).append(paramMediaType);
      throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString()));
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\0000\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\020\022\n\002\b\007\n\002\020\002\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\002\b\002\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\035\020\r\032\0020\016*\0060\017j\002`\0202\006\020\021\032\0020\022H\000¢\006\002\b\023R\020\020\003\032\0020\0048\006X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\006X\004¢\006\002\n\000R\016\020\b\032\0020\006X\004¢\006\002\n\000R\020\020\t\032\0020\0048\006X\004¢\006\002\n\000R\020\020\n\032\0020\0048\006X\004¢\006\002\n\000R\020\020\013\032\0020\0048\006X\004¢\006\002\n\000R\020\020\f\032\0020\0048\006X\004¢\006\002\n\000¨\006\024"}, d2={"Lokhttp3/MultipartBody$Companion;", "", "()V", "ALTERNATIVE", "Lokhttp3/MediaType;", "COLONSPACE", "", "CRLF", "DASHDASH", "DIGEST", "FORM", "MIXED", "PARALLEL", "appendQuotedString", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "key", "", "appendQuotedString$okhttp", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    public final void appendQuotedString$okhttp(StringBuilder paramStringBuilder, String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramStringBuilder, "$this$appendQuotedString");
      Intrinsics.checkParameterIsNotNull(paramString, "key");
      paramStringBuilder.append('"');
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        char c = paramString.charAt(i);
        if (c == '\n') {
          paramStringBuilder.append("%0A");
        } else if (c == '\r') {
          paramStringBuilder.append("%0D");
        } else if (c == '"') {
          paramStringBuilder.append("%22");
        } else {
          paramStringBuilder.append(c);
        }
        i += 1;
      }
      paramStringBuilder.append('"');
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\030\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\007\030\000 \0132\0020\001:\001\013B\031\b\002\022\b\020\002\032\004\030\0010\003\022\006\020\004\032\0020\005¢\006\002\020\006J\r\020\004\032\0020\005H\007¢\006\002\b\tJ\017\020\002\032\004\030\0010\003H\007¢\006\002\b\nR\023\020\004\032\0020\0058\007¢\006\b\n\000\032\004\b\004\020\007R\025\020\002\032\004\030\0010\0038\007¢\006\b\n\000\032\004\b\002\020\b¨\006\f"}, d2={"Lokhttp3/MultipartBody$Part;", "", "headers", "Lokhttp3/Headers;", "body", "Lokhttp3/RequestBody;", "(Lokhttp3/Headers;Lokhttp3/RequestBody;)V", "()Lokhttp3/RequestBody;", "()Lokhttp3/Headers;", "-deprecated_body", "-deprecated_headers", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Part
  {
    public static final Companion Companion = new Companion(null);
    private final RequestBody body;
    private final Headers headers;
    
    private Part(Headers paramHeaders, RequestBody paramRequestBody)
    {
      this.headers = paramHeaders;
      this.body = paramRequestBody;
    }
    
    @JvmStatic
    public static final Part create(Headers paramHeaders, RequestBody paramRequestBody)
    {
      return Companion.create(paramHeaders, paramRequestBody);
    }
    
    @JvmStatic
    public static final Part create(RequestBody paramRequestBody)
    {
      return Companion.create(paramRequestBody);
    }
    
    @JvmStatic
    public static final Part createFormData(String paramString1, String paramString2)
    {
      return Companion.createFormData(paramString1, paramString2);
    }
    
    @JvmStatic
    public static final Part createFormData(String paramString1, String paramString2, RequestBody paramRequestBody)
    {
      return Companion.createFormData(paramString1, paramString2, paramRequestBody);
    }
    
    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="body", imports={}))
    public final RequestBody -deprecated_body()
    {
      return this.body;
    }
    
    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="headers", imports={}))
    public final Headers -deprecated_headers()
    {
      return this.headers;
    }
    
    public final RequestBody body()
    {
      return this.body;
    }
    
    public final Headers headers()
    {
      return this.headers;
    }
    
    @Metadata(bv={1, 0, 3}, d1={"\000(\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\003\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\032\020\003\032\0020\0042\b\020\005\032\004\030\0010\0062\006\020\007\032\0020\bH\007J\020\020\003\032\0020\0042\006\020\007\032\0020\bH\007J\030\020\t\032\0020\0042\006\020\n\032\0020\0132\006\020\f\032\0020\013H\007J\"\020\t\032\0020\0042\006\020\n\032\0020\0132\b\020\r\032\004\030\0010\0132\006\020\007\032\0020\bH\007¨\006\016"}, d2={"Lokhttp3/MultipartBody$Part$Companion;", "", "()V", "create", "Lokhttp3/MultipartBody$Part;", "headers", "Lokhttp3/Headers;", "body", "Lokhttp3/RequestBody;", "createFormData", "name", "", "value", "filename", "okhttp"}, k=1, mv={1, 1, 16})
    public static final class Companion
    {
      @JvmStatic
      public final MultipartBody.Part create(Headers paramHeaders, RequestBody paramRequestBody)
      {
        Intrinsics.checkParameterIsNotNull(paramRequestBody, "body");
        String str;
        if (paramHeaders != null) {
          str = paramHeaders.get("Content-Type");
        } else {
          str = null;
        }
        int j = 1;
        int i;
        if (str == null) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          if (paramHeaders != null) {
            str = paramHeaders.get("Content-Length");
          } else {
            str = null;
          }
          if (str == null) {
            i = j;
          } else {
            i = 0;
          }
          if (i != 0) {
            return new MultipartBody.Part(paramHeaders, paramRequestBody, null);
          }
          throw ((Throwable)new IllegalArgumentException("Unexpected header: Content-Length".toString()));
        }
        throw ((Throwable)new IllegalArgumentException("Unexpected header: Content-Type".toString()));
      }
      
      @JvmStatic
      public final MultipartBody.Part create(RequestBody paramRequestBody)
      {
        Intrinsics.checkParameterIsNotNull(paramRequestBody, "body");
        return ((Companion)this).create(null, paramRequestBody);
      }
      
      @JvmStatic
      public final MultipartBody.Part createFormData(String paramString1, String paramString2)
      {
        Intrinsics.checkParameterIsNotNull(paramString1, "name");
        Intrinsics.checkParameterIsNotNull(paramString2, "value");
        return ((Companion)this).createFormData(paramString1, null, RequestBody.Companion.create$default(RequestBody.Companion, paramString2, null, 1, null));
      }
      
      @JvmStatic
      public final MultipartBody.Part createFormData(String paramString1, String paramString2, RequestBody paramRequestBody)
      {
        Intrinsics.checkParameterIsNotNull(paramString1, "name");
        Intrinsics.checkParameterIsNotNull(paramRequestBody, "body");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("form-data; name=");
        MultipartBody.Companion.appendQuotedString$okhttp(localStringBuilder, paramString1);
        if (paramString2 != null)
        {
          localStringBuilder.append("; filename=");
          MultipartBody.Companion.appendQuotedString$okhttp(localStringBuilder, paramString2);
        }
        paramString1 = localStringBuilder.toString();
        Intrinsics.checkExpressionValueIsNotNull(paramString1, "StringBuilder().apply(builderAction).toString()");
        paramString1 = new Headers.Builder().addUnsafeNonAscii("Content-Disposition", paramString1).build();
        return ((Companion)this).create(paramString1, paramRequestBody);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\MultipartBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */