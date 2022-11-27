package com.jakewharton.rxbinding2.widget;

import android.widget.PopupMenu;
import android.widget.PopupMenu.OnDismissListener;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class PopupMenuDismissObservable
  extends Observable<Object>
{
  private final PopupMenu view;
  
  PopupMenuDismissObservable(PopupMenu paramPopupMenu)
  {
    this.view = paramPopupMenu;
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
    implements PopupMenu.OnDismissListener
  {
    private final Observer<? super Object> observer;
    private final PopupMenu view;
    
    Listener(PopupMenu paramPopupMenu, Observer<? super Object> paramObserver)
    {
      this.view = paramPopupMenu;
      this.observer = paramObserver;
    }
    
    /* Error */
    public void onDismiss(PopupMenu arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    protected void onDispose()
    {
      this.view.setOnDismissListener(null);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\PopupMenuDismissObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */