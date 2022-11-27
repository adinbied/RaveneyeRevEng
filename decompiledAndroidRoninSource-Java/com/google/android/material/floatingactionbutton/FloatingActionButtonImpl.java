package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.animator;
import com.google.android.material.R.color;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MatrixEvaluator;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.internal.CircularBorderDrawable;
import com.google.android.material.internal.StateListAnimator;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.google.android.material.shadow.ShadowViewDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class FloatingActionButtonImpl
{
  static final int ANIM_STATE_HIDING = 1;
  static final int ANIM_STATE_NONE = 0;
  static final int ANIM_STATE_SHOWING = 2;
  static final long ELEVATION_ANIM_DELAY = 100L;
  static final long ELEVATION_ANIM_DURATION = 100L;
  static final TimeInterpolator ELEVATION_ANIM_INTERPOLATOR = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
  static final int[] EMPTY_STATE_SET = new int[0];
  static final int[] ENABLED_STATE_SET;
  static final int[] FOCUSED_ENABLED_STATE_SET;
  private static final float HIDE_ICON_SCALE = 0.0F;
  private static final float HIDE_OPACITY = 0.0F;
  private static final float HIDE_SCALE = 0.0F;
  static final int[] HOVERED_ENABLED_STATE_SET;
  static final int[] HOVERED_FOCUSED_ENABLED_STATE_SET;
  static final int[] PRESSED_ENABLED_STATE_SET = { 16842919, 16842910 };
  private static final float SHOW_ICON_SCALE = 1.0F;
  private static final float SHOW_OPACITY = 1.0F;
  private static final float SHOW_SCALE = 1.0F;
  int animState = 0;
  CircularBorderDrawable borderDrawable;
  Drawable contentBackground;
  Animator currentAnimator;
  private MotionSpec defaultHideMotionSpec;
  private MotionSpec defaultShowMotionSpec;
  float elevation;
  private ArrayList<Animator.AnimatorListener> hideListeners;
  MotionSpec hideMotionSpec;
  float hoveredFocusedTranslationZ;
  float imageMatrixScale = 1.0F;
  int maxImageSize;
  private ViewTreeObserver.OnPreDrawListener preDrawListener;
  float pressedTranslationZ;
  Drawable rippleDrawable;
  private float rotation;
  ShadowDrawableWrapper shadowDrawable;
  final ShadowViewDelegate shadowViewDelegate;
  Drawable shapeDrawable;
  private ArrayList<Animator.AnimatorListener> showListeners;
  MotionSpec showMotionSpec;
  private final StateListAnimator stateListAnimator;
  private final Matrix tmpMatrix = new Matrix();
  private final Rect tmpRect = new Rect();
  private final RectF tmpRectF1 = new RectF();
  private final RectF tmpRectF2 = new RectF();
  final VisibilityAwareImageButton view;
  
  static
  {
    HOVERED_FOCUSED_ENABLED_STATE_SET = new int[] { 16843623, 16842908, 16842910 };
    FOCUSED_ENABLED_STATE_SET = new int[] { 16842908, 16842910 };
    HOVERED_ENABLED_STATE_SET = new int[] { 16843623, 16842910 };
    ENABLED_STATE_SET = new int[] { 16842910 };
  }
  
  FloatingActionButtonImpl(VisibilityAwareImageButton paramVisibilityAwareImageButton, ShadowViewDelegate paramShadowViewDelegate)
  {
    this.view = paramVisibilityAwareImageButton;
    this.shadowViewDelegate = paramShadowViewDelegate;
    paramVisibilityAwareImageButton = new StateListAnimator();
    this.stateListAnimator = paramVisibilityAwareImageButton;
    paramVisibilityAwareImageButton.addState(PRESSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToPressedTranslationZAnimation()));
    this.stateListAnimator.addState(HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation()));
    this.stateListAnimator.addState(FOCUSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation()));
    this.stateListAnimator.addState(HOVERED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation()));
    this.stateListAnimator.addState(ENABLED_STATE_SET, createElevationAnimator(new ResetElevationAnimation()));
    this.stateListAnimator.addState(EMPTY_STATE_SET, createElevationAnimator(new DisabledElevationAnimation()));
    this.rotation = this.view.getRotation();
  }
  
  private void calculateImageMatrixFromScale(float paramFloat, Matrix paramMatrix)
  {
    paramMatrix.reset();
    Drawable localDrawable = this.view.getDrawable();
    if ((localDrawable != null) && (this.maxImageSize != 0))
    {
      RectF localRectF1 = this.tmpRectF1;
      RectF localRectF2 = this.tmpRectF2;
      localRectF1.set(0.0F, 0.0F, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      int i = this.maxImageSize;
      localRectF2.set(0.0F, 0.0F, i, i);
      paramMatrix.setRectToRect(localRectF1, localRectF2, Matrix.ScaleToFit.CENTER);
      i = this.maxImageSize;
      paramMatrix.postScale(paramFloat, paramFloat, i / 2.0F, i / 2.0F);
    }
  }
  
  private AnimatorSet createAnimator(MotionSpec paramMotionSpec, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ArrayList localArrayList = new ArrayList();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.view, View.ALPHA, new float[] { paramFloat1 });
    paramMotionSpec.getTiming("opacity").apply(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(this.view, View.SCALE_X, new float[] { paramFloat2 });
    paramMotionSpec.getTiming("scale").apply(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(this.view, View.SCALE_Y, new float[] { paramFloat2 });
    paramMotionSpec.getTiming("scale").apply(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    calculateImageMatrixFromScale(paramFloat3, this.tmpMatrix);
    localObjectAnimator = ObjectAnimator.ofObject(this.view, new ImageMatrixProperty(), new MatrixEvaluator(), new Matrix[] { new Matrix(this.tmpMatrix) });
    paramMotionSpec.getTiming("iconScale").apply(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    paramMotionSpec = new AnimatorSet();
    AnimatorSetCompat.playTogether(paramMotionSpec, localArrayList);
    return paramMotionSpec;
  }
  
  private ValueAnimator createElevationAnimator(ShadowAnimatorImpl paramShadowAnimatorImpl)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setInterpolator(ELEVATION_ANIM_INTERPOLATOR);
    localValueAnimator.setDuration(100L);
    localValueAnimator.addListener(paramShadowAnimatorImpl);
    localValueAnimator.addUpdateListener(paramShadowAnimatorImpl);
    localValueAnimator.setFloatValues(new float[] { 0.0F, 1.0F });
    return localValueAnimator;
  }
  
  private void ensurePreDrawListener()
  {
    if (this.preDrawListener == null) {
      this.preDrawListener = new ViewTreeObserver.OnPreDrawListener()
      {
        public boolean onPreDraw()
        {
          FloatingActionButtonImpl.this.onPreDraw();
          return true;
        }
      };
    }
  }
  
  private MotionSpec getDefaultHideMotionSpec()
  {
    if (this.defaultHideMotionSpec == null) {
      this.defaultHideMotionSpec = MotionSpec.createFromResource(this.view.getContext(), R.animator.design_fab_hide_motion_spec);
    }
    return this.defaultHideMotionSpec;
  }
  
  private MotionSpec getDefaultShowMotionSpec()
  {
    if (this.defaultShowMotionSpec == null) {
      this.defaultShowMotionSpec = MotionSpec.createFromResource(this.view.getContext(), R.animator.design_fab_show_motion_spec);
    }
    return this.defaultShowMotionSpec;
  }
  
  private boolean shouldAnimateVisibilityChange()
  {
    return (ViewCompat.isLaidOut(this.view)) && (!this.view.isInEditMode());
  }
  
  private void updateFromViewRotation()
  {
    if (Build.VERSION.SDK_INT == 19) {
      if (this.rotation % 90.0F != 0.0F)
      {
        if (this.view.getLayerType() != 1) {
          this.view.setLayerType(1, null);
        }
      }
      else if (this.view.getLayerType() != 0) {
        this.view.setLayerType(0, null);
      }
    }
    Object localObject = this.shadowDrawable;
    if (localObject != null) {
      ((ShadowDrawableWrapper)localObject).setRotation(-this.rotation);
    }
    localObject = this.borderDrawable;
    if (localObject != null) {
      ((CircularBorderDrawable)localObject).setRotation(-this.rotation);
    }
  }
  
  public void addOnHideAnimationListener(Animator.AnimatorListener paramAnimatorListener)
  {
    if (this.hideListeners == null) {
      this.hideListeners = new ArrayList();
    }
    this.hideListeners.add(paramAnimatorListener);
  }
  
  void addOnShowAnimationListener(Animator.AnimatorListener paramAnimatorListener)
  {
    if (this.showListeners == null) {
      this.showListeners = new ArrayList();
    }
    this.showListeners.add(paramAnimatorListener);
  }
  
  CircularBorderDrawable createBorderDrawable(int paramInt, ColorStateList paramColorStateList)
  {
    Context localContext = this.view.getContext();
    CircularBorderDrawable localCircularBorderDrawable = newCircularDrawable();
    localCircularBorderDrawable.setGradientColors(ContextCompat.getColor(localContext, R.color.design_fab_stroke_top_outer_color), ContextCompat.getColor(localContext, R.color.design_fab_stroke_top_inner_color), ContextCompat.getColor(localContext, R.color.design_fab_stroke_end_inner_color), ContextCompat.getColor(localContext, R.color.design_fab_stroke_end_outer_color));
    localCircularBorderDrawable.setBorderWidth(paramInt);
    localCircularBorderDrawable.setBorderTint(paramColorStateList);
    return localCircularBorderDrawable;
  }
  
  GradientDrawable createShapeDrawable()
  {
    GradientDrawable localGradientDrawable = newGradientDrawableForShape();
    localGradientDrawable.setShape(1);
    localGradientDrawable.setColor(-1);
    return localGradientDrawable;
  }
  
  final Drawable getContentBackground()
  {
    return this.contentBackground;
  }
  
  float getElevation()
  {
    return this.elevation;
  }
  
  final MotionSpec getHideMotionSpec()
  {
    return this.hideMotionSpec;
  }
  
  float getHoveredFocusedTranslationZ()
  {
    return this.hoveredFocusedTranslationZ;
  }
  
  void getPadding(Rect paramRect)
  {
    this.shadowDrawable.getPadding(paramRect);
  }
  
  float getPressedTranslationZ()
  {
    return this.pressedTranslationZ;
  }
  
  final MotionSpec getShowMotionSpec()
  {
    return this.showMotionSpec;
  }
  
  void hide(final InternalVisibilityChangedListener paramInternalVisibilityChangedListener, final boolean paramBoolean)
  {
    if (isOrWillBeHidden()) {
      return;
    }
    Object localObject = this.currentAnimator;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    if (shouldAnimateVisibilityChange())
    {
      localObject = this.hideMotionSpec;
      if (localObject == null) {
        localObject = getDefaultHideMotionSpec();
      }
      localObject = createAnimator((MotionSpec)localObject, 0.0F, 0.0F, 0.0F);
      ((AnimatorSet)localObject).addListener(new AnimatorListenerAdapter()
      {
        private boolean cancelled;
        
        public void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          this.cancelled = true;
        }
        
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          FloatingActionButtonImpl.this.animState = 0;
          FloatingActionButtonImpl.this.currentAnimator = null;
          if (!this.cancelled)
          {
            paramAnonymousAnimator = FloatingActionButtonImpl.this.view;
            int i;
            if (paramBoolean) {
              i = 8;
            } else {
              i = 4;
            }
            paramAnonymousAnimator.internalSetVisibility(i, paramBoolean);
            paramAnonymousAnimator = paramInternalVisibilityChangedListener;
            if (paramAnonymousAnimator != null) {
              paramAnonymousAnimator.onHidden();
            }
          }
        }
        
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          FloatingActionButtonImpl.this.view.internalSetVisibility(0, paramBoolean);
          FloatingActionButtonImpl.this.animState = 1;
          FloatingActionButtonImpl.this.currentAnimator = paramAnonymousAnimator;
          this.cancelled = false;
        }
      });
      paramInternalVisibilityChangedListener = this.hideListeners;
      if (paramInternalVisibilityChangedListener != null)
      {
        paramInternalVisibilityChangedListener = paramInternalVisibilityChangedListener.iterator();
        while (paramInternalVisibilityChangedListener.hasNext()) {
          ((AnimatorSet)localObject).addListener((Animator.AnimatorListener)paramInternalVisibilityChangedListener.next());
        }
      }
      ((AnimatorSet)localObject).start();
      return;
    }
    localObject = this.view;
    int i;
    if (paramBoolean) {
      i = 8;
    } else {
      i = 4;
    }
    ((VisibilityAwareImageButton)localObject).internalSetVisibility(i, paramBoolean);
    if (paramInternalVisibilityChangedListener != null) {
      paramInternalVisibilityChangedListener.onHidden();
    }
  }
  
  boolean isOrWillBeHidden()
  {
    int i = this.view.getVisibility();
    boolean bool2 = false;
    boolean bool1 = false;
    if (i == 0)
    {
      if (this.animState == 1) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (this.animState != 2) {
      bool1 = true;
    }
    return bool1;
  }
  
  boolean isOrWillBeShown()
  {
    int i = this.view.getVisibility();
    boolean bool2 = false;
    boolean bool1 = false;
    if (i != 0)
    {
      if (this.animState == 2) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (this.animState != 1) {
      bool1 = true;
    }
    return bool1;
  }
  
  void jumpDrawableToCurrentState()
  {
    this.stateListAnimator.jumpToCurrentState();
  }
  
  CircularBorderDrawable newCircularDrawable()
  {
    return new CircularBorderDrawable();
  }
  
  GradientDrawable newGradientDrawableForShape()
  {
    return new GradientDrawable();
  }
  
  void onAttachedToWindow()
  {
    if (requirePreDrawListener())
    {
      ensurePreDrawListener();
      this.view.getViewTreeObserver().addOnPreDrawListener(this.preDrawListener);
    }
  }
  
  void onCompatShadowChanged() {}
  
  void onDetachedFromWindow()
  {
    if (this.preDrawListener != null)
    {
      this.view.getViewTreeObserver().removeOnPreDrawListener(this.preDrawListener);
      this.preDrawListener = null;
    }
  }
  
  void onDrawableStateChanged(int[] paramArrayOfInt)
  {
    this.stateListAnimator.setState(paramArrayOfInt);
  }
  
  void onElevationsChanged(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ShadowDrawableWrapper localShadowDrawableWrapper = this.shadowDrawable;
    if (localShadowDrawableWrapper != null)
    {
      localShadowDrawableWrapper.setShadowSize(paramFloat1, this.pressedTranslationZ + paramFloat1);
      updatePadding();
    }
  }
  
  void onPaddingUpdated(Rect paramRect) {}
  
  void onPreDraw()
  {
    float f = this.view.getRotation();
    if (this.rotation != f)
    {
      this.rotation = f;
      updateFromViewRotation();
    }
  }
  
  public void removeOnHideAnimationListener(Animator.AnimatorListener paramAnimatorListener)
  {
    ArrayList localArrayList = this.hideListeners;
    if (localArrayList == null) {
      return;
    }
    localArrayList.remove(paramAnimatorListener);
  }
  
  void removeOnShowAnimationListener(Animator.AnimatorListener paramAnimatorListener)
  {
    ArrayList localArrayList = this.showListeners;
    if (localArrayList == null) {
      return;
    }
    localArrayList.remove(paramAnimatorListener);
  }
  
  boolean requirePreDrawListener()
  {
    return true;
  }
  
  void setBackgroundDrawable(ColorStateList paramColorStateList1, PorterDuff.Mode paramMode, ColorStateList paramColorStateList2, int paramInt)
  {
    Drawable localDrawable = DrawableCompat.wrap(createShapeDrawable());
    this.shapeDrawable = localDrawable;
    DrawableCompat.setTintList(localDrawable, paramColorStateList1);
    if (paramMode != null) {
      DrawableCompat.setTintMode(this.shapeDrawable, paramMode);
    }
    paramMode = DrawableCompat.wrap(createShapeDrawable());
    this.rippleDrawable = paramMode;
    DrawableCompat.setTintList(paramMode, RippleUtils.convertToRippleDrawableColor(paramColorStateList2));
    if (paramInt > 0)
    {
      paramMode = createBorderDrawable(paramInt, paramColorStateList1);
      this.borderDrawable = paramMode;
      paramColorStateList1 = new Drawable[3];
      paramColorStateList1[0] = paramMode;
      paramColorStateList1[1] = this.shapeDrawable;
      paramColorStateList1[2] = this.rippleDrawable;
    }
    else
    {
      this.borderDrawable = null;
      paramColorStateList1 = new Drawable[2];
      paramColorStateList1[0] = this.shapeDrawable;
      paramColorStateList1[1] = this.rippleDrawable;
    }
    this.contentBackground = new LayerDrawable(paramColorStateList1);
    paramColorStateList1 = this.view.getContext();
    paramMode = this.contentBackground;
    float f1 = this.shadowViewDelegate.getRadius();
    float f2 = this.elevation;
    paramColorStateList1 = new ShadowDrawableWrapper(paramColorStateList1, paramMode, f1, f2, f2 + this.pressedTranslationZ);
    this.shadowDrawable = paramColorStateList1;
    paramColorStateList1.setAddPaddingForCorners(false);
    this.shadowViewDelegate.setBackgroundDrawable(this.shadowDrawable);
  }
  
  void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    Object localObject = this.shapeDrawable;
    if (localObject != null) {
      DrawableCompat.setTintList((Drawable)localObject, paramColorStateList);
    }
    localObject = this.borderDrawable;
    if (localObject != null) {
      ((CircularBorderDrawable)localObject).setBorderTint(paramColorStateList);
    }
  }
  
  void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    Drawable localDrawable = this.shapeDrawable;
    if (localDrawable != null) {
      DrawableCompat.setTintMode(localDrawable, paramMode);
    }
  }
  
  final void setElevation(float paramFloat)
  {
    if (this.elevation != paramFloat)
    {
      this.elevation = paramFloat;
      onElevationsChanged(paramFloat, this.hoveredFocusedTranslationZ, this.pressedTranslationZ);
    }
  }
  
  final void setHideMotionSpec(MotionSpec paramMotionSpec)
  {
    this.hideMotionSpec = paramMotionSpec;
  }
  
  final void setHoveredFocusedTranslationZ(float paramFloat)
  {
    if (this.hoveredFocusedTranslationZ != paramFloat)
    {
      this.hoveredFocusedTranslationZ = paramFloat;
      onElevationsChanged(this.elevation, paramFloat, this.pressedTranslationZ);
    }
  }
  
  final void setImageMatrixScale(float paramFloat)
  {
    this.imageMatrixScale = paramFloat;
    Matrix localMatrix = this.tmpMatrix;
    calculateImageMatrixFromScale(paramFloat, localMatrix);
    this.view.setImageMatrix(localMatrix);
  }
  
  final void setMaxImageSize(int paramInt)
  {
    if (this.maxImageSize != paramInt)
    {
      this.maxImageSize = paramInt;
      updateImageMatrixScale();
    }
  }
  
  final void setPressedTranslationZ(float paramFloat)
  {
    if (this.pressedTranslationZ != paramFloat)
    {
      this.pressedTranslationZ = paramFloat;
      onElevationsChanged(this.elevation, this.hoveredFocusedTranslationZ, paramFloat);
    }
  }
  
  void setRippleColor(ColorStateList paramColorStateList)
  {
    Drawable localDrawable = this.rippleDrawable;
    if (localDrawable != null) {
      DrawableCompat.setTintList(localDrawable, RippleUtils.convertToRippleDrawableColor(paramColorStateList));
    }
  }
  
  final void setShowMotionSpec(MotionSpec paramMotionSpec)
  {
    this.showMotionSpec = paramMotionSpec;
  }
  
  void show(final InternalVisibilityChangedListener paramInternalVisibilityChangedListener, final boolean paramBoolean)
  {
    if (isOrWillBeShown()) {
      return;
    }
    Object localObject = this.currentAnimator;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    if (shouldAnimateVisibilityChange())
    {
      if (this.view.getVisibility() != 0)
      {
        this.view.setAlpha(0.0F);
        this.view.setScaleY(0.0F);
        this.view.setScaleX(0.0F);
        setImageMatrixScale(0.0F);
      }
      localObject = this.showMotionSpec;
      if (localObject == null) {
        localObject = getDefaultShowMotionSpec();
      }
      localObject = createAnimator((MotionSpec)localObject, 1.0F, 1.0F, 1.0F);
      ((AnimatorSet)localObject).addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          FloatingActionButtonImpl.this.animState = 0;
          FloatingActionButtonImpl.this.currentAnimator = null;
          paramAnonymousAnimator = paramInternalVisibilityChangedListener;
          if (paramAnonymousAnimator != null) {
            paramAnonymousAnimator.onShown();
          }
        }
        
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          FloatingActionButtonImpl.this.view.internalSetVisibility(0, paramBoolean);
          FloatingActionButtonImpl.this.animState = 2;
          FloatingActionButtonImpl.this.currentAnimator = paramAnonymousAnimator;
        }
      });
      paramInternalVisibilityChangedListener = this.showListeners;
      if (paramInternalVisibilityChangedListener != null)
      {
        paramInternalVisibilityChangedListener = paramInternalVisibilityChangedListener.iterator();
        while (paramInternalVisibilityChangedListener.hasNext()) {
          ((AnimatorSet)localObject).addListener((Animator.AnimatorListener)paramInternalVisibilityChangedListener.next());
        }
      }
      ((AnimatorSet)localObject).start();
      return;
    }
    this.view.internalSetVisibility(0, paramBoolean);
    this.view.setAlpha(1.0F);
    this.view.setScaleY(1.0F);
    this.view.setScaleX(1.0F);
    setImageMatrixScale(1.0F);
    if (paramInternalVisibilityChangedListener != null) {
      paramInternalVisibilityChangedListener.onShown();
    }
  }
  
  final void updateImageMatrixScale()
  {
    setImageMatrixScale(this.imageMatrixScale);
  }
  
  final void updatePadding()
  {
    Rect localRect = this.tmpRect;
    getPadding(localRect);
    onPaddingUpdated(localRect);
    this.shadowViewDelegate.setShadowPadding(localRect.left, localRect.top, localRect.right, localRect.bottom);
  }
  
  private class DisabledElevationAnimation
    extends FloatingActionButtonImpl.ShadowAnimatorImpl
  {
    DisabledElevationAnimation()
    {
      super(null);
    }
    
    protected float getTargetShadowSize()
    {
      return 0.0F;
    }
  }
  
  private class ElevateToHoveredFocusedTranslationZAnimation
    extends FloatingActionButtonImpl.ShadowAnimatorImpl
  {
    ElevateToHoveredFocusedTranslationZAnimation()
    {
      super(null);
    }
    
    protected float getTargetShadowSize()
    {
      return FloatingActionButtonImpl.this.elevation + FloatingActionButtonImpl.this.hoveredFocusedTranslationZ;
    }
  }
  
  private class ElevateToPressedTranslationZAnimation
    extends FloatingActionButtonImpl.ShadowAnimatorImpl
  {
    ElevateToPressedTranslationZAnimation()
    {
      super(null);
    }
    
    protected float getTargetShadowSize()
    {
      return FloatingActionButtonImpl.this.elevation + FloatingActionButtonImpl.this.pressedTranslationZ;
    }
  }
  
  static abstract interface InternalVisibilityChangedListener
  {
    public abstract void onHidden();
    
    public abstract void onShown();
  }
  
  private class ResetElevationAnimation
    extends FloatingActionButtonImpl.ShadowAnimatorImpl
  {
    ResetElevationAnimation()
    {
      super(null);
    }
    
    protected float getTargetShadowSize()
    {
      return FloatingActionButtonImpl.this.elevation;
    }
  }
  
  private abstract class ShadowAnimatorImpl
    extends AnimatorListenerAdapter
    implements ValueAnimator.AnimatorUpdateListener
  {
    private float shadowSizeEnd;
    private float shadowSizeStart;
    private boolean validValues;
    
    private ShadowAnimatorImpl() {}
    
    protected abstract float getTargetShadowSize();
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      FloatingActionButtonImpl.this.shadowDrawable.setShadowSize(this.shadowSizeEnd);
      this.validValues = false;
    }
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      if (!this.validValues)
      {
        this.shadowSizeStart = FloatingActionButtonImpl.this.shadowDrawable.getShadowSize();
        this.shadowSizeEnd = getTargetShadowSize();
        this.validValues = true;
      }
      ShadowDrawableWrapper localShadowDrawableWrapper = FloatingActionButtonImpl.this.shadowDrawable;
      float f = this.shadowSizeStart;
      localShadowDrawableWrapper.setShadowSize(f + (this.shadowSizeEnd - f) * paramValueAnimator.getAnimatedFraction());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\material\floatingactionbutton\FloatingActionButtonImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */