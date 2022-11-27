package com.jakewharton.rxbinding2.view;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.functions.Predicate;

final class MenuItemClickOnSubscribe
  extends Observable<Object>
{
  private final Predicate<? super MenuItem> handled;
  private final MenuItem menuItem;
  
  MenuItemClickOnSubscribe(MenuItem paramMenuItem, Predicate<? super MenuItem> paramPredicate)
  {
    this.menuItem = paramMenuItem;
    this.handled = paramPredicate;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super Object> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class Listener
    extends MainThreadDisposable
    implements MenuItem.OnMenuItemClickListener
  {
    private final Predicate<? super MenuItem> handled;
    private final MenuItem menuItem;
    private final Observer<? super Object> observer;
    
    Listener(MenuItem paramMenuItem, Predicate<? super MenuItem> paramPredicate, Observer<? super Object> paramObserver)
    {
      this.menuItem = paramMenuItem;
      this.handled = paramPredicate;
      this.observer = paramObserver;
    }
    
    protected void onDispose()
    {
      this.menuItem.setOnMenuItemClickListener(null);
    }
    
    public boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\view\MenuItemClickOnSubscribe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */