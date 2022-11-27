package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.HexDumpUtils;
import com.google.android.gms.internal.fitness.zzfa;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public final class Value
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<Value> CREATOR = new zzai();
  private final int format;
  private float value;
  private boolean zzee;
  private String zzef;
  private Map<String, MapValue> zzeg;
  private int[] zzeh;
  private float[] zzei;
  private byte[] zzej;
  
  public Value(int paramInt)
  {
    this(paramInt, false, 0.0F, null, null, null, null, null);
  }
  
  Value(int paramInt, boolean paramBoolean, float paramFloat, String paramString, Bundle paramBundle, int[] paramArrayOfInt, float[] paramArrayOfFloat, byte[] paramArrayOfByte)
  {
    this.format = paramInt;
    this.zzee = paramBoolean;
    this.value = paramFloat;
    this.zzef = paramString;
    if (paramBundle == null)
    {
      paramString = null;
    }
    else
    {
      paramBundle.setClassLoader(MapValue.class.getClassLoader());
      ArrayMap localArrayMap = new ArrayMap(paramBundle.size());
      Iterator localIterator = paramBundle.keySet().iterator();
      for (;;)
      {
        paramString = localArrayMap;
        if (!localIterator.hasNext()) {
          break;
        }
        paramString = (String)localIterator.next();
        localArrayMap.put(paramString, (MapValue)paramBundle.getParcelable(paramString));
      }
    }
    this.zzeg = paramString;
    this.zzeh = paramArrayOfInt;
    this.zzei = paramArrayOfFloat;
    this.zzej = paramArrayOfByte;
  }
  
  public final String asActivity()
  {
    return zzfa.getName(asInt());
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
  
  public final int asInt()
  {
    int i = this.format;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    Preconditions.checkState(bool, "Value is not in int format");
    return Float.floatToRawIntBits(this.value);
  }
  
  public final String asString()
  {
    boolean bool;
    if (this.format == 3) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "Value is not in string format");
    return this.zzef;
  }
  
  public final void clearKey(String paramString)
  {
    boolean bool;
    if (this.format == 4) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "Attempting to set a key's value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
    Map localMap = this.zzeg;
    if (localMap != null) {
      localMap.remove(paramString);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Value)) {
      return false;
    }
    paramObject = (Value)paramObject;
    int i = this.format;
    if ((i == ((Value)paramObject).format) && (this.zzee == ((Value)paramObject).zzee)) {
      switch (i)
      {
      default: 
        if (this.value == ((Value)paramObject).value) {
          return true;
        }
        break;
      case 7: 
        return Arrays.equals(this.zzej, ((Value)paramObject).zzej);
      case 6: 
        return Arrays.equals(this.zzei, ((Value)paramObject).zzei);
      case 5: 
        return Arrays.equals(this.zzeh, ((Value)paramObject).zzeh);
      case 4: 
        return Objects.equal(this.zzeg, ((Value)paramObject).zzeg);
      case 3: 
        return Objects.equal(this.zzef, ((Value)paramObject).zzef);
      case 2: 
        return this.value == ((Value)paramObject).value;
      case 1: 
        if (asInt() == ((Value)paramObject).asInt()) {
          return true;
        }
        break;
      }
    }
    return false;
  }
  
  public final int getFormat()
  {
    return this.format;
  }
  
  public final Float getKeyValue(String paramString)
  {
    boolean bool;
    if (this.format == 4) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "Value is not in float map format");
    Map localMap = this.zzeg;
    if ((localMap != null) && (localMap.containsKey(paramString))) {
      return Float.valueOf(((MapValue)this.zzeg.get(paramString)).asFloat());
    }
    return null;
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { Float.valueOf(this.value), this.zzef, this.zzeg, this.zzeh, this.zzei, this.zzej });
  }
  
  public final boolean isSet()
  {
    return this.zzee;
  }
  
  public final void setActivity(String paramString)
  {
    setInt(zzfa.zzl(paramString));
  }
  
  public final void setFloat(float paramFloat)
  {
    boolean bool;
    if (this.format == 2) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "Attempting to set an float value to a field that is not in FLOAT format.  Please check the data type definition and use the right format.");
    this.zzee = true;
    this.value = paramFloat;
  }
  
  public final void setInt(int paramInt)
  {
    boolean bool;
    if (this.format == 1) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "Attempting to set an int value to a field that is not in INT32 format.  Please check the data type definition and use the right format.");
    this.zzee = true;
    this.value = Float.intBitsToFloat(paramInt);
  }
  
  public final void setKeyValue(String paramString, float paramFloat)
  {
    boolean bool;
    if (this.format == 4) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "Attempting to set a key's value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
    this.zzee = true;
    if (this.zzeg == null) {
      this.zzeg = new HashMap();
    }
    this.zzeg.put(paramString, new MapValue(2, paramFloat));
  }
  
  public final void setString(String paramString)
  {
    boolean bool;
    if (this.format == 3) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "Attempting to set a string value to a field that is not in STRING format.  Please check the data type definition and use the right format.");
    this.zzee = true;
    this.zzef = paramString;
  }
  
  public final String toString()
  {
    if (!this.zzee) {
      return "unset";
    }
    switch (this.format)
    {
    default: 
      return "unknown";
    case 7: 
      byte[] arrayOfByte = this.zzej;
      return HexDumpUtils.dump(arrayOfByte, 0, arrayOfByte.length, false);
    case 6: 
      return Arrays.toString(this.zzei);
    case 5: 
      return Arrays.toString(this.zzeh);
    case 4: 
      return new TreeMap(this.zzeg).toString();
    case 3: 
      return this.zzef;
    case 2: 
      return Float.toString(this.value);
    }
    return Integer.toString(asInt());
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, getFormat());
    SafeParcelWriter.writeBoolean(paramParcel, 2, isSet());
    SafeParcelWriter.writeFloat(paramParcel, 3, this.value);
    SafeParcelWriter.writeString(paramParcel, 4, this.zzef, false);
    Object localObject;
    if (this.zzeg == null)
    {
      localObject = null;
    }
    else
    {
      Bundle localBundle = new Bundle(this.zzeg.size());
      Iterator localIterator = this.zzeg.entrySet().iterator();
      for (;;)
      {
        localObject = localBundle;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
        localBundle.putParcelable((String)((Map.Entry)localObject).getKey(), (Parcelable)((Map.Entry)localObject).getValue());
      }
    }
    SafeParcelWriter.writeBundle(paramParcel, 5, (Bundle)localObject, false);
    SafeParcelWriter.writeIntArray(paramParcel, 6, this.zzeh, false);
    SafeParcelWriter.writeFloatArray(paramParcel, 7, this.zzei, false);
    SafeParcelWriter.writeByteArray(paramParcel, 8, this.zzej, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\data\Value.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */