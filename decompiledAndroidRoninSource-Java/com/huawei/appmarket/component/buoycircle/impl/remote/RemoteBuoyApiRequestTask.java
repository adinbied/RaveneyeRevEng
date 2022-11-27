package com.huawei.appmarket.component.buoycircle.impl.remote;

import com.huawei.gamebox.plugin.gameservice.service.RequestInfo;

public class RemoteBuoyApiRequestTask
  extends SequentialTask
{
  private static final String TAG = "RemoteBuoyRequestTask";
  protected RequestInfo mRequest;
  
  public RemoteBuoyApiRequestTask(RequestInfo paramRequestInfo)
  {
    this.mRequest = paramRequestInfo;
  }
  
  /* Error */
  public void run(SequentialTaskListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static class RequestHandler
    implements BuoyServiceApiClient.GameServiceApiHandler
  {
    public void onResult(int paramInt, String paramString) {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\impl\remote\RemoteBuoyApiRequestTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */