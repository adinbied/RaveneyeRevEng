package dji.thirdparty.rx.schedulers;

public class TimeInterval<T>
{
  private final long intervalInMilliseconds;
  private final T value;
  
  public TimeInterval(long paramLong, T paramT)
  {
    this.value = paramT;
    this.intervalInMilliseconds = paramLong;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public long getIntervalInMilliseconds()
  {
    return this.intervalInMilliseconds;
  }
  
  public T getValue()
  {
    return (T)this.value;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\schedulers\TimeInterval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */