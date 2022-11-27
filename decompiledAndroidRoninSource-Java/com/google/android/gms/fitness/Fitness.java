package com.google.android.gms.fitness;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.fitness.zzab;
import com.google.android.gms.internal.fitness.zzag;
import com.google.android.gms.internal.fitness.zzam;
import com.google.android.gms.internal.fitness.zzas;
import com.google.android.gms.internal.fitness.zzay;
import com.google.android.gms.internal.fitness.zzct;
import com.google.android.gms.internal.fitness.zzdb;
import com.google.android.gms.internal.fitness.zzdg;
import com.google.android.gms.internal.fitness.zzdj;
import com.google.android.gms.internal.fitness.zzdt;
import com.google.android.gms.internal.fitness.zzea;
import com.google.android.gms.internal.fitness.zzee;
import com.google.android.gms.internal.fitness.zzeq;
import com.google.android.gms.internal.fitness.zzp;
import com.google.android.gms.internal.fitness.zzv;
import java.util.concurrent.TimeUnit;

public class Fitness
{
  public static final String ACTION_TRACK = "vnd.google.fitness.TRACK";
  public static final String ACTION_VIEW = "vnd.google.fitness.VIEW";
  public static final String ACTION_VIEW_GOAL = "vnd.google.fitness.VIEW_GOAL";
  @Deprecated
  public static final Void API;
  public static final Api<Api.ApiOptions.NoOptions> BLE_API;
  public static final BleApi BleApi;
  public static final Api<Api.ApiOptions.NoOptions> CONFIG_API;
  public static final ConfigApi ConfigApi;
  public static final String EXTRA_END_TIME = "vnd.google.fitness.end_time";
  public static final String EXTRA_START_TIME = "vnd.google.fitness.start_time";
  public static final Api<Api.ApiOptions.NoOptions> GOALS_API;
  public static final GoalsApi GoalsApi;
  public static final Api<Api.ApiOptions.NoOptions> HISTORY_API;
  public static final HistoryApi HistoryApi;
  public static final Api<Api.ApiOptions.NoOptions> RECORDING_API;
  public static final RecordingApi RecordingApi;
  public static final Scope SCOPE_ACTIVITY_READ;
  public static final Scope SCOPE_ACTIVITY_READ_WRITE;
  public static final Scope SCOPE_BODY_READ = new Scope("https://www.googleapis.com/auth/fitness.body.read");
  public static final Scope SCOPE_BODY_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.body.write");
  public static final Scope SCOPE_LOCATION_READ;
  public static final Scope SCOPE_LOCATION_READ_WRITE;
  public static final Scope SCOPE_NUTRITION_READ = new Scope("https://www.googleapis.com/auth/fitness.nutrition.read");
  public static final Scope SCOPE_NUTRITION_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.nutrition.write");
  public static final Api<Api.ApiOptions.NoOptions> SENSORS_API = zzas.API;
  public static final Api<Api.ApiOptions.NoOptions> SESSIONS_API;
  public static final SensorsApi SensorsApi = new zzea();
  public static final SessionsApi SessionsApi;
  
  static
  {
    RECORDING_API = zzam.API;
    RecordingApi = new zzdt();
    SESSIONS_API = zzay.API;
    SessionsApi = new zzee();
    HISTORY_API = zzag.API;
    HistoryApi = new zzdj();
    GOALS_API = zzab.API;
    GoalsApi = new zzdg();
    CONFIG_API = zzv.API;
    ConfigApi = new zzdb();
    BLE_API = zzp.API;
    Object localObject;
    if (Build.VERSION.SDK_INT >= 18) {
      localObject = new zzct();
    } else {
      localObject = new zzeq();
    }
    BleApi = (BleApi)localObject;
    SCOPE_ACTIVITY_READ = new Scope("https://www.googleapis.com/auth/fitness.activity.read");
    SCOPE_ACTIVITY_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.activity.write");
    SCOPE_LOCATION_READ = new Scope("https://www.googleapis.com/auth/fitness.location.read");
    SCOPE_LOCATION_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.location.write");
  }
  
  public static BleClient getBleClient(Activity paramActivity, GoogleSignInAccount paramGoogleSignInAccount)
  {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    return new BleClient(paramActivity, FitnessOptions.zza(paramGoogleSignInAccount).build());
  }
  
  public static BleClient getBleClient(Context paramContext, GoogleSignInAccount paramGoogleSignInAccount)
  {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    return new BleClient(paramContext, FitnessOptions.zza(paramGoogleSignInAccount).build());
  }
  
  public static ConfigClient getConfigClient(Activity paramActivity, GoogleSignInAccount paramGoogleSignInAccount)
  {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    return new ConfigClient(paramActivity, FitnessOptions.zza(paramGoogleSignInAccount).build());
  }
  
  public static ConfigClient getConfigClient(Context paramContext, GoogleSignInAccount paramGoogleSignInAccount)
  {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    return new ConfigClient(paramContext, FitnessOptions.zza(paramGoogleSignInAccount).build());
  }
  
  public static long getEndTime(Intent paramIntent, TimeUnit paramTimeUnit)
  {
    long l = paramIntent.getLongExtra("vnd.google.fitness.end_time", -1L);
    if (l == -1L) {
      return -1L;
    }
    return paramTimeUnit.convert(l, TimeUnit.MILLISECONDS);
  }
  
  public static GoalsClient getGoalsClient(Activity paramActivity, GoogleSignInAccount paramGoogleSignInAccount)
  {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    return new GoalsClient(paramActivity, FitnessOptions.zza(paramGoogleSignInAccount).build());
  }
  
  public static GoalsClient getGoalsClient(Context paramContext, GoogleSignInAccount paramGoogleSignInAccount)
  {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    return new GoalsClient(paramContext, FitnessOptions.zza(paramGoogleSignInAccount).build());
  }
  
  public static HistoryClient getHistoryClient(Activity paramActivity, GoogleSignInAccount paramGoogleSignInAccount)
  {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    return new HistoryClient(paramActivity, FitnessOptions.zza(paramGoogleSignInAccount).build());
  }
  
  public static HistoryClient getHistoryClient(Context paramContext, GoogleSignInAccount paramGoogleSignInAccount)
  {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    return new HistoryClient(paramContext, FitnessOptions.zza(paramGoogleSignInAccount).build());
  }
  
  public static RecordingClient getRecordingClient(Activity paramActivity, GoogleSignInAccount paramGoogleSignInAccount)
  {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    return new RecordingClient(paramActivity, FitnessOptions.zza(paramGoogleSignInAccount).build());
  }
  
  public static RecordingClient getRecordingClient(Context paramContext, GoogleSignInAccount paramGoogleSignInAccount)
  {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    return new RecordingClient(paramContext, FitnessOptions.zza(paramGoogleSignInAccount).build());
  }
  
  public static SensorsClient getSensorsClient(Activity paramActivity, GoogleSignInAccount paramGoogleSignInAccount)
  {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    return new SensorsClient(paramActivity, FitnessOptions.zza(paramGoogleSignInAccount).build());
  }
  
  public static SensorsClient getSensorsClient(Context paramContext, GoogleSignInAccount paramGoogleSignInAccount)
  {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    return new SensorsClient(paramContext, FitnessOptions.zza(paramGoogleSignInAccount).build());
  }
  
  public static SessionsClient getSessionsClient(Activity paramActivity, GoogleSignInAccount paramGoogleSignInAccount)
  {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    return new SessionsClient(paramActivity, FitnessOptions.zza(paramGoogleSignInAccount).build());
  }
  
  public static SessionsClient getSessionsClient(Context paramContext, GoogleSignInAccount paramGoogleSignInAccount)
  {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    return new SessionsClient(paramContext, FitnessOptions.zza(paramGoogleSignInAccount).build());
  }
  
  public static long getStartTime(Intent paramIntent, TimeUnit paramTimeUnit)
  {
    long l = paramIntent.getLongExtra("vnd.google.fitness.start_time", -1L);
    if (l == -1L) {
      return -1L;
    }
    return paramTimeUnit.convert(l, TimeUnit.MILLISECONDS);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\Fitness.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */