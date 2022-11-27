package com.google.android.gms.common.api.internal;

import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class zaag
  extends GoogleApiClient
{
  private final String zafs;
  
  public zaag(String paramString)
  {
    this.zafs = paramString;
  }
  
  public ConnectionResult blockingConnect()
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public PendingResult<Status> clearDefaultAccountAndReconnect()
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public void connect()
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public void disconnect()
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public ConnectionResult getConnectionResult(Api<?> paramApi)
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public boolean hasConnectedApi(Api<?> paramApi)
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public boolean isConnected()
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public boolean isConnecting()
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public void reconnect()
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public void stopAutoManage(FragmentActivity paramFragmentActivity)
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    throw new UnsupportedOperationException(this.zafs);
  }
  
  public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    throw new UnsupportedOperationException(this.zafs);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zaag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */