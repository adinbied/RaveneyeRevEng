package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirebaseInstanceId
{
  private static final long zza = TimeUnit.HOURS.toSeconds(8L);
  private static zzaz zzb;
  private static final Pattern zzc = Pattern.compile("\\AA[\\w-]{38}\\z");
  private static ScheduledExecutorService zzd;
  private final Executor zze;
  private final FirebaseApp zzf;
  private final zzao zzg;
  private final zzt zzh;
  private final zzat zzi;
  private final FirebaseInstallationsApi zzj;
  private boolean zzk = false;
  private final zza zzl;
  
  FirebaseInstanceId(FirebaseApp paramFirebaseApp, Subscriber paramSubscriber, UserAgentPublisher paramUserAgentPublisher, HeartBeatInfo paramHeartBeatInfo, FirebaseInstallationsApi paramFirebaseInstallationsApi)
  {
    this(paramFirebaseApp, new zzao(paramFirebaseApp.getApplicationContext()), zzh.zzb(), zzh.zzb(), paramSubscriber, paramUserAgentPublisher, paramHeartBeatInfo, paramFirebaseInstallationsApi);
  }
  
  private FirebaseInstanceId(FirebaseApp paramFirebaseApp, zzao paramzzao, Executor paramExecutor1, Executor paramExecutor2, Subscriber paramSubscriber, UserAgentPublisher paramUserAgentPublisher, HeartBeatInfo paramHeartBeatInfo, FirebaseInstallationsApi paramFirebaseInstallationsApi)
  {
    if (zzao.zza(paramFirebaseApp) != null) {
      try
      {
        if (zzb == null) {
          zzb = new zzaz(paramFirebaseApp.getApplicationContext());
        }
        this.zzf = paramFirebaseApp;
        this.zzg = paramzzao;
        this.zzh = new zzt(paramFirebaseApp, paramzzao, paramExecutor1, paramUserAgentPublisher, paramHeartBeatInfo, paramFirebaseInstallationsApi);
        this.zze = paramExecutor2;
        this.zzl = new zza(paramSubscriber);
        this.zzi = new zzat(paramExecutor1);
        this.zzj = paramFirebaseInstallationsApi;
        paramExecutor2.execute(new zzl(this));
        return;
      }
      finally {}
    }
    throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
  }
  
  public static FirebaseInstanceId getInstance()
  {
    return getInstance(FirebaseApp.getInstance());
  }
  
  public static FirebaseInstanceId getInstance(FirebaseApp paramFirebaseApp)
  {
    zza(paramFirebaseApp);
    return (FirebaseInstanceId)paramFirebaseApp.get(FirebaseInstanceId.class);
  }
  
  private final Task<InstanceIdResult> zza(String paramString1, String paramString2)
  {
    paramString2 = zza(paramString2);
    return Tasks.forResult(null).continueWithTask(this.zze, new zzk(this, paramString1, paramString2));
  }
  
  private final <T> T zza(Task<T> paramTask)
    throws IOException
  {
    try
    {
      paramTask = Tasks.await(paramTask, 30000L, TimeUnit.MILLISECONDS);
      return paramTask;
    }
    catch (ExecutionException paramTask)
    {
      Throwable localThrowable = paramTask.getCause();
      if (!(localThrowable instanceof IOException)) {
        break label57;
      }
      if (!"INSTANCE_ID_RESET".equals(localThrowable.getMessage())) {
        break label52;
      }
      zze();
      throw ((IOException)localThrowable);
      if (!(localThrowable instanceof RuntimeException)) {
        break label69;
      }
      throw ((RuntimeException)localThrowable);
      throw new IOException(paramTask);
    }
    catch (InterruptedException|TimeoutException paramTask)
    {
      label52:
      label57:
      label69:
      for (;;) {}
    }
    throw new IOException("SERVICE_NOT_AVAILABLE");
  }
  
  private static String zza(String paramString)
  {
    if ((!paramString.isEmpty()) && (!paramString.equalsIgnoreCase("fcm")) && (!paramString.equalsIgnoreCase("gcm"))) {
      return paramString;
    }
    return "*";
  }
  
  private static void zza(FirebaseApp paramFirebaseApp)
  {
    Preconditions.checkNotEmpty(paramFirebaseApp.getOptions().getProjectId(), "Please set your project ID. A valid Firebase project ID is required to communicate with Firebase server APIs: It identifies your project with Google.");
    Preconditions.checkNotEmpty(paramFirebaseApp.getOptions().getApplicationId(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.");
    Preconditions.checkNotEmpty(paramFirebaseApp.getOptions().getApiKey(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.");
    Preconditions.checkArgument(paramFirebaseApp.getOptions().getApplicationId().contains(":"), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
    paramFirebaseApp = paramFirebaseApp.getOptions().getApiKey();
    Preconditions.checkArgument(zzc.matcher(paramFirebaseApp).matches(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
  }
  
  static void zza(Runnable paramRunnable, long paramLong)
  {
    try
    {
      if (zzd == null) {
        zzd = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("FirebaseInstanceId"));
      }
      zzd.schedule(paramRunnable, paramLong, TimeUnit.SECONDS);
      return;
    }
    finally {}
  }
  
  private final zzay zzb(String paramString1, String paramString2)
  {
    return zzb.zza(zzm(), paramString1, paramString2);
  }
  
  static boolean zzd()
  {
    return (Log.isLoggable("FirebaseInstanceId", 3)) || ((Build.VERSION.SDK_INT == 23) && (Log.isLoggable("FirebaseInstanceId", 3)));
  }
  
  private final void zzj()
  {
    if (zza(zzb())) {
      zzk();
    }
  }
  
  private final void zzk()
  {
    try
    {
      if (!this.zzk) {
        zza(0L);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private final String zzl()
  {
    try
    {
      zzb.zzb(this.zzf.getPersistenceKey());
      Task localTask = this.zzj.getId();
      Preconditions.checkNotNull(localTask, "Task must not be null");
      CountDownLatch localCountDownLatch = new CountDownLatch(1);
      localTask.addOnCompleteListener(zzn.zza, new zzm(localCountDownLatch));
      localCountDownLatch.await(30000L, TimeUnit.MILLISECONDS);
      if (localTask.isSuccessful()) {
        return (String)localTask.getResult();
      }
      if (localTask.isCanceled()) {
        throw new CancellationException("Task is already canceled");
      }
      throw new IllegalStateException(localTask.getException());
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new IllegalStateException(localInterruptedException);
    }
  }
  
  private final String zzm()
  {
    if ("[DEFAULT]".equals(this.zzf.getName())) {
      return "";
    }
    return this.zzf.getPersistenceKey();
  }
  
  public void deleteInstanceId()
    throws IOException
  {
    zza(this.zzf);
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      zza(this.zzj.delete());
      zze();
      return;
    }
    throw new IOException("MAIN_THREAD");
  }
  
  public void deleteToken(String paramString1, String paramString2)
    throws IOException
  {
    zza(this.zzf);
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      paramString2 = zza(paramString2);
      String str = zzl();
      zza(this.zzh.zzb(str, paramString1, paramString2));
      zzb.zzb(zzm(), paramString1, paramString2);
      return;
    }
    throw new IOException("MAIN_THREAD");
  }
  
  public long getCreationTime()
  {
    return zzb.zza(this.zzf.getPersistenceKey());
  }
  
  public String getId()
  {
    zza(this.zzf);
    zzj();
    return zzl();
  }
  
  public Task<InstanceIdResult> getInstanceId()
  {
    zza(this.zzf);
    return zza(zzao.zza(this.zzf), "*");
  }
  
  @Deprecated
  public String getToken()
  {
    zza(this.zzf);
    zzay localzzay = zzb();
    if (zza(localzzay)) {
      zzk();
    }
    return zzay.zza(localzzay);
  }
  
  public String getToken(String paramString1, String paramString2)
    throws IOException
  {
    zza(this.zzf);
    if (Looper.getMainLooper() != Looper.myLooper()) {
      return ((InstanceIdResult)zza(zza(paramString1, paramString2))).getToken();
    }
    throw new IOException("MAIN_THREAD");
  }
  
  final FirebaseApp zza()
  {
    return this.zzf;
  }
  
  final void zza(long paramLong)
  {
    try
    {
      zza(new zzbb(this, Math.min(Math.max(30L, paramLong << 1), zza)), paramLong);
      this.zzk = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final void zza(boolean paramBoolean)
  {
    try
    {
      this.zzk = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final boolean zza(zzay paramzzay)
  {
    return (paramzzay == null) || (paramzzay.zzb(this.zzg.zzc()));
  }
  
  final zzay zzb()
  {
    return zzb(zzao.zza(this.zzf), "*");
  }
  
  public final void zzb(boolean paramBoolean)
  {
    this.zzl.zza(paramBoolean);
  }
  
  final String zzc()
    throws IOException
  {
    return getToken(zzao.zza(this.zzf), "*");
  }
  
  final void zze()
  {
    try
    {
      zzb.zza();
      if (this.zzl.zza()) {
        zzk();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean zzf()
  {
    return this.zzg.zza();
  }
  
  final void zzg()
  {
    zzb.zzc(zzm());
    zzk();
  }
  
  public final boolean zzh()
  {
    return this.zzl.zza();
  }
  
  private final class zza
  {
    private boolean zzb;
    private final Subscriber zzc;
    private boolean zzd;
    private EventHandler<DataCollectionDefaultChange> zze;
    private Boolean zzf;
    
    zza(Subscriber paramSubscriber)
    {
      this.zzc = paramSubscriber;
    }
    
    private final void zzb()
    {
      try
      {
        boolean bool = this.zzd;
        if (bool) {
          return;
        }
        this.zzb = zzd();
        Object localObject1 = zzc();
        this.zzf = ((Boolean)localObject1);
        if ((localObject1 == null) && (this.zzb))
        {
          localObject1 = new zzq(this);
          this.zze = ((EventHandler)localObject1);
          this.zzc.subscribe(DataCollectionDefaultChange.class, (EventHandler)localObject1);
        }
        this.zzd = true;
        return;
      }
      finally {}
    }
    
    private final Boolean zzc()
    {
      Object localObject1 = FirebaseInstanceId.zza(FirebaseInstanceId.this).getApplicationContext();
      Object localObject2 = ((Context)localObject1).getSharedPreferences("com.google.firebase.messaging", 0);
      if (((SharedPreferences)localObject2).contains("auto_init")) {
        return Boolean.valueOf(((SharedPreferences)localObject2).getBoolean("auto_init", false));
      }
      try
      {
        localObject2 = ((Context)localObject1).getPackageManager();
        if (localObject2 != null)
        {
          localObject1 = ((PackageManager)localObject2).getApplicationInfo(((Context)localObject1).getPackageName(), 128);
          if ((localObject1 != null) && (((ApplicationInfo)localObject1).metaData != null) && (((ApplicationInfo)localObject1).metaData.containsKey("firebase_messaging_auto_init_enabled")))
          {
            boolean bool = ((ApplicationInfo)localObject1).metaData.getBoolean("firebase_messaging_auto_init_enabled");
            return Boolean.valueOf(bool);
          }
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;) {}
      }
      return null;
    }
    
    private final boolean zzd()
    {
      try
      {
        Class.forName("com.google.firebase.messaging.FirebaseMessaging");
        return true;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Object localObject;
        Intent localIntent;
        for (;;) {}
      }
      localObject = FirebaseInstanceId.zza(FirebaseInstanceId.this).getApplicationContext();
      localIntent = new Intent("com.google.firebase.MESSAGING_EVENT");
      localIntent.setPackage(((Context)localObject).getPackageName());
      localObject = ((Context)localObject).getPackageManager().resolveService(localIntent, 0);
      return (localObject != null) && (((ResolveInfo)localObject).serviceInfo != null);
    }
    
    final void zza(boolean paramBoolean)
    {
      try
      {
        zzb();
        if (this.zze != null)
        {
          this.zzc.unsubscribe(DataCollectionDefaultChange.class, this.zze);
          this.zze = null;
        }
        SharedPreferences.Editor localEditor = FirebaseInstanceId.zza(FirebaseInstanceId.this).getApplicationContext().getSharedPreferences("com.google.firebase.messaging", 0).edit();
        localEditor.putBoolean("auto_init", paramBoolean);
        localEditor.apply();
        if (paramBoolean) {
          FirebaseInstanceId.zzb(FirebaseInstanceId.this);
        }
        this.zzf = Boolean.valueOf(paramBoolean);
        return;
      }
      finally {}
    }
    
    final boolean zza()
    {
      try
      {
        zzb();
        boolean bool;
        if (this.zzf != null)
        {
          bool = this.zzf.booleanValue();
          return bool;
        }
        if (this.zzb)
        {
          bool = FirebaseInstanceId.zza(FirebaseInstanceId.this).isDataCollectionDefaultEnabled();
          if (bool) {
            return true;
          }
        }
        return false;
      }
      finally {}
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\iid\FirebaseInstanceId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */