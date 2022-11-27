package com.huawei.android.hms.agent.common;

import com.huawei.android.hms.agent.common.handler.ICallbackResult;

public class CallbackResultRunnable<R>
  implements Runnable
{
  private ICallbackResult<R> handlerInner;
  private R resultInner;
  private int rtnCodeInner;
  
  public CallbackResultRunnable(ICallbackResult<R> paramICallbackResult, int paramInt, R paramR)
  {
    this.handlerInner = paramICallbackResult;
    this.rtnCodeInner = paramInt;
    this.resultInner = paramR;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\android\hms\agent\common\CallbackResultRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */