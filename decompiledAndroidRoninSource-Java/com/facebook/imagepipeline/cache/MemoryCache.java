package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Predicate;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.references.CloseableReference;
import javax.annotation.Nullable;

public abstract interface MemoryCache<K, V>
{
  @Nullable
  public abstract CloseableReference<V> cache(K paramK, CloseableReference<V> paramCloseableReference);
  
  public abstract boolean contains(Predicate<K> paramPredicate);
  
  public abstract boolean contains(K paramK);
  
  @Nullable
  public abstract CloseableReference<V> get(K paramK);
  
  public abstract int getCount();
  
  public abstract int getSizeInBytes();
  
  public abstract void probe(K paramK);
  
  public abstract int removeAll(Predicate<K> paramPredicate);
  
  public static abstract interface CacheTrimStrategy
  {
    public abstract double getTrimRatio(MemoryTrimType paramMemoryTrimType);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\cache\MemoryCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */