package com.huawei.android.hms.agent.common;

import com.huawei.android.hms.agent.common.handler.ICallbackCode;

public class CallbackCodeRunnable
  implements Runnable
{
  private ICallbackCode handlerInner;
  private int rtnCodeInner;
  
  public CallbackCodeRunnable(ICallbackCode paramICallbackCode, int paramInt)
  {
    this.handlerInner = paramICallbackCode;
    this.rtnCodeInner = paramInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\android\hms\agent\common\CallbackCodeRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */