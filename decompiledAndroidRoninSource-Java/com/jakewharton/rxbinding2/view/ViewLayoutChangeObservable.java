package com.jakewharton.rxbinding2.view;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.jakewharton.rxbinding2.internal.Notification;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class ViewLayoutChangeObservable
  extends Observable<Object>
{
  private final View view;
  
  ViewLayoutChangeObservable(View paramView)
  {
    this.view = paramView;
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
    implements View.OnLayoutChangeListener
  {
    private final Observer<? super Object> observer;
    private final View view;
    
    Listener(View paramView, Observer<? super Object> paramObserver)
    {
      this.view = paramView;
      this.observer = paramObserver;
    }
    
    protected void onDispose()
    {
      this.view.removeOnLayoutChangeListener(this);
    }
    
    public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      if (!isDisposed()) {
        this.observer.onNext(Notification.INSTANCE);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\view\ViewLayoutChangeObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */