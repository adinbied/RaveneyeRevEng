package com.google.firebase.iid;

import android.content.Intent;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutorService;

final class zzz
  implements zzb
{
  private final ExecutorService zza;
  
  zzz(ExecutorService paramExecutorService)
  {
    this.zza = paramExecutorService;
  }
  
  public final Task<Integer> zza(Intent paramIntent)
  {
    return Tasks.call(this.zza, new zzy(paramIntent));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\iid\zzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */