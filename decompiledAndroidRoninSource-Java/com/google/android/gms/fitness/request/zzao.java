package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.zzt;
import com.google.android.gms.fitness.data.zzu;
import com.google.android.gms.internal.fitness.zzcq;
import com.google.android.gms.internal.fitness.zzcr;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class zzao
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzao> CREATOR = new zzap();
  private final long zzec;
  private final int zzed;
  private final zzcq zzgj;
  private final PendingIntent zzhi;
  private zzt zzhr;
  private final long zzhs;
  private final long zzht;
  private final List<LocationRequest> zzhu;
  private final long zzhv;
  private final List<ClientIdentity> zzhw;
  private DataType zzq;
  private DataSource zzr;
  
  zzao(DataSource paramDataSource, DataType paramDataType, IBinder paramIBinder1, int paramInt1, int paramInt2, long paramLong1, long paramLong2, PendingIntent paramPendingIntent, long paramLong3, int paramInt3, List<LocationRequest> paramList, long paramLong4, IBinder paramIBinder2)
  {
    this.zzr = paramDataSource;
    this.zzq = paramDataType;
    if (paramIBinder1 == null) {
      paramDataSource = null;
    } else {
      paramDataSource = zzu.zza(paramIBinder1);
    }
    this.zzhr = paramDataSource;
    if (paramLong1 == 0L) {
      paramLong1 = paramInt1;
    }
    this.zzec = paramLong1;
    this.zzht = paramLong3;
    if (paramLong2 == 0L) {
      paramLong2 = paramInt2;
    }
    this.zzhs = paramLong2;
    this.zzhu = paramList;
    this.zzhi = paramPendingIntent;
    this.zzed = paramInt3;
    this.zzhw = Collections.emptyList();
    this.zzhv = paramLong4;
    this.zzgj = zzcr.zzj(paramIBinder2);
  }
  
  private zzao(DataSource paramDataSource, DataType paramDataType, zzt paramzzt, PendingIntent paramPendingIntent, long paramLong1, long paramLong2, long paramLong3, int paramInt, List<LocationRequest> paramList, List<ClientIdentity> paramList1, long paramLong4, zzcq paramzzcq)
  {
    this.zzr = paramDataSource;
    this.zzq = paramDataType;
    this.zzhr = paramzzt;
    this.zzhi = paramPendingIntent;
    this.zzec = paramLong1;
    this.zzht = paramLong2;
    this.zzhs = paramLong3;
    this.zzed = paramInt;
    this.zzhu = null;
    this.zzhw = paramList1;
    this.zzhv = paramLong4;
    this.zzgj = paramzzcq;
  }
  
  public zzao(SensorRequest paramSensorRequest, zzt paramzzt, PendingIntent paramPendingIntent, zzcq paramzzcq)
  {
    this(paramSensorRequest.getDataSource(), paramSensorRequest.getDataType(), paramzzt, paramPendingIntent, paramSensorRequest.getSamplingRate(TimeUnit.MICROSECONDS), paramSensorRequest.getFastestRate(TimeUnit.MICROSECONDS), paramSensorRequest.getMaxDeliveryLatency(TimeUnit.MICROSECONDS), paramSensorRequest.getAccuracyMode(), null, Collections.emptyList(), paramSensorRequest.zzx(), paramzzcq);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof zzao))
      {
        paramObject = (zzao)paramObject;
        int i;
        if ((Objects.equal(this.zzr, ((zzao)paramObject).zzr)) && (Objects.equal(this.zzq, ((zzao)paramObject).zzq)) && (Objects.equal(this.zzhr, ((zzao)paramObject).zzhr)) && (this.zzec == ((zzao)paramObject).zzec) && (this.zzht == ((zzao)paramObject).zzht) && (this.zzhs == ((zzao)paramObject).zzhs) && (this.zzed == ((zzao)paramObject).zzed) && (Objects.equal(this.zzhu, ((zzao)paramObject).zzhu))) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { this.zzr, this.zzq, this.zzhr, Long.valueOf(this.zzec), Long.valueOf(this.zzht), Long.valueOf(this.zzhs), Integer.valueOf(this.zzed), this.zzhu });
  }
  
  public final String toString()
  {
    return String.format("SensorRegistrationRequest{type %s source %s interval %s fastest %s latency %s}", new Object[] { this.zzq, this.zzr, Long.valueOf(this.zzec), Long.valueOf(this.zzht), Long.valueOf(this.zzhs) });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, this.zzr, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.zzq, paramInt, false);
    Object localObject1 = this.zzhr;
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((zzt)localObject1).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 3, (IBinder)localObject1, false);
    SafeParcelWriter.writeInt(paramParcel, 4, 0);
    SafeParcelWriter.writeInt(paramParcel, 5, 0);
    SafeParcelWriter.writeLong(paramParcel, 6, this.zzec);
    SafeParcelWriter.writeLong(paramParcel, 7, this.zzhs);
    SafeParcelWriter.writeParcelable(paramParcel, 8, this.zzhi, paramInt, false);
    SafeParcelWriter.writeLong(paramParcel, 9, this.zzht);
    SafeParcelWriter.writeInt(paramParcel, 10, this.zzed);
    SafeParcelWriter.writeTypedList(paramParcel, 11, this.zzhu, false);
    SafeParcelWriter.writeLong(paramParcel, 12, this.zzhv);
    localObject1 = this.zzgj;
    if (localObject1 == null) {
      localObject1 = localObject2;
    } else {
      localObject1 = ((zzcq)localObject1).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 13, (IBinder)localObject1, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\zzao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */