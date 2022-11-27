package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

@Metadata(bv={1, 0, 3}, d1={"\000b\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\022\n\002\b\002\n\002\030\002\n\000\n\002\020\002\n\002\b\002\n\002\020\000\n\000\n\002\030\002\n\002\030\002\n\000\n\002\020\b\n\002\b\002\n\002\020\t\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\003\b&\030\000 !2\0020\001:\002 !B\005¢\006\002\020\002J\006\020\005\032\0020\006J\006\020\007\032\0020\bJ\006\020\t\032\0020\nJ\006\020\013\032\0020\004J\b\020\f\032\0020\rH\002J\b\020\016\032\0020\017H\026J@\020\020\032\002H\021\"\b\b\000\020\021*\0020\0222\022\020\023\032\016\022\004\022\0020\025\022\004\022\002H\0210\0242\022\020\026\032\016\022\004\022\002H\021\022\004\022\0020\0270\024H\b¢\006\002\020\030J\b\020\031\032\0020\032H&J\n\020\033\032\004\030\0010\034H&J\b\020\035\032\0020\025H&J\006\020\036\032\0020\037R\020\020\003\032\004\030\0010\004X\016¢\006\002\n\000¨\006\""}, d2={"Lokhttp3/ResponseBody;", "Ljava/io/Closeable;", "()V", "reader", "Ljava/io/Reader;", "byteStream", "Ljava/io/InputStream;", "byteString", "Lokio/ByteString;", "bytes", "", "charStream", "charset", "Ljava/nio/charset/Charset;", "close", "", "consumeSource", "T", "", "consumer", "Lkotlin/Function1;", "Lokio/BufferedSource;", "sizeMapper", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "source", "string", "", "BomAwareReader", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public abstract class ResponseBody
  implements Closeable
{
  public static final Companion Companion = new Companion(null);
  private Reader reader;
  
  private final Charset charset()
  {
    Object localObject = contentType();
    if (localObject != null)
    {
      localObject = ((MediaType)localObject).charset(Charsets.UTF_8);
      if (localObject != null) {
        return (Charset)localObject;
      }
    }
    return Charsets.UTF_8;
  }
  
  private final <T> T consumeSource(Function1<? super BufferedSource, ? extends T> paramFunction1, Function1<? super T, Integer> paramFunction11)
  {
    long l = contentLength();
    if (l <= Integer.MAX_VALUE)
    {
      Closeable localCloseable = (Closeable)source();
      Throwable localThrowable = (Throwable)null;
      try
      {
        paramFunction1 = paramFunction1.invoke(localCloseable);
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(localCloseable, localThrowable);
        InlineMarker.finallyEnd(1);
        int i = ((Number)paramFunction11.invoke(paramFunction1)).intValue();
        if (l != -1L)
        {
          if (l == i) {
            return paramFunction1;
          }
          paramFunction1 = new StringBuilder();
          paramFunction1.append("Content-Length (");
          paramFunction1.append(l);
          paramFunction1.append(") and stream length (");
          paramFunction1.append(i);
          paramFunction1.append(") disagree");
          throw ((Throwable)new IOException(paramFunction1.toString()));
        }
        return paramFunction1;
      }
      finally
      {
        try
        {
          throw paramFunction1;
        }
        finally
        {
          InlineMarker.finallyStart(1);
          CloseableKt.closeFinally(localCloseable, paramFunction1);
          InlineMarker.finallyEnd(1);
        }
      }
    }
    paramFunction1 = new StringBuilder();
    paramFunction1.append("Cannot buffer entire body for content length: ");
    paramFunction1.append(l);
    throw ((Throwable)new IOException(paramFunction1.toString()));
  }
  
  @JvmStatic
  public static final ResponseBody create(String paramString, MediaType paramMediaType)
  {
    return Companion.create(paramString, paramMediaType);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.asResponseBody(contentType, contentLength)", imports={"okhttp3.ResponseBody.Companion.asResponseBody"}))
  @JvmStatic
  public static final ResponseBody create(MediaType paramMediaType, long paramLong, BufferedSource paramBufferedSource)
  {
    return Companion.create(paramMediaType, paramLong, paramBufferedSource);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toResponseBody(contentType)", imports={"okhttp3.ResponseBody.Companion.toResponseBody"}))
  @JvmStatic
  public static final ResponseBody create(MediaType paramMediaType, String paramString)
  {
    return Companion.create(paramMediaType, paramString);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toResponseBody(contentType)", imports={"okhttp3.ResponseBody.Companion.toResponseBody"}))
  @JvmStatic
  public static final ResponseBody create(MediaType paramMediaType, ByteString paramByteString)
  {
    return Companion.create(paramMediaType, paramByteString);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toResponseBody(contentType)", imports={"okhttp3.ResponseBody.Companion.toResponseBody"}))
  @JvmStatic
  public static final ResponseBody create(MediaType paramMediaType, byte[] paramArrayOfByte)
  {
    return Companion.create(paramMediaType, paramArrayOfByte);
  }
  
  @JvmStatic
  public static final ResponseBody create(BufferedSource paramBufferedSource, MediaType paramMediaType, long paramLong)
  {
    return Companion.create(paramBufferedSource, paramMediaType, paramLong);
  }
  
  @JvmStatic
  public static final ResponseBody create(ByteString paramByteString, MediaType paramMediaType)
  {
    return Companion.create(paramByteString, paramMediaType);
  }
  
  @JvmStatic
  public static final ResponseBody create(byte[] paramArrayOfByte, MediaType paramMediaType)
  {
    return Companion.create(paramArrayOfByte, paramMediaType);
  }
  
  public final InputStream byteStream()
  {
    return source().inputStream();
  }
  
  public final ByteString byteString()
    throws IOException
  {
    long l = contentLength();
    if (l <= Integer.MAX_VALUE)
    {
      localObject1 = (Closeable)source();
      Throwable localThrowable1 = (Throwable)null;
      try
      {
        ByteString localByteString = ((BufferedSource)localObject1).readByteString();
        CloseableKt.closeFinally((Closeable)localObject1, localThrowable1);
        int i = localByteString.size();
        if (l != -1L)
        {
          if (l == i) {
            return localByteString;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Content-Length (");
          ((StringBuilder)localObject1).append(l);
          ((StringBuilder)localObject1).append(") and stream length (");
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append(") disagree");
          throw ((Throwable)new IOException(((StringBuilder)localObject1).toString()));
        }
        return localByteString;
      }
      finally
      {
        try
        {
          throw localThrowable2;
        }
        finally
        {
          CloseableKt.closeFinally((Closeable)localObject1, localThrowable2);
        }
      }
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Cannot buffer entire body for content length: ");
    ((StringBuilder)localObject1).append(l);
    throw ((Throwable)new IOException(((StringBuilder)localObject1).toString()));
  }
  
  public final byte[] bytes()
    throws IOException
  {
    long l = contentLength();
    if (l <= Integer.MAX_VALUE)
    {
      localObject1 = (Closeable)source();
      Throwable localThrowable1 = (Throwable)null;
      try
      {
        byte[] arrayOfByte = ((BufferedSource)localObject1).readByteArray();
        CloseableKt.closeFinally((Closeable)localObject1, localThrowable1);
        int i = arrayOfByte.length;
        if (l != -1L)
        {
          if (l == i) {
            return arrayOfByte;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Content-Length (");
          ((StringBuilder)localObject1).append(l);
          ((StringBuilder)localObject1).append(") and stream length (");
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append(") disagree");
          throw ((Throwable)new IOException(((StringBuilder)localObject1).toString()));
        }
        return arrayOfByte;
      }
      finally
      {
        try
        {
          throw localThrowable2;
        }
        finally
        {
          CloseableKt.closeFinally((Closeable)localObject1, localThrowable2);
        }
      }
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Cannot buffer entire body for content length: ");
    ((StringBuilder)localObject1).append(l);
    throw ((Throwable)new IOException(((StringBuilder)localObject1).toString()));
  }
  
  public final Reader charStream()
  {
    Reader localReader = this.reader;
    if (localReader != null) {
      return localReader;
    }
    localReader = (Reader)new BomAwareReader(source(), charset());
    this.reader = localReader;
    return localReader;
  }
  
  public void close()
  {
    Util.closeQuietly((Closeable)source());
  }
  
  public abstract long contentLength();
  
  public abstract MediaType contentType();
  
  public abstract BufferedSource source();
  
  public final String string()
    throws IOException
  {
    Closeable localCloseable = (Closeable)source();
    Throwable localThrowable1 = (Throwable)null;
    try
    {
      Object localObject1 = (BufferedSource)localCloseable;
      localObject1 = ((BufferedSource)localObject1).readString(Util.readBomAsCharset((BufferedSource)localObject1, charset()));
      CloseableKt.closeFinally(localCloseable, localThrowable1);
      return (String)localObject1;
    }
    finally
    {
      try
      {
        throw localThrowable2;
      }
      finally
      {
        CloseableKt.closeFinally(localCloseable, localThrowable2);
      }
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\0004\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\002\n\002\020\002\n\000\n\002\020\b\n\000\n\002\020\031\n\002\b\003\b\000\030\0002\0020\001B\025\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005¢\006\002\020\006J\b\020\n\032\0020\013H\026J \020\f\032\0020\r2\006\020\016\032\0020\0172\006\020\020\032\0020\r2\006\020\021\032\0020\rH\026R\016\020\004\032\0020\005X\004¢\006\002\n\000R\016\020\007\032\0020\bX\016¢\006\002\n\000R\020\020\t\032\004\030\0010\001X\016¢\006\002\n\000R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\022"}, d2={"Lokhttp3/ResponseBody$BomAwareReader;", "Ljava/io/Reader;", "source", "Lokio/BufferedSource;", "charset", "Ljava/nio/charset/Charset;", "(Lokio/BufferedSource;Ljava/nio/charset/Charset;)V", "closed", "", "delegate", "close", "", "read", "", "cbuf", "", "off", "len", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class BomAwareReader
    extends Reader
  {
    private final Charset charset;
    private boolean closed;
    private Reader delegate;
    private final BufferedSource source;
    
    public BomAwareReader(BufferedSource paramBufferedSource, Charset paramCharset)
    {
      this.source = paramBufferedSource;
      this.charset = paramCharset;
    }
    
    public void close()
      throws IOException
    {
      this.closed = true;
      Reader localReader = this.delegate;
      if (localReader != null)
      {
        localReader.close();
        return;
      }
      ((BomAwareReader)this).source.close();
    }
    
    public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
      throws IOException
    {
      Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "cbuf");
      if (!this.closed)
      {
        Reader localReader = this.delegate;
        if (localReader == null)
        {
          localReader = (Reader)new InputStreamReader(this.source.inputStream(), Util.readBomAsCharset(this.source, this.charset));
          this.delegate = localReader;
        }
        return localReader.read(paramArrayOfChar, paramInt1, paramInt2);
      }
      throw ((Throwable)new IOException("Stream closed"));
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\0002\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\022\n\000\n\002\020\t\n\002\030\002\n\002\020\016\n\002\030\002\n\002\b\003\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\032\020\003\032\0020\0042\b\020\005\032\004\030\0010\0062\006\020\007\032\0020\bH\007J\"\020\003\032\0020\0042\b\020\005\032\004\030\0010\0062\006\020\t\032\0020\n2\006\020\007\032\0020\013H\007J\032\020\003\032\0020\0042\b\020\005\032\004\030\0010\0062\006\020\007\032\0020\fH\007J\032\020\003\032\0020\0042\b\020\005\032\004\030\0010\0062\006\020\007\032\0020\rH\007J'\020\016\032\0020\004*\0020\0132\n\b\002\020\005\032\004\030\0010\0062\b\b\002\020\t\032\0020\nH\007¢\006\002\b\003J\035\020\017\032\0020\004*\0020\b2\n\b\002\020\005\032\004\030\0010\006H\007¢\006\002\b\003J\035\020\017\032\0020\004*\0020\f2\n\b\002\020\005\032\004\030\0010\006H\007¢\006\002\b\003J\035\020\017\032\0020\004*\0020\r2\n\b\002\020\005\032\004\030\0010\006H\007¢\006\002\b\003¨\006\020"}, d2={"Lokhttp3/ResponseBody$Companion;", "", "()V", "create", "Lokhttp3/ResponseBody;", "contentType", "Lokhttp3/MediaType;", "content", "", "contentLength", "", "Lokio/BufferedSource;", "", "Lokio/ByteString;", "asResponseBody", "toResponseBody", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    @JvmStatic
    public final ResponseBody create(String paramString, MediaType paramMediaType)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "$this$toResponseBody");
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
      paramString = new Buffer().writeString(paramString, (Charset)localObject1);
      return ((Companion)this).create((BufferedSource)paramString, (MediaType)localObject2, paramString.size());
    }
    
    @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.asResponseBody(contentType, contentLength)", imports={"okhttp3.ResponseBody.Companion.asResponseBody"}))
    @JvmStatic
    public final ResponseBody create(MediaType paramMediaType, long paramLong, BufferedSource paramBufferedSource)
    {
      Intrinsics.checkParameterIsNotNull(paramBufferedSource, "content");
      return ((Companion)this).create(paramBufferedSource, paramMediaType, paramLong);
    }
    
    @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toResponseBody(contentType)", imports={"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @JvmStatic
    public final ResponseBody create(MediaType paramMediaType, String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "content");
      return ((Companion)this).create(paramString, paramMediaType);
    }
    
    @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toResponseBody(contentType)", imports={"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @JvmStatic
    public final ResponseBody create(MediaType paramMediaType, ByteString paramByteString)
    {
      Intrinsics.checkParameterIsNotNull(paramByteString, "content");
      return ((Companion)this).create(paramByteString, paramMediaType);
    }
    
    @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toResponseBody(contentType)", imports={"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @JvmStatic
    public final ResponseBody create(MediaType paramMediaType, byte[] paramArrayOfByte)
    {
      Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "content");
      return ((Companion)this).create(paramArrayOfByte, paramMediaType);
    }
    
    @JvmStatic
    public final ResponseBody create(BufferedSource paramBufferedSource, final MediaType paramMediaType, final long paramLong)
    {
      Intrinsics.checkParameterIsNotNull(paramBufferedSource, "$this$asResponseBody");
      (ResponseBody)new ResponseBody()
      {
        public long contentLength()
        {
          return paramLong;
        }
        
        public MediaType contentType()
        {
          return paramMediaType;
        }
        
        public BufferedSource source()
        {
          return this.$this_asResponseBody;
        }
      };
    }
    
    @JvmStatic
    public final ResponseBody create(ByteString paramByteString, MediaType paramMediaType)
    {
      Intrinsics.checkParameterIsNotNull(paramByteString, "$this$toResponseBody");
      return ((Companion)this).create((BufferedSource)new Buffer().write(paramByteString), paramMediaType, paramByteString.size());
    }
    
    @JvmStatic
    public final ResponseBody create(byte[] paramArrayOfByte, MediaType paramMediaType)
    {
      Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$toResponseBody");
      return ((Companion)this).create((BufferedSource)new Buffer().write(paramArrayOfByte), paramMediaType, paramArrayOfByte.length);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\ResponseBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */