package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicReference;

public class zaj
  extends zal
{
  private final SparseArray<zaa> zacw = new SparseArray();
  
  private zaj(LifecycleFragment paramLifecycleFragment)
  {
    super(paramLifecycleFragment);
    this.mLifecycleFragment.addCallback("AutoManageHelper", this);
  }
  
  public static zaj zaa(LifecycleActivity paramLifecycleActivity)
  {
    paramLifecycleActivity = getFragment(paramLifecycleActivity);
    zaj localzaj = (zaj)paramLifecycleActivity.getCallbackOrNull("AutoManageHelper", zaj.class);
    if (localzaj != null) {
      return localzaj;
    }
    return new zaj(paramLifecycleActivity);
  }
  
  private final zaa zab(int paramInt)
  {
    if (this.zacw.size() <= paramInt) {
      return null;
    }
    SparseArray localSparseArray = this.zacw;
    return (zaa)localSparseArray.get(localSparseArray.keyAt(paramInt));
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int i = 0;
    while (i < this.zacw.size())
    {
      zaa localzaa = zab(i);
      if (localzaa != null)
      {
        paramPrintWriter.append(paramString).append("GoogleApiClient #").print(localzaa.zacx);
        paramPrintWriter.println(":");
        localzaa.zacy.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      }
      i += 1;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    boolean bool = this.mStarted;
    Object localObject = String.valueOf(this.zacw);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject).length() + 14);
    localStringBuilder.append("onStart ");
    localStringBuilder.append(bool);
    localStringBuilder.append(" ");
    localStringBuilder.append((String)localObject);
    Log.d("AutoManageHelper", localStringBuilder.toString());
    if (this.zadf.get() == null)
    {
      int i = 0;
      while (i < this.zacw.size())
      {
        localObject = zab(i);
        if (localObject != null) {
          ((zaa)localObject).zacy.connect();
        }
        i += 1;
      }
    }
  }
  
  public void onStop()
  {
    super.onStop();
    int i = 0;
    while (i < this.zacw.size())
    {
      zaa localzaa = zab(i);
      if (localzaa != null) {
        localzaa.zacy.disconnect();
      }
      i += 1;
    }
  }
  
  public final void zaa(int paramInt)
  {
    zaa localzaa = (zaa)this.zacw.get(paramInt);
    this.zacw.remove(paramInt);
    if (localzaa != null)
    {
      localzaa.zacy.unregisterConnectionFailedListener(localzaa);
      localzaa.zacy.disconnect();
    }
  }
  
  public final void zaa(int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    Preconditions.checkNotNull(paramGoogleApiClient, "GoogleApiClient instance cannot be null");
    if (this.zacw.indexOfKey(paramInt) < 0) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject = new StringBuilder(54);
    ((StringBuilder)localObject).append("Already managing a GoogleApiClient with id ");
    ((StringBuilder)localObject).append(paramInt);
    Preconditions.checkState(bool, ((StringBuilder)localObject).toString());
    localObject = (zam)this.zadf.get();
    boolean bool = this.mStarted;
    String str = String.valueOf(localObject);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 49);
    localStringBuilder.append("starting AutoManage for client ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ");
    localStringBuilder.append(bool);
    localStringBuilder.append(" ");
    localStringBuilder.append(str);
    Log.d("AutoManageHelper", localStringBuilder.toString());
    paramOnConnectionFailedListener = new zaa(paramInt, paramGoogleApiClient, paramOnConnectionFailedListener);
    this.zacw.put(paramInt, paramOnConnectionFailedListener);
    if ((this.mStarted) && (localObject == null))
    {
      paramOnConnectionFailedListener = String.valueOf(paramGoogleApiClient);
      localObject = new StringBuilder(String.valueOf(paramOnConnectionFailedListener).length() + 11);
      ((StringBuilder)localObject).append("connecting ");
      ((StringBuilder)localObject).append(paramOnConnectionFailedListener);
      Log.d("AutoManageHelper", ((StringBuilder)localObject).toString());
      paramGoogleApiClient.connect();
    }
  }
  
  protected final void zaa(ConnectionResult paramConnectionResult, int paramInt)
  {
    Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
    if (paramInt < 0)
    {
      Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
      return;
    }
    Object localObject = (zaa)this.zacw.get(paramInt);
    if (localObject != null)
    {
      zaa(paramInt);
      localObject = ((zaa)localObject).zacz;
      if (localObject != null) {
        ((GoogleApiClient.OnConnectionFailedListener)localObject).onConnectionFailed(paramConnectionResult);
      }
    }
  }
  
  protected final void zao()
  {
    int i = 0;
    while (i < this.zacw.size())
    {
      zaa localzaa = zab(i);
      if (localzaa != null) {
        localzaa.zacy.connect();
      }
      i += 1;
    }
  }
  
  private final class zaa
    implements GoogleApiClient.OnConnectionFailedListener
  {
    public final int zacx;
    public final GoogleApiClient zacy;
    public final GoogleApiClient.OnConnectionFailedListener zacz;
    
    public zaa(int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      this.zacx = paramInt;
      this.zacy = paramGoogleApiClient;
      this.zacz = paramOnConnectionFailedListener;
      paramGoogleApiClient.registerConnectionFailedListener(this);
    }
    
    public final void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      String str = String.valueOf(paramConnectionResult);
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 27);
      localStringBuilder.append("beginFailureResolution for ");
      localStringBuilder.append(str);
      Log.d("AutoManageHelper", localStringBuilder.toString());
      zaj.this.zab(paramConnectionResult, this.zacx);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zaj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */