package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.Session;
import java.util.Collections;
import java.util.List;

public class SessionStopResult
  extends AbstractSafeParcelable
  implements Result
{
  public static final Parcelable.Creator<SessionStopResult> CREATOR = new zzi();
  private final List<Session> zzgn;
  private final Status zzir;
  
  public SessionStopResult(Status paramStatus, List<Session> paramList)
  {
    this.zzir = paramStatus;
    this.zzgn = Collections.unmodifiableList(paramList);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof SessionStopResult))
      {
        paramObject = (SessionStopResult)paramObject;
        int i;
        if ((this.zzir.equals(((SessionStopResult)paramObject).zzir)) && (Objects.equal(this.zzgn, ((SessionStopResult)paramObject).zzgn))) {
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
  
  public List<Session> getSessions()
  {
    return this.zzgn;
  }
  
  public Status getStatus()
  {
    return this.zzir;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.zzir, this.zzgn });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("status", this.zzir).add("sessions", this.zzgn).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getStatus(), paramInt, false);
    SafeParcelWriter.writeTypedList(paramParcel, 3, getSessions(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\result\SessionStopResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */