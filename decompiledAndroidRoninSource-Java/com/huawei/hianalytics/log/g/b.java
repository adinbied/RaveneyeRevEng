package com.huawei.hianalytics.log.g;

import android.os.Handler;
import com.huawei.hianalytics.log.b.a.a;

public class b
  implements e
{
  private String a;
  private String b;
  private String c;
  private Handler d;
  
  public b(String paramString1, Handler paramHandler, String paramString2)
  {
    this.a = paramString1;
    this.d = paramHandler;
    paramString1 = new StringBuilder();
    paramString1.append(paramString2);
    paramString1.append(a.a.b);
    this.b = paramString1.toString();
    paramString1 = new StringBuilder();
    paramString1.append(paramString2);
    paramString1.append(a.a.c);
    this.c = paramString1.toString();
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\log\g\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */