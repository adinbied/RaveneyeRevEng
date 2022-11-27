package com.jakewharton.rxbinding2.widget;

import android.widget.AbsListView;

public abstract class AbsListViewScrollEvent
{
  public static AbsListViewScrollEvent create(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return new AutoValue_AbsListViewScrollEvent(paramAbsListView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public abstract int firstVisibleItem();
  
  public abstract int scrollState();
  
  public abstract int totalItemCount();
  
  public abstract AbsListView view();
  
  public abstract int visibleItemCount();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\AbsListViewScrollEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */