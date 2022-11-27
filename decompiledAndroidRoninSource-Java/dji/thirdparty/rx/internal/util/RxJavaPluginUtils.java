package dji.thirdparty.rx.internal.util;

import dji.thirdparty.rx.plugins.RxJavaErrorHandler;
import dji.thirdparty.rx.plugins.RxJavaPlugins;
import java.io.PrintStream;

public final class RxJavaPluginUtils
{
  public static void handleException(Throwable paramThrowable)
  {
    try
    {
      RxJavaPlugins.getInstance().getErrorHandler().handleError(paramThrowable);
      return;
    }
    finally
    {
      handlePluginException(paramThrowable);
    }
  }
  
  private static void handlePluginException(Throwable paramThrowable)
  {
    PrintStream localPrintStream = System.err;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RxJavaErrorHandler threw an Exception. It shouldn't. => ");
    localStringBuilder.append(paramThrowable.getMessage());
    localPrintStream.println(localStringBuilder.toString());
    paramThrowable.printStackTrace();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\util\RxJavaPluginUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */