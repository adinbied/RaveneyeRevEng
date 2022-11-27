package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import javax.annotation.Nullable;

public class ScalingUtils
{
  @Nullable
  public static ScaleTypeDrawable getActiveScaleTypeDrawable(@Nullable Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    if ((paramDrawable instanceof ScaleTypeDrawable)) {
      return (ScaleTypeDrawable)paramDrawable;
    }
    if ((paramDrawable instanceof DrawableParent)) {
      return getActiveScaleTypeDrawable(((DrawableParent)paramDrawable).getDrawable());
    }
    if ((paramDrawable instanceof ArrayDrawable))
    {
      paramDrawable = (ArrayDrawable)paramDrawable;
      int j = paramDrawable.getNumberOfLayers();
      int i = 0;
      while (i < j)
      {
        ScaleTypeDrawable localScaleTypeDrawable = getActiveScaleTypeDrawable(paramDrawable.getDrawable(i));
        if (localScaleTypeDrawable != null) {
          return localScaleTypeDrawable;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public static abstract class AbstractScaleType
    implements ScalingUtils.ScaleType
  {
    public Matrix getTransform(Matrix paramMatrix, Rect paramRect, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
    {
      getTransformImpl(paramMatrix, paramRect, paramInt1, paramInt2, paramFloat1, paramFloat2, paramRect.width() / paramInt1, paramRect.height() / paramInt2);
      return paramMatrix;
    }
    
    public abstract void getTransformImpl(Matrix paramMatrix, Rect paramRect, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  }
  
  public static class InterpolatingScaleType
    implements ScalingUtils.ScaleType, ScalingUtils.StatefulScaleType
  {
    @Nullable
    private final Rect mBoundsFrom;
    @Nullable
    private final Rect mBoundsTo;
    @Nullable
    private final PointF mFocusPointFrom;
    @Nullable
    private final PointF mFocusPointTo;
    private float mInterpolatingValue;
    private final float[] mMatrixValuesFrom = new float[9];
    private final float[] mMatrixValuesInterpolated = new float[9];
    private final float[] mMatrixValuesTo = new float[9];
    private final ScalingUtils.ScaleType mScaleTypeFrom;
    private final ScalingUtils.ScaleType mScaleTypeTo;
    
    public InterpolatingScaleType(ScalingUtils.ScaleType paramScaleType1, ScalingUtils.ScaleType paramScaleType2)
    {
      this(paramScaleType1, paramScaleType2, null, null);
    }
    
    public InterpolatingScaleType(ScalingUtils.ScaleType paramScaleType1, ScalingUtils.ScaleType paramScaleType2, @Nullable Rect paramRect1, @Nullable Rect paramRect2)
    {
      this(paramScaleType1, paramScaleType2, paramRect1, paramRect2, null, null);
    }
    
    public InterpolatingScaleType(ScalingUtils.ScaleType paramScaleType1, ScalingUtils.ScaleType paramScaleType2, @Nullable Rect paramRect1, @Nullable Rect paramRect2, @Nullable PointF paramPointF1, @Nullable PointF paramPointF2)
    {
      this.mScaleTypeFrom = paramScaleType1;
      this.mScaleTypeTo = paramScaleType2;
      this.mBoundsFrom = paramRect1;
      this.mBoundsTo = paramRect2;
      this.mFocusPointFrom = paramPointF1;
      this.mFocusPointTo = paramPointF2;
    }
    
    @Nullable
    public Rect getBoundsFrom()
    {
      return this.mBoundsFrom;
    }
    
    @Nullable
    public Rect getBoundsTo()
    {
      return this.mBoundsTo;
    }
    
    @Nullable
    public PointF getFocusPointFrom()
    {
      return this.mFocusPointFrom;
    }
    
    @Nullable
    public PointF getFocusPointTo()
    {
      return this.mFocusPointTo;
    }
    
    public ScalingUtils.ScaleType getScaleTypeFrom()
    {
      return this.mScaleTypeFrom;
    }
    
    public ScalingUtils.ScaleType getScaleTypeTo()
    {
      return this.mScaleTypeTo;
    }
    
    public Object getState()
    {
      return Float.valueOf(this.mInterpolatingValue);
    }
    
    public Matrix getTransform(Matrix paramMatrix, Rect paramRect, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
    {
      Object localObject1 = this.mBoundsFrom;
      if (localObject1 == null) {
        localObject1 = paramRect;
      }
      Object localObject2 = this.mBoundsTo;
      if (localObject2 != null) {
        paramRect = (Rect)localObject2;
      }
      localObject2 = this.mScaleTypeFrom;
      PointF localPointF = this.mFocusPointFrom;
      float f1;
      if (localPointF == null) {
        f1 = paramFloat1;
      } else {
        f1 = localPointF.x;
      }
      localPointF = this.mFocusPointFrom;
      float f2;
      if (localPointF == null) {
        f2 = paramFloat2;
      } else {
        f2 = localPointF.y;
      }
      ((ScalingUtils.ScaleType)localObject2).getTransform(paramMatrix, (Rect)localObject1, paramInt1, paramInt2, f1, f2);
      paramMatrix.getValues(this.mMatrixValuesFrom);
      localObject1 = this.mScaleTypeTo;
      localObject2 = this.mFocusPointTo;
      if (localObject2 != null) {
        paramFloat1 = ((PointF)localObject2).x;
      }
      localObject2 = this.mFocusPointTo;
      if (localObject2 != null) {
        paramFloat2 = ((PointF)localObject2).y;
      }
      ((ScalingUtils.ScaleType)localObject1).getTransform(paramMatrix, paramRect, paramInt1, paramInt2, paramFloat1, paramFloat2);
      paramMatrix.getValues(this.mMatrixValuesTo);
      paramInt1 = 0;
      while (paramInt1 < 9)
      {
        paramRect = this.mMatrixValuesInterpolated;
        paramFloat1 = this.mMatrixValuesFrom[paramInt1];
        paramFloat2 = this.mInterpolatingValue;
        paramRect[paramInt1] = (paramFloat1 * (1.0F - paramFloat2) + this.mMatrixValuesTo[paramInt1] * paramFloat2);
        paramInt1 += 1;
      }
      paramMatrix.setValues(this.mMatrixValuesInterpolated);
      return paramMatrix;
    }
    
    public float getValue()
    {
      return this.mInterpolatingValue;
    }
    
    public void setValue(float paramFloat)
    {
      this.mInterpolatingValue = paramFloat;
    }
    
    public String toString()
    {
      return String.format("InterpolatingScaleType(%s (%s) -> %s (%s))", new Object[] { String.valueOf(this.mScaleTypeFrom), String.valueOf(this.mFocusPointFrom), String.valueOf(this.mScaleTypeTo), String.valueOf(this.mFocusPointTo) });
    }
  }
  
  public static abstract interface ScaleType
  {
    public static final ScaleType CENTER;
    public static final ScaleType CENTER_CROP;
    public static final ScaleType CENTER_INSIDE;
    public static final ScaleType FIT_BOTTOM_START = ScalingUtils.ScaleTypeFitBottomStart.INSTANCE;
    public static final ScaleType FIT_CENTER;
    public static final ScaleType FIT_END;
    public static final ScaleType FIT_START;
    public static final ScaleType FIT_X;
    public static final ScaleType FIT_XY = ScalingUtils.ScaleTypeFitXY.INSTANCE;
    public static final ScaleType FIT_Y;
    public static final ScaleType FOCUS_CROP;
    
    static
    {
      FIT_X = ScalingUtils.ScaleTypeFitX.INSTANCE;
      FIT_Y = ScalingUtils.ScaleTypeFitY.INSTANCE;
      FIT_START = ScalingUtils.ScaleTypeFitStart.INSTANCE;
      FIT_CENTER = ScalingUtils.ScaleTypeFitCenter.INSTANCE;
      FIT_END = ScalingUtils.ScaleTypeFitEnd.INSTANCE;
      CENTER = ScalingUtils.ScaleTypeCenter.INSTANCE;
      CENTER_INSIDE = ScalingUtils.ScaleTypeCenterInside.INSTANCE;
      CENTER_CROP = ScalingUtils.ScaleTypeCenterCrop.INSTANCE;
      FOCUS_CROP = ScalingUtils.ScaleTypeFocusCrop.INSTANCE;
    }
    
    public abstract Matrix getTransform(Matrix paramMatrix, Rect paramRect, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2);
  }
  
  private static class ScaleTypeCenter
    extends ScalingUtils.AbstractScaleType
  {
    public static final ScalingUtils.ScaleType INSTANCE = new ScaleTypeCenter();
    
    public void getTransformImpl(Matrix paramMatrix, Rect paramRect, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      paramFloat1 = paramRect.left;
      paramFloat2 = paramRect.width() - paramInt1;
      paramFloat3 = paramRect.top;
      paramFloat4 = paramRect.height() - paramInt2;
      paramMatrix.setTranslate((int)(paramFloat1 + paramFloat2 * 0.5F + 0.5F), (int)(paramFloat3 + paramFloat4 * 0.5F + 0.5F));
    }
    
    public String toString()
    {
      return "center";
    }
  }
  
  private static class ScaleTypeCenterCrop
    extends ScalingUtils.AbstractScaleType
  {
    public static final ScalingUtils.ScaleType INSTANCE = new ScaleTypeCenterCrop();
    
    public void getTransformImpl(Matrix paramMatrix, Rect paramRect, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      if (paramFloat4 > paramFloat3)
      {
        paramFloat2 = paramRect.left + (paramRect.width() - paramInt1 * paramFloat4) * 0.5F;
        paramFloat1 = paramRect.top;
        paramFloat3 = paramFloat4;
      }
      else
      {
        paramFloat2 = paramRect.left;
        paramFloat1 = paramRect.top;
        paramFloat1 = (paramRect.height() - paramInt2 * paramFloat3) * 0.5F + paramFloat1;
      }
      paramMatrix.setScale(paramFloat3, paramFloat3);
      paramMatrix.postTranslate((int)(paramFloat2 + 0.5F), (int)(paramFloat1 + 0.5F));
    }
    
    public String toString()
    {
      return "center_crop";
    }
  }
  
  private static class ScaleTypeCenterInside
    extends ScalingUtils.AbstractScaleType
  {
    public static final ScalingUtils.ScaleType INSTANCE = new ScaleTypeCenterInside();
    
    public void getTransformImpl(Matrix paramMatrix, Rect paramRect, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      paramFloat1 = Math.min(Math.min(paramFloat3, paramFloat4), 1.0F);
      paramFloat2 = paramRect.left;
      paramFloat3 = paramRect.width();
      paramFloat4 = paramInt1;
      float f1 = paramRect.top;
      float f2 = paramRect.height();
      float f3 = paramInt2;
      paramMatrix.setScale(paramFloat1, paramFloat1);
      paramMatrix.postTranslate((int)(paramFloat2 + (paramFloat3 - paramFloat4 * paramFloat1) * 0.5F + 0.5F), (int)(f1 + (f2 - f3 * paramFloat1) * 0.5F + 0.5F));
    }
    
    public String toString()
    {
      return "center_inside";
    }
  }
  
  private static class ScaleTypeFitBottomStart
    extends ScalingUtils.AbstractScaleType
  {
    public static final ScalingUtils.ScaleType INSTANCE = new ScaleTypeFitBottomStart();
    
    public void getTransformImpl(Matrix paramMatrix, Rect paramRect, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      paramFloat1 = Math.min(paramFloat3, paramFloat4);
      paramFloat2 = paramRect.left;
      paramFloat3 = paramRect.top;
      paramFloat4 = paramRect.height();
      float f = paramInt2;
      paramMatrix.setScale(paramFloat1, paramFloat1);
      paramMatrix.postTranslate((int)(paramFloat2 + 0.5F), (int)(paramFloat3 + (paramFloat4 - f * paramFloat1) + 0.5F));
    }
    
    public String toString()
    {
      return "fit_bottom_start";
    }
  }
  
  private static class ScaleTypeFitCenter
    extends ScalingUtils.AbstractScaleType
  {
    public static final ScalingUtils.ScaleType INSTANCE = new ScaleTypeFitCenter();
    
    public void getTransformImpl(Matrix paramMatrix, Rect paramRect, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      paramFloat1 = Math.min(paramFloat3, paramFloat4);
      paramFloat2 = paramRect.left;
      paramFloat3 = paramRect.width();
      paramFloat4 = paramInt1;
      float f1 = paramRect.top;
      float f2 = paramRect.height();
      float f3 = paramInt2;
      paramMatrix.setScale(paramFloat1, paramFloat1);
      paramMatrix.postTranslate((int)(paramFloat2 + (paramFloat3 - paramFloat4 * paramFloat1) * 0.5F + 0.5F), (int)(f1 + (f2 - f3 * paramFloat1) * 0.5F + 0.5F));
    }
    
    public String toString()
    {
      return "fit_center";
    }
  }
  
  private static class ScaleTypeFitEnd
    extends ScalingUtils.AbstractScaleType
  {
    public static final ScalingUtils.ScaleType INSTANCE = new ScaleTypeFitEnd();
    
    public void getTransformImpl(Matrix paramMatrix, Rect paramRect, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      paramFloat1 = Math.min(paramFloat3, paramFloat4);
      paramFloat2 = paramRect.left;
      paramFloat3 = paramRect.width();
      paramFloat4 = paramInt1;
      float f1 = paramRect.top;
      float f2 = paramRect.height();
      float f3 = paramInt2;
      paramMatrix.setScale(paramFloat1, paramFloat1);
      paramMatrix.postTranslate((int)(paramFloat2 + (paramFloat3 - paramFloat4 * paramFloat1) + 0.5F), (int)(f1 + (f2 - f3 * paramFloat1) + 0.5F));
    }
    
    public String toString()
    {
      return "fit_end";
    }
  }
  
  private static class ScaleTypeFitStart
    extends ScalingUtils.AbstractScaleType
  {
    public static final ScalingUtils.ScaleType INSTANCE = new ScaleTypeFitStart();
    
    public void getTransformImpl(Matrix paramMatrix, Rect paramRect, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      paramFloat1 = Math.min(paramFloat3, paramFloat4);
      paramFloat2 = paramRect.left;
      paramFloat3 = paramRect.top;
      paramMatrix.setScale(paramFloat1, paramFloat1);
      paramMatrix.postTranslate((int)(paramFloat2 + 0.5F), (int)(paramFloat3 + 0.5F));
    }
    
    public String toString()
    {
      return "fit_start";
    }
  }
  
  private static class ScaleTypeFitX
    extends ScalingUtils.AbstractScaleType
  {
    public static final ScalingUtils.ScaleType INSTANCE = new ScaleTypeFitX();
    
    public void getTransformImpl(Matrix paramMatrix, Rect paramRect, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      paramFloat1 = paramRect.left;
      paramFloat2 = paramRect.top;
      paramFloat4 = paramRect.height();
      float f = paramInt2;
      paramMatrix.setScale(paramFloat3, paramFloat3);
      paramMatrix.postTranslate((int)(paramFloat1 + 0.5F), (int)(paramFloat2 + (paramFloat4 - f * paramFloat3) * 0.5F + 0.5F));
    }
    
    public String toString()
    {
      return "fit_x";
    }
  }
  
  private static class ScaleTypeFitXY
    extends ScalingUtils.AbstractScaleType
  {
    public static final ScalingUtils.ScaleType INSTANCE = new ScaleTypeFitXY();
    
    public void getTransformImpl(Matrix paramMatrix, Rect paramRect, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      paramFloat1 = paramRect.left;
      paramFloat2 = paramRect.top;
      paramMatrix.setScale(paramFloat3, paramFloat4);
      paramMatrix.postTranslate((int)(paramFloat1 + 0.5F), (int)(paramFloat2 + 0.5F));
    }
    
    public String toString()
    {
      return "fit_xy";
    }
  }
  
  private static class ScaleTypeFitY
    extends ScalingUtils.AbstractScaleType
  {
    public static final ScalingUtils.ScaleType INSTANCE = new ScaleTypeFitY();
    
    public void getTransformImpl(Matrix paramMatrix, Rect paramRect, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      paramFloat1 = paramRect.left;
      paramFloat2 = paramRect.width();
      paramFloat3 = paramInt1;
      float f = paramRect.top;
      paramMatrix.setScale(paramFloat4, paramFloat4);
      paramMatrix.postTranslate((int)(paramFloat1 + (paramFloat2 - paramFloat3 * paramFloat4) * 0.5F + 0.5F), (int)(f + 0.5F));
    }
    
    public String toString()
    {
      return "fit_y";
    }
  }
  
  private static class ScaleTypeFocusCrop
    extends ScalingUtils.AbstractScaleType
  {
    public static final ScalingUtils.ScaleType INSTANCE = new ScaleTypeFocusCrop();
    
    public void getTransformImpl(Matrix paramMatrix, Rect paramRect, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      if (paramFloat4 > paramFloat3)
      {
        paramFloat2 = paramRect.width();
        paramFloat3 = paramInt1 * paramFloat4;
        paramFloat2 = paramRect.left + Math.max(Math.min(paramFloat2 * 0.5F - paramFloat1 * paramFloat3, 0.0F), paramRect.width() - paramFloat3);
        paramFloat1 = paramRect.top;
        paramFloat3 = paramFloat4;
      }
      else
      {
        paramFloat1 = paramRect.left;
        paramFloat4 = paramRect.height();
        float f1 = paramInt2 * paramFloat3;
        float f2 = paramRect.top;
        paramFloat4 = Math.max(Math.min(paramFloat4 * 0.5F - paramFloat2 * f1, 0.0F), paramRect.height() - f1) + f2;
        paramFloat2 = paramFloat1;
        paramFloat1 = paramFloat4;
      }
      paramMatrix.setScale(paramFloat3, paramFloat3);
      paramMatrix.postTranslate((int)(paramFloat2 + 0.5F), (int)(paramFloat1 + 0.5F));
    }
    
    public String toString()
    {
      return "focus_crop";
    }
  }
  
  public static abstract interface StatefulScaleType
  {
    public abstract Object getState();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\drawable\ScalingUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */