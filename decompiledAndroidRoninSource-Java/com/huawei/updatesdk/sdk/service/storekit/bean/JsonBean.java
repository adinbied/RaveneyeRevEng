package com.huawei.updatesdk.sdk.service.storekit.bean;

import java.lang.reflect.Field;
import java.security.PrivilegedAction;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class JsonBean
{
  private static final char COMMA = ',';
  private static final String END_FLAG = "_";
  private static final String TAG = JsonBean.class.getSimpleName();
  
  private String arrayToJson(Object paramObject)
    throws IllegalAccessException, IllegalArgumentException
  {
    return null;
  }
  
  /* Error */
  private void formatJsonStr(StringBuilder arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private Object jsonBeanFromJson(Class paramClass, Object paramObject)
    throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, JSONException
  {
    paramClass = (JsonBean)paramClass.newInstance();
    paramClass.fromJson((JSONObject)paramObject);
    return paramClass;
  }
  
  private String mapToJson(Map paramMap)
    throws IllegalAccessException, IllegalArgumentException
  {
    return null;
  }
  
  /* Error */
  private void processValueError(Field arg1, Object arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private Object valueFromJson(Class paramClass1, Class paramClass2, Object paramObject)
    throws IllegalAccessException, IllegalArgumentException, InstantiationException, ClassNotFoundException, JSONException
  {
    return null;
  }
  
  private String valueToJson(Object paramObject)
    throws IllegalAccessException, IllegalArgumentException
  {
    return null;
  }
  
  /* Error */
  public void fromJson(JSONObject arg1)
    throws IllegalArgumentException, IllegalAccessException, InstantiationException, ClassNotFoundException, JSONException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  protected Object listFromJson(Class paramClass, Object paramObject)
    throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, JSONException
  {
    return null;
  }
  
  protected String listToJson(List paramList)
    throws IllegalAccessException, IllegalArgumentException
  {
    return null;
  }
  
  protected Object mapFromJson(Class paramClass, Object paramObject)
    throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, JSONException
  {
    return null;
  }
  
  public String toJson()
    throws IllegalAccessException, IllegalArgumentException
  {
    return null;
  }
  
  private static class a
    implements PrivilegedAction
  {
    private Field a;
    
    public a(Field paramField)
    {
      this.a = paramField;
    }
    
    public Object run()
    {
      this.a.setAccessible(true);
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\sdk\service\storekit\bean\JsonBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */