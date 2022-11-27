package com.huawei.hianalytics.f.f;

import android.content.Context;
import com.huawei.hianalytics.f.e.b;

public class c
  implements f
{
  private String a;
  private String b;
  private String c = "oper";
  private long d;
  private String e;
  private Context f;
  private String g;
  private Boolean h;
  
  public c(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    this.f = paramContext.getApplicationContext();
    this.e = paramString1;
    this.a = paramString2;
    this.b = paramString3;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          this.c = "oper";
          if (!com.huawei.hianalytics.a.a.e(paramString1, "oper")) {
            break label117;
          }
          paramContext = com.huawei.hianalytics.f.e.a.a().a(paramString1, paramLong);
          this.g = paramContext.a();
          this.h = Boolean.valueOf(paramContext.b());
          break label117;
        }
        paramContext = "diffprivacy";
      }
      else
      {
        paramContext = "preins";
      }
    }
    else {
      paramContext = "maint";
    }
    this.c = paramContext;
    label117:
    this.d = paramLong;
  }
  
  public c(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong)
  {
    this.f = paramContext.getApplicationContext();
    this.e = paramString1;
    this.a = paramString2;
    this.b = paramString3;
    this.c = "oper";
    this.d = paramLong;
    if (com.huawei.hianalytics.a.a.e(paramString1, "oper"))
    {
      paramContext = com.huawei.hianalytics.f.e.a.a().a(paramString1, paramLong);
      this.g = paramContext.a();
      this.h = Boolean.valueOf(paramContext.b());
    }
  }
  
  /* Error */
  private void a()
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\f\f\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */