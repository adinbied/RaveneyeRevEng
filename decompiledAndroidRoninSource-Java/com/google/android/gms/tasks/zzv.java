package com.google.android.gms.tasks;

import java.util.concurrent.Callable;

final class zzv
  implements Runnable
{
  zzv(zzu paramzzu, Callable paramCallable) {}
  
  public final void run()
  {
    try
    {
      this.zzad.setResult(this.val$callable.call());
      return;
    }
    catch (Exception localException)
    {
      this.zzad.setException(localException);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\tasks\zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */