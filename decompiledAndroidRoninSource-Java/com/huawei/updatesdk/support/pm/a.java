package com.huawei.updatesdk.support.pm;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import java.io.File;

public class a
{
  private static void a()
  {
    g.a(4, 55534);
  }
  
  protected static void a(Context paramContext, b paramb)
  {
    b(paramContext, paramb);
  }
  
  private static void b(Context paramContext, b paramb)
  {
    if (paramb == null)
    {
      com.huawei.updatesdk.sdk.a.c.a.a.a.d("InstallProcess", "system install failed,task is null");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("systemInstall begin!!!task:");
    ((StringBuilder)localObject).append(paramb.toString());
    com.huawei.updatesdk.sdk.a.c.a.a.a.a("InstallProcess", ((StringBuilder)localObject).toString());
    paramb.a(c.a.a);
    g.a(3, 1);
    localObject = new File(paramb.f());
    if ((((File)localObject).exists()) && (((File)localObject).isFile()) && (((File)localObject).length() > 0L))
    {
      localObject = new Intent(paramContext, PackageInstallerActivity.class);
      ((Intent)localObject).putExtra("install_path", paramb.f());
      ((Intent)localObject).putExtra("install_packagename", paramb.e());
      ((Intent)localObject).putExtra("install_change_path_times", paramb.h());
      if (!(paramContext instanceof Activity)) {
        ((Intent)localObject).setFlags(402653184);
      }
      try
      {
        paramContext.startActivity((Intent)localObject);
        return;
      }
      catch (ActivityNotFoundException paramContext)
      {
        a();
        com.huawei.updatesdk.sdk.a.c.a.a.a.a("InstallProcess", " can not start install !", paramContext);
        return;
      }
    }
    paramContext = new StringBuilder();
    paramContext.append("system install failed,file not existed filePath:");
    paramContext.append(paramb.f());
    com.huawei.updatesdk.sdk.a.c.a.a.a.d("InstallProcess", paramContext.toString());
    g.a(4, 55533);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\support\pm\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */