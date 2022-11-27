package com.jakewharton.rxbinding2.view;

import android.view.View;

final class AutoValue_ViewAttachAttachedEvent
  extends ViewAttachAttachedEvent
{
  private final View view;
  
  AutoValue_ViewAttachAttachedEvent(View paramView)
  {
    if (paramView != null)
    {
      this.view = paramView;
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
  
  public View view()
  {
    return this.view;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\view\AutoValue_ViewAttachAttachedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */