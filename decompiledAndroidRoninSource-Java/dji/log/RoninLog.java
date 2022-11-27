package dji.log;

import android.content.Context;

public class RoninLog
{
  public static void addInterceptor(Interceptor paramInterceptor)
  {
    DJILog.addInterceptor(paramInterceptor);
  }
  
  public static Controller controller()
  {
    return DJILog.controller();
  }
  
  public static void countTime(String paramString, DJILog.Callback paramCallback)
  {
    DJILog.countTime(paramString, paramCallback);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    DJILog.d(paramString1, paramString2, paramThrowable, paramVarArgs);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    DJILog.d(paramString1, paramString2, paramVarArgs);
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    DJILog.d(paramString, paramVarArgs);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    DJILog.e(paramString1, paramString2, paramThrowable, paramVarArgs);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    DJILog.e(paramString1, paramString2, paramVarArgs);
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    DJILog.e(paramString, paramVarArgs);
  }
  
  public static void endTimes(int paramInt)
  {
    DJILog.endTimes(paramInt);
  }
  
  public static void flush() {}
  
  public static String formatObject(Object paramObject)
  {
    return DJILog.formatObject(paramObject);
  }
  
  public static String getRootDirectory()
  {
    return DJILog.getRootDirectory();
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    DJILog.i(paramString1, paramString2, paramThrowable, paramVarArgs);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    DJILog.i(paramString1, paramString2, paramVarArgs);
  }
  
  public static void i(String paramString, Object... paramVarArgs)
  {
    DJILog.i(paramString, paramVarArgs);
  }
  
  public static void init(Context paramContext)
  {
    DJILog.init(paramContext);
  }
  
  public static void init(Context paramContext, DJILogFileConfig paramDJILogFileConfig, DJILogConsoleConfig paramDJILogConsoleConfig)
  {
    DJILog.init(paramContext, paramDJILogFileConfig, paramDJILogConsoleConfig);
  }
  
  public static void interval() {}
  
  public static void json(int paramInt, String paramString1, String paramString2)
  {
    DJILog.json(paramInt, paramString1, paramString2);
  }
  
  public static void json(String paramString)
  {
    DJILog.json(paramString);
  }
  
  public static void logSaveStack(String paramString1, Thread paramThread, String paramString2)
  {
    DJILog.logSaveStack(paramString1, paramThread, paramString2);
  }
  
  public static void logStack() {}
  
  public static void logStack(int paramInt)
  {
    DJILog.logStack(paramInt);
  }
  
  public static void logStack(String paramString, int paramInt)
  {
    DJILog.logStack(paramString, paramInt);
  }
  
  public static void logWriteD(String paramString1, String paramString2, String paramString3, Object... paramVarArgs)
  {
    DJILog.logWriteD(paramString1, paramString2, paramString3, paramVarArgs);
  }
  
  public static void logWriteD(String paramString1, String paramString2, Object... paramVarArgs)
  {
    DJILog.logWriteD(paramString1, paramString2, paramVarArgs);
  }
  
  public static void logWriteE(String paramString1, String paramString2, String paramString3, Object... paramVarArgs)
  {
    DJILog.logWriteE(paramString1, paramString2, paramString3, paramVarArgs);
  }
  
  public static void logWriteE(String paramString1, String paramString2, Object... paramVarArgs)
  {
    DJILog.logWriteE(paramString1, paramString2, paramVarArgs);
  }
  
  public static void logWriteI(String paramString1, String paramString2, String paramString3, Object... paramVarArgs)
  {
    DJILog.logWriteI(paramString1, paramString2, paramString3, paramVarArgs);
  }
  
  public static void logWriteI(String paramString1, String paramString2, Object... paramVarArgs)
  {
    DJILog.logWriteI(paramString1, paramString2, paramVarArgs);
  }
  
  public static void logWriteV(String paramString1, String paramString2, String paramString3, Object... paramVarArgs)
  {
    DJILog.logWriteV(paramString1, paramString2, paramString3, paramVarArgs);
  }
  
  public static void logWriteV(String paramString1, String paramString2, Object... paramVarArgs)
  {
    DJILog.logWriteV(paramString1, paramString2, paramVarArgs);
  }
  
  public static void logWriteW(String paramString1, String paramString2, String paramString3, Object... paramVarArgs)
  {
    DJILog.logWriteW(paramString1, paramString2, paramString3, paramVarArgs);
  }
  
  public static void logWriteW(String paramString1, String paramString2, Object... paramVarArgs)
  {
    DJILog.logWriteW(paramString1, paramString2, paramVarArgs);
  }
  
  public static Controller newController()
  {
    return DJILog.newController();
  }
  
  public static void object(int paramInt, String paramString, Object paramObject)
  {
    DJILog.object(paramInt, paramString, paramObject);
  }
  
  public static void object(Object paramObject)
  {
    DJILog.object(paramObject);
  }
  
  public static void object(String paramString, Object paramObject)
  {
    DJILog.object(paramString, paramObject);
  }
  
  public static void removeInterceptor(Interceptor paramInterceptor)
  {
    DJILog.removeInterceptor(paramInterceptor);
  }
  
  public static void saveLog(String paramString)
  {
    DJILog.saveLog(paramString);
  }
  
  public static void saveLog(String paramString1, String paramString2)
  {
    DJILog.saveLog(paramString1, paramString2);
  }
  
  public static void saveStack(String paramString)
  {
    DJILog.saveStack(paramString);
  }
  
  public static void saveStack(String paramString, int paramInt)
  {
    DJILog.saveStack(paramString, paramInt);
  }
  
  public static void setController(Controller paramController)
  {
    DJILog.setController(paramController);
  }
  
  public static void showView(String paramString)
  {
    DJILog.showView(paramString);
  }
  
  public static void startTime(int paramInt)
  {
    DJILog.startTime(paramInt);
  }
  
  public static void v(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    DJILog.v(paramString1, paramString2, paramThrowable, paramVarArgs);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    DJILog.v(paramString1, paramString2, paramVarArgs);
  }
  
  public static void v(String paramString, Object... paramVarArgs)
  {
    DJILog.v(paramString, paramVarArgs);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    DJILog.w(paramString1, paramString2, paramThrowable, paramVarArgs);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    DJILog.w(paramString1, paramString2, paramVarArgs);
  }
  
  public static void w(String paramString, Object... paramVarArgs)
  {
    DJILog.w(paramString, paramVarArgs);
  }
  
  public static void xml(int paramInt, String paramString1, String paramString2)
  {
    DJILog.xml(paramInt, paramString1, paramString2);
  }
  
  public static void xml(String paramString)
  {
    DJILog.xml(paramString);
  }
  
  public static void xml(String paramString1, String paramString2)
  {
    DJILog.xml(paramString1, paramString2);
  }
  
  public static abstract interface Callback
  {
    public abstract void doMethod();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\log\RoninLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */