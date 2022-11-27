package com.jakewharton.rxbinding2.widget;

import android.widget.AbsListView;

final class AutoValue_AbsListViewScrollEvent
  extends AbsListViewScrollEvent
{
  private final int firstVisibleItem;
  private final int scrollState;
  private final int totalItemCount;
  private final AbsListView view;
  private final int visibleItemCount;
  
  AutoValue_AbsListViewScrollEvent(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramAbsListView != null)
    {
      this.view = paramAbsListView;
      this.scrollState = paramInt1;
      this.firstVisibleItem = paramInt2;
      this.visibleItemCount = paramInt3;
      this.totalItemCount = paramInt4;
      return;
    }
    throw new NullPointerException("Null view");
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int firstVisibleItem()
  {
    return this.firstVisibleItem;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public int scrollState()
  {
    return this.scrollState;
  }
  
  public String toString()
  {
    return null;
  }
  
  public int totalItemCount()
  {
    return this.totalItemCount;
  }
  
  public AbsListView view()
  {
    return this.view;
  }
  
  public int visibleItemCount()
  {
    return this.visibleItemCount;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\widget\AutoValue_AbsListViewScrollEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */