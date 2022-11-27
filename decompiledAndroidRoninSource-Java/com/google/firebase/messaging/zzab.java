package com.google.firebase.messaging;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.iid.zzao;
import com.google.firebase.iid.zzt;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class zzab
{
  private static final long zza = TimeUnit.HOURS.toSeconds(8L);
  private final FirebaseInstanceId zzb;
  private final Context zzc;
  private final zzao zzd;
  private final zzt zze;
  private final Map<String, ArrayDeque<TaskCompletionSource<Void>>> zzf = new ArrayMap();
  private final ScheduledExecutorService zzg;
  private boolean zzh = false;
  private final zzy zzi;
  
  private zzab(FirebaseInstanceId paramFirebaseInstanceId, zzao paramzzao, zzy paramzzy, zzt paramzzt, Context paramContext, ScheduledExecutorService paramScheduledExecutorService)
  {
    this.zzb = paramFirebaseInstanceId;
    this.zzd = paramzzao;
    this.zzi = paramzzy;
    this.zze = paramzzt;
    this.zzc = paramContext;
    this.zzg = paramScheduledExecutorService;
  }
  
  static Task<zzab> zza(FirebaseApp paramFirebaseApp, FirebaseInstanceId paramFirebaseInstanceId, zzao paramzzao, UserAgentPublisher paramUserAgentPublisher, HeartBeatInfo paramHeartBeatInfo, FirebaseInstallationsApi paramFirebaseInstallationsApi, Context paramContext, Executor paramExecutor, ScheduledExecutorService paramScheduledExecutorService)
  {
    return Tasks.call(paramScheduledExecutorService, new zzaa(paramContext, paramScheduledExecutorService, paramFirebaseInstanceId, paramzzao, new zzt(paramFirebaseApp, paramzzao, paramExecutor, paramUserAgentPublisher, paramHeartBeatInfo, paramFirebaseInstallationsApi)));
  }
  
  private static <T> T zza(Task<T> paramTask)
    throws IOException
  {
    try
    {
      try
      {
        paramTask = Tasks.await(paramTask, 30L, TimeUnit.SECONDS);
        return paramTask;
      }
      catch (TimeoutException paramTask) {}catch (InterruptedException paramTask) {}
      throw new IOException("SERVICE_NOT_AVAILABLE", paramTask);
    }
    catch (ExecutionException paramTask)
    {
      Throwable localThrowable = paramTask.getCause();
      if (!(localThrowable instanceof IOException))
      {
        if ((localThrowable instanceof RuntimeException)) {
          throw ((RuntimeException)localThrowable);
        }
        throw new IOException(paramTask);
      }
      throw ((IOException)localThrowable);
    }
  }
  
  private final boolean zzb(zzz paramzzz)
    throws IOException
  {
    try
    {
      localObject = paramzzz.zzb();
      int i = -1;
      int j = ((String)localObject).hashCode();
      if (j != 83)
      {
        if ((j == 85) && (((String)localObject).equals("U"))) {
          i = 1;
        }
      }
      else
      {
        boolean bool = ((String)localObject).equals("S");
        if (bool) {
          i = 0;
        }
      }
      InstanceIdResult localInstanceIdResult;
      if (i != 0)
      {
        if (i != 1)
        {
          if (zzd())
          {
            paramzzz = String.valueOf(paramzzz);
            localObject = new StringBuilder(String.valueOf(paramzzz).length() + 24);
            ((StringBuilder)localObject).append("Unknown topic operation");
            ((StringBuilder)localObject).append(paramzzz);
            ((StringBuilder)localObject).append(".");
            Log.d("FirebaseMessaging", ((StringBuilder)localObject).toString());
            return true;
          }
        }
        else
        {
          localObject = paramzzz.zza();
          localInstanceIdResult = (InstanceIdResult)zza(this.zzb.getInstanceId());
          zza(this.zze.zzd(localInstanceIdResult.getId(), localInstanceIdResult.getToken(), (String)localObject));
          if (zzd())
          {
            paramzzz = paramzzz.zza();
            localObject = new StringBuilder(String.valueOf(paramzzz).length() + 35);
            ((StringBuilder)localObject).append("Unsubscribe from topic: ");
            ((StringBuilder)localObject).append(paramzzz);
            ((StringBuilder)localObject).append(" succeeded.");
            Log.d("FirebaseMessaging", ((StringBuilder)localObject).toString());
            return true;
          }
        }
      }
      else
      {
        localObject = paramzzz.zza();
        localInstanceIdResult = (InstanceIdResult)zza(this.zzb.getInstanceId());
        zza(this.zze.zzc(localInstanceIdResult.getId(), localInstanceIdResult.getToken(), (String)localObject));
        if (zzd())
        {
          paramzzz = paramzzz.zza();
          localObject = new StringBuilder(String.valueOf(paramzzz).length() + 31);
          ((StringBuilder)localObject).append("Subscribe to topic: ");
          ((StringBuilder)localObject).append(paramzzz);
          ((StringBuilder)localObject).append(" succeeded.");
          Log.d("FirebaseMessaging", ((StringBuilder)localObject).toString());
        }
      }
      return true;
    }
    catch (IOException paramzzz)
    {
      if ((!"SERVICE_NOT_AVAILABLE".equals(paramzzz.getMessage())) && (!"INTERNAL_SERVER_ERROR".equals(paramzzz.getMessage())))
      {
        if (paramzzz.getMessage() == null)
        {
          Log.e("FirebaseMessaging", "Topic operation failed without exception message. Will retry Topic operation.");
          return false;
        }
        throw paramzzz;
      }
      paramzzz = paramzzz.getMessage();
      Object localObject = new StringBuilder(String.valueOf(paramzzz).length() + 53);
      ((StringBuilder)localObject).append("Topic operation failed: ");
      ((StringBuilder)localObject).append(paramzzz);
      ((StringBuilder)localObject).append(". Will retry Topic operation.");
      Log.e("FirebaseMessaging", ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  private final boolean zzc()
  {
    try
    {
      boolean bool = this.zzh;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static boolean zzd()
  {
    return (Log.isLoggable("FirebaseMessaging", 3)) || ((Build.VERSION.SDK_INT == 23) && (Log.isLoggable("FirebaseMessaging", 3)));
  }
  
  final Task<Void> zza(zzz paramzzz)
  {
    this.zzi.zza(paramzzz);
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    synchronized (this.zzf)
    {
      String str = paramzzz.zzc();
      if (this.zzf.containsKey(str))
      {
        paramzzz = (ArrayDeque)this.zzf.get(str);
      }
      else
      {
        paramzzz = new ArrayDeque();
        this.zzf.put(str, paramzzz);
      }
      paramzzz.add(localTaskCompletionSource);
      return localTaskCompletionSource.getTask();
    }
  }
  
  final void zza()
  {
    int i;
    if (this.zzi.zza() != null) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (!zzc())) {
      zza(0L);
    }
  }
  
  final void zza(long paramLong)
  {
    long l = Math.min(Math.max(30L, paramLong << 1), zza);
    zza(new zzad(this, this.zzc, this.zzd, l), paramLong);
    zza(true);
  }
  
  final void zza(Runnable paramRunnable, long paramLong)
  {
    this.zzg.schedule(paramRunnable, paramLong, TimeUnit.SECONDS);
  }
  
  final void zza(boolean paramBoolean)
  {
    try
    {
      this.zzh = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  final boolean zzb()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 57	com/google/firebase/messaging/zzab:zzi	Lcom/google/firebase/messaging/zzy;
    //   6: invokevirtual 267	com/google/firebase/messaging/zzy:zza	()Lcom/google/firebase/messaging/zzz;
    //   9: astore_2
    //   10: aload_2
    //   11: ifnonnull +22 -> 33
    //   14: invokestatic 149	com/google/firebase/messaging/zzab:zzd	()Z
    //   17: ifeq +12 -> 29
    //   20: ldc -85
    //   22: ldc_w 300
    //   25: invokestatic 180	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   28: pop
    //   29: aload_0
    //   30: monitorexit
    //   31: iconst_1
    //   32: ireturn
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_0
    //   36: aload_2
    //   37: invokespecial 302	com/google/firebase/messaging/zzab:zzb	(Lcom/google/firebase/messaging/zzz;)Z
    //   40: ifne +5 -> 45
    //   43: iconst_0
    //   44: ireturn
    //   45: aload_0
    //   46: getfield 57	com/google/firebase/messaging/zzab:zzi	Lcom/google/firebase/messaging/zzy;
    //   49: aload_2
    //   50: invokevirtual 303	com/google/firebase/messaging/zzy:zzb	(Lcom/google/firebase/messaging/zzz;)Z
    //   53: pop
    //   54: aload_0
    //   55: getfield 49	com/google/firebase/messaging/zzab:zzf	Ljava/util/Map;
    //   58: astore_1
    //   59: aload_1
    //   60: monitorenter
    //   61: aload_2
    //   62: invokevirtual 241	com/google/firebase/messaging/zzz:zzc	()Ljava/lang/String;
    //   65: astore_2
    //   66: aload_0
    //   67: getfield 49	com/google/firebase/messaging/zzab:zzf	Ljava/util/Map;
    //   70: aload_2
    //   71: invokeinterface 246 2 0
    //   76: ifne +8 -> 84
    //   79: aload_1
    //   80: monitorexit
    //   81: goto -81 -> 0
    //   84: aload_0
    //   85: getfield 49	com/google/firebase/messaging/zzab:zzf	Ljava/util/Map;
    //   88: aload_2
    //   89: invokeinterface 250 2 0
    //   94: checkcast 252	java/util/ArrayDeque
    //   97: astore_3
    //   98: aload_3
    //   99: invokevirtual 307	java/util/ArrayDeque:poll	()Ljava/lang/Object;
    //   102: checkcast 238	com/google/android/gms/tasks/TaskCompletionSource
    //   105: astore 4
    //   107: aload 4
    //   109: ifnull +9 -> 118
    //   112: aload 4
    //   114: aconst_null
    //   115: invokevirtual 311	com/google/android/gms/tasks/TaskCompletionSource:setResult	(Ljava/lang/Object;)V
    //   118: aload_3
    //   119: invokevirtual 314	java/util/ArrayDeque:isEmpty	()Z
    //   122: ifeq +14 -> 136
    //   125: aload_0
    //   126: getfield 49	com/google/firebase/messaging/zzab:zzf	Ljava/util/Map;
    //   129: aload_2
    //   130: invokeinterface 317 2 0
    //   135: pop
    //   136: aload_1
    //   137: monitorexit
    //   138: goto -138 -> 0
    //   141: astore_2
    //   142: aload_1
    //   143: monitorexit
    //   144: aload_2
    //   145: athrow
    //   146: astore_1
    //   147: aload_0
    //   148: monitorexit
    //   149: aload_1
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	zzab
    //   146	4	1	localObject1	Object
    //   9	121	2	localObject2	Object
    //   141	4	2	localObject3	Object
    //   97	22	3	localArrayDeque	ArrayDeque
    //   105	8	4	localTaskCompletionSource	TaskCompletionSource
    // Exception table:
    //   from	to	target	type
    //   61	81	141	finally
    //   84	107	141	finally
    //   112	118	141	finally
    //   118	136	141	finally
    //   136	138	141	finally
    //   142	144	141	finally
    //   2	10	146	finally
    //   14	29	146	finally
    //   29	31	146	finally
    //   33	35	146	finally
    //   147	149	146	finally
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\messaging\zzab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */