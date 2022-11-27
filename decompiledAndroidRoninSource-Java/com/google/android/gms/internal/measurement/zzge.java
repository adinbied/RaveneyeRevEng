package com.google.android.gms.internal.measurement;

import java.util.List;

final class zzge
  extends zzga
{
  private final zzgd zza = new zzgd();
  
  public final void zza(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    if (paramThrowable2 != paramThrowable1)
    {
      if (paramThrowable2 != null)
      {
        this.zza.zza(paramThrowable1, true).add(paramThrowable2);
        return;
      }
      throw new NullPointerException("The suppressed exception cannot be null.");
    }
    throw new IllegalArgumentException("Self suppression is not allowed.", paramThrowable2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */