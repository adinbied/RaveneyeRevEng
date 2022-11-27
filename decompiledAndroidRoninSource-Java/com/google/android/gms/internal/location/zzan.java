package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzan
  extends zzb
  implements zzam
{
  public zzan()
  {
    super("com.google.android.gms.location.internal.IGeofencerCallbacks");
  }
  
  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3) {
          return false;
        }
        zza(paramParcel1.readInt(), (PendingIntent)zzc.zza(paramParcel1, PendingIntent.CREATOR));
        return true;
      }
      zzb(paramParcel1.readInt(), paramParcel1.createStringArray());
      return true;
    }
    zza(paramParcel1.readInt(), paramParcel1.createStringArray());
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\location\zzan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */