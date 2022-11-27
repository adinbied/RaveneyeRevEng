package com.huawei.hianalytics.f.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hianalytics.f.g.g;
import com.huawei.hianalytics.g.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends c
{
  private Context h;
  
  public a() {}
  
  public a(Context paramContext)
  {
    this.h = paramContext;
  }
  
  public static Map<String, c[]> a(SharedPreferences paramSharedPreferences, Context paramContext, String paramString, boolean paramBoolean)
  {
    if ((paramSharedPreferences != null) && (paramContext != null))
    {
      HashMap localHashMap = new HashMap();
      if (paramBoolean)
      {
        paramSharedPreferences = g.b(paramSharedPreferences);
        if ((paramSharedPreferences.size() <= 200) && (paramSharedPreferences.size() != 0))
        {
          paramSharedPreferences = paramSharedPreferences.entrySet().iterator();
          while (paramSharedPreferences.hasNext()) {
            a((Map.Entry)paramSharedPreferences.next(), paramContext, localHashMap);
          }
        }
        b.c("ActionData", "get state data ：The number of data obtained is too much! or No data");
        return localHashMap;
      }
      a(paramString, g.a(paramSharedPreferences, paramString), paramContext, localHashMap);
      return localHashMap;
    }
    return null;
  }
  
  private static void a(String paramString1, String paramString2, Context paramContext, Map<String, c[]> paramMap)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      if (TextUtils.isEmpty(paramString2))
      {
        b.c("ActionData", "No data from cache sp!");
        return;
      }
      paramString2 = new JSONArray(paramString2);
      int j = paramString2.length();
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = paramString2.optJSONObject(i);
        a locala = new a(paramContext);
        locala.a(localJSONObject);
        localArrayList.add(locala);
        i += 1;
      }
      paramMap.put(paramString1, localArrayList.toArray(new a[localArrayList.size()]));
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;) {}
    }
    b.c("ActionData", "readDataToAppAction() events is not json format");
  }
  
  private static void a(Map.Entry<String, String> paramEntry, Context paramContext, Map<String, c[]> paramMap)
  {
    a((String)paramEntry.getKey(), (String)paramEntry.getValue(), paramContext, paramMap);
  }
  
  public JSONObject a()
  {
    return a(false);
  }
  
  public JSONObject a(boolean paramBoolean)
  {
    return null;
  }
  
  /* Error */
  public void a(JSONObject arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\f\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */