package com.huawei.hms.support.api.client;

import java.util.concurrent.TimeUnit;

public abstract class InnerPendingResult<R extends Result>
  extends PendingResult<R>
{
  public abstract R awaitOnAnyThread();
  
  public abstract R awaitOnAnyThread(long paramLong, TimeUnit paramTimeUnit);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\client\InnerPendingResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */