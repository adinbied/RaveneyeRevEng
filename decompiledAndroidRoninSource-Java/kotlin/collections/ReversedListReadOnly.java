package kotlin.collections;

import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000\034\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020 \n\002\b\002\n\002\020\b\n\002\b\006\b\022\030\000*\006\b\000\020\001 \0012\b\022\004\022\002H\0010\002B\023\022\f\020\003\032\b\022\004\022\0028\0000\004¢\006\002\020\005J\026\020\n\032\0028\0002\006\020\013\032\0020\007H\002¢\006\002\020\fR\024\020\003\032\b\022\004\022\0028\0000\004X\004¢\006\002\n\000R\024\020\006\032\0020\0078VX\004¢\006\006\032\004\b\b\020\t¨\006\r"}, d2={"Lkotlin/collections/ReversedListReadOnly;", "T", "Lkotlin/collections/AbstractList;", "delegate", "", "(Ljava/util/List;)V", "size", "", "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
class ReversedListReadOnly<T>
  extends AbstractList<T>
{
  private final List<T> delegate;
  
  public ReversedListReadOnly(List<? extends T> paramList)
  {
    this.delegate = paramList;
  }
  
  public T get(int paramInt)
  {
    return (T)this.delegate.get(CollectionsKt__ReversedViewsKt.access$reverseElementIndex(this, paramInt));
  }
  
  public int getSize()
  {
    return this.delegate.size();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\collections\ReversedListReadOnly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */