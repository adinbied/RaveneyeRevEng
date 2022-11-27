package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import javax.annotation.Nullable;

public class ScaleTypeDrawable
  extends ForwardingDrawable
{
  Matrix mDrawMatrix;
  @Nullable
  PointF mFocusPoint = null;
  ScalingUtils.ScaleType mScaleType;
  Object mScaleTypeState;
  private Matrix mTempMatrix = new Matrix();
  int mUnderlyingHeight = 0;
  int mUnderlyingWidth = 0;
  
  public ScaleTypeDrawable(Drawable paramDrawable, ScalingUtils.ScaleType paramScaleType)
  {
    super((Drawable)Preconditions.checkNotNull(paramDrawable));
    this.mScaleType = paramScaleType;
  }
  
  public ScaleTypeDrawable(Drawable paramDrawable, ScalingUtils.ScaleType paramScaleType, @Nullable PointF paramPointF)
  {
    super((Drawable)Preconditions.checkNotNull(paramDrawable));
    this.mScaleType = paramScaleType;
    this.mFocusPoint = paramPointF;
  }
  
  private void configureBoundsIfUnderlyingChanged()
  {
    Object localObject = this.mScaleType;
    boolean bool = localObject instanceof ScalingUtils.StatefulScaleType;
    int k = 1;
    int i;
    if (bool)
    {
      localObject = ((ScalingUtils.StatefulScaleType)localObject).getState();
      if ((localObject != null) && (localObject.equals(this.mScaleTypeState))) {
        i = 0;
      } else {
        i = 1;
      }
      this.mScaleTypeState = localObject;
    }
    else
    {
      i = 0;
    }
    int j = k;
    if (this.mUnderlyingWidth == getCurrent().getIntrinsicWidth()) {
      if (this.mUnderlyingHeight != getCurrent().getIntrinsicHeight()) {
        j = k;
      } else {
        j = 0;
      }
    }
    if ((j != 0) || (i != 0)) {
      configureBounds();
    }
  }
  
  void configureBounds()
  {
    Object localObject = getCurrent();
    Rect localRect = getBounds();
    int i = localRect.width();
    int j = localRect.height();
    int k = ((Drawable)localObject).getIntrinsicWidth();
    this.mUnderlyingWidth = k;
    int m = ((Drawable)localObject).getIntrinsicHeight();
    this.mUnderlyingHeight = m;
    if ((k > 0) && (m > 0))
    {
      if ((k == i) && (m == j))
      {
        ((Drawable)localObject).setBounds(localRect);
        this.mDrawMatrix = null;
        return;
      }
      if (this.mScaleType == ScalingUtils.ScaleType.FIT_XY)
      {
        ((Drawable)localObject).setBounds(localRect);
        this.mDrawMatrix = null;
        return;
      }
      ((Drawable)localObject).setBounds(0, 0, k, m);
      localObject = this.mScaleType;
      Matrix localMatrix = this.mTempMatrix;
      PointF localPointF = this.mFocusPoint;
      float f1;
      if (localPointF != null) {
        f1 = localPointF.x;
      } else {
        f1 = 0.5F;
      }
      localPointF = this.mFocusPoint;
      float f2;
      if (localPointF != null) {
        f2 = localPointF.y;
      } else {
        f2 = 0.5F;
      }
      ((ScalingUtils.ScaleType)localObject).getTransform(localMatrix, localRect, k, m, f1, f2);
      this.mDrawMatrix = this.mTempMatrix;
      return;
    }
    ((Drawable)localObject).setBounds(localRect);
    this.mDrawMatrix = null;
  }
  
  public void draw(Canvas paramCanvas)
  {
    configureBoundsIfUnderlyingChanged();
    if (this.mDrawMatrix != null)
    {
      int i = paramCanvas.save();
      paramCanvas.clipRect(getBounds());
      paramCanvas.concat(this.mDrawMatrix);
      super.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
      return;
    }
    super.draw(paramCanvas);
  }
  
  @Nullable
  public PointF getFocusPoint()
  {
    return this.mFocusPoint;
  }
  
  public ScalingUtils.ScaleType getScaleType()
  {
    return this.mScaleType;
  }
  
  public void getTransform(Matrix paramMatrix)
  {
    getParentTransform(paramMatrix);
    configureBoundsIfUnderlyingChanged();
    Matrix localMatrix = this.mDrawMatrix;
    if (localMatrix != null) {
      paramMatrix.preConcat(localMatrix);
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    configureBounds();
  }
  
  public Drawable setCurrent(Drawable paramDrawable)
  {
    paramDrawable = super.setCurrent(paramDrawable);
    configureBounds();
    return paramDrawable;
  }
  
  public void setFocusPoint(@Nullable PointF paramPointF)
  {
    if (Objects.equal(this.mFocusPoint, paramPointF)) {
      return;
    }
    if (paramPointF == null)
    {
      this.mFocusPoint = null;
    }
    else
    {
      if (this.mFocusPoint == null) {
        this.mFocusPoint = new PointF();
      }
      this.mFocusPoint.set(paramPointF);
    }
    configureBounds();
    invalidateSelf();
  }
  
  public void setScaleType(ScalingUtils.ScaleType paramScaleType)
  {
    if (Objects.equal(this.mScaleType, paramScaleType)) {
      return;
    }
    this.mScaleType = paramScaleType;
    this.mScaleTypeState = null;
    configureBounds();
    invalidateSelf();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\drawable\ScaleTypeDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */