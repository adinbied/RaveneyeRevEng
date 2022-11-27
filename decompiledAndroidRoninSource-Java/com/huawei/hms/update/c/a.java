package com.huawei.hms.update.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.c.g;
import com.huawei.hms.c.g.a;
import com.huawei.hms.update.e.u;
import java.util.ArrayList;

public class a
{
  public static void a(Activity paramActivity, int paramInt, u paramu)
  {
    if (paramActivity != null)
    {
      if (paramu == null) {
        return;
      }
      Object localObject = new ArrayList();
      g.a locala = b(paramActivity);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("in startUpdate: states is ");
      localStringBuilder.append(locala);
      com.huawei.hms.support.log.a.b("UpdateManager", localStringBuilder.toString());
      if (TextUtils.isEmpty(paramu.e()))
      {
        if (locala == g.a.a) {
          ((ArrayList)localObject).add(Integer.valueOf(5));
        } else {
          ((ArrayList)localObject).add(Integer.valueOf(4));
        }
      }
      else if ((locala != g.a.c) && (locala != g.a.b))
      {
        if (a(paramActivity))
        {
          ((ArrayList)localObject).add(Integer.valueOf(0));
          ((ArrayList)localObject).add(Integer.valueOf(6));
        }
        else
        {
          ((ArrayList)localObject).add(Integer.valueOf(5));
          ((ArrayList)localObject).add(Integer.valueOf(6));
        }
      }
      else {
        ((ArrayList)localObject).add(Integer.valueOf(6));
      }
      paramu.a((ArrayList)localObject);
      localObject = BridgeActivity.getIntentStartBridgeActivity(paramActivity, com.huawei.hms.update.e.a.a(((Integer)((ArrayList)localObject).get(0)).intValue()));
      ((Intent)localObject).putExtra("intent.extra.update.info", paramu);
      paramActivity.startActivityForResult((Intent)localObject, paramInt);
    }
  }
  
  private static boolean a(Context paramContext)
  {
    int i = new g(paramContext).b("com.huawei.appmarket");
    paramContext = new StringBuilder();
    paramContext.append("getHiappVersion is ");
    paramContext.append(i);
    com.huawei.hms.support.log.a.b("UpdateManager", paramContext.toString());
    return i >= 70203000L;
  }
  
  private static g.a b(Context paramContext)
  {
    return new g(paramContext).a("com.huawei.appmarket");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hm\\update\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */