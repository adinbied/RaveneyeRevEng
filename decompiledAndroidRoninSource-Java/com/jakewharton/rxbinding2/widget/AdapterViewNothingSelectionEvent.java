package com.jakewharton.rxbinding2.widget;

import android.widget.AdapterView;

public abstract class AdapterViewNothingSelectionEvent
  extends AdapterViewSelectionEvent
{
  public static AdapterViewSelectionEvent create(AdapterView<?> paramAdapterView)
  {
    return new AutoValue_AdapterViewNothingSelectionEvent(paramAdapterView);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\AdapterViewNothingSelectionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */