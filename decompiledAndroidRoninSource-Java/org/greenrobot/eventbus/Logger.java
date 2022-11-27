package org.greenrobot.eventbus;

import android.os.Looper;
import java.io.PrintStream;
import java.util.logging.Level;
import org.greenrobot.eventbus.android.AndroidLogger;

public abstract interface Logger
{
  public abstract void log(Level paramLevel, String paramString);
  
  public abstract void log(Level paramLevel, String paramString, Throwable paramThrowable);
  
  public static class Default
  {
    public static Logger get()
    {
      if ((AndroidLogger.isAndroidLogAvailable()) && (getAndroidMainLooperOrNull() != null)) {
        return new AndroidLogger("EventBus");
      }
      return new Logger.SystemOutLogger();
    }
    
    static Object getAndroidMainLooperOrNull()
    {
      try
      {
        Looper localLooper = Looper.getMainLooper();
        return localLooper;
      }
      catch (RuntimeException localRuntimeException)
      {
        for (;;) {}
      }
      return null;
    }
  }
  
  public static class JavaLogger
    implements Logger
  {
    protected final java.util.logging.Logger logger;
    
    public JavaLogger(String paramString)
    {
      this.logger = java.util.logging.Logger.getLogger(paramString);
    }
    
    public void log(Level paramLevel, String paramString)
    {
      this.logger.log(paramLevel, paramString);
    }
    
    public void log(Level paramLevel, String paramString, Throwable paramThrowable)
    {
      this.logger.log(paramLevel, paramString, paramThrowable);
    }
  }
  
  public static class SystemOutLogger
    implements Logger
  {
    public void log(Level paramLevel, String paramString)
    {
      PrintStream localPrintStream = System.out;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(paramLevel);
      localStringBuilder.append("] ");
      localStringBuilder.append(paramString);
      localPrintStream.println(localStringBuilder.toString());
    }
    
    public void log(Level paramLevel, String paramString, Throwable paramThrowable)
    {
      PrintStream localPrintStream = System.out;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(paramLevel);
      localStringBuilder.append("] ");
      localStringBuilder.append(paramString);
      localPrintStream.println(localStringBuilder.toString());
      paramThrowable.printStackTrace(System.out);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\greenrobot\eventbus\Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */