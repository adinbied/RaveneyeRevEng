package com.google.android.material.snackbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat.TouchExplorationStateChangeListener;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.layout;
import com.google.android.material.R.styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener;
import com.google.android.material.internal.ThemeEnforcement;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>>
{
  static final int ANIMATION_DURATION = 250;
  static final int ANIMATION_FADE_DURATION = 180;
  public static final int LENGTH_INDEFINITE = -2;
  public static final int LENGTH_LONG = 0;
  public static final int LENGTH_SHORT = -1;
  static final int MSG_DISMISS = 1;
  static final int MSG_SHOW = 0;
  private static final int[] SNACKBAR_STYLE_ATTR = { R.attr.snackbarStyle };
  private static final boolean USE_OFFSET_API;
  static final Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      int i = paramAnonymousMessage.what;
      if (i != 0)
      {
        if (i != 1) {
          return false;
        }
        ((BaseTransientBottomBar)paramAnonymousMessage.obj).hideView(paramAnonymousMessage.arg1);
        return true;
      }
      ((BaseTransientBottomBar)paramAnonymousMessage.obj).showView();
      return true;
    }
  });
  private final AccessibilityManager accessibilityManager;
  private Behavior behavior;
  private List<BaseCallback<B>> callbacks;
  private final ContentViewCallback contentViewCallback;
  private final Context context;
  private int duration;
  final SnackbarManager.Callback managerCallback = new SnackbarManager.Callback()
  {
    public void dismiss(int paramAnonymousInt)
    {
      BaseTransientBottomBar.handler.sendMessage(BaseTransientBottomBar.handler.obtainMessage(1, paramAnonymousInt, 0, BaseTransientBottomBar.this));
    }
    
    public void show()
    {
      BaseTransientBottomBar.handler.sendMessage(BaseTransientBottomBar.handler.obtainMessage(0, BaseTransientBottomBar.this));
    }
  };
  private final ViewGroup targetParent;
  protected final SnackbarBaseLayout view;
  
  static
  {
    boolean bool;
    if ((Build.VERSION.SDK_INT >= 16) && (Build.VERSION.SDK_INT <= 19)) {
      bool = true;
    } else {
      bool = false;
    }
    USE_OFFSET_API = bool;
  }
  
  protected BaseTransientBottomBar(ViewGroup paramViewGroup, View paramView, ContentViewCallback paramContentViewCallback)
  {
    if (paramViewGroup != null)
    {
      if (paramView != null)
      {
        if (paramContentViewCallback != null)
        {
          this.targetParent = paramViewGroup;
          this.contentViewCallback = paramContentViewCallback;
          paramViewGroup = paramViewGroup.getContext();
          this.context = paramViewGroup;
          ThemeEnforcement.checkAppCompatTheme(paramViewGroup);
          paramViewGroup = (SnackbarBaseLayout)LayoutInflater.from(this.context).inflate(getSnackbarBaseLayoutResId(), this.targetParent, false);
          this.view = paramViewGroup;
          paramViewGroup.addView(paramView);
          ViewCompat.setAccessibilityLiveRegion(this.view, 1);
          ViewCompat.setImportantForAccessibility(this.view, 1);
          ViewCompat.setFitsSystemWindows(this.view, true);
          ViewCompat.setOnApplyWindowInsetsListener(this.view, new OnApplyWindowInsetsListener()
          {
            public WindowInsetsCompat onApplyWindowInsets(View paramAnonymousView, WindowInsetsCompat paramAnonymousWindowInsetsCompat)
            {
              paramAnonymousView.setPadding(paramAnonymousView.getPaddingLeft(), paramAnonymousView.getPaddingTop(), paramAnonymousView.getPaddingRight(), paramAnonymousWindowInsetsCompat.getSystemWindowInsetBottom());
              return paramAnonymousWindowInsetsCompat;
            }
          });
          ViewCompat.setAccessibilityDelegate(this.view, new AccessibilityDelegateCompat()
          {
            public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfoCompat paramAnonymousAccessibilityNodeInfoCompat)
            {
              super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfoCompat);
              paramAnonymousAccessibilityNodeInfoCompat.addAction(1048576);
              paramAnonymousAccessibilityNodeInfoCompat.setDismissable(true);
            }
            
            public boolean performAccessibilityAction(View paramAnonymousView, int paramAnonymousInt, Bundle paramAnonymousBundle)
            {
              if (paramAnonymousInt == 1048576)
              {
                BaseTransientBottomBar.this.dismiss();
                return true;
              }
              return super.performAccessibilityAction(paramAnonymousView, paramAnonymousInt, paramAnonymousBundle);
            }
          });
          this.accessibilityManager = ((AccessibilityManager)this.context.getSystemService("accessibility"));
          return;
        }
        throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
      }
      throw new IllegalArgumentException("Transient bottom bar must have non-null content");
    }
    throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
  }
  
  private void animateViewOut(final int paramInt)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setIntValues(new int[] { 0, getTranslationYBottom() });
    localValueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    localValueAnimator.setDuration(250L);
    localValueAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        BaseTransientBottomBar.this.onViewHidden(paramInt);
      }
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        BaseTransientBottomBar.this.contentViewCallback.animateContentOut(0, 180);
      }
    });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      private int previousAnimatedIntValue = 0;
      
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        if (BaseTransientBottomBar.USE_OFFSET_API) {
          ViewCompat.offsetTopAndBottom(BaseTransientBottomBar.this.view, i - this.previousAnimatedIntValue);
        } else {
          BaseTransientBottomBar.this.view.setTranslationY(i);
        }
        this.previousAnimatedIntValue = i;
      }
    });
    localValueAnimator.start();
  }
  
  private int getTranslationYBottom()
  {
    int j = this.view.getHeight();
    ViewGroup.LayoutParams localLayoutParams = this.view.getLayoutParams();
    int i = j;
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      i = j + ((ViewGroup.MarginLayoutParams)localLayoutParams).bottomMargin;
    }
    return i;
  }
  
  public B addCallback(BaseCallback<B> paramBaseCallback)
  {
    if (paramBaseCallback == null) {
      return this;
    }
    if (this.callbacks == null) {
      this.callbacks = new ArrayList();
    }
    this.callbacks.add(paramBaseCallback);
    return this;
  }
  
  void animateViewIn()
  {
    final int i = getTranslationYBottom();
    if (USE_OFFSET_API) {
      ViewCompat.offsetTopAndBottom(this.view, i);
    } else {
      this.view.setTranslationY(i);
    }
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setIntValues(new int[] { i, 0 });
    localValueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    localValueAnimator.setDuration(250L);
    localValueAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        BaseTransientBottomBar.this.onViewShown();
      }
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        BaseTransientBottomBar.this.contentViewCallback.animateContentIn(70, 180);
      }
    });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      private int previousAnimatedIntValue = i;
      
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        if (BaseTransientBottomBar.USE_OFFSET_API) {
          ViewCompat.offsetTopAndBottom(BaseTransientBottomBar.this.view, i - this.previousAnimatedIntValue);
        } else {
          BaseTransientBottomBar.this.view.setTranslationY(i);
        }
        this.previousAnimatedIntValue = i;
      }
    });
    localValueAnimator.start();
  }
  
  public void dismiss()
  {
    dispatchDismiss(3);
  }
  
  protected void dispatchDismiss(int paramInt)
  {
    SnackbarManager.getInstance().dismiss(this.managerCallback, paramInt);
  }
  
  public Behavior getBehavior()
  {
    return this.behavior;
  }
  
  public Context getContext()
  {
    return this.context;
  }
  
  public int getDuration()
  {
    return this.duration;
  }
  
  protected SwipeDismissBehavior<? extends View> getNewBehavior()
  {
    return new Behavior();
  }
  
  protected int getSnackbarBaseLayoutResId()
  {
    if (hasSnackbarStyleAttr()) {
      return R.layout.mtrl_layout_snackbar;
    }
    return R.layout.design_layout_snackbar;
  }
  
  public View getView()
  {
    return this.view;
  }
  
  protected boolean hasSnackbarStyleAttr()
  {
    TypedArray localTypedArray = this.context.obtainStyledAttributes(SNACKBAR_STYLE_ATTR);
    boolean bool = false;
    int i = localTypedArray.getResourceId(0, -1);
    localTypedArray.recycle();
    if (i != -1) {
      bool = true;
    }
    return bool;
  }
  
  final void hideView(int paramInt)
  {
    if ((shouldAnimate()) && (this.view.getVisibility() == 0))
    {
      animateViewOut(paramInt);
      return;
    }
    onViewHidden(paramInt);
  }
  
  public boolean isShown()
  {
    return SnackbarManager.getInstance().isCurrent(this.managerCallback);
  }
  
  public boolean isShownOrQueued()
  {
    return SnackbarManager.getInstance().isCurrentOrNext(this.managerCallback);
  }
  
  void onViewHidden(int paramInt)
  {
    SnackbarManager.getInstance().onDismissed(this.managerCallback);
    Object localObject = this.callbacks;
    if (localObject != null)
    {
      int i = ((List)localObject).size() - 1;
      while (i >= 0)
      {
        ((BaseCallback)this.callbacks.get(i)).onDismissed(this, paramInt);
        i -= 1;
      }
    }
    localObject = this.view.getParent();
    if ((localObject instanceof ViewGroup)) {
      ((ViewGroup)localObject).removeView(this.view);
    }
  }
  
  void onViewShown()
  {
    SnackbarManager.getInstance().onShown(this.managerCallback);
    List localList = this.callbacks;
    if (localList != null)
    {
      int i = localList.size() - 1;
      while (i >= 0)
      {
        ((BaseCallback)this.callbacks.get(i)).onShown(this);
        i -= 1;
      }
    }
  }
  
  public B removeCallback(BaseCallback<B> paramBaseCallback)
  {
    if (paramBaseCallback == null) {
      return this;
    }
    List localList = this.callbacks;
    if (localList == null) {
      return this;
    }
    localList.remove(paramBaseCallback);
    return this;
  }
  
  public B setBehavior(Behavior paramBehavior)
  {
    this.behavior = paramBehavior;
    return this;
  }
  
  public B setDuration(int paramInt)
  {
    this.duration = paramInt;
    return this;
  }
  
  boolean shouldAnimate()
  {
    List localList = this.accessibilityManager.getEnabledAccessibilityServiceList(1);
    return (localList != null) && (localList.isEmpty());
  }
  
  public void show()
  {
    SnackbarManager.getInstance().show(getDuration(), this.managerCallback);
  }
  
  final void showView()
  {
    if (this.view.getParent() == null)
    {
      Object localObject = this.view.getLayoutParams();
      if ((localObject instanceof CoordinatorLayout.LayoutParams))
      {
        CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)localObject;
        Behavior localBehavior = this.behavior;
        localObject = localBehavior;
        if (localBehavior == null) {
          localObject = getNewBehavior();
        }
        if ((localObject instanceof Behavior)) {
          ((Behavior)localObject).setBaseTransientBottomBar(this);
        }
        ((SwipeDismissBehavior)localObject).setListener(new SwipeDismissBehavior.OnDismissListener()
        {
          public void onDismiss(View paramAnonymousView)
          {
            paramAnonymousView.setVisibility(8);
            BaseTransientBottomBar.this.dispatchDismiss(0);
          }
          
          public void onDragStateChanged(int paramAnonymousInt)
          {
            if (paramAnonymousInt != 0)
            {
              if ((paramAnonymousInt != 1) && (paramAnonymousInt != 2)) {
                return;
              }
              SnackbarManager.getInstance().pauseTimeout(BaseTransientBottomBar.this.managerCallback);
              return;
            }
            SnackbarManager.getInstance().restoreTimeoutIfPaused(BaseTransientBottomBar.this.managerCallback);
          }
        });
        localLayoutParams.setBehavior((CoordinatorLayout.Behavior)localObject);
        localLayoutParams.insetEdge = 80;
      }
      this.targetParent.addView(this.view);
    }
    this.view.setOnAttachStateChangeListener(new OnAttachStateChangeListener()
    {
      public void onViewAttachedToWindow(View paramAnonymousView) {}
      
      public void onViewDetachedFromWindow(View paramAnonymousView)
      {
        if (BaseTransientBottomBar.this.isShownOrQueued()) {
          BaseTransientBottomBar.handler.post(new Runnable()
          {
            public void run()
            {
              BaseTransientBottomBar.this.onViewHidden(3);
            }
          });
        }
      }
    });
    if (ViewCompat.isLaidOut(this.view))
    {
      if (shouldAnimate())
      {
        animateViewIn();
        return;
      }
      onViewShown();
      return;
    }
    this.view.setOnLayoutChangeListener(new OnLayoutChangeListener()
    {
      public void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        BaseTransientBottomBar.this.view.setOnLayoutChangeListener(null);
        if (BaseTransientBottomBar.this.shouldAnimate())
        {
          BaseTransientBottomBar.this.animateViewIn();
          return;
        }
        BaseTransientBottomBar.this.onViewShown();
      }
    });
  }
  
  public static abstract class BaseCallback<B>
  {
    public static final int DISMISS_EVENT_ACTION = 1;
    public static final int DISMISS_EVENT_CONSECUTIVE = 4;
    public static final int DISMISS_EVENT_MANUAL = 3;
    public static final int DISMISS_EVENT_SWIPE = 0;
    public static final int DISMISS_EVENT_TIMEOUT = 2;
    
    public void onDismissed(B paramB, int paramInt) {}
    
    public void onShown(B paramB) {}
    
    @Retention(RetentionPolicy.SOURCE)
    public static @interface DismissEvent {}
  }
  
  public static class Behavior
    extends SwipeDismissBehavior<View>
  {
    private final BaseTransientBottomBar.BehaviorDelegate delegate = new BaseTransientBottomBar.BehaviorDelegate(this);
    
    private void setBaseTransientBottomBar(BaseTransientBottomBar<?> paramBaseTransientBottomBar)
    {
      this.delegate.setBaseTransientBottomBar(paramBaseTransientBottomBar);
    }
    
    public boolean canSwipeDismissView(View paramView)
    {
      return this.delegate.canSwipeDismissView(paramView);
    }
    
    public boolean onInterceptTouchEvent(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
    {
      this.delegate.onInterceptTouchEvent(paramCoordinatorLayout, paramView, paramMotionEvent);
      return super.onInterceptTouchEvent(paramCoordinatorLayout, paramView, paramMotionEvent);
    }
  }
  
  public static class BehaviorDelegate
  {
    private SnackbarManager.Callback managerCallback;
    
    public BehaviorDelegate(SwipeDismissBehavior<?> paramSwipeDismissBehavior)
    {
      paramSwipeDismissBehavior.setStartAlphaSwipeDistance(0.1F);
      paramSwipeDismissBehavior.setEndAlphaSwipeDistance(0.6F);
      paramSwipeDismissBehavior.setSwipeDirection(0);
    }
    
    public boolean canSwipeDismissView(View paramView)
    {
      return paramView instanceof BaseTransientBottomBar.SnackbarBaseLayout;
    }
    
    public void onInterceptTouchEvent(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
    {
      int i = paramMotionEvent.getActionMasked();
      if (i != 0)
      {
        if ((i != 1) && (i != 3)) {
          return;
        }
        SnackbarManager.getInstance().restoreTimeoutIfPaused(this.managerCallback);
        return;
      }
      if (paramCoordinatorLayout.isPointInChildBounds(paramView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
        SnackbarManager.getInstance().pauseTimeout(this.managerCallback);
      }
    }
    
    public void setBaseTransientBottomBar(BaseTransientBottomBar<?> paramBaseTransientBottomBar)
    {
      this.managerCallback = paramBaseTransientBottomBar.managerCallback;
    }
  }
  
  @Deprecated
  public static abstract interface ContentViewCallback
    extends ContentViewCallback
  {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Duration {}
  
  protected static abstract interface OnAttachStateChangeListener
  {
    public abstract void onViewAttachedToWindow(View paramView);
    
    public abstract void onViewDetachedFromWindow(View paramView);
  }
  
  protected static abstract interface OnLayoutChangeListener
  {
    public abstract void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
  
  protected static class SnackbarBaseLayout
    extends FrameLayout
  {
    private final AccessibilityManager accessibilityManager;
    private BaseTransientBottomBar.OnAttachStateChangeListener onAttachStateChangeListener;
    private BaseTransientBottomBar.OnLayoutChangeListener onLayoutChangeListener;
    private final AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener;
    
    protected SnackbarBaseLayout(Context paramContext)
    {
      this(paramContext, null);
    }
    
    protected SnackbarBaseLayout(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SnackbarLayout);
      if (paramAttributeSet.hasValue(R.styleable.SnackbarLayout_elevation)) {
        ViewCompat.setElevation(this, paramAttributeSet.getDimensionPixelSize(R.styleable.SnackbarLayout_elevation, 0));
      }
      paramAttributeSet.recycle();
      this.accessibilityManager = ((AccessibilityManager)paramContext.getSystemService("accessibility"));
      paramContext = new AccessibilityManagerCompat.TouchExplorationStateChangeListener()
      {
        public void onTouchExplorationStateChanged(boolean paramAnonymousBoolean)
        {
          BaseTransientBottomBar.SnackbarBaseLayout.this.setClickableOrFocusableBasedOnAccessibility(paramAnonymousBoolean);
        }
      };
      this.touchExplorationStateChangeListener = paramContext;
      AccessibilityManagerCompat.addTouchExplorationStateChangeListener(this.accessibilityManager, paramContext);
      setClickableOrFocusableBasedOnAccessibility(this.accessibilityManager.isTouchExplorationEnabled());
    }
    
    private void setClickableOrFocusableBasedOnAccessibility(boolean paramBoolean)
    {
      setClickable(paramBoolean ^ true);
      setFocusable(paramBoolean);
    }
    
    protected void onAttachedToWindow()
    {
      super.onAttachedToWindow();
      BaseTransientBottomBar.OnAttachStateChangeListener localOnAttachStateChangeListener = this.onAttachStateChangeListener;
      if (localOnAttachStateChangeListener != null) {
        localOnAttachStateChangeListener.onViewAttachedToWindow(this);
      }
      ViewCompat.requestApplyInsets(this);
    }
    
    protected void onDetachedFromWindow()
    {
      super.onDetachedFromWindow();
      BaseTransientBottomBar.OnAttachStateChangeListener localOnAttachStateChangeListener = this.onAttachStateChangeListener;
      if (localOnAttachStateChangeListener != null) {
        localOnAttachStateChangeListener.onViewDetachedFromWindow(this);
      }
      AccessibilityManagerCompat.removeTouchExplorationStateChangeListener(this.accessibilityManager, this.touchExplorationStateChangeListener);
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      BaseTransientBottomBar.OnLayoutChangeListener localOnLayoutChangeListener = this.onLayoutChangeListener;
      if (localOnLayoutChangeListener != null) {
        localOnLayoutChangeListener.onLayoutChange(this, paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
    
    void setOnAttachStateChangeListener(BaseTransientBottomBar.OnAttachStateChangeListener paramOnAttachStateChangeListener)
    {
      this.onAttachStateChangeListener = paramOnAttachStateChangeListener;
    }
    
    void setOnLayoutChangeListener(BaseTransientBottomBar.OnLayoutChangeListener paramOnLayoutChangeListener)
    {
      this.onLayoutChangeListener = paramOnLayoutChangeListener;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\material\snackbar\BaseTransientBottomBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */