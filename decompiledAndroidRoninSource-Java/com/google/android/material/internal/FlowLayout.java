package com.google.android.material.internal;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.styleable;

public class FlowLayout
  extends ViewGroup
{
  private int itemSpacing;
  private int lineSpacing;
  private boolean singleLine = false;
  
  public FlowLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    loadFromAttributes(paramContext, paramAttributeSet);
  }
  
  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    loadFromAttributes(paramContext, paramAttributeSet);
  }
  
  private static int getMeasuredDimension(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 != Integer.MIN_VALUE)
    {
      if (paramInt2 != 1073741824) {
        return paramInt3;
      }
      return paramInt1;
    }
    return Math.min(paramInt3, paramInt1);
  }
  
  private void loadFromAttributes(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.FlowLayout, 0, 0);
    this.lineSpacing = paramContext.getDimensionPixelSize(R.styleable.FlowLayout_lineSpacing, 0);
    this.itemSpacing = paramContext.getDimensionPixelSize(R.styleable.FlowLayout_itemSpacing, 0);
    paramContext.recycle();
  }
  
  protected int getItemSpacing()
  {
    return this.itemSpacing;
  }
  
  protected int getLineSpacing()
  {
    return this.lineSpacing;
  }
  
  protected boolean isSingleLine()
  {
    return this.singleLine;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() == 0) {
      return;
    }
    paramInt2 = ViewCompat.getLayoutDirection(this);
    int i = 1;
    if (paramInt2 != 1) {
      i = 0;
    }
    if (i != 0) {
      paramInt2 = getPaddingRight();
    } else {
      paramInt2 = getPaddingLeft();
    }
    if (i != 0) {
      paramInt4 = getPaddingLeft();
    } else {
      paramInt4 = getPaddingRight();
    }
    int k = getPaddingTop();
    int i2 = paramInt3 - paramInt1 - paramInt4;
    paramInt3 = paramInt2;
    paramInt1 = k;
    int j = 0;
    while (j < getChildCount())
    {
      View localView = getChildAt(j);
      if (localView.getVisibility() != 8)
      {
        Object localObject = localView.getLayoutParams();
        int n;
        int m;
        if ((localObject instanceof ViewGroup.MarginLayoutParams))
        {
          localObject = (ViewGroup.MarginLayoutParams)localObject;
          n = MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams)localObject);
          m = MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams)localObject);
        }
        else
        {
          m = 0;
          n = 0;
        }
        int i3 = localView.getMeasuredWidth();
        int i1 = paramInt3;
        paramInt4 = paramInt1;
        if (!this.singleLine)
        {
          i1 = paramInt3;
          paramInt4 = paramInt1;
          if (paramInt3 + n + i3 > i2)
          {
            paramInt4 = this.lineSpacing + k;
            i1 = paramInt2;
          }
        }
        paramInt1 = i1 + n;
        paramInt3 = localView.getMeasuredWidth() + paramInt1;
        k = localView.getMeasuredHeight() + paramInt4;
        if (i != 0) {
          localView.layout(i2 - paramInt3, paramInt4, i2 - i1 - n, k);
        } else {
          localView.layout(paramInt1, paramInt4, paramInt3, k);
        }
        paramInt3 = i1 + (n + m + localView.getMeasuredWidth() + this.itemSpacing);
        paramInt1 = paramInt4;
      }
      j += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i4 = View.MeasureSpec.getSize(paramInt1);
    int i6 = View.MeasureSpec.getMode(paramInt1);
    int i7 = View.MeasureSpec.getSize(paramInt2);
    int i8 = View.MeasureSpec.getMode(paramInt2);
    int m;
    if ((i6 != Integer.MIN_VALUE) && (i6 != 1073741824)) {
      m = Integer.MAX_VALUE;
    } else {
      m = i4;
    }
    int k = getPaddingLeft();
    int i1 = getPaddingTop();
    int i9 = getPaddingRight();
    int j = i1;
    int n = 0;
    int i = 0;
    while (n < getChildCount())
    {
      View localView = getChildAt(n);
      if (localView.getVisibility() != 8)
      {
        measureChild(localView, paramInt1, paramInt2);
        Object localObject = localView.getLayoutParams();
        int i3;
        if ((localObject instanceof ViewGroup.MarginLayoutParams))
        {
          localObject = (ViewGroup.MarginLayoutParams)localObject;
          i2 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin + 0;
          i3 = ((ViewGroup.MarginLayoutParams)localObject).rightMargin + 0;
        }
        else
        {
          i2 = 0;
          i3 = 0;
        }
        if ((k + i2 + localView.getMeasuredWidth() > m - i9) && (!isSingleLine()))
        {
          j = getPaddingLeft();
          k = this.lineSpacing + i1;
          i1 = j;
          j = k;
        }
        else
        {
          i1 = k;
        }
        int i5 = i1 + i2 + localView.getMeasuredWidth();
        int i10 = localView.getMeasuredHeight();
        k = i;
        if (i5 > i) {
          k = i5;
        }
        int i2 = i1 + (i2 + i3 + localView.getMeasuredWidth() + this.itemSpacing);
        i1 = j + i10;
        i = k;
        k = i2;
      }
      n += 1;
    }
    setMeasuredDimension(getMeasuredDimension(i4, i6, i), getMeasuredDimension(i7, i8, i1));
  }
  
  protected void setItemSpacing(int paramInt)
  {
    this.itemSpacing = paramInt;
  }
  
  protected void setLineSpacing(int paramInt)
  {
    this.lineSpacing = paramInt;
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    this.singleLine = paramBoolean;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\material\internal\FlowLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */