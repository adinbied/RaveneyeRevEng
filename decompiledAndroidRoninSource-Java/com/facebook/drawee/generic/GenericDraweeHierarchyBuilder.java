package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public class GenericDraweeHierarchyBuilder
{
  public static final ScalingUtils.ScaleType DEFAULT_ACTUAL_IMAGE_SCALE_TYPE = ScalingUtils.ScaleType.CENTER_CROP;
  public static final int DEFAULT_FADE_DURATION = 300;
  public static final ScalingUtils.ScaleType DEFAULT_SCALE_TYPE = ScalingUtils.ScaleType.CENTER_INSIDE;
  @Nullable
  private ColorFilter mActualImageColorFilter;
  @Nullable
  private PointF mActualImageFocusPoint;
  @Nullable
  private Matrix mActualImageMatrix;
  @Nullable
  private ScalingUtils.ScaleType mActualImageScaleType;
  @Nullable
  private Drawable mBackground;
  private float mDesiredAspectRatio;
  private int mFadeDuration;
  @Nullable
  private Drawable mFailureImage;
  @Nullable
  private ScalingUtils.ScaleType mFailureImageScaleType;
  @Nullable
  private List<Drawable> mOverlays;
  @Nullable
  private Drawable mPlaceholderImage;
  @Nullable
  private ScalingUtils.ScaleType mPlaceholderImageScaleType;
  @Nullable
  private Drawable mPressedStateOverlay;
  @Nullable
  private Drawable mProgressBarImage;
  @Nullable
  private ScalingUtils.ScaleType mProgressBarImageScaleType;
  private Resources mResources;
  @Nullable
  private Drawable mRetryImage;
  @Nullable
  private ScalingUtils.ScaleType mRetryImageScaleType;
  @Nullable
  private RoundingParams mRoundingParams;
  
  public GenericDraweeHierarchyBuilder(Resources paramResources)
  {
    this.mResources = paramResources;
    init();
  }
  
  private void init()
  {
    this.mFadeDuration = 300;
    this.mDesiredAspectRatio = 0.0F;
    this.mPlaceholderImage = null;
    ScalingUtils.ScaleType localScaleType = DEFAULT_SCALE_TYPE;
    this.mPlaceholderImageScaleType = localScaleType;
    this.mRetryImage = null;
    this.mRetryImageScaleType = localScaleType;
    this.mFailureImage = null;
    this.mFailureImageScaleType = localScaleType;
    this.mProgressBarImage = null;
    this.mProgressBarImageScaleType = localScaleType;
    this.mActualImageScaleType = DEFAULT_ACTUAL_IMAGE_SCALE_TYPE;
    this.mActualImageMatrix = null;
    this.mActualImageFocusPoint = null;
    this.mActualImageColorFilter = null;
    this.mBackground = null;
    this.mOverlays = null;
    this.mPressedStateOverlay = null;
    this.mRoundingParams = null;
  }
  
  public static GenericDraweeHierarchyBuilder newInstance(Resources paramResources)
  {
    return new GenericDraweeHierarchyBuilder(paramResources);
  }
  
  private void validate()
  {
    Object localObject = this.mOverlays;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        Preconditions.checkNotNull((Drawable)((Iterator)localObject).next());
      }
    }
  }
  
  public GenericDraweeHierarchy build()
  {
    validate();
    return new GenericDraweeHierarchy(this);
  }
  
  @Nullable
  public ColorFilter getActualImageColorFilter()
  {
    return this.mActualImageColorFilter;
  }
  
  @Nullable
  public PointF getActualImageFocusPoint()
  {
    return this.mActualImageFocusPoint;
  }
  
  @Nullable
  public ScalingUtils.ScaleType getActualImageScaleType()
  {
    return this.mActualImageScaleType;
  }
  
  @Nullable
  public Drawable getBackground()
  {
    return this.mBackground;
  }
  
  public float getDesiredAspectRatio()
  {
    return this.mDesiredAspectRatio;
  }
  
  public int getFadeDuration()
  {
    return this.mFadeDuration;
  }
  
  @Nullable
  public Drawable getFailureImage()
  {
    return this.mFailureImage;
  }
  
  @Nullable
  public ScalingUtils.ScaleType getFailureImageScaleType()
  {
    return this.mFailureImageScaleType;
  }
  
  @Nullable
  public List<Drawable> getOverlays()
  {
    return this.mOverlays;
  }
  
  @Nullable
  public Drawable getPlaceholderImage()
  {
    return this.mPlaceholderImage;
  }
  
  @Nullable
  public ScalingUtils.ScaleType getPlaceholderImageScaleType()
  {
    return this.mPlaceholderImageScaleType;
  }
  
  @Nullable
  public Drawable getPressedStateOverlay()
  {
    return this.mPressedStateOverlay;
  }
  
  @Nullable
  public Drawable getProgressBarImage()
  {
    return this.mProgressBarImage;
  }
  
  @Nullable
  public ScalingUtils.ScaleType getProgressBarImageScaleType()
  {
    return this.mProgressBarImageScaleType;
  }
  
  public Resources getResources()
  {
    return this.mResources;
  }
  
  @Nullable
  public Drawable getRetryImage()
  {
    return this.mRetryImage;
  }
  
  @Nullable
  public ScalingUtils.ScaleType getRetryImageScaleType()
  {
    return this.mRetryImageScaleType;
  }
  
  @Nullable
  public RoundingParams getRoundingParams()
  {
    return this.mRoundingParams;
  }
  
  public GenericDraweeHierarchyBuilder reset()
  {
    init();
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setActualImageColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    this.mActualImageColorFilter = paramColorFilter;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setActualImageFocusPoint(@Nullable PointF paramPointF)
  {
    this.mActualImageFocusPoint = paramPointF;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setActualImageScaleType(@Nullable ScalingUtils.ScaleType paramScaleType)
  {
    this.mActualImageScaleType = paramScaleType;
    this.mActualImageMatrix = null;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setBackground(@Nullable Drawable paramDrawable)
  {
    this.mBackground = paramDrawable;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setDesiredAspectRatio(float paramFloat)
  {
    this.mDesiredAspectRatio = paramFloat;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setFadeDuration(int paramInt)
  {
    this.mFadeDuration = paramInt;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setFailureImage(int paramInt)
  {
    this.mFailureImage = this.mResources.getDrawable(paramInt);
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setFailureImage(int paramInt, @Nullable ScalingUtils.ScaleType paramScaleType)
  {
    this.mFailureImage = this.mResources.getDrawable(paramInt);
    this.mFailureImageScaleType = paramScaleType;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setFailureImage(@Nullable Drawable paramDrawable)
  {
    this.mFailureImage = paramDrawable;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setFailureImage(Drawable paramDrawable, @Nullable ScalingUtils.ScaleType paramScaleType)
  {
    this.mFailureImage = paramDrawable;
    this.mFailureImageScaleType = paramScaleType;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setFailureImageScaleType(@Nullable ScalingUtils.ScaleType paramScaleType)
  {
    this.mFailureImageScaleType = paramScaleType;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setOverlay(@Nullable Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      this.mOverlays = null;
      return this;
    }
    this.mOverlays = Arrays.asList(new Drawable[] { paramDrawable });
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setOverlays(@Nullable List<Drawable> paramList)
  {
    this.mOverlays = paramList;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setPlaceholderImage(int paramInt)
  {
    this.mPlaceholderImage = this.mResources.getDrawable(paramInt);
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setPlaceholderImage(int paramInt, @Nullable ScalingUtils.ScaleType paramScaleType)
  {
    this.mPlaceholderImage = this.mResources.getDrawable(paramInt);
    this.mPlaceholderImageScaleType = paramScaleType;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setPlaceholderImage(@Nullable Drawable paramDrawable)
  {
    this.mPlaceholderImage = paramDrawable;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setPlaceholderImage(Drawable paramDrawable, @Nullable ScalingUtils.ScaleType paramScaleType)
  {
    this.mPlaceholderImage = paramDrawable;
    this.mPlaceholderImageScaleType = paramScaleType;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setPlaceholderImageScaleType(@Nullable ScalingUtils.ScaleType paramScaleType)
  {
    this.mPlaceholderImageScaleType = paramScaleType;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setPressedStateOverlay(@Nullable Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      this.mPressedStateOverlay = null;
      return this;
    }
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, paramDrawable);
    this.mPressedStateOverlay = localStateListDrawable;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setProgressBarImage(int paramInt)
  {
    this.mProgressBarImage = this.mResources.getDrawable(paramInt);
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setProgressBarImage(int paramInt, @Nullable ScalingUtils.ScaleType paramScaleType)
  {
    this.mProgressBarImage = this.mResources.getDrawable(paramInt);
    this.mProgressBarImageScaleType = paramScaleType;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setProgressBarImage(@Nullable Drawable paramDrawable)
  {
    this.mProgressBarImage = paramDrawable;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setProgressBarImage(Drawable paramDrawable, @Nullable ScalingUtils.ScaleType paramScaleType)
  {
    this.mProgressBarImage = paramDrawable;
    this.mProgressBarImageScaleType = paramScaleType;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setProgressBarImageScaleType(@Nullable ScalingUtils.ScaleType paramScaleType)
  {
    this.mProgressBarImageScaleType = paramScaleType;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setRetryImage(int paramInt)
  {
    this.mRetryImage = this.mResources.getDrawable(paramInt);
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setRetryImage(int paramInt, @Nullable ScalingUtils.ScaleType paramScaleType)
  {
    this.mRetryImage = this.mResources.getDrawable(paramInt);
    this.mRetryImageScaleType = paramScaleType;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setRetryImage(@Nullable Drawable paramDrawable)
  {
    this.mRetryImage = paramDrawable;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setRetryImage(Drawable paramDrawable, @Nullable ScalingUtils.ScaleType paramScaleType)
  {
    this.mRetryImage = paramDrawable;
    this.mRetryImageScaleType = paramScaleType;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setRetryImageScaleType(@Nullable ScalingUtils.ScaleType paramScaleType)
  {
    this.mRetryImageScaleType = paramScaleType;
    return this;
  }
  
  public GenericDraweeHierarchyBuilder setRoundingParams(@Nullable RoundingParams paramRoundingParams)
  {
    this.mRoundingParams = paramRoundingParams;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\generic\GenericDraweeHierarchyBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */