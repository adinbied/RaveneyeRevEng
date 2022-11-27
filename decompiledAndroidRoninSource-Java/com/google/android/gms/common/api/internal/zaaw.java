package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClientEventManager;
import com.google.android.gms.common.internal.GmsClientEventManager.GmsClientEventState;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.common.internal.service.zac;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class zaaw
  extends GoogleApiClient
  implements zabt
{
  private final Context mContext;
  private final Looper zabj;
  private final int zacb;
  private final GoogleApiAvailability zacd;
  private final Api.AbstractClientBuilder<? extends zad, SignInOptions> zace;
  private boolean zach;
  private final Lock zaeo;
  private final ClientSettings zaet;
  private final Map<Api<?>, Boolean> zaew;
  final Queue<BaseImplementation.ApiMethodImpl<?, ?>> zafc = new LinkedList();
  private final GmsClientEventManager zags;
  private zabs zagt = null;
  private volatile boolean zagu;
  private long zagv;
  private long zagw;
  private final zabb zagx;
  private zabq zagy;
  final Map<Api.AnyClientKey<?>, Api.Client> zagz;
  Set<Scope> zaha;
  private final ListenerHolders zahb;
  private final ArrayList<zaq> zahc;
  private Integer zahd;
  Set<zacm> zahe;
  final zacp zahf;
  private final GmsClientEventManager.GmsClientEventState zahg;
  
  public zaaw(Context paramContext, Lock paramLock, Looper paramLooper, ClientSettings paramClientSettings, GoogleApiAvailability paramGoogleApiAvailability, Api.AbstractClientBuilder<? extends zad, SignInOptions> paramAbstractClientBuilder, Map<Api<?>, Boolean> paramMap, List<GoogleApiClient.ConnectionCallbacks> paramList, List<GoogleApiClient.OnConnectionFailedListener> paramList1, Map<Api.AnyClientKey<?>, Api.Client> paramMap1, int paramInt1, int paramInt2, ArrayList<zaq> paramArrayList, boolean paramBoolean)
  {
    long l;
    if (ClientLibraryUtils.isPackageSide()) {
      l = 10000L;
    } else {
      l = 120000L;
    }
    this.zagv = l;
    this.zagw = 5000L;
    this.zaha = new HashSet();
    this.zahb = new ListenerHolders();
    this.zahd = null;
    this.zahe = null;
    zaax localzaax = new zaax(this);
    this.zahg = localzaax;
    this.mContext = paramContext;
    this.zaeo = paramLock;
    this.zach = false;
    this.zags = new GmsClientEventManager(paramLooper, localzaax);
    this.zabj = paramLooper;
    this.zagx = new zabb(this, paramLooper);
    this.zacd = paramGoogleApiAvailability;
    this.zacb = paramInt1;
    if (paramInt1 >= 0) {
      this.zahd = Integer.valueOf(paramInt2);
    }
    this.zaew = paramMap;
    this.zagz = paramMap1;
    this.zahc = paramArrayList;
    this.zahf = new zacp(paramMap1);
    paramContext = paramList.iterator();
    while (paramContext.hasNext())
    {
      paramLock = (GoogleApiClient.ConnectionCallbacks)paramContext.next();
      this.zags.registerConnectionCallbacks(paramLock);
    }
    paramContext = paramList1.iterator();
    while (paramContext.hasNext())
    {
      paramLock = (GoogleApiClient.OnConnectionFailedListener)paramContext.next();
      this.zags.registerConnectionFailedListener(paramLock);
    }
    this.zaet = paramClientSettings;
    this.zace = paramAbstractClientBuilder;
  }
  
  private final void resume()
  {
    this.zaeo.lock();
    try
    {
      if (this.zagu) {
        zaau();
      }
      return;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public static int zaa(Iterable<Api.Client> paramIterable, boolean paramBoolean)
  {
    paramIterable = paramIterable.iterator();
    int j = 0;
    int i = 0;
    while (paramIterable.hasNext())
    {
      Api.Client localClient = (Api.Client)paramIterable.next();
      int k = j;
      if (localClient.requiresSignIn()) {
        k = 1;
      }
      j = k;
      if (localClient.providesSignIn())
      {
        i = 1;
        j = k;
      }
    }
    if (j != 0)
    {
      if ((i != 0) && (paramBoolean)) {
        return 2;
      }
      return 1;
    }
    return 3;
  }
  
  private final void zaa(GoogleApiClient paramGoogleApiClient, StatusPendingResult paramStatusPendingResult, boolean paramBoolean)
  {
    Common.zapi.zaa(paramGoogleApiClient).setResultCallback(new zaba(this, paramStatusPendingResult, paramBoolean, paramGoogleApiClient));
  }
  
  private final void zaau()
  {
    this.zags.enableCallbacks();
    this.zagt.connect();
  }
  
  private final void zaav()
  {
    this.zaeo.lock();
    try
    {
      if (zaaw()) {
        zaau();
      }
      return;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  private final void zae(int paramInt)
  {
    Object localObject1 = this.zahd;
    if (localObject1 == null) {
      this.zahd = Integer.valueOf(paramInt);
    } else {
      if (((Integer)localObject1).intValue() != paramInt) {
        break label382;
      }
    }
    if (this.zagt != null) {
      return;
    }
    localObject1 = this.zagz.values().iterator();
    int i = 0;
    paramInt = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Api.Client)((Iterator)localObject1).next();
      j = i;
      if (((Api.Client)localObject2).requiresSignIn()) {
        j = 1;
      }
      i = j;
      if (((Api.Client)localObject2).providesSignIn())
      {
        paramInt = 1;
        i = j;
      }
    }
    int j = this.zahd.intValue();
    if (j != 1)
    {
      if ((j == 2) && (i != 0))
      {
        if (this.zach)
        {
          this.zagt = new zax(this.mContext, this.zaeo, this.zabj, this.zacd, this.zagz, this.zaet, this.zaew, this.zace, this.zahc, this, true);
          return;
        }
        this.zagt = zas.zaa(this.mContext, this, this.zaeo, this.zabj, this.zacd, this.zagz, this.zaet, this.zaew, this.zace, this.zahc);
      }
    }
    else
    {
      if (i == 0) {
        break label371;
      }
      if (paramInt != 0) {
        break label360;
      }
    }
    if ((this.zach) && (paramInt == 0))
    {
      this.zagt = new zax(this.mContext, this.zaeo, this.zabj, this.zacd, this.zagz, this.zaet, this.zaew, this.zace, this.zahc, this, false);
      return;
    }
    this.zagt = new zabe(this.mContext, this, this.zaeo, this.zabj, this.zacd, this.zagz, this.zaet, this.zaew, this.zace, this.zahc, this);
    return;
    label360:
    throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
    label371:
    throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
    label382:
    localObject1 = zaf(paramInt);
    Object localObject2 = zaf(this.zahd.intValue());
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject1).length() + 51 + String.valueOf(localObject2).length());
    localStringBuilder.append("Cannot use sign-in mode: ");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(". Mode was already set to ");
    localStringBuilder.append((String)localObject2);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private static String zaf(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return "UNKNOWN";
        }
        return "SIGN_IN_MODE_NONE";
      }
      return "SIGN_IN_MODE_OPTIONAL";
    }
    return "SIGN_IN_MODE_REQUIRED";
  }
  
  public final ConnectionResult blockingConnect()
  {
    Object localObject1 = Looper.myLooper();
    Looper localLooper = Looper.getMainLooper();
    boolean bool2 = true;
    boolean bool1;
    if (localObject1 != localLooper) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkState(bool1, "blockingConnect must not be called on the UI thread");
    this.zaeo.lock();
    for (;;)
    {
      try
      {
        if (this.zacb >= 0)
        {
          if (this.zahd == null) {
            break label172;
          }
          bool1 = bool2;
          Preconditions.checkState(bool1, "Sign-in mode should have been set explicitly by auto-manage.");
        }
        else if (this.zahd == null)
        {
          this.zahd = Integer.valueOf(zaa(this.zagz.values(), false));
        }
        else
        {
          if (this.zahd.intValue() == 2) {
            continue;
          }
        }
        zae(this.zahd.intValue());
        this.zags.enableCallbacks();
        localObject1 = this.zagt.blockingConnect();
        return (ConnectionResult)localObject1;
        throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
      }
      finally
      {
        this.zaeo.unlock();
      }
      label172:
      bool1 = false;
    }
  }
  
  public final ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "blockingConnect must not be called on the UI thread");
    Preconditions.checkNotNull(paramTimeUnit, "TimeUnit must not be null");
    this.zaeo.lock();
    try
    {
      if (this.zahd == null) {
        this.zahd = Integer.valueOf(zaa(this.zagz.values(), false));
      } else {
        if (this.zahd.intValue() == 2) {
          break label125;
        }
      }
      zae(this.zahd.intValue());
      this.zags.enableCallbacks();
      paramTimeUnit = this.zagt.blockingConnect(paramLong, paramTimeUnit);
      return paramTimeUnit;
      label125:
      throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public final PendingResult<Status> clearDefaultAccountAndReconnect()
  {
    Preconditions.checkState(isConnected(), "GoogleApiClient is not connected yet.");
    boolean bool;
    if (this.zahd.intValue() != 2) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
    StatusPendingResult localStatusPendingResult = new StatusPendingResult(this);
    if (this.zagz.containsKey(Common.CLIENT_KEY))
    {
      zaa(this, localStatusPendingResult, false);
      return localStatusPendingResult;
    }
    AtomicReference localAtomicReference = new AtomicReference();
    Object localObject = new zaay(this, localAtomicReference, localStatusPendingResult);
    zaaz localzaaz = new zaaz(this, localStatusPendingResult);
    localObject = new GoogleApiClient.Builder(this.mContext).addApi(Common.API).addConnectionCallbacks((GoogleApiClient.ConnectionCallbacks)localObject).addOnConnectionFailedListener(localzaaz).setHandler(this.zagx).build();
    localAtomicReference.set(localObject);
    ((GoogleApiClient)localObject).connect();
    return localStatusPendingResult;
  }
  
  public final void connect()
  {
    this.zaeo.lock();
    try
    {
      int i = this.zacb;
      boolean bool = false;
      if (i >= 0)
      {
        if (this.zahd != null) {
          bool = true;
        }
        Preconditions.checkState(bool, "Sign-in mode should have been set explicitly by auto-manage.");
      }
      else if (this.zahd == null)
      {
        this.zahd = Integer.valueOf(zaa(this.zagz.values(), false));
      }
      else
      {
        if (this.zahd.intValue() == 2) {
          break label101;
        }
      }
      connect(this.zahd.intValue());
      return;
      label101:
      throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public final void connect(int paramInt)
  {
    this.zaeo.lock();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 3)
    {
      bool1 = bool2;
      if (paramInt != 1) {
        if (paramInt == 2) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder(33);
      localStringBuilder.append("Illegal sign-in mode: ");
      localStringBuilder.append(paramInt);
      Preconditions.checkArgument(bool1, localStringBuilder.toString());
      zae(paramInt);
      zaau();
      return;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public final void disconnect()
  {
    this.zaeo.lock();
    try
    {
      this.zahf.release();
      if (this.zagt != null) {
        this.zagt.disconnect();
      }
      this.zahb.release();
      Object localObject1 = this.zafc.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        BaseImplementation.ApiMethodImpl localApiMethodImpl = (BaseImplementation.ApiMethodImpl)((Iterator)localObject1).next();
        localApiMethodImpl.zaa(null);
        localApiMethodImpl.cancel();
      }
      this.zafc.clear();
      localObject1 = this.zagt;
      if (localObject1 == null) {
        return;
      }
      zaaw();
      this.zags.disableCallbacks();
      return;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.append(paramString).append("mContext=").println(this.mContext);
    paramPrintWriter.append(paramString).append("mResuming=").print(this.zagu);
    paramPrintWriter.append(" mWorkQueue.size()=").print(this.zafc.size());
    Object localObject = this.zahf;
    paramPrintWriter.append(" mUnconsumedApiCalls.size()=").println(((zacp)localObject).zakz.size());
    localObject = this.zagt;
    if (localObject != null) {
      ((zabs)localObject).dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T paramT)
  {
    if (paramT.getClientKey() != null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "This task can not be enqueued (it's probably a Batch or malformed)");
    boolean bool = this.zagz.containsKey(paramT.getClientKey());
    String str;
    if (paramT.getApi() != null) {
      str = paramT.getApi().getName();
    } else {
      str = "the API";
    }
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 65);
    localStringBuilder.append("GoogleApiClient is not configured to use ");
    localStringBuilder.append(str);
    localStringBuilder.append(" required for this call.");
    Preconditions.checkArgument(bool, localStringBuilder.toString());
    this.zaeo.lock();
    try
    {
      if (this.zagt == null)
      {
        this.zafc.add(paramT);
        return paramT;
      }
      paramT = this.zagt.enqueue(paramT);
      return paramT;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T paramT)
  {
    if (paramT.getClientKey() != null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "This task can not be executed (it's probably a Batch or malformed)");
    boolean bool = this.zagz.containsKey(paramT.getClientKey());
    Object localObject;
    if (paramT.getApi() != null) {
      localObject = paramT.getApi().getName();
    } else {
      localObject = "the API";
    }
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject).length() + 65);
    localStringBuilder.append("GoogleApiClient is not configured to use ");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" required for this call.");
    Preconditions.checkArgument(bool, localStringBuilder.toString());
    this.zaeo.lock();
    try
    {
      if (this.zagt != null)
      {
        if (this.zagu)
        {
          this.zafc.add(paramT);
          while (!this.zafc.isEmpty())
          {
            localObject = (BaseImplementation.ApiMethodImpl)this.zafc.remove();
            this.zahf.zab((BasePendingResult)localObject);
            ((BaseImplementation.ApiMethodImpl)localObject).setFailedResult(Status.RESULT_INTERNAL_ERROR);
          }
          return paramT;
        }
        paramT = this.zagt.execute(paramT);
        return paramT;
      }
      throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public final <C extends Api.Client> C getClient(Api.AnyClientKey<C> paramAnyClientKey)
  {
    paramAnyClientKey = (Api.Client)this.zagz.get(paramAnyClientKey);
    Preconditions.checkNotNull(paramAnyClientKey, "Appropriate Api was not requested.");
    return paramAnyClientKey;
  }
  
  public final ConnectionResult getConnectionResult(Api<?> paramApi)
  {
    this.zaeo.lock();
    try
    {
      if ((!isConnected()) && (!this.zagu)) {
        throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
      }
      if (this.zagz.containsKey(paramApi.getClientKey()))
      {
        ConnectionResult localConnectionResult = this.zagt.getConnectionResult(paramApi);
        if (localConnectionResult == null)
        {
          if (this.zagu)
          {
            paramApi = ConnectionResult.RESULT_SUCCESS;
            return paramApi;
          }
          Log.w("GoogleApiClientImpl", zaay());
          Log.wtf("GoogleApiClientImpl", String.valueOf(paramApi.getName()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map"), new Exception());
          paramApi = new ConnectionResult(8, null);
          return paramApi;
        }
        return localConnectionResult;
      }
      throw new IllegalArgumentException(String.valueOf(paramApi.getName()).concat(" was never registered with GoogleApiClient"));
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
  public final Looper getLooper()
  {
    return this.zabj;
  }
  
  public final boolean hasApi(Api<?> paramApi)
  {
    return this.zagz.containsKey(paramApi.getClientKey());
  }
  
  public final boolean hasConnectedApi(Api<?> paramApi)
  {
    if (!isConnected()) {
      return false;
    }
    paramApi = (Api.Client)this.zagz.get(paramApi.getClientKey());
    return (paramApi != null) && (paramApi.isConnected());
  }
  
  public final boolean isConnected()
  {
    zabs localzabs = this.zagt;
    return (localzabs != null) && (localzabs.isConnected());
  }
  
  public final boolean isConnecting()
  {
    zabs localzabs = this.zagt;
    return (localzabs != null) && (localzabs.isConnecting());
  }
  
  public final boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.zags.isConnectionCallbacksRegistered(paramConnectionCallbacks);
  }
  
  public final boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.zags.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  public final boolean maybeSignIn(SignInConnectionListener paramSignInConnectionListener)
  {
    zabs localzabs = this.zagt;
    return (localzabs != null) && (localzabs.maybeSignIn(paramSignInConnectionListener));
  }
  
  public final void maybeSignOut()
  {
    zabs localzabs = this.zagt;
    if (localzabs != null) {
      localzabs.maybeSignOut();
    }
  }
  
  public final void reconnect()
  {
    disconnect();
    connect();
  }
  
  public final void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.zags.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public final void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.zags.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public final <L> ListenerHolder<L> registerListener(L paramL)
  {
    this.zaeo.lock();
    try
    {
      paramL = this.zahb.zaa(paramL, this.zabj, "NO_TYPE");
      return paramL;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public final void stopAutoManage(FragmentActivity paramFragmentActivity)
  {
    paramFragmentActivity = new LifecycleActivity(paramFragmentActivity);
    if (this.zacb >= 0)
    {
      zaj.zaa(paramFragmentActivity).zaa(this.zacb);
      return;
    }
    throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
  }
  
  public final void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.zags.unregisterConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public final void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.zags.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public final void zaa(zacm paramzacm)
  {
    this.zaeo.lock();
    try
    {
      if (this.zahe == null) {
        this.zahe = new HashSet();
      }
      this.zahe.add(paramzacm);
      return;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  final boolean zaaw()
  {
    if (!this.zagu) {
      return false;
    }
    this.zagu = false;
    this.zagx.removeMessages(2);
    this.zagx.removeMessages(1);
    zabq localzabq = this.zagy;
    if (localzabq != null)
    {
      localzabq.unregister();
      this.zagy = null;
    }
    return true;
  }
  
  final boolean zaax()
  {
    this.zaeo.lock();
    try
    {
      Set localSet = this.zahe;
      if (localSet == null) {
        return false;
      }
      boolean bool = this.zahe.isEmpty();
      return bool ^ true;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  final String zaay()
  {
    StringWriter localStringWriter = new StringWriter();
    dump("", null, new PrintWriter(localStringWriter), null);
    return localStringWriter.toString();
  }
  
  public final void zab(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == 1) && (!paramBoolean) && (!this.zagu))
    {
      this.zagu = true;
      if ((this.zagy == null) && (!ClientLibraryUtils.isPackageSide())) {
        this.zagy = this.zacd.zaa(this.mContext.getApplicationContext(), new zabc(this));
      }
      zabb localzabb = this.zagx;
      localzabb.sendMessageDelayed(localzabb.obtainMessage(1), this.zagv);
      localzabb = this.zagx;
      localzabb.sendMessageDelayed(localzabb.obtainMessage(2), this.zagw);
    }
    this.zahf.zabx();
    this.zags.onUnintentionalDisconnection(paramInt);
    this.zags.disableCallbacks();
    if (paramInt == 2) {
      zaau();
    }
  }
  
  public final void zab(Bundle paramBundle)
  {
    while (!this.zafc.isEmpty()) {
      execute((BaseImplementation.ApiMethodImpl)this.zafc.remove());
    }
    this.zags.onConnectionSuccess(paramBundle);
  }
  
  public final void zab(zacm paramzacm)
  {
    this.zaeo.lock();
    try
    {
      Set localSet = this.zahe;
      if (localSet == null) {
        Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
      } else if (!this.zahe.remove(paramzacm)) {
        Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
      } else if (!zaax()) {
        this.zagt.zaw();
      }
      return;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public final void zac(ConnectionResult paramConnectionResult)
  {
    if (!this.zacd.isPlayServicesPossiblyUpdating(this.mContext, paramConnectionResult.getErrorCode())) {
      zaaw();
    }
    if (!this.zagu)
    {
      this.zags.onConnectionFailure(paramConnectionResult);
      this.zags.disableCallbacks();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zaaw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */