package com.google.android.gms.tasks;

final class zzf
  implements Runnable
{
  zzf(zze paramzze, Task paramTask) {}
  
  public final void run()
  {
    try
    {
      Task localTask = (Task)zze.zza(this.zzi).then(this.zzg);
      if (localTask == null)
      {
        this.zzi.onFailure(new NullPointerException("Continuation returned null"));
        return;
      }
      localTask.addOnSuccessListener(TaskExecutors.zzw, this.zzi);
      localTask.addOnFailureListener(TaskExecutors.zzw, this.zzi);
      localTask.addOnCanceledListener(TaskExecutors.zzw, this.zzi);
      return;
    }
    catch (Exception localException)
    {
      zze.zzb(this.zzi).setException(localException);
      return;
    }
    catch (RuntimeExecutionException localRuntimeExecutionException)
    {
      if ((localRuntimeExecutionException.getCause() instanceof Exception))
      {
        zze.zzb(this.zzi).setException((Exception)localRuntimeExecutionException.getCause());
        return;
      }
      zze.zzb(this.zzi).setException(localRuntimeExecutionException);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\tasks\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */