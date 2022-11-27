package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

final class zaj
  implements PendingResult.StatusListener
{
  zaj(PendingResult paramPendingResult, TaskCompletionSource paramTaskCompletionSource, PendingResultUtil.ResultConverter paramResultConverter, PendingResultUtil.zaa paramzaa) {}
  
  public final void onComplete(Status paramStatus)
  {
    if (paramStatus.isSuccess())
    {
      paramStatus = this.zaov.await(0L, TimeUnit.MILLISECONDS);
      this.zaow.setResult(this.zaox.convert(paramStatus));
      return;
    }
    this.zaow.setException(this.zaoy.zaf(paramStatus));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\internal\zaj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */