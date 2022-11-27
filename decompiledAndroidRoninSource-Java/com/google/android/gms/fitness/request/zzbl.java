package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fitness.zzcq;
import com.google.android.gms.internal.fitness.zzcr;

public final class zzbl
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzbl> CREATOR = new zzbm();
  private final String deviceAddress;
  private final zzcq zzgj;
  
  zzbl(String paramString, IBinder paramIBinder)
  {
    this.deviceAddress = paramString;
    this.zzgj = zzcr.zzj(paramIBinder);
  }
  
  public zzbl(String paramString, zzcq paramzzcq)
  {
    this.deviceAddress = paramString;
    this.zzgj = paramzzcq;
  }
  
  public final String toString()
  {
    return String.format("UnclaimBleDeviceRequest{%s}", new Object[] { this.deviceAddress });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.deviceAddress, false);
    Object localObject = this.zzgj;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((zzcq)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 3, (IBinder)localObject, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\zzbl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */