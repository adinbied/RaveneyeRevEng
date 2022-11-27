package com.huawei.appmarket.component.buoycircle.impl.manager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.huawei.appmarket.component.buoycircle.api.AppInfo;
import com.huawei.appmarket.component.buoycircle.api.ISwitchGameAccountCallBack;
import com.huawei.appmarket.component.buoycircle.impl.remote.BuoyServiceApiClient;
import com.huawei.appmarket.component.buoycircle.impl.remote.BuoyServiceApiClient.GameServiceApiHandler;
import com.huawei.appmarket.component.buoycircle.impl.remote.RunTask;
import com.huawei.appmarket.component.buoycircle.impl.remote.SequentialTaskManager.RunTaskResultHandler;
import com.huawei.appmarket.component.buoycircle.impl.utils.ResourceLoaderUtil;
import com.huawei.appmarket.component.buoycircle.impl.view.FloatWindowSmallView;

public class FloatWindowManager
{
  private static final int CREATE_DEFAULT_HIDE = 1;
  private static final int CREATE_FORCE_DISPLAY = 2;
  private static final int CRETAE_DEFAULT_DISPLAY = 0;
  private static final int HAS_NEW_RED_MSG = 1;
  private static final int IS_NEED_RED_TRUE = 0;
  private static final int REFRESH_FLOAT_WINDOW_HANDLER = 1;
  private static final int REFRESH_RED_INFO_HANDLER = 2;
  private static final int REMOVE_FLOAT_ON_UI_THREAD = 1002;
  private static final int RTN_CODE_SHOW_BUOY_ERROR = 1;
  private static final int RTN_CODE_SHOW_BUOY_FINISH = 2;
  private static final int RTN_CODE_SHOW_BUOY_OK = 0;
  private static final int SHOW_FLOAT_ON_UI_THREAD = 1001;
  private static final int SHOW_TOAST_CLICK_FAILED = 3;
  private static final String TAG = "FloatWindowManager";
  private static FloatWindowManager instance;
  private String appId;
  private AppInfo appInfo;
  private String cpId;
  private int createMode;
  private boolean isAppAdaptNotch;
  private int isNeedRed = -1;
  private boolean isRemoteViewShow = false;
  private final Object lock = new Object();
  protected Context mContext;
  private ISwitchGameAccountCallBack mSwitchCallBack;
  private Handler msgHandler;
  private RunTask onServiceDisconnectTask = new RunTask()
  {
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  private String packageName;
  private RunTask removeSmallBuoyTask = new RunTask()
  {
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  private boolean requestShowWindow = false;
  private SequentialTaskManager.RunTaskResultHandler resultHandler = new SequentialTaskManager.RunTaskResultHandler()
  {
    /* Error */
    public void onResult(int arg1, String arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
  };
  private FloatWindowSmallView smallWindow;
  private WindowManager.LayoutParams smallWindowParams;
  
  /* Error */
  private void addView()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void createSmallWindow()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void getBuoyHasNewRedInfo()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static FloatWindowManager getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new FloatWindowManager();
      }
      FloatWindowManager localFloatWindowManager = instance;
      return localFloatWindowManager;
    }
    finally {}
  }
  
  private WindowManager.LayoutParams getLayoutParams()
  {
    return null;
  }
  
  private Handler getMsgHandler()
  {
    return null;
  }
  
  private WindowManager getWindowManager(Context paramContext)
  {
    return null;
  }
  
  private void init(Context paramContext, AppInfo paramAppInfo, int paramInt)
  {
    this.mContext = paramContext;
    this.createMode = paramInt;
    String str = "com.huawei.gamebox";
    if (paramContext != null)
    {
      ResourceLoaderUtil.setContext(paramContext);
      if ("com.huawei.gamebox".equals(this.mContext.getPackageName()))
      {
        paramContext = str;
        break label46;
      }
    }
    paramContext = "com.huawei.appmarket";
    label46:
    if (paramAppInfo != null)
    {
      this.appId = paramAppInfo.getAppId();
      this.cpId = paramAppInfo.getCpId();
      this.packageName = paramAppInfo.getPackageName();
      this.appInfo = paramAppInfo;
    }
    BuoyServiceApiClient.getInstance().setTargetApp(paramContext);
    BuoyServiceApiClient.getInstance().setShowBuoyApp(this.packageName);
  }
  
  /* Error */
  private void registerMultiWindowListener()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void removeView()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private void resetStatus(boolean paramBoolean)
  {
    this.isRemoteViewShow = paramBoolean;
    this.isNeedRed = -1;
  }
  
  /* Error */
  private void sendRedInfo(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private void setNeedRed(int paramInt)
  {
    this.isNeedRed = paramInt;
    showRedPoint();
  }
  
  /* Error */
  private void setRequestShow(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void showRedPoint()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void startShowSmallWindow()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void createSmallWindow(Context paramContext, AppInfo paramAppInfo, int paramInt)
  {
    init(paramContext, paramAppInfo, paramInt);
    createSmallWindow();
  }
  
  /* Error */
  public void finishBigBuoy(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void getBuoyRedInfo(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getXPosition()
  {
    return 0;
  }
  
  public int getYPosition()
  {
    return 0;
  }
  
  public boolean isAppAdaptNotchArea()
  {
    return this.isAppAdaptNotch;
  }
  
  public boolean isRemoteViewShow()
  {
    return this.isRemoteViewShow;
  }
  
  public boolean isRequestShow()
  {
    return false;
  }
  
  /* Error */
  public void onFinishBuoy(int arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  /* Error */
  public void openBigBuoy(Context arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void performDestroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void refreshSmallWindow(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void registerAutoHideSensorListener()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void removeSmallWindow()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void setSwitchGameAccountCallBack(ISwitchGameAccountCallBack paramISwitchGameAccountCallBack)
  {
    this.mSwitchCallBack = paramISwitchGameAccountCallBack;
  }
  
  /* Error */
  public void showSmallWindow()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private class FinishBuoyHandler
    implements SequentialTaskManager.RunTaskResultHandler
  {
    private FinishBuoyHandler() {}
    
    public void onResult(int paramInt, String paramString)
    {
      FloatWindowManager.this.onFinishBuoy(paramInt, paramString);
    }
  }
  
  private class ShowBuoyHandler
    implements SequentialTaskManager.RunTaskResultHandler
  {
    private ShowBuoyHandler() {}
    
    /* Error */
    public void onResult(int arg1, String arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\impl\manager\FloatWindowManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */