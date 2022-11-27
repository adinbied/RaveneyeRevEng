package dji.sdksharedlib.extension;

import dji.common.error.DJIError;
import dji.sdksharedlib.DJISDKCache;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.sdksharedlib.listener.DJIActionCallback;
import dji.sdksharedlib.listener.DJIGetCallback;
import dji.sdksharedlib.listener.DJIParamAccessListener;
import dji.sdksharedlib.listener.DJISetCallback;
import dji.sdksharedlib.store.DJISDKCacheParamValue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CacheHelper
{
  public static void addAirlinkListener(DJIParamAccessListener paramDJIParamAccessListener, String... paramVarArgs)
  {
    addListener(paramDJIParamAccessListener, KeyHelper.getAirLinkKey(paramVarArgs));
  }
  
  public static void addBatteryAggregationListener(DJIParamAccessListener paramDJIParamAccessListener, String... paramVarArgs)
  {
    addListener(paramDJIParamAccessListener, KeyHelper.getBatteryAggregationKey(paramVarArgs));
  }
  
  public static void addBatteryListener(DJIParamAccessListener paramDJIParamAccessListener, int paramInt, String... paramVarArgs)
  {
    addListener(paramDJIParamAccessListener, KeyHelper.getBatteryKey(paramInt, paramVarArgs));
  }
  
  public static void addBatteryListener(DJIParamAccessListener paramDJIParamAccessListener, String... paramVarArgs)
  {
    addListener(paramDJIParamAccessListener, KeyHelper.getBatteryKey(paramVarArgs));
  }
  
  public static void addCameraListener(DJIParamAccessListener paramDJIParamAccessListener, int paramInt, String... paramVarArgs)
  {
    addListener(paramDJIParamAccessListener, KeyHelper.getCameraKey(paramInt, paramVarArgs));
  }
  
  public static void addCameraListener(DJIParamAccessListener paramDJIParamAccessListener, String... paramVarArgs)
  {
    addListener(paramDJIParamAccessListener, KeyHelper.getCameraKey(paramVarArgs));
  }
  
  public static void addFlightAssistantListener(DJIParamAccessListener paramDJIParamAccessListener, String... paramVarArgs)
  {
    addListener(paramDJIParamAccessListener, KeyHelper.getIntelligentFlightAssistantKeys(paramVarArgs));
  }
  
  public static void addFlightControllerListener(DJIParamAccessListener paramDJIParamAccessListener, String... paramVarArgs)
  {
    addListener(paramDJIParamAccessListener, KeyHelper.getFlightControllerKey(paramVarArgs));
  }
  
  public static void addGimbalListener(DJIParamAccessListener paramDJIParamAccessListener, int paramInt, String... paramVarArgs)
  {
    addListener(paramDJIParamAccessListener, KeyHelper.getGimbalKey(paramInt, paramVarArgs));
  }
  
  public static void addGimbalListener(DJIParamAccessListener paramDJIParamAccessListener, String... paramVarArgs)
  {
    addListener(paramDJIParamAccessListener, KeyHelper.getGimbalKey(paramVarArgs));
  }
  
  public static void addLightbridgeLinkListener(DJIParamAccessListener paramDJIParamAccessListener, String... paramVarArgs)
  {
    addListener(paramDJIParamAccessListener, KeyHelper.getLightbridgeLinkKey(paramVarArgs));
  }
  
  public static void addListener(DJIParamAccessListener paramDJIParamAccessListener, DJISDKCacheKey paramDJISDKCacheKey)
  {
    DJISDKCache.getInstance().startListeningForUpdates(paramDJISDKCacheKey, paramDJIParamAccessListener, true);
  }
  
  public static void addListener(DJIParamAccessListener paramDJIParamAccessListener, boolean paramBoolean, DJISDKCacheKey... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      DJISDKCacheKey localDJISDKCacheKey = paramVarArgs[i];
      DJISDKCache.getInstance().startListeningForUpdates(localDJISDKCacheKey, paramDJIParamAccessListener, paramBoolean);
      i += 1;
    }
  }
  
  public static void addListener(DJIParamAccessListener paramDJIParamAccessListener, DJISDKCacheKey... paramVarArgs)
  {
    addListener(paramDJIParamAccessListener, true, paramVarArgs);
  }
  
  public static void addListenerOnBackgroundThread(DJIParamAccessListener paramDJIParamAccessListener, DJISDKCacheKey... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      DJISDKCacheKey localDJISDKCacheKey = paramVarArgs[i];
      DJISDKCache.getInstance().startListeningForUpdates(localDJISDKCacheKey, paramDJIParamAccessListener, false);
      i += 1;
    }
  }
  
  public static void addMonitorListener(DJIParamAccessListener paramDJIParamAccessListener, String... paramVarArgs)
  {
    addListener(paramDJIParamAccessListener, KeyHelper.getMonitorKey(paramVarArgs));
  }
  
  public static void addProductListener(DJIParamAccessListener paramDJIParamAccessListener, String paramString)
  {
    addListener(paramDJIParamAccessListener, KeyHelper.getProductKey(paramString));
  }
  
  public static void addProductListener(DJIParamAccessListener paramDJIParamAccessListener, String... paramVarArgs)
  {
    addListener(paramDJIParamAccessListener, KeyHelper.getProductKey(paramVarArgs));
  }
  
  public static void addRemoteControllerListener(DJIParamAccessListener paramDJIParamAccessListener, String... paramVarArgs)
  {
    addListener(paramDJIParamAccessListener, KeyHelper.getRemoteControllerKey(paramVarArgs));
  }
  
  public static void addThirdPartyCameraListener(DJIParamAccessListener paramDJIParamAccessListener, String paramString)
  {
    addListener(paramDJIParamAccessListener, KeyHelper.getThirdPartyCameraKey(paramString));
  }
  
  public static void addThirdPartyCameraListener(DJIParamAccessListener paramDJIParamAccessListener, String... paramVarArgs)
  {
    addListener(paramDJIParamAccessListener, KeyHelper.getThirdPartyCameraKey(paramVarArgs));
  }
  
  public static void addWiFiAirlinkListener(DJIParamAccessListener paramDJIParamAccessListener, String... paramVarArgs)
  {
    addListener(paramDJIParamAccessListener, KeyHelper.getWiFiAirLinkKey(paramVarArgs));
  }
  
  public static void get(DJISDKCacheKey paramDJISDKCacheKey, DJIGetCallback paramDJIGetCallback)
  {
    DJISDKCache.getInstance().getValue(paramDJISDKCacheKey, paramDJIGetCallback);
  }
  
  public static <T> T getAirlink(String paramString)
  {
    return (T)getValue(KeyHelper.getAirLinkKey(paramString));
  }
  
  public static <T> T getBattery(String paramString)
  {
    return (T)getValue(KeyHelper.getBatteryKey(paramString));
  }
  
  public static <T> T getBattery(String paramString, int paramInt)
  {
    if (paramInt == Integer.MAX_VALUE) {
      return (T)getBattery(paramString, true);
    }
    return (T)getValue(KeyHelper.getBatteryKey(paramInt, paramString));
  }
  
  public static <T> T getBattery(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return (T)getValue(KeyHelper.getBatteryKey(paramString));
    }
    return (T)getValue(KeyHelper.getBatteryAggregationKey(paramString));
  }
  
  public static <T> T getCamera(int paramInt, String paramString)
  {
    return (T)getValue(KeyHelper.getCameraKey(paramInt, paramString));
  }
  
  public static <T> T getCamera(String paramString)
  {
    return (T)getValue(KeyHelper.getCameraKey(paramString));
  }
  
  public static void getCamera(int paramInt, String paramString, DJIGetCallback paramDJIGetCallback)
  {
    get(KeyHelper.getCameraKey(paramInt, paramString), paramDJIGetCallback);
  }
  
  public static void getCamera(String paramString, DJIGetCallback paramDJIGetCallback)
  {
    get(KeyHelper.getCameraKey(paramString), paramDJIGetCallback);
  }
  
  public static <T> T getFlightAssistant(String paramString)
  {
    return (T)getValue(KeyHelper.getIntelligentFlightAssistantKey(paramString));
  }
  
  public static void getFlightAssistant(String paramString, DJIGetCallback paramDJIGetCallback)
  {
    get(KeyHelper.getIntelligentFlightAssistantKey(paramString), paramDJIGetCallback);
  }
  
  public static <T> T getFlightController(String paramString)
  {
    return (T)getValue(KeyHelper.getFlightControllerKey(paramString));
  }
  
  public static void getFlightController(String paramString, DJIGetCallback paramDJIGetCallback)
  {
    get(KeyHelper.getFlightControllerKey(paramString), paramDJIGetCallback);
  }
  
  public static <T> T getGimbal(int paramInt, String paramString)
  {
    return (T)getValue(KeyHelper.getGimbalKey(paramInt, paramString));
  }
  
  public static <T> T getGimbal(String paramString)
  {
    return (T)getValue(KeyHelper.getGimbalKey(paramString));
  }
  
  public static void getGimbal(int paramInt, String paramString, DJIGetCallback paramDJIGetCallback)
  {
    get(KeyHelper.getGimbalKey(paramInt, paramString), paramDJIGetCallback);
  }
  
  public static void getGimbal(String paramString, DJIGetCallback paramDJIGetCallback)
  {
    get(KeyHelper.getGimbalKey(paramString), paramDJIGetCallback);
  }
  
  public static void getHandheld(String paramString, DJIGetCallback paramDJIGetCallback)
  {
    get(KeyHelper.getHandheldControllerKey(paramString), paramDJIGetCallback);
  }
  
  public static <T> T getLightbridgeLink(String paramString)
  {
    return (T)getValue(KeyHelper.getLightbridgeLinkKey(paramString));
  }
  
  public static void getLightbridgeLink(String paramString, DJIGetCallback paramDJIGetCallback)
  {
    get(KeyHelper.getLightbridgeLinkKey(paramString), paramDJIGetCallback);
  }
  
  public static <T> T getMonitor(String paramString)
  {
    return (T)getValue(KeyHelper.getMonitorKey(paramString));
  }
  
  public static <T> T getProduct(String paramString)
  {
    return (T)getValue(KeyHelper.getProductKey(paramString));
  }
  
  public static <T> T getRemoteController(String paramString)
  {
    return (T)getValue(KeyHelper.getRemoteControllerKey(paramString));
  }
  
  public static void getRemoteController(String paramString, DJIGetCallback paramDJIGetCallback)
  {
    get(KeyHelper.getRemoteControllerKey(paramString), paramDJIGetCallback);
  }
  
  public static <T> T getThirdPartyCamera(String paramString)
  {
    return (T)getValue(KeyHelper.getThirdPartyCameraKey(paramString));
  }
  
  public static void getThirdPartyCamera(String paramString, DJIGetCallback paramDJIGetCallback)
  {
    get(KeyHelper.getThirdPartyCameraKey(paramString), paramDJIGetCallback);
  }
  
  public static <T> T getValue(DJISDKCacheKey paramDJISDKCacheKey)
  {
    return (T)getValue(paramDJISDKCacheKey, null);
  }
  
  public static <T> T getValue(DJISDKCacheKey paramDJISDKCacheKey, T paramT)
  {
    paramDJISDKCacheKey = DJISDKCache.getInstance().getAvailableValue(paramDJISDKCacheKey);
    if ((paramDJISDKCacheKey != null) && (paramDJISDKCacheKey.getData() != null))
    {
      paramDJISDKCacheKey = paramDJISDKCacheKey.getData();
      if (paramDJISDKCacheKey != null) {
        return paramDJISDKCacheKey;
      }
    }
    return paramT;
  }
  
  public static DJISDKCacheParamValue getValueSynchronously(DJISDKCacheKey paramDJISDKCacheKey, int paramInt)
  {
    GetCallback localGetCallback = new GetCallback(new CountDownLatch(1));
    DJISDKCache.getInstance().getValue(paramDJISDKCacheKey, localGetCallback);
    if (paramInt > 0) {
      localGetCallback.await(paramInt, TimeUnit.MILLISECONDS);
    } else {
      localGetCallback.await();
    }
    if (localGetCallback.rst) {
      return localGetCallback.value;
    }
    return null;
  }
  
  public static <T> T getWiFiAirLink(String paramString)
  {
    return (T)getValue(KeyHelper.getWiFiAirLinkKey(paramString));
  }
  
  public static void getWiFiAirLink(String paramString, DJIGetCallback paramDJIGetCallback)
  {
    get(KeyHelper.getWiFiAirLinkKey(paramString), paramDJIGetCallback);
  }
  
  public static boolean isDataValid(DJISDKCacheKey paramDJISDKCacheKey, DJISDKCacheParamValue paramDJISDKCacheParamValue)
  {
    return (paramDJISDKCacheKey != null) && (paramDJISDKCacheParamValue != null) && (paramDJISDKCacheParamValue.getData() != null);
  }
  
  public static void performAction(DJISDKCacheKey paramDJISDKCacheKey, DJIActionCallback paramDJIActionCallback, Object... paramVarArgs)
  {
    DJISDKCache.getInstance().performAction(paramDJISDKCacheKey, paramDJIActionCallback, paramVarArgs);
  }
  
  public static void removeKeyListener(DJIParamAccessListener paramDJIParamAccessListener, DJISDKCacheKey... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      DJISDKCacheKey localDJISDKCacheKey = paramVarArgs[i];
      DJISDKCache.getInstance().stopListeningOnKey(localDJISDKCacheKey, paramDJIParamAccessListener);
      i += 1;
    }
  }
  
  public static void removeListener(DJIParamAccessListener paramDJIParamAccessListener)
  {
    DJISDKCache.getInstance().stopListening(paramDJIParamAccessListener);
  }
  
  public static void setBattery(String paramString, int paramInt, Object paramObject, DJISetCallback paramDJISetCallback)
  {
    setValue(KeyHelper.getBatteryKey(paramInt, paramString), paramObject, paramDJISetCallback);
  }
  
  public static void setBattery(String paramString, Object paramObject, DJISetCallback paramDJISetCallback)
  {
    setValue(KeyHelper.getBatteryKey(paramString), paramObject, paramDJISetCallback);
  }
  
  public static void setByBattery(String paramString, Object paramObject, DJISetCallback paramDJISetCallback)
  {
    setValue(KeyHelper.getBatteryKey(paramString), paramObject, paramDJISetCallback);
  }
  
  public static void setByFlightController(String paramString, Object paramObject, DJISetCallback paramDJISetCallback)
  {
    setValue(KeyHelper.getFlightControllerKey(paramString), paramObject, paramDJISetCallback);
  }
  
  public static void setByGimbal(int paramInt, String paramString, Object paramObject, DJISetCallback paramDJISetCallback)
  {
    setValue(KeyHelper.getGimbalKey(paramInt, paramString), paramObject, paramDJISetCallback);
  }
  
  public static void setCamera(String paramString, Object paramObject, DJISetCallback paramDJISetCallback)
  {
    setValue(KeyHelper.getCameraKey(paramString), paramObject, paramDJISetCallback);
  }
  
  public static void setFlightAssistant(String paramString, Object paramObject, DJISetCallback paramDJISetCallback)
  {
    setValue(KeyHelper.getIntelligentFlightAssistantKey(paramString), paramObject, paramDJISetCallback);
  }
  
  public static void setFlightController(String paramString, Object paramObject, DJISetCallback paramDJISetCallback)
  {
    setValue(KeyHelper.getFlightControllerKey(paramString), paramObject, paramDJISetCallback);
  }
  
  public static void setGimbal(String paramString, Object paramObject, DJISetCallback paramDJISetCallback)
  {
    setValue(KeyHelper.getGimbalKey(paramString), paramObject, paramDJISetCallback);
  }
  
  public static void setMonitor(String paramString, Object paramObject, DJISetCallback paramDJISetCallback)
  {
    setValue(KeyHelper.getMonitorKey(paramString), paramObject, paramDJISetCallback);
  }
  
  public static void setRemoteController(String paramString, Object paramObject, DJISetCallback paramDJISetCallback)
  {
    setValue(KeyHelper.getRemoteControllerKey(paramString), paramObject, paramDJISetCallback);
  }
  
  public static void setValue(DJISDKCacheKey paramDJISDKCacheKey, Object paramObject, DJISetCallback paramDJISetCallback)
  {
    DJISDKCache.getInstance().setValue(paramDJISDKCacheKey, paramObject, paramDJISetCallback);
  }
  
  public static boolean toBool(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Boolean))) {
      return ((Boolean)paramObject).booleanValue();
    }
    return false;
  }
  
  public static boolean toBool(Object paramObject, boolean paramBoolean)
  {
    if ((paramObject != null) && ((paramObject instanceof Boolean))) {
      return ((Boolean)paramObject).booleanValue();
    }
    return paramBoolean;
  }
  
  public static double toDouble(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Double))) {
      return ((Double)paramObject).doubleValue();
    }
    return 0.0D;
  }
  
  public static float toFloat(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Float))) {
      return ((Float)paramObject).floatValue();
    }
    return 0.0F;
  }
  
  public static float toFloat(Object paramObject, float paramFloat)
  {
    if ((paramObject != null) && ((paramObject instanceof Float))) {
      return ((Float)paramObject).floatValue();
    }
    return paramFloat;
  }
  
  public static int toInt(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Integer))) {
      return ((Integer)paramObject).intValue();
    }
    return 0;
  }
  
  public static long toLong(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Long))) {
      return ((Long)paramObject).longValue();
    }
    return 0L;
  }
  
  public static short toShort(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Short))) {
      return ((Short)paramObject).shortValue();
    }
    return 0;
  }
  
  private static class GetCallback
    implements DJIGetCallback
  {
    public DJIError error;
    public CountDownLatch latch;
    public boolean rst;
    public DJISDKCacheParamValue value;
    
    public GetCallback(CountDownLatch paramCountDownLatch)
    {
      this.latch = paramCountDownLatch;
      if (paramCountDownLatch == null) {
        this.latch = new CountDownLatch(1);
      }
    }
    
    public void await()
    {
      try
      {
        this.latch.await();
        return;
      }
      catch (InterruptedException localInterruptedException) {}
    }
    
    public void await(int paramInt, TimeUnit paramTimeUnit)
    {
      try
      {
        this.latch.await(paramInt, paramTimeUnit);
        return;
      }
      catch (InterruptedException paramTimeUnit) {}
    }
    
    public void onFails(DJIError paramDJIError)
    {
      this.error = paramDJIError;
      this.rst = false;
      this.latch.countDown();
    }
    
    public void onSuccess(DJISDKCacheParamValue paramDJISDKCacheParamValue)
    {
      this.value = paramDJISDKCacheParamValue;
      this.rst = true;
      this.latch.countDown();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\extension\CacheHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */