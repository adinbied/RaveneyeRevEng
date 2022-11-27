package dji.midware.util;

import java.lang.reflect.Method;

public class ReflectUtils
{
  private static Object get(String paramString)
  {
    try
    {
      Class localClass = Class.forName("dji.pilot.reflect.AppPublicReflect");
      paramString = localClass.getMethod(paramString, new Class[0]).invoke(localClass, new Object[0]);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private static Object get(String paramString, Object paramObject)
  {
    try
    {
      Class localClass = Class.forName("dji.pilot.reflect.AppPublicReflect");
      paramString = localClass.getMethod(paramString, new Class[] { paramObject.getClass() }).invoke(localClass, new Object[] { paramObject });
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static boolean getBuildConfig_DEBUG()
  {
    Object localObject = get("getBuildConfig_DEBUG");
    if (localObject != null) {
      return ((Boolean)localObject).booleanValue();
    }
    return false;
  }
  
  public static boolean getBuildConfig_Pad()
  {
    Object localObject = get("getBuildConfig_Pad");
    if ((localObject instanceof Boolean)) {
      return ((Boolean)localObject).booleanValue();
    }
    return false;
  }
  
  public static String getRcVersion()
  {
    Object localObject = get("getRcVersion");
    if (localObject != null) {
      return (String)localObject;
    }
    return null;
  }
  
  private static void invoke(String paramString)
  {
    get(paramString);
  }
  
  private static void invoke(String paramString, Object paramObject)
  {
    get(paramString, paramObject);
  }
  
  public static Boolean isFactoryMode()
  {
    Object localObject = get("isFactoryMode");
    if (localObject != null) {
      return (Boolean)localObject;
    }
    return Boolean.valueOf(false);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midwar\\util\ReflectUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */