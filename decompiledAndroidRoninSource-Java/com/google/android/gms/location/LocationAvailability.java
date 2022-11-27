package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

public final class LocationAvailability
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<LocationAvailability> CREATOR = new zzaa();
  @Deprecated
  private int zzar;
  @Deprecated
  private int zzas;
  private long zzat;
  private int zzau;
  private zzaj[] zzav;
  
  LocationAvailability(int paramInt1, int paramInt2, int paramInt3, long paramLong, zzaj[] paramArrayOfzzaj)
  {
    this.zzau = paramInt1;
    this.zzar = paramInt2;
    this.zzas = paramInt3;
    this.zzat = paramLong;
    this.zzav = paramArrayOfzzaj;
  }
  
  public static LocationAvailability extractLocationAvailability(Intent paramIntent)
  {
    if (!hasLocationAvailability(paramIntent)) {
      return null;
    }
    return (LocationAvailability)paramIntent.getExtras().getParcelable("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
  }
  
  public static boolean hasLocationAvailability(Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    return paramIntent.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (LocationAvailability)paramObject;
      if ((this.zzar == ((LocationAvailability)paramObject).zzar) && (this.zzas == ((LocationAvailability)paramObject).zzas) && (this.zzat == ((LocationAvailability)paramObject).zzat) && (this.zzau == ((LocationAvailability)paramObject).zzau) && (Arrays.equals(this.zzav, ((LocationAvailability)paramObject).zzav))) {
        return true;
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.zzau), Integer.valueOf(this.zzar), Integer.valueOf(this.zzas), Long.valueOf(this.zzat), this.zzav });
  }
  
  public final boolean isLocationAvailable()
  {
    return this.zzau < 1000;
  }
  
  public final String toString()
  {
    boolean bool = isLocationAvailable();
    StringBuilder localStringBuilder = new StringBuilder(48);
    localStringBuilder.append("LocationAvailability[isLocationAvailable: ");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzar);
    SafeParcelWriter.writeInt(paramParcel, 2, this.zzas);
    SafeParcelWriter.writeLong(paramParcel, 3, this.zzat);
    SafeParcelWriter.writeInt(paramParcel, 4, this.zzau);
    SafeParcelWriter.writeTypedArray(paramParcel, 5, this.zzav, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\location\LocationAvailability.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */