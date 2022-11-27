package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

@Metadata(bv={1, 0, 3}, d1={"\000*\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002\n\002\020(\n\002\020 \n\002\b\003\n\002\020\013\n\002\b\002\n\002\030\002\n\000\032\030\020\000\032\0020\0012\006\020\002\032\0020\0032\006\020\004\032\0020\003H\000\032H\020\005\032\016\022\n\022\b\022\004\022\002H\b0\0070\006\"\004\b\000\020\b2\f\020\t\032\b\022\004\022\002H\b0\0062\006\020\002\032\0020\0032\006\020\004\032\0020\0032\006\020\n\032\0020\0132\006\020\f\032\0020\013H\000\032D\020\r\032\016\022\n\022\b\022\004\022\002H\b0\0070\016\"\004\b\000\020\b*\b\022\004\022\002H\b0\0162\006\020\002\032\0020\0032\006\020\004\032\0020\0032\006\020\n\032\0020\0132\006\020\f\032\0020\013H\000¨\006\017"}, d2={"checkWindowSizeStep", "", "size", "", "step", "windowedIterator", "", "", "T", "iterator", "partialWindows", "", "reuseBuffer", "windowedSequence", "Lkotlin/sequences/Sequence;", "kotlin-stdlib"}, k=2, mv={1, 1, 15})
public final class SlidingWindowKt
{
  public static final void checkWindowSizeStep(int paramInt1, int paramInt2)
  {
    int i;
    if ((paramInt1 > 0) && (paramInt2 > 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      Object localObject;
      if (paramInt1 != paramInt2)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Both size ");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(" and step ");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(" must be greater than zero.");
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("size ");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(" must be greater than zero.");
        localObject = ((StringBuilder)localObject).toString();
      }
      throw ((Throwable)new IllegalArgumentException(localObject.toString()));
    }
  }
  
  public static final <T> Iterator<List<T>> windowedIterator(final Iterator<? extends T> paramIterator, int paramInt1, final int paramInt2, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramIterator, "iterator");
    if (!paramIterator.hasNext()) {
      return (Iterator)EmptyIterator.INSTANCE;
    }
    SequencesKt.iterator((Function2)new RestrictedSuspendLambda(paramInt1, paramInt2)
    {
      int I$0;
      int I$1;
      int I$2;
      Object L$0;
      Object L$1;
      Object L$2;
      Object L$3;
      int label;
      private SequenceScope p$;
      
      public final Continuation<Unit> create(Object paramAnonymousObject, Continuation<?> paramAnonymousContinuation)
      {
        Intrinsics.checkParameterIsNotNull(paramAnonymousContinuation, "completion");
        paramAnonymousContinuation = new 1(this.$size, paramInt2, paramIterator, paramBoolean2, paramBoolean1, paramAnonymousContinuation);
        paramAnonymousContinuation.p$ = ((SequenceScope)paramAnonymousObject);
        return paramAnonymousContinuation;
      }
      
      public final Object invoke(Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        return ((1)create(paramAnonymousObject1, (Continuation)paramAnonymousObject2)).invokeSuspend(Unit.INSTANCE);
      }
      
      public final Object invokeSuspend(Object paramAnonymousObject)
      {
        Object localObject7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        Object localObject1;
        Object localObject2;
        int j;
        Object localObject3;
        Object localObject5;
        Object localObject6;
        Object localObject4;
        int k;
        int m;
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3)
              {
                if (i != 4)
                {
                  if (i == 5) {
                    localObject1 = (RingBuffer)this.L$1;
                  } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }
                }
                else
                {
                  localObject2 = (RingBuffer)this.L$1;
                  j = this.I$1;
                  i = this.I$0;
                  localObject3 = (SequenceScope)this.L$0;
                  ResultKt.throwOnFailure(paramAnonymousObject);
                  localObject5 = this;
                  break label863;
                }
              }
              else
              {
                localObject3 = (Iterator)this.L$3;
                localObject1 = (RingBuffer)this.L$1;
                j = this.I$1;
                i = this.I$0;
                localObject5 = (SequenceScope)this.L$0;
                ResultKt.throwOnFailure(paramAnonymousObject);
                localObject6 = this;
                paramAnonymousObject = localObject1;
                break label723;
              }
            }
            else {
              localObject1 = (ArrayList)this.L$1;
            }
            localObject1 = (SequenceScope)this.L$0;
            ResultKt.throwOnFailure(paramAnonymousObject);
            break label945;
          }
          localObject2 = (Iterator)this.L$3;
          localObject4 = (ArrayList)this.L$1;
          i = this.I$1;
          k = this.I$0;
          localObject1 = (SequenceScope)this.L$0;
          ResultKt.throwOnFailure(paramAnonymousObject);
          localObject3 = this;
          paramAnonymousObject = localObject4;
        }
        else
        {
          ResultKt.throwOnFailure(paramAnonymousObject);
          localObject1 = this.p$;
          k = RangesKt.coerceAtMost(this.$size, 1024);
          j = paramInt2 - this.$size;
          if (j < 0) {
            break label532;
          }
          paramAnonymousObject = new ArrayList(k);
          m = 0;
          localObject2 = paramIterator;
          localObject3 = this;
          i = j;
          j = m;
        }
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = ((Iterator)localObject2).next();
          if (j > 0)
          {
            j -= 1;
          }
          else
          {
            ((ArrayList)paramAnonymousObject).add(localObject4);
            if (((ArrayList)paramAnonymousObject).size() == ((1)localObject3).$size)
            {
              ((1)localObject3).L$0 = localObject1;
              ((1)localObject3).I$0 = k;
              ((1)localObject3).I$1 = i;
              ((1)localObject3).L$1 = paramAnonymousObject;
              ((1)localObject3).I$2 = j;
              ((1)localObject3).L$2 = localObject4;
              ((1)localObject3).L$3 = localObject2;
              ((1)localObject3).label = 1;
              if (((SequenceScope)localObject1).yield(paramAnonymousObject, (Continuation)localObject3) == localObject7) {
                return localObject7;
              }
              if (paramBoolean2) {
                ((ArrayList)paramAnonymousObject).clear();
              } else {
                paramAnonymousObject = new ArrayList(((1)localObject3).$size);
              }
              m = i;
              j = i;
              i = m;
            }
          }
        }
        if (((((Collection)paramAnonymousObject).isEmpty() ^ true)) && ((paramBoolean1) || (((ArrayList)paramAnonymousObject).size() == ((1)localObject3).$size)))
        {
          ((1)localObject3).L$0 = localObject1;
          ((1)localObject3).I$0 = k;
          ((1)localObject3).I$1 = i;
          ((1)localObject3).L$1 = paramAnonymousObject;
          ((1)localObject3).I$2 = j;
          ((1)localObject3).label = 2;
          if (((SequenceScope)localObject1).yield(paramAnonymousObject, (Continuation)localObject3) == localObject7)
          {
            return localObject7;
            label532:
            paramAnonymousObject = new RingBuffer(k);
            localObject3 = paramIterator;
            localObject2 = localObject1;
            localObject1 = this;
            i = k;
            while (((Iterator)localObject3).hasNext())
            {
              localObject5 = ((Iterator)localObject3).next();
              ((RingBuffer)paramAnonymousObject).add(localObject5);
              if (((RingBuffer)paramAnonymousObject).isFull())
              {
                k = ((RingBuffer)paramAnonymousObject).size();
                m = ((1)localObject1).$size;
                if (k < m)
                {
                  paramAnonymousObject = ((RingBuffer)paramAnonymousObject).expanded(m);
                }
                else
                {
                  if (paramBoolean2) {
                    localObject4 = (List)paramAnonymousObject;
                  } else {
                    localObject4 = (List)new ArrayList((Collection)paramAnonymousObject);
                  }
                  ((1)localObject1).L$0 = localObject2;
                  ((1)localObject1).I$0 = i;
                  ((1)localObject1).I$1 = j;
                  ((1)localObject1).L$1 = paramAnonymousObject;
                  ((1)localObject1).L$2 = localObject5;
                  ((1)localObject1).L$3 = localObject3;
                  ((1)localObject1).label = 3;
                  localObject5 = localObject2;
                  localObject6 = localObject1;
                  if (((SequenceScope)localObject2).yield(localObject4, (Continuation)localObject1) == localObject7) {
                    return localObject7;
                  }
                  label723:
                  ((RingBuffer)paramAnonymousObject).removeFirst(paramInt2);
                  localObject2 = localObject5;
                  localObject1 = localObject6;
                }
              }
            }
            if (paramBoolean1)
            {
              localObject3 = paramAnonymousObject;
              paramAnonymousObject = localObject2;
              localObject2 = localObject3;
              while (((RingBuffer)localObject2).size() > paramInt2)
              {
                if (paramBoolean2) {
                  localObject4 = (List)localObject2;
                } else {
                  localObject4 = (List)new ArrayList((Collection)localObject2);
                }
                ((1)localObject1).L$0 = paramAnonymousObject;
                ((1)localObject1).I$0 = i;
                ((1)localObject1).I$1 = j;
                ((1)localObject1).L$1 = localObject2;
                ((1)localObject1).label = 4;
                localObject3 = paramAnonymousObject;
                localObject5 = localObject1;
                if (((SequenceScope)paramAnonymousObject).yield(localObject4, (Continuation)localObject1) == localObject7) {
                  return localObject7;
                }
                label863:
                ((RingBuffer)localObject2).removeFirst(paramInt2);
                paramAnonymousObject = localObject3;
                localObject1 = localObject5;
              }
              if ((((Collection)localObject2).isEmpty() ^ true))
              {
                ((1)localObject1).L$0 = paramAnonymousObject;
                ((1)localObject1).I$0 = i;
                ((1)localObject1).I$1 = j;
                ((1)localObject1).L$1 = localObject2;
                ((1)localObject1).label = 5;
                if (((SequenceScope)paramAnonymousObject).yield(localObject2, (Continuation)localObject1) == localObject7) {
                  return localObject7;
                }
              }
            }
          }
        }
        label945:
        return Unit.INSTANCE;
      }
    });
  }
  
  public static final <T> Sequence<List<T>> windowedSequence(Sequence<? extends T> paramSequence, final int paramInt1, final int paramInt2, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$windowedSequence");
    checkWindowSizeStep(paramInt1, paramInt2);
    (Sequence)new Sequence()
    {
      public Iterator<List<? extends T>> iterator()
      {
        return SlidingWindowKt.windowedIterator(this.$this_windowedSequence$inlined.iterator(), paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      }
    };
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\collections\SlidingWindowKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */