package com.jakewharton.rxbinding2.widget;

import android.widget.AbsListView;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;

public final class RxAbsListView
{
  private RxAbsListView()
  {
    throw new AssertionError("No instances.");
  }
  
  public static Observable<AbsListViewScrollEvent> scrollEvents(AbsListView paramAbsListView)
  {
    Preconditions.checkNotNull(paramAbsListView, "absListView == null");
    return new AbsListViewScrollEventObservable(paramAbsListView);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\RxAbsListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */