package com.xiaomi.push;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class en
{
  public static Uri a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("content://");
    localStringBuilder.append(paramString1);
    return Uri.parse(localStringBuilder.toString()).buildUpon().appendPath(paramString2).build();
  }
  
  public static String a(String paramString)
  {
    return Base64.encodeToString(bf.a(paramString), 2);
  }
  
  public static String a(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null) {
      return "";
    }
    localJSONObject = new JSONObject();
    Object localObject = paramHashMap.keySet();
    try
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localJSONObject.put(str, paramHashMap.get(str));
      }
      return localJSONObject.toString();
    }
    catch (JSONException paramHashMap)
    {
      b.a(paramHashMap);
    }
  }
  
  public static String b(String paramString)
  {
    return bf.a(Base64.decode(paramString, 2));
  }
  
  public static String b(HashMap<String, String> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    if (paramHashMap != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)paramHashMap.get("event_type"));
      localStringBuilder.append("");
      localHashMap.put("event_type", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)paramHashMap.get("description"));
      localStringBuilder.append("");
      localHashMap.put("description", localStringBuilder.toString());
      paramHashMap = (String)paramHashMap.get("awake_info");
      if (!TextUtils.isEmpty(paramHashMap)) {
        try
        {
          paramHashMap = new JSONObject(paramHashMap);
          localHashMap.put("__planId__", String.valueOf(paramHashMap.opt("__planId__")));
          localHashMap.put("flow_id", String.valueOf(paramHashMap.opt("flow_id")));
          localHashMap.put("jobkey", String.valueOf(paramHashMap.opt("jobkey")));
          localHashMap.put("msg_id", String.valueOf(paramHashMap.opt("msg_id")));
          localHashMap.put("A", String.valueOf(paramHashMap.opt("awake_app")));
          localHashMap.put("B", String.valueOf(paramHashMap.opt("awakened_app")));
          localHashMap.put("module", String.valueOf(paramHashMap.opt("awake_type")));
        }
        catch (JSONException paramHashMap)
        {
          b.a(paramHashMap);
        }
      }
    }
    return a(localHashMap);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\en.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */