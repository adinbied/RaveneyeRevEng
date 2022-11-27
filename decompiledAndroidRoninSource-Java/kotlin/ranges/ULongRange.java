package kotlin.ranges;

import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UnsignedKt;

@Metadata(bv={1, 0, 3}, d1={"\0002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\007\n\002\020\013\n\002\b\005\n\002\020\000\n\000\n\002\020\b\n\002\b\002\n\002\020\016\n\002\b\002\b\007\030\000 \0272\0020\0012\b\022\004\022\0020\0030\002:\001\027B\030\022\006\020\004\032\0020\003\022\006\020\005\032\0020\003ø\001\000¢\006\002\020\006J\033\020\n\032\0020\0132\006\020\f\032\0020\003H\002ø\001\000¢\006\004\b\r\020\016J\023\020\017\032\0020\0132\b\020\020\032\004\030\0010\021H\002J\b\020\022\032\0020\023H\026J\b\020\024\032\0020\013H\026J\b\020\025\032\0020\026H\026R\027\020\005\032\0020\0038VX\004ø\001\000¢\006\006\032\004\b\007\020\bR\027\020\004\032\0020\0038VX\004ø\001\000¢\006\006\032\004\b\t\020\bø\001\000\002\004\n\002\b\031¨\006\030"}, d2={"Lkotlin/ranges/ULongRange;", "Lkotlin/ranges/ULongProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/ULong;", "start", "endInclusive", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEndInclusive", "()Lkotlin/ULong;", "getStart", "contains", "", "value", "contains-VKZWuLQ", "(J)Z", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class ULongRange
  extends ULongProgression
  implements ClosedRange<ULong>
{
  public static final Companion Companion = new Companion(null);
  private static final ULongRange EMPTY = new ULongRange(-1L, 0L, null);
  
  private ULongRange(long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2, 1L, null);
  }
  
  public boolean contains-VKZWuLQ(long paramLong)
  {
    return (UnsignedKt.ulongCompare(getFirst(), paramLong) <= 0) && (UnsignedKt.ulongCompare(paramLong, getLast()) <= 0);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof ULongRange)) {
      if ((!isEmpty()) || (!((ULongRange)paramObject).isEmpty()))
      {
        long l = getFirst();
        paramObject = (ULongRange)paramObject;
        if ((l != ((ULongRange)paramObject).getFirst()) || (getLast() != ((ULongRange)paramObject).getLast())) {}
      }
      else
      {
        return true;
      }
    }
    return false;
  }
  
  public ULong getEndInclusive()
  {
    return ULong.box-impl(getLast());
  }
  
  public ULong getStart()
  {
    return ULong.box-impl(getFirst());
  }
  
  public int hashCode()
  {
    if (isEmpty()) {
      return -1;
    }
    int i = (int)ULong.constructor-impl(getFirst() ^ ULong.constructor-impl(getFirst() >>> 32));
    return (int)ULong.constructor-impl(getLast() ^ ULong.constructor-impl(getLast() >>> 32)) + i * 31;
  }
  
  public boolean isEmpty()
  {
    return UnsignedKt.ulongCompare(getFirst(), getLast()) > 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ULong.toString-impl(getFirst()));
    localStringBuilder.append("..");
    localStringBuilder.append(ULong.toString-impl(getLast()));
    return localStringBuilder.toString();
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\024\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\003\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006¨\006\007"}, d2={"Lkotlin/ranges/ULongRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/ULongRange;", "getEMPTY", "()Lkotlin/ranges/ULongRange;", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
  public static final class Companion
  {
    public final ULongRange getEMPTY()
    {
      return ULongRange.access$getEMPTY$cp();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\ranges\ULongRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */