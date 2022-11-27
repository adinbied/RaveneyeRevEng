package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.fitness.result.SessionStopResult;

final class zzem
  extends zzco
{
  private final BaseImplementation.ResultHolder<SessionStopResult> zzev;
  
  private zzem(BaseImplementation.ResultHolder<SessionStopResult> paramResultHolder)
  {
    this.zzev = paramResultHolder;
  }
  
  public final void zza(SessionStopResult paramSessionStopResult)
  {
    this.zzev.setResult(paramSessionStopResult);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */