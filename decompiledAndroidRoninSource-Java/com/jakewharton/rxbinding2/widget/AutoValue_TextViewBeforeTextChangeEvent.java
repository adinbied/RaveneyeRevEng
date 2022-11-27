package com.jakewharton.rxbinding2.widget;

import android.widget.TextView;

final class AutoValue_TextViewBeforeTextChangeEvent
  extends TextViewBeforeTextChangeEvent
{
  private final int after;
  private final int count;
  private final int start;
  private final CharSequence text;
  private final TextView view;
  
  AutoValue_TextViewBeforeTextChangeEvent(TextView paramTextView, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramTextView != null)
    {
      this.view = paramTextView;
      if (paramCharSequence != null)
      {
        this.text = paramCharSequence;
        this.start = paramInt1;
        this.count = paramInt2;
        this.after = paramInt3;
        return;
      }
      throw new NullPointerException("Null text");
    }
    throw new NullPointerException("Null view");
  }
  
  public int after()
  {
    return this.after;
  }
  
  public int count()
  {
    return this.count;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public int start()
  {
    return this.start;
  }
  
  public CharSequence text()
  {
    return this.text;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\AutoValue_TextViewBeforeTextChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */