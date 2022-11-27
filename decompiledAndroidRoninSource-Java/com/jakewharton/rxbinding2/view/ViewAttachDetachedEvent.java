package com.jakewharton.rxbinding2.view;

import android.view.View;

public abstract class ViewAttachDetachedEvent
  extends ViewAttachEvent
{
  public static ViewAttachDetachedEvent create(View paramView)
  {
    return new AutoValue_ViewAttachDetachedEvent(paramView);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\view\ViewAttachDetachedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */