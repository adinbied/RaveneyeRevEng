package com.huawei.appmarket.component.buoycircle.impl.update.ui.delegate;

import android.app.Activity;
import com.huawei.appmarket.component.buoycircle.impl.delegete.IBridgeActivityDelegate;
import com.huawei.appmarket.component.buoycircle.impl.update.ui.UpdateBean;
import com.huawei.appmarket.component.buoycircle.impl.update.ui.dialog.AbstractDialog;
import java.lang.ref.WeakReference;

public abstract class AbsUpdateDelegate
  implements IBridgeActivityDelegate
{
  protected static final int HIAPP_DL_REQUEST_CODE = 2006;
  protected static final int HIAPP_REQUEST_CODE = 2005;
  public static final int RESULT_CANCELED = 13;
  public static final int RESULT_FAILURE = 8;
  public static final int RESULT_SUCCESS = 0;
  public static final int RESULT_TIMEOUT = 14;
  protected static final int SILENT_DOWNLOAD_REQUEST_CODE = 2000;
  private static final String TAG = "AbsUpdateDelegate";
  protected UpdateBean bean = null;
  public IBridgeActivityDelegate mBridgeActivityDelegate;
  protected String mClientAppId = null;
  protected String mClientAppName = null;
  protected int mClientVersionCode = 0;
  protected AbstractDialog mLatestDialog = null;
  protected String mPackageName = null;
  public WeakReference<Activity> mThisWeakRef;
  protected boolean needTransfer = false;
  private String sdkVersionCode;
  protected int updateType = -1;
  
  private String dealUpdateResult(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  /* Error */
  private void getBridgeActivityDelegate(java.util.ArrayList arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static String getClassName(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 5)
      {
        if (paramInt != 6) {
          return "";
        }
        return OtaUpdateDelegate.class.getName();
      }
      return HiAppUpdateDelegate.class.getName();
    }
    return SilentUpdateDelegate.class.getName();
  }
  
  /* Error */
  protected void biReportEvent(int arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void dismissDialog()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  protected void finishBridgeActivity(int arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public Activity getActivity()
  {
    return null;
  }
  
  protected boolean isUpdated(String paramString, int paramInt)
  {
    return false;
  }
  
  /* Error */
  public void onBridgeActivityCreate(Activity arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onBridgeActivityDestroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onBridgeConfigurationChanged()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onCancel(AbstractDialog paramAbstractDialog) {}
  
  public void onDoWork(AbstractDialog paramAbstractDialog) {}
  
  /* Error */
  public void onKeyUp(int arg1, android.view.KeyEvent arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  abstract void showDialog(Class<? extends AbstractDialog> paramClass);
  
  protected boolean startNextWizard(boolean paramBoolean)
  {
    return false;
  }
  
  abstract void userCancelUpdate();
  
  public static abstract interface UpdateType
  {
    public static final int HIAPP = 5;
    public static final int HIAPP_DL = 6;
    public static final int HIAPP_WAP = 4;
    public static final int INIT = -1;
    public static final int SILENT = 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\updat\\ui\delegate\AbsUpdateDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */