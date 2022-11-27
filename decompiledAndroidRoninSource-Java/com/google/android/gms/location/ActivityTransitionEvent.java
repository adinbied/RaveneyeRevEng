package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public class ActivityTransitionEvent
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ActivityTransitionEvent> CREATOR = new zzd();
  private final int zzi;
  private final int zzj;
  private final long zzk;
  
  public ActivityTransitionEvent(int paramInt1, int paramInt2, long paramLong)
  {
    DetectedActivity.zzb(paramInt1);
    ActivityTransition.zza(paramInt2);
    this.zzi = paramInt1;
    this.zzj = paramInt2;
    this.zzk = paramLong;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ActivityTransitionEvent)) {
      return false;
    }
    paramObject = (ActivityTransitionEvent)paramObject;
    return (this.zzi == ((ActivityTransitionEvent)paramObject).zzi) && (this.zzj == ((ActivityTransitionEvent)paramObject).zzj) && (this.zzk == ((ActivityTransitionEvent)paramObject).zzk);
  }
  
  public int getActivityType()
  {
    return this.zzi;
  }
  
  public long getElapsedRealTimeNanos()
  {
    return this.zzk;
  }
  
  public int getTransitionType()
  {
    return this.zzj;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.zzi), Integer.valueOf(this.zzj), Long.valueOf(this.zzk) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i = this.zzi;
    StringBuilder localStringBuilder2 = new StringBuilder(24);
    localStringBuilder2.append("ActivityType ");
    localStringBuilder2.append(i);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append(" ");
    i = this.zzj;
    localStringBuilder2 = new StringBuilder(26);
    localStringBuilder2.append("TransitionType ");
    localStringBuilder2.append(i);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append(" ");
    long l = this.zzk;
    localStringBuilder2 = new StringBuilder(41);
    localStringBuilder2.append("ElapsedRealTimeNanos ");
    localStringBuilder2.append(l);
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, getActivityType());
    SafeParcelWriter.writeInt(paramParcel, 2, getTransitionType());
    SafeParcelWriter.writeLong(paramParcel, 3, getElapsedRealTimeNanos());
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\location\ActivityTransitionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */