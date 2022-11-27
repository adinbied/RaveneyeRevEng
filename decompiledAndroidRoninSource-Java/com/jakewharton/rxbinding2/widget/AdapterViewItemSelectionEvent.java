package com.jakewharton.rxbinding2.widget;

import android.view.View;
import android.widget.AdapterView;

public abstract class AdapterViewItemSelectionEvent
  extends AdapterViewSelectionEvent
{
  public static AdapterViewSelectionEvent create(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return new AutoValue_AdapterViewItemSelectionEvent(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public abstract long id();
  
  public abstract int position();
  
  public abstract View selectedView();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\AdapterViewItemSelectionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */