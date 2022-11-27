package com.huawei.hms.update.a;

import android.content.Context;

class a
{
  private String a;
  private int b;
  private String c;
  private int d;
  
  /* Error */
  private void b(Context arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int a()
  {
    return this.b;
  }
  
  public void a(Context paramContext, int paramInt, String paramString)
  {
    this.d = paramInt;
    b(paramContext, paramString);
  }
  
  /* Error */
  public void a(Context arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    this.a = paramString1;
    this.b = paramInt;
    this.c = paramString2;
    this.d = 0;
  }
  
  int b()
  {
    return this.d;
  }
  
  public boolean b(String paramString1, int paramInt, String paramString2)
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hm\\update\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */