package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.fitness.zzcq;
import com.google.android.gms.internal.fitness.zzcr;

public final class zzk
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzk> CREATOR = new zzl();
  private final DataSet zzeb;
  private final zzcq zzgj;
  private final boolean zzgq;
  
  zzk(DataSet paramDataSet, IBinder paramIBinder, boolean paramBoolean)
  {
    this.zzeb = paramDataSet;
    this.zzgj = zzcr.zzj(paramIBinder);
    this.zzgq = paramBoolean;
  }
  
  public zzk(DataSet paramDataSet, zzcq paramzzcq, boolean paramBoolean)
  {
    this.zzeb = paramDataSet;
    this.zzgj = paramzzcq;
    this.zzgq = paramBoolean;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this) {
      if ((paramObject instanceof zzk))
      {
        paramObject = (zzk)paramObject;
        if (Objects.equal(this.zzeb, ((zzk)paramObject).zzeb)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { this.zzeb });
  }
  
  public final String toString()
  {
    return Objects.toStringHelper(this).add("dataSet", this.zzeb).toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, this.zzeb, paramInt, false);
    Object localObject = this.zzgj;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((zzcq)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 2, (IBinder)localObject, false);
    SafeParcelWriter.writeBoolean(paramParcel, 4, this.zzgq);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */