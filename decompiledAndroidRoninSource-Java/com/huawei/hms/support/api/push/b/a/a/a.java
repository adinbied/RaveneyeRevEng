package com.huawei.hms.support.api.push.b.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.c.j;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.SubAppInfo;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static int a()
  {
    int i4 = 0;
    int i5 = 0;
    int i6 = 0;
    int i7 = 0;
    int i8 = 0;
    int i9 = 0;
    int i = 0;
    Object localObject = Integer.TYPE;
    int j = i;
    int k = i4;
    int m = i5;
    int n = i6;
    int i1 = i7;
    int i2 = i8;
    int i3 = i9;
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      j = i;
      k = i4;
      m = i5;
      n = i6;
      i1 = i7;
      i2 = i8;
      i3 = i9;
      i = ((Integer)localClass.getDeclaredMethod("getInt", new Class[] { String.class, localObject }).invoke(localClass, new Object[] { "ro.build.hw_emui_api_level", Integer.valueOf(0) })).intValue();
      j = i;
      k = i;
      m = i;
      n = i;
      i1 = i;
      i2 = i;
      i3 = i;
      localObject = new StringBuilder();
      j = i;
      k = i;
      m = i;
      n = i;
      i1 = i;
      i2 = i;
      i3 = i;
      ((StringBuilder)localObject).append("getEmuiLevel:");
      j = i;
      k = i;
      m = i;
      n = i;
      i1 = i;
      i2 = i;
      i3 = i;
      ((StringBuilder)localObject).append(i);
      j = i;
      k = i;
      m = i;
      n = i;
      i1 = i;
      i2 = i;
      i3 = i;
      com.huawei.hms.support.log.a.a("BaseUtil", ((StringBuilder)localObject).toString());
      return i;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;) {}
    }
    catch (ExceptionInInitializerError localExceptionInInitializerError)
    {
      for (;;) {}
    }
    catch (LinkageError localLinkageError)
    {
      for (;;) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;) {}
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;) {}
    }
    c(" getEmuiLevel wrong, InvocationTargetException");
    return i3;
    c(" getEmuiLevel wrong, IllegalArgumentException");
    return i2;
    c(" getEmuiLevel wrong, IllegalAccessException");
    return i1;
    c(" getEmuiLevel wrong, NoSuchMethodException");
    return n;
    c(" getEmuiLevel wrong, LinkageError");
    return m;
    c(" getEmuiLevel wrong, ExceptionInInitializerError");
    return k;
    c(" getEmuiLevel wrong, ClassNotFoundException");
    return j;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      paramString1 = (String)localClass.getDeclaredMethod("get", new Class[] { String.class, String.class }).invoke(localClass, new Object[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (ClassNotFoundException paramString1)
    {
      for (;;) {}
    }
    catch (NoSuchMethodException paramString1)
    {
      for (;;) {}
    }
    catch (IllegalAccessException paramString1)
    {
      for (;;) {}
    }
    catch (IllegalArgumentException paramString1)
    {
      for (;;) {}
    }
    catch (InvocationTargetException paramString1)
    {
      for (;;) {}
    }
    catch (ClassCastException paramString1)
    {
      for (;;) {}
    }
    c("An ClassCastException occurred while reading SystemProperties");
    return paramString2;
    c("An InvocationTargetException occurred while reading SystemProperties");
    return paramString2;
    c("An IllegalArgumentException occurred while reading SystemProperties");
    return paramString2;
    c("An IllegalAccessException occurred while reading SystemProperties");
    return paramString2;
    c("An NoSuchMethodException occurred while reading SystemProperties");
    return paramString2;
    c("An ClassNotFoundException occurred while reading SystemProperties");
    return paramString2;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    if (paramArrayOfByte.length == 0) {
      return "";
    }
    char[] arrayOfChar1 = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i];
      int k = i * 2;
      char[] arrayOfChar2 = a;
      arrayOfChar1[k] = arrayOfChar2[((j & 0xF0) >> 4)];
      arrayOfChar1[(k + 1)] = arrayOfChar2[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar1);
  }
  
  public static JSONArray a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      com.huawei.hms.support.log.a.a("BaseUtil", "jsonString is null");
      return null;
    }
    try
    {
      paramString = new JSONArray(paramString);
      return paramString;
    }
    catch (JSONException paramString)
    {
      for (;;) {}
    }
    com.huawei.hms.support.log.a.a("BaseUtil", "cast jsonString to jsonArray error");
    return null;
  }
  
  public static JSONArray a(List<String> paramList, Context paramContext)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    paramContext = new c(paramContext, "tags_info");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      Object localObject;
      if (paramContext.c(str))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("tagKey", str);
        ((JSONObject)localObject).put("opType", 2);
        if (((JSONObject)localObject).length() > 0) {
          localJSONArray.put(localObject);
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(" not exist, need not to remove");
        com.huawei.hms.support.log.a.a("BaseUtil", ((StringBuilder)localObject).toString());
      }
    }
    return localJSONArray;
  }
  
  public static void a(ApiClient paramApiClient, String paramString)
  {
    if (com.huawei.hms.support.b.a.a().b()) {
      return;
    }
    if (paramApiClient == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("package", paramApiClient.getPackageName());
    localHashMap.put("sdk_ver", String.valueOf(20603301));
    String str = null;
    Object localObject = paramApiClient.getSubAppInfo();
    if (localObject != null) {
      str = ((SubAppInfo)localObject).getSubAppID();
    }
    localObject = str;
    if (str == null) {
      localObject = paramApiClient.getAppID();
    }
    localHashMap.put("app_id", localObject);
    paramString = paramString.split("\\.");
    if (paramString.length == 2)
    {
      localHashMap.put("service", paramString[0]);
      localHashMap.put("api_name", paramString[1]);
    }
    localHashMap.put("result", String.valueOf(0));
    localHashMap.put("cost_time", String.valueOf(0));
    com.huawei.hms.support.b.a.a().a(paramApiClient.getContext(), "HMS_SDK_API_CALL", localHashMap);
  }
  
  public static String b()
  {
    return a("ro.build.version.emui", "");
  }
  
  public static byte[] b(String paramString)
  {
    int j = paramString.length() / 2;
    arrayOfByte = new byte[j];
    try
    {
      paramString = paramString.getBytes("UTF-8");
      int i = 0;
      StringBuilder localStringBuilder;
      while (i < j)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("0x");
        int k = i * 2;
        localStringBuilder.append(new String(new byte[] { paramString[k] }, "UTF-8"));
        int m = (byte)(Byte.decode(localStringBuilder.toString()).byteValue() << 4);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("0x");
        localStringBuilder.append(new String(new byte[] { paramString[(k + 1)] }, "UTF-8"));
        arrayOfByte[i] = ((byte)(m ^ Byte.decode(localStringBuilder.toString()).byteValue()));
        i += 1;
      }
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException paramString)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("hexString2ByteArray error");
      localStringBuilder.append(paramString.getMessage());
      com.huawei.hms.support.log.a.a("BaseUtil", localStringBuilder.toString());
    }
  }
  
  private static void c(String paramString)
  {
    com.huawei.hms.support.log.a.d("BaseUtil", paramString);
  }
  
  public static boolean c()
  {
    if (TextUtils.isEmpty(b()))
    {
      com.huawei.hms.support.log.a.c("BaseUtil", "it is not EMUI system.");
      return false;
    }
    return true;
  }
  
  public static boolean d()
  {
    return j.a();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\push\b\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */