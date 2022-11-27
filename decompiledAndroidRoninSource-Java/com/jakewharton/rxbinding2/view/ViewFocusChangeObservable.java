package com.jakewharton.rxbinding2.view;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.jakewharton.rxbinding2.InitialValueObservable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class ViewFocusChangeObservable
  extends InitialValueObservable<Boolean>
{
  private final View view;
  
  ViewFocusChangeObservable(View paramView)
  {
    this.view = paramView;
  }
  
  protected Boolean getInitialValue()
  {
    return null;
  }
  
  /* Error */
  protected void subscribeListener(Observer<? super Boolean> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class Listener
    extends MainThreadDisposable
    implements View.OnFocusChangeListener
  {
    private final Observer<? super Boolean> observer;
    private final View view;
    
    Listener(View paramView, Observer<? super Boolean> paramObserver)
    {
      this.view = paramView;
      this.observer = paramObserver;
    }
    
    protected void onDispose()
    {
      this.view.setOnFocusChangeListener(null);
    }
    
    public void onFocusChange(View paramView, boolean paramBoolean)
    {
      if (!isDisposed()) {
        this.observer.onNext(Boolean.valueOf(paramBoolean));
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\view\ViewFocusChangeObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */