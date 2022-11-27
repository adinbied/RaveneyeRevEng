package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

public class IncreasingQualityDataSourceSupplier<T>
  implements Supplier<DataSource<T>>
{
  private final boolean mDataSourceLazy;
  private final List<Supplier<DataSource<T>>> mDataSourceSuppliers;
  
  private IncreasingQualityDataSourceSupplier(List<Supplier<DataSource<T>>> paramList, boolean paramBoolean)
  {
    Preconditions.checkArgument(paramList.isEmpty() ^ true, "List of suppliers is empty!");
    this.mDataSourceSuppliers = paramList;
    this.mDataSourceLazy = paramBoolean;
  }
  
  public static <T> IncreasingQualityDataSourceSupplier<T> create(List<Supplier<DataSource<T>>> paramList)
  {
    return create(paramList, false);
  }
  
  public static <T> IncreasingQualityDataSourceSupplier<T> create(List<Supplier<DataSource<T>>> paramList, boolean paramBoolean)
  {
    return new IncreasingQualityDataSourceSupplier(paramList, paramBoolean);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof IncreasingQualityDataSourceSupplier)) {
      return false;
    }
    paramObject = (IncreasingQualityDataSourceSupplier)paramObject;
    return Objects.equal(this.mDataSourceSuppliers, ((IncreasingQualityDataSourceSupplier)paramObject).mDataSourceSuppliers);
  }
  
  public DataSource<T> get()
  {
    return new IncreasingQualityDataSource();
  }
  
  public int hashCode()
  {
    return this.mDataSourceSuppliers.hashCode();
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("list", this.mDataSourceSuppliers).toString();
  }
  
  private class IncreasingQualityDataSource
    extends AbstractDataSource<T>
  {
    @Nullable
    private ArrayList<DataSource<T>> mDataSources;
    @Nullable
    private Throwable mDelayedError;
    @Nullable
    private Map<String, Object> mDelayedExtras;
    private AtomicInteger mFinishedDataSources;
    private int mIndexOfDataSourceWithResult;
    private int mNumberOfDataSources;
    
    public IncreasingQualityDataSource()
    {
      if (!IncreasingQualityDataSourceSupplier.this.mDataSourceLazy) {
        ensureDataSourceInitialized();
      }
    }
    
    private void closeSafely(DataSource<T> paramDataSource)
    {
      if (paramDataSource != null) {
        paramDataSource.close();
      }
    }
    
    private void ensureDataSourceInitialized()
    {
      if (this.mFinishedDataSources != null) {
        return;
      }
      for (;;)
      {
        int i;
        try
        {
          if (this.mFinishedDataSources == null)
          {
            i = 0;
            this.mFinishedDataSources = new AtomicInteger(0);
            int j = IncreasingQualityDataSourceSupplier.this.mDataSourceSuppliers.size();
            this.mNumberOfDataSources = j;
            this.mIndexOfDataSourceWithResult = j;
            this.mDataSources = new ArrayList(j);
            if (i < j)
            {
              DataSource localDataSource = (DataSource)((Supplier)IncreasingQualityDataSourceSupplier.this.mDataSourceSuppliers.get(i)).get();
              this.mDataSources.add(localDataSource);
              localDataSource.subscribe(new InternalDataSubscriber(i), CallerThreadExecutor.getInstance());
              if (!localDataSource.hasResult()) {
                break label143;
              }
            }
          }
          return;
        }
        finally {}
        label143:
        i += 1;
      }
    }
    
    @Nullable
    private DataSource<T> getAndClearDataSource(int paramInt)
    {
      try
      {
        ArrayList localArrayList = this.mDataSources;
        Object localObject3 = null;
        Object localObject1 = localObject3;
        if (localArrayList != null)
        {
          localObject1 = localObject3;
          if (paramInt < this.mDataSources.size()) {
            localObject1 = (DataSource)this.mDataSources.set(paramInt, null);
          }
        }
        return (DataSource<T>)localObject1;
      }
      finally {}
    }
    
    @Nullable
    private DataSource<T> getDataSource(int paramInt)
    {
      try
      {
        DataSource localDataSource;
        if ((this.mDataSources != null) && (paramInt < this.mDataSources.size())) {
          localDataSource = (DataSource)this.mDataSources.get(paramInt);
        } else {
          localDataSource = null;
        }
        return localDataSource;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    @Nullable
    private DataSource<T> getDataSourceWithResult()
    {
      try
      {
        DataSource localDataSource = getDataSource(this.mIndexOfDataSourceWithResult);
        return localDataSource;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    private void maybeSetFailure()
    {
      if (this.mFinishedDataSources.incrementAndGet() == this.mNumberOfDataSources)
      {
        Throwable localThrowable = this.mDelayedError;
        if (localThrowable != null) {
          setFailure(localThrowable, this.mDelayedExtras);
        }
      }
    }
    
    private void maybeSetIndexOfDataSourceWithResult(int paramInt, DataSource<T> paramDataSource, boolean paramBoolean)
    {
      for (;;)
      {
        int j;
        try
        {
          int i = this.mIndexOfDataSourceWithResult;
          j = this.mIndexOfDataSourceWithResult;
          if ((paramDataSource == getDataSource(paramInt)) && (paramInt != this.mIndexOfDataSourceWithResult))
          {
            if (getDataSourceWithResult() != null) {
              if ((!paramBoolean) || (paramInt >= this.mIndexOfDataSourceWithResult)) {
                break label97;
              }
            }
            this.mIndexOfDataSourceWithResult = paramInt;
            if (i > paramInt)
            {
              closeSafely(getAndClearDataSource(i));
              i -= 1;
              continue;
            }
          }
          else
          {
            return;
          }
        }
        finally {}
        label97:
        paramInt = j;
      }
    }
    
    private void onDataSourceFailed(int paramInt, DataSource<T> paramDataSource)
    {
      closeSafely(tryGetAndClearDataSource(paramInt, paramDataSource));
      if (paramInt == 0)
      {
        this.mDelayedError = paramDataSource.getFailureCause();
        this.mDelayedExtras = paramDataSource.getExtras();
      }
      maybeSetFailure();
    }
    
    private void onDataSourceNewResult(int paramInt, DataSource<T> paramDataSource)
    {
      maybeSetIndexOfDataSourceWithResult(paramInt, paramDataSource, paramDataSource.isFinished());
      if (paramDataSource == getDataSourceWithResult())
      {
        boolean bool;
        if ((paramInt == 0) && (paramDataSource.isFinished())) {
          bool = true;
        } else {
          bool = false;
        }
        setResult(null, bool, paramDataSource.getExtras());
      }
      maybeSetFailure();
    }
    
    @Nullable
    private DataSource<T> tryGetAndClearDataSource(int paramInt, DataSource<T> paramDataSource)
    {
      try
      {
        DataSource localDataSource = getDataSourceWithResult();
        if (paramDataSource == localDataSource) {
          return null;
        }
        if (paramDataSource == getDataSource(paramInt))
        {
          paramDataSource = getAndClearDataSource(paramInt);
          return paramDataSource;
        }
        return paramDataSource;
      }
      finally {}
    }
    
    public boolean close()
    {
      if (IncreasingQualityDataSourceSupplier.this.mDataSourceLazy) {
        ensureDataSourceInitialized();
      }
      try
      {
        boolean bool = super.close();
        int i = 0;
        if (!bool) {
          return false;
        }
        ArrayList localArrayList = this.mDataSources;
        this.mDataSources = null;
        if (localArrayList != null) {
          while (i < localArrayList.size())
          {
            closeSafely((DataSource)localArrayList.get(i));
            i += 1;
          }
        }
        return true;
      }
      finally {}
    }
    
    @Nullable
    public T getResult()
    {
      try
      {
        if (IncreasingQualityDataSourceSupplier.this.mDataSourceLazy) {
          ensureDataSourceInitialized();
        }
        Object localObject1 = getDataSourceWithResult();
        if (localObject1 != null) {
          localObject1 = ((DataSource)localObject1).getResult();
        } else {
          localObject1 = null;
        }
        return (T)localObject1;
      }
      finally {}
    }
    
    public boolean hasResult()
    {
      try
      {
        if (IncreasingQualityDataSourceSupplier.this.mDataSourceLazy) {
          ensureDataSourceInitialized();
        }
        DataSource localDataSource = getDataSourceWithResult();
        if (localDataSource != null)
        {
          bool = localDataSource.hasResult();
          if (bool)
          {
            bool = true;
            break label43;
          }
        }
        boolean bool = false;
        label43:
        return bool;
      }
      finally {}
    }
    
    private class InternalDataSubscriber
      implements DataSubscriber<T>
    {
      private int mIndex;
      
      public InternalDataSubscriber(int paramInt)
      {
        this.mIndex = paramInt;
      }
      
      public void onCancellation(DataSource<T> paramDataSource) {}
      
      public void onFailure(DataSource<T> paramDataSource)
      {
        IncreasingQualityDataSourceSupplier.IncreasingQualityDataSource.this.onDataSourceFailed(this.mIndex, paramDataSource);
      }
      
      public void onNewResult(DataSource<T> paramDataSource)
      {
        if (paramDataSource.hasResult())
        {
          IncreasingQualityDataSourceSupplier.IncreasingQualityDataSource.this.onDataSourceNewResult(this.mIndex, paramDataSource);
          return;
        }
        if (paramDataSource.isFinished()) {
          IncreasingQualityDataSourceSupplier.IncreasingQualityDataSource.this.onDataSourceFailed(this.mIndex, paramDataSource);
        }
      }
      
      public void onProgressUpdate(DataSource<T> paramDataSource)
      {
        if (this.mIndex == 0) {
          IncreasingQualityDataSourceSupplier.IncreasingQualityDataSource.this.setProgress(paramDataSource.getProgress());
        }
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\datasource\IncreasingQualityDataSourceSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */