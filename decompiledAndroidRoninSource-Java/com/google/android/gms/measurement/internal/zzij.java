package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zznm;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class zzij
  extends zzg
{
  protected zzig zza;
  private volatile zzig zzb;
  private zzig zzc;
  private final Map<Activity, zzig> zzd = new ConcurrentHashMap();
  private Activity zze;
  private volatile boolean zzf;
  private volatile zzig zzg;
  private zzig zzh;
  private boolean zzi;
  private final Object zzj = new Object();
  private zzig zzk;
  private String zzl;
  
  public zzij(zzfv paramzzfv)
  {
    super(paramzzfv);
  }
  
  private static String zza(String paramString)
  {
    paramString = paramString.split("\\.");
    if (paramString.length > 0) {
      paramString = paramString[(paramString.length - 1)];
    } else {
      paramString = "";
    }
    String str = paramString;
    if (paramString.length() > 100) {
      str = paramString.substring(0, 100);
    }
    return str;
  }
  
  private final void zza(Activity paramActivity, zzig paramzzig, boolean paramBoolean)
  {
    zzig localzzig;
    if (this.zzb == null) {
      localzzig = this.zzc;
    } else {
      localzzig = this.zzb;
    }
    if (paramzzig.zzb == null)
    {
      if (paramActivity != null) {
        paramActivity = zza(paramActivity.getClass().getCanonicalName());
      } else {
        paramActivity = null;
      }
      paramzzig = new zzig(paramzzig.zza, paramActivity, paramzzig.zzc, paramzzig.zze, paramzzig.zzf);
    }
    this.zzc = this.zzb;
    this.zzb = paramzzig;
    long l = zzl().elapsedRealtime();
    zzp().zza(new zzil(this, paramzzig, localzzig, l, paramBoolean));
  }
  
  private final void zza(Bundle paramBundle, zzig paramzzig1, zzig paramzzig2, long paramLong)
  {
    if (paramBundle != null)
    {
      paramBundle.remove("screen_name");
      paramBundle.remove("screen_class");
    }
    zza(paramzzig1, paramzzig2, paramLong, true, zzo().zza(null, "screen_view", paramBundle, null, true, true));
  }
  
  public static void zza(zzig paramzzig, Bundle paramBundle, boolean paramBoolean)
  {
    if ((paramBundle != null) && (paramzzig != null) && ((!paramBundle.containsKey("_sc")) || (paramBoolean)))
    {
      if (paramzzig.zza != null) {
        paramBundle.putString("_sn", paramzzig.zza);
      } else {
        paramBundle.remove("_sn");
      }
      if (paramzzig.zzb != null) {
        paramBundle.putString("_sc", paramzzig.zzb);
      } else {
        paramBundle.remove("_sc");
      }
      paramBundle.putLong("_si", paramzzig.zzc);
      return;
    }
    if ((paramBundle != null) && (paramzzig == null) && (paramBoolean))
    {
      paramBundle.remove("_sn");
      paramBundle.remove("_sc");
      paramBundle.remove("_si");
    }
  }
  
  private final void zza(zzig paramzzig1, zzig paramzzig2, long paramLong, boolean paramBoolean, Bundle paramBundle)
  {
    zzc();
    boolean bool = zzs().zza(zzat.zzas);
    int k = 0;
    int i;
    int j;
    Object localObject;
    if (bool)
    {
      if ((paramBoolean) && (this.zza != null)) {
        i = 1;
      } else {
        i = 0;
      }
      j = i;
      if (i != 0)
      {
        zza(this.zza, true, paramLong);
        j = i;
      }
    }
    else
    {
      if (paramBoolean)
      {
        localObject = this.zza;
        if (localObject != null) {
          zza((zzig)localObject, true, paramLong);
        }
      }
      j = 0;
    }
    if ((paramzzig2 != null) && (paramzzig2.zzc == paramzzig1.zzc) && (zzkw.zzc(paramzzig2.zzb, paramzzig1.zzb)))
    {
      i = k;
      if (zzkw.zzc(paramzzig2.zza, paramzzig1.zza)) {}
    }
    else
    {
      i = 1;
    }
    if (i != 0)
    {
      localObject = new Bundle();
      if (zzs().zza(zzat.zzbu)) {
        if (paramBundle != null) {
          localObject = new Bundle(paramBundle);
        } else {
          localObject = new Bundle();
        }
      }
      zza(paramzzig1, (Bundle)localObject, true);
      if (paramzzig2 != null)
      {
        if (paramzzig2.zza != null) {
          ((Bundle)localObject).putString("_pn", paramzzig2.zza);
        }
        if (paramzzig2.zzb != null) {
          ((Bundle)localObject).putString("_pc", paramzzig2.zzb);
        }
        ((Bundle)localObject).putLong("_pi", paramzzig2.zzc);
      }
      if ((zzs().zza(zzat.zzas)) && (j != 0))
      {
        if ((zznm.zzb()) && (zzs().zza(zzat.zzau))) {
          paramLong = zzj().zza(paramLong);
        } else {
          paramLong = zzj().zzb.zzb();
        }
        if (paramLong > 0L) {
          zzo().zza((Bundle)localObject, paramLong);
        }
      }
      paramBoolean = zzs().zza(zzat.zzbu);
      paramBundle = "auto";
      paramzzig2 = paramBundle;
      if (paramBoolean)
      {
        if (!zzs().zzh().booleanValue()) {
          ((Bundle)localObject).putLong("_mst", 1L);
        }
        paramzzig2 = paramBundle;
        if (paramzzig1.zze) {
          paramzzig2 = "app";
        }
      }
      if (zzs().zza(zzat.zzbu))
      {
        long l = zzl().currentTimeMillis();
        paramLong = l;
        if (paramzzig1.zze)
        {
          paramLong = l;
          if (paramzzig1.zzf != 0L) {
            paramLong = paramzzig1.zzf;
          }
        }
        zze().zza(paramzzig2, "_vs", paramLong, (Bundle)localObject);
      }
      else
      {
        zze().zzb(paramzzig2, "_vs", (Bundle)localObject);
      }
    }
    this.zza = paramzzig1;
    if ((zzs().zza(zzat.zzbu)) && (paramzzig1.zze)) {
      this.zzh = paramzzig1;
    }
    zzg().zza(paramzzig1);
  }
  
  private final void zza(zzig paramzzig, boolean paramBoolean, long paramLong)
  {
    zzd().zza(zzl().elapsedRealtime());
    boolean bool;
    if ((paramzzig != null) && (paramzzig.zzd)) {
      bool = true;
    } else {
      bool = false;
    }
    if ((zzj().zza(bool, paramBoolean, paramLong)) && (paramzzig != null)) {
      paramzzig.zzd = false;
    }
  }
  
  private final zzig zzd(Activity paramActivity)
  {
    Preconditions.checkNotNull(paramActivity);
    zzig localzzig2 = (zzig)this.zzd.get(paramActivity);
    zzig localzzig1 = localzzig2;
    if (localzzig2 == null)
    {
      localzzig1 = new zzig(null, zza(paramActivity.getClass().getCanonicalName()), zzo().zzf());
      this.zzd.put(paramActivity, localzzig1);
    }
    if (!zzs().zza(zzat.zzbu)) {
      return localzzig1;
    }
    if (this.zzg != null) {
      return this.zzg;
    }
    return localzzig1;
  }
  
  public final zzig zza(boolean paramBoolean)
  {
    zzv();
    zzc();
    if ((zzs().zza(zzat.zzbu)) && (paramBoolean))
    {
      zzig localzzig = this.zza;
      if (localzzig != null) {
        return localzzig;
      }
      return this.zzh;
    }
    return this.zza;
  }
  
  public final void zza(Activity paramActivity)
  {
    if (zzs().zza(zzat.zzbu)) {
      synchronized (this.zzj)
      {
        this.zzi = true;
        if (paramActivity != this.zze) {
          synchronized (this.zzj)
          {
            this.zze = paramActivity;
            this.zzf = false;
            if ((zzs().zza(zzat.zzbt)) && (zzs().zzh().booleanValue()))
            {
              this.zzg = null;
              zzp().zza(new zzip(this));
            }
          }
        }
      }
    }
    if ((zzs().zza(zzat.zzbt)) && (!zzs().zzh().booleanValue()))
    {
      this.zzb = this.zzg;
      zzp().zza(new zzik(this));
      return;
    }
    zza(paramActivity, zzd(paramActivity), false);
    paramActivity = zzd();
    long l = paramActivity.zzl().elapsedRealtime();
    paramActivity.zzp().zza(new zze(paramActivity, l));
  }
  
  public final void zza(Activity paramActivity, Bundle paramBundle)
  {
    if (!zzs().zzh().booleanValue()) {
      return;
    }
    if (paramBundle == null) {
      return;
    }
    paramBundle = paramBundle.getBundle("com.google.app_measurement.screen_service");
    if (paramBundle == null) {
      return;
    }
    paramBundle = new zzig(paramBundle.getString("name"), paramBundle.getString("referrer_name"), paramBundle.getLong("id"));
    this.zzd.put(paramActivity, paramBundle);
  }
  
  @Deprecated
  public final void zza(Activity paramActivity, String paramString1, String paramString2)
  {
    if (!zzs().zzh().booleanValue())
    {
      zzq().zzj().zza("setCurrentScreen cannot be called while screen reporting is disabled.");
      return;
    }
    if (this.zzb == null)
    {
      zzq().zzj().zza("setCurrentScreen cannot be called while no activity active");
      return;
    }
    if (this.zzd.get(paramActivity) == null)
    {
      zzq().zzj().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
      return;
    }
    String str = paramString2;
    if (paramString2 == null) {
      str = zza(paramActivity.getClass().getCanonicalName());
    }
    boolean bool1 = zzkw.zzc(this.zzb.zzb, str);
    boolean bool2 = zzkw.zzc(this.zzb.zza, paramString1);
    if ((bool1) && (bool2))
    {
      zzq().zzj().zza("setCurrentScreen cannot be called with the same class and name");
      return;
    }
    if ((paramString1 != null) && ((paramString1.length() <= 0) || (paramString1.length() > 100)))
    {
      zzq().zzj().zza("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(paramString1.length()));
      return;
    }
    if ((str != null) && ((str.length() <= 0) || (str.length() > 100)))
    {
      zzq().zzj().zza("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
      return;
    }
    zzet localzzet = zzq().zzw();
    if (paramString1 == null) {
      paramString2 = "null";
    } else {
      paramString2 = paramString1;
    }
    localzzet.zza("Setting current screen to name, class", paramString2, str);
    paramString1 = new zzig(paramString1, str, zzo().zzf());
    this.zzd.put(paramActivity, paramString1);
    zza(paramActivity, paramString1, true);
  }
  
  public final void zza(Bundle paramBundle, long paramLong)
  {
    if (!zzs().zza(zzat.zzbu))
    {
      zzq().zzj().zza("Manual screen reporting is disabled.");
      return;
    }
    for (;;)
    {
      synchronized (this.zzj)
      {
        if (!this.zzi)
        {
          zzq().zzj().zza("Cannot log screen view event when the app is in the background.");
          return;
        }
        Object localObject2 = null;
        if (paramBundle == null) {
          break label448;
        }
        str = paramBundle.getString("screen_name");
        if ((str != null) && ((str.length() <= 0) || (str.length() > 100)))
        {
          zzq().zzj().zza("Invalid screen name length for screen view. Length", Integer.valueOf(str.length()));
          return;
        }
        localObject2 = paramBundle.getString("screen_class");
        if ((localObject2 != null) && ((((String)localObject2).length() <= 0) || (((String)localObject2).length() > 100)))
        {
          zzq().zzj().zza("Invalid screen class length for screen view. Length", Integer.valueOf(((String)localObject2).length()));
          return;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            if (this.zze == null) {
              break label454;
            }
            localObject1 = zza(this.zze.getClass().getCanonicalName());
          }
          if ((this.zzf) && (this.zzb != null))
          {
            this.zzf = false;
            boolean bool1 = zzkw.zzc(this.zzb.zzb, (String)localObject1);
            boolean bool2 = zzkw.zzc(this.zzb.zza, str);
            if ((bool1) && (bool2))
            {
              zzq().zzj().zza("Ignoring call to log screen view event with duplicate parameters.");
              return;
            }
          }
          zzet localzzet = zzq().zzw();
          if (str == null) {
            localObject2 = "null";
          } else {
            localObject2 = str;
          }
          if (localObject1 == null) {
            ??? = "null";
          } else {
            ??? = localObject1;
          }
          localzzet.zza("Logging screen view with name, class", localObject2, ???);
          if (this.zzb == null) {
            localObject2 = this.zzc;
          } else {
            localObject2 = this.zzb;
          }
          localObject1 = new zzig(str, (String)localObject1, zzo().zzf(), true, paramLong);
          this.zzb = ((zzig)localObject1);
          this.zzc = ((zzig)localObject2);
          this.zzg = ((zzig)localObject1);
          paramLong = zzl().elapsedRealtime();
          zzp().zza(new zzii(this, paramBundle, (zzig)localObject1, (zzig)localObject2, paramLong));
          return;
        }
      }
      continue;
      label448:
      String str = null;
      continue;
      label454:
      Object localObject1 = "Activity";
    }
  }
  
  public final void zza(String paramString, zzig paramzzig)
  {
    zzc();
    try
    {
      if ((this.zzl == null) || (this.zzl.equals(paramString)) || (paramzzig != null))
      {
        this.zzl = paramString;
        this.zzk = paramzzig;
      }
      return;
    }
    finally {}
  }
  
  public final zzig zzaa()
  {
    return this.zzb;
  }
  
  public final void zzb(Activity paramActivity)
  {
    if (zzs().zza(zzat.zzbu)) {
      synchronized (this.zzj)
      {
        this.zzi = false;
        this.zzf = true;
      }
    }
    long l = zzl().elapsedRealtime();
    if ((zzs().zza(zzat.zzbt)) && (!zzs().zzh().booleanValue()))
    {
      this.zzb = null;
      zzp().zza(new zzin(this, l));
      return;
    }
    paramActivity = zzd(paramActivity);
    this.zzc = this.zzb;
    this.zzb = null;
    zzp().zza(new zzim(this, paramActivity, l));
  }
  
  public final void zzb(Activity paramActivity, Bundle paramBundle)
  {
    if (!zzs().zzh().booleanValue()) {
      return;
    }
    if (paramBundle == null) {
      return;
    }
    paramActivity = (zzig)this.zzd.get(paramActivity);
    if (paramActivity == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("id", paramActivity.zzc);
    localBundle.putString("name", paramActivity.zza);
    localBundle.putString("referrer_name", paramActivity.zzb);
    paramBundle.putBundle("com.google.app_measurement.screen_service", localBundle);
  }
  
  public final void zzc(Activity paramActivity)
  {
    synchronized (this.zzj)
    {
      if (paramActivity == this.zze) {
        this.zze = null;
      }
      if (!zzs().zzh().booleanValue()) {
        return;
      }
      this.zzd.remove(paramActivity);
      return;
    }
  }
  
  protected final boolean zzy()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzij.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */