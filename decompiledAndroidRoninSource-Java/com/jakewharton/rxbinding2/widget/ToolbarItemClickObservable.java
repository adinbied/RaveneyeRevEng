package com.jakewharton.rxbinding2.widget;

import android.view.MenuItem;
import android.widget.Toolbar;
import android.widget.Toolbar.OnMenuItemClickListener;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class ToolbarItemClickObservable
  extends Observable<MenuItem>
{
  private final Toolbar view;
  
  ToolbarItemClickObservable(Toolbar paramToolbar)
  {
    this.view = paramToolbar;
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
    implements Toolbar.OnMenuItemClickListener
  {
    private final Observer<? super MenuItem> observer;
    private final Toolbar view;
    
    Listener(Toolbar paramToolbar, Observer<? super MenuItem> paramObserver)
    {
      this.view = paramToolbar;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\ToolbarItemClickObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */