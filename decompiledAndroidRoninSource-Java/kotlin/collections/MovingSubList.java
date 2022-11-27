package kotlin.collections;

import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000,\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020 \n\002\b\002\n\002\020\b\n\002\b\b\n\002\020\002\n\002\b\002\b\000\030\000*\006\b\000\020\001 \0012\b\022\004\022\002H\0010\0022\0060\003j\002`\004B\023\022\f\020\005\032\b\022\004\022\0028\0000\006¢\006\002\020\007J\026\020\016\032\0028\0002\006\020\017\032\0020\tH\002¢\006\002\020\020J\026\020\021\032\0020\0222\006\020\n\032\0020\t2\006\020\023\032\0020\tR\016\020\b\032\0020\tX\016¢\006\002\n\000R\016\020\n\032\0020\tX\016¢\006\002\n\000R\024\020\005\032\b\022\004\022\0028\0000\006X\004¢\006\002\n\000R\024\020\013\032\0020\t8VX\004¢\006\006\032\004\b\f\020\r¨\006\024"}, d2={"Lkotlin/collections/MovingSubList;", "E", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "list", "", "(Ljava/util/List;)V", "_size", "", "fromIndex", "size", "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "move", "", "toIndex", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class MovingSubList<E>
  extends AbstractList<E>
  implements RandomAccess
{
  private int _size;
  private int fromIndex;
  private final List<E> list;
  
  public MovingSubList(List<? extends E> paramList)
  {
    this.list = paramList;
  }
  
  public E get(int paramInt)
  {
    AbstractList.Companion.checkElementIndex$kotlin_stdlib(paramInt, this._size);
    return (E)this.list.get(this.fromIndex + paramInt);
  }
  
  public int getSize()
  {
    return this._size;
  }
  
  public final void move(int paramInt1, int paramInt2)
  {
    AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(paramInt1, paramInt2, this.list.size());
    this.fromIndex = paramInt1;
    this._size = (paramInt2 - paramInt1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\collections\MovingSubList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */