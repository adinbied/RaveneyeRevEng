package com.huawei.hms.update.a;

import android.content.Context;
import com.huawei.hms.c.i;
import java.io.File;
import java.io.IOException;

public class h
  implements com.huawei.hms.update.a.a.a
{
  private final Context a;
  private final com.huawei.hms.update.b.d b = new com.huawei.hms.update.b.b();
  private com.huawei.hms.update.a.a.b c;
  private File d;
  private final a e = new a();
  
  public h(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }
  
  private b a(File paramFile, int paramInt, String paramString)
    throws IOException
  {
    return null;
  }
  
  /* Error */
  private void a(int arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: return
  }
  
  private void a(com.huawei.hms.update.a.a.b paramb)
  {
    try
    {
      this.c = paramb;
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  private static boolean a(String paramString, File paramFile)
  {
    paramFile = i.a(paramFile);
    return (paramFile != null) && (com.huawei.hms.c.d.b(paramFile, true).equalsIgnoreCase(paramString));
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
  public void a(com.huawei.hms.update.a.a.b arg1, com.huawei.hms.update.a.a.c arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  void a(com.huawei.hms.update.a.a.c arg1)
    throws com.huawei.hms.update.b.a
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public Context b()
  {
    return this.a;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hm\\update\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */