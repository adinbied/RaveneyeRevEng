package com.jakewharton.rxbinding2.widget;

import android.widget.SeekBar;

final class AutoValue_SeekBarProgressChangeEvent
  extends SeekBarProgressChangeEvent
{
  private final boolean fromUser;
  private final int progress;
  private final SeekBar view;
  
  AutoValue_SeekBarProgressChangeEvent(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramSeekBar != null)
    {
      this.view = paramSeekBar;
      this.progress = paramInt;
      this.fromUser = paramBoolean;
      return;
    }
    throw new NullPointerException("Null view");
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public boolean fromUser()
  {
    return this.fromUser;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public int progress()
  {
    return this.progress;
  }
  
  public String toString()
  {
    return null;
  }
  
  public SeekBar view()
  {
    return this.view;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\AutoValue_SeekBarProgressChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */