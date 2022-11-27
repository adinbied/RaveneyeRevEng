package com.facebook.imagepipeline.memory;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

public abstract class LruBucketsPoolBackend<T>
  implements PoolBackend<T>
{
  private final Set<T> mCurrentItems = new HashSet();
  private final BucketMap<T> mMap = new BucketMap();
  
  private T maybeRemoveFromCurrentItems(@Nullable T paramT)
  {
    if (paramT != null) {
      try
      {
        this.mCurrentItems.remove(paramT);
        return paramT;
      }
      finally {}
    }
    return paramT;
  }
  
  @Nullable
  public T get(int paramInt)
  {
    return (T)maybeRemoveFromCurrentItems(this.mMap.acquire(paramInt));
  }
  
  @Nullable
  public T pop()
  {
    return (T)maybeRemoveFromCurrentItems(this.mMap.removeFromEnd());
  }
  
  public void put(T paramT)
  {
    try
    {
      boolean bool = this.mCurrentItems.add(paramT);
      if (bool) {
        this.mMap.release(getSize(paramT), paramT);
      }
      return;
    }
    finally {}
  }
  
  int valueCount()
  {
    return this.mMap.valueCount();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\memory\LruBucketsPoolBackend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */