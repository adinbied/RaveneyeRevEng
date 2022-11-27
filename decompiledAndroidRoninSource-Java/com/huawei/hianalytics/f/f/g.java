package com.huawei.hianalytics.f.f;

import android.content.Context;
import com.huawei.hianalytics.f.c.a;
import com.huawei.hianalytics.f.g.j;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

public class g
{
  private static g a;
  private static Map<String, Long> d = new HashMap();
  private Context b;
  private a c = new a();
  private long e = 0L;
  
  public static g a()
  {
    return e();
  }
  
  private static void a(String paramString1, Context paramContext, String paramString2, long paramLong, LinkedHashMap<String, String> paramLinkedHashMap, String paramString3, String paramString4)
  {
    j.a(new c(paramContext, paramString1, paramString3, j.a(paramString2, paramLong, paramLinkedHashMap, paramString4).toString(), System.currentTimeMillis()));
  }
  
  private static void a(String paramString1, Context paramContext, String paramString2, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    long l2 = System.currentTimeMillis();
    long l1;
    if (d.containsKey(paramString1)) {
      l1 = ((Long)d.get(paramString1)).longValue();
    } else {
      l1 = 0L;
    }
    if (l1 == 0L) {
      l1 = 0L;
    } else {
      l1 = l2 - l1;
    }
    a(paramString1, paramContext, paramString2, l1, paramLinkedHashMap, "$AppOnPause", "OnPause");
  }
  
  private static g e()
  {
    try
    {
      if (a == null) {
        a = new g();
      }
      g localg = a;
      return localg;
    }
    finally {}
  }
  
  /* Error */
  public void a(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(String arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(String arg1, int arg2, String arg3, LinkedHashMap<String, String> arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(String arg1, Context arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(String arg1, Context arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(String arg1, Context arg2, LinkedHashMap<String, String> arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(String arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(String arg1, String arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void a(String arg1, String arg2, LinkedHashMap<String, String> arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public a b()
  {
    return this.c;
  }
  
  /* Error */
  public void b(String arg1, int arg2, String arg3, LinkedHashMap<String, String> arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void b(String arg1, Context arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void b(String arg1, Context arg2, LinkedHashMap<String, String> arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void b(String arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void b(String arg1, String arg2, LinkedHashMap<String, String> arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Context c()
  {
    return this.b;
  }
  
  /* Error */
  public void c(String arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\f\f\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */