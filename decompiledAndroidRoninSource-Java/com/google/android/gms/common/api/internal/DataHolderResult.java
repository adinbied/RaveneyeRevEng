package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public class DataHolderResult
  implements Releasable, Result
{
  protected final DataHolder mDataHolder;
  protected final Status mStatus;
  
  protected DataHolderResult(DataHolder paramDataHolder)
  {
    this(paramDataHolder, new Status(paramDataHolder.getStatusCode()));
  }
  
  protected DataHolderResult(DataHolder paramDataHolder, Status paramStatus)
  {
    this.mStatus = paramStatus;
    this.mDataHolder = paramDataHolder;
  }
  
  public Status getStatus()
  {
    return this.mStatus;
  }
  
  public void release()
  {
    DataHolder localDataHolder = this.mDataHolder;
    if (localDataHolder != null) {
      localDataHolder.close();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\DataHolderResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */