package com.facebook.imagepipeline.cache;

import android.graphics.Bitmap;
import android.os.SystemClock;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.Nullable;

public class CountingMemoryCache<K, V>
  implements MemoryCache<K, V>, MemoryTrimmable
{
  private final MemoryCache.CacheTrimStrategy mCacheTrimStrategy;
  final CountingLruMap<K, Entry<K, V>> mCachedEntries;
  @Nullable
  private final EntryStateObserver<K> mEntryStateObserver;
  final CountingLruMap<K, Entry<K, V>> mExclusiveEntries;
  private long mLastCacheParamsCheck;
  protected MemoryCacheParams mMemoryCacheParams;
  private final Supplier<MemoryCacheParams> mMemoryCacheParamsSupplier;
  final Map<Bitmap, Object> mOtherEntries = new WeakHashMap();
  private final ValueDescriptor<V> mValueDescriptor;
  
  public CountingMemoryCache(ValueDescriptor<V> paramValueDescriptor, MemoryCache.CacheTrimStrategy paramCacheTrimStrategy, Supplier<MemoryCacheParams> paramSupplier, @Nullable EntryStateObserver<K> paramEntryStateObserver)
  {
    this.mValueDescriptor = paramValueDescriptor;
    this.mExclusiveEntries = new CountingLruMap(wrapValueDescriptor(paramValueDescriptor));
    this.mCachedEntries = new CountingLruMap(wrapValueDescriptor(paramValueDescriptor));
    this.mCacheTrimStrategy = paramCacheTrimStrategy;
    this.mMemoryCacheParamsSupplier = paramSupplier;
    this.mMemoryCacheParams = ((MemoryCacheParams)paramSupplier.get());
    this.mLastCacheParamsCheck = SystemClock.uptimeMillis();
    this.mEntryStateObserver = paramEntryStateObserver;
  }
  
  private boolean canCacheNewValue(V paramV)
  {
    try
    {
      int i = this.mValueDescriptor.getSizeInBytes(paramV);
      int j = this.mMemoryCacheParams.maxCacheEntrySize;
      boolean bool = true;
      if ((i <= j) && (getInUseCount() <= this.mMemoryCacheParams.maxCacheEntries - 1))
      {
        j = getInUseSizeInBytes();
        int k = this.mMemoryCacheParams.maxCacheSize;
        if (j <= k - i) {}
      }
      else
      {
        bool = false;
      }
      return bool;
    }
    finally {}
  }
  
  private void decreaseClientCount(Entry<K, V> paramEntry)
  {
    for (;;)
    {
      try
      {
        Preconditions.checkNotNull(paramEntry);
        if (paramEntry.clientCount > 0)
        {
          bool = true;
          Preconditions.checkState(bool);
          paramEntry.clientCount -= 1;
          return;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  private void increaseClientCount(Entry<K, V> paramEntry)
  {
    for (;;)
    {
      try
      {
        Preconditions.checkNotNull(paramEntry);
        if (!paramEntry.isOrphan)
        {
          bool = true;
          Preconditions.checkState(bool);
          paramEntry.clientCount += 1;
          return;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  private void makeOrphan(Entry<K, V> paramEntry)
  {
    for (;;)
    {
      try
      {
        Preconditions.checkNotNull(paramEntry);
        if (!paramEntry.isOrphan)
        {
          bool = true;
          Preconditions.checkState(bool);
          paramEntry.isOrphan = true;
          return;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  private void makeOrphans(@Nullable ArrayList<Entry<K, V>> paramArrayList)
  {
    if (paramArrayList != null) {
      try
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          makeOrphan((Entry)paramArrayList.next());
        }
      }
      finally {}
    }
  }
  
  private boolean maybeAddToExclusives(Entry<K, V> paramEntry)
  {
    try
    {
      if ((!paramEntry.isOrphan) && (paramEntry.clientCount == 0))
      {
        this.mExclusiveEntries.put(paramEntry.key, paramEntry);
        return true;
      }
      return false;
    }
    finally
    {
      paramEntry = finally;
      throw paramEntry;
    }
  }
  
  private void maybeClose(@Nullable ArrayList<Entry<K, V>> paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        CloseableReference.closeSafely(referenceToClose((Entry)paramArrayList.next()));
      }
    }
  }
  
  private void maybeEvictEntries()
  {
    try
    {
      ArrayList localArrayList = trimExclusivelyOwnedEntries(Math.min(this.mMemoryCacheParams.maxEvictionQueueEntries, this.mMemoryCacheParams.maxCacheEntries - getInUseCount()), Math.min(this.mMemoryCacheParams.maxEvictionQueueSize, this.mMemoryCacheParams.maxCacheSize - getInUseSizeInBytes()));
      makeOrphans(localArrayList);
      maybeClose(localArrayList);
      maybeNotifyExclusiveEntryRemoval(localArrayList);
      return;
    }
    finally {}
  }
  
  private static <K, V> void maybeNotifyExclusiveEntryInsertion(@Nullable Entry<K, V> paramEntry)
  {
    if ((paramEntry != null) && (paramEntry.observer != null)) {
      paramEntry.observer.onExclusivityChanged(paramEntry.key, true);
    }
  }
  
  private static <K, V> void maybeNotifyExclusiveEntryRemoval(@Nullable Entry<K, V> paramEntry)
  {
    if ((paramEntry != null) && (paramEntry.observer != null)) {
      paramEntry.observer.onExclusivityChanged(paramEntry.key, false);
    }
  }
  
  private void maybeNotifyExclusiveEntryRemoval(@Nullable ArrayList<Entry<K, V>> paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        maybeNotifyExclusiveEntryRemoval((Entry)paramArrayList.next());
      }
    }
  }
  
  private void maybeUpdateCacheParams()
  {
    try
    {
      long l1 = this.mLastCacheParamsCheck;
      long l2 = this.mMemoryCacheParams.paramsCheckIntervalMs;
      long l3 = SystemClock.uptimeMillis();
      if (l1 + l2 > l3) {
        return;
      }
      this.mLastCacheParamsCheck = SystemClock.uptimeMillis();
      this.mMemoryCacheParams = ((MemoryCacheParams)this.mMemoryCacheParamsSupplier.get());
      return;
    }
    finally {}
  }
  
  private CloseableReference<V> newClientReference(final Entry<K, V> paramEntry)
  {
    try
    {
      increaseClientCount(paramEntry);
      paramEntry = CloseableReference.of(paramEntry.valueRef.get(), new ResourceReleaser()
      {
        public void release(V paramAnonymousV)
        {
          CountingMemoryCache.this.releaseClientReference(paramEntry);
        }
      });
      return paramEntry;
    }
    finally
    {
      paramEntry = finally;
      throw paramEntry;
    }
  }
  
  @Nullable
  private CloseableReference<V> referenceToClose(Entry<K, V> paramEntry)
  {
    try
    {
      Preconditions.checkNotNull(paramEntry);
      if ((paramEntry.isOrphan) && (paramEntry.clientCount == 0)) {
        paramEntry = paramEntry.valueRef;
      } else {
        paramEntry = null;
      }
      return paramEntry;
    }
    finally
    {
      paramEntry = finally;
      throw paramEntry;
    }
  }
  
  private void releaseClientReference(Entry<K, V> paramEntry)
  {
    Preconditions.checkNotNull(paramEntry);
    try
    {
      decreaseClientCount(paramEntry);
      boolean bool = maybeAddToExclusives(paramEntry);
      CloseableReference localCloseableReference = referenceToClose(paramEntry);
      CloseableReference.closeSafely(localCloseableReference);
      if (!bool) {
        paramEntry = null;
      }
      maybeNotifyExclusiveEntryInsertion(paramEntry);
      maybeUpdateCacheParams();
      maybeEvictEntries();
      return;
    }
    finally {}
  }
  
  /* Error */
  @Nullable
  private ArrayList<Entry<K, V>> trimExclusivelyOwnedEntries(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: iconst_0
    //   4: invokestatic 258	java/lang/Math:max	(II)I
    //   7: istore_1
    //   8: iload_2
    //   9: iconst_0
    //   10: invokestatic 258	java/lang/Math:max	(II)I
    //   13: istore_2
    //   14: aload_0
    //   15: getfield 65	com/facebook/imagepipeline/cache/CountingMemoryCache:mExclusiveEntries	Lcom/facebook/imagepipeline/cache/CountingLruMap;
    //   18: invokevirtual 261	com/facebook/imagepipeline/cache/CountingLruMap:getCount	()I
    //   21: iload_1
    //   22: if_icmpgt +20 -> 42
    //   25: aload_0
    //   26: getfield 65	com/facebook/imagepipeline/cache/CountingMemoryCache:mExclusiveEntries	Lcom/facebook/imagepipeline/cache/CountingLruMap;
    //   29: invokevirtual 263	com/facebook/imagepipeline/cache/CountingLruMap:getSizeInBytes	()I
    //   32: istore_3
    //   33: iload_3
    //   34: iload_2
    //   35: if_icmpgt +7 -> 42
    //   38: aload_0
    //   39: monitorexit
    //   40: aconst_null
    //   41: areturn
    //   42: new 152	java/util/ArrayList
    //   45: dup
    //   46: invokespecial 264	java/util/ArrayList:<init>	()V
    //   49: astore 4
    //   51: aload_0
    //   52: getfield 65	com/facebook/imagepipeline/cache/CountingMemoryCache:mExclusiveEntries	Lcom/facebook/imagepipeline/cache/CountingLruMap;
    //   55: invokevirtual 261	com/facebook/imagepipeline/cache/CountingLruMap:getCount	()I
    //   58: iload_1
    //   59: if_icmpgt +24 -> 83
    //   62: aload_0
    //   63: getfield 65	com/facebook/imagepipeline/cache/CountingMemoryCache:mExclusiveEntries	Lcom/facebook/imagepipeline/cache/CountingLruMap;
    //   66: invokevirtual 263	com/facebook/imagepipeline/cache/CountingLruMap:getSizeInBytes	()I
    //   69: istore_3
    //   70: iload_3
    //   71: iload_2
    //   72: if_icmple +6 -> 78
    //   75: goto +8 -> 83
    //   78: aload_0
    //   79: monitorexit
    //   80: aload 4
    //   82: areturn
    //   83: aload_0
    //   84: getfield 65	com/facebook/imagepipeline/cache/CountingMemoryCache:mExclusiveEntries	Lcom/facebook/imagepipeline/cache/CountingLruMap;
    //   87: invokevirtual 267	com/facebook/imagepipeline/cache/CountingLruMap:getFirstKey	()Ljava/lang/Object;
    //   90: astore 5
    //   92: aload_0
    //   93: getfield 65	com/facebook/imagepipeline/cache/CountingMemoryCache:mExclusiveEntries	Lcom/facebook/imagepipeline/cache/CountingLruMap;
    //   96: aload 5
    //   98: invokevirtual 270	com/facebook/imagepipeline/cache/CountingLruMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   101: pop
    //   102: aload 4
    //   104: aload_0
    //   105: getfield 67	com/facebook/imagepipeline/cache/CountingMemoryCache:mCachedEntries	Lcom/facebook/imagepipeline/cache/CountingLruMap;
    //   108: aload 5
    //   110: invokevirtual 270	com/facebook/imagepipeline/cache/CountingLruMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   113: invokevirtual 273	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   116: pop
    //   117: goto -66 -> 51
    //   120: astore 4
    //   122: aload_0
    //   123: monitorexit
    //   124: aload 4
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	CountingMemoryCache
    //   0	127	1	paramInt1	int
    //   0	127	2	paramInt2	int
    //   32	41	3	i	int
    //   49	54	4	localArrayList	ArrayList
    //   120	5	4	localObject1	Object
    //   90	19	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	33	120	finally
    //   42	51	120	finally
    //   51	70	120	finally
    //   83	117	120	finally
  }
  
  private ValueDescriptor<Entry<K, V>> wrapValueDescriptor(final ValueDescriptor<V> paramValueDescriptor)
  {
    new ValueDescriptor()
    {
      public int getSizeInBytes(CountingMemoryCache.Entry<K, V> paramAnonymousEntry)
      {
        return paramValueDescriptor.getSizeInBytes(paramAnonymousEntry.valueRef.get());
      }
    };
  }
  
  public CloseableReference<V> cache(K paramK, CloseableReference<V> paramCloseableReference)
  {
    return cache(paramK, paramCloseableReference, this.mEntryStateObserver);
  }
  
  @Nullable
  public CloseableReference<V> cache(K paramK, CloseableReference<V> paramCloseableReference, EntryStateObserver<K> paramEntryStateObserver)
  {
    Preconditions.checkNotNull(paramK);
    Preconditions.checkNotNull(paramCloseableReference);
    maybeUpdateCacheParams();
    for (;;)
    {
      try
      {
        Entry localEntry = (Entry)this.mExclusiveEntries.remove(paramK);
        localObject = (Entry)this.mCachedEntries.remove(paramK);
        CloseableReference localCloseableReference = null;
        if (localObject != null)
        {
          makeOrphan((Entry)localObject);
          localObject = referenceToClose((Entry)localObject);
          if (canCacheNewValue(paramCloseableReference.get()))
          {
            paramCloseableReference = Entry.of(paramK, paramCloseableReference, paramEntryStateObserver);
            this.mCachedEntries.put(paramK, paramCloseableReference);
            localCloseableReference = newClientReference(paramCloseableReference);
          }
          CloseableReference.closeSafely((CloseableReference)localObject);
          maybeNotifyExclusiveEntryRemoval(localEntry);
          maybeEvictEntries();
          return localCloseableReference;
        }
      }
      finally {}
      Object localObject = null;
    }
  }
  
  public void clear()
  {
    try
    {
      ArrayList localArrayList1 = this.mExclusiveEntries.clear();
      ArrayList localArrayList2 = this.mCachedEntries.clear();
      makeOrphans(localArrayList2);
      maybeClose(localArrayList2);
      maybeNotifyExclusiveEntryRemoval(localArrayList1);
      maybeUpdateCacheParams();
      return;
    }
    finally {}
  }
  
  public boolean contains(Predicate<K> paramPredicate)
  {
    try
    {
      boolean bool = this.mCachedEntries.getMatchingEntries(paramPredicate).isEmpty();
      return bool ^ true;
    }
    finally
    {
      paramPredicate = finally;
      throw paramPredicate;
    }
  }
  
  public boolean contains(K paramK)
  {
    try
    {
      boolean bool = this.mCachedEntries.contains(paramK);
      return bool;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  @Nullable
  public CloseableReference<V> get(K paramK)
  {
    Preconditions.checkNotNull(paramK);
    for (;;)
    {
      try
      {
        Entry localEntry = (Entry)this.mExclusiveEntries.remove(paramK);
        paramK = (Entry)this.mCachedEntries.get(paramK);
        if (paramK != null)
        {
          paramK = newClientReference(paramK);
          maybeNotifyExclusiveEntryRemoval(localEntry);
          maybeUpdateCacheParams();
          maybeEvictEntries();
          return paramK;
        }
      }
      finally {}
      paramK = null;
    }
  }
  
  public int getCount()
  {
    try
    {
      int i = this.mCachedEntries.getCount();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getEvictionQueueCount()
  {
    try
    {
      int i = this.mExclusiveEntries.getCount();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getEvictionQueueSizeInBytes()
  {
    try
    {
      int i = this.mExclusiveEntries.getSizeInBytes();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getInUseCount()
  {
    try
    {
      int i = this.mCachedEntries.getCount();
      int j = this.mExclusiveEntries.getCount();
      return i - j;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getInUseSizeInBytes()
  {
    try
    {
      int i = this.mCachedEntries.getSizeInBytes();
      int j = this.mExclusiveEntries.getSizeInBytes();
      return i - j;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public MemoryCacheParams getMemoryCacheParams()
  {
    return this.mMemoryCacheParams;
  }
  
  public int getSizeInBytes()
  {
    try
    {
      int i = this.mCachedEntries.getSizeInBytes();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void probe(K paramK)
  {
    Preconditions.checkNotNull(paramK);
    try
    {
      Entry localEntry = (Entry)this.mExclusiveEntries.remove(paramK);
      if (localEntry != null) {
        this.mExclusiveEntries.put(paramK, localEntry);
      }
      return;
    }
    finally {}
  }
  
  public int removeAll(Predicate<K> paramPredicate)
  {
    try
    {
      ArrayList localArrayList = this.mExclusiveEntries.removeAll(paramPredicate);
      paramPredicate = this.mCachedEntries.removeAll(paramPredicate);
      makeOrphans(paramPredicate);
      maybeClose(paramPredicate);
      maybeNotifyExclusiveEntryRemoval(localArrayList);
      maybeUpdateCacheParams();
      maybeEvictEntries();
      return paramPredicate.size();
    }
    finally {}
  }
  
  public String reportData()
  {
    return Objects.toStringHelper("CountingMemoryCache").add("cached_entries_count:", this.mCachedEntries.getCount()).add("cached_entries_size_bytes", this.mCachedEntries.getSizeInBytes()).add("exclusive_entries_count", this.mExclusiveEntries.getCount()).add("exclusive_entries_size_bytes", this.mExclusiveEntries.getSizeInBytes()).toString();
  }
  
  @Nullable
  public CloseableReference<V> reuse(K paramK)
  {
    Preconditions.checkNotNull(paramK);
    for (;;)
    {
      try
      {
        Entry localEntry = (Entry)this.mExclusiveEntries.remove(paramK);
        i = 1;
        boolean bool = false;
        if (localEntry != null)
        {
          paramK = (Entry)this.mCachedEntries.remove(paramK);
          Preconditions.checkNotNull(paramK);
          if (paramK.clientCount == 0) {
            bool = true;
          }
          Preconditions.checkState(bool);
          paramK = paramK.valueRef;
          if (i != 0) {
            maybeNotifyExclusiveEntryRemoval(localEntry);
          }
          return paramK;
        }
      }
      finally {}
      paramK = null;
      int i = 0;
    }
  }
  
  public void trim(MemoryTrimType paramMemoryTrimType)
  {
    double d = this.mCacheTrimStrategy.getTrimRatio(paramMemoryTrimType);
    try
    {
      paramMemoryTrimType = trimExclusivelyOwnedEntries(Integer.MAX_VALUE, Math.max(0, (int)(this.mCachedEntries.getSizeInBytes() * (1.0D - d)) - getInUseSizeInBytes()));
      makeOrphans(paramMemoryTrimType);
      maybeClose(paramMemoryTrimType);
      maybeNotifyExclusiveEntryRemoval(paramMemoryTrimType);
      maybeUpdateCacheParams();
      maybeEvictEntries();
      return;
    }
    finally {}
  }
  
  static class Entry<K, V>
  {
    public int clientCount;
    public boolean isOrphan;
    public final K key;
    @Nullable
    public final CountingMemoryCache.EntryStateObserver<K> observer;
    public final CloseableReference<V> valueRef;
    
    private Entry(K paramK, CloseableReference<V> paramCloseableReference, @Nullable CountingMemoryCache.EntryStateObserver<K> paramEntryStateObserver)
    {
      this.key = Preconditions.checkNotNull(paramK);
      this.valueRef = ((CloseableReference)Preconditions.checkNotNull(CloseableReference.cloneOrNull(paramCloseableReference)));
      this.clientCount = 0;
      this.isOrphan = false;
      this.observer = paramEntryStateObserver;
    }
    
    static <K, V> Entry<K, V> of(K paramK, CloseableReference<V> paramCloseableReference, @Nullable CountingMemoryCache.EntryStateObserver<K> paramEntryStateObserver)
    {
      return new Entry(paramK, paramCloseableReference, paramEntryStateObserver);
    }
  }
  
  public static abstract interface EntryStateObserver<K>
  {
    public abstract void onExclusivityChanged(K paramK, boolean paramBoolean);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\cache\CountingMemoryCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */