package com.jakewharton.rxbinding2.view;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.functions.Predicate;

final class ViewKeyObservable
  extends Observable<KeyEvent>
{
  private final Predicate<? super KeyEvent> handled;
  private final View view;
  
  ViewKeyObservable(View paramView, Predicate<? super KeyEvent> paramPredicate)
  {
    this.view = paramView;
    this.handled = paramPredicate;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super KeyEvent> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class Listener
    extends MainThreadDisposable
    implements View.OnKeyListener
  {
    private final Predicate<? super KeyEvent> handled;
    private final Observer<? super KeyEvent> observer;
    private final View view;
    
    Listener(View paramView, Predicate<? super KeyEvent> paramPredicate, Observer<? super KeyEvent> paramObserver)
    {
      this.view = paramView;
      this.handled = paramPredicate;
      this.observer = paramObserver;
    }
    
    protected void onDispose()
    {
      this.view.setOnKeyListener(null);
    }
    
    public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
    {
      if (!isDisposed()) {
        try
        {
          if (this.handled.test(paramKeyEvent))
          {
            this.observer.onNext(paramKeyEvent);
            return true;
          }
        }
        catch (Exception paramView)
        {
          this.observer.onError(paramView);
          dispose();
        }
      }
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\view\ViewKeyObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */