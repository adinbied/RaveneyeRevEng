package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;

final class zzac
  extends zzak
{
  private final BaseImplementation.ResultHolder<Status> zzcq;
  
  public zzac(BaseImplementation.ResultHolder<Status> paramResultHolder)
  {
    this.zzcq = paramResultHolder;
  }
  
  public final void zza(zzad paramzzad)
  {
    this.zzcq.setResult(paramzzad.getStatus());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\location\zzac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */