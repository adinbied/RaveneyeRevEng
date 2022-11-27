package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={"\000\036\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020(\n\000\b\000\030\000*\004\b\000\020\001*\004\b\001\020\0022\b\022\004\022\002H\0010\003B'\022\f\020\004\032\b\022\004\022\0028\0000\003\022\022\020\005\032\016\022\004\022\0028\000\022\004\022\0028\0010\006¢\006\002\020\007J\017\020\b\032\b\022\004\022\0028\0000\tH\002R\032\020\005\032\016\022\004\022\0028\000\022\004\022\0028\0010\006X\004¢\006\002\n\000R\024\020\004\032\b\022\004\022\0028\0000\003X\004¢\006\002\n\000¨\006\n"}, d2={"Lkotlin/sequences/DistinctSequence;", "T", "K", "Lkotlin/sequences/Sequence;", "source", "keySelector", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class DistinctSequence<T, K>
  implements Sequence<T>
{
  private final Function1<T, K> keySelector;
  private final Sequence<T> source;
  
  public DistinctSequence(Sequence<? extends T> paramSequence, Function1<? super T, ? extends K> paramFunction1)
  {
    this.source = paramSequence;
    this.keySelector = paramFunction1;
  }
  
  public Iterator<T> iterator()
  {
    return (Iterator)new DistinctIterator(this.source.iterator(), this.keySelector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\sequences\DistinctSequence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */