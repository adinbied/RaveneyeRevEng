package com.huawei.appmarket.component.buoycircle.impl.update.manager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.huawei.appmarket.component.buoycircle.impl.delegete.BuoyBridgeActivity;
import com.huawei.appmarket.component.buoycircle.impl.log.BuoyLog;
import com.huawei.appmarket.component.buoycircle.impl.update.ui.UpdateBean;
import com.huawei.appmarket.component.buoycircle.impl.update.ui.delegate.AbsUpdateDelegate;
import com.huawei.appmarket.component.buoycircle.impl.utils.PackageManagerHelper;
import com.huawei.appmarket.component.buoycircle.impl.utils.PackageManagerHelper.PackageStates;
import java.util.ArrayList;

public class UpdateManager
{
  private static final String TAG = "UpdateManager";
  
  private static PackageManagerHelper.PackageStates getHiappStatus(Context paramContext)
  {
    return new PackageManagerHelper(paramContext).getPackageStates("com.huawei.appmarket");
  }
  
  private static boolean getSilentInstallSupport(Context paramContext)
  {
    return new PackageManagerHelper(paramContext).getPackageVersionCode("com.huawei.appmarket") >= 70203000L;
  }
  
  public static void startUpdate(Activity paramActivity, int paramInt, UpdateBean paramUpdateBean)
  {
    if (paramActivity != null)
    {
      if (paramUpdateBean == null) {
        return;
      }
      Object localObject = new ArrayList();
      PackageManagerHelper.PackageStates localPackageStates = getHiappStatus(paramActivity);
      if ((localPackageStates != PackageManagerHelper.PackageStates.NOT_INSTALLED) && (localPackageStates != PackageManagerHelper.PackageStates.DISABLED))
      {
        if (getSilentInstallSupport(paramActivity))
        {
          BuoyLog.i("UpdateManager", "current hiapp not support silent install");
          ((ArrayList)localObject).add(Integer.valueOf(0));
          ((ArrayList)localObject).add(Integer.valueOf(6));
        }
        else
        {
          BuoyLog.i("UpdateManager", "current hiapp support silent install");
          ((ArrayList)localObject).add(Integer.valueOf(5));
          ((ArrayList)localObject).add(Integer.valueOf(6));
        }
      }
      else {
        ((ArrayList)localObject).add(Integer.valueOf(6));
      }
      paramUpdateBean.setTypeList((ArrayList)localObject);
      localObject = BuoyBridgeActivity.getIntentStartBridgeActivity(paramActivity, AbsUpdateDelegate.getClassName(((Integer)((ArrayList)localObject).get(0)).intValue()));
      ((Intent)localObject).putExtra("intent.extra.update.info", paramUpdateBean);
      paramActivity.startActivityForResult((Intent)localObject, paramInt);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\update\manager\UpdateManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */