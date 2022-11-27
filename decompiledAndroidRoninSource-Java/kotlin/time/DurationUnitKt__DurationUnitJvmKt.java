package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000$\n\000\n\002\020\006\n\002\b\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\032(\020\000\032\0020\0012\006\020\002\032\0020\0012\n\020\003\032\0060\004j\002`\0052\n\020\006\032\0060\004j\002`\005H\001*\036\b\007\020\007\"\0020\0042\0020\004B\f\b\b\022\b\b\t\022\004\b\b(\nB\002\b\013¨\006\f"}, d2={"convertDurationUnit", "", "value", "sourceUnit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "targetUnit", "DurationUnit", "Lkotlin/SinceKotlin;", "version", "1.3", "Lkotlin/time/ExperimentalTime;", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/time/DurationUnitKt")
class DurationUnitKt__DurationUnitJvmKt
{
  public static final double convertDurationUnit(double paramDouble, TimeUnit paramTimeUnit1, TimeUnit paramTimeUnit2)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeUnit1, "sourceUnit");
    Intrinsics.checkParameterIsNotNull(paramTimeUnit2, "targetUnit");
    long l = paramTimeUnit2.convert(1L, paramTimeUnit1);
    if (l > 0L) {
      return paramDouble * l;
    }
    return paramDouble / paramTimeUnit1.convert(1L, paramTimeUnit2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\time\DurationUnitKt__DurationUnitJvmKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */