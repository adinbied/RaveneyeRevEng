package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;

public final class LocationSettingsStates
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new zzai();
  private final boolean zzbn;
  private final boolean zzbo;
  private final boolean zzbp;
  private final boolean zzbq;
  private final boolean zzbr;
  private final boolean zzbs;
  
  public LocationSettingsStates(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    this.zzbn = paramBoolean1;
    this.zzbo = paramBoolean2;
    this.zzbp = paramBoolean3;
    this.zzbq = paramBoolean4;
    this.zzbr = paramBoolean5;
    this.zzbs = paramBoolean6;
  }
  
  public static LocationSettingsStates fromIntent(Intent paramIntent)
  {
    return (LocationSettingsStates)SafeParcelableSerializer.deserializeFromIntentExtra(paramIntent, "com.google.android.gms.location.LOCATION_SETTINGS_STATES", CREATOR);
  }
  
  public final boolean isBlePresent()
  {
    return this.zzbs;
  }
  
  public final boolean isBleUsable()
  {
    return this.zzbp;
  }
  
  public final boolean isGpsPresent()
  {
    return this.zzbq;
  }
  
  public final boolean isGpsUsable()
  {
    return this.zzbn;
  }
  
  public final boolean isLocationPresent()
  {
    return (this.zzbq) || (this.zzbr);
  }
  
  public final boolean isLocationUsable()
  {
    return (this.zzbn) || (this.zzbo);
  }
  
  public final boolean isNetworkLocationPresent()
  {
    return this.zzbr;
  }
  
  public final boolean isNetworkLocationUsable()
  {
    return this.zzbo;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBoolean(paramParcel, 1, isGpsUsable());
    SafeParcelWriter.writeBoolean(paramParcel, 2, isNetworkLocationUsable());
    SafeParcelWriter.writeBoolean(paramParcel, 3, isBleUsable());
    SafeParcelWriter.writeBoolean(paramParcel, 4, isGpsPresent());
    SafeParcelWriter.writeBoolean(paramParcel, 5, isNetworkLocationPresent());
    SafeParcelWriter.writeBoolean(paramParcel, 6, isBlePresent());
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\location\LocationSettingsStates.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */