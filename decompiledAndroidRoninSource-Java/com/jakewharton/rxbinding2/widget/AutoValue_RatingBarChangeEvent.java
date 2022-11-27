package com.jakewharton.rxbinding2.widget;

import android.widget.RatingBar;

final class AutoValue_RatingBarChangeEvent
  extends RatingBarChangeEvent
{
  private final boolean fromUser;
  private final float rating;
  private final RatingBar view;
  
  AutoValue_RatingBarChangeEvent(RatingBar paramRatingBar, float paramFloat, boolean paramBoolean)
  {
    if (paramRatingBar != null)
    {
      this.view = paramRatingBar;
      this.rating = paramFloat;
      this.fromUser = paramBoolean;
      return;
    }
    throw new NullPointerException("Null view");
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public boolean fromUser()
  {
    return this.fromUser;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public float rating()
  {
    return this.rating;
  }
  
  public String toString()
  {
    return null;
  }
  
  public RatingBar view()
  {
    return this.view;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\AutoValue_RatingBarChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */