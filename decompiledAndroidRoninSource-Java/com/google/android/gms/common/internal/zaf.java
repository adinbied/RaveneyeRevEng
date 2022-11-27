package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;

final class zaf
  implements BaseGmsClient.BaseConnectionCallbacks
{
  zaf(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks) {}
  
  public final void onConnected(Bundle paramBundle)
  {
    this.zaoj.onConnected(paramBundle);
  }
  
  public final void onConnectionSuspended(int paramInt)
  {
    this.zaoj.onConnectionSuspended(paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\internal\zaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */