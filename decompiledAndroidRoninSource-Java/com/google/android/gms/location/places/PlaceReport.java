package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public class PlaceReport
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<PlaceReport> CREATOR = new zza();
  private final String tag;
  private final int versionCode;
  private final String zza;
  private final String zzb;
  
  PlaceReport(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.versionCode = paramInt;
    this.zza = paramString1;
    this.tag = paramString2;
    this.zzb = paramString3;
  }
  
  public static PlaceReport create(String paramString1, String paramString2)
  {
    Preconditions.checkNotNull(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    Preconditions.checkNotEmpty("unknown");
    Preconditions.checkArgument(true, "Invalid source");
    return new PlaceReport(1, paramString1, paramString2, "unknown");
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof PlaceReport)) {
      return false;
    }
    paramObject = (PlaceReport)paramObject;
    return (Objects.equal(this.zza, ((PlaceReport)paramObject).zza)) && (Objects.equal(this.tag, ((PlaceReport)paramObject).tag)) && (Objects.equal(this.zzb, ((PlaceReport)paramObject).zzb));
  }
  
  public String getPlaceId()
  {
    return this.zza;
  }
  
  public String getTag()
  {
    return this.tag;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.zza, this.tag, this.zzb });
  }
  
  public String toString()
  {
    Objects.ToStringHelper localToStringHelper = Objects.toStringHelper(this);
    localToStringHelper.add("placeId", this.zza);
    localToStringHelper.add("tag", this.tag);
    if (!"unknown".equals(this.zzb)) {
      localToStringHelper.add("source", this.zzb);
    }
    return localToStringHelper.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeString(paramParcel, 2, getPlaceId(), false);
    SafeParcelWriter.writeString(paramParcel, 3, getTag(), false);
    SafeParcelWriter.writeString(paramParcel, 4, this.zzb, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\location\places\PlaceReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */