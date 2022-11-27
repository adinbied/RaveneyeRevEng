package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv={1, 0, 3}, d1={"\000L\n\002\030\002\n\002\020\"\n\002\020\001\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\t\n\000\n\002\020\b\n\002\b\003\n\002\020\013\n\002\b\003\n\002\020\036\n\002\b\002\n\002\020\000\n\002\b\003\n\002\020(\n\002\b\002\n\002\020\016\n\000\bÀ\002\030\0002\b\022\004\022\0020\0020\0012\0060\003j\002`\004B\007\b\002¢\006\002\020\005J\021\020\f\032\0020\r2\006\020\016\032\0020\002H\002J\026\020\017\032\0020\r2\f\020\020\032\b\022\004\022\0020\0020\021H\026J\023\020\022\032\0020\r2\b\020\023\032\004\030\0010\024H\002J\b\020\025\032\0020\tH\026J\b\020\026\032\0020\rH\026J\017\020\027\032\b\022\004\022\0020\0020\030H\002J\b\020\031\032\0020\024H\002J\b\020\032\032\0020\033H\026R\016\020\006\032\0020\007XT¢\006\002\n\000R\024\020\b\032\0020\t8VX\004¢\006\006\032\004\b\n\020\013¨\006\034"}, d2={"Lkotlin/collections/EmptySet;", "", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "serialVersionUID", "", "size", "", "getSize", "()I", "contains", "", "element", "containsAll", "elements", "", "equals", "other", "", "hashCode", "isEmpty", "iterator", "", "readResolve", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class EmptySet
  implements Set, Serializable, KMappedMarker
{
  public static final EmptySet INSTANCE = new EmptySet();
  private static final long serialVersionUID = 3406603774387020532L;
  
  private final Object readResolve()
  {
    return INSTANCE;
  }
  
  public boolean add(Void paramVoid)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean addAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean contains(Void paramVoid)
  {
    Intrinsics.checkParameterIsNotNull(paramVoid, "element");
    return false;
  }
  
  public boolean containsAll(Collection paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    return paramCollection.isEmpty();
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof Set)) && (((Set)paramObject).isEmpty());
  }
  
  public int getSize()
  {
    return 0;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public Iterator iterator()
  {
    return (Iterator)EmptyIterator.INSTANCE;
  }
  
  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean removeAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean retainAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public Object[] toArray()
  {
    return CollectionToArray.toArray(this);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return CollectionToArray.toArray(this, paramArrayOfT);
  }
  
  public String toString()
  {
    return "[]";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\collections\EmptySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */