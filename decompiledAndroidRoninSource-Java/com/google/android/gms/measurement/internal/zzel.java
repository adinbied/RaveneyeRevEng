package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zza;
import com.google.android.gms.internal.measurement.zzb;
import java.util.List;

public final class zzel
  extends zza
  implements zzej
{
  zzel(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
  }
  
  public final List<zzkr> zza(zzn paramzzn, boolean paramBoolean)
    throws RemoteException
  {
    Object localObject = a_();
    zzb.zza((Parcel)localObject, paramzzn);
    zzb.zza((Parcel)localObject, paramBoolean);
    paramzzn = zza(7, (Parcel)localObject);
    localObject = paramzzn.createTypedArrayList(zzkr.CREATOR);
    paramzzn.recycle();
    return (List<zzkr>)localObject;
  }
  
  public final List<zzw> zza(String paramString1, String paramString2, zzn paramzzn)
    throws RemoteException
  {
    Parcel localParcel = a_();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzb.zza(localParcel, paramzzn);
    paramString1 = zza(16, localParcel);
    paramString2 = paramString1.createTypedArrayList(zzw.CREATOR);
    paramString1.recycle();
    return paramString2;
  }
  
  public final List<zzw> zza(String paramString1, String paramString2, String paramString3)
    throws RemoteException
  {
    Parcel localParcel = a_();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    localParcel.writeString(paramString3);
    paramString1 = zza(17, localParcel);
    paramString2 = paramString1.createTypedArrayList(zzw.CREATOR);
    paramString1.recycle();
    return paramString2;
  }
  
  public final List<zzkr> zza(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = a_();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    localParcel.writeString(paramString3);
    zzb.zza(localParcel, paramBoolean);
    paramString1 = zza(15, localParcel);
    paramString2 = paramString1.createTypedArrayList(zzkr.CREATOR);
    paramString1.recycle();
    return paramString2;
  }
  
  public final List<zzkr> zza(String paramString1, String paramString2, boolean paramBoolean, zzn paramzzn)
    throws RemoteException
  {
    Parcel localParcel = a_();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzb.zza(localParcel, paramBoolean);
    zzb.zza(localParcel, paramzzn);
    paramString1 = zza(14, localParcel);
    paramString2 = paramString1.createTypedArrayList(zzkr.CREATOR);
    paramString1.recycle();
    return paramString2;
  }
  
  public final void zza(long paramLong, String paramString1, String paramString2, String paramString3)
    throws RemoteException
  {
    Parcel localParcel = a_();
    localParcel.writeLong(paramLong);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    localParcel.writeString(paramString3);
    zzb(10, localParcel);
  }
  
  public final void zza(Bundle paramBundle, zzn paramzzn)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramBundle);
    zzb.zza(localParcel, paramzzn);
    zzb(19, localParcel);
  }
  
  public final void zza(zzar paramzzar, zzn paramzzn)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramzzar);
    zzb.zza(localParcel, paramzzn);
    zzb(1, localParcel);
  }
  
  public final void zza(zzar paramzzar, String paramString1, String paramString2)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramzzar);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzb(5, localParcel);
  }
  
  public final void zza(zzkr paramzzkr, zzn paramzzn)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramzzkr);
    zzb.zza(localParcel, paramzzn);
    zzb(2, localParcel);
  }
  
  public final void zza(zzn paramzzn)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramzzn);
    zzb(4, localParcel);
  }
  
  public final void zza(zzw paramzzw)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramzzw);
    zzb(13, localParcel);
  }
  
  public final void zza(zzw paramzzw, zzn paramzzn)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramzzw);
    zzb.zza(localParcel, paramzzn);
    zzb(12, localParcel);
  }
  
  public final byte[] zza(zzar paramzzar, String paramString)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramzzar);
    localParcel.writeString(paramString);
    paramzzar = zza(9, localParcel);
    paramString = paramzzar.createByteArray();
    paramzzar.recycle();
    return paramString;
  }
  
  public final void zzb(zzn paramzzn)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramzzn);
    zzb(6, localParcel);
  }
  
  public final String zzc(zzn paramzzn)
    throws RemoteException
  {
    Object localObject = a_();
    zzb.zza((Parcel)localObject, paramzzn);
    paramzzn = zza(11, (Parcel)localObject);
    localObject = paramzzn.readString();
    paramzzn.recycle();
    return (String)localObject;
  }
  
  public final void zzd(zzn paramzzn)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramzzn);
    zzb(18, localParcel);
  }
  
  public final void zze(zzn paramzzn)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramzzn);
    zzb(20, localParcel);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */