package com.jakewharton.rxbinding2.view;

import android.view.MenuItem;

final class AutoValue_MenuItemActionViewCollapseEvent
  extends MenuItemActionViewCollapseEvent
{
  private final MenuItem menuItem;
  
  AutoValue_MenuItemActionViewCollapseEvent(MenuItem paramMenuItem)
  {
    if (paramMenuItem != null)
    {
      this.menuItem = paramMenuItem;
      return;
    }
    throw new NullPointerException("Null menuItem");
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public MenuItem menuItem()
  {
    return this.menuItem;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\view\AutoValue_MenuItemActionViewCollapseEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */