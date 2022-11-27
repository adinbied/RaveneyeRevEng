package com.google.android.gms.common.internal.service;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;

public final class zai
  extends GmsClient<zal>
{
  public zai(Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 39, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  protected final String getServiceDescriptor()
  {
    return "com.google.android.gms.common.internal.service.ICommonService";
  }
  
  public final String getStartServiceAction()
  {
    return "com.google.android.gms.common.service.START";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\internal\service\zai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */