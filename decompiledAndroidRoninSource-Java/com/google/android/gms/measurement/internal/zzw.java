package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzw
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzw> CREATOR = new zzz();
  public String zza;
  public String zzb;
  public zzkr zzc;
  public long zzd;
  public boolean zze;
  public String zzf;
  public zzar zzg;
  public long zzh;
  public zzar zzi;
  public long zzj;
  public zzar zzk;
  
  zzw(zzw paramzzw)
  {
    Preconditions.checkNotNull(paramzzw);
    this.zza = paramzzw.zza;
    this.zzb = paramzzw.zzb;
    this.zzc = paramzzw.zzc;
    this.zzd = paramzzw.zzd;
    this.zze = paramzzw.zze;
    this.zzf = paramzzw.zzf;
    this.zzg = paramzzw.zzg;
    this.zzh = paramzzw.zzh;
    this.zzi = paramzzw.zzi;
    this.zzj = paramzzw.zzj;
    this.zzk = paramzzw.zzk;
  }
  
  zzw(String paramString1, String paramString2, zzkr paramzzkr, long paramLong1, boolean paramBoolean, String paramString3, zzar paramzzar1, long paramLong2, zzar paramzzar2, long paramLong3, zzar paramzzar3)
  {
    this.zza = paramString1;
    this.zzb = paramString2;
    this.zzc = paramzzkr;
    this.zzd = paramLong1;
    this.zze = paramBoolean;
    this.zzf = paramString3;
    this.zzg = paramzzar1;
    this.zzh = paramLong2;
    this.zzi = paramzzar2;
    this.zzj = paramLong3;
    this.zzk = paramzzar3;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.zza, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.zzb, false);
    SafeParcelWriter.writeParcelable(paramParcel, 4, this.zzc, paramInt, false);
    SafeParcelWriter.writeLong(paramParcel, 5, this.zzd);
    SafeParcelWriter.writeBoolean(paramParcel, 6, this.zze);
    SafeParcelWriter.writeString(paramParcel, 7, this.zzf, false);
    SafeParcelWriter.writeParcelable(paramParcel, 8, this.zzg, paramInt, false);
    SafeParcelWriter.writeLong(paramParcel, 9, this.zzh);
    SafeParcelWriter.writeParcelable(paramParcel, 10, this.zzi, paramInt, false);
    SafeParcelWriter.writeLong(paramParcel, 11, this.zzj);
    SafeParcelWriter.writeParcelable(paramParcel, 12, this.zzk, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */