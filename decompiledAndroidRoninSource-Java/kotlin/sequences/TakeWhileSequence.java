package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv={1, 0, 3}, d1={"\000 \n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\020\013\n\002\b\002\n\002\020(\n\000\b\000\030\000*\004\b\000\020\0012\b\022\004\022\002H\0010\002B'\022\f\020\003\032\b\022\004\022\0028\0000\002\022\022\020\004\032\016\022\004\022\0028\000\022\004\022\0020\0060\005¢\006\002\020\007J\017\020\b\032\b\022\004\022\0028\0000\tH\002R\032\020\004\032\016\022\004\022\0028\000\022\004\022\0020\0060\005X\004¢\006\002\n\000R\024\020\003\032\b\022\004\022\0028\0000\002X\004¢\006\002\n\000¨\006\n"}, d2={"Lkotlin/sequences/TakeWhileSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "predicate", "Lkotlin/Function1;", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class TakeWhileSequence<T>
  implements Sequence<T>
{
  private final Function1<T, Boolean> predicate;
  private final Sequence<T> sequence;
  
  public TakeWhileSequence(Sequence<? extends T> paramSequence, Function1<? super T, Boolean> paramFunction1)
  {
    this.sequence = paramSequence;
    this.predicate = paramFunction1;
  }
  
  public Iterator<T> iterator()
  {
    (Iterator)new Iterator()
    {
      private final Iterator<T> iterator;
      private T nextItem;
      private int nextState;
      
      private final void calcNext()
      {
        if (this.iterator.hasNext())
        {
          Object localObject = this.iterator.next();
          if (((Boolean)TakeWhileSequence.access$getPredicate$p(this.this$0).invoke(localObject)).booleanValue())
          {
            this.nextState = 1;
            this.nextItem = localObject;
            return;
          }
        }
        this.nextState = 0;
      }
      
      public final Iterator<T> getIterator()
      {
        return this.iterator;
      }
      
      public final T getNextItem()
      {
        return (T)this.nextItem;
      }
      
      public final int getNextState()
      {
        return this.nextState;
      }
      
      public boolean hasNext()
      {
        if (this.nextState == -1) {
          calcNext();
        }
        return this.nextState == 1;
      }
      
      public T next()
      {
        if (this.nextState == -1) {
          calcNext();
        }
        if (this.nextState != 0)
        {
          Object localObject = this.nextItem;
          this.nextItem = null;
          this.nextState = -1;
          return (T)localObject;
        }
        throw ((Throwable)new NoSuchElementException());
      }
      
      public void remove()
      {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
      }
      
      public final void setNextItem(T paramAnonymousT)
      {
        this.nextItem = paramAnonymousT;
      }
      
      public final void setNextState(int paramAnonymousInt)
      {
        this.nextState = paramAnonymousInt;
      }
    };
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\sequences\TakeWhileSequence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */