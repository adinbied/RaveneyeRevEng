package com.huawei.hms.support.api;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;

public class ResolvePendingResult<T extends IMessageEntity>
  extends c<ResolveResult<T>, T>
{
  protected ResolvePendingResult(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity, Class<T> paramClass)
  {
    super(paramApiClient, paramString, paramIMessageEntity, paramClass);
  }
  
  public static <R extends IMessageEntity> ResolvePendingResult<R> build(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity, Class<R> paramClass)
  {
    return new ResolvePendingResult(paramApiClient, paramString, paramIMessageEntity, paramClass);
  }
  
  public T get()
  {
    return null;
  }
  
  public ResolveResult<T> onComplete(T paramT)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\ResolvePendingResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */