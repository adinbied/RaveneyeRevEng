package com.huawei.hianalytics.f.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.huawei.hianalytics.g.b;
import com.huawei.hianalytics.util.d;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class g
{
  public static File a(Context paramContext, String paramString)
  {
    Object localObject = paramContext.getPackageName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hianalytics_");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(".xml");
    paramString = localStringBuilder.toString();
    paramContext = paramContext.getFilesDir();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("../shared_prefs/");
    ((StringBuilder)localObject).append(paramString);
    return new File(paramContext, ((StringBuilder)localObject).toString());
  }
  
  public static String a(SharedPreferences paramSharedPreferences, String paramString)
  {
    if (paramSharedPreferences == null) {
      return null;
    }
    String str = (String)b(paramSharedPreferences, paramString, "");
    paramSharedPreferences = paramSharedPreferences.edit();
    paramSharedPreferences.remove(paramString);
    paramSharedPreferences.apply();
    return str;
  }
  
  public static Set<String> a(SharedPreferences paramSharedPreferences)
  {
    return paramSharedPreferences.getAll().keySet();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    File localFile = paramContext.getFilesDir();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(d.b(paramContext, paramString2));
    localStringBuilder.append(".xml");
    paramContext = new File(localFile, localStringBuilder.toString());
    if ((paramContext.exists()) && (paramContext.delete())) {
      b.c("SharedPreferenceUtil", "delete sp file");
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = b(paramContext, paramString2).edit();
    paramContext.putString(paramString3, paramString1);
    paramContext.apply();
  }
  
  public static void a(SharedPreferences paramSharedPreferences, String paramString, Object paramObject)
  {
    d.a(paramSharedPreferences, paramString, paramObject);
  }
  
  private static void a(SharedPreferences paramSharedPreferences, Set<String> paramSet, Map<String, String> paramMap)
  {
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      paramMap.put(str, (String)b(paramSharedPreferences, str, ""));
    }
  }
  
  public static void a(String paramString, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString))
    {
      b.c("SharedPreferenceUtil", "clearTypeDataByTag() eventTag is null or empty!");
      return;
    }
    if (!"_default_config_tag".equals(paramString))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("-");
      ((StringBuilder)localObject1).append("oper");
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("-");
      ((StringBuilder)localObject2).append("maint");
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("-");
      localStringBuilder.append("diffprivacy");
      paramString = localStringBuilder.toString();
      a((String)localObject1, false, paramContext);
      a((String)localObject2, false, paramContext);
    }
    a(paramString, false, paramContext);
  }
  
  public static void a(String paramString, boolean paramBoolean, Context paramContext)
  {
    try
    {
      Object localObject = b(paramContext, "stat_v2_1");
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).edit();
        if (paramBoolean) {
          ((SharedPreferences.Editor)localObject).clear();
        } else {
          ((SharedPreferences.Editor)localObject).remove(paramString);
        }
        ((SharedPreferences.Editor)localObject).commit();
      }
      paramContext = b(paramContext, "cached_v2_1");
      if (paramContext != null)
      {
        paramContext = paramContext.edit();
        if (paramBoolean) {
          paramContext.clear();
        } else {
          paramContext.remove(paramString);
        }
        paramContext.commit();
      }
      return;
    }
    finally {}
  }
  
  public static void a(Set<String> paramSet1, Set<String> paramSet2, Context paramContext)
  {
    paramSet2 = paramSet2.iterator();
    while (paramSet2.hasNext())
    {
      String str = (String)paramSet2.next();
      if (!paramSet1.contains(str)) {
        a(str, false, paramContext);
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    SharedPreferences localSharedPreferences = b(paramContext, "analytics_key");
    Long localLong = Long.valueOf(-1L);
    long l2 = ((Long)b(localSharedPreferences, "flashKeyTime", localLong)).longValue();
    long l1 = l2;
    if (l2 == -1L) {
      l1 = ((Long)b(b(paramContext, "Privacy_MY"), "flashKeyTime", localLong)).longValue();
    }
    return System.currentTimeMillis() - l1 > 43200000L;
  }
  
  public static boolean a(Context paramContext, String paramString, int paramInt)
  {
    long l = a(paramContext, paramString).length();
    if (l > paramInt)
    {
      b.b("HiAnalytics/event", "reach local file limited size - file len: %d limitedSize: %d", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt) });
      return true;
    }
    return false;
  }
  
  public static boolean a(SharedPreferences paramSharedPreferences, int paramInt, String paramString)
  {
    return ((String)b(paramSharedPreferences, paramString, "")).length() > paramInt;
  }
  
  public static SharedPreferences b(Context paramContext, String paramString)
  {
    return d.a(paramContext, paramString);
  }
  
  public static Object b(SharedPreferences paramSharedPreferences, String paramString, Object paramObject)
  {
    return d.b(paramSharedPreferences, paramString, paramObject);
  }
  
  public static Map<String, String> b(SharedPreferences paramSharedPreferences)
  {
    Set localSet = a(paramSharedPreferences);
    HashMap localHashMap = new HashMap(localSet.size());
    a(paramSharedPreferences, localSet, localHashMap);
    return localHashMap;
  }
  
  public static void c(Context paramContext, String paramString)
  {
    a(b(paramContext, "global_v2"), "app_ver", paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\f\g\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */