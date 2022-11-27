package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fitness.zzcq;
import com.google.android.gms.internal.fitness.zzcr;

public final class zzax
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzax> CREATOR = new zzay();
  private final zzcq zzgj;
  private final PendingIntent zzhi;
  private final int zzii;
  
  zzax(PendingIntent paramPendingIntent, IBinder paramIBinder, int paramInt)
  {
    this.zzhi = paramPendingIntent;
    if (paramIBinder == null) {
      paramPendingIntent = null;
    } else {
      paramPendingIntent = zzcr.zzj(paramIBinder);
    }
    this.zzgj = paramPendingIntent;
    this.zzii = paramInt;
  }
  
  public zzax(PendingIntent paramPendingIntent, zzcq paramzzcq, int paramInt)
  {
    this.zzhi = paramPendingIntent;
    this.zzgj = paramzzcq;
    this.zzii = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof zzax))
      {
        paramObject = (zzax)paramObject;
        int i;
        if ((this.zzii == ((zzax)paramObject).zzii) && (Objects.equal(this.zzhi, ((zzax)paramObject).zzhi))) {
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
    return Objects.hashCode(new Object[] { this.zzhi, Integer.valueOf(this.zzii) });
  }
  
  public final String toString()
  {
    return Objects.toStringHelper(this).add("pendingIntent", this.zzhi).add("sessionRegistrationOption", Integer.valueOf(this.zzii)).toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, this.zzhi, paramInt, false);
    Object localObject = this.zzgj;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((zzcq)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 2, (IBinder)localObject, false);
    SafeParcelWriter.writeInt(paramParcel, 4, this.zzii);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\zzax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */