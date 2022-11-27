package com.jakewharton.rxbinding2.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class AdapterViewItemClickObservable
  extends Observable<Integer>
{
  private final AdapterView<?> view;
  
  AdapterViewItemClickObservable(AdapterView<?> paramAdapterView)
  {
    this.view = paramAdapterView;
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
    implements AdapterView.OnItemClickListener
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
      this.view.setOnItemClickListener(null);
    }
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      if (!isDisposed()) {
        this.observer.onNext(Integer.valueOf(paramInt));
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\AdapterViewItemClickObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */