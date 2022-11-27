package com.google.android.material.internal;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import androidx.core.graphics.ColorUtils;

public class CircularBorderDrawable
  extends Drawable
{
  private static final float DRAW_STROKE_WIDTH_MULTIPLE = 1.3333F;
  private ColorStateList borderTint;
  float borderWidth;
  private int bottomInnerStrokeColor;
  private int bottomOuterStrokeColor;
  private int currentBorderTintColor;
  private boolean invalidateShader = true;
  final Paint paint;
  final Rect rect = new Rect();
  final RectF rectF = new RectF();
  private float rotation;
  final CircularBorderState state = new CircularBorderState(null);
  private int topInnerStrokeColor;
  private int topOuterStrokeColor;
  
  public CircularBorderDrawable()
  {
    Paint localPaint = new Paint(1);
    this.paint = localPaint;
    localPaint.setStyle(Paint.Style.STROKE);
  }
  
  private Shader createGradientShader()
  {
    Object localObject = this.rect;
    copyBounds((Rect)localObject);
    float f1 = this.borderWidth / ((Rect)localObject).height();
    int i = ColorUtils.compositeColors(this.topOuterStrokeColor, this.currentBorderTintColor);
    int j = ColorUtils.compositeColors(this.topInnerStrokeColor, this.currentBorderTintColor);
    int k = ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.topInnerStrokeColor, 0), this.currentBorderTintColor);
    int m = ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.bottomInnerStrokeColor, 0), this.currentBorderTintColor);
    int n = ColorUtils.compositeColors(this.bottomInnerStrokeColor, this.currentBorderTintColor);
    int i1 = ColorUtils.compositeColors(this.bottomOuterStrokeColor, this.currentBorderTintColor);
    float f2 = ((Rect)localObject).top;
    float f3 = ((Rect)localObject).bottom;
    localObject = Shader.TileMode.CLAMP;
    return new LinearGradient(0.0F, f2, 0.0F, f3, new int[] { i, j, k, m, n, i1 }, new float[] { 0.0F, f1, 0.5F, 0.5F, 1.0F - f1, 1.0F }, (Shader.TileMode)localObject);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.invalidateShader)
    {
      this.paint.setShader(createGradientShader());
      this.invalidateShader = false;
    }
    float f = this.paint.getStrokeWidth() / 2.0F;
    RectF localRectF = this.rectF;
    copyBounds(this.rect);
    localRectF.set(this.rect);
    localRectF.left += f;
    localRectF.top += f;
    localRectF.right -= f;
    localRectF.bottom -= f;
    paramCanvas.save();
    paramCanvas.rotate(this.rotation, localRectF.centerX(), localRectF.centerY());
    paramCanvas.drawOval(localRectF, this.paint);
    paramCanvas.restore();
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.state;
  }
  
  public int getOpacity()
  {
    if (this.borderWidth > 0.0F) {
      return -3;
    }
    return -2;
  }
  
  public boolean getPadding(Rect paramRect)
  {
    int i = Math.round(this.borderWidth);
    paramRect.set(i, i, i, i);
    return true;
  }
  
  public boolean isStateful()
  {
    ColorStateList localColorStateList = this.borderTint;
    return ((localColorStateList != null) && (localColorStateList.isStateful())) || (super.isStateful());
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.invalidateShader = true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    ColorStateList localColorStateList = this.borderTint;
    if (localColorStateList != null)
    {
      int i = localColorStateList.getColorForState(paramArrayOfInt, this.currentBorderTintColor);
      if (i != this.currentBorderTintColor)
      {
        this.invalidateShader = true;
        this.currentBorderTintColor = i;
      }
    }
    if (this.invalidateShader) {
      invalidateSelf();
    }
    return this.invalidateShader;
  }
  
  public void setAlpha(int paramInt)
  {
    this.paint.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setBorderTint(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null) {
      this.currentBorderTintColor = paramColorStateList.getColorForState(getState(), this.currentBorderTintColor);
    }
    this.borderTint = paramColorStateList;
    this.invalidateShader = true;
    invalidateSelf();
  }
  
  public void setBorderWidth(float paramFloat)
  {
    if (this.borderWidth != paramFloat)
    {
      this.borderWidth = paramFloat;
      this.paint.setStrokeWidth(paramFloat * 1.3333F);
      this.invalidateShader = true;
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.paint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setGradientColors(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.topOuterStrokeColor = paramInt1;
    this.topInnerStrokeColor = paramInt2;
    this.bottomOuterStrokeColor = paramInt3;
    this.bottomInnerStrokeColor = paramInt4;
  }
  
  public final void setRotation(float paramFloat)
  {
    if (paramFloat != this.rotation)
    {
      this.rotation = paramFloat;
      invalidateSelf();
    }
  }
  
  private class CircularBorderState
    extends Drawable.ConstantState
  {
    private CircularBorderState() {}
    
    public int getChangingConfigurations()
    {
      return 0;
    }
    
    public Drawable newDrawable()
    {
      return CircularBorderDrawable.this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\material\internal\CircularBorderDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */