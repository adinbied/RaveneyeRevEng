package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.internal.Preconditions;

public final class zzfn
{
  private final zzfm zza;
  
  public zzfn(zzfm paramzzfm)
  {
    Preconditions.checkNotNull(paramzzfm);
    this.zza = paramzzfm;
  }
  
  public static boolean zza(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      if (localPackageManager == null) {
        return false;
      }
      paramContext = localPackageManager.getReceiverInfo(new ComponentName(paramContext, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0);
      if (paramContext != null)
      {
        boolean bool = paramContext.enabled;
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  public final void zza(Context paramContext, Intent paramIntent)
  {
    zzer localzzer = zzfv.zza(paramContext, null, null).zzq();
    if (paramIntent == null)
    {
      localzzer.zzh().zza("Receiver called with null intent");
      return;
    }
    paramIntent = paramIntent.getAction();
    localzzer.zzw().zza("Local receiver got", paramIntent);
    if ("com.google.android.gms.measurement.UPLOAD".equals(paramIntent))
    {
      paramIntent = new Intent().setClassName(paramContext, "com.google.android.gms.measurement.AppMeasurementService");
      paramIntent.setAction("com.google.android.gms.measurement.UPLOAD");
      localzzer.zzw().zza("Starting wakeful intent.");
      this.zza.doStartService(paramContext, paramIntent);
      return;
    }
    if ("com.android.vending.INSTALL_REFERRER".equals(paramIntent)) {
      localzzer.zzh().zza("Install Referrer Broadcasts are deprecated");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzfn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */