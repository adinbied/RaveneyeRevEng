package com.huawei.hms.support.log;

import android.content.Context;
import com.huawei.hms.support.log.b.a;

public class b
{
  private static final c a = new a();
  private int b = 4;
  private String c;
  
  private d b(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    return null;
  }
  
  /* Error */
  public void a(int arg1, String arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(int arg1, String arg2, String arg3, Throwable arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void a(Context paramContext, int paramInt, String paramString)
  {
    this.b = paramInt;
    this.c = paramString;
    a.a(paramContext, "HMSCore");
  }
  
  /* Error */
  public void a(String arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean a(int paramInt)
  {
    return paramInt >= this.b;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\log\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */