package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000 \n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\t\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\006\b\007\030\0002\0020\001B\005¢\006\002\020\002J\032\020\005\032\0020\0062\006\020\007\032\0020\bH\002ø\001\000¢\006\004\b\t\020\nJ\033\020\013\032\0020\0062\006\020\007\032\0020\bH\002ø\001\000¢\006\004\b\f\020\nJ\b\020\r\032\0020\004H\024R\016\020\003\032\0020\004X\016¢\006\002\n\000\002\004\n\002\b\031¨\006\016"}, d2={"Lkotlin/time/TestClock;", "Lkotlin/time/AbstractLongClock;", "()V", "reading", "", "overflow", "", "duration", "Lkotlin/time/Duration;", "overflow-LRDsOJo", "(D)V", "plusAssign", "plusAssign-LRDsOJo", "read", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class TestClock
  extends AbstractLongClock
{
  private long reading;
  
  public TestClock()
  {
    super(TimeUnit.NANOSECONDS);
  }
  
  private final void overflow-LRDsOJo(double paramDouble)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TestClock will overflow if its reading ");
    localStringBuilder.append(this.reading);
    localStringBuilder.append("ns is advanced by ");
    localStringBuilder.append(Duration.toString-impl(paramDouble));
    localStringBuilder.append('.');
    throw ((Throwable)new IllegalStateException(localStringBuilder.toString()));
  }
  
  public final void plusAssign-LRDsOJo(double paramDouble)
  {
    double d = Duration.toDouble-impl(paramDouble, getUnit());
    long l3 = d;
    long l1;
    if ((l3 != Long.MIN_VALUE) && (l3 != Long.MAX_VALUE))
    {
      long l4 = this.reading;
      long l2 = l4 + l3;
      l1 = l2;
      if ((l3 ^ l4) >= 0L)
      {
        l1 = l2;
        if ((l4 ^ l2) < 0L)
        {
          overflow-LRDsOJo(paramDouble);
          l1 = l2;
        }
      }
    }
    else
    {
      d = this.reading + d;
      if ((d > Long.MAX_VALUE) || (d < Long.MIN_VALUE)) {
        overflow-LRDsOJo(paramDouble);
      }
      l1 = d;
    }
    this.reading = l1;
  }
  
  protected long read()
  {
    return this.reading;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\time\TestClock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */