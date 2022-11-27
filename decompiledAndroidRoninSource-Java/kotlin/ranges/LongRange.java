package kotlin.ranges;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\0002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\020\t\n\002\b\007\n\002\020\013\n\002\b\003\n\002\020\000\n\000\n\002\020\b\n\002\b\002\n\002\020\016\n\002\b\002\030\000 \0252\0020\0012\b\022\004\022\0020\0030\002:\001\025B\025\022\006\020\004\032\0020\003\022\006\020\005\032\0020\003¢\006\002\020\006J\021\020\n\032\0020\0132\006\020\f\032\0020\003H\002J\023\020\r\032\0020\0132\b\020\016\032\004\030\0010\017H\002J\b\020\020\032\0020\021H\026J\b\020\022\032\0020\013H\026J\b\020\023\032\0020\024H\026R\024\020\005\032\0020\0038VX\004¢\006\006\032\004\b\007\020\bR\024\020\004\032\0020\0038VX\004¢\006\006\032\004\b\t\020\b¨\006\026"}, d2={"Lkotlin/ranges/LongRange;", "Lkotlin/ranges/LongProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(JJ)V", "getEndInclusive", "()Ljava/lang/Long;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class LongRange
  extends LongProgression
  implements ClosedRange<Long>
{
  public static final Companion Companion = new Companion(null);
  private static final LongRange EMPTY = new LongRange(1L, 0L);
  
  public LongRange(long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2, 1L);
  }
  
  public boolean contains(long paramLong)
  {
    return (getFirst() <= paramLong) && (paramLong <= getLast());
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof LongRange)) {
      if ((!isEmpty()) || (!((LongRange)paramObject).isEmpty()))
      {
        long l = getFirst();
        paramObject = (LongRange)paramObject;
        if ((l != ((LongRange)paramObject).getFirst()) || (getLast() != ((LongRange)paramObject).getLast())) {}
      }
      else
      {
        return true;
      }
    }
    return false;
  }
  
  public Long getEndInclusive()
  {
    return Long.valueOf(getLast());
  }
  
  public Long getStart()
  {
    return Long.valueOf(getFirst());
  }
  
  public int hashCode()
  {
    if (isEmpty()) {
      return -1;
    }
    return (int)(31 * (getFirst() ^ getFirst() >>> 32) + (getLast() ^ getLast() >>> 32));
  }
  
  public boolean isEmpty()
  {
    return getFirst() > getLast();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getFirst());
    localStringBuilder.append("..");
    localStringBuilder.append(getLast());
    return localStringBuilder.toString();
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\024\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\003\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006¨\006\007"}, d2={"Lkotlin/ranges/LongRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/LongRange;", "getEMPTY", "()Lkotlin/ranges/LongRange;", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
  public static final class Companion
  {
    public final LongRange getEMPTY()
    {
      return LongRange.access$getEMPTY$cp();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\ranges\LongRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */