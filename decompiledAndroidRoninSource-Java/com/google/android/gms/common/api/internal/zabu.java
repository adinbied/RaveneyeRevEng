package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;

public class zabu
  extends zal
{
  private TaskCompletionSource<Void> zajp = new TaskCompletionSource();
  
  private zabu(LifecycleFragment paramLifecycleFragment)
  {
    super(paramLifecycleFragment);
    this.mLifecycleFragment.addCallback("GmsAvailabilityHelper", this);
  }
  
  public static zabu zac(Activity paramActivity)
  {
    paramActivity = getFragment(paramActivity);
    zabu localzabu = (zabu)paramActivity.getCallbackOrNull("GmsAvailabilityHelper", zabu.class);
    if (localzabu != null)
    {
      if (localzabu.zajp.getTask().isComplete()) {
        localzabu.zajp = new TaskCompletionSource();
      }
      return localzabu;
    }
    return new zabu(paramActivity);
  }
  
  public final Task<Void> getTask()
  {
    return this.zajp.getTask();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.zajp.trySetException(new CancellationException("Host activity was destroyed before Google Play services could be made available."));
  }
  
  protected final void zaa(ConnectionResult paramConnectionResult, int paramInt)
  {
    this.zajp.setException(ApiExceptionUtil.fromStatus(new Status(paramConnectionResult.getErrorCode(), paramConnectionResult.getErrorMessage(), paramConnectionResult.getResolution())));
  }
  
  protected final void zao()
  {
    int i = this.zacd.isGooglePlayServicesAvailable(this.mLifecycleFragment.getLifecycleActivity());
    if (i == 0)
    {
      this.zajp.setResult(null);
      return;
    }
    if (!this.zajp.getTask().isComplete()) {
      zab(new ConnectionResult(i, null), 0);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zabu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */