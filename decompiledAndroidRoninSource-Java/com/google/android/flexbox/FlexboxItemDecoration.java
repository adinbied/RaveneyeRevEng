package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.State;
import java.util.List;

public class FlexboxItemDecoration
  extends RecyclerView.ItemDecoration
{
  public static final int BOTH = 3;
  public static final int HORIZONTAL = 1;
  private static final int[] LIST_DIVIDER_ATTRS = { 16843284 };
  public static final int VERTICAL = 2;
  private Drawable mDrawable;
  private int mOrientation;
  
  public FlexboxItemDecoration(Context paramContext)
  {
    paramContext = paramContext.obtainStyledAttributes(LIST_DIVIDER_ATTRS);
    this.mDrawable = paramContext.getDrawable(0);
    paramContext.recycle();
    setOrientation(3);
  }
  
  private void drawHorizontalDecorations(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    if (!needsHorizontalDecoration()) {
      return;
    }
    FlexboxLayoutManager localFlexboxLayoutManager = (FlexboxLayoutManager)paramRecyclerView.getLayoutManager();
    int i2 = localFlexboxLayoutManager.getFlexDirection();
    int i3 = paramRecyclerView.getLeft();
    int i4 = paramRecyclerView.getPaddingLeft();
    int i5 = paramRecyclerView.getRight();
    int i6 = paramRecyclerView.getPaddingRight();
    int i7 = paramRecyclerView.getChildCount();
    int j = 0;
    while (j < i7)
    {
      View localView = paramRecyclerView.getChildAt(j);
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
      int k;
      int m;
      if (i2 == 3)
      {
        k = localView.getBottom() + localLayoutParams.bottomMargin;
        m = this.mDrawable.getIntrinsicHeight() + k;
      }
      else
      {
        m = localView.getTop() - localLayoutParams.topMargin;
        k = m - this.mDrawable.getIntrinsicHeight();
      }
      int n;
      int i;
      int i1;
      if (localFlexboxLayoutManager.isMainAxisDirectionHorizontal())
      {
        if (localFlexboxLayoutManager.isLayoutRtl())
        {
          n = Math.min(localView.getRight() + localLayoutParams.rightMargin + this.mDrawable.getIntrinsicWidth(), i5 + i6);
          i = localView.getLeft() - localLayoutParams.leftMargin;
          break label279;
        }
        i = Math.max(localView.getLeft() - localLayoutParams.leftMargin - this.mDrawable.getIntrinsicWidth(), i3 - i4);
        n = localView.getRight();
        i1 = localLayoutParams.rightMargin;
      }
      else
      {
        i = localView.getLeft() - localLayoutParams.leftMargin;
        n = localView.getRight();
        i1 = localLayoutParams.rightMargin;
      }
      n += i1;
      label279:
      this.mDrawable.setBounds(i, k, n, m);
      this.mDrawable.draw(paramCanvas);
      j += 1;
    }
  }
  
  private void drawVerticalDecorations(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    if (!needsVerticalDecoration()) {
      return;
    }
    FlexboxLayoutManager localFlexboxLayoutManager = (FlexboxLayoutManager)paramRecyclerView.getLayoutManager();
    int i2 = paramRecyclerView.getTop();
    int i3 = paramRecyclerView.getPaddingTop();
    int i4 = paramRecyclerView.getBottom();
    int i5 = paramRecyclerView.getPaddingBottom();
    int i6 = paramRecyclerView.getChildCount();
    int i7 = localFlexboxLayoutManager.getFlexDirection();
    int j = 0;
    while (j < i6)
    {
      View localView = paramRecyclerView.getChildAt(j);
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
      int k;
      int m;
      if (localFlexboxLayoutManager.isLayoutRtl())
      {
        k = localView.getRight() + localLayoutParams.rightMargin;
        m = this.mDrawable.getIntrinsicWidth() + k;
      }
      else
      {
        m = localView.getLeft() - localLayoutParams.leftMargin;
        k = m - this.mDrawable.getIntrinsicWidth();
      }
      int i;
      int n;
      if (localFlexboxLayoutManager.isMainAxisDirectionHorizontal())
      {
        i = localView.getTop() - localLayoutParams.topMargin;
        n = localView.getBottom();
      }
      for (int i1 = localLayoutParams.bottomMargin;; i1 = localLayoutParams.bottomMargin)
      {
        n += i1;
        break;
        if (i7 == 3)
        {
          n = Math.min(localView.getBottom() + localLayoutParams.bottomMargin + this.mDrawable.getIntrinsicHeight(), i4 + i5);
          i = localView.getTop() - localLayoutParams.topMargin;
          break;
        }
        i = Math.max(localView.getTop() - localLayoutParams.topMargin - this.mDrawable.getIntrinsicHeight(), i2 - i3);
        n = localView.getBottom();
      }
      this.mDrawable.setBounds(k, i, m, n);
      this.mDrawable.draw(paramCanvas);
      j += 1;
    }
  }
  
  private boolean isFirstItemInLine(int paramInt, List<FlexLine> paramList, FlexboxLayoutManager paramFlexboxLayoutManager)
  {
    int i = paramFlexboxLayoutManager.getPositionToFlexLineIndex(paramInt);
    if ((i != -1) && (i < paramFlexboxLayoutManager.getFlexLinesInternal().size()) && (((FlexLine)paramFlexboxLayoutManager.getFlexLinesInternal().get(i)).mFirstIndex == paramInt)) {
      return true;
    }
    if (paramInt == 0) {
      return true;
    }
    if (paramList.size() == 0) {
      return false;
    }
    return ((FlexLine)paramList.get(paramList.size() - 1)).mLastIndex == paramInt - 1;
  }
  
  private boolean needsHorizontalDecoration()
  {
    return (this.mOrientation & 0x1) > 0;
  }
  
  private boolean needsVerticalDecoration()
  {
    return (this.mOrientation & 0x2) > 0;
  }
  
  private void setOffsetAlongCrossAxis(Rect paramRect, int paramInt, FlexboxLayoutManager paramFlexboxLayoutManager, List<FlexLine> paramList)
  {
    if (paramList.size() == 0) {
      return;
    }
    if (paramFlexboxLayoutManager.getPositionToFlexLineIndex(paramInt) == 0) {
      return;
    }
    if (paramFlexboxLayoutManager.isMainAxisDirectionHorizontal())
    {
      if (!needsHorizontalDecoration())
      {
        paramRect.top = 0;
        paramRect.bottom = 0;
        return;
      }
      paramRect.top = this.mDrawable.getIntrinsicHeight();
      paramRect.bottom = 0;
      return;
    }
    if (!needsVerticalDecoration()) {
      return;
    }
    if (paramFlexboxLayoutManager.isLayoutRtl())
    {
      paramRect.right = this.mDrawable.getIntrinsicWidth();
      paramRect.left = 0;
      return;
    }
    paramRect.left = this.mDrawable.getIntrinsicWidth();
    paramRect.right = 0;
  }
  
  private void setOffsetAlongMainAxis(Rect paramRect, int paramInt1, FlexboxLayoutManager paramFlexboxLayoutManager, List<FlexLine> paramList, int paramInt2)
  {
    if (isFirstItemInLine(paramInt1, paramList, paramFlexboxLayoutManager)) {
      return;
    }
    if (paramFlexboxLayoutManager.isMainAxisDirectionHorizontal())
    {
      if (!needsVerticalDecoration())
      {
        paramRect.left = 0;
        paramRect.right = 0;
        return;
      }
      if (paramFlexboxLayoutManager.isLayoutRtl())
      {
        paramRect.right = this.mDrawable.getIntrinsicWidth();
        paramRect.left = 0;
        return;
      }
      paramRect.left = this.mDrawable.getIntrinsicWidth();
      paramRect.right = 0;
      return;
    }
    if (!needsHorizontalDecoration())
    {
      paramRect.top = 0;
      paramRect.bottom = 0;
      return;
    }
    if (paramInt2 == 3)
    {
      paramRect.bottom = this.mDrawable.getIntrinsicHeight();
      paramRect.top = 0;
      return;
    }
    paramRect.top = this.mDrawable.getIntrinsicHeight();
    paramRect.bottom = 0;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = paramRecyclerView.getChildAdapterPosition(paramView);
    if (i == 0) {
      return;
    }
    if ((!needsHorizontalDecoration()) && (!needsVerticalDecoration()))
    {
      paramRect.set(0, 0, 0, 0);
      return;
    }
    paramView = (FlexboxLayoutManager)paramRecyclerView.getLayoutManager();
    paramRecyclerView = paramView.getFlexLines();
    setOffsetAlongMainAxis(paramRect, i, paramView, paramRecyclerView, paramView.getFlexDirection());
    setOffsetAlongCrossAxis(paramRect, i, paramView, paramRecyclerView);
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    drawHorizontalDecorations(paramCanvas, paramRecyclerView);
    drawVerticalDecorations(paramCanvas, paramRecyclerView);
  }
  
  public void setDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      this.mDrawable = paramDrawable;
      return;
    }
    throw new IllegalArgumentException("Drawable cannot be null.");
  }
  
  public void setOrientation(int paramInt)
  {
    this.mOrientation = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\flexbox\FlexboxItemDecoration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */