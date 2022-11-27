package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlexboxLayout
  extends ViewGroup
  implements FlexContainer
{
  public static final int SHOW_DIVIDER_BEGINNING = 1;
  public static final int SHOW_DIVIDER_END = 4;
  public static final int SHOW_DIVIDER_MIDDLE = 2;
  public static final int SHOW_DIVIDER_NONE = 0;
  private int mAlignContent;
  private int mAlignItems;
  private Drawable mDividerDrawableHorizontal;
  private Drawable mDividerDrawableVertical;
  private int mDividerHorizontalHeight;
  private int mDividerVerticalWidth;
  private int mFlexDirection;
  private List<FlexLine> mFlexLines = new ArrayList();
  private FlexboxHelper.FlexLinesResult mFlexLinesResult = new FlexboxHelper.FlexLinesResult();
  private int mFlexWrap;
  private FlexboxHelper mFlexboxHelper = new FlexboxHelper(this);
  private int mJustifyContent;
  private int mMaxLine = -1;
  private SparseIntArray mOrderCache;
  private int[] mReorderedIndices;
  private int mShowDividerHorizontal;
  private int mShowDividerVertical;
  
  public FlexboxLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FlexboxLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FlexboxLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FlexboxLayout, paramInt, 0);
    this.mFlexDirection = paramContext.getInt(R.styleable.FlexboxLayout_flexDirection, 0);
    this.mFlexWrap = paramContext.getInt(R.styleable.FlexboxLayout_flexWrap, 0);
    this.mJustifyContent = paramContext.getInt(R.styleable.FlexboxLayout_justifyContent, 0);
    this.mAlignItems = paramContext.getInt(R.styleable.FlexboxLayout_alignItems, 0);
    this.mAlignContent = paramContext.getInt(R.styleable.FlexboxLayout_alignContent, 0);
    this.mMaxLine = paramContext.getInt(R.styleable.FlexboxLayout_maxLine, -1);
    paramAttributeSet = paramContext.getDrawable(R.styleable.FlexboxLayout_dividerDrawable);
    if (paramAttributeSet != null)
    {
      setDividerDrawableHorizontal(paramAttributeSet);
      setDividerDrawableVertical(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getDrawable(R.styleable.FlexboxLayout_dividerDrawableHorizontal);
    if (paramAttributeSet != null) {
      setDividerDrawableHorizontal(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getDrawable(R.styleable.FlexboxLayout_dividerDrawableVertical);
    if (paramAttributeSet != null) {
      setDividerDrawableVertical(paramAttributeSet);
    }
    paramInt = paramContext.getInt(R.styleable.FlexboxLayout_showDivider, 0);
    if (paramInt != 0)
    {
      this.mShowDividerVertical = paramInt;
      this.mShowDividerHorizontal = paramInt;
    }
    paramInt = paramContext.getInt(R.styleable.FlexboxLayout_showDividerVertical, 0);
    if (paramInt != 0) {
      this.mShowDividerVertical = paramInt;
    }
    paramInt = paramContext.getInt(R.styleable.FlexboxLayout_showDividerHorizontal, 0);
    if (paramInt != 0) {
      this.mShowDividerHorizontal = paramInt;
    }
    paramContext.recycle();
  }
  
  private boolean allFlexLinesAreDummyBefore(int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (((FlexLine)this.mFlexLines.get(i)).getItemCountNotGone() > 0) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private boolean allViewsAreGoneBefore(int paramInt1, int paramInt2)
  {
    int i = 1;
    while (i <= paramInt2)
    {
      View localView = getReorderedChildAt(paramInt1 - i);
      if ((localView != null) && (localView.getVisibility() != 8)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private void drawDividersHorizontal(Canvas paramCanvas, boolean paramBoolean1, boolean paramBoolean2)
  {
    int m = getPaddingLeft();
    int i = getPaddingRight();
    int n = Math.max(0, getWidth() - i - m);
    int i1 = this.mFlexLines.size();
    i = 0;
    while (i < i1)
    {
      FlexLine localFlexLine = (FlexLine)this.mFlexLines.get(i);
      int j = 0;
      while (j < localFlexLine.mItemCount)
      {
        int k = localFlexLine.mFirstIndex + j;
        View localView = getReorderedChildAt(k);
        if ((localView != null) && (localView.getVisibility() != 8))
        {
          LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (hasDividerBeforeChildAtAlongMainAxis(k, j))
          {
            if (paramBoolean1) {
              k = localView.getRight() + localLayoutParams.rightMargin;
            } else {
              k = localView.getLeft() - localLayoutParams.leftMargin - this.mDividerVerticalWidth;
            }
            drawVerticalDivider(paramCanvas, k, localFlexLine.mTop, localFlexLine.mCrossSize);
          }
          if ((j == localFlexLine.mItemCount - 1) && ((this.mShowDividerVertical & 0x4) > 0))
          {
            if (paramBoolean1) {
              k = localView.getLeft() - localLayoutParams.leftMargin - this.mDividerVerticalWidth;
            } else {
              k = localView.getRight() + localLayoutParams.rightMargin;
            }
            drawVerticalDivider(paramCanvas, k, localFlexLine.mTop, localFlexLine.mCrossSize);
          }
        }
        j += 1;
      }
      if (hasDividerBeforeFlexLine(i))
      {
        if (paramBoolean2) {
          j = localFlexLine.mBottom;
        } else {
          j = localFlexLine.mTop - this.mDividerHorizontalHeight;
        }
        drawHorizontalDivider(paramCanvas, m, j, n);
      }
      if ((hasEndDividerAfterFlexLine(i)) && ((this.mShowDividerHorizontal & 0x4) > 0))
      {
        if (paramBoolean2) {
          j = localFlexLine.mTop - this.mDividerHorizontalHeight;
        } else {
          j = localFlexLine.mBottom;
        }
        drawHorizontalDivider(paramCanvas, m, j, n);
      }
      i += 1;
    }
  }
  
  private void drawDividersVertical(Canvas paramCanvas, boolean paramBoolean1, boolean paramBoolean2)
  {
    int m = getPaddingTop();
    int i = getPaddingBottom();
    int n = Math.max(0, getHeight() - i - m);
    int i1 = this.mFlexLines.size();
    i = 0;
    while (i < i1)
    {
      FlexLine localFlexLine = (FlexLine)this.mFlexLines.get(i);
      int j = 0;
      while (j < localFlexLine.mItemCount)
      {
        int k = localFlexLine.mFirstIndex + j;
        View localView = getReorderedChildAt(k);
        if ((localView != null) && (localView.getVisibility() != 8))
        {
          LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (hasDividerBeforeChildAtAlongMainAxis(k, j))
          {
            if (paramBoolean2) {
              k = localView.getBottom() + localLayoutParams.bottomMargin;
            } else {
              k = localView.getTop() - localLayoutParams.topMargin - this.mDividerHorizontalHeight;
            }
            drawHorizontalDivider(paramCanvas, localFlexLine.mLeft, k, localFlexLine.mCrossSize);
          }
          if ((j == localFlexLine.mItemCount - 1) && ((this.mShowDividerHorizontal & 0x4) > 0))
          {
            if (paramBoolean2) {
              k = localView.getTop() - localLayoutParams.topMargin - this.mDividerHorizontalHeight;
            } else {
              k = localView.getBottom() + localLayoutParams.bottomMargin;
            }
            drawHorizontalDivider(paramCanvas, localFlexLine.mLeft, k, localFlexLine.mCrossSize);
          }
        }
        j += 1;
      }
      if (hasDividerBeforeFlexLine(i))
      {
        if (paramBoolean1) {
          j = localFlexLine.mRight;
        } else {
          j = localFlexLine.mLeft - this.mDividerVerticalWidth;
        }
        drawVerticalDivider(paramCanvas, j, m, n);
      }
      if ((hasEndDividerAfterFlexLine(i)) && ((this.mShowDividerVertical & 0x4) > 0))
      {
        if (paramBoolean1) {
          j = localFlexLine.mLeft - this.mDividerVerticalWidth;
        } else {
          j = localFlexLine.mRight;
        }
        drawVerticalDivider(paramCanvas, j, m, n);
      }
      i += 1;
    }
  }
  
  private void drawHorizontalDivider(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    Drawable localDrawable = this.mDividerDrawableHorizontal;
    if (localDrawable == null) {
      return;
    }
    localDrawable.setBounds(paramInt1, paramInt2, paramInt3 + paramInt1, this.mDividerHorizontalHeight + paramInt2);
    this.mDividerDrawableHorizontal.draw(paramCanvas);
  }
  
  private void drawVerticalDivider(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    Drawable localDrawable = this.mDividerDrawableVertical;
    if (localDrawable == null) {
      return;
    }
    localDrawable.setBounds(paramInt1, paramInt2, this.mDividerVerticalWidth + paramInt1, paramInt3 + paramInt2);
    this.mDividerDrawableVertical.draw(paramCanvas);
  }
  
  private boolean hasDividerBeforeChildAtAlongMainAxis(int paramInt1, int paramInt2)
  {
    boolean bool5 = allViewsAreGoneBefore(paramInt1, paramInt2);
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    if (bool5)
    {
      if (isMainAxisDirectionHorizontal())
      {
        if ((this.mShowDividerVertical & 0x1) != 0) {
          bool1 = true;
        }
        return bool1;
      }
      bool1 = bool2;
      if ((this.mShowDividerHorizontal & 0x1) != 0) {
        bool1 = true;
      }
      return bool1;
    }
    if (isMainAxisDirectionHorizontal())
    {
      bool1 = bool3;
      if ((this.mShowDividerVertical & 0x2) != 0) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool4;
    if ((this.mShowDividerHorizontal & 0x2) != 0) {
      bool1 = true;
    }
    return bool1;
  }
  
  private boolean hasDividerBeforeFlexLine(int paramInt)
  {
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool2 = false;
    boolean bool1 = bool5;
    if (paramInt >= 0)
    {
      if (paramInt >= this.mFlexLines.size()) {
        return false;
      }
      if (allFlexLinesAreDummyBefore(paramInt))
      {
        if (isMainAxisDirectionHorizontal())
        {
          bool1 = bool2;
          if ((this.mShowDividerHorizontal & 0x1) != 0) {
            bool1 = true;
          }
          return bool1;
        }
        bool1 = bool3;
        if ((this.mShowDividerVertical & 0x1) != 0) {
          bool1 = true;
        }
        return bool1;
      }
      if (isMainAxisDirectionHorizontal())
      {
        bool1 = bool4;
        if ((this.mShowDividerHorizontal & 0x2) != 0) {
          bool1 = true;
        }
        return bool1;
      }
      bool1 = bool5;
      if ((this.mShowDividerVertical & 0x2) != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean hasEndDividerAfterFlexLine(int paramInt)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (paramInt >= 0)
    {
      if (paramInt >= this.mFlexLines.size()) {
        return false;
      }
      paramInt += 1;
      while (paramInt < this.mFlexLines.size())
      {
        if (((FlexLine)this.mFlexLines.get(paramInt)).getItemCountNotGone() > 0) {
          return false;
        }
        paramInt += 1;
      }
      if (isMainAxisDirectionHorizontal())
      {
        bool1 = bool2;
        if ((this.mShowDividerHorizontal & 0x4) != 0) {
          bool1 = true;
        }
        return bool1;
      }
      bool1 = bool3;
      if ((this.mShowDividerVertical & 0x4) != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void layoutHorizontal(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getPaddingLeft();
    int m = getPaddingRight();
    int n = paramInt3 - paramInt1;
    paramInt3 = paramInt4 - paramInt2 - getPaddingBottom();
    paramInt2 = getPaddingTop();
    int i1 = this.mFlexLines.size();
    paramInt4 = 0;
    paramInt1 = i;
    while (paramInt4 < i1)
    {
      FlexLine localFlexLine = (FlexLine)this.mFlexLines.get(paramInt4);
      i = paramInt3;
      int j = paramInt2;
      if (hasDividerBeforeFlexLine(paramInt4))
      {
        j = this.mDividerHorizontalHeight;
        i = paramInt3 - j;
        j = paramInt2 + j;
      }
      paramInt2 = this.mJustifyContent;
      float f1;
      Object localObject;
      if (paramInt2 != 0)
      {
        if (paramInt2 != 1)
        {
          if (paramInt2 != 2)
          {
            if (paramInt2 != 3)
            {
              if (paramInt2 != 4)
              {
                if (paramInt2 == 5)
                {
                  paramInt2 = localFlexLine.getItemCountNotGone();
                  if (paramInt2 != 0) {
                    f3 = (n - localFlexLine.mMainSize) / (paramInt2 + 1);
                  } else {
                    f3 = 0.0F;
                  }
                  f1 = paramInt1 + f3;
                  f2 = n - m - f3;
                  break label439;
                }
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("Invalid justifyContent is set: ");
                ((StringBuilder)localObject).append(this.mJustifyContent);
                throw new IllegalStateException(((StringBuilder)localObject).toString());
              }
              paramInt2 = localFlexLine.getItemCountNotGone();
              if (paramInt2 != 0) {
                f3 = (n - localFlexLine.mMainSize) / paramInt2;
              } else {
                f3 = 0.0F;
              }
              f1 = paramInt1;
              f2 = f3 / 2.0F;
              f1 += f2;
              f2 = n - m - f2;
              break label439;
            }
            f2 = paramInt1;
            paramInt2 = localFlexLine.getItemCountNotGone();
            if (paramInt2 != 1) {
              f1 = paramInt2 - 1;
            } else {
              f1 = 1.0F;
            }
            f3 = (n - localFlexLine.mMainSize) / f1;
            f4 = n - m;
            f1 = f2;
            f2 = f4;
            break label439;
          }
          f1 = paramInt1 + (n - localFlexLine.mMainSize) / 2.0F;
          f2 = n - m - (n - localFlexLine.mMainSize) / 2.0F;
          break label436;
        }
        f1 = n - localFlexLine.mMainSize + m;
        paramInt2 = localFlexLine.mMainSize - paramInt1;
      }
      else
      {
        f1 = paramInt1;
        paramInt2 = n - m;
      }
      float f2 = paramInt2;
      label436:
      float f3 = 0.0F;
      label439:
      float f4 = Math.max(f3, 0.0F);
      paramInt2 = 0;
      while (paramInt2 < localFlexLine.mItemCount)
      {
        paramInt3 = localFlexLine.mFirstIndex + paramInt2;
        View localView = getReorderedChildAt(paramInt3);
        if ((localView != null) && (localView.getVisibility() != 8))
        {
          localObject = (LayoutParams)localView.getLayoutParams();
          f3 = f1 + ((LayoutParams)localObject).leftMargin;
          f1 = f2 - ((LayoutParams)localObject).rightMargin;
          if (hasDividerBeforeChildAtAlongMainAxis(paramInt3, paramInt2))
          {
            paramInt3 = this.mDividerVerticalWidth;
            f5 = paramInt3;
            f2 = f3 + f5;
            f1 -= f5;
          }
          else
          {
            paramInt3 = 0;
            f2 = f3;
          }
          int k;
          if ((paramInt2 == localFlexLine.mItemCount - 1) && ((this.mShowDividerVertical & 0x4) > 0)) {
            k = this.mDividerVerticalWidth;
          } else {
            k = 0;
          }
          if (this.mFlexWrap == 2)
          {
            if (paramBoolean) {
              this.mFlexboxHelper.layoutSingleChildHorizontal(localView, localFlexLine, Math.round(f1) - localView.getMeasuredWidth(), i - localView.getMeasuredHeight(), Math.round(f1), i);
            } else {
              this.mFlexboxHelper.layoutSingleChildHorizontal(localView, localFlexLine, Math.round(f2), i - localView.getMeasuredHeight(), Math.round(f2) + localView.getMeasuredWidth(), i);
            }
          }
          else if (paramBoolean) {
            this.mFlexboxHelper.layoutSingleChildHorizontal(localView, localFlexLine, Math.round(f1) - localView.getMeasuredWidth(), j, Math.round(f1), j + localView.getMeasuredHeight());
          } else {
            this.mFlexboxHelper.layoutSingleChildHorizontal(localView, localFlexLine, Math.round(f2), j, Math.round(f2) + localView.getMeasuredWidth(), j + localView.getMeasuredHeight());
          }
          f2 += localView.getMeasuredWidth() + f4 + ((LayoutParams)localObject).rightMargin;
          f3 = localView.getMeasuredWidth();
          float f5 = ((LayoutParams)localObject).leftMargin;
          if (paramBoolean) {
            localFlexLine.updatePositionFromView(localView, k, 0, paramInt3, 0);
          } else {
            localFlexLine.updatePositionFromView(localView, paramInt3, 0, k, 0);
          }
          f3 = f1 - (f3 + f4 + f5);
          f1 = f2;
          f2 = f3;
        }
        paramInt2 += 1;
      }
      paramInt2 = j + localFlexLine.mCrossSize;
      paramInt3 = i - localFlexLine.mCrossSize;
      paramInt4 += 1;
    }
  }
  
  private void layoutVertical(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = getPaddingTop();
    int m = getPaddingBottom();
    int j = getPaddingRight();
    int i = getPaddingLeft();
    int n = paramInt4 - paramInt2;
    paramInt1 = paramInt3 - paramInt1 - j;
    int i1 = this.mFlexLines.size();
    paramInt3 = 0;
    paramInt2 = i;
    while (paramInt3 < i1)
    {
      FlexLine localFlexLine = (FlexLine)this.mFlexLines.get(paramInt3);
      i = paramInt2;
      paramInt4 = paramInt1;
      if (hasDividerBeforeFlexLine(paramInt3))
      {
        paramInt4 = this.mDividerVerticalWidth;
        i = paramInt2 + paramInt4;
        paramInt4 = paramInt1 - paramInt4;
      }
      paramInt1 = this.mJustifyContent;
      float f1;
      Object localObject;
      if (paramInt1 != 0)
      {
        if (paramInt1 != 1)
        {
          if (paramInt1 != 2)
          {
            if (paramInt1 != 3)
            {
              if (paramInt1 != 4)
              {
                if (paramInt1 == 5)
                {
                  paramInt1 = localFlexLine.getItemCountNotGone();
                  if (paramInt1 != 0) {
                    f3 = (n - localFlexLine.mMainSize) / (paramInt1 + 1);
                  } else {
                    f3 = 0.0F;
                  }
                  f1 = k + f3;
                  f2 = n - m - f3;
                  break label455;
                }
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("Invalid justifyContent is set: ");
                ((StringBuilder)localObject).append(this.mJustifyContent);
                throw new IllegalStateException(((StringBuilder)localObject).toString());
              }
              paramInt1 = localFlexLine.getItemCountNotGone();
              if (paramInt1 != 0) {
                f3 = (n - localFlexLine.mMainSize) / paramInt1;
              } else {
                f3 = 0.0F;
              }
              f1 = k;
              f2 = f3 / 2.0F;
              f1 += f2;
              f2 = n - m - f2;
              break label455;
            }
            f2 = k;
            paramInt1 = localFlexLine.getItemCountNotGone();
            if (paramInt1 != 1) {
              f1 = paramInt1 - 1;
            } else {
              f1 = 1.0F;
            }
            f3 = (n - localFlexLine.mMainSize) / f1;
            f4 = n - m;
            f1 = f2;
            f2 = f4;
            break label455;
          }
          f1 = k;
          f1 = (n - localFlexLine.mMainSize) / 2.0F + f1;
          f2 = n - m - (n - localFlexLine.mMainSize) / 2.0F;
          break label452;
        }
        f1 = n - localFlexLine.mMainSize + m;
        paramInt1 = localFlexLine.mMainSize - k;
      }
      else
      {
        f1 = k;
        paramInt1 = n - m;
      }
      float f2 = paramInt1;
      label452:
      float f3 = 0.0F;
      label455:
      float f4 = Math.max(f3, 0.0F);
      paramInt1 = 0;
      while (paramInt1 < localFlexLine.mItemCount)
      {
        paramInt2 = localFlexLine.mFirstIndex + paramInt1;
        View localView = getReorderedChildAt(paramInt2);
        if ((localView != null) && (localView.getVisibility() != 8))
        {
          localObject = (LayoutParams)localView.getLayoutParams();
          f3 = f1 + ((LayoutParams)localObject).topMargin;
          f1 = f2 - ((LayoutParams)localObject).bottomMargin;
          if (hasDividerBeforeChildAtAlongMainAxis(paramInt2, paramInt1))
          {
            paramInt2 = this.mDividerHorizontalHeight;
            f5 = paramInt2;
            f2 = f3 + f5;
            f1 -= f5;
          }
          else
          {
            f2 = f3;
            paramInt2 = 0;
          }
          if ((paramInt1 == localFlexLine.mItemCount - 1) && ((this.mShowDividerHorizontal & 0x4) > 0)) {
            j = this.mDividerHorizontalHeight;
          } else {
            j = 0;
          }
          if (paramBoolean1)
          {
            if (paramBoolean2) {
              this.mFlexboxHelper.layoutSingleChildVertical(localView, localFlexLine, true, paramInt4 - localView.getMeasuredWidth(), Math.round(f1) - localView.getMeasuredHeight(), paramInt4, Math.round(f1));
            } else {
              this.mFlexboxHelper.layoutSingleChildVertical(localView, localFlexLine, true, paramInt4 - localView.getMeasuredWidth(), Math.round(f2), paramInt4, Math.round(f2) + localView.getMeasuredHeight());
            }
          }
          else if (paramBoolean2) {
            this.mFlexboxHelper.layoutSingleChildVertical(localView, localFlexLine, false, i, Math.round(f1) - localView.getMeasuredHeight(), i + localView.getMeasuredWidth(), Math.round(f1));
          } else {
            this.mFlexboxHelper.layoutSingleChildVertical(localView, localFlexLine, false, i, Math.round(f2), i + localView.getMeasuredWidth(), Math.round(f2) + localView.getMeasuredHeight());
          }
          float f6 = localView.getMeasuredHeight();
          float f7 = ((LayoutParams)localObject).bottomMargin;
          f3 = localView.getMeasuredHeight();
          float f5 = ((LayoutParams)localObject).topMargin;
          if (paramBoolean2) {
            localFlexLine.updatePositionFromView(localView, 0, j, 0, paramInt2);
          } else {
            localFlexLine.updatePositionFromView(localView, 0, paramInt2, 0, j);
          }
          f2 += f6 + f4 + f7;
          f3 = f1 - (f3 + f4 + f5);
          f1 = f2;
          f2 = f3;
        }
        paramInt1 += 1;
      }
      paramInt2 = i + localFlexLine.mCrossSize;
      paramInt1 = paramInt4 - localFlexLine.mCrossSize;
      paramInt3 += 1;
    }
  }
  
  private void measureHorizontal(int paramInt1, int paramInt2)
  {
    this.mFlexLines.clear();
    this.mFlexLinesResult.reset();
    this.mFlexboxHelper.calculateHorizontalFlexLines(this.mFlexLinesResult, paramInt1, paramInt2);
    this.mFlexLines = this.mFlexLinesResult.mFlexLines;
    this.mFlexboxHelper.determineMainSize(paramInt1, paramInt2);
    if (this.mAlignItems == 3)
    {
      Iterator localIterator = this.mFlexLines.iterator();
      while (localIterator.hasNext())
      {
        FlexLine localFlexLine = (FlexLine)localIterator.next();
        int k = Integer.MIN_VALUE;
        int j = 0;
        while (j < localFlexLine.mItemCount)
        {
          View localView = getReorderedChildAt(localFlexLine.mFirstIndex + j);
          int i = k;
          if (localView != null) {
            if (localView.getVisibility() == 8)
            {
              i = k;
            }
            else
            {
              LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
              if (this.mFlexWrap != 2)
              {
                i = Math.max(localFlexLine.mMaxBaseline - localView.getBaseline(), localLayoutParams.topMargin);
                i = Math.max(k, localView.getMeasuredHeight() + i + localLayoutParams.bottomMargin);
              }
              else
              {
                i = Math.max(localFlexLine.mMaxBaseline - localView.getMeasuredHeight() + localView.getBaseline(), localLayoutParams.bottomMargin);
                i = Math.max(k, localView.getMeasuredHeight() + localLayoutParams.topMargin + i);
              }
            }
          }
          j += 1;
          k = i;
        }
        localFlexLine.mCrossSize = k;
      }
    }
    this.mFlexboxHelper.determineCrossSize(paramInt1, paramInt2, getPaddingTop() + getPaddingBottom());
    this.mFlexboxHelper.stretchViews();
    setMeasuredDimensionForFlex(this.mFlexDirection, paramInt1, paramInt2, this.mFlexLinesResult.mChildState);
  }
  
  private void measureVertical(int paramInt1, int paramInt2)
  {
    this.mFlexLines.clear();
    this.mFlexLinesResult.reset();
    this.mFlexboxHelper.calculateVerticalFlexLines(this.mFlexLinesResult, paramInt1, paramInt2);
    this.mFlexLines = this.mFlexLinesResult.mFlexLines;
    this.mFlexboxHelper.determineMainSize(paramInt1, paramInt2);
    this.mFlexboxHelper.determineCrossSize(paramInt1, paramInt2, getPaddingLeft() + getPaddingRight());
    this.mFlexboxHelper.stretchViews();
    setMeasuredDimensionForFlex(this.mFlexDirection, paramInt1, paramInt2, this.mFlexLinesResult.mChildState);
  }
  
  private void setMeasuredDimensionForFlex(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = View.MeasureSpec.getMode(paramInt2);
    int m = View.MeasureSpec.getSize(paramInt2);
    int n = View.MeasureSpec.getMode(paramInt3);
    int k = View.MeasureSpec.getSize(paramInt3);
    StringBuilder localStringBuilder;
    int i;
    if ((paramInt1 != 0) && (paramInt1 != 1))
    {
      if ((paramInt1 != 2) && (paramInt1 != 3))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Invalid flex direction: ");
        localStringBuilder.append(paramInt1);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      paramInt1 = getLargestMainSize();
      i = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
    }
    else
    {
      paramInt1 = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
      i = getLargestMainSize();
    }
    if (j != Integer.MIN_VALUE)
    {
      if (j != 0)
      {
        if (j == 1073741824)
        {
          j = paramInt4;
          if (m < i) {
            j = View.combineMeasuredStates(paramInt4, 16777216);
          }
          paramInt2 = View.resolveSizeAndState(m, paramInt2, j);
          paramInt4 = j;
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unknown width mode is set: ");
          localStringBuilder.append(j);
          throw new IllegalStateException(localStringBuilder.toString());
        }
      }
      else {
        paramInt2 = View.resolveSizeAndState(i, paramInt2, paramInt4);
      }
    }
    else
    {
      if (m < i)
      {
        paramInt4 = View.combineMeasuredStates(paramInt4, 16777216);
        i = m;
      }
      paramInt2 = View.resolveSizeAndState(i, paramInt2, paramInt4);
    }
    if (n != Integer.MIN_VALUE)
    {
      if (n != 0)
      {
        if (n == 1073741824)
        {
          i = paramInt4;
          if (k < paramInt1) {
            i = View.combineMeasuredStates(paramInt4, 256);
          }
          paramInt1 = View.resolveSizeAndState(k, paramInt3, i);
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unknown height mode is set: ");
          localStringBuilder.append(n);
          throw new IllegalStateException(localStringBuilder.toString());
        }
      }
      else {
        paramInt1 = View.resolveSizeAndState(paramInt1, paramInt3, paramInt4);
      }
    }
    else
    {
      if (k < paramInt1)
      {
        paramInt4 = View.combineMeasuredStates(paramInt4, 256);
        paramInt1 = k;
      }
      paramInt1 = View.resolveSizeAndState(paramInt1, paramInt3, paramInt4);
    }
    setMeasuredDimension(paramInt2, paramInt1);
  }
  
  private void setWillNotDrawFlag()
  {
    if ((this.mDividerDrawableHorizontal == null) && (this.mDividerDrawableVertical == null))
    {
      setWillNotDraw(true);
      return;
    }
    setWillNotDraw(false);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.mOrderCache == null) {
      this.mOrderCache = new SparseIntArray(getChildCount());
    }
    this.mReorderedIndices = this.mFlexboxHelper.createReorderedIndices(paramView, paramInt, paramLayoutParams, this.mOrderCache);
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LayoutParams)) {
      return new LayoutParams((LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  public int getAlignContent()
  {
    return this.mAlignContent;
  }
  
  public int getAlignItems()
  {
    return this.mAlignItems;
  }
  
  public int getChildHeightMeasureSpec(int paramInt1, int paramInt2, int paramInt3)
  {
    return getChildMeasureSpec(paramInt1, paramInt2, paramInt3);
  }
  
  public int getChildWidthMeasureSpec(int paramInt1, int paramInt2, int paramInt3)
  {
    return getChildMeasureSpec(paramInt1, paramInt2, paramInt3);
  }
  
  public int getDecorationLengthCrossAxis(View paramView)
  {
    return 0;
  }
  
  public int getDecorationLengthMainAxis(View paramView, int paramInt1, int paramInt2)
  {
    boolean bool = isMainAxisDirectionHorizontal();
    int j = 0;
    int i = 0;
    if (bool)
    {
      if (hasDividerBeforeChildAtAlongMainAxis(paramInt1, paramInt2)) {
        i = 0 + this.mDividerVerticalWidth;
      }
      paramInt1 = i;
      if ((this.mShowDividerVertical & 0x4) <= 0) {
        return paramInt1;
      }
      paramInt1 = this.mDividerVerticalWidth;
    }
    else
    {
      i = j;
      if (hasDividerBeforeChildAtAlongMainAxis(paramInt1, paramInt2)) {
        i = 0 + this.mDividerHorizontalHeight;
      }
      paramInt1 = i;
      if ((this.mShowDividerHorizontal & 0x4) <= 0) {
        return paramInt1;
      }
      paramInt1 = this.mDividerHorizontalHeight;
    }
    paramInt1 = i + paramInt1;
    return paramInt1;
  }
  
  public Drawable getDividerDrawableHorizontal()
  {
    return this.mDividerDrawableHorizontal;
  }
  
  public Drawable getDividerDrawableVertical()
  {
    return this.mDividerDrawableVertical;
  }
  
  public int getFlexDirection()
  {
    return this.mFlexDirection;
  }
  
  public View getFlexItemAt(int paramInt)
  {
    return getChildAt(paramInt);
  }
  
  public int getFlexItemCount()
  {
    return getChildCount();
  }
  
  public List<FlexLine> getFlexLines()
  {
    ArrayList localArrayList = new ArrayList(this.mFlexLines.size());
    Iterator localIterator = this.mFlexLines.iterator();
    while (localIterator.hasNext())
    {
      FlexLine localFlexLine = (FlexLine)localIterator.next();
      if (localFlexLine.getItemCountNotGone() != 0) {
        localArrayList.add(localFlexLine);
      }
    }
    return localArrayList;
  }
  
  public List<FlexLine> getFlexLinesInternal()
  {
    return this.mFlexLines;
  }
  
  public int getFlexWrap()
  {
    return this.mFlexWrap;
  }
  
  public int getJustifyContent()
  {
    return this.mJustifyContent;
  }
  
  public int getLargestMainSize()
  {
    Iterator localIterator = this.mFlexLines.iterator();
    for (int i = Integer.MIN_VALUE; localIterator.hasNext(); i = Math.max(i, ((FlexLine)localIterator.next()).mMainSize)) {}
    return i;
  }
  
  public int getMaxLine()
  {
    return this.mMaxLine;
  }
  
  public View getReorderedChildAt(int paramInt)
  {
    if (paramInt >= 0)
    {
      int[] arrayOfInt = this.mReorderedIndices;
      if (paramInt < arrayOfInt.length) {
        return getChildAt(arrayOfInt[paramInt]);
      }
    }
    return null;
  }
  
  public View getReorderedFlexItemAt(int paramInt)
  {
    return getReorderedChildAt(paramInt);
  }
  
  public int getShowDividerHorizontal()
  {
    return this.mShowDividerHorizontal;
  }
  
  public int getShowDividerVertical()
  {
    return this.mShowDividerVertical;
  }
  
  public int getSumOfCrossSize()
  {
    int m = this.mFlexLines.size();
    int k = 0;
    int i = 0;
    while (k < m)
    {
      FlexLine localFlexLine = (FlexLine)this.mFlexLines.get(k);
      int j = i;
      if (hasDividerBeforeFlexLine(k))
      {
        if (isMainAxisDirectionHorizontal()) {
          j = this.mDividerHorizontalHeight;
        } else {
          j = this.mDividerVerticalWidth;
        }
        j = i + j;
      }
      i = j;
      if (hasEndDividerAfterFlexLine(k))
      {
        if (isMainAxisDirectionHorizontal()) {
          i = this.mDividerHorizontalHeight;
        } else {
          i = this.mDividerVerticalWidth;
        }
        i = j + i;
      }
      i += localFlexLine.mCrossSize;
      k += 1;
    }
    return i;
  }
  
  public boolean isMainAxisDirectionHorizontal()
  {
    int i = this.mFlexDirection;
    boolean bool = true;
    if (i != 0)
    {
      if (i == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.mDividerDrawableVertical == null) && (this.mDividerDrawableHorizontal == null)) {
      return;
    }
    if ((this.mShowDividerHorizontal == 0) && (this.mShowDividerVertical == 0)) {
      return;
    }
    int i = ViewCompat.getLayoutDirection(this);
    int j = this.mFlexDirection;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool4 = true;
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3) {
            return;
          }
          if (i == 1) {
            bool1 = true;
          }
          bool2 = bool1;
          if (this.mFlexWrap == 2) {
            bool2 = bool1 ^ true;
          }
          drawDividersVertical(paramCanvas, bool2, true);
          return;
        }
        if (i == 1) {
          bool1 = bool4;
        } else {
          bool1 = false;
        }
        bool2 = bool1;
        if (this.mFlexWrap == 2) {
          bool2 = bool1 ^ true;
        }
        drawDividersVertical(paramCanvas, bool2, false);
        return;
      }
      if (i != 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (this.mFlexWrap == 2) {
        bool2 = true;
      }
      drawDividersHorizontal(paramCanvas, bool1, bool2);
      return;
    }
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    bool2 = bool3;
    if (this.mFlexWrap == 2) {
      bool2 = true;
    }
    drawDividersHorizontal(paramCanvas, bool1, bool2);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = ViewCompat.getLayoutDirection(this);
    int j = this.mFlexDirection;
    boolean bool = false;
    paramBoolean = false;
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2)
        {
          if (j == 3)
          {
            if (i == 1) {
              paramBoolean = true;
            }
            if (this.mFlexWrap == 2) {
              paramBoolean ^= true;
            }
            layoutVertical(paramBoolean, true, paramInt1, paramInt2, paramInt3, paramInt4);
            return;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Invalid flex direction is set: ");
          localStringBuilder.append(this.mFlexDirection);
          throw new IllegalStateException(localStringBuilder.toString());
        }
        paramBoolean = bool;
        if (i == 1) {
          paramBoolean = true;
        }
        if (this.mFlexWrap == 2) {
          paramBoolean ^= true;
        }
        layoutVertical(paramBoolean, false, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      if (i != 1) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      layoutHorizontal(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    if (i == 1) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    layoutHorizontal(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.mOrderCache == null) {
      this.mOrderCache = new SparseIntArray(getChildCount());
    }
    if (this.mFlexboxHelper.isOrderChangedFromLastMeasurement(this.mOrderCache)) {
      this.mReorderedIndices = this.mFlexboxHelper.createReorderedIndices(this.mOrderCache);
    }
    int i = this.mFlexDirection;
    if ((i != 0) && (i != 1))
    {
      if ((i != 2) && (i != 3))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Invalid value for the flex direction is set: ");
        localStringBuilder.append(this.mFlexDirection);
        throw new IllegalStateException(localStringBuilder.toString());
      }
      measureVertical(paramInt1, paramInt2);
      return;
    }
    measureHorizontal(paramInt1, paramInt2);
  }
  
  public void onNewFlexItemAdded(View paramView, int paramInt1, int paramInt2, FlexLine paramFlexLine)
  {
    if (hasDividerBeforeChildAtAlongMainAxis(paramInt1, paramInt2))
    {
      if (isMainAxisDirectionHorizontal())
      {
        paramFlexLine.mMainSize += this.mDividerVerticalWidth;
        paramFlexLine.mDividerLengthInMainSize += this.mDividerVerticalWidth;
        return;
      }
      paramFlexLine.mMainSize += this.mDividerHorizontalHeight;
      paramFlexLine.mDividerLengthInMainSize += this.mDividerHorizontalHeight;
    }
  }
  
  public void onNewFlexLineAdded(FlexLine paramFlexLine)
  {
    if (isMainAxisDirectionHorizontal())
    {
      if ((this.mShowDividerVertical & 0x4) > 0)
      {
        paramFlexLine.mMainSize += this.mDividerVerticalWidth;
        paramFlexLine.mDividerLengthInMainSize += this.mDividerVerticalWidth;
      }
    }
    else if ((this.mShowDividerHorizontal & 0x4) > 0)
    {
      paramFlexLine.mMainSize += this.mDividerHorizontalHeight;
      paramFlexLine.mDividerLengthInMainSize += this.mDividerHorizontalHeight;
    }
  }
  
  public void setAlignContent(int paramInt)
  {
    if (this.mAlignContent != paramInt)
    {
      this.mAlignContent = paramInt;
      requestLayout();
    }
  }
  
  public void setAlignItems(int paramInt)
  {
    if (this.mAlignItems != paramInt)
    {
      this.mAlignItems = paramInt;
      requestLayout();
    }
  }
  
  public void setDividerDrawable(Drawable paramDrawable)
  {
    setDividerDrawableHorizontal(paramDrawable);
    setDividerDrawableVertical(paramDrawable);
  }
  
  public void setDividerDrawableHorizontal(Drawable paramDrawable)
  {
    if (paramDrawable == this.mDividerDrawableHorizontal) {
      return;
    }
    this.mDividerDrawableHorizontal = paramDrawable;
    if (paramDrawable != null) {
      this.mDividerHorizontalHeight = paramDrawable.getIntrinsicHeight();
    } else {
      this.mDividerHorizontalHeight = 0;
    }
    setWillNotDrawFlag();
    requestLayout();
  }
  
  public void setDividerDrawableVertical(Drawable paramDrawable)
  {
    if (paramDrawable == this.mDividerDrawableVertical) {
      return;
    }
    this.mDividerDrawableVertical = paramDrawable;
    if (paramDrawable != null) {
      this.mDividerVerticalWidth = paramDrawable.getIntrinsicWidth();
    } else {
      this.mDividerVerticalWidth = 0;
    }
    setWillNotDrawFlag();
    requestLayout();
  }
  
  public void setFlexDirection(int paramInt)
  {
    if (this.mFlexDirection != paramInt)
    {
      this.mFlexDirection = paramInt;
      requestLayout();
    }
  }
  
  public void setFlexLines(List<FlexLine> paramList)
  {
    this.mFlexLines = paramList;
  }
  
  public void setFlexWrap(int paramInt)
  {
    if (this.mFlexWrap != paramInt)
    {
      this.mFlexWrap = paramInt;
      requestLayout();
    }
  }
  
  public void setJustifyContent(int paramInt)
  {
    if (this.mJustifyContent != paramInt)
    {
      this.mJustifyContent = paramInt;
      requestLayout();
    }
  }
  
  public void setMaxLine(int paramInt)
  {
    if (this.mMaxLine != paramInt)
    {
      this.mMaxLine = paramInt;
      requestLayout();
    }
  }
  
  public void setShowDivider(int paramInt)
  {
    setShowDividerVertical(paramInt);
    setShowDividerHorizontal(paramInt);
  }
  
  public void setShowDividerHorizontal(int paramInt)
  {
    if (paramInt != this.mShowDividerHorizontal)
    {
      this.mShowDividerHorizontal = paramInt;
      requestLayout();
    }
  }
  
  public void setShowDividerVertical(int paramInt)
  {
    if (paramInt != this.mShowDividerVertical)
    {
      this.mShowDividerVertical = paramInt;
      requestLayout();
    }
  }
  
  public void updateViewCache(int paramInt, View paramView) {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DividerMode {}
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
    implements FlexItem
  {
    public static final Parcelable.Creator<LayoutParams> CREATOR = new Parcelable.Creator()
    {
      public FlexboxLayout.LayoutParams createFromParcel(Parcel paramAnonymousParcel)
      {
        return new FlexboxLayout.LayoutParams(paramAnonymousParcel);
      }
      
      public FlexboxLayout.LayoutParams[] newArray(int paramAnonymousInt)
      {
        return new FlexboxLayout.LayoutParams[paramAnonymousInt];
      }
    };
    private int mAlignSelf = -1;
    private float mFlexBasisPercent = -1.0F;
    private float mFlexGrow = 0.0F;
    private float mFlexShrink = 1.0F;
    private int mMaxHeight = 16777215;
    private int mMaxWidth = 16777215;
    private int mMinHeight = -1;
    private int mMinWidth = -1;
    private int mOrder = 1;
    private boolean mWrapBefore;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super();
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FlexboxLayout_Layout);
      this.mOrder = paramContext.getInt(R.styleable.FlexboxLayout_Layout_layout_order, 1);
      this.mFlexGrow = paramContext.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexGrow, 0.0F);
      this.mFlexShrink = paramContext.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexShrink, 1.0F);
      this.mAlignSelf = paramContext.getInt(R.styleable.FlexboxLayout_Layout_layout_alignSelf, -1);
      this.mFlexBasisPercent = paramContext.getFraction(R.styleable.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0F);
      this.mMinWidth = paramContext.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minWidth, -1);
      this.mMinHeight = paramContext.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minHeight, -1);
      this.mMaxWidth = paramContext.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxWidth, 16777215);
      this.mMaxHeight = paramContext.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxHeight, 16777215);
      this.mWrapBefore = paramContext.getBoolean(R.styleable.FlexboxLayout_Layout_layout_wrapBefore, false);
      paramContext.recycle();
    }
    
    protected LayoutParams(Parcel paramParcel)
    {
      super(0);
      this.mOrder = paramParcel.readInt();
      this.mFlexGrow = paramParcel.readFloat();
      this.mFlexShrink = paramParcel.readFloat();
      this.mAlignSelf = paramParcel.readInt();
      this.mFlexBasisPercent = paramParcel.readFloat();
      this.mMinWidth = paramParcel.readInt();
      this.mMinHeight = paramParcel.readInt();
      this.mMaxWidth = paramParcel.readInt();
      this.mMaxHeight = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {
        bool = true;
      }
      this.mWrapBefore = bool;
      this.bottomMargin = paramParcel.readInt();
      this.leftMargin = paramParcel.readInt();
      this.rightMargin = paramParcel.readInt();
      this.topMargin = paramParcel.readInt();
      this.height = paramParcel.readInt();
      this.width = paramParcel.readInt();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.mOrder = paramLayoutParams.mOrder;
      this.mFlexGrow = paramLayoutParams.mFlexGrow;
      this.mFlexShrink = paramLayoutParams.mFlexShrink;
      this.mAlignSelf = paramLayoutParams.mAlignSelf;
      this.mFlexBasisPercent = paramLayoutParams.mFlexBasisPercent;
      this.mMinWidth = paramLayoutParams.mMinWidth;
      this.mMinHeight = paramLayoutParams.mMinHeight;
      this.mMaxWidth = paramLayoutParams.mMaxWidth;
      this.mMaxHeight = paramLayoutParams.mMaxHeight;
      this.mWrapBefore = paramLayoutParams.mWrapBefore;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public int getAlignSelf()
    {
      return this.mAlignSelf;
    }
    
    public float getFlexBasisPercent()
    {
      return this.mFlexBasisPercent;
    }
    
    public float getFlexGrow()
    {
      return this.mFlexGrow;
    }
    
    public float getFlexShrink()
    {
      return this.mFlexShrink;
    }
    
    public int getHeight()
    {
      return this.height;
    }
    
    public int getMarginBottom()
    {
      return this.bottomMargin;
    }
    
    public int getMarginLeft()
    {
      return this.leftMargin;
    }
    
    public int getMarginRight()
    {
      return this.rightMargin;
    }
    
    public int getMarginTop()
    {
      return this.topMargin;
    }
    
    public int getMaxHeight()
    {
      return this.mMaxHeight;
    }
    
    public int getMaxWidth()
    {
      return this.mMaxWidth;
    }
    
    public int getMinHeight()
    {
      return this.mMinHeight;
    }
    
    public int getMinWidth()
    {
      return this.mMinWidth;
    }
    
    public int getOrder()
    {
      return this.mOrder;
    }
    
    public int getWidth()
    {
      return this.width;
    }
    
    public boolean isWrapBefore()
    {
      return this.mWrapBefore;
    }
    
    public void setAlignSelf(int paramInt)
    {
      this.mAlignSelf = paramInt;
    }
    
    public void setFlexBasisPercent(float paramFloat)
    {
      this.mFlexBasisPercent = paramFloat;
    }
    
    public void setFlexGrow(float paramFloat)
    {
      this.mFlexGrow = paramFloat;
    }
    
    public void setFlexShrink(float paramFloat)
    {
      this.mFlexShrink = paramFloat;
    }
    
    public void setHeight(int paramInt)
    {
      this.height = paramInt;
    }
    
    public void setMaxHeight(int paramInt)
    {
      this.mMaxHeight = paramInt;
    }
    
    public void setMaxWidth(int paramInt)
    {
      this.mMaxWidth = paramInt;
    }
    
    public void setMinHeight(int paramInt)
    {
      this.mMinHeight = paramInt;
    }
    
    public void setMinWidth(int paramInt)
    {
      this.mMinWidth = paramInt;
    }
    
    public void setOrder(int paramInt)
    {
      this.mOrder = paramInt;
    }
    
    public void setWidth(int paramInt)
    {
      this.width = paramInt;
    }
    
    public void setWrapBefore(boolean paramBoolean)
    {
      this.mWrapBefore = paramBoolean;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\flexbox\FlexboxLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */