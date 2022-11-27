package com.facebook.imagepipeline.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;

public class ListDataSource<T>
  extends AbstractDataSource<List<CloseableReference<T>>>
{
  private final DataSource<CloseableReference<T>>[] mDataSources;
  private int mFinishedDataSources;
  
  protected ListDataSource(DataSource<CloseableReference<T>>[] paramArrayOfDataSource)
  {
    this.mDataSources = paramArrayOfDataSource;
    this.mFinishedDataSources = 0;
  }
  
  public static <T> ListDataSource<T> create(DataSource<CloseableReference<T>>... paramVarArgs)
  {
    Preconditions.checkNotNull(paramVarArgs);
    int j = paramVarArgs.length;
    int i = 0;
    boolean bool;
    if (j > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool);
    ListDataSource localListDataSource = new ListDataSource(paramVarArgs);
    j = paramVarArgs.length;
    while (i < j)
    {
      DataSource<CloseableReference<T>> localDataSource = paramVarArgs[i];
      if (localDataSource != null)
      {
        localListDataSource.getClass();
        localDataSource.subscribe(new InternalDataSubscriber(localListDataSource, null), CallerThreadExecutor.getInstance());
      }
      i += 1;
    }
    return localListDataSource;
  }
  
  private boolean increaseAndCheckIfLast()
  {
    try
    {
      int i = this.mFinishedDataSources;
      boolean bool = true;
      i += 1;
      this.mFinishedDataSources = i;
      int j = this.mDataSources.length;
      if (i != j) {
        bool = false;
      }
      return bool;
    }
    finally {}
  }
  
  private void onDataSourceCancelled()
  {
    setFailure(new CancellationException());
  }
  
  private void onDataSourceFailed(DataSource<CloseableReference<T>> paramDataSource)
  {
    setFailure(paramDataSource.getFailureCause());
  }
  
  private void onDataSourceFinished()
  {
    if (increaseAndCheckIfLast()) {
      setResult(null, true, null);
    }
  }
  
  private void onDataSourceProgress()
  {
    DataSource[] arrayOfDataSource = this.mDataSources;
    int j = arrayOfDataSource.length;
    float f = 0.0F;
    int i = 0;
    while (i < j)
    {
      f += arrayOfDataSource[i].getProgress();
      i += 1;
    }
    setProgress(f / this.mDataSources.length);
  }
  
  public boolean close()
  {
    boolean bool = super.close();
    int i = 0;
    if (!bool) {
      return false;
    }
    DataSource[] arrayOfDataSource = this.mDataSources;
    int j = arrayOfDataSource.length;
    while (i < j)
    {
      arrayOfDataSource[i].close();
      i += 1;
    }
    return true;
  }
  
  @Nullable
  public List<CloseableReference<T>> getResult()
  {
    try
    {
      boolean bool = hasResult();
      if (!bool) {
        return null;
      }
      ArrayList localArrayList = new ArrayList(this.mDataSources.length);
      DataSource[] arrayOfDataSource = this.mDataSources;
      int j = arrayOfDataSource.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(arrayOfDataSource[i].getResult());
        i += 1;
      }
      return localArrayList;
    }
    finally {}
  }
  
  public boolean hasResult()
  {
    try
    {
      if (!isClosed())
      {
        int i = this.mFinishedDataSources;
        int j = this.mDataSources.length;
        if (i == j)
        {
          bool = true;
          break label32;
        }
      }
      boolean bool = false;
      label32:
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private class InternalDataSubscriber
    implements DataSubscriber<CloseableReference<T>>
  {
    boolean mFinished = false;
    
    private InternalDataSubscriber() {}
    
    private boolean tryFinish()
    {
      try
      {
        boolean bool = this.mFinished;
        if (bool) {
          return false;
        }
        this.mFinished = true;
        return true;
      }
      finally {}
    }
    
    public void onCancellation(DataSource<CloseableReference<T>> paramDataSource)
    {
      ListDataSource.this.onDataSourceCancelled();
    }
    
    public void onFailure(DataSource<CloseableReference<T>> paramDataSource)
    {
      ListDataSource.this.onDataSourceFailed(paramDataSource);
    }
    
    public void onNewResult(DataSource<CloseableReference<T>> paramDataSource)
    {
      if ((paramDataSource.isFinished()) && (tryFinish())) {
        ListDataSource.this.onDataSourceFinished();
      }
    }
    
    public void onProgressUpdate(DataSource<CloseableReference<T>> paramDataSource)
    {
      ListDataSource.this.onDataSourceProgress();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\datasource\ListDataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */