package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000\020\n\002\b\006\n\002\030\002\n\002\030\002\n\002\b\004\032G\020\000\032\002H\001\"\004\b\000\020\0012\006\020\002\032\002H\0012\006\020\003\032\002H\0012\006\020\004\032\002H\0012\032\020\005\032\026\022\006\b\000\022\002H\0010\006j\n\022\006\b\000\022\002H\001`\007H\007¢\006\002\020\b\032?\020\000\032\002H\001\"\004\b\000\020\0012\006\020\002\032\002H\0012\006\020\003\032\002H\0012\032\020\005\032\026\022\006\b\000\022\002H\0010\006j\n\022\006\b\000\022\002H\001`\007H\007¢\006\002\020\t\032G\020\n\032\002H\001\"\004\b\000\020\0012\006\020\002\032\002H\0012\006\020\003\032\002H\0012\006\020\004\032\002H\0012\032\020\005\032\026\022\006\b\000\022\002H\0010\006j\n\022\006\b\000\022\002H\001`\007H\007¢\006\002\020\b\032?\020\n\032\002H\001\"\004\b\000\020\0012\006\020\002\032\002H\0012\006\020\003\032\002H\0012\032\020\005\032\026\022\006\b\000\022\002H\0010\006j\n\022\006\b\000\022\002H\001`\007H\007¢\006\002\020\t¨\006\013"}, d2={"maxOf", "T", "a", "b", "c", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "minOf", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/comparisons/ComparisonsKt")
class ComparisonsKt___ComparisonsKt
  extends ComparisonsKt___ComparisonsJvmKt
{
  public static final <T> T maxOf(T paramT1, T paramT2, T paramT3, Comparator<? super T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    return (T)ComparisonsKt.maxOf(paramT1, ComparisonsKt.maxOf(paramT2, paramT3, paramComparator), paramComparator);
  }
  
  public static final <T> T maxOf(T paramT1, T paramT2, Comparator<? super T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (paramComparator.compare(paramT1, paramT2) >= 0) {
      return paramT1;
    }
    return paramT2;
  }
  
  public static final <T> T minOf(T paramT1, T paramT2, T paramT3, Comparator<? super T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    return (T)ComparisonsKt.minOf(paramT1, ComparisonsKt.minOf(paramT2, paramT3, paramComparator), paramComparator);
  }
  
  public static final <T> T minOf(T paramT1, T paramT2, Comparator<? super T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (paramComparator.compare(paramT1, paramT2) <= 0) {
      return paramT1;
    }
    return paramT2;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\comparisons\ComparisonsKt___ComparisonsKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */