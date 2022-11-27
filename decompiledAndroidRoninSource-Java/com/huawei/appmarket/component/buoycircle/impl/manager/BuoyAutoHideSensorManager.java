package com.huawei.appmarket.component.buoycircle.impl.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class BuoyAutoHideSensorManager
{
  private static final float CRITICAL_DOWN_ANGLE = -9.8F;
  private static final float CRITICAL_UP_ANGLE = 9.8F;
  private static final String TAG = "BuoyAutoHideManager";
  private static final long TIME_REVERSE_MAX = 3000L;
  private static BuoyAutoHideSensorManager instance = new BuoyAutoHideSensorManager();
  private volatile boolean isScreenOn = true;
  private Context mContext;
  private Sensor mGsensor;
  private SensorEventListener mGsensorListener = new SensorEventListener()
  {
    public void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt) {}
    
    /* Error */
    public void onSensorChanged(android.hardware.SensorEvent arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  private int mReverseDownFlg = -1;
  private ScreenOnReceiver mScreenOnReceiver;
  private SensorCallback mSensorCallback;
  private SensorManager mSensorManager;
  private long timeStartReverse = 0L;
  
  public static BuoyAutoHideSensorManager getInstance()
  {
    return instance;
  }
  
  /* Error */
  private void registerScreenOnOffReceiver()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void unRegisterScreenOnReceiver()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public boolean isSupportSensor(Context paramContext)
  {
    return false;
  }
  
  /* Error */
  public void registerSensor(SensorCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void unRegisterSensor()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private class ScreenOnReceiver
    extends BroadcastReceiver
  {
    private ScreenOnReceiver() {}
    
    /* Error */
    public void onReceive(Context arg1, android.content.Intent arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  public static abstract interface SensorCallback
  {
    public abstract void onReverseUp();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\impl\manager\BuoyAutoHideSensorManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */