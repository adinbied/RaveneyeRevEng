package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class LocationRequest
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<LocationRequest> CREATOR = new zzab();
  public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
  public static final int PRIORITY_HIGH_ACCURACY = 100;
  public static final int PRIORITY_LOW_POWER = 104;
  public static final int PRIORITY_NO_POWER = 105;
  private int priority;
  private long zzaf;
  private long zzaw;
  private long zzax;
  private boolean zzay;
  private float zzaz;
  private long zzba;
  private int zzx;
  
  public LocationRequest()
  {
    this.priority = 102;
    this.zzaw = 3600000L;
    this.zzax = 600000L;
    this.zzay = false;
    this.zzaf = Long.MAX_VALUE;
    this.zzx = Integer.MAX_VALUE;
    this.zzaz = 0.0F;
    this.zzba = 0L;
  }
  
  LocationRequest(int paramInt1, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, int paramInt2, float paramFloat, long paramLong4)
  {
    this.priority = paramInt1;
    this.zzaw = paramLong1;
    this.zzax = paramLong2;
    this.zzay = paramBoolean;
    this.zzaf = paramLong3;
    this.zzx = paramInt2;
    this.zzaz = paramFloat;
    this.zzba = paramLong4;
  }
  
  public static LocationRequest create()
  {
    return new LocationRequest();
  }
  
  private static void zza(long paramLong)
  {
    if (paramLong >= 0L) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(38);
    localStringBuilder.append("invalid interval: ");
    localStringBuilder.append(paramLong);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof LocationRequest)) {
      return false;
    }
    paramObject = (LocationRequest)paramObject;
    return (this.priority == ((LocationRequest)paramObject).priority) && (this.zzaw == ((LocationRequest)paramObject).zzaw) && (this.zzax == ((LocationRequest)paramObject).zzax) && (this.zzay == ((LocationRequest)paramObject).zzay) && (this.zzaf == ((LocationRequest)paramObject).zzaf) && (this.zzx == ((LocationRequest)paramObject).zzx) && (this.zzaz == ((LocationRequest)paramObject).zzaz) && (getMaxWaitTime() == ((LocationRequest)paramObject).getMaxWaitTime());
  }
  
  public final long getExpirationTime()
  {
    return this.zzaf;
  }
  
  public final long getFastestInterval()
  {
    return this.zzax;
  }
  
  public final long getInterval()
  {
    return this.zzaw;
  }
  
  public final long getMaxWaitTime()
  {
    long l2 = this.zzba;
    long l3 = this.zzaw;
    long l1 = l2;
    if (l2 < l3) {
      l1 = l3;
    }
    return l1;
  }
  
  public final int getNumUpdates()
  {
    return this.zzx;
  }
  
  public final int getPriority()
  {
    return this.priority;
  }
  
  public final float getSmallestDisplacement()
  {
    return this.zzaz;
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.priority), Long.valueOf(this.zzaw), Float.valueOf(this.zzaz), Long.valueOf(this.zzba) });
  }
  
  public final boolean isFastestIntervalExplicitlySet()
  {
    return this.zzay;
  }
  
  public final LocationRequest setExpirationDuration(long paramLong)
  {
    long l = SystemClock.elapsedRealtime();
    if (paramLong > Long.MAX_VALUE - l) {
      this.zzaf = Long.MAX_VALUE;
    } else {
      this.zzaf = (paramLong + l);
    }
    if (this.zzaf < 0L) {
      this.zzaf = 0L;
    }
    return this;
  }
  
  public final LocationRequest setExpirationTime(long paramLong)
  {
    this.zzaf = paramLong;
    if (paramLong < 0L) {
      this.zzaf = 0L;
    }
    return this;
  }
  
  public final LocationRequest setFastestInterval(long paramLong)
  {
    zza(paramLong);
    this.zzay = true;
    this.zzax = paramLong;
    return this;
  }
  
  public final LocationRequest setInterval(long paramLong)
  {
    zza(paramLong);
    this.zzaw = paramLong;
    if (!this.zzay) {
      this.zzax = ((paramLong / 6.0D));
    }
    return this;
  }
  
  public final LocationRequest setMaxWaitTime(long paramLong)
  {
    zza(paramLong);
    this.zzba = paramLong;
    return this;
  }
  
  public final LocationRequest setNumUpdates(int paramInt)
  {
    if (paramInt > 0)
    {
      this.zzx = paramInt;
      return this;
    }
    StringBuilder localStringBuilder = new StringBuilder(31);
    localStringBuilder.append("invalid numUpdates: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public final LocationRequest setPriority(int paramInt)
  {
    if ((paramInt != 100) && (paramInt != 102) && (paramInt != 104) && (paramInt != 105))
    {
      StringBuilder localStringBuilder = new StringBuilder(28);
      localStringBuilder.append("invalid quality: ");
      localStringBuilder.append(paramInt);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    this.priority = paramInt;
    return this;
  }
  
  public final LocationRequest setSmallestDisplacement(float paramFloat)
  {
    if (paramFloat >= 0.0F)
    {
      this.zzaz = paramFloat;
      return this;
    }
    StringBuilder localStringBuilder = new StringBuilder(37);
    localStringBuilder.append("invalid displacement: ");
    localStringBuilder.append(paramFloat);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Request[");
    int i = this.priority;
    String str;
    if (i != 100)
    {
      if (i != 102)
      {
        if (i != 104)
        {
          if (i != 105) {
            str = "???";
          } else {
            str = "PRIORITY_NO_POWER";
          }
        }
        else {
          str = "PRIORITY_LOW_POWER";
        }
      }
      else {
        str = "PRIORITY_BALANCED_POWER_ACCURACY";
      }
    }
    else {
      str = "PRIORITY_HIGH_ACCURACY";
    }
    localStringBuilder.append(str);
    if (this.priority != 105)
    {
      localStringBuilder.append(" requested=");
      localStringBuilder.append(this.zzaw);
      localStringBuilder.append("ms");
    }
    localStringBuilder.append(" fastest=");
    localStringBuilder.append(this.zzax);
    localStringBuilder.append("ms");
    if (this.zzba > this.zzaw)
    {
      localStringBuilder.append(" maxWait=");
      localStringBuilder.append(this.zzba);
      localStringBuilder.append("ms");
    }
    if (this.zzaz > 0.0F)
    {
      localStringBuilder.append(" smallestDisplacement=");
      localStringBuilder.append(this.zzaz);
      localStringBuilder.append("m");
    }
    long l1 = this.zzaf;
    if (l1 != Long.MAX_VALUE)
    {
      long l2 = SystemClock.elapsedRealtime();
      localStringBuilder.append(" expireIn=");
      localStringBuilder.append(l1 - l2);
      localStringBuilder.append("ms");
    }
    if (this.zzx != Integer.MAX_VALUE)
    {
      localStringBuilder.append(" num=");
      localStringBuilder.append(this.zzx);
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.priority);
    SafeParcelWriter.writeLong(paramParcel, 2, this.zzaw);
    SafeParcelWriter.writeLong(paramParcel, 3, this.zzax);
    SafeParcelWriter.writeBoolean(paramParcel, 4, this.zzay);
    SafeParcelWriter.writeLong(paramParcel, 5, this.zzaf);
    SafeParcelWriter.writeInt(paramParcel, 6, this.zzx);
    SafeParcelWriter.writeFloat(paramParcel, 7, this.zzaz);
    SafeParcelWriter.writeLong(paramParcel, 8, this.zzba);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\location\LocationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */