package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.Iterator;

public abstract class AbstractDataBuffer<T>
  implements DataBuffer<T>
{
  protected final DataHolder mDataHolder;
  
  protected AbstractDataBuffer(DataHolder paramDataHolder)
  {
    this.mDataHolder = paramDataHolder;
  }
  
  @Deprecated
  public final void close()
  {
    release();
  }
  
  public abstract T get(int paramInt);
  
  public int getCount()
  {
    DataHolder localDataHolder = this.mDataHolder;
    if (localDataHolder == null) {
      return 0;
    }
    return localDataHolder.getCount();
  }
  
  public Bundle getMetadata()
  {
    return this.mDataHolder.getMetadata();
  }
  
  @Deprecated
  public boolean isClosed()
  {
    DataHolder localDataHolder = this.mDataHolder;
    return (localDataHolder == null) || (localDataHolder.isClosed());
  }
  
  public Iterator<T> iterator()
  {
    return new DataBufferIterator(this);
  }
  
  public void release()
  {
    DataHolder localDataHolder = this.mDataHolder;
    if (localDataHolder != null) {
      localDataHolder.close();
    }
  }
  
  public Iterator<T> singleRefIterator()
  {
    return new SingleRefDataBufferIterator(this);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\data\AbstractDataBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */