package com.huawei.hms.support.api.game.a;

import android.app.Activity;
import com.huawei.appmarket.component.buoycircle.api.AppInfo;
import com.huawei.appmarket.component.buoycircle.api.AppInfo.Builder;
import com.huawei.appmarket.component.buoycircle.api.IBuoyBIHandler;
import com.huawei.appmarket.component.buoycircle.api.ISwitchGameAccountCallBack;
import com.huawei.appmarket.component.buoycircle.impl.manager.BuoyCircleManager;

public class a
{
  private static a a;
  private AppInfo b;
  private Activity c;
  private boolean d = false;
  
  public static a a()
  {
    try
    {
      if (a == null) {
        a = new a();
      }
      a locala = a;
      return locala;
    }
    finally {}
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    this.c = paramActivity;
    this.b = new AppInfo.Builder().setAppId(paramString1).setPackageName(paramString3).setCpId(paramString2).setSdkVersionCode(String.valueOf(20603301)).build();
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void b(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    a(paramActivity, paramString1, paramString2, paramString3);
    c();
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void d()
  {
    BuoyCircleManager.getInstance().removeBuoyCircle();
  }
  
  private class a
    implements IBuoyBIHandler
  {
    private a() {}
    
    public String getPlayerId(String paramString)
    {
      return null;
    }
    
    /* Error */
    public void onBIReport(String arg1, String arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  private static class b
    implements ISwitchGameAccountCallBack
  {
    /* Error */
    public void notifySwitchGameAccount()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\game\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */