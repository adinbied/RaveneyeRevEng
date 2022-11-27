package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zaj;
import java.lang.ref.WeakReference;

final class zaar
  extends zac
{
  private final WeakReference<zaak> zagk;
  
  zaar(zaak paramzaak)
  {
    this.zagk = new WeakReference(paramzaak);
  }
  
  public final void zab(zaj paramzaj)
  {
    zaak localzaak = (zaak)this.zagk.get();
    if (localzaak == null) {
      return;
    }
    zaak.zad(localzaak).zaa(new zaas(this, localzaak, localzaak, paramzaj));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zaar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */