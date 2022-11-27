package com.jakewharton.rxbinding2.view;

import android.view.View;
import android.view.View.OnScrollChangeListener;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class ViewScrollChangeEventObservable
  extends Observable<ViewScrollChangeEvent>
{
  private final View view;
  
  ViewScrollChangeEventObservable(View paramView)
  {
    this.view = paramView;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super ViewScrollChangeEvent> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class Listener
    extends MainThreadDisposable
    implements View.OnScrollChangeListener
  {
    private final Observer<? super ViewScrollChangeEvent> observer;
    private final View view;
    
    Listener(View paramView, Observer<? super ViewScrollChangeEvent> paramObserver)
    {
      this.view = paramView;
      this.observer = paramObserver;
    }
    
    protected void onDispose()
    {
      this.view.setOnScrollChangeListener(null);
    }
    
    /* Error */
    public void onScrollChange(View arg1, int arg2, int arg3, int arg4, int arg5)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\view\ViewScrollChangeEventObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */