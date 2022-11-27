package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.SparseArray;

public class ParcelableSparseArray
  extends SparseArray<Parcelable>
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableSparseArray> CREATOR = new Parcelable.ClassLoaderCreator()
  {
    public ParcelableSparseArray createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ParcelableSparseArray(paramAnonymousParcel, null);
    }
    
    public ParcelableSparseArray createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
    {
      return new ParcelableSparseArray(paramAnonymousParcel, paramAnonymousClassLoader);
    }
    
    public ParcelableSparseArray[] newArray(int paramAnonymousInt)
    {
      return new ParcelableSparseArray[paramAnonymousInt];
    }
  };
  
  public ParcelableSparseArray() {}
  
  public ParcelableSparseArray(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    int j = paramParcel.readInt();
    int[] arrayOfInt = new int[j];
    paramParcel.readIntArray(arrayOfInt);
    paramParcel = paramParcel.readParcelableArray(paramClassLoader);
    int i = 0;
    while (i < j)
    {
      put(arrayOfInt[i], paramParcel[i]);
      i += 1;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = size();
    int[] arrayOfInt = new int[j];
    Parcelable[] arrayOfParcelable = new Parcelable[j];
    int i = 0;
    while (i < j)
    {
      arrayOfInt[i] = keyAt(i);
      arrayOfParcelable[i] = ((Parcelable)valueAt(i));
      i += 1;
    }
    paramParcel.writeInt(j);
    paramParcel.writeIntArray(arrayOfInt);
    paramParcel.writeParcelableArray(arrayOfParcelable, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\material\internal\ParcelableSparseArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */