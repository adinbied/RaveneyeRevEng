package org.greenrobot.eventbus.android;

import android.util.Log;
import java.util.logging.Level;
import org.greenrobot.eventbus.Logger;

public class AndroidLogger
  implements Logger
{
  private static final boolean ANDROID_LOG_AVAILABLE;
  private final String tag;
  
  static
  {
    boolean bool = false;
    try
    {
      Class localClass = Class.forName("android.util.Log");
      if (localClass != null) {
        bool = true;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;) {}
    }
    ANDROID_LOG_AVAILABLE = bool;
  }
  
  public AndroidLogger(String paramString)
  {
    this.tag = paramString;
  }
  
  public static boolean isAndroidLogAvailable()
  {
    return ANDROID_LOG_AVAILABLE;
  }
  
  private int mapLevel(Level paramLevel)
  {
    int i = paramLevel.intValue();
    if (i < 800)
    {
      if (i < 500) {
        return 2;
      }
      return 3;
    }
    if (i < 900) {
      return 4;
    }
    if (i < 1000) {
      return 5;
    }
    return 6;
  }
  
  public void log(Level paramLevel, String paramString)
  {
    if (paramLevel != Level.OFF) {
      Log.println(mapLevel(paramLevel), this.tag, paramString);
    }
  }
  
  public void log(Level paramLevel, String paramString, Throwable paramThrowable)
  {
    if (paramLevel != Level.OFF)
    {
      int i = mapLevel(paramLevel);
      paramLevel = this.tag;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("\n");
      localStringBuilder.append(Log.getStackTraceString(paramThrowable));
      Log.println(i, paramLevel, localStringBuilder.toString());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\greenrobot\eventbus\android\AndroidLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */