package com.jakewharton.rxbinding2.widget;

import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import com.jakewharton.rxbinding2.InitialValueObservable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class RatingBarRatingChangeObservable
  extends InitialValueObservable<Float>
{
  private final RatingBar view;
  
  RatingBarRatingChangeObservable(RatingBar paramRatingBar)
  {
    this.view = paramRatingBar;
  }
  
  protected Float getInitialValue()
  {
    return null;
  }
  
  /* Error */
  protected void subscribeListener(Observer<? super Float> arg1)
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
    private final Observer<? super Float> observer;
    private final RatingBar view;
    
    Listener(RatingBar paramRatingBar, Observer<? super Float> paramObserver)
    {
      this.view = paramRatingBar;
      this.observer = paramObserver;
    }
    
    protected void onDispose()
    {
      this.view.setOnRatingBarChangeListener(null);
    }
    
    public void onRatingChanged(RatingBar paramRatingBar, float paramFloat, boolean paramBoolean)
    {
      if (!isDisposed()) {
        this.observer.onNext(Float.valueOf(paramFloat));
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\RatingBarRatingChangeObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */