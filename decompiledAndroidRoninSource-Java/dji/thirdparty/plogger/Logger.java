package dji.thirdparty.plogger;

public final class Logger
{
  public static final int ASSERT = 7;
  public static final int DEBUG = 3;
  private static final String DEFAULT_TAG = "PRETTYLOGGER";
  public static final int ERROR = 6;
  public static final int INFO = 4;
  public static final int VERBOSE = 2;
  public static final int WARN = 5;
  private static LoggerPrinter printer = new LoggerPrinter();
  
  public static void d(Object paramObject)
  {
    printer.d(paramObject);
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    printer.d(paramString, paramVarArgs);
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    printer.e(null, paramString, paramVarArgs);
  }
  
  public static void e(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    printer.e(paramThrowable, paramString, paramVarArgs);
  }
  
  public static void i(String paramString, Object... paramVarArgs)
  {
    printer.i(paramString, paramVarArgs);
  }
  
  public static Settings init()
  {
    return init("PRETTYLOGGER");
  }
  
  public static Settings init(String paramString)
  {
    LoggerPrinter localLoggerPrinter = new LoggerPrinter();
    printer = localLoggerPrinter;
    return localLoggerPrinter.init(paramString);
  }
  
  public static void json(String paramString)
  {
    printer.json(paramString);
  }
  
  public static void log(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    printer.log(paramInt, paramString1, paramString2, paramThrowable);
  }
  
  public static void resetSettings()
  {
    printer.resetSettings();
  }
  
  public static Printer t(int paramInt)
  {
    return printer.t(null, paramInt);
  }
  
  public static Printer t(String paramString)
  {
    LoggerPrinter localLoggerPrinter = printer;
    return localLoggerPrinter.t(paramString, localLoggerPrinter.getSettings().getMethodCount());
  }
  
  public static Printer t(String paramString, int paramInt)
  {
    return printer.t(paramString, paramInt);
  }
  
  public static void v(String paramString, Object... paramVarArgs)
  {
    printer.v(paramString, paramVarArgs);
  }
  
  public static void w(String paramString, Object... paramVarArgs)
  {
    printer.w(paramString, paramVarArgs);
  }
  
  public static void wtf(String paramString, Object... paramVarArgs)
  {
    printer.wtf(paramString, paramVarArgs);
  }
  
  public static void xml(String paramString)
  {
    printer.xml(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\plogger\Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */