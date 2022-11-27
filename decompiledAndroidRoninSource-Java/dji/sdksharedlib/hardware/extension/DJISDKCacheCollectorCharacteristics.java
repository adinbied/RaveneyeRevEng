package dji.sdksharedlib.hardware.extension;

import android.os.Handler;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheKeyCharacteristics;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheUpdateType;
import dji.sdksharedlib.util.DJISDKCacheThreadManager;
import java.util.ArrayList;
import java.util.HashMap;

public class DJISDKCacheCollectorCharacteristics
  extends DJISDKCacheKeyCharacteristics
{
  private static final String TAG = "DJISDKCacheCollectorCharacteristics";
  private static Handler operationHandler = new Handler(DJISDKCacheThreadManager.getSingletonBackgroundLooper());
  public String defaultTimerScheduleTag;
  private HashMap<DJISDKCacheKeyCharacteristics, ArrayList<DJISDKCacheHWAbstraction.InnerCallback>> operations = new HashMap();
  
  public DJISDKCacheCollectorCharacteristics(String paramString, int paramInt, DJISDKCacheUpdateType paramDJISDKCacheUpdateType, Class paramClass)
  {
    super(paramString, paramInt, paramDJISDKCacheUpdateType, new Class[] { paramClass });
  }
  
  public HashMap<DJISDKCacheKeyCharacteristics, ArrayList<DJISDKCacheHWAbstraction.InnerCallback>> getOperations()
  {
    return this.operations;
  }
  
  public void removeAllOperation()
  {
    HashMap localHashMap = this.operations;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  /* Error */
  public void requestGet(DJISDKCacheKeyCharacteristics arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private class RequestGet
    implements Runnable
  {
    private DJISDKCacheHWAbstraction.InnerCallback callback;
    private DJISDKCacheKeyCharacteristics cha;
    
    public RequestGet(DJISDKCacheKeyCharacteristics paramDJISDKCacheKeyCharacteristics, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
    {
      this.cha = paramDJISDKCacheKeyCharacteristics;
      this.callback = paramInnerCallback;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\extension\DJISDKCacheCollectorCharacteristics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */