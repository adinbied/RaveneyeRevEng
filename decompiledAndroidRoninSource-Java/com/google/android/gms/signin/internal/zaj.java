package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zaj
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zaj> CREATOR = new zak();
  private final ConnectionResult zadi;
  private final int zalf;
  private final ResolveAccountResponse zase;
  
  public zaj(int paramInt)
  {
    this(new ConnectionResult(8, null), null);
  }
  
  zaj(int paramInt, ConnectionResult paramConnectionResult, ResolveAccountResponse paramResolveAccountResponse)
  {
    this.zalf = paramInt;
    this.zadi = paramConnectionResult;
    this.zase = paramResolveAccountResponse;
  }
  
  private zaj(ConnectionResult paramConnectionResult, ResolveAccountResponse paramResolveAccountResponse)
  {
    this(1, paramConnectionResult, null);
  }
  
  public final ConnectionResult getConnectionResult()
  {
    return this.zadi;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zalf);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.zadi, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.zase, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final ResolveAccountResponse zacx()
  {
    return this.zase;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\signin\internal\zaj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */