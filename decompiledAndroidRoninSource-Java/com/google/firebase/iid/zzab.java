package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.firebase_messaging.zza;
import com.google.android.gms.internal.firebase_messaging.zzb;
import com.google.android.gms.internal.firebase_messaging.zzf;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.ScheduledExecutorService;

public final class zzab
{
  private static zzab zza;
  private final Context zzb;
  private final ScheduledExecutorService zzc;
  private zzac zzd = new zzac(this, null);
  private int zze = 1;
  
  private zzab(Context paramContext, ScheduledExecutorService paramScheduledExecutorService)
  {
    this.zzc = paramScheduledExecutorService;
    this.zzb = paramContext.getApplicationContext();
  }
  
  private final int zza()
  {
    try
    {
      int i = this.zze;
      this.zze = (i + 1);
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private final <T> Task<T> zza(zzan<T> paramzzan)
  {
    try
    {
      Object localObject;
      if (Log.isLoggable("MessengerIpcClient", 3))
      {
        localObject = String.valueOf(paramzzan);
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject).length() + 9);
        localStringBuilder.append("Queueing ");
        localStringBuilder.append((String)localObject);
        Log.d("MessengerIpcClient", localStringBuilder.toString());
      }
      if (!this.zzd.zza(paramzzan))
      {
        localObject = new zzac(this, null);
        this.zzd = ((zzac)localObject);
        ((zzac)localObject).zza(paramzzan);
      }
      paramzzan = paramzzan.zzb.getTask();
      return paramzzan;
    }
    finally {}
  }
  
  public static zzab zza(Context paramContext)
  {
    try
    {
      if (zza == null) {
        zza = new zzab(paramContext, zza.zza().zza(1, new NamedThreadFactory("MessengerIpcClient"), zzf.zzb));
      }
      paramContext = zza;
      return paramContext;
    }
    finally {}
  }
  
  public final Task<Void> zza(int paramInt, Bundle paramBundle)
  {
    return zza(new zzak(zza(), 2, paramBundle));
  }
  
  public final Task<Bundle> zzb(int paramInt, Bundle paramBundle)
  {
    return zza(new zzap(zza(), 1, paramBundle));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\iid\zzab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */