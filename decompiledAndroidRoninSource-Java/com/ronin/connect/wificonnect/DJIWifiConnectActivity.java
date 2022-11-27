package com.ronin.connect.wificonnect;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.CCResult;
import com.dji.ronin.uilib.DJIBaseFullscreenActivity;
import com.dji.ronin.uilib.dialog.CommonWhiteDialog;
import com.dji.ronin.uilib.dialog.FpvInputDialog;
import com.dji.ronin.uilib.dialog.FpvInputDialog.OnButtonClickListener;
import com.ronin.connect.wificonnect.adapter.DJIWifiListAdapter;
import com.ronin.connect.wificonnect.contract.DJIIWifiConnectContract.IWifiConnectPresenter;
import com.ronin.connect.wificonnect.contract.DJIIWifiConnectContract.IWifiConnectView;
import com.ronin.connect.wificonnect.dialog.DJIWifiCannotConnectDialog;
import dji.common.util.CommonCallbacks.CompletionCallbackWith;
import dji.publics.widget.dialog.DJIDialog;
import dji.publics.widget.dialog.DJITopImageDialog;

public class DJIWifiConnectActivity
  extends DJIBaseFullscreenActivity
  implements DJIIWifiConnectContract.IWifiConnectView, View.OnClickListener
{
  private static final String[] NEEDED_PERMISSIONS = { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" };
  private static final int PERMISSION_REQUEST_CODE = 0;
  private static final String TAG = DJIWifiConnectActivity.class.getSimpleName();
  private CC cc;
  private View emptyView;
  private DJIWifiListAdapter mAdapter;
  private AnimationDrawable mAnimDrawable;
  private Button mBtnBuyMonitor;
  private DJIWifiCannotConnectDialog mCannotConnectDialog;
  private CommonWhiteDialog mErrorPwdDialog;
  private DJIDialog mHuaWeiWifiConnectErrorDialog;
  private ImageView mIvPageBack;
  private ImageView mIvWifiSearchAnim;
  private DJIDialog mLocationPermissionDialog;
  private DJITopImageDialog mMonitorTipDialog;
  private FpvInputDialog mPwdSettingDialog;
  private CommonWhiteDialog mPwdSettingSuccessDialog;
  private RecyclerView mRecyclerView;
  private TextView mTvEnterFpv;
  private TextView mTvPageTitle;
  private DJIDialog mWifiConnectErrorDialog;
  private DJIIWifiConnectContract.IWifiConnectPresenter mWifiConnectPresenter;
  private LinearLayout mllytWifiSearchAnim;
  private View openBlueTipView;
  private CCResult result;
  private ViewGroup searchAnimContainer;
  
  private boolean checkPermission()
  {
    return false;
  }
  
  /* Error */
  private void initView()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void requestPermission()
  {
    ActivityCompat.requestPermissions(this, NEEDED_PERMISSIONS, 0);
  }
  
  /* Error */
  private void showLocationPermissionDialog(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void showSuccessDialog()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void showWiFiConnectDialog(String arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void showWifiConnectRetryDialog(String arg1, String arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void switchEmptyListView(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void clearAllData()
  {
    clearData();
  }
  
  /* Error */
  public void clearData()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void configWifiPwd(com.ronin.connect.wificonnect.bean.DJIWifiBean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void dismissAnimView()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void dismissHuaWeiWifiConnectErrorTipDialog()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void dismissMonitorTipDialog()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void dismissPasswordSettingDialog()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void dismissSystemWifiConnectDialog()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void dismissWifiConnectErrorTipDialog()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void enterFPV()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Context getContext()
  {
    return this;
  }
  
  /* Error */
  public void onClick(View arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onCreate(android.os.Bundle arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onDestroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onPause()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onRequestPermissionsResult(int arg1, String[] arg2, int[] arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onResume()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void showAnimView()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void showErrorPwdDialog()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void showHuaWeiWifiConnectErrorTipDialog()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void showMonitorTipDialog()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void showNoWifiFound() {}
  
  /* Error */
  public void showPasswordSettingDialog()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void showSystemWiFiConnectDialog(String arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void showWifiClosed()
  {
    clearAllData();
    viewSwitchLogic();
    dismissAnimView();
  }
  
  /* Error */
  public void showWifiConnectErrorTipDialog()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void showWifiEnabled()
  {
    showAnimView();
    viewSwitchLogic();
  }
  
  /* Error */
  public void updateList(java.util.List<com.ronin.connect.wificonnect.bean.DJIWifiBean> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void viewSwitchLogic()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\ronin\connect\wificonnect\DJIWifiConnectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */