package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000<\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\020\017\n\000\n\002\020\021\n\002\b\005\n\002\020\b\n\002\b\013\n\002\020\000\n\002\b\b\n\002\030\002\n\002\030\002\n\002\b\003\032;\020\000\032\022\022\004\022\002H\0020\001j\b\022\004\022\002H\002`\003\"\004\b\000\020\0022\032\b\004\020\004\032\024\022\004\022\002H\002\022\n\022\b\022\002\b\003\030\0010\0060\005H\b\032Y\020\000\032\022\022\004\022\002H\0020\001j\b\022\004\022\002H\002`\003\"\004\b\000\020\00226\020\007\032\034\022\030\b\001\022\024\022\004\022\002H\002\022\n\022\b\022\002\b\003\030\0010\0060\0050\b\"\024\022\004\022\002H\002\022\n\022\b\022\002\b\003\030\0010\0060\005¢\006\002\020\t\032W\020\000\032\022\022\004\022\002H\0020\001j\b\022\004\022\002H\002`\003\"\004\b\000\020\002\"\004\b\001\020\n2\032\020\013\032\026\022\006\b\000\022\002H\n0\001j\n\022\006\b\000\022\002H\n`\0032\024\b\004\020\004\032\016\022\004\022\002H\002\022\004\022\002H\n0\005H\b\032;\020\f\032\022\022\004\022\002H\0020\001j\b\022\004\022\002H\002`\003\"\004\b\000\020\0022\032\b\004\020\004\032\024\022\004\022\002H\002\022\n\022\b\022\002\b\003\030\0010\0060\005H\b\032W\020\f\032\022\022\004\022\002H\0020\001j\b\022\004\022\002H\002`\003\"\004\b\000\020\002\"\004\b\001\020\n2\032\020\013\032\026\022\006\b\000\022\002H\n0\001j\n\022\006\b\000\022\002H\n`\0032\024\b\004\020\004\032\016\022\004\022\002H\002\022\004\022\002H\n0\005H\b\032-\020\r\032\0020\016\"\f\b\000\020\002*\006\022\002\b\0030\0062\b\020\017\032\004\030\001H\0022\b\020\020\032\004\030\001H\002¢\006\002\020\021\032>\020\022\032\0020\016\"\004\b\000\020\0022\006\020\017\032\002H\0022\006\020\020\032\002H\0022\030\020\004\032\024\022\004\022\002H\002\022\n\022\b\022\002\b\003\030\0010\0060\005H\b¢\006\002\020\023\032Y\020\022\032\0020\016\"\004\b\000\020\0022\006\020\017\032\002H\0022\006\020\020\032\002H\00226\020\007\032\034\022\030\b\001\022\024\022\004\022\002H\002\022\n\022\b\022\002\b\003\030\0010\0060\0050\b\"\024\022\004\022\002H\002\022\n\022\b\022\002\b\003\030\0010\0060\005¢\006\002\020\024\032Z\020\022\032\0020\016\"\004\b\000\020\002\"\004\b\001\020\n2\006\020\017\032\002H\0022\006\020\020\032\002H\0022\032\020\013\032\026\022\006\b\000\022\002H\n0\001j\n\022\006\b\000\022\002H\n`\0032\022\020\004\032\016\022\004\022\002H\002\022\004\022\002H\n0\005H\b¢\006\002\020\025\032G\020\026\032\0020\016\"\004\b\000\020\0022\006\020\017\032\002H\0022\006\020\020\032\002H\0022 \020\007\032\034\022\030\b\001\022\024\022\004\022\002H\002\022\n\022\b\022\002\b\003\030\0010\0060\0050\bH\002¢\006\004\b\027\020\024\032&\020\030\032\022\022\004\022\002H\0020\001j\b\022\004\022\002H\002`\003\"\016\b\000\020\002*\b\022\004\022\002H\0020\006\032-\020\031\032\026\022\006\022\004\030\001H\0020\001j\n\022\006\022\004\030\001H\002`\003\"\016\b\000\020\002*\b\022\004\022\002H\0020\006H\b\032@\020\031\032\026\022\006\022\004\030\001H\0020\001j\n\022\006\022\004\030\001H\002`\003\"\b\b\000\020\002*\0020\0322\032\020\013\032\026\022\006\b\000\022\002H\0020\001j\n\022\006\b\000\022\002H\002`\003\032-\020\033\032\026\022\006\022\004\030\001H\0020\001j\n\022\006\022\004\030\001H\002`\003\"\016\b\000\020\002*\b\022\004\022\002H\0020\006H\b\032@\020\033\032\026\022\006\022\004\030\001H\0020\001j\n\022\006\022\004\030\001H\002`\003\"\b\b\000\020\002*\0020\0322\032\020\013\032\026\022\006\b\000\022\002H\0020\001j\n\022\006\b\000\022\002H\002`\003\032&\020\034\032\022\022\004\022\002H\0020\001j\b\022\004\022\002H\002`\003\"\016\b\000\020\002*\b\022\004\022\002H\0020\006\0320\020\035\032\022\022\004\022\002H\0020\001j\b\022\004\022\002H\002`\003\"\004\b\000\020\002*\022\022\004\022\002H\0020\001j\b\022\004\022\002H\002`\003\032O\020\036\032\022\022\004\022\002H\0020\001j\b\022\004\022\002H\002`\003\"\004\b\000\020\002*\022\022\004\022\002H\0020\001j\b\022\004\022\002H\002`\0032\032\020\013\032\026\022\006\b\000\022\002H\0020\001j\n\022\006\b\000\022\002H\002`\003H\004\032O\020\037\032\022\022\004\022\002H\0020\001j\b\022\004\022\002H\002`\003\"\004\b\000\020\002*\022\022\004\022\002H\0020\001j\b\022\004\022\002H\002`\0032\032\b\004\020\004\032\024\022\004\022\002H\002\022\n\022\b\022\002\b\003\030\0010\0060\005H\b\032k\020\037\032\022\022\004\022\002H\0020\001j\b\022\004\022\002H\002`\003\"\004\b\000\020\002\"\004\b\001\020\n*\022\022\004\022\002H\0020\001j\b\022\004\022\002H\002`\0032\032\020\013\032\026\022\006\b\000\022\002H\n0\001j\n\022\006\b\000\022\002H\n`\0032\024\b\004\020\004\032\016\022\004\022\002H\002\022\004\022\002H\n0\005H\b\032O\020 \032\022\022\004\022\002H\0020\001j\b\022\004\022\002H\002`\003\"\004\b\000\020\002*\022\022\004\022\002H\0020\001j\b\022\004\022\002H\002`\0032\032\b\004\020\004\032\024\022\004\022\002H\002\022\n\022\b\022\002\b\003\030\0010\0060\005H\b\032k\020 \032\022\022\004\022\002H\0020\001j\b\022\004\022\002H\002`\003\"\004\b\000\020\002\"\004\b\001\020\n*\022\022\004\022\002H\0020\001j\b\022\004\022\002H\002`\0032\032\020\013\032\026\022\006\b\000\022\002H\n0\001j\n\022\006\b\000\022\002H\n`\0032\024\b\004\020\004\032\016\022\004\022\002H\002\022\004\022\002H\n0\005H\b\032m\020!\032\022\022\004\022\002H\0020\001j\b\022\004\022\002H\002`\003\"\004\b\000\020\002*\022\022\004\022\002H\0020\001j\b\022\004\022\002H\002`\00328\b\004\020\"\0322\022\023\022\021H\002¢\006\f\b$\022\b\b%\022\004\b\b(\017\022\023\022\021H\002¢\006\f\b$\022\b\b%\022\004\b\b(\020\022\004\022\0020\0160#H\b\032O\020&\032\022\022\004\022\002H\0020\001j\b\022\004\022\002H\002`\003\"\004\b\000\020\002*\022\022\004\022\002H\0020\001j\b\022\004\022\002H\002`\0032\032\020\013\032\026\022\006\b\000\022\002H\0020\001j\n\022\006\b\000\022\002H\002`\003H\004¨\006'"}, d2={"compareBy", "Ljava/util/Comparator;", "T", "Lkotlin/Comparator;", "selector", "Lkotlin/Function1;", "", "selectors", "", "([Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "K", "comparator", "compareByDescending", "compareValues", "", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)I", "compareValuesBy", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "(Ljava/lang/Object;Ljava/lang/Object;[Lkotlin/jvm/functions/Function1;)I", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)I", "compareValuesByImpl", "compareValuesByImpl$ComparisonsKt__ComparisonsKt", "naturalOrder", "nullsFirst", "", "nullsLast", "reverseOrder", "reversed", "then", "thenBy", "thenByDescending", "thenComparator", "comparison", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "thenDescending", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/comparisons/ComparisonsKt")
class ComparisonsKt__ComparisonsKt
{
  private static final <T, K> Comparator<T> compareBy(Comparator<? super K> paramComparator, final Function1<? super T, ? extends K> paramFunction1)
  {
    (Comparator)new Comparator()
    {
      public final int compare(T paramAnonymousT1, T paramAnonymousT2)
      {
        return this.$comparator.compare(paramFunction1.invoke(paramAnonymousT1), paramFunction1.invoke(paramAnonymousT2));
      }
    };
  }
  
  private static final <T> Comparator<T> compareBy(Function1<? super T, ? extends Comparable<?>> paramFunction1)
  {
    (Comparator)new Comparator()
    {
      public final int compare(T paramAnonymousT1, T paramAnonymousT2)
      {
        return ComparisonsKt.compareValues((Comparable)this.$selector.invoke(paramAnonymousT1), (Comparable)this.$selector.invoke(paramAnonymousT2));
      }
    };
  }
  
  public static final <T> Comparator<T> compareBy(Function1<? super T, ? extends Comparable<?>>... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "selectors");
    int i;
    if (paramVarArgs.length > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      (Comparator)new Comparator()
      {
        public final int compare(T paramAnonymousT1, T paramAnonymousT2)
        {
          return ComparisonsKt__ComparisonsKt.access$compareValuesByImpl(paramAnonymousT1, paramAnonymousT2, this.$selectors);
        }
      };
    }
    throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
  }
  
  private static final <T, K> Comparator<T> compareByDescending(Comparator<? super K> paramComparator, final Function1<? super T, ? extends K> paramFunction1)
  {
    (Comparator)new Comparator()
    {
      public final int compare(T paramAnonymousT1, T paramAnonymousT2)
      {
        return this.$comparator.compare(paramFunction1.invoke(paramAnonymousT2), paramFunction1.invoke(paramAnonymousT1));
      }
    };
  }
  
  private static final <T> Comparator<T> compareByDescending(Function1<? super T, ? extends Comparable<?>> paramFunction1)
  {
    (Comparator)new Comparator()
    {
      public final int compare(T paramAnonymousT1, T paramAnonymousT2)
      {
        return ComparisonsKt.compareValues((Comparable)this.$selector.invoke(paramAnonymousT2), (Comparable)this.$selector.invoke(paramAnonymousT1));
      }
    };
  }
  
  public static final <T extends Comparable<?>> int compareValues(T paramT1, T paramT2)
  {
    if (paramT1 == paramT2) {
      return 0;
    }
    if (paramT1 == null) {
      return -1;
    }
    if (paramT2 == null) {
      return 1;
    }
    return paramT1.compareTo(paramT2);
  }
  
  private static final <T, K> int compareValuesBy(T paramT1, T paramT2, Comparator<? super K> paramComparator, Function1<? super T, ? extends K> paramFunction1)
  {
    return paramComparator.compare(paramFunction1.invoke(paramT1), paramFunction1.invoke(paramT2));
  }
  
  private static final <T> int compareValuesBy(T paramT1, T paramT2, Function1<? super T, ? extends Comparable<?>> paramFunction1)
  {
    return ComparisonsKt.compareValues((Comparable)paramFunction1.invoke(paramT1), (Comparable)paramFunction1.invoke(paramT2));
  }
  
  public static final <T> int compareValuesBy(T paramT1, T paramT2, Function1<? super T, ? extends Comparable<?>>... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "selectors");
    int i;
    if (paramVarArgs.length > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return compareValuesByImpl$ComparisonsKt__ComparisonsKt(paramT1, paramT2, paramVarArgs);
    }
    throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
  }
  
  private static final <T> int compareValuesByImpl$ComparisonsKt__ComparisonsKt(T paramT1, T paramT2, Function1<? super T, ? extends Comparable<?>>[] paramArrayOfFunction1)
  {
    int j = paramArrayOfFunction1.length;
    int i = 0;
    while (i < j)
    {
      Function1<? super T, ? extends Comparable<?>> localFunction1 = paramArrayOfFunction1[i];
      int k = ComparisonsKt.compareValues((Comparable)localFunction1.invoke(paramT1), (Comparable)localFunction1.invoke(paramT2));
      if (k != 0) {
        return k;
      }
      i += 1;
    }
    return 0;
  }
  
  public static final <T extends Comparable<? super T>> Comparator<T> naturalOrder()
  {
    NaturalOrderComparator localNaturalOrderComparator = NaturalOrderComparator.INSTANCE;
    if (localNaturalOrderComparator != null) {
      return (Comparator)localNaturalOrderComparator;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
  }
  
  private static final <T extends Comparable<? super T>> Comparator<T> nullsFirst()
  {
    return ComparisonsKt.nullsFirst(ComparisonsKt.naturalOrder());
  }
  
  public static final <T> Comparator<T> nullsFirst(Comparator<? super T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    (Comparator)new Comparator()
    {
      public final int compare(T paramAnonymousT1, T paramAnonymousT2)
      {
        if (paramAnonymousT1 == paramAnonymousT2) {
          return 0;
        }
        if (paramAnonymousT1 == null) {
          return -1;
        }
        if (paramAnonymousT2 == null) {
          return 1;
        }
        return this.$comparator.compare(paramAnonymousT1, paramAnonymousT2);
      }
    };
  }
  
  private static final <T extends Comparable<? super T>> Comparator<T> nullsLast()
  {
    return ComparisonsKt.nullsLast(ComparisonsKt.naturalOrder());
  }
  
  public static final <T> Comparator<T> nullsLast(Comparator<? super T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    (Comparator)new Comparator()
    {
      public final int compare(T paramAnonymousT1, T paramAnonymousT2)
      {
        if (paramAnonymousT1 == paramAnonymousT2) {
          return 0;
        }
        if (paramAnonymousT1 == null) {
          return 1;
        }
        if (paramAnonymousT2 == null) {
          return -1;
        }
        return this.$comparator.compare(paramAnonymousT1, paramAnonymousT2);
      }
    };
  }
  
  public static final <T extends Comparable<? super T>> Comparator<T> reverseOrder()
  {
    ReverseOrderComparator localReverseOrderComparator = ReverseOrderComparator.INSTANCE;
    if (localReverseOrderComparator != null) {
      return (Comparator)localReverseOrderComparator;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
  }
  
  public static final <T> Comparator<T> reversed(Comparator<T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramComparator, "$this$reversed");
    if ((paramComparator instanceof ReversedComparator)) {
      return ((ReversedComparator)paramComparator).getComparator();
    }
    if (Intrinsics.areEqual(paramComparator, NaturalOrderComparator.INSTANCE))
    {
      paramComparator = ReverseOrderComparator.INSTANCE;
      if (paramComparator != null) {
        return (Comparator)paramComparator;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
    }
    if (Intrinsics.areEqual(paramComparator, ReverseOrderComparator.INSTANCE))
    {
      paramComparator = NaturalOrderComparator.INSTANCE;
      if (paramComparator != null) {
        return (Comparator)paramComparator;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
    }
    return (Comparator)new ReversedComparator(paramComparator);
  }
  
  public static final <T> Comparator<T> then(Comparator<T> paramComparator, final Comparator<? super T> paramComparator1)
  {
    Intrinsics.checkParameterIsNotNull(paramComparator, "$this$then");
    Intrinsics.checkParameterIsNotNull(paramComparator1, "comparator");
    (Comparator)new Comparator()
    {
      public final int compare(T paramAnonymousT1, T paramAnonymousT2)
      {
        int i = this.$this_then.compare(paramAnonymousT1, paramAnonymousT2);
        if (i != 0) {
          return i;
        }
        return paramComparator1.compare(paramAnonymousT1, paramAnonymousT2);
      }
    };
  }
  
  private static final <T, K> Comparator<T> thenBy(Comparator<T> paramComparator, final Comparator<? super K> paramComparator1, final Function1<? super T, ? extends K> paramFunction1)
  {
    (Comparator)new Comparator()
    {
      public final int compare(T paramAnonymousT1, T paramAnonymousT2)
      {
        int i = this.$this_thenBy.compare(paramAnonymousT1, paramAnonymousT2);
        if (i != 0) {
          return i;
        }
        return paramComparator1.compare(paramFunction1.invoke(paramAnonymousT1), paramFunction1.invoke(paramAnonymousT2));
      }
    };
  }
  
  private static final <T> Comparator<T> thenBy(Comparator<T> paramComparator, final Function1<? super T, ? extends Comparable<?>> paramFunction1)
  {
    (Comparator)new Comparator()
    {
      public final int compare(T paramAnonymousT1, T paramAnonymousT2)
      {
        int i = this.$this_thenBy.compare(paramAnonymousT1, paramAnonymousT2);
        if (i != 0) {
          return i;
        }
        return ComparisonsKt.compareValues((Comparable)paramFunction1.invoke(paramAnonymousT1), (Comparable)paramFunction1.invoke(paramAnonymousT2));
      }
    };
  }
  
  private static final <T, K> Comparator<T> thenByDescending(Comparator<T> paramComparator, final Comparator<? super K> paramComparator1, final Function1<? super T, ? extends K> paramFunction1)
  {
    (Comparator)new Comparator()
    {
      public final int compare(T paramAnonymousT1, T paramAnonymousT2)
      {
        int i = this.$this_thenByDescending.compare(paramAnonymousT1, paramAnonymousT2);
        if (i != 0) {
          return i;
        }
        return paramComparator1.compare(paramFunction1.invoke(paramAnonymousT2), paramFunction1.invoke(paramAnonymousT1));
      }
    };
  }
  
  private static final <T> Comparator<T> thenByDescending(Comparator<T> paramComparator, final Function1<? super T, ? extends Comparable<?>> paramFunction1)
  {
    (Comparator)new Comparator()
    {
      public final int compare(T paramAnonymousT1, T paramAnonymousT2)
      {
        int i = this.$this_thenByDescending.compare(paramAnonymousT1, paramAnonymousT2);
        if (i != 0) {
          return i;
        }
        return ComparisonsKt.compareValues((Comparable)paramFunction1.invoke(paramAnonymousT2), (Comparable)paramFunction1.invoke(paramAnonymousT1));
      }
    };
  }
  
  private static final <T> Comparator<T> thenComparator(Comparator<T> paramComparator, final Function2<? super T, ? super T, Integer> paramFunction2)
  {
    (Comparator)new Comparator()
    {
      public final int compare(T paramAnonymousT1, T paramAnonymousT2)
      {
        int i = this.$this_thenComparator.compare(paramAnonymousT1, paramAnonymousT2);
        if (i != 0) {
          return i;
        }
        return ((Number)paramFunction2.invoke(paramAnonymousT1, paramAnonymousT2)).intValue();
      }
    };
  }
  
  public static final <T> Comparator<T> thenDescending(Comparator<T> paramComparator, final Comparator<? super T> paramComparator1)
  {
    Intrinsics.checkParameterIsNotNull(paramComparator, "$this$thenDescending");
    Intrinsics.checkParameterIsNotNull(paramComparator1, "comparator");
    (Comparator)new Comparator()
    {
      public final int compare(T paramAnonymousT1, T paramAnonymousT2)
      {
        int i = this.$this_thenDescending.compare(paramAnonymousT1, paramAnonymousT2);
        if (i != 0) {
          return i;
        }
        return paramComparator1.compare(paramAnonymousT2, paramAnonymousT1);
      }
    };
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\comparisons\ComparisonsKt__ComparisonsKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */