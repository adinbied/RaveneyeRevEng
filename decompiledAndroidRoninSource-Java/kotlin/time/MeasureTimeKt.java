package kotlin.time;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000\"\n\000\n\002\030\002\n\000\n\002\030\002\n\002\020\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\032,\020\000\032\0020\0012\f\020\002\032\b\022\004\022\0020\0040\003H\bø\001\000\002\n\n\b\b\001\022\002\020\001 \001¢\006\002\020\005\0320\020\006\032\b\022\004\022\002H\b0\007\"\004\b\000\020\b2\f\020\002\032\b\022\004\022\002H\b0\003H\b\002\n\n\b\b\001\022\002\020\001 \001\0320\020\000\032\0020\001*\0020\t2\f\020\002\032\b\022\004\022\0020\0040\003H\bø\001\000\002\n\n\b\b\001\022\002\020\001 \001¢\006\002\020\n\0324\020\006\032\b\022\004\022\002H\b0\007\"\004\b\000\020\b*\0020\t2\f\020\002\032\b\022\004\022\002H\b0\003H\b\002\n\n\b\b\001\022\002\020\001 \001\002\004\n\002\b\031¨\006\013"}, d2={"measureTime", "Lkotlin/time/Duration;", "block", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)D", "measureTimedValue", "Lkotlin/time/TimedValue;", "T", "Lkotlin/time/Clock;", "(Lkotlin/time/Clock;Lkotlin/jvm/functions/Function0;)D", "kotlin-stdlib"}, k=2, mv={1, 1, 15})
public final class MeasureTimeKt
{
  public static final double measureTime(Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    ClockMark localClockMark = ((Clock)MonoClock.INSTANCE).markNow();
    paramFunction0.invoke();
    return localClockMark.elapsedNow();
  }
  
  public static final double measureTime(Clock paramClock, Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramClock, "$this$measureTime");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    paramClock = paramClock.markNow();
    paramFunction0.invoke();
    return paramClock.elapsedNow();
  }
  
  public static final <T> TimedValue<T> measureTimedValue(Function0<? extends T> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    ClockMark localClockMark = ((Clock)MonoClock.INSTANCE).markNow();
    return new TimedValue(paramFunction0.invoke(), localClockMark.elapsedNow(), null);
  }
  
  public static final <T> TimedValue<T> measureTimedValue(Clock paramClock, Function0<? extends T> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramClock, "$this$measureTimedValue");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    paramClock = paramClock.markNow();
    return new TimedValue(paramFunction0.invoke(), paramClock.elapsedNow(), null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\time\MeasureTimeKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */