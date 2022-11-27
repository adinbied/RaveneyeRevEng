package com.google.android.gms.common.wrappers;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Binder;
import android.os.Process;
import com.google.android.gms.common.util.PlatformVersion;

public class PackageManagerWrapper
{
  private final Context zzhx;
  
  public PackageManagerWrapper(Context paramContext)
  {
    this.zzhx = paramContext;
  }
  
  public int checkCallingOrSelfPermission(String paramString)
  {
    return this.zzhx.checkCallingOrSelfPermission(paramString);
  }
  
  public int checkPermission(String paramString1, String paramString2)
  {
    return this.zzhx.getPackageManager().checkPermission(paramString1, paramString2);
  }
  
  public ApplicationInfo getApplicationInfo(String paramString, int paramInt)
    throws PackageManager.NameNotFoundException
  {
    return this.zzhx.getPackageManager().getApplicationInfo(paramString, paramInt);
  }
  
  public CharSequence getApplicationLabel(String paramString)
    throws PackageManager.NameNotFoundException
  {
    return this.zzhx.getPackageManager().getApplicationLabel(this.zzhx.getPackageManager().getApplicationInfo(paramString, 0));
  }
  
  public PackageInfo getPackageInfo(String paramString, int paramInt)
    throws PackageManager.NameNotFoundException
  {
    return this.zzhx.getPackageManager().getPackageInfo(paramString, paramInt);
  }
  
  public final String[] getPackagesForUid(int paramInt)
  {
    return this.zzhx.getPackageManager().getPackagesForUid(paramInt);
  }
  
  public boolean isCallerInstantApp()
  {
    if (Binder.getCallingUid() == Process.myUid()) {
      return InstantApps.isInstantApp(this.zzhx);
    }
    if (PlatformVersion.isAtLeastO())
    {
      String str = this.zzhx.getPackageManager().getNameForUid(Binder.getCallingUid());
      if (str != null) {
        return this.zzhx.getPackageManager().isInstantApp(str);
      }
    }
    return false;
  }
  
  public final PackageInfo zza(String paramString, int paramInt1, int paramInt2)
    throws PackageManager.NameNotFoundException
  {
    return this.zzhx.getPackageManager().getPackageInfo(paramString, 64);
  }
  
  public final boolean zzb(int paramInt, String paramString)
  {
    if (PlatformVersion.isAtLeastKitKat()) {}
    try
    {
      ((AppOpsManager)this.zzhx.getSystemService("appops")).checkPackage(paramInt, paramString);
      return true;
    }
    catch (SecurityException paramString) {}
    String[] arrayOfString = this.zzhx.getPackageManager().getPackagesForUid(paramInt);
    if ((paramString != null) && (arrayOfString != null))
    {
      paramInt = 0;
      while (paramInt < arrayOfString.length)
      {
        if (paramString.equals(arrayOfString[paramInt])) {
          return true;
        }
        paramInt += 1;
      }
    }
    return false;
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\wrappers\PackageManagerWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */