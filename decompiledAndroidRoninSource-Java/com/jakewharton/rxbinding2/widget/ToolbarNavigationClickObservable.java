package com.jakewharton.rxbinding2.widget;

import android.view.View.OnClickListener;
import android.widget.Toolbar;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class ToolbarNavigationClickObservable
  extends Observable<Object>
{
  private final Toolbar view;
  
  ToolbarNavigationClickObservable(Toolbar paramToolbar)
  {
    this.view = paramToolbar;
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
    implements View.OnClickListener
  {
    private final Observer<? super Object> observer;
    private final Toolbar view;
    
    Listener(Toolbar paramToolbar, Observer<? super Object> paramObserver)
    {
      this.view = paramToolbar;
      this.observer = paramObserver;
    }
    
    /* Error */
    public void onClick(android.view.View arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    protected void onDispose()
    {
      this.view.setNavigationOnClickListener(null);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\ToolbarNavigationClickObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */