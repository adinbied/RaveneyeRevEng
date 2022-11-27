package kotlin.time;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000\026\n\000\n\002\020\b\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\032\025\020\000\032\0020\001*\0020\0022\006\020\003\032\0020\002H\n\032\035\020\004\032\0020\005*\0020\0022\006\020\003\032\0020\002H\nø\001\000¢\006\002\020\006\002\004\n\002\b\031¨\006\007"}, d2={"compareTo", "", "Lkotlin/time/ClockMark;", "other", "minus", "Lkotlin/time/Duration;", "(Lkotlin/time/ClockMark;Lkotlin/time/ClockMark;)D", "kotlin-stdlib"}, k=2, mv={1, 1, 15})
public final class ClockKt
{
  @Deprecated(level=DeprecationLevel.ERROR, message="Comparing one ClockMark to another is not a well defined operation because these clock marks could have been obtained from the different clocks.")
  private static final int compareTo(ClockMark paramClockMark1, ClockMark paramClockMark2)
  {
    Intrinsics.checkParameterIsNotNull(paramClockMark1, "$this$compareTo");
    throw ((Throwable)new Error("Operation is disallowed."));
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Subtracting one ClockMark from another is not a well defined operation because these clock marks could have been obtained from the different clocks.")
  private static final double minus(ClockMark paramClockMark1, ClockMark paramClockMark2)
  {
    Intrinsics.checkParameterIsNotNull(paramClockMark1, "$this$minus");
    throw ((Throwable)new Error("Operation is disallowed."));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\time\ClockKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */