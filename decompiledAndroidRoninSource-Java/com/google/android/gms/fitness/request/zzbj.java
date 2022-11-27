package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.internal.fitness.zzcq;
import com.google.android.gms.internal.fitness.zzcr;

public final class zzbj
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzbj> CREATOR = new zzbk();
  private final zzcq zzgj;
  private Subscription zzio;
  private final boolean zzip;
  
  zzbj(Subscription paramSubscription, boolean paramBoolean, IBinder paramIBinder)
  {
    this.zzio = paramSubscription;
    this.zzip = paramBoolean;
    this.zzgj = zzcr.zzj(paramIBinder);
  }
  
  public zzbj(Subscription paramSubscription, boolean paramBoolean, zzcq paramzzcq)
  {
    this.zzio = paramSubscription;
    this.zzip = false;
    this.zzgj = paramzzcq;
  }
  
  public final String toString()
  {
    return Objects.toStringHelper(this).add("subscription", this.zzio).toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, this.zzio, paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 2, this.zzip);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\zzbj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */