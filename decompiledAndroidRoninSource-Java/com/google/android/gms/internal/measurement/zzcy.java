package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import javax.annotation.Nullable;

final class zzcy
  implements zzcx
{
  private static zzcy zza;
  @Nullable
  private final Context zzb;
  @Nullable
  private final ContentObserver zzc;
  
  private zzcy()
  {
    this.zzb = null;
    this.zzc = null;
  }
  
  private zzcy(Context paramContext)
  {
    this.zzb = paramContext;
    this.zzc = new zzda(this, null);
    paramContext.getContentResolver().registerContentObserver(zzcp.zza, true, this.zzc);
  }
  
  static zzcy zza(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (zza == null)
        {
          if (PermissionChecker.checkSelfPermission(paramContext, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0)
          {
            i = 1;
            if (i != 0) {
              paramContext = new zzcy(paramContext);
            } else {
              paramContext = new zzcy();
            }
            zza = paramContext;
          }
        }
        else
        {
          paramContext = zza;
          return paramContext;
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  static void zza()
  {
    try
    {
      if ((zza != null) && (zza.zzb != null) && (zza.zzc != null)) {
        zza.zzb.getContentResolver().unregisterContentObserver(zza.zzc);
      }
      zza = null;
      return;
    }
    finally {}
  }
  
  private final String zzc(String paramString)
  {
    if (this.zzb == null) {
      return null;
    }
    try
    {
      String str = (String)zzcw.zza(new zzdb(this, paramString));
      return str;
    }
    catch (SecurityException localSecurityException) {}catch (IllegalStateException localIllegalStateException) {}
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      paramString = "Unable to read GServices for: ".concat(paramString);
    } else {
      paramString = new String("Unable to read GServices for: ");
    }
    Log.e("GservicesLoader", paramString, localIllegalStateException);
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzcy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */