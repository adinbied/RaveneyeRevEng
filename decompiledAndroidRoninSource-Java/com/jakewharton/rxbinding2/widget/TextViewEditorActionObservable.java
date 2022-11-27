package com.jakewharton.rxbinding2.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.functions.Predicate;

final class TextViewEditorActionObservable
  extends Observable<Integer>
{
  private final Predicate<? super Integer> handled;
  private final TextView view;
  
  TextViewEditorActionObservable(TextView paramTextView, Predicate<? super Integer> paramPredicate)
  {
    this.view = paramTextView;
    this.handled = paramPredicate;
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
    implements TextView.OnEditorActionListener
  {
    private final Predicate<? super Integer> handled;
    private final Observer<? super Integer> observer;
    private final TextView view;
    
    Listener(TextView paramTextView, Observer<? super Integer> paramObserver, Predicate<? super Integer> paramPredicate)
    {
      this.view = paramTextView;
      this.observer = paramObserver;
      this.handled = paramPredicate;
    }
    
    protected void onDispose()
    {
      this.view.setOnEditorActionListener(null);
    }
    
    public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
    {
      try
      {
        if ((!isDisposed()) && (this.handled.test(Integer.valueOf(paramInt))))
        {
          this.observer.onNext(Integer.valueOf(paramInt));
          return true;
        }
      }
      catch (Exception paramTextView)
      {
        this.observer.onError(paramTextView);
        dispose();
      }
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\TextViewEditorActionObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */