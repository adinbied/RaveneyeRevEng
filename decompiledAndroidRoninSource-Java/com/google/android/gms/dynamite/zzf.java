package com.google.android.gms.dynamite;

import android.content.Context;

final class zzf
  implements DynamiteModule.VersionPolicy
{
  public final DynamiteModule.VersionPolicy.zzb zza(Context paramContext, String paramString, DynamiteModule.VersionPolicy.zza paramzza)
    throws DynamiteModule.LoadingException
  {
    DynamiteModule.VersionPolicy.zzb localzzb = new DynamiteModule.VersionPolicy.zzb();
    localzzb.zzir = paramzza.getLocalVersion(paramContext, paramString);
    localzzb.zzis = paramzza.zza(paramContext, paramString, true);
    if ((localzzb.zzir == 0) && (localzzb.zzis == 0))
    {
      localzzb.zzit = 0;
      return localzzb;
    }
    if (localzzb.zzis >= localzzb.zzir)
    {
      localzzb.zzit = 1;
      return localzzb;
    }
    localzzb.zzit = -1;
    return localzzb;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\dynamite\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */