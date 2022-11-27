package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class LocationSettingsResult
  extends AbstractSafeParcelable
  implements Result
{
  public static final Parcelable.Creator<LocationSettingsResult> CREATOR = new zzah();
  private final Status zzbl;
  private final LocationSettingsStates zzbm;
  
  public LocationSettingsResult(Status paramStatus)
  {
    this(paramStatus, null);
  }
  
  public LocationSettingsResult(Status paramStatus, LocationSettingsStates paramLocationSettingsStates)
  {
    this.zzbl = paramStatus;
    this.zzbm = paramLocationSettingsStates;
  }
  
  public final LocationSettingsStates getLocationSettingsStates()
  {
    return this.zzbm;
  }
  
  public final Status getStatus()
  {
    return this.zzbl;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, getStatus(), paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getLocationSettingsStates(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\location\LocationSettingsResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */