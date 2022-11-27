package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fitness.zzcq;
import com.google.android.gms.internal.fitness.zzcr;

public final class zzw
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzw> CREATOR = new zzx();
  private final zzcq zzgj;
  private final PendingIntent zzhi;
  
  public zzw(PendingIntent paramPendingIntent, IBinder paramIBinder)
  {
    this.zzhi = paramPendingIntent;
    this.zzgj = zzcr.zzj(paramIBinder);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this) {
      if ((paramObject instanceof zzw))
      {
        paramObject = (zzw)paramObject;
        if (Objects.equal(this.zzhi, ((zzw)paramObject).zzhi)) {}
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
    return Objects.hashCode(new Object[] { this.zzhi });
  }
  
  public final String toString()
  {
    return "DataUpdateListenerUnregistrationRequest";
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
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\zzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */