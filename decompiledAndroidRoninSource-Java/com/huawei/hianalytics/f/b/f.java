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

public class f
  extends c
{
  private static final String h = f.class.getSimpleName();
  
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
        paramContext = h;
        paramString = new StringBuilder();
        paramString.append("get state data ：The number of data obtained is too much! or No data : ");
        paramString.append(paramSharedPreferences.size());
        b.c(paramContext, paramString.toString());
        return localHashMap;
      }
      a(paramString, (String)g.b(paramSharedPreferences, paramString, ""), paramContext, localHashMap);
      return localHashMap;
    }
    return null;
  }
  
  private static void a(String paramString1, String paramString2, Context paramContext, Map<String, c[]> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    String str = null;
    Object localObject = str;
    try
    {
      if (TextUtils.isEmpty(paramString2)) {
        break label48;
      }
      localObject = new JSONArray(paramString2);
    }
    catch (JSONException paramString2)
    {
      label48:
      int i;
      label296:
      for (;;) {}
    }
    b.c(h, "When events turn to JSONArray,JSON Exception has happened");
    localObject = str;
    if (localObject != null)
    {
      if (((JSONArray)localObject).length() == 0) {
        return;
      }
      i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        f localf = new f();
        try
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
          if (localJSONObject == null) {
            break label296;
          }
          paramString2 = localJSONObject.getString("event");
          str = "";
          if (paramString2 == null) {
            paramString2 = "";
          } else {
            paramString2 = localJSONObject.getString("event");
          }
          localf.b = paramString2;
          if (localJSONObject.getString("content") == null) {
            paramString2 = "";
          } else {
            paramString2 = com.huawei.hianalytics.f.g.c.a(localJSONObject.getString("content"), paramContext);
          }
          localf.c = paramString2;
          if (localJSONObject.getString("eventtime") == null) {
            paramString2 = "";
          } else {
            paramString2 = localJSONObject.getString("eventtime");
          }
          localf.a = paramString2;
          if (localJSONObject.getString("type") == null) {
            paramString2 = str;
          } else {
            paramString2 = localJSONObject.getString("type");
          }
          localf.d = paramString2;
          if (localJSONObject.toString().contains("event_session_name"))
          {
            localf.f = localJSONObject.getString("event_session_name");
            localf.g = localJSONObject.getString("first_session_event");
          }
          localArrayList.add(localf);
        }
        catch (JSONException paramString2)
        {
          for (;;) {}
        }
        localArrayList.add(localf);
        b.c(h, "JSON Exception happened when create data for report - readDataToRecord");
        i += 1;
      }
      paramMap.put(paramString1, localArrayList.toArray(new f[localArrayList.size()]));
    }
  }
  
  private static void a(Map.Entry<String, String> paramEntry, Context paramContext, Map<String, c[]> paramMap)
  {
    a((String)paramEntry.getKey(), (String)paramEntry.getValue(), paramContext, paramMap);
  }
  
  /* Error */
  public void a(SharedPreferences arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\f\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */