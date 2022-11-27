package dji.thirdparty.rx.schedulers;

public final class Timestamped<T>
{
  private final long timestampMillis;
  private final T value;
  
  public Timestamped(long paramLong, T paramT)
  {
    this.value = paramT;
    this.timestampMillis = paramLong;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public long getTimestampMillis()
  {
    return this.timestampMillis;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\schedulers\Timestamped.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */