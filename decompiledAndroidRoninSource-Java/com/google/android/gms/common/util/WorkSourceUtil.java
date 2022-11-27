package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WorkSourceUtil
{
  private static final int zzhj = ;
  private static final Method zzhk = zzx();
  private static final Method zzhl = zzy();
  private static final Method zzhm = zzz();
  private static final Method zzhn = zzaa();
  private static final Method zzho = zzab();
  private static final Method zzhp = zzac();
  private static final Method zzhq = zzad();
  
  public static WorkSource fromPackage(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramContext.getPackageManager() != null)) {
      if (paramString == null) {
        return null;
      }
    }
    try
    {
      paramContext = Wrappers.packageManager(paramContext).getApplicationInfo(paramString, 0);
      if (paramContext == null)
      {
        paramContext = String.valueOf(paramString);
        if (paramContext.length() != 0) {
          paramContext = "Could not get applicationInfo from package: ".concat(paramContext);
        } else {
          paramContext = new String("Could not get applicationInfo from package: ");
        }
        Log.e("WorkSourceUtil", paramContext);
        return null;
      }
      return zza(paramContext.uid, paramString);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    paramContext = String.valueOf(paramString);
    if (paramContext.length() != 0) {
      paramContext = "Could not find package: ".concat(paramContext);
    } else {
      paramContext = new String("Could not find package: ");
    }
    Log.e("WorkSourceUtil", paramContext);
    return null;
  }
  
  public static WorkSource fromPackageAndModuleExperimentalPi(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext != null) && (paramContext.getPackageManager() != null) && (paramString2 != null) && (paramString1 != null))
    {
      int i = zzd(paramContext, paramString1);
      if (i < 0) {
        return null;
      }
      paramContext = new WorkSource();
      Object localObject = zzhp;
      if ((localObject != null) && (zzhq != null)) {
        try
        {
          localObject = ((Method)localObject).invoke(paramContext, new Object[0]);
          if (i != zzhj) {
            zzhq.invoke(localObject, new Object[] { Integer.valueOf(i), paramString1 });
          }
          zzhq.invoke(localObject, new Object[] { Integer.valueOf(zzhj), paramString2 });
          return paramContext;
        }
        catch (Exception paramString1)
        {
          Log.w("WorkSourceUtil", "Unable to assign chained blame through WorkSource", paramString1);
          return paramContext;
        }
      }
      zza(paramContext, i, paramString1);
      return paramContext;
    }
    Log.w("WorkSourceUtil", "Unexpected null arguments");
    return null;
  }
  
  public static List<String> getNames(WorkSource paramWorkSource)
  {
    int j = 0;
    int i;
    if (paramWorkSource == null) {
      i = 0;
    } else {
      i = zza(paramWorkSource);
    }
    if (i == 0) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList();
    while (j < i)
    {
      String str = zza(paramWorkSource, j);
      if (!Strings.isEmptyOrWhitespace(str)) {
        localArrayList.add(str);
      }
      j += 1;
    }
    return localArrayList;
  }
  
  public static boolean hasWorkSourcePermission(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    if (paramContext.getPackageManager() == null) {
      return false;
    }
    return Wrappers.packageManager(paramContext).checkPermission("android.permission.UPDATE_DEVICE_STATS", paramContext.getPackageName()) == 0;
  }
  
  private static int zza(WorkSource paramWorkSource)
  {
    Method localMethod = zzhm;
    if (localMethod != null) {
      try
      {
        int i = ((Integer)localMethod.invoke(paramWorkSource, new Object[0])).intValue();
        return i;
      }
      catch (Exception paramWorkSource)
      {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramWorkSource);
      }
    }
    return 0;
  }
  
  private static WorkSource zza(int paramInt, String paramString)
  {
    WorkSource localWorkSource = new WorkSource();
    zza(localWorkSource, paramInt, paramString);
    return localWorkSource;
  }
  
  private static String zza(WorkSource paramWorkSource, int paramInt)
  {
    Method localMethod = zzho;
    if (localMethod != null) {
      try
      {
        paramWorkSource = (String)localMethod.invoke(paramWorkSource, new Object[] { Integer.valueOf(paramInt) });
        return paramWorkSource;
      }
      catch (Exception paramWorkSource)
      {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramWorkSource);
      }
    }
    return null;
  }
  
  private static void zza(WorkSource paramWorkSource, int paramInt, String paramString)
  {
    if (zzhl != null)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      try
      {
        zzhl.invoke(paramWorkSource, new Object[] { Integer.valueOf(paramInt), str });
        return;
      }
      catch (Exception paramWorkSource)
      {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramWorkSource);
        return;
      }
    }
    paramString = zzhk;
    if (paramString != null) {
      try
      {
        paramString.invoke(paramWorkSource, new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      catch (Exception paramWorkSource)
      {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramWorkSource);
      }
    }
  }
  
  private static Method zzaa()
  {
    try
    {
      Method localMethod = WorkSource.class.getMethod("get", new Class[] { Integer.TYPE });
      return localMethod;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return null;
  }
  
  private static Method zzab()
  {
    if (PlatformVersion.isAtLeastJellyBeanMR2()) {}
    try
    {
      Method localMethod = WorkSource.class.getMethod("getName", new Class[] { Integer.TYPE });
      return localMethod;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return null;
  }
  
  private static final Method zzac()
  {
    if (PlatformVersion.isAtLeastP()) {
      try
      {
        Method localMethod = WorkSource.class.getMethod("createWorkChain", new Class[0]);
        return localMethod;
      }
      catch (Exception localException)
      {
        Log.w("WorkSourceUtil", "Missing WorkChain API createWorkChain", localException);
      }
    }
    return null;
  }
  
  private static final Method zzad()
  {
    if (PlatformVersion.isAtLeastP()) {
      try
      {
        Method localMethod = Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", new Class[] { Integer.TYPE, String.class });
        return localMethod;
      }
      catch (Exception localException)
      {
        Log.w("WorkSourceUtil", "Missing WorkChain class", localException);
      }
    }
    return null;
  }
  
  private static int zzd(Context paramContext, String paramString)
  {
    try
    {
      paramContext = Wrappers.packageManager(paramContext).getApplicationInfo(paramString, 0);
      if (paramContext == null)
      {
        paramContext = String.valueOf(paramString);
        if (paramContext.length() != 0) {
          paramContext = "Could not get applicationInfo from package: ".concat(paramContext);
        } else {
          paramContext = new String("Could not get applicationInfo from package: ");
        }
        Log.e("WorkSourceUtil", paramContext);
        return -1;
      }
      return paramContext.uid;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    paramContext = String.valueOf(paramString);
    if (paramContext.length() != 0) {
      paramContext = "Could not find package: ".concat(paramContext);
    } else {
      paramContext = new String("Could not find package: ");
    }
    Log.e("WorkSourceUtil", paramContext);
    return -1;
  }
  
  private static Method zzx()
  {
    try
    {
      Method localMethod = WorkSource.class.getMethod("add", new Class[] { Integer.TYPE });
      return localMethod;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return null;
  }
  
  private static Method zzy()
  {
    if (PlatformVersion.isAtLeastJellyBeanMR2()) {}
    try
    {
      Method localMethod = WorkSource.class.getMethod("add", new Class[] { Integer.TYPE, String.class });
      return localMethod;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return null;
  }
  
  private static Method zzz()
  {
    try
    {
      Method localMethod = WorkSource.class.getMethod("size", new Class[0]);
      return localMethod;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\commo\\util\WorkSourceUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */