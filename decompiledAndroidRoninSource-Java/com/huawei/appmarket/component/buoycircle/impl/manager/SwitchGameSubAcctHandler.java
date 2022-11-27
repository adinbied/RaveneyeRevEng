package com.huawei.appmarket.component.buoycircle.impl.manager;

import android.content.Context;
import com.huawei.appmarket.component.buoycircle.api.ISwitchGameAccountCallBack;
import com.huawei.appmarket.component.buoycircle.impl.remote.BuoyServiceApiClient.GameServiceApiHandler;

public class SwitchGameSubAcctHandler
  implements BuoyServiceApiClient.GameServiceApiHandler
{
  private static final String TAG = "SwitchGameSubAcctHandler";
  private ISwitchGameAccountCallBack mCallback;
  private Context mContext;
  
  public SwitchGameSubAcctHandler(Context paramContext, ISwitchGameAccountCallBack paramISwitchGameAccountCallBack)
  {
    this.mContext = paramContext;
    this.mCallback = paramISwitchGameAccountCallBack;
  }
  
  /* Error */
  public void onResult(int arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\impl\manager\SwitchGameSubAcctHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */