package dji.thirdparty.okhttp3;

import dji.thirdparty.okhttp3.internal.Util;
import dji.thirdparty.okio.BufferedSink;
import dji.thirdparty.okio.ByteString;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public abstract class RequestBody
{
  public static RequestBody create(MediaType paramMediaType, final ByteString paramByteString)
  {
    new RequestBody()
    {
      public long contentLength()
        throws IOException
      {
        return paramByteString.size();
      }
      
      public MediaType contentType()
      {
        return this.val$contentType;
      }
      
      public void writeTo(BufferedSink paramAnonymousBufferedSink)
        throws IOException
      {
        paramAnonymousBufferedSink.write(paramByteString);
      }
    };
  }
  
  public static RequestBody create(MediaType paramMediaType, final File paramFile)
  {
    if (paramFile != null) {
      new RequestBody()
      {
        public long contentLength()
        {
          return paramFile.length();
        }
        
        public MediaType contentType()
        {
          return this.val$contentType;
        }
        
        /* Error */
        public void writeTo(BufferedSink arg1)
          throws IOException
        {
          // Byte code:
          //   0: return
          //   1: astore_1
          //   2: return
        }
      };
    }
    throw new NullPointerException("content == null");
  }
  
  public static RequestBody create(MediaType paramMediaType, String paramString)
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
    return create((MediaType)localObject2, paramString.getBytes((Charset)localObject1));
  }
  
  public static RequestBody create(MediaType paramMediaType, byte[] paramArrayOfByte)
  {
    return create(paramMediaType, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static RequestBody create(MediaType paramMediaType, final byte[] paramArrayOfByte, final int paramInt1, final int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
      new RequestBody()
      {
        public long contentLength()
        {
          return paramInt2;
        }
        
        public MediaType contentType()
        {
          return this.val$contentType;
        }
        
        /* Error */
        public void writeTo(BufferedSink arg1)
          throws IOException
        {
          // Byte code:
          //   0: return
          //   1: astore_1
          //   2: goto -2 -> 0
        }
      };
    }
    throw new NullPointerException("content == null");
  }
  
  public long contentLength()
    throws IOException
  {
    return -1L;
  }
  
  public abstract MediaType contentType();
  
  public abstract void writeTo(BufferedSink paramBufferedSink)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\RequestBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */