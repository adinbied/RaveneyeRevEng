package com.jakewharton.rxbinding2.widget;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class AbsListViewScrollEventObservable
  extends Observable<AbsListViewScrollEvent>
{
  private final AbsListView view;
  
  AbsListViewScrollEventObservable(AbsListView paramAbsListView)
  {
    this.view = paramAbsListView;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super AbsListViewScrollEvent> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class Listener
    extends MainThreadDisposable
    implements AbsListView.OnScrollListener
  {
    private int currentScrollState = 0;
    private final Observer<? super AbsListViewScrollEvent> observer;
    private final AbsListView view;
    
    Listener(AbsListView paramAbsListView, Observer<? super AbsListViewScrollEvent> paramObserver)
    {
      this.view = paramAbsListView;
      this.observer = paramObserver;
    }
    
    protected void onDispose()
    {
      this.view.setOnScrollListener(null);
    }
    
    /* Error */
    public void onScroll(AbsListView arg1, int arg2, int arg3, int arg4)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onScrollStateChanged(AbsListView arg1, int arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\AbsListViewScrollEventObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */