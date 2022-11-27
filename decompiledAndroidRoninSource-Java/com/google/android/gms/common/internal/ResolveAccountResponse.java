package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public class ResolveAccountResponse
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new zan();
  private ConnectionResult zadi;
  private boolean zagg;
  private final int zalf;
  private IBinder zanx;
  private boolean zapc;
  
  public ResolveAccountResponse(int paramInt)
  {
    this(new ConnectionResult(paramInt, null));
  }
  
  ResolveAccountResponse(int paramInt, IBinder paramIBinder, ConnectionResult paramConnectionResult, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.zalf = paramInt;
    this.zanx = paramIBinder;
    this.zadi = paramConnectionResult;
    this.zagg = paramBoolean1;
    this.zapc = paramBoolean2;
  }
  
  public ResolveAccountResponse(ConnectionResult paramConnectionResult)
  {
    this(1, null, paramConnectionResult, false, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ResolveAccountResponse)) {
      return false;
    }
    paramObject = (ResolveAccountResponse)paramObject;
    return (this.zadi.equals(((ResolveAccountResponse)paramObject).zadi)) && (getAccountAccessor().equals(((ResolveAccountResponse)paramObject).getAccountAccessor()));
  }
  
  public IAccountAccessor getAccountAccessor()
  {
    return IAccountAccessor.Stub.asInterface(this.zanx);
  }
  
  public ConnectionResult getConnectionResult()
  {
    return this.zadi;
  }
  
  public boolean getSaveDefaultAccount()
  {
    return this.zagg;
  }
  
  public boolean isFromCrossClientAuth()
  {
    return this.zapc;
  }
  
  public ResolveAccountResponse setAccountAccessor(IAccountAccessor paramIAccountAccessor)
  {
    if (paramIAccountAccessor == null) {
      paramIAccountAccessor = null;
    } else {
      paramIAccountAccessor = paramIAccountAccessor.asBinder();
    }
    this.zanx = paramIAccountAccessor;
    return this;
  }
  
  public ResolveAccountResponse setIsFromCrossClientAuth(boolean paramBoolean)
  {
    this.zapc = paramBoolean;
    return this;
  }
  
  public ResolveAccountResponse setSaveDefaultAccount(boolean paramBoolean)
  {
    this.zagg = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zalf);
    SafeParcelWriter.writeIBinder(paramParcel, 2, this.zanx, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, getConnectionResult(), paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 4, getSaveDefaultAccount());
    SafeParcelWriter.writeBoolean(paramParcel, 5, isFromCrossClientAuth());
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\internal\ResolveAccountResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */