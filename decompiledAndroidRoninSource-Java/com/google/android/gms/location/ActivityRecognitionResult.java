package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ActivityRecognitionResult
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<ActivityRecognitionResult> CREATOR = new zzb();
  private Bundle extras;
  private List<DetectedActivity> zze;
  private long zzf;
  private long zzg;
  private int zzh;
  
  public ActivityRecognitionResult(DetectedActivity paramDetectedActivity, long paramLong1, long paramLong2)
  {
    this(paramDetectedActivity, paramLong1, paramLong2, 0, null);
  }
  
  private ActivityRecognitionResult(DetectedActivity paramDetectedActivity, long paramLong1, long paramLong2, int paramInt, Bundle paramBundle)
  {
    this(Collections.singletonList(paramDetectedActivity), paramLong1, paramLong2, 0, null);
  }
  
  public ActivityRecognitionResult(List<DetectedActivity> paramList, long paramLong1, long paramLong2)
  {
    this(paramList, paramLong1, paramLong2, 0, null);
  }
  
  public ActivityRecognitionResult(List<DetectedActivity> paramList, long paramLong1, long paramLong2, int paramInt, Bundle paramBundle)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramList != null) && (paramList.size() > 0)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1, "Must have at least 1 detected activity");
    if ((paramLong1 > 0L) && (paramLong2 > 0L)) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1, "Must set times");
    this.zze = paramList;
    this.zzf = paramLong1;
    this.zzg = paramLong2;
    this.zzh = paramInt;
    this.extras = paramBundle;
  }
  
  public static ActivityRecognitionResult extractResult(Intent paramIntent)
  {
    if (hasResult(paramIntent))
    {
      localObject = paramIntent.getExtras().get("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
      if ((localObject instanceof byte[])) {
        localObject = SafeParcelableSerializer.deserializeFromBytes((byte[])localObject, CREATOR);
      }
      while ((localObject instanceof ActivityRecognitionResult))
      {
        localObject = (ActivityRecognitionResult)localObject;
        break;
      }
    }
    Object localObject = null;
    if (localObject != null) {
      return (ActivityRecognitionResult)localObject;
    }
    paramIntent = zza(paramIntent);
    if (paramIntent != null)
    {
      if (paramIntent.isEmpty()) {
        return null;
      }
      return (ActivityRecognitionResult)paramIntent.get(paramIntent.size() - 1);
    }
    return null;
  }
  
  public static boolean hasResult(Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    boolean bool;
    if (paramIntent == null) {
      bool = false;
    } else {
      bool = paramIntent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
    }
    if (bool) {
      return true;
    }
    paramIntent = zza(paramIntent);
    return (paramIntent != null) && (!paramIntent.isEmpty());
  }
  
  private static List<ActivityRecognitionResult> zza(Intent paramIntent)
  {
    boolean bool;
    if (paramIntent == null) {
      bool = false;
    } else {
      bool = paramIntent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT_LIST");
    }
    if (!bool) {
      return null;
    }
    return SafeParcelableSerializer.deserializeIterableFromIntentExtra(paramIntent, "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT_LIST", CREATOR);
  }
  
  private static boolean zza(Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramBundle1 == null) && (paramBundle2 == null)) {
      return true;
    }
    if (((paramBundle1 == null) && (paramBundle2 != null)) || ((paramBundle1 != null) && (paramBundle2 == null))) {
      return false;
    }
    if (paramBundle1.size() != paramBundle2.size()) {
      return false;
    }
    Iterator localIterator = paramBundle1.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!paramBundle2.containsKey(str)) {
        return false;
      }
      if (paramBundle1.get(str) == null)
      {
        if (paramBundle2.get(str) != null) {
          return false;
        }
      }
      else if ((paramBundle1.get(str) instanceof Bundle))
      {
        if (!zza(paramBundle1.getBundle(str), paramBundle2.getBundle(str))) {
          return false;
        }
      }
      else if (!paramBundle1.get(str).equals(paramBundle2.get(str))) {
        return false;
      }
    }
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (ActivityRecognitionResult)paramObject;
      if ((this.zzf == ((ActivityRecognitionResult)paramObject).zzf) && (this.zzg == ((ActivityRecognitionResult)paramObject).zzg) && (this.zzh == ((ActivityRecognitionResult)paramObject).zzh) && (Objects.equal(this.zze, ((ActivityRecognitionResult)paramObject).zze)) && (zza(this.extras, ((ActivityRecognitionResult)paramObject).extras))) {
        return true;
      }
    }
    return false;
  }
  
  public int getActivityConfidence(int paramInt)
  {
    Iterator localIterator = this.zze.iterator();
    while (localIterator.hasNext())
    {
      DetectedActivity localDetectedActivity = (DetectedActivity)localIterator.next();
      if (localDetectedActivity.getType() == paramInt) {
        return localDetectedActivity.getConfidence();
      }
    }
    return 0;
  }
  
  public long getElapsedRealtimeMillis()
  {
    return this.zzg;
  }
  
  public DetectedActivity getMostProbableActivity()
  {
    return (DetectedActivity)this.zze.get(0);
  }
  
  public List<DetectedActivity> getProbableActivities()
  {
    return this.zze;
  }
  
  public long getTime()
  {
    return this.zzf;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { Long.valueOf(this.zzf), Long.valueOf(this.zzg), Integer.valueOf(this.zzh), this.zze, this.extras });
  }
  
  public String toString()
  {
    String str = String.valueOf(this.zze);
    long l1 = this.zzf;
    long l2 = this.zzg;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 124);
    localStringBuilder.append("ActivityRecognitionResult [probableActivities=");
    localStringBuilder.append(str);
    localStringBuilder.append(", timeMillis=");
    localStringBuilder.append(l1);
    localStringBuilder.append(", elapsedRealtimeMillis=");
    localStringBuilder.append(l2);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, this.zze, false);
    SafeParcelWriter.writeLong(paramParcel, 2, this.zzf);
    SafeParcelWriter.writeLong(paramParcel, 3, this.zzg);
    SafeParcelWriter.writeInt(paramParcel, 4, this.zzh);
    SafeParcelWriter.writeBundle(paramParcel, 5, this.extras, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\location\ActivityRecognitionResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */