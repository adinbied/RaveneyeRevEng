package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.common.zzb;
import javax.annotation.Nullable;

public final class zzk
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzk> CREATOR = new zzl();
  private final boolean zzaa;
  private final boolean zzab;
  private final String zzy;
  @Nullable
  private final zze zzz;
  
  zzk(String paramString, @Nullable IBinder paramIBinder, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.zzy = paramString;
    this.zzz = zza(paramIBinder);
    this.zzaa = paramBoolean1;
    this.zzab = paramBoolean2;
  }
  
  zzk(String paramString, @Nullable zze paramzze, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.zzy = paramString;
    this.zzz = paramzze;
    this.zzaa = paramBoolean1;
    this.zzab = paramBoolean2;
  }
  
  @Nullable
  private static zze zza(@Nullable IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    try
    {
      paramIBinder = zzj.zzb(paramIBinder).zzb();
      if (paramIBinder == null) {
        paramIBinder = null;
      } else {
        paramIBinder = (byte[])ObjectWrapper.unwrap(paramIBinder);
      }
      if (paramIBinder != null) {
        return new zzf(paramIBinder);
      }
      Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
      return null;
    }
    catch (RemoteException paramIBinder)
    {
      Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", paramIBinder);
    }
    return null;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, this.zzy, false);
    Object localObject = this.zzz;
    if (localObject == null)
    {
      Log.w("GoogleCertificatesQuery", "certificate binder is null");
      localObject = null;
    }
    else
    {
      localObject = ((zzb)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 2, (IBinder)localObject, false);
    SafeParcelWriter.writeBoolean(paramParcel, 3, this.zzaa);
    SafeParcelWriter.writeBoolean(paramParcel, 4, this.zzab);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */