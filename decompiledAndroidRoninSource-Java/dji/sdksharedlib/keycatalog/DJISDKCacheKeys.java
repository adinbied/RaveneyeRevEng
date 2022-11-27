package dji.sdksharedlib.keycatalog;

import dji.log.DJILog;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheUpdateType;
import dji.sdksharedlib.hardware.abstractions.battery.NonSmartA3BatteryAbstraction;
import dji.sdksharedlib.hardware.abstractions.gimbal.DJIGimbalRoninMXAbstraction;
import dji.sdksharedlib.keycatalog.extension.ComplexKey;
import dji.sdksharedlib.keycatalog.extension.Key;
import dji.sdksharedlib.keycatalog.extension.Utils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DJISDKCacheKeys
{
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String CONNECTION = "Connection";
  @Key(accessType=1, excludedAbstractions={DJIGimbalRoninMXAbstraction.class}, type=String.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String FIRMWARE_VERSION = "FirmwareVersion";
  public static final String NONE = "None";
  @Key(accessType=1, excludedAbstractions={NonSmartA3BatteryAbstraction.class}, type=String.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String SERIAL_NUMBER = "SerialNumber";
  private static final String TAG = "DJISDKCacheKeys";
  public static Map<Class<? extends DJISDKCacheKeys>, Map<String, KeyInfo>> keyInfoMap;
  private String name;
  
  public DJISDKCacheKeys(String paramString)
  {
    this.name = paramString;
  }
  
  public static Map<String, KeyInfo> getKeyInfoMap(Class<? extends DJISDKCacheKeys> paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    if (keyInfoMap == null) {
      keyInfoMap = new HashMap();
    }
    if (!keyInfoMap.containsKey(paramClass))
    {
      HashMap localHashMap = new HashMap();
      Field[] arrayOfField = paramClass.getFields();
      int j = arrayOfField.length;
      int i = 0;
      while (i < j)
      {
        Field localField = arrayOfField[i];
        if ((localField.getType() == String.class) && (isStatic(localField.getModifiers())) && ((localField.isAnnotationPresent(ComplexKey.class)) || (localField.isAnnotationPresent(Key.class)))) {
          try
          {
            String str = (String)localField.get(null);
            localHashMap.put(str, new KeyInfo(str, (ComplexKey)localField.getAnnotation(ComplexKey.class), (Key)localField.getAnnotation(Key.class)));
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
        i += 1;
      }
      keyInfoMap.put(paramClass, localHashMap);
    }
    return (Map)keyInfoMap.get(paramClass);
  }
  
  public static boolean isStatic(int paramInt)
  {
    return (paramInt & 0x8) != 0;
  }
  
  protected String getDefaultAbstractionName()
  {
    return null;
  }
  
  public String getKeyName()
  {
    return this.name;
  }
  
  public static class KeyInfo
  {
    private Map<Class, Key> classKeyMap;
    private ComplexKey complexKeyAnnotation;
    private Key defaultKey;
    private Key keyAnnotation;
    private Set<Class> unsupport;
    
    public KeyInfo(String paramString, ComplexKey paramComplexKey, Key paramKey)
    {
      this.complexKeyAnnotation = paramComplexKey;
      this.keyAnnotation = paramKey;
      paramString = Utils.parseAllKey(paramComplexKey, paramKey);
      this.unsupport = new HashSet();
      this.classKeyMap = new HashMap();
      if ((paramString != null) && (paramString.length > 0))
      {
        int k = paramString.length;
        int i = 0;
        while (i < k)
        {
          paramComplexKey = paramString[i];
          Class[] arrayOfClass = Utils.parseAllClass(paramComplexKey.excludedAbstractions());
          paramKey = Utils.parseAllClass(paramComplexKey.includedAbstractions());
          int m;
          int j;
          Object localObject;
          if (arrayOfClass != null)
          {
            m = arrayOfClass.length;
            j = 0;
            while (j < m)
            {
              localObject = arrayOfClass[j];
              if (!this.unsupport.contains(localObject)) {
                this.unsupport.add(localObject);
              }
              j += 1;
            }
          }
          if (paramKey == null) {
            this.defaultKey = paramComplexKey;
          }
          if (paramKey != null)
          {
            m = paramKey.length;
            j = 0;
            while (j < m)
            {
              arrayOfClass = paramKey[j];
              if (!this.classKeyMap.containsKey(arrayOfClass))
              {
                this.classKeyMap.put(arrayOfClass, paramComplexKey);
              }
              else
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("repeat include key, please check your code : ");
                ((StringBuilder)localObject).append(arrayOfClass.toString());
                ((StringBuilder)localObject).append(", key : ");
                ((StringBuilder)localObject).append(paramComplexKey);
                DJILog.e("DJISDKCacheKeys", ((StringBuilder)localObject).toString(), new Object[0]);
              }
              j += 1;
            }
          }
          i += 1;
        }
      }
      paramString = this.unsupport.iterator();
      while (paramString.hasNext())
      {
        paramComplexKey = (Class)paramString.next();
        if (this.classKeyMap.containsKey(paramComplexKey)) {
          this.classKeyMap.remove(paramComplexKey);
        }
      }
    }
    
    public Key getKey(Class<? extends DJISDKCacheKeys> paramClass)
    {
      return null;
    }
    
    public boolean support(Class<? extends DJISDKCacheHWAbstraction> paramClass)
    {
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\keycatalog\DJISDKCacheKeys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */