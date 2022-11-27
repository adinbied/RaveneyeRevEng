package com.huawei.hianalytics.f.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.huawei.hianalytics.f.g.g;
import java.util.UUID;

public class j
  implements com.huawei.hianalytics.i.a
{
  private Context a;
  
  public j(Context paramContext)
  {
    this.a = paramContext;
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static void a(Context paramContext)
  {
    paramContext = com.huawei.hianalytics.util.d.a(paramContext, "global_v2");
    String str = (String)com.huawei.hianalytics.util.d.b(paramContext, "uuid", "");
    if (TextUtils.isEmpty(str))
    {
      str = UUID.randomUUID().toString().replace("-", "");
      com.huawei.hianalytics.e.a.a().f().j(str);
      paramContext.edit().putString("uuid", str).apply();
    }
    else
    {
      com.huawei.hianalytics.e.a.a().f().j(str);
    }
    str = (String)com.huawei.hianalytics.util.d.b(paramContext, "upload_url", "");
    long l1 = ((Long)com.huawei.hianalytics.util.d.b(paramContext, "upload_url_time", Long.valueOf(0L))).longValue();
    long l2 = System.currentTimeMillis();
    boolean bool;
    if ((!TextUtils.isEmpty(str)) && (l2 - l1 <= 86400000L))
    {
      com.huawei.hianalytics.e.a.a().f().m(str);
      paramContext = com.huawei.hianalytics.e.a.a().f();
      bool = false;
    }
    else
    {
      paramContext = com.huawei.hianalytics.e.a.a().f();
      bool = true;
    }
    paramContext.a(bool);
  }
  
  private void a(Context paramContext, String paramString)
  {
    paramContext = g.b(paramContext, paramString).edit();
    paramContext.clear();
    paramContext.apply();
  }
  
  /* Error */
  private void a(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private void a(String paramString1, String paramString2)
  {
    b(paramString1);
    a(paramString2);
  }
  
  /* Error */
  private void a(org.json.JSONArray arg1)
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
  
  /* Error */
  private void b(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\f\f\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */