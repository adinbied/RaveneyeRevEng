package com.jakewharton.rxbinding2.view;

import android.view.View;
import android.view.ViewGroup;

final class AutoValue_ViewGroupHierarchyChildViewAddEvent
  extends ViewGroupHierarchyChildViewAddEvent
{
  private final View child;
  private final ViewGroup view;
  
  AutoValue_ViewGroupHierarchyChildViewAddEvent(ViewGroup paramViewGroup, View paramView)
  {
    if (paramViewGroup != null)
    {
      this.view = paramViewGroup;
      if (paramView != null)
      {
        this.child = paramView;
        return;
      }
      throw new NullPointerException("Null child");
    }
    throw new NullPointerException("Null view");
  }
  
  public View child()
  {
    return this.child;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    return null;
  }
  
  public ViewGroup view()
  {
    return this.view;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\view\AutoValue_ViewGroupHierarchyChildViewAddEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */