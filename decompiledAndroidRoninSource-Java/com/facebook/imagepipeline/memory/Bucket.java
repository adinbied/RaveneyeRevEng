package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;

class Bucket<V>
{
  private static final String TAG = "BUCKET";
  private final boolean mFixBucketsReinitialization;
  final Queue mFreeList;
  private int mInUseLength;
  public final int mItemSize;
  public final int mMaxLength;
  
  public Bucket(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramInt1 > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkState(bool1);
    if (paramInt2 >= 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkState(bool1);
    if (paramInt3 >= 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    Preconditions.checkState(bool1);
    this.mItemSize = paramInt1;
    this.mMaxLength = paramInt2;
    this.mFreeList = new LinkedList();
    this.mInUseLength = paramInt3;
    this.mFixBucketsReinitialization = paramBoolean;
  }
  
  void addToFreeList(V paramV)
  {
    this.mFreeList.add(paramV);
  }
  
  public void decrementInUseCount()
  {
    boolean bool;
    if (this.mInUseLength > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool);
    this.mInUseLength -= 1;
  }
  
  @Deprecated
  @Nullable
  public V get()
  {
    Object localObject = pop();
    if (localObject != null) {
      this.mInUseLength += 1;
    }
    return (V)localObject;
  }
  
  int getFreeListSize()
  {
    return this.mFreeList.size();
  }
  
  public int getInUseCount()
  {
    return this.mInUseLength;
  }
  
  public void incrementInUseCount()
  {
    this.mInUseLength += 1;
  }
  
  public boolean isMaxLengthExceeded()
  {
    return this.mInUseLength + getFreeListSize() > this.mMaxLength;
  }
  
  @Nullable
  public V pop()
  {
    return (V)this.mFreeList.poll();
  }
  
  public void release(V paramV)
  {
    Preconditions.checkNotNull(paramV);
    boolean bool2 = this.mFixBucketsReinitialization;
    boolean bool1 = false;
    if (bool2)
    {
      if (this.mInUseLength > 0) {
        bool1 = true;
      }
      Preconditions.checkState(bool1);
      this.mInUseLength -= 1;
      addToFreeList(paramV);
      return;
    }
    int i = this.mInUseLength;
    if (i > 0)
    {
      this.mInUseLength = (i - 1);
      addToFreeList(paramV);
      return;
    }
    FLog.e("BUCKET", "Tried to release value %s from an empty bucket!", new Object[] { paramV });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\memory\Bucket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */