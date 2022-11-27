package com.jakewharton.rxbinding2.widget;

import android.view.KeyEvent;
import android.widget.TextView;

final class AutoValue_TextViewEditorActionEvent
  extends TextViewEditorActionEvent
{
  private final int actionId;
  private final KeyEvent keyEvent;
  private final TextView view;
  
  AutoValue_TextViewEditorActionEvent(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramTextView != null)
    {
      this.view = paramTextView;
      this.actionId = paramInt;
      this.keyEvent = paramKeyEvent;
      return;
    }
    throw new NullPointerException("Null view");
  }
  
  public int actionId()
  {
    return this.actionId;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public KeyEvent keyEvent()
  {
    return this.keyEvent;
  }
  
  public String toString()
  {
    return null;
  }
  
  public TextView view()
  {
    return this.view;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\AutoValue_TextViewEditorActionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */