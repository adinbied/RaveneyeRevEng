package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;

class ViewOffsetBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  private int tempLeftRightOffset = 0;
  private int tempTopBottomOffset = 0;
  private ViewOffsetHelper viewOffsetHelper;
  
  public ViewOffsetBehavior() {}
  
  public ViewOffsetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int getLeftAndRightOffset()
  {
    ViewOffsetHelper localViewOffsetHelper = this.viewOffsetHelper;
    if (localViewOffsetHelper != null) {
      return localViewOffsetHelper.getLeftAndRightOffset();
    }
    return 0;
  }
  
  public int getTopAndBottomOffset()
  {
    ViewOffsetHelper localViewOffsetHelper = this.viewOffsetHelper;
    if (localViewOffsetHelper != null) {
      return localViewOffsetHelper.getTopAndBottomOffset();
    }
    return 0;
  }
  
  protected void layoutChild(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    paramCoordinatorLayout.onLayoutChild(paramV, paramInt);
  }
  
  public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    layoutChild(paramCoordinatorLayout, paramV, paramInt);
    if (this.viewOffsetHelper == null) {
      this.viewOffsetHelper = new ViewOffsetHelper(paramV);
    }
    this.viewOffsetHelper.onViewLayout();
    paramInt = this.tempTopBottomOffset;
    if (paramInt != 0)
    {
      this.viewOffsetHelper.setTopAndBottomOffset(paramInt);
      this.tempTopBottomOffset = 0;
    }
    paramInt = this.tempLeftRightOffset;
    if (paramInt != 0)
    {
      this.viewOffsetHelper.setLeftAndRightOffset(paramInt);
      this.tempLeftRightOffset = 0;
    }
    return true;
  }
  
  public boolean setLeftAndRightOffset(int paramInt)
  {
    ViewOffsetHelper localViewOffsetHelper = this.viewOffsetHelper;
    if (localViewOffsetHelper != null) {
      return localViewOffsetHelper.setLeftAndRightOffset(paramInt);
    }
    this.tempLeftRightOffset = paramInt;
    return false;
  }
  
  public boolean setTopAndBottomOffset(int paramInt)
  {
    ViewOffsetHelper localViewOffsetHelper = this.viewOffsetHelper;
    if (localViewOffsetHelper != null) {
      return localViewOffsetHelper.setTopAndBottomOffset(paramInt);
    }
    this.tempTopBottomOffset = paramInt;
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\material\appbar\ViewOffsetBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */