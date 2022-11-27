package com.jakewharton.rxbinding2.widget;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.jakewharton.rxbinding2.InitialValueObservable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class CompoundButtonCheckedChangeObservable
  extends InitialValueObservable<Boolean>
{
  private final CompoundButton view;
  
  CompoundButtonCheckedChangeObservable(CompoundButton paramCompoundButton)
  {
    this.view = paramCompoundButton;
  }
  
  protected Boolean getInitialValue()
  {
    return null;
  }
  
  /* Error */
  protected void subscribeListener(Observer<? super Boolean> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class Listener
    extends MainThreadDisposable
    implements CompoundButton.OnCheckedChangeListener
  {
    private final Observer<? super Boolean> observer;
    private final CompoundButton view;
    
    Listener(CompoundButton paramCompoundButton, Observer<? super Boolean> paramObserver)
    {
      this.view = paramCompoundButton;
      this.observer = paramObserver;
    }
    
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      if (!isDisposed()) {
        this.observer.onNext(Boolean.valueOf(paramBoolean));
      }
    }
    
    protected void onDispose()
    {
      this.view.setOnCheckedChangeListener(null);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\CompoundButtonCheckedChangeObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */