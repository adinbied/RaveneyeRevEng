package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

final class zzf
{
  private final zzfv zza;
  private long zzaa;
  private long zzab;
  private long zzac;
  private String zzad;
  private boolean zzae;
  private long zzaf;
  private long zzag;
  private final String zzb;
  private String zzc;
  private String zzd;
  private String zze;
  private String zzf;
  private long zzg;
  private long zzh;
  private long zzi;
  private String zzj;
  private long zzk;
  private String zzl;
  private long zzm;
  private long zzn;
  private boolean zzo;
  private long zzp;
  private boolean zzq;
  private boolean zzr;
  private String zzs;
  private Boolean zzt;
  private long zzu;
  private List<String> zzv;
  private String zzw;
  private long zzx;
  private long zzy;
  private long zzz;
  
  zzf(zzfv paramzzfv, String paramString)
  {
    Preconditions.checkNotNull(paramzzfv);
    Preconditions.checkNotEmpty(paramString);
    this.zza = paramzzfv;
    this.zzb = paramString;
    paramzzfv.zzp().zzc();
  }
  
  public final void zza(long paramLong)
  {
    this.zza.zzp().zzc();
    boolean bool2 = this.zzae;
    boolean bool1;
    if (this.zzh != paramLong) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.zzae = (bool2 | bool1);
    this.zzh = paramLong;
  }
  
  public final void zza(Boolean paramBoolean)
  {
    this.zza.zzp().zzc();
    this.zzae |= zzkw.zza(this.zzt, paramBoolean) ^ true;
    this.zzt = paramBoolean;
  }
  
  public final void zza(String paramString)
  {
    this.zza.zzp().zzc();
    this.zzae |= zzkw.zzc(this.zzc, paramString) ^ true;
    this.zzc = paramString;
  }
  
  public final void zza(List<String> paramList)
  {
    this.zza.zzp().zzc();
    if (!zzkw.zza(this.zzv, paramList))
    {
      this.zzae = true;
      if (paramList != null) {
        paramList = new ArrayList(paramList);
      } else {
        paramList = null;
      }
      this.zzv = paramList;
    }
  }
  
  public final void zza(boolean paramBoolean)
  {
    this.zza.zzp().zzc();
    boolean bool2 = this.zzae;
    boolean bool1;
    if (this.zzo != paramBoolean) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.zzae = (bool2 | bool1);
    this.zzo = paramBoolean;
  }
  
  public final boolean zza()
  {
    this.zza.zzp().zzc();
    return this.zzae;
  }
  
  public final long zzaa()
  {
    this.zza.zzp().zzc();
    return this.zzac;
  }
  
  public final long zzab()
  {
    this.zza.zzp().zzc();
    return this.zzab;
  }
  
  public final String zzac()
  {
    this.zza.zzp().zzc();
    return this.zzad;
  }
  
  public final String zzad()
  {
    this.zza.zzp().zzc();
    String str = this.zzad;
    zzi(null);
    return str;
  }
  
  public final long zzae()
  {
    this.zza.zzp().zzc();
    return this.zzp;
  }
  
  public final boolean zzaf()
  {
    this.zza.zzp().zzc();
    return this.zzq;
  }
  
  public final boolean zzag()
  {
    this.zza.zzp().zzc();
    return this.zzr;
  }
  
  public final Boolean zzah()
  {
    this.zza.zzp().zzc();
    return this.zzt;
  }
  
  public final List<String> zzai()
  {
    this.zza.zzp().zzc();
    return this.zzv;
  }
  
  public final void zzb()
  {
    this.zza.zzp().zzc();
    this.zzae = false;
  }
  
  public final void zzb(long paramLong)
  {
    this.zza.zzp().zzc();
    boolean bool2 = this.zzae;
    boolean bool1;
    if (this.zzi != paramLong) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.zzae = (bool2 | bool1);
    this.zzi = paramLong;
  }
  
  public final void zzb(String paramString)
  {
    this.zza.zzp().zzc();
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = null;
    }
    this.zzae |= zzkw.zzc(this.zzd, str) ^ true;
    this.zzd = str;
  }
  
  public final void zzb(boolean paramBoolean)
  {
    this.zza.zzp().zzc();
    boolean bool2 = this.zzae;
    boolean bool1;
    if (this.zzq != paramBoolean) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.zzae = (bool2 | bool1);
    this.zzq = paramBoolean;
  }
  
  public final String zzc()
  {
    this.zza.zzp().zzc();
    return this.zzb;
  }
  
  public final void zzc(long paramLong)
  {
    this.zza.zzp().zzc();
    boolean bool2 = this.zzae;
    boolean bool1;
    if (this.zzk != paramLong) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.zzae = (bool2 | bool1);
    this.zzk = paramLong;
  }
  
  public final void zzc(String paramString)
  {
    this.zza.zzp().zzc();
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = null;
    }
    this.zzae |= zzkw.zzc(this.zzs, str) ^ true;
    this.zzs = str;
  }
  
  public final void zzc(boolean paramBoolean)
  {
    this.zza.zzp().zzc();
    boolean bool2 = this.zzae;
    boolean bool1;
    if (this.zzr != paramBoolean) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.zzae = (bool2 | bool1);
    this.zzr = paramBoolean;
  }
  
  public final String zzd()
  {
    this.zza.zzp().zzc();
    return this.zzc;
  }
  
  public final void zzd(long paramLong)
  {
    this.zza.zzp().zzc();
    boolean bool2 = this.zzae;
    boolean bool1;
    if (this.zzm != paramLong) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.zzae = (bool2 | bool1);
    this.zzm = paramLong;
  }
  
  public final void zzd(String paramString)
  {
    this.zza.zzp().zzc();
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = null;
    }
    this.zzae |= zzkw.zzc(this.zzw, str) ^ true;
    this.zzw = str;
  }
  
  public final String zze()
  {
    this.zza.zzp().zzc();
    return this.zzd;
  }
  
  public final void zze(long paramLong)
  {
    this.zza.zzp().zzc();
    boolean bool2 = this.zzae;
    boolean bool1;
    if (this.zzn != paramLong) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.zzae = (bool2 | bool1);
    this.zzn = paramLong;
  }
  
  public final void zze(String paramString)
  {
    this.zza.zzp().zzc();
    this.zzae |= zzkw.zzc(this.zze, paramString) ^ true;
    this.zze = paramString;
  }
  
  public final String zzf()
  {
    this.zza.zzp().zzc();
    return this.zzs;
  }
  
  public final void zzf(long paramLong)
  {
    this.zza.zzp().zzc();
    boolean bool2 = this.zzae;
    boolean bool1;
    if (this.zzu != paramLong) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.zzae = (bool2 | bool1);
    this.zzu = paramLong;
  }
  
  public final void zzf(String paramString)
  {
    this.zza.zzp().zzc();
    this.zzae |= zzkw.zzc(this.zzf, paramString) ^ true;
    this.zzf = paramString;
  }
  
  public final String zzg()
  {
    this.zza.zzp().zzc();
    return this.zzw;
  }
  
  public final void zzg(long paramLong)
  {
    boolean bool1 = true;
    if (paramLong >= 0L) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    Preconditions.checkArgument(bool2);
    this.zza.zzp().zzc();
    boolean bool2 = this.zzae;
    if (this.zzg == paramLong) {
      bool1 = false;
    }
    this.zzae = (bool1 | bool2);
    this.zzg = paramLong;
  }
  
  public final void zzg(String paramString)
  {
    this.zza.zzp().zzc();
    this.zzae |= zzkw.zzc(this.zzj, paramString) ^ true;
    this.zzj = paramString;
  }
  
  public final String zzh()
  {
    this.zza.zzp().zzc();
    return this.zze;
  }
  
  public final void zzh(long paramLong)
  {
    this.zza.zzp().zzc();
    boolean bool2 = this.zzae;
    boolean bool1;
    if (this.zzaf != paramLong) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.zzae = (bool2 | bool1);
    this.zzaf = paramLong;
  }
  
  public final void zzh(String paramString)
  {
    this.zza.zzp().zzc();
    this.zzae |= zzkw.zzc(this.zzl, paramString) ^ true;
    this.zzl = paramString;
  }
  
  public final String zzi()
  {
    this.zza.zzp().zzc();
    return this.zzf;
  }
  
  public final void zzi(long paramLong)
  {
    this.zza.zzp().zzc();
    boolean bool2 = this.zzae;
    boolean bool1;
    if (this.zzag != paramLong) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.zzae = (bool2 | bool1);
    this.zzag = paramLong;
  }
  
  public final void zzi(String paramString)
  {
    this.zza.zzp().zzc();
    this.zzae |= zzkw.zzc(this.zzad, paramString) ^ true;
    this.zzad = paramString;
  }
  
  public final long zzj()
  {
    this.zza.zzp().zzc();
    return this.zzh;
  }
  
  public final void zzj(long paramLong)
  {
    this.zza.zzp().zzc();
    boolean bool2 = this.zzae;
    boolean bool1;
    if (this.zzx != paramLong) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.zzae = (bool2 | bool1);
    this.zzx = paramLong;
  }
  
  public final long zzk()
  {
    this.zza.zzp().zzc();
    return this.zzi;
  }
  
  public final void zzk(long paramLong)
  {
    this.zza.zzp().zzc();
    boolean bool2 = this.zzae;
    boolean bool1;
    if (this.zzy != paramLong) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.zzae = (bool2 | bool1);
    this.zzy = paramLong;
  }
  
  public final String zzl()
  {
    this.zza.zzp().zzc();
    return this.zzj;
  }
  
  public final void zzl(long paramLong)
  {
    this.zza.zzp().zzc();
    boolean bool2 = this.zzae;
    boolean bool1;
    if (this.zzz != paramLong) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.zzae = (bool2 | bool1);
    this.zzz = paramLong;
  }
  
  public final long zzm()
  {
    this.zza.zzp().zzc();
    return this.zzk;
  }
  
  public final void zzm(long paramLong)
  {
    this.zza.zzp().zzc();
    boolean bool2 = this.zzae;
    boolean bool1;
    if (this.zzaa != paramLong) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.zzae = (bool2 | bool1);
    this.zzaa = paramLong;
  }
  
  public final String zzn()
  {
    this.zza.zzp().zzc();
    return this.zzl;
  }
  
  public final void zzn(long paramLong)
  {
    this.zza.zzp().zzc();
    boolean bool2 = this.zzae;
    boolean bool1;
    if (this.zzac != paramLong) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.zzae = (bool2 | bool1);
    this.zzac = paramLong;
  }
  
  public final long zzo()
  {
    this.zza.zzp().zzc();
    return this.zzm;
  }
  
  public final void zzo(long paramLong)
  {
    this.zza.zzp().zzc();
    boolean bool2 = this.zzae;
    boolean bool1;
    if (this.zzab != paramLong) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.zzae = (bool2 | bool1);
    this.zzab = paramLong;
  }
  
  public final long zzp()
  {
    this.zza.zzp().zzc();
    return this.zzn;
  }
  
  public final void zzp(long paramLong)
  {
    this.zza.zzp().zzc();
    boolean bool2 = this.zzae;
    boolean bool1;
    if (this.zzp != paramLong) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.zzae = (bool2 | bool1);
    this.zzp = paramLong;
  }
  
  public final long zzq()
  {
    this.zza.zzp().zzc();
    return this.zzu;
  }
  
  public final boolean zzr()
  {
    this.zza.zzp().zzc();
    return this.zzo;
  }
  
  public final long zzs()
  {
    this.zza.zzp().zzc();
    return this.zzg;
  }
  
  public final long zzt()
  {
    this.zza.zzp().zzc();
    return this.zzaf;
  }
  
  public final long zzu()
  {
    this.zza.zzp().zzc();
    return this.zzag;
  }
  
  public final void zzv()
  {
    this.zza.zzp().zzc();
    long l2 = this.zzg + 1L;
    long l1 = l2;
    if (l2 > 2147483647L)
    {
      this.zza.zzq().zzh().zza("Bundle index overflow. appId", zzer.zza(this.zzb));
      l1 = 0L;
    }
    this.zzae = true;
    this.zzg = l1;
  }
  
  public final long zzw()
  {
    this.zza.zzp().zzc();
    return this.zzx;
  }
  
  public final long zzx()
  {
    this.zza.zzp().zzc();
    return this.zzy;
  }
  
  public final long zzy()
  {
    this.zza.zzp().zzc();
    return this.zzz;
  }
  
  public final long zzz()
  {
    this.zza.zzp().zzc();
    return this.zzaa;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */