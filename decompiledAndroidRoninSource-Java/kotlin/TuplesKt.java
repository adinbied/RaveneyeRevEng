package kotlin;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000\026\n\000\n\002\030\002\n\002\b\005\n\002\020 \n\000\n\002\030\002\n\000\0322\020\000\032\016\022\004\022\002H\002\022\004\022\002H\0030\001\"\004\b\000\020\002\"\004\b\001\020\003*\002H\0022\006\020\004\032\002H\003H\004¢\006\002\020\005\032\"\020\006\032\b\022\004\022\002H\b0\007\"\004\b\000\020\b*\016\022\004\022\002H\b\022\004\022\002H\b0\001\032(\020\006\032\b\022\004\022\002H\b0\007\"\004\b\000\020\b*\024\022\004\022\002H\b\022\004\022\002H\b\022\004\022\002H\b0\t¨\006\n"}, d2={"to", "Lkotlin/Pair;", "A", "B", "that", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;", "toList", "", "T", "Lkotlin/Triple;", "kotlin-stdlib"}, k=2, mv={1, 1, 15})
public final class TuplesKt
{
  public static final <A, B> Pair<A, B> to(A paramA, B paramB)
  {
    return new Pair(paramA, paramB);
  }
  
  public static final <T> List<T> toList(Pair<? extends T, ? extends T> paramPair)
  {
    Intrinsics.checkParameterIsNotNull(paramPair, "$this$toList");
    return CollectionsKt.listOf(new Object[] { paramPair.getFirst(), paramPair.getSecond() });
  }
  
  public static final <T> List<T> toList(Triple<? extends T, ? extends T, ? extends T> paramTriple)
  {
    Intrinsics.checkParameterIsNotNull(paramTriple, "$this$toList");
    return CollectionsKt.listOf(new Object[] { paramTriple.getFirst(), paramTriple.getSecond(), paramTriple.getThird() });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\TuplesKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */