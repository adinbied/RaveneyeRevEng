package com.huawei.appmarket.component.buoycircle.impl.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.huawei.appmarket.component.buoycircle.api.AppInfo;
import com.huawei.appmarket.component.buoycircle.impl.bi.BuoyAnalyticHelper;
import com.huawei.appmarket.component.buoycircle.impl.manager.BuoyAutoHideSensorManager;
import com.huawei.appmarket.component.buoycircle.impl.manager.BuoyHideCacheManager;
import com.huawei.appmarket.component.buoycircle.impl.manager.FloatWindowManager;
import com.huawei.appmarket.component.buoycircle.impl.storage.BuoyStorage;
import com.huawei.appmarket.component.buoycircle.impl.utils.ActivityUtil;
import com.huawei.appmarket.component.buoycircle.impl.utils.ResourceLoaderUtil;

public class BuoyHideGuideDialog
{
  protected static int getDialogThemeId(Context paramContext)
  {
    if ((getThemeEmui(paramContext) != 0) && (Build.VERSION.SDK_INT >= 16)) {
      return 0;
    }
    return 16974394;
  }
  
  public static AlertDialog getGuideDialog(final Context paramContext, final AppInfo paramAppInfo, boolean paramBoolean)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramContext, getDialogThemeId(paramContext));
    localBuilder.setTitle(ResourceLoaderUtil.getStringId("c_buoycircle_hide_guide_title"));
    View localView = View.inflate(paramContext, ResourceLoaderUtil.getLayoutId("c_buoycircle_hide_guide_dialog"), null);
    if (paramBoolean)
    {
      ((TextView)localView.findViewById(ResourceLoaderUtil.getIdId("game_id_buoy_hide_guide_text"))).setText(ResourceLoaderUtil.getString("c_buoycircle_hide_guide_content_sensor"));
    }
    else
    {
      TextView localTextView = (TextView)localView.findViewById(ResourceLoaderUtil.getIdId("game_id_buoy_hide_guide_text"));
      localTextView.setText(ResourceLoaderUtil.getString("c_buoycircle_hide_guide_content_nosensor"));
      localTextView.setPadding(0, 0, 0, ActivityUtil.dp2Px(paramContext, 16.0F));
      localView.findViewById(ResourceLoaderUtil.getIdId("game_id_buoy_hide_guide_gif")).setVisibility(8);
    }
    localBuilder.setView(localView);
    localBuilder.setPositiveButton(ResourceLoaderUtil.getStringId("c_buoycircle_hide_guide_btn_confirm"), new DialogInterface.OnClickListener()
    {
      /* Error */
      public void onClick(DialogInterface arg1, int arg2)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    });
    localBuilder.setNegativeButton(ResourceLoaderUtil.getStringId("c_buoycircle_hide_guide_btn_cancel"), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        BuoyHideGuideDialog.handleCancelHide(this.val$context);
      }
    });
    localBuilder.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        BuoyHideGuideDialog.handleCancelHide(this.val$context);
      }
    });
    paramContext = localBuilder.create();
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    return paramContext;
  }
  
  private static int getThemeEmui(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    return paramContext.getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
  }
  
  private static void handleCancelHide(Context paramContext)
  {
    FloatWindowManager.getInstance().refreshSmallWindow(true);
    BuoyAutoHideSensorManager.getInstance().unRegisterSensor();
    if (((paramContext instanceof Activity)) && (!"com.huawei.gamebox".equals(paramContext.getPackageName()))) {
      ((Activity)paramContext).finish();
    }
  }
  
  private static void handleConfirmHide(View paramView, Context paramContext, AppInfo paramAppInfo)
  {
    if (((CheckBox)paramView.findViewById(ResourceLoaderUtil.getIdId("game_id_buoy_hide_guide_remind"))).isChecked()) {
      BuoyStorage.getInstance().saveHideGuideRecord(paramContext);
    }
    BuoyHideCacheManager.getInstance().saveHideBuoyEvent(paramContext, paramAppInfo, 2);
    if (paramAppInfo != null) {
      BuoyAnalyticHelper.getInstance().onReportHideSmallBuoy(paramContext, paramAppInfo);
    }
    if (((paramContext instanceof Activity)) && (!"com.huawei.gamebox".equals(paramContext.getPackageName()))) {
      ((Activity)paramContext).finish();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\impl\view\BuoyHideGuideDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */