package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.location.zzr;
import com.google.android.gms.location.zzs;

public final class zzo
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzo> CREATOR = new zzp();
  private int zzcg;
  private zzm zzch;
  private zzr zzci;
  private zzaj zzcj;
  
  zzo(int paramInt, zzm paramzzm, IBinder paramIBinder1, IBinder paramIBinder2)
  {
    this.zzcg = paramInt;
    this.zzch = paramzzm;
    Object localObject = null;
    if (paramIBinder1 == null) {
      paramzzm = null;
    } else {
      paramzzm = zzs.zza(paramIBinder1);
    }
    this.zzci = paramzzm;
    if (paramIBinder2 == null)
    {
      paramzzm = (zzm)localObject;
    }
    else if (paramIBinder2 == null)
    {
      paramzzm = (zzm)localObject;
    }
    else
    {
      paramzzm = paramIBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
      if ((paramzzm instanceof zzaj)) {
        paramzzm = (zzaj)paramzzm;
      } else {
        paramzzm = new zzal(paramIBinder2);
      }
    }
    this.zzcj = paramzzm;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzcg);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.zzch, paramInt, false);
    Object localObject1 = this.zzci;
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((zzr)localObject1).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 3, (IBinder)localObject1, false);
    localObject1 = this.zzcj;
    if (localObject1 == null) {
      localObject1 = localObject2;
    } else {
      localObject1 = ((zzaj)localObject1).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 4, (IBinder)localObject1, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\location\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */