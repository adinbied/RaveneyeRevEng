package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ActivityTransition
  extends AbstractSafeParcelable
{
  public static final int ACTIVITY_TRANSITION_ENTER = 0;
  public static final int ACTIVITY_TRANSITION_EXIT = 1;
  public static final Parcelable.Creator<ActivityTransition> CREATOR = new zzc();
  private final int zzi;
  private final int zzj;
  
  ActivityTransition(int paramInt1, int paramInt2)
  {
    this.zzi = paramInt1;
    this.zzj = paramInt2;
  }
  
  public static void zza(int paramInt)
  {
    boolean bool = true;
    if ((paramInt < 0) || (paramInt > 1)) {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder(41);
    localStringBuilder.append("Transition type ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" is not valid.");
    Preconditions.checkArgument(bool, localStringBuilder.toString());
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ActivityTransition)) {
      return false;
    }
    paramObject = (ActivityTransition)paramObject;
    return (this.zzi == ((ActivityTransition)paramObject).zzi) && (this.zzj == ((ActivityTransition)paramObject).zzj);
  }
  
  public int getActivityType()
  {
    return this.zzi;
  }
  
  public int getTransitionType()
  {
    return this.zzj;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.zzi), Integer.valueOf(this.zzj) });
  }
  
  public String toString()
  {
    int i = this.zzi;
    int j = this.zzj;
    StringBuilder localStringBuilder = new StringBuilder(75);
    localStringBuilder.append("ActivityTransition [mActivityType=");
    localStringBuilder.append(i);
    localStringBuilder.append(", mTransitionType=");
    localStringBuilder.append(j);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, getActivityType());
    SafeParcelWriter.writeInt(paramParcel, 2, getTransitionType());
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private int zzi = -1;
    private int zzj = -1;
    
    public ActivityTransition build()
    {
      int i = this.zzi;
      boolean bool2 = true;
      boolean bool1;
      if (i != -1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Preconditions.checkState(bool1, "Activity type not set.");
      if (this.zzj != -1) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      Preconditions.checkState(bool1, "Activity transition type not set.");
      return new ActivityTransition(this.zzi, this.zzj);
    }
    
    public Builder setActivityTransition(int paramInt)
    {
      ActivityTransition.zza(paramInt);
      this.zzj = paramInt;
      return this;
    }
    
    public Builder setActivityType(int paramInt)
    {
      DetectedActivity.zzb(paramInt);
      this.zzi = paramInt;
      return this;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SupportedActivityTransition {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\location\ActivityTransition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */