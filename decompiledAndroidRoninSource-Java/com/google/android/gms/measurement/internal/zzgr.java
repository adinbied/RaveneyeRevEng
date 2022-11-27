package com.google.android.gms.measurement.internal;

abstract class zzgr
  extends zzgo
{
  private boolean zza;
  
  zzgr(zzfv paramzzfv)
  {
    super(paramzzfv);
    this.zzy.zza(this);
  }
  
  protected void g_() {}
  
  protected final void zzaa()
  {
    if (zzz()) {
      return;
    }
    throw new IllegalStateException("Not initialized");
  }
  
  public final void zzab()
  {
    if (!this.zza)
    {
      if (!zzd())
      {
        this.zzy.zzae();
        this.zza = true;
      }
      return;
    }
    throw new IllegalStateException("Can't initialize twice");
  }
  
  public final void zzac()
  {
    if (!this.zza)
    {
      g_();
      this.zzy.zzae();
      this.zza = true;
      return;
    }
    throw new IllegalStateException("Can't initialize twice");
  }
  
  protected abstract boolean zzd();
  
  final boolean zzz()
  {
    return this.zza;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */