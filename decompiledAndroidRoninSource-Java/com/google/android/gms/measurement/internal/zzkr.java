package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzkr
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzkr> CREATOR = new zzku();
  public final String zza;
  public final long zzb;
  public final Long zzc;
  public final String zzd;
  public final String zze;
  public final Double zzf;
  private final int zzg;
  private final Float zzh;
  
  zzkr(int paramInt, String paramString1, long paramLong, Long paramLong1, Float paramFloat, String paramString2, String paramString3, Double paramDouble)
  {
    this.zzg = paramInt;
    this.zza = paramString1;
    this.zzb = paramLong;
    this.zzc = paramLong1;
    paramString1 = null;
    this.zzh = null;
    if (paramInt == 1)
    {
      if (paramFloat != null) {
        paramString1 = Double.valueOf(paramFloat.doubleValue());
      }
      this.zzf = paramString1;
    }
    else
    {
      this.zzf = paramDouble;
    }
    this.zzd = paramString2;
    this.zze = paramString3;
  }
  
  zzkr(zzkt paramzzkt)
  {
    this(paramzzkt.zzc, paramzzkt.zzd, paramzzkt.zze, paramzzkt.zzb);
  }
  
  zzkr(String paramString1, long paramLong, Object paramObject, String paramString2)
  {
    Preconditions.checkNotEmpty(paramString1);
    this.zzg = 2;
    this.zza = paramString1;
    this.zzb = paramLong;
    this.zze = paramString2;
    if (paramObject == null)
    {
      this.zzc = null;
      this.zzh = null;
      this.zzf = null;
      this.zzd = null;
      return;
    }
    if ((paramObject instanceof Long))
    {
      this.zzc = ((Long)paramObject);
      this.zzh = null;
      this.zzf = null;
      this.zzd = null;
      return;
    }
    if ((paramObject instanceof String))
    {
      this.zzc = null;
      this.zzh = null;
      this.zzf = null;
      this.zzd = ((String)paramObject);
      return;
    }
    if ((paramObject instanceof Double))
    {
      this.zzc = null;
      this.zzh = null;
      this.zzf = ((Double)paramObject);
      this.zzd = null;
      return;
    }
    throw new IllegalArgumentException("User attribute given of un-supported type");
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzg);
    SafeParcelWriter.writeString(paramParcel, 2, this.zza, false);
    SafeParcelWriter.writeLong(paramParcel, 3, this.zzb);
    SafeParcelWriter.writeLongObject(paramParcel, 4, this.zzc, false);
    SafeParcelWriter.writeFloatObject(paramParcel, 5, null, false);
    SafeParcelWriter.writeString(paramParcel, 6, this.zzd, false);
    SafeParcelWriter.writeString(paramParcel, 7, this.zze, false);
    SafeParcelWriter.writeDoubleObject(paramParcel, 8, this.zzf, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public final Object zza()
  {
    Object localObject = this.zzc;
    if (localObject != null) {
      return localObject;
    }
    localObject = this.zzf;
    if (localObject != null) {
      return localObject;
    }
    localObject = this.zzd;
    if (localObject != null) {
      return localObject;
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzkr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */