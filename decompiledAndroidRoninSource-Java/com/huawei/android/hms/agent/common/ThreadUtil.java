package com.huawei.android.hms.agent.common;

import java.util.concurrent.ExecutorService;

public final class ThreadUtil
{
  public static final ThreadUtil INST = new ThreadUtil();
  private ExecutorService executors;
  
  private ExecutorService getExecutorService()
  {
    return null;
  }
  
  /* Error */
  public void excute(Runnable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void excuteInMainThread(Runnable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\android\hms\agent\common\ThreadUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */