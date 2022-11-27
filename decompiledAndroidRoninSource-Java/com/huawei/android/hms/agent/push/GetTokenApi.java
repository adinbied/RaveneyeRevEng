package com.huawei.android.hms.agent.push;

import com.huawei.android.hms.agent.common.BaseApiAgent;
import com.huawei.android.hms.agent.push.handler.GetTokenHandler;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.push.TokenResult;

public class GetTokenApi
  extends BaseApiAgent
{
  private static final int MAX_RETRY_TIMES = 1;
  private GetTokenHandler handler;
  private int retryTimes = 1;
  
  /* Error */
  public void getToken(GetTokenHandler arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onConnect(int arg1, com.huawei.hms.api.HuaweiApiClient arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void onPushTokenResult(int arg1, TokenResult arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\android\hms\agent\push\GetTokenApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */