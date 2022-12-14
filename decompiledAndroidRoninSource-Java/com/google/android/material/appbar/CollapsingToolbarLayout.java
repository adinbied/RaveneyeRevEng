package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R.id;
import com.google.android.material.R.styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;

public class CollapsingToolbarLayout
  extends FrameLayout
{
  private static final int DEFAULT_SCRIM_ANIMATION_DURATION = 600;
  final CollapsingTextHelper collapsingTextHelper;
  private boolean collapsingTitleEnabled;
  private Drawable contentScrim;
  int currentOffset;
  private boolean drawCollapsingTitle;
  private View dummyView;
  private int expandedMarginBottom;
  private int expandedMarginEnd;
  private int expandedMarginStart;
  private int expandedMarginTop;
  WindowInsetsCompat lastInsets;
  private AppBarLayout.OnOffsetChangedListener onOffsetChangedListener;
  private boolean refreshToolbar = true;
  private int scrimAlpha;
  private long scrimAnimationDuration;
  private ValueAnimator scrimAnimator;
  private int scrimVisibleHeightTrigger = -1;
  private boolean scrimsAreShown;
  Drawable statusBarScrim;
  private final Rect tmpRect = new Rect();
  private Toolbar toolbar;
  private View toolbarDirectChild;
  private int toolbarId;
  
  public CollapsingToolbarLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CollapsingToolbarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CollapsingToolbarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    CollapsingTextHelper localCollapsingTextHelper = new CollapsingTextHelper(this);
    this.collapsingTextHelper = localCollapsingTextHelper;
    localCollapsingTextHelper.setTextSizeInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
    paramContext = ThemeEnforcement.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.CollapsingToolbarLayout, paramInt, com.google.android.material.R.style.Widget_Design_CollapsingToolbar, new int[0]);
    this.collapsingTextHelper.setExpandedTextGravity(paramContext.getInt(R.styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
    this.collapsingTextHelper.setCollapsedTextGravity(paramContext.getInt(R.styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
    paramInt = paramContext.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
    this.expandedMarginBottom = paramInt;
    this.expandedMarginEnd = paramInt;
    this.expandedMarginTop = paramInt;
    this.expandedMarginStart = paramInt;
    if (paramContext.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart)) {
      this.expandedMarginStart = paramContext.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
    }
    if (paramContext.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
      this.expandedMarginEnd = paramContext.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
    }
    if (paramContext.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop)) {
      this.expandedMarginTop = paramContext.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
    }
    if (paramContext.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
      this.expandedMarginBottom = paramContext.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
    }
    this.collapsingTitleEnabled = paramContext.getBoolean(R.styleable.CollapsingToolbarLayout_titleEnabled, true);
    setTitle(paramContext.getText(R.styleable.CollapsingToolbarLayout_title));
    this.collapsingTextHelper.setExpandedTextAppearance(com.google.android.material.R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
    this.collapsingTextHelper.setCollapsedTextAppearance(androidx.appcompat.R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
    if (paramContext.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
      this.collapsingTextHelper.setExpandedTextAppearance(paramContext.getResourceId(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
    }
    if (paramContext.hasValue(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
      this.collapsingTextHelper.setCollapsedTextAppearance(paramContext.getResourceId(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
    }
    this.scrimVisibleHeightTrigger = paramContext.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
    this.scrimAnimationDuration = paramContext.getInt(R.styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
    setContentScrim(paramContext.getDrawable(R.styleable.CollapsingToolbarLayout_contentScrim));
    setStatusBarScrim(paramContext.getDrawable(R.styleable.CollapsingToolbarLayout_statusBarScrim));
    this.toolbarId = paramContext.getResourceId(R.styleable.CollapsingToolbarLayout_toolbarId, -1);
    paramContext.recycle();
    setWillNotDraw(false);
    ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener()
    {
      public WindowInsetsCompat onApplyWindowInsets(View paramAnonymousView, WindowInsetsCompat paramAnonymousWindowInsetsCompat)
      {
        return CollapsingToolbarLayout.this.onWindowInsetChanged(paramAnonymousWindowInsetsCompat);
      }
    });
  }
  
  private void animateScrim(int paramInt)
  {
    ensureToolbar();
    Object localObject = this.scrimAnimator;
    if (localObject == null)
    {
      localObject = new ValueAnimator();
      this.scrimAnimator = ((ValueAnimator)localObject);
      ((ValueAnimator)localObject).setDuration(this.scrimAnimationDuration);
      ValueAnimator localValueAnimator = this.scrimAnimator;
      if (paramInt > this.scrimAlpha) {
        localObject = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
      } else {
        localObject = AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
      }
      localValueAnimator.setInterpolator((TimeInterpolator)localObject);
      this.scrimAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          CollapsingToolbarLayout.this.setScrimAlpha(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        }
      });
    }
    else if (((ValueAnimator)localObject).isRunning())
    {
      this.scrimAnimator.cancel();
    }
    this.scrimAnimator.setIntValues(new int[] { this.scrimAlpha, paramInt });
    this.scrimAnimator.start();
  }
  
  private void ensureToolbar()
  {
    if (!this.refreshToolbar) {
      return;
    }
    Object localObject2 = null;
    this.toolbar = null;
    this.toolbarDirectChild = null;
    int i = this.toolbarId;
    Object localObject1;
    if (i != -1)
    {
      localObject1 = (Toolbar)findViewById(i);
      this.toolbar = ((Toolbar)localObject1);
      if (localObject1 != null) {
        this.toolbarDirectChild = findDirectChild((View)localObject1);
      }
    }
    if (this.toolbar == null)
    {
      int j = getChildCount();
      i = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (i >= j) {
          break;
        }
        localObject1 = getChildAt(i);
        if ((localObject1 instanceof Toolbar))
        {
          localObject1 = (Toolbar)localObject1;
          break;
        }
        i += 1;
      }
      this.toolbar = ((Toolbar)localObject1);
    }
    updateDummyView();
    this.refreshToolbar = false;
  }
  
  private View findDirectChild(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    View localView = paramView;
    for (paramView = localViewParent; (paramView != this) && (paramView != null); paramView = paramView.getParent()) {
      if ((paramView instanceof View)) {
        localView = (View)paramView;
      }
    }
    return localView;
  }
  
  private static int getHeightWithMargins(View paramView)
  {
    Object localObject = paramView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      return paramView.getHeight() + ((ViewGroup.MarginLayoutParams)localObject).topMargin + ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
    }
    return paramView.getHeight();
  }
  
  static ViewOffsetHelper getViewOffsetHelper(View paramView)
  {
    ViewOffsetHelper localViewOffsetHelper2 = (ViewOffsetHelper)paramView.getTag(R.id.view_offset_helper);
    ViewOffsetHelper localViewOffsetHelper1 = localViewOffsetHelper2;
    if (localViewOffsetHelper2 == null)
    {
      localViewOffsetHelper1 = new ViewOffsetHelper(paramView);
      paramView.setTag(R.id.view_offset_helper, localViewOffsetHelper1);
    }
    return localViewOffsetHelper1;
  }
  
  private boolean isToolbarChild(View paramView)
  {
    View localView = this.toolbarDirectChild;
    if ((localView != null) && (localView != this))
    {
      if (paramView == localView) {
        return true;
      }
    }
    else if (paramView == this.toolbar) {
      return true;
    }
    return false;
  }
  
  private void updateContentDescriptionFromTitle()
  {
    setContentDescription(getTitle());
  }
  
  private void updateDummyView()
  {
    if (!this.collapsingTitleEnabled)
    {
      Object localObject = this.dummyView;
      if (localObject != null)
      {
        localObject = ((View)localObject).getParent();
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeView(this.dummyView);
        }
      }
    }
    if ((this.collapsingTitleEnabled) && (this.toolbar != null))
    {
      if (this.dummyView == null) {
        this.dummyView = new View(getContext());
      }
      if (this.dummyView.getParent() == null) {
        this.toolbar.addView(this.dummyView, -1, -1);
      }
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    ensureToolbar();
    Object localObject;
    if (this.toolbar == null)
    {
      localObject = this.contentScrim;
      if ((localObject != null) && (this.scrimAlpha > 0))
      {
        ((Drawable)localObject).mutate().setAlpha(this.scrimAlpha);
        this.contentScrim.draw(paramCanvas);
      }
    }
    if ((this.collapsingTitleEnabled) && (this.drawCollapsingTitle)) {
      this.collapsingTextHelper.draw(paramCanvas);
    }
    if ((this.statusBarScrim != null) && (this.scrimAlpha > 0))
    {
      localObject = this.lastInsets;
      int i;
      if (localObject != null) {
        i = ((WindowInsetsCompat)localObject).getSystemWindowInsetTop();
      } else {
        i = 0;
      }
      if (i > 0)
      {
        this.statusBarScrim.setBounds(0, -this.currentOffset, getWidth(), i - this.currentOffset);
        this.statusBarScrim.mutate().setAlpha(this.scrimAlpha);
        this.statusBarScrim.draw(paramCanvas);
      }
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    Drawable localDrawable = this.contentScrim;
    boolean bool = true;
    int i;
    if ((localDrawable != null) && (this.scrimAlpha > 0) && (isToolbarChild(paramView)))
    {
      this.contentScrim.mutate().setAlpha(this.scrimAlpha);
      this.contentScrim.draw(paramCanvas);
      i = 1;
    }
    else
    {
      i = 0;
    }
    if (!super.drawChild(paramCanvas, paramView, paramLong))
    {
      if (i != 0) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    Object localObject = this.statusBarScrim;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((Drawable)localObject).isStateful()) {
        bool1 = false | ((Drawable)localObject).setState(arrayOfInt);
      }
    }
    localObject = this.contentScrim;
    bool2 = bool1;
    if (localObject != null)
    {
      bool2 = bool1;
      if (((Drawable)localObject).isStateful()) {
        bool2 = bool1 | ((Drawable)localObject).setState(arrayOfInt);
      }
    }
    localObject = this.collapsingTextHelper;
    bool1 = bool2;
    if (localObject != null) {
      bool1 = bool2 | ((CollapsingTextHelper)localObject).setState(arrayOfInt);
    }
    if (bool1) {
      invalidate();
    }
  }
  
  protected LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-1, -1);
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getCollapsedTitleGravity()
  {
    return this.collapsingTextHelper.getCollapsedTextGravity();
  }
  
  public Typeface getCollapsedTitleTypeface()
  {
    return this.collapsingTextHelper.getCollapsedTypeface();
  }
  
  public Drawable getContentScrim()
  {
    return this.contentScrim;
  }
  
  public int getExpandedTitleGravity()
  {
    return this.collapsingTextHelper.getExpandedTextGravity();
  }
  
  public int getExpandedTitleMarginBottom()
  {
    return this.expandedMarginBottom;
  }
  
  public int getExpandedTitleMarginEnd()
  {
    return this.expandedMarginEnd;
  }
  
  public int getExpandedTitleMarginStart()
  {
    return this.expandedMarginStart;
  }
  
  public int getExpandedTitleMarginTop()
  {
    return this.expandedMarginTop;
  }
  
  public Typeface getExpandedTitleTypeface()
  {
    return this.collapsingTextHelper.getExpandedTypeface();
  }
  
  final int getMaxOffsetForPinChild(View paramView)
  {
    ViewOffsetHelper localViewOffsetHelper = getViewOffsetHelper(paramView);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    return getHeight() - localViewOffsetHelper.getLayoutTop() - paramView.getHeight() - localLayoutParams.bottomMargin;
  }
  
  int getScrimAlpha()
  {
    return this.scrimAlpha;
  }
  
  public long getScrimAnimationDuration()
  {
    return this.scrimAnimationDuration;
  }
  
  public int getScrimVisibleHeightTrigger()
  {
    int i = this.scrimVisibleHeightTrigger;
    if (i >= 0) {
      return i;
    }
    WindowInsetsCompat localWindowInsetsCompat = this.lastInsets;
    if (localWindowInsetsCompat != null) {
      i = localWindowInsetsCompat.getSystemWindowInsetTop();
    } else {
      i = 0;
    }
    int j = ViewCompat.getMinimumHeight(this);
    if (j > 0) {
      return Math.min(j * 2 + i, getHeight());
    }
    return getHeight() / 3;
  }
  
  public Drawable getStatusBarScrim()
  {
    return this.statusBarScrim;
  }
  
  public CharSequence getTitle()
  {
    if (this.collapsingTitleEnabled) {
      return this.collapsingTextHelper.getText();
    }
    return null;
  }
  
  public boolean isTitleEnabled()
  {
    return this.collapsingTitleEnabled;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ViewParent localViewParent = getParent();
    if ((localViewParent instanceof AppBarLayout))
    {
      ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows((View)localViewParent));
      if (this.onOffsetChangedListener == null) {
        this.onOffsetChangedListener = new OffsetUpdateListener();
      }
      ((AppBarLayout)localViewParent).addOnOffsetChangedListener(this.onOffsetChangedListener);
      ViewCompat.requestApplyInsets(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    ViewParent localViewParent = getParent();
    AppBarLayout.OnOffsetChangedListener localOnOffsetChangedListener = this.onOffsetChangedListener;
    if ((localOnOffsetChangedListener != null) && ((localViewParent instanceof AppBarLayout))) {
      ((AppBarLayout)localViewParent).removeOnOffsetChangedListener(localOnOffsetChangedListener);
    }
    super.onDetachedFromWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject = this.lastInsets;
    int m = 0;
    int j;
    int k;
    int i;
    if (localObject != null)
    {
      j = ((WindowInsetsCompat)localObject).getSystemWindowInsetTop();
      k = getChildCount();
      i = 0;
      while (i < k)
      {
        localObject = getChildAt(i);
        if ((!ViewCompat.getFitsSystemWindows((View)localObject)) && (((View)localObject).getTop() < j)) {
          ViewCompat.offsetTopAndBottom((View)localObject, j);
        }
        i += 1;
      }
    }
    if (this.collapsingTitleEnabled)
    {
      localObject = this.dummyView;
      if (localObject != null)
      {
        paramBoolean = ViewCompat.isAttachedToWindow((View)localObject);
        i = 1;
        if ((paramBoolean) && (this.dummyView.getVisibility() == 0)) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        this.drawCollapsingTitle = paramBoolean;
        if (paramBoolean)
        {
          if (ViewCompat.getLayoutDirection(this) != 1) {
            i = 0;
          }
          localObject = this.toolbarDirectChild;
          if (localObject == null) {
            localObject = this.toolbar;
          }
          int n = getMaxOffsetForPinChild((View)localObject);
          DescendantOffsetUtils.getDescendantRect(this, this.dummyView, this.tmpRect);
          localObject = this.collapsingTextHelper;
          int i1 = this.tmpRect.left;
          if (i != 0) {
            j = this.toolbar.getTitleMarginEnd();
          } else {
            j = this.toolbar.getTitleMarginStart();
          }
          int i2 = this.tmpRect.top;
          int i3 = this.toolbar.getTitleMarginTop();
          int i4 = this.tmpRect.right;
          if (i != 0) {
            k = this.toolbar.getTitleMarginStart();
          } else {
            k = this.toolbar.getTitleMarginEnd();
          }
          ((CollapsingTextHelper)localObject).setCollapsedBounds(i1 + j, i2 + n + i3, i4 + k, this.tmpRect.bottom + n - this.toolbar.getTitleMarginBottom());
          localObject = this.collapsingTextHelper;
          if (i != 0) {
            j = this.expandedMarginEnd;
          } else {
            j = this.expandedMarginStart;
          }
          k = this.tmpRect.top;
          n = this.expandedMarginTop;
          if (i != 0) {
            i = this.expandedMarginStart;
          } else {
            i = this.expandedMarginEnd;
          }
          ((CollapsingTextHelper)localObject).setExpandedBounds(j, k + n, paramInt3 - paramInt1 - i, paramInt4 - paramInt2 - this.expandedMarginBottom);
          this.collapsingTextHelper.recalculate();
        }
      }
    }
    paramInt2 = getChildCount();
    paramInt1 = m;
    while (paramInt1 < paramInt2)
    {
      getViewOffsetHelper(getChildAt(paramInt1)).onViewLayout();
      paramInt1 += 1;
    }
    if (this.toolbar != null)
    {
      if ((this.collapsingTitleEnabled) && (TextUtils.isEmpty(this.collapsingTextHelper.getText()))) {
        setTitle(this.toolbar.getTitle());
      }
      localObject = this.toolbarDirectChild;
      if ((localObject != null) && (localObject != this)) {
        setMinimumHeight(getHeightWithMargins((View)localObject));
      } else {
        setMinimumHeight(getHeightWithMargins(this.toolbar));
      }
    }
    updateScrimVisibility();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    ensureToolbar();
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt2);
    WindowInsetsCompat localWindowInsetsCompat = this.lastInsets;
    if (localWindowInsetsCompat != null) {
      paramInt2 = localWindowInsetsCompat.getSystemWindowInsetTop();
    } else {
      paramInt2 = 0;
    }
    if ((i == 0) && (paramInt2 > 0)) {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + paramInt2, 1073741824));
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Drawable localDrawable = this.contentScrim;
    if (localDrawable != null) {
      localDrawable.setBounds(0, 0, paramInt1, paramInt2);
    }
  }
  
  WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat paramWindowInsetsCompat)
  {
    WindowInsetsCompat localWindowInsetsCompat;
    if (ViewCompat.getFitsSystemWindows(this)) {
      localWindowInsetsCompat = paramWindowInsetsCompat;
    } else {
      localWindowInsetsCompat = null;
    }
    if (!ObjectsCompat.equals(this.lastInsets, localWindowInsetsCompat))
    {
      this.lastInsets = localWindowInsetsCompat;
      requestLayout();
    }
    return paramWindowInsetsCompat.consumeSystemWindowInsets();
  }
  
  public void setCollapsedTitleGravity(int paramInt)
  {
    this.collapsingTextHelper.setCollapsedTextGravity(paramInt);
  }
  
  public void setCollapsedTitleTextAppearance(int paramInt)
  {
    this.collapsingTextHelper.setCollapsedTextAppearance(paramInt);
  }
  
  public void setCollapsedTitleTextColor(int paramInt)
  {
    setCollapsedTitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setCollapsedTitleTextColor(ColorStateList paramColorStateList)
  {
    this.collapsingTextHelper.setCollapsedTextColor(paramColorStateList);
  }
  
  public void setCollapsedTitleTypeface(Typeface paramTypeface)
  {
    this.collapsingTextHelper.setCollapsedTypeface(paramTypeface);
  }
  
  public void setContentScrim(Drawable paramDrawable)
  {
    Drawable localDrawable2 = this.contentScrim;
    if (localDrawable2 != paramDrawable)
    {
      Drawable localDrawable1 = null;
      if (localDrawable2 != null) {
        localDrawable2.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable1 = paramDrawable.mutate();
      }
      this.contentScrim = localDrawable1;
      if (localDrawable1 != null)
      {
        localDrawable1.setBounds(0, 0, getWidth(), getHeight());
        this.contentScrim.setCallback(this);
        this.contentScrim.setAlpha(this.scrimAlpha);
      }
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void setContentScrimColor(int paramInt)
  {
    setContentScrim(new ColorDrawable(paramInt));
  }
  
  public void setContentScrimResource(int paramInt)
  {
    setContentScrim(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setExpandedTitleColor(int paramInt)
  {
    setExpandedTitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setExpandedTitleGravity(int paramInt)
  {
    this.collapsingTextHelper.setExpandedTextGravity(paramInt);
  }
  
  public void setExpandedTitleMargin(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.expandedMarginStart = paramInt1;
    this.expandedMarginTop = paramInt2;
    this.expandedMarginEnd = paramInt3;
    this.expandedMarginBottom = paramInt4;
    requestLayout();
  }
  
  public void setExpandedTitleMarginBottom(int paramInt)
  {
    this.expandedMarginBottom = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginEnd(int paramInt)
  {
    this.expandedMarginEnd = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginStart(int paramInt)
  {
    this.expandedMarginStart = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginTop(int paramInt)
  {
    this.expandedMarginTop = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleTextAppearance(int paramInt)
  {
    this.collapsingTextHelper.setExpandedTextAppearance(paramInt);
  }
  
  public void setExpandedTitleTextColor(ColorStateList paramColorStateList)
  {
    this.collapsingTextHelper.setExpandedTextColor(paramColorStateList);
  }
  
  public void setExpandedTitleTypeface(Typeface paramTypeface)
  {
    this.collapsingTextHelper.setExpandedTypeface(paramTypeface);
  }
  
  void setScrimAlpha(int paramInt)
  {
    if (paramInt != this.scrimAlpha)
    {
      if (this.contentScrim != null)
      {
        Toolbar localToolbar = this.toolbar;
        if (localToolbar != null) {
          ViewCompat.postInvalidateOnAnimation(localToolbar);
        }
      }
      this.scrimAlpha = paramInt;
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void setScrimAnimationDuration(long paramLong)
  {
    this.scrimAnimationDuration = paramLong;
  }
  
  public void setScrimVisibleHeightTrigger(int paramInt)
  {
    if (this.scrimVisibleHeightTrigger != paramInt)
    {
      this.scrimVisibleHeightTrigger = paramInt;
      updateScrimVisibility();
    }
  }
  
  public void setScrimsShown(boolean paramBoolean)
  {
    boolean bool;
    if ((ViewCompat.isLaidOut(this)) && (!isInEditMode())) {
      bool = true;
    } else {
      bool = false;
    }
    setScrimsShown(paramBoolean, bool);
  }
  
  public void setScrimsShown(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.scrimsAreShown != paramBoolean1)
    {
      int i = 255;
      if (paramBoolean2)
      {
        if (!paramBoolean1) {
          i = 0;
        }
        animateScrim(i);
      }
      else
      {
        if (!paramBoolean1) {
          i = 0;
        }
        setScrimAlpha(i);
      }
      this.scrimsAreShown = paramBoolean1;
    }
  }
  
  public void setStatusBarScrim(Drawable paramDrawable)
  {
    Drawable localDrawable2 = this.statusBarScrim;
    if (localDrawable2 != paramDrawable)
    {
      Drawable localDrawable1 = null;
      if (localDrawable2 != null) {
        localDrawable2.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable1 = paramDrawable.mutate();
      }
      this.statusBarScrim = localDrawable1;
      if (localDrawable1 != null)
      {
        if (localDrawable1.isStateful()) {
          this.statusBarScrim.setState(getDrawableState());
        }
        DrawableCompat.setLayoutDirection(this.statusBarScrim, ViewCompat.getLayoutDirection(this));
        paramDrawable = this.statusBarScrim;
        boolean bool;
        if (getVisibility() == 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramDrawable.setVisible(bool, false);
        this.statusBarScrim.setCallback(this);
        this.statusBarScrim.setAlpha(this.scrimAlpha);
      }
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void setStatusBarScrimColor(int paramInt)
  {
    setStatusBarScrim(new ColorDrawable(paramInt));
  }
  
  public void setStatusBarScrimResource(int paramInt)
  {
    setStatusBarScrim(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.collapsingTextHelper.setText(paramCharSequence);
    updateContentDescriptionFromTitle();
  }
  
  public void setTitleEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.collapsingTitleEnabled)
    {
      this.collapsingTitleEnabled = paramBoolean;
      updateContentDescriptionFromTitle();
      updateDummyView();
      requestLayout();
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    Drawable localDrawable = this.statusBarScrim;
    if ((localDrawable != null) && (localDrawable.isVisible() != bool)) {
      this.statusBarScrim.setVisible(bool, false);
    }
    localDrawable = this.contentScrim;
    if ((localDrawable != null) && (localDrawable.isVisible() != bool)) {
      this.contentScrim.setVisible(bool, false);
    }
  }
  
  final void updateScrimVisibility()
  {
    if ((this.contentScrim != null) || (this.statusBarScrim != null))
    {
      boolean bool;
      if (getHeight() + this.currentOffset < getScrimVisibleHeightTrigger()) {
        bool = true;
      } else {
        bool = false;
      }
      setScrimsShown(bool);
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.contentScrim) || (paramDrawable == this.statusBarScrim);
  }
  
  public static class LayoutParams
    extends FrameLayout.LayoutParams
  {
    public static final int COLLAPSE_MODE_OFF = 0;
    public static final int COLLAPSE_MODE_PARALLAX = 2;
    public static final int COLLAPSE_MODE_PIN = 1;
    private static final float DEFAULT_PARALLAX_MULTIPLIER = 0.5F;
    int collapseMode = 0;
    float parallaxMult = 0.5F;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(int paramInt1, int paramInt2, int paramInt3)
    {
      super(paramInt2, paramInt3);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CollapsingToolbarLayout_Layout);
      this.collapseMode = paramContext.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
      setParallaxMultiplier(paramContext.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5F));
      paramContext.recycle();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public LayoutParams(FrameLayout.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public int getCollapseMode()
    {
      return this.collapseMode;
    }
    
    public float getParallaxMultiplier()
    {
      return this.parallaxMult;
    }
    
    public void setCollapseMode(int paramInt)
    {
      this.collapseMode = paramInt;
    }
    
    public void setParallaxMultiplier(float paramFloat)
    {
      this.parallaxMult = paramFloat;
    }
  }
  
  private class OffsetUpdateListener
    implements AppBarLayout.OnOffsetChangedListener
  {
    OffsetUpdateListener() {}
    
    public void onOffsetChanged(AppBarLayout paramAppBarLayout, int paramInt)
    {
      CollapsingToolbarLayout.this.currentOffset = paramInt;
      int i;
      if (CollapsingToolbarLayout.this.lastInsets != null) {
        i = CollapsingToolbarLayout.this.lastInsets.getSystemWindowInsetTop();
      } else {
        i = 0;
      }
      int k = CollapsingToolbarLayout.this.getChildCount();
      int j = 0;
      while (j < k)
      {
        paramAppBarLayout = CollapsingToolbarLayout.this.getChildAt(j);
        CollapsingToolbarLayout.LayoutParams localLayoutParams = (CollapsingToolbarLayout.LayoutParams)paramAppBarLayout.getLayoutParams();
        ViewOffsetHelper localViewOffsetHelper = CollapsingToolbarLayout.getViewOffsetHelper(paramAppBarLayout);
        int m = localLayoutParams.collapseMode;
        if (m != 1)
        {
          if (m == 2) {
            localViewOffsetHelper.setTopAndBottomOffset(Math.round(-paramInt * localLayoutParams.parallaxMult));
          }
        }
        else {
          localViewOffsetHelper.setTopAndBottomOffset(MathUtils.clamp(-paramInt, 0, CollapsingToolbarLayout.this.getMaxOffsetForPinChild(paramAppBarLayout)));
        }
        j += 1;
      }
      CollapsingToolbarLayout.this.updateScrimVisibility();
      if ((CollapsingToolbarLayout.this.statusBarScrim != null) && (i > 0)) {
        ViewCompat.postInvalidateOnAnimation(CollapsingToolbarLayout.this);
      }
      j = CollapsingToolbarLayout.this.getHeight();
      k = ViewCompat.getMinimumHeight(CollapsingToolbarLayout.this);
      CollapsingToolbarLayout.this.collapsingTextHelper.setExpansionFraction(Math.abs(paramInt) / (j - k - i));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\material\appbar\CollapsingToolbarLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */