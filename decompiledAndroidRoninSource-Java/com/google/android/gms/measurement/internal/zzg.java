package com.google.android.gms.measurement.internal;

abstract class zzg
  extends zzd
{
  private boolean zza;
  
  zzg(zzfv paramzzfv)
  {
    super(paramzzfv);
    this.zzy.zza(this);
  }
  
  final boolean zzu()
  {
    return this.zza;
  }
  
  protected final void zzv()
  {
    if (zzu()) {
      return;
    }
    throw new IllegalStateException("Not initialized");
  }
  
  public final void zzw()
  {
    if (!this.zza)
    {
      if (!zzy())
      {
        this.zzy.zzae();
        this.zza = true;
      }
      return;
    }
    throw new IllegalStateException("Can't initialize twice");
  }
  
  public final void zzx()
  {
    if (!this.zza)
    {
      zzz();
      this.zzy.zzae();
      this.zza = true;
      return;
    }
    throw new IllegalStateException("Can't initialize twice");
  }
  
  protected abstract boolean zzy();
  
  protected void zzz() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */