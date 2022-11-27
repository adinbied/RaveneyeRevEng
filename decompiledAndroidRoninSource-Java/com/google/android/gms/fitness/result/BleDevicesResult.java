package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BleDevicesResult
  extends AbstractSafeParcelable
  implements Result
{
  public static final Parcelable.Creator<BleDevicesResult> CREATOR = new zza();
  private final List<BleDevice> zziq;
  private final Status zzir;
  
  public BleDevicesResult(List<BleDevice> paramList, Status paramStatus)
  {
    this.zziq = Collections.unmodifiableList(paramList);
    this.zzir = paramStatus;
  }
  
  public static BleDevicesResult zzb(Status paramStatus)
  {
    return new BleDevicesResult(Collections.emptyList(), paramStatus);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof BleDevicesResult))
      {
        paramObject = (BleDevicesResult)paramObject;
        int i;
        if ((this.zzir.equals(((BleDevicesResult)paramObject).zzir)) && (Objects.equal(this.zziq, ((BleDevicesResult)paramObject).zziq))) {
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
  
  public List<BleDevice> getClaimedBleDevices()
  {
    return this.zziq;
  }
  
  public List<BleDevice> getClaimedBleDevices(DataType paramDataType)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zziq.iterator();
    while (localIterator.hasNext())
    {
      BleDevice localBleDevice = (BleDevice)localIterator.next();
      if (localBleDevice.getDataTypes().contains(paramDataType)) {
        localArrayList.add(localBleDevice);
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
    return Objects.hashCode(new Object[] { this.zzir, this.zziq });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("status", this.zzir).add("bleDevices", this.zziq).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, getClaimedBleDevices(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getStatus(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\result\BleDevicesResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */