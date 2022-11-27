package com.google.android.flexbox;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class FlexLine
{
  boolean mAnyItemsHaveFlexGrow;
  boolean mAnyItemsHaveFlexShrink;
  int mBottom = Integer.MIN_VALUE;
  int mCrossSize;
  int mDividerLengthInMainSize;
  int mFirstIndex;
  int mGoneItemCount;
  List<Integer> mIndicesAlignSelfStretch = new ArrayList();
  int mItemCount;
  int mLastIndex;
  int mLeft = Integer.MAX_VALUE;
  int mMainSize;
  int mMaxBaseline;
  int mRight = Integer.MIN_VALUE;
  int mSumCrossSizeBefore;
  int mTop = Integer.MAX_VALUE;
  float mTotalFlexGrow;
  float mTotalFlexShrink;
  
  public int getCrossSize()
  {
    return this.mCrossSize;
  }
  
  public int getFirstIndex()
  {
    return this.mFirstIndex;
  }
  
  public int getItemCount()
  {
    return this.mItemCount;
  }
  
  public int getItemCountNotGone()
  {
    return this.mItemCount - this.mGoneItemCount;
  }
  
  public int getMainSize()
  {
    return this.mMainSize;
  }
  
  public float getTotalFlexGrow()
  {
    return this.mTotalFlexGrow;
  }
  
  public float getTotalFlexShrink()
  {
    return this.mTotalFlexShrink;
  }
  
  void updatePositionFromView(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    FlexItem localFlexItem = (FlexItem)paramView.getLayoutParams();
    this.mLeft = Math.min(this.mLeft, paramView.getLeft() - localFlexItem.getMarginLeft() - paramInt1);
    this.mTop = Math.min(this.mTop, paramView.getTop() - localFlexItem.getMarginTop() - paramInt2);
    this.mRight = Math.max(this.mRight, paramView.getRight() + localFlexItem.getMarginRight() + paramInt3);
    this.mBottom = Math.max(this.mBottom, paramView.getBottom() + localFlexItem.getMarginBottom() + paramInt4);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\flexbox\FlexLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */