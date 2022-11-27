package com.huawei.hianalytics.util;

import android.text.TextUtils;
import com.huawei.hianalytics.g.b;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class f
{
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt2)
    {
      b.c("HianalyticsSDK", "checkIntRange(): parameter overlarge.");
      return paramInt2;
    }
    paramInt2 = paramInt1;
    if (paramInt1 < paramInt3)
    {
      b.c("HianalyticsSDK", "checkIntRange(): parameter under size.");
      paramInt2 = paramInt3;
    }
    return paramInt2;
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        int i = Integer.parseInt(paramString);
        if ((i <= paramInt1) && (i >= paramInt2)) {
          return String.valueOf(paramString);
        }
        paramString = "checkMcc(): MCC out of range!";
        b.c("HianalyticsSDK", paramString);
        return "";
      }
      catch (NumberFormatException paramString)
      {
        continue;
      }
      paramString = "checkMcc(): mcc is not a number!please set up correctly";
    }
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("checkStrParameter() Parameter verification failure! Parameter:");
      paramString2.append(paramString1);
      b.c("HianalyticsSDK", paramString2.toString());
      return paramString4;
    }
    if (a(paramString1, paramString2, paramString3)) {
      return paramString2;
    }
    return paramString4;
  }
  
  public static boolean a(String paramString)
  {
    return a("eventId", paramString, 256) ^ true;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    if (!Pattern.compile(paramString2).matcher(paramString1).matches())
    {
      b.c("HianalyticsSDK", "isURLMatch(): URL check failed.");
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = new StringBuilder();
    }
    for (String str = "checkString() Parameter is empty : ";; str = "checkString() Failure of parameter length check! Parameter:")
    {
      paramString2.append(str);
      paramString2.append(paramString1);
      b.c("HianalyticsSDK", paramString2.toString());
      return false;
      if (paramString2.length() <= paramInt) {
        break;
      }
      paramString2 = new StringBuilder();
    }
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = new StringBuilder();
    }
    for (paramString3 = "checkString() Parameter is null! Parameter:";; paramString3 = "checkString() Parameter verification failure! Parameter:")
    {
      paramString2.append(paramString3);
      paramString2.append(paramString1);
      b.c("HianalyticsSDK", paramString2.toString());
      return false;
      if (Pattern.compile(paramString3).matcher(paramString2).matches()) {
        return true;
      }
      paramString2 = new StringBuilder();
    }
  }
  
  public static boolean a(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() != 0))
    {
      if ((paramMap.size() == 1) && ((paramMap.get("constants") != null) || (paramMap.get("_constants") != null)))
      {
        b.c("HianalyticsSDK", "checkMap() the key can't be constants or _constants");
        return false;
      }
      if ((paramMap.size() <= 2048) && (paramMap.toString().length() <= 204800)) {
        return true;
      }
      b.c("HianalyticsSDK", "checkMap Map data is too big! size: %d , length: %d", new Object[] { Integer.valueOf(paramMap.size()), Integer.valueOf(paramMap.toString().length()) });
      return false;
    }
    b.c("HianalyticsSDK", "onEvent() mapValue has not data.so,The data will be empty");
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytic\\util\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */