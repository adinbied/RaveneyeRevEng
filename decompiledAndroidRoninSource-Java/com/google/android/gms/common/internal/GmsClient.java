package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import java.util.Iterator;
import java.util.Set;

public abstract class GmsClient<T extends IInterface>
  extends BaseGmsClient<T>
  implements Api.Client, GmsClientEventManager.GmsClientEventState
{
  private final Set<Scope> mScopes;
  private final ClientSettings zaet;
  private final Account zax;
  
  protected GmsClient(Context paramContext, Handler paramHandler, int paramInt, ClientSettings paramClientSettings)
  {
    this(paramContext, paramHandler, GmsClientSupervisor.getInstance(paramContext), GoogleApiAvailability.getInstance(), paramInt, paramClientSettings, null, null);
  }
  
  protected GmsClient(Context paramContext, Handler paramHandler, GmsClientSupervisor paramGmsClientSupervisor, GoogleApiAvailability paramGoogleApiAvailability, int paramInt, ClientSettings paramClientSettings, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramHandler, paramGmsClientSupervisor, paramGoogleApiAvailability, paramInt, zaa(paramConnectionCallbacks), zaa(paramOnConnectionFailedListener));
    this.zaet = ((ClientSettings)Preconditions.checkNotNull(paramClientSettings));
    this.zax = paramClientSettings.getAccount();
    this.mScopes = zaa(paramClientSettings.getAllRequestedScopes());
  }
  
  protected GmsClient(Context paramContext, Looper paramLooper, int paramInt, ClientSettings paramClientSettings)
  {
    this(paramContext, paramLooper, GmsClientSupervisor.getInstance(paramContext), GoogleApiAvailability.getInstance(), paramInt, paramClientSettings, null, null);
  }
  
  protected GmsClient(Context paramContext, Looper paramLooper, int paramInt, ClientSettings paramClientSettings, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this(paramContext, paramLooper, GmsClientSupervisor.getInstance(paramContext), GoogleApiAvailability.getInstance(), paramInt, paramClientSettings, (GoogleApiClient.ConnectionCallbacks)Preconditions.checkNotNull(paramConnectionCallbacks), (GoogleApiClient.OnConnectionFailedListener)Preconditions.checkNotNull(paramOnConnectionFailedListener));
  }
  
  protected GmsClient(Context paramContext, Looper paramLooper, GmsClientSupervisor paramGmsClientSupervisor, GoogleApiAvailability paramGoogleApiAvailability, int paramInt, ClientSettings paramClientSettings, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, paramGmsClientSupervisor, paramGoogleApiAvailability, paramInt, zaa(paramConnectionCallbacks), zaa(paramOnConnectionFailedListener), paramClientSettings.getRealClientClassName());
    this.zaet = paramClientSettings;
    this.zax = paramClientSettings.getAccount();
    this.mScopes = zaa(paramClientSettings.getAllRequestedScopes());
  }
  
  private static BaseGmsClient.BaseConnectionCallbacks zaa(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    if (paramConnectionCallbacks == null) {
      return null;
    }
    return new zaf(paramConnectionCallbacks);
  }
  
  private static BaseGmsClient.BaseOnConnectionFailedListener zaa(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    if (paramOnConnectionFailedListener == null) {
      return null;
    }
    return new zag(paramOnConnectionFailedListener);
  }
  
  private final Set<Scope> zaa(Set<Scope> paramSet)
  {
    Set localSet = validateScopes(paramSet);
    Iterator localIterator = localSet.iterator();
    while (localIterator.hasNext()) {
      if (!paramSet.contains((Scope)localIterator.next())) {
        throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
      }
    }
    return localSet;
  }
  
  public final Account getAccount()
  {
    return this.zax;
  }
  
  protected final ClientSettings getClientSettings()
  {
    return this.zaet;
  }
  
  public int getMinApkVersion()
  {
    return super.getMinApkVersion();
  }
  
  public Feature[] getRequiredFeatures()
  {
    return new Feature[0];
  }
  
  protected final Set<Scope> getScopes()
  {
    return this.mScopes;
  }
  
  protected Set<Scope> validateScopes(Set<Scope> paramSet)
  {
    return paramSet;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\internal\GmsClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */