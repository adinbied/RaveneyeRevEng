package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzb;
import com.google.android.gms.internal.measurement.zzc;

public abstract class zzei
  extends zzc
  implements zzej
{
  public zzei()
  {
    super("com.google.android.gms.measurement.internal.IMeasurementService");
  }
  
  protected final boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    case 3: 
    case 8: 
    default: 
      return false;
    case 20: 
      zze((zzn)zzb.zza(paramParcel1, zzn.CREATOR));
      paramParcel2.writeNoException();
      break;
    case 19: 
      zza((Bundle)zzb.zza(paramParcel1, Bundle.CREATOR), (zzn)zzb.zza(paramParcel1, zzn.CREATOR));
      paramParcel2.writeNoException();
      break;
    case 18: 
      zzd((zzn)zzb.zza(paramParcel1, zzn.CREATOR));
      paramParcel2.writeNoException();
      break;
    case 17: 
      paramParcel1 = zza(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(paramParcel1);
      break;
    case 16: 
      paramParcel1 = zza(paramParcel1.readString(), paramParcel1.readString(), (zzn)zzb.zza(paramParcel1, zzn.CREATOR));
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(paramParcel1);
      break;
    case 15: 
      paramParcel1 = zza(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), zzb.zza(paramParcel1));
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(paramParcel1);
      break;
    case 14: 
      paramParcel1 = zza(paramParcel1.readString(), paramParcel1.readString(), zzb.zza(paramParcel1), (zzn)zzb.zza(paramParcel1, zzn.CREATOR));
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(paramParcel1);
      break;
    case 13: 
      zza((zzw)zzb.zza(paramParcel1, zzw.CREATOR));
      paramParcel2.writeNoException();
      break;
    case 12: 
      zza((zzw)zzb.zza(paramParcel1, zzw.CREATOR), (zzn)zzb.zza(paramParcel1, zzn.CREATOR));
      paramParcel2.writeNoException();
      break;
    case 11: 
      paramParcel1 = zzc((zzn)zzb.zza(paramParcel1, zzn.CREATOR));
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      break;
    case 10: 
      zza(paramParcel1.readLong(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      break;
    case 9: 
      paramParcel1 = zza((zzar)zzb.zza(paramParcel1, zzar.CREATOR), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeByteArray(paramParcel1);
      break;
    case 7: 
      paramParcel1 = zza((zzn)zzb.zza(paramParcel1, zzn.CREATOR), zzb.zza(paramParcel1));
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(paramParcel1);
      break;
    case 6: 
      zzb((zzn)zzb.zza(paramParcel1, zzn.CREATOR));
      paramParcel2.writeNoException();
      break;
    case 5: 
      zza((zzar)zzb.zza(paramParcel1, zzar.CREATOR), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      break;
    case 4: 
      zza((zzn)zzb.zza(paramParcel1, zzn.CREATOR));
      paramParcel2.writeNoException();
      break;
    case 2: 
      zza((zzkr)zzb.zza(paramParcel1, zzkr.CREATOR), (zzn)zzb.zza(paramParcel1, zzn.CREATOR));
      paramParcel2.writeNoException();
      break;
    case 1: 
      zza((zzar)zzb.zza(paramParcel1, zzar.CREATOR), (zzn)zzb.zza(paramParcel1, zzn.CREATOR));
      paramParcel2.writeNoException();
    }
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */