package dji.sdksharedlib.extension;

import dji.common.error.DJIError;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.sdksharedlib.listener.DJIGetCallback;
import dji.sdksharedlib.store.DJISDKCacheParamValue;

public class RepeatGet
  implements DJIGetCallback, Runnable
{
  public final String TAG = "RepeatGet";
  private DJIGetCallback callback;
  private int count;
  private DJISDKCacheKey key;
  private int repeatDelayTime;
  private int repeatInvoke = -1;
  private int repeatTime;
  private Runnable runnable = null;
  
  public RepeatGet(DJISDKCacheKey paramDJISDKCacheKey, int paramInt1, int paramInt2, DJIGetCallback paramDJIGetCallback)
  {
    this.key = paramDJISDKCacheKey;
    this.repeatTime = paramInt1;
    this.repeatDelayTime = paramInt2;
    this.callback = paramDJIGetCallback;
    this.count = 0;
  }
  
  public RepeatGet(DJISDKCacheKey paramDJISDKCacheKey, int paramInt, DJIGetCallback paramDJIGetCallback)
  {
    this.key = paramDJISDKCacheKey;
    this.repeatTime = paramInt;
    this.repeatDelayTime = 1000;
    this.callback = paramDJIGetCallback;
    this.count = 0;
  }
  
  public RepeatGet(DJISDKCacheKey paramDJISDKCacheKey, DJIGetCallback paramDJIGetCallback)
  {
    this.key = paramDJISDKCacheKey;
    this.repeatTime = 3;
    this.repeatDelayTime = 1000;
    this.callback = paramDJIGetCallback;
    this.count = 0;
  }
  
  /* Error */
  private void getFlycSnDemo()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void getFlycSnRepeatDemo()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onFails(DJIError arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onSuccess(DJISDKCacheParamValue paramDJISDKCacheParamValue)
  {
    DJIGetCallback localDJIGetCallback = this.callback;
    if (localDJIGetCallback != null) {
      localDJIGetCallback.onSuccess(paramDJISDKCacheParamValue);
    }
  }
  
  public void run()
  {
    start();
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\extension\RepeatGet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */