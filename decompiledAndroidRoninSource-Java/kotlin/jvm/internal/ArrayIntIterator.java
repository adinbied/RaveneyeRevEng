package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.IntIterator;

@Metadata(bv={1, 0, 3}, d1={"\000 \n\002\030\002\n\002\030\002\n\000\n\002\020\025\n\002\b\002\n\002\020\b\n\000\n\002\020\013\n\002\b\002\b\002\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\t\020\007\032\0020\bH\002J\b\020\t\032\0020\006H\026R\016\020\002\032\0020\003X\004¢\006\002\n\000R\016\020\005\032\0020\006X\016¢\006\002\n\000¨\006\n"}, d2={"Lkotlin/jvm/internal/ArrayIntIterator;", "Lkotlin/collections/IntIterator;", "array", "", "([I)V", "index", "", "hasNext", "", "nextInt", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
final class ArrayIntIterator
  extends IntIterator
{
  private final int[] array;
  private int index;
  
  public ArrayIntIterator(int[] paramArrayOfInt)
  {
    this.array = paramArrayOfInt;
  }
  
  public boolean hasNext()
  {
    return this.index < this.array.length;
  }
  
  public int nextInt()
  {
    try
    {
      int[] arrayOfInt = this.array;
      int i = this.index;
      this.index = (i + 1);
      i = arrayOfInt[i];
      return i;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      this.index -= 1;
      throw ((Throwable)new NoSuchElementException(localArrayIndexOutOfBoundsException.getMessage()));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\jvm\internal\ArrayIntIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */