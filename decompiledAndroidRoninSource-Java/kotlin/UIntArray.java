package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.collections.UIntIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv={1, 0, 3}, d1={"\000F\n\002\030\002\n\002\020\036\n\002\030\002\n\000\n\002\020\b\n\002\b\003\n\002\020\025\n\002\b\006\n\002\020\013\n\002\b\t\n\002\020\000\n\002\b\t\n\002\030\002\n\002\b\003\n\002\020\002\n\002\b\004\n\002\020\016\n\002\b\002\b@\030\0002\b\022\004\022\0020\0020\001:\001-B\024\b\026\022\006\020\003\032\0020\004ø\001\000¢\006\004\b\005\020\006B\024\b\001\022\006\020\007\032\0020\bø\001\000¢\006\004\b\005\020\tJ\033\020\016\032\0020\0172\006\020\020\032\0020\002H\002ø\001\000¢\006\004\b\021\020\022J \020\023\032\0020\0172\f\020\024\032\b\022\004\022\0020\0020\001H\026ø\001\000¢\006\004\b\025\020\026J\023\020\027\032\0020\0172\b\020\030\032\004\030\0010\031HÖ\003J\033\020\032\032\0020\0022\006\020\033\032\0020\004H\002ø\001\000¢\006\004\b\034\020\035J\t\020\036\032\0020\004HÖ\001J\017\020\037\032\0020\017H\026¢\006\004\b \020!J\020\020\"\032\0020#H\002¢\006\004\b$\020%J#\020&\032\0020'2\006\020\033\032\0020\0042\006\020(\032\0020\002H\002ø\001\000¢\006\004\b)\020*J\t\020+\032\0020,HÖ\001R\024\020\003\032\0020\0048VX\004¢\006\006\032\004\b\n\020\013R\026\020\007\032\0020\b8\000X\004¢\006\b\n\000\022\004\b\f\020\rø\001\000\002\004\n\002\b\031¨\006."}, d2={"Lkotlin/UIntArray;", "", "Lkotlin/UInt;", "size", "", "constructor-impl", "(I)[I", "storage", "", "([I)[I", "getSize-impl", "([I)I", "storage$annotations", "()V", "contains", "", "element", "contains-WZ4Q5Ns", "([II)Z", "containsAll", "elements", "containsAll-impl", "([ILjava/util/Collection;)Z", "equals", "other", "", "get", "index", "get-impl", "([II)I", "hashCode", "isEmpty", "isEmpty-impl", "([I)Z", "iterator", "Lkotlin/collections/UIntIterator;", "iterator-impl", "([I)Lkotlin/collections/UIntIterator;", "set", "", "value", "set-VXSXFK8", "([III)V", "toString", "", "Iterator", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class UIntArray
  implements Collection<UInt>, KMappedMarker
{
  private final int[] storage;
  
  public static int[] constructor-impl(int paramInt)
  {
    return constructor-impl(new int[paramInt]);
  }
  
  public static int[] constructor-impl(int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "storage");
    return paramArrayOfInt;
  }
  
  public static boolean contains-WZ4Q5Ns(int[] paramArrayOfInt, int paramInt)
  {
    return ArraysKt.contains(paramArrayOfInt, paramInt);
  }
  
  public static boolean containsAll-impl(int[] paramArrayOfInt, Collection<UInt> paramCollection)
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
      if (((localObject instanceof UInt)) && (ArraysKt.contains(paramArrayOfInt, ((UInt)localObject).unbox-impl()))) {
        i = 1;
      } else {
        i = 0;
      }
    } while (i != 0);
    return false;
  }
  
  public static boolean equals-impl(int[] paramArrayOfInt, Object paramObject)
  {
    return ((paramObject instanceof UIntArray)) && (Intrinsics.areEqual(paramArrayOfInt, ((UIntArray)paramObject).unbox-impl()));
  }
  
  public static final boolean equals-impl0(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt1, "p1");
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt2, "p2");
    throw null;
  }
  
  public static final int get-impl(int[] paramArrayOfInt, int paramInt)
  {
    return UInt.constructor-impl(paramArrayOfInt[paramInt]);
  }
  
  public static int getSize-impl(int[] paramArrayOfInt)
  {
    return paramArrayOfInt.length;
  }
  
  public static int hashCode-impl(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null) {
      return Arrays.hashCode(paramArrayOfInt);
    }
    return 0;
  }
  
  public static boolean isEmpty-impl(int[] paramArrayOfInt)
  {
    return paramArrayOfInt.length == 0;
  }
  
  public static UIntIterator iterator-impl(int[] paramArrayOfInt)
  {
    return (UIntIterator)new Iterator(paramArrayOfInt);
  }
  
  public static final void set-VXSXFK8(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    paramArrayOfInt[paramInt1] = paramInt2;
  }
  
  public static String toString-impl(int[] paramArrayOfInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UIntArray(storage=");
    localStringBuilder.append(Arrays.toString(paramArrayOfInt));
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public boolean add-WZ4Q5Ns(int paramInt)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean addAll(Collection<? extends UInt> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean contains-WZ4Q5Ns(int paramInt)
  {
    return contains-WZ4Q5Ns(this.storage, paramInt);
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
  
  public UIntIterator iterator()
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
  
  @Metadata(bv={1, 0, 3}, d1={"\000&\n\002\030\002\n\002\030\002\n\000\n\002\020\025\n\002\b\002\n\002\020\b\n\000\n\002\020\013\n\000\n\002\030\002\n\002\b\002\b\002\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\t\020\007\032\0020\bH\002J\020\020\t\032\0020\nH\026ø\001\000¢\006\002\020\013R\016\020\002\032\0020\003X\004¢\006\002\n\000R\016\020\005\032\0020\006X\016¢\006\002\n\000\002\004\n\002\b\031¨\006\f"}, d2={"Lkotlin/UIntArray$Iterator;", "Lkotlin/collections/UIntIterator;", "array", "", "([I)V", "index", "", "hasNext", "", "nextUInt", "Lkotlin/UInt;", "()I", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
  private static final class Iterator
    extends UIntIterator
  {
    private final int[] array;
    private int index;
    
    public Iterator(int[] paramArrayOfInt)
    {
      this.array = paramArrayOfInt;
    }
    
    public boolean hasNext()
    {
      return this.index < this.array.length;
    }
    
    public int nextUInt()
    {
      int i = this.index;
      int[] arrayOfInt = this.array;
      if (i < arrayOfInt.length)
      {
        this.index = (i + 1);
        return UInt.constructor-impl(arrayOfInt[i]);
      }
      throw ((Throwable)new NoSuchElementException(String.valueOf(this.index)));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\UIntArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */