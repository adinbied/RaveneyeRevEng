package com.huawei.hianalytics.log.g;

import android.content.Context;
import com.huawei.hianalytics.b.a;
import com.huawei.hianalytics.b.b;

public class c
  implements b
{
  private static c a;
  private Context b;
  
  public c(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public static c a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new c(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public void a()
  {
    a.a().b();
  }
  
  /* Error */
  public void a(org.json.JSONObject arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void a(String[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\log\g\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */