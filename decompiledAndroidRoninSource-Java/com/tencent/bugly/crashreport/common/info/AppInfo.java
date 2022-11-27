package com.tencent.bugly.crashreport.common.info;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tencent.bugly.proguard.x;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppInfo
{
  private static ActivityManager a;
  
  static
  {
    "@buglyAllChannel@".split(",");
    "@buglyAllChannelPriority@".split(",");
  }
  
  /* Error */
  public static String a(int paramInt)
  {
    // Byte code:
    //   0: new 27	java/lang/StringBuilder
    //   3: dup
    //   4: ldc 29
    //   6: invokespecial 32	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   9: astore_2
    //   10: aload_2
    //   11: iload_0
    //   12: invokevirtual 36	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload_2
    //   17: ldc 38
    //   19: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: new 43	java/io/FileReader
    //   26: dup
    //   27: aload_2
    //   28: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokespecial 48	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   34: astore_2
    //   35: sipush 512
    //   38: newarray <illegal type>
    //   40: astore_3
    //   41: aload_2
    //   42: aload_3
    //   43: invokevirtual 52	java/io/FileReader:read	([C)I
    //   46: pop
    //   47: iconst_0
    //   48: istore_1
    //   49: goto +77 -> 126
    //   52: new 14	java/lang/String
    //   55: dup
    //   56: aload_3
    //   57: invokespecial 55	java/lang/String:<init>	([C)V
    //   60: iconst_0
    //   61: iload_1
    //   62: invokevirtual 59	java/lang/String:substring	(II)Ljava/lang/String;
    //   65: astore_3
    //   66: aload_2
    //   67: invokevirtual 62	java/io/FileReader:close	()V
    //   70: aload_3
    //   71: areturn
    //   72: astore_3
    //   73: goto +6 -> 79
    //   76: astore_3
    //   77: aconst_null
    //   78: astore_2
    //   79: aload_3
    //   80: invokestatic 67	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   83: ifne +7 -> 90
    //   86: aload_3
    //   87: invokevirtual 72	java/lang/Throwable:printStackTrace	()V
    //   90: iload_0
    //   91: invokestatic 75	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   94: astore_3
    //   95: aload_2
    //   96: ifnull +7 -> 103
    //   99: aload_2
    //   100: invokevirtual 62	java/io/FileReader:close	()V
    //   103: aload_3
    //   104: areturn
    //   105: astore_3
    //   106: aload_2
    //   107: ifnull +7 -> 114
    //   110: aload_2
    //   111: invokevirtual 62	java/io/FileReader:close	()V
    //   114: aload_3
    //   115: athrow
    //   116: astore_2
    //   117: aload_3
    //   118: areturn
    //   119: astore_2
    //   120: aload_3
    //   121: areturn
    //   122: astore_2
    //   123: goto -9 -> 114
    //   126: iload_1
    //   127: sipush 512
    //   130: if_icmpge -78 -> 52
    //   133: aload_3
    //   134: iload_1
    //   135: caload
    //   136: ifeq -84 -> 52
    //   139: iload_1
    //   140: iconst_1
    //   141: iadd
    //   142: istore_1
    //   143: goto -17 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramInt	int
    //   48	95	1	i	int
    //   9	102	2	localObject1	Object
    //   116	1	2	localObject2	Object
    //   119	1	2	localObject3	Object
    //   122	1	2	localObject4	Object
    //   40	31	3	localObject5	Object
    //   72	1	3	localObject6	Object
    //   76	11	3	localThrowable	Throwable
    //   94	10	3	str1	String
    //   105	29	3	str2	String
    // Exception table:
    //   from	to	target	type
    //   35	47	72	finally
    //   52	66	72	finally
    //   0	35	76	finally
    //   79	90	105	finally
    //   90	95	105	finally
    //   66	70	116	finally
    //   99	103	119	finally
    //   110	114	122	finally
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramContext = paramContext.getPackageName();
      return paramContext;
    }
    finally
    {
      if (!x.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return "fail";
  }
  
  public static List<String> a(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return null;
    }
    try
    {
      paramMap = (String)paramMap.get("BUGLY_DISABLE");
      if (paramMap != null)
      {
        if (paramMap.length() == 0) {
          return null;
        }
        paramMap = paramMap.split(",");
        int i = 0;
        while (i < paramMap.length)
        {
          paramMap[i] = paramMap[i].trim();
          i += 1;
        }
        paramMap = Arrays.asList(paramMap);
        return paramMap;
      }
      return null;
    }
    finally
    {
      if (!x.a(paramMap)) {
        paramMap.printStackTrace();
      }
    }
    return null;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramString != null))
    {
      if (paramString.trim().length() <= 0) {
        return false;
      }
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 4096).requestedPermissions;
        if (paramContext != null)
        {
          int j = paramContext.length;
          int i = 0;
          while (i < j)
          {
            boolean bool = paramString.equals(paramContext[i]);
            if (bool) {
              return true;
            }
            i += 1;
          }
        }
        return false;
      }
      finally
      {
        if (!x.a(paramContext)) {
          paramContext.printStackTrace();
        }
      }
    }
  }
  
  public static PackageInfo b(Context paramContext)
  {
    try
    {
      String str = a(paramContext);
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 0);
      return paramContext;
    }
    finally
    {
      if (!x.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return null;
  }
  
  public static String c(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      paramContext = paramContext.getApplicationInfo();
      if ((localPackageManager != null) && (paramContext != null))
      {
        paramContext = localPackageManager.getApplicationLabel(paramContext);
        if (paramContext != null)
        {
          paramContext = paramContext.toString();
          return paramContext;
        }
      }
    }
    finally
    {
      if (!x.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return null;
  }
  
  public static Map<String, String> d(Context paramContext)
  {
    Object localObject = null;
    if (paramContext == null) {
      return null;
    }
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      paramContext = (Context)localObject;
      if (localApplicationInfo.metaData != null)
      {
        paramContext = new HashMap();
        localObject = localApplicationInfo.metaData.get("BUGLY_DISABLE");
        if (localObject != null) {
          paramContext.put("BUGLY_DISABLE", localObject.toString());
        }
        localObject = localApplicationInfo.metaData.get("BUGLY_APPID");
        if (localObject != null) {
          paramContext.put("BUGLY_APPID", localObject.toString());
        }
        localObject = localApplicationInfo.metaData.get("BUGLY_APP_CHANNEL");
        if (localObject != null) {
          paramContext.put("BUGLY_APP_CHANNEL", localObject.toString());
        }
        localObject = localApplicationInfo.metaData.get("BUGLY_APP_VERSION");
        if (localObject != null) {
          paramContext.put("BUGLY_APP_VERSION", localObject.toString());
        }
        localObject = localApplicationInfo.metaData.get("BUGLY_ENABLE_DEBUG");
        if (localObject != null) {
          paramContext.put("BUGLY_ENABLE_DEBUG", localObject.toString());
        }
        localObject = localApplicationInfo.metaData.get("com.tencent.rdm.uuid");
        if (localObject != null) {
          paramContext.put("com.tencent.rdm.uuid", localObject.toString());
        }
        localObject = localApplicationInfo.metaData.get("BUGLY_APP_BUILD_NO");
        if (localObject != null) {
          paramContext.put("BUGLY_APP_BUILD_NO", localObject.toString());
        }
        localObject = localApplicationInfo.metaData.get("BUGLY_AREA");
        if (localObject != null) {
          paramContext.put("BUGLY_AREA", localObject.toString());
        }
      }
      return paramContext;
    }
    finally
    {
      if (!x.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return null;
  }
  
  public static boolean e(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    if (a == null) {
      a = (ActivityManager)paramContext.getSystemService("activity");
    }
    try
    {
      paramContext = new ActivityManager.MemoryInfo();
      a.getMemoryInfo(paramContext);
      if (paramContext.lowMemory)
      {
        x.c("Memory is low.", new Object[0]);
        return true;
      }
      return false;
    }
    finally
    {
      if (!x.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\crashreport\common\info\AppInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */