package com.jakewharton.rxbinding2.widget;

import android.widget.AdapterView;

final class AutoValue_AdapterViewNothingSelectionEvent
  extends AdapterViewNothingSelectionEvent
{
  private final AdapterView<?> view;
  
  AutoValue_AdapterViewNothingSelectionEvent(AdapterView<?> paramAdapterView)
  {
    if (paramAdapterView != null)
    {
      this.view = paramAdapterView;
      return;
    }
    throw new NullPointerException("Null view");
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    return null;
  }
  
  public AdapterView<?> view()
  {
    return this.view;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\AutoValue_AdapterViewNothingSelectionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */