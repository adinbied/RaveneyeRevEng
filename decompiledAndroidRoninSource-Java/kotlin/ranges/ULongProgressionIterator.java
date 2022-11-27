package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.collections.ULongIterator;

@Metadata(bv={1, 0, 3}, d1={"\000\"\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\t\n\002\b\004\n\002\020\013\n\002\b\004\b\003\030\0002\0020\001B \022\006\020\002\032\0020\003\022\006\020\004\032\0020\003\022\006\020\005\032\0020\006ø\001\000¢\006\002\020\007J\t\020\n\032\0020\013H\002J\020\020\r\032\0020\003H\026ø\001\000¢\006\002\020\016R\023\020\b\032\0020\003X\004ø\001\000¢\006\004\n\002\020\tR\016\020\n\032\0020\013X\016¢\006\002\n\000R\023\020\f\032\0020\003X\016ø\001\000¢\006\004\n\002\020\tR\023\020\005\032\0020\003X\004ø\001\000¢\006\004\n\002\020\t\002\004\n\002\b\031¨\006\017"}, d2={"Lkotlin/ranges/ULongProgressionIterator;", "Lkotlin/collections/ULongIterator;", "first", "Lkotlin/ULong;", "last", "step", "", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "finalElement", "J", "hasNext", "", "next", "nextULong", "()J", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
final class ULongProgressionIterator
  extends ULongIterator
{
  private final long finalElement;
  private boolean hasNext;
  private long next;
  private final long step;
  
  private ULongProgressionIterator(long paramLong1, long paramLong2, long paramLong3)
  {
    this.finalElement = paramLong2;
    boolean bool = true;
    int i = UnsignedKt.ulongCompare(paramLong1, paramLong2);
    if (paramLong3 > 0L ? i > 0 : i < 0) {
      bool = false;
    }
    this.hasNext = bool;
    this.step = ULong.constructor-impl(paramLong3);
    if (!this.hasNext) {
      paramLong1 = this.finalElement;
    }
    this.next = paramLong1;
  }
  
  public boolean hasNext()
  {
    return this.hasNext;
  }
  
  public long nextULong()
  {
    long l = this.next;
    if (l == this.finalElement)
    {
      if (this.hasNext)
      {
        this.hasNext = false;
        return l;
      }
      throw ((Throwable)new NoSuchElementException());
    }
    this.next = ULong.constructor-impl(this.step + l);
    return l;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\ranges\ULongProgressionIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */