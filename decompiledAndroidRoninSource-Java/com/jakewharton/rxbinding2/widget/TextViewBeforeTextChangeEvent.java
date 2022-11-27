package com.jakewharton.rxbinding2.widget;

import android.widget.TextView;

public abstract class TextViewBeforeTextChangeEvent
{
  public static TextViewBeforeTextChangeEvent create(TextView paramTextView, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    return new AutoValue_TextViewBeforeTextChangeEvent(paramTextView, paramCharSequence, paramInt1, paramInt2, paramInt3);
  }
  
  public abstract int after();
  
  public abstract int count();
  
  public abstract int start();
  
  public abstract CharSequence text();
  
  public abstract TextView view();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\TextViewBeforeTextChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */