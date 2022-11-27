package com.google.android.gms.internal.fitness;

import android.util.Log;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.fitness.result.DataReadResult;

final class zzds
  extends zzbi
{
  private final BaseImplementation.ResultHolder<DataReadResult> zzev;
  private int zzfp = 0;
  private DataReadResult zzfq = null;
  
  private zzds(BaseImplementation.ResultHolder<DataReadResult> paramResultHolder)
  {
    this.zzev = paramResultHolder;
  }
  
  public final void zza(DataReadResult paramDataReadResult)
  {
    try
    {
      if (Log.isLoggable("Fitness", 2))
      {
        i = this.zzfp;
        StringBuilder localStringBuilder = new StringBuilder(33);
        localStringBuilder.append("Received batch result ");
        localStringBuilder.append(i);
        Log.v("Fitness", localStringBuilder.toString());
      }
      if (this.zzfq == null) {
        this.zzfq = paramDataReadResult;
      } else {
        this.zzfq.zzb(paramDataReadResult);
      }
      int i = this.zzfp + 1;
      this.zzfp = i;
      if (i == this.zzfq.zzaa()) {
        this.zzev.setResult(this.zzfq);
      }
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */