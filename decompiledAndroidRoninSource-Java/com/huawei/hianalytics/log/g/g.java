package com.huawei.hianalytics.log.g;

import android.content.Context;
import com.huawei.hianalytics.log.b.a.a;

public class g
  implements e
{
  private Context a;
  private String b;
  private String c;
  private String d;
  private String e;
  
  public g(Context paramContext, String paramString1, String paramString2)
  {
    this.a = paramContext;
    this.e = paramString1;
    paramContext = new StringBuilder();
    paramContext.append(paramString2);
    paramContext.append(a.a.c);
    this.b = paramContext.toString();
    paramContext = new StringBuilder();
    paramContext.append(paramString2);
    paramContext.append(a.a.d);
    this.c = paramContext.toString();
    paramContext = new StringBuilder();
    paramContext.append(paramString2);
    paramContext.append(a.a.a);
    this.d = paramContext.toString();
  }
  
  private boolean a(String paramString)
  {
    return false;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\log\g\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */