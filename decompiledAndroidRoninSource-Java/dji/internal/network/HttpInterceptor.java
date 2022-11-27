package dji.internal.network;

import dji.thirdparty.okhttp3.Headers;
import dji.thirdparty.okhttp3.Interceptor;
import dji.thirdparty.okhttp3.Interceptor.Chain;
import dji.thirdparty.okhttp3.Response;
import dji.thirdparty.okio.Buffer;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public final class HttpInterceptor
  implements Interceptor
{
  private static final Charset UTF8 = Charset.forName("UTF-8");
  private List<Header> commonHeaderList;
  private volatile Level level = Level.NONE;
  private final Logger logger;
  
  public HttpInterceptor()
  {
    this(Logger.DEFAULT);
  }
  
  public HttpInterceptor(Logger paramLogger)
  {
    this.logger = paramLogger;
    this.commonHeaderList = new ArrayList();
  }
  
  private boolean bodyEncoded(Headers paramHeaders)
  {
    return false;
  }
  
  private static boolean isPlaintext(Buffer paramBuffer)
    throws EOFException
  {
    for (;;)
    {
      try
      {
        Buffer localBuffer = new Buffer();
        if (paramBuffer.size() < 64L)
        {
          l = paramBuffer.size();
          paramBuffer.copyTo(localBuffer, 0L, l);
          int i = 0;
          if ((i < 16) && (!localBuffer.exhausted()))
          {
            int j = localBuffer.readUtf8CodePoint();
            if (Character.isISOControl(j))
            {
              boolean bool = Character.isWhitespace(j);
              if (!bool) {
                return false;
              }
            }
            i += 1;
            continue;
          }
          return true;
        }
      }
      catch (EOFException paramBuffer)
      {
        return false;
      }
      long l = 64L;
    }
  }
  
  /* Error */
  public void addHeader(String arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Level getLevel()
  {
    return this.level;
  }
  
  public Response intercept(Interceptor.Chain paramChain)
    throws IOException
  {
    return null;
  }
  
  public HttpInterceptor setLevel(Level paramLevel)
  {
    return null;
  }
  
  private class Header
  {
    String name;
    String value;
    
    public Header(String paramString1, String paramString2)
    {
      this.name = paramString1;
      this.value = paramString2;
    }
  }
  
  public static enum Level
  {
    static
    {
      BASIC = new Level("BASIC", 1);
      HEADERS = new Level("HEADERS", 2);
      Level localLevel = new Level("BODY", 3);
      BODY = localLevel;
      $VALUES = new Level[] { NONE, BASIC, HEADERS, localLevel };
    }
    
    private Level() {}
  }
  
  public static abstract interface Logger
  {
    public static final Logger DEFAULT = new Logger()
    {
      /* Error */
      public void log(String arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    };
    
    public abstract void log(String paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\network\HttpInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */