package com.google.android.flexbox;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager.Properties;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.Recycler;
import androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider;
import androidx.recyclerview.widget.RecyclerView.State;
import java.util.ArrayList;
import java.util.List;

public class FlexboxLayoutManager
  extends RecyclerView.LayoutManager
  implements FlexContainer, RecyclerView.SmoothScroller.ScrollVectorProvider
{
  private static final boolean DEBUG = false;
  private static final String TAG = "FlexboxLayoutManager";
  private static final Rect TEMP_RECT = new Rect();
  private int mAlignItems;
  private AnchorInfo mAnchorInfo = new AnchorInfo(null);
  private final Context mContext;
  private int mDirtyPosition = -1;
  private int mFlexDirection;
  private List<FlexLine> mFlexLines = new ArrayList();
  private FlexboxHelper.FlexLinesResult mFlexLinesResult = new FlexboxHelper.FlexLinesResult();
  private int mFlexWrap;
  private final FlexboxHelper mFlexboxHelper = new FlexboxHelper(this);
  private boolean mFromBottomToTop;
  private boolean mIsRtl;
  private int mJustifyContent;
  private int mLastHeight = Integer.MIN_VALUE;
  private int mLastWidth = Integer.MIN_VALUE;
  private LayoutState mLayoutState;
  private int mMaxLine = -1;
  private OrientationHelper mOrientationHelper;
  private View mParent;
  private SavedState mPendingSavedState;
  private int mPendingScrollPosition = -1;
  private int mPendingScrollPositionOffset = Integer.MIN_VALUE;
  private boolean mRecycleChildrenOnDetach;
  private RecyclerView.Recycler mRecycler;
  private RecyclerView.State mState;
  private OrientationHelper mSubOrientationHelper;
  private SparseArray<View> mViewCache = new SparseArray();
  
  public FlexboxLayoutManager(Context paramContext)
  {
    this(paramContext, 0, 1);
  }
  
  public FlexboxLayoutManager(Context paramContext, int paramInt)
  {
    this(paramContext, paramInt, 1);
  }
  
  public FlexboxLayoutManager(Context paramContext, int paramInt1, int paramInt2)
  {
    setFlexDirection(paramInt1);
    setFlexWrap(paramInt2);
    setAlignItems(4);
    setAutoMeasureEnabled(true);
    this.mContext = paramContext;
  }
  
  public FlexboxLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramAttributeSet = getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2);
    paramInt1 = paramAttributeSet.orientation;
    if (paramInt1 != 0)
    {
      if (paramInt1 == 1) {
        if (paramAttributeSet.reverseLayout) {
          setFlexDirection(3);
        } else {
          setFlexDirection(2);
        }
      }
    }
    else if (paramAttributeSet.reverseLayout) {
      setFlexDirection(1);
    } else {
      setFlexDirection(0);
    }
    setFlexWrap(1);
    setAlignItems(4);
    setAutoMeasureEnabled(true);
    this.mContext = paramContext;
  }
  
  private boolean canViewBeRecycledFromEnd(View paramView, int paramInt)
  {
    if ((!isMainAxisDirectionHorizontal()) && (this.mIsRtl)) {
      return this.mOrientationHelper.getDecoratedEnd(paramView) <= paramInt;
    }
    return this.mOrientationHelper.getDecoratedStart(paramView) >= this.mOrientationHelper.getEnd() - paramInt;
  }
  
  private boolean canViewBeRecycledFromStart(View paramView, int paramInt)
  {
    if ((!isMainAxisDirectionHorizontal()) && (this.mIsRtl)) {
      return this.mOrientationHelper.getEnd() - this.mOrientationHelper.getDecoratedStart(paramView) <= paramInt;
    }
    return this.mOrientationHelper.getDecoratedEnd(paramView) <= paramInt;
  }
  
  private void clearFlexLines()
  {
    this.mFlexLines.clear();
    this.mAnchorInfo.reset();
    AnchorInfo.access$2402(this.mAnchorInfo, 0);
  }
  
  private int computeScrollExtent(RecyclerView.State paramState)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    int i = paramState.getItemCount();
    ensureOrientationHelper();
    View localView1 = findFirstReferenceChild(i);
    View localView2 = findLastReferenceChild(i);
    if ((paramState.getItemCount() != 0) && (localView1 != null))
    {
      if (localView2 == null) {
        return 0;
      }
      i = this.mOrientationHelper.getDecoratedEnd(localView2);
      int j = this.mOrientationHelper.getDecoratedStart(localView1);
      return Math.min(this.mOrientationHelper.getTotalSpace(), i - j);
    }
    return 0;
  }
  
  private int computeScrollOffset(RecyclerView.State paramState)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    int i = paramState.getItemCount();
    View localView1 = findFirstReferenceChild(i);
    View localView2 = findLastReferenceChild(i);
    if ((paramState.getItemCount() != 0) && (localView1 != null))
    {
      if (localView2 == null) {
        return 0;
      }
      int k = getPosition(localView1);
      int j = getPosition(localView2);
      i = Math.abs(this.mOrientationHelper.getDecoratedEnd(localView2) - this.mOrientationHelper.getDecoratedStart(localView1));
      k = this.mFlexboxHelper.mIndexToFlexLine[k];
      if (k != 0)
      {
        if (k == -1) {
          return 0;
        }
        j = this.mFlexboxHelper.mIndexToFlexLine[j];
        float f = i / (j - k + 1);
        return Math.round(k * f + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(localView1)));
      }
    }
    return 0;
  }
  
  private int computeScrollRange(RecyclerView.State paramState)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    int i = paramState.getItemCount();
    View localView1 = findFirstReferenceChild(i);
    View localView2 = findLastReferenceChild(i);
    if ((paramState.getItemCount() != 0) && (localView1 != null))
    {
      if (localView2 == null) {
        return 0;
      }
      i = findFirstVisibleItemPosition();
      int j = findLastVisibleItemPosition();
      return (int)(Math.abs(this.mOrientationHelper.getDecoratedEnd(localView2) - this.mOrientationHelper.getDecoratedStart(localView1)) / (j - i + 1) * paramState.getItemCount());
    }
    return 0;
  }
  
  private void ensureLayoutState()
  {
    if (this.mLayoutState == null) {
      this.mLayoutState = new LayoutState(null);
    }
  }
  
  private void ensureOrientationHelper()
  {
    if (this.mOrientationHelper != null) {
      return;
    }
    if (isMainAxisDirectionHorizontal())
    {
      if (this.mFlexWrap == 0)
      {
        this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
        this.mSubOrientationHelper = OrientationHelper.createVerticalHelper(this);
        return;
      }
      this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
      this.mSubOrientationHelper = OrientationHelper.createHorizontalHelper(this);
      return;
    }
    if (this.mFlexWrap == 0)
    {
      this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
      this.mSubOrientationHelper = OrientationHelper.createHorizontalHelper(this);
      return;
    }
    this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
    this.mSubOrientationHelper = OrientationHelper.createVerticalHelper(this);
  }
  
  private int fill(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LayoutState paramLayoutState)
  {
    if (paramLayoutState.mScrollingOffset != Integer.MIN_VALUE)
    {
      if (paramLayoutState.mAvailable < 0) {
        LayoutState.access$2002(paramLayoutState, paramLayoutState.mScrollingOffset + paramLayoutState.mAvailable);
      }
      recycleByLayoutState(paramRecycler, paramLayoutState);
    }
    int k = paramLayoutState.mAvailable;
    int i = paramLayoutState.mAvailable;
    int j = 0;
    boolean bool = isMainAxisDirectionHorizontal();
    while (((i > 0) || (this.mLayoutState.mInfinite)) && (paramLayoutState.hasMore(paramState, this.mFlexLines)))
    {
      FlexLine localFlexLine = (FlexLine)this.mFlexLines.get(paramLayoutState.mFlexLinePosition);
      LayoutState.access$2202(paramLayoutState, localFlexLine.mFirstIndex);
      j += layoutFlexLine(localFlexLine, paramLayoutState);
      if ((!bool) && (this.mIsRtl)) {
        LayoutState.access$1002(paramLayoutState, paramLayoutState.mOffset - localFlexLine.getCrossSize() * paramLayoutState.mLayoutDirection);
      } else {
        LayoutState.access$1002(paramLayoutState, paramLayoutState.mOffset + localFlexLine.getCrossSize() * paramLayoutState.mLayoutDirection);
      }
      i -= localFlexLine.getCrossSize();
    }
    LayoutState.access$1202(paramLayoutState, paramLayoutState.mAvailable - j);
    if (paramLayoutState.mScrollingOffset != Integer.MIN_VALUE)
    {
      LayoutState.access$2002(paramLayoutState, paramLayoutState.mScrollingOffset + j);
      if (paramLayoutState.mAvailable < 0) {
        LayoutState.access$2002(paramLayoutState, paramLayoutState.mScrollingOffset + paramLayoutState.mAvailable);
      }
      recycleByLayoutState(paramRecycler, paramLayoutState);
    }
    return k - paramLayoutState.mAvailable;
  }
  
  private View findFirstReferenceChild(int paramInt)
  {
    View localView = findReferenceChild(0, getChildCount(), paramInt);
    if (localView == null) {
      return null;
    }
    paramInt = getPosition(localView);
    paramInt = this.mFlexboxHelper.mIndexToFlexLine[paramInt];
    if (paramInt == -1) {
      return null;
    }
    return findFirstReferenceViewInLine(localView, (FlexLine)this.mFlexLines.get(paramInt));
  }
  
  private View findFirstReferenceViewInLine(View paramView, FlexLine paramFlexLine)
  {
    boolean bool = isMainAxisDirectionHorizontal();
    int j = paramFlexLine.mItemCount;
    int i = 1;
    while (i < j)
    {
      View localView = getChildAt(i);
      paramFlexLine = paramView;
      if (localView != null) {
        if (localView.getVisibility() == 8)
        {
          paramFlexLine = paramView;
        }
        else
        {
          if ((this.mIsRtl) && (!bool))
          {
            paramFlexLine = paramView;
            if (this.mOrientationHelper.getDecoratedEnd(paramView) >= this.mOrientationHelper.getDecoratedEnd(localView)) {
              break label111;
            }
          }
          else
          {
            paramFlexLine = paramView;
            if (this.mOrientationHelper.getDecoratedStart(paramView) <= this.mOrientationHelper.getDecoratedStart(localView)) {
              break label111;
            }
          }
          paramFlexLine = localView;
        }
      }
      label111:
      i += 1;
      paramView = paramFlexLine;
    }
    return paramView;
  }
  
  private View findLastReferenceChild(int paramInt)
  {
    View localView = findReferenceChild(getChildCount() - 1, -1, paramInt);
    if (localView == null) {
      return null;
    }
    paramInt = getPosition(localView);
    paramInt = this.mFlexboxHelper.mIndexToFlexLine[paramInt];
    return findLastReferenceViewInLine(localView, (FlexLine)this.mFlexLines.get(paramInt));
  }
  
  private View findLastReferenceViewInLine(View paramView, FlexLine paramFlexLine)
  {
    boolean bool = isMainAxisDirectionHorizontal();
    int i = getChildCount() - 2;
    int j = getChildCount();
    int k = paramFlexLine.mItemCount;
    while (i > j - k - 1)
    {
      View localView = getChildAt(i);
      paramFlexLine = paramView;
      if (localView != null) {
        if (localView.getVisibility() == 8)
        {
          paramFlexLine = paramView;
        }
        else
        {
          if ((this.mIsRtl) && (!bool))
          {
            paramFlexLine = paramView;
            if (this.mOrientationHelper.getDecoratedStart(paramView) <= this.mOrientationHelper.getDecoratedStart(localView)) {
              break label127;
            }
          }
          else
          {
            paramFlexLine = paramView;
            if (this.mOrientationHelper.getDecoratedEnd(paramView) >= this.mOrientationHelper.getDecoratedEnd(localView)) {
              break label127;
            }
          }
          paramFlexLine = localView;
        }
      }
      label127:
      i -= 1;
      paramView = paramFlexLine;
    }
    return paramView;
  }
  
  private View findOneVisibleChild(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i;
    if (paramInt2 > paramInt1) {
      i = 1;
    } else {
      i = -1;
    }
    while (paramInt1 != paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (isViewVisible(localView, paramBoolean)) {
        return localView;
      }
      paramInt1 += i;
    }
    return null;
  }
  
  private View findReferenceChild(int paramInt1, int paramInt2, int paramInt3)
  {
    ensureOrientationHelper();
    ensureLayoutState();
    int j = this.mOrientationHelper.getStartAfterPadding();
    int k = this.mOrientationHelper.getEndAfterPadding();
    int i;
    if (paramInt2 > paramInt1) {
      i = 1;
    } else {
      i = -1;
    }
    Object localObject2 = null;
    Object localObject4;
    for (Object localObject1 = null; paramInt1 != paramInt2; localObject1 = localObject4)
    {
      View localView = getChildAt(paramInt1);
      int m = getPosition(localView);
      Object localObject3 = localObject2;
      localObject4 = localObject1;
      if (m >= 0)
      {
        localObject3 = localObject2;
        localObject4 = localObject1;
        if (m < paramInt3) {
          if (((RecyclerView.LayoutParams)localView.getLayoutParams()).isItemRemoved())
          {
            localObject3 = localObject2;
            localObject4 = localObject1;
            if (localObject1 == null)
            {
              localObject4 = localView;
              localObject3 = localObject2;
            }
          }
          else
          {
            if ((this.mOrientationHelper.getDecoratedStart(localView) >= j) && (this.mOrientationHelper.getDecoratedEnd(localView) <= k)) {
              return localView;
            }
            localObject3 = localObject2;
            localObject4 = localObject1;
            if (localObject2 == null)
            {
              localObject3 = localView;
              localObject4 = localObject1;
            }
          }
        }
      }
      paramInt1 += i;
      localObject2 = localObject3;
    }
    if (localObject2 != null) {
      return (View)localObject2;
    }
    return (View)localObject1;
  }
  
  private int fixLayoutEndGap(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean)
  {
    int i;
    if ((!isMainAxisDirectionHorizontal()) && (this.mIsRtl)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      i = paramInt - this.mOrientationHelper.getStartAfterPadding();
      if (i > 0) {
        i = handleScrollingMainOrientation(i, paramRecycler, paramState);
      } else {
        return 0;
      }
    }
    else
    {
      i = this.mOrientationHelper.getEndAfterPadding() - paramInt;
      if (i <= 0) {
        break label125;
      }
      i = -handleScrollingMainOrientation(-i, paramRecycler, paramState);
    }
    if (paramBoolean)
    {
      paramInt = this.mOrientationHelper.getEndAfterPadding() - (paramInt + i);
      if (paramInt > 0)
      {
        this.mOrientationHelper.offsetChildren(paramInt);
        return paramInt + i;
      }
    }
    return i;
    label125:
    return 0;
  }
  
  private int fixLayoutStartGap(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean)
  {
    int i;
    if ((!isMainAxisDirectionHorizontal()) && (this.mIsRtl))
    {
      i = this.mOrientationHelper.getEndAfterPadding() - paramInt;
      if (i > 0) {
        i = handleScrollingMainOrientation(-i, paramRecycler, paramState);
      } else {
        return 0;
      }
    }
    else
    {
      i = paramInt - this.mOrientationHelper.getStartAfterPadding();
      if (i <= 0) {
        break label121;
      }
      i = -handleScrollingMainOrientation(i, paramRecycler, paramState);
    }
    int j = i;
    if (paramBoolean)
    {
      paramInt = paramInt + i - this.mOrientationHelper.getStartAfterPadding();
      j = i;
      if (paramInt > 0)
      {
        this.mOrientationHelper.offsetChildren(-paramInt);
        j = i - paramInt;
      }
    }
    return j;
    label121:
    return 0;
  }
  
  private int getChildBottom(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return getDecoratedBottom(paramView) + localLayoutParams.bottomMargin;
  }
  
  private View getChildClosestToStart()
  {
    return getChildAt(0);
  }
  
  private int getChildLeft(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return getDecoratedLeft(paramView) - localLayoutParams.leftMargin;
  }
  
  private int getChildRight(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return getDecoratedRight(paramView) + localLayoutParams.rightMargin;
  }
  
  private int getChildTop(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return getDecoratedTop(paramView) - localLayoutParams.topMargin;
  }
  
  private int handleScrollingMainOrientation(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (getChildCount() != 0)
    {
      if (paramInt == 0) {
        return 0;
      }
      ensureOrientationHelper();
      LayoutState localLayoutState = this.mLayoutState;
      int j = 1;
      LayoutState.access$502(localLayoutState, true);
      int i;
      if ((!isMainAxisDirectionHorizontal()) && (this.mIsRtl)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (paramInt < 0) {}
      }
      else {
        while (paramInt <= 0)
        {
          j = -1;
          break;
        }
      }
      int k = Math.abs(paramInt);
      updateLayoutState(j, k);
      int m = this.mLayoutState.mScrollingOffset + fill(paramRecycler, paramState, this.mLayoutState);
      if (m < 0) {
        return 0;
      }
      if (i != 0)
      {
        if (k > m) {
          paramInt = -j * m;
        }
      }
      else if (k > m) {
        paramInt = j * m;
      }
      this.mOrientationHelper.offsetChildren(-paramInt);
      LayoutState.access$2702(this.mLayoutState, paramInt);
      return paramInt;
    }
    return 0;
  }
  
  private int handleScrollingSubOrientation(int paramInt)
  {
    int i = getChildCount();
    int k = 0;
    if (i != 0)
    {
      if (paramInt == 0) {
        return 0;
      }
      ensureOrientationHelper();
      boolean bool = isMainAxisDirectionHorizontal();
      View localView = this.mParent;
      if (bool) {
        i = localView.getWidth();
      } else {
        i = localView.getHeight();
      }
      int j;
      if (bool) {
        j = getWidth();
      } else {
        j = getHeight();
      }
      if (getLayoutDirection() == 1) {
        k = 1;
      }
      if (k != 0)
      {
        k = Math.abs(paramInt);
        if (paramInt < 0) {
          paramInt = Math.min(j + this.mAnchorInfo.mPerpendicularCoordinate - i, k);
        } else {
          if (this.mAnchorInfo.mPerpendicularCoordinate + paramInt <= 0) {
            break label186;
          }
        }
      }
      for (paramInt = this.mAnchorInfo.mPerpendicularCoordinate;; paramInt = this.mAnchorInfo.mPerpendicularCoordinate)
      {
        return -paramInt;
        if (paramInt > 0) {
          return Math.min(j - this.mAnchorInfo.mPerpendicularCoordinate - i, paramInt);
        }
        if (this.mAnchorInfo.mPerpendicularCoordinate + paramInt >= 0) {
          return paramInt;
        }
      }
      label186:
      return paramInt;
    }
    return 0;
  }
  
  private static boolean isMeasurementUpToDate(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    boolean bool2 = false;
    boolean bool1 = false;
    if ((paramInt3 > 0) && (paramInt1 != paramInt3)) {
      return false;
    }
    if (i != Integer.MIN_VALUE)
    {
      if (i != 0)
      {
        if (i != 1073741824) {
          return false;
        }
        if (paramInt2 == paramInt1) {
          bool1 = true;
        }
        return bool1;
      }
      return true;
    }
    bool1 = bool2;
    if (paramInt2 >= paramInt1) {
      bool1 = true;
    }
    return bool1;
  }
  
  private boolean isViewVisible(View paramView, boolean paramBoolean)
  {
    int j = getPaddingLeft();
    int m = getPaddingTop();
    int k = getWidth() - getPaddingRight();
    int n = getHeight() - getPaddingBottom();
    int i3 = getChildLeft(paramView);
    int i1 = getChildTop(paramView);
    int i4 = getChildRight(paramView);
    int i2 = getChildBottom(paramView);
    int i;
    if ((j <= i3) && (k >= i4)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i3 < k) && (i4 < j)) {
      j = 0;
    } else {
      j = 1;
    }
    if ((m <= i1) && (n >= i2)) {
      k = 1;
    } else {
      k = 0;
    }
    if ((i1 < n) && (i2 < m)) {
      m = 0;
    } else {
      m = 1;
    }
    if (paramBoolean) {
      return (i != 0) && (k != 0);
    }
    return (j != 0) && (m != 0);
  }
  
  private int layoutFlexLine(FlexLine paramFlexLine, LayoutState paramLayoutState)
  {
    if (isMainAxisDirectionHorizontal()) {
      return layoutFlexLineMainAxisHorizontal(paramFlexLine, paramLayoutState);
    }
    return layoutFlexLineMainAxisVertical(paramFlexLine, paramLayoutState);
  }
  
  private int layoutFlexLineMainAxisHorizontal(FlexLine paramFlexLine, LayoutState paramLayoutState)
  {
    int k = getPaddingLeft();
    int n = getPaddingRight();
    int i1 = getWidth();
    int i = paramLayoutState.mOffset;
    int j = i;
    if (paramLayoutState.mLayoutDirection == -1) {
      j = i - paramFlexLine.mCrossSize;
    }
    int m = paramLayoutState.mPosition;
    i = this.mJustifyContent;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i == 5)
              {
                if (paramFlexLine.mItemCount != 0) {
                  f3 = (i1 - paramFlexLine.mMainSize) / (paramFlexLine.mItemCount + 1);
                } else {
                  f3 = 0.0F;
                }
                f1 = k + f3;
                f2 = i1 - n - f3;
                break label375;
              }
              paramFlexLine = new StringBuilder();
              paramFlexLine.append("Invalid justifyContent is set: ");
              paramFlexLine.append(this.mJustifyContent);
              throw new IllegalStateException(paramFlexLine.toString());
            }
            if (paramFlexLine.mItemCount != 0) {
              f3 = (i1 - paramFlexLine.mMainSize) / paramFlexLine.mItemCount;
            } else {
              f3 = 0.0F;
            }
            f1 = k;
            f2 = f3 / 2.0F;
            f1 += f2;
            f2 = i1 - n - f2;
            break label375;
          }
          f2 = k;
          if (paramFlexLine.mItemCount != 1) {
            f1 = paramFlexLine.mItemCount - 1;
          } else {
            f1 = 1.0F;
          }
          f3 = (i1 - paramFlexLine.mMainSize) / f1;
          f4 = i1 - n;
          f1 = f2;
          f2 = f4;
          break label375;
        }
        f1 = k + (i1 - paramFlexLine.mMainSize) / 2.0F;
        f2 = i1 - n - (i1 - paramFlexLine.mMainSize) / 2.0F;
      }
      else
      {
        f1 = i1 - paramFlexLine.mMainSize + n;
        f2 = paramFlexLine.mMainSize - k;
        f3 = 0.0F;
        break label375;
      }
    }
    else
    {
      f1 = k;
      f2 = i1 - n;
    }
    float f3 = 0.0F;
    label375:
    float f4 = f1 - this.mAnchorInfo.mPerpendicularCoordinate;
    float f1 = f2 - this.mAnchorInfo.mPerpendicularCoordinate;
    f3 = Math.max(f3, 0.0F);
    i = 0;
    n = paramFlexLine.getItemCount();
    k = m;
    float f2 = f4;
    while (k < m + n)
    {
      View localView = getFlexItemAt(k);
      if (localView != null)
      {
        if (paramLayoutState.mLayoutDirection == 1)
        {
          calculateItemDecorationsForChild(localView, TEMP_RECT);
          addView(localView);
        }
        else
        {
          calculateItemDecorationsForChild(localView, TEMP_RECT);
          addView(localView, i);
          i += 1;
        }
        long l = this.mFlexboxHelper.mMeasureSpecCache[k];
        i1 = this.mFlexboxHelper.extractLowerInt(l);
        int i2 = this.mFlexboxHelper.extractHigherInt(l);
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (shouldMeasureChild(localView, i1, i2, localLayoutParams)) {
          localView.measure(i1, i2);
        }
        f2 += localLayoutParams.leftMargin + getLeftDecorationWidth(localView);
        f1 -= localLayoutParams.rightMargin + getRightDecorationWidth(localView);
        i1 = j + getTopDecorationHeight(localView);
        if (this.mIsRtl) {
          this.mFlexboxHelper.layoutSingleChildHorizontal(localView, paramFlexLine, Math.round(f1) - localView.getMeasuredWidth(), i1, Math.round(f1), i1 + localView.getMeasuredHeight());
        } else {
          this.mFlexboxHelper.layoutSingleChildHorizontal(localView, paramFlexLine, Math.round(f2), i1, Math.round(f2) + localView.getMeasuredWidth(), i1 + localView.getMeasuredHeight());
        }
        float f5 = localView.getMeasuredWidth() + localLayoutParams.rightMargin + getRightDecorationWidth(localView);
        f4 = localView.getMeasuredWidth() + localLayoutParams.leftMargin + getLeftDecorationWidth(localView);
        f2 += f5 + f3;
        f1 -= f4 + f3;
      }
      k += 1;
    }
    LayoutState.access$1502(paramLayoutState, paramLayoutState.mFlexLinePosition + this.mLayoutState.mLayoutDirection);
    return paramFlexLine.getCrossSize();
  }
  
  private int layoutFlexLineMainAxisVertical(FlexLine paramFlexLine, LayoutState paramLayoutState)
  {
    int i1 = getPaddingTop();
    int i2 = getPaddingBottom();
    int i3 = getHeight();
    int m = paramLayoutState.mOffset;
    int i = paramLayoutState.mOffset;
    int k = m;
    int j = i;
    if (paramLayoutState.mLayoutDirection == -1)
    {
      k = m - paramFlexLine.mCrossSize;
      j = i + paramFlexLine.mCrossSize;
    }
    int n = paramLayoutState.mPosition;
    i = this.mJustifyContent;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i == 5)
              {
                if (paramFlexLine.mItemCount != 0) {
                  f3 = (i3 - paramFlexLine.mMainSize) / (paramFlexLine.mItemCount + 1);
                } else {
                  f3 = 0.0F;
                }
                f1 = i1 + f3;
                f2 = i3 - i2 - f3;
                break label394;
              }
              paramFlexLine = new StringBuilder();
              paramFlexLine.append("Invalid justifyContent is set: ");
              paramFlexLine.append(this.mJustifyContent);
              throw new IllegalStateException(paramFlexLine.toString());
            }
            if (paramFlexLine.mItemCount != 0) {
              f3 = (i3 - paramFlexLine.mMainSize) / paramFlexLine.mItemCount;
            } else {
              f3 = 0.0F;
            }
            f1 = i1;
            f2 = f3 / 2.0F;
            f1 += f2;
            f2 = i3 - i2 - f2;
            break label394;
          }
          f2 = i1;
          if (paramFlexLine.mItemCount != 1) {
            f1 = paramFlexLine.mItemCount - 1;
          } else {
            f1 = 1.0F;
          }
          f3 = (i3 - paramFlexLine.mMainSize) / f1;
          f4 = i3 - i2;
          f1 = f2;
          f2 = f4;
          break label394;
        }
        f1 = i1 + (i3 - paramFlexLine.mMainSize) / 2.0F;
        f2 = i3 - i2 - (i3 - paramFlexLine.mMainSize) / 2.0F;
      }
      else
      {
        f1 = i3 - paramFlexLine.mMainSize + i2;
        f2 = paramFlexLine.mMainSize - i1;
        f3 = 0.0F;
        break label394;
      }
    }
    else
    {
      f1 = i1;
      f2 = i3 - i2;
    }
    float f3 = 0.0F;
    label394:
    float f4 = f1 - this.mAnchorInfo.mPerpendicularCoordinate;
    float f1 = f2 - this.mAnchorInfo.mPerpendicularCoordinate;
    f3 = Math.max(f3, 0.0F);
    i = 0;
    i1 = paramFlexLine.getItemCount();
    m = n;
    float f2 = f4;
    while (m < n + i1)
    {
      View localView1 = getFlexItemAt(m);
      if (localView1 != null)
      {
        long l = this.mFlexboxHelper.mMeasureSpecCache[m];
        i2 = this.mFlexboxHelper.extractLowerInt(l);
        i3 = this.mFlexboxHelper.extractHigherInt(l);
        LayoutParams localLayoutParams = (LayoutParams)localView1.getLayoutParams();
        if (shouldMeasureChild(localView1, i2, i3, localLayoutParams)) {
          localView1.measure(i2, i3);
        }
        f2 += localLayoutParams.topMargin + getTopDecorationHeight(localView1);
        f1 -= localLayoutParams.rightMargin + getBottomDecorationHeight(localView1);
        if (paramLayoutState.mLayoutDirection == 1)
        {
          calculateItemDecorationsForChild(localView1, TEMP_RECT);
          addView(localView1);
        }
        else
        {
          calculateItemDecorationsForChild(localView1, TEMP_RECT);
          addView(localView1, i);
          i += 1;
        }
        i2 = k + getLeftDecorationWidth(localView1);
        i3 = j - getRightDecorationWidth(localView1);
        boolean bool = this.mIsRtl;
        View localView2;
        if (bool)
        {
          if (this.mFromBottomToTop)
          {
            this.mFlexboxHelper.layoutSingleChildVertical(localView1, paramFlexLine, bool, i3 - localView1.getMeasuredWidth(), Math.round(f1) - localView1.getMeasuredHeight(), i3, Math.round(f1));
          }
          else
          {
            localView2 = localView1;
            this.mFlexboxHelper.layoutSingleChildVertical(localView2, paramFlexLine, bool, i3 - localView2.getMeasuredWidth(), Math.round(f2), i3, Math.round(f2) + localView2.getMeasuredHeight());
          }
        }
        else
        {
          localView2 = localView1;
          if (this.mFromBottomToTop) {
            this.mFlexboxHelper.layoutSingleChildVertical(localView2, paramFlexLine, bool, i2, Math.round(f1) - localView2.getMeasuredHeight(), i2 + localView2.getMeasuredWidth(), Math.round(f1));
          } else {
            this.mFlexboxHelper.layoutSingleChildVertical(localView2, paramFlexLine, bool, i2, Math.round(f2), i2 + localView2.getMeasuredWidth(), Math.round(f2) + localView2.getMeasuredHeight());
          }
        }
        float f5 = localView1.getMeasuredHeight() + localLayoutParams.topMargin + getBottomDecorationHeight(localView1);
        f4 = localView1.getMeasuredHeight() + localLayoutParams.bottomMargin + getTopDecorationHeight(localView1);
        f2 += f5 + f3;
        f1 -= f4 + f3;
      }
      m += 1;
    }
    LayoutState.access$1502(paramLayoutState, paramLayoutState.mFlexLinePosition + this.mLayoutState.mLayoutDirection);
    return paramFlexLine.getCrossSize();
  }
  
  private void recycleByLayoutState(RecyclerView.Recycler paramRecycler, LayoutState paramLayoutState)
  {
    if (!paramLayoutState.mShouldRecycle) {
      return;
    }
    if (paramLayoutState.mLayoutDirection == -1)
    {
      recycleFlexLinesFromEnd(paramRecycler, paramLayoutState);
      return;
    }
    recycleFlexLinesFromStart(paramRecycler, paramLayoutState);
  }
  
  private void recycleChildren(RecyclerView.Recycler paramRecycler, int paramInt1, int paramInt2)
  {
    while (paramInt2 >= paramInt1)
    {
      removeAndRecycleViewAt(paramInt2, paramRecycler);
      paramInt2 -= 1;
    }
  }
  
  private void recycleFlexLinesFromEnd(RecyclerView.Recycler paramRecycler, LayoutState paramLayoutState)
  {
    if (paramLayoutState.mScrollingOffset < 0) {
      return;
    }
    this.mOrientationHelper.getEnd();
    int j = getChildCount();
    if (j == 0) {
      return;
    }
    int n = j - 1;
    Object localObject1 = getChildAt(n);
    int k = this.mFlexboxHelper.mIndexToFlexLine[getPosition(localObject1)];
    if (k == -1) {
      return;
    }
    localObject1 = (FlexLine)this.mFlexLines.get(k);
    int i = n;
    int m;
    for (;;)
    {
      m = j;
      if (i < 0) {
        break;
      }
      View localView = getChildAt(i);
      m = j;
      if (!canViewBeRecycledFromEnd(localView, paramLayoutState.mScrollingOffset)) {
        break;
      }
      m = k;
      Object localObject2 = localObject1;
      if (((FlexLine)localObject1).mFirstIndex == getPosition(localView))
      {
        if (k <= 0)
        {
          m = i;
          break;
        }
        m = k + paramLayoutState.mLayoutDirection;
        localObject2 = (FlexLine)this.mFlexLines.get(m);
        j = i;
      }
      i -= 1;
      k = m;
      localObject1 = localObject2;
    }
    recycleChildren(paramRecycler, m, n);
  }
  
  private void recycleFlexLinesFromStart(RecyclerView.Recycler paramRecycler, LayoutState paramLayoutState)
  {
    if (paramLayoutState.mScrollingOffset < 0) {
      return;
    }
    int n = getChildCount();
    if (n == 0) {
      return;
    }
    Object localObject1 = getChildAt(0);
    int k = this.mFlexboxHelper.mIndexToFlexLine[getPosition(localObject1)];
    int j = -1;
    if (k == -1) {
      return;
    }
    localObject1 = (FlexLine)this.mFlexLines.get(k);
    int i = 0;
    int m;
    for (;;)
    {
      m = j;
      if (i >= n) {
        break;
      }
      View localView = getChildAt(i);
      m = j;
      if (!canViewBeRecycledFromStart(localView, paramLayoutState.mScrollingOffset)) {
        break;
      }
      m = k;
      Object localObject2 = localObject1;
      if (((FlexLine)localObject1).mLastIndex == getPosition(localView))
      {
        if (k >= this.mFlexLines.size() - 1)
        {
          m = i;
          break;
        }
        m = k + paramLayoutState.mLayoutDirection;
        localObject2 = (FlexLine)this.mFlexLines.get(m);
        j = i;
      }
      i += 1;
      k = m;
      localObject1 = localObject2;
    }
    recycleChildren(paramRecycler, 0, m);
  }
  
  private void resolveInfiniteAmount()
  {
    int i;
    if (isMainAxisDirectionHorizontal()) {
      i = getHeightMode();
    } else {
      i = getWidthMode();
    }
    LayoutState localLayoutState = this.mLayoutState;
    boolean bool;
    if ((i != 0) && (i != Integer.MIN_VALUE)) {
      bool = false;
    } else {
      bool = true;
    }
    LayoutState.access$1102(localLayoutState, bool);
  }
  
  private void resolveLayoutDirection()
  {
    int i = getLayoutDirection();
    int j = this.mFlexDirection;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3)
          {
            this.mIsRtl = false;
            this.mFromBottomToTop = false;
            return;
          }
          if (i == 1) {
            bool1 = true;
          }
          this.mIsRtl = bool1;
          if (this.mFlexWrap == 2) {
            this.mIsRtl = (bool1 ^ true);
          }
          this.mFromBottomToTop = true;
          return;
        }
        if (i == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        this.mIsRtl = bool1;
        if (this.mFlexWrap == 2) {
          this.mIsRtl = (bool1 ^ true);
        }
        this.mFromBottomToTop = false;
        return;
      }
      if (i != 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.mIsRtl = bool1;
      bool1 = bool2;
      if (this.mFlexWrap == 2) {
        bool1 = true;
      }
      this.mFromBottomToTop = bool1;
      return;
    }
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.mIsRtl = bool1;
    bool1 = bool3;
    if (this.mFlexWrap == 2) {
      bool1 = true;
    }
    this.mFromBottomToTop = bool1;
  }
  
  private boolean shouldMeasureChild(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
  {
    return (paramView.isLayoutRequested()) || (!isMeasurementCacheEnabled()) || (!isMeasurementUpToDate(paramView.getWidth(), paramInt1, paramLayoutParams.width)) || (!isMeasurementUpToDate(paramView.getHeight(), paramInt2, paramLayoutParams.height));
  }
  
  private boolean updateAnchorFromChildren(RecyclerView.State paramState, AnchorInfo paramAnchorInfo)
  {
    int j = getChildCount();
    int i = 0;
    if (j == 0) {
      return false;
    }
    View localView;
    if (paramAnchorInfo.mLayoutFromEnd) {
      localView = findLastReferenceChild(paramState.getItemCount());
    } else {
      localView = findFirstReferenceChild(paramState.getItemCount());
    }
    if (localView != null)
    {
      paramAnchorInfo.assignFromView(localView);
      if ((!paramState.isPreLayout()) && (supportsPredictiveItemAnimations()))
      {
        if ((this.mOrientationHelper.getDecoratedStart(localView) >= this.mOrientationHelper.getEndAfterPadding()) || (this.mOrientationHelper.getDecoratedEnd(localView) < this.mOrientationHelper.getStartAfterPadding())) {
          i = 1;
        }
        if (i != 0)
        {
          if (paramAnchorInfo.mLayoutFromEnd) {
            i = this.mOrientationHelper.getEndAfterPadding();
          } else {
            i = this.mOrientationHelper.getStartAfterPadding();
          }
          AnchorInfo.access$1702(paramAnchorInfo, i);
        }
      }
      return true;
    }
    return false;
  }
  
  private boolean updateAnchorFromPendingState(RecyclerView.State paramState, AnchorInfo paramAnchorInfo, SavedState paramSavedState)
  {
    boolean bool2 = paramState.isPreLayout();
    boolean bool1 = false;
    if (!bool2)
    {
      int i = this.mPendingScrollPosition;
      if (i == -1) {
        return false;
      }
      if ((i >= 0) && (i < paramState.getItemCount()))
      {
        AnchorInfo.access$1302(paramAnchorInfo, this.mPendingScrollPosition);
        AnchorInfo.access$1402(paramAnchorInfo, this.mFlexboxHelper.mIndexToFlexLine[paramAnchorInfo.mPosition]);
        SavedState localSavedState = this.mPendingSavedState;
        if ((localSavedState != null) && (localSavedState.hasValidAnchor(paramState.getItemCount())))
        {
          AnchorInfo.access$1702(paramAnchorInfo, this.mOrientationHelper.getStartAfterPadding() + paramSavedState.mAnchorOffset);
          AnchorInfo.access$1802(paramAnchorInfo, true);
          AnchorInfo.access$1402(paramAnchorInfo, -1);
          return true;
        }
        if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE)
        {
          paramState = findViewByPosition(this.mPendingScrollPosition);
          if (paramState != null)
          {
            if (this.mOrientationHelper.getDecoratedMeasurement(paramState) > this.mOrientationHelper.getTotalSpace())
            {
              paramAnchorInfo.assignCoordinateFromPadding();
              return true;
            }
            if (this.mOrientationHelper.getDecoratedStart(paramState) - this.mOrientationHelper.getStartAfterPadding() < 0)
            {
              AnchorInfo.access$1702(paramAnchorInfo, this.mOrientationHelper.getStartAfterPadding());
              AnchorInfo.access$902(paramAnchorInfo, false);
              return true;
            }
            if (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(paramState) < 0)
            {
              AnchorInfo.access$1702(paramAnchorInfo, this.mOrientationHelper.getEndAfterPadding());
              AnchorInfo.access$902(paramAnchorInfo, true);
              return true;
            }
            if (paramAnchorInfo.mLayoutFromEnd) {
              i = this.mOrientationHelper.getDecoratedEnd(paramState) + this.mOrientationHelper.getTotalSpaceChange();
            } else {
              i = this.mOrientationHelper.getDecoratedStart(paramState);
            }
            AnchorInfo.access$1702(paramAnchorInfo, i);
            return true;
          }
          if (getChildCount() > 0)
          {
            i = getPosition(getChildAt(0));
            if (this.mPendingScrollPosition < i) {
              bool1 = true;
            }
            AnchorInfo.access$902(paramAnchorInfo, bool1);
          }
          paramAnchorInfo.assignCoordinateFromPadding();
          return true;
        }
        if ((!isMainAxisDirectionHorizontal()) && (this.mIsRtl))
        {
          AnchorInfo.access$1702(paramAnchorInfo, this.mPendingScrollPositionOffset - this.mOrientationHelper.getEndPadding());
          return true;
        }
        AnchorInfo.access$1702(paramAnchorInfo, this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset);
        return true;
      }
      this.mPendingScrollPosition = -1;
      this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
    }
    return false;
  }
  
  private void updateAnchorInfoForLayout(RecyclerView.State paramState, AnchorInfo paramAnchorInfo)
  {
    if (updateAnchorFromPendingState(paramState, paramAnchorInfo, this.mPendingSavedState)) {
      return;
    }
    if (updateAnchorFromChildren(paramState, paramAnchorInfo)) {
      return;
    }
    paramAnchorInfo.assignCoordinateFromPadding();
    AnchorInfo.access$1302(paramAnchorInfo, 0);
    AnchorInfo.access$1402(paramAnchorInfo, 0);
  }
  
  private void updateDirtyPosition(int paramInt)
  {
    if (paramInt >= findLastVisibleItemPosition()) {
      return;
    }
    int i = getChildCount();
    this.mFlexboxHelper.ensureMeasureSpecCache(i);
    this.mFlexboxHelper.ensureMeasuredSizeCache(i);
    this.mFlexboxHelper.ensureIndexToFlexLine(i);
    if (paramInt >= this.mFlexboxHelper.mIndexToFlexLine.length) {
      return;
    }
    this.mDirtyPosition = paramInt;
    View localView = getChildClosestToStart();
    if (localView == null) {
      return;
    }
    this.mPendingScrollPosition = getPosition(localView);
    if ((!isMainAxisDirectionHorizontal()) && (this.mIsRtl))
    {
      this.mPendingScrollPositionOffset = (this.mOrientationHelper.getDecoratedEnd(localView) + this.mOrientationHelper.getEndPadding());
      return;
    }
    this.mPendingScrollPositionOffset = (this.mOrientationHelper.getDecoratedStart(localView) - this.mOrientationHelper.getStartAfterPadding());
  }
  
  private void updateFlexLines(int paramInt)
  {
    int k = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
    int m = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
    int n = getWidth();
    int i1 = getHeight();
    boolean bool = isMainAxisDirectionHorizontal();
    int i = 1;
    int j = 1;
    if (bool)
    {
      i = this.mLastWidth;
      if ((i == Integer.MIN_VALUE) || (i == n)) {
        j = 0;
      }
      if (this.mLayoutState.mInfinite) {
        i = this.mContext.getResources().getDisplayMetrics().heightPixels;
      } else {
        i = this.mLayoutState.mAvailable;
      }
    }
    else
    {
      j = this.mLastHeight;
      if ((j != Integer.MIN_VALUE) && (j != i1)) {
        j = i;
      } else {
        j = 0;
      }
      if (this.mLayoutState.mInfinite) {
        i = this.mContext.getResources().getDisplayMetrics().widthPixels;
      } else {
        i = this.mLayoutState.mAvailable;
      }
    }
    this.mLastWidth = n;
    this.mLastHeight = i1;
    if ((this.mDirtyPosition == -1) && ((this.mPendingScrollPosition != -1) || (j != 0)))
    {
      if (this.mAnchorInfo.mLayoutFromEnd) {
        return;
      }
      this.mFlexLines.clear();
      this.mFlexLinesResult.reset();
      if (isMainAxisDirectionHorizontal()) {
        this.mFlexboxHelper.calculateHorizontalFlexLinesToIndex(this.mFlexLinesResult, k, m, i, this.mAnchorInfo.mPosition, this.mFlexLines);
      } else {
        this.mFlexboxHelper.calculateVerticalFlexLinesToIndex(this.mFlexLinesResult, k, m, i, this.mAnchorInfo.mPosition, this.mFlexLines);
      }
      this.mFlexLines = this.mFlexLinesResult.mFlexLines;
      this.mFlexboxHelper.determineMainSize(k, m);
      this.mFlexboxHelper.stretchViews();
      AnchorInfo.access$1402(this.mAnchorInfo, this.mFlexboxHelper.mIndexToFlexLine[this.mAnchorInfo.mPosition]);
      LayoutState.access$1502(this.mLayoutState, this.mAnchorInfo.mFlexLinePosition);
      return;
    }
    j = this.mDirtyPosition;
    if (j != -1) {
      j = Math.min(j, this.mAnchorInfo.mPosition);
    } else {
      j = this.mAnchorInfo.mPosition;
    }
    this.mFlexLinesResult.reset();
    if (isMainAxisDirectionHorizontal())
    {
      if (this.mFlexLines.size() > 0)
      {
        this.mFlexboxHelper.clearFlexLines(this.mFlexLines, j);
        this.mFlexboxHelper.calculateFlexLines(this.mFlexLinesResult, k, m, i, j, this.mAnchorInfo.mPosition, this.mFlexLines);
      }
      else
      {
        this.mFlexboxHelper.ensureIndexToFlexLine(paramInt);
        this.mFlexboxHelper.calculateHorizontalFlexLines(this.mFlexLinesResult, k, m, i, 0, this.mFlexLines);
      }
    }
    else if (this.mFlexLines.size() > 0)
    {
      this.mFlexboxHelper.clearFlexLines(this.mFlexLines, j);
      this.mFlexboxHelper.calculateFlexLines(this.mFlexLinesResult, m, k, i, j, this.mAnchorInfo.mPosition, this.mFlexLines);
    }
    else
    {
      this.mFlexboxHelper.ensureIndexToFlexLine(paramInt);
      this.mFlexboxHelper.calculateVerticalFlexLines(this.mFlexLinesResult, k, m, i, 0, this.mFlexLines);
    }
    this.mFlexLines = this.mFlexLinesResult.mFlexLines;
    this.mFlexboxHelper.determineMainSize(k, m, j);
    this.mFlexboxHelper.stretchViews(j);
  }
  
  private void updateLayoutState(int paramInt1, int paramInt2)
  {
    LayoutState.access$2302(this.mLayoutState, paramInt1);
    boolean bool = isMainAxisDirectionHorizontal();
    int m = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
    int n = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
    int j = 0;
    int k = 0;
    int i;
    if ((!bool) && (this.mIsRtl)) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject2;
    if (paramInt1 == 1)
    {
      localObject1 = getChildAt(getChildCount() - 1);
      LayoutState.access$1002(this.mLayoutState, this.mOrientationHelper.getDecoratedEnd((View)localObject1));
      paramInt1 = getPosition((View)localObject1);
      j = this.mFlexboxHelper.mIndexToFlexLine[paramInt1];
      localObject1 = findLastReferenceViewInLine((View)localObject1, (FlexLine)this.mFlexLines.get(j));
      LayoutState.access$2502(this.mLayoutState, 1);
      localObject2 = this.mLayoutState;
      LayoutState.access$2202((LayoutState)localObject2, paramInt1 + ((LayoutState)localObject2).mItemDirection);
      if (this.mFlexboxHelper.mIndexToFlexLine.length <= this.mLayoutState.mPosition) {
        LayoutState.access$1502(this.mLayoutState, -1);
      } else {
        LayoutState.access$1502(this.mLayoutState, this.mFlexboxHelper.mIndexToFlexLine[this.mLayoutState.mPosition]);
      }
      if (i != 0)
      {
        LayoutState.access$1002(this.mLayoutState, this.mOrientationHelper.getDecoratedStart((View)localObject1));
        LayoutState.access$2002(this.mLayoutState, -this.mOrientationHelper.getDecoratedStart((View)localObject1) + this.mOrientationHelper.getStartAfterPadding());
        localObject1 = this.mLayoutState;
        paramInt1 = k;
        if (((LayoutState)localObject1).mScrollingOffset >= 0) {
          paramInt1 = this.mLayoutState.mScrollingOffset;
        }
        LayoutState.access$2002((LayoutState)localObject1, paramInt1);
      }
      else
      {
        LayoutState.access$1002(this.mLayoutState, this.mOrientationHelper.getDecoratedEnd((View)localObject1));
        LayoutState.access$2002(this.mLayoutState, this.mOrientationHelper.getDecoratedEnd((View)localObject1) - this.mOrientationHelper.getEndAfterPadding());
      }
      if (((this.mLayoutState.mFlexLinePosition == -1) || (this.mLayoutState.mFlexLinePosition > this.mFlexLines.size() - 1)) && (this.mLayoutState.mPosition <= getFlexItemCount()))
      {
        paramInt1 = paramInt2 - this.mLayoutState.mScrollingOffset;
        this.mFlexLinesResult.reset();
        if (paramInt1 > 0)
        {
          if (bool) {
            this.mFlexboxHelper.calculateHorizontalFlexLines(this.mFlexLinesResult, m, n, paramInt1, this.mLayoutState.mPosition, this.mFlexLines);
          } else {
            this.mFlexboxHelper.calculateVerticalFlexLines(this.mFlexLinesResult, m, n, paramInt1, this.mLayoutState.mPosition, this.mFlexLines);
          }
          this.mFlexboxHelper.determineMainSize(m, n, this.mLayoutState.mPosition);
          this.mFlexboxHelper.stretchViews(this.mLayoutState.mPosition);
        }
      }
    }
    else
    {
      localObject1 = getChildAt(0);
      LayoutState.access$1002(this.mLayoutState, this.mOrientationHelper.getDecoratedStart((View)localObject1));
      m = getPosition((View)localObject1);
      paramInt1 = this.mFlexboxHelper.mIndexToFlexLine[m];
      localObject1 = findFirstReferenceViewInLine((View)localObject1, (FlexLine)this.mFlexLines.get(paramInt1));
      LayoutState.access$2502(this.mLayoutState, 1);
      k = this.mFlexboxHelper.mIndexToFlexLine[m];
      paramInt1 = k;
      if (k == -1) {
        paramInt1 = 0;
      }
      if (paramInt1 > 0)
      {
        localObject2 = (FlexLine)this.mFlexLines.get(paramInt1 - 1);
        LayoutState.access$2202(this.mLayoutState, m - ((FlexLine)localObject2).getItemCount());
      }
      else
      {
        LayoutState.access$2202(this.mLayoutState, -1);
      }
      localObject2 = this.mLayoutState;
      if (paramInt1 > 0) {
        paramInt1 -= 1;
      } else {
        paramInt1 = 0;
      }
      LayoutState.access$1502((LayoutState)localObject2, paramInt1);
      if (i != 0)
      {
        LayoutState.access$1002(this.mLayoutState, this.mOrientationHelper.getDecoratedEnd((View)localObject1));
        LayoutState.access$2002(this.mLayoutState, this.mOrientationHelper.getDecoratedEnd((View)localObject1) - this.mOrientationHelper.getEndAfterPadding());
        localObject1 = this.mLayoutState;
        paramInt1 = j;
        if (((LayoutState)localObject1).mScrollingOffset >= 0) {
          paramInt1 = this.mLayoutState.mScrollingOffset;
        }
        LayoutState.access$2002((LayoutState)localObject1, paramInt1);
      }
      else
      {
        LayoutState.access$1002(this.mLayoutState, this.mOrientationHelper.getDecoratedStart((View)localObject1));
        LayoutState.access$2002(this.mLayoutState, -this.mOrientationHelper.getDecoratedStart((View)localObject1) + this.mOrientationHelper.getStartAfterPadding());
      }
    }
    Object localObject1 = this.mLayoutState;
    LayoutState.access$1202((LayoutState)localObject1, paramInt2 - ((LayoutState)localObject1).mScrollingOffset);
  }
  
  private void updateLayoutStateToFillEnd(AnchorInfo paramAnchorInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {
      resolveInfiniteAmount();
    } else {
      LayoutState.access$1102(this.mLayoutState, false);
    }
    if ((!isMainAxisDirectionHorizontal()) && (this.mIsRtl)) {
      LayoutState.access$1202(this.mLayoutState, paramAnchorInfo.mCoordinate - getPaddingRight());
    } else {
      LayoutState.access$1202(this.mLayoutState, this.mOrientationHelper.getEndAfterPadding() - paramAnchorInfo.mCoordinate);
    }
    LayoutState.access$2202(this.mLayoutState, paramAnchorInfo.mPosition);
    LayoutState.access$2502(this.mLayoutState, 1);
    LayoutState.access$2302(this.mLayoutState, 1);
    LayoutState.access$1002(this.mLayoutState, paramAnchorInfo.mCoordinate);
    LayoutState.access$2002(this.mLayoutState, Integer.MIN_VALUE);
    LayoutState.access$1502(this.mLayoutState, paramAnchorInfo.mFlexLinePosition);
    if ((paramBoolean1) && (this.mFlexLines.size() > 1) && (paramAnchorInfo.mFlexLinePosition >= 0) && (paramAnchorInfo.mFlexLinePosition < this.mFlexLines.size() - 1))
    {
      paramAnchorInfo = (FlexLine)this.mFlexLines.get(paramAnchorInfo.mFlexLinePosition);
      LayoutState.access$1508(this.mLayoutState);
      LayoutState localLayoutState = this.mLayoutState;
      LayoutState.access$2202(localLayoutState, localLayoutState.mPosition + paramAnchorInfo.getItemCount());
    }
  }
  
  private void updateLayoutStateToFillStart(AnchorInfo paramAnchorInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {
      resolveInfiniteAmount();
    } else {
      LayoutState.access$1102(this.mLayoutState, false);
    }
    if ((!isMainAxisDirectionHorizontal()) && (this.mIsRtl)) {
      LayoutState.access$1202(this.mLayoutState, this.mParent.getWidth() - paramAnchorInfo.mCoordinate - this.mOrientationHelper.getStartAfterPadding());
    } else {
      LayoutState.access$1202(this.mLayoutState, paramAnchorInfo.mCoordinate - this.mOrientationHelper.getStartAfterPadding());
    }
    LayoutState.access$2202(this.mLayoutState, paramAnchorInfo.mPosition);
    LayoutState.access$2502(this.mLayoutState, 1);
    LayoutState.access$2302(this.mLayoutState, -1);
    LayoutState.access$1002(this.mLayoutState, paramAnchorInfo.mCoordinate);
    LayoutState.access$2002(this.mLayoutState, Integer.MIN_VALUE);
    LayoutState.access$1502(this.mLayoutState, paramAnchorInfo.mFlexLinePosition);
    if ((paramBoolean1) && (paramAnchorInfo.mFlexLinePosition > 0) && (this.mFlexLines.size() > paramAnchorInfo.mFlexLinePosition))
    {
      paramAnchorInfo = (FlexLine)this.mFlexLines.get(paramAnchorInfo.mFlexLinePosition);
      LayoutState.access$1510(this.mLayoutState);
      LayoutState localLayoutState = this.mLayoutState;
      LayoutState.access$2202(localLayoutState, localLayoutState.mPosition - paramAnchorInfo.getItemCount());
    }
  }
  
  public boolean canScrollHorizontally()
  {
    if (this.mFlexWrap == 0) {
      return isMainAxisDirectionHorizontal();
    }
    boolean bool2 = isMainAxisDirectionHorizontal();
    boolean bool1 = false;
    if (bool2)
    {
      int j = getWidth();
      View localView = this.mParent;
      int i;
      if (localView != null) {
        i = localView.getWidth();
      } else {
        i = 0;
      }
      if (j <= i) {}
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean canScrollVertically()
  {
    int i = this.mFlexWrap;
    boolean bool = true;
    if (i == 0) {
      return isMainAxisDirectionHorizontal() ^ true;
    }
    if (!isMainAxisDirectionHorizontal())
    {
      int j = getHeight();
      View localView = this.mParent;
      if (localView != null) {
        i = localView.getHeight();
      } else {
        i = 0;
      }
      if (j > i) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public int computeHorizontalScrollExtent(RecyclerView.State paramState)
  {
    return computeScrollExtent(paramState);
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.State paramState)
  {
    return computeScrollOffset(paramState);
  }
  
  public int computeHorizontalScrollRange(RecyclerView.State paramState)
  {
    return computeScrollRange(paramState);
  }
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    if (getChildCount() == 0) {
      return null;
    }
    if (paramInt < getPosition(getChildAt(0))) {
      paramInt = -1;
    } else {
      paramInt = 1;
    }
    if (isMainAxisDirectionHorizontal()) {
      return new PointF(0.0F, paramInt);
    }
    return new PointF(paramInt, 0.0F);
  }
  
  public int computeVerticalScrollExtent(RecyclerView.State paramState)
  {
    return computeScrollExtent(paramState);
  }
  
  public int computeVerticalScrollOffset(RecyclerView.State paramState)
  {
    return computeScrollOffset(paramState);
  }
  
  public int computeVerticalScrollRange(RecyclerView.State paramState)
  {
    return computeScrollRange(paramState);
  }
  
  public int findFirstCompletelyVisibleItemPosition()
  {
    View localView = findOneVisibleChild(0, getChildCount(), true);
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  public int findFirstVisibleItemPosition()
  {
    View localView = findOneVisibleChild(0, getChildCount(), false);
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  public int findLastCompletelyVisibleItemPosition()
  {
    View localView = findOneVisibleChild(getChildCount() - 1, -1, true);
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  public int findLastVisibleItemPosition()
  {
    View localView = findOneVisibleChild(getChildCount() - 1, -1, false);
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-2, -2);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new LayoutParams(paramContext, paramAttributeSet);
  }
  
  public int getAlignContent()
  {
    return 5;
  }
  
  public int getAlignItems()
  {
    return this.mAlignItems;
  }
  
  public int getChildHeightMeasureSpec(int paramInt1, int paramInt2, int paramInt3)
  {
    return getChildMeasureSpec(getHeight(), getHeightMode(), paramInt2, paramInt3, canScrollVertically());
  }
  
  public int getChildWidthMeasureSpec(int paramInt1, int paramInt2, int paramInt3)
  {
    return getChildMeasureSpec(getWidth(), getWidthMode(), paramInt2, paramInt3, canScrollHorizontally());
  }
  
  public int getDecorationLengthCrossAxis(View paramView)
  {
    int i;
    if (isMainAxisDirectionHorizontal()) {
      i = getTopDecorationHeight(paramView);
    }
    for (int j = getBottomDecorationHeight(paramView);; j = getRightDecorationWidth(paramView))
    {
      return i + j;
      i = getLeftDecorationWidth(paramView);
    }
  }
  
  public int getDecorationLengthMainAxis(View paramView, int paramInt1, int paramInt2)
  {
    if (isMainAxisDirectionHorizontal()) {
      paramInt2 = getLeftDecorationWidth(paramView);
    }
    for (paramInt1 = getRightDecorationWidth(paramView);; paramInt1 = getBottomDecorationHeight(paramView))
    {
      return paramInt2 + paramInt1;
      paramInt2 = getTopDecorationHeight(paramView);
    }
  }
  
  public int getFlexDirection()
  {
    return this.mFlexDirection;
  }
  
  public View getFlexItemAt(int paramInt)
  {
    View localView = (View)this.mViewCache.get(paramInt);
    if (localView != null) {
      return localView;
    }
    return this.mRecycler.getViewForPosition(paramInt);
  }
  
  public int getFlexItemCount()
  {
    return this.mState.getItemCount();
  }
  
  public List<FlexLine> getFlexLines()
  {
    ArrayList localArrayList = new ArrayList(this.mFlexLines.size());
    int j = this.mFlexLines.size();
    int i = 0;
    while (i < j)
    {
      FlexLine localFlexLine = (FlexLine)this.mFlexLines.get(i);
      if (localFlexLine.getItemCount() != 0) {
        localArrayList.add(localFlexLine);
      }
      i += 1;
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
    int j = this.mFlexLines.size();
    int i = 0;
    if (j == 0) {
      return 0;
    }
    j = Integer.MIN_VALUE;
    int k = this.mFlexLines.size();
    while (i < k)
    {
      j = Math.max(j, ((FlexLine)this.mFlexLines.get(i)).mMainSize);
      i += 1;
    }
    return j;
  }
  
  public int getMaxLine()
  {
    return this.mMaxLine;
  }
  
  int getPositionToFlexLineIndex(int paramInt)
  {
    return this.mFlexboxHelper.mIndexToFlexLine[paramInt];
  }
  
  public boolean getRecycleChildrenOnDetach()
  {
    return this.mRecycleChildrenOnDetach;
  }
  
  public View getReorderedFlexItemAt(int paramInt)
  {
    return getFlexItemAt(paramInt);
  }
  
  public int getSumOfCrossSize()
  {
    int k = this.mFlexLines.size();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += ((FlexLine)this.mFlexLines.get(i)).mCrossSize;
      i += 1;
    }
    return j;
  }
  
  boolean isLayoutRtl()
  {
    return this.mIsRtl;
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
  
  public void onAdapterChanged(RecyclerView.Adapter paramAdapter1, RecyclerView.Adapter paramAdapter2)
  {
    removeAllViews();
  }
  
  public void onAttachedToWindow(RecyclerView paramRecyclerView)
  {
    super.onAttachedToWindow(paramRecyclerView);
    this.mParent = ((View)paramRecyclerView.getParent());
  }
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.Recycler paramRecycler)
  {
    super.onDetachedFromWindow(paramRecyclerView, paramRecycler);
    if (this.mRecycleChildrenOnDetach)
    {
      removeAndRecycleAllViews(paramRecycler);
      paramRecycler.clear();
    }
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onItemsAdded(paramRecyclerView, paramInt1, paramInt2);
    updateDirtyPosition(paramInt1);
  }
  
  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onItemsMoved(paramRecyclerView, paramInt1, paramInt2, paramInt3);
    updateDirtyPosition(Math.min(paramInt1, paramInt2));
  }
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onItemsRemoved(paramRecyclerView, paramInt1, paramInt2);
    updateDirtyPosition(paramInt1);
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onItemsUpdated(paramRecyclerView, paramInt1, paramInt2);
    updateDirtyPosition(paramInt1);
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    super.onItemsUpdated(paramRecyclerView, paramInt1, paramInt2, paramObject);
    updateDirtyPosition(paramInt1);
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    this.mRecycler = paramRecycler;
    this.mState = paramState;
    int i = paramState.getItemCount();
    if ((i == 0) && (paramState.isPreLayout())) {
      return;
    }
    resolveLayoutDirection();
    ensureOrientationHelper();
    ensureLayoutState();
    this.mFlexboxHelper.ensureMeasureSpecCache(i);
    this.mFlexboxHelper.ensureMeasuredSizeCache(i);
    this.mFlexboxHelper.ensureIndexToFlexLine(i);
    LayoutState.access$502(this.mLayoutState, false);
    SavedState localSavedState = this.mPendingSavedState;
    if ((localSavedState != null) && (localSavedState.hasValidAnchor(i))) {
      this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
    }
    if ((!this.mAnchorInfo.mValid) || (this.mPendingScrollPosition != -1) || (this.mPendingSavedState != null))
    {
      this.mAnchorInfo.reset();
      updateAnchorInfoForLayout(paramState, this.mAnchorInfo);
      AnchorInfo.access$702(this.mAnchorInfo, true);
    }
    detachAndScrapAttachedViews(paramRecycler);
    if (this.mAnchorInfo.mLayoutFromEnd) {
      updateLayoutStateToFillStart(this.mAnchorInfo, false, true);
    } else {
      updateLayoutStateToFillEnd(this.mAnchorInfo, false, true);
    }
    updateFlexLines(i);
    int j;
    if (this.mAnchorInfo.mLayoutFromEnd)
    {
      fill(paramRecycler, paramState, this.mLayoutState);
      i = this.mLayoutState.mOffset;
      updateLayoutStateToFillEnd(this.mAnchorInfo, true, false);
      fill(paramRecycler, paramState, this.mLayoutState);
      j = this.mLayoutState.mOffset;
    }
    else
    {
      fill(paramRecycler, paramState, this.mLayoutState);
      j = this.mLayoutState.mOffset;
      updateLayoutStateToFillStart(this.mAnchorInfo, true, false);
      fill(paramRecycler, paramState, this.mLayoutState);
      i = this.mLayoutState.mOffset;
    }
    if (getChildCount() > 0)
    {
      if (this.mAnchorInfo.mLayoutFromEnd)
      {
        fixLayoutStartGap(i + fixLayoutEndGap(j, paramRecycler, paramState, true), paramRecycler, paramState, false);
        return;
      }
      fixLayoutEndGap(j + fixLayoutStartGap(i, paramRecycler, paramState, true), paramRecycler, paramState, false);
    }
  }
  
  public void onLayoutCompleted(RecyclerView.State paramState)
  {
    super.onLayoutCompleted(paramState);
    this.mPendingSavedState = null;
    this.mPendingScrollPosition = -1;
    this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
    this.mDirtyPosition = -1;
    this.mAnchorInfo.reset();
    this.mViewCache.clear();
  }
  
  public void onNewFlexItemAdded(View paramView, int paramInt1, int paramInt2, FlexLine paramFlexLine)
  {
    calculateItemDecorationsForChild(paramView, TEMP_RECT);
    if (isMainAxisDirectionHorizontal())
    {
      paramInt1 = getLeftDecorationWidth(paramView) + getRightDecorationWidth(paramView);
      paramFlexLine.mMainSize += paramInt1;
      paramFlexLine.mDividerLengthInMainSize += paramInt1;
      return;
    }
    paramInt1 = getTopDecorationHeight(paramView) + getBottomDecorationHeight(paramView);
    paramFlexLine.mMainSize += paramInt1;
    paramFlexLine.mDividerLengthInMainSize += paramInt1;
  }
  
  public void onNewFlexLineAdded(FlexLine paramFlexLine) {}
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      this.mPendingSavedState = ((SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = this.mPendingSavedState;
    if (localSavedState != null) {
      return new SavedState(localSavedState, null);
    }
    localSavedState = new SavedState();
    if (getChildCount() > 0)
    {
      View localView = getChildClosestToStart();
      SavedState.access$202(localSavedState, getPosition(localView));
      SavedState.access$302(localSavedState, this.mOrientationHelper.getDecoratedStart(localView) - this.mOrientationHelper.getStartAfterPadding());
      return localSavedState;
    }
    localSavedState.invalidateAnchor();
    return localSavedState;
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if ((isMainAxisDirectionHorizontal()) && ((this.mFlexWrap != 0) || (!isMainAxisDirectionHorizontal())))
    {
      paramInt = handleScrollingSubOrientation(paramInt);
      paramRecycler = this.mAnchorInfo;
      AnchorInfo.access$2402(paramRecycler, paramRecycler.mPerpendicularCoordinate + paramInt);
      this.mSubOrientationHelper.offsetChildren(-paramInt);
      return paramInt;
    }
    paramInt = handleScrollingMainOrientation(paramInt, paramRecycler, paramState);
    this.mViewCache.clear();
    return paramInt;
  }
  
  public void scrollToPosition(int paramInt)
  {
    this.mPendingScrollPosition = paramInt;
    this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
    SavedState localSavedState = this.mPendingSavedState;
    if (localSavedState != null) {
      localSavedState.invalidateAnchor();
    }
    requestLayout();
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if ((!isMainAxisDirectionHorizontal()) && ((this.mFlexWrap != 0) || (isMainAxisDirectionHorizontal())))
    {
      paramInt = handleScrollingSubOrientation(paramInt);
      paramRecycler = this.mAnchorInfo;
      AnchorInfo.access$2402(paramRecycler, paramRecycler.mPerpendicularCoordinate + paramInt);
      this.mSubOrientationHelper.offsetChildren(-paramInt);
      return paramInt;
    }
    paramInt = handleScrollingMainOrientation(paramInt, paramRecycler, paramState);
    this.mViewCache.clear();
    return paramInt;
  }
  
  public void setAlignContent(int paramInt)
  {
    throw new UnsupportedOperationException("Setting the alignContent in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to use this attribute.");
  }
  
  public void setAlignItems(int paramInt)
  {
    int i = this.mAlignItems;
    if (i != paramInt)
    {
      if ((i == 4) || (paramInt == 4))
      {
        removeAllViews();
        clearFlexLines();
      }
      this.mAlignItems = paramInt;
      requestLayout();
    }
  }
  
  public void setFlexDirection(int paramInt)
  {
    if (this.mFlexDirection != paramInt)
    {
      removeAllViews();
      this.mFlexDirection = paramInt;
      this.mOrientationHelper = null;
      this.mSubOrientationHelper = null;
      clearFlexLines();
      requestLayout();
    }
  }
  
  public void setFlexLines(List<FlexLine> paramList)
  {
    this.mFlexLines = paramList;
  }
  
  public void setFlexWrap(int paramInt)
  {
    if (paramInt != 2)
    {
      int i = this.mFlexWrap;
      if (i != paramInt)
      {
        if ((i == 0) || (paramInt == 0))
        {
          removeAllViews();
          clearFlexLines();
        }
        this.mFlexWrap = paramInt;
        this.mOrientationHelper = null;
        this.mSubOrientationHelper = null;
        requestLayout();
      }
      return;
    }
    throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
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
  
  public void setRecycleChildrenOnDetach(boolean paramBoolean)
  {
    this.mRecycleChildrenOnDetach = paramBoolean;
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.State paramState, int paramInt)
  {
    paramRecyclerView = new LinearSmoothScroller(paramRecyclerView.getContext());
    paramRecyclerView.setTargetPosition(paramInt);
    startSmoothScroll(paramRecyclerView);
  }
  
  public void updateViewCache(int paramInt, View paramView)
  {
    this.mViewCache.put(paramInt, paramView);
  }
  
  private class AnchorInfo
  {
    private boolean mAssignedFromSavedState;
    private int mCoordinate;
    private int mFlexLinePosition;
    private boolean mLayoutFromEnd;
    private int mPerpendicularCoordinate = 0;
    private int mPosition;
    private boolean mValid;
    
    private AnchorInfo() {}
    
    private void assignCoordinateFromPadding()
    {
      int i;
      if ((!FlexboxLayoutManager.this.isMainAxisDirectionHorizontal()) && (FlexboxLayoutManager.this.mIsRtl))
      {
        if (this.mLayoutFromEnd) {
          i = FlexboxLayoutManager.this.mOrientationHelper.getEndAfterPadding();
        } else {
          i = FlexboxLayoutManager.this.getWidth() - FlexboxLayoutManager.this.mOrientationHelper.getStartAfterPadding();
        }
        this.mCoordinate = i;
        return;
      }
      if (this.mLayoutFromEnd) {
        i = FlexboxLayoutManager.this.mOrientationHelper.getEndAfterPadding();
      } else {
        i = FlexboxLayoutManager.this.mOrientationHelper.getStartAfterPadding();
      }
      this.mCoordinate = i;
    }
    
    private void assignFromView(View paramView)
    {
      OrientationHelper localOrientationHelper;
      if (FlexboxLayoutManager.this.mFlexWrap == 0) {
        localOrientationHelper = FlexboxLayoutManager.this.mSubOrientationHelper;
      } else {
        localOrientationHelper = FlexboxLayoutManager.this.mOrientationHelper;
      }
      if ((!FlexboxLayoutManager.this.isMainAxisDirectionHorizontal()) && (FlexboxLayoutManager.this.mIsRtl))
      {
        if (this.mLayoutFromEnd) {
          this.mCoordinate = (localOrientationHelper.getDecoratedStart(paramView) + localOrientationHelper.getTotalSpaceChange());
        } else {
          this.mCoordinate = localOrientationHelper.getDecoratedEnd(paramView);
        }
      }
      else if (this.mLayoutFromEnd) {
        this.mCoordinate = (localOrientationHelper.getDecoratedEnd(paramView) + localOrientationHelper.getTotalSpaceChange());
      } else {
        this.mCoordinate = localOrientationHelper.getDecoratedStart(paramView);
      }
      this.mPosition = FlexboxLayoutManager.this.getPosition(paramView);
      int j = 0;
      this.mAssignedFromSavedState = false;
      paramView = FlexboxLayoutManager.this.mFlexboxHelper.mIndexToFlexLine;
      int i = this.mPosition;
      if (i == -1) {
        i = 0;
      }
      int k = paramView[i];
      i = j;
      if (k != -1) {
        i = k;
      }
      this.mFlexLinePosition = i;
      if (FlexboxLayoutManager.this.mFlexLines.size() > this.mFlexLinePosition) {
        this.mPosition = ((FlexLine)FlexboxLayoutManager.this.mFlexLines.get(this.mFlexLinePosition)).mFirstIndex;
      }
    }
    
    private void reset()
    {
      this.mPosition = -1;
      this.mFlexLinePosition = -1;
      this.mCoordinate = Integer.MIN_VALUE;
      boolean bool2 = false;
      boolean bool3 = false;
      boolean bool4 = false;
      boolean bool1 = false;
      this.mValid = false;
      this.mAssignedFromSavedState = false;
      if (FlexboxLayoutManager.this.isMainAxisDirectionHorizontal())
      {
        if (FlexboxLayoutManager.this.mFlexWrap == 0)
        {
          if (FlexboxLayoutManager.this.mFlexDirection == 1) {
            bool1 = true;
          }
          this.mLayoutFromEnd = bool1;
          return;
        }
        bool1 = bool2;
        if (FlexboxLayoutManager.this.mFlexWrap == 2) {
          bool1 = true;
        }
        this.mLayoutFromEnd = bool1;
        return;
      }
      if (FlexboxLayoutManager.this.mFlexWrap == 0)
      {
        bool1 = bool3;
        if (FlexboxLayoutManager.this.mFlexDirection == 3) {
          bool1 = true;
        }
        this.mLayoutFromEnd = bool1;
        return;
      }
      bool1 = bool4;
      if (FlexboxLayoutManager.this.mFlexWrap == 2) {
        bool1 = true;
      }
      this.mLayoutFromEnd = bool1;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AnchorInfo{mPosition=");
      localStringBuilder.append(this.mPosition);
      localStringBuilder.append(", mFlexLinePosition=");
      localStringBuilder.append(this.mFlexLinePosition);
      localStringBuilder.append(", mCoordinate=");
      localStringBuilder.append(this.mCoordinate);
      localStringBuilder.append(", mPerpendicularCoordinate=");
      localStringBuilder.append(this.mPerpendicularCoordinate);
      localStringBuilder.append(", mLayoutFromEnd=");
      localStringBuilder.append(this.mLayoutFromEnd);
      localStringBuilder.append(", mValid=");
      localStringBuilder.append(this.mValid);
      localStringBuilder.append(", mAssignedFromSavedState=");
      localStringBuilder.append(this.mAssignedFromSavedState);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
    implements FlexItem
  {
    public static final Parcelable.Creator<LayoutParams> CREATOR = new Parcelable.Creator()
    {
      public FlexboxLayoutManager.LayoutParams createFromParcel(Parcel paramAnonymousParcel)
      {
        return new FlexboxLayoutManager.LayoutParams(paramAnonymousParcel);
      }
      
      public FlexboxLayoutManager.LayoutParams[] newArray(int paramAnonymousInt)
      {
        return new FlexboxLayoutManager.LayoutParams[paramAnonymousInt];
      }
    };
    private int mAlignSelf = -1;
    private float mFlexBasisPercent = -1.0F;
    private float mFlexGrow = 0.0F;
    private float mFlexShrink = 1.0F;
    private int mMaxHeight = 16777215;
    private int mMaxWidth = 16777215;
    private int mMinHeight;
    private int mMinWidth;
    private boolean mWrapBefore;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    protected LayoutParams(Parcel paramParcel)
    {
      super(-2);
      this.mFlexGrow = paramParcel.readFloat();
      this.mFlexShrink = paramParcel.readFloat();
      this.mAlignSelf = paramParcel.readInt();
      this.mFlexBasisPercent = paramParcel.readFloat();
      this.mMinWidth = paramParcel.readInt();
      this.mMinHeight = paramParcel.readInt();
      this.mMaxWidth = paramParcel.readInt();
      this.mMaxHeight = paramParcel.readInt();
      boolean bool;
      if (paramParcel.readByte() != 0) {
        bool = true;
      } else {
        bool = false;
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
    
    public LayoutParams(RecyclerView.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
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
      return 1;
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
      throw new UnsupportedOperationException("Setting the order in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to reorder using the attribute.");
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
  
  private static class LayoutState
  {
    private static final int ITEM_DIRECTION_TAIL = 1;
    private static final int LAYOUT_END = 1;
    private static final int LAYOUT_START = -1;
    private static final int SCROLLING_OFFSET_NaN = Integer.MIN_VALUE;
    private int mAvailable;
    private int mFlexLinePosition;
    private boolean mInfinite;
    private int mItemDirection = 1;
    private int mLastScrollDelta;
    private int mLayoutDirection = 1;
    private int mOffset;
    private int mPosition;
    private int mScrollingOffset;
    private boolean mShouldRecycle;
    
    private boolean hasMore(RecyclerView.State paramState, List<FlexLine> paramList)
    {
      int i = this.mPosition;
      if ((i >= 0) && (i < paramState.getItemCount()))
      {
        i = this.mFlexLinePosition;
        if ((i >= 0) && (i < paramList.size())) {
          return true;
        }
      }
      return false;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("LayoutState{mAvailable=");
      localStringBuilder.append(this.mAvailable);
      localStringBuilder.append(", mFlexLinePosition=");
      localStringBuilder.append(this.mFlexLinePosition);
      localStringBuilder.append(", mPosition=");
      localStringBuilder.append(this.mPosition);
      localStringBuilder.append(", mOffset=");
      localStringBuilder.append(this.mOffset);
      localStringBuilder.append(", mScrollingOffset=");
      localStringBuilder.append(this.mScrollingOffset);
      localStringBuilder.append(", mLastScrollDelta=");
      localStringBuilder.append(this.mLastScrollDelta);
      localStringBuilder.append(", mItemDirection=");
      localStringBuilder.append(this.mItemDirection);
      localStringBuilder.append(", mLayoutDirection=");
      localStringBuilder.append(this.mLayoutDirection);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
  
  private static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public FlexboxLayoutManager.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new FlexboxLayoutManager.SavedState(paramAnonymousParcel, null);
      }
      
      public FlexboxLayoutManager.SavedState[] newArray(int paramAnonymousInt)
      {
        return new FlexboxLayoutManager.SavedState[paramAnonymousInt];
      }
    };
    private int mAnchorOffset;
    private int mAnchorPosition;
    
    SavedState() {}
    
    private SavedState(Parcel paramParcel)
    {
      this.mAnchorPosition = paramParcel.readInt();
      this.mAnchorOffset = paramParcel.readInt();
    }
    
    private SavedState(SavedState paramSavedState)
    {
      this.mAnchorPosition = paramSavedState.mAnchorPosition;
      this.mAnchorOffset = paramSavedState.mAnchorOffset;
    }
    
    private boolean hasValidAnchor(int paramInt)
    {
      int i = this.mAnchorPosition;
      return (i >= 0) && (i < paramInt);
    }
    
    private void invalidateAnchor()
    {
      this.mAnchorPosition = -1;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SavedState{mAnchorPosition=");
      localStringBuilder.append(this.mAnchorPosition);
      localStringBuilder.append(", mAnchorOffset=");
      localStringBuilder.append(this.mAnchorOffset);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.mAnchorPosition);
      paramParcel.writeInt(this.mAnchorOffset);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\flexbox\FlexboxLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */