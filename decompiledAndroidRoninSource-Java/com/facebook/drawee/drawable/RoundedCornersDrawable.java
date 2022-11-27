package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import java.util.Arrays;
import javax.annotation.Nullable;

public class RoundedCornersDrawable
  extends ForwardingDrawable
  implements Rounded
{
  private int mBorderColor = 0;
  private final Path mBorderPath = new Path();
  final float[] mBorderRadii = new float[8];
  private float mBorderWidth = 0.0F;
  private final RectF mBounds = new RectF();
  @Nullable
  private RectF mInsideBorderBounds;
  @Nullable
  private Matrix mInsideBorderTransform;
  private boolean mIsCircle = false;
  private int mOverlayColor = 0;
  private float mPadding = 0.0F;
  final Paint mPaint = new Paint(1);
  private boolean mPaintFilterBitmap = false;
  private final Path mPath = new Path();
  private final float[] mRadii = new float[8];
  private boolean mScaleDownInsideBorders = false;
  private final RectF mTempRectangle = new RectF();
  Type mType = Type.OVERLAY_COLOR;
  
  public RoundedCornersDrawable(Drawable paramDrawable)
  {
    super((Drawable)Preconditions.checkNotNull(paramDrawable));
  }
  
  private void updatePath()
  {
    this.mPath.reset();
    this.mBorderPath.reset();
    this.mTempRectangle.set(getBounds());
    Object localObject = this.mTempRectangle;
    float f = this.mPadding;
    ((RectF)localObject).inset(f, f);
    if (this.mType == Type.OVERLAY_COLOR) {
      this.mPath.addRect(this.mTempRectangle, Path.Direction.CW);
    }
    if (this.mIsCircle) {
      this.mPath.addCircle(this.mTempRectangle.centerX(), this.mTempRectangle.centerY(), Math.min(this.mTempRectangle.width(), this.mTempRectangle.height()) / 2.0F, Path.Direction.CW);
    } else {
      this.mPath.addRoundRect(this.mTempRectangle, this.mRadii, Path.Direction.CW);
    }
    localObject = this.mTempRectangle;
    f = this.mPadding;
    ((RectF)localObject).inset(-f, -f);
    localObject = this.mTempRectangle;
    f = this.mBorderWidth;
    ((RectF)localObject).inset(f / 2.0F, f / 2.0F);
    if (this.mIsCircle)
    {
      f = Math.min(this.mTempRectangle.width(), this.mTempRectangle.height()) / 2.0F;
      this.mBorderPath.addCircle(this.mTempRectangle.centerX(), this.mTempRectangle.centerY(), f, Path.Direction.CW);
    }
    else
    {
      int i = 0;
      for (;;)
      {
        localObject = this.mBorderRadii;
        if (i >= localObject.length) {
          break;
        }
        localObject[i] = (this.mRadii[i] + this.mPadding - this.mBorderWidth / 2.0F);
        i += 1;
      }
      this.mBorderPath.addRoundRect(this.mTempRectangle, (float[])localObject, Path.Direction.CW);
    }
    localObject = this.mTempRectangle;
    f = this.mBorderWidth;
    ((RectF)localObject).inset(-f / 2.0F, -f / 2.0F);
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.mBounds.set(getBounds());
    int i = 1.$SwitchMap$com$facebook$drawee$drawable$RoundedCornersDrawable$Type[this.mType.ordinal()];
    if (i != 1)
    {
      if (i == 2)
      {
        float f1;
        if (this.mScaleDownInsideBorders)
        {
          RectF localRectF = this.mInsideBorderBounds;
          if (localRectF == null)
          {
            this.mInsideBorderBounds = new RectF(this.mBounds);
            this.mInsideBorderTransform = new Matrix();
          }
          else
          {
            localRectF.set(this.mBounds);
          }
          localRectF = this.mInsideBorderBounds;
          f1 = this.mBorderWidth;
          localRectF.inset(f1, f1);
          this.mInsideBorderTransform.setRectToRect(this.mBounds, this.mInsideBorderBounds, Matrix.ScaleToFit.FILL);
          i = paramCanvas.save();
          paramCanvas.clipRect(this.mBounds);
          paramCanvas.concat(this.mInsideBorderTransform);
          super.draw(paramCanvas);
          paramCanvas.restoreToCount(i);
        }
        else
        {
          super.draw(paramCanvas);
        }
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.mOverlayColor);
        this.mPaint.setStrokeWidth(0.0F);
        this.mPaint.setFilterBitmap(getPaintFilterBitmap());
        this.mPath.setFillType(Path.FillType.EVEN_ODD);
        paramCanvas.drawPath(this.mPath, this.mPaint);
        if (this.mIsCircle)
        {
          f1 = (this.mBounds.width() - this.mBounds.height() + this.mBorderWidth) / 2.0F;
          float f2 = (this.mBounds.height() - this.mBounds.width() + this.mBorderWidth) / 2.0F;
          if (f1 > 0.0F)
          {
            paramCanvas.drawRect(this.mBounds.left, this.mBounds.top, this.mBounds.left + f1, this.mBounds.bottom, this.mPaint);
            paramCanvas.drawRect(this.mBounds.right - f1, this.mBounds.top, this.mBounds.right, this.mBounds.bottom, this.mPaint);
          }
          if (f2 > 0.0F)
          {
            paramCanvas.drawRect(this.mBounds.left, this.mBounds.top, this.mBounds.right, this.mBounds.top + f2, this.mPaint);
            paramCanvas.drawRect(this.mBounds.left, this.mBounds.bottom - f2, this.mBounds.right, this.mBounds.bottom, this.mPaint);
          }
        }
      }
    }
    else
    {
      i = paramCanvas.save();
      paramCanvas.clipPath(this.mPath);
      super.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
    }
    if (this.mBorderColor != 0)
    {
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.mPaint.setColor(this.mBorderColor);
      this.mPaint.setStrokeWidth(this.mBorderWidth);
      this.mPath.setFillType(Path.FillType.EVEN_ODD);
      paramCanvas.drawPath(this.mBorderPath, this.mPaint);
    }
  }
  
  public int getBorderColor()
  {
    return this.mBorderColor;
  }
  
  public float getBorderWidth()
  {
    return this.mBorderWidth;
  }
  
  public int getOverlayColor()
  {
    return this.mOverlayColor;
  }
  
  public float getPadding()
  {
    return this.mPadding;
  }
  
  public boolean getPaintFilterBitmap()
  {
    return this.mPaintFilterBitmap;
  }
  
  public float[] getRadii()
  {
    return this.mRadii;
  }
  
  public boolean getScaleDownInsideBorders()
  {
    return this.mScaleDownInsideBorders;
  }
  
  public boolean isCircle()
  {
    return this.mIsCircle;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    updatePath();
  }
  
  public void setBorder(int paramInt, float paramFloat)
  {
    this.mBorderColor = paramInt;
    this.mBorderWidth = paramFloat;
    updatePath();
    invalidateSelf();
  }
  
  public void setCircle(boolean paramBoolean)
  {
    this.mIsCircle = paramBoolean;
    updatePath();
    invalidateSelf();
  }
  
  public void setOverlayColor(int paramInt)
  {
    this.mOverlayColor = paramInt;
    invalidateSelf();
  }
  
  public void setPadding(float paramFloat)
  {
    this.mPadding = paramFloat;
    updatePath();
    invalidateSelf();
  }
  
  public void setPaintFilterBitmap(boolean paramBoolean)
  {
    if (this.mPaintFilterBitmap != paramBoolean)
    {
      this.mPaintFilterBitmap = paramBoolean;
      invalidateSelf();
    }
  }
  
  public void setRadii(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null)
    {
      Arrays.fill(this.mRadii, 0.0F);
    }
    else
    {
      boolean bool;
      if (paramArrayOfFloat.length == 8) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "radii should have exactly 8 values");
      System.arraycopy(paramArrayOfFloat, 0, this.mRadii, 0, 8);
    }
    updatePath();
    invalidateSelf();
  }
  
  public void setRadius(float paramFloat)
  {
    Arrays.fill(this.mRadii, paramFloat);
    updatePath();
    invalidateSelf();
  }
  
  public void setScaleDownInsideBorders(boolean paramBoolean)
  {
    this.mScaleDownInsideBorders = paramBoolean;
    updatePath();
    invalidateSelf();
  }
  
  public void setType(Type paramType)
  {
    this.mType = paramType;
    updatePath();
    invalidateSelf();
  }
  
  public static enum Type
  {
    static
    {
      Type localType = new Type("CLIPPING", 1);
      CLIPPING = localType;
      $VALUES = new Type[] { OVERLAY_COLOR, localType };
    }
    
    private Type() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\drawable\RoundedCornersDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */