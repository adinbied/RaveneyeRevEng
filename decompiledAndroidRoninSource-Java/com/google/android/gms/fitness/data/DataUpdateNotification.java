package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.concurrent.TimeUnit;

public class DataUpdateNotification
  extends AbstractSafeParcelable
{
  public static final String ACTION = "com.google.android.gms.fitness.DATA_UPDATE_NOTIFICATION";
  public static final Parcelable.Creator<DataUpdateNotification> CREATOR = new zzn();
  public static final String EXTRA_DATA_UPDATE_NOTIFICATION = "vnd.google.fitness.data_udpate_notification";
  public static final int OPERATION_DELETE = 2;
  public static final int OPERATION_INSERT = 1;
  public static final int OPERATION_UPDATE = 3;
  private final long zzbz;
  private final long zzca;
  private final int zzcb;
  private final DataType zzq;
  private final DataSource zzr;
  
  public DataUpdateNotification(long paramLong1, long paramLong2, int paramInt, DataSource paramDataSource, DataType paramDataType)
  {
    this.zzbz = paramLong1;
    this.zzca = paramLong2;
    this.zzcb = paramInt;
    this.zzr = paramDataSource;
    this.zzq = paramDataType;
  }
  
  public static DataUpdateNotification getDataUpdateNotification(Intent paramIntent)
  {
    return (DataUpdateNotification)SafeParcelableSerializer.deserializeFromIntentExtra(paramIntent, "vnd.google.fitness.data_udpate_notification", CREATOR);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof DataUpdateNotification)) {
      return false;
    }
    paramObject = (DataUpdateNotification)paramObject;
    return (this.zzbz == ((DataUpdateNotification)paramObject).zzbz) && (this.zzca == ((DataUpdateNotification)paramObject).zzca) && (this.zzcb == ((DataUpdateNotification)paramObject).zzcb) && (Objects.equal(this.zzr, ((DataUpdateNotification)paramObject).zzr)) && (Objects.equal(this.zzq, ((DataUpdateNotification)paramObject).zzq));
  }
  
  public DataSource getDataSource()
  {
    return this.zzr;
  }
  
  public DataType getDataType()
  {
    return this.zzq;
  }
  
  public int getOperationType()
  {
    return this.zzcb;
  }
  
  public long getUpdateEndTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzca, TimeUnit.NANOSECONDS);
  }
  
  public long getUpdateStartTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzbz, TimeUnit.NANOSECONDS);
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { Long.valueOf(this.zzbz), Long.valueOf(this.zzca), Integer.valueOf(this.zzcb), this.zzr, this.zzq });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("updateStartTimeNanos", Long.valueOf(this.zzbz)).add("updateEndTimeNanos", Long.valueOf(this.zzca)).add("operationType", Integer.valueOf(this.zzcb)).add("dataSource", this.zzr).add("dataType", this.zzq).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeLong(paramParcel, 1, this.zzbz);
    SafeParcelWriter.writeLong(paramParcel, 2, this.zzca);
    SafeParcelWriter.writeInt(paramParcel, 3, getOperationType());
    SafeParcelWriter.writeParcelable(paramParcel, 4, getDataSource(), paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 5, getDataType(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\data\DataUpdateNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */