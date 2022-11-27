package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.zzt;
import com.google.android.gms.fitness.data.zzu;
import java.util.concurrent.TimeUnit;

public class FitnessSensorServiceRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<FitnessSensorServiceRequest> CREATOR = new zzb();
  public static final int UNSPECIFIED = -1;
  private final zzt zzhr;
  private final long zziz;
  private final long zzja;
  private final DataSource zzr;
  
  FitnessSensorServiceRequest(DataSource paramDataSource, IBinder paramIBinder, long paramLong1, long paramLong2)
  {
    this.zzr = paramDataSource;
    this.zzhr = zzu.zza(paramIBinder);
    this.zziz = paramLong1;
    this.zzja = paramLong2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof FitnessSensorServiceRequest)) {
      return false;
    }
    paramObject = (FitnessSensorServiceRequest)paramObject;
    return (Objects.equal(this.zzr, ((FitnessSensorServiceRequest)paramObject).zzr)) && (this.zziz == ((FitnessSensorServiceRequest)paramObject).zziz) && (this.zzja == ((FitnessSensorServiceRequest)paramObject).zzja);
  }
  
  public long getBatchInterval(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzja, TimeUnit.MICROSECONDS);
  }
  
  public DataSource getDataSource()
  {
    return this.zzr;
  }
  
  public SensorEventDispatcher getDispatcher()
  {
    return new zzc(this.zzhr);
  }
  
  public long getSamplingRate(TimeUnit paramTimeUnit)
  {
    long l = this.zziz;
    if (l == -1L) {
      return -1L;
    }
    return paramTimeUnit.convert(l, TimeUnit.MICROSECONDS);
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.zzr, Long.valueOf(this.zziz), Long.valueOf(this.zzja) });
  }
  
  public String toString()
  {
    return String.format("FitnessSensorServiceRequest{%s}", new Object[] { this.zzr });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, getDataSource(), paramInt, false);
    SafeParcelWriter.writeIBinder(paramParcel, 2, this.zzhr.asBinder(), false);
    SafeParcelWriter.writeLong(paramParcel, 3, this.zziz);
    SafeParcelWriter.writeLong(paramParcel, 4, this.zzja);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\service\FitnessSensorServiceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */