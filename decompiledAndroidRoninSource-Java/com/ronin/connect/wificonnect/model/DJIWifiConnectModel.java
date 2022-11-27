package com.ronin.connect.wificonnect.model;

import com.ronin.connect.wificonnect.bean.DJIWifiBean;
import com.ronin.connect.wificonnect.contract.DJIIWifiConnectContract.IWifiConnectModel;
import com.ronin.connect.wificonnect.contract.DJIIWifiConnectContract.IWifiConnectPresenter;
import java.util.List;

public class DJIWifiConnectModel
  implements DJIIWifiConnectContract.IWifiConnectModel
{
  private static final String TAG = DJIWifiConnectModel.class.getSimpleName();
  private final DJIIWifiConnectContract.IWifiConnectPresenter mPresenter;
  
  public DJIWifiConnectModel(DJIIWifiConnectContract.IWifiConnectPresenter paramIWifiConnectPresenter)
  {
    this.mPresenter = paramIWifiConnectPresenter;
  }
  
  public void bind() {}
  
  public void clearSelections() {}
  
  public List<DJIWifiBean> getItemList()
  {
    return null;
  }
  
  public void unbind() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\ronin\connect\wificonnect\model\DJIWifiConnectModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */