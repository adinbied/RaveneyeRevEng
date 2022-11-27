package com.facebook.drawee.generic;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.VisibilityAwareDrawable;
import com.facebook.drawee.drawable.VisibilityCallback;
import javax.annotation.Nullable;

public class RootDrawable
  extends ForwardingDrawable
  implements VisibilityAwareDrawable
{
  @Nullable
  Drawable mControllerOverlay = null;
  @Nullable
  private VisibilityCallback mVisibilityCallback;
  
  public RootDrawable(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (!isVisible()) {
      return;
    }
    Object localObject = this.mVisibilityCallback;
    if (localObject != null) {
      ((VisibilityCallback)localObject).onDraw();
    }
    super.draw(paramCanvas);
    localObject = this.mControllerOverlay;
    if (localObject != null)
    {
      ((Drawable)localObject).setBounds(getBounds());
      this.mControllerOverlay.draw(paramCanvas);
    }
  }
  
  public int getIntrinsicHeight()
  {
    return -1;
  }
  
  public int getIntrinsicWidth()
  {
    return -1;
  }
  
  public void setControllerOverlay(@Nullable Drawable paramDrawable)
  {
    this.mControllerOverlay = paramDrawable;
    invalidateSelf();
  }
  
  public void setVisibilityCallback(@Nullable VisibilityCallback paramVisibilityCallback)
  {
    this.mVisibilityCallback = paramVisibilityCallback;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    VisibilityCallback localVisibilityCallback = this.mVisibilityCallback;
    if (localVisibilityCallback != null) {
      localVisibilityCallback.onVisibilityChange(paramBoolean1);
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\generic\RootDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */