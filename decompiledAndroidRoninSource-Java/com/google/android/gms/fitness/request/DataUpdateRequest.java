package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.fitness.zzcq;
import com.google.android.gms.internal.fitness.zzcr;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataUpdateRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<DataUpdateRequest> CREATOR = new zzz();
  private final DataSet zzeb;
  private final zzcq zzgj;
  private final long zzs;
  private final long zzt;
  
  public DataUpdateRequest(long paramLong1, long paramLong2, DataSet paramDataSet, IBinder paramIBinder)
  {
    this.zzs = paramLong1;
    this.zzt = paramLong2;
    this.zzeb = paramDataSet;
    this.zzgj = zzcr.zzj(paramIBinder);
  }
  
  private DataUpdateRequest(Builder paramBuilder)
  {
    this(Builder.zza(paramBuilder), Builder.zzb(paramBuilder), Builder.zzc(paramBuilder), null);
  }
  
  public DataUpdateRequest(DataUpdateRequest paramDataUpdateRequest, IBinder paramIBinder)
  {
    this(paramDataUpdateRequest.zzs, paramDataUpdateRequest.zzt, paramDataUpdateRequest.getDataSet(), paramIBinder);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof DataUpdateRequest))
      {
        paramObject = (DataUpdateRequest)paramObject;
        int i;
        if ((this.zzs == ((DataUpdateRequest)paramObject).zzs) && (this.zzt == ((DataUpdateRequest)paramObject).zzt) && (Objects.equal(this.zzeb, ((DataUpdateRequest)paramObject).zzeb))) {
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
  
  public IBinder getCallbackBinder()
  {
    zzcq localzzcq = this.zzgj;
    if (localzzcq == null) {
      return null;
    }
    return localzzcq.asBinder();
  }
  
  public DataSet getDataSet()
  {
    return this.zzeb;
  }
  
  public long getEndTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzt, TimeUnit.MILLISECONDS);
  }
  
  public long getStartTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzs, TimeUnit.MILLISECONDS);
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { Long.valueOf(this.zzs), Long.valueOf(this.zzt), this.zzeb });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("startTimeMillis", Long.valueOf(this.zzs)).add("endTimeMillis", Long.valueOf(this.zzt)).add("dataSet", this.zzeb).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeLong(paramParcel, 1, this.zzs);
    SafeParcelWriter.writeLong(paramParcel, 2, this.zzt);
    SafeParcelWriter.writeParcelable(paramParcel, 3, getDataSet(), paramInt, false);
    SafeParcelWriter.writeIBinder(paramParcel, 4, getCallbackBinder(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final long zzu()
  {
    return this.zzs;
  }
  
  public final long zzv()
  {
    return this.zzt;
  }
  
  public static class Builder
  {
    private DataSet zzeb;
    private long zzs;
    private long zzt;
    
    public DataUpdateRequest build()
    {
      Preconditions.checkNotZero(this.zzs, "Must set a non-zero value for startTimeMillis/startTime");
      Preconditions.checkNotZero(this.zzt, "Must set a non-zero value for endTimeMillis/endTime");
      Preconditions.checkNotNull(this.zzeb, "Must set the data set");
      Iterator localIterator = this.zzeb.getDataPoints().iterator();
      while (localIterator.hasNext())
      {
        DataPoint localDataPoint = (DataPoint)localIterator.next();
        long l1 = localDataPoint.getStartTime(TimeUnit.MILLISECONDS);
        long l2 = localDataPoint.getEndTime(TimeUnit.MILLISECONDS);
        if (l1 <= l2)
        {
          bool = l1 < 0L;
          if (((!bool) || (l1 >= this.zzs)) && ((!bool) || (l1 <= this.zzt)) && (l2 <= this.zzt) && (l2 >= this.zzs))
          {
            bool = false;
            break label152;
          }
        }
        boolean bool = true;
        label152:
        Preconditions.checkState(bool ^ true, "Data Point's startTimeMillis %d, endTimeMillis %d should lie between timeRange provided in the request. StartTimeMillis %d, EndTimeMillis: %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(this.zzs), Long.valueOf(this.zzt) });
      }
      return new DataUpdateRequest(this, null);
    }
    
    public Builder setDataSet(DataSet paramDataSet)
    {
      Preconditions.checkNotNull(paramDataSet, "Must set the data set");
      this.zzeb = paramDataSet;
      return this;
    }
    
    public Builder setTimeInterval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      boolean bool;
      if (paramLong1 > 0L) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Invalid start time :%d", new Object[] { Long.valueOf(paramLong1) });
      if (paramLong2 >= paramLong1) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Invalid end time :%d", new Object[] { Long.valueOf(paramLong2) });
      this.zzs = paramTimeUnit.toMillis(paramLong1);
      this.zzt = paramTimeUnit.toMillis(paramLong2);
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\DataUpdateRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */