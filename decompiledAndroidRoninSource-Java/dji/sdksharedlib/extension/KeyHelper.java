package dji.sdksharedlib.extension;

import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey.Builder;

public class KeyHelper
{
  public static DJISDKCacheKey get(String paramString1, int paramInt, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(paramString2);
    DJISDKCacheKey localDJISDKCacheKey = DJISDKCacheKey.getCache(((StringBuilder)localObject).toString());
    localObject = localDJISDKCacheKey;
    if (localDJISDKCacheKey == null)
    {
      localObject = new DJISDKCacheKey.Builder();
      ((DJISDKCacheKey.Builder)localObject).component(paramString1);
      ((DJISDKCacheKey.Builder)localObject).index(paramInt);
      ((DJISDKCacheKey.Builder)localObject).paramKey(paramString2);
      localObject = ((DJISDKCacheKey.Builder)localObject).build();
    }
    return (DJISDKCacheKey)localObject;
  }
  
  public static DJISDKCacheKey get(String paramString1, String paramString2)
  {
    return get(paramString1, 0, paramString2);
  }
  
  public static DJISDKCacheKey get(String paramString1, String paramString2, int paramInt)
  {
    return get(paramString1, paramInt, paramString2);
  }
  
  public static DJISDKCacheKey get(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(paramString3);
    DJISDKCacheKey localDJISDKCacheKey = DJISDKCacheKey.getCache(((StringBuilder)localObject).toString());
    localObject = localDJISDKCacheKey;
    if (localDJISDKCacheKey == null)
    {
      localObject = new DJISDKCacheKey.Builder();
      ((DJISDKCacheKey.Builder)localObject).component(paramString1);
      ((DJISDKCacheKey.Builder)localObject).index(paramInt1);
      ((DJISDKCacheKey.Builder)localObject).subComponent(paramString2);
      ((DJISDKCacheKey.Builder)localObject).subComponentIndex(paramInt2);
      ((DJISDKCacheKey.Builder)localObject).paramKey(paramString3);
      localObject = ((DJISDKCacheKey.Builder)localObject).build();
    }
    return (DJISDKCacheKey)localObject;
  }
  
  public static DJISDKCacheKey[] get(String paramString, int paramInt, String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return null;
    }
    int j = paramArrayOfString.length;
    DJISDKCacheKey[] arrayOfDJISDKCacheKey = new DJISDKCacheKey[j];
    int i = 0;
    while (i < j)
    {
      arrayOfDJISDKCacheKey[i] = get(paramString, paramInt, paramArrayOfString[i]);
      i += 1;
    }
    return arrayOfDJISDKCacheKey;
  }
  
  public static DJISDKCacheKey[] get(String paramString, String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return null;
    }
    int j = paramArrayOfString.length;
    DJISDKCacheKey[] arrayOfDJISDKCacheKey = new DJISDKCacheKey[j];
    int i = 0;
    while (i < j)
    {
      arrayOfDJISDKCacheKey[i] = get(paramString, paramArrayOfString[i]);
      i += 1;
    }
    return arrayOfDJISDKCacheKey;
  }
  
  public static DJISDKCacheKey[] get(String paramString, String[] paramArrayOfString, int paramInt)
  {
    if (paramArrayOfString == null) {
      return null;
    }
    int j = paramArrayOfString.length;
    DJISDKCacheKey[] arrayOfDJISDKCacheKey = new DJISDKCacheKey[j];
    int i = 0;
    while (i < j)
    {
      arrayOfDJISDKCacheKey[i] = get(paramString, paramInt, paramArrayOfString[i]);
      i += 1;
    }
    return arrayOfDJISDKCacheKey;
  }
  
  public static DJISDKCacheKey getAirLinkKey(String paramString)
  {
    return get("AirLink", paramString);
  }
  
  public static DJISDKCacheKey[] getAirLinkKey(String[] paramArrayOfString)
  {
    return get("AirLink", paramArrayOfString);
  }
  
  public static DJISDKCacheKey getBatteryAggregationKey(String paramString)
  {
    return get("Battery", paramString, Integer.MAX_VALUE);
  }
  
  public static DJISDKCacheKey[] getBatteryAggregationKey(String[] paramArrayOfString)
  {
    return get("Battery", paramArrayOfString, Integer.MAX_VALUE);
  }
  
  public static DJISDKCacheKey getBatteryKey(int paramInt, String paramString)
  {
    return get("Battery", paramInt, paramString);
  }
  
  public static DJISDKCacheKey getBatteryKey(String paramString)
  {
    return get("Battery", paramString);
  }
  
  public static DJISDKCacheKey[] getBatteryKey(int paramInt, String[] paramArrayOfString)
  {
    return get("Battery", paramArrayOfString, paramInt);
  }
  
  public static DJISDKCacheKey[] getBatteryKey(String[] paramArrayOfString)
  {
    return get("Battery", paramArrayOfString);
  }
  
  public static DJISDKCacheKey getCameraKey(int paramInt, String paramString)
  {
    return get("Camera", paramInt, paramString);
  }
  
  public static DJISDKCacheKey getCameraKey(String paramString)
  {
    return get("Camera", paramString);
  }
  
  public static DJISDKCacheKey[] getCameraKey(int paramInt, String[] paramArrayOfString)
  {
    return get("Camera", paramInt, paramArrayOfString);
  }
  
  public static DJISDKCacheKey[] getCameraKey(String[] paramArrayOfString)
  {
    return get("Camera", paramArrayOfString);
  }
  
  public static DJISDKCacheKey getFlightControllerKey(String paramString)
  {
    return get("FlightController", paramString);
  }
  
  public static DJISDKCacheKey[] getFlightControllerKey(String[] paramArrayOfString)
  {
    return get("FlightController", paramArrayOfString);
  }
  
  public static DJISDKCacheKey getGimbalKey(int paramInt, String paramString)
  {
    return get("Gimbal", paramInt, paramString);
  }
  
  public static DJISDKCacheKey getGimbalKey(String paramString)
  {
    return get("Gimbal", paramString);
  }
  
  public static DJISDKCacheKey[] getGimbalKey(int paramInt, String[] paramArrayOfString)
  {
    return get("Gimbal", paramInt, paramArrayOfString);
  }
  
  public static DJISDKCacheKey[] getGimbalKey(String[] paramArrayOfString)
  {
    return get("Gimbal", paramArrayOfString);
  }
  
  public static DJISDKCacheKey getHandheldControllerKey(String paramString)
  {
    return get("HandheldController", paramString);
  }
  
  public static DJISDKCacheKey[] getHandheldControllerKey(String[] paramArrayOfString)
  {
    return get("HandheldController", paramArrayOfString);
  }
  
  public static DJISDKCacheKey getIntelligentFlightAssistantKey(String paramString)
  {
    DJISDKCacheKey.Builder localBuilder = new DJISDKCacheKey.Builder();
    localBuilder.component("FlightController").index(0).subComponent("IntelligentFlightAssistant").subComponentIndex(0);
    return localBuilder.paramKey(paramString).build();
  }
  
  public static DJISDKCacheKey[] getIntelligentFlightAssistantKeys(String[] paramArrayOfString)
  {
    DJISDKCacheKey[] arrayOfDJISDKCacheKey = new DJISDKCacheKey[paramArrayOfString.length];
    DJISDKCacheKey.Builder localBuilder1 = new DJISDKCacheKey.Builder();
    DJISDKCacheKey.Builder localBuilder2 = localBuilder1.component("FlightController");
    int i = 0;
    localBuilder2.index(0).subComponent("IntelligentFlightAssistant").subComponentIndex(0);
    while (i < paramArrayOfString.length)
    {
      arrayOfDJISDKCacheKey[i] = localBuilder1.paramKey(paramArrayOfString[i]).build();
      i += 1;
    }
    return arrayOfDJISDKCacheKey;
  }
  
  public static DJISDKCacheKey getLightbridgeLinkKey(int paramInt1, int paramInt2, String paramString)
  {
    DJISDKCacheKey.Builder localBuilder = new DJISDKCacheKey.Builder();
    localBuilder.component("AirLink").index(paramInt1).subComponent("LightbridgeLink").subComponentIndex(paramInt2);
    return localBuilder.paramKey(paramString).build();
  }
  
  public static DJISDKCacheKey getLightbridgeLinkKey(String paramString)
  {
    return getLightbridgeLinkKey(0, 0, paramString);
  }
  
  public static DJISDKCacheKey[] getLightbridgeLinkKey(String[] paramArrayOfString)
  {
    DJISDKCacheKey[] arrayOfDJISDKCacheKey = new DJISDKCacheKey[paramArrayOfString.length];
    DJISDKCacheKey.Builder localBuilder1 = new DJISDKCacheKey.Builder();
    DJISDKCacheKey.Builder localBuilder2 = localBuilder1.component("AirLink");
    int i = 0;
    localBuilder2.index(0).subComponent("LightbridgeLink").subComponentIndex(0);
    while (i < paramArrayOfString.length)
    {
      arrayOfDJISDKCacheKey[i] = localBuilder1.paramKey(paramArrayOfString[i]).build();
      i += 1;
    }
    return arrayOfDJISDKCacheKey;
  }
  
  public static DJISDKCacheKey getMonitorKey(String paramString)
  {
    return get("Monitor", paramString);
  }
  
  public static DJISDKCacheKey[] getMonitorKey(String[] paramArrayOfString)
  {
    return get("Monitor", paramArrayOfString);
  }
  
  public static DJISDKCacheKey getOcuSyncLinkKey(int paramInt1, int paramInt2, String paramString)
  {
    DJISDKCacheKey.Builder localBuilder = new DJISDKCacheKey.Builder();
    localBuilder.component("AirLink").index(paramInt1).subComponent("OcuSyncLink").subComponentIndex(paramInt2);
    return localBuilder.paramKey(paramString).build();
  }
  
  public static DJISDKCacheKey getOcuSyncLinkKey(String paramString)
  {
    return getOcuSyncLinkKey(0, 0, paramString);
  }
  
  public static DJISDKCacheKey getProductKey(String paramString)
  {
    return get("Product", paramString);
  }
  
  public static DJISDKCacheKey[] getProductKey(String[] paramArrayOfString)
  {
    return get("Product", paramArrayOfString);
  }
  
  public static DJISDKCacheKey getRemoteControllerKey(String paramString)
  {
    return get("RemoteController", paramString);
  }
  
  public static DJISDKCacheKey[] getRemoteControllerKey(String[] paramArrayOfString)
  {
    return get("RemoteController", paramArrayOfString);
  }
  
  public static DJISDKCacheKey[] getSubComponentKeys(String paramString1, String paramString2, int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return null;
    }
    int j = paramArrayOfString.length;
    DJISDKCacheKey[] arrayOfDJISDKCacheKey = new DJISDKCacheKey[j];
    int i = 0;
    while (i < j)
    {
      arrayOfDJISDKCacheKey[i] = get(paramString1, paramString2, paramInt1, paramInt2, paramArrayOfString[i]);
      i += 1;
    }
    return arrayOfDJISDKCacheKey;
  }
  
  public static DJISDKCacheKey getThirdPartyCameraKey(String paramString)
  {
    return get("ThirdPartyCamera", paramString);
  }
  
  public static DJISDKCacheKey[] getThirdPartyCameraKey(String[] paramArrayOfString)
  {
    return get("ThirdPartyCamera", paramArrayOfString);
  }
  
  public static DJISDKCacheKey getWiFiAirLinkKey(int paramInt1, int paramInt2, String paramString)
  {
    DJISDKCacheKey.Builder localBuilder = new DJISDKCacheKey.Builder();
    localBuilder.component("AirLink").index(paramInt1).subComponent("WifiLink").subComponentIndex(paramInt2);
    return localBuilder.paramKey(paramString).build();
  }
  
  public static DJISDKCacheKey getWiFiAirLinkKey(String paramString)
  {
    return getWiFiAirLinkKey(0, 0, paramString);
  }
  
  public static DJISDKCacheKey[] getWiFiAirLinkKey(String[] paramArrayOfString)
  {
    return getSubComponentKeys("AirLink", "WifiLink", 0, 0, paramArrayOfString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\extension\KeyHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */