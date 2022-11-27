package com.huawei.hms.update.e;

import android.app.AlertDialog;
import com.huawei.hms.c.h;

public final class e
{
  private static abstract class a
    extends b
  {
    public AlertDialog a()
    {
      return null;
    }
    
    protected abstract int h();
    
    protected abstract int i();
    
    protected abstract int j();
  }
  
  public static class b
    extends e.a
  {
    public b()
    {
      super();
    }
    
    protected int h()
    {
      return h.c("hms_download_retry");
    }
    
    protected int i()
    {
      return h.c("hms_retry");
    }
    
    protected int j()
    {
      return h.c("hms_cancel");
    }
  }
  
  public static class c
    extends e.a
  {
    public c()
    {
      super();
    }
    
    protected int h()
    {
      return h.c("hms_abort_message");
    }
    
    protected int i()
    {
      return h.c("hms_abort");
    }
    
    protected int j()
    {
      return h.c("hms_cancel");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hm\\update\e\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */