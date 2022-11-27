package dji.sdksharedlib.hardware.abstractions;

import com.dji.frame.util.MD5;
import dji.common.error.DJIError;
import dji.common.error.DJISDKCacheError;
import dji.sdksharedlib.hardware.extension.DJISDKMergeHandler;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey.Builder;
import dji.sdksharedlib.listener.DJIActionCallback;
import dji.sdksharedlib.listener.DJIGetCallback;
import dji.sdksharedlib.listener.DJISetCallback;
import dji.sdksharedlib.store.DJISDKCacheParamValue;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class DJISDKCacheHWAbstraction
{
  protected static final int FULL_SERIAL_NUM = 2;
  protected static final int INTERNAL_SERIAL_NUM = 3;
  protected static final int LEGACY_SERIAL_NUM = 1;
  protected static final int SHORT_SERIAL_NUM = 0;
  private static final String TAG = "DJISDKCacheHWAbstraction";
  protected static DJISDKMergeHandler mergeHandler = new DJISDKMergeHandler();
  private Map<String, Method> actionMethodMap;
  private DJISDKCacheKey.Builder builder = new DJISDKCacheKey.Builder();
  protected Map<String, DJISDKCacheKeyCharacteristics> characteristicsMap;
  protected DJISDKCacheKey defaultKeyPath;
  private Map<String, Method> getterMethodMap;
  protected Map<String, DJISDKCacheKeyCharacteristics> keyMap;
  protected OnValueChangeListener onValueChangeListener;
  private Map<String, Method> setterMethodMap;
  protected Map<String, Map<Integer, DJISDKCacheHWAbstraction>> subComponentMap;
  
  private void addActionMethod(String paramString, Method paramMethod)
  {
    this.actionMethodMap.put(paramString, paramMethod);
  }
  
  /* Error */
  private void addCollectorCharacteristics(String arg1, int arg2, DJISDKCacheUpdateType arg3, Class arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void addGetterMethod(String paramString, Method paramMethod)
  {
    this.getterMethodMap.put(paramString, paramMethod);
  }
  
  /* Error */
  private void addKeyToCollector(String arg1, String arg2, InnerCallback arg3, int arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void addSetterMethod(String paramString, Method paramMethod)
  {
    this.setterMethodMap.put(paramString, paramMethod);
  }
  
  private DJISDKCacheKeyCharacteristics createGetRequestCollector()
  {
    return null;
  }
  
  private int getAutoGetIntervalFromSubComponent(DJISDKCacheKey paramDJISDKCacheKey)
  {
    return 0;
  }
  
  private ArrayList<String> getGettableKeys()
  {
    return null;
  }
  
  private String getMD5Full(String paramString)
  {
    return MD5.getMD5(paramString);
  }
  
  private String getMD5Legacy(String paramString)
  {
    return null;
  }
  
  private List<Method> getMethodsFromSuperClass(Class<?> paramClass)
  {
    return null;
  }
  
  private Map<String, Method> getSetterMethodMap()
  {
    return this.setterMethodMap;
  }
  
  private ArrayList<String> getSupportedKeys()
  {
    return null;
  }
  
  /* Error */
  private void getValueFromSubComponent(DJISDKCacheKey arg1, DJIGetCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean handleActionCustom(DJISDKCacheKey paramDJISDKCacheKey, DJIActionCallback paramDJIActionCallback, Object... paramVarArgs)
  {
    return false;
  }
  
  private boolean handleGetCustom(DJISDKCacheKey paramDJISDKCacheKey, DJIGetCallback paramDJIGetCallback)
  {
    return false;
  }
  
  private boolean handleSetCustom(DJISDKCacheKey paramDJISDKCacheKey, Object paramObject, DJISetCallback paramDJISetCallback)
  {
    return false;
  }
  
  private void initializeCommonCharacteristics()
  {
    this.characteristicsMap = new HashMap();
  }
  
  private void mergeGetRequest(String paramString, DJISDKCacheKeyCharacteristics paramDJISDKCacheKeyCharacteristics, DJIGetCallback paramDJIGetCallback, int paramInt) {}
  
  /* Error */
  private void notifyValueChangeForKeyPathFromSetter(Object arg1, DJISDKCacheKey arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void performActionFromSubComponent(DJISDKCacheKey arg1, DJIActionCallback arg2, Object... arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void performGetOnCollector(DJISDKCacheKeyCharacteristics paramDJISDKCacheKeyCharacteristics, DJISDKCacheError paramDJISDKCacheError) {}
  
  private <T> T[] prepend(T[] paramArrayOfT, T paramT)
  {
    return null;
  }
  
  /* Error */
  private void removeCharacteristics(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void removeCollectorCharacteristics(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void setValueFromSubComponent(DJISDKCacheKey arg1, Object arg2, DJISetCallback arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void addCharacteristics(Class<? extends dji.sdksharedlib.keycatalog.DJISDKCacheKeys> arg1, Class arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void addCharacteristics(String arg1, int arg2, DJISDKCacheUpdateType arg3, int arg4, int arg5, Class... arg6)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void addCollectorCharacteristics(String paramString, int paramInt, DJISDKCacheUpdateType paramDJISDKCacheUpdateType)
  {
    addCollectorCharacteristics(paramString, paramInt, paramDJISDKCacheUpdateType, null);
  }
  
  /* Error */
  protected void addSubComponents(DJISDKCacheHWAbstraction arg1, String arg2, int arg3, DJISDKCacheStoreLayer arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected DJISDKCacheKey convertKeyToPath(DJISDKCacheKey paramDJISDKCacheKey)
  {
    return null;
  }
  
  protected DJISDKCacheKey convertKeyToPath(String paramString)
  {
    return this.defaultKeyPath.clone(paramString);
  }
  
  /* Error */
  protected void createMethodMap()
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
  
  public int getAutoGetInterval(DJISDKCacheKey paramDJISDKCacheKey)
  {
    return 0;
  }
  
  public DJISDKCacheKeyCharacteristics getCharacteristics(DJISDKCacheKey paramDJISDKCacheKey)
  {
    return null;
  }
  
  public Map<String, Method> getGetterMethodMap()
  {
    return this.getterMethodMap;
  }
  
  protected String getHashSerialNum(String paramString, int paramInt)
  {
    return null;
  }
  
  public DJISDKCacheHWAbstraction getSubComponent(DJISDKCacheKey paramDJISDKCacheKey)
  {
    return null;
  }
  
  public Map<String, Map<Integer, DJISDKCacheHWAbstraction>> getSubComponents()
  {
    return this.subComponentMap;
  }
  
  public DJISDKCacheUpdateType getUpdateType(DJISDKCacheKey paramDJISDKCacheKey)
  {
    return null;
  }
  
  /* Error */
  public void getValue(DJISDKCacheKey arg1, DJIGetCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void init(String arg1, int arg2, DJISDKCacheStoreLayer arg3, OnValueChangeListener arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void initializeAllCharacteristics()
  {
    initializeCommonCharacteristics();
    initializeComponentCharacteristics();
  }
  
  protected abstract void initializeComponentCharacteristics();
  
  protected void initializeSubComponents(DJISDKCacheStoreLayer paramDJISDKCacheStoreLayer) {}
  
  public boolean isConstantKey(DJISDKCacheKey paramDJISDKCacheKey)
  {
    return false;
  }
  
  public boolean isPushKey(DJISDKCacheKey paramDJISDKCacheKey)
  {
    return false;
  }
  
  protected void notifyValueChangeForKey(Object paramObject, DJISDKCacheKey paramDJISDKCacheKey)
  {
    OnValueChangeListener localOnValueChangeListener = this.onValueChangeListener;
    if (localOnValueChangeListener != null) {
      localOnValueChangeListener.onNewValueFromSetter(paramObject, paramDJISDKCacheKey);
    }
  }
  
  /* Error */
  protected void notifyValueChangeForKey(Object arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void notifyValueChangeForKeyPath(Object paramObject, DJISDKCacheKey paramDJISDKCacheKey)
  {
    OnValueChangeListener localOnValueChangeListener = this.onValueChangeListener;
    if (localOnValueChangeListener != null) {
      localOnValueChangeListener.onNewValue(paramObject, paramDJISDKCacheKey);
    }
  }
  
  /* Error */
  protected void notifyValueChangeForKeyPath(Object arg1, DJISDKCacheKey arg2, UpdateStoreForGetterCallback arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void notifyValueChangeForKeyPath(Object arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void performAction(DJISDKCacheKey arg1, DJIActionCallback arg2, Object... arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void setValue(DJISDKCacheKey arg1, Object arg2, DJISetCallback arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void syncPushDataFromMidware()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public class DefaultActionInnerCallback
    implements DJISDKCacheHWAbstraction.InnerCallback
  {
    private DJIActionCallback cb;
    private String key;
    private Object[] value;
    
    public DefaultActionInnerCallback(String paramString, DJIActionCallback paramDJIActionCallback, Object... paramVarArgs)
    {
      this.key = paramString;
      this.cb = paramDJIActionCallback;
      this.value = paramVarArgs;
    }
    
    /* Error */
    public void onFails(DJIError arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onSuccess(Object arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  public class DefaultGetInnerCallback
    implements DJISDKCacheHWAbstraction.GetterInnerCallback
  {
    private DJIGetCallback cb;
    private DJISDKCacheKey keyPath;
    
    public DefaultGetInnerCallback(DJISDKCacheKey paramDJISDKCacheKey, DJIGetCallback paramDJIGetCallback)
    {
      this.keyPath = paramDJISDKCacheKey;
      this.cb = paramDJIGetCallback;
    }
    
    public boolean hasGetCallback()
    {
      return this.cb != null;
    }
    
    /* Error */
    public void onFails(DJIError arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onSuccess(Object arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  public class DefaultSetInnerCallback
    implements DJISDKCacheHWAbstraction.InnerCallback
  {
    private DJISetCallback cb;
    private DJISDKCacheKey keyPath;
    private Object value;
    
    public DefaultSetInnerCallback(DJISDKCacheKey paramDJISDKCacheKey, Object paramObject, DJISetCallback paramDJISetCallback)
    {
      this.keyPath = paramDJISDKCacheKey;
      this.cb = paramDJISetCallback;
      this.value = paramObject;
    }
    
    /* Error */
    public void onFails(DJIError arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onSuccess(Object arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  protected static abstract interface GetterInnerCallback
    extends DJISDKCacheHWAbstraction.InnerCallback
  {
    public abstract boolean hasGetCallback();
  }
  
  public static abstract interface InnerCallback
  {
    public abstract void onFails(DJIError paramDJIError);
    
    public abstract void onSuccess(Object paramObject);
  }
  
  public static abstract interface OnValueChangeListener
  {
    public abstract void onNewValue(Object paramObject, DJISDKCacheKey paramDJISDKCacheKey);
    
    public abstract void onNewValueFromGetter(Object paramObject, DJISDKCacheKey paramDJISDKCacheKey, DJISDKCacheHWAbstraction.UpdateStoreForGetterCallback paramUpdateStoreForGetterCallback);
    
    public abstract void onNewValueFromSetter(Object paramObject, DJISDKCacheKey paramDJISDKCacheKey);
  }
  
  public class UpdateStoreForGetterCallback
    implements DJISDKCacheHWAbstraction.GetterInnerCallback
  {
    private DJIGetCallback cb;
    private DJISDKCacheKey keyPath;
    
    public UpdateStoreForGetterCallback(DJISDKCacheKey paramDJISDKCacheKey, DJIGetCallback paramDJIGetCallback)
    {
      this.keyPath = paramDJISDKCacheKey;
      this.cb = paramDJIGetCallback;
    }
    
    public UpdateStoreForGetterCallback(DJIGetCallback paramDJIGetCallback)
    {
      this.cb = paramDJIGetCallback;
    }
    
    public boolean hasGetCallback()
    {
      return this.cb != null;
    }
    
    /* Error */
    public void onFails(DJIError arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onNoChange(DJISDKCacheParamValue arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onSuccess(Object arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\DJISDKCacheHWAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */