package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.ClientSettings.OptionalApiSettings;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import com.google.android.gms.tasks.Task;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class zax
  implements zabs
{
  private final Looper zabj;
  private final GoogleApiManager zabm;
  private final Lock zaeo;
  private final ClientSettings zaet;
  private final Map<Api.AnyClientKey<?>, zaw<?>> zaeu = new HashMap();
  private final Map<Api.AnyClientKey<?>, zaw<?>> zaev = new HashMap();
  private final Map<Api<?>, Boolean> zaew;
  private final zaaw zaex;
  private final GoogleApiAvailabilityLight zaey;
  private final Condition zaez;
  private final boolean zafa;
  private final boolean zafb;
  private final Queue<BaseImplementation.ApiMethodImpl<?, ?>> zafc = new LinkedList();
  private boolean zafd;
  private Map<zai<?>, ConnectionResult> zafe;
  private Map<zai<?>, ConnectionResult> zaff;
  private zaaa zafg;
  private ConnectionResult zafh;
  
  public zax(Context paramContext, Lock paramLock, Looper paramLooper, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> paramMap, ClientSettings paramClientSettings, Map<Api<?>, Boolean> paramMap1, Api.AbstractClientBuilder<? extends zad, SignInOptions> paramAbstractClientBuilder, ArrayList<zaq> paramArrayList, zaaw paramzaaw, boolean paramBoolean)
  {
    this.zaeo = paramLock;
    this.zabj = paramLooper;
    this.zaez = paramLock.newCondition();
    this.zaey = paramGoogleApiAvailabilityLight;
    this.zaex = paramzaaw;
    this.zaew = paramMap1;
    this.zaet = paramClientSettings;
    this.zafa = paramBoolean;
    paramLock = new HashMap();
    paramGoogleApiAvailabilityLight = paramMap1.keySet().iterator();
    while (paramGoogleApiAvailabilityLight.hasNext())
    {
      paramMap1 = (Api)paramGoogleApiAvailabilityLight.next();
      paramLock.put(paramMap1.getClientKey(), paramMap1);
    }
    paramGoogleApiAvailabilityLight = new HashMap();
    paramMap1 = (ArrayList)paramArrayList;
    int j = paramMap1.size();
    int i = 0;
    while (i < j)
    {
      paramArrayList = paramMap1.get(i);
      i += 1;
      paramArrayList = (zaq)paramArrayList;
      paramGoogleApiAvailabilityLight.put(paramArrayList.mApi, paramArrayList);
    }
    paramMap = paramMap.entrySet().iterator();
    j = 0;
    int k = 1;
    i = 0;
    while (paramMap.hasNext())
    {
      paramMap1 = (Map.Entry)paramMap.next();
      paramzaaw = (Api)paramLock.get(paramMap1.getKey());
      paramArrayList = (Api.Client)paramMap1.getValue();
      if (paramArrayList.requiresGooglePlayServices())
      {
        paramBoolean = ((Boolean)this.zaew.get(paramzaaw)).booleanValue();
        if (!paramBoolean)
        {
          j = 1;
          i = 1;
        }
        else
        {
          j = 1;
        }
      }
      else
      {
        k = 0;
      }
      paramzaaw = new zaw(paramContext, paramzaaw, paramLooper, paramArrayList, (zaq)paramGoogleApiAvailabilityLight.get(paramzaaw), paramClientSettings, paramAbstractClientBuilder);
      this.zaeu.put((Api.AnyClientKey)paramMap1.getKey(), paramzaaw);
      if (paramArrayList.requiresSignIn()) {
        this.zaev.put((Api.AnyClientKey)paramMap1.getKey(), paramzaaw);
      }
    }
    if ((j != 0) && (k == 0) && (i == 0)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    this.zafb = paramBoolean;
    this.zabm = GoogleApiManager.zabc();
  }
  
  private final ConnectionResult zaa(Api.AnyClientKey<?> paramAnyClientKey)
  {
    this.zaeo.lock();
    try
    {
      paramAnyClientKey = (zaw)this.zaeu.get(paramAnyClientKey);
      if ((this.zafe != null) && (paramAnyClientKey != null))
      {
        paramAnyClientKey = (ConnectionResult)this.zafe.get(paramAnyClientKey.zak());
        return paramAnyClientKey;
      }
      return null;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  private final boolean zaa(zaw<?> paramzaw, ConnectionResult paramConnectionResult)
  {
    return (!paramConnectionResult.isSuccess()) && (!paramConnectionResult.hasResolution()) && (((Boolean)this.zaew.get(paramzaw.getApi())).booleanValue()) && (paramzaw.zaab().requiresGooglePlayServices()) && (this.zaey.isUserResolvableError(paramConnectionResult.getErrorCode()));
  }
  
  private final boolean zaac()
  {
    this.zaeo.lock();
    try
    {
      if ((this.zafd) && (this.zafa))
      {
        Iterator localIterator = this.zaev.keySet().iterator();
        while (localIterator.hasNext())
        {
          ConnectionResult localConnectionResult = zaa((Api.AnyClientKey)localIterator.next());
          if (localConnectionResult != null)
          {
            boolean bool = localConnectionResult.isSuccess();
            if (bool) {
              break;
            }
          }
          else
          {
            return false;
          }
        }
        return true;
      }
      return false;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  private final void zaad()
  {
    if (this.zaet == null)
    {
      this.zaex.zaha = Collections.emptySet();
      return;
    }
    HashSet localHashSet = new HashSet(this.zaet.getRequiredScopes());
    Map localMap = this.zaet.getOptionalApiSettings();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api localApi = (Api)localIterator.next();
      ConnectionResult localConnectionResult = getConnectionResult(localApi);
      if ((localConnectionResult != null) && (localConnectionResult.isSuccess())) {
        localHashSet.addAll(((ClientSettings.OptionalApiSettings)localMap.get(localApi)).mScopes);
      }
    }
    this.zaex.zaha = localHashSet;
  }
  
  private final void zaae()
  {
    while (!this.zafc.isEmpty()) {
      execute((BaseImplementation.ApiMethodImpl)this.zafc.remove());
    }
    this.zaex.zab(null);
  }
  
  private final ConnectionResult zaaf()
  {
    Iterator localIterator = this.zaeu.values().iterator();
    int j = 0;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject3 = (zaw)localIterator.next();
      Api localApi = ((GoogleApi)localObject3).getApi();
      localObject3 = ((GoogleApi)localObject3).zak();
      localObject3 = (ConnectionResult)this.zafe.get(localObject3);
      if ((!((ConnectionResult)localObject3).isSuccess()) && ((!((Boolean)this.zaew.get(localApi)).booleanValue()) || (((ConnectionResult)localObject3).hasResolution()) || (this.zaey.isUserResolvableError(((ConnectionResult)localObject3).getErrorCode()))))
      {
        int k;
        if ((((ConnectionResult)localObject3).getErrorCode() == 4) && (this.zafa))
        {
          k = localApi.zah().getPriority();
          if ((localObject1 == null) || (i > k))
          {
            localObject1 = localObject3;
            i = k;
          }
        }
        else
        {
          k = localApi.zah().getPriority();
          if ((localObject2 == null) || (j > k))
          {
            localObject2 = localObject3;
            j = k;
          }
        }
      }
    }
    if ((localObject2 != null) && (localObject1 != null) && (j > i)) {
      return (ConnectionResult)localObject1;
    }
    return (ConnectionResult)localObject2;
  }
  
  private final <T extends BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>> boolean zab(T paramT)
  {
    Api.AnyClientKey localAnyClientKey = paramT.getClientKey();
    ConnectionResult localConnectionResult = zaa(localAnyClientKey);
    if ((localConnectionResult != null) && (localConnectionResult.getErrorCode() == 4))
    {
      paramT.setFailedResult(new Status(4, null, this.zabm.zaa(((zaw)this.zaeu.get(localAnyClientKey)).zak(), System.identityHashCode(this.zaex))));
      return true;
    }
    return false;
  }
  
  public final ConnectionResult blockingConnect()
  {
    connect();
    for (;;)
    {
      if (!isConnecting()) {
        break label40;
      }
      try
      {
        this.zaez.await();
      }
      catch (InterruptedException localInterruptedException)
      {
        ConnectionResult localConnectionResult;
        for (;;) {}
      }
    }
    Thread.currentThread().interrupt();
    return new ConnectionResult(15, null);
    label40:
    if (isConnected()) {
      return ConnectionResult.RESULT_SUCCESS;
    }
    localConnectionResult = this.zafh;
    if (localConnectionResult != null) {
      return localConnectionResult;
    }
    return new ConnectionResult(13, null);
  }
  
  public final ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    connect();
    for (paramLong = paramTimeUnit.toNanos(paramLong);; paramLong = this.zaez.awaitNanos(paramLong))
    {
      if ((!isConnecting()) || (paramLong <= 0L)) {}
      try
      {
        disconnect();
        return new ConnectionResult(14, null);
      }
      catch (InterruptedException paramTimeUnit)
      {
        for (;;) {}
      }
    }
    Thread.currentThread().interrupt();
    return new ConnectionResult(15, null);
    if (isConnected()) {
      return ConnectionResult.RESULT_SUCCESS;
    }
    paramTimeUnit = this.zafh;
    if (paramTimeUnit != null) {
      return paramTimeUnit;
    }
    return new ConnectionResult(13, null);
  }
  
  public final void connect()
  {
    this.zaeo.lock();
    try
    {
      boolean bool = this.zafd;
      if (bool) {
        return;
      }
      this.zafd = true;
      this.zafe = null;
      this.zaff = null;
      this.zafg = null;
      this.zafh = null;
      this.zabm.zao();
      this.zabm.zaa(this.zaeu.values()).addOnCompleteListener(new HandlerExecutor(this.zabj), new zaz(this, null));
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
      this.zafd = false;
      this.zafe = null;
      this.zaff = null;
      if (this.zafg != null)
      {
        this.zafg.cancel();
        this.zafg = null;
      }
      this.zafh = null;
      while (!this.zafc.isEmpty())
      {
        BaseImplementation.ApiMethodImpl localApiMethodImpl = (BaseImplementation.ApiMethodImpl)this.zafc.remove();
        localApiMethodImpl.zaa(null);
        localApiMethodImpl.cancel();
      }
      this.zaez.signalAll();
      return;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T paramT)
  {
    if ((this.zafa) && (zab(paramT))) {
      return paramT;
    }
    if (!isConnected())
    {
      this.zafc.add(paramT);
      return paramT;
    }
    this.zaex.zahf.zab(paramT);
    return ((zaw)this.zaeu.get(paramT.getClientKey())).doRead(paramT);
  }
  
  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T paramT)
  {
    Api.AnyClientKey localAnyClientKey = paramT.getClientKey();
    if ((this.zafa) && (zab(paramT))) {
      return paramT;
    }
    this.zaex.zahf.zab(paramT);
    return ((zaw)this.zaeu.get(localAnyClientKey)).doWrite(paramT);
  }
  
  public final ConnectionResult getConnectionResult(Api<?> paramApi)
  {
    return zaa(paramApi.getClientKey());
  }
  
  public final boolean isConnected()
  {
    this.zaeo.lock();
    try
    {
      if (this.zafe != null)
      {
        ConnectionResult localConnectionResult = this.zafh;
        if (localConnectionResult == null)
        {
          bool = true;
          break label32;
        }
      }
      boolean bool = false;
      label32:
      return bool;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public final boolean isConnecting()
  {
    this.zaeo.lock();
    try
    {
      if (this.zafe == null)
      {
        bool = this.zafd;
        if (bool)
        {
          bool = true;
          break label32;
        }
      }
      boolean bool = false;
      label32:
      return bool;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public final boolean maybeSignIn(SignInConnectionListener paramSignInConnectionListener)
  {
    this.zaeo.lock();
    try
    {
      if ((this.zafd) && (!zaac()))
      {
        this.zabm.zao();
        this.zafg = new zaaa(this, paramSignInConnectionListener);
        this.zabm.zaa(this.zaev.values()).addOnCompleteListener(new HandlerExecutor(this.zabj), this.zafg);
        return true;
      }
      return false;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public final void maybeSignOut()
  {
    this.zaeo.lock();
    try
    {
      this.zabm.maybeSignOut();
      if (this.zafg != null)
      {
        this.zafg.cancel();
        this.zafg = null;
      }
      if (this.zaff == null) {
        this.zaff = new ArrayMap(this.zaev.size());
      }
      ConnectionResult localConnectionResult = new ConnectionResult(4);
      Iterator localIterator = this.zaev.values().iterator();
      while (localIterator.hasNext())
      {
        zaw localzaw = (zaw)localIterator.next();
        this.zaff.put(localzaw.zak(), localConnectionResult);
      }
      if (this.zafe != null) {
        this.zafe.putAll(this.zaff);
      }
      return;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public final void zaw() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */