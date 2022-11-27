package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.zzt;
import com.google.android.gms.fitness.data.zzu;
import com.google.android.gms.internal.fitness.zzcq;
import com.google.android.gms.internal.fitness.zzcr;

public final class zzar
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzar> CREATOR = new zzas();
  private final zzcq zzgj;
  private final PendingIntent zzhi;
  private final zzt zzhr;
  
  zzar(IBinder paramIBinder1, PendingIntent paramPendingIntent, IBinder paramIBinder2)
  {
    if (paramIBinder1 == null) {
      paramIBinder1 = null;
    } else {
      paramIBinder1 = zzu.zza(paramIBinder1);
    }
    this.zzhr = paramIBinder1;
    this.zzhi = paramPendingIntent;
    this.zzgj = zzcr.zzj(paramIBinder2);
  }
  
  public zzar(zzt paramzzt, PendingIntent paramPendingIntent, zzcq paramzzcq)
  {
    this.zzhr = paramzzt;
    this.zzhi = paramPendingIntent;
    this.zzgj = paramzzcq;
  }
  
  public final String toString()
  {
    return String.format("SensorUnregistrationRequest{%s}", new Object[] { this.zzhr });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    Object localObject1 = this.zzhr;
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((zzt)localObject1).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 1, (IBinder)localObject1, false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.zzhi, paramInt, false);
    localObject1 = this.zzgj;
    if (localObject1 == null) {
      localObject1 = localObject2;
    } else {
      localObject1 = ((zzcq)localObject1).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 3, (IBinder)localObject1, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\zzar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */