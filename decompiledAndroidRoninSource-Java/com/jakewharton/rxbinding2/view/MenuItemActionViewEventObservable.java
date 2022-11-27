package com.jakewharton.rxbinding2.view;

import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.functions.Predicate;

final class MenuItemActionViewEventObservable
  extends Observable<MenuItemActionViewEvent>
{
  private final Predicate<? super MenuItemActionViewEvent> handled;
  private final MenuItem menuItem;
  
  MenuItemActionViewEventObservable(MenuItem paramMenuItem, Predicate<? super MenuItemActionViewEvent> paramPredicate)
  {
    this.menuItem = paramMenuItem;
    this.handled = paramPredicate;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super MenuItemActionViewEvent> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class Listener
    extends MainThreadDisposable
    implements MenuItem.OnActionExpandListener
  {
    private final Predicate<? super MenuItemActionViewEvent> handled;
    private final MenuItem menuItem;
    private final Observer<? super MenuItemActionViewEvent> observer;
    
    Listener(MenuItem paramMenuItem, Predicate<? super MenuItemActionViewEvent> paramPredicate, Observer<? super MenuItemActionViewEvent> paramObserver)
    {
      this.menuItem = paramMenuItem;
      this.handled = paramPredicate;
      this.observer = paramObserver;
    }
    
    private boolean onEvent(MenuItemActionViewEvent paramMenuItemActionViewEvent)
    {
      return false;
    }
    
    protected void onDispose()
    {
      this.menuItem.setOnActionExpandListener(null);
    }
    
    public boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
    {
      return onEvent(MenuItemActionViewCollapseEvent.create(paramMenuItem));
    }
    
    public boolean onMenuItemActionExpand(MenuItem paramMenuItem)
    {
      return onEvent(MenuItemActionViewExpandEvent.create(paramMenuItem));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\view\MenuItemActionViewEventObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */