package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.legacy.widget.Space;
import com.google.android.material.R.dimen;
import com.google.android.material.R.id;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import java.util.ArrayList;
import java.util.List;

final class IndicatorViewController
{
  private static final int CAPTION_OPACITY_FADE_ANIMATION_DURATION = 167;
  private static final int CAPTION_STATE_ERROR = 1;
  private static final int CAPTION_STATE_HELPER_TEXT = 2;
  private static final int CAPTION_STATE_NONE = 0;
  private static final int CAPTION_TRANSLATE_Y_ANIMATION_DURATION = 217;
  static final int COUNTER_INDEX = 2;
  static final int ERROR_INDEX = 0;
  static final int HELPER_INDEX = 1;
  private Animator captionAnimator;
  private FrameLayout captionArea;
  private int captionDisplayed;
  private int captionToShow;
  private final float captionTranslationYPx;
  private int captionViewsAdded;
  private final Context context;
  private boolean errorEnabled;
  private CharSequence errorText;
  private int errorTextAppearance;
  private TextView errorView;
  private CharSequence helperText;
  private boolean helperTextEnabled;
  private int helperTextTextAppearance;
  private TextView helperTextView;
  private LinearLayout indicatorArea;
  private int indicatorsAdded;
  private final TextInputLayout textInputView;
  private Typeface typeface;
  
  public IndicatorViewController(TextInputLayout paramTextInputLayout)
  {
    Context localContext = paramTextInputLayout.getContext();
    this.context = localContext;
    this.textInputView = paramTextInputLayout;
    this.captionTranslationYPx = localContext.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
  }
  
  private boolean canAdjustIndicatorPadding()
  {
    return (this.indicatorArea != null) && (this.textInputView.getEditText() != null);
  }
  
  private void createCaptionAnimators(List<Animator> paramList, boolean paramBoolean, TextView paramTextView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramTextView != null)
    {
      if (!paramBoolean) {
        return;
      }
      if ((paramInt1 == paramInt3) || (paramInt1 == paramInt2))
      {
        if (paramInt3 == paramInt1) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        paramList.add(createCaptionOpacityAnimator(paramTextView, paramBoolean));
        if (paramInt3 == paramInt1) {
          paramList.add(createCaptionTranslationYAnimator(paramTextView));
        }
      }
    }
  }
  
  private ObjectAnimator createCaptionOpacityAnimator(TextView paramTextView, boolean paramBoolean)
  {
    float f;
    if (paramBoolean) {
      f = 1.0F;
    } else {
      f = 0.0F;
    }
    paramTextView = ObjectAnimator.ofFloat(paramTextView, View.ALPHA, new float[] { f });
    paramTextView.setDuration(167L);
    paramTextView.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
    return paramTextView;
  }
  
  private ObjectAnimator createCaptionTranslationYAnimator(TextView paramTextView)
  {
    paramTextView = ObjectAnimator.ofFloat(paramTextView, View.TRANSLATION_Y, new float[] { -this.captionTranslationYPx, 0.0F });
    paramTextView.setDuration(217L);
    paramTextView.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
    return paramTextView;
  }
  
  private TextView getCaptionViewFromDisplayState(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return null;
      }
      return this.helperTextView;
    }
    return this.errorView;
  }
  
  private boolean isCaptionStateError(int paramInt)
  {
    return (paramInt == 1) && (this.errorView != null) && (!TextUtils.isEmpty(this.errorText));
  }
  
  private boolean isCaptionStateHelperText(int paramInt)
  {
    return (paramInt == 2) && (this.helperTextView != null) && (!TextUtils.isEmpty(this.helperText));
  }
  
  private void setCaptionViewVisibilities(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    TextView localTextView;
    if (paramInt2 != 0)
    {
      localTextView = getCaptionViewFromDisplayState(paramInt2);
      if (localTextView != null)
      {
        localTextView.setVisibility(0);
        localTextView.setAlpha(1.0F);
      }
    }
    if (paramInt1 != 0)
    {
      localTextView = getCaptionViewFromDisplayState(paramInt1);
      if (localTextView != null)
      {
        localTextView.setVisibility(4);
        if (paramInt1 == 1) {
          localTextView.setText(null);
        }
      }
    }
    this.captionDisplayed = paramInt2;
  }
  
  private void setTextViewTypeface(TextView paramTextView, Typeface paramTypeface)
  {
    if (paramTextView != null) {
      paramTextView.setTypeface(paramTypeface);
    }
  }
  
  private void setViewGroupGoneIfEmpty(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      paramViewGroup.setVisibility(8);
    }
  }
  
  private boolean shouldAnimateCaptionView(TextView paramTextView, CharSequence paramCharSequence)
  {
    return (ViewCompat.isLaidOut(this.textInputView)) && (this.textInputView.isEnabled()) && ((this.captionToShow != this.captionDisplayed) || (paramTextView == null) || (!TextUtils.equals(paramTextView.getText(), paramCharSequence)));
  }
  
  private void updateCaptionViewsVisibility(final int paramInt1, final int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      AnimatorSet localAnimatorSet = new AnimatorSet();
      this.captionAnimator = localAnimatorSet;
      ArrayList localArrayList = new ArrayList();
      createCaptionAnimators(localArrayList, this.helperTextEnabled, this.helperTextView, 2, paramInt1, paramInt2);
      createCaptionAnimators(localArrayList, this.errorEnabled, this.errorView, 1, paramInt1, paramInt2);
      AnimatorSetCompat.playTogether(localAnimatorSet, localArrayList);
      localAnimatorSet.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          IndicatorViewController.access$002(IndicatorViewController.this, paramInt2);
          IndicatorViewController.access$102(IndicatorViewController.this, null);
          paramAnonymousAnimator = this.val$captionViewToHide;
          if (paramAnonymousAnimator != null)
          {
            paramAnonymousAnimator.setVisibility(4);
            if ((paramInt1 == 1) && (IndicatorViewController.this.errorView != null)) {
              IndicatorViewController.this.errorView.setText(null);
            }
          }
        }
        
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          paramAnonymousAnimator = this.val$captionViewToShow;
          if (paramAnonymousAnimator != null) {
            paramAnonymousAnimator.setVisibility(0);
          }
        }
      });
      localAnimatorSet.start();
    }
    else
    {
      setCaptionViewVisibilities(paramInt1, paramInt2);
    }
    this.textInputView.updateEditTextBackground();
    this.textInputView.updateLabelState(paramBoolean);
    this.textInputView.updateTextInputBoxState();
  }
  
  void addIndicator(TextView paramTextView, int paramInt)
  {
    if ((this.indicatorArea == null) && (this.captionArea == null))
    {
      Object localObject = new LinearLayout(this.context);
      this.indicatorArea = ((LinearLayout)localObject);
      ((LinearLayout)localObject).setOrientation(0);
      this.textInputView.addView(this.indicatorArea, -1, -2);
      localObject = new FrameLayout(this.context);
      this.captionArea = ((FrameLayout)localObject);
      this.indicatorArea.addView((View)localObject, -1, new FrameLayout.LayoutParams(-2, -2));
      localObject = new Space(this.context);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, 0, 1.0F);
      this.indicatorArea.addView((View)localObject, localLayoutParams);
      if (this.textInputView.getEditText() != null) {
        adjustIndicatorPadding();
      }
    }
    if (isCaptionView(paramInt))
    {
      this.captionArea.setVisibility(0);
      this.captionArea.addView(paramTextView);
      this.captionViewsAdded += 1;
    }
    else
    {
      this.indicatorArea.addView(paramTextView, paramInt);
    }
    this.indicatorArea.setVisibility(0);
    this.indicatorsAdded += 1;
  }
  
  void adjustIndicatorPadding()
  {
    if (canAdjustIndicatorPadding()) {
      ViewCompat.setPaddingRelative(this.indicatorArea, ViewCompat.getPaddingStart(this.textInputView.getEditText()), 0, ViewCompat.getPaddingEnd(this.textInputView.getEditText()), 0);
    }
  }
  
  void cancelCaptionAnimator()
  {
    Animator localAnimator = this.captionAnimator;
    if (localAnimator != null) {
      localAnimator.cancel();
    }
  }
  
  boolean errorIsDisplayed()
  {
    return isCaptionStateError(this.captionDisplayed);
  }
  
  boolean errorShouldBeShown()
  {
    return isCaptionStateError(this.captionToShow);
  }
  
  CharSequence getErrorText()
  {
    return this.errorText;
  }
  
  int getErrorViewCurrentTextColor()
  {
    TextView localTextView = this.errorView;
    if (localTextView != null) {
      return localTextView.getCurrentTextColor();
    }
    return -1;
  }
  
  ColorStateList getErrorViewTextColors()
  {
    TextView localTextView = this.errorView;
    if (localTextView != null) {
      return localTextView.getTextColors();
    }
    return null;
  }
  
  CharSequence getHelperText()
  {
    return this.helperText;
  }
  
  ColorStateList getHelperTextViewColors()
  {
    TextView localTextView = this.helperTextView;
    if (localTextView != null) {
      return localTextView.getTextColors();
    }
    return null;
  }
  
  int getHelperTextViewCurrentTextColor()
  {
    TextView localTextView = this.helperTextView;
    if (localTextView != null) {
      return localTextView.getCurrentTextColor();
    }
    return -1;
  }
  
  boolean helperTextIsDisplayed()
  {
    return isCaptionStateHelperText(this.captionDisplayed);
  }
  
  boolean helperTextShouldBeShown()
  {
    return isCaptionStateHelperText(this.captionToShow);
  }
  
  void hideError()
  {
    this.errorText = null;
    cancelCaptionAnimator();
    if (this.captionDisplayed == 1) {
      if ((this.helperTextEnabled) && (!TextUtils.isEmpty(this.helperText))) {
        this.captionToShow = 2;
      } else {
        this.captionToShow = 0;
      }
    }
    updateCaptionViewsVisibility(this.captionDisplayed, this.captionToShow, shouldAnimateCaptionView(this.errorView, null));
  }
  
  void hideHelperText()
  {
    cancelCaptionAnimator();
    if (this.captionDisplayed == 2) {
      this.captionToShow = 0;
    }
    updateCaptionViewsVisibility(this.captionDisplayed, this.captionToShow, shouldAnimateCaptionView(this.helperTextView, null));
  }
  
  boolean isCaptionView(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  boolean isErrorEnabled()
  {
    return this.errorEnabled;
  }
  
  boolean isHelperTextEnabled()
  {
    return this.helperTextEnabled;
  }
  
  void removeIndicator(TextView paramTextView, int paramInt)
  {
    if (this.indicatorArea == null) {
      return;
    }
    if (isCaptionView(paramInt))
    {
      FrameLayout localFrameLayout = this.captionArea;
      if (localFrameLayout != null)
      {
        paramInt = this.captionViewsAdded - 1;
        this.captionViewsAdded = paramInt;
        setViewGroupGoneIfEmpty(localFrameLayout, paramInt);
        this.captionArea.removeView(paramTextView);
        break label62;
      }
    }
    this.indicatorArea.removeView(paramTextView);
    label62:
    paramInt = this.indicatorsAdded - 1;
    this.indicatorsAdded = paramInt;
    setViewGroupGoneIfEmpty(this.indicatorArea, paramInt);
  }
  
  void setErrorEnabled(boolean paramBoolean)
  {
    if (this.errorEnabled == paramBoolean) {
      return;
    }
    cancelCaptionAnimator();
    if (paramBoolean)
    {
      Object localObject = new AppCompatTextView(this.context);
      this.errorView = ((TextView)localObject);
      ((TextView)localObject).setId(R.id.textinput_error);
      localObject = this.typeface;
      if (localObject != null) {
        this.errorView.setTypeface((Typeface)localObject);
      }
      setErrorTextAppearance(this.errorTextAppearance);
      this.errorView.setVisibility(4);
      ViewCompat.setAccessibilityLiveRegion(this.errorView, 1);
      addIndicator(this.errorView, 0);
    }
    else
    {
      hideError();
      removeIndicator(this.errorView, 0);
      this.errorView = null;
      this.textInputView.updateEditTextBackground();
      this.textInputView.updateTextInputBoxState();
    }
    this.errorEnabled = paramBoolean;
  }
  
  void setErrorTextAppearance(int paramInt)
  {
    this.errorTextAppearance = paramInt;
    TextView localTextView = this.errorView;
    if (localTextView != null) {
      this.textInputView.setTextAppearanceCompatWithErrorFallback(localTextView, paramInt);
    }
  }
  
  void setErrorViewTextColor(ColorStateList paramColorStateList)
  {
    TextView localTextView = this.errorView;
    if (localTextView != null) {
      localTextView.setTextColor(paramColorStateList);
    }
  }
  
  void setHelperTextAppearance(int paramInt)
  {
    this.helperTextTextAppearance = paramInt;
    TextView localTextView = this.helperTextView;
    if (localTextView != null) {
      TextViewCompat.setTextAppearance(localTextView, paramInt);
    }
  }
  
  void setHelperTextEnabled(boolean paramBoolean)
  {
    if (this.helperTextEnabled == paramBoolean) {
      return;
    }
    cancelCaptionAnimator();
    if (paramBoolean)
    {
      Object localObject = new AppCompatTextView(this.context);
      this.helperTextView = ((TextView)localObject);
      ((TextView)localObject).setId(R.id.textinput_helper_text);
      localObject = this.typeface;
      if (localObject != null) {
        this.helperTextView.setTypeface((Typeface)localObject);
      }
      this.helperTextView.setVisibility(4);
      ViewCompat.setAccessibilityLiveRegion(this.helperTextView, 1);
      setHelperTextAppearance(this.helperTextTextAppearance);
      addIndicator(this.helperTextView, 1);
    }
    else
    {
      hideHelperText();
      removeIndicator(this.helperTextView, 1);
      this.helperTextView = null;
      this.textInputView.updateEditTextBackground();
      this.textInputView.updateTextInputBoxState();
    }
    this.helperTextEnabled = paramBoolean;
  }
  
  void setHelperTextViewTextColor(ColorStateList paramColorStateList)
  {
    TextView localTextView = this.helperTextView;
    if (localTextView != null) {
      localTextView.setTextColor(paramColorStateList);
    }
  }
  
  void setTypefaces(Typeface paramTypeface)
  {
    if (paramTypeface != this.typeface)
    {
      this.typeface = paramTypeface;
      setTextViewTypeface(this.errorView, paramTypeface);
      setTextViewTypeface(this.helperTextView, paramTypeface);
    }
  }
  
  void showError(CharSequence paramCharSequence)
  {
    cancelCaptionAnimator();
    this.errorText = paramCharSequence;
    this.errorView.setText(paramCharSequence);
    if (this.captionDisplayed != 1) {
      this.captionToShow = 1;
    }
    updateCaptionViewsVisibility(this.captionDisplayed, this.captionToShow, shouldAnimateCaptionView(this.errorView, paramCharSequence));
  }
  
  void showHelper(CharSequence paramCharSequence)
  {
    cancelCaptionAnimator();
    this.helperText = paramCharSequence;
    this.helperTextView.setText(paramCharSequence);
    if (this.captionDisplayed != 2) {
      this.captionToShow = 2;
    }
    updateCaptionViewsVisibility(this.captionDisplayed, this.captionToShow, shouldAnimateCaptionView(this.helperTextView, paramCharSequence));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\material\textfield\IndicatorViewController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */