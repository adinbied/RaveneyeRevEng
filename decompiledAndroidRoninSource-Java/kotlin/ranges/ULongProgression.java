package kotlin.ranges;

import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.collections.ULongIterator;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv={1, 0, 3}, d1={"\000:\n\002\030\002\n\002\020\034\n\002\030\002\n\002\b\003\n\002\020\t\n\002\b\t\n\002\020\013\n\000\n\002\020\000\n\000\n\002\020\b\n\002\b\002\n\002\030\002\n\000\n\002\020\016\n\002\b\002\b\027\030\000 \0322\b\022\004\022\0020\0020\001:\001\032B\"\b\000\022\006\020\003\032\0020\002\022\006\020\004\032\0020\002\022\006\020\005\032\0020\006ø\001\000¢\006\002\020\007J\023\020\017\032\0020\0202\b\020\021\032\004\030\0010\022H\002J\b\020\023\032\0020\024H\026J\b\020\025\032\0020\020H\026J\t\020\026\032\0020\027H\002J\b\020\030\032\0020\031H\026R\026\020\b\032\0020\002ø\001\000¢\006\n\n\002\020\013\032\004\b\t\020\nR\026\020\f\032\0020\002ø\001\000¢\006\n\n\002\020\013\032\004\b\r\020\nR\021\020\005\032\0020\006¢\006\b\n\000\032\004\b\016\020\nø\001\000\002\004\n\002\b\031¨\006\033"}, d2={"Lkotlin/ranges/ULongProgression;", "", "Lkotlin/ULong;", "start", "endInclusive", "step", "", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "first", "getFirst", "()J", "J", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "", "isEmpty", "iterator", "Lkotlin/collections/ULongIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public class ULongProgression
  implements Iterable<ULong>, KMappedMarker
{
  public static final Companion Companion = new Companion(null);
  private final long first;
  private final long last;
  private final long step;
  
  private ULongProgression(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong3 != 0L)
    {
      if (paramLong3 != Long.MIN_VALUE)
      {
        this.first = paramLong1;
        this.last = UProgressionUtilKt.getProgressionLastElement-7ftBX0g(paramLong1, paramLong2, paramLong3);
        this.step = paramLong3;
        return;
      }
      throw ((Throwable)new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation."));
    }
    throw ((Throwable)new IllegalArgumentException("Step must be non-zero."));
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof ULongProgression)) {
      if ((!isEmpty()) || (!((ULongProgression)paramObject).isEmpty()))
      {
        long l = this.first;
        paramObject = (ULongProgression)paramObject;
        if ((l != ((ULongProgression)paramObject).first) || (this.last != ((ULongProgression)paramObject).last) || (this.step != ((ULongProgression)paramObject).step)) {}
      }
      else
      {
        return true;
      }
    }
    return false;
  }
  
  public final long getFirst()
  {
    return this.first;
  }
  
  public final long getLast()
  {
    return this.last;
  }
  
  public final long getStep()
  {
    return this.step;
  }
  
  public int hashCode()
  {
    if (isEmpty()) {
      return -1;
    }
    long l = this.first;
    int i = (int)ULong.constructor-impl(l ^ ULong.constructor-impl(l >>> 32));
    l = this.last;
    int j = (int)ULong.constructor-impl(l ^ ULong.constructor-impl(l >>> 32));
    l = this.step;
    return (int)(l ^ l >>> 32) + (i * 31 + j) * 31;
  }
  
  public boolean isEmpty()
  {
    long l = this.step;
    int i = UnsignedKt.ulongCompare(this.first, this.last);
    if (l > 0L)
    {
      if (i > 0) {
        return true;
      }
    }
    else if (i < 0) {
      return true;
    }
    return false;
  }
  
  public ULongIterator iterator()
  {
    return (ULongIterator)new ULongProgressionIterator(this.first, this.last, this.step, null);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder;
    long l;
    if (this.step > 0L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(ULong.toString-impl(this.first));
      localStringBuilder.append("..");
      localStringBuilder.append(ULong.toString-impl(this.last));
      localStringBuilder.append(" step ");
      l = this.step;
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(ULong.toString-impl(this.first));
      localStringBuilder.append(" downTo ");
      localStringBuilder.append(ULong.toString-impl(this.last));
      localStringBuilder.append(" step ");
      l = -this.step;
    }
    localStringBuilder.append(l);
    return localStringBuilder.toString();
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\"\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\t\n\002\b\003\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J(\020\003\032\0020\0042\006\020\005\032\0020\0062\006\020\007\032\0020\0062\006\020\b\032\0020\tø\001\000¢\006\004\b\n\020\013\002\004\n\002\b\031¨\006\f"}, d2={"Lkotlin/ranges/ULongProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/ULongProgression;", "rangeStart", "Lkotlin/ULong;", "rangeEnd", "step", "", "fromClosedRange-7ftBX0g", "(JJJ)Lkotlin/ranges/ULongProgression;", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
  public static final class Companion
  {
    public final ULongProgression fromClosedRange-7ftBX0g(long paramLong1, long paramLong2, long paramLong3)
    {
      return new ULongProgression(paramLong1, paramLong2, paramLong3, null);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\ranges\ULongProgression.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */