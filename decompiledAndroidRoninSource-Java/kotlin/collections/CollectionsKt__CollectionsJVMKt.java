package kotlin.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\0002\n\000\n\002\020\b\n\002\b\004\n\002\020\021\n\002\020\000\n\000\n\002\020\036\n\002\b\005\n\002\020 \n\002\b\004\n\002\020\013\n\002\b\002\n\002\030\002\n\000\032\021\020\000\032\0020\0012\006\020\002\032\0020\001H\b\032\021\020\003\032\0020\0012\006\020\004\032\0020\001H\b\032\"\020\005\032\n\022\006\022\004\030\0010\0070\0062\n\020\b\032\006\022\002\b\0030\tH\b¢\006\002\020\n\0324\020\005\032\b\022\004\022\002H\0130\006\"\004\b\000\020\0132\n\020\b\032\006\022\002\b\0030\t2\f\020\f\032\b\022\004\022\002H\0130\006H\b¢\006\002\020\r\032\037\020\016\032\b\022\004\022\002H\0130\017\"\004\b\000\020\0132\006\020\020\032\002H\013¢\006\002\020\021\0321\020\022\032\f\022\b\b\001\022\004\030\0010\0070\006\"\004\b\000\020\013*\n\022\006\b\001\022\002H\0130\0062\006\020\023\032\0020\024H\000¢\006\002\020\025\032\037\020\026\032\b\022\004\022\002H\0130\017\"\004\b\000\020\013*\b\022\004\022\002H\0130\027H\b¨\006\030"}, d2={"checkCountOverflow", "", "count", "checkIndexOverflow", "index", "copyToArrayImpl", "", "", "collection", "", "(Ljava/util/Collection;)[Ljava/lang/Object;", "T", "array", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "listOf", "", "element", "(Ljava/lang/Object;)Ljava/util/List;", "copyToArrayOfAny", "isVarargs", "", "([Ljava/lang/Object;Z)[Ljava/lang/Object;", "toList", "Ljava/util/Enumeration;", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/collections/CollectionsKt")
class CollectionsKt__CollectionsJVMKt
{
  private static final int checkCountOverflow(int paramInt)
  {
    if (paramInt < 0)
    {
      if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0))
      {
        CollectionsKt.throwCountOverflow();
        return paramInt;
      }
      throw ((Throwable)new ArithmeticException("Count overflow has happened."));
    }
    return paramInt;
  }
  
  private static final int checkIndexOverflow(int paramInt)
  {
    if (paramInt < 0)
    {
      if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0))
      {
        CollectionsKt.throwIndexOverflow();
        return paramInt;
      }
      throw ((Throwable)new ArithmeticException("Index overflow has happened."));
    }
    return paramInt;
  }
  
  private static final Object[] copyToArrayImpl(Collection<?> paramCollection)
  {
    return CollectionToArray.toArray(paramCollection);
  }
  
  private static final <T> T[] copyToArrayImpl(Collection<?> paramCollection, T[] paramArrayOfT)
  {
    if (paramArrayOfT != null)
    {
      paramCollection = CollectionToArray.toArray(paramCollection, paramArrayOfT);
      if (paramCollection != null) {
        return paramCollection;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
  }
  
  public static final <T> Object[] copyToArrayOfAny(T[] paramArrayOfT, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$copyToArrayOfAny");
    if ((paramBoolean) && (Intrinsics.areEqual(paramArrayOfT.getClass(), Object[].class))) {
      return paramArrayOfT;
    }
    paramArrayOfT = Arrays.copyOf(paramArrayOfT, paramArrayOfT.length, Object[].class);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfT, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
    return paramArrayOfT;
  }
  
  public static final <T> List<T> listOf(T paramT)
  {
    paramT = Collections.singletonList(paramT);
    Intrinsics.checkExpressionValueIsNotNull(paramT, "java.util.Collections.singletonList(element)");
    return paramT;
  }
  
  private static final <T> List<T> toList(Enumeration<T> paramEnumeration)
  {
    paramEnumeration = Collections.list(paramEnumeration);
    Intrinsics.checkExpressionValueIsNotNull(paramEnumeration, "java.util.Collections.list(this)");
    return (List)paramEnumeration;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\collections\CollectionsKt__CollectionsJVMKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */