package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000\020\n\000\n\002\020\016\n\002\030\002\n\002\030\002\n\000\032\020\020\000\032\0020\001*\0060\002j\002`\003H\001¨\006\004"}, d2={"shortName", "", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/time/DurationUnitKt")
class DurationUnitKt__DurationUnitKt
  extends DurationUnitKt__DurationUnitJvmKt
{
  public static final String shortName(TimeUnit paramTimeUnit)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeUnit, "$this$shortName");
    switch (DurationUnitKt.WhenMappings.$EnumSwitchMapping$0[paramTimeUnit.ordinal()])
    {
    default: 
      throw new NoWhenBranchMatchedException();
    case 7: 
      return "d";
    case 6: 
      return "h";
    case 5: 
      return "m";
    case 4: 
      return "s";
    case 3: 
      return "ms";
    case 2: 
      return "us";
    }
    return "ns";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\time\DurationUnitKt__DurationUnitKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */