package com.huawei.android.hms.agent.common;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

public final class UIUtils
{
  public static boolean isActivityFullscreen(Activity paramActivity)
  {
    return (paramActivity.getWindow().getAttributes().flags & 0x400) == 1024;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\android\hms\agent\common\UIUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */