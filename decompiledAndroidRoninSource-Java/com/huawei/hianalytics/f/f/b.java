package com.huawei.hianalytics.f.f;

import android.content.Context;
import com.huawei.hianalytics.b.a;

public class b
  implements com.huawei.hianalytics.b.b
{
  private static b b;
  private Context a;
  
  public b(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public static b a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new b(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(org.json.JSONObject arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void b()
  {
    a.a().c();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\f\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */