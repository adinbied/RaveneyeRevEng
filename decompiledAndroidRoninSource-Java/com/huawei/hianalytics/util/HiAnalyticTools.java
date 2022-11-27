package com.huawei.hianalytics.util;

import android.content.Context;
import com.huawei.hianalytics.g.b;

public abstract class HiAnalyticTools
{
  public static void enableLog(Context paramContext)
  {
    enableLog(paramContext, 4);
  }
  
  public static void enableLog(Context paramContext, int paramInt)
  {
    b.a(paramContext, paramInt, "hianalytics");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytic\\util\HiAnalyticTools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */