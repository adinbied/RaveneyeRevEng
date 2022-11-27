package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zaa
  extends AbstractSafeParcelable
  implements Result
{
  public static final Parcelable.Creator<zaa> CREATOR = new zab();
  private final int zalf;
  private int zarz;
  private Intent zasa;
  
  public zaa()
  {
    this(0, null);
  }
  
  zaa(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.zalf = paramInt1;
    this.zarz = paramInt2;
    this.zasa = paramIntent;
  }
  
  private zaa(int paramInt, Intent paramIntent)
  {
    this(2, 0, null);
  }
  
  public final Status getStatus()
  {
    if (this.zarz == 0) {
      return Status.RESULT_SUCCESS;
    }
    return Status.RESULT_CANCELED;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zalf);
    SafeParcelWriter.writeInt(paramParcel, 2, this.zarz);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.zasa, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\signin\internal\zaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */