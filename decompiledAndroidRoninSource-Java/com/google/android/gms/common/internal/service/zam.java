package com.google.android.gms.common.internal.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;

public final class zam
  extends zaa
  implements zal
{
  zam(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.common.internal.service.ICommonService");
  }
  
  public final void zaa(zaj paramzaj)
    throws RemoteException
  {
    Parcel localParcel = zaa();
    zac.zaa(localParcel, paramzaj);
    zac(1, localParcel);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\internal\service\zam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */