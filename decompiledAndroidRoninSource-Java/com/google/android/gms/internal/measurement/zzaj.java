package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;

final class zzaj
  extends zzag.zzb
{
  zzaj(zzag paramzzag, String paramString1, String paramString2, Context paramContext, Bundle paramBundle)
  {
    super(paramzzag);
  }
  
  public final void zza()
  {
    Object localObject3;
    String str;
    label81:
    boolean bool;
    int k;
    try
    {
      zzag.zza(this.zzg, new ArrayList());
      if (!zzag.zza(this.zzg, this.zzc, this.zzd)) {
        break label230;
      }
      localObject3 = this.zzd;
      localObject1 = this.zzc;
      str = zzag.zzb(this.zzg);
      zzag.zzb(this.zze);
      if (zzag.zzj().booleanValue()) {
        break label250;
      }
      if (localObject1 == null) {
        break label244;
      }
    }
    catch (Exception localException)
    {
      Object localObject1;
      zzag.zza(this.zzg, localException, true, false);
      return;
    }
    zzag.zza(this.zzg, this.zzg.zza(this.zze, bool));
    if (zzag.zzc(this.zzg) == null)
    {
      Log.w(zzag.zzb(this.zzg), "Failed to connect to measurement client.");
      return;
    }
    int j = zzag.zzc(this.zze);
    int i = zzag.zzd(this.zze);
    if (bool)
    {
      k = Math.max(j, i);
      if (i < j) {
        bool = true;
      }
    }
    for (;;)
    {
      localObject1 = new zzae(32053L, i, bool, str, (String)localObject1, (String)localObject3, this.zzf);
      zzag.zzc(this.zzg).initialize(ObjectWrapper.wrap(this.zze), (zzae)localObject1, this.zza);
      return;
      label230:
      str = null;
      Object localObject2 = str;
      localObject3 = localObject2;
      break;
      label244:
      bool = false;
      break label81;
      label250:
      bool = true;
      break label81;
      bool = false;
      i = k;
      continue;
      if (j > 0) {
        i = j;
      }
      if (j > 0) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzaj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */