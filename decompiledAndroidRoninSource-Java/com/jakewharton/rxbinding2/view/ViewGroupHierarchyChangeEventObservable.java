package com.jakewharton.rxbinding2.view;

import android.view.ViewGroup;
import android.view.ViewGroup.OnHierarchyChangeListener;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class ViewGroupHierarchyChangeEventObservable
  extends Observable<ViewGroupHierarchyChangeEvent>
{
  private final ViewGroup viewGroup;
  
  ViewGroupHierarchyChangeEventObservable(ViewGroup paramViewGroup)
  {
    this.viewGroup = paramViewGroup;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super ViewGroupHierarchyChangeEvent> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class Listener
    extends MainThreadDisposable
    implements ViewGroup.OnHierarchyChangeListener
  {
    private final Observer<? super ViewGroupHierarchyChangeEvent> observer;
    private final ViewGroup viewGroup;
    
    Listener(ViewGroup paramViewGroup, Observer<? super ViewGroupHierarchyChangeEvent> paramObserver)
    {
      this.viewGroup = paramViewGroup;
      this.observer = paramObserver;
    }
    
    /* Error */
    public void onChildViewAdded(android.view.View arg1, android.view.View arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onChildViewRemoved(android.view.View arg1, android.view.View arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    protected void onDispose()
    {
      this.viewGroup.setOnHierarchyChangeListener(null);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\view\ViewGroupHierarchyChangeEventObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */