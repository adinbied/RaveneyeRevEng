package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.ClientSettings.OptionalApiSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.zaj;
import com.google.android.gms.signin.zad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public final class zaak
  implements zabd
{
  private final Context mContext;
  private final Api.AbstractClientBuilder<? extends zad, SignInOptions> zace;
  private final Lock zaeo;
  private final ClientSettings zaet;
  private final Map<Api<?>, Boolean> zaew;
  private final GoogleApiAvailabilityLight zaey;
  private ConnectionResult zafh;
  private final zabe zaft;
  private int zafw;
  private int zafx = 0;
  private int zafy;
  private final Bundle zafz = new Bundle();
  private final Set<Api.AnyClientKey> zaga = new HashSet();
  private zad zagb;
  private boolean zagc;
  private boolean zagd;
  private boolean zage;
  private IAccountAccessor zagf;
  private boolean zagg;
  private boolean zagh;
  private ArrayList<Future<?>> zagi = new ArrayList();
  
  public zaak(zabe paramzabe, ClientSettings paramClientSettings, Map<Api<?>, Boolean> paramMap, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, Api.AbstractClientBuilder<? extends zad, SignInOptions> paramAbstractClientBuilder, Lock paramLock, Context paramContext)
  {
    this.zaft = paramzabe;
    this.zaet = paramClientSettings;
    this.zaew = paramMap;
    this.zaey = paramGoogleApiAvailabilityLight;
    this.zace = paramAbstractClientBuilder;
    this.zaeo = paramLock;
    this.mContext = paramContext;
  }
  
  private final void zaa(zaj paramzaj)
  {
    if (!zac(0)) {
      return;
    }
    Object localObject = paramzaj.getConnectionResult();
    if (((ConnectionResult)localObject).isSuccess())
    {
      localObject = paramzaj.zacx();
      paramzaj = ((ResolveAccountResponse)localObject).getConnectionResult();
      if (!paramzaj.isSuccess())
      {
        localObject = String.valueOf(paramzaj);
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject).length() + 48);
        localStringBuilder.append("Sign-in succeeded with resolve account failure: ");
        localStringBuilder.append((String)localObject);
        Log.wtf("GoogleApiClientConnecting", localStringBuilder.toString(), new Exception());
        zae(paramzaj);
        return;
      }
      this.zage = true;
      this.zagf = ((ResolveAccountResponse)localObject).getAccountAccessor();
      this.zagg = ((ResolveAccountResponse)localObject).getSaveDefaultAccount();
      this.zagh = ((ResolveAccountResponse)localObject).isFromCrossClientAuth();
      zaap();
      return;
    }
    if (zad((ConnectionResult)localObject))
    {
      zaar();
      zaap();
      return;
    }
    zae((ConnectionResult)localObject);
  }
  
  private final boolean zaao()
  {
    int i = this.zafy - 1;
    this.zafy = i;
    if (i > 0) {
      return false;
    }
    if (i < 0)
    {
      Log.w("GoogleApiClientConnecting", this.zaft.zaee.zaay());
      Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
      zae(new ConnectionResult(8, null));
      return false;
    }
    if (this.zafh != null)
    {
      this.zaft.zahs = this.zafw;
      zae(this.zafh);
      return false;
    }
    return true;
  }
  
  private final void zaap()
  {
    if (this.zafy != 0) {
      return;
    }
    if ((!this.zagd) || (this.zage))
    {
      ArrayList localArrayList = new ArrayList();
      this.zafx = 1;
      this.zafy = this.zaft.zagz.size();
      Iterator localIterator = this.zaft.zagz.keySet().iterator();
      while (localIterator.hasNext())
      {
        Api.AnyClientKey localAnyClientKey = (Api.AnyClientKey)localIterator.next();
        if (this.zaft.zahp.containsKey(localAnyClientKey))
        {
          if (zaao()) {
            zaaq();
          }
        }
        else {
          localArrayList.add((Api.Client)this.zaft.zagz.get(localAnyClientKey));
        }
      }
      if (!localArrayList.isEmpty()) {
        this.zagi.add(zabh.zabb().submit(new zaaq(this, localArrayList)));
      }
    }
  }
  
  private final void zaaq()
  {
    this.zaft.zaba();
    zabh.zabb().execute(new zaal(this));
    Object localObject = this.zagb;
    if (localObject != null)
    {
      if (this.zagg) {
        ((zad)localObject).zaa(this.zagf, this.zagh);
      }
      zab(false);
    }
    localObject = this.zaft.zahp.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Api.AnyClientKey localAnyClientKey = (Api.AnyClientKey)((Iterator)localObject).next();
      ((Api.Client)this.zaft.zagz.get(localAnyClientKey)).disconnect();
    }
    if (this.zafz.isEmpty()) {
      localObject = null;
    } else {
      localObject = this.zafz;
    }
    this.zaft.zaht.zab((Bundle)localObject);
  }
  
  private final void zaar()
  {
    this.zagd = false;
    this.zaft.zaee.zaha = Collections.emptySet();
    Iterator localIterator = this.zaga.iterator();
    while (localIterator.hasNext())
    {
      Api.AnyClientKey localAnyClientKey = (Api.AnyClientKey)localIterator.next();
      if (!this.zaft.zahp.containsKey(localAnyClientKey)) {
        this.zaft.zahp.put(localAnyClientKey, new ConnectionResult(17, null));
      }
    }
  }
  
  private final void zaas()
  {
    ArrayList localArrayList = (ArrayList)this.zagi;
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = localArrayList.get(i);
      i += 1;
      ((Future)localObject).cancel(true);
    }
    this.zagi.clear();
  }
  
  private final Set<Scope> zaat()
  {
    if (this.zaet == null) {
      return Collections.emptySet();
    }
    HashSet localHashSet = new HashSet(this.zaet.getRequiredScopes());
    Map localMap = this.zaet.getOptionalApiSettings();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api localApi = (Api)localIterator.next();
      if (!this.zaft.zahp.containsKey(localApi.getClientKey())) {
        localHashSet.addAll(((ClientSettings.OptionalApiSettings)localMap.get(localApi)).mScopes);
      }
    }
    return localHashSet;
  }
  
  private final void zab(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean)
  {
    int m = paramApi.zah().getPriority();
    int k = 0;
    int j;
    if (paramBoolean)
    {
      if (paramConnectionResult.hasResolution()) {}
      while (this.zaey.getErrorResolutionIntent(paramConnectionResult.getErrorCode()) != null)
      {
        i = 1;
        break;
      }
      int i = 0;
      j = k;
      if (i == 0) {}
    }
    else if (this.zafh != null)
    {
      j = k;
      if (m >= this.zafw) {}
    }
    else
    {
      j = 1;
    }
    if (j != 0)
    {
      this.zafh = paramConnectionResult;
      this.zafw = m;
    }
    this.zaft.zahp.put(paramApi.getClientKey(), paramConnectionResult);
  }
  
  private final void zab(boolean paramBoolean)
  {
    zad localzad = this.zagb;
    if (localzad != null)
    {
      if ((localzad.isConnected()) && (paramBoolean)) {
        this.zagb.zacw();
      }
      this.zagb.disconnect();
      if (this.zaet.isSignInClientDisconnectFixEnabled()) {
        this.zagb = null;
      }
      this.zagf = null;
    }
  }
  
  private final boolean zac(int paramInt)
  {
    if (this.zafx != paramInt)
    {
      Log.w("GoogleApiClientConnecting", this.zaft.zaee.zaay());
      Object localObject1 = String.valueOf(this);
      Object localObject2 = new StringBuilder(String.valueOf(localObject1).length() + 23);
      ((StringBuilder)localObject2).append("Unexpected callback in ");
      ((StringBuilder)localObject2).append((String)localObject1);
      Log.w("GoogleApiClientConnecting", ((StringBuilder)localObject2).toString());
      int i = this.zafy;
      localObject1 = new StringBuilder(33);
      ((StringBuilder)localObject1).append("mRemainingConnections=");
      ((StringBuilder)localObject1).append(i);
      Log.w("GoogleApiClientConnecting", ((StringBuilder)localObject1).toString());
      localObject1 = zad(this.zafx);
      localObject2 = zad(paramInt);
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject1).length() + 70 + String.valueOf(localObject2).length());
      localStringBuilder.append("GoogleApiClient connecting is in step ");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(" but received callback for step ");
      localStringBuilder.append((String)localObject2);
      Log.wtf("GoogleApiClientConnecting", localStringBuilder.toString(), new Exception());
      zae(new ConnectionResult(8, null));
      return false;
    }
    return true;
  }
  
  private static String zad(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return "UNKNOWN";
      }
      return "STEP_GETTING_REMOTE_SERVICE";
    }
    return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
  }
  
  private final boolean zad(ConnectionResult paramConnectionResult)
  {
    return (this.zagc) && (!paramConnectionResult.hasResolution());
  }
  
  private final void zae(ConnectionResult paramConnectionResult)
  {
    zaas();
    zab(paramConnectionResult.hasResolution() ^ true);
    this.zaft.zaf(paramConnectionResult);
    this.zaft.zaht.zac(paramConnectionResult);
  }
  
  public final void begin()
  {
    this.zaft.zahp.clear();
    this.zagd = false;
    this.zafh = null;
    this.zafx = 0;
    this.zagc = true;
    this.zage = false;
    this.zagg = false;
    HashMap localHashMap = new HashMap();
    Object localObject1 = this.zaew.keySet().iterator();
    int i = 0;
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Api)((Iterator)localObject1).next();
      localObject3 = (Api.Client)this.zaft.zagz.get(((Api)localObject2).getClientKey());
      int j;
      if (((Api)localObject2).zah().getPriority() == 1) {
        j = 1;
      } else {
        j = 0;
      }
      i |= j;
      boolean bool = ((Boolean)this.zaew.get(localObject2)).booleanValue();
      if (((Api.Client)localObject3).requiresSignIn())
      {
        this.zagd = true;
        if (bool) {
          this.zaga.add(((Api)localObject2).getClientKey());
        } else {
          this.zagc = false;
        }
      }
      localHashMap.put(localObject3, new zaam(this, (Api)localObject2, bool));
    }
    if (i != 0) {
      this.zagd = false;
    }
    if (this.zagd)
    {
      this.zaet.setClientSessionId(Integer.valueOf(System.identityHashCode(this.zaft.zaee)));
      localObject1 = new zaat(this, null);
      localObject2 = this.zace;
      localObject3 = this.mContext;
      Looper localLooper = this.zaft.zaee.getLooper();
      ClientSettings localClientSettings = this.zaet;
      this.zagb = ((zad)((Api.AbstractClientBuilder)localObject2).buildClient((Context)localObject3, localLooper, localClientSettings, localClientSettings.getSignInOptions(), (GoogleApiClient.ConnectionCallbacks)localObject1, (GoogleApiClient.OnConnectionFailedListener)localObject1));
    }
    this.zafy = this.zaft.zagz.size();
    this.zagi.add(zabh.zabb().submit(new zaan(this, localHashMap)));
  }
  
  public final void connect() {}
  
  public final boolean disconnect()
  {
    zaas();
    zab(true);
    this.zaft.zaf(null);
    return true;
  }
  
  public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T paramT)
  {
    this.zaft.zaee.zafc.add(paramT);
    return paramT;
  }
  
  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T paramT)
  {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }
  
  public final void onConnected(Bundle paramBundle)
  {
    if (!zac(1)) {
      return;
    }
    if (paramBundle != null) {
      this.zafz.putAll(paramBundle);
    }
    if (zaao()) {
      zaaq();
    }
  }
  
  public final void onConnectionSuspended(int paramInt)
  {
    zae(new ConnectionResult(8, null));
  }
  
  public final void zaa(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean)
  {
    if (!zac(1)) {
      return;
    }
    zab(paramConnectionResult, paramApi, paramBoolean);
    if (zaao()) {
      zaaq();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zaak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */