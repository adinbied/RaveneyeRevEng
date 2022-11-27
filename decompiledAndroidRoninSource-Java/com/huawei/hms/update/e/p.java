package com.huawei.hms.update.e;

import android.app.AlertDialog;
import com.huawei.hms.c.h;

public final class p
{
  private static abstract class a
    extends b
  {
    public AlertDialog a()
    {
      return null;
    }
    
    protected abstract int h();
    
    protected int i()
    {
      return h.c("hms_confirm");
    }
  }
  
  public static class b
    extends p.a
  {
    public b()
    {
      super();
    }
    
    protected int h()
    {
      return h.c("hms_check_failure");
    }
  }
  
  public static class c
    extends p.a
  {
    public c()
    {
      super();
    }
    
    protected int h()
    {
      return h.c("hms_download_failure");
    }
  }
  
  public static class d
    extends p.a
  {
    public d()
    {
      super();
    }
    
    protected int h()
    {
      return h.c("hms_download_no_space");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hm\\update\e\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */