package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;
import okio.Source;

@Metadata(bv={1, 0, 3}, d1={"\000.\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\t\n\000\n\002\030\002\n\000\n\002\020\013\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\002\b\002\b&\030\000 \0162\0020\001:\001\016B\005¢\006\002\020\002J\b\020\003\032\0020\004H\026J\n\020\005\032\004\030\0010\006H&J\b\020\007\032\0020\bH\026J\b\020\t\032\0020\bH\026J\020\020\n\032\0020\0132\006\020\f\032\0020\rH&¨\006\017"}, d2={"Lokhttp3/RequestBody;", "", "()V", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "isDuplex", "", "isOneShot", "writeTo", "", "sink", "Lokio/BufferedSink;", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public abstract class RequestBody
{
  public static final Companion Companion = new Companion(null);
  
  @JvmStatic
  public static final RequestBody create(File paramFile, MediaType paramMediaType)
  {
    return Companion.create(paramFile, paramMediaType);
  }
  
  @JvmStatic
  public static final RequestBody create(String paramString, MediaType paramMediaType)
  {
    return Companion.create(paramString, paramMediaType);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'file' argument first to fix Java", replaceWith=@ReplaceWith(expression="file.asRequestBody(contentType)", imports={"okhttp3.RequestBody.Companion.asRequestBody"}))
  @JvmStatic
  public static final RequestBody create(MediaType paramMediaType, File paramFile)
  {
    return Companion.create(paramMediaType, paramFile);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toRequestBody(contentType)", imports={"okhttp3.RequestBody.Companion.toRequestBody"}))
  @JvmStatic
  public static final RequestBody create(MediaType paramMediaType, String paramString)
  {
    return Companion.create(paramMediaType, paramString);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toRequestBody(contentType)", imports={"okhttp3.RequestBody.Companion.toRequestBody"}))
  @JvmStatic
  public static final RequestBody create(MediaType paramMediaType, ByteString paramByteString)
  {
    return Companion.create(paramMediaType, paramByteString);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toRequestBody(contentType, offset, byteCount)", imports={"okhttp3.RequestBody.Companion.toRequestBody"}))
  @JvmStatic
  public static final RequestBody create(MediaType paramMediaType, byte[] paramArrayOfByte)
  {
    return Companion.create$default(Companion, paramMediaType, paramArrayOfByte, 0, 0, 12, null);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toRequestBody(contentType, offset, byteCount)", imports={"okhttp3.RequestBody.Companion.toRequestBody"}))
  @JvmStatic
  public static final RequestBody create(MediaType paramMediaType, byte[] paramArrayOfByte, int paramInt)
  {
    return Companion.create$default(Companion, paramMediaType, paramArrayOfByte, paramInt, 0, 8, null);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toRequestBody(contentType, offset, byteCount)", imports={"okhttp3.RequestBody.Companion.toRequestBody"}))
  @JvmStatic
  public static final RequestBody create(MediaType paramMediaType, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return Companion.create(paramMediaType, paramArrayOfByte, paramInt1, paramInt2);
  }
  
  @JvmStatic
  public static final RequestBody create(ByteString paramByteString, MediaType paramMediaType)
  {
    return Companion.create(paramByteString, paramMediaType);
  }
  
  @JvmStatic
  public static final RequestBody create(byte[] paramArrayOfByte)
  {
    return Companion.create$default(Companion, paramArrayOfByte, null, 0, 0, 7, null);
  }
  
  @JvmStatic
  public static final RequestBody create(byte[] paramArrayOfByte, MediaType paramMediaType)
  {
    return Companion.create$default(Companion, paramArrayOfByte, paramMediaType, 0, 0, 6, null);
  }
  
  @JvmStatic
  public static final RequestBody create(byte[] paramArrayOfByte, MediaType paramMediaType, int paramInt)
  {
    return Companion.create$default(Companion, paramArrayOfByte, paramMediaType, paramInt, 0, 4, null);
  }
  
  @JvmStatic
  public static final RequestBody create(byte[] paramArrayOfByte, MediaType paramMediaType, int paramInt1, int paramInt2)
  {
    return Companion.create(paramArrayOfByte, paramMediaType, paramInt1, paramInt2);
  }
  
  public long contentLength()
    throws IOException
  {
    return -1L;
  }
  
  public abstract MediaType contentType();
  
  public boolean isDuplex()
  {
    return false;
  }
  
  public boolean isOneShot()
  {
    return false;
  }
  
  public abstract void writeTo(BufferedSink paramBufferedSink)
    throws IOException;
  
  @Metadata(bv={1, 0, 3}, d1={"\0006\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\022\n\000\n\002\020\b\n\000\n\002\020\016\n\002\030\002\n\002\b\003\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\032\020\003\032\0020\0042\b\020\005\032\004\030\0010\0062\006\020\007\032\0020\bH\007J.\020\003\032\0020\0042\b\020\005\032\004\030\0010\0062\006\020\t\032\0020\n2\b\b\002\020\013\032\0020\f2\b\b\002\020\r\032\0020\fH\007J\032\020\003\032\0020\0042\b\020\005\032\004\030\0010\0062\006\020\t\032\0020\016H\007J\032\020\003\032\0020\0042\b\020\005\032\004\030\0010\0062\006\020\t\032\0020\017H\007J\035\020\020\032\0020\004*\0020\b2\n\b\002\020\005\032\004\030\0010\006H\007¢\006\002\b\003J1\020\021\032\0020\004*\0020\n2\n\b\002\020\005\032\004\030\0010\0062\b\b\002\020\013\032\0020\f2\b\b\002\020\r\032\0020\fH\007¢\006\002\b\003J\035\020\021\032\0020\004*\0020\0162\n\b\002\020\005\032\004\030\0010\006H\007¢\006\002\b\003J\035\020\021\032\0020\004*\0020\0172\n\b\002\020\005\032\004\030\0010\006H\007¢\006\002\b\003¨\006\022"}, d2={"Lokhttp3/RequestBody$Companion;", "", "()V", "create", "Lokhttp3/RequestBody;", "contentType", "Lokhttp3/MediaType;", "file", "Ljava/io/File;", "content", "", "offset", "", "byteCount", "", "Lokio/ByteString;", "asRequestBody", "toRequestBody", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    @JvmStatic
    public final RequestBody create(File paramFile, final MediaType paramMediaType)
    {
      Intrinsics.checkParameterIsNotNull(paramFile, "$this$asRequestBody");
      (RequestBody)new RequestBody()
      {
        public long contentLength()
        {
          return this.$this_asRequestBody.length();
        }
        
        public MediaType contentType()
        {
          return paramMediaType;
        }
        
        public void writeTo(BufferedSink paramAnonymousBufferedSink)
        {
          Intrinsics.checkParameterIsNotNull(paramAnonymousBufferedSink, "sink");
          Closeable localCloseable = (Closeable)Okio.source(this.$this_asRequestBody);
          Throwable localThrowable = (Throwable)null;
          try
          {
            paramAnonymousBufferedSink.writeAll((Source)localCloseable);
            CloseableKt.closeFinally(localCloseable, localThrowable);
            return;
          }
          finally
          {
            try
            {
              throw paramAnonymousBufferedSink;
            }
            finally
            {
              CloseableKt.closeFinally(localCloseable, paramAnonymousBufferedSink);
            }
          }
        }
      };
    }
    
    @JvmStatic
    public final RequestBody create(String paramString, MediaType paramMediaType)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "$this$toRequestBody");
      Object localObject1 = Charsets.UTF_8;
      Object localObject2 = paramMediaType;
      if (paramMediaType != null)
      {
        Object localObject3 = MediaType.charset$default(paramMediaType, null, 1, null);
        localObject1 = localObject3;
        localObject2 = paramMediaType;
        if (localObject3 == null)
        {
          localObject1 = Charsets.UTF_8;
          localObject2 = MediaType.Companion;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(paramMediaType);
          ((StringBuilder)localObject3).append("; charset=utf-8");
          localObject2 = ((MediaType.Companion)localObject2).parse(((StringBuilder)localObject3).toString());
        }
      }
      paramString = paramString.getBytes((Charset)localObject1);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).getBytes(charset)");
      return ((Companion)this).create(paramString, (MediaType)localObject2, 0, paramString.length);
    }
    
    @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'file' argument first to fix Java", replaceWith=@ReplaceWith(expression="file.asRequestBody(contentType)", imports={"okhttp3.RequestBody.Companion.asRequestBody"}))
    @JvmStatic
    public final RequestBody create(MediaType paramMediaType, File paramFile)
    {
      Intrinsics.checkParameterIsNotNull(paramFile, "file");
      return ((Companion)this).create(paramFile, paramMediaType);
    }
    
    @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toRequestBody(contentType)", imports={"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    public final RequestBody create(MediaType paramMediaType, String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "content");
      return ((Companion)this).create(paramString, paramMediaType);
    }
    
    @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toRequestBody(contentType)", imports={"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    public final RequestBody create(MediaType paramMediaType, ByteString paramByteString)
    {
      Intrinsics.checkParameterIsNotNull(paramByteString, "content");
      return ((Companion)this).create(paramByteString, paramMediaType);
    }
    
    @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toRequestBody(contentType, offset, byteCount)", imports={"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    public final RequestBody create(MediaType paramMediaType, byte[] paramArrayOfByte)
    {
      return create$default(this, paramMediaType, paramArrayOfByte, 0, 0, 12, null);
    }
    
    @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toRequestBody(contentType, offset, byteCount)", imports={"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    public final RequestBody create(MediaType paramMediaType, byte[] paramArrayOfByte, int paramInt)
    {
      return create$default(this, paramMediaType, paramArrayOfByte, paramInt, 0, 8, null);
    }
    
    @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toRequestBody(contentType, offset, byteCount)", imports={"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    public final RequestBody create(MediaType paramMediaType, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "content");
      return ((Companion)this).create(paramArrayOfByte, paramMediaType, paramInt1, paramInt2);
    }
    
    @JvmStatic
    public final RequestBody create(ByteString paramByteString, final MediaType paramMediaType)
    {
      Intrinsics.checkParameterIsNotNull(paramByteString, "$this$toRequestBody");
      (RequestBody)new RequestBody()
      {
        public long contentLength()
        {
          return this.$this_toRequestBody.size();
        }
        
        public MediaType contentType()
        {
          return paramMediaType;
        }
        
        public void writeTo(BufferedSink paramAnonymousBufferedSink)
        {
          Intrinsics.checkParameterIsNotNull(paramAnonymousBufferedSink, "sink");
          paramAnonymousBufferedSink.write(this.$this_toRequestBody);
        }
      };
    }
    
    @JvmStatic
    public final RequestBody create(byte[] paramArrayOfByte)
    {
      return create$default(this, paramArrayOfByte, null, 0, 0, 7, null);
    }
    
    @JvmStatic
    public final RequestBody create(byte[] paramArrayOfByte, MediaType paramMediaType)
    {
      return create$default(this, paramArrayOfByte, paramMediaType, 0, 0, 6, null);
    }
    
    @JvmStatic
    public final RequestBody create(byte[] paramArrayOfByte, MediaType paramMediaType, int paramInt)
    {
      return create$default(this, paramArrayOfByte, paramMediaType, paramInt, 0, 4, null);
    }
    
    @JvmStatic
    public final RequestBody create(byte[] paramArrayOfByte, final MediaType paramMediaType, final int paramInt1, final int paramInt2)
    {
      Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$toRequestBody");
      Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
      (RequestBody)new RequestBody()
      {
        public long contentLength()
        {
          return paramInt2;
        }
        
        public MediaType contentType()
        {
          return paramMediaType;
        }
        
        public void writeTo(BufferedSink paramAnonymousBufferedSink)
        {
          Intrinsics.checkParameterIsNotNull(paramAnonymousBufferedSink, "sink");
          paramAnonymousBufferedSink.write(this.$this_toRequestBody, paramInt1, paramInt2);
        }
      };
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\RequestBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */