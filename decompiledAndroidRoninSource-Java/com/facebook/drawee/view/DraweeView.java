package com.facebook.drawee.view;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.Nullable;

public class DraweeView<DH extends DraweeHierarchy>
  extends ImageView
{
  private static boolean sGlobalLegacyVisibilityHandlingEnabled;
  private float mAspectRatio = 0.0F;
  private DraweeHolder<DH> mDraweeHolder;
  private boolean mInitialised = false;
  private boolean mLegacyVisibilityHandlingEnabled = false;
  private final AspectRatioMeasure.Spec mMeasureSpec = new AspectRatioMeasure.Spec();
  
  public DraweeView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public DraweeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public DraweeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  public DraweeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.beginSection("DraweeView#init");
        }
        bool = this.mInitialised;
        if (bool) {
          return;
        }
        bool = true;
        this.mInitialised = true;
        this.mDraweeHolder = DraweeHolder.create(null, paramContext);
        if (Build.VERSION.SDK_INT >= 21)
        {
          ColorStateList localColorStateList = getImageTintList();
          if (localColorStateList == null) {
            return;
          }
          setColorFilter(localColorStateList.getDefaultColor());
        }
        if ((sGlobalLegacyVisibilityHandlingEnabled) && (paramContext.getApplicationInfo().targetSdkVersion >= 24))
        {
          this.mLegacyVisibilityHandlingEnabled = bool;
          return;
        }
      }
      finally
      {
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.endSection();
        }
      }
      boolean bool = false;
    }
  }
  
  private void maybeOverrideVisibilityHandling()
  {
    if (this.mLegacyVisibilityHandlingEnabled)
    {
      Drawable localDrawable = getDrawable();
      if (localDrawable != null)
      {
        boolean bool;
        if (getVisibility() == 0) {
          bool = true;
        } else {
          bool = false;
        }
        localDrawable.setVisible(bool, false);
      }
    }
  }
  
  public static void setGlobalLegacyVisibilityHandlingEnabled(boolean paramBoolean)
  {
    sGlobalLegacyVisibilityHandlingEnabled = paramBoolean;
  }
  
  protected void doAttach()
  {
    this.mDraweeHolder.onAttach();
  }
  
  protected void doDetach()
  {
    this.mDraweeHolder.onDetach();
  }
  
  public float getAspectRatio()
  {
    return this.mAspectRatio;
  }
  
  @Nullable
  public DraweeController getController()
  {
    return this.mDraweeHolder.getController();
  }
  
  public DH getHierarchy()
  {
    return this.mDraweeHolder.getHierarchy();
  }
  
  @Nullable
  public Drawable getTopLevelDrawable()
  {
    return this.mDraweeHolder.getTopLevelDrawable();
  }
  
  public boolean hasController()
  {
    return this.mDraweeHolder.getController() != null;
  }
  
  public boolean hasHierarchy()
  {
    return this.mDraweeHolder.hasHierarchy();
  }
  
  protected void onAttach()
  {
    doAttach();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    maybeOverrideVisibilityHandling();
    onAttach();
  }
  
  protected void onDetach()
  {
    doDetach();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    maybeOverrideVisibilityHandling();
    onDetach();
  }
  
  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    maybeOverrideVisibilityHandling();
    onAttach();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.mMeasureSpec.width = paramInt1;
    this.mMeasureSpec.height = paramInt2;
    AspectRatioMeasure.updateMeasureSpec(this.mMeasureSpec, this.mAspectRatio, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
    super.onMeasure(this.mMeasureSpec.width, this.mMeasureSpec.height);
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    maybeOverrideVisibilityHandling();
    onDetach();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mDraweeHolder.onTouchEvent(paramMotionEvent)) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    maybeOverrideVisibilityHandling();
  }
  
  public void setAspectRatio(float paramFloat)
  {
    if (paramFloat == this.mAspectRatio) {
      return;
    }
    this.mAspectRatio = paramFloat;
    requestLayout();
  }
  
  public void setController(@Nullable DraweeController paramDraweeController)
  {
    this.mDraweeHolder.setController(paramDraweeController);
    super.setImageDrawable(this.mDraweeHolder.getTopLevelDrawable());
  }
  
  public void setHierarchy(DH paramDH)
  {
    this.mDraweeHolder.setHierarchy(paramDH);
    super.setImageDrawable(this.mDraweeHolder.getTopLevelDrawable());
  }
  
  @Deprecated
  public void setImageBitmap(Bitmap paramBitmap)
  {
    init(getContext());
    this.mDraweeHolder.setController(null);
    super.setImageBitmap(paramBitmap);
  }
  
  @Deprecated
  public void setImageDrawable(Drawable paramDrawable)
  {
    init(getContext());
    this.mDraweeHolder.setController(null);
    super.setImageDrawable(paramDrawable);
  }
  
  @Deprecated
  public void setImageResource(int paramInt)
  {
    init(getContext());
    this.mDraweeHolder.setController(null);
    super.setImageResource(paramInt);
  }
  
  @Deprecated
  public void setImageURI(Uri paramUri)
  {
    init(getContext());
    this.mDraweeHolder.setController(null);
    super.setImageURI(paramUri);
  }
  
  public void setLegacyVisibilityHandlingEnabled(boolean paramBoolean)
  {
    this.mLegacyVisibilityHandlingEnabled = paramBoolean;
  }
  
  public String toString()
  {
    Objects.ToStringHelper localToStringHelper = Objects.toStringHelper(this);
    Object localObject = this.mDraweeHolder;
    if (localObject != null) {
      localObject = ((DraweeHolder)localObject).toString();
    } else {
      localObject = "<no holder set>";
    }
    return localToStringHelper.add("holder", localObject).toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\view\DraweeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */