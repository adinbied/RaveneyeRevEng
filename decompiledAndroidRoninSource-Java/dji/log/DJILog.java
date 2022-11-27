package dji.log;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;

public class DJILog
{
  private static final int DEFAULT_ALL_STACK = 100;
  private static final int DEFAULT_START_STACK = 2;
  private static int intervalIndex = 999;
  private static SparseArray<Long> startTimes = new SparseArray(5);
  
  public static void addInterceptor(Interceptor paramInterceptor)
  {
    getLogHelper().addInterceptors(paramInterceptor);
  }
  
  public static Controller controller()
  {
    return getLogHelper().controller();
  }
  
  public static void countTime(String paramString, Callback paramCallback)
  {
    long l1 = System.currentTimeMillis();
    paramCallback.doMethod();
    long l2 = System.currentTimeMillis();
    paramCallback = new StringBuilder();
    paramCallback.append("execution time=");
    paramCallback.append((float)(l2 - l1) / 1000.0F);
    paramCallback.append("s");
    e(paramString, paramCallback.toString(), new Object[0]);
    d(paramString, DJILogUtils.getCurrentStack(2, 100), new Object[0]);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    getLogHelper().d(paramString1, paramString2, paramThrowable, paramVarArgs);
  }
  
  public static void d(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    DJILogHelper localDJILogHelper = DJILogHelper.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" : ");
    localStringBuilder.append(paramString2);
    localDJILogHelper.LOGD("DJIGo", localStringBuilder.toString(), paramBoolean1, paramBoolean2);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    getLogHelper().d(paramString1, paramString2, paramVarArgs);
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    d(DJILogUtils.obtainStackElementTag(), paramString, paramVarArgs);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    getLogHelper().e(paramString1, paramString2, paramThrowable, paramVarArgs);
  }
  
  public static void e(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    DJILogHelper.getInstance().LOGE(paramString1, paramString2, paramBoolean1, paramBoolean2);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    getLogHelper().e(paramString1, paramString2, paramVarArgs);
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    e(DJILogUtils.obtainStackElementTag(), paramString, paramVarArgs);
  }
  
  public static void endTimes(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CostTime index : ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", time : ");
    localStringBuilder.append(System.currentTimeMillis() - ((Long)startTimes.get(paramInt)).longValue());
    Log.d("CostTime", localStringBuilder.toString());
  }
  
  public static void endTimesFilter(int paramInt)
  {
    long l = System.currentTimeMillis() - ((Long)startTimes.get(paramInt)).longValue();
    if (l > 100L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CostTime index : ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", time : ");
      localStringBuilder.append(l);
      Log.d("CostTime", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("CostTime index : ");
      localStringBuilder.append(getCurrentStack());
      Log.d("CostTime", localStringBuilder.toString());
    }
  }
  
  public static String exceptionToString(Throwable paramThrowable)
  {
    return DJILogUtils.exceptionToString(paramThrowable);
  }
  
  public static void flush()
  {
    getLogHelper().flush();
  }
  
  public static String formatObject(Object paramObject)
  {
    return DJILogUtils.formatObject(paramObject);
  }
  
  public static String getCurrentStack()
  {
    return DJILogUtils.getCurrentStack();
  }
  
  private static DJILogHelper getLogHelper()
  {
    return DJILogHelper.getInstance();
  }
  
  private static long[] getPriorityRatio()
  {
    return getLogHelper().getPriorityRatio();
  }
  
  public static String getRootDirectory()
  {
    return getLogHelper().getRootDirectory();
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    getLogHelper().i(paramString1, paramString2, paramThrowable, paramVarArgs);
  }
  
  public static void i(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    DJILogHelper.getInstance().LOGI(paramString1, paramString2, paramBoolean1, paramBoolean2);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    getLogHelper().i(paramString1, paramString2, paramVarArgs);
  }
  
  public static void i(String paramString, Object... paramVarArgs)
  {
    i(DJILogUtils.obtainStackElementTag(), paramString, paramVarArgs);
  }
  
  public static void init(Context paramContext)
  {
    getLogHelper().init(paramContext);
  }
  
  public static void init(Context paramContext, DJILogFileConfig paramDJILogFileConfig, DJILogConsoleConfig paramDJILogConsoleConfig)
  {
    getLogHelper().init(paramContext, paramDJILogFileConfig, paramDJILogConsoleConfig);
  }
  
  public static void interval()
  {
    if (startTimes.get(intervalIndex) == null)
    {
      startTime(intervalIndex);
      return;
    }
    endTimesFilter(intervalIndex);
    startTime(intervalIndex);
  }
  
  public static void json(int paramInt, String paramString1, String paramString2)
  {
    getLogHelper().println(paramInt, paramString1, DJILogUtils.formatJson(paramString2));
  }
  
  public static void json(String paramString)
  {
    json(DJILogUtils.obtainStackElementTag(), paramString);
  }
  
  public static void json(String paramString1, String paramString2)
  {
    json(3, paramString1, paramString2);
  }
  
  public static void logSaveStack(String paramString1, Thread paramThread, String paramString2)
  {
    d(paramString1, DJILogUtils.getThreadStack(paramThread), new Object[0]);
    saveLog(paramString1, DJILogUtils.getThreadStack(paramThread), paramString2);
  }
  
  public static void logStack()
  {
    logStack(100);
  }
  
  public static void logStack(int paramInt)
  {
    logStack(DJILogUtils.obtainStackElementTag(), paramInt);
  }
  
  public static void logStack(String paramString, int paramInt)
  {
    d(paramString, DJILogUtils.getCurrentStack(2, paramInt), new Object[0]);
  }
  
  public static void logWriteD(String paramString1, String paramString2, String paramString3, Object... paramVarArgs)
  {
    d(paramString1, paramString2, paramVarArgs);
    saveLog(3, paramString1, DJILogUtils.formatMessage(paramString2, paramVarArgs), paramString3);
  }
  
  public static void logWriteD(String paramString1, String paramString2, Object... paramVarArgs)
  {
    logWriteD(paramString1, paramString2, null, paramVarArgs);
  }
  
  public static void logWriteE(String paramString1, String paramString2, String paramString3, Object... paramVarArgs)
  {
    e(paramString1, paramString2, paramVarArgs);
    saveLog(6, paramString1, DJILogUtils.formatMessage(paramString2, paramVarArgs), paramString3);
  }
  
  public static void logWriteE(String paramString1, String paramString2, Object... paramVarArgs)
  {
    logWriteE(paramString1, paramString2, null, paramVarArgs);
  }
  
  public static void logWriteI(String paramString1, String paramString2, String paramString3, Object... paramVarArgs)
  {
    i(paramString1, paramString2, paramVarArgs);
    saveLog(4, paramString1, DJILogUtils.formatMessage(paramString2, paramVarArgs), paramString3);
  }
  
  public static void logWriteI(String paramString1, String paramString2, Object... paramVarArgs)
  {
    logWriteI(paramString1, paramString2, null, paramVarArgs);
  }
  
  public static void logWriteV(String paramString1, String paramString2, String paramString3, Object... paramVarArgs)
  {
    v(paramString1, paramString2, paramVarArgs);
    saveLog(2, paramString1, DJILogUtils.formatMessage(paramString2, paramVarArgs), paramString3);
  }
  
  public static void logWriteV(String paramString1, String paramString2, Object... paramVarArgs)
  {
    logWriteV(paramString1, paramString2, null, paramVarArgs);
  }
  
  public static void logWriteW(String paramString1, String paramString2, String paramString3, Object... paramVarArgs)
  {
    w(paramString1, paramString2, paramVarArgs);
    saveLog(5, paramString1, DJILogUtils.formatMessage(paramString2, paramVarArgs), paramString3);
  }
  
  public static void logWriteW(String paramString1, String paramString2, Object... paramVarArgs)
  {
    logWriteW(paramString1, paramString2, null, paramVarArgs);
  }
  
  public static Controller newController()
  {
    return getLogHelper().newController();
  }
  
  public static void object(int paramInt, String paramString, Object paramObject)
  {
    getLogHelper().println(paramInt, paramString, DJILogUtils.formatObject(paramObject));
  }
  
  public static void object(Object paramObject)
  {
    object(DJILogUtils.obtainStackElementTag(), paramObject);
  }
  
  public static void object(String paramString, Object paramObject)
  {
    object(3, paramString, paramObject);
  }
  
  public static void removeInterceptor(Interceptor paramInterceptor)
  {
    getLogHelper().removeInterceptors(paramInterceptor);
  }
  
  public static void save(String paramString1, String paramString2)
  {
    logWriteI(paramString1, paramString2, paramString1, new Object[0]);
  }
  
  public static void saveAsync(String paramString1, String paramString2)
  {
    logWriteI(paramString1, paramString2, paramString1, new Object[0]);
  }
  
  public static void saveConnectDebug(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append(") ");
    localStringBuilder.append(paramString);
    logWriteI("ConnectDebug", localStringBuilder.toString(), "ConnectDebug", new Object[0]);
  }
  
  @Deprecated
  public static void saveExtraLog(String paramString1, String paramString2)
  {
    getLogHelper().saveExtraLog(paramString1, paramString2);
  }
  
  private static void saveExtraLog(String paramString1, String paramString2, String paramString3)
  {
    getLogHelper().saveExtraLog(paramString1, paramString2, paramString3);
  }
  
  private static void saveLog(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    getLogHelper().saveLog(paramInt, paramString1, paramString2, paramString3);
  }
  
  public static void saveLog(String paramString)
  {
    getLogHelper().saveLog(paramString);
  }
  
  public static void saveLog(String paramString1, String paramString2)
  {
    getLogHelper().saveLog(paramString1, paramString2);
  }
  
  private static void saveLog(String paramString1, String paramString2, String paramString3)
  {
    getLogHelper().saveLog(paramString1, paramString2, paramString3);
  }
  
  public static void saveStack(String paramString)
  {
    saveStack(paramString, 100);
  }
  
  public static void saveStack(String paramString, int paramInt)
  {
    saveStack("DJIGo", paramString, paramInt);
  }
  
  private static void saveStack(String paramString1, String paramString2, int paramInt)
  {
    saveLog(paramString1, DJILogUtils.getCurrentStack(2, paramInt), paramString2);
  }
  
  public static void setController(Controller paramController)
  {
    getLogHelper().setController(paramController);
  }
  
  public static void showView(String paramString)
  {
    getLogHelper().showView(paramString);
  }
  
  public static void startTime(int paramInt)
  {
    startTimes.put(paramInt, Long.valueOf(System.currentTimeMillis()));
  }
  
  public static void v(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    getLogHelper().v(paramString1, paramString2, paramThrowable, paramVarArgs);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    getLogHelper().v(paramString1, paramString2, paramVarArgs);
  }
  
  public static void v(String paramString, Object... paramVarArgs)
  {
    v(DJILogUtils.obtainStackElementTag(), paramString, paramVarArgs);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    getLogHelper().w(paramString1, paramString2, paramThrowable, paramVarArgs);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    getLogHelper().w(paramString1, paramString2, paramVarArgs);
  }
  
  public static void w(String paramString, Object... paramVarArgs)
  {
    w(DJILogUtils.obtainStackElementTag(), paramString, paramVarArgs);
  }
  
  public static void xml(int paramInt, String paramString1, String paramString2)
  {
    getLogHelper().println(paramInt, paramString1, DJILogUtils.formatXml(paramString2));
  }
  
  public static void xml(String paramString)
  {
    xml(DJILogUtils.obtainStackElementTag(), paramString);
  }
  
  public static void xml(String paramString1, String paramString2)
  {
    xml(3, paramString1, paramString2);
  }
  
  public static abstract interface Callback
  {
    public abstract void doMethod();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\log\DJILog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */