package com.facebook.imagepipeline.cache;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CountingMemoryCacheInspector<K, V>
{
  private final CountingMemoryCache<K, V> mCountingBitmapCache;
  
  public CountingMemoryCacheInspector(CountingMemoryCache<K, V> paramCountingMemoryCache)
  {
    this.mCountingBitmapCache = paramCountingMemoryCache;
  }
  
  public DumpInfo dumpCacheContent()
  {
    synchronized (this.mCountingBitmapCache)
    {
      DumpInfo localDumpInfo = new DumpInfo(this.mCountingBitmapCache.getSizeInBytes(), this.mCountingBitmapCache.getEvictionQueueSizeInBytes(), this.mCountingBitmapCache.mMemoryCacheParams);
      Iterator localIterator = this.mCountingBitmapCache.mCachedEntries.getMatchingEntries(null).iterator();
      Object localObject2;
      while (localIterator.hasNext())
      {
        localObject2 = (CountingMemoryCache.Entry)((Map.Entry)localIterator.next()).getValue();
        DumpInfoEntry localDumpInfoEntry = new DumpInfoEntry(((CountingMemoryCache.Entry)localObject2).key, ((CountingMemoryCache.Entry)localObject2).valueRef);
        if (((CountingMemoryCache.Entry)localObject2).clientCount > 0) {
          localDumpInfo.sharedEntries.add(localDumpInfoEntry);
        } else {
          localDumpInfo.lruEntries.add(localDumpInfoEntry);
        }
      }
      localIterator = this.mCountingBitmapCache.mOtherEntries.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (Map.Entry)localIterator.next();
        if ((localObject2 != null) && (!((Bitmap)((Map.Entry)localObject2).getKey()).isRecycled())) {
          localDumpInfo.otherEntries.put(((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
        }
      }
      return localDumpInfo;
    }
  }
  
  public static class DumpInfo<K, V>
  {
    public final List<CountingMemoryCacheInspector.DumpInfoEntry<K, V>> lruEntries;
    public final int lruSize;
    public final int maxEntriesCount;
    public final int maxEntrySize;
    public final int maxSize;
    public final Map<Bitmap, Object> otherEntries;
    public final List<CountingMemoryCacheInspector.DumpInfoEntry<K, V>> sharedEntries;
    public final int size;
    
    public DumpInfo(int paramInt1, int paramInt2, MemoryCacheParams paramMemoryCacheParams)
    {
      this.maxSize = paramMemoryCacheParams.maxCacheSize;
      this.maxEntriesCount = paramMemoryCacheParams.maxCacheEntries;
      this.maxEntrySize = paramMemoryCacheParams.maxCacheEntrySize;
      this.size = paramInt1;
      this.lruSize = paramInt2;
      this.lruEntries = new ArrayList();
      this.sharedEntries = new ArrayList();
      this.otherEntries = new HashMap();
    }
    
    public void release()
    {
      Iterator localIterator = this.lruEntries.iterator();
      while (localIterator.hasNext()) {
        ((CountingMemoryCacheInspector.DumpInfoEntry)localIterator.next()).release();
      }
      localIterator = this.sharedEntries.iterator();
      while (localIterator.hasNext()) {
        ((CountingMemoryCacheInspector.DumpInfoEntry)localIterator.next()).release();
      }
    }
  }
  
  public static class DumpInfoEntry<K, V>
  {
    public final K key;
    public final CloseableReference<V> value;
    
    public DumpInfoEntry(K paramK, CloseableReference<V> paramCloseableReference)
    {
      this.key = Preconditions.checkNotNull(paramK);
      this.value = CloseableReference.cloneOrNull(paramCloseableReference);
    }
    
    public void release()
    {
      CloseableReference.closeSafely(this.value);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\cache\CountingMemoryCacheInspector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */