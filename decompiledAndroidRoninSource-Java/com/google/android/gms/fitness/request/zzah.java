package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fitness.zzer;
import com.google.android.gms.internal.fitness.zzes;

public final class zzah
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzah> CREATOR = new zzai();
  private final zzer zzhl;
  
  zzah(IBinder paramIBinder)
  {
    this.zzhl = zzes.zzk(paramIBinder);
  }
  
  public zzah(zzer paramzzer)
  {
    this.zzhl = paramzzer;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeIBinder(paramParcel, 1, this.zzhl.asBinder(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\zzah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */