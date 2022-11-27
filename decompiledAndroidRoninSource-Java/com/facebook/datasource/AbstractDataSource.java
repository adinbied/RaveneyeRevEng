package com.facebook.datasource;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public abstract class AbstractDataSource<T>
  implements DataSource<T>
{
  @Nullable
  private static volatile DataSourceInstrumenter sDataSourceInstrumenter;
  private DataSourceStatus mDataSourceStatus = DataSourceStatus.IN_PROGRESS;
  @Nullable
  private Map<String, Object> mExtras;
  private Throwable mFailureThrowable = null;
  private boolean mIsClosed = false;
  private float mProgress = 0.0F;
  @Nullable
  private T mResult = null;
  private final ConcurrentLinkedQueue<Pair<DataSubscriber<T>, Executor>> mSubscribers = new ConcurrentLinkedQueue();
  
  @Nullable
  public static DataSourceInstrumenter getDataSourceInstrumenter()
  {
    return sDataSourceInstrumenter;
  }
  
  private void notifyDataSubscribers()
  {
    boolean bool1 = hasFailed();
    boolean bool2 = wasCancelled();
    Iterator localIterator = this.mSubscribers.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      notifyDataSubscriber((DataSubscriber)localPair.first, (Executor)localPair.second, bool1, bool2);
    }
  }
  
  public static void provideInstrumenter(@Nullable DataSourceInstrumenter paramDataSourceInstrumenter)
  {
    sDataSourceInstrumenter = paramDataSourceInstrumenter;
  }
  
  private boolean setFailureInternal(Throwable paramThrowable, @Nullable Map<String, Object> paramMap)
  {
    try
    {
      if ((!this.mIsClosed) && (this.mDataSourceStatus == DataSourceStatus.IN_PROGRESS))
      {
        this.mDataSourceStatus = DataSourceStatus.FAILURE;
        this.mFailureThrowable = paramThrowable;
        this.mExtras = paramMap;
        return true;
      }
      return false;
    }
    finally {}
  }
  
  private boolean setProgressInternal(float paramFloat)
  {
    try
    {
      if ((!this.mIsClosed) && (this.mDataSourceStatus == DataSourceStatus.IN_PROGRESS))
      {
        float f = this.mProgress;
        if (paramFloat < f) {
          return false;
        }
        this.mProgress = paramFloat;
        return true;
      }
      return false;
    }
    finally {}
  }
  
  /* Error */
  private boolean setResultInternal(@Nullable T paramT, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_3
    //   8: astore 4
    //   10: aload_0
    //   11: getfield 49	com/facebook/datasource/AbstractDataSource:mIsClosed	Z
    //   14: ifne +97 -> 111
    //   17: aload_3
    //   18: astore 4
    //   20: aload_0
    //   21: getfield 54	com/facebook/datasource/AbstractDataSource:mDataSourceStatus	Lcom/facebook/datasource/AbstractDataSource$DataSourceStatus;
    //   24: getstatic 52	com/facebook/datasource/AbstractDataSource$DataSourceStatus:IN_PROGRESS	Lcom/facebook/datasource/AbstractDataSource$DataSourceStatus;
    //   27: if_acmpeq +6 -> 33
    //   30: goto +81 -> 111
    //   33: iload_2
    //   34: ifeq +21 -> 55
    //   37: aload_3
    //   38: astore 4
    //   40: aload_0
    //   41: getstatic 121	com/facebook/datasource/AbstractDataSource$DataSourceStatus:SUCCESS	Lcom/facebook/datasource/AbstractDataSource$DataSourceStatus;
    //   44: putfield 54	com/facebook/datasource/AbstractDataSource:mDataSourceStatus	Lcom/facebook/datasource/AbstractDataSource$DataSourceStatus;
    //   47: aload_3
    //   48: astore 4
    //   50: aload_0
    //   51: fconst_1
    //   52: putfield 47	com/facebook/datasource/AbstractDataSource:mProgress	F
    //   55: aload_3
    //   56: astore 4
    //   58: aload_0
    //   59: getfield 43	com/facebook/datasource/AbstractDataSource:mResult	Ljava/lang/Object;
    //   62: aload_1
    //   63: if_acmpeq +31 -> 94
    //   66: aload_3
    //   67: astore 4
    //   69: aload_0
    //   70: getfield 43	com/facebook/datasource/AbstractDataSource:mResult	Ljava/lang/Object;
    //   73: astore_3
    //   74: aload_0
    //   75: aload_1
    //   76: putfield 43	com/facebook/datasource/AbstractDataSource:mResult	Ljava/lang/Object;
    //   79: aload_3
    //   80: astore_1
    //   81: goto +15 -> 96
    //   84: astore 4
    //   86: aload_3
    //   87: astore_1
    //   88: aload 4
    //   90: astore_3
    //   91: goto +49 -> 140
    //   94: aconst_null
    //   95: astore_1
    //   96: aload_1
    //   97: astore_3
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_1
    //   101: ifnull +8 -> 109
    //   104: aload_0
    //   105: aload_1
    //   106: invokevirtual 125	com/facebook/datasource/AbstractDataSource:closeResult	(Ljava/lang/Object;)V
    //   109: iconst_1
    //   110: ireturn
    //   111: aload_1
    //   112: astore_3
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_1
    //   116: ifnull +8 -> 124
    //   119: aload_0
    //   120: aload_1
    //   121: invokevirtual 125	com/facebook/datasource/AbstractDataSource:closeResult	(Ljava/lang/Object;)V
    //   124: iconst_0
    //   125: ireturn
    //   126: astore 4
    //   128: aload_3
    //   129: astore_1
    //   130: aload 4
    //   132: astore_3
    //   133: goto +7 -> 140
    //   136: astore_3
    //   137: aload 4
    //   139: astore_1
    //   140: aload_1
    //   141: astore 4
    //   143: aload_0
    //   144: monitorexit
    //   145: aload_1
    //   146: astore 4
    //   148: aload_3
    //   149: athrow
    //   150: astore_1
    //   151: aload 4
    //   153: ifnull +9 -> 162
    //   156: aload_0
    //   157: aload 4
    //   159: invokevirtual 125	com/facebook/datasource/AbstractDataSource:closeResult	(Ljava/lang/Object;)V
    //   162: aload_1
    //   163: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	AbstractDataSource
    //   0	164	1	paramT	T
    //   0	164	2	paramBoolean	boolean
    //   4	129	3	localObject1	Object
    //   136	13	3	localObject2	Object
    //   1	67	4	localObject3	Object
    //   84	5	4	localObject4	Object
    //   126	12	4	localObject5	Object
    //   141	17	4	?	T
    // Exception table:
    //   from	to	target	type
    //   74	79	84	finally
    //   98	100	126	finally
    //   113	115	126	finally
    //   10	17	136	finally
    //   20	30	136	finally
    //   40	47	136	finally
    //   50	55	136	finally
    //   58	66	136	finally
    //   69	74	136	finally
    //   143	145	136	finally
    //   5	7	150	finally
    //   148	150	150	finally
  }
  
  private boolean wasCancelled()
  {
    try
    {
      if (isClosed())
      {
        bool = isFinished();
        if (!bool)
        {
          bool = true;
          break label25;
        }
      }
      boolean bool = false;
      label25:
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public boolean close()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 49	com/facebook/datasource/AbstractDataSource:mIsClosed	Z
    //   6: ifeq +7 -> 13
    //   9: aload_0
    //   10: monitorexit
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_0
    //   14: iconst_1
    //   15: putfield 49	com/facebook/datasource/AbstractDataSource:mIsClosed	Z
    //   18: aload_0
    //   19: getfield 43	com/facebook/datasource/AbstractDataSource:mResult	Ljava/lang/Object;
    //   22: astore_1
    //   23: aload_0
    //   24: aconst_null
    //   25: putfield 43	com/facebook/datasource/AbstractDataSource:mResult	Ljava/lang/Object;
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: ifnull +8 -> 39
    //   34: aload_0
    //   35: aload_1
    //   36: invokevirtual 125	com/facebook/datasource/AbstractDataSource:closeResult	(Ljava/lang/Object;)V
    //   39: aload_0
    //   40: invokevirtual 132	com/facebook/datasource/AbstractDataSource:isFinished	()Z
    //   43: ifne +7 -> 50
    //   46: aload_0
    //   47: invokespecial 135	com/facebook/datasource/AbstractDataSource:notifyDataSubscribers	()V
    //   50: aload_0
    //   51: monitorenter
    //   52: aload_0
    //   53: getfield 59	com/facebook/datasource/AbstractDataSource:mSubscribers	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   56: invokevirtual 138	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   59: aload_0
    //   60: monitorexit
    //   61: iconst_1
    //   62: ireturn
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	AbstractDataSource
    //   22	14	1	localObject1	Object
    //   63	4	1	localObject2	Object
    //   68	4	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   52	61	63	finally
    //   64	66	63	finally
    //   2	11	68	finally
    //   13	30	68	finally
    //   69	71	68	finally
  }
  
  protected void closeResult(@Nullable T paramT) {}
  
  @Nullable
  public Map<String, Object> getExtras()
  {
    return this.mExtras;
  }
  
  @Nullable
  public Throwable getFailureCause()
  {
    try
    {
      Throwable localThrowable = this.mFailureThrowable;
      return localThrowable;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public float getProgress()
  {
    try
    {
      float f = this.mProgress;
      return f;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @Nullable
  public T getResult()
  {
    try
    {
      Object localObject1 = this.mResult;
      return (T)localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  public boolean hasFailed()
  {
    try
    {
      DataSourceStatus localDataSourceStatus1 = this.mDataSourceStatus;
      DataSourceStatus localDataSourceStatus2 = DataSourceStatus.FAILURE;
      boolean bool;
      if (localDataSourceStatus1 == localDataSourceStatus2) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean hasMultipleResults()
  {
    return false;
  }
  
  public boolean hasResult()
  {
    try
    {
      Object localObject1 = this.mResult;
      boolean bool;
      if (localObject1 != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  public boolean isClosed()
  {
    try
    {
      boolean bool = this.mIsClosed;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isFinished()
  {
    try
    {
      DataSourceStatus localDataSourceStatus1 = this.mDataSourceStatus;
      DataSourceStatus localDataSourceStatus2 = DataSourceStatus.IN_PROGRESS;
      boolean bool;
      if (localDataSourceStatus1 != localDataSourceStatus2) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected void notifyDataSubscriber(final DataSubscriber<T> paramDataSubscriber, Executor paramExecutor, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    Runnable local1 = new Runnable()
    {
      public void run()
      {
        if (paramBoolean1)
        {
          paramDataSubscriber.onFailure(AbstractDataSource.this);
          return;
        }
        if (paramBoolean2)
        {
          paramDataSubscriber.onCancellation(AbstractDataSource.this);
          return;
        }
        paramDataSubscriber.onNewResult(AbstractDataSource.this);
      }
    };
    DataSourceInstrumenter localDataSourceInstrumenter = getDataSourceInstrumenter();
    paramDataSubscriber = local1;
    if (localDataSourceInstrumenter != null) {
      paramDataSubscriber = localDataSourceInstrumenter.decorateRunnable(local1, "AbstractDataSource_notifyDataSubscriber");
    }
    paramExecutor.execute(paramDataSubscriber);
  }
  
  protected void notifyProgressUpdate()
  {
    Iterator localIterator = this.mSubscribers.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      final DataSubscriber localDataSubscriber = (DataSubscriber)localPair.first;
      ((Executor)localPair.second).execute(new Runnable()
      {
        public void run()
        {
          localDataSubscriber.onProgressUpdate(AbstractDataSource.this);
        }
      });
    }
  }
  
  protected void setExtras(@Nullable Map<String, Object> paramMap)
  {
    this.mExtras = paramMap;
  }
  
  protected boolean setFailure(Throwable paramThrowable)
  {
    return setFailure(paramThrowable, null);
  }
  
  protected boolean setFailure(Throwable paramThrowable, @Nullable Map<String, Object> paramMap)
  {
    boolean bool = setFailureInternal(paramThrowable, paramMap);
    if (bool) {
      notifyDataSubscribers();
    }
    return bool;
  }
  
  protected boolean setProgress(float paramFloat)
  {
    boolean bool = setProgressInternal(paramFloat);
    if (bool) {
      notifyProgressUpdate();
    }
    return bool;
  }
  
  public boolean setResult(@Nullable T paramT, boolean paramBoolean)
  {
    return setResult(paramT, paramBoolean, null);
  }
  
  protected boolean setResult(@Nullable T paramT, boolean paramBoolean, @Nullable Map<String, Object> paramMap)
  {
    setExtras(paramMap);
    paramBoolean = setResultInternal(paramT, paramBoolean);
    if (paramBoolean) {
      notifyDataSubscribers();
    }
    return paramBoolean;
  }
  
  public void subscribe(DataSubscriber<T> paramDataSubscriber, Executor paramExecutor)
  {
    Preconditions.checkNotNull(paramDataSubscriber);
    Preconditions.checkNotNull(paramExecutor);
    for (;;)
    {
      try
      {
        if (this.mIsClosed) {
          return;
        }
        if (this.mDataSourceStatus == DataSourceStatus.IN_PROGRESS) {
          this.mSubscribers.add(Pair.create(paramDataSubscriber, paramExecutor));
        }
        if ((hasResult()) || (isFinished())) {
          break label100;
        }
        if (!wasCancelled()) {
          break label95;
        }
      }
      finally {}
      if (i != 0) {
        notifyDataSubscriber(paramDataSubscriber, paramExecutor, hasFailed(), wasCancelled());
      }
      return;
      label95:
      int i = 0;
      continue;
      label100:
      i = 1;
    }
  }
  
  public static abstract interface DataSourceInstrumenter
  {
    public abstract Runnable decorateRunnable(Runnable paramRunnable, String paramString);
  }
  
  private static enum DataSourceStatus
  {
    static
    {
      DataSourceStatus localDataSourceStatus = new DataSourceStatus("FAILURE", 2);
      FAILURE = localDataSourceStatus;
      $VALUES = new DataSourceStatus[] { IN_PROGRESS, SUCCESS, localDataSourceStatus };
    }
    
    private DataSourceStatus() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\datasource\AbstractDataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */