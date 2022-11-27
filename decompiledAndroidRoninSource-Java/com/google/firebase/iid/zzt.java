package com.google.firebase.iid;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.heartbeatinfo.HeartBeatInfo.HeartBeat;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public final class zzt
{
  private final FirebaseApp zza;
  private final zzao zzb;
  private final zzau zzc;
  private final Executor zzd;
  private final UserAgentPublisher zze;
  private final HeartBeatInfo zzf;
  private final FirebaseInstallationsApi zzg;
  
  private zzt(FirebaseApp paramFirebaseApp, zzao paramzzao, Executor paramExecutor, zzau paramzzau, UserAgentPublisher paramUserAgentPublisher, HeartBeatInfo paramHeartBeatInfo, FirebaseInstallationsApi paramFirebaseInstallationsApi)
  {
    this.zza = paramFirebaseApp;
    this.zzb = paramzzao;
    this.zzc = paramzzau;
    this.zzd = paramExecutor;
    this.zze = paramUserAgentPublisher;
    this.zzf = paramHeartBeatInfo;
    this.zzg = paramFirebaseInstallationsApi;
  }
  
  public zzt(FirebaseApp paramFirebaseApp, zzao paramzzao, Executor paramExecutor, UserAgentPublisher paramUserAgentPublisher, HeartBeatInfo paramHeartBeatInfo, FirebaseInstallationsApi paramFirebaseInstallationsApi)
  {
    this(paramFirebaseApp, paramzzao, paramExecutor, new zzau(paramFirebaseApp.getApplicationContext(), paramzzao), paramUserAgentPublisher, paramHeartBeatInfo, paramFirebaseInstallationsApi);
  }
  
  private static <T> Task<Void> zza(Task<T> paramTask)
  {
    return paramTask.continueWith(zzh.zza(), zzv.zza);
  }
  
  private final Task<Bundle> zza(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    this.zzd.execute(new zzs(this, paramString1, paramString2, paramString3, paramBundle, localTaskCompletionSource));
    return localTaskCompletionSource.getTask();
  }
  
  private final String zza()
  {
    String str = this.zza.getName();
    try
    {
      str = Base64.encodeToString(MessageDigest.getInstance("SHA-1").digest(str.getBytes()), 11);
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      for (;;) {}
    }
    return "[HASH-ERROR]";
  }
  
  private final Bundle zzb(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    paramBundle.putString("scope", paramString3);
    paramBundle.putString("sender", paramString2);
    paramBundle.putString("subtype", paramString2);
    paramBundle.putString("appid", paramString1);
    paramBundle.putString("gmp_app_id", this.zza.getOptions().getApplicationId());
    paramBundle.putString("gmsv", Integer.toString(this.zzb.zze()));
    paramBundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
    paramBundle.putString("app_ver", this.zzb.zzc());
    paramBundle.putString("app_ver_name", this.zzb.zzd());
    paramBundle.putString("firebase-app-name-hash", zza());
    try
    {
      paramString1 = ((InstallationTokenResult)Tasks.await(this.zzg.getToken(false))).getToken();
      if (!TextUtils.isEmpty(paramString1)) {
        paramBundle.putString("Goog-Firebase-Installations-Auth", paramString1);
      } else {
        Log.w("FirebaseInstanceId", "FIS auth token is empty");
      }
    }
    catch (InterruptedException paramString1) {}catch (ExecutionException paramString1) {}
    Log.e("FirebaseInstanceId", "Failed to get FIS auth token", paramString1);
    paramString2 = LibraryVersion.getInstance().getVersion("firebase-iid");
    paramString1 = paramString2;
    if ("UNKNOWN".equals(paramString2))
    {
      int i = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
      paramString1 = new StringBuilder(19);
      paramString1.append("unknown_");
      paramString1.append(i);
      paramString1 = paramString1.toString();
    }
    paramString1 = String.valueOf(paramString1);
    if (paramString1.length() != 0) {
      paramString1 = "fiid-".concat(paramString1);
    } else {
      paramString1 = new String("fiid-");
    }
    paramBundle.putString("cliv", paramString1);
    paramString1 = this.zzf.getHeartBeatCode("fire-iid");
    if (paramString1 != HeartBeatInfo.HeartBeat.NONE)
    {
      paramBundle.putString("Firebase-Client-Log-Type", Integer.toString(paramString1.getCode()));
      paramBundle.putString("Firebase-Client", this.zze.getUserAgent());
    }
    return paramBundle;
  }
  
  private final Task<String> zzb(Task<Bundle> paramTask)
  {
    return paramTask.continueWith(this.zzd, new zzu(this));
  }
  
  public final Task<String> zza(String paramString1, String paramString2, String paramString3)
  {
    return zzb(zza(paramString1, paramString2, paramString3, new Bundle()));
  }
  
  public final Task<Void> zzb(String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("delete", "1");
    return zza(zzb(zza(paramString1, paramString2, paramString3, localBundle)));
  }
  
  public final Task<Void> zzc(String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    String str = String.valueOf(paramString3);
    if (str.length() != 0) {
      str = "/topics/".concat(str);
    } else {
      str = new String("/topics/");
    }
    localBundle.putString("gcm.topic", str);
    paramString3 = String.valueOf(paramString3);
    if (paramString3.length() != 0) {
      paramString3 = "/topics/".concat(paramString3);
    } else {
      paramString3 = new String("/topics/");
    }
    return zza(zzb(zza(paramString1, paramString2, paramString3, localBundle)));
  }
  
  public final Task<Void> zzd(String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    String str = String.valueOf(paramString3);
    if (str.length() != 0) {
      str = "/topics/".concat(str);
    } else {
      str = new String("/topics/");
    }
    localBundle.putString("gcm.topic", str);
    localBundle.putString("delete", "1");
    paramString3 = String.valueOf(paramString3);
    if (paramString3.length() != 0) {
      paramString3 = "/topics/".concat(paramString3);
    } else {
      paramString3 = new String("/topics/");
    }
    return zza(zzb(zza(paramString1, paramString2, paramString3, localBundle)));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\iid\zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */