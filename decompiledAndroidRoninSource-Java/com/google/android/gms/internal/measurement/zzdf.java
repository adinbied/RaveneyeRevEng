package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.util.Log;

public final class zzdf
{
  private static volatile zzdy<Boolean> zza = ;
  private static final Object zzb = new Object();
  
  private static boolean zza(Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getApplicationInfo("com.google.android.gms", 0);
      return (paramContext.flags & 0x81) != 0;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  public static boolean zza(Context paramContext, Uri arg1)
  {
    ??? = ???.getAuthority();
    boolean bool1 = "com.google.android.gms.phenotype".equals(???);
    boolean bool2 = false;
    if (!bool1)
    {
      paramContext = new StringBuilder(String.valueOf(???).length() + 91);
      paramContext.append(???);
      paramContext.append(" is an unsupported authority. Only com.google.android.gms.phenotype authority is supported.");
      Log.e("PhenotypeClientHelper", paramContext.toString());
      return false;
    }
    if (zza.zza()) {
      return ((Boolean)zza.zzb()).booleanValue();
    }
    for (;;)
    {
      synchronized (zzb)
      {
        if (zza.zza())
        {
          bool1 = ((Boolean)zza.zzb()).booleanValue();
          return bool1;
        }
        if (!"com.google.android.gms".equals(paramContext.getPackageName()))
        {
          ProviderInfo localProviderInfo = paramContext.getPackageManager().resolveContentProvider("com.google.android.gms.phenotype", 0);
          if ((localProviderInfo == null) || (!"com.google.android.gms".equals(localProviderInfo.packageName))) {
            break label218;
          }
          break label213;
          bool1 = bool2;
          if (i != 0)
          {
            bool1 = bool2;
            if (zza(paramContext)) {
              bool1 = true;
            }
          }
          zza = zzdy.zza(Boolean.valueOf(bool1));
          return ((Boolean)zza.zzb()).booleanValue();
        }
      }
      label213:
      int i = 1;
      continue;
      label218:
      i = 0;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzdf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */