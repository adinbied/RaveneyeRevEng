package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api.Client;

public class GoogleApiAvailabilityCache
{
  private final SparseIntArray zaos = new SparseIntArray();
  private GoogleApiAvailabilityLight zaot;
  
  public GoogleApiAvailabilityCache()
  {
    this(GoogleApiAvailability.getInstance());
  }
  
  public GoogleApiAvailabilityCache(GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight)
  {
    Preconditions.checkNotNull(paramGoogleApiAvailabilityLight);
    this.zaot = paramGoogleApiAvailabilityLight;
  }
  
  public void flush()
  {
    this.zaos.clear();
  }
  
  public int getClientAvailability(Context paramContext, Api.Client paramClient)
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramClient);
    boolean bool = paramClient.requiresGooglePlayServices();
    int j = 0;
    if (!bool) {
      return 0;
    }
    int m = paramClient.getMinApkVersion();
    int k = this.zaos.get(m, -1);
    if (k != -1) {
      return k;
    }
    int i = 0;
    while (i < this.zaos.size())
    {
      int n = this.zaos.keyAt(i);
      if ((n > m) && (this.zaos.get(n) == 0))
      {
        i = j;
        break label115;
      }
      i += 1;
    }
    i = k;
    label115:
    j = i;
    if (i == -1) {
      j = this.zaot.isGooglePlayServicesAvailable(paramContext, m);
    }
    this.zaos.put(m, j);
    return j;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\internal\GoogleApiAvailabilityCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */