package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zak;

public abstract class zaa
{
  final zab zamv;
  private int zamw = 0;
  protected int zamx = 0;
  private boolean zamy = false;
  private boolean zamz = true;
  private boolean zana = false;
  private boolean zanb = true;
  
  public zaa(Uri paramUri, int paramInt)
  {
    this.zamv = new zab(paramUri);
    this.zamx = paramInt;
  }
  
  final void zaa(Context paramContext, Bitmap paramBitmap, boolean paramBoolean)
  {
    Asserts.checkNotNull(paramBitmap);
    zaa(new BitmapDrawable(paramContext.getResources(), paramBitmap), paramBoolean, false, true);
  }
  
  final void zaa(Context paramContext, zak paramzak)
  {
    if (this.zanb) {
      zaa(null, false, true, false);
    }
  }
  
  final void zaa(Context paramContext, zak paramzak, boolean paramBoolean)
  {
    int i = this.zamx;
    if (i != 0) {
      paramContext = paramContext.getResources().getDrawable(i);
    } else {
      paramContext = null;
    }
    zaa(paramContext, paramBoolean, false, false);
  }
  
  protected abstract void zaa(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  protected final boolean zaa(boolean paramBoolean1, boolean paramBoolean2)
  {
    return (this.zamz) && (!paramBoolean2) && (!paramBoolean1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\images\zaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */