package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv={1, 0, 3}, d1={"\000\036\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\020(\n\000\b\000\030\000*\004\b\000\020\001*\004\b\001\020\002*\004\b\002\020\0032\b\022\004\022\002H\0030\004B;\022\f\020\005\032\b\022\004\022\0028\0000\004\022\f\020\006\032\b\022\004\022\0028\0010\004\022\030\020\007\032\024\022\004\022\0028\000\022\004\022\0028\001\022\004\022\0028\0020\b¢\006\002\020\tJ\017\020\n\032\b\022\004\022\0028\0020\013H\002R\024\020\005\032\b\022\004\022\0028\0000\004X\004¢\006\002\n\000R\024\020\006\032\b\022\004\022\0028\0010\004X\004¢\006\002\n\000R \020\007\032\024\022\004\022\0028\000\022\004\022\0028\001\022\004\022\0028\0020\bX\004¢\006\002\n\000¨\006\f"}, d2={"Lkotlin/sequences/MergingSequence;", "T1", "T2", "V", "Lkotlin/sequences/Sequence;", "sequence1", "sequence2", "transform", "Lkotlin/Function2;", "(Lkotlin/sequences/Sequence;Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class MergingSequence<T1, T2, V>
  implements Sequence<V>
{
  private final Sequence<T1> sequence1;
  private final Sequence<T2> sequence2;
  private final Function2<T1, T2, V> transform;
  
  public MergingSequence(Sequence<? extends T1> paramSequence, Sequence<? extends T2> paramSequence1, Function2<? super T1, ? super T2, ? extends V> paramFunction2)
  {
    this.sequence1 = paramSequence;
    this.sequence2 = paramSequence1;
    this.transform = paramFunction2;
  }
  
  public Iterator<V> iterator()
  {
    (Iterator)new Iterator()
    {
      private final Iterator<T1> iterator1;
      private final Iterator<T2> iterator2;
      
      public final Iterator<T1> getIterator1()
      {
        return this.iterator1;
      }
      
      public final Iterator<T2> getIterator2()
      {
        return this.iterator2;
      }
      
      public boolean hasNext()
      {
        return (this.iterator1.hasNext()) && (this.iterator2.hasNext());
      }
      
      public V next()
      {
        return (V)MergingSequence.access$getTransform$p(this.this$0).invoke(this.iterator1.next(), this.iterator2.next());
      }
      
      public void remove()
      {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
      }
    };
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\sequences\MergingSequence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */