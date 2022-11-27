package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public abstract class FastSafeParcelableJsonResponse
  extends FastJsonResponse
  implements SafeParcelable
{
  public final int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!getClass().isInstance(paramObject)) {
      return false;
    }
    paramObject = (FastJsonResponse)paramObject;
    Iterator localIterator = getFieldMappings().values().iterator();
    while (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (isFieldSet(localField))
      {
        if ((!((FastJsonResponse)paramObject).isFieldSet(localField)) || (!getFieldValue(localField).equals(((FastJsonResponse)paramObject).getFieldValue(localField)))) {
          return false;
        }
      }
      else if (((FastJsonResponse)paramObject).isFieldSet(localField)) {
        return false;
      }
    }
    return true;
  }
  
  public Object getValueObject(String paramString)
  {
    return null;
  }
  
  public int hashCode()
  {
    Iterator localIterator = getFieldMappings().values().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (isFieldSet(localField)) {
        i = i * 31 + getFieldValue(localField).hashCode();
      }
    }
    return i;
  }
  
  public boolean isPrimitiveFieldSet(String paramString)
  {
    return false;
  }
  
  public byte[] toByteArray()
  {
    Parcel localParcel = Parcel.obtain();
    writeToParcel(localParcel, 0);
    byte[] arrayOfByte = localParcel.marshall();
    localParcel.recycle();
    return arrayOfByte;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\server\response\FastSafeParcelableJsonResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */