package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.fitness.zzbk;
import com.google.android.gms.internal.fitness.zzbl;
import java.util.Arrays;
import java.util.List;

public class DataSourcesRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<DataSourcesRequest> CREATOR = new zzp();
  private final List<DataType> zzah;
  private final List<Integer> zzhc;
  private final boolean zzhd;
  private final zzbk zzhe;
  
  private DataSourcesRequest(Builder paramBuilder)
  {
    this(ArrayUtils.toArrayList(Builder.zza(paramBuilder)), Arrays.asList(ArrayUtils.toWrapperArray(Builder.zzb(paramBuilder))), false, null);
  }
  
  public DataSourcesRequest(DataSourcesRequest paramDataSourcesRequest, zzbk paramzzbk)
  {
    this(paramDataSourcesRequest.zzah, paramDataSourcesRequest.zzhc, paramDataSourcesRequest.zzhd, paramzzbk);
  }
  
  DataSourcesRequest(List<DataType> paramList, List<Integer> paramList1, boolean paramBoolean, IBinder paramIBinder)
  {
    this.zzah = paramList;
    this.zzhc = paramList1;
    this.zzhd = paramBoolean;
    this.zzhe = zzbl.zzd(paramIBinder);
  }
  
  private DataSourcesRequest(List<DataType> paramList, List<Integer> paramList1, boolean paramBoolean, zzbk paramzzbk)
  {
    this.zzah = paramList;
    this.zzhc = paramList1;
    this.zzhd = paramBoolean;
    this.zzhe = paramzzbk;
  }
  
  public List<DataType> getDataTypes()
  {
    return this.zzah;
  }
  
  public String toString()
  {
    Objects.ToStringHelper localToStringHelper = Objects.toStringHelper(this).add("dataTypes", this.zzah).add("sourceTypes", this.zzhc);
    if (this.zzhd) {
      localToStringHelper.add("includeDbOnlySources", "true");
    }
    return localToStringHelper.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, getDataTypes(), false);
    SafeParcelWriter.writeIntegerList(paramParcel, 2, this.zzhc, false);
    SafeParcelWriter.writeBoolean(paramParcel, 3, this.zzhd);
    Object localObject = this.zzhe;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((zzbk)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 4, (IBinder)localObject, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private boolean zzhd = false;
    private DataType[] zzhf = new DataType[0];
    private int[] zzhg = { 0, 1 };
    
    public DataSourcesRequest build()
    {
      int i = this.zzhf.length;
      boolean bool2 = true;
      boolean bool1;
      if (i > 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Preconditions.checkState(bool1, "Must add at least one data type");
      if (this.zzhg.length > 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      Preconditions.checkState(bool1, "Must add at least one data source type");
      return new DataSourcesRequest(this, null);
    }
    
    public Builder setDataSourceTypes(int... paramVarArgs)
    {
      this.zzhg = paramVarArgs;
      return this;
    }
    
    public Builder setDataTypes(DataType... paramVarArgs)
    {
      this.zzhf = paramVarArgs;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\DataSourcesRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */