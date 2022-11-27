package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import javax.annotation.Nullable;

public class ForwardingDrawable
  extends Drawable
  implements Drawable.Callback, TransformCallback, TransformAwareDrawable, DrawableParent
{
  private static final Matrix sTempTransform = new Matrix();
  @Nullable
  private Drawable mCurrentDelegate;
  private final DrawableProperties mDrawableProperties = new DrawableProperties();
  protected TransformCallback mTransformCallback;
  
  public ForwardingDrawable(@Nullable Drawable paramDrawable)
  {
    this.mCurrentDelegate = paramDrawable;
    DrawableUtils.setCallbacks(paramDrawable, this, this);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Drawable localDrawable = this.mCurrentDelegate;
    if (localDrawable != null) {
      localDrawable.draw(paramCanvas);
    }
  }
  
  @Nullable
  public Drawable.ConstantState getConstantState()
  {
    Drawable localDrawable = this.mCurrentDelegate;
    if (localDrawable == null) {
      return super.getConstantState();
    }
    return localDrawable.getConstantState();
  }
  
  @Nullable
  public Drawable getCurrent()
  {
    return this.mCurrentDelegate;
  }
  
  @Nullable
  public Drawable getDrawable()
  {
    return getCurrent();
  }
  
  public int getIntrinsicHeight()
  {
    Drawable localDrawable = this.mCurrentDelegate;
    if (localDrawable == null) {
      return super.getIntrinsicHeight();
    }
    return localDrawable.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    Drawable localDrawable = this.mCurrentDelegate;
    if (localDrawable == null) {
      return super.getIntrinsicWidth();
    }
    return localDrawable.getIntrinsicWidth();
  }
  
  public int getOpacity()
  {
    Drawable localDrawable = this.mCurrentDelegate;
    if (localDrawable == null) {
      return 0;
    }
    return localDrawable.getOpacity();
  }
  
  public boolean getPadding(Rect paramRect)
  {
    Drawable localDrawable = this.mCurrentDelegate;
    if (localDrawable == null) {
      return super.getPadding(paramRect);
    }
    return localDrawable.getPadding(paramRect);
  }
  
  protected void getParentTransform(Matrix paramMatrix)
  {
    TransformCallback localTransformCallback = this.mTransformCallback;
    if (localTransformCallback != null)
    {
      localTransformCallback.getTransform(paramMatrix);
      return;
    }
    paramMatrix.reset();
  }
  
  public void getRootBounds(RectF paramRectF)
  {
    TransformCallback localTransformCallback = this.mTransformCallback;
    if (localTransformCallback != null)
    {
      localTransformCallback.getRootBounds(paramRectF);
      return;
    }
    paramRectF.set(getBounds());
  }
  
  public void getTransform(Matrix paramMatrix)
  {
    getParentTransform(paramMatrix);
  }
  
  public void getTransformedBounds(RectF paramRectF)
  {
    getParentTransform(sTempTransform);
    paramRectF.set(getBounds());
    sTempTransform.mapRect(paramRectF);
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidateSelf();
  }
  
  public boolean isStateful()
  {
    Drawable localDrawable = this.mCurrentDelegate;
    if (localDrawable == null) {
      return false;
    }
    return localDrawable.isStateful();
  }
  
  public Drawable mutate()
  {
    Drawable localDrawable = this.mCurrentDelegate;
    if (localDrawable != null) {
      localDrawable.mutate();
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    Drawable localDrawable = this.mCurrentDelegate;
    if (localDrawable != null) {
      localDrawable.setBounds(paramRect);
    }
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    Drawable localDrawable = this.mCurrentDelegate;
    if (localDrawable == null) {
      return super.onLevelChange(paramInt);
    }
    return localDrawable.setLevel(paramInt);
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    Drawable localDrawable = this.mCurrentDelegate;
    if (localDrawable == null) {
      return super.onStateChange(paramArrayOfInt);
    }
    return localDrawable.setState(paramArrayOfInt);
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    this.mDrawableProperties.setAlpha(paramInt);
    Drawable localDrawable = this.mCurrentDelegate;
    if (localDrawable != null) {
      localDrawable.setAlpha(paramInt);
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mDrawableProperties.setColorFilter(paramColorFilter);
    Drawable localDrawable = this.mCurrentDelegate;
    if (localDrawable != null) {
      localDrawable.setColorFilter(paramColorFilter);
    }
  }
  
  @Nullable
  public Drawable setCurrent(@Nullable Drawable paramDrawable)
  {
    paramDrawable = setCurrentWithoutInvalidate(paramDrawable);
    invalidateSelf();
    return paramDrawable;
  }
  
  @Nullable
  protected Drawable setCurrentWithoutInvalidate(@Nullable Drawable paramDrawable)
  {
    Drawable localDrawable = this.mCurrentDelegate;
    DrawableUtils.setCallbacks(localDrawable, null, null);
    DrawableUtils.setCallbacks(paramDrawable, null, null);
    DrawableUtils.setDrawableProperties(paramDrawable, this.mDrawableProperties);
    DrawableUtils.copyProperties(paramDrawable, this);
    DrawableUtils.setCallbacks(paramDrawable, this, this);
    this.mCurrentDelegate = paramDrawable;
    return localDrawable;
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mDrawableProperties.setDither(paramBoolean);
    Drawable localDrawable = this.mCurrentDelegate;
    if (localDrawable != null) {
      localDrawable.setDither(paramBoolean);
    }
  }
  
  public Drawable setDrawable(@Nullable Drawable paramDrawable)
  {
    return setCurrent(paramDrawable);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.mDrawableProperties.setFilterBitmap(paramBoolean);
    Drawable localDrawable = this.mCurrentDelegate;
    if (localDrawable != null) {
      localDrawable.setFilterBitmap(paramBoolean);
    }
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    Drawable localDrawable = this.mCurrentDelegate;
    if (localDrawable != null) {
      localDrawable.setHotspot(paramFloat1, paramFloat2);
    }
  }
  
  public void setTransformCallback(TransformCallback paramTransformCallback)
  {
    this.mTransformCallback = paramTransformCallback;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    Drawable localDrawable = this.mCurrentDelegate;
    if (localDrawable == null) {
      return bool;
    }
    return localDrawable.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    unscheduleSelf(paramRunnable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\drawable\ForwardingDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */