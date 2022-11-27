package com.huawei.hms.update.a;

import java.io.File;

class i
  extends b
{
  private long d = 0L;
  private int e = h.a(this.c).b();
  
  i(h paramh, File paramFile, int paramInt1, int paramInt2, String paramString)
  {
    super(paramFile, paramInt1);
  }
  
  /* Error */
  private void a(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void write(byte[] arg1, int arg2, int arg3)
    throws java.io.IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hm\\update\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */