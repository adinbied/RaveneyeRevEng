package com.jakewharton.rxbinding2.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.functions.Predicate;

final class TextViewEditorActionEventObservable
  extends Observable<TextViewEditorActionEvent>
{
  private final Predicate<? super TextViewEditorActionEvent> handled;
  private final TextView view;
  
  TextViewEditorActionEventObservable(TextView paramTextView, Predicate<? super TextViewEditorActionEvent> paramPredicate)
  {
    this.view = paramTextView;
    this.handled = paramPredicate;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super TextViewEditorActionEvent> arg1)
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
    private final Predicate<? super TextViewEditorActionEvent> handled;
    private final Observer<? super TextViewEditorActionEvent> observer;
    private final TextView view;
    
    Listener(TextView paramTextView, Observer<? super TextViewEditorActionEvent> paramObserver, Predicate<? super TextViewEditorActionEvent> paramPredicate)
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
      paramTextView = TextViewEditorActionEvent.create(this.view, paramInt, paramKeyEvent);
      try
      {
        if ((!isDisposed()) && (this.handled.test(paramTextView)))
        {
          this.observer.onNext(paramTextView);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\TextViewEditorActionEventObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */