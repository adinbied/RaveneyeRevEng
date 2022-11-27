package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.collections.ULongIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv={1, 0, 3}, d1={"\000F\n\002\030\002\n\002\020\036\n\002\030\002\n\000\n\002\020\b\n\002\b\003\n\002\020\026\n\002\b\006\n\002\020\013\n\002\b\t\n\002\020\000\n\002\b\t\n\002\030\002\n\002\b\003\n\002\020\002\n\002\b\004\n\002\020\016\n\002\b\002\b@\030\0002\b\022\004\022\0020\0020\001:\001-B\024\b\026\022\006\020\003\032\0020\004ø\001\000¢\006\004\b\005\020\006B\024\b\001\022\006\020\007\032\0020\bø\001\000¢\006\004\b\005\020\tJ\033\020\016\032\0020\0172\006\020\020\032\0020\002H\002ø\001\000¢\006\004\b\021\020\022J \020\023\032\0020\0172\f\020\024\032\b\022\004\022\0020\0020\001H\026ø\001\000¢\006\004\b\025\020\026J\023\020\027\032\0020\0172\b\020\030\032\004\030\0010\031HÖ\003J\033\020\032\032\0020\0022\006\020\033\032\0020\004H\002ø\001\000¢\006\004\b\034\020\035J\t\020\036\032\0020\004HÖ\001J\017\020\037\032\0020\017H\026¢\006\004\b \020!J\020\020\"\032\0020#H\002¢\006\004\b$\020%J#\020&\032\0020'2\006\020\033\032\0020\0042\006\020(\032\0020\002H\002ø\001\000¢\006\004\b)\020*J\t\020+\032\0020,HÖ\001R\024\020\003\032\0020\0048VX\004¢\006\006\032\004\b\n\020\013R\026\020\007\032\0020\b8\000X\004¢\006\b\n\000\022\004\b\f\020\rø\001\000\002\004\n\002\b\031¨\006."}, d2={"Lkotlin/ULongArray;", "", "Lkotlin/ULong;", "size", "", "constructor-impl", "(I)[J", "storage", "", "([J)[J", "getSize-impl", "([J)I", "storage$annotations", "()V", "contains", "", "element", "contains-VKZWuLQ", "([JJ)Z", "containsAll", "elements", "containsAll-impl", "([JLjava/util/Collection;)Z", "equals", "other", "", "get", "index", "get-impl", "([JI)J", "hashCode", "isEmpty", "isEmpty-impl", "([J)Z", "iterator", "Lkotlin/collections/ULongIterator;", "iterator-impl", "([J)Lkotlin/collections/ULongIterator;", "set", "", "value", "set-k8EXiF4", "([JIJ)V", "toString", "", "Iterator", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class ULongArray
  implements Collection<ULong>, KMappedMarker
{
  private final long[] storage;
  
  public static long[] constructor-impl(int paramInt)
  {
    return constructor-impl(new long[paramInt]);
  }
  
  public static long[] constructor-impl(long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "storage");
    return paramArrayOfLong;
  }
  
  public static boolean contains-VKZWuLQ(long[] paramArrayOfLong, long paramLong)
  {
    return ArraysKt.contains(paramArrayOfLong, paramLong);
  }
  
  public static boolean containsAll-impl(long[] paramArrayOfLong, Collection<ULong> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    paramCollection = (Iterable)paramCollection;
    if (((Collection)paramCollection).isEmpty()) {}
    int i;
    do
    {
      while (!paramCollection.hasNext())
      {
        return true;
        paramCollection = paramCollection.iterator();
      }
      Object localObject = paramCollection.next();
      if (((localObject instanceof ULong)) && (ArraysKt.contains(paramArrayOfLong, ((ULong)localObject).unbox-impl()))) {
        i = 1;
      } else {
        i = 0;
      }
    } while (i != 0);
    return false;
  }
  
  public static boolean equals-impl(long[] paramArrayOfLong, Object paramObject)
  {
    return ((paramObject instanceof ULongArray)) && (Intrinsics.areEqual(paramArrayOfLong, ((ULongArray)paramObject).unbox-impl()));
  }
  
  public static final boolean equals-impl0(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong1, "p1");
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong2, "p2");
    throw null;
  }
  
  public static final long get-impl(long[] paramArrayOfLong, int paramInt)
  {
    return ULong.constructor-impl(paramArrayOfLong[paramInt]);
  }
  
  public static int getSize-impl(long[] paramArrayOfLong)
  {
    return paramArrayOfLong.length;
  }
  
  public static int hashCode-impl(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong != null) {
      return Arrays.hashCode(paramArrayOfLong);
    }
    return 0;
  }
  
  public static boolean isEmpty-impl(long[] paramArrayOfLong)
  {
    return paramArrayOfLong.length == 0;
  }
  
  public static ULongIterator iterator-impl(long[] paramArrayOfLong)
  {
    return (ULongIterator)new Iterator(paramArrayOfLong);
  }
  
  public static final void set-k8EXiF4(long[] paramArrayOfLong, int paramInt, long paramLong)
  {
    paramArrayOfLong[paramInt] = paramLong;
  }
  
  public static String toString-impl(long[] paramArrayOfLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ULongArray(storage=");
    localStringBuilder.append(Arrays.toString(paramArrayOfLong));
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public boolean add-VKZWuLQ(long paramLong)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean addAll(Collection<? extends ULong> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean contains-VKZWuLQ(long paramLong)
  {
    return contains-VKZWuLQ(this.storage, paramLong);
  }
  
  public boolean containsAll(Collection<? extends Object> paramCollection)
  {
    return containsAll-impl(this.storage, paramCollection);
  }
  
  public boolean equals(Object paramObject)
  {
    return equals-impl(this.storage, paramObject);
  }
  
  public int getSize()
  {
    return getSize-impl(this.storage);
  }
  
  public int hashCode()
  {
    return hashCode-impl(this.storage);
  }
  
  public boolean isEmpty()
  {
    return isEmpty-impl(this.storage);
  }
  
  public ULongIterator iterator()
  {
    return iterator-impl(this.storage);
  }
  
  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean removeAll(Collection<? extends Object> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean retainAll(Collection<? extends Object> paramCollection)
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
    return toString-impl(this.storage);
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000&\n\002\030\002\n\002\030\002\n\000\n\002\020\026\n\002\b\002\n\002\020\b\n\000\n\002\020\013\n\000\n\002\030\002\n\002\b\002\b\002\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\t\020\007\032\0020\bH\002J\020\020\t\032\0020\nH\026ø\001\000¢\006\002\020\013R\016\020\002\032\0020\003X\004¢\006\002\n\000R\016\020\005\032\0020\006X\016¢\006\002\n\000\002\004\n\002\b\031¨\006\f"}, d2={"Lkotlin/ULongArray$Iterator;", "Lkotlin/collections/ULongIterator;", "array", "", "([J)V", "index", "", "hasNext", "", "nextULong", "Lkotlin/ULong;", "()J", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
  private static final class Iterator
    extends ULongIterator
  {
    private final long[] array;
    private int index;
    
    public Iterator(long[] paramArrayOfLong)
    {
      this.array = paramArrayOfLong;
    }
    
    public boolean hasNext()
    {
      return this.index < this.array.length;
    }
    
    public long nextULong()
    {
      int i = this.index;
      long[] arrayOfLong = this.array;
      if (i < arrayOfLong.length)
      {
        this.index = (i + 1);
        return ULong.constructor-impl(arrayOfLong[i]);
      }
      throw ((Throwable)new NoSuchElementException(String.valueOf(this.index)));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\ULongArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */