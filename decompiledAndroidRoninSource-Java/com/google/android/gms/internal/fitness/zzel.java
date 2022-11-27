package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.fitness.result.SessionReadResult;

final class zzel
  extends zzcl
{
  private final BaseImplementation.ResultHolder<SessionReadResult> zzev;
  
  private zzel(BaseImplementation.ResultHolder<SessionReadResult> paramResultHolder)
  {
    this.zzev = paramResultHolder;
  }
  
  public final void zza(SessionReadResult paramSessionReadResult)
    throws RemoteException
  {
    this.zzev.setResult(paramSessionReadResult);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */