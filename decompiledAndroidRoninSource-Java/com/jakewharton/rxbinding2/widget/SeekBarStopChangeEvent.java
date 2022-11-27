package com.jakewharton.rxbinding2.widget;

import android.widget.SeekBar;

public abstract class SeekBarStopChangeEvent
  extends SeekBarChangeEvent
{
  public static SeekBarStopChangeEvent create(SeekBar paramSeekBar)
  {
    return new AutoValue_SeekBarStopChangeEvent(paramSeekBar);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\SeekBarStopChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */