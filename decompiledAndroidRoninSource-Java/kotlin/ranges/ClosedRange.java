package kotlin.ranges;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000\032\n\002\030\002\n\000\n\002\020\017\n\002\020\000\n\002\b\006\n\002\020\013\n\002\b\004\bf\030\000*\016\b\000\020\001*\b\022\004\022\002H\0010\0022\0020\003J\026\020\t\032\0020\n2\006\020\013\032\0028\000H\002¢\006\002\020\fJ\b\020\r\032\0020\nH\026R\022\020\004\032\0028\000X¦\004¢\006\006\032\004\b\005\020\006R\022\020\007\032\0028\000X¦\004¢\006\006\032\004\b\b\020\006¨\006\016"}, d2={"Lkotlin/ranges/ClosedRange;", "T", "", "", "endInclusive", "getEndInclusive", "()Ljava/lang/Comparable;", "start", "getStart", "contains", "", "value", "(Ljava/lang/Comparable;)Z", "isEmpty", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public abstract interface ClosedRange<T extends Comparable<? super T>>
{
  public abstract boolean contains(T paramT);
  
  public abstract T getEndInclusive();
  
  public abstract T getStart();
  
  public abstract boolean isEmpty();
  
  @Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 15})
  public static final class DefaultImpls
  {
    public static <T extends Comparable<? super T>> boolean contains(ClosedRange<T> paramClosedRange, T paramT)
    {
      Intrinsics.checkParameterIsNotNull(paramT, "value");
      return (paramT.compareTo(paramClosedRange.getStart()) >= 0) && (paramT.compareTo(paramClosedRange.getEndInclusive()) <= 0);
    }
    
    public static <T extends Comparable<? super T>> boolean isEmpty(ClosedRange<T> paramClosedRange)
    {
      return paramClosedRange.getStart().compareTo(paramClosedRange.getEndInclusive()) > 0;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\ranges\ClosedRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */