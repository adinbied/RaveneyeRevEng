package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.common.util.ClientLibraryUtils;
import java.util.Collections;
import java.util.List;

public class ConnectionTracker
{
  private static final Object zzdp = new Object();
  private static volatile ConnectionTracker zzfa;
  private static boolean zzfb = false;
  private final List<String> zzfc = Collections.EMPTY_LIST;
  private final List<String> zzfd = Collections.EMPTY_LIST;
  private final List<String> zzfe = Collections.EMPTY_LIST;
  private final List<String> zzff = Collections.EMPTY_LIST;
  
  public static ConnectionTracker getInstance()
  {
    if (zzfa == null) {
      synchronized (zzdp)
      {
        if (zzfa == null) {
          zzfa = new ConnectionTracker();
        }
      }
    }
    return zzfa;
  }
  
  public boolean bindService(Context paramContext, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    return zza(paramContext, paramContext.getClass().getName(), paramIntent, paramServiceConnection, paramInt);
  }
  
  public void unbindService(Context paramContext, ServiceConnection paramServiceConnection)
  {
    paramContext.unbindService(paramServiceConnection);
  }
  
  public final boolean zza(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    paramString = paramIntent.getComponent();
    boolean bool;
    if (paramString == null) {
      bool = false;
    } else {
      bool = ClientLibraryUtils.zzc(paramContext, paramString.getPackageName());
    }
    if (bool)
    {
      Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
      return false;
    }
    return paramContext.bindService(paramIntent, paramServiceConnection, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\stats\ConnectionTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */