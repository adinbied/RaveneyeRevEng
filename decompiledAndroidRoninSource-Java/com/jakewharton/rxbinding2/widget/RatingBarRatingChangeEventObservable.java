package com.jakewharton.rxbinding2.widget;

import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import com.jakewharton.rxbinding2.InitialValueObservable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class RatingBarRatingChangeEventObservable
  extends InitialValueObservable<RatingBarChangeEvent>
{
  private final RatingBar view;
  
  RatingBarRatingChangeEventObservable(RatingBar paramRatingBar)
  {
    this.view = paramRatingBar;
  }
  
  protected RatingBarChangeEvent getInitialValue()
  {
    return null;
  }
  
  /* Error */
  protected void subscribeListener(Observer<? super RatingBarChangeEvent> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class Listener
    extends MainThreadDisposable
    implements RatingBar.OnRatingBarChangeListener
  {
    private final Observer<? super RatingBarChangeEvent> observer;
    private final RatingBar view;
    
    Listener(RatingBar paramRatingBar, Observer<? super RatingBarChangeEvent> paramObserver)
    {
      this.view = paramRatingBar;
      this.observer = paramObserver;
    }
    
    protected void onDispose()
    {
      this.view.setOnRatingBarChangeListener(null);
    }
    
    /* Error */
    public void onRatingChanged(RatingBar arg1, float arg2, boolean arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\RatingBarRatingChangeEventObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */