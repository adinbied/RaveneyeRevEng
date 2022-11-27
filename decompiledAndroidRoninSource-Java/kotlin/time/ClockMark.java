package kotlin.time;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000\034\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\b\b'\030\0002\0020\001B\005¢\006\002\020\002J\020\020\003\032\0020\004H&ø\001\000¢\006\002\020\005J\006\020\006\032\0020\007J\006\020\b\032\0020\007J\033\020\t\032\0020\0002\006\020\n\032\0020\004H\002ø\001\000¢\006\004\b\013\020\fJ\033\020\r\032\0020\0002\006\020\n\032\0020\004H\002ø\001\000¢\006\004\b\016\020\f\002\004\n\002\b\031¨\006\017"}, d2={"Lkotlin/time/ClockMark;", "", "()V", "elapsedNow", "Lkotlin/time/Duration;", "()D", "hasNotPassedNow", "", "hasPassedNow", "minus", "duration", "minus-LRDsOJo", "(D)Lkotlin/time/ClockMark;", "plus", "plus-LRDsOJo", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public abstract class ClockMark
{
  public abstract double elapsedNow();
  
  public final boolean hasNotPassedNow()
  {
    return Duration.isNegative-impl(elapsedNow());
  }
  
  public final boolean hasPassedNow()
  {
    return Duration.isNegative-impl(elapsedNow()) ^ true;
  }
  
  public ClockMark minus-LRDsOJo(double paramDouble)
  {
    return plus-LRDsOJo(Duration.unaryMinus-impl(paramDouble));
  }
  
  public ClockMark plus-LRDsOJo(double paramDouble)
  {
    return (ClockMark)new AdjustedClockMark(this, paramDouble, null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\time\ClockMark.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */