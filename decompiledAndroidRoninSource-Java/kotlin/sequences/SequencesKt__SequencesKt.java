package kotlin.sequences;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={"\000@\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\020(\n\002\b\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\004\n\002\020\021\n\002\b\006\n\002\020\034\n\002\b\005\n\002\030\002\n\002\020 \n\000\032+\020\000\032\b\022\004\022\002H\0020\001\"\004\b\000\020\0022\024\b\004\020\003\032\016\022\n\022\b\022\004\022\002H\0020\0050\004H\b\032\022\020\006\032\b\022\004\022\002H\0020\001\"\004\b\000\020\002\032&\020\007\032\b\022\004\022\002H\0020\001\"\b\b\000\020\002*\0020\b2\016\020\t\032\n\022\006\022\004\030\001H\0020\004\032<\020\007\032\b\022\004\022\002H\0020\001\"\b\b\000\020\002*\0020\b2\016\020\n\032\n\022\006\022\004\030\001H\0020\0042\024\020\t\032\020\022\004\022\002H\002\022\006\022\004\030\001H\0020\013\032=\020\007\032\b\022\004\022\002H\0020\001\"\b\b\000\020\002*\0020\b2\b\020\f\032\004\030\001H\0022\024\020\t\032\020\022\004\022\002H\002\022\006\022\004\030\001H\0020\013H\007¢\006\002\020\r\032+\020\016\032\b\022\004\022\002H\0020\001\"\004\b\000\020\0022\022\020\017\032\n\022\006\b\001\022\002H\0020\020\"\002H\002¢\006\002\020\021\032\034\020\022\032\b\022\004\022\002H\0020\001\"\004\b\000\020\002*\b\022\004\022\002H\0020\005\032\034\020\023\032\b\022\004\022\002H\0020\001\"\004\b\000\020\002*\b\022\004\022\002H\0020\001\032C\020\024\032\b\022\004\022\002H\0250\001\"\004\b\000\020\002\"\004\b\001\020\025*\b\022\004\022\002H\0020\0012\030\020\003\032\024\022\004\022\002H\002\022\n\022\b\022\004\022\002H\0250\0050\013H\002¢\006\002\b\026\032)\020\024\032\b\022\004\022\002H\0020\001\"\004\b\000\020\002*\016\022\n\022\b\022\004\022\002H\0020\0270\001H\007¢\006\002\b\030\032\"\020\024\032\b\022\004\022\002H\0020\001\"\004\b\000\020\002*\016\022\n\022\b\022\004\022\002H\0020\0010\001\0322\020\031\032\b\022\004\022\002H\0020\001\"\004\b\000\020\002*\b\022\004\022\002H\0020\0012\022\020\032\032\016\022\n\022\b\022\004\022\002H\0020\0010\004H\007\032!\020\033\032\b\022\004\022\002H\0020\001\"\004\b\000\020\002*\n\022\004\022\002H\002\030\0010\001H\b\032@\020\034\032\032\022\n\022\b\022\004\022\002H\0020\036\022\n\022\b\022\004\022\002H\0250\0360\035\"\004\b\000\020\002\"\004\b\001\020\025*\024\022\020\022\016\022\004\022\002H\002\022\004\022\002H\0250\0350\001¨\006\037"}, d2={"Sequence", "Lkotlin/sequences/Sequence;", "T", "iterator", "Lkotlin/Function0;", "", "emptySequence", "generateSequence", "", "nextFunction", "seedFunction", "Lkotlin/Function1;", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "sequenceOf", "elements", "", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "asSequence", "constrainOnce", "flatten", "R", "flatten$SequencesKt__SequencesKt", "", "flattenSequenceOfIterable", "ifEmpty", "defaultValue", "orEmpty", "unzip", "Lkotlin/Pair;", "", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/sequences/SequencesKt")
class SequencesKt__SequencesKt
  extends SequencesKt__SequencesJVMKt
{
  private static final <T> Sequence<T> Sequence(Function0<? extends Iterator<? extends T>> paramFunction0)
  {
    (Sequence)new Sequence()
    {
      public Iterator<T> iterator()
      {
        return (Iterator)this.$iterator.invoke();
      }
    };
  }
  
  public static final <T> Sequence<T> asSequence(Iterator<? extends T> paramIterator)
  {
    Intrinsics.checkParameterIsNotNull(paramIterator, "$this$asSequence");
    SequencesKt.constrainOnce((Sequence)new Sequence()
    {
      public Iterator<T> iterator()
      {
        return this.$this_asSequence$inlined;
      }
    });
  }
  
  public static final <T> Sequence<T> constrainOnce(Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$constrainOnce");
    if ((paramSequence instanceof ConstrainedOnceSequence)) {
      return paramSequence;
    }
    return (Sequence)new ConstrainedOnceSequence(paramSequence);
  }
  
  public static final <T> Sequence<T> emptySequence()
  {
    return (Sequence)EmptySequence.INSTANCE;
  }
  
  public static final <T> Sequence<T> flatten(Sequence<? extends Sequence<? extends T>> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$flatten");
    return flatten$SequencesKt__SequencesKt(paramSequence, (Function1)flatten.1.INSTANCE);
  }
  
  private static final <T, R> Sequence<R> flatten$SequencesKt__SequencesKt(Sequence<? extends T> paramSequence, Function1<? super T, ? extends Iterator<? extends R>> paramFunction1)
  {
    if ((paramSequence instanceof TransformingSequence)) {
      return ((TransformingSequence)paramSequence).flatten$kotlin_stdlib(paramFunction1);
    }
    return (Sequence)new FlatteningSequence(paramSequence, (Function1)flatten.3.INSTANCE, paramFunction1);
  }
  
  public static final <T> Sequence<T> flattenSequenceOfIterable(Sequence<? extends Iterable<? extends T>> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$flatten");
    return flatten$SequencesKt__SequencesKt(paramSequence, (Function1)flatten.2.INSTANCE);
  }
  
  public static final <T> Sequence<T> generateSequence(T paramT, Function1<? super T, ? extends T> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "nextFunction");
    if (paramT == null) {
      return (Sequence)EmptySequence.INSTANCE;
    }
    (Sequence)new GeneratorSequence((Function0)new Lambda(paramT)
    {
      public final T invoke()
      {
        return (T)this.$seed;
      }
    }, paramFunction1);
  }
  
  public static final <T> Sequence<T> generateSequence(Function0<? extends T> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "nextFunction");
    SequencesKt.constrainOnce((Sequence)new GeneratorSequence(paramFunction0, (Function1)new Lambda(paramFunction0)
    {
      public final T invoke(T paramAnonymousT)
      {
        Intrinsics.checkParameterIsNotNull(paramAnonymousT, "it");
        return (T)this.$nextFunction.invoke();
      }
    }));
  }
  
  public static final <T> Sequence<T> generateSequence(Function0<? extends T> paramFunction0, Function1<? super T, ? extends T> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "seedFunction");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "nextFunction");
    return (Sequence)new GeneratorSequence(paramFunction0, paramFunction1);
  }
  
  public static final <T> Sequence<T> ifEmpty(Sequence<? extends T> paramSequence, final Function0<? extends Sequence<? extends T>> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$ifEmpty");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "defaultValue");
    SequencesKt.sequence((Function2)new RestrictedSuspendLambda(paramSequence, paramFunction0)
    {
      Object L$0;
      Object L$1;
      int label;
      private SequenceScope p$;
      
      public final Continuation<Unit> create(Object paramAnonymousObject, Continuation<?> paramAnonymousContinuation)
      {
        Intrinsics.checkParameterIsNotNull(paramAnonymousContinuation, "completion");
        paramAnonymousContinuation = new 1(this.$this_ifEmpty, paramFunction0, paramAnonymousContinuation);
        paramAnonymousContinuation.p$ = ((SequenceScope)paramAnonymousObject);
        return paramAnonymousContinuation;
      }
      
      public final Object invoke(Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        return ((1)create(paramAnonymousObject1, (Continuation)paramAnonymousObject2)).invokeSuspend(Unit.INSTANCE);
      }
      
      public final Object invokeSuspend(Object paramAnonymousObject)
      {
        Object localObject = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0)
        {
          if ((i != 1) && (i != 2)) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          }
          localObject = (Iterator)this.L$1;
          localObject = (SequenceScope)this.L$0;
          ResultKt.throwOnFailure(paramAnonymousObject);
        }
        else
        {
          ResultKt.throwOnFailure(paramAnonymousObject);
          paramAnonymousObject = this.p$;
          Iterator localIterator = this.$this_ifEmpty.iterator();
          if (localIterator.hasNext())
          {
            this.L$0 = paramAnonymousObject;
            this.L$1 = localIterator;
            this.label = 1;
            if (((SequenceScope)paramAnonymousObject).yieldAll(localIterator, this) == localObject) {
              return localObject;
            }
          }
          else
          {
            Sequence localSequence = (Sequence)paramFunction0.invoke();
            this.L$0 = paramAnonymousObject;
            this.L$1 = localIterator;
            this.label = 2;
            if (((SequenceScope)paramAnonymousObject).yieldAll(localSequence, this) == localObject) {
              return localObject;
            }
          }
        }
        return Unit.INSTANCE;
      }
    });
  }
  
  private static final <T> Sequence<T> orEmpty(Sequence<? extends T> paramSequence)
  {
    if (paramSequence != null) {
      return paramSequence;
    }
    return SequencesKt.emptySequence();
  }
  
  public static final <T> Sequence<T> sequenceOf(T... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "elements");
    int i;
    if (paramVarArgs.length == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return SequencesKt.emptySequence();
    }
    return ArraysKt.asSequence(paramVarArgs);
  }
  
  public static final <T, R> Pair<List<T>, List<R>> unzip(Sequence<? extends Pair<? extends T, ? extends R>> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$unzip");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Pair localPair = (Pair)paramSequence.next();
      localArrayList1.add(localPair.getFirst());
      localArrayList2.add(localPair.getSecond());
    }
    return TuplesKt.to(localArrayList1, localArrayList2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\sequences\SequencesKt__SequencesKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */