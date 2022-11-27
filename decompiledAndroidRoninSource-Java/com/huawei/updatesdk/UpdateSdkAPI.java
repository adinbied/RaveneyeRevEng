package com.huawei.updatesdk;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;
import com.huawei.updatesdk.service.otaupdate.e;
import com.huawei.updatesdk.service.otaupdate.e.b;
import com.huawei.updatesdk.support.e.d;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class UpdateSdkAPI
{
  public static final String TAG = "UpdateSdk";
  
  public static void checkAppUpdate(Context paramContext, final CheckUpdateCallBack paramCheckUpdateCallBack, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    if (paramContext == null) {
      return;
    }
    if (com.huawei.updatesdk.sdk.a.d.c.b.a(paramContext))
    {
      init(paramContext);
      new e(paramContext, new e.b()
      {
        /* Error */
        public void a()
        {
          // Byte code:
          //   0: return
          //   1: astore_1
          //   2: goto -2 -> 0
        }
      });
      return;
    }
    if (paramCheckUpdateCallBack != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("status", 2);
      paramCheckUpdateCallBack.onUpdateInfo(localIntent);
    }
    Toast.makeText(paramContext, d.b(paramContext, "upsdk_no_available_network_prompt_toast"), 0).show();
  }
  
  public static void checkClientOTAUpdate(Context paramContext, final CheckUpdateCallBack paramCheckUpdateCallBack, final boolean paramBoolean1, int paramInt, final boolean paramBoolean2)
  {
    if (paramContext != null)
    {
      if (!com.huawei.updatesdk.sdk.a.d.c.b.a(paramContext)) {
        return;
      }
      init(paramContext);
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.US);
      long l1 = 0L;
      try
      {
        l2 = Long.parseLong(localSimpleDateFormat.format(new Date()));
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("get date error: ");
        localStringBuilder.append(localNumberFormatException.toString());
        com.huawei.updatesdk.sdk.a.c.a.a.a.d("UpdateSdk", localStringBuilder.toString());
      }
      long l2 = com.huawei.updatesdk.service.a.b.a().d();
      if ((paramInt == 0) || (Math.abs(l1 - l2) >= paramInt))
      {
        com.huawei.updatesdk.service.a.b.a().a(l1);
        new e(paramContext, new e.b()
        {
          /* Error */
          public void a()
          {
            // Byte code:
            //   0: return
            //   1: astore_1
            //   2: goto -2 -> 0
          }
        });
      }
    }
  }
  
  public static void checkTargetAppUpdate(Context paramContext, final String paramString, final CheckUpdateCallBack paramCheckUpdateCallBack)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (com.huawei.updatesdk.sdk.a.d.c.b.a(paramContext))
      {
        init(paramContext);
        new e(paramContext, new e.b()
        {
          /* Error */
          public void a()
          {
            // Byte code:
            //   0: return
            //   1: astore_1
            //   2: goto -2 -> 0
          }
        });
        return;
      }
      if (paramCheckUpdateCallBack != null)
      {
        paramContext = new Intent();
        paramContext.putExtra("status", 2);
        paramCheckUpdateCallBack.onUpdateInfo(paramContext);
      }
      return;
    }
    if (paramCheckUpdateCallBack != null)
    {
      paramContext = new Intent();
      paramContext.putExtra("status", 1);
      paramCheckUpdateCallBack.onUpdateInfo(paramContext);
    }
  }
  
  private static void init(Context paramContext)
  {
    com.huawei.updatesdk.sdk.service.a.a.a(paramContext);
    com.huawei.updatesdk.sdk.a.d.b.a.a(paramContext);
    com.huawei.updatesdk.service.b.a.a.a();
  }
  
  public static void releaseCallBack()
  {
    com.huawei.updatesdk.service.otaupdate.b.a().a(null);
  }
  
  public static void showUpdateDialog(Context paramContext, ApkUpgradeInfo paramApkUpgradeInfo, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      if (paramApkUpgradeInfo == null) {
        return;
      }
      Intent localIntent = new Intent(paramContext, AppUpdateActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("app_update_parm", paramApkUpgradeInfo);
      localBundle.putSerializable("app_must_btn", Boolean.valueOf(paramBoolean));
      localIntent.putExtras(localBundle);
      if (!(paramContext instanceof Activity)) {
        localIntent.setFlags(268435456);
      }
      try
      {
        paramContext.startActivity(localIntent);
        return;
      }
      catch (ActivityNotFoundException paramContext)
      {
        paramApkUpgradeInfo = new StringBuilder();
        paramApkUpgradeInfo.append("go AppUpdateActivity error: ");
        paramApkUpgradeInfo.append(paramContext.toString());
        Log.e("UpdateSdk", paramApkUpgradeInfo.toString());
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\UpdateSdkAPI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */