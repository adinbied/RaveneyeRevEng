package com.jakewharton.rxbinding2.view;

import android.view.ViewGroup;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;

public final class RxViewGroup
{
  private RxViewGroup()
  {
    throw new AssertionError("No instances.");
  }
  
  public static Observable<ViewGroupHierarchyChangeEvent> changeEvents(ViewGroup paramViewGroup)
  {
    Preconditions.checkNotNull(paramViewGroup, "viewGroup == null");
    return new ViewGroupHierarchyChangeEventObservable(paramViewGroup);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\view\RxViewGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */