package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.fitness.result.DataTypeResult;

final class zzdf
  extends zzbo
{
  private final BaseImplementation.ResultHolder<DataTypeResult> zzev;
  
  private zzdf(BaseImplementation.ResultHolder<DataTypeResult> paramResultHolder)
  {
    this.zzev = paramResultHolder;
  }
  
  public final void zza(DataTypeResult paramDataTypeResult)
  {
    this.zzev.setResult(paramDataTypeResult);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzdf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */