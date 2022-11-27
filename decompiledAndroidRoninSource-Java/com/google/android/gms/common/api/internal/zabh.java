package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.util.concurrent.NumberedThreadFactory;
import com.google.android.gms.internal.base.zal;
import com.google.android.gms.internal.base.zam;
import java.util.concurrent.ExecutorService;

public final class zabh
{
  private static final ExecutorService zahw = zam.zacv().zaa(2, new NumberedThreadFactory("GAC_Executor"), 9);
  
  public static ExecutorService zabb()
  {
    return zahw;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zabh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */