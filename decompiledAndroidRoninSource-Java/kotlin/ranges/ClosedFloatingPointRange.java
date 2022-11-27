package kotlin.ranges;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000\030\n\002\030\002\n\000\n\002\020\017\n\002\030\002\n\000\n\002\020\013\n\002\b\b\bg\030\000*\016\b\000\020\001*\b\022\004\022\002H\0010\0022\b\022\004\022\002H\0010\003J\026\020\004\032\0020\0052\006\020\006\032\0028\000H\002¢\006\002\020\007J\b\020\b\032\0020\005H\026J\035\020\t\032\0020\0052\006\020\n\032\0028\0002\006\020\013\032\0028\000H&¢\006\002\020\f¨\006\r"}, d2={"Lkotlin/ranges/ClosedFloatingPointRange;", "T", "", "Lkotlin/ranges/ClosedRange;", "contains", "", "value", "(Ljava/lang/Comparable;)Z", "isEmpty", "lessThanOrEquals", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Z", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public abstract interface ClosedFloatingPointRange<T extends Comparable<? super T>>
  extends ClosedRange<T>
{
  public abstract boolean contains(T paramT);
  
  public abstract boolean isEmpty();
  
  public abstract boolean lessThanOrEquals(T paramT1, T paramT2);
  
  @Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 15})
  public static final class DefaultImpls
  {
    public static <T extends Comparable<? super T>> boolean contains(ClosedFloatingPointRange<T> paramClosedFloatingPointRange, T paramT)
    {
      Intrinsics.checkParameterIsNotNull(paramT, "value");
      return (paramClosedFloatingPointRange.lessThanOrEquals(paramClosedFloatingPointRange.getStart(), paramT)) && (paramClosedFloatingPointRange.lessThanOrEquals(paramT, paramClosedFloatingPointRange.getEndInclusive()));
    }
    
    public static <T extends Comparable<? super T>> boolean isEmpty(ClosedFloatingPointRange<T> paramClosedFloatingPointRange)
    {
      return paramClosedFloatingPointRange.lessThanOrEquals(paramClosedFloatingPointRange.getStart(), paramClosedFloatingPointRange.getEndInclusive()) ^ true;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\ranges\ClosedFloatingPointRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */