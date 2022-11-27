package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

final class zaam
  implements BaseGmsClient.ConnectionProgressReportCallbacks
{
  private final Api<?> mApi;
  private final boolean zaec;
  private final WeakReference<zaak> zagk;
  
  public zaam(zaak paramzaak, Api<?> paramApi, boolean paramBoolean)
  {
    this.zagk = new WeakReference(paramzaak);
    this.mApi = paramApi;
    this.zaec = paramBoolean;
  }
  
  public final void onReportServiceBinding(ConnectionResult paramConnectionResult)
  {
    zaak localzaak = (zaak)this.zagk.get();
    if (localzaak == null) {
      return;
    }
    boolean bool;
    if (Looper.myLooper() == zaak.zad(localzaak).zaee.getLooper()) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
    zaak.zac(localzaak).lock();
    try
    {
      bool = zaak.zaa(localzaak, 0);
      if (!bool) {
        return;
      }
      if (!paramConnectionResult.isSuccess()) {
        zaak.zaa(localzaak, paramConnectionResult, this.mApi, this.zaec);
      }
      if (zaak.zal(localzaak)) {
        zaak.zak(localzaak);
      }
      return;
    }
    finally
    {
      zaak.zac(localzaak).unlock();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zaam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */