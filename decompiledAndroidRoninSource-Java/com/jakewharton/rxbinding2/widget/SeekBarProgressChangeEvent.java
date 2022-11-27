package com.jakewharton.rxbinding2.widget;

import android.widget.SeekBar;

public abstract class SeekBarProgressChangeEvent
  extends SeekBarChangeEvent
{
  public static SeekBarProgressChangeEvent create(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    return new AutoValue_SeekBarProgressChangeEvent(paramSeekBar, paramInt, paramBoolean);
  }
  
  public abstract boolean fromUser();
  
  public abstract int progress();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\SeekBarProgressChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */