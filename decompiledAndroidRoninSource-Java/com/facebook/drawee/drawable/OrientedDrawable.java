package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class OrientedDrawable
  extends ForwardingDrawable
{
  private int mExifOrientation;
  private int mRotationAngle;
  final Matrix mRotationMatrix = new Matrix();
  private final Matrix mTempMatrix = new Matrix();
  private final RectF mTempRectF = new RectF();
  
  public OrientedDrawable(Drawable paramDrawable, int paramInt)
  {
    this(paramDrawable, paramInt, 0);
  }
  
  public OrientedDrawable(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    super(paramDrawable);
    this.mRotationAngle = (paramInt1 - paramInt1 % 90);
    if ((paramInt2 < 0) || (paramInt2 > 8)) {
      paramInt2 = 0;
    }
    this.mExifOrientation = paramInt2;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mRotationAngle <= 0)
    {
      i = this.mExifOrientation;
      if ((i == 0) || (i == 1))
      {
        super.draw(paramCanvas);
        return;
      }
    }
    int i = paramCanvas.save();
    paramCanvas.concat(this.mRotationMatrix);
    super.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
  
  public int getIntrinsicHeight()
  {
    int i = this.mExifOrientation;
    if ((i != 5) && (i != 7) && (this.mRotationAngle % 180 == 0)) {
      return super.getIntrinsicHeight();
    }
    return super.getIntrinsicWidth();
  }
  
  public int getIntrinsicWidth()
  {
    int i = this.mExifOrientation;
    if ((i != 5) && (i != 7) && (this.mRotationAngle % 180 == 0)) {
      return super.getIntrinsicWidth();
    }
    return super.getIntrinsicHeight();
  }
  
  public void getTransform(Matrix paramMatrix)
  {
    getParentTransform(paramMatrix);
    if (!this.mRotationMatrix.isIdentity()) {
      paramMatrix.preConcat(this.mRotationMatrix);
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    Drawable localDrawable = getCurrent();
    if (this.mRotationAngle <= 0)
    {
      i = this.mExifOrientation;
      if ((i == 0) || (i == 1))
      {
        localDrawable.setBounds(paramRect);
        return;
      }
    }
    int i = this.mExifOrientation;
    if (i != 2)
    {
      if (i != 7)
      {
        if (i != 4)
        {
          if (i != 5)
          {
            this.mRotationMatrix.setRotate(this.mRotationAngle, paramRect.centerX(), paramRect.centerY());
          }
          else
          {
            this.mRotationMatrix.setRotate(270.0F, paramRect.centerX(), paramRect.centerY());
            this.mRotationMatrix.postScale(1.0F, -1.0F);
          }
        }
        else {
          this.mRotationMatrix.setScale(1.0F, -1.0F);
        }
      }
      else
      {
        this.mRotationMatrix.setRotate(270.0F, paramRect.centerX(), paramRect.centerY());
        this.mRotationMatrix.postScale(-1.0F, 1.0F);
      }
    }
    else {
      this.mRotationMatrix.setScale(-1.0F, 1.0F);
    }
    this.mTempMatrix.reset();
    this.mRotationMatrix.invert(this.mTempMatrix);
    this.mTempRectF.set(paramRect);
    this.mTempMatrix.mapRect(this.mTempRectF);
    localDrawable.setBounds((int)this.mTempRectF.left, (int)this.mTempRectF.top, (int)this.mTempRectF.right, (int)this.mTempRectF.bottom);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\drawable\OrientedDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */