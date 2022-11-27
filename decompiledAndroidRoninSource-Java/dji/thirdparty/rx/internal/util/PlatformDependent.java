package dji.thirdparty.rx.internal.util;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;

public final class PlatformDependent
{
  private static final int ANDROID_API_VERSION;
  public static final int ANDROID_API_VERSION_IS_NOT_ANDROID = 0;
  private static final boolean IS_ANDROID;
  
  static
  {
    int i = resolveAndroidApiVersion();
    ANDROID_API_VERSION = i;
    boolean bool;
    if (i != 0) {
      bool = true;
    } else {
      bool = false;
    }
    IS_ANDROID = bool;
  }
  
  public static int getAndroidApiVersion()
  {
    return ANDROID_API_VERSION;
  }
  
  static ClassLoader getSystemClassLoader()
  {
    if (System.getSecurityManager() == null) {
      return ClassLoader.getSystemClassLoader();
    }
    (ClassLoader)AccessController.doPrivileged(new PrivilegedAction()
    {
      public ClassLoader run()
      {
        return ClassLoader.getSystemClassLoader();
      }
    });
  }
  
  public static boolean isAndroid()
  {
    return IS_ANDROID;
  }
  
  private static int resolveAndroidApiVersion()
  {
    try
    {
      int i = ((Integer)Class.forName("android.os.Build$VERSION", true, getSystemClassLoader()).getField("SDK_INT").get(null)).intValue();
      return i;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\util\PlatformDependent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */