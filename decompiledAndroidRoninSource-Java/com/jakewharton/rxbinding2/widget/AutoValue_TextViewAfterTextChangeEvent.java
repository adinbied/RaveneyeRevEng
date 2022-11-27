package com.jakewharton.rxbinding2.widget;

import android.text.Editable;
import android.widget.TextView;

final class AutoValue_TextViewAfterTextChangeEvent
  extends TextViewAfterTextChangeEvent
{
  private final Editable editable;
  private final TextView view;
  
  AutoValue_TextViewAfterTextChangeEvent(TextView paramTextView, Editable paramEditable)
  {
    if (paramTextView != null)
    {
      this.view = paramTextView;
      this.editable = paramEditable;
      return;
    }
    throw new NullPointerException("Null view");
  }
  
  public Editable editable()
  {
    return this.editable;
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
  
  public TextView view()
  {
    return this.view;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\AutoValue_TextViewAfterTextChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */