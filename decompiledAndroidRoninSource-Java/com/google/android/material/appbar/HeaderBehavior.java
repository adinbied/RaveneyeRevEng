package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;

abstract class HeaderBehavior<V extends View>
  extends ViewOffsetBehavior<V>
{
  private static final int INVALID_POINTER = -1;
  private int activePointerId = -1;
  private Runnable flingRunnable;
  private boolean isBeingDragged;
  private int lastMotionY;
  OverScroller scroller;
  private int touchSlop = -1;
  private VelocityTracker velocityTracker;
  
  public HeaderBehavior() {}
  
  public HeaderBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void ensureVelocityTracker()
  {
    if (this.velocityTracker == null) {
      this.velocityTracker = VelocityTracker.obtain();
    }
  }
  
  boolean canDragView(V paramV)
  {
    return false;
  }
  
  final boolean fling(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, float paramFloat)
  {
    Runnable localRunnable = this.flingRunnable;
    if (localRunnable != null)
    {
      paramV.removeCallbacks(localRunnable);
      this.flingRunnable = null;
    }
    if (this.scroller == null) {
      this.scroller = new OverScroller(paramV.getContext());
    }
    this.scroller.fling(0, getTopAndBottomOffset(), 0, Math.round(paramFloat), 0, 0, paramInt1, paramInt2);
    if (this.scroller.computeScrollOffset())
    {
      paramCoordinatorLayout = new FlingRunnable(paramCoordinatorLayout, paramV);
      this.flingRunnable = paramCoordinatorLayout;
      ViewCompat.postOnAnimation(paramV, paramCoordinatorLayout);
      return true;
    }
    onFlingFinished(paramCoordinatorLayout, paramV);
    return false;
  }
  
  int getMaxDragOffset(V paramV)
  {
    return -paramV.getHeight();
  }
  
  int getScrollRangeForDragFling(V paramV)
  {
    return paramV.getHeight();
  }
  
  int getTopBottomOffsetForScrollingSibling()
  {
    return getTopAndBottomOffset();
  }
  
  void onFlingFinished(CoordinatorLayout paramCoordinatorLayout, V paramV) {}
  
  public boolean onInterceptTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.touchSlop < 0) {
      this.touchSlop = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    if ((paramMotionEvent.getAction() == 2) && (this.isBeingDragged)) {
      return true;
    }
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label231;
          }
        }
        else
        {
          i = this.activePointerId;
          if (i == -1) {
            break label231;
          }
          i = paramMotionEvent.findPointerIndex(i);
          if (i == -1) {
            break label231;
          }
          i = (int)paramMotionEvent.getY(i);
          if (Math.abs(i - this.lastMotionY) <= this.touchSlop) {
            break label231;
          }
          this.isBeingDragged = true;
          this.lastMotionY = i;
          break label231;
        }
      }
      this.isBeingDragged = false;
      this.activePointerId = -1;
      paramCoordinatorLayout = this.velocityTracker;
      if (paramCoordinatorLayout != null)
      {
        paramCoordinatorLayout.recycle();
        this.velocityTracker = null;
      }
    }
    else
    {
      this.isBeingDragged = false;
      i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if ((canDragView(paramV)) && (paramCoordinatorLayout.isPointInChildBounds(paramV, i, j)))
      {
        this.lastMotionY = j;
        this.activePointerId = paramMotionEvent.getPointerId(0);
        ensureVelocityTracker();
      }
    }
    label231:
    paramCoordinatorLayout = this.velocityTracker;
    if (paramCoordinatorLayout != null) {
      paramCoordinatorLayout.addMovement(paramMotionEvent);
    }
    return this.isBeingDragged;
  }
  
  public boolean onTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.touchSlop < 0) {
      this.touchSlop = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    int i = paramMotionEvent.getActionMasked();
    int j;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            break label322;
          }
        }
        else
        {
          i = paramMotionEvent.findPointerIndex(this.activePointerId);
          if (i == -1) {
            return false;
          }
          int k = (int)paramMotionEvent.getY(i);
          j = this.lastMotionY - k;
          i = j;
          if (!this.isBeingDragged)
          {
            int m = Math.abs(j);
            int n = this.touchSlop;
            i = j;
            if (m > n)
            {
              this.isBeingDragged = true;
              if (j > 0) {
                i = j - n;
              } else {
                i = j + n;
              }
            }
          }
          if (!this.isBeingDragged) {
            break label322;
          }
          this.lastMotionY = k;
          scroll(paramCoordinatorLayout, paramV, i, getMaxDragOffset(paramV), 0);
          break label322;
        }
      }
      else
      {
        VelocityTracker localVelocityTracker = this.velocityTracker;
        if (localVelocityTracker != null)
        {
          localVelocityTracker.addMovement(paramMotionEvent);
          this.velocityTracker.computeCurrentVelocity(1000);
          float f = this.velocityTracker.getYVelocity(this.activePointerId);
          fling(paramCoordinatorLayout, paramV, -getScrollRangeForDragFling(paramV), 0, f);
        }
      }
      this.isBeingDragged = false;
      this.activePointerId = -1;
      paramCoordinatorLayout = this.velocityTracker;
      if (paramCoordinatorLayout != null)
      {
        paramCoordinatorLayout.recycle();
        this.velocityTracker = null;
      }
    }
    else
    {
      i = (int)paramMotionEvent.getX();
      j = (int)paramMotionEvent.getY();
      if ((!paramCoordinatorLayout.isPointInChildBounds(paramV, i, j)) || (!canDragView(paramV))) {
        break label338;
      }
      this.lastMotionY = j;
      this.activePointerId = paramMotionEvent.getPointerId(0);
      ensureVelocityTracker();
    }
    label322:
    paramCoordinatorLayout = this.velocityTracker;
    if (paramCoordinatorLayout != null) {
      paramCoordinatorLayout.addMovement(paramMotionEvent);
    }
    return true;
    label338:
    return false;
  }
  
  final int scroll(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    return setHeaderTopBottomOffset(paramCoordinatorLayout, paramV, getTopBottomOffsetForScrollingSibling() - paramInt1, paramInt2, paramInt3);
  }
  
  int setHeaderTopBottomOffset(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    return setHeaderTopBottomOffset(paramCoordinatorLayout, paramV, paramInt, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  
  int setHeaderTopBottomOffset(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = getTopAndBottomOffset();
    if ((paramInt2 != 0) && (i >= paramInt2) && (i <= paramInt3))
    {
      paramInt1 = MathUtils.clamp(paramInt1, paramInt2, paramInt3);
      if (i != paramInt1)
      {
        setTopAndBottomOffset(paramInt1);
        return i - paramInt1;
      }
    }
    return 0;
  }
  
  private class FlingRunnable
    implements Runnable
  {
    private final V layout;
    private final CoordinatorLayout parent;
    
    FlingRunnable(V paramV)
    {
      this.parent = paramV;
      View localView;
      this.layout = localView;
    }
    
    public void run()
    {
      if ((this.layout != null) && (HeaderBehavior.this.scroller != null))
      {
        if (HeaderBehavior.this.scroller.computeScrollOffset())
        {
          HeaderBehavior localHeaderBehavior = HeaderBehavior.this;
          localHeaderBehavior.setHeaderTopBottomOffset(this.parent, this.layout, localHeaderBehavior.scroller.getCurrY());
          ViewCompat.postOnAnimation(this.layout, this);
          return;
        }
        HeaderBehavior.this.onFlingFinished(this.parent, this.layout);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\material\appbar\HeaderBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */