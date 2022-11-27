package kotlin.collections;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\0000\n\000\n\002\020\"\n\002\b\002\n\002\030\002\n\002\030\002\n\000\n\002\020\021\n\002\b\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020#\n\002\b\005\032\022\020\000\032\b\022\004\022\002H\0020\001\"\004\b\000\020\002\032\037\020\003\032\022\022\004\022\002H\0020\004j\b\022\004\022\002H\002`\005\"\004\b\000\020\002H\b\0325\020\003\032\022\022\004\022\002H\0020\004j\b\022\004\022\002H\002`\005\"\004\b\000\020\0022\022\020\006\032\n\022\006\b\001\022\002H\0020\007\"\002H\002¢\006\002\020\b\032\037\020\t\032\022\022\004\022\002H\0020\nj\b\022\004\022\002H\002`\013\"\004\b\000\020\002H\b\0325\020\t\032\022\022\004\022\002H\0020\nj\b\022\004\022\002H\002`\013\"\004\b\000\020\0022\022\020\006\032\n\022\006\b\001\022\002H\0020\007\"\002H\002¢\006\002\020\f\032\025\020\r\032\b\022\004\022\002H\0020\016\"\004\b\000\020\002H\b\032+\020\r\032\b\022\004\022\002H\0020\016\"\004\b\000\020\0022\022\020\006\032\n\022\006\b\001\022\002H\0020\007\"\002H\002¢\006\002\020\017\032\025\020\020\032\b\022\004\022\002H\0020\001\"\004\b\000\020\002H\b\032+\020\020\032\b\022\004\022\002H\0020\001\"\004\b\000\020\0022\022\020\006\032\n\022\006\b\001\022\002H\0020\007\"\002H\002¢\006\002\020\017\032\036\020\021\032\b\022\004\022\002H\0020\001\"\004\b\000\020\002*\b\022\004\022\002H\0020\001H\000\032!\020\022\032\b\022\004\022\002H\0020\001\"\004\b\000\020\002*\n\022\004\022\002H\002\030\0010\001H\b¨\006\023"}, d2={"emptySet", "", "T", "hashSetOf", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "elements", "", "([Ljava/lang/Object;)Ljava/util/HashSet;", "linkedSetOf", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "([Ljava/lang/Object;)Ljava/util/LinkedHashSet;", "mutableSetOf", "", "([Ljava/lang/Object;)Ljava/util/Set;", "setOf", "optimizeReadOnlySet", "orEmpty", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/collections/SetsKt")
class SetsKt__SetsKt
  extends SetsKt__SetsJVMKt
{
  public static final <T> Set<T> emptySet()
  {
    return (Set)EmptySet.INSTANCE;
  }
  
  private static final <T> HashSet<T> hashSetOf()
  {
    return new HashSet();
  }
  
  public static final <T> HashSet<T> hashSetOf(T... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "elements");
    return (HashSet)ArraysKt.toCollection(paramVarArgs, (Collection)new HashSet(MapsKt.mapCapacity(paramVarArgs.length)));
  }
  
  private static final <T> LinkedHashSet<T> linkedSetOf()
  {
    return new LinkedHashSet();
  }
  
  public static final <T> LinkedHashSet<T> linkedSetOf(T... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "elements");
    return (LinkedHashSet)ArraysKt.toCollection(paramVarArgs, (Collection)new LinkedHashSet(MapsKt.mapCapacity(paramVarArgs.length)));
  }
  
  private static final <T> Set<T> mutableSetOf()
  {
    return (Set)new LinkedHashSet();
  }
  
  public static final <T> Set<T> mutableSetOf(T... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "elements");
    return (Set)ArraysKt.toCollection(paramVarArgs, (Collection)new LinkedHashSet(MapsKt.mapCapacity(paramVarArgs.length)));
  }
  
  public static final <T> Set<T> optimizeReadOnlySet(Set<? extends T> paramSet)
  {
    Intrinsics.checkParameterIsNotNull(paramSet, "$this$optimizeReadOnlySet");
    int i = paramSet.size();
    if (i != 0)
    {
      if (i != 1) {
        return paramSet;
      }
      return SetsKt.setOf(paramSet.iterator().next());
    }
    return SetsKt.emptySet();
  }
  
  private static final <T> Set<T> orEmpty(Set<? extends T> paramSet)
  {
    if (paramSet != null) {
      return paramSet;
    }
    return SetsKt.emptySet();
  }
  
  private static final <T> Set<T> setOf()
  {
    return SetsKt.emptySet();
  }
  
  public static final <T> Set<T> setOf(T... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "elements");
    if (paramVarArgs.length > 0) {
      return ArraysKt.toSet(paramVarArgs);
    }
    return SetsKt.emptySet();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\collections\SetsKt__SetsKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */