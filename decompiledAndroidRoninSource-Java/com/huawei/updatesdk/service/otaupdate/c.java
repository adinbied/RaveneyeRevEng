package com.huawei.updatesdk.service.otaupdate;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import com.huawei.updatesdk.sdk.service.storekit.bean.ResponseBean;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import java.util.List;

public class c
  extends AsyncTask<Void, Void, ResponseBean>
{
  private Context a;
  private CheckUpdateCallBack b;
  private boolean c = false;
  private boolean d = false;
  private String e = null;
  private String f = null;
  private Toast g;
  private boolean h = false;
  
  public c(Context paramContext, CheckUpdateCallBack paramCheckUpdateCallBack, boolean paramBoolean)
  {
    this.b = paramCheckUpdateCallBack;
    this.a = paramContext;
    this.d = paramBoolean;
  }
  
  private ResponseBean a(Context paramContext, String paramString)
  {
    return null;
  }
  
  private ApkUpgradeInfo a(String paramString, List<ApkUpgradeInfo> paramList)
  {
    return null;
  }
  
  private void a()
  {
    Toast localToast = this.g;
    if (localToast != null) {
      localToast.cancel();
    }
  }
  
  /* Error */
  private void a(Context arg1, ApkUpgradeInfo arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected ResponseBean a(Void... paramVarArgs)
  {
    return null;
  }
  
  /* Error */
  protected void a(ResponseBean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  /* Error */
  protected void onPreExecute()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\service\otaupdate\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */