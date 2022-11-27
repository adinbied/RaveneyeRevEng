package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class LocationResult
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<LocationResult> CREATOR = new zzac();
  static final List<Location> zzbb = ;
  private final List<Location> zzbc;
  
  LocationResult(List<Location> paramList)
  {
    this.zzbc = paramList;
  }
  
  public static LocationResult create(List<Location> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = zzbb;
    }
    return new LocationResult((List)localObject);
  }
  
  public static LocationResult extractResult(Intent paramIntent)
  {
    if (!hasResult(paramIntent)) {
      return null;
    }
    return (LocationResult)paramIntent.getExtras().getParcelable("com.google.android.gms.location.EXTRA_LOCATION_RESULT");
  }
  
  public static boolean hasResult(Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    return paramIntent.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_RESULT");
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof LocationResult)) {
      return false;
    }
    paramObject = (LocationResult)paramObject;
    if (((LocationResult)paramObject).zzbc.size() != this.zzbc.size()) {
      return false;
    }
    paramObject = ((LocationResult)paramObject).zzbc.iterator();
    Iterator localIterator = this.zzbc.iterator();
    while (((Iterator)paramObject).hasNext())
    {
      Location localLocation1 = (Location)localIterator.next();
      Location localLocation2 = (Location)((Iterator)paramObject).next();
      if (localLocation1.getTime() != localLocation2.getTime()) {
        return false;
      }
    }
    return true;
  }
  
  public final Location getLastLocation()
  {
    int i = this.zzbc.size();
    if (i == 0) {
      return null;
    }
    return (Location)this.zzbc.get(i - 1);
  }
  
  public final List<Location> getLocations()
  {
    return this.zzbc;
  }
  
  public final int hashCode()
  {
    Iterator localIterator = this.zzbc.iterator();
    long l;
    for (int i = 17; localIterator.hasNext(); i = i * 31 + (int)(l ^ l >>> 32)) {
      l = ((Location)localIterator.next()).getTime();
    }
    return i;
  }
  
  public final String toString()
  {
    String str = String.valueOf(this.zzbc);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 27);
    localStringBuilder.append("LocationResult[locations: ");
    localStringBuilder.append(str);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, getLocations(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\location\LocationResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */