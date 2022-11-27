package io.flutter.util;

import android.content.Context;
import android.os.Build.VERSION;
import java.io.File;

public final class PathUtils
{
  public static String getCacheDirectory(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramContext.getCodeCacheDir().getPath();
    }
    return paramContext.getCacheDir().getPath();
  }
  
  public static String getDataDirectory(Context paramContext)
  {
    return paramContext.getDir("flutter", 0).getPath();
  }
  
  public static String getFilesDir(Context paramContext)
  {
    return paramContext.getFilesDir().getPath();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutte\\util\PathUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */