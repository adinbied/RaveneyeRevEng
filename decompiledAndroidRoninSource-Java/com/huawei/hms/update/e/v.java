package com.huawei.hms.update.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hms.c.g;
import com.huawei.hms.update.a.a.b;
import com.huawei.hms.update.a.a.c;
import com.huawei.hms.update.provider.UpdateProvider;
import java.io.File;

public class v
  extends a
  implements b
{
  private com.huawei.hms.update.a.a.a k;
  private c l;
  private int m = 0;
  
  private static Uri a(Context paramContext, File paramFile)
  {
    g localg = new g(paramContext);
    String str = paramContext.getPackageName();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(".hms.update.provider");
    localObject = ((StringBuilder)localObject).toString();
    int j = Build.VERSION.SDK_INT;
    int i = 1;
    if ((j <= 23) || ((paramContext.getApplicationInfo().targetSdkVersion <= 23) && (!localg.a(str, (String)localObject)))) {
      i = 0;
    }
    if (i != 0) {
      return UpdateProvider.getUriForFile(paramContext, (String)localObject, paramFile);
    }
    return Uri.fromFile(paramFile);
  }
  
  /* Error */
  private void a(Intent arg1, b arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void a(b arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static void a(b paramb, int paramInt, c paramc)
  {
    if (paramb != null) {
      new Handler(Looper.getMainLooper()).post(new x(paramb, paramInt, paramc));
    }
  }
  
  /* Error */
  private void a(File arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(int arg1, int arg2, int arg3, File arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: goto -3 -> 0
  }
  
  /* Error */
  public void a(int arg1, c arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(b arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void a(Class<? extends b> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void b(b arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int c()
  {
    return 2006;
  }
  
  void d()
  {
    b(13, this.f);
  }
  
  public void onBridgeActivityCreate(Activity paramActivity)
  {
    super.onBridgeActivityCreate(paramActivity);
    if (this.c == null) {
      return;
    }
    this.f = 6;
    if ((this.c.g()) && (!TextUtils.isEmpty(this.h)))
    {
      a(m.class);
      return;
    }
    a(d.class);
    a(this);
  }
  
  public void onBridgeActivityDestroy()
  {
    g();
    super.onBridgeActivityDestroy();
  }
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    return false;
  }
  
  /* Error */
  public void onKeyUp(int arg1, android.view.KeyEvent arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hm\\update\e\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */