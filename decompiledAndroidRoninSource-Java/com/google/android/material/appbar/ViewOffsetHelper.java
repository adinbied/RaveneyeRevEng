package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;

class ViewOffsetHelper
{
  private int layoutLeft;
  private int layoutTop;
  private int offsetLeft;
  private int offsetTop;
  private final View view;
  
  public ViewOffsetHelper(View paramView)
  {
    this.view = paramView;
  }
  
  private void updateOffsets()
  {
    View localView = this.view;
    ViewCompat.offsetTopAndBottom(localView, this.offsetTop - (localView.getTop() - this.layoutTop));
    localView = this.view;
    ViewCompat.offsetLeftAndRight(localView, this.offsetLeft - (localView.getLeft() - this.layoutLeft));
  }
  
  public int getLayoutLeft()
  {
    return this.layoutLeft;
  }
  
  public int getLayoutTop()
  {
    return this.layoutTop;
  }
  
  public int getLeftAndRightOffset()
  {
    return this.offsetLeft;
  }
  
  public int getTopAndBottomOffset()
  {
    return this.offsetTop;
  }
  
  public void onViewLayout()
  {
    this.layoutTop = this.view.getTop();
    this.layoutLeft = this.view.getLeft();
    updateOffsets();
  }
  
  public boolean setLeftAndRightOffset(int paramInt)
  {
    if (this.offsetLeft != paramInt)
    {
      this.offsetLeft = paramInt;
      updateOffsets();
      return true;
    }
    return false;
  }
  
  public boolean setTopAndBottomOffset(int paramInt)
  {
    if (this.offsetTop != paramInt)
    {
      this.offsetTop = paramInt;
      updateOffsets();
      return true;
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\material\appbar\ViewOffsetHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */