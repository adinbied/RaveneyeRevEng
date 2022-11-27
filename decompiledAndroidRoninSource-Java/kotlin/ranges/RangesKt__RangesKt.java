package kotlin.ranges;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000:\n\000\n\002\020\002\n\000\n\002\020\013\n\000\n\002\020\004\n\002\b\002\n\002\020\000\n\000\n\002\020\034\n\002\030\002\n\002\b\003\n\002\020\017\n\002\b\002\n\002\030\002\n\002\020\006\n\000\032\030\020\000\032\0020\0012\006\020\002\032\0020\0032\006\020\004\032\0020\005H\000\032@\020\006\032\0020\003\"\b\b\000\020\007*\0020\b\"\030\b\001\020\t*\b\022\004\022\002H\0070\n*\b\022\004\022\002H\0070\013*\002H\t2\b\020\f\032\004\030\001H\007H\n¢\006\002\020\r\0320\020\016\032\b\022\004\022\002H\0070\013\"\016\b\000\020\007*\b\022\004\022\002H\0070\017*\002H\0072\006\020\020\032\002H\007H\002¢\006\002\020\021\032\033\020\016\032\b\022\004\022\0020\0230\022*\0020\0232\006\020\020\032\0020\023H\002¨\006\024"}, d2={"checkStepIsPositive", "", "isPositive", "", "step", "", "contains", "T", "", "R", "", "Lkotlin/ranges/ClosedRange;", "element", "(Ljava/lang/Iterable;Ljava/lang/Object;)Z", "rangeTo", "", "that", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/ClosedRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/ranges/RangesKt")
class RangesKt__RangesKt
  extends RangesKt__RangesJVMKt
{
  public static final void checkStepIsPositive(boolean paramBoolean, Number paramNumber)
  {
    Intrinsics.checkParameterIsNotNull(paramNumber, "step");
    if (paramBoolean) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Step must be positive, was: ");
    localStringBuilder.append(paramNumber);
    localStringBuilder.append('.');
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString()));
  }
  
  private static final <T, R extends Iterable<? extends T>,  extends ClosedRange<T>> boolean contains(R paramR, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramR, "$this$contains");
    return (paramT != null) && (((ClosedRange)paramR).contains((Comparable)paramT));
  }
  
  public static final ClosedFloatingPointRange<Double> rangeTo(double paramDouble1, double paramDouble2)
  {
    return (ClosedFloatingPointRange)new ClosedDoubleRange(paramDouble1, paramDouble2);
  }
  
  public static final <T extends Comparable<? super T>> ClosedRange<T> rangeTo(T paramT1, T paramT2)
  {
    Intrinsics.checkParameterIsNotNull(paramT1, "$this$rangeTo");
    Intrinsics.checkParameterIsNotNull(paramT2, "that");
    return (ClosedRange)new ComparableRange(paramT1, paramT2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\ranges\RangesKt__RangesKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */