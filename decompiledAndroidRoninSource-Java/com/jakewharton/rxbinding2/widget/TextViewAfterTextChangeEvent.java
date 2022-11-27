package com.jakewharton.rxbinding2.widget;

import android.text.Editable;
import android.widget.TextView;

public abstract class TextViewAfterTextChangeEvent
{
  public static TextViewAfterTextChangeEvent create(TextView paramTextView, Editable paramEditable)
  {
    return new AutoValue_TextViewAfterTextChangeEvent(paramTextView, paramEditable);
  }
  
  public abstract Editable editable();
  
  public abstract TextView view();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\TextViewAfterTextChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */