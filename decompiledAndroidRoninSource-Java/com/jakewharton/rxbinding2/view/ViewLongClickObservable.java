package com.jakewharton.rxbinding2.view;

import android.view.View;
import android.view.View.OnLongClickListener;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import java.util.concurrent.Callable;

final class ViewLongClickObservable
  extends Observable<Object>
{
  private final Callable<Boolean> handled;
  private final View view;
  
  ViewLongClickObservable(View paramView, Callable<Boolean> paramCallable)
  {
    this.view = paramView;
    this.handled = paramCallable;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super Object> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class Listener
    extends MainThreadDisposable
    implements View.OnLongClickListener
  {
    private final Callable<Boolean> handled;
    private final Observer<? super Object> observer;
    private final View view;
    
    Listener(View paramView, Callable<Boolean> paramCallable, Observer<? super Object> paramObserver)
    {
      this.view = paramView;
      this.observer = paramObserver;
      this.handled = paramCallable;
    }
    
    protected void onDispose()
    {
      this.view.setOnLongClickListener(null);
    }
    
    public boolean onLongClick(View paramView)
    {
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\view\ViewLongClickObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */