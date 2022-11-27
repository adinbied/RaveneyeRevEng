package com.google.android.gms.measurement.internal;

abstract class zzkj
  extends zzkg
{
  private boolean zzb;
  
  zzkj(zzki paramzzki)
  {
    super(paramzzki);
    this.zza.zza(this);
  }
  
  final boolean zzai()
  {
    return this.zzb;
  }
  
  protected final void zzaj()
  {
    if (zzai()) {
      return;
    }
    throw new IllegalStateException("Not initialized");
  }
  
  public final void zzak()
  {
    if (!this.zzb)
    {
      zzd();
      this.zza.zzs();
      this.zzb = true;
      return;
    }
    throw new IllegalStateException("Can't initialize twice");
  }
  
  protected abstract boolean zzd();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzkj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */