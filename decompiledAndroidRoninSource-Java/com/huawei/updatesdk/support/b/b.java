package com.huawei.updatesdk.support.b;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class b
{
  private static String[] a;
  
  private static long a(String paramString)
  {
    try
    {
      paramString = new StatFs(paramString);
      long l1;
      if (Build.VERSION.SDK_INT >= 18) {
        l1 = paramString.getBlockSizeLong();
      }
      for (long l2 = paramString.getAvailableBlocksLong();; l2 = paramString.getAvailableBlocks())
      {
        return l1 * l2;
        l1 = paramString.getBlockSize();
      }
      return 0L;
    }
    catch (IllegalArgumentException paramString)
    {
      com.huawei.updatesdk.sdk.a.c.a.a.a.a("StorageManage", "path error", paramString);
    }
  }
  
  public static a a()
  {
    Object localObject1 = com.huawei.updatesdk.sdk.service.a.a.a().b();
    if ((Build.VERSION.SDK_INT < 24) && (com.huawei.updatesdk.sdk.a.d.b.a.g() != 0)) {
      localObject1 = a((Context)localObject1);
    } else {
      localObject1 = b((Context)localObject1);
    }
    if (TextUtils.isEmpty(((a)localObject1).a())) {
      return null;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((a)localObject1).a());
    ((StringBuilder)localObject2).append(File.separator);
    localObject2 = ((StringBuilder)localObject2).toString();
    ((a)localObject1).a((String)localObject2);
    localObject2 = new File((String)localObject2);
    if ((!((File)localObject2).exists()) && (!((File)localObject2).mkdirs())) {
      return null;
    }
    if ((Build.VERSION.SDK_INT < 24) && (!((File)localObject2).setExecutable(true, false))) {
      com.huawei.updatesdk.sdk.a.c.a.a.a.d("StorageManage", "can not set Executeable to AppCache");
    }
    return (a)localObject1;
  }
  
  private static a a(Context paramContext)
  {
    Object localObject = d(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramContext.getPackageName());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("files");
    localObject = new File(localStringBuilder.toString());
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs())) {
      com.huawei.updatesdk.sdk.a.c.a.a.a.d("StorageManage", "failed to create file.");
    }
    paramContext = new a();
    localObject = ((File)localObject).getAbsolutePath();
    paramContext.b(a((String)localObject));
    paramContext.a(b((String)localObject));
    paramContext.a((String)localObject);
    paramContext.a(a.a.b);
    return paramContext;
  }
  
  private static long b(String paramString)
  {
    paramString = new StatFs(paramString);
    long l1;
    if (Build.VERSION.SDK_INT >= 18) {
      l1 = paramString.getBlockSizeLong();
    }
    for (long l2 = paramString.getBlockCountLong();; l2 = paramString.getBlockCount())
    {
      return l1 * l2;
      l1 = paramString.getBlockSize();
    }
  }
  
  private static a b(Context paramContext)
  {
    Object localObject = paramContext.getFilesDir();
    paramContext = new a();
    if (localObject != null)
    {
      localObject = ((File)localObject).getAbsolutePath();
      paramContext.b(a((String)localObject));
      paramContext.a(b((String)localObject));
      paramContext.a((String)localObject);
    }
    paramContext.a(a.a.a);
    return paramContext;
  }
  
  public static String[] b()
  {
    if (a == null) {
      a = c(com.huawei.updatesdk.sdk.service.a.a.a().b());
    }
    return (String[])a.clone();
  }
  
  private static Method c()
  {
    Object localObject = null;
    try
    {
      Method localMethod = StorageVolume.class.getMethod("isRemovable", new Class[0]);
      localObject = localMethod;
      localMethod.setAccessible(true);
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      com.huawei.updatesdk.sdk.a.c.a.a.a.a("StorageManage", "can not find method:isRemovable", localNoSuchMethodException);
    }
    return (Method)localObject;
  }
  
  private static String[] c(Context paramContext)
  {
    String str = d(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("Android");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("data");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramContext.getPackageName());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("files");
    return new String[] { localStringBuilder.toString() };
  }
  
  private static String d(Context paramContext)
  {
    paramContext = (StorageManager)paramContext.getSystemService("storage");
    StorageVolume[] arrayOfStorageVolume = new StorageVolume[0];
    Method localMethod1;
    try
    {
      localMethod1 = StorageManager.class.getMethod("getVolumeList", new Class[0]);
      localMethod1.setAccessible(true);
      paramContext = (StorageVolume[])localMethod1.invoke(paramContext, new Object[0]);
    }
    catch (InvocationTargetException paramContext) {}catch (IllegalAccessException paramContext) {}catch (NoSuchMethodException paramContext) {}
    com.huawei.updatesdk.sdk.a.c.a.a.a.a("StorageManage", "can not find method:getVolumeList", paramContext);
    paramContext = arrayOfStorageVolume;
    if ((paramContext != null) && (paramContext.length > 0))
    {
      localMethod1 = c();
      Method localMethod2 = d();
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramContext[i];
        boolean bool;
        if (localMethod1 != null)
        {
          try
          {
            bool = ((Boolean)localMethod1.invoke(localObject, new Object[0])).booleanValue();
          }
          catch (InvocationTargetException localInvocationTargetException1) {}catch (IllegalAccessException localIllegalAccessException1) {}
          com.huawei.updatesdk.sdk.a.c.a.a.a.a("StorageManage", "can not invoke method:getVolumeList", localIllegalAccessException1);
        }
        else
        {
          bool = false;
        }
        try
        {
          String str1 = (String)localMethod2.invoke(localObject, new Object[0]);
        }
        catch (InvocationTargetException localInvocationTargetException2) {}catch (IllegalAccessException localIllegalAccessException2) {}
        com.huawei.updatesdk.sdk.a.c.a.a.a.a("StorageManage", "can not invoke method:getPath", localIllegalAccessException2);
        String str2 = "";
        if ((!bool) && (!str2.contains("usb"))) {
          return str2;
        }
        i += 1;
      }
    }
    return null;
  }
  
  private static Method d()
  {
    Object localObject = null;
    try
    {
      Method localMethod = StorageVolume.class.getMethod("getPath", new Class[0]);
      localObject = localMethod;
      localMethod.setAccessible(true);
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      com.huawei.updatesdk.sdk.a.c.a.a.a.a("StorageManage", "can not find method:getPath", localNoSuchMethodException);
    }
    return (Method)localObject;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\support\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */