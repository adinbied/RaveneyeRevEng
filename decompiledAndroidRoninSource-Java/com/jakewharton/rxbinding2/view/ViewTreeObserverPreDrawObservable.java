package com.jakewharton.rxbinding2.view;

import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import java.util.concurrent.Callable;

final class ViewTreeObserverPreDrawObservable
  extends Observable<Object>
{
  private final Callable<Boolean> proceedDrawingPass;
  private final View view;
  
  ViewTreeObserverPreDrawObservable(View paramView, Callable<Boolean> paramCallable)
  {
    this.view = paramView;
    this.proceedDrawingPass = paramCallable;
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
    implements ViewTreeObserver.OnPreDrawListener
  {
    private final Observer<? super Object> observer;
    private final Callable<Boolean> proceedDrawingPass;
    private final View view;
    
    Listener(View paramView, Callable<Boolean> paramCallable, Observer<? super Object> paramObserver)
    {
      this.view = paramView;
      this.proceedDrawingPass = paramCallable;
      this.observer = paramObserver;
    }
    
    /* Error */
    protected void onDispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean onPreDraw()
    {
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\view\ViewTreeObserverPreDrawObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */