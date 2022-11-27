package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class zabe
  implements zabs, zar
{
  private final Context mContext;
  private final Api.AbstractClientBuilder<? extends zad, SignInOptions> zace;
  final zaaw zaee;
  private final Lock zaeo;
  private final ClientSettings zaet;
  private final Map<Api<?>, Boolean> zaew;
  private final GoogleApiAvailabilityLight zaey;
  final Map<Api.AnyClientKey<?>, Api.Client> zagz;
  private final Condition zahn;
  private final zabg zaho;
  final Map<Api.AnyClientKey<?>, ConnectionResult> zahp = new HashMap();
  private volatile zabd zahq;
  private ConnectionResult zahr = null;
  int zahs;
  final zabt zaht;
  
  public zabe(Context paramContext, zaaw paramzaaw, Lock paramLock, Looper paramLooper, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> paramMap, ClientSettings paramClientSettings, Map<Api<?>, Boolean> paramMap1, Api.AbstractClientBuilder<? extends zad, SignInOptions> paramAbstractClientBuilder, ArrayList<zaq> paramArrayList, zabt paramzabt)
  {
    this.mContext = paramContext;
    this.zaeo = paramLock;
    this.zaey = paramGoogleApiAvailabilityLight;
    this.zagz = paramMap;
    this.zaet = paramClientSettings;
    this.zaew = paramMap1;
    this.zace = paramAbstractClientBuilder;
    this.zaee = paramzaaw;
    this.zaht = paramzabt;
    paramContext = (ArrayList)paramArrayList;
    int j = paramContext.size();
    int i = 0;
    while (i < j)
    {
      paramzaaw = paramContext.get(i);
      i += 1;
      ((zaq)paramzaaw).zaa(this);
    }
    this.zaho = new zabg(this, paramLooper);
    this.zahn = paramLock.newCondition();
    this.zahq = new zaav(this);
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
        this.zahn.await();
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
    localConnectionResult = this.zahr;
    if (localConnectionResult != null) {
      return localConnectionResult;
    }
    return new ConnectionResult(13, null);
  }
  
  public final ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    connect();
    for (paramLong = paramTimeUnit.toNanos(paramLong);; paramLong = this.zahn.awaitNanos(paramLong))
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
    paramTimeUnit = this.zahr;
    if (paramTimeUnit != null) {
      return paramTimeUnit;
    }
    return new ConnectionResult(13, null);
  }
  
  public final void connect()
  {
    this.zahq.connect();
  }
  
  public final void disconnect()
  {
    if (this.zahq.disconnect()) {
      this.zahp.clear();
    }
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    String str = String.valueOf(paramString).concat("  ");
    paramPrintWriter.append(paramString).append("mState=").println(this.zahq);
    Iterator localIterator = this.zaew.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api localApi = (Api)localIterator.next();
      paramPrintWriter.append(paramString).append(localApi.getName()).println(":");
      ((Api.Client)this.zagz.get(localApi.getClientKey())).dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T paramT)
  {
    paramT.zau();
    return this.zahq.enqueue(paramT);
  }
  
  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T paramT)
  {
    paramT.zau();
    return this.zahq.execute(paramT);
  }
  
  public final ConnectionResult getConnectionResult(Api<?> paramApi)
  {
    paramApi = paramApi.getClientKey();
    if (this.zagz.containsKey(paramApi))
    {
      if (((Api.Client)this.zagz.get(paramApi)).isConnected()) {
        return ConnectionResult.RESULT_SUCCESS;
      }
      if (this.zahp.containsKey(paramApi)) {
        return (ConnectionResult)this.zahp.get(paramApi);
      }
    }
    return null;
  }
  
  public final boolean isConnected()
  {
    return this.zahq instanceof zaah;
  }
  
  public final boolean isConnecting()
  {
    return this.zahq instanceof zaak;
  }
  
  public final boolean maybeSignIn(SignInConnectionListener paramSignInConnectionListener)
  {
    return false;
  }
  
  public final void maybeSignOut() {}
  
  public final void onConnected(Bundle paramBundle)
  {
    this.zaeo.lock();
    try
    {
      this.zahq.onConnected(paramBundle);
      return;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public final void onConnectionSuspended(int paramInt)
  {
    this.zaeo.lock();
    try
    {
      this.zahq.onConnectionSuspended(paramInt);
      return;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public final void zaa(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean)
  {
    this.zaeo.lock();
    try
    {
      this.zahq.zaa(paramConnectionResult, paramApi, paramBoolean);
      return;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  final void zaa(zabf paramzabf)
  {
    paramzabf = this.zaho.obtainMessage(1, paramzabf);
    this.zaho.sendMessage(paramzabf);
  }
  
  final void zaaz()
  {
    this.zaeo.lock();
    try
    {
      this.zahq = new zaak(this, this.zaet, this.zaew, this.zaey, this.zace, this.zaeo, this.mContext);
      this.zahq.begin();
      this.zahn.signalAll();
      return;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  final void zab(RuntimeException paramRuntimeException)
  {
    paramRuntimeException = this.zaho.obtainMessage(2, paramRuntimeException);
    this.zaho.sendMessage(paramRuntimeException);
  }
  
  final void zaba()
  {
    this.zaeo.lock();
    try
    {
      this.zaee.zaaw();
      this.zahq = new zaah(this);
      this.zahq.begin();
      this.zahn.signalAll();
      return;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  final void zaf(ConnectionResult paramConnectionResult)
  {
    this.zaeo.lock();
    try
    {
      this.zahr = paramConnectionResult;
      this.zahq = new zaav(this);
      this.zahq.begin();
      this.zahn.signalAll();
      return;
    }
    finally
    {
      this.zaeo.unlock();
    }
  }
  
  public final void zaw()
  {
    if (isConnected()) {
      ((zaah)this.zahq).zaam();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zabe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */