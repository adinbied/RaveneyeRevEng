package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.fitness.zzcq;
import com.google.android.gms.internal.fitness.zzcr;

public final class zzbn
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzbn> CREATOR = new zzbo();
  private final zzcq zzgj;
  private final DataType zzq;
  private final DataSource zzr;
  
  zzbn(DataType paramDataType, DataSource paramDataSource, IBinder paramIBinder)
  {
    this.zzq = paramDataType;
    this.zzr = paramDataSource;
    this.zzgj = zzcr.zzj(paramIBinder);
  }
  
  public zzbn(DataType paramDataType, DataSource paramDataSource, zzcq paramzzcq)
  {
    this.zzq = paramDataType;
    this.zzr = paramDataSource;
    this.zzgj = paramzzcq;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof zzbn))
      {
        paramObject = (zzbn)paramObject;
        int i;
        if ((Objects.equal(this.zzr, ((zzbn)paramObject).zzr)) && (Objects.equal(this.zzq, ((zzbn)paramObject).zzq))) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { this.zzr, this.zzq });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, this.zzq, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.zzr, paramInt, false);
    Object localObject = this.zzgj;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((zzcq)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 3, (IBinder)localObject, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\zzbn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */