package com.jakewharton.rxbinding2.widget;

import android.view.MenuItem;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class PopupMenuItemClickObservable
  extends Observable<MenuItem>
{
  private final PopupMenu view;
  
  PopupMenuItemClickObservable(PopupMenu paramPopupMenu)
  {
    this.view = paramPopupMenu;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super MenuItem> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class Listener
    extends MainThreadDisposable
    implements PopupMenu.OnMenuItemClickListener
  {
    private final Observer<? super MenuItem> observer;
    private final PopupMenu view;
    
    Listener(PopupMenu paramPopupMenu, Observer<? super MenuItem> paramObserver)
    {
      this.view = paramPopupMenu;
      this.observer = paramObserver;
    }
    
    protected void onDispose()
    {
      this.view.setOnMenuItemClickListener(null);
    }
    
    public boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\PopupMenuItemClickObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */