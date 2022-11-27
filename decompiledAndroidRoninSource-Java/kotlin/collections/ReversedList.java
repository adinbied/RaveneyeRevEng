package kotlin.collections;

import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000$\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020!\n\002\b\002\n\002\020\b\n\002\b\003\n\002\020\002\n\002\b\n\b\002\030\000*\004\b\000\020\0012\b\022\004\022\002H\0010\002B\023\022\f\020\003\032\b\022\004\022\0028\0000\004¢\006\002\020\005J\035\020\n\032\0020\0132\006\020\f\032\0020\0072\006\020\r\032\0028\000H\026¢\006\002\020\016J\b\020\017\032\0020\013H\026J\026\020\020\032\0028\0002\006\020\f\032\0020\007H\002¢\006\002\020\021J\025\020\022\032\0028\0002\006\020\f\032\0020\007H\026¢\006\002\020\021J\036\020\023\032\0028\0002\006\020\f\032\0020\0072\006\020\r\032\0028\000H\002¢\006\002\020\024R\024\020\003\032\b\022\004\022\0028\0000\004X\004¢\006\002\n\000R\024\020\006\032\0020\0078VX\004¢\006\006\032\004\b\b\020\t¨\006\025"}, d2={"Lkotlin/collections/ReversedList;", "T", "Lkotlin/collections/AbstractMutableList;", "delegate", "", "(Ljava/util/List;)V", "size", "", "getSize", "()I", "add", "", "index", "element", "(ILjava/lang/Object;)V", "clear", "get", "(I)Ljava/lang/Object;", "removeAt", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
final class ReversedList<T>
  extends AbstractMutableList<T>
{
  private final List<T> delegate;
  
  public ReversedList(List<T> paramList)
  {
    this.delegate = paramList;
  }
  
  public void add(int paramInt, T paramT)
  {
    this.delegate.add(CollectionsKt__ReversedViewsKt.access$reversePositionIndex(this, paramInt), paramT);
  }
  
  public void clear()
  {
    this.delegate.clear();
  }
  
  public T get(int paramInt)
  {
    return (T)this.delegate.get(CollectionsKt__ReversedViewsKt.access$reverseElementIndex(this, paramInt));
  }
  
  public int getSize()
  {
    return this.delegate.size();
  }
  
  public T removeAt(int paramInt)
  {
    return (T)this.delegate.remove(CollectionsKt__ReversedViewsKt.access$reverseElementIndex(this, paramInt));
  }
  
  public T set(int paramInt, T paramT)
  {
    return (T)this.delegate.set(CollectionsKt__ReversedViewsKt.access$reverseElementIndex(this, paramInt), paramT);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\collections\ReversedList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */