package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fitness.zzcq;
import com.google.android.gms.internal.fitness.zzcr;

public final class zzaa
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzaa> CREATOR = new zzab();
  private final zzcq zzgj;
  
  zzaa(IBinder paramIBinder)
  {
    this.zzgj = zzcr.zzj(paramIBinder);
  }
  
  public zzaa(zzcq paramzzcq)
  {
    this.zzgj = paramzzcq;
  }
  
  public final String toString()
  {
    return String.format("DisableFitRequest", new Object[0]);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeIBinder(paramParcel, 1, this.zzgj.asBinder(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\zzaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */