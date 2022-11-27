package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import java.lang.ref.WeakReference;

public final class zad
  extends zaa
{
  private WeakReference<ImageManager.OnImageLoadedListener> zand;
  
  public zad(ImageManager.OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
  {
    super(paramUri, 0);
    Asserts.checkNotNull(paramOnImageLoadedListener);
    this.zand = new WeakReference(paramOnImageLoadedListener);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zad)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (zad)paramObject;
    ImageManager.OnImageLoadedListener localOnImageLoadedListener1 = (ImageManager.OnImageLoadedListener)this.zand.get();
    ImageManager.OnImageLoadedListener localOnImageLoadedListener2 = (ImageManager.OnImageLoadedListener)((zad)paramObject).zand.get();
    return (localOnImageLoadedListener2 != null) && (localOnImageLoadedListener1 != null) && (Objects.equal(localOnImageLoadedListener2, localOnImageLoadedListener1)) && (Objects.equal(((zad)paramObject).zamv, this.zamv));
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { this.zamv });
  }
  
  protected final void zaa(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!paramBoolean2)
    {
      ImageManager.OnImageLoadedListener localOnImageLoadedListener = (ImageManager.OnImageLoadedListener)this.zand.get();
      if (localOnImageLoadedListener != null) {
        localOnImageLoadedListener.onImageLoaded(this.zamv.uri, paramDrawable, paramBoolean3);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\images\zad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */