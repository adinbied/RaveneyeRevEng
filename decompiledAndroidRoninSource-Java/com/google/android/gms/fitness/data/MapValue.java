package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public class MapValue
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<MapValue> CREATOR = new zzw();
  private final int format;
  private final float value;
  
  public MapValue(int paramInt, float paramFloat)
  {
    this.format = paramInt;
    this.value = paramFloat;
  }
  
  public final float asFloat()
  {
    boolean bool;
    if (this.format == 2) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "Value is not in float format");
    return this.value;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof MapValue)) {
      return false;
    }
    paramObject = (MapValue)paramObject;
    int i = this.format;
    if (i == ((MapValue)paramObject).format)
    {
      if (i != 2) {
        return this.value == ((MapValue)paramObject).value;
      }
      if (asFloat() == ((MapValue)paramObject).asFloat()) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return (int)this.value;
  }
  
  public String toString()
  {
    if (this.format != 2) {
      return "unknown";
    }
    return Float.toString(asFloat());
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.format);
    SafeParcelWriter.writeFloat(paramParcel, 2, this.value);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\data\MapValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */