package com.huawei.appmarket.component.buoycircle.impl.update.ui.delegate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.appmarket.component.buoycircle.impl.update.download.api.IOtaUpdate;
import com.huawei.appmarket.component.buoycircle.impl.update.download.api.IUpdateCallback;
import com.huawei.appmarket.component.buoycircle.impl.update.download.api.UpdateInfo;
import com.huawei.appmarket.component.buoycircle.impl.update.provider.UpdateProvider;
import com.huawei.appmarket.component.buoycircle.impl.update.ui.UpdateBean;
import com.huawei.appmarket.component.buoycircle.impl.update.ui.dialog.CheckUpdateDialog;
import com.huawei.appmarket.component.buoycircle.impl.update.ui.dialog.InstallConfirmDialog;
import com.huawei.appmarket.component.buoycircle.impl.utils.PackageManagerHelper;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;
import java.io.File;

public class OtaUpdateDelegate
  extends AbsUpdateDelegate
  implements IUpdateCallback
{
  private static final String TAG = "BuoyUpdateDelegate";
  private int mCurProgress = 0;
  private IOtaUpdate mUpdate;
  private UpdateInfo mUpdateInfo;
  
  /* Error */
  private void cancelUpdate()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static void checkCallback(IUpdateCallback paramIUpdateCallback, final int paramInt, final UpdateInfo paramUpdateInfo)
  {
    if (paramIUpdateCallback != null) {
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        /* Error */
        public void run()
        {
          // Byte code:
          //   0: return
          //   1: astore_1
          //   2: goto -2 -> 0
        }
      });
    }
  }
  
  /* Error */
  private void checkUpdate(IUpdateCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static Uri contentUriFromFile(Context paramContext, File paramFile)
  {
    PackageManagerHelper localPackageManagerHelper = new PackageManagerHelper(paramContext);
    String str = paramContext.getPackageName();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(".hms.update.provider");
    localObject = ((StringBuilder)localObject).toString();
    int j = Build.VERSION.SDK_INT;
    int i = 1;
    if ((j <= 23) || ((paramContext.getApplicationInfo().targetSdkVersion <= 23) && (!localPackageManagerHelper.hasProvider(str, (String)localObject)))) {
      i = 0;
    }
    if (i != 0) {
      return UpdateProvider.getUriForFile(paramContext, (String)localObject, paramFile);
    }
    return Uri.fromFile(paramFile);
  }
  
  /* Error */
  private void downloadFaild()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void downloadPackage()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void startInstaller(File arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public int getRequestCode()
  {
    return 2006;
  }
  
  public void onBridgeActivityCreate(Activity paramActivity)
  {
    super.onBridgeActivityCreate(paramActivity);
    if (this.bean == null) {
      return;
    }
    this.updateType = 6;
    if ((this.bean.isNeedConfirm()) && (!TextUtils.isEmpty(this.mClientAppName)))
    {
      showDialog(InstallConfirmDialog.class);
      return;
    }
    showDialog(CheckUpdateDialog.class);
    checkUpdate(this);
  }
  
  public void onBridgeActivityDestroy()
  {
    cancelUpdate();
    super.onBridgeActivityDestroy();
  }
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    return false;
  }
  
  /* Error */
  public void onCancel(com.huawei.appmarket.component.buoycircle.impl.update.ui.dialog.AbstractDialog arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onCheckUpdate(int arg1, UpdateInfo arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onDoWork(com.huawei.appmarket.component.buoycircle.impl.update.ui.dialog.AbstractDialog arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onDownloadPackage(int arg1, int arg2, int arg3, File arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: goto -3 -> 0
  }
  
  /* Error */
  public void onKeyUp(int arg1, android.view.KeyEvent arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void showDialog(Class<? extends com.huawei.appmarket.component.buoycircle.impl.update.ui.dialog.AbstractDialog> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  void userCancelUpdate()
  {
    finishBridgeActivity(13, this.updateType);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\updat\\ui\delegate\OtaUpdateDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */