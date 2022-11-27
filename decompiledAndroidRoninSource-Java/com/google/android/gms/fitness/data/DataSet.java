package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fitness.zzj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class DataSet
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<DataSet> CREATOR = new zzi();
  private final int versionCode;
  private boolean zzal = false;
  private final List<DataPoint> zzau;
  private final List<DataSource> zzav;
  private final DataSource zzr;
  
  DataSet(int paramInt, DataSource paramDataSource, List<RawDataPoint> paramList, List<DataSource> paramList1, boolean paramBoolean)
  {
    this.versionCode = paramInt;
    this.zzr = paramDataSource;
    this.zzal = paramBoolean;
    this.zzau = new ArrayList(paramList.size());
    if (paramInt < 2) {
      paramList1 = Collections.singletonList(paramDataSource);
    }
    this.zzav = paramList1;
    paramDataSource = paramList.iterator();
    while (paramDataSource.hasNext())
    {
      paramList = (RawDataPoint)paramDataSource.next();
      this.zzau.add(new DataPoint(this.zzav, paramList));
    }
  }
  
  private DataSet(DataSource paramDataSource)
  {
    this.versionCode = 3;
    this.zzr = ((DataSource)Preconditions.checkNotNull(paramDataSource));
    this.zzau = new ArrayList();
    paramDataSource = new ArrayList();
    this.zzav = paramDataSource;
    paramDataSource.add(this.zzr);
  }
  
  public DataSet(RawDataSet paramRawDataSet, List<DataSource> paramList)
  {
    this.versionCode = 3;
    this.zzr = ((DataSource)paramList.get(paramRawDataSet.zzdw));
    this.zzav = paramList;
    this.zzal = paramRawDataSet.zzal;
    paramRawDataSet = paramRawDataSet.zzdy;
    this.zzau = new ArrayList(paramRawDataSet.size());
    paramRawDataSet = paramRawDataSet.iterator();
    while (paramRawDataSet.hasNext())
    {
      paramList = (RawDataPoint)paramRawDataSet.next();
      this.zzau.add(new DataPoint(this.zzav, paramList));
    }
  }
  
  public static DataSet create(DataSource paramDataSource)
  {
    Preconditions.checkNotNull(paramDataSource, "DataSource should be specified");
    return new DataSet(paramDataSource);
  }
  
  private final void zza(DataPoint paramDataPoint)
  {
    this.zzau.add(paramDataPoint);
    paramDataPoint = paramDataPoint.getOriginalDataSource();
    if ((paramDataPoint != null) && (!this.zzav.contains(paramDataPoint))) {
      this.zzav.add(paramDataPoint);
    }
  }
  
  public static void zzb(DataPoint paramDataPoint)
    throws IllegalArgumentException
  {
    String str = zzj.zza(paramDataPoint, zzf.zzam);
    if (str == null) {
      return;
    }
    paramDataPoint = String.valueOf(paramDataPoint);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramDataPoint).length() + 20);
    localStringBuilder.append("Invalid data point: ");
    localStringBuilder.append(paramDataPoint);
    Log.w("Fitness", localStringBuilder.toString());
    throw new IllegalArgumentException(str);
  }
  
  private final List<RawDataPoint> zzh()
  {
    return zza(this.zzav);
  }
  
  public final void add(DataPoint paramDataPoint)
  {
    DataSource localDataSource = paramDataPoint.getDataSource();
    Preconditions.checkArgument(localDataSource.getStreamIdentifier().equals(this.zzr.getStreamIdentifier()), "Conflicting data sources found %s vs %s", new Object[] { localDataSource, this.zzr });
    paramDataPoint.zzg();
    zzb(paramDataPoint);
    zza(paramDataPoint);
  }
  
  public final void addAll(Iterable<DataPoint> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      add((DataPoint)paramIterable.next());
    }
  }
  
  public final DataPoint createDataPoint()
  {
    return DataPoint.create(this.zzr);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof DataSet)) {
      return false;
    }
    paramObject = (DataSet)paramObject;
    return (Objects.equal(this.zzr, ((DataSet)paramObject).zzr)) && (Objects.equal(this.zzau, ((DataSet)paramObject).zzau)) && (this.zzal == ((DataSet)paramObject).zzal);
  }
  
  public final List<DataPoint> getDataPoints()
  {
    return Collections.unmodifiableList(this.zzau);
  }
  
  public final DataSource getDataSource()
  {
    return this.zzr;
  }
  
  public final DataType getDataType()
  {
    return this.zzr.getDataType();
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { this.zzr });
  }
  
  public final boolean isEmpty()
  {
    return this.zzau.isEmpty();
  }
  
  public final String toString()
  {
    Object localObject = zzh();
    Locale localLocale = Locale.US;
    String str = this.zzr.toDebugString();
    if (this.zzau.size() >= 10) {
      localObject = String.format(Locale.US, "%d data points, first 5: %s", new Object[] { Integer.valueOf(this.zzau.size()), ((List)localObject).subList(0, 5) });
    }
    return String.format(localLocale, "DataSet{%s %s}", new Object[] { str, localObject });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, getDataSource(), paramInt, false);
    SafeParcelWriter.writeList(paramParcel, 3, zzh(), false);
    SafeParcelWriter.writeTypedList(paramParcel, 4, this.zzav, false);
    SafeParcelWriter.writeBoolean(paramParcel, 5, this.zzal);
    SafeParcelWriter.writeInt(paramParcel, 1000, this.versionCode);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  final List<RawDataPoint> zza(List<DataSource> paramList)
  {
    ArrayList localArrayList = new ArrayList(this.zzau.size());
    Iterator localIterator = this.zzau.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new RawDataPoint((DataPoint)localIterator.next(), paramList));
    }
    return localArrayList;
  }
  
  public final void zza(Iterable<DataPoint> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      zza((DataPoint)paramIterable.next());
    }
  }
  
  public final boolean zza()
  {
    return this.zzal;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\data\DataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */