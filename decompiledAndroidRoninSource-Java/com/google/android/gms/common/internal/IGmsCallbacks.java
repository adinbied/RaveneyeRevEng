package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zzc;

public abstract interface IGmsCallbacks
  extends IInterface
{
  public abstract void onPostInitComplete(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void zza(int paramInt, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void zza(int paramInt, IBinder paramIBinder, zzb paramzzb)
    throws RemoteException;
  
  public static abstract class zza
    extends com.google.android.gms.internal.common.zzb
    implements IGmsCallbacks
  {
    public zza()
    {
      super();
    }
    
    protected final boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3) {
            return false;
          }
          zza(paramParcel1.readInt(), paramParcel1.readStrongBinder(), (zzb)zzc.zza(paramParcel1, zzb.CREATOR));
        }
        else
        {
          zza(paramParcel1.readInt(), (Bundle)zzc.zza(paramParcel1, Bundle.CREATOR));
        }
      }
      else {
        onPostInitComplete(paramParcel1.readInt(), paramParcel1.readStrongBinder(), (Bundle)zzc.zza(paramParcel1, Bundle.CREATOR));
      }
      paramParcel2.writeNoException();
      return true;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\internal\IGmsCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */