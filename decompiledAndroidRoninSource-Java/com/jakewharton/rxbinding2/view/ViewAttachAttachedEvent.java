package com.jakewharton.rxbinding2.view;

import android.view.View;

public abstract class ViewAttachAttachedEvent
  extends ViewAttachEvent
{
  public static ViewAttachAttachedEvent create(View paramView)
  {
    return new AutoValue_ViewAttachAttachedEvent(paramView);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\view\ViewAttachAttachedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */