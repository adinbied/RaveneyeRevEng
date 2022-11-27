package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;
import com.google.android.gms.internal.fitness.zzbh;
import com.google.android.gms.internal.fitness.zzbi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DataReadRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<DataReadRequest> CREATOR = new zzn();
  public static final int NO_LIMIT = 0;
  private final int limit;
  private final List<DataType> zzah;
  private final int zzak;
  private final List<DataSource> zzgm;
  private final List<DataType> zzgr;
  private final List<DataSource> zzgs;
  private final long zzgt;
  private final DataSource zzgu;
  private final boolean zzgv;
  private final boolean zzgw;
  private final zzbh zzgx;
  private final List<Device> zzgy;
  private final List<Integer> zzgz;
  private final List<Long> zzha;
  private final List<Long> zzhb;
  private final long zzs;
  private final long zzt;
  
  private DataReadRequest(Builder paramBuilder)
  {
    this(Builder.zza(paramBuilder), Builder.zzb(paramBuilder), Builder.zzc(paramBuilder), Builder.zzd(paramBuilder), Builder.zze(paramBuilder), Builder.zzf(paramBuilder), Builder.zzg(paramBuilder), Builder.zzh(paramBuilder), Builder.zzi(paramBuilder), Builder.zzj(paramBuilder), false, Builder.zzk(paramBuilder), null, Builder.zzl(paramBuilder), Builder.zzm(paramBuilder), Builder.zzn(paramBuilder), Builder.zzo(paramBuilder));
  }
  
  public DataReadRequest(DataReadRequest paramDataReadRequest, zzbh paramzzbh)
  {
    this(paramDataReadRequest.zzah, paramDataReadRequest.zzgm, paramDataReadRequest.zzs, paramDataReadRequest.zzt, paramDataReadRequest.zzgr, paramDataReadRequest.zzgs, paramDataReadRequest.zzak, paramDataReadRequest.zzgt, paramDataReadRequest.zzgu, paramDataReadRequest.limit, paramDataReadRequest.zzgv, paramDataReadRequest.zzgw, paramzzbh, paramDataReadRequest.zzgy, paramDataReadRequest.zzgz, paramDataReadRequest.zzha, paramDataReadRequest.zzhb);
  }
  
  DataReadRequest(List<DataType> paramList1, List<DataSource> paramList2, long paramLong1, long paramLong2, List<DataType> paramList3, List<DataSource> paramList4, int paramInt1, long paramLong3, DataSource paramDataSource, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, IBinder paramIBinder, List<Device> paramList, List<Integer> paramList5, List<Long> paramList6, List<Long> paramList7)
  {
    this.zzah = paramList1;
    this.zzgm = paramList2;
    this.zzs = paramLong1;
    this.zzt = paramLong2;
    this.zzgr = paramList3;
    this.zzgs = paramList4;
    this.zzak = paramInt1;
    this.zzgt = paramLong3;
    this.zzgu = paramDataSource;
    this.limit = paramInt2;
    this.zzgv = paramBoolean1;
    this.zzgw = paramBoolean2;
    if (paramIBinder == null) {
      paramList1 = null;
    } else {
      paramList1 = zzbi.zzc(paramIBinder);
    }
    this.zzgx = paramList1;
    if (paramList == null) {
      paramList = Collections.emptyList();
    }
    this.zzgy = paramList;
    if (paramList5 == null) {
      paramList5 = Collections.emptyList();
    }
    this.zzgz = paramList5;
    if (paramList6 == null) {
      paramList6 = Collections.emptyList();
    }
    this.zzha = paramList6;
    if (paramList7 == null) {
      paramList7 = Collections.emptyList();
    }
    this.zzhb = paramList7;
    if (this.zzha.size() == this.zzhb.size()) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    Preconditions.checkArgument(paramBoolean1, "Unequal number of interval start and end times.");
  }
  
  private DataReadRequest(List<DataType> paramList1, List<DataSource> paramList2, long paramLong1, long paramLong2, List<DataType> paramList3, List<DataSource> paramList4, int paramInt1, long paramLong3, DataSource paramDataSource, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, zzbh paramzzbh, List<Device> paramList, List<Integer> paramList5, List<Long> paramList6, List<Long> paramList7)
  {
    this(paramList1, paramList2, paramLong1, paramLong2, paramList3, paramList4, paramInt1, paramLong3, paramDataSource, paramInt2, paramBoolean1, paramBoolean2, paramzzbh, paramList, paramList5, paramList6, paramList7);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof DataReadRequest))
      {
        paramObject = (DataReadRequest)paramObject;
        int i;
        if ((this.zzah.equals(((DataReadRequest)paramObject).zzah)) && (this.zzgm.equals(((DataReadRequest)paramObject).zzgm)) && (this.zzs == ((DataReadRequest)paramObject).zzs) && (this.zzt == ((DataReadRequest)paramObject).zzt) && (this.zzak == ((DataReadRequest)paramObject).zzak) && (this.zzgs.equals(((DataReadRequest)paramObject).zzgs)) && (this.zzgr.equals(((DataReadRequest)paramObject).zzgr)) && (Objects.equal(this.zzgu, ((DataReadRequest)paramObject).zzgu)) && (this.zzgt == ((DataReadRequest)paramObject).zzgt) && (this.zzgw == ((DataReadRequest)paramObject).zzgw) && (this.limit == ((DataReadRequest)paramObject).limit) && (this.zzgv == ((DataReadRequest)paramObject).zzgv) && (Objects.equal(this.zzgx, ((DataReadRequest)paramObject).zzgx)) && (Objects.equal(this.zzgy, ((DataReadRequest)paramObject).zzgy)) && (Objects.equal(this.zzgz, ((DataReadRequest)paramObject).zzgz))) {
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
  
  public DataSource getActivityDataSource()
  {
    return this.zzgu;
  }
  
  public List<DataSource> getAggregatedDataSources()
  {
    return this.zzgs;
  }
  
  public List<DataType> getAggregatedDataTypes()
  {
    return this.zzgr;
  }
  
  public long getBucketDuration(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzgt, TimeUnit.MILLISECONDS);
  }
  
  public int getBucketType()
  {
    return this.zzak;
  }
  
  public List<DataSource> getDataSources()
  {
    return this.zzgm;
  }
  
  public List<DataType> getDataTypes()
  {
    return this.zzah;
  }
  
  public long getEndTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzt, TimeUnit.MILLISECONDS);
  }
  
  public List<Integer> getFilteredDataQualityStandards()
  {
    return this.zzgz;
  }
  
  public int getLimit()
  {
    return this.limit;
  }
  
  public long getStartTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzs, TimeUnit.MILLISECONDS);
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.zzak), Long.valueOf(this.zzs), Long.valueOf(this.zzt) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataReadRequest{");
    Iterator localIterator;
    if (!this.zzah.isEmpty())
    {
      localIterator = this.zzah.iterator();
      while (localIterator.hasNext())
      {
        localStringBuilder.append(((DataType)localIterator.next()).zzm());
        localStringBuilder.append(" ");
      }
    }
    if (!this.zzgm.isEmpty())
    {
      localIterator = this.zzgm.iterator();
      while (localIterator.hasNext())
      {
        localStringBuilder.append(((DataSource)localIterator.next()).toDebugString());
        localStringBuilder.append(" ");
      }
    }
    if (this.zzak != 0)
    {
      localStringBuilder.append("bucket by ");
      localStringBuilder.append(Bucket.zza(this.zzak));
      if (this.zzgt > 0L)
      {
        localStringBuilder.append(" >");
        localStringBuilder.append(this.zzgt);
        localStringBuilder.append("ms");
      }
      localStringBuilder.append(": ");
    }
    if (!this.zzgr.isEmpty())
    {
      localIterator = this.zzgr.iterator();
      while (localIterator.hasNext())
      {
        localStringBuilder.append(((DataType)localIterator.next()).zzm());
        localStringBuilder.append(" ");
      }
    }
    if (!this.zzgs.isEmpty())
    {
      localIterator = this.zzgs.iterator();
      while (localIterator.hasNext())
      {
        localStringBuilder.append(((DataSource)localIterator.next()).toDebugString());
        localStringBuilder.append(" ");
      }
    }
    localStringBuilder.append(String.format(Locale.US, "(%tF %tT - %tF %tT)", new Object[] { Long.valueOf(this.zzs), Long.valueOf(this.zzs), Long.valueOf(this.zzt), Long.valueOf(this.zzt) }));
    if (this.zzgu != null)
    {
      localStringBuilder.append("activities: ");
      localStringBuilder.append(this.zzgu.toDebugString());
    }
    if (!this.zzgz.isEmpty())
    {
      localStringBuilder.append("quality: ");
      localIterator = this.zzgz.iterator();
      while (localIterator.hasNext())
      {
        localStringBuilder.append(DataSource.zzd(((Integer)localIterator.next()).intValue()));
        localStringBuilder.append(" ");
      }
    }
    if (this.zzgw) {
      localStringBuilder.append(" +server");
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, getDataTypes(), false);
    SafeParcelWriter.writeTypedList(paramParcel, 2, getDataSources(), false);
    SafeParcelWriter.writeLong(paramParcel, 3, this.zzs);
    SafeParcelWriter.writeLong(paramParcel, 4, this.zzt);
    SafeParcelWriter.writeTypedList(paramParcel, 5, getAggregatedDataTypes(), false);
    SafeParcelWriter.writeTypedList(paramParcel, 6, getAggregatedDataSources(), false);
    SafeParcelWriter.writeInt(paramParcel, 7, getBucketType());
    SafeParcelWriter.writeLong(paramParcel, 8, this.zzgt);
    SafeParcelWriter.writeParcelable(paramParcel, 9, getActivityDataSource(), paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 10, getLimit());
    SafeParcelWriter.writeBoolean(paramParcel, 12, this.zzgv);
    SafeParcelWriter.writeBoolean(paramParcel, 13, this.zzgw);
    Object localObject = this.zzgx;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((zzbh)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 14, (IBinder)localObject, false);
    SafeParcelWriter.writeTypedList(paramParcel, 16, this.zzgy, false);
    SafeParcelWriter.writeIntegerList(paramParcel, 17, getFilteredDataQualityStandards(), false);
    SafeParcelWriter.writeLongList(paramParcel, 18, this.zzha, false);
    SafeParcelWriter.writeLongList(paramParcel, 19, this.zzhb, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public static class Builder
  {
    private int limit = 0;
    private List<DataType> zzah = new ArrayList();
    private int zzak = 0;
    private List<DataSource> zzgm = new ArrayList();
    private List<DataType> zzgr = new ArrayList();
    private List<DataSource> zzgs = new ArrayList();
    private long zzgt = 0L;
    private DataSource zzgu;
    private boolean zzgv = false;
    private boolean zzgw = false;
    private final List<Device> zzgy = new ArrayList();
    private final List<Integer> zzgz = new ArrayList();
    private List<Long> zzha = new ArrayList();
    private List<Long> zzhb = new ArrayList();
    private long zzs;
    private long zzt;
    
    public Builder addFilteredDataQualityStandard(int paramInt)
    {
      Preconditions.checkArgument(this.zzgy.isEmpty(), "Cannot add data quality standard filter when filtering by device.");
      this.zzgz.add(Integer.valueOf(paramInt));
      return this;
    }
    
    public Builder aggregate(DataSource paramDataSource, DataType paramDataType)
    {
      Preconditions.checkNotNull(paramDataSource, "Attempting to add a null data source");
      Preconditions.checkState(this.zzgm.contains(paramDataSource) ^ true, "Cannot add the same data source for aggregated and detailed");
      DataType localDataType = paramDataSource.getDataType();
      List localList = DataType.getAggregatesForInput(localDataType);
      Preconditions.checkArgument(localList.isEmpty() ^ true, "Unsupported input data type specified for aggregation: %s", new Object[] { localDataType });
      Preconditions.checkArgument(localList.contains(paramDataType), "Invalid output aggregate data type specified: %s -> %s", new Object[] { localDataType, paramDataType });
      if (!this.zzgs.contains(paramDataSource)) {
        this.zzgs.add(paramDataSource);
      }
      return this;
    }
    
    public Builder aggregate(DataType paramDataType1, DataType paramDataType2)
    {
      Preconditions.checkNotNull(paramDataType1, "Attempting to use a null data type");
      Preconditions.checkState(this.zzah.contains(paramDataType1) ^ true, "Cannot add the same data type as aggregated and detailed");
      List localList = DataType.getAggregatesForInput(paramDataType1);
      Preconditions.checkArgument(localList.isEmpty() ^ true, "Unsupported input data type specified for aggregation: %s", new Object[] { paramDataType1 });
      Preconditions.checkArgument(localList.contains(paramDataType2), "Invalid output aggregate data type specified: %s -> %s", new Object[] { paramDataType1, paramDataType2 });
      if (!this.zzgr.contains(paramDataType1)) {
        this.zzgr.add(paramDataType1);
      }
      return this;
    }
    
    public Builder bucketByActivitySegment(int paramInt, TimeUnit paramTimeUnit)
    {
      boolean bool;
      if (this.zzak == 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Bucketing strategy already set to %s", new Object[] { Integer.valueOf(this.zzak) });
      if (paramInt > 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Must specify a valid minimum duration for an activity segment: %d", new Object[] { Integer.valueOf(paramInt) });
      this.zzak = 4;
      this.zzgt = paramTimeUnit.toMillis(paramInt);
      return this;
    }
    
    public Builder bucketByActivitySegment(int paramInt, TimeUnit paramTimeUnit, DataSource paramDataSource)
    {
      boolean bool;
      if (this.zzak == 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Bucketing strategy already set to %s", new Object[] { Integer.valueOf(this.zzak) });
      if (paramInt > 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Must specify a valid minimum duration for an activity segment: %d", new Object[] { Integer.valueOf(paramInt) });
      if (paramDataSource != null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Invalid activity data source specified");
      Preconditions.checkArgument(paramDataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", new Object[] { paramDataSource });
      this.zzgu = paramDataSource;
      this.zzak = 4;
      this.zzgt = paramTimeUnit.toMillis(paramInt);
      return this;
    }
    
    public Builder bucketByActivityType(int paramInt, TimeUnit paramTimeUnit)
    {
      boolean bool;
      if (this.zzak == 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Bucketing strategy already set to %s", new Object[] { Integer.valueOf(this.zzak) });
      if (paramInt > 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Must specify a valid minimum duration for an activity segment: %d", new Object[] { Integer.valueOf(paramInt) });
      this.zzak = 3;
      this.zzgt = paramTimeUnit.toMillis(paramInt);
      return this;
    }
    
    public Builder bucketByActivityType(int paramInt, TimeUnit paramTimeUnit, DataSource paramDataSource)
    {
      boolean bool;
      if (this.zzak == 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Bucketing strategy already set to %s", new Object[] { Integer.valueOf(this.zzak) });
      if (paramInt > 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Must specify a valid minimum duration for an activity segment: %d", new Object[] { Integer.valueOf(paramInt) });
      if (paramDataSource != null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Invalid activity data source specified");
      Preconditions.checkArgument(paramDataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", new Object[] { paramDataSource });
      this.zzgu = paramDataSource;
      this.zzak = 3;
      this.zzgt = paramTimeUnit.toMillis(paramInt);
      return this;
    }
    
    public Builder bucketBySession(int paramInt, TimeUnit paramTimeUnit)
    {
      boolean bool;
      if (this.zzak == 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Bucketing strategy already set to %s", new Object[] { Integer.valueOf(this.zzak) });
      if (paramInt > 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Must specify a valid minimum duration for a session: %d", new Object[] { Integer.valueOf(paramInt) });
      this.zzak = 2;
      this.zzgt = paramTimeUnit.toMillis(paramInt);
      return this;
    }
    
    public Builder bucketByTime(int paramInt, TimeUnit paramTimeUnit)
    {
      boolean bool;
      if (this.zzak == 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Bucketing strategy already set to %s", new Object[] { Integer.valueOf(this.zzak) });
      if (paramInt > 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Must specify a valid minimum duration: %d", new Object[] { Integer.valueOf(paramInt) });
      this.zzak = 1;
      this.zzgt = paramTimeUnit.toMillis(paramInt);
      return this;
    }
    
    public DataReadRequest build()
    {
      boolean bool1 = this.zzgm.isEmpty();
      boolean bool2 = false;
      if ((bool1) && (this.zzah.isEmpty()) && (this.zzgs.isEmpty()) && (this.zzgr.isEmpty())) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      Preconditions.checkState(bool1, "Must add at least one data source (aggregated or detailed)");
      if (this.zzak != 5)
      {
        if (this.zzs > 0L) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        Preconditions.checkState(bool1, "Invalid start time: %s", new Object[] { Long.valueOf(this.zzs) });
        long l = this.zzt;
        if ((l > 0L) && (l > this.zzs)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        Preconditions.checkState(bool1, "Invalid end time: %s", new Object[] { Long.valueOf(this.zzt) });
      }
      if ((this.zzgs.isEmpty()) && (this.zzgr.isEmpty())) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (this.zzak == 0) {
        Preconditions.checkState(bool1, "Must specify a valid bucketing strategy while requesting aggregation");
      }
      if (!bool1)
      {
        bool1 = bool2;
        if (this.zzak != 0) {
          bool1 = true;
        }
        Preconditions.checkState(bool1, "Must specify a valid bucketing strategy while requesting aggregation");
      }
      return new DataReadRequest(this, null);
    }
    
    public Builder enableServerQueries()
    {
      this.zzgw = true;
      return this;
    }
    
    public Builder read(DataSource paramDataSource)
    {
      Preconditions.checkNotNull(paramDataSource, "Attempting to add a null data source");
      Preconditions.checkArgument(this.zzgs.contains(paramDataSource) ^ true, "Cannot add the same data source as aggregated and detailed");
      if (!this.zzgm.contains(paramDataSource)) {
        this.zzgm.add(paramDataSource);
      }
      return this;
    }
    
    public Builder read(DataType paramDataType)
    {
      Preconditions.checkNotNull(paramDataType, "Attempting to use a null data type");
      Preconditions.checkState(this.zzgr.contains(paramDataType) ^ true, "Cannot add the same data type as aggregated and detailed");
      if (!this.zzah.contains(paramDataType)) {
        this.zzah.add(paramDataType);
      }
      return this;
    }
    
    public Builder setLimit(int paramInt)
    {
      boolean bool;
      if (paramInt > 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Invalid limit %d is specified", new Object[] { Integer.valueOf(paramInt) });
      this.limit = paramInt;
      return this;
    }
    
    public Builder setTimeRange(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      this.zzs = paramTimeUnit.toMillis(paramLong1);
      this.zzt = paramTimeUnit.toMillis(paramLong2);
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\DataReadRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */