package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.IntIterator;

@Metadata(bv={1, 0, 3}, d1={"\000\032\n\002\030\002\n\002\030\002\n\000\n\002\020\b\n\002\b\005\n\002\020\013\n\002\b\005\b\000\030\0002\0020\001B\035\022\006\020\002\032\0020\003\022\006\020\004\032\0020\003\022\006\020\005\032\0020\003¢\006\002\020\006J\t\020\b\032\0020\tH\002J\b\020\r\032\0020\003H\026R\016\020\007\032\0020\003X\004¢\006\002\n\000R\016\020\b\032\0020\tX\016¢\006\002\n\000R\016\020\n\032\0020\003X\016¢\006\002\n\000R\021\020\005\032\0020\003¢\006\b\n\000\032\004\b\013\020\f¨\006\016"}, d2={"Lkotlin/ranges/IntProgressionIterator;", "Lkotlin/collections/IntIterator;", "first", "", "last", "step", "(III)V", "finalElement", "hasNext", "", "next", "getStep", "()I", "nextInt", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class IntProgressionIterator
  extends IntIterator
{
  private final int finalElement;
  private boolean hasNext;
  private int next;
  private final int step;
  
  public IntProgressionIterator(int paramInt1, int paramInt2, int paramInt3)
  {
    this.step = paramInt3;
    this.finalElement = paramInt2;
    boolean bool = true;
    if (paramInt3 > 0 ? paramInt1 > paramInt2 : paramInt1 < paramInt2) {
      bool = false;
    }
    this.hasNext = bool;
    if (!bool) {
      paramInt1 = this.finalElement;
    }
    this.next = paramInt1;
  }
  
  public final int getStep()
  {
    return this.step;
  }
  
  public boolean hasNext()
  {
    return this.hasNext;
  }
  
  public int nextInt()
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
    this.next = (this.step + i);
    return i;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\ranges\IntProgressionIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */