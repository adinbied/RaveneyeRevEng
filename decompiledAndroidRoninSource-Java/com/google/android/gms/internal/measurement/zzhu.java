package com.google.android.gms.internal.measurement;

import java.lang.reflect.Type;

public enum zzhu
{
  private static final zzhu[] zzbe;
  private static final Type[] zzbf;
  private final zzij zzaz;
  private final int zzba;
  private final zzhw zzbb;
  private final Class<?> zzbc;
  private final boolean zzbd;
  
  static
  {
    zzaa = new zzhu("FIXED32_LIST", 24, 24, zzhw.zzb, zzij.zzb);
    zzab = new zzhu("BOOL_LIST", 25, 25, zzhw.zzb, zzij.zzf);
    zzac = new zzhu("STRING_LIST", 26, 26, zzhw.zzb, zzij.zzg);
    zzad = new zzhu("MESSAGE_LIST", 27, 27, zzhw.zzb, zzij.zzj);
    zzae = new zzhu("BYTES_LIST", 28, 28, zzhw.zzb, zzij.zzh);
    zzaf = new zzhu("UINT32_LIST", 29, 29, zzhw.zzb, zzij.zzb);
    zzag = new zzhu("ENUM_LIST", 30, 30, zzhw.zzb, zzij.zzi);
    zzah = new zzhu("SFIXED32_LIST", 31, 31, zzhw.zzb, zzij.zzb);
    zzai = new zzhu("SFIXED64_LIST", 32, 32, zzhw.zzb, zzij.zzc);
    zzaj = new zzhu("SINT32_LIST", 33, 33, zzhw.zzb, zzij.zzb);
    zzak = new zzhu("SINT64_LIST", 34, 34, zzhw.zzb, zzij.zzc);
    zza = new zzhu("DOUBLE_LIST_PACKED", 35, 35, zzhw.zzc, zzij.zze);
    zzal = new zzhu("FLOAT_LIST_PACKED", 36, 36, zzhw.zzc, zzij.zzd);
    zzam = new zzhu("INT64_LIST_PACKED", 37, 37, zzhw.zzc, zzij.zzc);
    zzan = new zzhu("UINT64_LIST_PACKED", 38, 38, zzhw.zzc, zzij.zzc);
    zzao = new zzhu("INT32_LIST_PACKED", 39, 39, zzhw.zzc, zzij.zzb);
    zzap = new zzhu("FIXED64_LIST_PACKED", 40, 40, zzhw.zzc, zzij.zzc);
    zzaq = new zzhu("FIXED32_LIST_PACKED", 41, 41, zzhw.zzc, zzij.zzb);
    zzar = new zzhu("BOOL_LIST_PACKED", 42, 42, zzhw.zzc, zzij.zzf);
    zzas = new zzhu("UINT32_LIST_PACKED", 43, 43, zzhw.zzc, zzij.zzb);
    zzat = new zzhu("ENUM_LIST_PACKED", 44, 44, zzhw.zzc, zzij.zzi);
    zzau = new zzhu("SFIXED32_LIST_PACKED", 45, 45, zzhw.zzc, zzij.zzb);
    zzav = new zzhu("SFIXED64_LIST_PACKED", 46, 46, zzhw.zzc, zzij.zzc);
    zzaw = new zzhu("SINT32_LIST_PACKED", 47, 47, zzhw.zzc, zzij.zzb);
    zzb = new zzhu("SINT64_LIST_PACKED", 48, 48, zzhw.zzc, zzij.zzc);
    zzax = new zzhu("GROUP_LIST", 49, 49, zzhw.zzb, zzij.zzj);
    Object localObject = new zzhu("MAP", 50, 50, zzhw.zzd, zzij.zza);
    zzay = (zzhu)localObject;
    zzhu localzzhu = zzc;
    int i = 0;
    zzbg = new zzhu[] { localzzhu, zzd, zze, zzf, zzg, zzh, zzi, zzj, zzk, zzl, zzm, zzn, zzo, zzp, zzq, zzr, zzs, zzt, zzu, zzv, zzw, zzx, zzy, zzz, zzaa, zzab, zzac, zzad, zzae, zzaf, zzag, zzah, zzai, zzaj, zzak, zza, zzal, zzam, zzan, zzao, zzap, zzaq, zzar, zzas, zzat, zzau, zzav, zzaw, zzb, zzax, localObject };
    zzbf = new Type[0];
    localObject = values();
    zzbe = new zzhu[localObject.length];
    int j = localObject.length;
    while (i < j)
    {
      localzzhu = localObject[i];
      zzbe[localzzhu.zzba] = localzzhu;
      i += 1;
    }
  }
  
  private zzhu(int paramInt, zzhw paramzzhw, zzij paramzzij)
  {
    this.zzba = paramInt;
    this.zzbb = paramzzhw;
    this.zzaz = paramzzij;
    ??? = zzht.zza[paramzzhw.ordinal()];
    boolean bool = true;
    if (??? != 1)
    {
      if (??? != 2) {
        this.zzbc = null;
      } else {
        this.zzbc = paramzzij.zza();
      }
    }
    else {
      this.zzbc = paramzzij.zza();
    }
    if (paramzzhw == zzhw.zza)
    {
      ??? = zzht.zzb[paramzzij.ordinal()];
      if ((??? != 1) && (??? != 2) && (??? != 3)) {}
    }
    else
    {
      bool = false;
    }
    this.zzbd = bool;
  }
  
  public final int zza()
  {
    return this.zzba;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzhu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */