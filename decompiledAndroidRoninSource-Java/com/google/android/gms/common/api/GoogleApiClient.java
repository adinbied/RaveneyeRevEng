package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.common.api.internal.zacm;
import com.google.android.gms.common.api.internal.zaj;
import com.google.android.gms.common.api.internal.zaq;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.ClientSettings.OptionalApiSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zaa;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public abstract class GoogleApiClient
{
  public static final String DEFAULT_ACCOUNT = "<<default account>>";
  public static final int SIGN_IN_MODE_OPTIONAL = 2;
  public static final int SIGN_IN_MODE_REQUIRED = 1;
  private static final Set<GoogleApiClient> zabq = Collections.newSetFromMap(new WeakHashMap());
  
  public static void dumpAll(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    Set localSet = zabq;
    int i = 0;
    try
    {
      String str = String.valueOf(paramString).concat("  ");
      Iterator localIterator = zabq.iterator();
      while (localIterator.hasNext())
      {
        GoogleApiClient localGoogleApiClient = (GoogleApiClient)localIterator.next();
        paramPrintWriter.append(paramString).append("GoogleApiClient#").println(i);
        localGoogleApiClient.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  public static Set<GoogleApiClient> getAllClients()
  {
    synchronized (zabq)
    {
      Set localSet2 = zabq;
      return localSet2;
    }
  }
  
  public abstract ConnectionResult blockingConnect();
  
  public abstract ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract PendingResult<Status> clearDefaultAccountAndReconnect();
  
  public abstract void connect();
  
  public void connect(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract void disconnect();
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T paramT)
  {
    throw new UnsupportedOperationException();
  }
  
  public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T paramT)
  {
    throw new UnsupportedOperationException();
  }
  
  public <C extends Api.Client> C getClient(Api.AnyClientKey<C> paramAnyClientKey)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract ConnectionResult getConnectionResult(Api<?> paramApi);
  
  public Context getContext()
  {
    throw new UnsupportedOperationException();
  }
  
  public Looper getLooper()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean hasApi(Api<?> paramApi)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract boolean hasConnectedApi(Api<?> paramApi);
  
  public abstract boolean isConnected();
  
  public abstract boolean isConnecting();
  
  public abstract boolean isConnectionCallbacksRegistered(ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public boolean maybeSignIn(SignInConnectionListener paramSignInConnectionListener)
  {
    throw new UnsupportedOperationException();
  }
  
  public void maybeSignOut()
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract void reconnect();
  
  public abstract void registerConnectionCallbacks(ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract void registerConnectionFailedListener(OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public <L> ListenerHolder<L> registerListener(L paramL)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract void stopAutoManage(FragmentActivity paramFragmentActivity);
  
  public abstract void unregisterConnectionCallbacks(ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract void unregisterConnectionFailedListener(OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public void zaa(zacm paramzacm)
  {
    throw new UnsupportedOperationException();
  }
  
  public void zab(zacm paramzacm)
  {
    throw new UnsupportedOperationException();
  }
  
  public static final class Builder
  {
    private final Context mContext;
    private Looper zabj;
    private final Set<Scope> zabr = new HashSet();
    private final Set<Scope> zabs = new HashSet();
    private int zabt;
    private View zabu;
    private String zabv;
    private String zabw;
    private final Map<Api<?>, ClientSettings.OptionalApiSettings> zabx = new ArrayMap();
    private boolean zaby = false;
    private final Map<Api<?>, Api.ApiOptions> zabz = new ArrayMap();
    private LifecycleActivity zaca;
    private int zacb = -1;
    private GoogleApiClient.OnConnectionFailedListener zacc;
    private GoogleApiAvailability zacd = GoogleApiAvailability.getInstance();
    private Api.AbstractClientBuilder<? extends zad, SignInOptions> zace = zaa.zaph;
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> zacf = new ArrayList();
    private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zacg = new ArrayList();
    private boolean zach = false;
    private Account zax;
    
    public Builder(Context paramContext)
    {
      this.mContext = paramContext;
      this.zabj = paramContext.getMainLooper();
      this.zabv = paramContext.getPackageName();
      this.zabw = paramContext.getClass().getName();
    }
    
    public Builder(Context paramContext, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      this(paramContext);
      Preconditions.checkNotNull(paramConnectionCallbacks, "Must provide a connected listener");
      this.zacf.add(paramConnectionCallbacks);
      Preconditions.checkNotNull(paramOnConnectionFailedListener, "Must provide a connection failed listener");
      this.zacg.add(paramOnConnectionFailedListener);
    }
    
    private final <O extends Api.ApiOptions> void zaa(Api<O> paramApi, O paramO, Scope... paramVarArgs)
    {
      paramO = new HashSet(paramApi.zah().getImpliedScopes(paramO));
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        paramO.add(paramVarArgs[i]);
        i += 1;
      }
      this.zabx.put(paramApi, new ClientSettings.OptionalApiSettings(paramO));
    }
    
    public final Builder addApi(Api<? extends Api.ApiOptions.NotRequiredOptions> paramApi)
    {
      Preconditions.checkNotNull(paramApi, "Api must not be null");
      this.zabz.put(paramApi, null);
      paramApi = paramApi.zah().getImpliedScopes(null);
      this.zabs.addAll(paramApi);
      this.zabr.addAll(paramApi);
      return this;
    }
    
    public final <O extends Api.ApiOptions.HasOptions> Builder addApi(Api<O> paramApi, O paramO)
    {
      Preconditions.checkNotNull(paramApi, "Api must not be null");
      Preconditions.checkNotNull(paramO, "Null options are not permitted for this Api");
      this.zabz.put(paramApi, paramO);
      paramApi = paramApi.zah().getImpliedScopes(paramO);
      this.zabs.addAll(paramApi);
      this.zabr.addAll(paramApi);
      return this;
    }
    
    public final <O extends Api.ApiOptions.HasOptions> Builder addApiIfAvailable(Api<O> paramApi, O paramO, Scope... paramVarArgs)
    {
      Preconditions.checkNotNull(paramApi, "Api must not be null");
      Preconditions.checkNotNull(paramO, "Null options are not permitted for this Api");
      this.zabz.put(paramApi, paramO);
      zaa(paramApi, paramO, paramVarArgs);
      return this;
    }
    
    public final Builder addApiIfAvailable(Api<? extends Api.ApiOptions.NotRequiredOptions> paramApi, Scope... paramVarArgs)
    {
      Preconditions.checkNotNull(paramApi, "Api must not be null");
      this.zabz.put(paramApi, null);
      zaa(paramApi, null, paramVarArgs);
      return this;
    }
    
    public final Builder addConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
    {
      Preconditions.checkNotNull(paramConnectionCallbacks, "Listener must not be null");
      this.zacf.add(paramConnectionCallbacks);
      return this;
    }
    
    public final Builder addOnConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      Preconditions.checkNotNull(paramOnConnectionFailedListener, "Listener must not be null");
      this.zacg.add(paramOnConnectionFailedListener);
      return this;
    }
    
    public final Builder addScope(Scope paramScope)
    {
      Preconditions.checkNotNull(paramScope, "Scope must not be null");
      this.zabr.add(paramScope);
      return this;
    }
    
    public final Builder addScopeNames(String[] paramArrayOfString)
    {
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        this.zabr.add(new Scope(paramArrayOfString[i]));
        i += 1;
      }
      return this;
    }
    
    public final GoogleApiClient build()
    {
      Preconditions.checkArgument(this.zabz.isEmpty() ^ true, "must call addApi() to add at least one API");
      Object localObject4 = buildClientSettings();
      ??? = null;
      Map localMap = ((ClientSettings)localObject4).getOptionalApiSettings();
      ArrayMap localArrayMap1 = new ArrayMap();
      ArrayMap localArrayMap2 = new ArrayMap();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.zabz.keySet().iterator();
      int j = 0;
      boolean bool;
      while (localIterator.hasNext())
      {
        localObject2 = (Api)localIterator.next();
        Object localObject5 = this.zabz.get(localObject2);
        if (localMap.get(localObject2) != null) {
          bool = true;
        } else {
          bool = false;
        }
        localArrayMap1.put(localObject2, Boolean.valueOf(bool));
        Object localObject6 = new zaq((Api)localObject2, bool);
        localArrayList.add(localObject6);
        Api.AbstractClientBuilder localAbstractClientBuilder = ((Api)localObject2).zai();
        localObject6 = localAbstractClientBuilder.buildClient(this.mContext, this.zabj, (ClientSettings)localObject4, localObject5, (GoogleApiClient.ConnectionCallbacks)localObject6, (GoogleApiClient.OnConnectionFailedListener)localObject6);
        localArrayMap2.put(((Api)localObject2).getClientKey(), localObject6);
        i = j;
        if (localAbstractClientBuilder.getPriority() == 1) {
          if (localObject5 != null) {
            i = 1;
          } else {
            i = 0;
          }
        }
        j = i;
        if (((Api.Client)localObject6).providesSignIn()) {
          if (??? == null)
          {
            ??? = localObject2;
            j = i;
          }
          else
          {
            localObject2 = ((Api)localObject2).getName();
            ??? = ((Api)???).getName();
            localObject4 = new StringBuilder(String.valueOf(localObject2).length() + 21 + String.valueOf(???).length());
            ((StringBuilder)localObject4).append((String)localObject2);
            ((StringBuilder)localObject4).append(" cannot be used with ");
            ((StringBuilder)localObject4).append((String)???);
            throw new IllegalStateException(((StringBuilder)localObject4).toString());
          }
        }
      }
      if (??? != null) {
        if (j == 0)
        {
          if (this.zax == null) {
            bool = true;
          } else {
            bool = false;
          }
          Preconditions.checkState(bool, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", new Object[] { ((Api)???).getName() });
          Preconditions.checkState(this.zabr.equals(this.zabs), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", new Object[] { ((Api)???).getName() });
        }
        else
        {
          ??? = ((Api)???).getName();
          localObject2 = new StringBuilder(String.valueOf(???).length() + 82);
          ((StringBuilder)localObject2).append("With using ");
          ((StringBuilder)localObject2).append((String)???);
          ((StringBuilder)localObject2).append(", GamesOptions can only be specified within GoogleSignInOptions.Builder");
          throw new IllegalStateException(((StringBuilder)localObject2).toString());
        }
      }
      int i = zaaw.zaa(localArrayMap2.values(), true);
      Object localObject2 = new zaaw(this.mContext, new ReentrantLock(), this.zabj, (ClientSettings)localObject4, this.zacd, this.zace, localArrayMap1, this.zacf, this.zacg, localArrayMap2, this.zacb, i, localArrayList, false);
      synchronized (GoogleApiClient.zal())
      {
        GoogleApiClient.zal().add(localObject2);
        if (this.zacb >= 0) {
          zaj.zaa(this.zaca).zaa(this.zacb, (GoogleApiClient)localObject2, this.zacc);
        }
        return (GoogleApiClient)localObject2;
      }
    }
    
    public final ClientSettings buildClientSettings()
    {
      SignInOptions localSignInOptions = SignInOptions.DEFAULT;
      if (this.zabz.containsKey(zaa.API)) {
        localSignInOptions = (SignInOptions)this.zabz.get(zaa.API);
      }
      return new ClientSettings(this.zax, this.zabr, this.zabx, this.zabt, this.zabu, this.zabv, this.zabw, localSignInOptions, false);
    }
    
    public final Builder enableAutoManage(FragmentActivity paramFragmentActivity, int paramInt, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      paramFragmentActivity = new LifecycleActivity(paramFragmentActivity);
      boolean bool;
      if (paramInt >= 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "clientId must be non-negative");
      this.zacb = paramInt;
      this.zacc = paramOnConnectionFailedListener;
      this.zaca = paramFragmentActivity;
      return this;
    }
    
    public final Builder enableAutoManage(FragmentActivity paramFragmentActivity, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      return enableAutoManage(paramFragmentActivity, 0, paramOnConnectionFailedListener);
    }
    
    public final Builder setAccountName(String paramString)
    {
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = new Account(paramString, "com.google");
      }
      this.zax = paramString;
      return this;
    }
    
    public final Builder setGravityForPopups(int paramInt)
    {
      this.zabt = paramInt;
      return this;
    }
    
    public final Builder setHandler(Handler paramHandler)
    {
      Preconditions.checkNotNull(paramHandler, "Handler must not be null");
      this.zabj = paramHandler.getLooper();
      return this;
    }
    
    public final Builder setViewForPopups(View paramView)
    {
      Preconditions.checkNotNull(paramView, "View must not be null");
      this.zabu = paramView;
      return this;
    }
    
    public final Builder useDefaultAccount()
    {
      return setAccountName("<<default account>>");
    }
  }
  
  public static abstract interface ConnectionCallbacks
  {
    public static final int CAUSE_NETWORK_LOST = 2;
    public static final int CAUSE_SERVICE_DISCONNECTED = 1;
    
    public abstract void onConnected(Bundle paramBundle);
    
    public abstract void onConnectionSuspended(int paramInt);
  }
  
  public static abstract interface OnConnectionFailedListener
  {
    public abstract void onConnectionFailed(ConnectionResult paramConnectionResult);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\GoogleApiClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */