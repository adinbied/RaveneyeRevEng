package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fitness.zzf;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class RawDataPoint
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<RawDataPoint> CREATOR = new zzz();
  private final long zzao;
  private final long zzap;
  private final Value[] zzaq;
  private final long zzas;
  private final long zzat;
  private final int zzdw;
  private final int zzdx;
  
  public RawDataPoint(long paramLong1, long paramLong2, Value[] paramArrayOfValue, int paramInt1, int paramInt2, long paramLong3, long paramLong4)
  {
    this.zzao = paramLong1;
    this.zzap = paramLong2;
    this.zzdw = paramInt1;
    this.zzdx = paramInt2;
    this.zzas = paramLong3;
    this.zzat = paramLong4;
    this.zzaq = paramArrayOfValue;
  }
  
  RawDataPoint(DataPoint paramDataPoint, List<DataSource> paramList)
  {
    this.zzao = paramDataPoint.getTimestamp(TimeUnit.NANOSECONDS);
    this.zzap = paramDataPoint.getStartTime(TimeUnit.NANOSECONDS);
    this.zzaq = paramDataPoint.zzc();
    this.zzdw = zzf.zza(paramDataPoint.getDataSource(), paramList);
    this.zzdx = zzf.zza(paramDataPoint.zzd(), paramList);
    this.zzas = paramDataPoint.zze();
    this.zzat = paramDataPoint.zzf();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof RawDataPoint)) {
      return false;
    }
    paramObject = (RawDataPoint)paramObject;
    return (this.zzao == ((RawDataPoint)paramObject).zzao) && (this.zzap == ((RawDataPoint)paramObject).zzap) && (Arrays.equals(this.zzaq, ((RawDataPoint)paramObject).zzaq)) && (this.zzdw == ((RawDataPoint)paramObject).zzdw) && (this.zzdx == ((RawDataPoint)paramObject).zzdx) && (this.zzas == ((RawDataPoint)paramObject).zzas);
  }
  
  public final long getTimestampNanos()
  {
    return this.zzao;
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { Long.valueOf(this.zzao), Long.valueOf(this.zzap) });
  }
  
  public final String toString()
  {
    return String.format(Locale.US, "RawDataPoint{%s@[%s, %s](%d,%d)}", new Object[] { Arrays.toString(this.zzaq), Long.valueOf(this.zzap), Long.valueOf(this.zzao), Integer.valueOf(this.zzdw), Integer.valueOf(this.zzdx) });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeLong(paramParcel, 1, this.zzao);
    SafeParcelWriter.writeLong(paramParcel, 2, this.zzap);
    SafeParcelWriter.writeTypedArray(paramParcel, 3, this.zzaq, paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 4, this.zzdw);
    SafeParcelWriter.writeInt(paramParcel, 5, this.zzdx);
    SafeParcelWriter.writeLong(paramParcel, 6, this.zzas);
    SafeParcelWriter.writeLong(paramParcel, 7, this.zzat);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final Value[] zzc()
  {
    return this.zzaq;
  }
  
  public final long zze()
  {
    return this.zzas;
  }
  
  public final long zzf()
  {
    return this.zzat;
  }
  
  public final long zzn()
  {
    return this.zzap;
  }
  
  public final int zzo()
  {
    return this.zzdw;
  }
  
  public final int zzp()
  {
    return this.zzdx;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\data\RawDataPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */