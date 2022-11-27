package com.xiaomi.push;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class g
{
  public static int a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 16384);
    }
    catch (Exception paramContext)
    {
      b.a(paramContext);
      paramContext = null;
    }
    if (paramContext != null) {
      return paramContext.versionCode;
    }
    return 0;
  }
  
  public static a a(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString)) && (Build.VERSION.SDK_INT >= 19)) {}
    try
    {
      Integer localInteger = (Integer)ba.a(AppOpsManager.class, "OP_POST_NOTIFICATION");
      if (localInteger == null) {
        return a.a;
      }
      ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramString, 0);
      paramContext = (Integer)ba.a((AppOpsManager)paramContext.getSystemService("appops"), "checkOpNoThrow", new Object[] { localInteger, Integer.valueOf(localApplicationInfo.uid), paramString });
      if ((paramContext != null) && (paramContext.intValue() == 0)) {
        return a.b;
      }
      paramContext = a.c;
      return paramContext;
    }
    finally
    {
      for (;;) {}
    }
    return a.a;
    return a.a;
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null) {
      return null;
    }
    int i = Process.myPid();
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.pid == i) {
        return localRunningAppProcessInfo.processName;
      }
    }
    return null;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 16384);
    }
    catch (Exception paramContext)
    {
      b.a(paramContext);
      paramContext = null;
    }
    if (paramContext != null) {
      return paramContext.versionName;
    }
    return "1.0";
  }
  
  public static boolean a(Context paramContext)
  {
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      if (((List)localObject).size() < 1) {
        return false;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if ((localRunningAppProcessInfo.pid == Process.myPid()) && (localRunningAppProcessInfo.processName.equals(paramContext.getPackageName()))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext()) {
        if (Arrays.asList(((ActivityManager.RunningAppProcessInfo)paramContext.next()).pkgList).contains(paramString)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static String b(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramContext != null) && (paramContext.size() > 0))
    {
      Iterator localIterator = paramContext.iterator();
      while (localIterator.hasNext())
      {
        String[] arrayOfString = ((ActivityManager.RunningAppProcessInfo)localIterator.next()).pkgList;
        int i = 0;
        while ((arrayOfString != null) && (i < arrayOfString.length))
        {
          if (!localArrayList.contains(arrayOfString[i]))
          {
            localArrayList.add(arrayOfString[i]);
            if (localArrayList.size() == 1)
            {
              paramContext = (String)localArrayList.get(0);
            }
            else
            {
              localStringBuilder.append("#");
              paramContext = arrayOfString[i];
            }
            localStringBuilder.append(paramContext.hashCode() % 100000);
          }
          i += 1;
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String b(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager();
      Object localObject = paramContext.getPackageInfo(paramString, 0);
      if (localObject != null)
      {
        localObject = ((PackageInfo)localObject).applicationInfo;
        if (localObject != null)
        {
          paramContext = paramContext.getApplicationLabel((ApplicationInfo)localObject).toString();
          return paramContext;
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      b.a(paramContext);
    }
    return paramString;
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    paramContext = null;
    return paramContext != null;
  }
  
  public static boolean c(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName()) == 0;
  }
  
  public static enum a
  {
    private final int jdField_a_of_type_Int;
    
    static
    {
      jdField_a_of_type_ComXiaomiPushG$a = new a("UNKNOWN", 0, 0);
      b = new a("ALLOWED", 1, 1);
      a locala = new a("NOT_ALLOWED", 2, 2);
      c = locala;
      jdField_a_of_type_ArrayOfComXiaomiPushG$a = new a[] { jdField_a_of_type_ComXiaomiPushG$a, b, locala };
    }
    
    private a(int paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
    }
    
    public int a()
    {
      return this.jdField_a_of_type_Int;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */