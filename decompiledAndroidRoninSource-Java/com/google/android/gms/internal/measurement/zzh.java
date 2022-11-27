package com.google.android.gms.internal.measurement;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.UserHandle;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzh
{
  private static final Method zzb = ;
  private static final Method zzc = zzb();
  private final JobScheduler zza;
  
  private zzh(JobScheduler paramJobScheduler)
  {
    this.zza = paramJobScheduler;
  }
  
  private final int zza(JobInfo paramJobInfo, String paramString1, int paramInt, String paramString2)
  {
    Method localMethod = zzb;
    if (localMethod != null)
    {
      try
      {
        paramInt = ((Integer)localMethod.invoke(this.zza, new Object[] { paramJobInfo, paramString1, Integer.valueOf(paramInt), paramString2 })).intValue();
        return paramInt;
      }
      catch (InvocationTargetException paramString1) {}catch (IllegalAccessException paramString1) {}
      Log.e(paramString2, "error calling scheduleAsPackage", paramString1);
    }
    return this.zza.schedule(paramJobInfo);
  }
  
  public static int zza(Context paramContext, JobInfo paramJobInfo, String paramString1, String paramString2)
  {
    JobScheduler localJobScheduler = (JobScheduler)paramContext.getSystemService("jobscheduler");
    if ((zzb != null) && (paramContext.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS") == 0)) {
      return new zzh(localJobScheduler).zza(paramJobInfo, paramString1, zzc(), paramString2);
    }
    return localJobScheduler.schedule(paramJobInfo);
  }
  
  private static Method zza()
  {
    if (Build.VERSION.SDK_INT >= 24) {}
    try
    {
      Method localMethod = JobScheduler.class.getDeclaredMethod("scheduleAsPackage", new Class[] { JobInfo.class, String.class, Integer.TYPE, String.class });
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
    if (Log.isLoggable("JobSchedulerCompat", 6)) {
      Log.e("JobSchedulerCompat", "No scheduleAsPackage method available, falling back to schedule");
    }
    return null;
  }
  
  private static Method zzb()
  {
    if (Build.VERSION.SDK_INT >= 24) {}
    try
    {
      Method localMethod = UserHandle.class.getDeclaredMethod("myUserId", null);
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
    if (Log.isLoggable("JobSchedulerCompat", 6)) {
      Log.e("JobSchedulerCompat", "No myUserId method available");
    }
    return null;
  }
  
  private static int zzc()
  {
    Method localMethod = zzc;
    if (localMethod != null)
    {
      try
      {
        int i = ((Integer)localMethod.invoke(null, new Object[0])).intValue();
        return i;
      }
      catch (InvocationTargetException localInvocationTargetException) {}catch (IllegalAccessException localIllegalAccessException) {}
      if (Log.isLoggable("JobSchedulerCompat", 6)) {
        Log.e("JobSchedulerCompat", "myUserId invocation illegal", localIllegalAccessException);
      }
    }
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */