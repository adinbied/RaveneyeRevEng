package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzar
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzar> CREATOR = new zzaq();
  public final String zza;
  public final zzam zzb;
  public final String zzc;
  public final long zzd;
  
  zzar(zzar paramzzar, long paramLong)
  {
    Preconditions.checkNotNull(paramzzar);
    this.zza = paramzzar.zza;
    this.zzb = paramzzar.zzb;
    this.zzc = paramzzar.zzc;
    this.zzd = paramLong;
  }
  
  public zzar(String paramString1, zzam paramzzam, String paramString2, long paramLong)
  {
    this.zza = paramString1;
    this.zzb = paramzzam;
    this.zzc = paramString2;
    this.zzd = paramLong;
  }
  
  public final String toString()
  {
    String str1 = this.zzc;
    String str2 = this.zza;
    String str3 = String.valueOf(this.zzb);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 21 + String.valueOf(str2).length() + String.valueOf(str3).length());
    localStringBuilder.append("origin=");
    localStringBuilder.append(str1);
    localStringBuilder.append(",name=");
    localStringBuilder.append(str2);
    localStringBuilder.append(",params=");
    localStringBuilder.append(str3);
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.zza, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.zzb, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 4, this.zzc, false);
    SafeParcelWriter.writeLong(paramParcel, 5, this.zzd);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */