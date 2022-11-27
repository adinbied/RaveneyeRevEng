package com.jakewharton.rxbinding2.widget;

import android.widget.SeekBar;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Preconditions;

public final class RxSeekBar
{
  private RxSeekBar()
  {
    throw new AssertionError("No instances.");
  }
  
  public static InitialValueObservable<SeekBarChangeEvent> changeEvents(SeekBar paramSeekBar)
  {
    Preconditions.checkNotNull(paramSeekBar, "view == null");
    return new SeekBarChangeEventObservable(paramSeekBar);
  }
  
  public static InitialValueObservable<Integer> changes(SeekBar paramSeekBar)
  {
    Preconditions.checkNotNull(paramSeekBar, "view == null");
    return new SeekBarChangeObservable(paramSeekBar, null);
  }
  
  public static InitialValueObservable<Integer> systemChanges(SeekBar paramSeekBar)
  {
    Preconditions.checkNotNull(paramSeekBar, "view == null");
    return new SeekBarChangeObservable(paramSeekBar, Boolean.valueOf(false));
  }
  
  public static InitialValueObservable<Integer> userChanges(SeekBar paramSeekBar)
  {
    Preconditions.checkNotNull(paramSeekBar, "view == null");
    return new SeekBarChangeObservable(paramSeekBar, Boolean.valueOf(true));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\RxSeekBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */