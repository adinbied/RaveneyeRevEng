package dji.sdksharedlib.util.configuration;

import dji.common.util.CallbackUtils;
import dji.midware.data.config.P3.Ccode;
import dji.midware.data.model.P3.DataFlycGetParamInfoByHash;
import dji.midware.data.params.P3.ParamInfo;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.DJISDKCache;
import dji.sdksharedlib.extension.CacheHelper;
import dji.sdksharedlib.extension.KeyHelper;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.sdksharedlib.listener.DJIParamAccessListener;
import dji.sdksharedlib.store.DJISDKCacheParamValue;
import dji.sdksharedlib.util.configuration.keymaps.FlightControllerConfigsKeyMap;
import java.util.ArrayList;
import java.util.HashMap;

public class DJISDKCacheProductConfigManager
{
  private static DJISDKCacheProductConfigManager instance;
  private int currentProductVersion = 0;
  private HashMap<String, DJISDKCacheProductConfigsKey> keyHashMap = FlightControllerConfigsKeyMap.getFlightControllerConfigsKeyMap();
  
  private DJISDKCacheProductConfigManager()
  {
    loadKeyHashMapToParamInfoManager();
    DJISDKCache.getInstance().startListeningForUpdates(KeyHelper.getFlightControllerKey("InternalFlightControllerVersion"), new DJIParamAccessListener()
    {
      public void onValueChange(DJISDKCacheKey paramAnonymousDJISDKCacheKey, DJISDKCacheParamValue paramAnonymousDJISDKCacheParamValue1, DJISDKCacheParamValue paramAnonymousDJISDKCacheParamValue2)
      {
        DJISDKCacheProductConfigManager.access$002(DJISDKCacheProductConfigManager.this, CacheHelper.toInt(CacheHelper.getFlightController("InternalFlightControllerVersion")));
      }
    }, false);
    this.currentProductVersion = CacheHelper.toInt(CacheHelper.getFlightController("InternalFlightControllerVersion"));
  }
  
  public static DJISDKCacheProductConfigManager getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DJISDKCacheProductConfigManager();
      }
      DJISDKCacheProductConfigManager localDJISDKCacheProductConfigManager = instance;
      return localDJISDKCacheProductConfigManager;
    }
    finally {}
  }
  
  private String getSupportedConfigHashKey(String paramString)
  {
    return null;
  }
  
  private ConfigValueStructure getSupportedConfigHashKeys(ArrayList<String> paramArrayList, ArrayList<Number> paramArrayList1, boolean paramBoolean)
  {
    return null;
  }
  
  private int getSupportedVersion(String paramString, int paramInt)
  {
    return 0;
  }
  
  private int getTypeIdFromClassType(Class paramClass)
  {
    return 0;
  }
  
  /* Error */
  private void loadKeyHashMapToParamInfoManager()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public ParamInfo getParamInfo(String paramString)
  {
    return null;
  }
  
  public boolean isConfigSupported(String paramString)
  {
    return false;
  }
  
  public boolean isConfigValueValid(String paramString, Number paramNumber)
  {
    return false;
  }
  
  public boolean isReadable(String paramString)
  {
    return false;
  }
  
  public boolean isSubscribable(String paramString)
  {
    return false;
  }
  
  public boolean isWritable(String paramString)
  {
    return false;
  }
  
  /* Error */
  public void readConfig(String arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void readConfig(ArrayList<String> arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void readConfigRange(String arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void resetConfig(ArrayList<String> arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void writeConfig(String arg1, Number arg2, DJISDKCacheHWAbstraction.InnerCallback arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void writeConfig(ArrayList<String> arg1, ArrayList<Number> arg2, DJISDKCacheHWAbstraction.InnerCallback arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public class ConfigRange
  {
    public Number defaultValue;
    public Number maxValue;
    public Number minValue;
    
    public ConfigRange(Number paramNumber1, Number paramNumber2, Number paramNumber3)
    {
      this.minValue = paramNumber1;
      this.maxValue = paramNumber2;
      this.defaultValue = paramNumber3;
    }
  }
  
  private class ConfigValueStructure
  {
    public String[] keys;
    public Number[] values;
    
    public ConfigValueStructure(String[] paramArrayOfString, Number[] paramArrayOfNumber)
    {
      this.keys = paramArrayOfString;
      this.values = paramArrayOfNumber;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedli\\util\configuration\DJISDKCacheProductConfigManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */