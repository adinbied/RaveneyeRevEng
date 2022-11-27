package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DataSourcesResult
  extends AbstractSafeParcelable
  implements Result
{
  public static final Parcelable.Creator<DataSourcesResult> CREATOR = new zzd();
  private final List<DataSource> zzgm;
  private final Status zzir;
  
  public DataSourcesResult(List<DataSource> paramList, Status paramStatus)
  {
    this.zzgm = Collections.unmodifiableList(paramList);
    this.zzir = paramStatus;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof DataSourcesResult))
      {
        paramObject = (DataSourcesResult)paramObject;
        int i;
        if ((this.zzir.equals(((DataSourcesResult)paramObject).zzir)) && (Objects.equal(this.zzgm, ((DataSourcesResult)paramObject).zzgm))) {
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
  
  public List<DataSource> getDataSources()
  {
    return this.zzgm;
  }
  
  public List<DataSource> getDataSources(DataType paramDataType)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zzgm.iterator();
    while (localIterator.hasNext())
    {
      DataSource localDataSource = (DataSource)localIterator.next();
      if (localDataSource.getDataType().equals(paramDataType)) {
        localArrayList.add(localDataSource);
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public Status getStatus()
  {
    return this.zzir;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.zzir, this.zzgm });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("status", this.zzir).add("dataSources", this.zzgm).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, getDataSources(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getStatus(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\result\DataSourcesResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */