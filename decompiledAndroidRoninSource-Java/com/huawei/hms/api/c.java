package com.huawei.hms.api;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

class c
{
  static final c a = new c();
  List<Activity> b = new ArrayList(1);
  
  /* Error */
  void a(Activity arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  void b(Activity paramActivity)
  {
    this.b.remove(paramActivity);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\api\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */