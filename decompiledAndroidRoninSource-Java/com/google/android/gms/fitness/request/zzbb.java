package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fitness.zzcn;
import com.google.android.gms.internal.fitness.zzco;

public final class zzbb
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzbb> CREATOR = new zzbc();
  private final String name;
  private final String zzdz;
  private final zzcn zzij;
  
  zzbb(String paramString1, String paramString2, IBinder paramIBinder)
  {
    this.name = paramString1;
    this.zzdz = paramString2;
    this.zzij = zzco.zzi(paramIBinder);
  }
  
  public zzbb(String paramString1, String paramString2, zzcn paramzzcn)
  {
    this.name = paramString1;
    this.zzdz = paramString2;
    this.zzij = paramzzcn;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof zzbb))
      {
        paramObject = (zzbb)paramObject;
        int i;
        if ((Objects.equal(this.name, ((zzbb)paramObject).name)) && (Objects.equal(this.zzdz, ((zzbb)paramObject).zzdz))) {
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
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { this.name, this.zzdz });
  }
  
  public final String toString()
  {
    return Objects.toStringHelper(this).add("name", this.name).add("identifier", this.zzdz).toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, this.name, false);
    SafeParcelWriter.writeString(paramParcel, 2, this.zzdz, false);
    Object localObject = this.zzij;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((zzcn)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 3, (IBinder)localObject, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\zzbb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */