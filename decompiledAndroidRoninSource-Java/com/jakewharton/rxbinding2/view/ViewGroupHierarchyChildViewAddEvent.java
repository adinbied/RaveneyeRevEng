package com.jakewharton.rxbinding2.view;

import android.view.View;
import android.view.ViewGroup;

public abstract class ViewGroupHierarchyChildViewAddEvent
  extends ViewGroupHierarchyChangeEvent
{
  public static ViewGroupHierarchyChildViewAddEvent create(ViewGroup paramViewGroup, View paramView)
  {
    return new AutoValue_ViewGroupHierarchyChildViewAddEvent(paramViewGroup, paramView);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\view\ViewGroupHierarchyChildViewAddEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */