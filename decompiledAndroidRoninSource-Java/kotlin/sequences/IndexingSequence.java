package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv={1, 0, 3}, d1={"\000\030\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020(\n\000\b\000\030\000*\004\b\000\020\0012\016\022\n\022\b\022\004\022\002H\0010\0030\002B\023\022\f\020\004\032\b\022\004\022\0028\0000\002¢\006\002\020\005J\025\020\006\032\016\022\n\022\b\022\004\022\0028\0000\0030\007H\002R\024\020\004\032\b\022\004\022\0028\0000\002X\004¢\006\002\n\000¨\006\b"}, d2={"Lkotlin/sequences/IndexingSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/collections/IndexedValue;", "sequence", "(Lkotlin/sequences/Sequence;)V", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class IndexingSequence<T>
  implements Sequence<IndexedValue<? extends T>>
{
  private final Sequence<T> sequence;
  
  public IndexingSequence(Sequence<? extends T> paramSequence)
  {
    this.sequence = paramSequence;
  }
  
  public Iterator<IndexedValue<T>> iterator()
  {
    (Iterator)new Iterator()
    {
      private int index;
      private final Iterator<T> iterator;
      
      public final int getIndex()
      {
        return this.index;
      }
      
      public final Iterator<T> getIterator()
      {
        return this.iterator;
      }
      
      public boolean hasNext()
      {
        return this.iterator.hasNext();
      }
      
      public IndexedValue<T> next()
      {
        int i = this.index;
        this.index = (i + 1);
        if (i < 0) {
          CollectionsKt.throwIndexOverflow();
        }
        return new IndexedValue(i, this.iterator.next());
      }
      
      public void remove()
      {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
      }
      
      public final void setIndex(int paramAnonymousInt)
      {
        this.index = paramAnonymousInt;
      }
    };
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\sequences\IndexingSequence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */