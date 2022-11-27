package io.reactivex.schedulers;

import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.TimeUnit;

public final class Timed<T>
{
  final long time;
  final TimeUnit unit;
  final T value;
  
  public Timed(T paramT, long paramLong, TimeUnit paramTimeUnit)
  {
    this.value = paramT;
    this.time = paramLong;
    this.unit = ((TimeUnit)ObjectHelper.requireNonNull(paramTimeUnit, "unit is null"));
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public long time()
  {
    return this.time;
  }
  
  public long time(TimeUnit paramTimeUnit)
  {
    return 277791584L;
  }
  
  public String toString()
  {
    return null;
  }
  
  public TimeUnit unit()
  {
    return this.unit;
  }
  
  public T value()
  {
    return (T)this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\schedulers\Timed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */