package com.huawei.android.hms.agent.push;

import com.huawei.android.hms.agent.common.BaseApiAgent;
import com.huawei.android.hms.agent.push.handler.GetPushStateHandler;
import com.huawei.hms.api.HuaweiApiClient;

public class GetPushStateApi
  extends BaseApiAgent
{
  private GetPushStateHandler handler;
  
  /* Error */
  public void getPushState(GetPushStateHandler arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onConnect(int arg1, HuaweiApiClient arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void onGetPushStateResult(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\android\hms\agent\push\GetPushStateApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */