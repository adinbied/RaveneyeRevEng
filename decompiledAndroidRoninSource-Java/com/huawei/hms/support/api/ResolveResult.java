package com.huawei.hms.support.api;

import com.huawei.hms.support.api.client.Result;

public class ResolveResult<T>
  extends Result
{
  private T a;
  
  public ResolveResult()
  {
    this.a = null;
  }
  
  public ResolveResult(T paramT)
  {
    this.a = paramT;
  }
  
  public T getValue()
  {
    return (T)this.a;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\ResolveResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */