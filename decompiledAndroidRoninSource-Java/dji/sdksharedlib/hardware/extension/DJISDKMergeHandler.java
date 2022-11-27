package dji.sdksharedlib.hardware.extension;

import android.os.Handler;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction;
import dji.sdksharedlib.util.DJISDKCacheThreadManager;
import java.util.HashMap;

public class DJISDKMergeHandler
{
  private static final String TAG = "DJISDKMergeHandler";
  private Handler handler;
  private HashMap<String, DJISDKMergeSignal> signalHashMap;
  
  public DJISDKMergeHandler()
  {
    DJISDKCacheThreadManager.getInstance();
    this.handler = new Handler(DJISDKCacheThreadManager.getSingletonBackgroundLooper());
    this.signalHashMap = new HashMap();
  }
  
  /* Error */
  private void removeSignal(DJISDKMergeSignal arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void addSignal(DJISDKMergeSignal arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static class DJISDKMergeSignal
    implements Runnable
  {
    public DJISDKCacheHWAbstraction abstraction;
    public DJISDKCacheCollectorCharacteristics characteristics;
    
    public DJISDKMergeSignal(DJISDKCacheHWAbstraction paramDJISDKCacheHWAbstraction, DJISDKCacheCollectorCharacteristics paramDJISDKCacheCollectorCharacteristics)
    {
      this.abstraction = paramDJISDKCacheHWAbstraction;
      this.characteristics = paramDJISDKCacheCollectorCharacteristics;
    }
    
    /* Error */
    private void handleOnFailureCallback(dji.common.error.DJISDKCacheError arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\extension\DJISDKMergeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */