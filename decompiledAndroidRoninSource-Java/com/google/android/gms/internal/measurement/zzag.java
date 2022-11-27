package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import com.google.android.gms.dynamite.DynamiteModule.VersionPolicy;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzgw;
import com.google.android.gms.measurement.internal.zzgx;
import com.google.android.gms.measurement.internal.zzih;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public class zzag
{
  private static volatile zzag zzb;
  private static Boolean zzh;
  private static String zzi = "allow_remote_dynamite";
  private static boolean zzj;
  protected final Clock zza;
  private final String zzc;
  private final ExecutorService zzd;
  private final AppMeasurementSdk zze;
  private List<Pair<zzgw, zzd>> zzf;
  private int zzg;
  private boolean zzk;
  private String zzl;
  private zzv zzm;
  
  private zzag(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if ((paramString1 != null) && (zzc(paramString2, paramString3))) {
      this.zzc = paramString1;
    } else {
      this.zzc = "FA";
    }
    this.zza = DefaultClock.getInstance();
    this.zzd = zzi.zza().zza(new zzat(this), zzr.zza);
    this.zze = new AppMeasurementSdk(this);
    boolean bool = zze(paramContext);
    int j = 0;
    int i;
    if ((bool) && (!zzk())) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      this.zzl = null;
      this.zzk = true;
      Log.w(this.zzc, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
      return;
    }
    if (!zzc(paramString2, paramString3))
    {
      this.zzl = "fa";
      if ((paramString2 != null) && (paramString3 != null))
      {
        Log.v(this.zzc, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
      }
      else
      {
        if (paramString2 == null) {
          i = 1;
        } else {
          i = 0;
        }
        if (paramString3 == null) {
          j = 1;
        }
        if ((i ^ j) != 0) {
          Log.w(this.zzc, "Specified origin or custom app id is null. Both parameters will be ignored.");
        }
      }
    }
    else
    {
      this.zzl = paramString2;
    }
    zza(new zzaj(this, paramString2, paramString3, paramContext, paramBundle));
    paramContext = (Application)paramContext.getApplicationContext();
    if (paramContext == null)
    {
      Log.w(this.zzc, "Unable to register lifecycle notifications. Application null.");
      return;
    }
    paramContext.registerActivityLifecycleCallbacks(new zzc());
  }
  
  public static zzag zza(Context paramContext)
  {
    return zza(paramContext, null, null, null, null);
  }
  
  public static zzag zza(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    Preconditions.checkNotNull(paramContext);
    if (zzb == null) {
      try
      {
        if (zzb == null) {
          zzb = new zzag(paramContext, paramString1, paramString2, paramString3, paramBundle);
        }
      }
      finally {}
    }
    return zzb;
  }
  
  private final void zza(zzb paramzzb)
  {
    this.zzd.execute(paramzzb);
  }
  
  private final void zza(Exception paramException, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.zzk |= paramBoolean1;
    if (paramBoolean1)
    {
      Log.w(this.zzc, "Data collection startup failed. No data will be collected.", paramException);
      return;
    }
    if (paramBoolean2) {
      zza(5, "Error with data collection. Data lost.", paramException, null, null);
    }
    Log.w(this.zzc, "Error with data collection. Data lost.", paramException);
  }
  
  private final void zza(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, Long paramLong)
  {
    zza(new zzbn(this, paramLong, paramString1, paramString2, paramBundle, paramBoolean1, paramBoolean2));
  }
  
  private final void zza(String paramString1, String paramString2, Object paramObject, boolean paramBoolean)
  {
    zza(new zzbm(this, paramString1, paramString2, paramObject, paramBoolean));
  }
  
  private static boolean zza(Context paramContext, String paramString)
  {
    Preconditions.checkNotEmpty(paramString);
    try
    {
      paramContext = Wrappers.packageManager(paramContext).getApplicationInfo(paramContext.getPackageName(), 128);
      if (paramContext != null)
      {
        if (paramContext.metaData == null) {
          return false;
        }
        boolean bool = paramContext.metaData.getBoolean(paramString);
        return bool;
      }
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  private static boolean zzc(String paramString1, String paramString2)
  {
    return (paramString2 != null) && (paramString1 != null) && (!zzk());
  }
  
  private static boolean zze(Context paramContext)
  {
    try
    {
      paramContext = zzih.zza(paramContext, "google_app_id");
      return paramContext != null;
    }
    catch (IllegalStateException paramContext) {}
    return false;
  }
  
  private static int zzf(Context paramContext)
  {
    return DynamiteModule.getRemoteVersion(paramContext, "com.google.android.gms.measurement.dynamite");
  }
  
  private static int zzg(Context paramContext)
  {
    return DynamiteModule.getLocalVersion(paramContext, "com.google.android.gms.measurement.dynamite");
  }
  
  /* Error */
  private static void zzh(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 261	com/google/android/gms/internal/measurement/zzag:zzh	Ljava/lang/Boolean;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: aload_0
    //   16: ldc_w 263
    //   19: invokestatic 265	com/google/android/gms/internal/measurement/zzag:zza	(Landroid/content/Context;Ljava/lang/String;)Z
    //   22: ifeq +14 -> 36
    //   25: iconst_0
    //   26: invokestatic 271	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   29: putstatic 261	com/google/android/gms/internal/measurement/zzag:zzh	Ljava/lang/Boolean;
    //   32: ldc 2
    //   34: monitorexit
    //   35: return
    //   36: aload_0
    //   37: ldc_w 273
    //   40: iconst_0
    //   41: invokevirtual 277	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   44: astore_0
    //   45: aload_0
    //   46: getstatic 279	com/google/android/gms/internal/measurement/zzag:zzi	Ljava/lang/String;
    //   49: iconst_0
    //   50: invokeinterface 284 3 0
    //   55: invokestatic 271	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   58: putstatic 261	com/google/android/gms/internal/measurement/zzag:zzh	Ljava/lang/Boolean;
    //   61: aload_0
    //   62: invokeinterface 288 1 0
    //   67: astore_0
    //   68: aload_0
    //   69: getstatic 279	com/google/android/gms/internal/measurement/zzag:zzi	Ljava/lang/String;
    //   72: invokeinterface 294 2 0
    //   77: pop
    //   78: aload_0
    //   79: invokeinterface 297 1 0
    //   84: goto +25 -> 109
    //   87: astore_0
    //   88: goto +25 -> 113
    //   91: astore_0
    //   92: ldc 52
    //   94: ldc_w 299
    //   97: aload_0
    //   98: invokestatic 302	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   101: pop
    //   102: iconst_0
    //   103: invokestatic 271	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   106: putstatic 261	com/google/android/gms/internal/measurement/zzag:zzh	Ljava/lang/Boolean;
    //   109: ldc 2
    //   111: monitorexit
    //   112: return
    //   113: ldc 2
    //   115: monitorexit
    //   116: aload_0
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramContext	Context
    //   6	2	1	localBoolean	Boolean
    // Exception table:
    //   from	to	target	type
    //   3	7	87	finally
    //   11	14	87	finally
    //   15	32	87	finally
    //   32	35	87	finally
    //   36	84	87	finally
    //   92	109	87	finally
    //   109	112	87	finally
    //   113	116	87	finally
    //   3	7	91	java/lang/Exception
    //   15	32	91	java/lang/Exception
    //   36	84	91	java/lang/Exception
  }
  
  private static boolean zzk()
  {
    try
    {
      Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;) {}
    }
    return false;
  }
  
  public final Bundle zza(Bundle paramBundle, boolean paramBoolean)
  {
    zzt localzzt = new zzt();
    zza(new zzbf(this, paramBundle, localzzt));
    if (paramBoolean) {
      return localzzt.zzb(5000L);
    }
    return null;
  }
  
  protected final zzv zza(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      DynamiteModule.VersionPolicy localVersionPolicy = DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION;
      break label15;
      localVersionPolicy = DynamiteModule.PREFER_LOCAL;
      label15:
      paramContext = zzu.asInterface(DynamiteModule.load(paramContext, localVersionPolicy, "com.google.android.gms.measurement.dynamite").instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
      return paramContext;
    }
    catch (DynamiteModule.LoadingException paramContext)
    {
      zza(paramContext, true, false);
    }
    return null;
  }
  
  public final AppMeasurementSdk zza()
  {
    return this.zze;
  }
  
  public final Object zza(int paramInt)
  {
    zzt localzzt = new zzt();
    zza(new zzbg(this, localzzt, paramInt));
    return zzt.zza(localzzt.zzb(15000L), Object.class);
  }
  
  public final Map<String, Object> zza(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject1 = new zzt();
    zza(new zzba(this, paramString1, paramString2, paramBoolean, (zzt)localObject1));
    paramString1 = ((zzt)localObject1).zzb(5000L);
    if ((paramString1 != null) && (paramString1.size() != 0))
    {
      paramString2 = new HashMap(paramString1.size());
      localObject1 = paramString1.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        String str = (String)((Iterator)localObject1).next();
        Object localObject2 = paramString1.get(str);
        if (((localObject2 instanceof Double)) || ((localObject2 instanceof Long)) || ((localObject2 instanceof String))) {
          paramString2.put(str, localObject2);
        }
      }
      return paramString2;
    }
    return Collections.emptyMap();
  }
  
  public final void zza(int paramInt, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    zza(new zzbd(this, false, 5, paramString, paramObject1, null, null));
  }
  
  public final void zza(long paramLong)
  {
    zza(new zzaq(this, paramLong));
  }
  
  public final void zza(Activity paramActivity, String paramString1, String paramString2)
  {
    zza(new zzam(this, paramActivity, paramString1, paramString2));
  }
  
  public final void zza(Bundle paramBundle)
  {
    zza(new zzai(this, paramBundle));
  }
  
  public final void zza(zzgw paramzzgw)
  {
    Preconditions.checkNotNull(paramzzgw);
    zza(new zzbl(this, paramzzgw));
  }
  
  public final void zza(zzgx paramzzgx)
  {
    zza(new zzbc(this, paramzzgx));
  }
  
  public final void zza(Boolean paramBoolean)
  {
    zza(new zzap(this, paramBoolean));
  }
  
  public final void zza(String paramString)
  {
    zza(new zzan(this, paramString));
  }
  
  public final void zza(String paramString, Bundle paramBundle)
  {
    zza(null, paramString, paramBundle, false, true, null);
  }
  
  public final void zza(String paramString1, String paramString2)
  {
    zza(null, paramString1, paramString2, false);
  }
  
  public final void zza(String paramString1, String paramString2, Bundle paramBundle)
  {
    zza(paramString1, paramString2, paramBundle, true, true, null);
  }
  
  public final void zza(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
  {
    zza(paramString1, paramString2, paramBundle, true, false, Long.valueOf(paramLong));
  }
  
  public final void zza(String paramString1, String paramString2, Object paramObject)
  {
    zza(paramString1, paramString2, paramObject, true);
  }
  
  public final void zza(boolean paramBoolean)
  {
    zza(new zzbj(this, paramBoolean));
  }
  
  public final List<Bundle> zzb(String paramString1, String paramString2)
  {
    zzt localzzt = new zzt();
    zza(new zzak(this, paramString1, paramString2, localzzt));
    paramString2 = (List)zzt.zza(localzzt.zzb(5000L), List.class);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = Collections.emptyList();
    }
    return paramString1;
  }
  
  public final void zzb()
  {
    zza(new zzar(this));
  }
  
  public final void zzb(long paramLong)
  {
    zza(new zzas(this, paramLong));
  }
  
  public final void zzb(Bundle paramBundle)
  {
    zza(new zzao(this, paramBundle));
  }
  
  public final void zzb(zzgw paramzzgw)
  {
    Preconditions.checkNotNull(paramzzgw);
    zza(new zzbk(this, paramzzgw));
  }
  
  public final void zzb(String paramString)
  {
    zza(new zzav(this, paramString));
  }
  
  public final void zzb(String paramString1, String paramString2, Bundle paramBundle)
  {
    zza(new zzal(this, paramString1, paramString2, paramBundle));
  }
  
  public final String zzc()
  {
    zzt localzzt = new zzt();
    zza(new zzax(this, localzzt));
    return localzzt.zza(500L);
  }
  
  public final void zzc(Bundle paramBundle)
  {
    zza(new zzbi(this, paramBundle));
  }
  
  public final void zzc(String paramString)
  {
    zza(new zzau(this, paramString));
  }
  
  public final int zzd(String paramString)
  {
    zzt localzzt = new zzt();
    zza(new zzbe(this, paramString, localzzt));
    paramString = (Integer)zzt.zza(localzzt.zzb(10000L), Integer.class);
    if (paramString == null) {
      return 25;
    }
    return paramString.intValue();
  }
  
  public final String zzd()
  {
    zzt localzzt = new zzt();
    zza(new zzaw(this, localzzt));
    return localzzt.zza(50L);
  }
  
  public final long zze()
  {
    Object localObject = new zzt();
    zza(new zzaz(this, (zzt)localObject));
    localObject = (Long)zzt.zza(((zzt)localObject).zzb(500L), Long.class);
    if (localObject == null)
    {
      long l = new Random(System.nanoTime() ^ this.zza.currentTimeMillis()).nextLong();
      int i = this.zzg + 1;
      this.zzg = i;
      return l + i;
    }
    return ((Long)localObject).longValue();
  }
  
  public final String zzf()
  {
    zzt localzzt = new zzt();
    zza(new zzay(this, localzzt));
    return localzzt.zza(500L);
  }
  
  public final String zzg()
  {
    zzt localzzt = new zzt();
    zza(new zzbb(this, localzzt));
    return localzzt.zza(500L);
  }
  
  public final String zzh()
  {
    zzt localzzt = new zzt();
    zza(new zzbh(this, localzzt));
    return localzzt.zza(120000L);
  }
  
  public final String zzi()
  {
    return this.zzl;
  }
  
  static final class zza
    extends zzaa
  {
    private final zzgx zza;
    
    zza(zzgx paramzzgx)
    {
      this.zza = paramzzgx;
    }
    
    public final int zza()
    {
      return System.identityHashCode(this.zza);
    }
    
    public final void zza(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
    {
      this.zza.interceptEvent(paramString1, paramString2, paramBundle, paramLong);
    }
  }
  
  abstract class zzb
    implements Runnable
  {
    final long zza = zzag.this.zza.currentTimeMillis();
    final long zzb = zzag.this.zza.elapsedRealtime();
    private final boolean zzc;
    
    zzb()
    {
      this(true);
    }
    
    zzb(boolean paramBoolean)
    {
      this.zzc = paramBoolean;
    }
    
    public void run()
    {
      if (zzag.zza(zzag.this))
      {
        zzb();
        return;
      }
      try
      {
        zza();
        return;
      }
      catch (Exception localException)
      {
        zzag.zza(zzag.this, localException, false, this.zzc);
        zzb();
      }
    }
    
    abstract void zza()
      throws RemoteException;
    
    protected void zzb() {}
  }
  
  final class zzc
    implements Application.ActivityLifecycleCallbacks
  {
    zzc() {}
    
    public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      zzag.zza(zzag.this, new zzbp(this, paramBundle, paramActivity));
    }
    
    public final void onActivityDestroyed(Activity paramActivity)
    {
      zzag.zza(zzag.this, new zzbu(this, paramActivity));
    }
    
    public final void onActivityPaused(Activity paramActivity)
    {
      zzag.zza(zzag.this, new zzbq(this, paramActivity));
    }
    
    public final void onActivityResumed(Activity paramActivity)
    {
      zzag.zza(zzag.this, new zzbr(this, paramActivity));
    }
    
    public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
    {
      zzt localzzt = new zzt();
      zzag.zza(zzag.this, new zzbs(this, paramActivity, localzzt));
      paramActivity = localzzt.zzb(50L);
      if (paramActivity != null) {
        paramBundle.putAll(paramActivity);
      }
    }
    
    public final void onActivityStarted(Activity paramActivity)
    {
      zzag.zza(zzag.this, new zzbo(this, paramActivity));
    }
    
    public final void onActivityStopped(Activity paramActivity)
    {
      zzag.zza(zzag.this, new zzbt(this, paramActivity));
    }
  }
  
  static final class zzd
    extends zzaa
  {
    private final zzgw zza;
    
    zzd(zzgw paramzzgw)
    {
      this.zza = paramzzgw;
    }
    
    public final int zza()
    {
      return System.identityHashCode(this.zza);
    }
    
    public final void zza(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
    {
      this.zza.onEvent(paramString1, paramString2, paramBundle, paramLong);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */