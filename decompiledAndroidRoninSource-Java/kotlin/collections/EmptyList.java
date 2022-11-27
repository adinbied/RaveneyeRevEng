package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv={1, 0, 3}, d1={"\000\\\n\002\030\002\n\002\020 \n\002\020\001\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\t\n\000\n\002\020\b\n\002\b\003\n\002\020\013\n\002\b\003\n\002\020\036\n\002\b\002\n\002\020\000\n\002\b\006\n\002\020(\n\002\b\002\n\002\020*\n\002\b\005\n\002\020\016\n\000\bÀ\002\030\0002\b\022\004\022\0020\0020\0012\0060\003j\002`\0042\0060\005j\002`\006B\007\b\002¢\006\002\020\007J\021\020\016\032\0020\0172\006\020\020\032\0020\002H\002J\026\020\021\032\0020\0172\f\020\022\032\b\022\004\022\0020\0020\023H\026J\023\020\024\032\0020\0172\b\020\025\032\004\030\0010\026H\002J\021\020\027\032\0020\0022\006\020\030\032\0020\013H\002J\b\020\031\032\0020\013H\026J\020\020\032\032\0020\0132\006\020\020\032\0020\002H\026J\b\020\033\032\0020\017H\026J\017\020\034\032\b\022\004\022\0020\0020\035H\002J\020\020\036\032\0020\0132\006\020\020\032\0020\002H\026J\016\020\037\032\b\022\004\022\0020\0020 H\026J\026\020\037\032\b\022\004\022\0020\0020 2\006\020\030\032\0020\013H\026J\b\020!\032\0020\026H\002J\036\020\"\032\b\022\004\022\0020\0020\0012\006\020#\032\0020\0132\006\020$\032\0020\013H\026J\b\020%\032\0020&H\026R\016\020\b\032\0020\tXT¢\006\002\n\000R\024\020\n\032\0020\0138VX\004¢\006\006\032\004\b\f\020\r¨\006'"}, d2={"Lkotlin/collections/EmptyList;", "", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "()V", "serialVersionUID", "", "size", "", "getSize", "()I", "contains", "", "element", "containsAll", "elements", "", "equals", "other", "", "get", "index", "hashCode", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "readResolve", "subList", "fromIndex", "toIndex", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class EmptyList
  implements List, Serializable, RandomAccess, KMappedMarker
{
  public static final EmptyList INSTANCE = new EmptyList();
  private static final long serialVersionUID = -7390468764508069838L;
  
  private final Object readResolve()
  {
    return INSTANCE;
  }
  
  public void add(int paramInt, Void paramVoid)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean add(Void paramVoid)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean addAll(int paramInt, Collection paramCollection)
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
    return ((paramObject instanceof List)) && (((List)paramObject).isEmpty());
  }
  
  public Void get(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Empty list doesn't contain element at index ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append('.');
    throw ((Throwable)new IndexOutOfBoundsException(localStringBuilder.toString()));
  }
  
  public int getSize()
  {
    return 0;
  }
  
  public int hashCode()
  {
    return 1;
  }
  
  public int indexOf(Void paramVoid)
  {
    Intrinsics.checkParameterIsNotNull(paramVoid, "element");
    return -1;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public Iterator iterator()
  {
    return (Iterator)EmptyIterator.INSTANCE;
  }
  
  public int lastIndexOf(Void paramVoid)
  {
    Intrinsics.checkParameterIsNotNull(paramVoid, "element");
    return -1;
  }
  
  public ListIterator listIterator()
  {
    return (ListIterator)EmptyIterator.INSTANCE;
  }
  
  public ListIterator listIterator(int paramInt)
  {
    if (paramInt == 0) {
      return (ListIterator)EmptyIterator.INSTANCE;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Index: ");
    localStringBuilder.append(paramInt);
    throw ((Throwable)new IndexOutOfBoundsException(localStringBuilder.toString()));
  }
  
  public Void remove(int paramInt)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
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
  
  public Void set(int paramInt, Void paramVoid)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public List subList(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return (List)this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fromIndex: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", toIndex: ");
    localStringBuilder.append(paramInt2);
    throw ((Throwable)new IndexOutOfBoundsException(localStringBuilder.toString()));
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\collections\EmptyList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */