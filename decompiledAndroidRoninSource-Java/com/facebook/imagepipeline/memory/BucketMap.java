package com.facebook.imagepipeline.memory;

import android.util.SparseArray;
import java.util.LinkedList;
import javax.annotation.Nullable;

public class BucketMap<T>
{
  @Nullable
  LinkedEntry<T> mHead;
  protected final SparseArray<LinkedEntry<T>> mMap = new SparseArray();
  @Nullable
  LinkedEntry<T> mTail;
  
  private void maybePrune(LinkedEntry<T> paramLinkedEntry)
  {
    if ((paramLinkedEntry != null) && (paramLinkedEntry.value.isEmpty()))
    {
      prune(paramLinkedEntry);
      this.mMap.remove(paramLinkedEntry.key);
    }
  }
  
  private void moveToFront(LinkedEntry<T> paramLinkedEntry)
  {
    if (this.mHead == paramLinkedEntry) {
      return;
    }
    prune(paramLinkedEntry);
    LinkedEntry localLinkedEntry = this.mHead;
    if (localLinkedEntry == null)
    {
      this.mHead = paramLinkedEntry;
      this.mTail = paramLinkedEntry;
      return;
    }
    paramLinkedEntry.next = localLinkedEntry;
    this.mHead.prev = paramLinkedEntry;
    this.mHead = paramLinkedEntry;
  }
  
  private void prune(LinkedEntry<T> paramLinkedEntry)
  {
    try
    {
      LinkedEntry localLinkedEntry1 = paramLinkedEntry.prev;
      LinkedEntry localLinkedEntry2 = paramLinkedEntry.next;
      if (localLinkedEntry1 != null) {
        localLinkedEntry1.next = localLinkedEntry2;
      }
      if (localLinkedEntry2 != null) {
        localLinkedEntry2.prev = localLinkedEntry1;
      }
      paramLinkedEntry.prev = null;
      paramLinkedEntry.next = null;
      if (paramLinkedEntry == this.mHead) {
        this.mHead = localLinkedEntry2;
      }
      if (paramLinkedEntry == this.mTail) {
        this.mTail = localLinkedEntry1;
      }
      return;
    }
    finally {}
  }
  
  @Nullable
  public T acquire(int paramInt)
  {
    try
    {
      LinkedEntry localLinkedEntry = (LinkedEntry)this.mMap.get(paramInt);
      if (localLinkedEntry == null) {
        return null;
      }
      Object localObject2 = localLinkedEntry.value.pollFirst();
      moveToFront(localLinkedEntry);
      return (T)localObject2;
    }
    finally {}
  }
  
  public void release(int paramInt, T paramT)
  {
    try
    {
      LinkedEntry localLinkedEntry2 = (LinkedEntry)this.mMap.get(paramInt);
      LinkedEntry localLinkedEntry1 = localLinkedEntry2;
      if (localLinkedEntry2 == null)
      {
        localLinkedEntry1 = new LinkedEntry(null, paramInt, new LinkedList(), null, null);
        this.mMap.put(paramInt, localLinkedEntry1);
      }
      localLinkedEntry1.value.addLast(paramT);
      moveToFront(localLinkedEntry1);
      return;
    }
    finally {}
  }
  
  @Nullable
  public T removeFromEnd()
  {
    try
    {
      LinkedEntry localLinkedEntry = this.mTail;
      if (localLinkedEntry == null) {
        return null;
      }
      Object localObject2 = localLinkedEntry.value.pollLast();
      maybePrune(localLinkedEntry);
      return (T)localObject2;
    }
    finally {}
  }
  
  int valueCount()
  {
    int i = 0;
    try
    {
      LinkedEntry localLinkedEntry = this.mHead;
      while (localLinkedEntry != null)
      {
        int j = i;
        if (localLinkedEntry.value != null) {
          j = i + localLinkedEntry.value.size();
        }
        localLinkedEntry = localLinkedEntry.next;
        i = j;
      }
      return i;
    }
    finally {}
  }
  
  static class LinkedEntry<I>
  {
    int key;
    @Nullable
    LinkedEntry<I> next;
    @Nullable
    LinkedEntry<I> prev;
    LinkedList<I> value;
    
    private LinkedEntry(@Nullable LinkedEntry<I> paramLinkedEntry1, int paramInt, LinkedList<I> paramLinkedList, @Nullable LinkedEntry<I> paramLinkedEntry2)
    {
      this.prev = paramLinkedEntry1;
      this.key = paramInt;
      this.value = paramLinkedList;
      this.next = paramLinkedEntry2;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("LinkedEntry(key: ");
      localStringBuilder.append(this.key);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\memory\BucketMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */