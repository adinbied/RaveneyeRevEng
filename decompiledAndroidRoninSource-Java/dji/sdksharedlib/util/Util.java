package dji.sdksharedlib.util;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Util
{
  public static Application getApplication()
    throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException
  {
    return (Application)Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, (Object[])null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedli\\util\Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */