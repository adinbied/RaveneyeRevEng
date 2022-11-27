package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.BooleanIterator;

@Metadata(bv={1, 0, 3}, d1={"\000 \n\002\030\002\n\002\030\002\n\000\n\002\020\030\n\002\b\002\n\002\020\b\n\000\n\002\020\013\n\002\b\002\b\002\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\t\020\007\032\0020\bH\002J\b\020\t\032\0020\bH\026R\016\020\002\032\0020\003X\004¢\006\002\n\000R\016\020\005\032\0020\006X\016¢\006\002\n\000¨\006\n"}, d2={"Lkotlin/jvm/internal/ArrayBooleanIterator;", "Lkotlin/collections/BooleanIterator;", "array", "", "([Z)V", "index", "", "hasNext", "", "nextBoolean", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
final class ArrayBooleanIterator
  extends BooleanIterator
{
  private final boolean[] array;
  private int index;
  
  public ArrayBooleanIterator(boolean[] paramArrayOfBoolean)
  {
    this.array = paramArrayOfBoolean;
  }
  
  public boolean hasNext()
  {
    return this.index < this.array.length;
  }
  
  public boolean nextBoolean()
  {
    try
    {
      boolean[] arrayOfBoolean = this.array;
      int i = this.index;
      this.index = (i + 1);
      int j = arrayOfBoolean[i];
      return j;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      this.index -= 1;
      throw ((Throwable)new NoSuchElementException(localArrayIndexOutOfBoundsException.getMessage()));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\jvm\internal\ArrayBooleanIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */