package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.Goal;
import java.util.List;

public class GoalsResult
  extends AbstractSafeParcelable
  implements Result
{
  public static final Parcelable.Creator<GoalsResult> CREATOR = new zzf();
  private final Status zzir;
  private final List<Goal> zziu;
  
  public GoalsResult(Status paramStatus, List<Goal> paramList)
  {
    this.zzir = paramStatus;
    this.zziu = paramList;
  }
  
  public List<Goal> getGoals()
  {
    return this.zziu;
  }
  
  public Status getStatus()
  {
    return this.zzir;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, getStatus(), paramInt, false);
    SafeParcelWriter.writeTypedList(paramParcel, 2, getGoals(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\result\GoalsResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */