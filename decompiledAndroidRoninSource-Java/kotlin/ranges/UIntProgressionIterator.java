package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.UnsignedKt;
import kotlin.collections.UIntIterator;

@Metadata(bv={1, 0, 3}, d1={"\000\"\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\004\n\002\020\013\n\002\b\004\b\003\030\0002\0020\001B \022\006\020\002\032\0020\003\022\006\020\004\032\0020\003\022\006\020\005\032\0020\006ø\001\000¢\006\002\020\007J\t\020\n\032\0020\013H\002J\020\020\r\032\0020\003H\026ø\001\000¢\006\002\020\016R\023\020\b\032\0020\003X\004ø\001\000¢\006\004\n\002\020\tR\016\020\n\032\0020\013X\016¢\006\002\n\000R\023\020\f\032\0020\003X\016ø\001\000¢\006\004\n\002\020\tR\023\020\005\032\0020\003X\004ø\001\000¢\006\004\n\002\020\t\002\004\n\002\b\031¨\006\017"}, d2={"Lkotlin/ranges/UIntProgressionIterator;", "Lkotlin/collections/UIntIterator;", "first", "Lkotlin/UInt;", "last", "step", "", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "finalElement", "I", "hasNext", "", "next", "nextUInt", "()I", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
final class UIntProgressionIterator
  extends UIntIterator
{
  private final int finalElement;
  private boolean hasNext;
  private int next;
  private final int step;
  
  private UIntProgressionIterator(int paramInt1, int paramInt2, int paramInt3)
  {
    this.finalElement = paramInt2;
    boolean bool = true;
    paramInt2 = UnsignedKt.uintCompare(paramInt1, paramInt2);
    if (paramInt3 > 0 ? paramInt2 > 0 : paramInt2 < 0) {
      bool = false;
    }
    this.hasNext = bool;
    this.step = UInt.constructor-impl(paramInt3);
    if (!this.hasNext) {
      paramInt1 = this.finalElement;
    }
    this.next = paramInt1;
  }
  
  public boolean hasNext()
  {
    return this.hasNext;
  }
  
  public int nextUInt()
  {
    int i = this.next;
    if (i == this.finalElement)
    {
      if (this.hasNext)
      {
        this.hasNext = false;
        return i;
      }
      throw ((Throwable)new NoSuchElementException());
    }
    this.next = UInt.constructor-impl(this.step + i);
    return i;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\ranges\UIntProgressionIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */