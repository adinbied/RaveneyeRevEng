package com.jakewharton.rxbinding2.view;

import android.view.MenuItem;

public abstract class MenuItemActionViewExpandEvent
  extends MenuItemActionViewEvent
{
  public static MenuItemActionViewExpandEvent create(MenuItem paramMenuItem)
  {
    return new AutoValue_MenuItemActionViewExpandEvent(paramMenuItem);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\view\MenuItemActionViewExpandEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */