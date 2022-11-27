package com.jakewharton.rxbinding2.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnHoverListener;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.functions.Predicate;

final class ViewHoverObservable
  extends Observable<MotionEvent>
{
  private final Predicate<? super MotionEvent> handled;
  private final View view;
  
  ViewHoverObservable(View paramView, Predicate<? super MotionEvent> paramPredicate)
  {
    this.view = paramView;
    this.handled = paramPredicate;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super MotionEvent> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class Listener
    extends MainThreadDisposable
    implements View.OnHoverListener
  {
    private final Predicate<? super MotionEvent> handled;
    private final Observer<? super MotionEvent> observer;
    private final View view;
    
    Listener(View paramView, Predicate<? super MotionEvent> paramPredicate, Observer<? super MotionEvent> paramObserver)
    {
      this.view = paramView;
      this.handled = paramPredicate;
      this.observer = paramObserver;
    }
    
    protected void onDispose()
    {
      this.view.setOnHoverListener(null);
    }
    
    public boolean onHover(View paramView, MotionEvent paramMotionEvent)
    {
      if (!isDisposed()) {
        try
        {
          if (this.handled.test(paramMotionEvent))
          {
            this.observer.onNext(paramMotionEvent);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\view\ViewHoverObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */