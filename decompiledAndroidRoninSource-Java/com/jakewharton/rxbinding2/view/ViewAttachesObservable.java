package com.jakewharton.rxbinding2.view;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class ViewAttachesObservable
  extends Observable<Object>
{
  private final boolean callOnAttach;
  private final View view;
  
  ViewAttachesObservable(View paramView, boolean paramBoolean)
  {
    this.view = paramView;
    this.callOnAttach = paramBoolean;
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
    implements View.OnAttachStateChangeListener
  {
    private final boolean callOnAttach;
    private final Observer<? super Object> observer;
    private final View view;
    
    Listener(View paramView, boolean paramBoolean, Observer<? super Object> paramObserver)
    {
      this.view = paramView;
      this.callOnAttach = paramBoolean;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\view\ViewAttachesObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */