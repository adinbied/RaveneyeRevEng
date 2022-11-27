package com.jakewharton.rxbinding2.view;

import android.view.View;

final class AutoValue_ViewScrollChangeEvent
  extends ViewScrollChangeEvent
{
  private final int oldScrollX;
  private final int oldScrollY;
  private final int scrollX;
  private final int scrollY;
  private final View view;
  
  AutoValue_ViewScrollChangeEvent(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramView != null)
    {
      this.view = paramView;
      this.scrollX = paramInt1;
      this.scrollY = paramInt2;
      this.oldScrollX = paramInt3;
      this.oldScrollY = paramInt4;
      return;
    }
    throw new NullPointerException("Null view");
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public int oldScrollX()
  {
    return this.oldScrollX;
  }
  
  public int oldScrollY()
  {
    return this.oldScrollY;
  }
  
  public int scrollX()
  {
    return this.scrollX;
  }
  
  public int scrollY()
  {
    return this.scrollY;
  }
  
  public String toString()
  {
    return null;
  }
  
  public View view()
  {
    return this.view;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\view\AutoValue_ViewScrollChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */