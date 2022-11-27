package kotlin.sequences;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={"\0000\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\037\n\002\b\003\n\002\030\002\n\000\n\002\020\017\n\000\n\002\030\002\n\002\030\002\n\000\032(\020\000\032\b\022\004\022\002H\0020\001\"\004\b\000\020\002*\006\022\002\b\0030\0012\f\020\003\032\b\022\004\022\002H\0020\004\032A\020\005\032\002H\006\"\020\b\000\020\006*\n\022\006\b\000\022\002H\0020\007\"\004\b\001\020\002*\006\022\002\b\0030\0012\006\020\b\032\002H\0062\f\020\003\032\b\022\004\022\002H\0020\004¢\006\002\020\t\032&\020\n\032\b\022\004\022\002H\f0\013\"\016\b\000\020\f*\b\022\004\022\002H\f0\r*\b\022\004\022\002H\f0\001\0328\020\n\032\b\022\004\022\002H\f0\013\"\004\b\000\020\f*\b\022\004\022\002H\f0\0012\032\020\016\032\026\022\006\b\000\022\002H\f0\017j\n\022\006\b\000\022\002H\f`\020¨\006\021"}, d2={"filterIsInstance", "Lkotlin/sequences/Sequence;", "R", "klass", "Ljava/lang/Class;", "filterIsInstanceTo", "C", "", "destination", "(Lkotlin/sequences/Sequence;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "toSortedSet", "Ljava/util/SortedSet;", "T", "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/sequences/SequencesKt")
class SequencesKt___SequencesJvmKt
  extends SequencesKt__SequencesKt
{
  public static final <R> Sequence<R> filterIsInstance(Sequence<?> paramSequence, Class<R> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$filterIsInstance");
    Intrinsics.checkParameterIsNotNull(paramClass, "klass");
    paramSequence = SequencesKt.filter(paramSequence, (Function1)new Lambda(paramClass)
    {
      public final boolean invoke(Object paramAnonymousObject)
      {
        return this.$klass.isInstance(paramAnonymousObject);
      }
    });
    if (paramSequence != null) {
      return paramSequence;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
  }
  
  public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(Sequence<?> paramSequence, C paramC, Class<R> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$filterIsInstanceTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramClass, "klass");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (paramClass.isInstance(localObject)) {
        paramC.add(localObject);
      }
    }
    return paramC;
  }
  
  public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$toSortedSet");
    return (SortedSet)SequencesKt.toCollection(paramSequence, (Collection)new TreeSet());
  }
  
  public static final <T> SortedSet<T> toSortedSet(Sequence<? extends T> paramSequence, Comparator<? super T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$toSortedSet");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    return (SortedSet)SequencesKt.toCollection(paramSequence, (Collection)new TreeSet(paramComparator));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\sequences\SequencesKt___SequencesJvmKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */