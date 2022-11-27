package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class BleDevice
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<BleDevice> CREATOR = new zzd();
  private final String name;
  private final String zzaf;
  private final List<String> zzag;
  private final List<DataType> zzah;
  
  BleDevice(String paramString1, String paramString2, List<String> paramList, List<DataType> paramList1)
  {
    this.zzaf = paramString1;
    this.name = paramString2;
    this.zzag = Collections.unmodifiableList(paramList);
    this.zzah = Collections.unmodifiableList(paramList1);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof BleDevice)) {
      return false;
    }
    paramObject = (BleDevice)paramObject;
    return (this.name.equals(((BleDevice)paramObject).name)) && (this.zzaf.equals(((BleDevice)paramObject).zzaf)) && (new HashSet(this.zzag).equals(new HashSet(((BleDevice)paramObject).zzag))) && (new HashSet(this.zzah).equals(new HashSet(((BleDevice)paramObject).zzah)));
  }
  
  public String getAddress()
  {
    return this.zzaf;
  }
  
  public List<DataType> getDataTypes()
  {
    return this.zzah;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public List<String> getSupportedProfiles()
  {
    return this.zzag;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.name, this.zzaf, this.zzag, this.zzah });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("name", this.name).add("address", this.zzaf).add("dataTypes", this.zzah).add("supportedProfiles", this.zzag).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getAddress(), false);
    SafeParcelWriter.writeString(paramParcel, 2, getName(), false);
    SafeParcelWriter.writeStringList(paramParcel, 3, getSupportedProfiles(), false);
    SafeParcelWriter.writeTypedList(paramParcel, 4, getDataTypes(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\data\BleDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */