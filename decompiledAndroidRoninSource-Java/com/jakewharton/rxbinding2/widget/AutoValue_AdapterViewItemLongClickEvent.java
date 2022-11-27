package com.jakewharton.rxbinding2.widget;

import android.view.View;
import android.widget.AdapterView;

final class AutoValue_AdapterViewItemLongClickEvent
  extends AdapterViewItemLongClickEvent
{
  private final View clickedView;
  private final long id;
  private final int position;
  private final AdapterView<?> view;
  
  AutoValue_AdapterViewItemLongClickEvent(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramAdapterView != null)
    {
      this.view = paramAdapterView;
      if (paramView != null)
      {
        this.clickedView = paramView;
        this.position = paramInt;
        this.id = paramLong;
        return;
      }
      throw new NullPointerException("Null clickedView");
    }
    throw new NullPointerException("Null view");
  }
  
  public View clickedView()
  {
    return this.clickedView;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public long id()
  {
    return this.id;
  }
  
  public int position()
  {
    return this.position;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\AutoValue_AdapterViewItemLongClickEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */