package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageManager;

public class m
{
  public static boolean a(Context paramContext, String paramString)
  {
    String str = paramContext.getPackageName();
    return paramContext.getPackageManager().checkPermission(paramString, str) == 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */