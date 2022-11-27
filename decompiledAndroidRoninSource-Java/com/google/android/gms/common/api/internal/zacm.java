package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

public final class zacm<R extends Result>
  extends TransformedResult<R>
  implements ResultCallback<R>
{
  private final Object zado = new Object();
  private final WeakReference<GoogleApiClient> zadq;
  private ResultTransform<? super R, ? extends Result> zako = null;
  private zacm<? extends Result> zakp = null;
  private volatile ResultCallbacks<? super R> zakq = null;
  private PendingResult<R> zakr = null;
  private Status zaks = null;
  private final zaco zakt;
  private boolean zaku = false;
  
  public zacm(WeakReference<GoogleApiClient> paramWeakReference)
  {
    Preconditions.checkNotNull(paramWeakReference, "GoogleApiClient reference must not be null");
    this.zadq = paramWeakReference;
    paramWeakReference = (GoogleApiClient)paramWeakReference.get();
    if (paramWeakReference != null) {
      paramWeakReference = paramWeakReference.getLooper();
    } else {
      paramWeakReference = Looper.getMainLooper();
    }
    this.zakt = new zaco(this, paramWeakReference);
  }
  
  private static void zab(Result paramResult)
  {
    if ((paramResult instanceof Releasable)) {
      try
      {
        ((Releasable)paramResult).release();
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        paramResult = String.valueOf(paramResult);
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramResult).length() + 18);
        localStringBuilder.append("Unable to release ");
        localStringBuilder.append(paramResult);
        Log.w("TransformedResultImpl", localStringBuilder.toString(), localRuntimeException);
      }
    }
  }
  
  private final void zabu()
  {
    if ((this.zako == null) && (this.zakq == null)) {
      return;
    }
    Object localObject = (GoogleApiClient)this.zadq.get();
    if ((!this.zaku) && (this.zako != null) && (localObject != null))
    {
      ((GoogleApiClient)localObject).zaa(this);
      this.zaku = true;
    }
    localObject = this.zaks;
    if (localObject != null)
    {
      zae((Status)localObject);
      return;
    }
    localObject = this.zakr;
    if (localObject != null) {
      ((PendingResult)localObject).setResultCallback(this);
    }
  }
  
  private final boolean zabw()
  {
    GoogleApiClient localGoogleApiClient = (GoogleApiClient)this.zadq.get();
    return (this.zakq != null) && (localGoogleApiClient != null);
  }
  
  private final void zad(Status paramStatus)
  {
    synchronized (this.zado)
    {
      this.zaks = paramStatus;
      zae(paramStatus);
      return;
    }
  }
  
  private final void zae(Status paramStatus)
  {
    synchronized (this.zado)
    {
      if (this.zako != null)
      {
        paramStatus = this.zako.onFailure(paramStatus);
        Preconditions.checkNotNull(paramStatus, "onFailure must not return null");
        this.zakp.zad(paramStatus);
      }
      else if (zabw())
      {
        this.zakq.onFailure(paramStatus);
      }
      return;
    }
  }
  
  public final void andFinally(ResultCallbacks<? super R> paramResultCallbacks)
  {
    for (;;)
    {
      synchronized (this.zado)
      {
        ResultCallbacks localResultCallbacks = this.zakq;
        boolean bool2 = true;
        if (localResultCallbacks == null)
        {
          bool1 = true;
          Preconditions.checkState(bool1, "Cannot call andFinally() twice.");
          if (this.zako != null) {
            break label75;
          }
          bool1 = bool2;
          Preconditions.checkState(bool1, "Cannot call then() and andFinally() on the same TransformedResult.");
          this.zakq = paramResultCallbacks;
          zabu();
          return;
        }
      }
      boolean bool1 = false;
      continue;
      label75:
      bool1 = false;
    }
  }
  
  public final void onResult(R paramR)
  {
    synchronized (this.zado)
    {
      if (paramR.getStatus().isSuccess())
      {
        if (this.zako != null) {
          zacc.zabb().submit(new zacn(this, paramR));
        } else if (zabw()) {
          this.zakq.onSuccess(paramR);
        }
      }
      else
      {
        zad(paramR.getStatus());
        zab(paramR);
      }
      return;
    }
  }
  
  public final <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> paramResultTransform)
  {
    for (;;)
    {
      synchronized (this.zado)
      {
        ResultTransform localResultTransform = this.zako;
        boolean bool2 = true;
        if (localResultTransform == null)
        {
          bool1 = true;
          Preconditions.checkState(bool1, "Cannot call then() twice.");
          if (this.zakq != null) {
            break label93;
          }
          bool1 = bool2;
          Preconditions.checkState(bool1, "Cannot call then() and andFinally() on the same TransformedResult.");
          this.zako = paramResultTransform;
          paramResultTransform = new zacm(this.zadq);
          this.zakp = paramResultTransform;
          zabu();
          return paramResultTransform;
        }
      }
      boolean bool1 = false;
      continue;
      label93:
      bool1 = false;
    }
  }
  
  public final void zaa(PendingResult<?> paramPendingResult)
  {
    synchronized (this.zado)
    {
      this.zakr = paramPendingResult;
      zabu();
      return;
    }
  }
  
  final void zabv()
  {
    this.zakq = null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zacm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */