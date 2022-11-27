package com.jakewharton.rxbinding2.widget;

import android.widget.Adapter;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Preconditions;

public final class RxAdapter
{
  private RxAdapter()
  {
    throw new AssertionError("No instances.");
  }
  
  public static <T extends Adapter> InitialValueObservable<T> dataChanges(T paramT)
  {
    Preconditions.checkNotNull(paramT, "adapter == null");
    return new AdapterDataChangeObservable(paramT);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\RxAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */