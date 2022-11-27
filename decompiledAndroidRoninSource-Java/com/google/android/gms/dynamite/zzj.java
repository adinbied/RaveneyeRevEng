package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

public final class zzj
  extends zza
  implements zzi
{
  zzj(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
  }
  
  public final int zza(IObjectWrapper paramIObjectWrapper, String paramString, boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.zza(localParcel, paramIObjectWrapper);
    localParcel.writeString(paramString);
    zzc.writeBoolean(localParcel, paramBoolean);
    paramIObjectWrapper = zza(3, localParcel);
    int i = paramIObjectWrapper.readInt();
    paramIObjectWrapper.recycle();
    return i;
  }
  
  public final IObjectWrapper zza(IObjectWrapper paramIObjectWrapper, String paramString, int paramInt)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.zza(localParcel, paramIObjectWrapper);
    localParcel.writeString(paramString);
    localParcel.writeInt(paramInt);
    paramIObjectWrapper = zza(2, localParcel);
    paramString = IObjectWrapper.Stub.asInterface(paramIObjectWrapper.readStrongBinder());
    paramIObjectWrapper.recycle();
    return paramString;
  }
  
  public final int zzak()
    throws RemoteException
  {
    Parcel localParcel = zza(6, zza());
    int i = localParcel.readInt();
    localParcel.recycle();
    return i;
  }
  
  public final int zzb(IObjectWrapper paramIObjectWrapper, String paramString, boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.zza(localParcel, paramIObjectWrapper);
    localParcel.writeString(paramString);
    zzc.writeBoolean(localParcel, paramBoolean);
    paramIObjectWrapper = zza(5, localParcel);
    int i = paramIObjectWrapper.readInt();
    paramIObjectWrapper.recycle();
    return i;
  }
  
  public final IObjectWrapper zzb(IObjectWrapper paramIObjectWrapper, String paramString, int paramInt)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.zza(localParcel, paramIObjectWrapper);
    localParcel.writeString(paramString);
    localParcel.writeInt(paramInt);
    paramIObjectWrapper = zza(4, localParcel);
    paramString = IObjectWrapper.Stub.asInterface(paramIObjectWrapper.readStrongBinder());
    paramIObjectWrapper.recycle();
    return paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\dynamite\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */