package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fitness.zzf;
import java.util.List;

public final class RawDataSet
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<RawDataSet> CREATOR = new zzaa();
  public final boolean zzal;
  public final int zzdw;
  public final List<RawDataPoint> zzdy;
  
  public RawDataSet(int paramInt, List<RawDataPoint> paramList, boolean paramBoolean)
  {
    this.zzdw = paramInt;
    this.zzdy = paramList;
    this.zzal = paramBoolean;
  }
  
  public RawDataSet(DataSet paramDataSet, List<DataSource> paramList)
  {
    this.zzdy = paramDataSet.zza(paramList);
    this.zzal = paramDataSet.zza();
    this.zzdw = zzf.zza(paramDataSet.getDataSource(), paramList);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof RawDataSet)) {
      return false;
    }
    paramObject = (RawDataSet)paramObject;
    return (this.zzdw == ((RawDataSet)paramObject).zzdw) && (this.zzal == ((RawDataSet)paramObject).zzal) && (Objects.equal(this.zzdy, ((RawDataSet)paramObject).zzdy));
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.zzdw) });
  }
  
  public final String toString()
  {
    return String.format("RawDataSet{%s@[%s]}", new Object[] { Integer.valueOf(this.zzdw), this.zzdy });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzdw);
    SafeParcelWriter.writeTypedList(paramParcel, 3, this.zzdy, false);
    SafeParcelWriter.writeBoolean(paramParcel, 4, this.zzal);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\data\RawDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */