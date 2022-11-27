package com.jakewharton.rxbinding2.widget;

import android.widget.SeekBar;

public abstract class SeekBarStartChangeEvent
  extends SeekBarChangeEvent
{
  public static SeekBarStartChangeEvent create(SeekBar paramSeekBar)
  {
    return new AutoValue_SeekBarStartChangeEvent(paramSeekBar);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\SeekBarStartChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */