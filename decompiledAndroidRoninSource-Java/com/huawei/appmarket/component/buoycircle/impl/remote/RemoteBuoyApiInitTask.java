package com.huawei.appmarket.component.buoycircle.impl.remote;

import android.content.Context;

public class RemoteBuoyApiInitTask
  extends SequentialTask
{
  private static final String TAG = "RemoteBuoyApiInitTask";
  protected Context mContext;
  protected boolean mNeedRetryAidl;
  
  public RemoteBuoyApiInitTask(Context paramContext, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.mNeedRetryAidl = paramBoolean;
  }
  
  /* Error */
  public void run(SequentialTaskListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static class InitHandler
    implements BuoyServiceApiClient.GameServiceApiHandler
  {
    public void onResult(int paramInt, String paramString) {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\impl\remote\RemoteBuoyApiInitTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */