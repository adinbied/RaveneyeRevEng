package com.jakewharton.rxbinding2.widget;

import android.database.DataSetObserver;
import android.widget.Adapter;
import com.jakewharton.rxbinding2.InitialValueObservable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class AdapterDataChangeObservable<T extends Adapter>
  extends InitialValueObservable<T>
{
  private final T adapter;
  
  AdapterDataChangeObservable(T paramT)
  {
    this.adapter = paramT;
  }
  
  protected T getInitialValue()
  {
    return this.adapter;
  }
  
  /* Error */
  protected void subscribeListener(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ObserverDisposable<T extends Adapter>
    extends MainThreadDisposable
  {
    private final T adapter;
    final DataSetObserver dataSetObserver;
    
    ObserverDisposable(final T paramT, final Observer<? super T> paramObserver)
    {
      this.adapter = paramT;
      this.dataSetObserver = new DataSetObserver()
      {
        /* Error */
        public void onChanged()
        {
          // Byte code:
          //   0: return
          //   1: astore_1
          //   2: goto -2 -> 0
        }
      };
    }
    
    protected void onDispose()
    {
      this.adapter.unregisterDataSetObserver(this.dataSetObserver);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\AdapterDataChangeObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */