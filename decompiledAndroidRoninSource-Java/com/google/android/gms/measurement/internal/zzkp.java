package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

final class zzkp
  implements zzkv
{
  zzkp(zzki paramzzki) {}
  
  public final void zza(String paramString, Bundle paramBundle)
  {
    if (TextUtils.isEmpty(paramString))
    {
      zzki.zza(this.zza).zzq().zze().zza("AppId not known when logging error event");
      return;
    }
    this.zza.zzp().zza(new zzko(this, paramString, paramBundle));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzkp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */