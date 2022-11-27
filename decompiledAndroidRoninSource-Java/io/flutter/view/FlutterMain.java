package io.flutter.view;

import android.content.Context;
import android.os.Handler;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.loader.FlutterLoader.Settings;

public class FlutterMain
{
  private static boolean isRunningInRobolectricTest;
  
  public static void ensureInitializationComplete(Context paramContext, String[] paramArrayOfString)
  {
    if (isRunningInRobolectricTest) {
      return;
    }
    FlutterLoader.getInstance().ensureInitializationComplete(paramContext, paramArrayOfString);
  }
  
  public static void ensureInitializationCompleteAsync(Context paramContext, String[] paramArrayOfString, Handler paramHandler, Runnable paramRunnable)
  {
    if (isRunningInRobolectricTest) {
      return;
    }
    FlutterLoader.getInstance().ensureInitializationCompleteAsync(paramContext, paramArrayOfString, paramHandler, paramRunnable);
  }
  
  public static String findAppBundlePath()
  {
    return FlutterLoader.getInstance().findAppBundlePath();
  }
  
  @Deprecated
  public static String findAppBundlePath(Context paramContext)
  {
    return FlutterLoader.getInstance().findAppBundlePath();
  }
  
  public static String getLookupKeyForAsset(String paramString)
  {
    return FlutterLoader.getInstance().getLookupKeyForAsset(paramString);
  }
  
  public static String getLookupKeyForAsset(String paramString1, String paramString2)
  {
    return FlutterLoader.getInstance().getLookupKeyForAsset(paramString1, paramString2);
  }
  
  @Deprecated
  public static void setIsRunningInRobolectricTest(boolean paramBoolean)
  {
    isRunningInRobolectricTest = paramBoolean;
  }
  
  public static void startInitialization(Context paramContext)
  {
    if (isRunningInRobolectricTest) {
      return;
    }
    FlutterLoader.getInstance().startInitialization(paramContext);
  }
  
  public static void startInitialization(Context paramContext, Settings paramSettings)
  {
    if (isRunningInRobolectricTest) {
      return;
    }
    FlutterLoader.Settings localSettings = new FlutterLoader.Settings();
    localSettings.setLogTag(paramSettings.getLogTag());
    FlutterLoader.getInstance().startInitialization(paramContext, localSettings);
  }
  
  public static class Settings
  {
    private String logTag;
    
    public String getLogTag()
    {
      return this.logTag;
    }
    
    public void setLogTag(String paramString)
    {
      this.logTag = paramString;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\view\FlutterMain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */