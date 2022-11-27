package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

public class ClientLibraryUtils
{
  public static int getClientVersion(Context paramContext, String paramString)
  {
    paramContext = zzb(paramContext, paramString);
    if (paramContext != null)
    {
      if (paramContext.applicationInfo == null) {
        return -1;
      }
      paramContext = paramContext.applicationInfo.metaData;
      if (paramContext == null) {
        return -1;
      }
      return paramContext.getInt("com.google.android.gms.version", -1);
    }
    return -1;
  }
  
  public static boolean isPackageSide()
  {
    return false;
  }
  
  private static PackageInfo zzb(Context paramContext, String paramString)
  {
    try
    {
      paramContext = Wrappers.packageManager(paramContext).getPackageInfo(paramString, 128);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static boolean zzc(Context paramContext, String paramString)
  {
    "com.google.android.gms".equals(paramString);
    try
    {
      int i = Wrappers.packageManager(paramContext).getApplicationInfo(paramString, 0).flags;
      return (i & 0x200000) != 0;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\commo\\util\ClientLibraryUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */