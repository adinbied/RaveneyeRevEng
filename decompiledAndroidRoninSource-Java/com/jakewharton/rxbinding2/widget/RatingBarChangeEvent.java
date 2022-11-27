package com.jakewharton.rxbinding2.widget;

import android.widget.RatingBar;

public abstract class RatingBarChangeEvent
{
  public static RatingBarChangeEvent create(RatingBar paramRatingBar, float paramFloat, boolean paramBoolean)
  {
    return new AutoValue_RatingBarChangeEvent(paramRatingBar, paramFloat, paramBoolean);
  }
  
  public abstract boolean fromUser();
  
  public abstract float rating();
  
  public abstract RatingBar view();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\RatingBarChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */