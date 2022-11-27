package dji.thirdparty.okhttp3;

import dji.thirdparty.okhttp3.internal.Util;
import dji.thirdparty.okio.Buffer;
import dji.thirdparty.okio.BufferedSource;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.Charset;

public abstract class ResponseBody
  implements Closeable
{
  private Reader reader;
  
  private Charset charset()
  {
    return null;
  }
  
  public static ResponseBody create(MediaType paramMediaType, final long paramLong, BufferedSource paramBufferedSource)
  {
    if (paramBufferedSource != null) {
      new ResponseBody()
      {
        public long contentLength()
        {
          return paramLong;
        }
        
        public MediaType contentType()
        {
          return this.val$contentType;
        }
        
        public BufferedSource source()
        {
          return this.val$content;
        }
      };
    }
    throw new NullPointerException("source == null");
  }
  
  public static ResponseBody create(MediaType paramMediaType, String paramString)
  {
    Object localObject1 = Util.UTF_8;
    Object localObject2 = paramMediaType;
    if (paramMediaType != null)
    {
      Charset localCharset = paramMediaType.charset();
      localObject1 = localCharset;
      localObject2 = paramMediaType;
      if (localCharset == null)
      {
        localObject1 = Util.UTF_8;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramMediaType);
        ((StringBuilder)localObject2).append("; charset=utf-8");
        localObject2 = MediaType.parse(((StringBuilder)localObject2).toString());
      }
    }
    paramMediaType = new Buffer().writeString(paramString, (Charset)localObject1);
    return create((MediaType)localObject2, paramMediaType.size(), paramMediaType);
  }
  
  public static ResponseBody create(MediaType paramMediaType, byte[] paramArrayOfByte)
  {
    Buffer localBuffer = new Buffer().write(paramArrayOfByte);
    return create(paramMediaType, paramArrayOfByte.length, localBuffer);
  }
  
  public final InputStream byteStream()
  {
    return null;
  }
  
  public final byte[] bytes()
    throws IOException
  {
    return null;
  }
  
  public final Reader charStream()
  {
    return null;
  }
  
  public void close()
  {
    Util.closeQuietly(source());
  }
  
  public abstract long contentLength();
  
  public abstract MediaType contentType();
  
  public abstract BufferedSource source();
  
  public final String string()
    throws IOException
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\ResponseBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */