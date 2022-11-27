package com.jakewharton.rxbinding2.widget;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.jakewharton.rxbinding2.InitialValueObservable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class SeekBarChangeEventObservable
  extends InitialValueObservable<SeekBarChangeEvent>
{
  private final SeekBar view;
  
  SeekBarChangeEventObservable(SeekBar paramSeekBar)
  {
    this.view = paramSeekBar;
  }
  
  protected SeekBarChangeEvent getInitialValue()
  {
    return null;
  }
  
  /* Error */
  protected void subscribeListener(Observer<? super SeekBarChangeEvent> arg1)
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
    private final Observer<? super SeekBarChangeEvent> observer;
    private final SeekBar view;
    
    Listener(SeekBar paramSeekBar, Observer<? super SeekBarChangeEvent> paramObserver)
    {
      this.view = paramSeekBar;
      this.observer = paramObserver;
    }
    
    protected void onDispose()
    {
      this.view.setOnSeekBarChangeListener(null);
    }
    
    /* Error */
    public void onProgressChanged(SeekBar arg1, int arg2, boolean arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onStartTrackingTouch(SeekBar arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onStopTrackingTouch(SeekBar arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\SeekBarChangeEventObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */