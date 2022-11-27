package com.jakewharton.rxbinding2.view;

import android.view.View;
import android.view.ViewTreeObserver.OnDrawListener;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class ViewTreeObserverDrawObservable
  extends Observable<Object>
{
  private final View view;
  
  ViewTreeObserverDrawObservable(View paramView)
  {
    this.view = paramView;
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
    implements ViewTreeObserver.OnDrawListener
  {
    private final Observer<? super Object> observer;
    private final View view;
    
    Listener(View paramView, Observer<? super Object> paramObserver)
    {
      this.view = paramView;
      this.observer = paramObserver;
    }
    
    /* Error */
    protected void onDispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onDraw()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\view\ViewTreeObserverDrawObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */