package com.jakewharton.rxbinding2.widget;

import android.view.KeyEvent;
import android.widget.TextView;

public abstract class TextViewEditorActionEvent
{
  public static TextViewEditorActionEvent create(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    return new AutoValue_TextViewEditorActionEvent(paramTextView, paramInt, paramKeyEvent);
  }
  
  public abstract int actionId();
  
  public abstract KeyEvent keyEvent();
  
  public abstract TextView view();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\TextViewEditorActionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */