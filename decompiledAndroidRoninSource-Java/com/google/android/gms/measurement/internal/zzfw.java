package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.internal.measurement.zzmj;
import com.google.android.gms.internal.measurement.zzny;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class zzfw
  extends zzei
{
  private final zzki zza;
  private Boolean zzb;
  private String zzc;
  
  public zzfw(zzki paramzzki)
  {
    this(paramzzki, null);
  }
  
  private zzfw(zzki paramzzki, String paramString)
  {
    Preconditions.checkNotNull(paramzzki);
    this.zza = paramzzki;
    this.zzc = null;
  }
  
  private final void zza(Runnable paramRunnable)
  {
    Preconditions.checkNotNull(paramRunnable);
    if (this.zza.zzp().zzf())
    {
      paramRunnable.run();
      return;
    }
    this.zza.zzp().zza(paramRunnable);
  }
  
  private final void zza(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString)) {
      if (!paramBoolean) {}
    }
    for (;;)
    {
      try
      {
        if (this.zzb == null)
        {
          if (("com.google.android.gms".equals(this.zzc)) || (UidVerifier.isGooglePlayServicesUid(this.zza.zzm(), Binder.getCallingUid()))) {
            break label200;
          }
          if (!GoogleSignatureVerifier.getInstance(this.zza.zzm()).isUidGoogleSigned(Binder.getCallingUid())) {
            break label195;
          }
          break label200;
          this.zzb = Boolean.valueOf(paramBoolean);
        }
        if (this.zzb.booleanValue()) {
          break;
        }
        if ((this.zzc == null) && (GooglePlayServicesUtilLight.uidHasPackageName(this.zza.zzm(), Binder.getCallingUid(), paramString))) {
          this.zzc = paramString;
        }
        if (paramString.equals(this.zzc)) {
          return;
        }
        throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[] { paramString }));
      }
      catch (SecurityException localSecurityException)
      {
        this.zza.zzq().zze().zza("Measurement Service called with invalid calling package. appId", zzer.zza(paramString));
        throw localSecurityException;
      }
      this.zza.zzq().zze().zza("Measurement Service called without app package");
      throw new SecurityException("Measurement Service called without app package");
      label195:
      paramBoolean = false;
      continue;
      label200:
      paramBoolean = true;
    }
  }
  
  private final void zzb(zzn paramzzn, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramzzn);
    zza(paramzzn.zza, false);
    this.zza.zzk().zza(paramzzn.zzb, paramzzn.zzr, paramzzn.zzv);
  }
  
  public final List<zzkr> zza(zzn paramzzn, boolean paramBoolean)
  {
    zzb(paramzzn, false);
    Object localObject1 = this.zza.zzp().zza(new zzgn(this, paramzzn));
    try
    {
      Object localObject2 = (List)((Future)localObject1).get();
      localObject1 = new ArrayList(((List)localObject2).size());
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        zzkt localzzkt = (zzkt)((Iterator)localObject2).next();
        if ((paramBoolean) || (!zzkw.zzd(localzzkt.zzc))) {
          ((List)localObject1).add(new zzkr(localzzkt));
        }
      }
      return (List<zzkr>)localObject1;
    }
    catch (ExecutionException localExecutionException) {}catch (InterruptedException localInterruptedException) {}
    this.zza.zzq().zze().zza("Failed to get user properties. appId", zzer.zza(paramzzn.zza), localInterruptedException);
    return null;
  }
  
  public final List<zzw> zza(String paramString1, String paramString2, zzn paramzzn)
  {
    zzb(paramzzn, false);
    paramString1 = this.zza.zzp().zza(new zzgf(this, paramzzn, paramString1, paramString2));
    try
    {
      paramString1 = (List)paramString1.get();
      return paramString1;
    }
    catch (ExecutionException paramString1) {}catch (InterruptedException paramString1) {}
    this.zza.zzq().zze().zza("Failed to get conditional user properties", paramString1);
    return Collections.emptyList();
  }
  
  public final List<zzw> zza(String paramString1, String paramString2, String paramString3)
  {
    zza(paramString1, true);
    paramString1 = this.zza.zzp().zza(new zzge(this, paramString1, paramString2, paramString3));
    try
    {
      paramString1 = (List)paramString1.get();
      return paramString1;
    }
    catch (ExecutionException paramString1) {}catch (InterruptedException paramString1) {}
    this.zza.zzq().zze().zza("Failed to get conditional user properties as", paramString1);
    return Collections.emptyList();
  }
  
  public final List<zzkr> zza(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    zza(paramString1, true);
    paramString2 = this.zza.zzp().zza(new zzgc(this, paramString1, paramString2, paramString3));
    try
    {
      paramString3 = (List)paramString2.get();
      paramString2 = new ArrayList(paramString3.size());
      paramString3 = paramString3.iterator();
      while (paramString3.hasNext())
      {
        zzkt localzzkt = (zzkt)paramString3.next();
        if ((paramBoolean) || (!zzkw.zzd(localzzkt.zzc))) {
          paramString2.add(new zzkr(localzzkt));
        }
      }
      return paramString2;
    }
    catch (ExecutionException paramString2) {}catch (InterruptedException paramString2) {}
    this.zza.zzq().zze().zza("Failed to get user properties as. appId", zzer.zza(paramString1), paramString2);
    return Collections.emptyList();
  }
  
  public final List<zzkr> zza(String paramString1, String paramString2, boolean paramBoolean, zzn paramzzn)
  {
    zzb(paramzzn, false);
    paramString1 = this.zza.zzp().zza(new zzgd(this, paramzzn, paramString1, paramString2));
    try
    {
      paramString2 = (List)paramString1.get();
      paramString1 = new ArrayList(paramString2.size());
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        zzkt localzzkt = (zzkt)paramString2.next();
        if ((paramBoolean) || (!zzkw.zzd(localzzkt.zzc))) {
          paramString1.add(new zzkr(localzzkt));
        }
      }
      return paramString1;
    }
    catch (ExecutionException paramString1) {}catch (InterruptedException paramString1) {}
    this.zza.zzq().zze().zza("Failed to query user properties. appId", zzer.zza(paramzzn.zza), paramString1);
    return Collections.emptyList();
  }
  
  public final void zza(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    zza(new zzgp(this, paramString2, paramString3, paramString1, paramLong));
  }
  
  public final void zza(Bundle paramBundle, zzn paramzzn)
  {
    if ((zzny.zzb()) && (this.zza.zzb().zza(zzat.zzbz)))
    {
      zzb(paramzzn, false);
      zza(new zzfz(this, paramzzn, paramBundle));
    }
  }
  
  public final void zza(zzar paramzzar, zzn paramzzn)
  {
    Preconditions.checkNotNull(paramzzar);
    zzb(paramzzn, false);
    zza(new zzgj(this, paramzzar, paramzzn));
  }
  
  public final void zza(zzar paramzzar, String paramString1, String paramString2)
  {
    Preconditions.checkNotNull(paramzzar);
    Preconditions.checkNotEmpty(paramString1);
    zza(paramString1, true);
    zza(new zzgi(this, paramzzar, paramString1));
  }
  
  public final void zza(zzkr paramzzkr, zzn paramzzn)
  {
    Preconditions.checkNotNull(paramzzkr);
    zzb(paramzzn, false);
    zza(new zzgk(this, paramzzkr, paramzzn));
  }
  
  public final void zza(zzn paramzzn)
  {
    zzb(paramzzn, false);
    zza(new zzgm(this, paramzzn));
  }
  
  public final void zza(zzw paramzzw)
  {
    Preconditions.checkNotNull(paramzzw);
    Preconditions.checkNotNull(paramzzw.zzc);
    zza(paramzzw.zza, true);
    zza(new zzga(this, new zzw(paramzzw)));
  }
  
  public final void zza(zzw paramzzw, zzn paramzzn)
  {
    Preconditions.checkNotNull(paramzzw);
    Preconditions.checkNotNull(paramzzw.zzc);
    zzb(paramzzn, false);
    paramzzw = new zzw(paramzzw);
    paramzzw.zza = paramzzn.zza;
    zza(new zzgb(this, paramzzw, paramzzn));
  }
  
  public final byte[] zza(zzar paramzzar, String paramString)
  {
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramzzar);
    zza(paramString, true);
    this.zza.zzq().zzv().zza("Log and bundle. event", this.zza.zzj().zza(paramzzar.zza));
    long l1 = this.zza.zzl().nanoTime() / 1000000L;
    Object localObject = this.zza.zzp().zzb(new zzgl(this, paramzzar, paramString));
    try
    {
      byte[] arrayOfByte = (byte[])((Future)localObject).get();
      localObject = arrayOfByte;
      if (arrayOfByte == null)
      {
        this.zza.zzq().zze().zza("Log and bundle returned null. appId", zzer.zza(paramString));
        localObject = new byte[0];
      }
      long l2 = this.zza.zzl().nanoTime() / 1000000L;
      this.zza.zzq().zzv().zza("Log and bundle processed. event, size, time_ms", this.zza.zzj().zza(paramzzar.zza), Integer.valueOf(localObject.length), Long.valueOf(l2 - l1));
      return (byte[])localObject;
    }
    catch (ExecutionException localExecutionException) {}catch (InterruptedException localInterruptedException) {}
    this.zza.zzq().zze().zza("Failed to log and bundle. appId, event, error", zzer.zza(paramString), this.zza.zzj().zza(paramzzar.zza), localInterruptedException);
    return null;
  }
  
  final zzar zzb(zzar paramzzar, zzn paramzzn)
  {
    boolean bool = "_cmp".equals(paramzzar.zza);
    int j = 0;
    int i = j;
    if (bool)
    {
      i = j;
      if (paramzzar.zzb != null) {
        if (paramzzar.zzb.zza() == 0)
        {
          i = j;
        }
        else
        {
          paramzzn = paramzzar.zzb.zzd("_cis");
          if (!"referrer broadcast".equals(paramzzn))
          {
            i = j;
            if (!"referrer API".equals(paramzzn)) {}
          }
          else
          {
            i = 1;
          }
        }
      }
    }
    if (i != 0)
    {
      this.zza.zzq().zzu().zza("Event has been filtered ", paramzzar.toString());
      return new zzar("_cmpx", paramzzar.zzb, paramzzar.zzc, paramzzar.zzd);
    }
    return paramzzar;
  }
  
  public final void zzb(zzn paramzzn)
  {
    zzb(paramzzn, false);
    zza(new zzfy(this, paramzzn));
  }
  
  public final String zzc(zzn paramzzn)
  {
    zzb(paramzzn, false);
    return this.zza.zzd(paramzzn);
  }
  
  public final void zzd(zzn paramzzn)
  {
    zza(paramzzn.zza, false);
    zza(new zzgh(this, paramzzn));
  }
  
  public final void zze(zzn paramzzn)
  {
    if ((zzmj.zzb()) && (this.zza.zzb().zza(zzat.zzci)))
    {
      Preconditions.checkNotEmpty(paramzzn.zza);
      Preconditions.checkNotNull(paramzzn.zzw);
      paramzzn = new zzgg(this, paramzzn);
      Preconditions.checkNotNull(paramzzn);
      if (this.zza.zzp().zzf())
      {
        paramzzn.run();
        return;
      }
      this.zza.zzp().zzb(paramzzn);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzfw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */