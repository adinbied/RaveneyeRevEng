package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Comparator;

public class DetectedActivity
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<DetectedActivity> CREATOR = new zzi();
  public static final int IN_VEHICLE = 0;
  public static final int ON_BICYCLE = 1;
  public static final int ON_FOOT = 2;
  public static final int RUNNING = 8;
  public static final int STILL = 3;
  public static final int TILTING = 5;
  public static final int UNKNOWN = 4;
  public static final int WALKING = 7;
  private static final Comparator<DetectedActivity> zzo = new zzh();
  private static final int[] zzp = { 9, 10 };
  private static final int[] zzq = { 0, 1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 16, 17, 18, 19 };
  private static final int[] zzr = { 0, 1, 2, 3, 7, 8, 16, 17 };
  private int zzi;
  private int zzs;
  
  public DetectedActivity(int paramInt1, int paramInt2)
  {
    this.zzi = paramInt1;
    this.zzs = paramInt2;
  }
  
  public static void zzb(int paramInt)
  {
    Object localObject = zzr;
    int k = localObject.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      if (localObject[i] == paramInt) {
        j = 1;
      }
      i += 1;
    }
    if (j == 0)
    {
      localObject = new StringBuilder(81);
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" is not a valid DetectedActivity supported by Activity Transition API.");
      Log.w("DetectedActivity", ((StringBuilder)localObject).toString());
    }
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
      paramObject = (DetectedActivity)paramObject;
      if ((this.zzi == ((DetectedActivity)paramObject).zzi) && (this.zzs == ((DetectedActivity)paramObject).zzs)) {
        return true;
      }
    }
    return false;
  }
  
  public int getConfidence()
  {
    return this.zzs;
  }
  
  public int getType()
  {
    int i = this.zzi;
    if ((i <= 19) && (i >= 0)) {
      return i;
    }
    return 4;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.zzi), Integer.valueOf(this.zzs) });
  }
  
  public String toString()
  {
    int i = getType();
    String str;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5)
              {
                if (i != 7)
                {
                  if (i != 8) {
                    switch (i)
                    {
                    default: 
                      str = Integer.toString(i);
                      break;
                    case 19: 
                      str = "IN_FOUR_WHEELER_VEHICLE";
                      break;
                    case 18: 
                      str = "IN_TWO_WHEELER_VEHICLE";
                      break;
                    case 17: 
                      str = "IN_RAIL_VEHICLE";
                      break;
                    case 16: 
                      str = "IN_ROAD_VEHICLE";
                      break;
                    }
                  } else {
                    str = "RUNNING";
                  }
                }
                else {
                  str = "WALKING";
                }
              }
              else {
                str = "TILTING";
              }
            }
            else {
              str = "UNKNOWN";
            }
          }
          else {
            str = "STILL";
          }
        }
        else {
          str = "ON_FOOT";
        }
      }
      else {
        str = "ON_BICYCLE";
      }
    }
    else {
      str = "IN_VEHICLE";
    }
    i = this.zzs;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 48);
    localStringBuilder.append("DetectedActivity [type=");
    localStringBuilder.append(str);
    localStringBuilder.append(", confidence=");
    localStringBuilder.append(i);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzi);
    SafeParcelWriter.writeInt(paramParcel, 2, this.zzs);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\location\DetectedActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */