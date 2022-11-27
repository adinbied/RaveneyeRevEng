package dji.sdksharedlib.hardware;

import dji.common.error.DJISDKCacheError;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.UpdateStoreForGetterCallback;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheUpdateType;
import dji.sdksharedlib.hardware.extension.DJISDKCacheAutoGetterVerifier;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.sdksharedlib.store.DJISDKCacheParamValue.Source;
import dji.sdksharedlib.store.DJISDKCacheParamValue.Status;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class DJISDKCacheHWAbstractionLayer
{
  public static final int DEFAULT_EXPIRATION_DURATION = 100;
  public static final int DEFAULT_SETTER_VAL_PROTECTION_DURATION = 500;
  private static final String TAG = "DJISDKCacheHWAbstractionLayer";
  protected static final String URI_AIR_LINK = "AirLink";
  protected static final String URI_BATTERY = "Battery";
  protected static final String URI_CAMERA = "Camera";
  protected static final String URI_FLIGHT_CONTROLLER = "FlightController";
  protected static final String URI_GIMBAL = "Gimbal";
  protected static final String URI_HANDHELD_CONTROLLER = "HandheldController";
  protected static final String URI_MONITOR = "Monitor";
  protected static final String URI_PRODUCT = "Product";
  protected static final String URI_REMOTE_CONTROLLER = "RemoteController";
  protected static final String URI_THIRD_PARTY_CAMERA = "ThirdPartyCamera";
  private DJISDKCacheAutoGetterVerifier autoGetterVerifier = null;
  private TimerTask disconnectTask = new TimerTask()
  {
    public void run()
    {
      DJISDKCacheHWAbstractionLayer.this.removeAbstraction("MockAbstraction");
    }
  };
  private DJISDKCacheError error = null;
  public Map<String, List<DJISDKCacheHWAbstraction>> hwAbstractionMap = null;
  DJISDKCacheHWAbstraction.OnValueChangeListener listener = new DJISDKCacheHWAbstraction.OnValueChangeListener()
  {
    /* Error */
    public void onNewValue(Object arg1, DJISDKCacheKey arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onNewValueFromGetter(Object arg1, DJISDKCacheKey arg2, DJISDKCacheHWAbstraction.UpdateStoreForGetterCallback arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onNewValueFromSetter(Object arg1, DJISDKCacheKey arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  private DJISDKCacheStoreLayer storeLayer = null;
  private Timer testTimer = new Timer();
  protected Runnable updateComponentRunnable = -..Lambda.DJISDKCacheHWAbstractionLayer.n5s3nkZflBi0b5JlWFjiEJz8e6o.INSTANCE;
  
  /* Error */
  private void addHandheldControllerAbstraction()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private String convertToName(DJISDKCacheHWAbstraction paramDJISDKCacheHWAbstraction, String paramString)
  {
    return null;
  }
  
  private DJISDKCacheHWAbstraction getComponent(DJISDKCacheKey paramDJISDKCacheKey)
  {
    return null;
  }
  
  private DJISDKCacheHWAbstraction getComponentIncludeSub(DJISDKCacheKey paramDJISDKCacheKey)
  {
    return null;
  }
  
  private DJISDKCacheHWAbstraction getComponentTillSub(DJISDKCacheKey paramDJISDKCacheKey)
  {
    return null;
  }
  
  private DJISDKCacheHWAbstraction getHwAbstraction(DJISDKCacheKey paramDJISDKCacheKey)
  {
    return getComponent(paramDJISDKCacheKey);
  }
  
  private DJISDKCacheUpdateType getUpdateType(DJISDKCacheKey paramDJISDKCacheKey)
  {
    return null;
  }
  
  private void initAirLink()
  {
    addAirLinkAbstraction();
  }
  
  private void initBattery()
  {
    addBatteryAbstraction();
  }
  
  private void initCamera()
  {
    addCameraAbstraction();
  }
  
  private void initFlightController()
  {
    addFlightController();
  }
  
  private void initGimbalController()
  {
    addGimbalAbstraction();
  }
  
  private void initHandheldController()
  {
    addHandheldControllerAbstraction();
  }
  
  private void initMonitor()
  {
    addMonitorAbstraction();
  }
  
  private void initRc()
  {
    addRcAbstraction();
  }
  
  private void notifyUpdateResult(Boolean paramBoolean, Object paramObject, DJISDKCacheHWAbstraction.UpdateStoreForGetterCallback paramUpdateStoreForGetterCallback)
  {
    if (paramUpdateStoreForGetterCallback != null)
    {
      if (paramBoolean.booleanValue())
      {
        paramUpdateStoreForGetterCallback.onSuccess(paramObject);
        return;
      }
      paramUpdateStoreForGetterCallback.onFails(this.error);
    }
  }
  
  /* Error */
  private void updateAirLinkAbstraction()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateBattery()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateCamera()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateFakeBattery()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateFlightController()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateGimbal()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateHandheldController()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateMonitor()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateRemoteController()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean updateStoredValueForKeyPath(Object paramObject, DJISDKCacheKey paramDJISDKCacheKey, DJISDKCacheParamValue.Status paramStatus, DJISDKCacheParamValue.Source paramSource, DJISDKCacheHWAbstraction.UpdateStoreForGetterCallback paramUpdateStoreForGetterCallback)
  {
    return false;
  }
  
  /* Error */
  protected void addAbstraction(int arg1, String arg2, Class<? extends DJISDKCacheHWAbstraction> arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  /* Error */
  protected void addAbstractionWithIndex(int arg1, String arg2, Class<? extends DJISDKCacheHWAbstraction> arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  /* Error */
  protected void addAirLinkAbstraction()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  protected void addAirLinkAbstraction(dji.sdksharedlib.hardware.abstractions.airlink.DJIAirLinkAbstraction arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void addBatteryAbstraction()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void addCameraAbstraction()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void addFlightController()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void addGimbalAbstraction()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void addMockAbstraction(int paramInt, String paramString, Class<? extends DJISDKCacheHWAbstraction> paramClass)
  {
    addAbstraction(paramInt, paramString, paramClass);
  }
  
  /* Error */
  protected void addMonitorAbstraction()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void addRcAbstraction()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void addSecondaryCameraAbstraction()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DJISDKCacheAutoGetterVerifier getAutoGetterVerifier()
  {
    return this.autoGetterVerifier;
  }
  
  public int getInterval(DJISDKCacheKey paramDJISDKCacheKey)
  {
    return 0;
  }
  
  /* Error */
  public void getValue(DJISDKCacheKey arg1, dji.sdksharedlib.listener.DJIGetCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void init(DJISDKCacheStoreLayer arg1, dji.sdksharedlib.listener.DJISDKCacheListenerLayer arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void initProductAbstraction()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void notifyComponentChanged()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.component.DJIComponentManager.CameraComponentType arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.component.DJIComponentManager.GimbalComponentType arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.component.DJIComponentManager.MonitorComponentType arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.component.DJIComponentManager.PlatformType arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.component.DJIComponentManager.RcComponentType arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void performAction(DJISDKCacheKey arg1, dji.sdksharedlib.listener.DJIActionCallback arg2, Object... arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void removeAbstraction(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setValue(DJISDKCacheKey arg1, Object arg2, dji.sdksharedlib.listener.DJISetCallback arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void testDestroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void updateStore(Object paramObject, DJISDKCacheKey paramDJISDKCacheKey, DJISDKCacheParamValue.Status paramStatus, DJISDKCacheParamValue.Source paramSource, DJISDKCacheHWAbstraction.UpdateStoreForGetterCallback paramUpdateStoreForGetterCallback)
  {
    updateStoredValueForKeyPath(paramObject, paramDJISDKCacheKey, paramStatus, paramSource, paramUpdateStoreForGetterCallback);
  }
  
  public static class AbstractionChangeEvent {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\DJISDKCacheHWAbstractionLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */