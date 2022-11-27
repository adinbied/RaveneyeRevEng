package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.fitness.zzbe;
import com.google.android.gms.internal.fitness.zzbf;

public final class zzg
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzg> CREATOR = new zzh();
  private final zzbe zzgk;
  private final boolean zzgl;
  private DataType zzq;
  
  zzg(IBinder paramIBinder, DataType paramDataType, boolean paramBoolean)
  {
    this.zzgk = zzbf.zzb(paramIBinder);
    this.zzq = paramDataType;
    this.zzgl = paramBoolean;
  }
  
  public zzg(zzbe paramzzbe, DataType paramDataType, boolean paramBoolean)
  {
    this.zzgk = paramzzbe;
    this.zzq = paramDataType;
    this.zzgl = paramBoolean;
  }
  
  public final String toString()
  {
    Object localObject = this.zzq;
    if (localObject == null) {
      localObject = "null";
    } else {
      localObject = ((DataType)localObject).zzm();
    }
    return String.format("DailyTotalRequest{%s}", new Object[] { localObject });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeIBinder(paramParcel, 1, this.zzgk.asBinder(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.zzq, paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 4, this.zzgl);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */