package com.google.android.gms.internal.location;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;

public class zzk
  extends GmsClient<zzao>
{
  private final String zzca;
  protected final zzbj<zzao> zzcb = new zzl(this);
  
  public zzk(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, ClientSettings paramClientSettings)
  {
    super(paramContext, paramLooper, 23, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zzca = paramString;
  }
  
  protected Bundle getGetServiceRequestExtraArgs()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("client_name", this.zzca);
    return localBundle;
  }
  
  public int getMinApkVersion()
  {
    return 11925000;
  }
  
  protected String getServiceDescriptor()
  {
    return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
  }
  
  protected String getStartServiceAction()
  {
    return "com.google.android.location.internal.GoogleLocationManagerService.START";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\location\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */