package dji.thirdparty.okhttp3.internal.http;

import java.io.IOException;
import java.lang.reflect.Method;

public final class RouteException
  extends Exception
{
  private static final Method addSuppressedExceptionMethod;
  private IOException lastException;
  
  static
  {
    try
    {
      localMethod = Throwable.class.getDeclaredMethod("addSuppressed", new Class[] { Throwable.class });
    }
    catch (Exception localException)
    {
      Method localMethod;
      for (;;) {}
    }
    localMethod = null;
    addSuppressedExceptionMethod = localMethod;
  }
  
  public RouteException(IOException paramIOException)
  {
    super(paramIOException);
    this.lastException = paramIOException;
  }
  
  /* Error */
  private void addSuppressedIfPossible(IOException arg1, IOException arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void addConnectException(IOException paramIOException)
  {
    addSuppressedIfPossible(paramIOException, this.lastException);
    this.lastException = paramIOException;
  }
  
  public IOException getLastConnectException()
  {
    return this.lastException;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\http\RouteException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */