package com.huawei.hianalytics.f.h.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.huawei.hianalytics.f.g.d;
import com.huawei.hianalytics.f.g.g;
import com.huawei.hianalytics.i.a;

public class c
  implements a
{
  private Context a;
  private String b;
  
  public c(Context paramContext, String paramString)
  {
    this.a = paramContext;
    this.b = paramString;
  }
  
  private String a(Context paramContext)
  {
    return d.a(paramContext, "cached");
  }
  
  private String a(SharedPreferences paramSharedPreferences, String paramString)
  {
    return null;
  }
  
  private void a(Context paramContext, String paramString)
  {
    paramContext = g.b(paramContext, paramString).edit();
    paramContext.clear();
    paramContext.apply();
  }
  
  /* Error */
  private void a(b arg1, String arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void a(String arg1, String arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void b(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void c(Context paramContext)
  {
    d.b(paramContext, "cached");
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void run()
  {
    a();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\f\h\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */