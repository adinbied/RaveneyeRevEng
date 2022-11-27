package com.jakewharton.rxbinding2.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.functions.Predicate;

final class AdapterViewItemLongClickEventObservable
  extends Observable<AdapterViewItemLongClickEvent>
{
  private final Predicate<? super AdapterViewItemLongClickEvent> handled;
  private final AdapterView<?> view;
  
  AdapterViewItemLongClickEventObservable(AdapterView<?> paramAdapterView, Predicate<? super AdapterViewItemLongClickEvent> paramPredicate)
  {
    this.view = paramAdapterView;
    this.handled = paramPredicate;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super AdapterViewItemLongClickEvent> arg1)
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
    private final Predicate<? super AdapterViewItemLongClickEvent> handled;
    private final Observer<? super AdapterViewItemLongClickEvent> observer;
    private final AdapterView<?> view;
    
    Listener(AdapterView<?> paramAdapterView, Observer<? super AdapterViewItemLongClickEvent> paramObserver, Predicate<? super AdapterViewItemLongClickEvent> paramPredicate)
    {
      this.view = paramAdapterView;
      this.observer = paramObserver;
      this.handled = paramPredicate;
    }
    
    protected void onDispose()
    {
      this.view.setOnItemLongClickListener(null);
    }
    
    public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\AdapterViewItemLongClickEventObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */