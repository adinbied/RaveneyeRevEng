package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.facebook.common.internal.Preconditions;
import javax.annotation.Nullable;

public class ArrayDrawable
  extends Drawable
  implements Drawable.Callback, TransformCallback, TransformAwareDrawable
{
  private final DrawableParent[] mDrawableParents;
  private final DrawableProperties mDrawableProperties = new DrawableProperties();
  private boolean mIsMutated;
  private boolean mIsStateful;
  private boolean mIsStatefulCalculated;
  private final Drawable[] mLayers;
  private final Rect mTmpRect = new Rect();
  private TransformCallback mTransformCallback;
  
  public ArrayDrawable(Drawable[] paramArrayOfDrawable)
  {
    int i = 0;
    this.mIsStateful = false;
    this.mIsStatefulCalculated = false;
    this.mIsMutated = false;
    Preconditions.checkNotNull(paramArrayOfDrawable);
    this.mLayers = paramArrayOfDrawable;
    for (;;)
    {
      paramArrayOfDrawable = this.mLayers;
      if (i >= paramArrayOfDrawable.length) {
        break;
      }
      DrawableUtils.setCallbacks(paramArrayOfDrawable[i], this, this);
      i += 1;
    }
    this.mDrawableParents = new DrawableParent[paramArrayOfDrawable.length];
  }
  
  private DrawableParent createDrawableParentForIndex(final int paramInt)
  {
    new DrawableParent()
    {
      public Drawable getDrawable()
      {
        return ArrayDrawable.this.getDrawable(paramInt);
      }
      
      public Drawable setDrawable(Drawable paramAnonymousDrawable)
      {
        return ArrayDrawable.this.setDrawable(paramInt, paramAnonymousDrawable);
      }
    };
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = 0;
    for (;;)
    {
      Object localObject = this.mLayers;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      if (localObject != null) {
        ((Drawable)localObject).draw(paramCanvas);
      }
      i += 1;
    }
  }
  
  @Nullable
  public Drawable getDrawable(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramInt >= 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    if (paramInt < this.mLayers.length) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    return this.mLayers[paramInt];
  }
  
  public DrawableParent getDrawableParentForIndex(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramInt >= 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    if (paramInt < this.mDrawableParents.length) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    DrawableParent[] arrayOfDrawableParent = this.mDrawableParents;
    if (arrayOfDrawableParent[paramInt] == null) {
      arrayOfDrawableParent[paramInt] = createDrawableParentForIndex(paramInt);
    }
    return this.mDrawableParents[paramInt];
  }
  
  public int getIntrinsicHeight()
  {
    int m = -1;
    int j = 0;
    int k;
    for (int i = -1;; i = k)
    {
      Object localObject = this.mLayers;
      if (j >= localObject.length) {
        break;
      }
      localObject = localObject[j];
      k = i;
      if (localObject != null) {
        k = Math.max(i, ((Drawable)localObject).getIntrinsicHeight());
      }
      j += 1;
    }
    j = m;
    if (i > 0) {
      j = i;
    }
    return j;
  }
  
  public int getIntrinsicWidth()
  {
    int m = -1;
    int j = 0;
    int k;
    for (int i = -1;; i = k)
    {
      Object localObject = this.mLayers;
      if (j >= localObject.length) {
        break;
      }
      localObject = localObject[j];
      k = i;
      if (localObject != null) {
        k = Math.max(i, ((Drawable)localObject).getIntrinsicWidth());
      }
      j += 1;
    }
    j = m;
    if (i > 0) {
      j = i;
    }
    return j;
  }
  
  public int getNumberOfLayers()
  {
    return this.mLayers.length;
  }
  
  public int getOpacity()
  {
    if (this.mLayers.length == 0) {
      return -2;
    }
    int j = -1;
    int i = 1;
    for (;;)
    {
      Object localObject = this.mLayers;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      int k = j;
      if (localObject != null) {
        k = Drawable.resolveOpacity(j, ((Drawable)localObject).getOpacity());
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  public boolean getPadding(Rect paramRect)
  {
    int i = 0;
    paramRect.left = 0;
    paramRect.top = 0;
    paramRect.right = 0;
    paramRect.bottom = 0;
    Rect localRect = this.mTmpRect;
    for (;;)
    {
      Object localObject = this.mLayers;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      if (localObject != null)
      {
        ((Drawable)localObject).getPadding(localRect);
        paramRect.left = Math.max(paramRect.left, localRect.left);
        paramRect.top = Math.max(paramRect.top, localRect.top);
        paramRect.right = Math.max(paramRect.right, localRect.right);
        paramRect.bottom = Math.max(paramRect.bottom, localRect.bottom);
      }
      i += 1;
    }
    return true;
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
    TransformCallback localTransformCallback = this.mTransformCallback;
    if (localTransformCallback != null)
    {
      localTransformCallback.getTransform(paramMatrix);
      return;
    }
    paramMatrix.reset();
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidateSelf();
  }
  
  public boolean isStateful()
  {
    if (!this.mIsStatefulCalculated)
    {
      this.mIsStateful = false;
      int i = 0;
      for (;;)
      {
        Object localObject = this.mLayers;
        int j = localObject.length;
        boolean bool1 = true;
        if (i >= j) {
          break;
        }
        localObject = localObject[i];
        boolean bool2 = this.mIsStateful;
        if ((localObject == null) || (!((Drawable)localObject).isStateful())) {
          bool1 = false;
        }
        this.mIsStateful = (bool2 | bool1);
        i += 1;
      }
      this.mIsStatefulCalculated = true;
    }
    return this.mIsStateful;
  }
  
  public Drawable mutate()
  {
    int i = 0;
    for (;;)
    {
      Object localObject = this.mLayers;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      if (localObject != null) {
        ((Drawable)localObject).mutate();
      }
      i += 1;
    }
    this.mIsMutated = true;
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    int i = 0;
    for (;;)
    {
      Object localObject = this.mLayers;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      if (localObject != null) {
        ((Drawable)localObject).setBounds(paramRect);
      }
      i += 1;
    }
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false;; bool1 = bool2)
    {
      Object localObject = this.mLayers;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      bool2 = bool1;
      if (localObject != null)
      {
        bool2 = bool1;
        if (((Drawable)localObject).setLevel(paramInt)) {
          bool2 = true;
        }
      }
      i += 1;
    }
    return bool1;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false;; bool1 = bool2)
    {
      Object localObject = this.mLayers;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      bool2 = bool1;
      if (localObject != null)
      {
        bool2 = bool1;
        if (((Drawable)localObject).setState(paramArrayOfInt)) {
          bool2 = true;
        }
      }
      i += 1;
    }
    return bool1;
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    this.mDrawableProperties.setAlpha(paramInt);
    int i = 0;
    for (;;)
    {
      Object localObject = this.mLayers;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      if (localObject != null) {
        ((Drawable)localObject).setAlpha(paramInt);
      }
      i += 1;
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mDrawableProperties.setColorFilter(paramColorFilter);
    int i = 0;
    for (;;)
    {
      Object localObject = this.mLayers;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      if (localObject != null) {
        ((Drawable)localObject).setColorFilter(paramColorFilter);
      }
      i += 1;
    }
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mDrawableProperties.setDither(paramBoolean);
    int i = 0;
    for (;;)
    {
      Object localObject = this.mLayers;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      if (localObject != null) {
        ((Drawable)localObject).setDither(paramBoolean);
      }
      i += 1;
    }
  }
  
  @Nullable
  public Drawable setDrawable(int paramInt, @Nullable Drawable paramDrawable)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramInt >= 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    if (paramInt < this.mLayers.length) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    Drawable localDrawable = this.mLayers[paramInt];
    if (paramDrawable != localDrawable)
    {
      if ((paramDrawable != null) && (this.mIsMutated)) {
        paramDrawable.mutate();
      }
      DrawableUtils.setCallbacks(this.mLayers[paramInt], null, null);
      DrawableUtils.setCallbacks(paramDrawable, null, null);
      DrawableUtils.setDrawableProperties(paramDrawable, this.mDrawableProperties);
      DrawableUtils.copyProperties(paramDrawable, this);
      DrawableUtils.setCallbacks(paramDrawable, this, this);
      this.mIsStatefulCalculated = false;
      this.mLayers[paramInt] = paramDrawable;
      invalidateSelf();
    }
    return localDrawable;
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.mDrawableProperties.setFilterBitmap(paramBoolean);
    int i = 0;
    for (;;)
    {
      Object localObject = this.mLayers;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      if (localObject != null) {
        ((Drawable)localObject).setFilterBitmap(paramBoolean);
      }
      i += 1;
    }
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    int i = 0;
    for (;;)
    {
      Object localObject = this.mLayers;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      if (localObject != null) {
        ((Drawable)localObject).setHotspot(paramFloat1, paramFloat2);
      }
      i += 1;
    }
  }
  
  public void setTransformCallback(TransformCallback paramTransformCallback)
  {
    this.mTransformCallback = paramTransformCallback;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    int i = 0;
    for (;;)
    {
      Object localObject = this.mLayers;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      if (localObject != null) {
        ((Drawable)localObject).setVisible(paramBoolean1, paramBoolean2);
      }
      i += 1;
    }
    return bool;
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    unscheduleSelf(paramRunnable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\drawable\ArrayDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */