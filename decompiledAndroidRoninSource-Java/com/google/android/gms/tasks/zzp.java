package com.google.android.gms.tasks;

import java.util.concurrent.CancellationException;

final class zzp
  implements Runnable
{
  zzp(zzo paramzzo, Task paramTask) {}
  
  public final void run()
  {
    try
    {
      Task localTask = zzo.zza(this.zzs).then(this.zzg.getResult());
      if (localTask == null)
      {
        this.zzs.onFailure(new NullPointerException("Continuation returned null"));
        return;
      }
      localTask.addOnSuccessListener(TaskExecutors.zzw, this.zzs);
      localTask.addOnFailureListener(TaskExecutors.zzw, this.zzs);
      localTask.addOnCanceledListener(TaskExecutors.zzw, this.zzs);
      return;
    }
    catch (Exception localException)
    {
      this.zzs.onFailure(localException);
      return;
      this.zzs.onCanceled();
      return;
    }
    catch (RuntimeExecutionException localRuntimeExecutionException)
    {
      if ((localRuntimeExecutionException.getCause() instanceof Exception))
      {
        this.zzs.onFailure((Exception)localRuntimeExecutionException.getCause());
        return;
      }
      this.zzs.onFailure(localRuntimeExecutionException);
      return;
    }
    catch (CancellationException localCancellationException)
    {
      for (;;) {}
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\tasks\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */