package com.facebook.imagepipeline.memory;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Sets;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.Pool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

public abstract class BasePool<V>
  implements Pool<V>
{
  private final Class<?> TAG = getClass();
  private boolean mAllowNewBuckets;
  final SparseArray<Bucket<V>> mBuckets;
  final Counter mFree;
  private boolean mIgnoreHardCap;
  final Set<V> mInUseValues;
  final MemoryTrimmableRegistry mMemoryTrimmableRegistry;
  final PoolParams mPoolParams;
  private final PoolStatsTracker mPoolStatsTracker;
  final Counter mUsed;
  
  public BasePool(MemoryTrimmableRegistry paramMemoryTrimmableRegistry, PoolParams paramPoolParams, PoolStatsTracker paramPoolStatsTracker)
  {
    this.mMemoryTrimmableRegistry = ((MemoryTrimmableRegistry)Preconditions.checkNotNull(paramMemoryTrimmableRegistry));
    this.mPoolParams = ((PoolParams)Preconditions.checkNotNull(paramPoolParams));
    this.mPoolStatsTracker = ((PoolStatsTracker)Preconditions.checkNotNull(paramPoolStatsTracker));
    this.mBuckets = new SparseArray();
    if (this.mPoolParams.fixBucketsReinitialization) {
      initBuckets();
    } else {
      legacyInitBuckets(new SparseIntArray(0));
    }
    this.mInUseValues = Sets.newIdentityHashSet();
    this.mFree = new Counter();
    this.mUsed = new Counter();
  }
  
  public BasePool(MemoryTrimmableRegistry paramMemoryTrimmableRegistry, PoolParams paramPoolParams, PoolStatsTracker paramPoolStatsTracker, boolean paramBoolean)
  {
    this(paramMemoryTrimmableRegistry, paramPoolParams, paramPoolStatsTracker);
    this.mIgnoreHardCap = paramBoolean;
  }
  
  private void ensurePoolSizeInvariant()
  {
    for (;;)
    {
      try
      {
        if (!isMaxSizeSoftCapExceeded()) {
          break label39;
        }
        if (this.mFree.mNumBytes != 0) {
          break label34;
        }
      }
      finally {}
      Preconditions.checkState(bool);
      return;
      label34:
      boolean bool = false;
      continue;
      label39:
      bool = true;
    }
  }
  
  private void fillBuckets(SparseIntArray paramSparseIntArray)
  {
    this.mBuckets.clear();
    int i = 0;
    while (i < paramSparseIntArray.size())
    {
      int j = paramSparseIntArray.keyAt(i);
      int k = paramSparseIntArray.valueAt(i);
      this.mBuckets.put(j, new Bucket(getSizeInBytes(j), k, 0, this.mPoolParams.fixBucketsReinitialization));
      i += 1;
    }
  }
  
  private Bucket<V> getBucketIfPresent(int paramInt)
  {
    try
    {
      Bucket localBucket = (Bucket)this.mBuckets.get(paramInt);
      return localBucket;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void initBuckets()
  {
    try
    {
      SparseIntArray localSparseIntArray = this.mPoolParams.bucketSizes;
      if (localSparseIntArray != null)
      {
        fillBuckets(localSparseIntArray);
        this.mAllowNewBuckets = false;
      }
      else
      {
        this.mAllowNewBuckets = true;
      }
      return;
    }
    finally {}
  }
  
  private void legacyInitBuckets(SparseIntArray paramSparseIntArray)
  {
    try
    {
      Preconditions.checkNotNull(paramSparseIntArray);
      this.mBuckets.clear();
      SparseIntArray localSparseIntArray = this.mPoolParams.bucketSizes;
      if (localSparseIntArray != null)
      {
        int i = 0;
        while (i < localSparseIntArray.size())
        {
          int j = localSparseIntArray.keyAt(i);
          int k = localSparseIntArray.valueAt(i);
          int m = paramSparseIntArray.get(j, 0);
          this.mBuckets.put(j, new Bucket(getSizeInBytes(j), k, m, this.mPoolParams.fixBucketsReinitialization));
          i += 1;
        }
        this.mAllowNewBuckets = false;
      }
      else
      {
        this.mAllowNewBuckets = true;
      }
      return;
    }
    finally {}
  }
  
  private void logStats()
  {
    if (FLog.isLoggable(2)) {
      FLog.v(this.TAG, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.mUsed.mCount), Integer.valueOf(this.mUsed.mNumBytes), Integer.valueOf(this.mFree.mCount), Integer.valueOf(this.mFree.mNumBytes));
    }
  }
  
  private List<Bucket<V>> refillBuckets()
  {
    ArrayList localArrayList = new ArrayList(this.mBuckets.size());
    int j = this.mBuckets.size();
    int i = 0;
    while (i < j)
    {
      Bucket localBucket = (Bucket)this.mBuckets.valueAt(i);
      int k = localBucket.mItemSize;
      int m = localBucket.mMaxLength;
      int n = localBucket.getInUseCount();
      if (localBucket.getFreeListSize() > 0) {
        localArrayList.add(localBucket);
      }
      this.mBuckets.setValueAt(i, new Bucket(getSizeInBytes(k), m, n, this.mPoolParams.fixBucketsReinitialization));
      i += 1;
    }
    return localArrayList;
  }
  
  protected abstract V alloc(int paramInt);
  
  boolean canAllocate(int paramInt)
  {
    try
    {
      boolean bool = this.mIgnoreHardCap;
      if (bool) {
        return true;
      }
      int i = this.mPoolParams.maxSizeHardCap;
      if (paramInt > i - this.mUsed.mNumBytes)
      {
        this.mPoolStatsTracker.onHardCapReached();
        return false;
      }
      int j = this.mPoolParams.maxSizeSoftCap;
      if (paramInt > j - (this.mUsed.mNumBytes + this.mFree.mNumBytes)) {
        trimToSize(j - paramInt);
      }
      if (paramInt > i - (this.mUsed.mNumBytes + this.mFree.mNumBytes))
      {
        this.mPoolStatsTracker.onHardCapReached();
        return false;
      }
      return true;
    }
    finally {}
  }
  
  protected abstract void free(V paramV);
  
  /* Error */
  public V get(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 240	com/facebook/imagepipeline/memory/BasePool:ensurePoolSizeInvariant	()V
    //   4: aload_0
    //   5: iload_1
    //   6: invokevirtual 243	com/facebook/imagepipeline/memory/BasePool:getBucketedSize	(I)I
    //   9: istore_1
    //   10: aload_0
    //   11: monitorenter
    //   12: aload_0
    //   13: iload_1
    //   14: invokevirtual 246	com/facebook/imagepipeline/memory/BasePool:getBucket	(I)Lcom/facebook/imagepipeline/memory/Bucket;
    //   17: astore_3
    //   18: aload_3
    //   19: ifnull +106 -> 125
    //   22: aload_0
    //   23: aload_3
    //   24: invokevirtual 250	com/facebook/imagepipeline/memory/BasePool:getValue	(Lcom/facebook/imagepipeline/memory/Bucket;)Ljava/lang/Object;
    //   27: astore 4
    //   29: aload 4
    //   31: ifnull +94 -> 125
    //   34: aload_0
    //   35: getfield 100	com/facebook/imagepipeline/memory/BasePool:mInUseValues	Ljava/util/Set;
    //   38: aload 4
    //   40: invokeinterface 253 2 0
    //   45: invokestatic 124	com/facebook/common/internal/Preconditions:checkState	(Z)V
    //   48: aload_0
    //   49: aload 4
    //   51: invokevirtual 257	com/facebook/imagepipeline/memory/BasePool:getBucketedSizeForValue	(Ljava/lang/Object;)I
    //   54: istore_1
    //   55: aload_0
    //   56: iload_1
    //   57: invokevirtual 144	com/facebook/imagepipeline/memory/BasePool:getSizeInBytes	(I)I
    //   60: istore_2
    //   61: aload_0
    //   62: getfield 105	com/facebook/imagepipeline/memory/BasePool:mUsed	Lcom/facebook/imagepipeline/memory/BasePool$Counter;
    //   65: iload_2
    //   66: invokevirtual 260	com/facebook/imagepipeline/memory/BasePool$Counter:increment	(I)V
    //   69: aload_0
    //   70: getfield 103	com/facebook/imagepipeline/memory/BasePool:mFree	Lcom/facebook/imagepipeline/memory/BasePool$Counter;
    //   73: iload_2
    //   74: invokevirtual 263	com/facebook/imagepipeline/memory/BasePool$Counter:decrement	(I)V
    //   77: aload_0
    //   78: getfield 72	com/facebook/imagepipeline/memory/BasePool:mPoolStatsTracker	Lcom/facebook/imagepipeline/memory/PoolStatsTracker;
    //   81: iload_2
    //   82: invokeinterface 266 2 0
    //   87: aload_0
    //   88: invokespecial 268	com/facebook/imagepipeline/memory/BasePool:logStats	()V
    //   91: iconst_2
    //   92: invokestatic 177	com/facebook/common/logging/FLog:isLoggable	(I)Z
    //   95: ifeq +25 -> 120
    //   98: aload_0
    //   99: getfield 54	com/facebook/imagepipeline/memory/BasePool:TAG	Ljava/lang/Class;
    //   102: ldc_w 270
    //   105: aload 4
    //   107: invokestatic 275	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   110: invokestatic 188	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   113: iload_1
    //   114: invokestatic 188	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   117: invokestatic 278	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   120: aload_0
    //   121: monitorexit
    //   122: aload 4
    //   124: areturn
    //   125: aload_0
    //   126: iload_1
    //   127: invokevirtual 144	com/facebook/imagepipeline/memory/BasePool:getSizeInBytes	(I)I
    //   130: istore_2
    //   131: aload_0
    //   132: iload_2
    //   133: invokevirtual 280	com/facebook/imagepipeline/memory/BasePool:canAllocate	(I)Z
    //   136: ifeq +147 -> 283
    //   139: aload_0
    //   140: getfield 105	com/facebook/imagepipeline/memory/BasePool:mUsed	Lcom/facebook/imagepipeline/memory/BasePool$Counter;
    //   143: iload_2
    //   144: invokevirtual 260	com/facebook/imagepipeline/memory/BasePool$Counter:increment	(I)V
    //   147: aload_3
    //   148: ifnull +7 -> 155
    //   151: aload_3
    //   152: invokevirtual 283	com/facebook/imagepipeline/memory/Bucket:incrementInUseCount	()V
    //   155: aload_0
    //   156: monitorexit
    //   157: aconst_null
    //   158: astore_3
    //   159: aload_0
    //   160: iload_1
    //   161: invokevirtual 285	com/facebook/imagepipeline/memory/BasePool:alloc	(I)Ljava/lang/Object;
    //   164: astore 4
    //   166: aload 4
    //   168: astore_3
    //   169: goto +39 -> 208
    //   172: astore 4
    //   174: aload_0
    //   175: monitorenter
    //   176: aload_0
    //   177: getfield 105	com/facebook/imagepipeline/memory/BasePool:mUsed	Lcom/facebook/imagepipeline/memory/BasePool$Counter;
    //   180: iload_2
    //   181: invokevirtual 263	com/facebook/imagepipeline/memory/BasePool$Counter:decrement	(I)V
    //   184: aload_0
    //   185: iload_1
    //   186: invokevirtual 246	com/facebook/imagepipeline/memory/BasePool:getBucket	(I)Lcom/facebook/imagepipeline/memory/Bucket;
    //   189: astore 5
    //   191: aload 5
    //   193: ifnull +8 -> 201
    //   196: aload 5
    //   198: invokevirtual 288	com/facebook/imagepipeline/memory/Bucket:decrementInUseCount	()V
    //   201: aload_0
    //   202: monitorexit
    //   203: aload 4
    //   205: invokestatic 294	com/facebook/common/internal/Throwables:propagateIfPossible	(Ljava/lang/Throwable;)V
    //   208: aload_0
    //   209: monitorenter
    //   210: aload_0
    //   211: getfield 100	com/facebook/imagepipeline/memory/BasePool:mInUseValues	Ljava/util/Set;
    //   214: aload_3
    //   215: invokeinterface 253 2 0
    //   220: invokestatic 124	com/facebook/common/internal/Preconditions:checkState	(Z)V
    //   223: aload_0
    //   224: invokevirtual 297	com/facebook/imagepipeline/memory/BasePool:trimToSoftCap	()V
    //   227: aload_0
    //   228: getfield 72	com/facebook/imagepipeline/memory/BasePool:mPoolStatsTracker	Lcom/facebook/imagepipeline/memory/PoolStatsTracker;
    //   231: iload_2
    //   232: invokeinterface 300 2 0
    //   237: aload_0
    //   238: invokespecial 268	com/facebook/imagepipeline/memory/BasePool:logStats	()V
    //   241: iconst_2
    //   242: invokestatic 177	com/facebook/common/logging/FLog:isLoggable	(I)Z
    //   245: ifeq +24 -> 269
    //   248: aload_0
    //   249: getfield 54	com/facebook/imagepipeline/memory/BasePool:TAG	Ljava/lang/Class;
    //   252: ldc_w 302
    //   255: aload_3
    //   256: invokestatic 275	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   259: invokestatic 188	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   262: iload_1
    //   263: invokestatic 188	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   266: invokestatic 278	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   269: aload_0
    //   270: monitorexit
    //   271: aload_3
    //   272: areturn
    //   273: astore_3
    //   274: aload_0
    //   275: monitorexit
    //   276: aload_3
    //   277: athrow
    //   278: astore_3
    //   279: aload_0
    //   280: monitorexit
    //   281: aload_3
    //   282: athrow
    //   283: new 18	com/facebook/imagepipeline/memory/BasePool$PoolSizeViolationException
    //   286: dup
    //   287: aload_0
    //   288: getfield 68	com/facebook/imagepipeline/memory/BasePool:mPoolParams	Lcom/facebook/imagepipeline/memory/PoolParams;
    //   291: getfield 227	com/facebook/imagepipeline/memory/PoolParams:maxSizeHardCap	I
    //   294: aload_0
    //   295: getfield 105	com/facebook/imagepipeline/memory/BasePool:mUsed	Lcom/facebook/imagepipeline/memory/BasePool$Counter;
    //   298: getfield 120	com/facebook/imagepipeline/memory/BasePool$Counter:mNumBytes	I
    //   301: aload_0
    //   302: getfield 103	com/facebook/imagepipeline/memory/BasePool:mFree	Lcom/facebook/imagepipeline/memory/BasePool$Counter;
    //   305: getfield 120	com/facebook/imagepipeline/memory/BasePool$Counter:mNumBytes	I
    //   308: iload_2
    //   309: invokespecial 305	com/facebook/imagepipeline/memory/BasePool$PoolSizeViolationException:<init>	(IIII)V
    //   312: athrow
    //   313: astore_3
    //   314: aload_0
    //   315: monitorexit
    //   316: aload_3
    //   317: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	this	BasePool
    //   0	318	1	paramInt	int
    //   60	249	2	i	int
    //   17	255	3	localObject1	Object
    //   273	4	3	localObject2	Object
    //   278	4	3	localObject3	Object
    //   313	4	3	localObject4	Object
    //   27	140	4	localObject5	Object
    //   172	32	4	localThrowable	Throwable
    //   189	8	5	localBucket	Bucket
    // Exception table:
    //   from	to	target	type
    //   159	166	172	finally
    //   210	269	273	finally
    //   269	271	273	finally
    //   274	276	273	finally
    //   176	191	278	finally
    //   196	201	278	finally
    //   201	203	278	finally
    //   279	281	278	finally
    //   12	18	313	finally
    //   22	29	313	finally
    //   34	120	313	finally
    //   120	122	313	finally
    //   125	147	313	finally
    //   151	155	313	finally
    //   155	157	313	finally
    //   283	313	313	finally
    //   314	316	313	finally
  }
  
  Bucket<V> getBucket(int paramInt)
  {
    try
    {
      Bucket localBucket = (Bucket)this.mBuckets.get(paramInt);
      if ((localBucket == null) && (this.mAllowNewBuckets))
      {
        if (FLog.isLoggable(2)) {
          FLog.v(this.TAG, "creating new bucket %s", Integer.valueOf(paramInt));
        }
        localBucket = newBucket(paramInt);
        this.mBuckets.put(paramInt, localBucket);
        return localBucket;
      }
      return localBucket;
    }
    finally {}
  }
  
  protected abstract int getBucketedSize(int paramInt);
  
  protected abstract int getBucketedSizeForValue(V paramV);
  
  protected abstract int getSizeInBytes(int paramInt);
  
  public Map<String, Integer> getStats()
  {
    try
    {
      HashMap localHashMap = new HashMap();
      int i = 0;
      while (i < this.mBuckets.size())
      {
        int j = this.mBuckets.keyAt(i);
        Bucket localBucket = (Bucket)this.mBuckets.valueAt(i);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("buckets_used_");
        localStringBuilder.append(getSizeInBytes(j));
        localHashMap.put(localStringBuilder.toString(), Integer.valueOf(localBucket.getInUseCount()));
        i += 1;
      }
      localHashMap.put("soft_cap", Integer.valueOf(this.mPoolParams.maxSizeSoftCap));
      localHashMap.put("hard_cap", Integer.valueOf(this.mPoolParams.maxSizeHardCap));
      localHashMap.put("used_count", Integer.valueOf(this.mUsed.mCount));
      localHashMap.put("used_bytes", Integer.valueOf(this.mUsed.mNumBytes));
      localHashMap.put("free_count", Integer.valueOf(this.mFree.mCount));
      localHashMap.put("free_bytes", Integer.valueOf(this.mFree.mNumBytes));
      return localHashMap;
    }
    finally {}
  }
  
  @Nullable
  protected V getValue(Bucket<V> paramBucket)
  {
    try
    {
      paramBucket = paramBucket.get();
      return paramBucket;
    }
    finally
    {
      paramBucket = finally;
      throw paramBucket;
    }
  }
  
  protected void initialize()
  {
    this.mMemoryTrimmableRegistry.registerMemoryTrimmable(this);
    this.mPoolStatsTracker.setBasePool(this);
  }
  
  boolean isMaxSizeSoftCapExceeded()
  {
    for (;;)
    {
      try
      {
        if (this.mUsed.mNumBytes + this.mFree.mNumBytes > this.mPoolParams.maxSizeSoftCap)
        {
          bool = true;
          if (bool) {
            this.mPoolStatsTracker.onSoftCapReached();
          }
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  protected boolean isReusable(V paramV)
  {
    Preconditions.checkNotNull(paramV);
    return true;
  }
  
  Bucket<V> newBucket(int paramInt)
  {
    return new Bucket(getSizeInBytes(paramInt), Integer.MAX_VALUE, 0, this.mPoolParams.fixBucketsReinitialization);
  }
  
  protected void onParamsChanged() {}
  
  public void release(V paramV)
  {
    Preconditions.checkNotNull(paramV);
    int i = getBucketedSizeForValue(paramV);
    int j = getSizeInBytes(i);
    try
    {
      Bucket localBucket = getBucketIfPresent(i);
      if (!this.mInUseValues.remove(paramV))
      {
        FLog.e(this.TAG, "release (free, value unrecognized) (object, size) = (%x, %s)", new Object[] { Integer.valueOf(System.identityHashCode(paramV)), Integer.valueOf(i) });
        free(paramV);
        this.mPoolStatsTracker.onFree(j);
      }
      else if ((localBucket != null) && (!localBucket.isMaxLengthExceeded()) && (!isMaxSizeSoftCapExceeded()) && (isReusable(paramV)))
      {
        localBucket.release(paramV);
        this.mFree.increment(j);
        this.mUsed.decrement(j);
        this.mPoolStatsTracker.onValueRelease(j);
        if (FLog.isLoggable(2)) {
          FLog.v(this.TAG, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(paramV)), Integer.valueOf(i));
        }
      }
      else
      {
        if (localBucket != null) {
          localBucket.decrementInUseCount();
        }
        if (FLog.isLoggable(2)) {
          FLog.v(this.TAG, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(paramV)), Integer.valueOf(i));
        }
        free(paramV);
        this.mUsed.decrement(j);
        this.mPoolStatsTracker.onFree(j);
      }
      logStats();
      return;
    }
    finally {}
  }
  
  public void trim(MemoryTrimType paramMemoryTrimType)
  {
    trimToNothing();
  }
  
  void trimToNothing()
  {
    try
    {
      boolean bool = this.mPoolParams.fixBucketsReinitialization;
      int j = 0;
      Object localObject1;
      Object localObject3;
      Object localObject4;
      if (bool)
      {
        localObject1 = refillBuckets();
      }
      else
      {
        localObject1 = new ArrayList(this.mBuckets.size());
        localObject3 = new SparseIntArray();
        i = 0;
        while (i < this.mBuckets.size())
        {
          localObject4 = (Bucket)this.mBuckets.valueAt(i);
          if (((Bucket)localObject4).getFreeListSize() > 0) {
            ((List)localObject1).add(localObject4);
          }
          ((SparseIntArray)localObject3).put(this.mBuckets.keyAt(i), ((Bucket)localObject4).getInUseCount());
          i += 1;
        }
        legacyInitBuckets((SparseIntArray)localObject3);
      }
      this.mFree.reset();
      logStats();
      onParamsChanged();
      int i = j;
      if (i < ((List)localObject1).size())
      {
        localObject3 = (Bucket)((List)localObject1).get(i);
        for (;;)
        {
          localObject4 = ((Bucket)localObject3).pop();
          if (localObject4 == null)
          {
            i += 1;
            break;
          }
          free(localObject4);
        }
      }
      return;
    }
    finally {}
  }
  
  void trimToSize(int paramInt)
  {
    for (;;)
    {
      int i;
      try
      {
        int j = Math.min(this.mUsed.mNumBytes + this.mFree.mNumBytes - paramInt, this.mFree.mNumBytes);
        if (j <= 0) {
          return;
        }
        if (FLog.isLoggable(2)) {
          FLog.v(this.TAG, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(paramInt), Integer.valueOf(this.mUsed.mNumBytes + this.mFree.mNumBytes), Integer.valueOf(j));
        }
        logStats();
        i = 0;
        if ((i < this.mBuckets.size()) && (j > 0))
        {
          Bucket localBucket = (Bucket)this.mBuckets.valueAt(i);
          if (j > 0)
          {
            Object localObject2 = localBucket.pop();
            if (localObject2 != null)
            {
              free(localObject2);
              j -= localBucket.mItemSize;
              this.mFree.decrement(localBucket.mItemSize);
              continue;
            }
          }
        }
        else
        {
          logStats();
          if (FLog.isLoggable(2)) {
            FLog.v(this.TAG, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(paramInt), Integer.valueOf(this.mUsed.mNumBytes + this.mFree.mNumBytes));
          }
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  void trimToSoftCap()
  {
    try
    {
      if (isMaxSizeSoftCapExceeded()) {
        trimToSize(this.mPoolParams.maxSizeSoftCap);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  static class Counter
  {
    private static final String TAG = "com.facebook.imagepipeline.memory.BasePool.Counter";
    int mCount;
    int mNumBytes;
    
    public void decrement(int paramInt)
    {
      int i = this.mNumBytes;
      if (i >= paramInt)
      {
        int j = this.mCount;
        if (j > 0)
        {
          this.mCount = (j - 1);
          this.mNumBytes = (i - paramInt);
          return;
        }
      }
      FLog.wtf("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mNumBytes), Integer.valueOf(this.mCount) });
    }
    
    public void increment(int paramInt)
    {
      this.mCount += 1;
      this.mNumBytes += paramInt;
    }
    
    public void reset()
    {
      this.mCount = 0;
      this.mNumBytes = 0;
    }
  }
  
  public static class InvalidSizeException
    extends RuntimeException
  {
    public InvalidSizeException(Object paramObject)
    {
      super();
    }
  }
  
  public static class InvalidValueException
    extends RuntimeException
  {
    public InvalidValueException(Object paramObject)
    {
      super();
    }
  }
  
  public static class PoolSizeViolationException
    extends RuntimeException
  {
    public PoolSizeViolationException(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super();
    }
  }
  
  public static class SizeTooLargeException
    extends BasePool.InvalidSizeException
  {
    public SizeTooLargeException(Object paramObject)
    {
      super();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\memory\BasePool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */