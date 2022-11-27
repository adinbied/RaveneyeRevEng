package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutorService;

public final class zza
  implements zzb
{
  private static final Object zza = new Object();
  private static zzbh zzb;
  private final Context zzc;
  private final ExecutorService zzd;
  
  public zza(Context paramContext, ExecutorService paramExecutorService)
  {
    this.zzc = paramContext;
    this.zzd = paramExecutorService;
  }
  
  private static zzbh zza(Context paramContext, String paramString)
  {
    synchronized (zza)
    {
      if (zzb == null) {
        zzb = new zzbh(paramContext, paramString);
      }
      paramContext = zzb;
      return paramContext;
    }
  }
  
  private static Task<Integer> zzb(Context paramContext, Intent paramIntent)
  {
    if (Log.isLoggable("FirebaseInstanceId", 3)) {
      Log.d("FirebaseInstanceId", "Binding to service");
    }
    return zza(paramContext, "com.google.firebase.MESSAGING_EVENT").zza(paramIntent).continueWith(zzh.zza(), zzf.zza);
  }
  
  public final Task<Integer> zza(Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("gcm.rawData64");
    int j = 0;
    if (localObject != null)
    {
      paramIntent.putExtra("rawData", Base64.decode((String)localObject, 0));
      paramIntent.removeExtra("gcm.rawData64");
    }
    localObject = this.zzc;
    int i;
    if ((PlatformVersion.isAtLeastO()) && (((Context)localObject).getApplicationInfo().targetSdkVersion >= 26)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramIntent.getFlags() & 0x10000000) != 0) {
      j = 1;
    }
    if ((i != 0) && (j == 0)) {
      return zzb((Context)localObject, paramIntent);
    }
    return Tasks.call(this.zzd, new zzd((Context)localObject, paramIntent)).continueWithTask(this.zzd, new zzc((Context)localObject, paramIntent));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\iid\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */