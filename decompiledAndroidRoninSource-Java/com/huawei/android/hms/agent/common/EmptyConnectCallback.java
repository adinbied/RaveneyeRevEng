package com.huawei.android.hms.agent.common;

public class EmptyConnectCallback
  implements IClientConnectCallback
{
  private String msgPre;
  
  public EmptyConnectCallback(String paramString)
  {
    this.msgPre = paramString;
  }
  
  /* Error */
  public void onConnect(int arg1, com.huawei.hms.api.HuaweiApiClient arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\android\hms\agent\common\EmptyConnectCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */