package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

public final class zzn
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzn> CREATOR = new zzm();
  public final String zza;
  public final String zzb;
  public final String zzc;
  public final String zzd;
  public final long zze;
  public final long zzf;
  public final String zzg;
  public final boolean zzh;
  public final boolean zzi;
  public final long zzj;
  public final String zzk;
  public final long zzl;
  public final long zzm;
  public final int zzn;
  public final boolean zzo;
  public final boolean zzp;
  public final boolean zzq;
  public final String zzr;
  public final Boolean zzs;
  public final long zzt;
  public final List<String> zzu;
  public final String zzv;
  public final String zzw;
  
  zzn(String paramString1, String paramString2, String paramString3, long paramLong1, String paramString4, long paramLong2, long paramLong3, String paramString5, boolean paramBoolean1, boolean paramBoolean2, String paramString6, long paramLong4, long paramLong5, int paramInt, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String paramString7, Boolean paramBoolean, long paramLong6, List<String> paramList, String paramString8, String paramString9)
  {
    Preconditions.checkNotEmpty(paramString1);
    this.zza = paramString1;
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = null;
    }
    this.zzb = paramString2;
    this.zzc = paramString3;
    this.zzj = paramLong1;
    this.zzd = paramString4;
    this.zze = paramLong2;
    this.zzf = paramLong3;
    this.zzg = paramString5;
    this.zzh = paramBoolean1;
    this.zzi = paramBoolean2;
    this.zzk = paramString6;
    this.zzl = paramLong4;
    this.zzm = paramLong5;
    this.zzn = paramInt;
    this.zzo = paramBoolean3;
    this.zzp = paramBoolean4;
    this.zzq = paramBoolean5;
    this.zzr = paramString7;
    this.zzs = paramBoolean;
    this.zzt = paramLong6;
    this.zzu = paramList;
    this.zzv = paramString8;
    this.zzw = paramString9;
  }
  
  zzn(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, String paramString5, boolean paramBoolean1, boolean paramBoolean2, long paramLong3, String paramString6, long paramLong4, long paramLong5, int paramInt, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String paramString7, Boolean paramBoolean, long paramLong6, List<String> paramList, String paramString8, String paramString9)
  {
    this.zza = paramString1;
    this.zzb = paramString2;
    this.zzc = paramString3;
    this.zzj = paramLong3;
    this.zzd = paramString4;
    this.zze = paramLong1;
    this.zzf = paramLong2;
    this.zzg = paramString5;
    this.zzh = paramBoolean1;
    this.zzi = paramBoolean2;
    this.zzk = paramString6;
    this.zzl = paramLong4;
    this.zzm = paramLong5;
    this.zzn = paramInt;
    this.zzo = paramBoolean3;
    this.zzp = paramBoolean4;
    this.zzq = paramBoolean5;
    this.zzr = paramString7;
    this.zzs = paramBoolean;
    this.zzt = paramLong6;
    this.zzu = paramList;
    this.zzv = paramString8;
    this.zzw = paramString9;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.zza, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.zzb, false);
    SafeParcelWriter.writeString(paramParcel, 4, this.zzc, false);
    SafeParcelWriter.writeString(paramParcel, 5, this.zzd, false);
    SafeParcelWriter.writeLong(paramParcel, 6, this.zze);
    SafeParcelWriter.writeLong(paramParcel, 7, this.zzf);
    SafeParcelWriter.writeString(paramParcel, 8, this.zzg, false);
    SafeParcelWriter.writeBoolean(paramParcel, 9, this.zzh);
    SafeParcelWriter.writeBoolean(paramParcel, 10, this.zzi);
    SafeParcelWriter.writeLong(paramParcel, 11, this.zzj);
    SafeParcelWriter.writeString(paramParcel, 12, this.zzk, false);
    SafeParcelWriter.writeLong(paramParcel, 13, this.zzl);
    SafeParcelWriter.writeLong(paramParcel, 14, this.zzm);
    SafeParcelWriter.writeInt(paramParcel, 15, this.zzn);
    SafeParcelWriter.writeBoolean(paramParcel, 16, this.zzo);
    SafeParcelWriter.writeBoolean(paramParcel, 17, this.zzp);
    SafeParcelWriter.writeBoolean(paramParcel, 18, this.zzq);
    SafeParcelWriter.writeString(paramParcel, 19, this.zzr, false);
    SafeParcelWriter.writeBooleanObject(paramParcel, 21, this.zzs, false);
    SafeParcelWriter.writeLong(paramParcel, 22, this.zzt);
    SafeParcelWriter.writeStringList(paramParcel, 23, this.zzu, false);
    SafeParcelWriter.writeString(paramParcel, 24, this.zzv, false);
    SafeParcelWriter.writeString(paramParcel, 25, this.zzw, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */