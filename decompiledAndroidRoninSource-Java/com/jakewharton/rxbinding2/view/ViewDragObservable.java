package com.jakewharton.rxbinding2.view;

import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.functions.Predicate;

final class ViewDragObservable
  extends Observable<DragEvent>
{
  private final Predicate<? super DragEvent> handled;
  private final View view;
  
  ViewDragObservable(View paramView, Predicate<? super DragEvent> paramPredicate)
  {
    this.view = paramView;
    this.handled = paramPredicate;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super DragEvent> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class Listener
    extends MainThreadDisposable
    implements View.OnDragListener
  {
    private final Predicate<? super DragEvent> handled;
    private final Observer<? super DragEvent> observer;
    private final View view;
    
    Listener(View paramView, Predicate<? super DragEvent> paramPredicate, Observer<? super DragEvent> paramObserver)
    {
      this.view = paramView;
      this.handled = paramPredicate;
      this.observer = paramObserver;
    }
    
    protected void onDispose()
    {
      this.view.setOnDragListener(null);
    }
    
    public boolean onDrag(View paramView, DragEvent paramDragEvent)
    {
      if (!isDisposed()) {
        try
        {
          if (this.handled.test(paramDragEvent))
          {
            this.observer.onNext(paramDragEvent);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\view\ViewDragObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */