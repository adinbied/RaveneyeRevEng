package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000>\n\000\n\002\020 \n\000\n\002\020\034\n\000\n\002\030\002\n\002\b\002\n\002\020\037\n\002\b\003\n\002\020\002\n\000\n\002\020!\n\000\n\002\030\002\n\002\020\017\n\000\n\002\030\002\n\002\030\002\n\000\032(\020\000\032\b\022\004\022\002H\0020\001\"\004\b\000\020\002*\006\022\002\b\0030\0032\f\020\004\032\b\022\004\022\002H\0020\005\032A\020\006\032\002H\007\"\020\b\000\020\007*\n\022\006\b\000\022\002H\0020\b\"\004\b\001\020\002*\006\022\002\b\0030\0032\006\020\t\032\002H\0072\f\020\004\032\b\022\004\022\002H\0020\005¢\006\002\020\n\032\026\020\013\032\0020\f\"\004\b\000\020\r*\b\022\004\022\002H\r0\016\032&\020\017\032\b\022\004\022\002H\r0\020\"\016\b\000\020\r*\b\022\004\022\002H\r0\021*\b\022\004\022\002H\r0\003\0328\020\017\032\b\022\004\022\002H\r0\020\"\004\b\000\020\r*\b\022\004\022\002H\r0\0032\032\020\022\032\026\022\006\b\000\022\002H\r0\023j\n\022\006\b\000\022\002H\r`\024¨\006\025"}, d2={"filterIsInstance", "", "R", "", "klass", "Ljava/lang/Class;", "filterIsInstanceTo", "C", "", "destination", "(Ljava/lang/Iterable;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "reverse", "", "T", "", "toSortedSet", "Ljava/util/SortedSet;", "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/collections/CollectionsKt")
class CollectionsKt___CollectionsJvmKt
  extends CollectionsKt__ReversedViewsKt
{
  public static final <R> List<R> filterIsInstance(Iterable<?> paramIterable, Class<R> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$filterIsInstance");
    Intrinsics.checkParameterIsNotNull(paramClass, "klass");
    return (List)CollectionsKt.filterIsInstanceTo(paramIterable, (Collection)new ArrayList(), paramClass);
  }
  
  public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(Iterable<?> paramIterable, C paramC, Class<R> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$filterIsInstanceTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramClass, "klass");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (paramClass.isInstance(localObject)) {
        paramC.add(localObject);
      }
    }
    return paramC;
  }
  
  public static final <T> void reverse(List<T> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$reverse");
    Collections.reverse(paramList);
  }
  
  public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$toSortedSet");
    return (SortedSet)CollectionsKt.toCollection(paramIterable, (Collection)new TreeSet());
  }
  
  public static final <T> SortedSet<T> toSortedSet(Iterable<? extends T> paramIterable, Comparator<? super T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$toSortedSet");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    return (SortedSet)CollectionsKt.toCollection(paramIterable, (Collection)new TreeSet(paramComparator));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\collections\CollectionsKt___CollectionsJvmKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */