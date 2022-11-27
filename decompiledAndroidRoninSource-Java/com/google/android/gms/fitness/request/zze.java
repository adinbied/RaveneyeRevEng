package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.internal.fitness.zzcq;
import com.google.android.gms.internal.fitness.zzcr;

public final class zze
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zze> CREATOR = new zzf();
  private final String deviceAddress;
  private final BleDevice zzgi;
  private final zzcq zzgj;
  
  zze(String paramString, BleDevice paramBleDevice, IBinder paramIBinder)
  {
    this.deviceAddress = paramString;
    this.zzgi = paramBleDevice;
    this.zzgj = zzcr.zzj(paramIBinder);
  }
  
  public zze(String paramString, BleDevice paramBleDevice, zzcq paramzzcq)
  {
    this.deviceAddress = paramString;
    this.zzgi = paramBleDevice;
    this.zzgj = paramzzcq;
  }
  
  public final String toString()
  {
    return String.format("ClaimBleDeviceRequest{%s %s}", new Object[] { this.deviceAddress, this.zzgi });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, this.deviceAddress, false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.zzgi, paramInt, false);
    Object localObject = this.zzgj;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((zzcq)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 3, (IBinder)localObject, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */