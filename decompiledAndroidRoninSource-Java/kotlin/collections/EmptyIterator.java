package kotlin.collections;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv={1, 0, 3}, d1={"\000 \n\002\030\002\n\002\020*\n\002\020\001\n\002\b\002\n\002\020\013\n\002\b\003\n\002\020\b\n\002\b\003\bÀ\002\030\0002\b\022\004\022\0020\0020\001B\007\b\002¢\006\002\020\003J\t\020\004\032\0020\005H\002J\b\020\006\032\0020\005H\026J\t\020\007\032\0020\002H\002J\b\020\b\032\0020\tH\026J\b\020\n\032\0020\002H\026J\b\020\013\032\0020\tH\026¨\006\f"}, d2={"Lkotlin/collections/EmptyIterator;", "", "", "()V", "hasNext", "", "hasPrevious", "next", "nextIndex", "", "previous", "previousIndex", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class EmptyIterator
  implements ListIterator, KMappedMarker
{
  public static final EmptyIterator INSTANCE = new EmptyIterator();
  
  public void add(Void paramVoid)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean hasNext()
  {
    return false;
  }
  
  public boolean hasPrevious()
  {
    return false;
  }
  
  public Void next()
  {
    throw ((Throwable)new NoSuchElementException());
  }
  
  public int nextIndex()
  {
    return 0;
  }
  
  public Void previous()
  {
    throw ((Throwable)new NoSuchElementException());
  }
  
  public int previousIndex()
  {
    return -1;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void set(Void paramVoid)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\collections\EmptyIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */