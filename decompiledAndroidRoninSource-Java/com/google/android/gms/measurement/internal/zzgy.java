package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.measurement.zzlq;
import com.google.android.gms.internal.measurement.zzmj;
import com.google.android.gms.internal.measurement.zzmu;
import com.google.android.gms.internal.measurement.zzna;
import com.google.android.gms.internal.measurement.zznh;
import com.google.android.gms.internal.measurement.zzny;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class zzgy
  extends zzg
{
  protected zzhz zza;
  final zzp zzb;
  private zzgx zzc;
  private final Set<zzgw> zzd = new CopyOnWriteArraySet();
  private boolean zze;
  private final AtomicReference<String> zzf = new AtomicReference();
  private final Object zzg = new Object();
  private zzad zzh = new zzad(null, null);
  private int zzi = 100;
  private final AtomicLong zzj = new AtomicLong(0L);
  private long zzk = -1L;
  private int zzl = 100;
  private boolean zzm = true;
  private final zzkv zzn = new zzhr(this);
  
  protected zzgy(zzfv paramzzfv)
  {
    super(paramzzfv);
    this.zzb = new zzp(paramzzfv);
  }
  
  private final void zza(zzad paramzzad, int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    zzc();
    zzv();
    if ((paramLong <= this.zzk) && (zzad.zza(this.zzl, paramInt)))
    {
      zzq().zzu().zza("Dropped out-of-date consent setting, proposed settings", paramzzad);
      return;
    }
    if (zzr().zza(paramzzad, paramInt))
    {
      this.zzk = paramLong;
      this.zzl = paramInt;
      zzg().zza(paramBoolean1);
      if (paramBoolean2) {
        zzg().zza(new AtomicReference());
      }
    }
    else
    {
      zzq().zzu().zza("Lower precedence consent source ignored, proposed source", Integer.valueOf(paramInt));
    }
  }
  
  private final void zza(Boolean paramBoolean, boolean paramBoolean1)
  {
    zzc();
    zzv();
    zzq().zzv().zza("Setting app measurement enabled (FE)", paramBoolean);
    zzr().zza(paramBoolean);
    if ((zzmj.zzb()) && (zzs().zza(zzat.zzcg)) && (paramBoolean1)) {
      zzr().zzb(paramBoolean);
    }
    if ((!zzmj.zzb()) || (!zzs().zza(zzat.zzcg)) || (this.zzy.zzac()) || (!paramBoolean.booleanValue())) {
      zzal();
    }
  }
  
  private final void zza(String paramString1, String paramString2, long paramLong, Object paramObject)
  {
    zzp().zza(new zzhg(this, paramString1, paramString2, paramObject, paramLong));
  }
  
  private final void zzal()
  {
    zzc();
    Object localObject = zzr().zzn.zza();
    if (localObject != null) {
      if ("unset".equals(localObject))
      {
        zza("app", "_npa", null, zzl().currentTimeMillis());
      }
      else
      {
        long l;
        if ("true".equals(localObject)) {
          l = 1L;
        } else {
          l = 0L;
        }
        zza("app", "_npa", Long.valueOf(l), zzl().currentTimeMillis());
      }
    }
    if ((this.zzy.zzaa()) && (this.zzm))
    {
      zzq().zzv().zza("Recording app launch after enabling measurement for the first time (FE)");
      zzah();
      if ((zznh.zzb()) && (zzs().zza(zzat.zzbp))) {
        zzj().zza.zza();
      }
      if ((zzna.zzb()) && (zzs().zza(zzat.zzbs)))
      {
        int i;
        if (this.zzy.zze().zza.zzb().zzi.zza() > 0L) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0)
        {
          localObject = this.zzy.zze();
          ((zzfi)localObject).zza(((zzfi)localObject).zza.zzm().getPackageName());
        }
      }
      if (zzs().zza(zzat.zzcc)) {
        zzp().zza(new zzhc(this));
      }
      return;
    }
    zzq().zzv().zza("Updating Scion state (FE)");
    zzg().zzab();
  }
  
  private final ArrayList<Bundle> zzb(String paramString1, String paramString2, String paramString3)
  {
    if (zzp().zzf())
    {
      zzq().zze().zza("Cannot get conditional user properties from analytics worker thread");
      return new ArrayList(0);
    }
    if (zzx.zza())
    {
      zzq().zze().zza("Cannot get conditional user properties from main thread");
      return new ArrayList(0);
    }
    AtomicReference localAtomicReference = new AtomicReference();
    this.zzy.zzp().zza(localAtomicReference, 5000L, "get conditional user properties", new zzhp(this, localAtomicReference, paramString1, paramString2, paramString3));
    paramString2 = (List)localAtomicReference.get();
    if (paramString2 == null)
    {
      zzq().zze().zza("Timed out waiting for get conditional user properties", paramString1);
      return new ArrayList();
    }
    return zzkw.zzb(paramString2);
  }
  
  private final Map<String, Object> zzb(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (zzp().zzf())
    {
      zzq().zze().zza("Cannot get user properties from analytics worker thread");
      return Collections.emptyMap();
    }
    if (zzx.zza())
    {
      zzq().zze().zza("Cannot get user properties from main thread");
      return Collections.emptyMap();
    }
    AtomicReference localAtomicReference = new AtomicReference();
    this.zzy.zzp().zza(localAtomicReference, 5000L, "get user properties", new zzho(this, localAtomicReference, paramString1, paramString2, paramString3, paramBoolean));
    paramString2 = (List)localAtomicReference.get();
    if (paramString2 == null)
    {
      zzq().zze().zza("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(paramBoolean));
      return Collections.emptyMap();
    }
    paramString1 = new ArrayMap(paramString2.size());
    paramString2 = paramString2.iterator();
    while (paramString2.hasNext())
    {
      paramString3 = (zzkr)paramString2.next();
      paramString1.put(paramString3.zza, paramString3.zza());
    }
    return paramString1;
  }
  
  private final void zzb(Bundle paramBundle, long paramLong)
  {
    Preconditions.checkNotNull(paramBundle);
    zzgt.zza(paramBundle, "app_id", String.class, null);
    zzgt.zza(paramBundle, "origin", String.class, null);
    zzgt.zza(paramBundle, "name", String.class, null);
    zzgt.zza(paramBundle, "value", Object.class, null);
    zzgt.zza(paramBundle, "trigger_event_name", String.class, null);
    Object localObject1 = Long.valueOf(0L);
    zzgt.zza(paramBundle, "trigger_timeout", Long.class, localObject1);
    zzgt.zza(paramBundle, "timed_out_event_name", String.class, null);
    zzgt.zza(paramBundle, "timed_out_event_params", Bundle.class, null);
    zzgt.zza(paramBundle, "triggered_event_name", String.class, null);
    zzgt.zza(paramBundle, "triggered_event_params", Bundle.class, null);
    zzgt.zza(paramBundle, "time_to_live", Long.class, localObject1);
    zzgt.zza(paramBundle, "expired_event_name", String.class, null);
    zzgt.zza(paramBundle, "expired_event_params", Bundle.class, null);
    Preconditions.checkNotEmpty(paramBundle.getString("name"));
    Preconditions.checkNotEmpty(paramBundle.getString("origin"));
    Preconditions.checkNotNull(paramBundle.get("value"));
    paramBundle.putLong("creation_timestamp", paramLong);
    localObject1 = paramBundle.getString("name");
    Object localObject2 = paramBundle.get("value");
    if (zzo().zzb((String)localObject1) != 0)
    {
      zzq().zze().zza("Invalid conditional user property name", zzn().zzc((String)localObject1));
      return;
    }
    if (zzo().zzb((String)localObject1, localObject2) != 0)
    {
      zzq().zze().zza("Invalid conditional user property value", zzn().zzc((String)localObject1), localObject2);
      return;
    }
    Object localObject3 = zzo().zzc((String)localObject1, localObject2);
    if (localObject3 == null)
    {
      zzq().zze().zza("Unable to normalize conditional user property value", zzn().zzc((String)localObject1), localObject2);
      return;
    }
    zzgt.zza(paramBundle, localObject3);
    paramLong = paramBundle.getLong("trigger_timeout");
    if ((!TextUtils.isEmpty(paramBundle.getString("trigger_event_name"))) && ((paramLong > 15552000000L) || (paramLong < 1L)))
    {
      zzq().zze().zza("Invalid conditional user property timeout", zzn().zzc((String)localObject1), Long.valueOf(paramLong));
      return;
    }
    paramLong = paramBundle.getLong("time_to_live");
    if ((paramLong <= 15552000000L) && (paramLong >= 1L))
    {
      zzp().zza(new zzhk(this, paramBundle));
      return;
    }
    zzq().zze().zza("Invalid conditional user property time to live", zzn().zzc((String)localObject1), Long.valueOf(paramLong));
  }
  
  private final void zzb(String paramString1, String paramString2, long paramLong, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    paramBundle = zzkw.zzb(paramBundle);
    zzp().zza(new zzhh(this, paramString1, paramString2, paramLong, paramBundle, paramBoolean1, paramBoolean2, paramBoolean3, paramString3));
  }
  
  private final void zzb(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    long l = zzl().currentTimeMillis();
    Preconditions.checkNotEmpty(paramString2);
    Bundle localBundle = new Bundle();
    if (paramString1 != null) {
      localBundle.putString("app_id", paramString1);
    }
    localBundle.putString("name", paramString2);
    localBundle.putLong("creation_timestamp", l);
    if (paramString3 != null)
    {
      localBundle.putString("expired_event_name", paramString3);
      localBundle.putBundle("expired_event_params", paramBundle);
    }
    zzp().zza(new zzhm(this, localBundle));
  }
  
  private final void zzd(Bundle paramBundle)
  {
    zzc();
    zzv();
    Preconditions.checkNotNull(paramBundle);
    Preconditions.checkNotEmpty(paramBundle.getString("name"));
    Preconditions.checkNotEmpty(paramBundle.getString("origin"));
    Preconditions.checkNotNull(paramBundle.get("value"));
    if (!this.zzy.zzaa())
    {
      zzq().zzw().zza("Conditional property not set since app measurement is disabled");
      return;
    }
    zzkr localzzkr = new zzkr(paramBundle.getString("name"), paramBundle.getLong("triggered_timestamp"), paramBundle.get("value"), paramBundle.getString("origin"));
    for (;;)
    {
      try
      {
        Object localObject1 = zzo();
        Object localObject2 = paramBundle.getString("app_id");
        Object localObject3 = paramBundle.getString("triggered_event_name");
        Object localObject4 = paramBundle.getBundle("triggered_event_params");
        Object localObject5 = paramBundle.getString("origin");
        if ((zzlq.zzb()) && (zzs().zza(zzat.zzck)))
        {
          bool = true;
          localObject1 = ((zzkw)localObject1).zza((String)localObject2, (String)localObject3, (Bundle)localObject4, (String)localObject5, 0L, true, false, bool);
          localObject2 = zzo();
          localObject3 = paramBundle.getString("app_id");
          localObject4 = paramBundle.getString("timed_out_event_name");
          localObject5 = paramBundle.getBundle("timed_out_event_params");
          Object localObject6 = paramBundle.getString("origin");
          if ((!zzlq.zzb()) || (!zzs().zza(zzat.zzck))) {
            break label435;
          }
          bool = true;
          localObject2 = ((zzkw)localObject2).zza((String)localObject3, (String)localObject4, (Bundle)localObject5, (String)localObject6, 0L, true, false, bool);
          localObject3 = zzo();
          localObject4 = paramBundle.getString("app_id");
          localObject5 = paramBundle.getString("expired_event_name");
          localObject6 = paramBundle.getBundle("expired_event_params");
          String str = paramBundle.getString("origin");
          if ((!zzlq.zzb()) || (!zzs().zza(zzat.zzck))) {
            break label440;
          }
          bool = true;
          localObject3 = ((zzkw)localObject3).zza((String)localObject4, (String)localObject5, (Bundle)localObject6, str, 0L, true, false, bool);
          paramBundle = new zzw(paramBundle.getString("app_id"), paramBundle.getString("origin"), localzzkr, paramBundle.getLong("creation_timestamp"), false, paramBundle.getString("trigger_event_name"), (zzar)localObject2, paramBundle.getLong("trigger_timeout"), (zzar)localObject1, paramBundle.getLong("time_to_live"), (zzar)localObject3);
          zzg().zza(paramBundle);
          return;
        }
      }
      catch (IllegalArgumentException paramBundle)
      {
        return;
      }
      boolean bool = false;
      continue;
      label435:
      bool = false;
      continue;
      label440:
      bool = false;
    }
  }
  
  private final void zze(Bundle paramBundle)
  {
    zzc();
    zzv();
    Preconditions.checkNotNull(paramBundle);
    Preconditions.checkNotEmpty(paramBundle.getString("name"));
    if (!this.zzy.zzaa())
    {
      zzq().zzw().zza("Conditional property not cleared since app measurement is disabled");
      return;
    }
    zzkr localzzkr = new zzkr(paramBundle.getString("name"), 0L, null, null);
    for (;;)
    {
      try
      {
        Object localObject = zzo();
        String str1 = paramBundle.getString("app_id");
        String str2 = paramBundle.getString("expired_event_name");
        Bundle localBundle = paramBundle.getBundle("expired_event_params");
        String str3 = paramBundle.getString("origin");
        long l = paramBundle.getLong("creation_timestamp");
        if ((zzlq.zzb()) && (zzs().zza(zzat.zzck)))
        {
          bool = true;
          localObject = ((zzkw)localObject).zza(str1, str2, localBundle, str3, l, true, false, bool);
          paramBundle = new zzw(paramBundle.getString("app_id"), paramBundle.getString("origin"), localzzkr, paramBundle.getLong("creation_timestamp"), paramBundle.getBoolean("active"), paramBundle.getString("trigger_event_name"), null, paramBundle.getLong("trigger_timeout"), null, paramBundle.getLong("time_to_live"), (zzar)localObject);
          zzg().zza(paramBundle);
          return;
        }
      }
      catch (IllegalArgumentException paramBundle)
      {
        return;
      }
      boolean bool = false;
    }
  }
  
  public final ArrayList<Bundle> zza(String paramString1, String paramString2)
  {
    return zzb(null, paramString1, paramString2);
  }
  
  public final ArrayList<Bundle> zza(String paramString1, String paramString2, String paramString3)
  {
    Preconditions.checkNotEmpty(paramString1);
    zza();
    return zzb(paramString1, paramString2, paramString3);
  }
  
  public final List<zzkr> zza(boolean paramBoolean)
  {
    zzv();
    zzq().zzw().zza("Getting user properties (FE)");
    if (zzp().zzf())
    {
      zzq().zze().zza("Cannot get all user properties from analytics worker thread");
      return Collections.emptyList();
    }
    if (zzx.zza())
    {
      zzq().zze().zza("Cannot get all user properties from main thread");
      return Collections.emptyList();
    }
    Object localObject = new AtomicReference();
    this.zzy.zzp().zza((AtomicReference)localObject, 5000L, "get user properties", new zzhj(this, (AtomicReference)localObject, paramBoolean));
    localObject = (List)((AtomicReference)localObject).get();
    if (localObject == null)
    {
      zzq().zze().zza("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(paramBoolean));
      return Collections.emptyList();
    }
    return (List<zzkr>)localObject;
  }
  
  public final Map<String, Object> zza(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    Preconditions.checkNotEmpty(paramString1);
    zza();
    return zzb(paramString1, paramString2, paramString3, paramBoolean);
  }
  
  public final Map<String, Object> zza(String paramString1, String paramString2, boolean paramBoolean)
  {
    return zzb(null, paramString1, paramString2, paramBoolean);
  }
  
  final void zza(long paramLong, boolean paramBoolean)
  {
    zzc();
    zzv();
    zzq().zzv().zza("Resetting analytics data (FE)");
    Object localObject = zzj();
    ((zzgo)localObject).zzc();
    ((zzju)localObject).zzb.zza();
    boolean bool = this.zzy.zzaa();
    localObject = zzr();
    ((zzfd)localObject).zzh.zza(paramLong);
    if (!TextUtils.isEmpty(((zzgo)localObject).zzr().zzu.zza())) {
      ((zzfd)localObject).zzu.zza(null);
    }
    if ((zznh.zzb()) && (((zzgo)localObject).zzs().zza(zzat.zzbp))) {
      ((zzfd)localObject).zzp.zza(0L);
    }
    if (!((zzgo)localObject).zzs().zzf()) {
      ((zzfd)localObject).zzb(bool ^ true);
    }
    ((zzfd)localObject).zzv.zza(null);
    ((zzfd)localObject).zzw.zza(0L);
    ((zzfd)localObject).zzx.zza(null);
    if (paramBoolean) {
      zzg().zzac();
    }
    if ((zznh.zzb()) && (zzs().zza(zzat.zzbp))) {
      zzj().zza.zza();
    }
    this.zzm = (bool ^ true);
  }
  
  public final void zza(Bundle paramBundle)
  {
    zza(paramBundle, zzl().currentTimeMillis());
  }
  
  public final void zza(Bundle paramBundle, int paramInt, long paramLong)
  {
    if ((zzmj.zzb()) && (zzs().zza(zzat.zzcg)))
    {
      zzv();
      String str = zzad.zza(paramBundle);
      if (str != null)
      {
        zzq().zzj().zza("Ignoring invalid consent setting", str);
        zzq().zzj().zza("Valid consent values are 'granted', 'denied'");
      }
      zza(zzad.zzb(paramBundle), paramInt, paramLong);
    }
  }
  
  public final void zza(Bundle paramBundle, long paramLong)
  {
    Preconditions.checkNotNull(paramBundle);
    paramBundle = new Bundle(paramBundle);
    if (!TextUtils.isEmpty(paramBundle.getString("app_id"))) {
      zzq().zzh().zza("Package name should be null when calling setConditionalUserProperty");
    }
    paramBundle.remove("app_id");
    zzb(paramBundle, paramLong);
  }
  
  final void zza(zzad paramzzad)
  {
    zzc();
    boolean bool;
    if (((paramzzad.zze()) && (paramzzad.zzc())) || (zzg().zzai())) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool != this.zzy.zzac())
    {
      this.zzy.zzb(bool);
      paramzzad = zzr().zzv();
      if ((!bool) || (paramzzad == null) || (paramzzad.booleanValue())) {
        zza(Boolean.valueOf(bool), false);
      }
    }
  }
  
  public final void zza(zzad paramzzad, int paramInt, long paramLong)
  {
    zzad localzzad = paramzzad;
    if ((zzmj.zzb()) && (zzs().zza(zzat.zzcg)))
    {
      zzv();
      if ((paramzzad.zzb() == null) && (paramzzad.zzd() == null))
      {
        zzq().zzj().zza("Discarding empty consent settings");
        return;
      }
    }
    for (;;)
    {
      synchronized (this.zzg)
      {
        bool3 = zzad.zza(paramInt, this.zzi);
        i = 1;
        bool1 = false;
        bool2 = false;
        if (!bool3) {
          break label245;
        }
        bool3 = paramzzad.zza(this.zzh);
        bool1 = bool2;
        if (paramzzad.zze())
        {
          bool1 = bool2;
          if (!this.zzh.zze()) {
            bool1 = true;
          }
        }
        localzzad = paramzzad.zzc(this.zzh);
        this.zzh = localzzad;
        bool2 = bool3;
        if (i == 0)
        {
          zzq().zzu().zza("Ignoring lower-priority consent settings, proposed settings", localzzad);
          return;
        }
        long l = this.zzj.getAndIncrement();
        if (bool2)
        {
          zza(null);
          zzp().zzb(new zzhu(this, localzzad, paramLong, paramInt, l, bool1));
          return;
        }
        zzp().zza(new zzhx(this, localzzad, paramInt, l, bool1));
        return;
      }
      return;
      label245:
      int i = 0;
      boolean bool3 = false;
      boolean bool2 = bool1;
      boolean bool1 = bool3;
    }
  }
  
  public final void zza(zzgw paramzzgw)
  {
    zzv();
    Preconditions.checkNotNull(paramzzgw);
    if (!this.zzd.add(paramzzgw)) {
      zzq().zzh().zza("OnEventListener already registered");
    }
  }
  
  public final void zza(zzgx paramzzgx)
  {
    zzc();
    zzv();
    if (paramzzgx != null)
    {
      zzgx localzzgx = this.zzc;
      if (paramzzgx != localzzgx)
      {
        boolean bool;
        if (localzzgx == null) {
          bool = true;
        } else {
          bool = false;
        }
        Preconditions.checkState(bool, "EventInterceptor already set.");
      }
    }
    this.zzc = paramzzgx;
  }
  
  public final void zza(Boolean paramBoolean)
  {
    zzv();
    zzp().zza(new zzhv(this, paramBoolean));
  }
  
  final void zza(String paramString)
  {
    this.zzf.set(paramString);
  }
  
  final void zza(String paramString1, String paramString2, long paramLong, Bundle paramBundle)
  {
    zzc();
    boolean bool;
    if ((this.zzc != null) && (!zzkw.zzd(paramString2))) {
      bool = false;
    } else {
      bool = true;
    }
    zza(paramString1, paramString2, paramLong, paramBundle, true, bool, false, null);
  }
  
  protected final void zza(String paramString1, String paramString2, long paramLong, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotNull(paramBundle);
    zzc();
    zzv();
    if (!this.zzy.zzaa())
    {
      zzq().zzv().zza("Event not sent since app measurement is disabled");
      return;
    }
    Object localObject1 = zzf().zzag();
    if ((localObject1 != null) && (!((List)localObject1).contains(paramString2)))
    {
      zzq().zzv().zza("Dropping non-safelisted event. event name, origin", paramString2, paramString1);
      return;
    }
    boolean bool1 = this.zze;
    int j = 0;
    int k = 0;
    if (!bool1) {
      this.zze = true;
    }
    try
    {
      bool1 = this.zzy.zzs();
      if (!bool1) {
        localObject1 = Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, zzm().getClassLoader());
      } else {
        localObject1 = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
      }
      try
      {
        ((Class)localObject1).getDeclaredMethod("initialize", new Class[] { Context.class }).invoke(null, new Object[] { zzm() });
      }
      catch (Exception localException)
      {
        zzq().zzh().zza("Failed to invoke Tag Manager's initialize() method", localException);
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Object localObject2;
      int i;
      int m;
      boolean bool2;
      long l;
      Object localObject3;
      ArrayList localArrayList;
      for (;;) {}
    }
    zzq().zzu().zza("Tag Manager is not found and thus will not be used");
    if ((zzs().zza(zzat.zzbd)) && ("_cmp".equals(paramString2)) && (paramBundle.containsKey("gclid"))) {
      zza("auto", "_lgclid", paramBundle.getString("gclid"), zzl().currentTimeMillis());
    }
    if ((zzny.zzb()) && (zzs().zza(zzat.zzby)) && (paramBoolean1) && (zzkw.zzf(paramString2))) {
      zzo().zza(paramBundle, zzr().zzx.zza());
    }
    if ((paramBoolean3) && (!"_iap".equals(paramString2)))
    {
      localObject2 = this.zzy.zzh();
      if ((zzlq.zzb()) && (zzs().zza(zzat.zzck))) {
        i = 1;
      } else {
        i = 0;
      }
      bool1 = ((zzkw)localObject2).zza("event", paramString2);
      m = 2;
      if (!bool1) {
        i = m;
      } else if (i != 0 ? !((zzkw)localObject2).zza("event", zzgs.zza, zzgs.zzb, paramString2) : !((zzkw)localObject2).zza("event", zzgs.zza, paramString2)) {
        i = 13;
      } else if (!((zzkw)localObject2).zza("event", 40, paramString2)) {
        i = m;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        zzq().zzg().zza("Invalid public event name. Event will not be logged (FE)", zzn().zza(paramString2));
        this.zzy.zzh();
        paramString1 = zzkw.zza(paramString2, 40, true);
        j = k;
        if (paramString2 != null) {
          j = paramString2.length();
        }
        this.zzy.zzh().zza(this.zzn, i, "_ev", paramString1, j);
        return;
      }
    }
    localObject2 = zzh().zza(false);
    if ((localObject2 != null) && (!paramBundle.containsKey("_sc"))) {
      ((zzig)localObject2).zzd = true;
    }
    if ((paramBoolean1) && (paramBoolean3)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    zzij.zza((zzig)localObject2, paramBundle, bool1);
    bool1 = "am".equals(paramString1);
    bool2 = zzkw.zzd(paramString2);
    if ((paramBoolean1) && (this.zzc != null) && (!bool2) && (!bool1))
    {
      zzq().zzv().zza("Passing event to registered event handler (FE)", zzn().zza(paramString2), zzn().zza(paramBundle));
      this.zzc.interceptEvent(paramString1, paramString2, paramBundle, paramLong);
      return;
    }
    if (!this.zzy.zzaf()) {
      return;
    }
    localObject2 = zzo();
    if ((zzlq.zzb()) && (zzs().zza(zzat.zzck))) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    k = ((zzkw)localObject2).zza(paramString2, paramBoolean1);
    if (k != 0)
    {
      zzq().zzg().zza("Invalid event name. Event will not be logged (FE)", zzn().zza(paramString2));
      zzo();
      paramString1 = zzkw.zza(paramString2, 40, true);
      i = j;
      if (paramString2 != null) {
        i = paramString2.length();
      }
      this.zzy.zzh().zza(this.zzn, paramString3, k, "_ev", paramString1, i);
      return;
    }
    localObject2 = CollectionUtils.listOf(new String[] { "_o", "_sn", "_sc", "_si" });
    localObject2 = zzo().zza(paramString3, paramString2, paramBundle, (List)localObject2, paramBoolean3, true);
    if ((localObject2 != null) && (((Bundle)localObject2).containsKey("_sc")) && (((Bundle)localObject2).containsKey("_si"))) {
      new zzig(((Bundle)localObject2).getString("_sn"), ((Bundle)localObject2).getString("_sc"), Long.valueOf(((Bundle)localObject2).getLong("_si")).longValue());
    }
    if ((zzs().zza(zzat.zzas)) && (zzh().zza(false) != null) && ("_ae".equals(paramString2)))
    {
      l = zzj().zzb.zzb();
      if (l > 0L) {
        zzo().zza((Bundle)localObject2, l);
      }
    }
    if ((zzmu.zzb()) && (zzs().zza(zzat.zzbo))) {
      if ((!"auto".equals(paramString1)) && ("_ssr".equals(paramString2)))
      {
        localObject3 = zzo();
        paramBundle = ((Bundle)localObject2).getString("_ffr");
        if (Strings.isEmptyOrWhitespace(paramBundle)) {
          paramBundle = null;
        } else {
          paramBundle = paramBundle.trim();
        }
        if (zzkw.zzc(paramBundle, ((zzgo)localObject3).zzr().zzu.zza()))
        {
          ((zzgo)localObject3).zzq().zzv().zza("Not logging duplicate session_start_with_rollout event");
          i = 0;
        }
        else
        {
          ((zzgo)localObject3).zzr().zzu.zza(paramBundle);
          i = 1;
        }
        if (i != 0) {}
      }
      else if ("_ae".equals(paramString2))
      {
        paramBundle = zzo().zzr().zzu.zza();
        if (!TextUtils.isEmpty(paramBundle)) {
          ((Bundle)localObject2).putString("_ffr", paramBundle);
        }
      }
    }
    localArrayList = new ArrayList();
    localArrayList.add(localObject2);
    zzo().zzg().nextLong();
    if ((zzr().zzp.zza() > 0L) && (zzr().zza(paramLong)) && (zzr().zzr.zza()))
    {
      zzq().zzw().zza("Current session is expired, remove the session number, ID, and engagement time");
      zza("auto", "_sid", null, zzl().currentTimeMillis());
      zza("auto", "_sno", null, zzl().currentTimeMillis());
      zza("auto", "_se", null, zzl().currentTimeMillis());
    }
    if (((Bundle)localObject2).getLong("extend_session", 0L) == 1L)
    {
      zzq().zzw().zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
      this.zzy.zzd().zza.zza(paramLong, true);
    }
    paramBundle = (String[])((Bundle)localObject2).keySet().toArray(new String[((Bundle)localObject2).size()]);
    Arrays.sort(paramBundle);
    j = paramBundle.length;
    i = 0;
    while (i < j)
    {
      localObject3 = paramBundle[i];
      zzo();
      Bundle[] arrayOfBundle = zzkw.zzb(((Bundle)localObject2).get((String)localObject3));
      if (arrayOfBundle != null) {
        ((Bundle)localObject2).putParcelableArray((String)localObject3, arrayOfBundle);
      }
      i += 1;
    }
    i = 0;
    while (i < localArrayList.size())
    {
      localObject3 = (Bundle)localArrayList.get(i);
      if (i != 0) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0) {
        localObject2 = "_ep";
      } else {
        localObject2 = paramString2;
      }
      ((Bundle)localObject3).putString("_o", paramString1);
      paramBundle = (Bundle)localObject3;
      if (paramBoolean2) {
        paramBundle = zzo().zza((Bundle)localObject3);
      }
      localObject2 = new zzar((String)localObject2, new zzam(paramBundle), paramString1, paramLong);
      zzg().zza((zzar)localObject2, paramString3);
      if (!bool1)
      {
        localObject2 = this.zzd.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((zzgw)((Iterator)localObject2).next()).onEvent(paramString1, paramString2, new Bundle(paramBundle), paramLong);
        }
      }
      i += 1;
    }
    if ((zzh().zza(false) != null) && ("_ae".equals(paramString2))) {
      zzj().zza(true, true, zzl().elapsedRealtime());
    }
  }
  
  public final void zza(String paramString1, String paramString2, Bundle paramBundle)
  {
    zza(paramString1, paramString2, paramBundle, true, true, zzl().currentTimeMillis());
  }
  
  public final void zza(String paramString1, String paramString2, Bundle paramBundle, String paramString3)
  {
    zza();
    zzb(paramString1, paramString2, zzl().currentTimeMillis(), paramBundle, false, true, false, paramString3);
  }
  
  public final void zza(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if (paramString1 == null) {
      paramString1 = "app";
    }
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    if ((zzs().zza(zzat.zzbu)) && (zzkw.zzc(paramString2, "screen_view")))
    {
      zzh().zza(paramBundle, paramLong);
      return;
    }
    boolean bool;
    if ((paramBoolean2) && (this.zzc != null) && (!zzkw.zzd(paramString2))) {
      bool = false;
    } else {
      bool = true;
    }
    zzb(paramString1, paramString2, paramLong, paramBundle, paramBoolean2, bool, paramBoolean1 ^ true, null);
  }
  
  final void zza(String paramString1, String paramString2, Object paramObject, long paramLong)
  {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    zzc();
    zzv();
    if ("allow_personalized_ads".equals(paramString2))
    {
      if ((paramObject instanceof String))
      {
        localObject = (String)paramObject;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramObject = ((String)localObject).toLowerCase(Locale.ENGLISH);
          paramString2 = "false";
          long l;
          if ("false".equals(paramObject)) {
            l = 1L;
          } else {
            l = 0L;
          }
          paramObject = Long.valueOf(l);
          localObject = zzr().zzn;
          if (((Long)paramObject).longValue() == 1L) {
            paramString2 = "true";
          }
          ((zzfj)localObject).zza(paramString2);
          paramString2 = (String)paramObject;
          break label140;
        }
      }
      if (paramObject == null)
      {
        zzr().zzn.zza("unset");
        paramString2 = (String)paramObject;
        label140:
        paramObject = "_npa";
        localObject = paramString2;
        break label154;
      }
    }
    Object localObject = paramObject;
    paramObject = paramString2;
    label154:
    if (!this.zzy.zzaa())
    {
      zzq().zzw().zza("User property not set since app measurement is disabled");
      return;
    }
    if (!this.zzy.zzaf()) {
      return;
    }
    paramString1 = new zzkr((String)paramObject, paramLong, localObject, paramString1);
    zzg().zza(paramString1);
  }
  
  public final void zza(String paramString1, String paramString2, Object paramObject, boolean paramBoolean)
  {
    zza(paramString1, paramString2, paramObject, true, zzl().currentTimeMillis());
  }
  
  public final void zza(String paramString1, String paramString2, Object paramObject, boolean paramBoolean, long paramLong)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "app";
    }
    int i;
    if (paramBoolean)
    {
      i = zzo().zzb(paramString2);
    }
    else
    {
      paramString1 = zzo();
      if (!paramString1.zza("user property", paramString2)) {}
      do
      {
        i = 6;
        break;
        if (!paramString1.zza("user property", zzgu.zza, paramString2))
        {
          i = 15;
          break;
        }
      } while (!paramString1.zza("user property", 24, paramString2));
      i = 0;
    }
    int j;
    if (i != 0)
    {
      zzo();
      paramString1 = zzkw.zza(paramString2, 24, true);
      if (paramString2 != null) {
        j = paramString2.length();
      } else {
        j = 0;
      }
      this.zzy.zzh().zza(this.zzn, i, "_ev", paramString1, j);
      return;
    }
    if (paramObject != null)
    {
      j = zzo().zzb(paramString2, paramObject);
      if (j != 0)
      {
        zzo();
        paramString1 = zzkw.zza(paramString2, 24, true);
        if ((!(paramObject instanceof String)) && (!(paramObject instanceof CharSequence))) {
          i = 0;
        } else {
          i = String.valueOf(paramObject).length();
        }
        this.zzy.zzh().zza(this.zzn, j, "_ev", paramString1, i);
        return;
      }
      paramString1 = zzo().zzc(paramString2, paramObject);
      if (paramString1 != null) {
        zza(str, paramString2, paramLong, paramString1);
      }
      return;
    }
    zza(str, paramString2, paramLong, null);
  }
  
  public final void zza(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    Preconditions.checkNotEmpty(paramString1);
    zza();
    zzb(paramString1, paramString2, paramString3, paramBundle);
  }
  
  public final void zzaa()
  {
    if ((zzm().getApplicationContext() instanceof Application)) {
      ((Application)zzm().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
    }
  }
  
  public final Boolean zzab()
  {
    AtomicReference localAtomicReference = new AtomicReference();
    return (Boolean)zzp().zza(localAtomicReference, 15000L, "boolean test flag value", new zzhd(this, localAtomicReference));
  }
  
  public final String zzac()
  {
    AtomicReference localAtomicReference = new AtomicReference();
    return (String)zzp().zza(localAtomicReference, 15000L, "String test flag value", new zzhn(this, localAtomicReference));
  }
  
  public final Long zzad()
  {
    AtomicReference localAtomicReference = new AtomicReference();
    return (Long)zzp().zza(localAtomicReference, 15000L, "long test flag value", new zzhq(this, localAtomicReference));
  }
  
  public final Integer zzae()
  {
    AtomicReference localAtomicReference = new AtomicReference();
    return (Integer)zzp().zza(localAtomicReference, 15000L, "int test flag value", new zzht(this, localAtomicReference));
  }
  
  public final Double zzaf()
  {
    AtomicReference localAtomicReference = new AtomicReference();
    return (Double)zzp().zza(localAtomicReference, 15000L, "double test flag value", new zzhs(this, localAtomicReference));
  }
  
  public final String zzag()
  {
    return (String)this.zzf.get();
  }
  
  public final void zzah()
  {
    zzc();
    zzv();
    if (!this.zzy.zzaf()) {
      return;
    }
    if (zzs().zza(zzat.zzbc))
    {
      localObject = zzs().zzf("google_analytics_deferred_deep_link_enabled");
      int i;
      if ((localObject != null) && (((Boolean)localObject).booleanValue())) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        zzq().zzv().zza("Deferred Deep Link feature enabled.");
        zzp().zza(new zzha(this));
      }
    }
    zzg().zzad();
    this.zzm = false;
    Object localObject = zzr().zzx();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      zzk().zzaa();
      if (!((String)localObject).equals(Build.VERSION.RELEASE))
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("_po", (String)localObject);
        zza("auto", "_ou", localBundle);
      }
    }
  }
  
  public final String zzai()
  {
    zzig localzzig = this.zzy.zzu().zzaa();
    if (localzzig != null) {
      return localzzig.zza;
    }
    return null;
  }
  
  public final String zzaj()
  {
    zzig localzzig = this.zzy.zzu().zzaa();
    if (localzzig != null) {
      return localzzig.zzb;
    }
    return null;
  }
  
  public final String zzak()
  {
    if (this.zzy.zzn() != null) {
      return this.zzy.zzn();
    }
    try
    {
      String str = zzih.zza(zzm(), "google_app_id");
      return str;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      this.zzy.zzq().zze().zza("getGoogleAppId failed with exception", localIllegalStateException);
    }
    return null;
  }
  
  public final void zzb(Bundle paramBundle)
  {
    Preconditions.checkNotNull(paramBundle);
    Preconditions.checkNotEmpty(paramBundle.getString("app_id"));
    zza();
    zzb(new Bundle(paramBundle), zzl().currentTimeMillis());
  }
  
  public final void zzb(zzgw paramzzgw)
  {
    zzv();
    Preconditions.checkNotNull(paramzzgw);
    if (!this.zzd.remove(paramzzgw)) {
      zzq().zzh().zza("OnEventListener had not been registered");
    }
  }
  
  final void zzb(String paramString1, String paramString2, Bundle paramBundle)
  {
    zzc();
    zza(paramString1, paramString2, zzl().currentTimeMillis(), paramBundle);
  }
  
  public final void zzc(String paramString1, String paramString2, Bundle paramBundle)
  {
    zzb(null, paramString1, paramString2, paramBundle);
  }
  
  protected final boolean zzy()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzgy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */