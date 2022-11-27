package com.jakewharton.rxbinding2.view;

import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class ViewSystemUiVisibilityChangeObservable
  extends Observable<Integer>
{
  private final View view;
  
  ViewSystemUiVisibilityChangeObservable(View paramView)
  {
    this.view = paramView;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super Integer> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class Listener
    extends MainThreadDisposable
    implements View.OnSystemUiVisibilityChangeListener
  {
    private final Observer<? super Integer> observer;
    private final View view;
    
    Listener(View paramView, Observer<? super Integer> paramObserver)
    {
      this.view = paramView;
      this.observer = paramObserver;
    }
    
    protected void onDispose()
    {
      this.view.setOnSystemUiVisibilityChangeListener(null);
    }
    
    /* Error */
    public void onSystemUiVisibilityChange(int arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\view\ViewSystemUiVisibilityChangeObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */