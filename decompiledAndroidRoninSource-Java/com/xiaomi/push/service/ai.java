package com.xiaomi.push.service;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.xiaomi.push.ad;
import com.xiaomi.push.hu;
import com.xiaomi.push.hv;
import com.xiaomi.push.hx;
import com.xiaomi.push.hz;
import com.xiaomi.push.il;
import com.xiaomi.push.im;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ai
{
  public static int a(ah paramah, hu paramhu)
  {
    String str = a(paramhu);
    int j = aj.a[paramhu.ordinal()];
    int i = 1;
    if (j != 1) {
      i = 0;
    }
    return paramah.a.getInt(str, i);
  }
  
  private static String a(hu paramhu)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("oc_version_");
    localStringBuilder.append(paramhu.a());
    return localStringBuilder.toString();
  }
  
  private static List<Pair<Integer, Object>> a(List<hz> paramList, boolean paramBoolean)
  {
    if (ad.a(paramList)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (hz)localIterator.next();
      int i = paramList.a();
      hv localhv = hv.a(paramList.b());
      if (localhv != null) {
        if ((paramBoolean) && (paramList.a))
        {
          localArrayList.add(new Pair(Integer.valueOf(i), null));
        }
        else
        {
          int j = aj.b[localhv.ordinal()];
          if (j != 1)
          {
            if (j != 2)
            {
              if (j != 3)
              {
                if (j != 4) {
                  paramList = null;
                } else {
                  paramList = new Pair(Integer.valueOf(i), Boolean.valueOf(paramList.g()));
                }
              }
              else {
                paramList = new Pair(Integer.valueOf(i), paramList.a());
              }
            }
            else {
              paramList = new Pair(Integer.valueOf(i), Long.valueOf(paramList.a()));
            }
          }
          else {
            paramList = new Pair(Integer.valueOf(i), Integer.valueOf(paramList.c()));
          }
          localArrayList.add(paramList);
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(ah paramah, hu paramhu, int paramInt)
  {
    paramhu = a(paramhu);
    paramah.a.edit().putInt(paramhu, paramInt).commit();
  }
  
  public static void a(ah paramah, il paramil)
  {
    paramah.b(a(paramil.a(), true));
    paramah.b();
  }
  
  public static void a(ah paramah, im paramim)
  {
    paramim = paramim.a().iterator();
    while (paramim.hasNext())
    {
      hx localhx = (hx)paramim.next();
      if (localhx.a() > a(paramah, localhx.a()))
      {
        a(paramah, localhx.a(), localhx.a());
        paramah.a(a(localhx.a, false));
      }
    }
    paramah.b();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */