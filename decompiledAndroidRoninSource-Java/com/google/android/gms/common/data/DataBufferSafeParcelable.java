package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DataBufferSafeParcelable<T extends SafeParcelable>
  extends AbstractDataBuffer<T>
{
  private static final String[] zalo = { "data" };
  private final Parcelable.Creator<T> zalp;
  
  public DataBufferSafeParcelable(DataHolder paramDataHolder, Parcelable.Creator<T> paramCreator)
  {
    super(paramDataHolder);
    this.zalp = paramCreator;
  }
  
  public static <T extends SafeParcelable> void addValue(DataHolder.Builder paramBuilder, T paramT)
  {
    Parcel localParcel = Parcel.obtain();
    paramT.writeToParcel(localParcel, 0);
    paramT = new ContentValues();
    paramT.put("data", localParcel.marshall());
    paramBuilder.withRow(paramT);
    localParcel.recycle();
  }
  
  public static DataHolder.Builder buildDataHolder()
  {
    return DataHolder.builder(zalo);
  }
  
  public T get(int paramInt)
  {
    Object localObject = this.mDataHolder.getByteArray("data", paramInt, this.mDataHolder.getWindowIndex(paramInt));
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall((byte[])localObject, 0, localObject.length);
    localParcel.setDataPosition(0);
    localObject = (SafeParcelable)this.zalp.createFromParcel(localParcel);
    localParcel.recycle();
    return (T)localObject;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\data\DataBufferSafeParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */