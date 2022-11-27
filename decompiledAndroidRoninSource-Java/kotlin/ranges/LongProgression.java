package kotlin.ranges;

import kotlin.Metadata;
import kotlin.collections.LongIterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv={1, 0, 3}, d1={"\0002\n\002\030\002\n\002\020\034\n\002\020\t\n\002\b\013\n\002\020\013\n\000\n\002\020\000\n\000\n\002\020\b\n\002\b\002\n\002\030\002\n\000\n\002\020\016\n\002\b\002\b\026\030\000 \0302\b\022\004\022\0020\0020\001:\001\030B\037\b\000\022\006\020\003\032\0020\002\022\006\020\004\032\0020\002\022\006\020\005\032\0020\002¢\006\002\020\006J\023\020\r\032\0020\0162\b\020\017\032\004\030\0010\020H\002J\b\020\021\032\0020\022H\026J\b\020\023\032\0020\016H\026J\t\020\024\032\0020\025H\002J\b\020\026\032\0020\027H\026R\021\020\007\032\0020\002¢\006\b\n\000\032\004\b\b\020\tR\021\020\n\032\0020\002¢\006\b\n\000\032\004\b\013\020\tR\021\020\005\032\0020\002¢\006\b\n\000\032\004\b\f\020\t¨\006\031"}, d2={"Lkotlin/ranges/LongProgression;", "", "", "start", "endInclusive", "step", "(JJJ)V", "first", "getFirst", "()J", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "", "isEmpty", "iterator", "Lkotlin/collections/LongIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public class LongProgression
  implements Iterable<Long>, KMappedMarker
{
  public static final Companion Companion = new Companion(null);
  private final long first;
  private final long last;
  private final long step;
  
  public LongProgression(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong3 != 0L)
    {
      if (paramLong3 != Long.MIN_VALUE)
      {
        this.first = paramLong1;
        this.last = ProgressionUtilKt.getProgressionLastElement(paramLong1, paramLong2, paramLong3);
        this.step = paramLong3;
        return;
      }
      throw ((Throwable)new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation."));
    }
    throw ((Throwable)new IllegalArgumentException("Step must be non-zero."));
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof LongProgression)) {
      if ((!isEmpty()) || (!((LongProgression)paramObject).isEmpty()))
      {
        long l = this.first;
        paramObject = (LongProgression)paramObject;
        if ((l != ((LongProgression)paramObject).first) || (this.last != ((LongProgression)paramObject).last) || (this.step != ((LongProgression)paramObject).step)) {}
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
    long l1 = 31;
    long l2 = this.first;
    long l3 = this.last;
    long l4 = this.step;
    return (int)(l1 * ((l2 ^ l2 >>> 32) * l1 + (l3 ^ l3 >>> 32)) + (l4 ^ l4 >>> 32));
  }
  
  public boolean isEmpty()
  {
    long l1 = this.step;
    long l2 = this.first;
    long l3 = this.last;
    if (l1 > 0L)
    {
      if (l2 > l3) {
        return true;
      }
    }
    else if (l2 < l3) {
      return true;
    }
    return false;
  }
  
  public LongIterator iterator()
  {
    return (LongIterator)new LongProgressionIterator(this.first, this.last, this.step);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder;
    long l;
    if (this.step > 0L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.first);
      localStringBuilder.append("..");
      localStringBuilder.append(this.last);
      localStringBuilder.append(" step ");
      l = this.step;
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.first);
      localStringBuilder.append(" downTo ");
      localStringBuilder.append(this.last);
      localStringBuilder.append(" step ");
      l = -this.step;
    }
    localStringBuilder.append(l);
    return localStringBuilder.toString();
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\032\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\020\t\n\002\b\003\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\036\020\003\032\0020\0042\006\020\005\032\0020\0062\006\020\007\032\0020\0062\006\020\b\032\0020\006¨\006\t"}, d2={"Lkotlin/ranges/LongProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/LongProgression;", "rangeStart", "", "rangeEnd", "step", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
  public static final class Companion
  {
    public final LongProgression fromClosedRange(long paramLong1, long paramLong2, long paramLong3)
    {
      return new LongProgression(paramLong1, paramLong2, paramLong3);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\ranges\LongProgression.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */