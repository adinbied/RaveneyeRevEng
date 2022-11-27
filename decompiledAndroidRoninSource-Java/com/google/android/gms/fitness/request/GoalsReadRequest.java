package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.fitness.zzbq;
import com.google.android.gms.internal.fitness.zzbr;
import com.google.android.gms.internal.fitness.zzf;
import com.google.android.gms.internal.fitness.zzfa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GoalsReadRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<GoalsReadRequest> CREATOR = new zzad();
  private final List<DataType> zzah;
  private final List<Integer> zzdl;
  private final zzbq zzhj;
  private final List<Integer> zzhk;
  
  GoalsReadRequest(IBinder paramIBinder, List<DataType> paramList, List<Integer> paramList1, List<Integer> paramList2)
  {
    if (paramIBinder == null) {
      paramIBinder = null;
    } else {
      paramIBinder = zzbr.zzf(paramIBinder);
    }
    this.zzhj = paramIBinder;
    this.zzah = paramList;
    this.zzhk = paramList1;
    this.zzdl = paramList2;
  }
  
  private GoalsReadRequest(Builder paramBuilder)
  {
    this(null, Builder.zza(paramBuilder), Builder.zzb(paramBuilder), Builder.zzc(paramBuilder));
  }
  
  public GoalsReadRequest(GoalsReadRequest paramGoalsReadRequest, zzbq paramzzbq)
  {
    this(paramzzbq, paramGoalsReadRequest.getDataTypes(), paramGoalsReadRequest.zzhk, paramGoalsReadRequest.zzdl);
  }
  
  private GoalsReadRequest(zzbq paramzzbq, List<DataType> paramList, List<Integer> paramList1, List<Integer> paramList2)
  {
    this(paramzzbq, paramList, paramList1, paramList2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof GoalsReadRequest))
      {
        paramObject = (GoalsReadRequest)paramObject;
        int i;
        if ((Objects.equal(this.zzah, ((GoalsReadRequest)paramObject).zzah)) && (Objects.equal(this.zzhk, ((GoalsReadRequest)paramObject).zzhk)) && (Objects.equal(this.zzdl, ((GoalsReadRequest)paramObject).zzdl))) {
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
  
  public List<String> getActivityNames()
  {
    if (this.zzdl.isEmpty()) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zzdl.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(zzfa.getName(((Integer)localIterator.next()).intValue()));
    }
    return localArrayList;
  }
  
  public List<DataType> getDataTypes()
  {
    return this.zzah;
  }
  
  public List<Integer> getObjectiveTypes()
  {
    if (this.zzhk.isEmpty()) {
      return null;
    }
    return this.zzhk;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.zzah, this.zzhk, getActivityNames() });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("dataTypes", this.zzah).add("objectiveTypes", this.zzhk).add("activities", getActivityNames()).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeIBinder(paramParcel, 1, this.zzhj.asBinder(), false);
    SafeParcelWriter.writeList(paramParcel, 2, getDataTypes(), false);
    SafeParcelWriter.writeList(paramParcel, 3, this.zzhk, false);
    SafeParcelWriter.writeList(paramParcel, 4, this.zzdl, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private final List<DataType> zzah = new ArrayList();
    private final List<Integer> zzdl = new ArrayList();
    private final List<Integer> zzhk = new ArrayList();
    
    public Builder addActivity(String paramString)
    {
      int i = zzfa.zzl(paramString);
      boolean bool;
      if (i != 4) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkState(bool, "Attempting to add an unknown activity");
      zzf.zza(Integer.valueOf(i), this.zzdl);
      return this;
    }
    
    public Builder addDataType(DataType paramDataType)
    {
      Preconditions.checkNotNull(paramDataType, "Attempting to use a null data type");
      if (!this.zzah.contains(paramDataType)) {
        this.zzah.add(paramDataType);
      }
      return this;
    }
    
    public Builder addObjectiveType(int paramInt)
    {
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (paramInt != 1)
      {
        bool1 = bool2;
        if (paramInt != 2) {
          if (paramInt == 3) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
        }
      }
      Preconditions.checkState(bool1, "Attempting to add an invalid objective type");
      if (!this.zzhk.contains(Integer.valueOf(paramInt))) {
        this.zzhk.add(Integer.valueOf(paramInt));
      }
      return this;
    }
    
    public GoalsReadRequest build()
    {
      Preconditions.checkState(this.zzah.isEmpty() ^ true, "At least one data type should be specified.");
      return new GoalsReadRequest(this, null);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\GoalsReadRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */