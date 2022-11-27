package com.google.android.gms.tasks;

final class zza
  extends CancellationToken
{
  private final zzu<Void> zza = new zzu();
  
  public final void cancel()
  {
    this.zza.trySetResult(null);
  }
  
  public final boolean isCancellationRequested()
  {
    return this.zza.isComplete();
  }
  
  public final CancellationToken onCanceledRequested(OnTokenCanceledListener paramOnTokenCanceledListener)
  {
    this.zza.addOnSuccessListener(new zzb(this, paramOnTokenCanceledListener));
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\tasks\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */