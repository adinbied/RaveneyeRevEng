package com.jakewharton.rxbinding2.view;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class ViewAttachEventObservable
  extends Observable<ViewAttachEvent>
{
  private final View view;
  
  ViewAttachEventObservable(View paramView)
  {
    this.view = paramView;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super ViewAttachEvent> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class Listener
    extends MainThreadDisposable
    implements View.OnAttachStateChangeListener
  {
    private final Observer<? super ViewAttachEvent> observer;
    private final View view;
    
    Listener(View paramView, Observer<? super ViewAttachEvent> paramObserver)
    {
      this.view = paramView;
      this.observer = paramObserver;
    }
    
    protected void onDispose()
    {
      this.view.removeOnAttachStateChangeListener(this);
    }
    
    /* Error */
    public void onViewAttachedToWindow(View arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onViewDetachedFromWindow(View arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\view\ViewAttachEventObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */