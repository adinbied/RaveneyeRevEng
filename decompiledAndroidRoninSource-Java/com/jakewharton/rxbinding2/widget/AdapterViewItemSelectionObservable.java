package com.jakewharton.rxbinding2.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.jakewharton.rxbinding2.InitialValueObservable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class AdapterViewItemSelectionObservable
  extends InitialValueObservable<Integer>
{
  private final AdapterView<?> view;
  
  AdapterViewItemSelectionObservable(AdapterView<?> paramAdapterView)
  {
    this.view = paramAdapterView;
  }
  
  protected Integer getInitialValue()
  {
    return null;
  }
  
  /* Error */
  protected void subscribeListener(Observer<? super Integer> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class Listener
    extends MainThreadDisposable
    implements AdapterView.OnItemSelectedListener
  {
    private final Observer<? super Integer> observer;
    private final AdapterView<?> view;
    
    Listener(AdapterView<?> paramAdapterView, Observer<? super Integer> paramObserver)
    {
      this.view = paramAdapterView;
      this.observer = paramObserver;
    }
    
    protected void onDispose()
    {
      this.view.setOnItemSelectedListener(null);
    }
    
    public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      if (!isDisposed()) {
        this.observer.onNext(Integer.valueOf(paramInt));
      }
    }
    
    /* Error */
    public void onNothingSelected(AdapterView<?> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\AdapterViewItemSelectionObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */