package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class Api<O extends ApiOptions>
{
  private final String mName;
  private final AbstractClientBuilder<?, O> zaau;
  private final zaa<?, O> zaav;
  private final ClientKey<?> zaaw;
  private final zab<?> zaax;
  
  public <C extends Client> Api(String paramString, AbstractClientBuilder<C, O> paramAbstractClientBuilder, ClientKey<C> paramClientKey)
  {
    Preconditions.checkNotNull(paramAbstractClientBuilder, "Cannot construct an Api with a null ClientBuilder");
    Preconditions.checkNotNull(paramClientKey, "Cannot construct an Api with a null ClientKey");
    this.mName = paramString;
    this.zaau = paramAbstractClientBuilder;
    this.zaav = null;
    this.zaaw = paramClientKey;
    this.zaax = null;
  }
  
  public final AnyClientKey<?> getClientKey()
  {
    ClientKey localClientKey = this.zaaw;
    if (localClientKey != null) {
      return localClientKey;
    }
    throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
  }
  
  public final String getName()
  {
    return this.mName;
  }
  
  public final BaseClientBuilder<?, O> zah()
  {
    return this.zaau;
  }
  
  public final AbstractClientBuilder<?, O> zai()
  {
    boolean bool;
    if (this.zaau != null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
    return this.zaau;
  }
  
  public static abstract class AbstractClientBuilder<T extends Api.Client, O>
    extends Api.BaseClientBuilder<T, O>
  {
    public abstract T buildClient(Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, O paramO, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener);
  }
  
  public static abstract interface AnyClient {}
  
  public static class AnyClientKey<C extends Api.AnyClient> {}
  
  public static abstract interface ApiOptions
  {
    public static abstract interface HasAccountOptions
      extends Api.ApiOptions.HasOptions, Api.ApiOptions.NotRequiredOptions
    {
      public abstract Account getAccount();
    }
    
    public static abstract interface HasGoogleSignInAccountOptions
      extends Api.ApiOptions.HasOptions
    {
      public abstract GoogleSignInAccount getGoogleSignInAccount();
    }
    
    public static abstract interface HasOptions
      extends Api.ApiOptions
    {}
    
    public static final class NoOptions
      implements Api.ApiOptions.NotRequiredOptions
    {}
    
    public static abstract interface NotRequiredOptions
      extends Api.ApiOptions
    {}
    
    public static abstract interface Optional
      extends Api.ApiOptions.HasOptions, Api.ApiOptions.NotRequiredOptions
    {}
  }
  
  public static class BaseClientBuilder<T extends Api.AnyClient, O>
  {
    public static final int API_PRIORITY_GAMES = 1;
    public static final int API_PRIORITY_OTHER = Integer.MAX_VALUE;
    public static final int API_PRIORITY_PLUS = 2;
    
    public List<Scope> getImpliedScopes(O paramO)
    {
      return Collections.emptyList();
    }
    
    public int getPriority()
    {
      return Integer.MAX_VALUE;
    }
  }
  
  public static abstract interface Client
    extends Api.AnyClient
  {
    public abstract void connect(BaseGmsClient.ConnectionProgressReportCallbacks paramConnectionProgressReportCallbacks);
    
    public abstract void disconnect();
    
    public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
    
    public abstract Feature[] getAvailableFeatures();
    
    public abstract String getEndpointPackageName();
    
    public abstract int getMinApkVersion();
    
    public abstract void getRemoteService(IAccountAccessor paramIAccountAccessor, Set<Scope> paramSet);
    
    public abstract Feature[] getRequiredFeatures();
    
    public abstract IBinder getServiceBrokerBinder();
    
    public abstract Intent getSignInIntent();
    
    public abstract boolean isConnected();
    
    public abstract boolean isConnecting();
    
    public abstract void onUserSignOut(BaseGmsClient.SignOutCallbacks paramSignOutCallbacks);
    
    public abstract boolean providesSignIn();
    
    public abstract boolean requiresAccount();
    
    public abstract boolean requiresGooglePlayServices();
    
    public abstract boolean requiresSignIn();
  }
  
  public static final class ClientKey<C extends Api.Client>
    extends Api.AnyClientKey<C>
  {}
  
  public static abstract interface SimpleClient<T extends IInterface>
    extends Api.AnyClient
  {
    public abstract T createServiceInterface(IBinder paramIBinder);
    
    public abstract Context getContext();
    
    public abstract String getServiceDescriptor();
    
    public abstract String getStartServiceAction();
    
    public abstract void setState(int paramInt, T paramT);
  }
  
  public static class zaa<T extends Api.SimpleClient, O>
    extends Api.BaseClientBuilder<T, O>
  {}
  
  public static final class zab<C extends Api.SimpleClient>
    extends Api.AnyClientKey<C>
  {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\Api.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */