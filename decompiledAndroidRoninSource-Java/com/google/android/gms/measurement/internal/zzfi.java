package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzd;
import java.util.List;

public final class zzfi
{
  final zzfv zza;
  
  zzfi(zzfv paramzzfv)
  {
    this.zza = paramzzfv;
  }
  
  private final boolean zza()
  {
    boolean bool = false;
    try
    {
      PackageManagerWrapper localPackageManagerWrapper = Wrappers.packageManager(this.zza.zzm());
      if (localPackageManagerWrapper == null)
      {
        this.zza.zzq().zzw().zza("Failed to get PackageManager for Install Referrer Play Store compatibility check");
        return false;
      }
      int i = localPackageManagerWrapper.getPackageInfo("com.android.vending", 128).versionCode;
      if (i >= 80837300) {
        bool = true;
      }
      return bool;
    }
    catch (Exception localException)
    {
      this.zza.zzq().zzw().zza("Failed to retrieve Play Store version for Install Referrer", localException);
    }
    return false;
  }
  
  final Bundle zza(String paramString, zzd paramzzd)
  {
    this.zza.zzp().zzc();
    if (paramzzd == null)
    {
      this.zza.zzq().zzh().zza("Attempting to use Install Referrer Service while it is not initialized");
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("package_name", paramString);
    try
    {
      paramString = paramzzd.zza(localBundle);
      if (paramString == null)
      {
        this.zza.zzq().zze().zza("Install Referrer Service returned a null response");
        return null;
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      this.zza.zzq().zze().zza("Exception occurred while retrieving the Install Referrer", paramString.getMessage());
    }
    return null;
  }
  
  protected final void zza(String paramString)
  {
    Object localObject1;
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      this.zza.zzp().zzc();
      if (!zza())
      {
        this.zza.zzq().zzu().zza("Install Referrer Reporter is not available");
        return;
      }
      paramString = new zzfl(this, paramString);
      this.zza.zzp().zzc();
      localObject1 = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
      ((Intent)localObject1).setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
      Object localObject2 = this.zza.zzm().getPackageManager();
      if (localObject2 == null)
      {
        this.zza.zzq().zzi().zza("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
        return;
      }
      localObject2 = ((PackageManager)localObject2).queryIntentServices((Intent)localObject1, 0);
      if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
      {
        localObject2 = (ResolveInfo)((List)localObject2).get(0);
        if (((ResolveInfo)localObject2).serviceInfo != null)
        {
          String str = ((ResolveInfo)localObject2).serviceInfo.packageName;
          if ((((ResolveInfo)localObject2).serviceInfo.name != null) && ("com.android.vending".equals(str)) && (zza())) {
            localObject1 = new Intent((Intent)localObject1);
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        boolean bool = ConnectionTracker.getInstance().bindService(this.zza.zzm(), (Intent)localObject1, paramString, 1);
        localObject1 = this.zza.zzq().zzw();
        if (!bool) {
          break label333;
        }
        paramString = "available";
        ((zzet)localObject1).zza("Install Referrer Service is", paramString);
        return;
      }
      catch (Exception paramString)
      {
        this.zza.zzq().zze().zza("Exception occurred while binding to Install Referrer Service", paramString.getMessage());
        return;
      }
      this.zza.zzq().zzh().zza("Play Store version 8.3.73 or higher required for Install Referrer");
      return;
      this.zza.zzq().zzu().zza("Play Service for fetching Install Referrer is unavailable on device");
      return;
      this.zza.zzq().zzi().zza("Install Referrer Reporter was called with invalid app package name");
      return;
      label333:
      paramString = "not available";
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzfi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */