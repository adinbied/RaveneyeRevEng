package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzmj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class zzio
  extends zzg
{
  private final zzji zza;
  private zzej zzb;
  private volatile Boolean zzc;
  private final zzaj zzd;
  private final zzkf zze;
  private final List<Runnable> zzf = new ArrayList();
  private final zzaj zzg;
  
  protected zzio(zzfv paramzzfv)
  {
    super(paramzzfv);
    this.zze = new zzkf(paramzzfv.zzl());
    this.zza = new zzji(this);
    this.zzd = new zzir(this, paramzzfv);
    this.zzg = new zzjb(this, paramzzfv);
  }
  
  private final void zza(ComponentName paramComponentName)
  {
    zzc();
    if (this.zzb != null)
    {
      this.zzb = null;
      zzq().zzw().zza("Disconnected from device MeasurementService", paramComponentName);
      zzc();
      zzae();
    }
  }
  
  private final void zza(Runnable paramRunnable)
    throws IllegalStateException
  {
    zzc();
    if (zzaa())
    {
      paramRunnable.run();
      return;
    }
    if (this.zzf.size() >= 1000L)
    {
      zzq().zze().zza("Discarding data. Max runnable queue size reached");
      return;
    }
    this.zzf.add(paramRunnable);
    this.zzg.zza(60000L);
    zzae();
  }
  
  private final void zzaj()
  {
    zzc();
    this.zze.zza();
    this.zzd.zza(((Long)zzat.zzai.zza(null)).longValue());
  }
  
  private final boolean zzak()
  {
    zzc();
    zzv();
    if (this.zzc == null)
    {
      zzc();
      zzv();
      Boolean localBoolean = zzr().zzi();
      boolean bool2 = true;
      boolean bool3 = true;
      boolean bool1 = true;
      if ((localBoolean != null) && (localBoolean.booleanValue()))
      {
        bool2 = bool3;
      }
      else
      {
        int i = zzf().zzaf();
        int j = 0;
        if (i == 1) {}
        for (;;)
        {
          i = 1;
          bool1 = bool2;
          break;
          zzq().zzw().zza("Checking service availability");
          i = zzo().zza(12451000);
          if (i != 0)
          {
            if (i != 1)
            {
              if (i != 2)
              {
                if (i != 3)
                {
                  if (i != 9)
                  {
                    if (i != 18) {
                      zzq().zzh().zza("Unexpected service status", Integer.valueOf(i));
                    } else {
                      zzq().zzh().zza("Service updating");
                    }
                  }
                  else {
                    zzq().zzh().zza("Service invalid");
                  }
                }
                else {
                  zzq().zzh().zza("Service disabled");
                }
                i = 0;
                break label259;
              }
              zzq().zzv().zza("Service container out of date");
              if (zzo().zzi() >= 17443)
              {
                if (localBoolean != null) {
                  bool1 = false;
                }
                i = 0;
                break;
              }
            }
            else
            {
              zzq().zzw().zza("Service missing");
            }
            i = 1;
            label259:
            bool1 = false;
            break;
          }
          else
          {
            zzq().zzw().zza("Service available");
          }
        }
        if ((!bool1) && (zzs().zzw()))
        {
          zzq().zze().zza("No way to upload. Consider using the full version of Analytics");
          i = j;
        }
        bool2 = bool1;
        if (i != 0)
        {
          zzr().zza(bool1);
          bool2 = bool1;
        }
      }
      this.zzc = Boolean.valueOf(bool2);
    }
    return this.zzc.booleanValue();
  }
  
  private final void zzal()
  {
    zzc();
    if (!zzaa()) {
      return;
    }
    zzq().zzw().zza("Inactivity, disconnecting from the service");
    zzag();
  }
  
  private final void zzam()
  {
    zzc();
    zzq().zzw().zza("Processing queued up service tasks", Integer.valueOf(this.zzf.size()));
    Iterator localIterator = this.zzf.iterator();
    while (localIterator.hasNext())
    {
      Runnable localRunnable = (Runnable)localIterator.next();
      try
      {
        localRunnable.run();
      }
      catch (Exception localException)
      {
        zzq().zze().zza("Task exception while flushing queue", localException);
      }
    }
    this.zzf.clear();
    this.zzg.zzc();
  }
  
  private final zzn zzb(boolean paramBoolean)
  {
    zzek localzzek = zzf();
    String str;
    if (paramBoolean) {
      str = zzq().zzx();
    } else {
      str = null;
    }
    return localzzek.zza(str);
  }
  
  public final void zza(Bundle paramBundle)
  {
    zzc();
    zzv();
    zza(new zziy(this, paramBundle, zzb(false)));
  }
  
  public final void zza(com.google.android.gms.internal.measurement.zzw paramzzw)
  {
    zzc();
    zzv();
    zza(new zzix(this, zzb(false), paramzzw));
  }
  
  public final void zza(com.google.android.gms.internal.measurement.zzw paramzzw, zzar paramzzar, String paramString)
  {
    zzc();
    zzv();
    if (zzo().zza(12451000) != 0)
    {
      zzq().zzh().zza("Not bundling data. Service unavailable or out of date");
      zzo().zza(paramzzw, new byte[0]);
      return;
    }
    zza(new zzja(this, paramzzar, paramString, paramzzw));
  }
  
  protected final void zza(com.google.android.gms.internal.measurement.zzw paramzzw, String paramString1, String paramString2)
  {
    zzc();
    zzv();
    zza(new zzjg(this, paramString1, paramString2, zzb(false), paramzzw));
  }
  
  protected final void zza(com.google.android.gms.internal.measurement.zzw paramzzw, String paramString1, String paramString2, boolean paramBoolean)
  {
    zzc();
    zzv();
    zza(new zziq(this, paramString1, paramString2, paramBoolean, zzb(false), paramzzw));
  }
  
  protected final void zza(zzar paramzzar, String paramString)
  {
    Preconditions.checkNotNull(paramzzar);
    zzc();
    zzv();
    zza(new zzjf(this, true, zzi().zza(paramzzar), paramzzar, zzb(true), paramString));
  }
  
  protected final void zza(zzej paramzzej)
  {
    zzc();
    Preconditions.checkNotNull(paramzzej);
    this.zzb = paramzzej;
    zzaj();
    zzam();
  }
  
  final void zza(zzej paramzzej, AbstractSafeParcelable paramAbstractSafeParcelable, zzn paramzzn)
  {
    zzc();
    zzv();
    int j = 0;
    int i = 100;
    while ((j < 1001) && (i == 100))
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject = zzi().zza(100);
      if (localObject != null)
      {
        localArrayList.addAll((Collection)localObject);
        i = ((List)localObject).size();
      }
      else
      {
        i = 0;
      }
      if ((paramAbstractSafeParcelable != null) && (i < 100)) {
        localArrayList.add(paramAbstractSafeParcelable);
      }
      localArrayList = (ArrayList)localArrayList;
      int m = localArrayList.size();
      int k = 0;
      while (k < m)
      {
        localObject = localArrayList.get(k);
        k += 1;
        localObject = (AbstractSafeParcelable)localObject;
        if ((localObject instanceof zzar)) {
          try
          {
            paramzzej.zza((zzar)localObject, paramzzn);
          }
          catch (RemoteException localRemoteException1)
          {
            zzq().zze().zza("Failed to send event to the service", localRemoteException1);
          }
        } else if ((localRemoteException1 instanceof zzkr)) {
          try
          {
            paramzzej.zza((zzkr)localRemoteException1, paramzzn);
          }
          catch (RemoteException localRemoteException2)
          {
            zzq().zze().zza("Failed to send user property to the service", localRemoteException2);
          }
        } else if ((localRemoteException2 instanceof zzw)) {
          try
          {
            paramzzej.zza((zzw)localRemoteException2, paramzzn);
          }
          catch (RemoteException localRemoteException3)
          {
            zzq().zze().zza("Failed to send conditional user property to the service", localRemoteException3);
          }
        } else {
          zzq().zze().zza("Discarding data. Unrecognized parcel type.");
        }
      }
      j += 1;
    }
  }
  
  protected final void zza(zzig paramzzig)
  {
    zzc();
    zzv();
    zza(new zziz(this, paramzzig));
  }
  
  protected final void zza(zzkr paramzzkr)
  {
    zzc();
    zzv();
    zza(new zzit(this, zzi().zza(paramzzkr), paramzzkr, zzb(true)));
  }
  
  protected final void zza(zzw paramzzw)
  {
    Preconditions.checkNotNull(paramzzw);
    zzc();
    zzv();
    zza(new zzje(this, true, zzi().zza(paramzzw), new zzw(paramzzw), zzb(true), paramzzw));
  }
  
  public final void zza(AtomicReference<String> paramAtomicReference)
  {
    zzc();
    zzv();
    zza(new zziu(this, paramAtomicReference, zzb(false)));
  }
  
  protected final void zza(AtomicReference<List<zzw>> paramAtomicReference, String paramString1, String paramString2, String paramString3)
  {
    zzc();
    zzv();
    zza(new zzjh(this, paramAtomicReference, paramString1, paramString2, paramString3, zzb(false)));
  }
  
  protected final void zza(AtomicReference<List<zzkr>> paramAtomicReference, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    zzc();
    zzv();
    zza(new zzjj(this, paramAtomicReference, paramString1, paramString2, paramString3, paramBoolean, zzb(false)));
  }
  
  protected final void zza(AtomicReference<List<zzkr>> paramAtomicReference, boolean paramBoolean)
  {
    zzc();
    zzv();
    zza(new zzis(this, paramAtomicReference, zzb(false), paramBoolean));
  }
  
  protected final void zza(boolean paramBoolean)
  {
    if ((zzmj.zzb()) && (zzs().zza(zzat.zzcg)))
    {
      zzc();
      zzv();
      if (paramBoolean) {
        zzi().zzaa();
      }
      if (zzai()) {
        zza(new zzjc(this, zzb(false)));
      }
    }
  }
  
  public final boolean zzaa()
  {
    zzc();
    zzv();
    return this.zzb != null;
  }
  
  protected final void zzab()
  {
    zzc();
    zzv();
    zza(new zzjd(this, zzb(true)));
  }
  
  protected final void zzac()
  {
    zzc();
    zzv();
    zzn localzzn = zzb(false);
    zzi().zzaa();
    zza(new zziv(this, localzzn));
  }
  
  protected final void zzad()
  {
    zzc();
    zzv();
    zzn localzzn = zzb(true);
    zzi().zzab();
    zza(new zziw(this, localzzn));
  }
  
  final void zzae()
  {
    zzc();
    zzv();
    if (zzaa()) {
      return;
    }
    if (zzak())
    {
      this.zza.zzb();
      return;
    }
    if (!zzs().zzw())
    {
      Object localObject = zzm().getPackageManager().queryIntentServices(new Intent().setClassName(zzm(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
      int i;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        localObject = new Intent("com.google.android.gms.measurement.START");
        ((Intent)localObject).setComponent(new ComponentName(zzm(), "com.google.android.gms.measurement.AppMeasurementService"));
        this.zza.zza((Intent)localObject);
        return;
      }
      zzq().zze().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
    }
  }
  
  final Boolean zzaf()
  {
    return this.zzc;
  }
  
  public final void zzag()
  {
    zzc();
    zzv();
    this.zza.zza();
    try
    {
      ConnectionTracker.getInstance().unbindService(zzm(), this.zza);
      this.zzb = null;
      return;
    }
    catch (IllegalStateException|IllegalArgumentException localIllegalStateException)
    {
      for (;;) {}
    }
  }
  
  final boolean zzah()
  {
    zzc();
    zzv();
    if (!zzak()) {
      return true;
    }
    return zzo().zzi() >= 200900;
  }
  
  final boolean zzai()
  {
    zzc();
    zzv();
    if (!zzs().zza(zzat.zzci)) {
      return false;
    }
    if (!zzak()) {
      return true;
    }
    return zzo().zzi() >= ((Integer)zzat.zzcj.zza(null)).intValue();
  }
  
  protected final boolean zzy()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */