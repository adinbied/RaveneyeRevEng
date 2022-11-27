package com.google.firebase.iid;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.util.Log;

public class zzj
  implements Parcelable
{
  public static final Parcelable.Creator<zzj> CREATOR = new zzi();
  private Messenger zza;
  private zzx zzb;
  
  public zzj(IBinder paramIBinder)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.zza = new Messenger(paramIBinder);
      return;
    }
    this.zzb = new zzw(paramIBinder);
  }
  
  private final IBinder zza()
  {
    Messenger localMessenger = this.zza;
    if (localMessenger != null) {
      return localMessenger.getBinder();
    }
    return this.zzb.asBinder();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    try
    {
      boolean bool = zza().equals(((zzj)paramObject).zza());
      return bool;
    }
    catch (ClassCastException paramObject) {}
    return false;
  }
  
  public int hashCode()
  {
    return zza().hashCode();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Messenger localMessenger = this.zza;
    if (localMessenger != null)
    {
      paramParcel.writeStrongBinder(localMessenger.getBinder());
      return;
    }
    paramParcel.writeStrongBinder(this.zzb.asBinder());
  }
  
  public final void zza(Message paramMessage)
    throws RemoteException
  {
    Messenger localMessenger = this.zza;
    if (localMessenger != null)
    {
      localMessenger.send(paramMessage);
      return;
    }
    this.zzb.zza(paramMessage);
  }
  
  public static final class zza
    extends ClassLoader
  {
    protected final Class<?> loadClass(String paramString, boolean paramBoolean)
      throws ClassNotFoundException
    {
      if ("com.google.android.gms.iid.MessengerCompat".equals(paramString))
      {
        if (FirebaseInstanceId.zzd()) {
          Log.d("FirebaseInstanceId", "Using renamed FirebaseIidMessengerCompat class");
        }
        return zzj.class;
      }
      return super.loadClass(paramString, paramBoolean);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\iid\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */