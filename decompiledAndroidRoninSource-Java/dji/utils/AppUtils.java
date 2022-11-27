package dji.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class AppUtils
{
  private static Application mApplication;
  
  public static Application getApp()
  {
    Application localApplication = mApplication;
    if (localApplication != null) {
      return localApplication;
    }
    localApplication = getApplicationByReflect();
    init(localApplication);
    return localApplication;
  }
  
  private static Application getApplicationByReflect()
  {
    try
    {
      Object localObject1 = Class.forName("android.app.ActivityThread");
      Object localObject2 = ((Class)localObject1).getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
      localObject1 = ((Class)localObject1).getMethod("getApplication", new Class[0]).invoke(localObject2, new Object[0]);
      if (localObject1 != null) {
        return (Application)localObject1;
      }
      throw new NullPointerException();
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      localInvocationTargetException.printStackTrace();
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
    }
    throw null;
  }
  
  public static PackageInfo getPackageInfo(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 16384);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static String getTaskTopActivityName(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((paramContext != null) && (!paramContext.isEmpty())) {
      return ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity.getShortClassName();
    }
    return null;
  }
  
  private static void init(Application paramApplication)
  {
    if (mApplication == null)
    {
      if (paramApplication == null)
      {
        mApplication = getApplicationByReflect();
        return;
      }
      mApplication = paramApplication;
    }
  }
  
  public static void installApk(String paramString)
  {
    Object localObject;
    Intent localIntent;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = new File(Uri.parse(paramString).getPath());
      if (isFileExists((File)localObject))
      {
        paramString = ((File)localObject).getAbsolutePath();
        localIntent = new Intent("android.intent.action.VIEW");
      }
    }
    try
    {
      if (Build.VERSION.SDK_INT >= 24)
      {
        localObject = getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(getApp().getPackageName());
        localStringBuilder.append(".fileprovider");
        paramString = FileProvider.getUriForFile((Context)localObject, localStringBuilder.toString(), new File(paramString));
        localIntent.setFlags(1);
      }
      else
      {
        paramString = Uri.fromFile((File)localObject);
      }
      localIntent.setDataAndType(paramString, "application/vnd.android.package-archive");
      localIntent.addFlags(268435456);
      getApp().startActivity(localIntent);
      return;
    }
    catch (NullPointerException paramString) {}
  }
  
  private static boolean isFileExists(File paramFile)
  {
    return (paramFile != null) && (paramFile.exists());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dj\\utils\AppUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */