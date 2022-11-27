package com.dji.webviewui.buymonitor;

import com.dji.api.RoninBuyMonitorHttpApi;
import com.dji.webviewui.DJIRoninBaseWebViewActivity;

public class DJIRoninBuyMonitorActivity
  extends DJIRoninBaseWebViewActivity<BuyMonitorViewModel>
{
  private static final String TAG = "DJIRoninBuyMonitorActivity";
  
  public String getLoadUrl()
  {
    return RoninBuyMonitorHttpApi.getBuyMonitorUrl();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\webviewui\buymonitor\DJIRoninBuyMonitorActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */