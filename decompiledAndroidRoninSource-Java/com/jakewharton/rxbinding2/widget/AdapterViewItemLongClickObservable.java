package com.jakewharton.rxbinding2.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import java.util.concurrent.Callable;

final class AdapterViewItemLongClickObservable
  extends Observable<Integer>
{
  private final Callable<Boolean> handled;
  private final AdapterView<?> view;
  
  AdapterViewItemLongClickObservable(AdapterView<?> paramAdapterView, Callable<Boolean> paramCallable)
  {
    this.view = paramAdapterView;
    this.handled = paramCallable;
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
    implements AdapterView.OnItemLongClickListener
  {
    private final Callable<Boolean> handled;
    private final Observer<? super Integer> observer;
    private final AdapterView<?> view;
    
    Listener(AdapterView<?> paramAdapterView, Observer<? super Integer> paramObserver, Callable<Boolean> paramCallable)
    {
      this.view = paramAdapterView;
      this.observer = paramObserver;
      this.handled = paramCallable;
    }
    
    protected void onDispose()
    {
      this.view.setOnItemLongClickListener(null);
    }
    
    public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      if (!isDisposed()) {
        try
        {
          if (((Boolean)this.handled.call()).booleanValue())
          {
            this.observer.onNext(Integer.valueOf(paramInt));
            return true;
          }
        }
        catch (Exception paramAdapterView)
        {
          this.observer.onError(paramAdapterView);
          dispose();
        }
      }
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\AdapterViewItemLongClickObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */