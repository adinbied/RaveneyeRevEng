package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import java.util.List;
import javax.annotation.Nullable;

public class FirstAvailableDataSourceSupplier<T>
  implements Supplier<DataSource<T>>
{
  private final List<Supplier<DataSource<T>>> mDataSourceSuppliers;
  
  private FirstAvailableDataSourceSupplier(List<Supplier<DataSource<T>>> paramList)
  {
    Preconditions.checkArgument(paramList.isEmpty() ^ true, "List of suppliers is empty!");
    this.mDataSourceSuppliers = paramList;
  }
  
  public static <T> FirstAvailableDataSourceSupplier<T> create(List<Supplier<DataSource<T>>> paramList)
  {
    return new FirstAvailableDataSourceSupplier(paramList);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof FirstAvailableDataSourceSupplier)) {
      return false;
    }
    paramObject = (FirstAvailableDataSourceSupplier)paramObject;
    return Objects.equal(this.mDataSourceSuppliers, ((FirstAvailableDataSourceSupplier)paramObject).mDataSourceSuppliers);
  }
  
  public DataSource<T> get()
  {
    return new FirstAvailableDataSource();
  }
  
  public int hashCode()
  {
    return this.mDataSourceSuppliers.hashCode();
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("list", this.mDataSourceSuppliers).toString();
  }
  
  private class FirstAvailableDataSource
    extends AbstractDataSource<T>
  {
    private DataSource<T> mCurrentDataSource = null;
    private DataSource<T> mDataSourceWithResult = null;
    private int mIndex = 0;
    
    public FirstAvailableDataSource()
    {
      if (!startNextDataSource()) {
        setFailure(new RuntimeException("No data source supplier or supplier returned null."));
      }
    }
    
    private boolean clearCurrentDataSource(DataSource<T> paramDataSource)
    {
      try
      {
        if ((!isClosed()) && (paramDataSource == this.mCurrentDataSource))
        {
          this.mCurrentDataSource = null;
          return true;
        }
        return false;
      }
      finally {}
    }
    
    private void closeSafely(DataSource<T> paramDataSource)
    {
      if (paramDataSource != null) {
        paramDataSource.close();
      }
    }
    
    @Nullable
    private DataSource<T> getDataSourceWithResult()
    {
      try
      {
        DataSource localDataSource = this.mDataSourceWithResult;
        return localDataSource;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    @Nullable
    private Supplier<DataSource<T>> getNextSupplier()
    {
      try
      {
        if ((!isClosed()) && (this.mIndex < FirstAvailableDataSourceSupplier.this.mDataSourceSuppliers.size()))
        {
          Object localObject1 = FirstAvailableDataSourceSupplier.this.mDataSourceSuppliers;
          int i = this.mIndex;
          this.mIndex = (i + 1);
          localObject1 = (Supplier)((List)localObject1).get(i);
          return (Supplier<DataSource<T>>)localObject1;
        }
        return null;
      }
      finally
      {
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
    }
    
    private void maybeSetDataSourceWithResult(DataSource<T> paramDataSource, boolean paramBoolean)
    {
      for (;;)
      {
        try
        {
          if ((paramDataSource == this.mCurrentDataSource) && (paramDataSource != this.mDataSourceWithResult))
          {
            if (this.mDataSourceWithResult != null) {
              if (!paramBoolean) {
                break label63;
              }
            }
            DataSource localDataSource = this.mDataSourceWithResult;
            this.mDataSourceWithResult = paramDataSource;
            paramDataSource = localDataSource;
            closeSafely(paramDataSource);
          }
          else
          {
            return;
          }
        }
        finally {}
        label63:
        paramDataSource = null;
      }
    }
    
    private void onDataSourceFailed(DataSource<T> paramDataSource)
    {
      if (!clearCurrentDataSource(paramDataSource)) {
        return;
      }
      if (paramDataSource != getDataSourceWithResult()) {
        closeSafely(paramDataSource);
      }
      if (!startNextDataSource()) {
        setFailure(paramDataSource.getFailureCause(), paramDataSource.getExtras());
      }
    }
    
    private void onDataSourceNewResult(DataSource<T> paramDataSource)
    {
      maybeSetDataSourceWithResult(paramDataSource, paramDataSource.isFinished());
      if (paramDataSource == getDataSourceWithResult()) {
        setResult(null, paramDataSource.isFinished(), paramDataSource.getExtras());
      }
    }
    
    private boolean setCurrentDataSource(DataSource<T> paramDataSource)
    {
      try
      {
        boolean bool = isClosed();
        if (bool) {
          return false;
        }
        this.mCurrentDataSource = paramDataSource;
        return true;
      }
      finally {}
    }
    
    private boolean startNextDataSource()
    {
      Object localObject = getNextSupplier();
      if (localObject != null) {
        localObject = (DataSource)((Supplier)localObject).get();
      } else {
        localObject = null;
      }
      if ((setCurrentDataSource((DataSource)localObject)) && (localObject != null))
      {
        ((DataSource)localObject).subscribe(new InternalDataSubscriber(null), CallerThreadExecutor.getInstance());
        return true;
      }
      closeSafely((DataSource)localObject);
      return false;
    }
    
    public boolean close()
    {
      try
      {
        if (!super.close()) {
          return false;
        }
        DataSource localDataSource1 = this.mCurrentDataSource;
        this.mCurrentDataSource = null;
        DataSource localDataSource2 = this.mDataSourceWithResult;
        this.mDataSourceWithResult = null;
        closeSafely(localDataSource2);
        closeSafely(localDataSource1);
        return true;
      }
      finally {}
    }
    
    @Nullable
    public T getResult()
    {
      try
      {
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
        DataSource localDataSource = getDataSourceWithResult();
        if (localDataSource != null)
        {
          bool = localDataSource.hasResult();
          if (bool)
          {
            bool = true;
            break label29;
          }
        }
        boolean bool = false;
        label29:
        return bool;
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
        FirstAvailableDataSourceSupplier.FirstAvailableDataSource.this.onDataSourceFailed(paramDataSource);
      }
      
      public void onNewResult(DataSource<T> paramDataSource)
      {
        if (paramDataSource.hasResult())
        {
          FirstAvailableDataSourceSupplier.FirstAvailableDataSource.this.onDataSourceNewResult(paramDataSource);
          return;
        }
        if (paramDataSource.isFinished()) {
          FirstAvailableDataSourceSupplier.FirstAvailableDataSource.this.onDataSourceFailed(paramDataSource);
        }
      }
      
      public void onProgressUpdate(DataSource<T> paramDataSource)
      {
        float f = FirstAvailableDataSourceSupplier.FirstAvailableDataSource.this.getProgress();
        FirstAvailableDataSourceSupplier.FirstAvailableDataSource.this.setProgress(Math.max(f, paramDataSource.getProgress()));
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\datasource\FirstAvailableDataSourceSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */