package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource.Builder;
import com.google.android.gms.fitness.data.DataType;

public class DailyTotalResult
  extends AbstractSafeParcelable
  implements Result
{
  public static final Parcelable.Creator<DailyTotalResult> CREATOR = new zzb();
  private final DataSet zzeb;
  private final Status zzir;
  
  DailyTotalResult(Status paramStatus, DataSet paramDataSet)
  {
    this.zzir = paramStatus;
    this.zzeb = paramDataSet;
  }
  
  private DailyTotalResult(DataSet paramDataSet, Status paramStatus)
  {
    this.zzir = paramStatus;
    this.zzeb = paramDataSet;
  }
  
  public static DailyTotalResult zza(Status paramStatus, DataType paramDataType)
  {
    return new DailyTotalResult(DataSet.create(new DataSource.Builder().setDataType(paramDataType).setType(1).build()), paramStatus);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof DailyTotalResult))
      {
        paramObject = (DailyTotalResult)paramObject;
        int i;
        if ((this.zzir.equals(((DailyTotalResult)paramObject).zzir)) && (Objects.equal(this.zzeb, ((DailyTotalResult)paramObject).zzeb))) {
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
  
  public Status getStatus()
  {
    return this.zzir;
  }
  
  public DataSet getTotal()
  {
    return this.zzeb;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.zzir, this.zzeb });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("status", this.zzir).add("dataPoint", this.zzeb).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, getStatus(), paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getTotal(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\result\DailyTotalResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */