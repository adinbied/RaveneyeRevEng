package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzad
  extends AbstractSafeParcelable
  implements Result
{
  public static final Parcelable.Creator<zzad> CREATOR = new zzae();
  private static final zzad zzcr = new zzad(Status.RESULT_SUCCESS);
  private final Status zzbl;
  
  public zzad(Status paramStatus)
  {
    this.zzbl = paramStatus;
  }
  
  public final Status getStatus()
  {
    return this.zzbl;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, getStatus(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\location\zzad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */