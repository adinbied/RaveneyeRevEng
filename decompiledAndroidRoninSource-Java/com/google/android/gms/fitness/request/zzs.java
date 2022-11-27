package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fitness.zzbn;
import com.google.android.gms.internal.fitness.zzbo;

public final class zzs
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzs> CREATOR = new zzt();
  private final String name;
  private final zzbn zzhh;
  
  zzs(String paramString, IBinder paramIBinder)
  {
    this.name = paramString;
    this.zzhh = zzbo.zze(paramIBinder);
  }
  
  public zzs(String paramString, zzbn paramzzbn)
  {
    this.name = paramString;
    this.zzhh = paramzzbn;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this) {
      if ((paramObject instanceof zzs))
      {
        paramObject = (zzs)paramObject;
        if (Objects.equal(this.name, ((zzs)paramObject).name)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { this.name });
  }
  
  public final String toString()
  {
    return Objects.toStringHelper(this).add("name", this.name).toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, this.name, false);
    SafeParcelWriter.writeIBinder(paramParcel, 3, this.zzhh.asBinder(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\zzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */