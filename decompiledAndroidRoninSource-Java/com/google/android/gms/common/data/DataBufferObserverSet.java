package com.google.android.gms.common.data;

import java.util.HashSet;
import java.util.Iterator;

public final class DataBufferObserverSet
  implements DataBufferObserver, DataBufferObserver.Observable
{
  private HashSet<DataBufferObserver> zalm = new HashSet();
  
  public final void addObserver(DataBufferObserver paramDataBufferObserver)
  {
    this.zalm.add(paramDataBufferObserver);
  }
  
  public final void clear()
  {
    this.zalm.clear();
  }
  
  public final boolean hasObservers()
  {
    return !this.zalm.isEmpty();
  }
  
  public final void onDataChanged()
  {
    Iterator localIterator = this.zalm.iterator();
    while (localIterator.hasNext()) {
      ((DataBufferObserver)localIterator.next()).onDataChanged();
    }
  }
  
  public final void onDataRangeChanged(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.zalm.iterator();
    while (localIterator.hasNext()) {
      ((DataBufferObserver)localIterator.next()).onDataRangeChanged(paramInt1, paramInt2);
    }
  }
  
  public final void onDataRangeInserted(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.zalm.iterator();
    while (localIterator.hasNext()) {
      ((DataBufferObserver)localIterator.next()).onDataRangeInserted(paramInt1, paramInt2);
    }
  }
  
  public final void onDataRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    Iterator localIterator = this.zalm.iterator();
    while (localIterator.hasNext()) {
      ((DataBufferObserver)localIterator.next()).onDataRangeMoved(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public final void onDataRangeRemoved(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.zalm.iterator();
    while (localIterator.hasNext()) {
      ((DataBufferObserver)localIterator.next()).onDataRangeRemoved(paramInt1, paramInt2);
    }
  }
  
  public final void removeObserver(DataBufferObserver paramDataBufferObserver)
  {
    this.zalm.remove(paramDataBufferObserver);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\data\DataBufferObserverSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */