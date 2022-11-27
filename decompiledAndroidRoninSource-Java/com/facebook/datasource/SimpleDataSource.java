package com.facebook.datasource;

import com.facebook.common.internal.Preconditions;
import java.util.Map;

public class SimpleDataSource<T>
  extends AbstractDataSource<T>
{
  public static <T> SimpleDataSource<T> create()
  {
    return new SimpleDataSource();
  }
  
  public boolean setFailure(Throwable paramThrowable)
  {
    return super.setFailure((Throwable)Preconditions.checkNotNull(paramThrowable));
  }
  
  public boolean setProgress(float paramFloat)
  {
    return super.setProgress(paramFloat);
  }
  
  public boolean setResult(T paramT)
  {
    return super.setResult(Preconditions.checkNotNull(paramT), true, null);
  }
  
  public boolean setResult(T paramT, boolean paramBoolean, Map<String, Object> paramMap)
  {
    return super.setResult(Preconditions.checkNotNull(paramT), paramBoolean, paramMap);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\datasource\SimpleDataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */