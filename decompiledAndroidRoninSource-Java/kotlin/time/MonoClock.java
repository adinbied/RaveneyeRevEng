package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000\034\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\t\n\000\n\002\020\016\n\000\bÇ\002\030\0002\0020\0012\0020\002B\007\b\002¢\006\002\020\003J\b\020\004\032\0020\005H\024J\b\020\006\032\0020\007H\026¨\006\b"}, d2={"Lkotlin/time/MonoClock;", "Lkotlin/time/AbstractLongClock;", "Lkotlin/time/Clock;", "()V", "read", "", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class MonoClock
  extends AbstractLongClock
  implements Clock
{
  public static final MonoClock INSTANCE = new MonoClock();
  
  private MonoClock()
  {
    super(TimeUnit.NANOSECONDS);
  }
  
  protected long read()
  {
    return System.nanoTime();
  }
  
  public String toString()
  {
    return "Clock(System.nanoTime())";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\time\MonoClock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */