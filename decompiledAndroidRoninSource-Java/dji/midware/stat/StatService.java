package dji.midware.stat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import java.io.FileOutputStream;
import java.lang.ref.ReferenceQueue;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;

public class StatService
{
  public static final long BYTES_IN_MEGA = 1048576L;
  public static final int CPU_MEASURE_WINDOW = 1000;
  private static boolean DEBUG = false;
  public static boolean OPEN = false;
  private static boolean SHOW_ON_VIEW = false;
  public static final int STAT_WINDOW_MS = 10000;
  private static String TAG = "StatService";
  private static int c_decoder;
  private static int c_hub;
  private static int c_main;
  private static int c_preview;
  private static Context ctx;
  private static StatService instance;
  private static LinkedList objectSet = new LinkedList();
  private static ReferenceQueue q_decoder;
  private static ReferenceQueue q_hub;
  private static ReferenceQueue q_main;
  private static ReferenceQueue q_preview = new ReferenceQueue();
  private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.US);
  private SimpleDateFormat fileNameFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.US);
  private FileOutputStream fos;
  private Handler handler;
  private LinuxUtils linuxUtils = new LinuxUtils();
  private HashMap<String, StatBase> statSet = new HashMap();
  private HandlerThread thread = new HandlerThread("DJIStatService");
  
  static
  {
    q_hub = new ReferenceQueue();
    q_main = new ReferenceQueue();
    q_decoder = new ReferenceQueue();
  }
  
  private StatService()
  {
    if (!OPEN) {
      return;
    }
    initLogFile();
    this.thread.start();
    Handler localHandler = new Handler(this.thread.getLooper());
    this.handler = localHandler;
    localHandler.postDelayed(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    }, 10000L);
  }
  
  public static void destroyInstance()
  {
    try
    {
      if (instance != null) {
        instance.onDestroy();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static StatService getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new StatService();
      }
      StatService localStatService = instance;
      return localStatService;
    }
    finally {}
  }
  
  /* Error */
  private void initLogFile()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void onDestroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void saveAllEventToFile()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void saveProcessMemoryStat(StringBuilder arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void saveSystemMemoryStat(StringBuilder arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static void setContext(Context paramContext)
  {
    ctx = paramContext;
    getInstance();
  }
  
  /* Error */
  public void countActivity()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void postEvent(Class<? extends StatBase> arg1, String arg2, float arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\stat\StatService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */