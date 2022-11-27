package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.dimen;
import com.google.android.material.R.id;
import com.google.android.material.R.styleable;

public class SnackbarContentLayout
  extends LinearLayout
  implements ContentViewCallback
{
  private Button actionView;
  private int maxInlineActionWidth;
  private int maxWidth;
  private TextView messageView;
  
  public SnackbarContentLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SnackbarContentLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SnackbarLayout);
    this.maxWidth = paramContext.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
    this.maxInlineActionWidth = paramContext.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
    paramContext.recycle();
  }
  
  private static void updateTopBottomPadding(View paramView, int paramInt1, int paramInt2)
  {
    if (ViewCompat.isPaddingRelative(paramView))
    {
      ViewCompat.setPaddingRelative(paramView, ViewCompat.getPaddingStart(paramView), paramInt1, ViewCompat.getPaddingEnd(paramView), paramInt2);
      return;
    }
    paramView.setPadding(paramView.getPaddingLeft(), paramInt1, paramView.getPaddingRight(), paramInt2);
  }
  
  private boolean updateViewsWithinLayout(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    if (paramInt1 != getOrientation())
    {
      setOrientation(paramInt1);
      bool = true;
    }
    else
    {
      bool = false;
    }
    if ((this.messageView.getPaddingTop() == paramInt2) && (this.messageView.getPaddingBottom() == paramInt3)) {
      return bool;
    }
    updateTopBottomPadding(this.messageView, paramInt2, paramInt3);
    return true;
  }
  
  public void animateContentIn(int paramInt1, int paramInt2)
  {
    this.messageView.setAlpha(0.0F);
    ViewPropertyAnimator localViewPropertyAnimator = this.messageView.animate().alpha(1.0F);
    long l1 = paramInt2;
    localViewPropertyAnimator = localViewPropertyAnimator.setDuration(l1);
    long l2 = paramInt1;
    localViewPropertyAnimator.setStartDelay(l2).start();
    if (this.actionView.getVisibility() == 0)
    {
      this.actionView.setAlpha(0.0F);
      this.actionView.animate().alpha(1.0F).setDuration(l1).setStartDelay(l2).start();
    }
  }
  
  public void animateContentOut(int paramInt1, int paramInt2)
  {
    this.messageView.setAlpha(1.0F);
    ViewPropertyAnimator localViewPropertyAnimator = this.messageView.animate().alpha(0.0F);
    long l1 = paramInt2;
    localViewPropertyAnimator = localViewPropertyAnimator.setDuration(l1);
    long l2 = paramInt1;
    localViewPropertyAnimator.setStartDelay(l2).start();
    if (this.actionView.getVisibility() == 0)
    {
      this.actionView.setAlpha(1.0F);
      this.actionView.animate().alpha(0.0F).setDuration(l1).setStartDelay(l2).start();
    }
  }
  
  public Button getActionView()
  {
    return this.actionView;
  }
  
  public TextView getMessageView()
  {
    return this.messageView;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.messageView = ((TextView)findViewById(R.id.snackbar_text));
    this.actionView = ((Button)findViewById(R.id.snackbar_action));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = paramInt1;
    if (this.maxWidth > 0)
    {
      j = getMeasuredWidth();
      k = this.maxWidth;
      i = paramInt1;
      if (j > k)
      {
        i = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
        super.onMeasure(i, paramInt2);
      }
    }
    int j = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
    int m = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
    paramInt1 = this.messageView.getLayout().getLineCount();
    int k = 0;
    if (paramInt1 > 1) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if ((paramInt1 != 0) && (this.maxInlineActionWidth > 0) && (this.actionView.getMeasuredWidth() > this.maxInlineActionWidth))
    {
      paramInt1 = k;
      if (!updateViewsWithinLayout(1, j, j - m)) {
        break label174;
      }
    }
    else
    {
      if (paramInt1 == 0) {
        j = m;
      }
      paramInt1 = k;
      if (!updateViewsWithinLayout(0, j, j)) {
        break label174;
      }
    }
    paramInt1 = 1;
    label174:
    if (paramInt1 != 0) {
      super.onMeasure(i, paramInt2);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\material\snackbar\SnackbarContentLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */