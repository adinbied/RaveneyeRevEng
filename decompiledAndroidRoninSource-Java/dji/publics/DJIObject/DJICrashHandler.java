package dji.publics.DJIObject;

import android.content.Context;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class DJICrashHandler
  implements Thread.UncaughtExceptionHandler
{
  public static final String FINALIZER_WATCH_DOG_DAEMON = "FinalizerWatchDogDaemon";
  private static DJICrashHandler INSTANCE;
  private static final String LOG_RELATIVE_PATH = "/LOG/CRASH/";
  private static final String TAG = "DJICrashHandler";
  private Context context;
  private CrashCallback crashCallback;
  private String dirName;
  private SimpleDateFormat formatData = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.CHINA);
  private Thread.UncaughtExceptionHandler mDefaultHandler;
  
  public static DJICrashHandler getInstance()
  {
    try
    {
      if (INSTANCE == null) {
        INSTANCE = new DJICrashHandler();
      }
      DJICrashHandler localDJICrashHandler = INSTANCE;
      return localDJICrashHandler;
    }
    finally {}
  }
  
  /* Error */
  private void invokeCallback(Throwable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private String saveCrashInfo2File(Throwable paramThrowable)
  {
    return null;
  }
  
  public boolean handleException(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return false;
    }
    saveCrashInfo2File(paramThrowable);
    invokeCallback(paramThrowable);
    return true;
  }
  
  /* Error */
  public void init(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setCrashCallback(CrashCallback paramCrashCallback)
  {
    this.crashCallback = paramCrashCallback;
  }
  
  /* Error */
  public void uncaughtException(Thread arg1, Throwable arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static abstract interface CrashCallback
  {
    public abstract void onCallback(String paramString);
  }
  
  public static enum DJICrashEvent
  {
    static
    {
      DJICrashEvent localDJICrashEvent = new DJICrashEvent("Crashed", 0);
      Crashed = localDJICrashEvent;
      $VALUES = new DJICrashEvent[] { localDJICrashEvent };
    }
    
    private DJICrashEvent() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\DJIObject\DJICrashHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */