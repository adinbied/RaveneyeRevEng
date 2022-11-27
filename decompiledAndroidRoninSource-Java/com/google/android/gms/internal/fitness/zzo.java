package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.fitness.result.DataSourcesResult;

public final class zzo
  extends zzbl
{
  private final BaseImplementation.ResultHolder<DataSourcesResult> zzev;
  
  public zzo(BaseImplementation.ResultHolder<DataSourcesResult> paramResultHolder)
  {
    this.zzev = paramResultHolder;
  }
  
  public final void zza(DataSourcesResult paramDataSourcesResult)
  {
    this.zzev.setResult(paramDataSourcesResult);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */