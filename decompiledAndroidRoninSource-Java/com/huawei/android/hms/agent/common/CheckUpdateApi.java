package com.huawei.android.hms.agent.common;

import android.app.Activity;
import com.huawei.android.hms.agent.common.handler.CheckUpdateHandler;
import com.huawei.hms.api.CheckUpdatelistener;

public class CheckUpdateApi
  extends BaseApiAgent
  implements CheckUpdatelistener
{
  private Activity activity;
  private CheckUpdateHandler handler;
  
  /* Error */
  private void onCheckUpdateResult(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void checkUpdate(Activity arg1, CheckUpdateHandler arg2)
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
  
  public void onResult(int paramInt)
  {
    onCheckUpdateResult(paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\android\hms\agent\common\CheckUpdateApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */