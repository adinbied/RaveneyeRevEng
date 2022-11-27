package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class RawBucket
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<RawBucket> CREATOR = new zzy();
  public final List<RawDataSet> zzaj;
  public final int zzak;
  public final boolean zzal;
  public final int zzdv;
  public final long zzs;
  public final long zzt;
  public final Session zzz;
  
  public RawBucket(long paramLong1, long paramLong2, Session paramSession, int paramInt1, List<RawDataSet> paramList, int paramInt2, boolean paramBoolean)
  {
    this.zzs = paramLong1;
    this.zzt = paramLong2;
    this.zzz = paramSession;
    this.zzdv = paramInt1;
    this.zzaj = paramList;
    this.zzak = paramInt2;
    this.zzal = paramBoolean;
  }
  
  public RawBucket(Bucket paramBucket, List<DataSource> paramList)
  {
    this.zzs = paramBucket.getStartTime(TimeUnit.MILLISECONDS);
    this.zzt = paramBucket.getEndTime(TimeUnit.MILLISECONDS);
    this.zzz = paramBucket.getSession();
    this.zzdv = paramBucket.getActivityType();
    this.zzak = paramBucket.getBucketType();
    this.zzal = paramBucket.zza();
    paramBucket = paramBucket.getDataSets();
    this.zzaj = new ArrayList(paramBucket.size());
    paramBucket = paramBucket.iterator();
    while (paramBucket.hasNext())
    {
      DataSet localDataSet = (DataSet)paramBucket.next();
      this.zzaj.add(new RawDataSet(localDataSet, paramList));
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof RawBucket)) {
      return false;
    }
    paramObject = (RawBucket)paramObject;
    return (this.zzs == ((RawBucket)paramObject).zzs) && (this.zzt == ((RawBucket)paramObject).zzt) && (this.zzdv == ((RawBucket)paramObject).zzdv) && (Objects.equal(this.zzaj, ((RawBucket)paramObject).zzaj)) && (this.zzak == ((RawBucket)paramObject).zzak) && (this.zzal == ((RawBucket)paramObject).zzal);
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { Long.valueOf(this.zzs), Long.valueOf(this.zzt), Integer.valueOf(this.zzak) });
  }
  
  public final String toString()
  {
    return Objects.toStringHelper(this).add("startTime", Long.valueOf(this.zzs)).add("endTime", Long.valueOf(this.zzt)).add("activity", Integer.valueOf(this.zzdv)).add("dataSets", this.zzaj).add("bucketType", Integer.valueOf(this.zzak)).add("serverHasMoreData", Boolean.valueOf(this.zzal)).toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeLong(paramParcel, 1, this.zzs);
    SafeParcelWriter.writeLong(paramParcel, 2, this.zzt);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.zzz, paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 4, this.zzdv);
    SafeParcelWriter.writeTypedList(paramParcel, 5, this.zzaj, false);
    SafeParcelWriter.writeInt(paramParcel, 6, this.zzak);
    SafeParcelWriter.writeBoolean(paramParcel, 7, this.zzal);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\data\RawBucket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */