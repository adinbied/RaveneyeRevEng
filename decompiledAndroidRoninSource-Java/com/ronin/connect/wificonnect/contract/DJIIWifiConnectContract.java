package com.ronin.connect.wificonnect.contract;

import android.content.Context;
import com.dji.ronin.uilib.mvp.IDJIMvpModel;
import com.dji.ronin.uilib.mvp.IDJIMvpPresenter;
import com.dji.ronin.uilib.mvp.IDJIMvpView;
import com.ronin.connect.wificonnect.bean.ConnectWiFiInfo;
import com.ronin.connect.wificonnect.bean.DJIWifiBean;
import com.ronin.connect.wificonnect.bean.DJIWifiCipherType;
import dji.common.util.CommonCallbacks.CompletionCallbackWith;
import io.reactivex.Completable;
import java.util.List;

public abstract interface DJIIWifiConnectContract
{
  public static abstract interface IWifiConnectModel
    extends IDJIMvpModel
  {
    public abstract void clearSelections();
    
    public abstract List<DJIWifiBean> getItemList();
  }
  
  public static abstract interface IWifiConnectPresenter
    extends IDJIMvpPresenter<DJIIWifiConnectContract.IWifiConnectView>
  {
    public abstract ConnectWiFiInfo connectWifi(String paramString1, String paramString2, DJIWifiCipherType paramDJIWifiCipherType);
    
    public abstract void connectWifi(String paramString1, String paramString2, String paramString3, CommonCallbacks.CompletionCallbackWith<Boolean> paramCompletionCallbackWith);
    
    public abstract String getWifiPassword();
    
    public abstract int getWifiState();
    
    public abstract void initWifiConnectManager(Context paramContext);
    
    public abstract boolean isConnecting();
    
    public abstract boolean isWifiEnabled();
    
    public abstract boolean isWifiListEmpty();
    
    public abstract boolean needUseNewWifiConnect();
    
    public abstract void notTipAnyMore();
    
    public abstract Completable performPasswordChange(String paramString);
    
    public abstract void registerRecever();
    
    public abstract void setPasswordChanged(boolean paramBoolean);
    
    public abstract void startScheduleWifiScan();
    
    public abstract void stopScheduleWifiScan();
    
    public abstract void unregisterRecever();
    
    public abstract void updateList(List<DJIWifiBean> paramList);
    
    public abstract boolean wifiNoNeedPwd(String paramString);
  }
  
  public static abstract interface IWifiConnectView
    extends IDJIMvpView
  {
    public abstract void clearAllData();
    
    public abstract void dismissAnimView();
    
    public abstract void dismissHuaWeiWifiConnectErrorTipDialog();
    
    public abstract void dismissMonitorTipDialog();
    
    public abstract void dismissPasswordSettingDialog();
    
    public abstract void dismissSystemWifiConnectDialog();
    
    public abstract void dismissWifiConnectErrorTipDialog();
    
    public abstract void enterFPV();
    
    public abstract void showAnimView();
    
    public abstract void showErrorPwdDialog();
    
    public abstract void showHuaWeiWifiConnectErrorTipDialog();
    
    public abstract void showMonitorTipDialog();
    
    public abstract void showNoWifiFound();
    
    public abstract void showPasswordSettingDialog();
    
    public abstract void showSystemWiFiConnectDialog(String paramString1, String paramString2);
    
    public abstract void showWifiClosed();
    
    public abstract void showWifiEnabled();
    
    public abstract void updateList(List<DJIWifiBean> paramList);
    
    public abstract void viewSwitchLogic();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\ronin\connect\wificonnect\contract\DJIIWifiConnectContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */