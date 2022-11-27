package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataType;

public class DataTypeResult
  extends AbstractSafeParcelable
  implements Result
{
  public static final Parcelable.Creator<DataTypeResult> CREATOR = new zze();
  private final Status zzir;
  private final DataType zzq;
  
  public DataTypeResult(Status paramStatus, DataType paramDataType)
  {
    this.zzir = paramStatus;
    this.zzq = paramDataType;
  }
  
  public static DataTypeResult zzc(Status paramStatus)
  {
    return new DataTypeResult(paramStatus, null);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof DataTypeResult))
      {
        paramObject = (DataTypeResult)paramObject;
        int i;
        if ((this.zzir.equals(((DataTypeResult)paramObject).zzir)) && (Objects.equal(this.zzq, ((DataTypeResult)paramObject).zzq))) {
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
  
  public DataType getDataType()
  {
    return this.zzq;
  }
  
  public Status getStatus()
  {
    return this.zzir;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.zzir, this.zzq });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("status", this.zzir).add("dataType", this.zzq).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, getStatus(), paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, getDataType(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\result\DataTypeResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */