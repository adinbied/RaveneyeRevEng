package com.huawei.hms.support.api.game.d;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.huawei.hms.support.log.a;
import java.lang.reflect.Field;

public class f
{
  private static int a = -1;
  
  public static int a(Context paramContext)
  {
    if (a == -1) {
      try
      {
        Class localClass = Class.forName("com.android.internal.R$dimen");
        Object localObject = localClass.newInstance();
        int i = ((Integer)localClass.getField("status_bar_height").get(localObject)).intValue();
        a = paramContext.getResources().getDimensionPixelSize(i);
      }
      catch (Exception paramContext)
      {
        a = 0;
        a.a("WindowUtil", "getStatusBarHeight Exception", paramContext);
      }
      catch (NoSuchFieldException paramContext)
      {
        a = 0;
        a.a("WindowUtil", "getStatusBarHeight NoSuchFieldException", paramContext);
      }
      catch (IllegalAccessException paramContext)
      {
        a = 0;
        a.a("WindowUtil", "getStatusBarHeight IllegalAccessException", paramContext);
      }
      catch (InstantiationException paramContext)
      {
        a = 0;
        a.a("WindowUtil", "getStatusBarHeight InstantiationException", paramContext);
      }
      catch (ClassNotFoundException paramContext)
      {
        a = 0;
        a.a("WindowUtil", "getStatusBarHeight ClassNotFoundException", paramContext);
      }
    }
    return a;
  }
  
  public static void a(Activity paramActivity)
  {
    if ((paramActivity.getWindow().getAttributes().flags & 0x400) == 1024)
    {
      a = 0;
      return;
    }
    a = -1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\game\d\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */