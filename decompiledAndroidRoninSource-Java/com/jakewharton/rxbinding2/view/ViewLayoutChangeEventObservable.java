package com.jakewharton.rxbinding2.view;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class ViewLayoutChangeEventObservable
  extends Observable<ViewLayoutChangeEvent>
{
  private final View view;
  
  ViewLayoutChangeEventObservable(View paramView)
  {
    this.view = paramView;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super ViewLayoutChangeEvent> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class Listener
    extends MainThreadDisposable
    implements View.OnLayoutChangeListener
  {
    private final Observer<? super ViewLayoutChangeEvent> observer;
    private final View view;
    
    Listener(View paramView, Observer<? super ViewLayoutChangeEvent> paramObserver)
    {
      this.view = paramView;
      this.observer = paramObserver;
    }
    
    protected void onDispose()
    {
      this.view.removeOnLayoutChangeListener(this);
    }
    
    /* Error */
    public void onLayoutChange(View arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\view\ViewLayoutChangeEventObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */