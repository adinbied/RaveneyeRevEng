package com.facebook.datasource;

public abstract class BaseBooleanSubscriber
  implements DataSubscriber<Boolean>
{
  public void onCancellation(DataSource<Boolean> paramDataSource) {}
  
  public void onFailure(DataSource<Boolean> paramDataSource)
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
  
  protected abstract void onFailureImpl(DataSource<Boolean> paramDataSource);
  
  public void onNewResult(DataSource<Boolean> paramDataSource)
  {
    try
    {
      onNewResultImpl(((Boolean)paramDataSource.getResult()).booleanValue());
      return;
    }
    finally
    {
      paramDataSource.close();
    }
  }
  
  protected abstract void onNewResultImpl(boolean paramBoolean);
  
  public void onProgressUpdate(DataSource<Boolean> paramDataSource) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\datasource\BaseBooleanSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */