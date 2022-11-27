package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fitness.zzcq;
import com.google.android.gms.internal.fitness.zzcr;

public final class zzbh
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzbh> CREATOR = new zzbi();
  private final zzcq zzgj;
  private final zzae zzik;
  
  zzbh(IBinder paramIBinder1, IBinder paramIBinder2)
  {
    if (paramIBinder1 == null)
    {
      paramIBinder1 = null;
    }
    else
    {
      IInterface localIInterface = paramIBinder1.queryLocalInterface("com.google.android.gms.fitness.request.IBleScanCallback");
      if ((localIInterface instanceof zzae)) {
        paramIBinder1 = (zzae)localIInterface;
      } else {
        paramIBinder1 = new zzag(paramIBinder1);
      }
    }
    this.zzik = paramIBinder1;
    this.zzgj = zzcr.zzj(paramIBinder2);
  }
  
  public zzbh(zzae paramzzae, zzcq paramzzcq)
  {
    this.zzik = paramzzae;
    this.zzgj = paramzzcq;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeIBinder(paramParcel, 1, this.zzik.asBinder(), false);
    Object localObject = this.zzgj;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((zzcq)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 2, (IBinder)localObject, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\zzbh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */