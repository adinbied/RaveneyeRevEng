package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.bf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class hl
{
  private static HashMap<String, ArrayList<hs>> a(Context paramContext, List<hs> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        hs localhs = (hs)localIterator.next();
        a(paramContext, localhs);
        ArrayList localArrayList = (ArrayList)localHashMap.get(localhs.c());
        paramList = localArrayList;
        if (localArrayList == null)
        {
          paramList = new ArrayList();
          localHashMap.put(localhs.c(), paramList);
        }
        paramList.add(localhs);
      }
      return localHashMap;
    }
    return null;
  }
  
  private static void a(Context paramContext, hn paramhn, HashMap<String, ArrayList<hs>> paramHashMap)
  {
    paramContext = paramHashMap.entrySet().iterator();
    while (paramContext.hasNext())
    {
      paramHashMap = (Map.Entry)paramContext.next();
      try
      {
        ArrayList localArrayList = (ArrayList)paramHashMap.getValue();
        if ((localArrayList != null) && (localArrayList.size() != 0))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("TinyData is uploaded immediately item size:");
          localStringBuilder.append(localArrayList.size());
          b.a(localStringBuilder.toString());
          paramhn.a(localArrayList, ((hs)localArrayList.get(0)).e(), (String)paramHashMap.getKey());
        }
      }
      catch (Exception paramHashMap)
      {
        for (;;) {}
      }
    }
  }
  
  public static void a(Context paramContext, hn paramhn, List<hs> paramList)
  {
    paramList = a(paramContext, paramList);
    if ((paramList != null) && (paramList.size() != 0))
    {
      a(paramContext, paramhn, paramList);
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("TinyData TinyDataCacheUploader.uploadTinyData itemsUploading == null || itemsUploading.size() == 0  ts:");
    paramContext.append(System.currentTimeMillis());
    b.a(paramContext.toString());
  }
  
  private static void a(Context paramContext, hs paramhs)
  {
    if (paramhs.a) {
      paramhs.a("push_sdk_channel");
    }
    if (TextUtils.isEmpty(paramhs.d())) {
      paramhs.f(bf.a());
    }
    paramhs.b(System.currentTimeMillis());
    if (TextUtils.isEmpty(paramhs.e())) {
      paramhs.e(paramContext.getPackageName());
    }
    if (TextUtils.isEmpty(paramhs.c())) {
      paramhs.e(paramhs.e());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\hl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */