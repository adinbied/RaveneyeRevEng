package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.HashMap;

public class eo
{
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    ai.a(paramContext).a(new ep(paramContext, paramString1, paramInt, paramString2));
  }
  
  private static void a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    ew localew = es.a(paramContext).a();
    if (localew != null) {
      localew.a(paramContext, paramHashMap);
    }
  }
  
  private static void b(Context paramContext, HashMap<String, String> paramHashMap)
  {
    ew localew = es.a(paramContext).a();
    if (localew != null) {
      localew.c(paramContext, paramHashMap);
    }
  }
  
  private static void c(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      try
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("awake_info", paramString1);
        localHashMap.put("event_type", String.valueOf(paramInt));
        localHashMap.put("description", paramString2);
        paramInt = es.a(paramContext).a();
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt == 3) {
              a(paramContext, localHashMap);
            }
          }
          else {
            c(paramContext, localHashMap);
          }
        }
        else {
          a(paramContext, localHashMap);
        }
        b(paramContext, localHashMap);
        return;
      }
      catch (Exception paramContext)
      {
        b.a(paramContext);
      }
    }
  }
  
  private static void c(Context paramContext, HashMap<String, String> paramHashMap)
  {
    ew localew = es.a(paramContext).a();
    if (localew != null) {
      localew.b(paramContext, paramHashMap);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\eo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */