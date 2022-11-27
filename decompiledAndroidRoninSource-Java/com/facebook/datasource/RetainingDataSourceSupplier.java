package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Supplier;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import javax.annotation.Nullable;

public class RetainingDataSourceSupplier<T>
  implements Supplier<DataSource<T>>
{
  @Nullable
  private Supplier<DataSource<T>> mCurrentDataSourceSupplier = null;
  private final Set<RetainingDataSource> mDataSources = Collections.newSetFromMap(new WeakHashMap());
  
  public DataSource<T> get()
  {
    RetainingDataSource localRetainingDataSource = new RetainingDataSource(null);
    localRetainingDataSource.setSupplier(this.mCurrentDataSourceSupplier);
    this.mDataSources.add(localRetainingDataSource);
    return localRetainingDataSource;
  }
  
  public void replaceSupplier(Supplier<DataSource<T>> paramSupplier)
  {
    this.mCurrentDataSourceSupplier = paramSupplier;
    Iterator localIterator = this.mDataSources.iterator();
    while (localIterator.hasNext())
    {
      RetainingDataSource localRetainingDataSource = (RetainingDataSource)localIterator.next();
      if (!localRetainingDataSource.isClosed()) {
        localRetainingDataSource.setSupplier(paramSupplier);
      }
    }
  }
  
  private static class RetainingDataSource<T>
    extends AbstractDataSource<T>
  {
    @Nullable
    private DataSource<T> mDataSource = null;
    
    private static <T> void closeSafely(DataSource<T> paramDataSource)
    {
      if (paramDataSource != null) {
        paramDataSource.close();
      }
    }
    
    private void onDataSourceFailed(DataSource<T> paramDataSource) {}
    
    private void onDataSourceNewResult(DataSource<T> paramDataSource)
    {
      if (paramDataSource == this.mDataSource) {
        setResult(null, false, paramDataSource.getExtras());
      }
    }
    
    private void onDatasourceProgress(DataSource<T> paramDataSource)
    {
      if (paramDataSource == this.mDataSource) {
        setProgress(paramDataSource.getProgress());
      }
    }
    
    public boolean close()
    {
      try
      {
        if (!super.close()) {
          return false;
        }
        DataSource localDataSource = this.mDataSource;
        this.mDataSource = null;
        closeSafely(localDataSource);
        return true;
      }
      finally {}
    }
    
    @Nullable
    public T getResult()
    {
      try
      {
        Object localObject1;
        if (this.mDataSource != null) {
          localObject1 = this.mDataSource.getResult();
        } else {
          localObject1 = null;
        }
        return (T)localObject1;
      }
      finally
      {
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
    }
    
    public boolean hasMultipleResults()
    {
      return true;
    }
    
    public boolean hasResult()
    {
      try
      {
        if (this.mDataSource != null)
        {
          bool = this.mDataSource.hasResult();
          if (bool)
          {
            bool = true;
            break label30;
          }
        }
        boolean bool = false;
        label30:
        return bool;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void setSupplier(@Nullable Supplier<DataSource<T>> paramSupplier)
    {
      if (isClosed()) {
        return;
      }
      if (paramSupplier != null) {
        paramSupplier = (DataSource)paramSupplier.get();
      } else {
        paramSupplier = null;
      }
      try
      {
        if (isClosed())
        {
          closeSafely(paramSupplier);
          return;
        }
        DataSource localDataSource = this.mDataSource;
        this.mDataSource = paramSupplier;
        if (paramSupplier != null) {
          paramSupplier.subscribe(new InternalDataSubscriber(null), CallerThreadExecutor.getInstance());
        }
        closeSafely(localDataSource);
        return;
      }
      finally {}
    }
    
    private class InternalDataSubscriber
      implements DataSubscriber<T>
    {
      private InternalDataSubscriber() {}
      
      public void onCancellation(DataSource<T> paramDataSource) {}
      
      public void onFailure(DataSource<T> paramDataSource)
      {
        RetainingDataSourceSupplier.RetainingDataSource.this.onDataSourceFailed(paramDataSource);
      }
      
      public void onNewResult(DataSource<T> paramDataSource)
      {
        if (paramDataSource.hasResult())
        {
          RetainingDataSourceSupplier.RetainingDataSource.this.onDataSourceNewResult(paramDataSource);
          return;
        }
        if (paramDataSource.isFinished()) {
          RetainingDataSourceSupplier.RetainingDataSource.this.onDataSourceFailed(paramDataSource);
        }
      }
      
      public void onProgressUpdate(DataSource<T> paramDataSource)
      {
        RetainingDataSourceSupplier.RetainingDataSource.this.onDatasourceProgress(paramDataSource);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\datasource\RetainingDataSourceSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */