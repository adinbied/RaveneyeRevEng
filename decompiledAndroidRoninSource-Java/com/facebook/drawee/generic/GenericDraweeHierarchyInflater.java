package com.facebook.drawee.generic;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.facebook.drawee.R.styleable;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.Nullable;

public class GenericDraweeHierarchyInflater
{
  @Nullable
  private static Drawable getDrawable(Context paramContext, TypedArray paramTypedArray, int paramInt)
  {
    paramInt = paramTypedArray.getResourceId(paramInt, 0);
    if (paramInt == 0) {
      return null;
    }
    return paramContext.getResources().getDrawable(paramInt);
  }
  
  private static RoundingParams getRoundingParams(GenericDraweeHierarchyBuilder paramGenericDraweeHierarchyBuilder)
  {
    if (paramGenericDraweeHierarchyBuilder.getRoundingParams() == null) {
      paramGenericDraweeHierarchyBuilder.setRoundingParams(new RoundingParams());
    }
    return paramGenericDraweeHierarchyBuilder.getRoundingParams();
  }
  
  @Nullable
  private static ScalingUtils.ScaleType getScaleTypeFromXml(TypedArray paramTypedArray, int paramInt)
  {
    switch (paramTypedArray.getInt(paramInt, -2))
    {
    default: 
      throw new RuntimeException("XML attribute not specified!");
    case 8: 
      return ScalingUtils.ScaleType.FIT_BOTTOM_START;
    case 7: 
      return ScalingUtils.ScaleType.FOCUS_CROP;
    case 6: 
      return ScalingUtils.ScaleType.CENTER_CROP;
    case 5: 
      return ScalingUtils.ScaleType.CENTER_INSIDE;
    case 4: 
      return ScalingUtils.ScaleType.CENTER;
    case 3: 
      return ScalingUtils.ScaleType.FIT_END;
    case 2: 
      return ScalingUtils.ScaleType.FIT_CENTER;
    case 1: 
      return ScalingUtils.ScaleType.FIT_START;
    case 0: 
      return ScalingUtils.ScaleType.FIT_XY;
    }
    return null;
  }
  
  public static GenericDraweeHierarchyBuilder inflateBuilder(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.beginSection("GenericDraweeHierarchyBuilder#inflateBuilder");
    }
    paramContext = updateBuilder(new GenericDraweeHierarchyBuilder(paramContext.getResources()), paramContext, paramAttributeSet);
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.endSection();
    }
    return paramContext;
  }
  
  public static GenericDraweeHierarchy inflateHierarchy(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    return inflateBuilder(paramContext, paramAttributeSet).build();
  }
  
  public static GenericDraweeHierarchyBuilder updateBuilder(GenericDraweeHierarchyBuilder paramGenericDraweeHierarchyBuilder, Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray;
    if (paramAttributeSet != null) {
      localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.GenericDraweeHierarchy);
    }
    boolean bool8;
    int j;
    boolean bool7;
    boolean bool6;
    boolean bool5;
    boolean bool4;
    boolean bool3;
    boolean bool2;
    boolean bool1;
    int i;
    boolean bool9;
    boolean bool10;
    boolean bool11;
    boolean bool12;
    boolean bool13;
    boolean bool14;
    boolean bool15;
    boolean bool16;
    int m;
    try
    {
      int i1 = localTypedArray.getIndexCount();
      bool8 = true;
      j = 0;
      int n = 0;
      bool7 = true;
      bool6 = true;
      bool5 = true;
      bool4 = true;
      bool3 = true;
      bool2 = true;
      bool1 = true;
      i = 0;
      for (;;)
      {
        paramAttributeSet = paramContext;
        if (n < i1) {
          try
          {
            i2 = localTypedArray.getIndex(n);
            if (i2 == R.styleable.GenericDraweeHierarchy_actualImageScaleType)
            {
              paramGenericDraweeHierarchyBuilder.setActualImageScaleType(getScaleTypeFromXml(localTypedArray, i2));
              bool9 = bool8;
              k = j;
              bool10 = bool7;
              bool11 = bool6;
              bool12 = bool5;
              bool13 = bool4;
              bool14 = bool3;
              bool15 = bool2;
              bool16 = bool1;
              break label1962;
            }
            if (i2 == R.styleable.GenericDraweeHierarchy_placeholderImage)
            {
              paramGenericDraweeHierarchyBuilder.setPlaceholderImage(getDrawable(paramAttributeSet, localTypedArray, i2));
              bool9 = bool8;
              k = j;
              bool10 = bool7;
              bool11 = bool6;
              bool12 = bool5;
              bool13 = bool4;
              bool14 = bool3;
              bool15 = bool2;
              bool16 = bool1;
              break label1962;
            }
            if (i2 == R.styleable.GenericDraweeHierarchy_pressedStateOverlayImage)
            {
              paramGenericDraweeHierarchyBuilder.setPressedStateOverlay(getDrawable(paramAttributeSet, localTypedArray, i2));
              bool9 = bool8;
              k = j;
              bool10 = bool7;
              bool11 = bool6;
              bool12 = bool5;
              bool13 = bool4;
              bool14 = bool3;
              bool15 = bool2;
              bool16 = bool1;
              break label1962;
            }
            if (i2 == R.styleable.GenericDraweeHierarchy_progressBarImage)
            {
              paramGenericDraweeHierarchyBuilder.setProgressBarImage(getDrawable(paramAttributeSet, localTypedArray, i2));
              bool9 = bool8;
              k = j;
              bool10 = bool7;
              bool11 = bool6;
              bool12 = bool5;
              bool13 = bool4;
              bool14 = bool3;
              bool15 = bool2;
              bool16 = bool1;
              break label1962;
            }
            if (i2 == R.styleable.GenericDraweeHierarchy_fadeDuration)
            {
              paramGenericDraweeHierarchyBuilder.setFadeDuration(localTypedArray.getInt(i2, 0));
              bool9 = bool8;
              k = j;
              bool10 = bool7;
              bool11 = bool6;
              bool12 = bool5;
              bool13 = bool4;
              bool14 = bool3;
              bool15 = bool2;
              bool16 = bool1;
              break label1962;
            }
            if (i2 == R.styleable.GenericDraweeHierarchy_viewAspectRatio)
            {
              paramGenericDraweeHierarchyBuilder.setDesiredAspectRatio(localTypedArray.getFloat(i2, 0.0F));
              bool9 = bool8;
              k = j;
              bool10 = bool7;
              bool11 = bool6;
              bool12 = bool5;
              bool13 = bool4;
              bool14 = bool3;
              bool15 = bool2;
              bool16 = bool1;
              break label1962;
            }
            if (i2 == R.styleable.GenericDraweeHierarchy_placeholderImageScaleType)
            {
              paramGenericDraweeHierarchyBuilder.setPlaceholderImageScaleType(getScaleTypeFromXml(localTypedArray, i2));
              bool9 = bool8;
              k = j;
              bool10 = bool7;
              bool11 = bool6;
              bool12 = bool5;
              bool13 = bool4;
              bool14 = bool3;
              bool15 = bool2;
              bool16 = bool1;
              break label1962;
            }
            if (i2 == R.styleable.GenericDraweeHierarchy_retryImage)
            {
              paramGenericDraweeHierarchyBuilder.setRetryImage(getDrawable(paramAttributeSet, localTypedArray, i2));
              bool9 = bool8;
              k = j;
              bool10 = bool7;
              bool11 = bool6;
              bool12 = bool5;
              bool13 = bool4;
              bool14 = bool3;
              bool15 = bool2;
              bool16 = bool1;
              break label1962;
            }
            if (i2 == R.styleable.GenericDraweeHierarchy_retryImageScaleType)
            {
              paramGenericDraweeHierarchyBuilder.setRetryImageScaleType(getScaleTypeFromXml(localTypedArray, i2));
              bool9 = bool8;
              k = j;
              bool10 = bool7;
              bool11 = bool6;
              bool12 = bool5;
              bool13 = bool4;
              bool14 = bool3;
              bool15 = bool2;
              bool16 = bool1;
              break label1962;
            }
            if (i2 == R.styleable.GenericDraweeHierarchy_failureImage)
            {
              paramGenericDraweeHierarchyBuilder.setFailureImage(getDrawable(paramAttributeSet, localTypedArray, i2));
              bool9 = bool8;
              k = j;
              bool10 = bool7;
              bool11 = bool6;
              bool12 = bool5;
              bool13 = bool4;
              bool14 = bool3;
              bool15 = bool2;
              bool16 = bool1;
              break label1962;
            }
            if (i2 == R.styleable.GenericDraweeHierarchy_failureImageScaleType)
            {
              paramGenericDraweeHierarchyBuilder.setFailureImageScaleType(getScaleTypeFromXml(localTypedArray, i2));
              bool9 = bool8;
              k = j;
              bool10 = bool7;
              bool11 = bool6;
              bool12 = bool5;
              bool13 = bool4;
              bool14 = bool3;
              bool15 = bool2;
              bool16 = bool1;
              break label1962;
            }
            if (i2 == R.styleable.GenericDraweeHierarchy_progressBarImageScaleType)
            {
              paramGenericDraweeHierarchyBuilder.setProgressBarImageScaleType(getScaleTypeFromXml(localTypedArray, i2));
              bool9 = bool8;
              k = j;
              bool10 = bool7;
              bool11 = bool6;
              bool12 = bool5;
              bool13 = bool4;
              bool14 = bool3;
              bool15 = bool2;
              bool16 = bool1;
              break label1962;
            }
            if (i2 == R.styleable.GenericDraweeHierarchy_progressBarAutoRotateInterval)
            {
              k = localTypedArray.getInteger(i2, j);
              bool9 = bool8;
              bool10 = bool7;
              bool11 = bool6;
              bool12 = bool5;
              bool13 = bool4;
              bool14 = bool3;
              bool15 = bool2;
              bool16 = bool1;
              break label1962;
            }
            if (i2 == R.styleable.GenericDraweeHierarchy_backgroundImage)
            {
              paramGenericDraweeHierarchyBuilder.setBackground(getDrawable(paramAttributeSet, localTypedArray, i2));
              bool9 = bool8;
              k = j;
              bool10 = bool7;
              bool11 = bool6;
              bool12 = bool5;
              bool13 = bool4;
              bool14 = bool3;
              bool15 = bool2;
              bool16 = bool1;
              break label1962;
            }
            if (i2 == R.styleable.GenericDraweeHierarchy_overlayImage)
            {
              paramGenericDraweeHierarchyBuilder.setOverlay(getDrawable(paramAttributeSet, localTypedArray, i2));
              bool9 = bool8;
              k = j;
              bool10 = bool7;
              bool11 = bool6;
              bool12 = bool5;
              bool13 = bool4;
              bool14 = bool3;
              bool15 = bool2;
              bool16 = bool1;
              break label1962;
            }
            if (i2 == R.styleable.GenericDraweeHierarchy_roundAsCircle)
            {
              getRoundingParams(paramGenericDraweeHierarchyBuilder).setRoundAsCircle(localTypedArray.getBoolean(i2, false));
              bool9 = bool8;
              k = j;
              bool10 = bool7;
              bool11 = bool6;
              bool12 = bool5;
              bool13 = bool4;
              bool14 = bool3;
              bool15 = bool2;
              bool16 = bool1;
              break label1962;
            }
            if (i2 == R.styleable.GenericDraweeHierarchy_roundedCornerRadius)
            {
              i = localTypedArray.getDimensionPixelSize(i2, i);
              bool9 = bool8;
              k = j;
              bool10 = bool7;
              bool11 = bool6;
              bool12 = bool5;
              bool13 = bool4;
              bool14 = bool3;
              bool15 = bool2;
              bool16 = bool1;
              break label1962;
            }
            if (i2 == R.styleable.GenericDraweeHierarchy_roundTopLeft)
            {
              bool7 = localTypedArray.getBoolean(i2, bool7);
              break label2001;
            }
            if (i2 == R.styleable.GenericDraweeHierarchy_roundTopRight)
            {
              bool5 = localTypedArray.getBoolean(i2, bool5);
              break label2001;
            }
            if (i2 == R.styleable.GenericDraweeHierarchy_roundBottomLeft)
            {
              bool1 = localTypedArray.getBoolean(i2, bool1);
              break label2001;
            }
            if (i2 == R.styleable.GenericDraweeHierarchy_roundBottomRight)
            {
              bool3 = localTypedArray.getBoolean(i2, bool3);
              break label2001;
            }
            if (i2 == R.styleable.GenericDraweeHierarchy_roundTopStart)
            {
              bool6 = localTypedArray.getBoolean(i2, bool6);
              break label2001;
            }
            if (i2 == R.styleable.GenericDraweeHierarchy_roundTopEnd)
            {
              bool4 = localTypedArray.getBoolean(i2, bool4);
              break label2001;
            }
            if (i2 == R.styleable.GenericDraweeHierarchy_roundBottomStart)
            {
              bool8 = localTypedArray.getBoolean(i2, bool8);
              break label2001;
            }
            if (i2 == R.styleable.GenericDraweeHierarchy_roundBottomEnd)
            {
              bool2 = localTypedArray.getBoolean(i2, bool2);
              break label2001;
            }
            if (i2 == R.styleable.GenericDraweeHierarchy_roundWithOverlayColor)
            {
              paramAttributeSet = getRoundingParams(paramGenericDraweeHierarchyBuilder);
              paramAttributeSet.setOverlayColor(localTypedArray.getColor(i2, 0));
              bool9 = bool8;
              k = j;
              bool10 = bool7;
              bool11 = bool6;
              bool12 = bool5;
              bool13 = bool4;
              bool14 = bool3;
              bool15 = bool2;
              bool16 = bool1;
              break label1962;
            }
            m = i;
            if (i2 == R.styleable.GenericDraweeHierarchy_roundingBorderWidth)
            {
              getRoundingParams(paramGenericDraweeHierarchyBuilder).setBorderWidth(localTypedArray.getDimensionPixelSize(i2, 0));
              bool9 = bool8;
              k = j;
              bool10 = bool7;
              bool11 = bool6;
              bool12 = bool5;
              bool13 = bool4;
              bool14 = bool3;
              bool15 = bool2;
              bool16 = bool1;
              i = m;
              break label1962;
            }
            if (i2 == R.styleable.GenericDraweeHierarchy_roundingBorderColor)
            {
              getRoundingParams(paramGenericDraweeHierarchyBuilder).setBorderColor(localTypedArray.getColor(i2, 0));
              bool9 = bool8;
              k = j;
              bool10 = bool7;
              bool11 = bool6;
              bool12 = bool5;
              bool13 = bool4;
              bool14 = bool3;
              bool15 = bool2;
              bool16 = bool1;
              i = m;
              break label1962;
            }
            bool9 = bool8;
            k = j;
            bool10 = bool7;
            bool11 = bool6;
            bool12 = bool5;
            bool13 = bool4;
            bool14 = bool3;
            bool15 = bool2;
            bool16 = bool1;
            i = m;
            if (i2 != R.styleable.GenericDraweeHierarchy_roundingBorderPadding) {
              break label1962;
            }
            getRoundingParams(paramGenericDraweeHierarchyBuilder).setPadding(localTypedArray.getDimensionPixelSize(i2, 0));
            i = m;
            n += 1;
          }
          finally
          {
            break label1802;
          }
        }
      }
      int i5 = 0;
      localTypedArray.recycle();
      int i3;
      if ((Build.VERSION.SDK_INT >= 17) && (paramContext.getResources().getConfiguration().getLayoutDirection() == 1))
      {
        if ((bool7) && (bool4)) {
          n = 1;
        } else {
          n = 0;
        }
        if ((bool5) && (bool6)) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if ((bool3) && (bool8)) {
          i3 = 1;
        } else {
          i3 = 0;
        }
        i2 = n;
        m = i1;
        k = i3;
        i4 = i5;
        if (!bool1) {
          break label1798;
        }
        i2 = n;
        m = i1;
        k = i3;
        i4 = i5;
        if (!bool2) {
          break label1798;
        }
        m = i1;
        k = i3;
      }
      else
      {
        if ((bool7) && (bool6)) {
          n = 1;
        } else {
          n = 0;
        }
        if ((bool5) && (bool4)) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if ((bool3) && (bool2)) {
          i3 = 1;
        } else {
          i3 = 0;
        }
        i2 = n;
        m = i1;
        k = i3;
        i4 = i5;
        if (!bool1) {
          break label1798;
        }
        i2 = n;
        m = i1;
        k = i3;
        i4 = i5;
        if (!bool8) {
          break label1798;
        }
        k = i3;
        m = i1;
      }
      i4 = 1;
      i2 = n;
    }
    finally
    {
      label1798:
      label1802:
      localTypedArray.recycle();
      if (Build.VERSION.SDK_INT >= 17) {
        paramContext.getResources().getConfiguration().getLayoutDirection();
      }
    }
    int k = 1;
    int i2 = 1;
    int i4 = 1;
    if ((paramGenericDraweeHierarchyBuilder.getProgressBarImage() != null) && (j > 0)) {
      paramGenericDraweeHierarchyBuilder.setProgressBarImage(new AutoRotateDrawable(paramGenericDraweeHierarchyBuilder.getProgressBarImage(), j));
    }
    if (i > 0)
    {
      paramContext = getRoundingParams(paramGenericDraweeHierarchyBuilder);
      float f1;
      if (i2 != 0) {
        f1 = i;
      } else {
        f1 = 0.0F;
      }
      float f2;
      if (m != 0) {
        f2 = i;
      } else {
        f2 = 0.0F;
      }
      float f3;
      if (k != 0) {
        f3 = i;
      } else {
        f3 = 0.0F;
      }
      float f4;
      if (i4 != 0) {
        f4 = i;
      } else {
        f4 = 0.0F;
      }
      paramContext.setCornersRadii(f1, f2, f3, f4);
    }
    return paramGenericDraweeHierarchyBuilder;
    for (;;)
    {
      label1962:
      bool8 = bool9;
      j = k;
      bool7 = bool10;
      bool6 = bool11;
      bool5 = bool12;
      bool4 = bool13;
      bool3 = bool14;
      bool2 = bool15;
      bool1 = bool16;
      break;
      label2001:
      bool9 = bool8;
      k = j;
      bool10 = bool7;
      bool11 = bool6;
      bool12 = bool5;
      bool13 = bool4;
      bool14 = bool3;
      bool15 = bool2;
      bool16 = bool1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\generic\GenericDraweeHierarchyInflater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */