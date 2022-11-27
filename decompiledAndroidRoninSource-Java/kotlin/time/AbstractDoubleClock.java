package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000$\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b\004\n\002\030\002\n\000\n\002\020\006\n\002\b\002\b'\030\0002\0020\001:\001\fB\021\022\n\020\002\032\0060\003j\002`\004¢\006\002\020\005J\b\020\b\032\0020\tH\026J\b\020\n\032\0020\013H$R\030\020\002\032\0060\003j\002`\004X\004¢\006\b\n\000\032\004\b\006\020\007\002\004\n\002\b\031¨\006\r"}, d2={"Lkotlin/time/AbstractDoubleClock;", "Lkotlin/time/Clock;", "unit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "(Ljava/util/concurrent/TimeUnit;)V", "getUnit", "()Ljava/util/concurrent/TimeUnit;", "markNow", "Lkotlin/time/ClockMark;", "read", "", "DoubleClockMark", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public abstract class AbstractDoubleClock
  implements Clock
{
  private final TimeUnit unit;
  
  public AbstractDoubleClock(TimeUnit paramTimeUnit)
  {
    this.unit = paramTimeUnit;
  }
  
  protected final TimeUnit getUnit()
  {
    return this.unit;
  }
  
  public ClockMark markNow()
  {
    return (ClockMark)new DoubleClockMark(read(), this, Duration.Companion.getZERO(), null);
  }
  
  protected abstract double read();
  
  @Metadata(bv={1, 0, 3}, d1={"\000\036\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\t\b\002\030\0002\0020\001B \022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007ø\001\000¢\006\002\020\bJ\020\020\n\032\0020\007H\026ø\001\000¢\006\002\020\013J\033\020\f\032\0020\0012\006\020\r\032\0020\007H\002ø\001\000¢\006\004\b\016\020\017R\016\020\004\032\0020\005X\004¢\006\002\n\000R\023\020\006\032\0020\007X\004ø\001\000¢\006\004\n\002\020\tR\016\020\002\032\0020\003X\004¢\006\002\n\000\002\004\n\002\b\031¨\006\020"}, d2={"Lkotlin/time/AbstractDoubleClock$DoubleClockMark;", "Lkotlin/time/ClockMark;", "startedAt", "", "clock", "Lkotlin/time/AbstractDoubleClock;", "offset", "Lkotlin/time/Duration;", "(DLkotlin/time/AbstractDoubleClock;DLkotlin/jvm/internal/DefaultConstructorMarker;)V", "D", "elapsedNow", "()D", "plus", "duration", "plus-LRDsOJo", "(D)Lkotlin/time/ClockMark;", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
  private static final class DoubleClockMark
    extends ClockMark
  {
    private final AbstractDoubleClock clock;
    private final double offset;
    private final double startedAt;
    
    private DoubleClockMark(double paramDouble1, AbstractDoubleClock paramAbstractDoubleClock, double paramDouble2)
    {
      this.startedAt = paramDouble1;
      this.clock = paramAbstractDoubleClock;
      this.offset = paramDouble2;
    }
    
    public double elapsedNow()
    {
      return Duration.minus-LRDsOJo(DurationKt.toDuration(this.clock.read() - this.startedAt, this.clock.getUnit()), this.offset);
    }
    
    public ClockMark plus-LRDsOJo(double paramDouble)
    {
      return (ClockMark)new DoubleClockMark(this.startedAt, this.clock, Duration.plus-LRDsOJo(this.offset, paramDouble), null);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\time\AbstractDoubleClock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */