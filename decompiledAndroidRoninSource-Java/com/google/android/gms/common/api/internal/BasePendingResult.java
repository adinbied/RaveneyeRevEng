package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public abstract class BasePendingResult<R extends Result>
  extends PendingResult<R>
{
  static final ThreadLocal<Boolean> zadn = new zap();
  private zaa mResultGuardian;
  private Status mStatus;
  private R zacj;
  private final Object zado = new Object();
  private final CallbackHandler<R> zadp;
  private final WeakReference<GoogleApiClient> zadq;
  private final CountDownLatch zadr = new CountDownLatch(1);
  private final ArrayList<PendingResult.StatusListener> zads = new ArrayList();
  private ResultCallback<? super R> zadt;
  private final AtomicReference<zacs> zadu = new AtomicReference();
  private volatile boolean zadv;
  private boolean zadw;
  private boolean zadx;
  private ICancelToken zady;
  private volatile zacm<R> zadz;
  private boolean zaea = false;
  
  @Deprecated
  BasePendingResult()
  {
    this.zadp = new CallbackHandler(Looper.getMainLooper());
    this.zadq = new WeakReference(null);
  }
  
  @Deprecated
  protected BasePendingResult(Looper paramLooper)
  {
    this.zadp = new CallbackHandler(paramLooper);
    this.zadq = new WeakReference(null);
  }
  
  protected BasePendingResult(GoogleApiClient paramGoogleApiClient)
  {
    Looper localLooper;
    if (paramGoogleApiClient != null) {
      localLooper = paramGoogleApiClient.getLooper();
    } else {
      localLooper = Looper.getMainLooper();
    }
    this.zadp = new CallbackHandler(localLooper);
    this.zadq = new WeakReference(paramGoogleApiClient);
  }
  
  protected BasePendingResult(CallbackHandler<R> paramCallbackHandler)
  {
    this.zadp = ((CallbackHandler)Preconditions.checkNotNull(paramCallbackHandler, "CallbackHandler must not be null"));
    this.zadq = new WeakReference(null);
  }
  
  private final R get()
  {
    for (;;)
    {
      synchronized (this.zado)
      {
        if (!this.zadv)
        {
          bool = true;
          Preconditions.checkState(bool, "Result has already been consumed.");
          Preconditions.checkState(isReady(), "Result is not ready.");
          Result localResult = this.zacj;
          this.zacj = null;
          this.zadt = null;
          this.zadv = true;
          ??? = (zacs)this.zadu.getAndSet(null);
          if (??? != null) {
            ((zacs)???).zac(this);
          }
          return localResult;
        }
      }
      boolean bool = false;
    }
  }
  
  private final void zaa(R paramR)
  {
    this.zacj = paramR;
    this.zady = null;
    this.zadr.countDown();
    this.mStatus = this.zacj.getStatus();
    if (this.zadw)
    {
      this.zadt = null;
    }
    else if (this.zadt == null)
    {
      if ((this.zacj instanceof Releasable)) {
        this.mResultGuardian = new zaa(null);
      }
    }
    else
    {
      this.zadp.removeMessages(2);
      this.zadp.zaa(this.zadt, get());
    }
    paramR = (ArrayList)this.zads;
    int j = paramR.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = paramR.get(i);
      i += 1;
      ((PendingResult.StatusListener)localObject).onComplete(this.mStatus);
    }
    this.zads.clear();
  }
  
  public static void zab(Result paramResult)
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
        Log.w("BasePendingResult", localStringBuilder.toString(), localRuntimeException);
      }
    }
  }
  
  public final void addStatusListener(PendingResult.StatusListener paramStatusListener)
  {
    boolean bool;
    if (paramStatusListener != null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "Callback cannot be null.");
    synchronized (this.zado)
    {
      if (isReady()) {
        paramStatusListener.onComplete(this.mStatus);
      } else {
        this.zads.add(paramStatusListener);
      }
      return;
    }
  }
  
  public final R await()
  {
    Preconditions.checkNotMainThread("await must not be called on the UI thread");
    boolean bool2 = this.zadv;
    boolean bool1 = true;
    Preconditions.checkState(bool2 ^ true, "Result has already been consumed");
    if (this.zadz != null) {
      bool1 = false;
    }
    Preconditions.checkState(bool1, "Cannot await if then() has been called.");
    try
    {
      this.zadr.await();
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
    zab(Status.RESULT_INTERRUPTED);
    Preconditions.checkState(isReady(), "Result is not ready.");
    return get();
  }
  
  public final R await(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong > 0L) {
      Preconditions.checkNotMainThread("await must not be called on the UI thread when time is greater than zero.");
    }
    boolean bool2 = this.zadv;
    boolean bool1 = true;
    Preconditions.checkState(bool2 ^ true, "Result has already been consumed.");
    if (this.zadz != null) {
      bool1 = false;
    }
    Preconditions.checkState(bool1, "Cannot await if then() has been called.");
    try
    {
      if (this.zadr.await(paramLong, paramTimeUnit)) {
        break label80;
      }
      zab(Status.RESULT_TIMEOUT);
    }
    catch (InterruptedException paramTimeUnit)
    {
      for (;;) {}
    }
    zab(Status.RESULT_INTERRUPTED);
    label80:
    Preconditions.checkState(isReady(), "Result is not ready.");
    return get();
  }
  
  public void cancel()
  {
    synchronized (this.zado)
    {
      if ((!this.zadw) && (!this.zadv))
      {
        ICancelToken localICancelToken = this.zady;
        if (localICancelToken == null) {}
      }
    }
    try
    {
      this.zady.cancel();
      zab(this.zacj);
      this.zadw = true;
      zaa(createFailedResult(Status.RESULT_CANCELED));
      return;
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
  
  protected abstract R createFailedResult(Status paramStatus);
  
  public boolean isCanceled()
  {
    synchronized (this.zado)
    {
      boolean bool = this.zadw;
      return bool;
    }
  }
  
  public final boolean isReady()
  {
    return this.zadr.getCount() == 0L;
  }
  
  protected final void setCancelToken(ICancelToken paramICancelToken)
  {
    synchronized (this.zado)
    {
      this.zady = paramICancelToken;
      return;
    }
  }
  
  public final void setResult(R paramR)
  {
    for (;;)
    {
      synchronized (this.zado)
      {
        if ((!this.zadx) && (!this.zadw))
        {
          isReady();
          bool1 = isReady();
          boolean bool2 = true;
          if (!bool1)
          {
            bool1 = true;
            Preconditions.checkState(bool1, "Results have already been set");
            if (this.zadv) {
              break label98;
            }
            bool1 = bool2;
            Preconditions.checkState(bool1, "Result has already been consumed");
            zaa(paramR);
          }
        }
        else
        {
          zab(paramR);
          return;
        }
      }
      boolean bool1 = false;
      continue;
      label98:
      bool1 = false;
    }
  }
  
  public final void setResultCallback(ResultCallback<? super R> paramResultCallback)
  {
    Object localObject = this.zado;
    if (paramResultCallback == null) {}
    try
    {
      this.zadt = null;
      return;
    }
    finally {}
    boolean bool1 = this.zadv;
    boolean bool2 = true;
    if (!bool1)
    {
      bool1 = true;
      Preconditions.checkState(bool1, "Result has already been consumed.");
      if (this.zadz != null) {
        break label116;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      Preconditions.checkState(bool1, "Cannot set callbacks if then() has been called.");
      if (isCanceled()) {
        return;
      }
      if (isReady()) {
        this.zadp.zaa(paramResultCallback, get());
      } else {
        this.zadt = paramResultCallback;
      }
      return;
      bool1 = false;
      break;
      label116:
      bool1 = false;
    }
  }
  
  public final void setResultCallback(ResultCallback<? super R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit)
  {
    Object localObject = this.zado;
    if (paramResultCallback == null) {}
    try
    {
      this.zadt = null;
      return;
    }
    finally {}
    boolean bool1 = this.zadv;
    boolean bool2 = true;
    if (!bool1)
    {
      bool1 = true;
      Preconditions.checkState(bool1, "Result has already been consumed.");
      if (this.zadz != null) {
        break label149;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      Preconditions.checkState(bool1, "Cannot set callbacks if then() has been called.");
      if (isCanceled()) {
        return;
      }
      if (isReady())
      {
        this.zadp.zaa(paramResultCallback, get());
      }
      else
      {
        this.zadt = paramResultCallback;
        paramResultCallback = this.zadp;
        paramLong = paramTimeUnit.toMillis(paramLong);
        paramResultCallback.sendMessageDelayed(paramResultCallback.obtainMessage(2, this), paramLong);
      }
      return;
      bool1 = false;
      break;
      label149:
      bool1 = false;
    }
  }
  
  public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> paramResultTransform)
  {
    Preconditions.checkState(this.zadv ^ true, "Result has already been consumed.");
    for (;;)
    {
      synchronized (this.zado)
      {
        zacm localzacm = this.zadz;
        boolean bool2 = false;
        if (localzacm == null)
        {
          bool1 = true;
          Preconditions.checkState(bool1, "Cannot call then() twice.");
          if (this.zadt != null) {
            break label160;
          }
          bool1 = true;
          Preconditions.checkState(bool1, "Cannot call then() if callbacks are set.");
          bool1 = bool2;
          if (!this.zadw) {
            bool1 = true;
          }
          Preconditions.checkState(bool1, "Cannot call then() if result was canceled.");
          this.zaea = true;
          this.zadz = new zacm(this.zadq);
          paramResultTransform = this.zadz.then(paramResultTransform);
          if (isReady()) {
            this.zadp.zaa(this.zadz, get());
          } else {
            this.zadt = this.zadz;
          }
          return paramResultTransform;
        }
      }
      boolean bool1 = false;
      continue;
      label160:
      bool1 = false;
    }
  }
  
  public final void zaa(zacs paramzacs)
  {
    this.zadu.set(paramzacs);
  }
  
  public final void zab(Status paramStatus)
  {
    synchronized (this.zado)
    {
      if (!isReady())
      {
        setResult(createFailedResult(paramStatus));
        this.zadx = true;
      }
      return;
    }
  }
  
  public final Integer zam()
  {
    return null;
  }
  
  public final boolean zat()
  {
    synchronized (this.zado)
    {
      if (((GoogleApiClient)this.zadq.get() == null) || (!this.zaea)) {
        cancel();
      }
      boolean bool = isCanceled();
      return bool;
    }
  }
  
  public final void zau()
  {
    boolean bool;
    if ((!this.zaea) && (!((Boolean)zadn.get()).booleanValue())) {
      bool = false;
    } else {
      bool = true;
    }
    this.zaea = bool;
  }
  
  public static class CallbackHandler<R extends Result>
    extends com.google.android.gms.internal.base.zap
  {
    public CallbackHandler()
    {
      this(Looper.getMainLooper());
    }
    
    public CallbackHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      int i = paramMessage.what;
      if (i != 1)
      {
        if (i != 2)
        {
          i = paramMessage.what;
          paramMessage = new StringBuilder(45);
          paramMessage.append("Don't know how to handle message: ");
          paramMessage.append(i);
          Log.wtf("BasePendingResult", paramMessage.toString(), new Exception());
          return;
        }
        ((BasePendingResult)paramMessage.obj).zab(Status.RESULT_TIMEOUT);
        return;
      }
      Object localObject = (Pair)paramMessage.obj;
      paramMessage = (ResultCallback)((Pair)localObject).first;
      localObject = (Result)((Pair)localObject).second;
      try
      {
        paramMessage.onResult((Result)localObject);
        return;
      }
      catch (RuntimeException paramMessage)
      {
        BasePendingResult.zab((Result)localObject);
        throw paramMessage;
      }
    }
    
    public final void zaa(ResultCallback<? super R> paramResultCallback, R paramR)
    {
      sendMessage(obtainMessage(1, new Pair(paramResultCallback, paramR)));
    }
  }
  
  private final class zaa
  {
    private zaa() {}
    
    protected final void finalize()
      throws Throwable
    {
      BasePendingResult.zab(BasePendingResult.zaa(BasePendingResult.this));
      super.finalize();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\BasePendingResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */