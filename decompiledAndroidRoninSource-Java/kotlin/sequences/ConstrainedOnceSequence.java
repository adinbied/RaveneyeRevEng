package kotlin.sequences;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000\034\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\020(\n\000\b\000\030\000*\004\b\000\020\0012\b\022\004\022\002H\0010\002B\023\022\f\020\003\032\b\022\004\022\0028\0000\002¢\006\002\020\004J\017\020\b\032\b\022\004\022\0028\0000\tH\002R(\020\005\032\034\022\030\022\026\022\004\022\0028\000 \007*\n\022\004\022\0028\000\030\0010\0020\0020\006X\004¢\006\002\n\000¨\006\n"}, d2={"Lkotlin/sequences/ConstrainedOnceSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "(Lkotlin/sequences/Sequence;)V", "sequenceRef", "Ljava/util/concurrent/atomic/AtomicReference;", "kotlin.jvm.PlatformType", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class ConstrainedOnceSequence<T>
  implements Sequence<T>
{
  private final AtomicReference<Sequence<T>> sequenceRef;
  
  public ConstrainedOnceSequence(Sequence<? extends T> paramSequence)
  {
    this.sequenceRef = new AtomicReference(paramSequence);
  }
  
  public Iterator<T> iterator()
  {
    Sequence localSequence = (Sequence)this.sequenceRef.getAndSet(null);
    if (localSequence != null) {
      return localSequence.iterator();
    }
    throw ((Throwable)new IllegalStateException("This sequence can be consumed only once."));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\sequences\ConstrainedOnceSequence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */