package com.jakewharton.rxbinding2.widget;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.jakewharton.rxbinding2.InitialValueObservable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class RadioGroupCheckedChangeObservable
  extends InitialValueObservable<Integer>
{
  private final RadioGroup view;
  
  RadioGroupCheckedChangeObservable(RadioGroup paramRadioGroup)
  {
    this.view = paramRadioGroup;
  }
  
  protected Integer getInitialValue()
  {
    return null;
  }
  
  /* Error */
  protected void subscribeListener(Observer<? super Integer> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class Listener
    extends MainThreadDisposable
    implements RadioGroup.OnCheckedChangeListener
  {
    private int lastChecked = -1;
    private final Observer<? super Integer> observer;
    private final RadioGroup view;
    
    Listener(RadioGroup paramRadioGroup, Observer<? super Integer> paramObserver)
    {
      this.view = paramRadioGroup;
      this.observer = paramObserver;
    }
    
    public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
    {
      if ((!isDisposed()) && (paramInt != this.lastChecked))
      {
        this.lastChecked = paramInt;
        this.observer.onNext(Integer.valueOf(paramInt));
      }
    }
    
    protected void onDispose()
    {
      this.view.setOnCheckedChangeListener(null);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\RadioGroupCheckedChangeObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */