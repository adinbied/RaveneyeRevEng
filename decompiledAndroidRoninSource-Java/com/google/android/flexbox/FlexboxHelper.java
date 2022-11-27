package com.google.android.flexbox;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.CompoundButton;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.widget.CompoundButtonCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class FlexboxHelper
{
  private static final int INITIAL_CAPACITY = 10;
  private static final long MEASURE_SPEC_WIDTH_MASK = 4294967295L;
  private boolean[] mChildrenFrozen;
  private final FlexContainer mFlexContainer;
  int[] mIndexToFlexLine;
  long[] mMeasureSpecCache;
  private long[] mMeasuredSizeCache;
  
  FlexboxHelper(FlexContainer paramFlexContainer)
  {
    this.mFlexContainer = paramFlexContainer;
  }
  
  private void addFlexLine(List<FlexLine> paramList, FlexLine paramFlexLine, int paramInt1, int paramInt2)
  {
    paramFlexLine.mSumCrossSizeBefore = paramInt2;
    this.mFlexContainer.onNewFlexLineAdded(paramFlexLine);
    paramFlexLine.mLastIndex = paramInt1;
    paramList.add(paramFlexLine);
  }
  
  private void checkSizeConstraints(View paramView, int paramInt)
  {
    FlexItem localFlexItem = (FlexItem)paramView.getLayoutParams();
    int j = paramView.getMeasuredWidth();
    int m = paramView.getMeasuredHeight();
    int i = localFlexItem.getMinWidth();
    int k = 1;
    if (j < i) {}
    for (i = localFlexItem.getMinWidth();; i = localFlexItem.getMaxWidth())
    {
      int n = 1;
      j = i;
      i = n;
      break label83;
      if (j <= localFlexItem.getMaxWidth()) {
        break;
      }
    }
    i = 0;
    label83:
    if (m < localFlexItem.getMinHeight())
    {
      i = localFlexItem.getMinHeight();
    }
    else if (m > localFlexItem.getMaxHeight())
    {
      i = localFlexItem.getMaxHeight();
    }
    else
    {
      k = i;
      i = m;
    }
    if (k != 0)
    {
      j = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
      i = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
      paramView.measure(j, i);
      updateMeasureCache(paramInt, j, i, paramView);
      this.mFlexContainer.updateViewCache(paramInt, paramView);
    }
  }
  
  private List<FlexLine> constructFlexLinesForAlignContentCenter(List<FlexLine> paramList, int paramInt1, int paramInt2)
  {
    paramInt1 = (paramInt1 - paramInt2) / 2;
    ArrayList localArrayList = new ArrayList();
    FlexLine localFlexLine = new FlexLine();
    localFlexLine.mCrossSize = paramInt1;
    paramInt2 = paramList.size();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      if (paramInt1 == 0) {
        localArrayList.add(localFlexLine);
      }
      localArrayList.add((FlexLine)paramList.get(paramInt1));
      if (paramInt1 == paramList.size() - 1) {
        localArrayList.add(localFlexLine);
      }
      paramInt1 += 1;
    }
    return localArrayList;
  }
  
  private List<Order> createOrders(int paramInt)
  {
    ArrayList localArrayList = new ArrayList(paramInt);
    int i = 0;
    while (i < paramInt)
    {
      FlexItem localFlexItem = (FlexItem)this.mFlexContainer.getFlexItemAt(i).getLayoutParams();
      Order localOrder = new Order(null);
      localOrder.order = localFlexItem.getOrder();
      localOrder.index = i;
      localArrayList.add(localOrder);
      i += 1;
    }
    return localArrayList;
  }
  
  private void ensureChildrenFrozen(int paramInt)
  {
    boolean[] arrayOfBoolean = this.mChildrenFrozen;
    int i;
    if (arrayOfBoolean == null)
    {
      i = paramInt;
      if (paramInt < 10) {
        i = 10;
      }
      this.mChildrenFrozen = new boolean[i];
      return;
    }
    if (arrayOfBoolean.length < paramInt)
    {
      int j = arrayOfBoolean.length * 2;
      i = paramInt;
      if (j >= paramInt) {
        i = j;
      }
      this.mChildrenFrozen = new boolean[i];
      return;
    }
    Arrays.fill(arrayOfBoolean, false);
  }
  
  private void evaluateMinimumSizeForCompoundButton(CompoundButton paramCompoundButton)
  {
    FlexItem localFlexItem = (FlexItem)paramCompoundButton.getLayoutParams();
    int n = localFlexItem.getMinWidth();
    int m = localFlexItem.getMinHeight();
    paramCompoundButton = CompoundButtonCompat.getButtonDrawable(paramCompoundButton);
    int j = 0;
    if (paramCompoundButton == null) {
      i = 0;
    } else {
      i = paramCompoundButton.getMinimumWidth();
    }
    if (paramCompoundButton != null) {
      j = paramCompoundButton.getMinimumHeight();
    }
    int k = n;
    if (n == -1) {
      k = i;
    }
    localFlexItem.setMinWidth(k);
    int i = m;
    if (m == -1) {
      i = j;
    }
    localFlexItem.setMinHeight(i);
  }
  
  private void expandFlexItems(int paramInt1, int paramInt2, FlexLine paramFlexLine, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (paramFlexLine.mTotalFlexGrow > 0.0F)
    {
      if (paramInt3 < paramFlexLine.mMainSize) {
        return;
      }
      int j = paramFlexLine.mMainSize;
      float f5 = (paramInt3 - paramFlexLine.mMainSize) / paramFlexLine.mTotalFlexGrow;
      paramFlexLine.mMainSize = (paramInt4 + paramFlexLine.mDividerLengthInMainSize);
      if (!paramBoolean) {
        paramFlexLine.mCrossSize = Integer.MIN_VALUE;
      }
      int n = 0;
      int i = 0;
      int i1 = 0;
      float f1 = 0.0F;
      while (n < paramFlexLine.mItemCount)
      {
        int i3 = paramFlexLine.mFirstIndex + n;
        View localView = this.mFlexContainer.getReorderedFlexItemAt(i3);
        if ((localView != null) && (localView.getVisibility() != 8))
        {
          FlexItem localFlexItem = (FlexItem)localView.getLayoutParams();
          int k = this.mFlexContainer.getFlexDirection();
          long[] arrayOfLong;
          int m;
          float f4;
          float f2;
          float f3;
          int i2;
          double d;
          int i4;
          if ((k != 0) && (k != 1))
          {
            k = localView.getMeasuredHeight();
            arrayOfLong = this.mMeasuredSizeCache;
            if (arrayOfLong != null) {
              k = extractHigherInt(arrayOfLong[i3]);
            }
            m = localView.getMeasuredWidth();
            arrayOfLong = this.mMeasuredSizeCache;
            if (arrayOfLong != null) {
              m = extractLowerInt(arrayOfLong[i3]);
            }
            if ((this.mChildrenFrozen[i3] == 0) && (localFlexItem.getFlexGrow() > 0.0F))
            {
              f4 = k + localFlexItem.getFlexGrow() * f5;
              f2 = f1;
              f3 = f4;
              if (n == paramFlexLine.mItemCount - 1)
              {
                f3 = f4 + f1;
                f2 = 0.0F;
              }
              i2 = Math.round(f3);
              if (i2 > localFlexItem.getMaxHeight())
              {
                m = localFlexItem.getMaxHeight();
                this.mChildrenFrozen[i3] = true;
                paramFlexLine.mTotalFlexGrow -= localFlexItem.getFlexGrow();
                k = 1;
                f1 = f2;
              }
              else
              {
                f1 = f2 + (f3 - i2);
                d = f1;
                if (d > 1.0D) {
                  m = i2 + 1;
                }
                for (d -= 1.0D;; d += 1.0D)
                {
                  f1 = (float)d;
                  k = i;
                  break;
                  k = i;
                  m = i2;
                  if (d >= -1.0D) {
                    break;
                  }
                  m = i2 - 1;
                }
              }
              i = getChildWidthMeasureSpecInternal(paramInt1, localFlexItem, paramFlexLine.mSumCrossSizeBefore);
              i4 = View.MeasureSpec.makeMeasureSpec(m, 1073741824);
              localView.measure(i, i4);
              i2 = localView.getMeasuredWidth();
              m = localView.getMeasuredHeight();
              updateMeasureCache(i3, i, i4, localView);
              this.mFlexContainer.updateViewCache(i3, localView);
              i = k;
              k = m;
              m = i2;
            }
            m = Math.max(i1, m + localFlexItem.getMarginLeft() + localFlexItem.getMarginRight() + this.mFlexContainer.getDecorationLengthCrossAxis(localView));
            paramFlexLine.mMainSize += k + localFlexItem.getMarginTop() + localFlexItem.getMarginBottom();
            k = m;
          }
          else
          {
            k = localView.getMeasuredWidth();
            arrayOfLong = this.mMeasuredSizeCache;
            if (arrayOfLong != null) {
              k = extractLowerInt(arrayOfLong[i3]);
            }
            i2 = localView.getMeasuredHeight();
            arrayOfLong = this.mMeasuredSizeCache;
            m = j;
            j = i2;
            if (arrayOfLong != null) {
              j = extractHigherInt(arrayOfLong[i3]);
            }
            if ((this.mChildrenFrozen[i3] == 0) && (localFlexItem.getFlexGrow() > 0.0F))
            {
              f4 = k + localFlexItem.getFlexGrow() * f5;
              f3 = f4;
              f2 = f1;
              if (n == paramFlexLine.mItemCount - 1)
              {
                f3 = f4 + f1;
                f2 = 0.0F;
              }
              i2 = Math.round(f3);
              if (i2 > localFlexItem.getMaxWidth())
              {
                k = localFlexItem.getMaxWidth();
                this.mChildrenFrozen[i3] = true;
                paramFlexLine.mTotalFlexGrow -= localFlexItem.getFlexGrow();
                j = 1;
                f1 = f2;
              }
              else
              {
                f1 = f2 + (f3 - i2);
                d = f1;
                if (d > 1.0D) {
                  k = i2 + 1;
                }
                for (d -= 1.0D;; d += 1.0D)
                {
                  f1 = (float)d;
                  j = i;
                  break;
                  k = i2;
                  j = i;
                  if (d >= -1.0D) {
                    break;
                  }
                  k = i2 - 1;
                }
              }
              i = getChildHeightMeasureSpecInternal(paramInt2, localFlexItem, paramFlexLine.mSumCrossSizeBefore);
              i4 = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
              localView.measure(i4, i);
              k = localView.getMeasuredWidth();
              i2 = localView.getMeasuredHeight();
              updateMeasureCache(i3, i4, i, localView);
              this.mFlexContainer.updateViewCache(i3, localView);
              i = j;
            }
            else
            {
              i2 = j;
            }
            j = Math.max(i1, i2 + localFlexItem.getMarginTop() + localFlexItem.getMarginBottom() + this.mFlexContainer.getDecorationLengthCrossAxis(localView));
            paramFlexLine.mMainSize += k + localFlexItem.getMarginLeft() + localFlexItem.getMarginRight();
            k = j;
            j = m;
          }
          paramFlexLine.mCrossSize = Math.max(paramFlexLine.mCrossSize, k);
          i1 = k;
        }
        n += 1;
      }
      if ((i != 0) && (j != paramFlexLine.mMainSize)) {
        expandFlexItems(paramInt1, paramInt2, paramFlexLine, paramInt3, paramInt4, true);
      }
    }
  }
  
  private int getChildHeightMeasureSpecInternal(int paramInt1, FlexItem paramFlexItem, int paramInt2)
  {
    FlexContainer localFlexContainer = this.mFlexContainer;
    paramInt2 = localFlexContainer.getChildHeightMeasureSpec(paramInt1, localFlexContainer.getPaddingTop() + this.mFlexContainer.getPaddingBottom() + paramFlexItem.getMarginTop() + paramFlexItem.getMarginBottom() + paramInt2, paramFlexItem.getHeight());
    int i = View.MeasureSpec.getSize(paramInt2);
    if (i > paramFlexItem.getMaxHeight()) {
      return View.MeasureSpec.makeMeasureSpec(paramFlexItem.getMaxHeight(), View.MeasureSpec.getMode(paramInt2));
    }
    paramInt1 = paramInt2;
    if (i < paramFlexItem.getMinHeight()) {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(paramFlexItem.getMinHeight(), View.MeasureSpec.getMode(paramInt2));
    }
    return paramInt1;
  }
  
  private int getChildWidthMeasureSpecInternal(int paramInt1, FlexItem paramFlexItem, int paramInt2)
  {
    FlexContainer localFlexContainer = this.mFlexContainer;
    paramInt2 = localFlexContainer.getChildWidthMeasureSpec(paramInt1, localFlexContainer.getPaddingLeft() + this.mFlexContainer.getPaddingRight() + paramFlexItem.getMarginLeft() + paramFlexItem.getMarginRight() + paramInt2, paramFlexItem.getWidth());
    int i = View.MeasureSpec.getSize(paramInt2);
    if (i > paramFlexItem.getMaxWidth()) {
      return View.MeasureSpec.makeMeasureSpec(paramFlexItem.getMaxWidth(), View.MeasureSpec.getMode(paramInt2));
    }
    paramInt1 = paramInt2;
    if (i < paramFlexItem.getMinWidth()) {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(paramFlexItem.getMinWidth(), View.MeasureSpec.getMode(paramInt2));
    }
    return paramInt1;
  }
  
  private int getFlexItemMarginEndCross(FlexItem paramFlexItem, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramFlexItem.getMarginBottom();
    }
    return paramFlexItem.getMarginRight();
  }
  
  private int getFlexItemMarginEndMain(FlexItem paramFlexItem, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramFlexItem.getMarginRight();
    }
    return paramFlexItem.getMarginBottom();
  }
  
  private int getFlexItemMarginStartCross(FlexItem paramFlexItem, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramFlexItem.getMarginTop();
    }
    return paramFlexItem.getMarginLeft();
  }
  
  private int getFlexItemMarginStartMain(FlexItem paramFlexItem, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramFlexItem.getMarginLeft();
    }
    return paramFlexItem.getMarginTop();
  }
  
  private int getFlexItemSizeCross(FlexItem paramFlexItem, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramFlexItem.getHeight();
    }
    return paramFlexItem.getWidth();
  }
  
  private int getFlexItemSizeMain(FlexItem paramFlexItem, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramFlexItem.getWidth();
    }
    return paramFlexItem.getHeight();
  }
  
  private int getPaddingEndCross(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.mFlexContainer.getPaddingBottom();
    }
    return this.mFlexContainer.getPaddingEnd();
  }
  
  private int getPaddingEndMain(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.mFlexContainer.getPaddingEnd();
    }
    return this.mFlexContainer.getPaddingBottom();
  }
  
  private int getPaddingStartCross(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.mFlexContainer.getPaddingTop();
    }
    return this.mFlexContainer.getPaddingStart();
  }
  
  private int getPaddingStartMain(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.mFlexContainer.getPaddingStart();
    }
    return this.mFlexContainer.getPaddingTop();
  }
  
  private int getViewMeasuredSizeCross(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramView.getMeasuredHeight();
    }
    return paramView.getMeasuredWidth();
  }
  
  private int getViewMeasuredSizeMain(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramView.getMeasuredWidth();
    }
    return paramView.getMeasuredHeight();
  }
  
  private boolean isLastFlexItem(int paramInt1, int paramInt2, FlexLine paramFlexLine)
  {
    return (paramInt1 == paramInt2 - 1) && (paramFlexLine.getItemCountNotGone() != 0);
  }
  
  private boolean isWrapRequired(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, FlexItem paramFlexItem, int paramInt5, int paramInt6, int paramInt7)
  {
    int i = this.mFlexContainer.getFlexWrap();
    boolean bool = false;
    if (i == 0) {
      return false;
    }
    if (paramFlexItem.isWrapBefore()) {
      return true;
    }
    if (paramInt1 == 0) {
      return false;
    }
    paramInt1 = this.mFlexContainer.getMaxLine();
    if ((paramInt1 != -1) && (paramInt1 <= paramInt7 + 1)) {
      return false;
    }
    paramInt5 = this.mFlexContainer.getDecorationLengthMainAxis(paramView, paramInt5, paramInt6);
    paramInt1 = paramInt4;
    if (paramInt5 > 0) {
      paramInt1 = paramInt4 + paramInt5;
    }
    if (paramInt2 < paramInt3 + paramInt1) {
      bool = true;
    }
    return bool;
  }
  
  private void shrinkFlexItems(int paramInt1, int paramInt2, FlexLine paramFlexLine, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    int i2 = paramFlexLine.mMainSize;
    if (paramFlexLine.mTotalFlexShrink > 0.0F)
    {
      if (paramInt3 > paramFlexLine.mMainSize) {
        return;
      }
      float f5 = (paramFlexLine.mMainSize - paramInt3) / paramFlexLine.mTotalFlexShrink;
      paramFlexLine.mMainSize = (paramInt4 + paramFlexLine.mDividerLengthInMainSize);
      if (!paramBoolean) {
        paramFlexLine.mCrossSize = Integer.MIN_VALUE;
      }
      int m = 0;
      int i = 0;
      int n = 0;
      float f1 = 0.0F;
      while (m < paramFlexLine.mItemCount)
      {
        int i3 = paramFlexLine.mFirstIndex + m;
        View localView = this.mFlexContainer.getReorderedFlexItemAt(i3);
        if ((localView != null) && (localView.getVisibility() != 8))
        {
          FlexItem localFlexItem = (FlexItem)localView.getLayoutParams();
          int j = this.mFlexContainer.getFlexDirection();
          long[] arrayOfLong;
          int k;
          float f4;
          float f2;
          float f3;
          int i1;
          double d;
          int i4;
          if ((j != 0) && (j != 1))
          {
            j = localView.getMeasuredHeight();
            arrayOfLong = this.mMeasuredSizeCache;
            if (arrayOfLong != null) {
              j = extractHigherInt(arrayOfLong[i3]);
            }
            k = localView.getMeasuredWidth();
            arrayOfLong = this.mMeasuredSizeCache;
            if (arrayOfLong != null) {
              k = extractLowerInt(arrayOfLong[i3]);
            }
            if ((this.mChildrenFrozen[i3] == 0) && (localFlexItem.getFlexShrink() > 0.0F))
            {
              f4 = j - localFlexItem.getFlexShrink() * f5;
              f2 = f1;
              f3 = f4;
              if (m == paramFlexLine.mItemCount - 1)
              {
                f3 = f4 + f1;
                f2 = 0.0F;
              }
              i1 = Math.round(f3);
              if (i1 < localFlexItem.getMinHeight())
              {
                j = localFlexItem.getMinHeight();
                this.mChildrenFrozen[i3] = true;
                paramFlexLine.mTotalFlexShrink -= localFlexItem.getFlexShrink();
                k = 1;
                f1 = f2;
              }
              else
              {
                f2 += f3 - i1;
                d = f2;
                if (d > 1.0D)
                {
                  j = i1 + 1;
                  f1 = f2 - 1.0F;
                  k = i;
                }
                else
                {
                  k = i;
                  f1 = f2;
                  j = i1;
                  if (d < -1.0D)
                  {
                    j = i1 - 1;
                    f1 = f2 + 1.0F;
                    k = i;
                  }
                }
              }
              i = getChildWidthMeasureSpecInternal(paramInt1, localFlexItem, paramFlexLine.mSumCrossSizeBefore);
              i4 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
              localView.measure(i, i4);
              i1 = localView.getMeasuredWidth();
              j = localView.getMeasuredHeight();
              updateMeasureCache(i3, i, i4, localView);
              this.mFlexContainer.updateViewCache(i3, localView);
              i = k;
              k = i1;
            }
            k = Math.max(n, k + localFlexItem.getMarginLeft() + localFlexItem.getMarginRight() + this.mFlexContainer.getDecorationLengthCrossAxis(localView));
            paramFlexLine.mMainSize += j + localFlexItem.getMarginTop() + localFlexItem.getMarginBottom();
            j = k;
          }
          else
          {
            j = localView.getMeasuredWidth();
            arrayOfLong = this.mMeasuredSizeCache;
            if (arrayOfLong != null) {
              j = extractLowerInt(arrayOfLong[i3]);
            }
            k = localView.getMeasuredHeight();
            arrayOfLong = this.mMeasuredSizeCache;
            if (arrayOfLong != null) {
              k = extractHigherInt(arrayOfLong[i3]);
            }
            if ((this.mChildrenFrozen[i3] == 0) && (localFlexItem.getFlexShrink() > 0.0F))
            {
              f4 = j - localFlexItem.getFlexShrink() * f5;
              f3 = f4;
              f2 = f1;
              if (m == paramFlexLine.mItemCount - 1)
              {
                f3 = f4 + f1;
                f2 = 0.0F;
              }
              i1 = Math.round(f3);
              if (i1 < localFlexItem.getMinWidth())
              {
                j = localFlexItem.getMinWidth();
                this.mChildrenFrozen[i3] = true;
                paramFlexLine.mTotalFlexShrink -= localFlexItem.getFlexShrink();
                k = 1;
                f1 = f2;
              }
              else
              {
                f2 += f3 - i1;
                d = f2;
                if (d > 1.0D)
                {
                  j = i1 + 1;
                  f1 = f2 - 1.0F;
                  k = i;
                }
                else
                {
                  k = i;
                  f1 = f2;
                  j = i1;
                  if (d < -1.0D)
                  {
                    j = i1 - 1;
                    f1 = f2 + 1.0F;
                    k = i;
                  }
                }
              }
              i = getChildHeightMeasureSpecInternal(paramInt2, localFlexItem, paramFlexLine.mSumCrossSizeBefore);
              i4 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
              localView.measure(i4, i);
              j = localView.getMeasuredWidth();
              i1 = localView.getMeasuredHeight();
              updateMeasureCache(i3, i4, i, localView);
              this.mFlexContainer.updateViewCache(i3, localView);
              i = k;
              k = i1;
            }
            k = Math.max(n, k + localFlexItem.getMarginTop() + localFlexItem.getMarginBottom() + this.mFlexContainer.getDecorationLengthCrossAxis(localView));
            paramFlexLine.mMainSize += j + localFlexItem.getMarginLeft() + localFlexItem.getMarginRight();
            j = k;
          }
          paramFlexLine.mCrossSize = Math.max(paramFlexLine.mCrossSize, j);
          n = j;
        }
        m += 1;
      }
      if ((i != 0) && (i2 != paramFlexLine.mMainSize)) {
        shrinkFlexItems(paramInt1, paramInt2, paramFlexLine, paramInt3, paramInt4, true);
      }
    }
  }
  
  private int[] sortOrdersIntoReorderedIndices(int paramInt, List<Order> paramList, SparseIntArray paramSparseIntArray)
  {
    Collections.sort(paramList);
    paramSparseIntArray.clear();
    int[] arrayOfInt = new int[paramInt];
    paramList = paramList.iterator();
    paramInt = 0;
    while (paramList.hasNext())
    {
      Order localOrder = (Order)paramList.next();
      arrayOfInt[paramInt] = localOrder.index;
      paramSparseIntArray.append(localOrder.index, localOrder.order);
      paramInt += 1;
    }
    return arrayOfInt;
  }
  
  private void stretchViewHorizontally(View paramView, int paramInt1, int paramInt2)
  {
    Object localObject = (FlexItem)paramView.getLayoutParams();
    int i = Math.min(Math.max(paramInt1 - ((FlexItem)localObject).getMarginLeft() - ((FlexItem)localObject).getMarginRight() - this.mFlexContainer.getDecorationLengthCrossAxis(paramView), ((FlexItem)localObject).getMinWidth()), ((FlexItem)localObject).getMaxWidth());
    localObject = this.mMeasuredSizeCache;
    if (localObject != null) {
      paramInt1 = extractHigherInt(localObject[paramInt2]);
    } else {
      paramInt1 = paramView.getMeasuredHeight();
    }
    paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    i = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
    paramView.measure(i, paramInt1);
    updateMeasureCache(paramInt2, i, paramInt1, paramView);
    this.mFlexContainer.updateViewCache(paramInt2, paramView);
  }
  
  private void stretchViewVertically(View paramView, int paramInt1, int paramInt2)
  {
    Object localObject = (FlexItem)paramView.getLayoutParams();
    int i = Math.min(Math.max(paramInt1 - ((FlexItem)localObject).getMarginTop() - ((FlexItem)localObject).getMarginBottom() - this.mFlexContainer.getDecorationLengthCrossAxis(paramView), ((FlexItem)localObject).getMinHeight()), ((FlexItem)localObject).getMaxHeight());
    localObject = this.mMeasuredSizeCache;
    if (localObject != null) {
      paramInt1 = extractLowerInt(localObject[paramInt2]);
    } else {
      paramInt1 = paramView.getMeasuredWidth();
    }
    paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    i = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
    paramView.measure(paramInt1, i);
    updateMeasureCache(paramInt2, paramInt1, i, paramView);
    this.mFlexContainer.updateViewCache(paramInt2, paramView);
  }
  
  private void updateMeasureCache(int paramInt1, int paramInt2, int paramInt3, View paramView)
  {
    long[] arrayOfLong = this.mMeasureSpecCache;
    if (arrayOfLong != null) {
      arrayOfLong[paramInt1] = makeCombinedLong(paramInt2, paramInt3);
    }
    arrayOfLong = this.mMeasuredSizeCache;
    if (arrayOfLong != null) {
      arrayOfLong[paramInt1] = makeCombinedLong(paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
    }
  }
  
  void calculateFlexLines(FlexLinesResult paramFlexLinesResult, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, List<FlexLine> paramList)
  {
    int n = paramInt2;
    int i1 = paramInt5;
    boolean bool = this.mFlexContainer.isMainAxisDirectionHorizontal();
    int i3 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt1);
    Object localObject1;
    if (paramList == null) {
      localObject1 = new ArrayList();
    } else {
      localObject1 = paramList;
    }
    paramFlexLinesResult.mFlexLines = ((List)localObject1);
    if (i1 == -1) {
      i = 1;
    } else {
      i = 0;
    }
    int j = getPaddingStartMain(bool);
    int k = getPaddingEndMain(bool);
    int i10 = getPaddingStartCross(bool);
    int i11 = getPaddingEndCross(bool);
    paramList = new FlexLine();
    paramList.mFirstIndex = paramInt4;
    int i4 = k + j;
    paramList.mMainSize = i4;
    int i5 = this.mFlexContainer.getFlexItemCount();
    int i7 = 0;
    int m = 0;
    int i6 = 0;
    k = Integer.MIN_VALUE;
    j = i;
    int i = i7;
    for (;;)
    {
      i7 = paramInt1;
      if (paramInt4 >= i5) {
        break;
      }
      View localView = this.mFlexContainer.getReorderedFlexItemAt(paramInt4);
      if (localView == null)
      {
        if (isLastFlexItem(paramInt4, i5, paramList)) {
          addFlexLine((List)localObject1, paramList, paramInt4, i);
        }
      }
      else
      {
        if (localView.getVisibility() != 8) {
          break label312;
        }
        paramList.mGoneItemCount += 1;
        paramList.mItemCount += 1;
        if (isLastFlexItem(paramInt4, i5, paramList)) {
          addFlexLine((List)localObject1, paramList, paramInt4, i);
        }
      }
      i7 = n;
      n = i;
      i = i7;
      int i9 = paramInt4;
      paramInt4 = i1;
      int i8 = j;
      i7 = i6;
      break label1561;
      label312:
      if ((localView instanceof CompoundButton)) {
        evaluateMinimumSizeForCompoundButton((CompoundButton)localView);
      }
      FlexItem localFlexItem = (FlexItem)localView.getLayoutParams();
      if (localFlexItem.getAlignSelf() == 4) {
        paramList.mIndicesAlignSelfStretch.add(Integer.valueOf(paramInt4));
      }
      i8 = getFlexItemSizeMain(localFlexItem, bool);
      i1 = i8;
      if (localFlexItem.getFlexBasisPercent() != -1.0F)
      {
        i1 = i8;
        if (i3 == 1073741824) {
          i1 = Math.round(i2 * localFlexItem.getFlexBasisPercent());
        }
      }
      if (bool)
      {
        i1 = this.mFlexContainer.getChildWidthMeasureSpec(i7, i4 + getFlexItemMarginStartMain(localFlexItem, true) + getFlexItemMarginEndMain(localFlexItem, true), i1);
        n = this.mFlexContainer.getChildHeightMeasureSpec(n, i10 + i11 + getFlexItemMarginStartCross(localFlexItem, true) + getFlexItemMarginEndCross(localFlexItem, true) + i, getFlexItemSizeCross(localFlexItem, true));
        localView.measure(i1, n);
        updateMeasureCache(paramInt4, i1, n, localView);
      }
      else
      {
        n = this.mFlexContainer.getChildWidthMeasureSpec(n, i10 + i11 + getFlexItemMarginStartCross(localFlexItem, false) + getFlexItemMarginEndCross(localFlexItem, false) + i, getFlexItemSizeCross(localFlexItem, false));
        i1 = this.mFlexContainer.getChildHeightMeasureSpec(i7, getFlexItemMarginStartMain(localFlexItem, false) + i4 + getFlexItemMarginEndMain(localFlexItem, false), i1);
        localView.measure(n, i1);
        updateMeasureCache(paramInt4, n, i1, localView);
      }
      this.mFlexContainer.updateViewCache(paramInt4, localView);
      checkSizeConstraints(localView, paramInt4);
      n = View.combineMeasuredStates(m, localView.getMeasuredState());
      m = paramList.mMainSize;
      i7 = getViewMeasuredSizeMain(localView, bool);
      i8 = getFlexItemMarginStartMain(localFlexItem, bool);
      i9 = getFlexItemMarginEndMain(localFlexItem, bool);
      int i12 = ((List)localObject1).size();
      Object localObject2 = localObject1;
      if (isWrapRequired(localView, i3, i2, m, i9 + (i7 + i8), localFlexItem, paramInt4, i6, i12))
      {
        if (paramList.getItemCountNotGone() > 0)
        {
          if (paramInt4 > 0) {
            k = paramInt4 - 1;
          } else {
            k = 0;
          }
          addFlexLine((List)localObject2, paramList, k, i);
          k = paramList.mCrossSize + i;
        }
        else
        {
          k = i;
        }
        if (bool)
        {
          if (localFlexItem.getHeight() == -1)
          {
            paramList = this.mFlexContainer;
            i = paramList.getChildHeightMeasureSpec(paramInt2, paramList.getPaddingTop() + this.mFlexContainer.getPaddingBottom() + localFlexItem.getMarginTop() + localFlexItem.getMarginBottom() + k, localFlexItem.getHeight());
            paramList = localView;
            paramList.measure(i1, i);
            checkSizeConstraints(paramList, paramInt4);
          }
        }
        else
        {
          paramList = localView;
          if (localFlexItem.getWidth() == -1)
          {
            localObject3 = this.mFlexContainer;
            paramList.measure(((FlexContainer)localObject3).getChildWidthMeasureSpec(paramInt2, ((FlexContainer)localObject3).getPaddingLeft() + this.mFlexContainer.getPaddingRight() + localFlexItem.getMarginLeft() + localFlexItem.getMarginRight() + k, localFlexItem.getWidth()), i1);
            checkSizeConstraints(paramList, paramInt4);
          }
        }
        paramList = new FlexLine();
        paramList.mItemCount = 1;
        paramList.mMainSize = i4;
        paramList.mFirstIndex = paramInt4;
        i = 0;
        m = Integer.MIN_VALUE;
      }
      else
      {
        paramList.mItemCount += 1;
        i6 += 1;
        i1 = i;
        m = k;
        i = i6;
        k = i1;
      }
      i6 = paramInt4;
      i1 = paramInt2;
      int i13 = paramList.mAnyItemsHaveFlexGrow;
      if (localFlexItem.getFlexGrow() != 0.0F) {
        paramInt4 = 1;
      } else {
        paramInt4 = 0;
      }
      paramList.mAnyItemsHaveFlexGrow = (i13 | paramInt4);
      int i14 = paramList.mAnyItemsHaveFlexShrink;
      if (localFlexItem.getFlexShrink() != 0.0F) {
        paramInt4 = 1;
      } else {
        paramInt4 = 0;
      }
      paramList.mAnyItemsHaveFlexShrink = (i14 | paramInt4);
      Object localObject3 = this.mIndexToFlexLine;
      if (localObject3 != null) {
        localObject3[i6] = ((List)localObject2).size();
      }
      paramList.mMainSize += getViewMeasuredSizeMain(localView, bool) + getFlexItemMarginStartMain(localFlexItem, bool) + getFlexItemMarginEndMain(localFlexItem, bool);
      paramList.mTotalFlexGrow += localFlexItem.getFlexGrow();
      paramList.mTotalFlexShrink += localFlexItem.getFlexShrink();
      this.mFlexContainer.onNewFlexItemAdded(localView, i6, i, paramList);
      i7 = Math.max(m, getViewMeasuredSizeCross(localView, bool) + getFlexItemMarginStartCross(localFlexItem, bool) + getFlexItemMarginEndCross(localFlexItem, bool) + this.mFlexContainer.getDecorationLengthCrossAxis(localView));
      paramList.mCrossSize = Math.max(paramList.mCrossSize, i7);
      if (bool) {
        if (this.mFlexContainer.getFlexWrap() != 2) {
          paramList.mMaxBaseline = Math.max(paramList.mMaxBaseline, localView.getBaseline() + localFlexItem.getMarginTop());
        } else {
          paramList.mMaxBaseline = Math.max(paramList.mMaxBaseline, localView.getMeasuredHeight() - localView.getBaseline() + localFlexItem.getMarginBottom());
        }
      }
      m = k;
      if (isLastFlexItem(i6, i5, paramList))
      {
        addFlexLine((List)localObject2, paramList, i6, k);
        m = k + paramList.mCrossSize;
      }
      i9 = paramInt5;
      if ((i9 != -1) && (((List)localObject2).size() > 0) && (((FlexLine)((List)localObject2).get(((List)localObject2).size() - 1)).mLastIndex >= i9) && (i6 >= i9) && (j == 0))
      {
        j = -paramList.getCrossSize();
        paramInt4 = 1;
      }
      else
      {
        paramInt4 = j;
        j = m;
      }
      if ((j > paramInt3) && (paramInt4 != 0))
      {
        m = n;
        break;
      }
      k = i7;
      i7 = i;
      m = n;
      i8 = paramInt4;
      paramInt4 = i9;
      i9 = i6;
      i = i1;
      n = j;
      label1561:
      i6 = i9 + 1;
      j = i;
      i1 = paramInt4;
      i = n;
      paramInt4 = i6;
      n = j;
      j = i8;
      i6 = i7;
    }
    paramFlexLinesResult.mChildState = m;
  }
  
  void calculateHorizontalFlexLines(FlexLinesResult paramFlexLinesResult, int paramInt1, int paramInt2)
  {
    calculateFlexLines(paramFlexLinesResult, paramInt1, paramInt2, Integer.MAX_VALUE, 0, -1, null);
  }
  
  void calculateHorizontalFlexLines(FlexLinesResult paramFlexLinesResult, int paramInt1, int paramInt2, int paramInt3, int paramInt4, List<FlexLine> paramList)
  {
    calculateFlexLines(paramFlexLinesResult, paramInt1, paramInt2, paramInt3, paramInt4, -1, paramList);
  }
  
  void calculateHorizontalFlexLinesToIndex(FlexLinesResult paramFlexLinesResult, int paramInt1, int paramInt2, int paramInt3, int paramInt4, List<FlexLine> paramList)
  {
    calculateFlexLines(paramFlexLinesResult, paramInt1, paramInt2, paramInt3, 0, paramInt4, paramList);
  }
  
  void calculateVerticalFlexLines(FlexLinesResult paramFlexLinesResult, int paramInt1, int paramInt2)
  {
    calculateFlexLines(paramFlexLinesResult, paramInt2, paramInt1, Integer.MAX_VALUE, 0, -1, null);
  }
  
  void calculateVerticalFlexLines(FlexLinesResult paramFlexLinesResult, int paramInt1, int paramInt2, int paramInt3, int paramInt4, List<FlexLine> paramList)
  {
    calculateFlexLines(paramFlexLinesResult, paramInt2, paramInt1, paramInt3, paramInt4, -1, paramList);
  }
  
  void calculateVerticalFlexLinesToIndex(FlexLinesResult paramFlexLinesResult, int paramInt1, int paramInt2, int paramInt3, int paramInt4, List<FlexLine> paramList)
  {
    calculateFlexLines(paramFlexLinesResult, paramInt2, paramInt1, paramInt3, 0, paramInt4, paramList);
  }
  
  void clearFlexLines(List<FlexLine> paramList, int paramInt)
  {
    int j = this.mIndexToFlexLine[paramInt];
    int i = j;
    if (j == -1) {
      i = 0;
    }
    j = paramList.size() - 1;
    while (j >= i)
    {
      paramList.remove(j);
      j -= 1;
    }
    paramList = this.mIndexToFlexLine;
    i = paramList.length - 1;
    if (paramInt > i) {
      Arrays.fill(paramList, -1);
    } else {
      Arrays.fill(paramList, paramInt, i, -1);
    }
    paramList = this.mMeasureSpecCache;
    i = paramList.length - 1;
    if (paramInt > i)
    {
      Arrays.fill(paramList, 0L);
      return;
    }
    Arrays.fill(paramList, paramInt, i, 0L);
  }
  
  int[] createReorderedIndices(SparseIntArray paramSparseIntArray)
  {
    int i = this.mFlexContainer.getFlexItemCount();
    return sortOrdersIntoReorderedIndices(i, createOrders(i), paramSparseIntArray);
  }
  
  int[] createReorderedIndices(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, SparseIntArray paramSparseIntArray)
  {
    int i = this.mFlexContainer.getFlexItemCount();
    List localList = createOrders(i);
    Order localOrder = new Order(null);
    if ((paramView != null) && ((paramLayoutParams instanceof FlexItem))) {
      localOrder.order = ((FlexItem)paramLayoutParams).getOrder();
    } else {
      localOrder.order = 1;
    }
    if ((paramInt != -1) && (paramInt != i))
    {
      if (paramInt < this.mFlexContainer.getFlexItemCount())
      {
        localOrder.index = paramInt;
        while (paramInt < i)
        {
          paramView = (Order)localList.get(paramInt);
          paramView.index += 1;
          paramInt += 1;
        }
      }
      localOrder.index = i;
    }
    else
    {
      localOrder.index = i;
    }
    localList.add(localOrder);
    return sortOrdersIntoReorderedIndices(i + 1, localList, paramSparseIntArray);
  }
  
  void determineCrossSize(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.mFlexContainer.getFlexDirection();
    if ((i != 0) && (i != 1))
    {
      if ((i != 2) && (i != 3))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Invalid flex direction: ");
        ((StringBuilder)localObject1).append(i);
        throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
      }
      i = View.MeasureSpec.getMode(paramInt1);
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
    }
    else
    {
      paramInt1 = View.MeasureSpec.getMode(paramInt2);
      paramInt2 = View.MeasureSpec.getSize(paramInt2);
      i = paramInt1;
      paramInt1 = paramInt2;
    }
    Object localObject1 = this.mFlexContainer.getFlexLinesInternal();
    if (i == 1073741824)
    {
      int j = this.mFlexContainer.getSumOfCrossSize() + paramInt3;
      int k = ((List)localObject1).size();
      i = 0;
      paramInt2 = 0;
      if (k == 1)
      {
        ((FlexLine)((List)localObject1).get(0)).mCrossSize = (paramInt1 - paramInt3);
        return;
      }
      if (((List)localObject1).size() >= 2)
      {
        paramInt3 = this.mFlexContainer.getAlignContent();
        if (paramInt3 != 1)
        {
          if (paramInt3 != 2)
          {
            float f2;
            FlexLine localFlexLine1;
            if (paramInt3 != 3)
            {
              if (paramInt3 != 4)
              {
                if (paramInt3 != 5) {
                  return;
                }
                if (j >= paramInt1) {
                  return;
                }
                float f5 = (paramInt1 - j) / ((List)localObject1).size();
                i = ((List)localObject1).size();
                f1 = 0.0F;
                while (paramInt2 < i)
                {
                  localObject2 = (FlexLine)((List)localObject1).get(paramInt2);
                  float f4 = ((FlexLine)localObject2).mCrossSize + f5;
                  f3 = f4;
                  f2 = f1;
                  if (paramInt2 == ((List)localObject1).size() - 1)
                  {
                    f3 = f4 + f1;
                    f2 = 0.0F;
                  }
                  paramInt3 = Math.round(f3);
                  f2 += f3 - paramInt3;
                  if (f2 > 1.0F)
                  {
                    paramInt1 = paramInt3 + 1;
                    f1 = f2 - 1.0F;
                  }
                  else
                  {
                    paramInt1 = paramInt3;
                    f1 = f2;
                    if (f2 < -1.0F)
                    {
                      paramInt1 = paramInt3 - 1;
                      f1 = f2 + 1.0F;
                    }
                  }
                  ((FlexLine)localObject2).mCrossSize = paramInt1;
                  paramInt2 += 1;
                }
              }
              if (j >= paramInt1)
              {
                this.mFlexContainer.setFlexLines(constructFlexLinesForAlignContentCenter((List)localObject1, paramInt1, j));
                return;
              }
              paramInt1 = (paramInt1 - j) / (((List)localObject1).size() * 2);
              localObject2 = new ArrayList();
              localFlexLine1 = new FlexLine();
              localFlexLine1.mCrossSize = paramInt1;
              localObject1 = ((List)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                FlexLine localFlexLine2 = (FlexLine)((Iterator)localObject1).next();
                ((List)localObject2).add(localFlexLine1);
                ((List)localObject2).add(localFlexLine2);
                ((List)localObject2).add(localFlexLine1);
              }
              this.mFlexContainer.setFlexLines((List)localObject2);
              return;
            }
            if (j >= paramInt1) {
              return;
            }
            float f3 = (paramInt1 - j) / (((List)localObject1).size() - 1);
            localObject2 = new ArrayList();
            paramInt2 = ((List)localObject1).size();
            float f1 = 0.0F;
            paramInt1 = i;
            while (paramInt1 < paramInt2)
            {
              ((List)localObject2).add((FlexLine)((List)localObject1).get(paramInt1));
              f2 = f1;
              if (paramInt1 != ((List)localObject1).size() - 1)
              {
                localFlexLine1 = new FlexLine();
                if (paramInt1 == ((List)localObject1).size() - 2)
                {
                  localFlexLine1.mCrossSize = Math.round(f1 + f3);
                  f1 = 0.0F;
                }
                else
                {
                  localFlexLine1.mCrossSize = Math.round(f3);
                }
                f2 = f1 + (f3 - localFlexLine1.mCrossSize);
                if (f2 > 1.0F)
                {
                  localFlexLine1.mCrossSize += 1;
                  f1 = f2 - 1.0F;
                }
                else
                {
                  f1 = f2;
                  if (f2 < -1.0F)
                  {
                    localFlexLine1.mCrossSize -= 1;
                    f1 = f2 + 1.0F;
                  }
                }
                ((List)localObject2).add(localFlexLine1);
                f2 = f1;
              }
              paramInt1 += 1;
              f1 = f2;
            }
            this.mFlexContainer.setFlexLines((List)localObject2);
            return;
          }
          this.mFlexContainer.setFlexLines(constructFlexLinesForAlignContentCenter((List)localObject1, paramInt1, j));
          return;
        }
        Object localObject2 = new FlexLine();
        ((FlexLine)localObject2).mCrossSize = (paramInt1 - j);
        ((List)localObject1).add(0, localObject2);
      }
    }
  }
  
  void determineMainSize(int paramInt1, int paramInt2)
  {
    determineMainSize(paramInt1, paramInt2, 0);
  }
  
  void determineMainSize(int paramInt1, int paramInt2, int paramInt3)
  {
    ensureChildrenFrozen(this.mFlexContainer.getFlexItemCount());
    if (paramInt3 >= this.mFlexContainer.getFlexItemCount()) {
      return;
    }
    int i = this.mFlexContainer.getFlexDirection();
    int j = this.mFlexContainer.getFlexDirection();
    int k;
    int m;
    if ((j != 0) && (j != 1))
    {
      if ((j != 2) && (j != 3))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Invalid flex direction: ");
        ((StringBuilder)localObject).append(i);
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
      j = View.MeasureSpec.getMode(paramInt2);
      i = View.MeasureSpec.getSize(paramInt2);
      if (j != 1073741824) {
        i = this.mFlexContainer.getLargestMainSize();
      }
      k = this.mFlexContainer.getPaddingTop();
      m = this.mFlexContainer.getPaddingBottom();
      j = i;
    }
    else
    {
      k = View.MeasureSpec.getMode(paramInt1);
      i = View.MeasureSpec.getSize(paramInt1);
      j = this.mFlexContainer.getLargestMainSize();
      if ((k != 1073741824) && (j <= i)) {
        i = j;
      }
      k = this.mFlexContainer.getPaddingLeft();
      m = this.mFlexContainer.getPaddingRight();
      j = i;
    }
    k += m;
    i = 0;
    Object localObject = this.mIndexToFlexLine;
    if (localObject != null) {
      i = localObject[paramInt3];
    }
    localObject = this.mFlexContainer.getFlexLinesInternal();
    paramInt3 = ((List)localObject).size();
    while (i < paramInt3)
    {
      FlexLine localFlexLine = (FlexLine)((List)localObject).get(i);
      if ((localFlexLine.mMainSize < j) && (localFlexLine.mAnyItemsHaveFlexGrow)) {
        expandFlexItems(paramInt1, paramInt2, localFlexLine, j, k, false);
      } else if ((localFlexLine.mMainSize > j) && (localFlexLine.mAnyItemsHaveFlexShrink)) {
        shrinkFlexItems(paramInt1, paramInt2, localFlexLine, j, k, false);
      }
      i += 1;
    }
  }
  
  void ensureIndexToFlexLine(int paramInt)
  {
    int[] arrayOfInt = this.mIndexToFlexLine;
    int i;
    if (arrayOfInt == null)
    {
      i = paramInt;
      if (paramInt < 10) {
        i = 10;
      }
      this.mIndexToFlexLine = new int[i];
      return;
    }
    if (arrayOfInt.length < paramInt)
    {
      int j = arrayOfInt.length * 2;
      i = paramInt;
      if (j >= paramInt) {
        i = j;
      }
      this.mIndexToFlexLine = Arrays.copyOf(this.mIndexToFlexLine, i);
    }
  }
  
  void ensureMeasureSpecCache(int paramInt)
  {
    long[] arrayOfLong = this.mMeasureSpecCache;
    int i;
    if (arrayOfLong == null)
    {
      i = paramInt;
      if (paramInt < 10) {
        i = 10;
      }
      this.mMeasureSpecCache = new long[i];
      return;
    }
    if (arrayOfLong.length < paramInt)
    {
      int j = arrayOfLong.length * 2;
      i = paramInt;
      if (j >= paramInt) {
        i = j;
      }
      this.mMeasureSpecCache = Arrays.copyOf(this.mMeasureSpecCache, i);
    }
  }
  
  void ensureMeasuredSizeCache(int paramInt)
  {
    long[] arrayOfLong = this.mMeasuredSizeCache;
    int i;
    if (arrayOfLong == null)
    {
      i = paramInt;
      if (paramInt < 10) {
        i = 10;
      }
      this.mMeasuredSizeCache = new long[i];
      return;
    }
    if (arrayOfLong.length < paramInt)
    {
      int j = arrayOfLong.length * 2;
      i = paramInt;
      if (j >= paramInt) {
        i = j;
      }
      this.mMeasuredSizeCache = Arrays.copyOf(this.mMeasuredSizeCache, i);
    }
  }
  
  int extractHigherInt(long paramLong)
  {
    return (int)(paramLong >> 32);
  }
  
  int extractLowerInt(long paramLong)
  {
    return (int)paramLong;
  }
  
  boolean isOrderChangedFromLastMeasurement(SparseIntArray paramSparseIntArray)
  {
    int j = this.mFlexContainer.getFlexItemCount();
    if (paramSparseIntArray.size() != j) {
      return true;
    }
    int i = 0;
    while (i < j)
    {
      View localView = this.mFlexContainer.getFlexItemAt(i);
      if ((localView != null) && (((FlexItem)localView.getLayoutParams()).getOrder() != paramSparseIntArray.get(i))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  void layoutSingleChildHorizontal(View paramView, FlexLine paramFlexLine, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    FlexItem localFlexItem = (FlexItem)paramView.getLayoutParams();
    int i = this.mFlexContainer.getAlignItems();
    if (localFlexItem.getAlignSelf() != -1) {
      i = localFlexItem.getAlignSelf();
    }
    int j = paramFlexLine.mCrossSize;
    if (i != 0) {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i == 4) {}
          }
          else
          {
            if (this.mFlexContainer.getFlexWrap() != 2)
            {
              i = Math.max(paramFlexLine.mMaxBaseline - paramView.getBaseline(), localFlexItem.getMarginTop());
              paramView.layout(paramInt1, paramInt2 + i, paramInt3, paramInt4 + i);
              return;
            }
            i = Math.max(paramFlexLine.mMaxBaseline - paramView.getMeasuredHeight() + paramView.getBaseline(), localFlexItem.getMarginBottom());
            paramView.layout(paramInt1, paramInt2 - i, paramInt3, paramInt4 - i);
          }
        }
        else
        {
          paramInt4 = (j - paramView.getMeasuredHeight() + localFlexItem.getMarginTop() - localFlexItem.getMarginBottom()) / 2;
          if (this.mFlexContainer.getFlexWrap() != 2)
          {
            paramInt2 += paramInt4;
            paramView.layout(paramInt1, paramInt2, paramInt3, paramView.getMeasuredHeight() + paramInt2);
            return;
          }
          paramInt2 -= paramInt4;
          paramView.layout(paramInt1, paramInt2, paramInt3, paramView.getMeasuredHeight() + paramInt2);
        }
      }
      else
      {
        if (this.mFlexContainer.getFlexWrap() != 2)
        {
          paramInt2 += j;
          paramView.layout(paramInt1, paramInt2 - paramView.getMeasuredHeight() - localFlexItem.getMarginBottom(), paramInt3, paramInt2 - localFlexItem.getMarginBottom());
          return;
        }
        paramView.layout(paramInt1, paramInt2 - j + paramView.getMeasuredHeight() + localFlexItem.getMarginTop(), paramInt3, paramInt4 - j + paramView.getMeasuredHeight() + localFlexItem.getMarginTop());
        return;
      }
    }
    if (this.mFlexContainer.getFlexWrap() != 2)
    {
      paramView.layout(paramInt1, paramInt2 + localFlexItem.getMarginTop(), paramInt3, paramInt4 + localFlexItem.getMarginTop());
      return;
    }
    paramView.layout(paramInt1, paramInt2 - localFlexItem.getMarginBottom(), paramInt3, paramInt4 - localFlexItem.getMarginBottom());
  }
  
  void layoutSingleChildVertical(View paramView, FlexLine paramFlexLine, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    FlexItem localFlexItem = (FlexItem)paramView.getLayoutParams();
    int i = this.mFlexContainer.getAlignItems();
    if (localFlexItem.getAlignSelf() != -1) {
      i = localFlexItem.getAlignSelf();
    }
    int j = paramFlexLine.mCrossSize;
    if (i != 0) {
      if (i != 1)
      {
        if (i != 2)
        {
          if ((i == 3) || (i == 4)) {}
        }
        else
        {
          paramFlexLine = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
          i = (j - paramView.getMeasuredWidth() + MarginLayoutParamsCompat.getMarginStart(paramFlexLine) - MarginLayoutParamsCompat.getMarginEnd(paramFlexLine)) / 2;
          if (!paramBoolean)
          {
            paramView.layout(paramInt1 + i, paramInt2, paramInt3 + i, paramInt4);
            return;
          }
          paramView.layout(paramInt1 - i, paramInt2, paramInt3 - i, paramInt4);
        }
      }
      else
      {
        if (!paramBoolean)
        {
          paramView.layout(paramInt1 + j - paramView.getMeasuredWidth() - localFlexItem.getMarginRight(), paramInt2, paramInt3 + j - paramView.getMeasuredWidth() - localFlexItem.getMarginRight(), paramInt4);
          return;
        }
        paramView.layout(paramInt1 - j + paramView.getMeasuredWidth() + localFlexItem.getMarginLeft(), paramInt2, paramInt3 - j + paramView.getMeasuredWidth() + localFlexItem.getMarginLeft(), paramInt4);
        return;
      }
    }
    if (!paramBoolean)
    {
      paramView.layout(paramInt1 + localFlexItem.getMarginLeft(), paramInt2, paramInt3 + localFlexItem.getMarginLeft(), paramInt4);
      return;
    }
    paramView.layout(paramInt1 - localFlexItem.getMarginRight(), paramInt2, paramInt3 - localFlexItem.getMarginRight(), paramInt4);
  }
  
  long makeCombinedLong(int paramInt1, int paramInt2)
  {
    long l = paramInt2;
    return paramInt1 & 0xFFFFFFFF | l << 32;
  }
  
  void stretchViews()
  {
    stretchViews(0);
  }
  
  void stretchViews(int paramInt)
  {
    if (paramInt >= this.mFlexContainer.getFlexItemCount()) {
      return;
    }
    int j = this.mFlexContainer.getFlexDirection();
    FlexLine localFlexLine;
    Object localObject2;
    Object localObject3;
    if (this.mFlexContainer.getAlignItems() == 4)
    {
      localObject1 = this.mIndexToFlexLine;
      if (localObject1 != null) {
        paramInt = localObject1[paramInt];
      } else {
        paramInt = 0;
      }
      localObject1 = this.mFlexContainer.getFlexLinesInternal();
      int k = ((List)localObject1).size();
      while (paramInt < k)
      {
        localFlexLine = (FlexLine)((List)localObject1).get(paramInt);
        int m = localFlexLine.mItemCount;
        int i = 0;
        while (i < m)
        {
          int n = localFlexLine.mFirstIndex + i;
          if (i < this.mFlexContainer.getFlexItemCount())
          {
            localObject2 = this.mFlexContainer.getReorderedFlexItemAt(n);
            if ((localObject2 != null) && (((View)localObject2).getVisibility() != 8))
            {
              localObject3 = (FlexItem)((View)localObject2).getLayoutParams();
              if ((((FlexItem)localObject3).getAlignSelf() == -1) || (((FlexItem)localObject3).getAlignSelf() == 4)) {
                if ((j != 0) && (j != 1))
                {
                  if ((j != 2) && (j != 3))
                  {
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append("Invalid flex direction: ");
                    ((StringBuilder)localObject1).append(j);
                    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
                  }
                  stretchViewHorizontally((View)localObject2, localFlexLine.mCrossSize, n);
                }
                else
                {
                  stretchViewVertically((View)localObject2, localFlexLine.mCrossSize, n);
                }
              }
            }
          }
          i += 1;
        }
        paramInt += 1;
      }
    }
    Object localObject1 = this.mFlexContainer.getFlexLinesInternal().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localFlexLine = (FlexLine)((Iterator)localObject1).next();
      localObject2 = localFlexLine.mIndicesAlignSelfStretch.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Integer)((Iterator)localObject2).next();
        View localView = this.mFlexContainer.getReorderedFlexItemAt(((Integer)localObject3).intValue());
        if ((j != 0) && (j != 1))
        {
          if ((j != 2) && (j != 3))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Invalid flex direction: ");
            ((StringBuilder)localObject1).append(j);
            throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
          }
          stretchViewHorizontally(localView, localFlexLine.mCrossSize, ((Integer)localObject3).intValue());
        }
        else
        {
          stretchViewVertically(localView, localFlexLine.mCrossSize, ((Integer)localObject3).intValue());
        }
      }
    }
  }
  
  static class FlexLinesResult
  {
    int mChildState;
    List<FlexLine> mFlexLines;
    
    void reset()
    {
      this.mFlexLines = null;
      this.mChildState = 0;
    }
  }
  
  private static class Order
    implements Comparable<Order>
  {
    int index;
    int order;
    
    public int compareTo(Order paramOrder)
    {
      int i = this.order;
      int j = paramOrder.order;
      if (i != j) {
        return i - j;
      }
      return this.index - paramOrder.index;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Order{order=");
      localStringBuilder.append(this.order);
      localStringBuilder.append(", index=");
      localStringBuilder.append(this.index);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\flexbox\FlexboxHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */