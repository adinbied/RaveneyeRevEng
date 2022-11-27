package dji.log;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.LinkedList;
import java.util.List;

public class DJILogHelper
  implements ComponentCallbacks2
{
  public static DJILogHelper INSTANCE;
  private static final long INTERVAL_TIME_PUT_TO_MEMORY = 100L;
  private static final int MSG_LOG_TO_CACHE = 0;
  private static final int TRANSACTION_MAX_SIZE = 200;
  private static final int TRANSACTION_SIZE = 20;
  private static String[] filterTag = new String[0];
  private DJILogConsolePrinter consolePrinter;
  private Controller controller;
  private long currentTimePutToMemory;
  private DJILogFileManager fileManager;
  private LogHandler handler;
  private DJILogWarnHandler mConsoleWarnHandler;
  private DJILogWarnHandler mFileManagerHandler;
  private List<Interceptor> mInterceptors;
  private List<DJILogEntry> memoryCache = new LinkedList();
  
  private boolean checkTagFilter(String paramString)
  {
    return false;
  }
  
  private void dispatchLog(int paramInt, String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    println(paramInt, paramString1, paramString2, paramThrowable, paramVarArgs);
  }
  
  /* Error */
  private void dispatchLogCache(int arg1, String arg2, String arg3, String arg4, Object... arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  private String getCachePath()
  {
    return getCachePath(null);
  }
  
  private String getCachePath(String paramString)
  {
    return null;
  }
  
  public static DJILogHelper getInstance()
  {
    try
    {
      if (INSTANCE == null)
      {
        localDJILogHelper = new DJILogHelper();
        INSTANCE = localDJILogHelper;
        localDJILogHelper.consolePrinter = new DJILogConsolePrinter();
        INSTANCE.fileManager = new DJILogFileManager();
      }
      DJILogHelper localDJILogHelper = INSTANCE;
      return localDJILogHelper;
    }
    finally {}
  }
  
  /* Error */
  private void initLogHelper(Context arg1, DJILogFileConfig arg2, DJILogConsoleConfig arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void initManagers(Context arg1, DJILogFileConfig arg2, DJILogConsoleConfig arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void nfzSaveCrashInfo2File(String paramString)
  {
    saveExtraLog(paramString, "NFZ");
  }
  
  private DJILogEntry obtainLogEntry(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    return null;
  }
  
  /* Error */
  private void println(int arg1, String arg2, String arg3, Throwable arg4, Object... arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  /* Error */
  private void putLogCacheToMemory(DJILogEntry arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void LOGD(String paramString1, String paramString2)
  {
    d(paramString1, paramString2, new Object[0]);
  }
  
  /* Error */
  public void LOGD(String arg1, String arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void LOGD(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (checkTagFilter(paramString1)) {
      return;
    }
    d(paramString1, paramString2, new Object[0]);
    if (paramBoolean1) {
      saveLog(paramString2);
    }
  }
  
  public void LOGE(String paramString1, String paramString2)
  {
    e(paramString1, paramString2, new Object[0]);
  }
  
  /* Error */
  public void LOGE(String arg1, String arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void LOGE(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (checkTagFilter(paramString1)) {
      return;
    }
    e(paramString1, paramString2, new Object[0]);
    if (paramBoolean1) {
      saveLog(paramString2);
    }
  }
  
  public void LOGI(String paramString1, String paramString2)
  {
    i(paramString1, paramString2, new Object[0]);
  }
  
  /* Error */
  public void LOGI(String arg1, String arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void LOGI(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (checkTagFilter(paramString1)) {
      return;
    }
    i(paramString1, paramString2, new Object[0]);
    if (paramBoolean1) {
      saveLog(paramString2);
    }
  }
  
  public void NFZSavedLOGE(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (controller().print) {
      Log.e(paramString1, paramString2);
    }
    if (paramBoolean1) {
      nfzSaveCrashInfo2File(paramString2);
    }
  }
  
  void addInterceptors(Interceptor paramInterceptor)
  {
    List localList = this.mInterceptors;
    if (localList != null) {
      localList.add(paramInterceptor);
    }
  }
  
  /* Error */
  public void autoHandle()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void closeLog() {}
  
  Controller controller()
  {
    return null;
  }
  
  /* Error */
  void d(String arg1, String arg2, Throwable arg3, Object... arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void d(String arg1, String arg2, Object... arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void e(String arg1, String arg2, Throwable arg3, Object... arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void e(String arg1, String arg2, Object... arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void flush()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String getLogName()
  {
    return this.fileManager.generateFileName();
  }
  
  public String getLogParentDir()
  {
    return getCachePath();
  }
  
  long[] getPriorityRatio()
  {
    return null;
  }
  
  String getRootDirectory()
  {
    return this.fileManager.getRootDirectory();
  }
  
  /* Error */
  void i(String arg1, String arg2, Throwable arg3, Object... arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void i(String arg1, String arg2, Object... arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  void init(Context paramContext)
  {
    init(paramContext, null, null);
  }
  
  /* Error */
  void init(Context arg1, DJILogFileConfig arg2, DJILogConsoleConfig arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void logNoVideoData()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  Controller newController()
  {
    return new Controller();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onLowMemory() {}
  
  public void onTrimMemory(int paramInt)
  {
    flush();
  }
  
  /* Error */
  void println(int arg1, String arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void removeInterceptors(Interceptor arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  void saveExtraLog(String paramString1, String paramString2)
  {
    saveExtraLog("DJIGo", paramString1, paramString2);
  }
  
  /* Error */
  void saveExtraLog(String arg1, String arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void saveLog(int arg1, String arg2, String arg3, String arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  void saveLog(String paramString)
  {
    saveLog(paramString, null);
  }
  
  void saveLog(String paramString1, String paramString2)
  {
    saveLog("DJIGo", paramString1, paramString2);
  }
  
  void saveLog(String paramString1, String paramString2, String paramString3)
  {
    saveLog(3, paramString1, paramString2, paramString3);
  }
  
  void setController(Controller paramController)
  {
    this.controller = paramController;
  }
  
  void showView(String paramString)
  {
    boolean bool = controller().print;
  }
  
  /* Error */
  void v(String arg1, String arg2, Throwable arg3, Object... arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void v(String arg1, String arg2, Object... arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void w(String arg1, String arg2, Throwable arg3, Object... arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void w(String arg1, String arg2, Object... arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void writeMapLog(String paramString)
  {
    saveExtraLog(paramString, "MAP");
  }
  
  private class LogHandler
    extends Handler
  {
    public LogHandler(Looper paramLooper)
    {
      super();
    }
    
    /* Error */
    public void handleMessage(android.os.Message arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\log\DJILogHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */