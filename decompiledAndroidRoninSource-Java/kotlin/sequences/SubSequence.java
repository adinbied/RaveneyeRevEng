package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv={1, 0, 3}, d1={"\000\"\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\b\n\002\020(\n\002\b\002\b\000\030\000*\004\b\000\020\0012\b\022\004\022\002H\0010\0022\b\022\004\022\002H\0010\003B#\022\f\020\004\032\b\022\004\022\0028\0000\002\022\006\020\005\032\0020\006\022\006\020\007\032\0020\006¢\006\002\020\bJ\026\020\f\032\b\022\004\022\0028\0000\0022\006\020\r\032\0020\006H\026J\017\020\016\032\b\022\004\022\0028\0000\017H\002J\026\020\020\032\b\022\004\022\0028\0000\0022\006\020\r\032\0020\006H\026R\024\020\t\032\0020\0068BX\004¢\006\006\032\004\b\n\020\013R\016\020\007\032\0020\006X\004¢\006\002\n\000R\024\020\004\032\b\022\004\022\0028\0000\002X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000¨\006\021"}, d2={"Lkotlin/sequences/SubSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "startIndex", "", "endIndex", "(Lkotlin/sequences/Sequence;II)V", "count", "getCount", "()I", "drop", "n", "iterator", "", "take", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class SubSequence<T>
  implements Sequence<T>, DropTakeSequence<T>
{
  private final int endIndex;
  private final Sequence<T> sequence;
  private final int startIndex;
  
  public SubSequence(Sequence<? extends T> paramSequence, int paramInt1, int paramInt2)
  {
    this.sequence = paramSequence;
    this.startIndex = paramInt1;
    this.endIndex = paramInt2;
    paramInt2 = 1;
    if (paramInt1 >= 0) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 != 0)
    {
      if (this.endIndex >= 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      if (paramInt1 != 0)
      {
        if (this.endIndex >= this.startIndex) {
          paramInt1 = paramInt2;
        } else {
          paramInt1 = 0;
        }
        if (paramInt1 != 0) {
          return;
        }
        paramSequence = new StringBuilder();
        paramSequence.append("endIndex should be not less than startIndex, but was ");
        paramSequence.append(this.endIndex);
        paramSequence.append(" < ");
        paramSequence.append(this.startIndex);
        throw ((Throwable)new IllegalArgumentException(paramSequence.toString().toString()));
      }
      paramSequence = new StringBuilder();
      paramSequence.append("endIndex should be non-negative, but is ");
      paramSequence.append(this.endIndex);
      throw ((Throwable)new IllegalArgumentException(paramSequence.toString().toString()));
    }
    paramSequence = new StringBuilder();
    paramSequence.append("startIndex should be non-negative, but is ");
    paramSequence.append(this.startIndex);
    throw ((Throwable)new IllegalArgumentException(paramSequence.toString().toString()));
  }
  
  private final int getCount()
  {
    return this.endIndex - this.startIndex;
  }
  
  public Sequence<T> drop(int paramInt)
  {
    if (paramInt >= getCount()) {
      return SequencesKt.emptySequence();
    }
    return (Sequence)new SubSequence(this.sequence, this.startIndex + paramInt, this.endIndex);
  }
  
  public Iterator<T> iterator()
  {
    (Iterator)new Iterator()
    {
      private final Iterator<T> iterator;
      private int position;
      
      private final void drop()
      {
        while ((this.position < SubSequence.access$getStartIndex$p(this.this$0)) && (this.iterator.hasNext()))
        {
          this.iterator.next();
          this.position += 1;
        }
      }
      
      public final Iterator<T> getIterator()
      {
        return this.iterator;
      }
      
      public final int getPosition()
      {
        return this.position;
      }
      
      public boolean hasNext()
      {
        drop();
        return (this.position < SubSequence.access$getEndIndex$p(this.this$0)) && (this.iterator.hasNext());
      }
      
      public T next()
      {
        drop();
        if (this.position < SubSequence.access$getEndIndex$p(this.this$0))
        {
          this.position += 1;
          return (T)this.iterator.next();
        }
        throw ((Throwable)new NoSuchElementException());
      }
      
      public void remove()
      {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
      }
      
      public final void setPosition(int paramAnonymousInt)
      {
        this.position = paramAnonymousInt;
      }
    };
  }
  
  public Sequence<T> take(int paramInt)
  {
    if (paramInt >= getCount()) {
      return (Sequence)this;
    }
    Sequence localSequence = this.sequence;
    int i = this.startIndex;
    return (Sequence)new SubSequence(localSequence, i, paramInt + i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\sequences\SubSequence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */