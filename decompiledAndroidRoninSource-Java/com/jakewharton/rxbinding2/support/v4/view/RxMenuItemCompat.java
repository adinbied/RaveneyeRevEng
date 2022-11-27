package com.jakewharton.rxbinding2.support.v4.view;

import android.view.MenuItem;
import com.jakewharton.rxbinding2.internal.Preconditions;
import com.jakewharton.rxbinding2.view.MenuItemActionViewEvent;
import com.jakewharton.rxbinding2.view.RxMenuItem;
import io.reactivex.Observable;
import io.reactivex.functions.Predicate;

@Deprecated
public final class RxMenuItemCompat
{
  private RxMenuItemCompat()
  {
    throw new AssertionError("No instances.");
  }
  
  @Deprecated
  public static Observable<MenuItemActionViewEvent> actionViewEvents(MenuItem paramMenuItem)
  {
    Preconditions.checkNotNull(paramMenuItem, "menuItem == null");
    return RxMenuItem.actionViewEvents(paramMenuItem);
  }
  
  @Deprecated
  public static Observable<MenuItemActionViewEvent> actionViewEvents(MenuItem paramMenuItem, Predicate<? super MenuItemActionViewEvent> paramPredicate)
  {
    Preconditions.checkNotNull(paramMenuItem, "menuItem == null");
    Preconditions.checkNotNull(paramPredicate, "handled == null");
    return RxMenuItem.actionViewEvents(paramMenuItem, paramPredicate);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\support\v4\view\RxMenuItemCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */