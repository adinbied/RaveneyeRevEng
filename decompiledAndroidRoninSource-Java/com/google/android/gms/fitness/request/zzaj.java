package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.fitness.zzch;
import com.google.android.gms.internal.fitness.zzci;

public final class zzaj
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzaj> CREATOR = new zzak();
  private final zzch zzhm;
  private final DataType zzq;
  
  zzaj(DataType paramDataType, IBinder paramIBinder)
  {
    this.zzq = paramDataType;
    this.zzhm = zzci.zzg(paramIBinder);
  }
  
  public zzaj(DataType paramDataType, zzch paramzzch)
  {
    this.zzq = paramDataType;
    this.zzhm = paramzzch;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, this.zzq, paramInt, false);
    Object localObject = this.zzhm;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((zzch)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 2, (IBinder)localObject, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\zzaj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */