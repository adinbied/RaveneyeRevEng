package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.fitness.zzcq;
import com.google.android.gms.internal.fitness.zzcr;
import java.util.concurrent.TimeUnit;

public final class zzaz
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzaz> CREATOR = new zzba();
  private final zzcq zzgj;
  private final Session zzz;
  
  zzaz(Session paramSession, IBinder paramIBinder)
  {
    this.zzz = paramSession;
    this.zzgj = zzcr.zzj(paramIBinder);
  }
  
  public zzaz(Session paramSession, zzcq paramzzcq)
  {
    boolean bool;
    if (paramSession.getStartTime(TimeUnit.MILLISECONDS) < System.currentTimeMillis()) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "Cannot start a session in the future");
    Preconditions.checkArgument(paramSession.isOngoing(), "Cannot start a session which has already ended");
    this.zzz = paramSession;
    this.zzgj = paramzzcq;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this) {
      if ((paramObject instanceof zzaz))
      {
        paramObject = (zzaz)paramObject;
        if (Objects.equal(this.zzz, ((zzaz)paramObject).zzz)) {}
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
    return Objects.hashCode(new Object[] { this.zzz });
  }
  
  public final String toString()
  {
    return Objects.toStringHelper(this).add("session", this.zzz).toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, this.zzz, paramInt, false);
    Object localObject = this.zzgj;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((zzcq)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 2, (IBinder)localObject, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\zzaz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */