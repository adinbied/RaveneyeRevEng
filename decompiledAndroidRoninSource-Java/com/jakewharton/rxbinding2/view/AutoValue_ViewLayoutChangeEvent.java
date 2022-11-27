package com.jakewharton.rxbinding2.view;

import android.view.View;

final class AutoValue_ViewLayoutChangeEvent
  extends ViewLayoutChangeEvent
{
  private final int bottom;
  private final int left;
  private final int oldBottom;
  private final int oldLeft;
  private final int oldRight;
  private final int oldTop;
  private final int right;
  private final int top;
  private final View view;
  
  AutoValue_ViewLayoutChangeEvent(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (paramView != null)
    {
      this.view = paramView;
      this.left = paramInt1;
      this.top = paramInt2;
      this.right = paramInt3;
      this.bottom = paramInt4;
      this.oldLeft = paramInt5;
      this.oldTop = paramInt6;
      this.oldRight = paramInt7;
      this.oldBottom = paramInt8;
      return;
    }
    throw new NullPointerException("Null view");
  }
  
  public int bottom()
  {
    return this.bottom;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public int left()
  {
    return this.left;
  }
  
  public int oldBottom()
  {
    return this.oldBottom;
  }
  
  public int oldLeft()
  {
    return this.oldLeft;
  }
  
  public int oldRight()
  {
    return this.oldRight;
  }
  
  public int oldTop()
  {
    return this.oldTop;
  }
  
  public int right()
  {
    return this.right;
  }
  
  public String toString()
  {
    return null;
  }
  
  public int top()
  {
    return this.top;
  }
  
  public View view()
  {
    return this.view;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\view\AutoValue_ViewLayoutChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */