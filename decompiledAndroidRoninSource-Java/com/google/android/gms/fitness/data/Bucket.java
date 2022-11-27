package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fitness.zzfa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Bucket
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<Bucket> CREATOR = new zze();
  public static final int TYPE_ACTIVITY_SEGMENT = 4;
  public static final int TYPE_ACTIVITY_TYPE = 3;
  public static final int TYPE_SESSION = 2;
  public static final int TYPE_TIME = 1;
  private final int zzai;
  private final List<DataSet> zzaj;
  private final int zzak;
  private boolean zzal = false;
  private final long zzs;
  private final long zzt;
  private final Session zzz;
  
  Bucket(long paramLong1, long paramLong2, Session paramSession, int paramInt1, List<DataSet> paramList, int paramInt2, boolean paramBoolean)
  {
    this.zzs = paramLong1;
    this.zzt = paramLong2;
    this.zzz = paramSession;
    this.zzai = paramInt1;
    this.zzaj = paramList;
    this.zzak = paramInt2;
    this.zzal = paramBoolean;
  }
  
  public Bucket(RawBucket paramRawBucket, List<DataSource> paramList)
  {
    this(l1, l2, localSession, i, localArrayList, paramRawBucket.zzak, paramRawBucket.zzal);
  }
  
  public static String zza(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                return "bug";
              }
              return "intervals";
            }
            return "segment";
          }
          return "type";
        }
        return "session";
      }
      return "time";
    }
    return "none";
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Bucket)) {
      return false;
    }
    paramObject = (Bucket)paramObject;
    return (this.zzs == ((Bucket)paramObject).zzs) && (this.zzt == ((Bucket)paramObject).zzt) && (this.zzai == ((Bucket)paramObject).zzai) && (Objects.equal(this.zzaj, ((Bucket)paramObject).zzaj)) && (this.zzak == ((Bucket)paramObject).zzak) && (this.zzal == ((Bucket)paramObject).zzal);
  }
  
  public String getActivity()
  {
    return zzfa.getName(this.zzai);
  }
  
  public final int getActivityType()
  {
    return this.zzai;
  }
  
  public int getBucketType()
  {
    return this.zzak;
  }
  
  public DataSet getDataSet(DataType paramDataType)
  {
    Iterator localIterator = this.zzaj.iterator();
    while (localIterator.hasNext())
    {
      DataSet localDataSet = (DataSet)localIterator.next();
      if (localDataSet.getDataType().equals(paramDataType)) {
        return localDataSet;
      }
    }
    return null;
  }
  
  public List<DataSet> getDataSets()
  {
    return this.zzaj;
  }
  
  public long getEndTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzt, TimeUnit.MILLISECONDS);
  }
  
  public Session getSession()
  {
    return this.zzz;
  }
  
  public long getStartTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzs, TimeUnit.MILLISECONDS);
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { Long.valueOf(this.zzs), Long.valueOf(this.zzt), Integer.valueOf(this.zzai), Integer.valueOf(this.zzak) });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("startTime", Long.valueOf(this.zzs)).add("endTime", Long.valueOf(this.zzt)).add("activity", Integer.valueOf(this.zzai)).add("dataSets", this.zzaj).add("bucketType", zza(this.zzak)).add("serverHasMoreData", Boolean.valueOf(this.zzal)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeLong(paramParcel, 1, this.zzs);
    SafeParcelWriter.writeLong(paramParcel, 2, this.zzt);
    SafeParcelWriter.writeParcelable(paramParcel, 3, getSession(), paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 4, this.zzai);
    SafeParcelWriter.writeTypedList(paramParcel, 5, getDataSets(), false);
    SafeParcelWriter.writeInt(paramParcel, 6, getBucketType());
    SafeParcelWriter.writeBoolean(paramParcel, 7, zza());
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final boolean zza()
  {
    if (this.zzal) {
      return true;
    }
    Iterator localIterator = this.zzaj.iterator();
    while (localIterator.hasNext()) {
      if (((DataSet)localIterator.next()).zza()) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean zza(Bucket paramBucket)
  {
    return (this.zzs == paramBucket.zzs) && (this.zzt == paramBucket.zzt) && (this.zzai == paramBucket.zzai) && (this.zzak == paramBucket.zzak);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\data\Bucket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */