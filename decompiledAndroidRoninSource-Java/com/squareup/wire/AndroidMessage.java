package com.squareup.wire;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.IOException;
import java.lang.reflect.Array;
import okio.ByteString;

public abstract class AndroidMessage<M extends Message<M, B>, B extends Message.Builder<M, B>>
  extends Message<M, B>
  implements Parcelable
{
  protected AndroidMessage(ProtoAdapter<M> paramProtoAdapter, ByteString paramByteString)
  {
    super(paramProtoAdapter, paramByteString);
  }
  
  public static <E> Parcelable.Creator<E> newCreator(ProtoAdapter<E> paramProtoAdapter)
  {
    return new ProtoAdapterCreator(paramProtoAdapter);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeByteArray(encode());
  }
  
  private static final class ProtoAdapterCreator<M>
    implements Parcelable.Creator<M>
  {
    private final ProtoAdapter<M> adapter;
    
    ProtoAdapterCreator(ProtoAdapter<M> paramProtoAdapter)
    {
      this.adapter = paramProtoAdapter;
    }
    
    public M createFromParcel(Parcel paramParcel)
    {
      try
      {
        paramParcel = this.adapter.decode(paramParcel.createByteArray());
        return paramParcel;
      }
      catch (IOException paramParcel)
      {
        throw new RuntimeException(paramParcel);
      }
    }
    
    public M[] newArray(int paramInt)
    {
      return (Object[])Array.newInstance(this.adapter.javaType, paramInt);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\squareup\wire\AndroidMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */