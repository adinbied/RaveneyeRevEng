package com.jakewharton.rxbinding2.widget;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.jakewharton.rxbinding2.InitialValueObservable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class SeekBarChangeObservable
  extends InitialValueObservable<Integer>
{
  private final Boolean shouldBeFromUser;
  private final SeekBar view;
  
  SeekBarChangeObservable(SeekBar paramSeekBar, Boolean paramBoolean)
  {
    this.view = paramSeekBar;
    this.shouldBeFromUser = paramBoolean;
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
    implements SeekBar.OnSeekBarChangeListener
  {
    private final Observer<? super Integer> observer;
    private final Boolean shouldBeFromUser;
    private final SeekBar view;
    
    Listener(SeekBar paramSeekBar, Boolean paramBoolean, Observer<? super Integer> paramObserver)
    {
      this.view = paramSeekBar;
      this.shouldBeFromUser = paramBoolean;
      this.observer = paramObserver;
    }
    
    protected void onDispose()
    {
      this.view.setOnSeekBarChangeListener(null);
    }
    
    public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
    {
      if (!isDisposed())
      {
        paramSeekBar = this.shouldBeFromUser;
        if ((paramSeekBar == null) || (paramSeekBar.booleanValue() == paramBoolean)) {
          this.observer.onNext(Integer.valueOf(paramInt));
        }
      }
    }
    
    public void onStartTrackingTouch(SeekBar paramSeekBar) {}
    
    public void onStopTrackingTouch(SeekBar paramSeekBar) {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\SeekBarChangeObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */