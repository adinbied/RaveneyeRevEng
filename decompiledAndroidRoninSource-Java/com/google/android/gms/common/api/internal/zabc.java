package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

final class zabc
  extends zabr
{
  private WeakReference<zaaw> zahm;
  
  zabc(zaaw paramzaaw)
  {
    this.zahm = new WeakReference(paramzaaw);
  }
  
  public final void zas()
  {
    zaaw localzaaw = (zaaw)this.zahm.get();
    if (localzaaw == null) {
      return;
    }
    zaaw.zaa(localzaaw);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zabc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */