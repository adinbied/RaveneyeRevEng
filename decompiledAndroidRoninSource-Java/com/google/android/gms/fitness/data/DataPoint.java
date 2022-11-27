package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class DataPoint
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<DataPoint> CREATOR = new zzh();
  private long zzao;
  private long zzap;
  private final Value[] zzaq;
  private DataSource zzar;
  private long zzas;
  private long zzat;
  private final DataSource zzr;
  
  private DataPoint(DataSource paramDataSource)
  {
    this.zzr = ((DataSource)Preconditions.checkNotNull(paramDataSource, "Data source cannot be null"));
    paramDataSource = paramDataSource.getDataType().getFields();
    this.zzaq = new Value[paramDataSource.size()];
    paramDataSource = paramDataSource.iterator();
    int i = 0;
    while (paramDataSource.hasNext())
    {
      Field localField = (Field)paramDataSource.next();
      this.zzaq[i] = new Value(localField.getFormat());
      i += 1;
    }
  }
  
  public DataPoint(DataSource paramDataSource1, long paramLong1, long paramLong2, Value[] paramArrayOfValue, DataSource paramDataSource2, long paramLong3, long paramLong4)
  {
    this.zzr = paramDataSource1;
    this.zzar = paramDataSource2;
    this.zzao = paramLong1;
    this.zzap = paramLong2;
    this.zzaq = paramArrayOfValue;
    this.zzas = paramLong3;
    this.zzat = paramLong4;
  }
  
  private DataPoint(DataSource paramDataSource1, DataSource paramDataSource2, RawDataPoint paramRawDataPoint)
  {
    this(paramDataSource1, zza(Long.valueOf(paramRawDataPoint.getTimestampNanos()), 0L), zza(Long.valueOf(paramRawDataPoint.zzn()), 0L), paramRawDataPoint.zzc(), paramDataSource2, zza(Long.valueOf(paramRawDataPoint.zze()), 0L), zza(Long.valueOf(paramRawDataPoint.zzf()), 0L));
  }
  
  DataPoint(List<DataSource> paramList, RawDataPoint paramRawDataPoint)
  {
    this(zza(paramList, paramRawDataPoint.zzo()), zza(paramList, paramRawDataPoint.zzp()), paramRawDataPoint);
  }
  
  public static DataPoint create(DataSource paramDataSource)
  {
    return new DataPoint(paramDataSource);
  }
  
  public static DataPoint extract(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    return (DataPoint)SafeParcelableSerializer.deserializeFromIntentExtra(paramIntent, "com.google.android.gms.fitness.EXTRA_DATA_POINT", CREATOR);
  }
  
  private static long zza(Long paramLong, long paramLong1)
  {
    if (paramLong != null) {
      return paramLong.longValue();
    }
    return 0L;
  }
  
  private static DataSource zza(List<DataSource> paramList, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < paramList.size())) {
      return (DataSource)paramList.get(paramInt);
    }
    return null;
  }
  
  private final void zzc(int paramInt)
  {
    List localList = getDataType().getFields();
    int i = localList.size();
    boolean bool;
    if (paramInt == i) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "Attempting to insert %s values, but needed %s: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), localList });
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof DataPoint)) {
      return false;
    }
    paramObject = (DataPoint)paramObject;
    return (Objects.equal(this.zzr, ((DataPoint)paramObject).zzr)) && (this.zzao == ((DataPoint)paramObject).zzao) && (this.zzap == ((DataPoint)paramObject).zzap) && (Arrays.equals(this.zzaq, ((DataPoint)paramObject).zzaq)) && (Objects.equal(getOriginalDataSource(), ((DataPoint)paramObject).getOriginalDataSource()));
  }
  
  public final DataSource getDataSource()
  {
    return this.zzr;
  }
  
  public final DataType getDataType()
  {
    return this.zzr.getDataType();
  }
  
  public final long getEndTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzao, TimeUnit.NANOSECONDS);
  }
  
  public final DataSource getOriginalDataSource()
  {
    DataSource localDataSource = this.zzar;
    if (localDataSource != null) {
      return localDataSource;
    }
    return this.zzr;
  }
  
  public final long getStartTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzap, TimeUnit.NANOSECONDS);
  }
  
  public final long getTimestamp(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzao, TimeUnit.NANOSECONDS);
  }
  
  public final Value getValue(Field paramField)
  {
    int i = getDataType().indexOf(paramField);
    return this.zzaq[i];
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { this.zzr, Long.valueOf(this.zzao), Long.valueOf(this.zzap) });
  }
  
  public final DataPoint setFloatValues(float... paramVarArgs)
  {
    zzc(paramVarArgs.length);
    int i = 0;
    while (i < paramVarArgs.length)
    {
      this.zzaq[i].setFloat(paramVarArgs[i]);
      i += 1;
    }
    return this;
  }
  
  public final DataPoint setIntValues(int... paramVarArgs)
  {
    zzc(paramVarArgs.length);
    int i = 0;
    while (i < paramVarArgs.length)
    {
      this.zzaq[i].setInt(paramVarArgs[i]);
      i += 1;
    }
    return this;
  }
  
  public final DataPoint setTimeInterval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    this.zzap = paramTimeUnit.toNanos(paramLong1);
    this.zzao = paramTimeUnit.toNanos(paramLong2);
    return this;
  }
  
  public final DataPoint setTimestamp(long paramLong, TimeUnit paramTimeUnit)
  {
    this.zzao = paramTimeUnit.toNanos(paramLong);
    return this;
  }
  
  public final String toString()
  {
    String str1 = Arrays.toString(this.zzaq);
    long l1 = this.zzap;
    long l2 = this.zzao;
    long l3 = this.zzas;
    long l4 = this.zzat;
    String str2 = this.zzr.toDebugString();
    Object localObject = this.zzar;
    if (localObject != null) {
      localObject = ((DataSource)localObject).toDebugString();
    } else {
      localObject = "N/A";
    }
    return String.format("DataPoint{%s@[%s, %s,raw=%s,insert=%s](%s %s)}", new Object[] { str1, Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), str2, localObject });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, getDataSource(), paramInt, false);
    SafeParcelWriter.writeLong(paramParcel, 3, this.zzao);
    SafeParcelWriter.writeLong(paramParcel, 4, this.zzap);
    SafeParcelWriter.writeTypedArray(paramParcel, 5, this.zzaq, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 6, this.zzar, paramInt, false);
    SafeParcelWriter.writeLong(paramParcel, 7, this.zzas);
    SafeParcelWriter.writeLong(paramParcel, 8, this.zzat);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final Value zzb(int paramInt)
  {
    DataType localDataType = getDataType();
    boolean bool;
    if ((paramInt >= 0) && (paramInt < localDataType.getFields().size())) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "fieldIndex %s is out of range for %s", new Object[] { Integer.valueOf(paramInt), localDataType });
    return this.zzaq[paramInt];
  }
  
  public final Value[] zzc()
  {
    return this.zzaq;
  }
  
  public final DataSource zzd()
  {
    return this.zzar;
  }
  
  public final long zze()
  {
    return this.zzas;
  }
  
  public final long zzf()
  {
    return this.zzat;
  }
  
  public final void zzg()
  {
    DataSource localDataSource = getDataSource();
    Preconditions.checkArgument(getDataType().getName().equals(localDataSource.getDataType().getName()), "Conflicting data types found %s vs %s", new Object[] { getDataType(), getDataType() });
    boolean bool;
    if (this.zzao > 0L) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "Data point does not have the timestamp set: %s", new Object[] { this });
    if (this.zzap <= this.zzao) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "Data point with start time greater than end time found: %s", new Object[] { this });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\data\DataPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */