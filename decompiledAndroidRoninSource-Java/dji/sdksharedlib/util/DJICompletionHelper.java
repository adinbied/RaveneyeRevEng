package dji.sdksharedlib.util;

import android.os.Handler;
import android.os.Looper;
import dji.midware.data.model.P3.DataOsdGetPushCommon;
import dji.midware.data.model.P3.DataOsdGetPushCommon.FLYC_STATE;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey.Builder;
import dji.sdksharedlib.listener.DJIParamAccessListener;
import dji.sdksharedlib.store.DJISDKCacheParamValue;

public class DJICompletionHelper
{
  private static final DJISDKCacheKey ALTITUDE_KEY = new DJISDKCacheKey.Builder().component("FlightController").paramKey("Altitude").build();
  private static final int REMOVE_LISTENER = 0;
  private static final String TAG = "DJICompletionHelper";
  private static DJICompletionHelper instance;
  private DefaultCompletionCallback cancelTakeOffCallback;
  private DataOsdGetPushCommon.FLYC_STATE currentFlycState;
  private Handler handler = new Handler(DJISDKCacheThreadManager.getSingletonBackgroundLooper())
  {
    /* Error */
    public void handleMessage(android.os.Message arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  private DataOsdGetPushCommon.FLYC_STATE lastFlycState = DataOsdGetPushCommon.FLYC_STATE.GoHome;
  private DefaultCompletionCallback takeOffCallback;
  final DJIParamAccessListener takeOffListener = new DJIParamAccessListener()
  {
    public void onValueChange(DJISDKCacheKey paramAnonymousDJISDKCacheKey, DJISDKCacheParamValue paramAnonymousDJISDKCacheParamValue1, DJISDKCacheParamValue paramAnonymousDJISDKCacheParamValue2)
    {
      if ((paramAnonymousDJISDKCacheParamValue2 != null) && (paramAnonymousDJISDKCacheParamValue2.isValid()))
      {
        DJICompletionHelper.access$002(DJICompletionHelper.this, DataOsdGetPushCommon.getInstance().getFlycState());
        if ((DJICompletionHelper.this.lastFlycState.equals(DataOsdGetPushCommon.FLYC_STATE.AutoTakeoff)) && (DJICompletionHelper.this.currentFlycState.equals(DataOsdGetPushCommon.FLYC_STATE.GPS_Atti))) {
          DJICompletionHelper.this.takeOffCallback.onSuccess(null);
        }
        paramAnonymousDJISDKCacheKey = DJICompletionHelper.this;
        DJICompletionHelper.access$102(paramAnonymousDJISDKCacheKey, paramAnonymousDJISDKCacheKey.currentFlycState);
      }
    }
  };
  final Runnable takeOffTimeOut = new Runnable()
  {
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  
  public static DJICompletionHelper getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DJICompletionHelper();
      }
      DJICompletionHelper localDJICompletionHelper = instance;
      return localDJICompletionHelper;
    }
    finally {}
  }
  
  /* Error */
  public void cancelTakeOffCallbackCompletionHelper(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void takeOffCompletionHelper(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private class DefaultCompletionCallback
    implements DJISDKCacheHWAbstraction.InnerCallback
  {
    private DJISDKCacheHWAbstraction.InnerCallback innerCallback;
    private DJIParamAccessListener listener;
    private Runnable runnable;
    
    public DefaultCompletionCallback(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback, Runnable paramRunnable, DJIParamAccessListener paramDJIParamAccessListener)
    {
      this.innerCallback = paramInnerCallback;
      this.runnable = paramRunnable;
      this.listener = paramDJIParamAccessListener;
    }
    
    /* Error */
    public void onFails(dji.common.error.DJIError arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onSuccess(Object arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedli\\util\DJICompletionHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */