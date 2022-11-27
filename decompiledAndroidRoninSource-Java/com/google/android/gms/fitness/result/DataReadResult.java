package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataSource.Builder;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DataReadResult
  extends AbstractSafeParcelable
  implements Result
{
  public static final Parcelable.Creator<DataReadResult> CREATOR = new zzc();
  private final List<DataSet> zzaj;
  private final List<DataSource> zzav;
  private final Status zzir;
  private final List<Bucket> zzis;
  private int zzit;
  
  DataReadResult(List<RawDataSet> paramList, Status paramStatus, List<RawBucket> paramList1, int paramInt, List<DataSource> paramList2)
  {
    this.zzir = paramStatus;
    this.zzit = paramInt;
    this.zzav = paramList2;
    this.zzaj = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramStatus = (RawDataSet)paramList.next();
      this.zzaj.add(new DataSet(paramStatus, paramList2));
    }
    this.zzis = new ArrayList(paramList1.size());
    paramList = paramList1.iterator();
    while (paramList.hasNext())
    {
      paramStatus = (RawBucket)paramList.next();
      this.zzis.add(new Bucket(paramStatus, paramList2));
    }
  }
  
  private DataReadResult(List<DataSet> paramList, List<Bucket> paramList1, Status paramStatus)
  {
    this.zzaj = paramList;
    this.zzir = paramStatus;
    this.zzis = paramList1;
    this.zzit = 1;
    this.zzav = new ArrayList();
  }
  
  public static DataReadResult zza(Status paramStatus, List<DataType> paramList, List<DataSource> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext()) {
      localArrayList.add(DataSet.create((DataSource)paramList1.next()));
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramList1 = (DataType)paramList.next();
      localArrayList.add(DataSet.create(new DataSource.Builder().setType(1).setDataType(paramList1).setName("Default").build()));
    }
    return new DataReadResult(localArrayList, Collections.emptyList(), paramStatus);
  }
  
  private static void zza(DataSet paramDataSet, List<DataSet> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      DataSet localDataSet = (DataSet)localIterator.next();
      if (localDataSet.getDataSource().equals(paramDataSet.getDataSource()))
      {
        localDataSet.zza(paramDataSet.getDataPoints());
        return;
      }
    }
    paramList.add(paramDataSet);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof DataReadResult))
      {
        paramObject = (DataReadResult)paramObject;
        int i;
        if ((this.zzir.equals(((DataReadResult)paramObject).zzir)) && (Objects.equal(this.zzaj, ((DataReadResult)paramObject).zzaj)) && (Objects.equal(this.zzis, ((DataReadResult)paramObject).zzis))) {
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
  
  public List<Bucket> getBuckets()
  {
    return this.zzis;
  }
  
  public DataSet getDataSet(DataSource paramDataSource)
  {
    Iterator localIterator = this.zzaj.iterator();
    while (localIterator.hasNext())
    {
      DataSet localDataSet = (DataSet)localIterator.next();
      if (paramDataSource.equals(localDataSet.getDataSource())) {
        return localDataSet;
      }
    }
    return DataSet.create(paramDataSource);
  }
  
  public DataSet getDataSet(DataType paramDataType)
  {
    Iterator localIterator = this.zzaj.iterator();
    while (localIterator.hasNext())
    {
      DataSet localDataSet = (DataSet)localIterator.next();
      if (paramDataType.equals(localDataSet.getDataType())) {
        return localDataSet;
      }
    }
    return DataSet.create(new DataSource.Builder().setDataType(paramDataType).setType(1).build());
  }
  
  public List<DataSet> getDataSets()
  {
    return this.zzaj;
  }
  
  public Status getStatus()
  {
    return this.zzir;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.zzir, this.zzaj, this.zzis });
  }
  
  public String toString()
  {
    Objects.ToStringHelper localToStringHelper = Objects.toStringHelper(this).add("status", this.zzir);
    int i;
    Object localObject;
    if (this.zzaj.size() > 5)
    {
      i = this.zzaj.size();
      localObject = new StringBuilder(21);
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" data sets");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = this.zzaj;
    }
    localToStringHelper = localToStringHelper.add("dataSets", localObject);
    if (this.zzis.size() > 5)
    {
      i = this.zzis.size();
      localObject = new StringBuilder(19);
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" buckets");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = this.zzis;
    }
    return localToStringHelper.add("buckets", localObject).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    ArrayList localArrayList = new ArrayList(this.zzaj.size());
    Iterator localIterator = this.zzaj.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new RawDataSet((DataSet)localIterator.next(), this.zzav));
    }
    SafeParcelWriter.writeList(paramParcel, 1, localArrayList, false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getStatus(), paramInt, false);
    localArrayList = new ArrayList(this.zzis.size());
    localIterator = this.zzis.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new RawBucket((Bucket)localIterator.next(), this.zzav));
    }
    SafeParcelWriter.writeList(paramParcel, 3, localArrayList, false);
    SafeParcelWriter.writeInt(paramParcel, 5, this.zzit);
    SafeParcelWriter.writeTypedList(paramParcel, 6, this.zzav, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final int zzaa()
  {
    return this.zzit;
  }
  
  public final void zzb(DataReadResult paramDataReadResult)
  {
    Object localObject1 = paramDataReadResult.getDataSets().iterator();
    while (((Iterator)localObject1).hasNext()) {
      zza((DataSet)((Iterator)localObject1).next(), this.zzaj);
    }
    paramDataReadResult = paramDataReadResult.getBuckets().iterator();
    while (paramDataReadResult.hasNext())
    {
      Object localObject2 = (Bucket)paramDataReadResult.next();
      Iterator localIterator = this.zzis.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject1 = (Bucket)localIterator.next();
          if (((Bucket)localObject1).zza((Bucket)localObject2))
          {
            localObject2 = ((Bucket)localObject2).getDataSets().iterator();
            while (((Iterator)localObject2).hasNext()) {
              zza((DataSet)((Iterator)localObject2).next(), ((Bucket)localObject1).getDataSets());
            }
            break;
          }
        }
      }
      this.zzis.add(localObject2);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\result\DataReadResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */