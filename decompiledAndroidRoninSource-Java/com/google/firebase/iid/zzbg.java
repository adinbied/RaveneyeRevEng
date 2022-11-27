package com.google.firebase.iid;

import android.content.Intent;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbg
{
  final Intent zza;
  private final TaskCompletionSource<Void> zzb = new TaskCompletionSource();
  
  zzbg(Intent paramIntent)
  {
    this.zza = paramIntent;
  }
  
  final Task<Void> zza()
  {
    return this.zzb.getTask();
  }
  
  final void zzb()
  {
    this.zzb.trySetResult(null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\iid\zzbg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */