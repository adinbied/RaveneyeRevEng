package com.google.android.material.expandable;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public final class ExpandableWidgetHelper
{
  private boolean expanded = false;
  private int expandedComponentIdHint = 0;
  private final View widget;
  
  public ExpandableWidgetHelper(ExpandableWidget paramExpandableWidget)
  {
    this.widget = ((View)paramExpandableWidget);
  }
  
  private void dispatchExpandedStateChanged()
  {
    ViewParent localViewParent = this.widget.getParent();
    if ((localViewParent instanceof CoordinatorLayout)) {
      ((CoordinatorLayout)localViewParent).dispatchDependentViewsChanged(this.widget);
    }
  }
  
  public int getExpandedComponentIdHint()
  {
    return this.expandedComponentIdHint;
  }
  
  public boolean isExpanded()
  {
    return this.expanded;
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    this.expanded = paramBundle.getBoolean("expanded", false);
    this.expandedComponentIdHint = paramBundle.getInt("expandedComponentIdHint", 0);
    if (this.expanded) {
      dispatchExpandedStateChanged();
    }
  }
  
  public Bundle onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("expanded", this.expanded);
    localBundle.putInt("expandedComponentIdHint", this.expandedComponentIdHint);
    return localBundle;
  }
  
  public boolean setExpanded(boolean paramBoolean)
  {
    if (this.expanded != paramBoolean)
    {
      this.expanded = paramBoolean;
      dispatchExpandedStateChanged();
      return true;
    }
    return false;
  }
  
  public void setExpandedComponentIdHint(int paramInt)
  {
    this.expandedComponentIdHint = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\material\expandable\ExpandableWidgetHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */