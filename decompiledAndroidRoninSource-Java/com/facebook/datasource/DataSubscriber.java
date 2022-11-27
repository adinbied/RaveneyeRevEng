package com.facebook.datasource;

import javax.annotation.Nonnull;

public abstract interface DataSubscriber<T>
{
  public abstract void onCancellation(@Nonnull DataSource<T> paramDataSource);
  
  public abstract void onFailure(@Nonnull DataSource<T> paramDataSource);
  
  public abstract void onNewResult(@Nonnull DataSource<T> paramDataSource);
  
  public abstract void onProgressUpdate(@Nonnull DataSource<T> paramDataSource);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\datasource\DataSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */