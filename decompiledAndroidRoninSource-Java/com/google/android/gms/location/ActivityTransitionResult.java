package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.Collections;
import java.util.List;

public class ActivityTransitionResult
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ActivityTransitionResult> CREATOR = new zzg();
  private final List<ActivityTransitionEvent> zzn;
  
  public ActivityTransitionResult(List<ActivityTransitionEvent> paramList)
  {
    Preconditions.checkNotNull(paramList, "transitionEvents list can't be null.");
    if (!paramList.isEmpty())
    {
      int i = 1;
      while (i < paramList.size())
      {
        boolean bool;
        if (((ActivityTransitionEvent)paramList.get(i)).getElapsedRealTimeNanos() >= ((ActivityTransitionEvent)paramList.get(i - 1)).getElapsedRealTimeNanos()) {
          bool = true;
        } else {
          bool = false;
        }
        Preconditions.checkArgument(bool);
        i += 1;
      }
    }
    this.zzn = Collections.unmodifiableList(paramList);
  }
  
  public static ActivityTransitionResult extractResult(Intent paramIntent)
  {
    if (!hasResult(paramIntent)) {
      return null;
    }
    return (ActivityTransitionResult)SafeParcelableSerializer.deserializeFromIntentExtra(paramIntent, "com.google.android.location.internal.EXTRA_ACTIVITY_TRANSITION_RESULT", CREATOR);
  }
  
  public static boolean hasResult(Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    return paramIntent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_TRANSITION_RESULT");
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass())) {
      return this.zzn.equals(((ActivityTransitionResult)paramObject).zzn);
    }
    return false;
  }
  
  public List<ActivityTransitionEvent> getTransitionEvents()
  {
    return this.zzn;
  }
  
  public int hashCode()
  {
    return this.zzn.hashCode();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, getTransitionEvents(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\location\ActivityTransitionResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */