package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000\026\n\002\030\002\n\002\b\002\n\002\020\000\n\002\b\004\n\002\020(\n\000\bg\030\000*\004\b\000\020\001*\006\b\001\020\002 \0012\0020\003J\025\020\004\032\0028\0012\006\020\005\032\0028\000H&¢\006\002\020\006J\016\020\007\032\b\022\004\022\0028\0000\bH&¨\006\t"}, d2={"Lkotlin/collections/Grouping;", "T", "K", "", "keyOf", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "sourceIterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public abstract interface Grouping<T, K>
{
  public abstract K keyOf(T paramT);
  
  public abstract Iterator<T> sourceIterator();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\collections\Grouping.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */