package com.huawei.android.hms.agent.push;

import com.huawei.android.hms.agent.common.BaseApiAgent;
import com.huawei.android.hms.agent.push.handler.EnableReceiveNotifyMsgHandler;
import com.huawei.hms.api.HuaweiApiClient;

public class EnableReceiveNotifyMsgApi
  extends BaseApiAgent
{
  boolean enable;
  private EnableReceiveNotifyMsgHandler handler;
  
  /* Error */
  public void enableReceiveNotifyMsg(boolean arg1, EnableReceiveNotifyMsgHandler arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
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
  void onEnableReceiveNotifyMsgResult(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\android\hms\agent\push\EnableReceiveNotifyMsgApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */