package com.jakewharton.rxbinding2.widget;

import android.widget.RatingBar;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.functions.Consumer;

public final class RxRatingBar
{
  private RxRatingBar()
  {
    throw new AssertionError("No instances.");
  }
  
  @Deprecated
  public static Consumer<? super Boolean> isIndicator(RatingBar paramRatingBar)
  {
    Preconditions.checkNotNull(paramRatingBar, "view == null");
    paramRatingBar.getClass();
    return new -..Lambda.mXYKOWLna-fBaWPdUPa8A_ldCAY(paramRatingBar);
  }
  
  @Deprecated
  public static Consumer<? super Float> rating(RatingBar paramRatingBar)
  {
    Preconditions.checkNotNull(paramRatingBar, "view == null");
    paramRatingBar.getClass();
    return new -..Lambda.EhCV9bXkJ4bZz5YaU0UpGJlGYuw(paramRatingBar);
  }
  
  public static InitialValueObservable<RatingBarChangeEvent> ratingChangeEvents(RatingBar paramRatingBar)
  {
    Preconditions.checkNotNull(paramRatingBar, "view == null");
    return new RatingBarRatingChangeEventObservable(paramRatingBar);
  }
  
  public static InitialValueObservable<Float> ratingChanges(RatingBar paramRatingBar)
  {
    Preconditions.checkNotNull(paramRatingBar, "view == null");
    return new RatingBarRatingChangeObservable(paramRatingBar);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\RxRatingBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */