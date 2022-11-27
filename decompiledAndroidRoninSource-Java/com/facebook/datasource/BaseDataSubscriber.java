package com.facebook.datasource;

import javax.annotation.Nonnull;

public abstract class BaseDataSubscriber<T>
  implements DataSubscriber<T>
{
  public void onCancellation(@Nonnull DataSource<T> paramDataSource) {}
  
  public void onFailure(@Nonnull DataSource<T> paramDataSource)
  {
    try
    {
      onFailureImpl(paramDataSource);
      return;
    }
    finally
    {
      paramDataSource.close();
    }
  }
  
  protected abstract void onFailureImpl(@Nonnull DataSource<T> paramDataSource);
  
  public void onNewResult(@Nonnull DataSource<T> paramDataSource)
  {
    boolean bool = paramDataSource.isFinished();
    try
    {
      onNewResultImpl(paramDataSource);
      return;
    }
    finally
    {
      if (bool) {
        paramDataSource.close();
      }
    }
  }
  
  protected abstract void onNewResultImpl(@Nonnull DataSource<T> paramDataSource);
  
  public void onProgressUpdate(@Nonnull DataSource<T> paramDataSource) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\datasource\BaseDataSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */