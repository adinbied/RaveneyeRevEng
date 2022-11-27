package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R.attr;
import com.google.android.material.R.color;
import com.google.android.material.R.dimen;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;
import com.google.android.material.R.string;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public class TextInputLayout
  extends LinearLayout
{
  public static final int BOX_BACKGROUND_FILLED = 1;
  public static final int BOX_BACKGROUND_NONE = 0;
  public static final int BOX_BACKGROUND_OUTLINE = 2;
  private static final int INVALID_MAX_LENGTH = -1;
  private static final int LABEL_SCALE_ANIMATION_DURATION = 167;
  private static final String LOG_TAG = "TextInputLayout";
  private ValueAnimator animator;
  private GradientDrawable boxBackground;
  private int boxBackgroundColor;
  private int boxBackgroundMode;
  private final int boxBottomOffsetPx;
  private final int boxCollapsedPaddingTopPx;
  private float boxCornerRadiusBottomEnd;
  private float boxCornerRadiusBottomStart;
  private float boxCornerRadiusTopEnd;
  private float boxCornerRadiusTopStart;
  private final int boxLabelCutoutPaddingPx;
  private int boxStrokeColor;
  private final int boxStrokeWidthDefaultPx;
  private final int boxStrokeWidthFocusedPx;
  private int boxStrokeWidthPx;
  final CollapsingTextHelper collapsingTextHelper = new CollapsingTextHelper(this);
  boolean counterEnabled;
  private int counterMaxLength;
  private final int counterOverflowTextAppearance;
  private boolean counterOverflowed;
  private final int counterTextAppearance;
  private TextView counterView;
  private ColorStateList defaultHintTextColor;
  private final int defaultStrokeColor;
  private final int disabledColor;
  EditText editText;
  private Drawable editTextOriginalDrawable;
  private int focusedStrokeColor;
  private ColorStateList focusedTextColor;
  private boolean hasPasswordToggleTintList;
  private boolean hasPasswordToggleTintMode;
  private boolean hasReconstructedEditTextBackground;
  private CharSequence hint;
  private boolean hintAnimationEnabled;
  private boolean hintEnabled;
  private boolean hintExpanded;
  private final int hoveredStrokeColor;
  private boolean inDrawableStateChanged;
  private final IndicatorViewController indicatorViewController = new IndicatorViewController(this);
  private final FrameLayout inputFrame;
  private boolean isProvidingHint;
  private Drawable originalEditTextEndDrawable;
  private CharSequence originalHint;
  private CharSequence passwordToggleContentDesc;
  private Drawable passwordToggleDrawable;
  private Drawable passwordToggleDummyDrawable;
  private boolean passwordToggleEnabled;
  private ColorStateList passwordToggleTintList;
  private PorterDuff.Mode passwordToggleTintMode;
  private CheckableImageButton passwordToggleView;
  private boolean passwordToggledVisible;
  private boolean restoringSavedState;
  private final Rect tmpRect = new Rect();
  private final RectF tmpRectF = new RectF();
  private Typeface typeface;
  
  public TextInputLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.textInputStyle);
  }
  
  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(1);
    setWillNotDraw(false);
    setAddStatesFromChildren(true);
    Object localObject = new FrameLayout(paramContext);
    this.inputFrame = ((FrameLayout)localObject);
    ((FrameLayout)localObject).setAddStatesFromChildren(true);
    addView(this.inputFrame);
    this.collapsingTextHelper.setTextSizeInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
    this.collapsingTextHelper.setPositionInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
    this.collapsingTextHelper.setCollapsedTextGravity(8388659);
    paramAttributeSet = ThemeEnforcement.obtainTintedStyledAttributes(paramContext, paramAttributeSet, R.styleable.TextInputLayout, paramInt, R.style.Widget_Design_TextInputLayout, new int[0]);
    this.hintEnabled = paramAttributeSet.getBoolean(R.styleable.TextInputLayout_hintEnabled, true);
    setHint(paramAttributeSet.getText(R.styleable.TextInputLayout_android_hint));
    this.hintAnimationEnabled = paramAttributeSet.getBoolean(R.styleable.TextInputLayout_hintAnimationEnabled, true);
    this.boxBottomOffsetPx = paramContext.getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_box_bottom_offset);
    this.boxLabelCutoutPaddingPx = paramContext.getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_box_label_cutout_padding);
    this.boxCollapsedPaddingTopPx = paramAttributeSet.getDimensionPixelOffset(R.styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
    this.boxCornerRadiusTopStart = paramAttributeSet.getDimension(R.styleable.TextInputLayout_boxCornerRadiusTopStart, 0.0F);
    this.boxCornerRadiusTopEnd = paramAttributeSet.getDimension(R.styleable.TextInputLayout_boxCornerRadiusTopEnd, 0.0F);
    this.boxCornerRadiusBottomEnd = paramAttributeSet.getDimension(R.styleable.TextInputLayout_boxCornerRadiusBottomEnd, 0.0F);
    this.boxCornerRadiusBottomStart = paramAttributeSet.getDimension(R.styleable.TextInputLayout_boxCornerRadiusBottomStart, 0.0F);
    this.boxBackgroundColor = paramAttributeSet.getColor(R.styleable.TextInputLayout_boxBackgroundColor, 0);
    this.focusedStrokeColor = paramAttributeSet.getColor(R.styleable.TextInputLayout_boxStrokeColor, 0);
    this.boxStrokeWidthDefaultPx = paramContext.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_default);
    this.boxStrokeWidthFocusedPx = paramContext.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_focused);
    this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
    setBoxBackgroundMode(paramAttributeSet.getInt(R.styleable.TextInputLayout_boxBackgroundMode, 0));
    if (paramAttributeSet.hasValue(R.styleable.TextInputLayout_android_textColorHint))
    {
      localObject = paramAttributeSet.getColorStateList(R.styleable.TextInputLayout_android_textColorHint);
      this.focusedTextColor = ((ColorStateList)localObject);
      this.defaultHintTextColor = ((ColorStateList)localObject);
    }
    this.defaultStrokeColor = ContextCompat.getColor(paramContext, R.color.mtrl_textinput_default_box_stroke_color);
    this.disabledColor = ContextCompat.getColor(paramContext, R.color.mtrl_textinput_disabled_color);
    this.hoveredStrokeColor = ContextCompat.getColor(paramContext, R.color.mtrl_textinput_hovered_box_stroke_color);
    if (paramAttributeSet.getResourceId(R.styleable.TextInputLayout_hintTextAppearance, -1) != -1) {
      setHintTextAppearance(paramAttributeSet.getResourceId(R.styleable.TextInputLayout_hintTextAppearance, 0));
    }
    paramInt = paramAttributeSet.getResourceId(R.styleable.TextInputLayout_errorTextAppearance, 0);
    boolean bool1 = paramAttributeSet.getBoolean(R.styleable.TextInputLayout_errorEnabled, false);
    int i = paramAttributeSet.getResourceId(R.styleable.TextInputLayout_helperTextTextAppearance, 0);
    boolean bool2 = paramAttributeSet.getBoolean(R.styleable.TextInputLayout_helperTextEnabled, false);
    paramContext = paramAttributeSet.getText(R.styleable.TextInputLayout_helperText);
    boolean bool3 = paramAttributeSet.getBoolean(R.styleable.TextInputLayout_counterEnabled, false);
    setCounterMaxLength(paramAttributeSet.getInt(R.styleable.TextInputLayout_counterMaxLength, -1));
    this.counterTextAppearance = paramAttributeSet.getResourceId(R.styleable.TextInputLayout_counterTextAppearance, 0);
    this.counterOverflowTextAppearance = paramAttributeSet.getResourceId(R.styleable.TextInputLayout_counterOverflowTextAppearance, 0);
    this.passwordToggleEnabled = paramAttributeSet.getBoolean(R.styleable.TextInputLayout_passwordToggleEnabled, false);
    this.passwordToggleDrawable = paramAttributeSet.getDrawable(R.styleable.TextInputLayout_passwordToggleDrawable);
    this.passwordToggleContentDesc = paramAttributeSet.getText(R.styleable.TextInputLayout_passwordToggleContentDescription);
    if (paramAttributeSet.hasValue(R.styleable.TextInputLayout_passwordToggleTint))
    {
      this.hasPasswordToggleTintList = true;
      this.passwordToggleTintList = paramAttributeSet.getColorStateList(R.styleable.TextInputLayout_passwordToggleTint);
    }
    if (paramAttributeSet.hasValue(R.styleable.TextInputLayout_passwordToggleTintMode))
    {
      this.hasPasswordToggleTintMode = true;
      this.passwordToggleTintMode = ViewUtils.parseTintMode(paramAttributeSet.getInt(R.styleable.TextInputLayout_passwordToggleTintMode, -1), null);
    }
    paramAttributeSet.recycle();
    setHelperTextEnabled(bool2);
    setHelperText(paramContext);
    setHelperTextTextAppearance(i);
    setErrorEnabled(bool1);
    setErrorTextAppearance(paramInt);
    setCounterEnabled(bool3);
    applyPasswordToggleTint();
    ViewCompat.setImportantForAccessibility(this, 2);
  }
  
  private void applyBoxAttributes()
  {
    if (this.boxBackground == null) {
      return;
    }
    setBoxAttributes();
    EditText localEditText = this.editText;
    if ((localEditText != null) && (this.boxBackgroundMode == 2))
    {
      if (localEditText.getBackground() != null) {
        this.editTextOriginalDrawable = this.editText.getBackground();
      }
      ViewCompat.setBackground(this.editText, null);
    }
    localEditText = this.editText;
    if ((localEditText != null) && (this.boxBackgroundMode == 1))
    {
      Drawable localDrawable = this.editTextOriginalDrawable;
      if (localDrawable != null) {
        ViewCompat.setBackground(localEditText, localDrawable);
      }
    }
    int i = this.boxStrokeWidthPx;
    if (i > -1)
    {
      int j = this.boxStrokeColor;
      if (j != 0) {
        this.boxBackground.setStroke(i, j);
      }
    }
    this.boxBackground.setCornerRadii(getCornerRadiiAsArray());
    this.boxBackground.setColor(this.boxBackgroundColor);
    invalidate();
  }
  
  private void applyCutoutPadding(RectF paramRectF)
  {
    paramRectF.left -= this.boxLabelCutoutPaddingPx;
    paramRectF.top -= this.boxLabelCutoutPaddingPx;
    paramRectF.right += this.boxLabelCutoutPaddingPx;
    paramRectF.bottom += this.boxLabelCutoutPaddingPx;
  }
  
  private void applyPasswordToggleTint()
  {
    if ((this.passwordToggleDrawable != null) && ((this.hasPasswordToggleTintList) || (this.hasPasswordToggleTintMode)))
    {
      Object localObject = DrawableCompat.wrap(this.passwordToggleDrawable).mutate();
      this.passwordToggleDrawable = ((Drawable)localObject);
      if (this.hasPasswordToggleTintList) {
        DrawableCompat.setTintList((Drawable)localObject, this.passwordToggleTintList);
      }
      if (this.hasPasswordToggleTintMode) {
        DrawableCompat.setTintMode(this.passwordToggleDrawable, this.passwordToggleTintMode);
      }
      localObject = this.passwordToggleView;
      if (localObject != null)
      {
        localObject = ((CheckableImageButton)localObject).getDrawable();
        Drawable localDrawable = this.passwordToggleDrawable;
        if (localObject != localDrawable) {
          this.passwordToggleView.setImageDrawable(localDrawable);
        }
      }
    }
  }
  
  private void assignBoxBackgroundByMode()
  {
    int i = this.boxBackgroundMode;
    if (i == 0)
    {
      this.boxBackground = null;
      return;
    }
    if ((i == 2) && (this.hintEnabled) && (!(this.boxBackground instanceof CutoutDrawable)))
    {
      this.boxBackground = new CutoutDrawable();
      return;
    }
    if (!(this.boxBackground instanceof GradientDrawable)) {
      this.boxBackground = new GradientDrawable();
    }
  }
  
  private int calculateBoxBackgroundTop()
  {
    EditText localEditText = this.editText;
    if (localEditText == null) {
      return 0;
    }
    int i = this.boxBackgroundMode;
    if (i != 1)
    {
      if (i != 2) {
        return 0;
      }
      return localEditText.getTop() + calculateLabelMarginTop();
    }
    return localEditText.getTop();
  }
  
  private int calculateCollapsedTextTopBounds()
  {
    int i = this.boxBackgroundMode;
    if (i != 1)
    {
      if (i != 2) {
        return getPaddingTop();
      }
      return getBoxBackground().getBounds().top - calculateLabelMarginTop();
    }
    return getBoxBackground().getBounds().top + this.boxCollapsedPaddingTopPx;
  }
  
  private int calculateLabelMarginTop()
  {
    if (!this.hintEnabled) {
      return 0;
    }
    int i = this.boxBackgroundMode;
    if ((i != 0) && (i != 1)) {
      if (i != 2) {
        return 0;
      }
    }
    for (float f = this.collapsingTextHelper.getCollapsedTextHeight() / 2.0F;; f = this.collapsingTextHelper.getCollapsedTextHeight()) {
      return (int)f;
    }
  }
  
  private void closeCutout()
  {
    if (cutoutEnabled()) {
      ((CutoutDrawable)this.boxBackground).removeCutout();
    }
  }
  
  private void collapseHint(boolean paramBoolean)
  {
    ValueAnimator localValueAnimator = this.animator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.animator.cancel();
    }
    if ((paramBoolean) && (this.hintAnimationEnabled)) {
      animateToExpansionFraction(1.0F);
    } else {
      this.collapsingTextHelper.setExpansionFraction(1.0F);
    }
    this.hintExpanded = false;
    if (cutoutEnabled()) {
      openCutout();
    }
  }
  
  private boolean cutoutEnabled()
  {
    return (this.hintEnabled) && (!TextUtils.isEmpty(this.hint)) && ((this.boxBackground instanceof CutoutDrawable));
  }
  
  private void ensureBackgroundDrawableStateWorkaround()
  {
    int i = Build.VERSION.SDK_INT;
    if ((i != 21) && (i != 22)) {
      return;
    }
    Drawable localDrawable1 = this.editText.getBackground();
    if (localDrawable1 == null) {
      return;
    }
    if (!this.hasReconstructedEditTextBackground)
    {
      Drawable localDrawable2 = localDrawable1.getConstantState().newDrawable();
      if ((localDrawable1 instanceof DrawableContainer)) {
        this.hasReconstructedEditTextBackground = com.google.android.material.internal.DrawableUtils.setContainerConstantState((DrawableContainer)localDrawable1, localDrawable2.getConstantState());
      }
      if (!this.hasReconstructedEditTextBackground)
      {
        ViewCompat.setBackground(this.editText, localDrawable2);
        this.hasReconstructedEditTextBackground = true;
        onApplyBoxBackgroundMode();
      }
    }
  }
  
  private void expandHint(boolean paramBoolean)
  {
    ValueAnimator localValueAnimator = this.animator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.animator.cancel();
    }
    if ((paramBoolean) && (this.hintAnimationEnabled)) {
      animateToExpansionFraction(0.0F);
    } else {
      this.collapsingTextHelper.setExpansionFraction(0.0F);
    }
    if ((cutoutEnabled()) && (((CutoutDrawable)this.boxBackground).hasCutout())) {
      closeCutout();
    }
    this.hintExpanded = true;
  }
  
  private Drawable getBoxBackground()
  {
    int i = this.boxBackgroundMode;
    if ((i != 1) && (i != 2)) {
      throw new IllegalStateException();
    }
    return this.boxBackground;
  }
  
  private float[] getCornerRadiiAsArray()
  {
    if (!ViewUtils.isLayoutRtl(this))
    {
      f1 = this.boxCornerRadiusTopStart;
      f2 = this.boxCornerRadiusTopEnd;
      f3 = this.boxCornerRadiusBottomEnd;
      f4 = this.boxCornerRadiusBottomStart;
      return new float[] { f1, f1, f2, f2, f3, f3, f4, f4 };
    }
    float f1 = this.boxCornerRadiusTopEnd;
    float f2 = this.boxCornerRadiusTopStart;
    float f3 = this.boxCornerRadiusBottomStart;
    float f4 = this.boxCornerRadiusBottomEnd;
    return new float[] { f1, f1, f2, f2, f3, f3, f4, f4 };
  }
  
  private boolean hasPasswordTransformation()
  {
    EditText localEditText = this.editText;
    return (localEditText != null) && ((localEditText.getTransformationMethod() instanceof PasswordTransformationMethod));
  }
  
  private void onApplyBoxBackgroundMode()
  {
    assignBoxBackgroundByMode();
    if (this.boxBackgroundMode != 0) {
      updateInputLayoutMargins();
    }
    updateTextInputBoxBounds();
  }
  
  private void openCutout()
  {
    if (!cutoutEnabled()) {
      return;
    }
    RectF localRectF = this.tmpRectF;
    this.collapsingTextHelper.getCollapsedTextActualBounds(localRectF);
    applyCutoutPadding(localRectF);
    ((CutoutDrawable)this.boxBackground).setCutout(localRectF);
  }
  
  private static void recursiveSetEnabled(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramViewGroup.getChildAt(i);
      localView.setEnabled(paramBoolean);
      if ((localView instanceof ViewGroup)) {
        recursiveSetEnabled((ViewGroup)localView, paramBoolean);
      }
      i += 1;
    }
  }
  
  private void setBoxAttributes()
  {
    int i = this.boxBackgroundMode;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      if (this.focusedStrokeColor == 0) {
        this.focusedStrokeColor = this.focusedTextColor.getColorForState(getDrawableState(), this.focusedTextColor.getDefaultColor());
      }
    }
    else
    {
      this.boxStrokeWidthPx = 0;
    }
  }
  
  private void setEditText(EditText paramEditText)
  {
    if (this.editText == null)
    {
      if (!(paramEditText instanceof TextInputEditText)) {
        Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
      }
      this.editText = paramEditText;
      onApplyBoxBackgroundMode();
      setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
      if (!hasPasswordTransformation()) {
        this.collapsingTextHelper.setTypefaces(this.editText.getTypeface());
      }
      this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
      int i = this.editText.getGravity();
      this.collapsingTextHelper.setCollapsedTextGravity(i & 0xFFFFFF8F | 0x30);
      this.collapsingTextHelper.setExpandedTextGravity(i);
      this.editText.addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable)
        {
          TextInputLayout localTextInputLayout = TextInputLayout.this;
          localTextInputLayout.updateLabelState(localTextInputLayout.restoringSavedState ^ true);
          if (TextInputLayout.this.counterEnabled) {
            TextInputLayout.this.updateCounter(paramAnonymousEditable.length());
          }
        }
        
        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      if (this.defaultHintTextColor == null) {
        this.defaultHintTextColor = this.editText.getHintTextColors();
      }
      if (this.hintEnabled)
      {
        if (TextUtils.isEmpty(this.hint))
        {
          paramEditText = this.editText.getHint();
          this.originalHint = paramEditText;
          setHint(paramEditText);
          this.editText.setHint(null);
        }
        this.isProvidingHint = true;
      }
      if (this.counterView != null) {
        updateCounter(this.editText.getText().length());
      }
      this.indicatorViewController.adjustIndicatorPadding();
      updatePasswordToggleView();
      updateLabelState(false, true);
      return;
    }
    throw new IllegalArgumentException("We already have an EditText, can only have one");
  }
  
  private void setHintInternal(CharSequence paramCharSequence)
  {
    if (!TextUtils.equals(paramCharSequence, this.hint))
    {
      this.hint = paramCharSequence;
      this.collapsingTextHelper.setText(paramCharSequence);
      if (!this.hintExpanded) {
        openCutout();
      }
    }
  }
  
  private boolean shouldShowPasswordIcon()
  {
    return (this.passwordToggleEnabled) && ((hasPasswordTransformation()) || (this.passwordToggledVisible));
  }
  
  private void updateEditTextBackgroundBounds()
  {
    Object localObject1 = this.editText;
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = ((EditText)localObject1).getBackground();
    if (localObject2 == null) {
      return;
    }
    localObject1 = localObject2;
    if (androidx.appcompat.widget.DrawableUtils.canSafelyMutateDrawable((Drawable)localObject2)) {
      localObject1 = ((Drawable)localObject2).mutate();
    }
    localObject2 = new Rect();
    DescendantOffsetUtils.getDescendantRect(this, this.editText, (Rect)localObject2);
    localObject2 = ((Drawable)localObject1).getBounds();
    if (((Rect)localObject2).left != ((Rect)localObject2).right)
    {
      Rect localRect = new Rect();
      ((Drawable)localObject1).getPadding(localRect);
      int i = ((Rect)localObject2).left;
      int j = localRect.left;
      int k = ((Rect)localObject2).right;
      int m = localRect.right;
      ((Drawable)localObject1).setBounds(i - j, ((Rect)localObject2).top, k + m * 2, this.editText.getBottom());
    }
  }
  
  private void updateInputLayoutMargins()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.inputFrame.getLayoutParams();
    int i = calculateLabelMarginTop();
    if (i != localLayoutParams.topMargin)
    {
      localLayoutParams.topMargin = i;
      this.inputFrame.requestLayout();
    }
  }
  
  private void updateLabelState(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool1 = isEnabled();
    Object localObject = this.editText;
    int j = 1;
    int i;
    if ((localObject != null) && (!TextUtils.isEmpty(((EditText)localObject).getText()))) {
      i = 1;
    } else {
      i = 0;
    }
    localObject = this.editText;
    if ((localObject == null) || (!((EditText)localObject).hasFocus())) {
      j = 0;
    }
    boolean bool2 = this.indicatorViewController.errorShouldBeShown();
    localObject = this.defaultHintTextColor;
    if (localObject != null)
    {
      this.collapsingTextHelper.setCollapsedTextColor((ColorStateList)localObject);
      this.collapsingTextHelper.setExpandedTextColor(this.defaultHintTextColor);
    }
    if (!bool1)
    {
      this.collapsingTextHelper.setCollapsedTextColor(ColorStateList.valueOf(this.disabledColor));
      this.collapsingTextHelper.setExpandedTextColor(ColorStateList.valueOf(this.disabledColor));
    }
    else if (bool2)
    {
      this.collapsingTextHelper.setCollapsedTextColor(this.indicatorViewController.getErrorViewTextColors());
    }
    else
    {
      if (this.counterOverflowed)
      {
        localObject = this.counterView;
        if (localObject != null)
        {
          this.collapsingTextHelper.setCollapsedTextColor(((TextView)localObject).getTextColors());
          break label219;
        }
      }
      if (j != 0)
      {
        localObject = this.focusedTextColor;
        if (localObject != null) {
          this.collapsingTextHelper.setCollapsedTextColor((ColorStateList)localObject);
        }
      }
    }
    label219:
    if ((i == 0) && ((!isEnabled()) || ((j == 0) && (!bool2))))
    {
      if ((paramBoolean2) || (!this.hintExpanded)) {
        expandHint(paramBoolean1);
      }
    }
    else if ((paramBoolean2) || (this.hintExpanded)) {
      collapseHint(paramBoolean1);
    }
  }
  
  private void updatePasswordToggleView()
  {
    if (this.editText == null) {
      return;
    }
    if (shouldShowPasswordIcon())
    {
      if (this.passwordToggleView == null)
      {
        localObject = (CheckableImageButton)LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_password_icon, this.inputFrame, false);
        this.passwordToggleView = ((CheckableImageButton)localObject);
        ((CheckableImageButton)localObject).setImageDrawable(this.passwordToggleDrawable);
        this.passwordToggleView.setContentDescription(this.passwordToggleContentDesc);
        this.inputFrame.addView(this.passwordToggleView);
        this.passwordToggleView.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            TextInputLayout.this.passwordVisibilityToggleRequested(false);
          }
        });
      }
      localObject = this.editText;
      if ((localObject != null) && (ViewCompat.getMinimumHeight((View)localObject) <= 0)) {
        this.editText.setMinimumHeight(ViewCompat.getMinimumHeight(this.passwordToggleView));
      }
      this.passwordToggleView.setVisibility(0);
      this.passwordToggleView.setChecked(this.passwordToggledVisible);
      if (this.passwordToggleDummyDrawable == null) {
        this.passwordToggleDummyDrawable = new ColorDrawable();
      }
      this.passwordToggleDummyDrawable.setBounds(0, 0, this.passwordToggleView.getMeasuredWidth(), 1);
      localObject = TextViewCompat.getCompoundDrawablesRelative(this.editText);
      if (localObject[2] != this.passwordToggleDummyDrawable) {
        this.originalEditTextEndDrawable = localObject[2];
      }
      TextViewCompat.setCompoundDrawablesRelative(this.editText, localObject[0], localObject[1], this.passwordToggleDummyDrawable, localObject[3]);
      this.passwordToggleView.setPadding(this.editText.getPaddingLeft(), this.editText.getPaddingTop(), this.editText.getPaddingRight(), this.editText.getPaddingBottom());
      return;
    }
    Object localObject = this.passwordToggleView;
    if ((localObject != null) && (((CheckableImageButton)localObject).getVisibility() == 0)) {
      this.passwordToggleView.setVisibility(8);
    }
    if (this.passwordToggleDummyDrawable != null)
    {
      localObject = TextViewCompat.getCompoundDrawablesRelative(this.editText);
      if (localObject[2] == this.passwordToggleDummyDrawable)
      {
        TextViewCompat.setCompoundDrawablesRelative(this.editText, localObject[0], localObject[1], this.originalEditTextEndDrawable, localObject[3]);
        this.passwordToggleDummyDrawable = null;
      }
    }
  }
  
  private void updateTextInputBoxBounds()
  {
    if ((this.boxBackgroundMode != 0) && (this.boxBackground != null) && (this.editText != null))
    {
      if (getRight() == 0) {
        return;
      }
      int i3 = this.editText.getLeft();
      int i2 = calculateBoxBackgroundTop();
      int i1 = this.editText.getRight();
      int n = this.editText.getBottom() + this.boxBottomOffsetPx;
      int m = i3;
      int k = i2;
      int j = i1;
      int i = n;
      if (this.boxBackgroundMode == 2)
      {
        i = this.boxStrokeWidthFocusedPx;
        m = i3 + i / 2;
        k = i2 - i / 2;
        j = i1 - i / 2;
        i = n + i / 2;
      }
      this.boxBackground.setBounds(m, k, j, i);
      applyBoxAttributes();
      updateEditTextBackgroundBounds();
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramView instanceof EditText))
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramLayoutParams);
      localLayoutParams.gravity = (localLayoutParams.gravity & 0xFFFFFF8F | 0x10);
      this.inputFrame.addView(paramView, localLayoutParams);
      this.inputFrame.setLayoutParams(paramLayoutParams);
      updateInputLayoutMargins();
      setEditText((EditText)paramView);
      return;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  void animateToExpansionFraction(float paramFloat)
  {
    if (this.collapsingTextHelper.getExpansionFraction() == paramFloat) {
      return;
    }
    if (this.animator == null)
    {
      ValueAnimator localValueAnimator = new ValueAnimator();
      this.animator = localValueAnimator;
      localValueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
      this.animator.setDuration(167L);
      this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          TextInputLayout.this.collapsingTextHelper.setExpansionFraction(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        }
      });
    }
    this.animator.setFloatValues(new float[] { this.collapsingTextHelper.getExpansionFraction(), paramFloat });
    this.animator.start();
  }
  
  boolean cutoutIsOpen()
  {
    return (cutoutEnabled()) && (((CutoutDrawable)this.boxBackground).hasCutout());
  }
  
  public void dispatchProvideAutofillStructure(ViewStructure paramViewStructure, int paramInt)
  {
    if (this.originalHint != null)
    {
      Object localObject = this.editText;
      if (localObject != null)
      {
        boolean bool = this.isProvidingHint;
        this.isProvidingHint = false;
        localObject = ((EditText)localObject).getHint();
        this.editText.setHint(this.originalHint);
        try
        {
          super.dispatchProvideAutofillStructure(paramViewStructure, paramInt);
          return;
        }
        finally
        {
          this.editText.setHint((CharSequence)localObject);
          this.isProvidingHint = bool;
        }
      }
    }
    super.dispatchProvideAutofillStructure(paramViewStructure, paramInt);
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    this.restoringSavedState = true;
    super.dispatchRestoreInstanceState(paramSparseArray);
    this.restoringSavedState = false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    GradientDrawable localGradientDrawable = this.boxBackground;
    if (localGradientDrawable != null) {
      localGradientDrawable.draw(paramCanvas);
    }
    super.draw(paramCanvas);
    if (this.hintEnabled) {
      this.collapsingTextHelper.draw(paramCanvas);
    }
  }
  
  protected void drawableStateChanged()
  {
    if (this.inDrawableStateChanged) {
      return;
    }
    boolean bool2 = true;
    this.inDrawableStateChanged = true;
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    if ((!ViewCompat.isLaidOut(this)) || (!isEnabled())) {
      bool2 = false;
    }
    updateLabelState(bool2);
    updateEditTextBackground();
    updateTextInputBoxBounds();
    updateTextInputBoxState();
    CollapsingTextHelper localCollapsingTextHelper = this.collapsingTextHelper;
    boolean bool1;
    if (localCollapsingTextHelper != null) {
      bool1 = localCollapsingTextHelper.setState(arrayOfInt) | false;
    } else {
      bool1 = false;
    }
    if (bool1) {
      invalidate();
    }
    this.inDrawableStateChanged = false;
  }
  
  public int getBoxBackgroundColor()
  {
    return this.boxBackgroundColor;
  }
  
  public float getBoxCornerRadiusBottomEnd()
  {
    return this.boxCornerRadiusBottomEnd;
  }
  
  public float getBoxCornerRadiusBottomStart()
  {
    return this.boxCornerRadiusBottomStart;
  }
  
  public float getBoxCornerRadiusTopEnd()
  {
    return this.boxCornerRadiusTopEnd;
  }
  
  public float getBoxCornerRadiusTopStart()
  {
    return this.boxCornerRadiusTopStart;
  }
  
  public int getBoxStrokeColor()
  {
    return this.focusedStrokeColor;
  }
  
  public int getCounterMaxLength()
  {
    return this.counterMaxLength;
  }
  
  CharSequence getCounterOverflowDescription()
  {
    if ((this.counterEnabled) && (this.counterOverflowed))
    {
      TextView localTextView = this.counterView;
      if (localTextView != null) {
        return localTextView.getContentDescription();
      }
    }
    return null;
  }
  
  public ColorStateList getDefaultHintTextColor()
  {
    return this.defaultHintTextColor;
  }
  
  public EditText getEditText()
  {
    return this.editText;
  }
  
  public CharSequence getError()
  {
    if (this.indicatorViewController.isErrorEnabled()) {
      return this.indicatorViewController.getErrorText();
    }
    return null;
  }
  
  public int getErrorCurrentTextColors()
  {
    return this.indicatorViewController.getErrorViewCurrentTextColor();
  }
  
  final int getErrorTextCurrentColor()
  {
    return this.indicatorViewController.getErrorViewCurrentTextColor();
  }
  
  public CharSequence getHelperText()
  {
    if (this.indicatorViewController.isHelperTextEnabled()) {
      return this.indicatorViewController.getHelperText();
    }
    return null;
  }
  
  public int getHelperTextCurrentTextColor()
  {
    return this.indicatorViewController.getHelperTextViewCurrentTextColor();
  }
  
  public CharSequence getHint()
  {
    if (this.hintEnabled) {
      return this.hint;
    }
    return null;
  }
  
  final float getHintCollapsedTextHeight()
  {
    return this.collapsingTextHelper.getCollapsedTextHeight();
  }
  
  final int getHintCurrentCollapsedTextColor()
  {
    return this.collapsingTextHelper.getCurrentCollapsedTextColor();
  }
  
  public CharSequence getPasswordVisibilityToggleContentDescription()
  {
    return this.passwordToggleContentDesc;
  }
  
  public Drawable getPasswordVisibilityToggleDrawable()
  {
    return this.passwordToggleDrawable;
  }
  
  public Typeface getTypeface()
  {
    return this.typeface;
  }
  
  public boolean isCounterEnabled()
  {
    return this.counterEnabled;
  }
  
  public boolean isErrorEnabled()
  {
    return this.indicatorViewController.isErrorEnabled();
  }
  
  final boolean isHelperTextDisplayed()
  {
    return this.indicatorViewController.helperTextIsDisplayed();
  }
  
  public boolean isHelperTextEnabled()
  {
    return this.indicatorViewController.isHelperTextEnabled();
  }
  
  public boolean isHintAnimationEnabled()
  {
    return this.hintAnimationEnabled;
  }
  
  public boolean isHintEnabled()
  {
    return this.hintEnabled;
  }
  
  final boolean isHintExpanded()
  {
    return this.hintExpanded;
  }
  
  public boolean isPasswordVisibilityToggleEnabled()
  {
    return this.passwordToggleEnabled;
  }
  
  boolean isProvidingHint()
  {
    return this.isProvidingHint;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.boxBackground != null) {
      updateTextInputBoxBounds();
    }
    if (this.hintEnabled)
    {
      EditText localEditText = this.editText;
      if (localEditText != null)
      {
        Rect localRect = this.tmpRect;
        DescendantOffsetUtils.getDescendantRect(this, localEditText, localRect);
        paramInt1 = localRect.left + this.editText.getCompoundPaddingLeft();
        paramInt3 = localRect.right - this.editText.getCompoundPaddingRight();
        int i = calculateCollapsedTextTopBounds();
        this.collapsingTextHelper.setExpandedBounds(paramInt1, localRect.top + this.editText.getCompoundPaddingTop(), paramInt3, localRect.bottom - this.editText.getCompoundPaddingBottom());
        this.collapsingTextHelper.setCollapsedBounds(paramInt1, i, paramInt3, paramInt4 - paramInt2 - getPaddingBottom());
        this.collapsingTextHelper.recalculate();
        if ((cutoutEnabled()) && (!this.hintExpanded)) {
          openCutout();
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    updatePasswordToggleView();
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setError(paramParcelable.error);
    if (paramParcelable.isPasswordToggledVisible) {
      passwordVisibilityToggleRequested(true);
    }
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if (this.indicatorViewController.errorShouldBeShown()) {
      localSavedState.error = getError();
    }
    localSavedState.isPasswordToggledVisible = this.passwordToggledVisible;
    return localSavedState;
  }
  
  public void passwordVisibilityToggleRequested(boolean paramBoolean)
  {
    if (this.passwordToggleEnabled)
    {
      int i = this.editText.getSelectionEnd();
      if (hasPasswordTransformation())
      {
        this.editText.setTransformationMethod(null);
        this.passwordToggledVisible = true;
      }
      else
      {
        this.editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.passwordToggledVisible = false;
      }
      this.passwordToggleView.setChecked(this.passwordToggledVisible);
      if (paramBoolean) {
        this.passwordToggleView.jumpDrawablesToCurrentState();
      }
      this.editText.setSelection(i);
    }
  }
  
  public void setBoxBackgroundColor(int paramInt)
  {
    if (this.boxBackgroundColor != paramInt)
    {
      this.boxBackgroundColor = paramInt;
      applyBoxAttributes();
    }
  }
  
  public void setBoxBackgroundColorResource(int paramInt)
  {
    setBoxBackgroundColor(ContextCompat.getColor(getContext(), paramInt));
  }
  
  public void setBoxBackgroundMode(int paramInt)
  {
    if (paramInt == this.boxBackgroundMode) {
      return;
    }
    this.boxBackgroundMode = paramInt;
    onApplyBoxBackgroundMode();
  }
  
  public void setBoxCornerRadii(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((this.boxCornerRadiusTopStart != paramFloat1) || (this.boxCornerRadiusTopEnd != paramFloat2) || (this.boxCornerRadiusBottomEnd != paramFloat4) || (this.boxCornerRadiusBottomStart != paramFloat3))
    {
      this.boxCornerRadiusTopStart = paramFloat1;
      this.boxCornerRadiusTopEnd = paramFloat2;
      this.boxCornerRadiusBottomEnd = paramFloat4;
      this.boxCornerRadiusBottomStart = paramFloat3;
      applyBoxAttributes();
    }
  }
  
  public void setBoxCornerRadiiResources(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    setBoxCornerRadii(getContext().getResources().getDimension(paramInt1), getContext().getResources().getDimension(paramInt2), getContext().getResources().getDimension(paramInt3), getContext().getResources().getDimension(paramInt4));
  }
  
  public void setBoxStrokeColor(int paramInt)
  {
    if (this.focusedStrokeColor != paramInt)
    {
      this.focusedStrokeColor = paramInt;
      updateTextInputBoxState();
    }
  }
  
  public void setCounterEnabled(boolean paramBoolean)
  {
    if (this.counterEnabled != paramBoolean)
    {
      if (paramBoolean)
      {
        Object localObject = new AppCompatTextView(getContext());
        this.counterView = ((TextView)localObject);
        ((TextView)localObject).setId(R.id.textinput_counter);
        localObject = this.typeface;
        if (localObject != null) {
          this.counterView.setTypeface((Typeface)localObject);
        }
        this.counterView.setMaxLines(1);
        setTextAppearanceCompatWithErrorFallback(this.counterView, this.counterTextAppearance);
        this.indicatorViewController.addIndicator(this.counterView, 2);
        localObject = this.editText;
        if (localObject == null) {
          updateCounter(0);
        } else {
          updateCounter(((EditText)localObject).getText().length());
        }
      }
      else
      {
        this.indicatorViewController.removeIndicator(this.counterView, 2);
        this.counterView = null;
      }
      this.counterEnabled = paramBoolean;
    }
  }
  
  public void setCounterMaxLength(int paramInt)
  {
    if (this.counterMaxLength != paramInt)
    {
      if (paramInt > 0) {
        this.counterMaxLength = paramInt;
      } else {
        this.counterMaxLength = -1;
      }
      if (this.counterEnabled)
      {
        EditText localEditText = this.editText;
        if (localEditText == null) {
          paramInt = 0;
        } else {
          paramInt = localEditText.getText().length();
        }
        updateCounter(paramInt);
      }
    }
  }
  
  public void setDefaultHintTextColor(ColorStateList paramColorStateList)
  {
    this.defaultHintTextColor = paramColorStateList;
    this.focusedTextColor = paramColorStateList;
    if (this.editText != null) {
      updateLabelState(false);
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    recursiveSetEnabled(this, paramBoolean);
    super.setEnabled(paramBoolean);
  }
  
  public void setError(CharSequence paramCharSequence)
  {
    if (!this.indicatorViewController.isErrorEnabled())
    {
      if (TextUtils.isEmpty(paramCharSequence)) {
        return;
      }
      setErrorEnabled(true);
    }
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      this.indicatorViewController.showError(paramCharSequence);
      return;
    }
    this.indicatorViewController.hideError();
  }
  
  public void setErrorEnabled(boolean paramBoolean)
  {
    this.indicatorViewController.setErrorEnabled(paramBoolean);
  }
  
  public void setErrorTextAppearance(int paramInt)
  {
    this.indicatorViewController.setErrorTextAppearance(paramInt);
  }
  
  public void setErrorTextColor(ColorStateList paramColorStateList)
  {
    this.indicatorViewController.setErrorViewTextColor(paramColorStateList);
  }
  
  public void setHelperText(CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(paramCharSequence))
    {
      if (isHelperTextEnabled()) {
        setHelperTextEnabled(false);
      }
    }
    else
    {
      if (!isHelperTextEnabled()) {
        setHelperTextEnabled(true);
      }
      this.indicatorViewController.showHelper(paramCharSequence);
    }
  }
  
  public void setHelperTextColor(ColorStateList paramColorStateList)
  {
    this.indicatorViewController.setHelperTextViewTextColor(paramColorStateList);
  }
  
  public void setHelperTextEnabled(boolean paramBoolean)
  {
    this.indicatorViewController.setHelperTextEnabled(paramBoolean);
  }
  
  public void setHelperTextTextAppearance(int paramInt)
  {
    this.indicatorViewController.setHelperTextAppearance(paramInt);
  }
  
  public void setHint(CharSequence paramCharSequence)
  {
    if (this.hintEnabled)
    {
      setHintInternal(paramCharSequence);
      sendAccessibilityEvent(2048);
    }
  }
  
  public void setHintAnimationEnabled(boolean paramBoolean)
  {
    this.hintAnimationEnabled = paramBoolean;
  }
  
  public void setHintEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.hintEnabled)
    {
      this.hintEnabled = paramBoolean;
      if (!paramBoolean)
      {
        this.isProvidingHint = false;
        if ((!TextUtils.isEmpty(this.hint)) && (TextUtils.isEmpty(this.editText.getHint()))) {
          this.editText.setHint(this.hint);
        }
        setHintInternal(null);
      }
      else
      {
        CharSequence localCharSequence = this.editText.getHint();
        if (!TextUtils.isEmpty(localCharSequence))
        {
          if (TextUtils.isEmpty(this.hint)) {
            setHint(localCharSequence);
          }
          this.editText.setHint(null);
        }
        this.isProvidingHint = true;
      }
      if (this.editText != null) {
        updateInputLayoutMargins();
      }
    }
  }
  
  public void setHintTextAppearance(int paramInt)
  {
    this.collapsingTextHelper.setCollapsedTextAppearance(paramInt);
    this.focusedTextColor = this.collapsingTextHelper.getCollapsedTextColor();
    if (this.editText != null)
    {
      updateLabelState(false);
      updateInputLayoutMargins();
    }
  }
  
  public void setPasswordVisibilityToggleContentDescription(int paramInt)
  {
    CharSequence localCharSequence;
    if (paramInt != 0) {
      localCharSequence = getResources().getText(paramInt);
    } else {
      localCharSequence = null;
    }
    setPasswordVisibilityToggleContentDescription(localCharSequence);
  }
  
  public void setPasswordVisibilityToggleContentDescription(CharSequence paramCharSequence)
  {
    this.passwordToggleContentDesc = paramCharSequence;
    CheckableImageButton localCheckableImageButton = this.passwordToggleView;
    if (localCheckableImageButton != null) {
      localCheckableImageButton.setContentDescription(paramCharSequence);
    }
  }
  
  public void setPasswordVisibilityToggleDrawable(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = AppCompatResources.getDrawable(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setPasswordVisibilityToggleDrawable(localDrawable);
  }
  
  public void setPasswordVisibilityToggleDrawable(Drawable paramDrawable)
  {
    this.passwordToggleDrawable = paramDrawable;
    CheckableImageButton localCheckableImageButton = this.passwordToggleView;
    if (localCheckableImageButton != null) {
      localCheckableImageButton.setImageDrawable(paramDrawable);
    }
  }
  
  public void setPasswordVisibilityToggleEnabled(boolean paramBoolean)
  {
    if (this.passwordToggleEnabled != paramBoolean)
    {
      this.passwordToggleEnabled = paramBoolean;
      if ((!paramBoolean) && (this.passwordToggledVisible))
      {
        EditText localEditText = this.editText;
        if (localEditText != null) {
          localEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
      }
      this.passwordToggledVisible = false;
      updatePasswordToggleView();
    }
  }
  
  public void setPasswordVisibilityToggleTintList(ColorStateList paramColorStateList)
  {
    this.passwordToggleTintList = paramColorStateList;
    this.hasPasswordToggleTintList = true;
    applyPasswordToggleTint();
  }
  
  public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode paramMode)
  {
    this.passwordToggleTintMode = paramMode;
    this.hasPasswordToggleTintMode = true;
    applyPasswordToggleTint();
  }
  
  void setTextAppearanceCompatWithErrorFallback(TextView paramTextView, int paramInt)
  {
    i = 1;
    try
    {
      TextViewCompat.setTextAppearance(paramTextView, paramInt);
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramInt = paramTextView.getTextColors().getDefaultColor();
        if (paramInt == -65281)
        {
          paramInt = i;
          break label40;
        }
      }
      paramInt = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label40:
        paramInt = i;
      }
    }
    if (paramInt != 0)
    {
      TextViewCompat.setTextAppearance(paramTextView, R.style.TextAppearance_AppCompat_Caption);
      paramTextView.setTextColor(ContextCompat.getColor(getContext(), R.color.design_error));
    }
  }
  
  public void setTextInputAccessibilityDelegate(AccessibilityDelegate paramAccessibilityDelegate)
  {
    EditText localEditText = this.editText;
    if (localEditText != null) {
      ViewCompat.setAccessibilityDelegate(localEditText, paramAccessibilityDelegate);
    }
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    if (paramTypeface != this.typeface)
    {
      this.typeface = paramTypeface;
      this.collapsingTextHelper.setTypefaces(paramTypeface);
      this.indicatorViewController.setTypefaces(paramTypeface);
      TextView localTextView = this.counterView;
      if (localTextView != null) {
        localTextView.setTypeface(paramTypeface);
      }
    }
  }
  
  void updateCounter(int paramInt)
  {
    boolean bool2 = this.counterOverflowed;
    if (this.counterMaxLength == -1)
    {
      this.counterView.setText(String.valueOf(paramInt));
      this.counterView.setContentDescription(null);
      this.counterOverflowed = false;
    }
    else
    {
      if (ViewCompat.getAccessibilityLiveRegion(this.counterView) == 1) {
        ViewCompat.setAccessibilityLiveRegion(this.counterView, 0);
      }
      boolean bool1;
      if (paramInt > this.counterMaxLength) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.counterOverflowed = bool1;
      if (bool2 != bool1)
      {
        TextView localTextView = this.counterView;
        int i;
        if (bool1) {
          i = this.counterOverflowTextAppearance;
        } else {
          i = this.counterTextAppearance;
        }
        setTextAppearanceCompatWithErrorFallback(localTextView, i);
        if (this.counterOverflowed) {
          ViewCompat.setAccessibilityLiveRegion(this.counterView, 1);
        }
      }
      this.counterView.setText(getContext().getString(R.string.character_counter_pattern, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.counterMaxLength) }));
      this.counterView.setContentDescription(getContext().getString(R.string.character_counter_content_description, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.counterMaxLength) }));
    }
    if ((this.editText != null) && (bool2 != this.counterOverflowed))
    {
      updateLabelState(false);
      updateTextInputBoxState();
      updateEditTextBackground();
    }
  }
  
  void updateEditTextBackground()
  {
    Object localObject1 = this.editText;
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = ((EditText)localObject1).getBackground();
    if (localObject2 == null) {
      return;
    }
    ensureBackgroundDrawableStateWorkaround();
    localObject1 = localObject2;
    if (androidx.appcompat.widget.DrawableUtils.canSafelyMutateDrawable((Drawable)localObject2)) {
      localObject1 = ((Drawable)localObject2).mutate();
    }
    if (this.indicatorViewController.errorShouldBeShown())
    {
      ((Drawable)localObject1).setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.indicatorViewController.getErrorViewCurrentTextColor(), PorterDuff.Mode.SRC_IN));
      return;
    }
    if (this.counterOverflowed)
    {
      localObject2 = this.counterView;
      if (localObject2 != null)
      {
        ((Drawable)localObject1).setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(((TextView)localObject2).getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        return;
      }
    }
    DrawableCompat.clearColorFilter((Drawable)localObject1);
    this.editText.refreshDrawableState();
  }
  
  void updateLabelState(boolean paramBoolean)
  {
    updateLabelState(paramBoolean, false);
  }
  
  void updateTextInputBoxState()
  {
    if (this.boxBackground != null)
    {
      if (this.boxBackgroundMode == 0) {
        return;
      }
      Object localObject = this.editText;
      int j = 1;
      int i;
      if ((localObject != null) && (((EditText)localObject).hasFocus())) {
        i = 1;
      } else {
        i = 0;
      }
      localObject = this.editText;
      if ((localObject == null) || (!((EditText)localObject).isHovered())) {
        j = 0;
      }
      if (this.boxBackgroundMode == 2)
      {
        if (!isEnabled())
        {
          this.boxStrokeColor = this.disabledColor;
        }
        else if (this.indicatorViewController.errorShouldBeShown())
        {
          this.boxStrokeColor = this.indicatorViewController.getErrorViewCurrentTextColor();
        }
        else
        {
          if (this.counterOverflowed)
          {
            localObject = this.counterView;
            if (localObject != null)
            {
              this.boxStrokeColor = ((TextView)localObject).getCurrentTextColor();
              break label176;
            }
          }
          if (i != 0) {
            this.boxStrokeColor = this.focusedStrokeColor;
          } else if (j != 0) {
            this.boxStrokeColor = this.hoveredStrokeColor;
          } else {
            this.boxStrokeColor = this.defaultStrokeColor;
          }
        }
        label176:
        if (((j != 0) || (i != 0)) && (isEnabled())) {
          this.boxStrokeWidthPx = this.boxStrokeWidthFocusedPx;
        } else {
          this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
        }
        applyBoxAttributes();
      }
    }
  }
  
  public static class AccessibilityDelegate
    extends AccessibilityDelegateCompat
  {
    private final TextInputLayout layout;
    
    public AccessibilityDelegate(TextInputLayout paramTextInputLayout)
    {
      this.layout = paramTextInputLayout;
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      paramView = this.layout.getEditText();
      if (paramView != null) {
        paramView = paramView.getText();
      } else {
        paramView = null;
      }
      CharSequence localCharSequence3 = this.layout.getHint();
      CharSequence localCharSequence1 = this.layout.getError();
      CharSequence localCharSequence2 = this.layout.getCounterOverflowDescription();
      boolean bool1 = TextUtils.isEmpty(paramView) ^ true;
      boolean bool2 = TextUtils.isEmpty(localCharSequence3) ^ true;
      boolean bool3 = TextUtils.isEmpty(localCharSequence1) ^ true;
      boolean bool5 = false;
      int i;
      if ((!bool3) && (TextUtils.isEmpty(localCharSequence2))) {
        i = 0;
      } else {
        i = 1;
      }
      if (bool1) {
        paramAccessibilityNodeInfoCompat.setText(paramView);
      } else if (bool2) {
        paramAccessibilityNodeInfoCompat.setText(localCharSequence3);
      }
      if (bool2)
      {
        paramAccessibilityNodeInfoCompat.setHintText(localCharSequence3);
        boolean bool4 = bool5;
        if (!bool1)
        {
          bool4 = bool5;
          if (bool2) {
            bool4 = true;
          }
        }
        paramAccessibilityNodeInfoCompat.setShowingHintText(bool4);
      }
      if (i != 0)
      {
        if (bool3) {
          paramView = localCharSequence1;
        } else {
          paramView = localCharSequence2;
        }
        paramAccessibilityNodeInfoCompat.setError(paramView);
        paramAccessibilityNodeInfoCompat.setContentInvalid(true);
      }
    }
    
    public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramView = this.layout.getEditText();
      if (paramView != null) {
        paramView = paramView.getText();
      } else {
        paramView = null;
      }
      Object localObject = paramView;
      if (TextUtils.isEmpty(paramView)) {
        localObject = this.layout.getHint();
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramAccessibilityEvent.getText().add(localObject);
      }
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface BoxBackgroundMode {}
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
    {
      public TextInputLayout.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new TextInputLayout.SavedState(paramAnonymousParcel, null);
      }
      
      public TextInputLayout.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new TextInputLayout.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }
      
      public TextInputLayout.SavedState[] newArray(int paramAnonymousInt)
      {
        return new TextInputLayout.SavedState[paramAnonymousInt];
      }
    };
    CharSequence error;
    boolean isPasswordToggledVisible;
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.error = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
      int i = paramParcel.readInt();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      this.isPasswordToggledVisible = bool;
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TextInputLayout.SavedState{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append(" error=");
      localStringBuilder.append(this.error);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\material\textfield\TextInputLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */