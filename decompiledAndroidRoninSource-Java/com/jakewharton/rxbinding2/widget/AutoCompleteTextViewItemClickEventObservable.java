package com.jakewharton.rxbinding2.widget;

import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class AutoCompleteTextViewItemClickEventObservable
  extends Observable<AdapterViewItemClickEvent>
{
  private final AutoCompleteTextView view;
  
  AutoCompleteTextViewItemClickEventObservable(AutoCompleteTextView paramAutoCompleteTextView)
  {
    this.view = paramAutoCompleteTextView;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super AdapterViewItemClickEvent> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class Listener
    extends MainThreadDisposable
    implements AdapterView.OnItemClickListener
  {
    private final Observer<? super AdapterViewItemClickEvent> observer;
    private final AutoCompleteTextView view;
    
    Listener(AutoCompleteTextView paramAutoCompleteTextView, Observer<? super AdapterViewItemClickEvent> paramObserver)
    {
      this.view = paramAutoCompleteTextView;
      this.observer = paramObserver;
    }
    
    protected void onDispose()
    {
      this.view.setOnItemClickListener(null);
    }
    
    /* Error */
    public void onItemClick(android.widget.AdapterView<?> arg1, android.view.View arg2, int arg3, long arg4)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\AutoCompleteTextViewItemClickEventObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */