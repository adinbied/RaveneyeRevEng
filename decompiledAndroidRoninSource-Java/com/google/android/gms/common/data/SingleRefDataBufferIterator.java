package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

public class SingleRefDataBufferIterator<T>
  extends DataBufferIterator<T>
{
  private T zamg;
  
  public SingleRefDataBufferIterator(DataBuffer<T> paramDataBuffer)
  {
    super(paramDataBuffer);
  }
  
  public T next()
  {
    if (hasNext())
    {
      this.zall += 1;
      if (this.zall == 0)
      {
        localObject = this.zalk.get(0);
        this.zamg = localObject;
        if (!(localObject instanceof DataBufferRef))
        {
          localObject = String.valueOf(this.zamg.getClass());
          StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject).length() + 44);
          localStringBuilder.append("DataBuffer reference of type ");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(" is not movable");
          throw new IllegalStateException(localStringBuilder.toString());
        }
      }
      else
      {
        ((DataBufferRef)this.zamg).zag(this.zall);
      }
      return (T)this.zamg;
    }
    int i = this.zall;
    Object localObject = new StringBuilder(46);
    ((StringBuilder)localObject).append("Cannot advance the iterator beyond ");
    ((StringBuilder)localObject).append(i);
    throw new NoSuchElementException(((StringBuilder)localObject).toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\data\SingleRefDataBufferIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */