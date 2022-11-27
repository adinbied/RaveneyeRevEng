package com.jakewharton.rxbinding2.widget;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.jakewharton.rxbinding2.InitialValueObservable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class AdapterViewSelectionObservable
  extends InitialValueObservable<AdapterViewSelectionEvent>
{
  private final AdapterView<?> view;
  
  AdapterViewSelectionObservable(AdapterView<?> paramAdapterView)
  {
    this.view = paramAdapterView;
  }
  
  protected AdapterViewSelectionEvent getInitialValue()
  {
    return null;
  }
  
  /* Error */
  protected void subscribeListener(Observer<? super AdapterViewSelectionEvent> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class Listener
    extends MainThreadDisposable
    implements AdapterView.OnItemSelectedListener
  {
    private final Observer<? super AdapterViewSelectionEvent> observer;
    private final AdapterView<?> view;
    
    Listener(AdapterView<?> paramAdapterView, Observer<? super AdapterViewSelectionEvent> paramObserver)
    {
      this.view = paramAdapterView;
      this.observer = paramObserver;
    }
    
    protected void onDispose()
    {
      this.view.setOnItemSelectedListener(null);
    }
    
    /* Error */
    public void onItemSelected(AdapterView<?> arg1, android.view.View arg2, int arg3, long arg4)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onNothingSelected(AdapterView<?> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\AdapterViewSelectionObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */