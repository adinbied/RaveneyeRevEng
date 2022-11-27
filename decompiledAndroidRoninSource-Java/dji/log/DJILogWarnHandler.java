package dji.log;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class DJILogWarnHandler
{
  private static final String INVALID_EMPTY_KEY = "Empty";
  private static final int STATISTICS_INIT = 1;
  private static final int WARN_BORDER = 100;
  private static final int WARN_CONTENT_CUT_OUT_LENGTH = 20;
  private static final int WARN_KEY_LENGTH = 50;
  private static final int WARN_TIME_MILLIS = 1000;
  private Context context;
  public AtomicLong d = new AtomicLong();
  public AtomicLong e = new AtomicLong();
  private Handler handler;
  private ConcurrentHashMap<String, Integer> hashKeyStatistics = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> hashKeyTimeStatistics = new ConcurrentHashMap();
  public AtomicLong i = new AtomicLong();
  public AtomicLong v = new AtomicLong();
  public AtomicLong w = new AtomicLong();
  
  DJILogWarnHandler(Context paramContext)
  {
    this.context = paramContext.getApplicationContext();
    this.handler = new Handler(Looper.getMainLooper());
  }
  
  /* Error */
  private void consoleWarn(String arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void dispatchWarn(String arg1, String arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void emptyKeyWarn(String paramString1, String paramString2) {}
  
  /* Error */
  private void highFrequencyWarn(String arg1, String arg2, float arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void toastWarn(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void tooLongKeyWarn(String arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void handleWarnKey(String arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\log\DJILogWarnHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */