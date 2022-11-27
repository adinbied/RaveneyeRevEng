package kotlin.coroutines.experimental.intrinsics;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(bv={1, 0, 3}, d1={"\0002\n\000\n\002\020\000\n\002\b\005\n\002\030\002\n\002\020\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\030\002\n\002\b\006\032:\020\006\032\b\022\004\022\0020\b0\007\"\004\b\000\020\t2\f\020\n\032\b\022\004\022\002H\t0\0072\020\b\004\020\013\032\n\022\006\022\004\030\0010\0010\fH\b¢\006\002\b\r\032D\020\016\032\b\022\004\022\0020\b0\007\"\004\b\000\020\t*\030\b\001\022\n\022\b\022\004\022\002H\t0\007\022\006\022\004\030\0010\0010\0172\f\020\n\032\b\022\004\022\002H\t0\007H\007ø\001\000¢\006\002\020\020\032]\020\016\032\b\022\004\022\0020\b0\007\"\004\b\000\020\021\"\004\b\001\020\t*#\b\001\022\004\022\002H\021\022\n\022\b\022\004\022\002H\t0\007\022\006\022\004\030\0010\0010\022¢\006\002\b\0232\006\020\024\032\002H\0212\f\020\n\032\b\022\004\022\002H\t0\007H\007ø\001\000¢\006\002\020\025\032A\020\026\032\004\030\0010\001\"\004\b\000\020\t*\030\b\001\022\n\022\b\022\004\022\002H\t0\007\022\006\022\004\030\0010\0010\0172\f\020\n\032\b\022\004\022\002H\t0\007H\bø\001\000¢\006\002\020\027\032Z\020\026\032\004\030\0010\001\"\004\b\000\020\021\"\004\b\001\020\t*#\b\001\022\004\022\002H\021\022\n\022\b\022\004\022\002H\t0\007\022\006\022\004\030\0010\0010\022¢\006\002\b\0232\006\020\024\032\002H\0212\f\020\n\032\b\022\004\022\002H\t0\007H\bø\001\000¢\006\002\020\030\"\032\020\000\032\0020\0018FX\004¢\006\f\022\004\b\002\020\003\032\004\b\004\020\005\002\004\n\002\b\t¨\006\031"}, d2={"COROUTINE_SUSPENDED", "", "COROUTINE_SUSPENDED$annotations", "()V", "getCOROUTINE_SUSPENDED", "()Ljava/lang/Object;", "buildContinuationByInvokeCall", "Lkotlin/coroutines/experimental/Continuation;", "", "T", "completion", "block", "Lkotlin/Function0;", "buildContinuationByInvokeCall$IntrinsicsKt__IntrinsicsJvmKt", "createCoroutineUnchecked", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)Lkotlin/coroutines/experimental/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Lkotlin/coroutines/experimental/Continuation;", "startCoroutineUninterceptedOrReturn", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "kotlin-stdlib-coroutines"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/coroutines/experimental/intrinsics/IntrinsicsKt")
class IntrinsicsKt__IntrinsicsJvmKt
{
  private static final <T> Continuation<Unit> buildContinuationByInvokeCall$IntrinsicsKt__IntrinsicsJvmKt(Continuation<? super T> paramContinuation, final Function0<? extends Object> paramFunction0)
  {
    paramFunction0 = new Continuation()
    {
      public CoroutineContext getContext()
      {
        return this.$completion.getContext();
      }
      
      public void resume(Unit paramAnonymousUnit)
      {
        Intrinsics.checkParameterIsNotNull(paramAnonymousUnit, "value");
        paramAnonymousUnit = this.$completion;
        try
        {
          Object localObject = paramFunction0.invoke();
          if (localObject != IntrinsicsKt.getCOROUTINE_SUSPENDED())
          {
            if (paramAnonymousUnit != null) {
              return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
          }
        }
        finally
        {
          paramAnonymousUnit.resumeWithException(localThrowable);
        }
      }
      
      public void resumeWithException(Throwable paramAnonymousThrowable)
      {
        Intrinsics.checkParameterIsNotNull(paramAnonymousThrowable, "exception");
        this.$completion.resumeWithException(paramAnonymousThrowable);
      }
    };
    return CoroutineIntrinsics.interceptContinuationIfNeeded(paramContinuation.getContext(), (Continuation)paramFunction0);
  }
  
  public static final <T> Continuation<Unit> createCoroutineUnchecked(final Function1<? super Continuation<? super T>, ? extends Object> paramFunction1, final Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "$this$createCoroutineUnchecked");
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    if (!(paramFunction1 instanceof CoroutineImpl))
    {
      paramFunction1 = new Continuation()
      {
        public CoroutineContext getContext()
        {
          return this.$completion.getContext();
        }
        
        public void resume(Unit paramAnonymousUnit)
        {
          Intrinsics.checkParameterIsNotNull(paramAnonymousUnit, "value");
          paramAnonymousUnit = this.$completion;
          try
          {
            Object localObject = paramFunction1;
            if (localObject != null)
            {
              localObject = ((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(localObject, 1)).invoke(paramContinuation);
              if (localObject != IntrinsicsKt.getCOROUTINE_SUSPENDED())
              {
                if (paramAnonymousUnit != null) {
                  return;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
              }
            }
            else
            {
              throw new TypeCastException("null cannot be cast to non-null type (kotlin.coroutines.experimental.Continuation<T>) -> kotlin.Any?");
            }
          }
          finally
          {
            paramAnonymousUnit.resumeWithException(localThrowable);
          }
        }
        
        public void resumeWithException(Throwable paramAnonymousThrowable)
        {
          Intrinsics.checkParameterIsNotNull(paramAnonymousThrowable, "exception");
          this.$completion.resumeWithException(paramAnonymousThrowable);
        }
      };
      return CoroutineIntrinsics.interceptContinuationIfNeeded(paramContinuation.getContext(), (Continuation)paramFunction1);
    }
    paramFunction1 = ((CoroutineImpl)paramFunction1).create(paramContinuation);
    if (paramFunction1 != null) {
      return ((CoroutineImpl)paramFunction1).getFacade();
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.jvm.internal.CoroutineImpl");
  }
  
  public static final <R, T> Continuation<Unit> createCoroutineUnchecked(final Function2<? super R, ? super Continuation<? super T>, ? extends Object> paramFunction2, final R paramR, final Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "$this$createCoroutineUnchecked");
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    if (!(paramFunction2 instanceof CoroutineImpl))
    {
      paramFunction2 = new Continuation()
      {
        public CoroutineContext getContext()
        {
          return this.$completion.getContext();
        }
        
        public void resume(Unit paramAnonymousUnit)
        {
          Intrinsics.checkParameterIsNotNull(paramAnonymousUnit, "value");
          paramAnonymousUnit = this.$completion;
          try
          {
            Object localObject = paramFunction2;
            if (localObject != null)
            {
              localObject = ((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(localObject, 2)).invoke(paramR, paramContinuation);
              if (localObject != IntrinsicsKt.getCOROUTINE_SUSPENDED())
              {
                if (paramAnonymousUnit != null) {
                  return;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
              }
            }
            else
            {
              throw new TypeCastException("null cannot be cast to non-null type (R, kotlin.coroutines.experimental.Continuation<T>) -> kotlin.Any?");
            }
          }
          finally
          {
            paramAnonymousUnit.resumeWithException(localThrowable);
          }
        }
        
        public void resumeWithException(Throwable paramAnonymousThrowable)
        {
          Intrinsics.checkParameterIsNotNull(paramAnonymousThrowable, "exception");
          this.$completion.resumeWithException(paramAnonymousThrowable);
        }
      };
      return CoroutineIntrinsics.interceptContinuationIfNeeded(paramContinuation.getContext(), (Continuation)paramFunction2);
    }
    paramFunction2 = ((CoroutineImpl)paramFunction2).create(paramR, paramContinuation);
    if (paramFunction2 != null) {
      return ((CoroutineImpl)paramFunction2).getFacade();
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.jvm.internal.CoroutineImpl");
  }
  
  public static final Object getCOROUTINE_SUSPENDED()
  {
    return kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
  }
  
  private static final <T> Object startCoroutineUninterceptedOrReturn(Function1<? super Continuation<? super T>, ? extends Object> paramFunction1, Continuation<? super T> paramContinuation)
  {
    if (paramFunction1 != null) {
      return ((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(paramFunction1, 1)).invoke(paramContinuation);
    }
    throw new TypeCastException("null cannot be cast to non-null type (kotlin.coroutines.experimental.Continuation<T>) -> kotlin.Any?");
  }
  
  private static final <R, T> Object startCoroutineUninterceptedOrReturn(Function2<? super R, ? super Continuation<? super T>, ? extends Object> paramFunction2, R paramR, Continuation<? super T> paramContinuation)
  {
    if (paramFunction2 != null) {
      return ((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(paramFunction2, 2)).invoke(paramR, paramContinuation);
    }
    throw new TypeCastException("null cannot be cast to non-null type (R, kotlin.coroutines.experimental.Continuation<T>) -> kotlin.Any?");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\coroutines\experimental\intrinsics\IntrinsicsKt__IntrinsicsJvmKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */