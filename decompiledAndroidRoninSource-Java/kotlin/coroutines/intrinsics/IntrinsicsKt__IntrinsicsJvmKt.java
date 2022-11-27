package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000&\n\000\n\002\030\002\n\002\020\002\n\002\b\003\n\002\030\002\n\002\020\000\n\002\b\004\n\002\030\002\n\002\030\002\n\002\b\007\032F\020\000\032\b\022\004\022\0020\0020\001\"\004\b\000\020\0032\f\020\004\032\b\022\004\022\002H\0030\0012\034\b\004\020\005\032\026\022\n\022\b\022\004\022\002H\0030\001\022\006\022\004\030\0010\0070\006H\b¢\006\002\b\b\032D\020\t\032\b\022\004\022\0020\0020\001\"\004\b\000\020\003*\030\b\001\022\n\022\b\022\004\022\002H\0030\001\022\006\022\004\030\0010\0070\0062\f\020\004\032\b\022\004\022\002H\0030\001H\007ø\001\000¢\006\002\020\n\032]\020\t\032\b\022\004\022\0020\0020\001\"\004\b\000\020\013\"\004\b\001\020\003*#\b\001\022\004\022\002H\013\022\n\022\b\022\004\022\002H\0030\001\022\006\022\004\030\0010\0070\f¢\006\002\b\r2\006\020\016\032\002H\0132\f\020\004\032\b\022\004\022\002H\0030\001H\007ø\001\000¢\006\002\020\017\032\036\020\020\032\b\022\004\022\002H\0030\001\"\004\b\000\020\003*\b\022\004\022\002H\0030\001H\007\032A\020\021\032\004\030\0010\007\"\004\b\000\020\003*\030\b\001\022\n\022\b\022\004\022\002H\0030\001\022\006\022\004\030\0010\0070\0062\f\020\004\032\b\022\004\022\002H\0030\001H\bø\001\000¢\006\002\020\022\032Z\020\021\032\004\030\0010\007\"\004\b\000\020\013\"\004\b\001\020\003*#\b\001\022\004\022\002H\013\022\n\022\b\022\004\022\002H\0030\001\022\006\022\004\030\0010\0070\f¢\006\002\b\r2\006\020\016\032\002H\0132\f\020\004\032\b\022\004\022\002H\0030\001H\bø\001\000¢\006\002\020\023\002\004\n\002\b\031¨\006\024"}, d2={"createCoroutineFromSuspendFunction", "Lkotlin/coroutines/Continuation;", "", "T", "completion", "block", "Lkotlin/Function1;", "", "createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt", "createCoroutineUnintercepted", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "intercepted", "startCoroutineUninterceptedOrReturn", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/coroutines/intrinsics/IntrinsicsKt")
class IntrinsicsKt__IntrinsicsJvmKt
{
  private static final <T> Continuation<Unit> createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(final Continuation<? super T> paramContinuation, Function1<? super Continuation<? super T>, ? extends Object> paramFunction1)
  {
    final CoroutineContext localCoroutineContext = paramContinuation.getContext();
    if (localCoroutineContext == EmptyCoroutineContext.INSTANCE)
    {
      if (paramContinuation != null) {
        (Continuation)new RestrictedContinuationImpl(paramFunction1)
        {
          private int label;
          
          protected Object invokeSuspend(Object paramAnonymousObject)
          {
            int i = this.label;
            if (i != 0)
            {
              if (i == 1)
              {
                this.label = 2;
                ResultKt.throwOnFailure(paramAnonymousObject);
                return paramAnonymousObject;
              }
              throw ((Throwable)new IllegalStateException("This coroutine had already completed".toString()));
            }
            this.label = 1;
            ResultKt.throwOnFailure(paramAnonymousObject);
            return this.$block.invoke(this);
          }
        };
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }
    if (paramContinuation != null) {
      (Continuation)new ContinuationImpl(paramFunction1, paramContinuation)
      {
        private int label;
        
        protected Object invokeSuspend(Object paramAnonymousObject)
        {
          int i = this.label;
          if (i != 0)
          {
            if (i == 1)
            {
              this.label = 2;
              ResultKt.throwOnFailure(paramAnonymousObject);
              return paramAnonymousObject;
            }
            throw ((Throwable)new IllegalStateException("This coroutine had already completed".toString()));
          }
          this.label = 1;
          ResultKt.throwOnFailure(paramAnonymousObject);
          return this.$block.invoke(this);
        }
      };
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
  }
  
  public static final <T> Continuation<Unit> createCoroutineUnintercepted(final Function1<? super Continuation<? super T>, ? extends Object> paramFunction1, Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "$this$createCoroutineUnintercepted");
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = DebugProbesKt.probeCoroutineCreated(paramContinuation);
    if ((paramFunction1 instanceof BaseContinuationImpl)) {
      return ((BaseContinuationImpl)paramFunction1).create(paramContinuation);
    }
    final CoroutineContext localCoroutineContext = paramContinuation.getContext();
    if (localCoroutineContext == EmptyCoroutineContext.INSTANCE)
    {
      if (paramContinuation != null) {
        paramFunction1 = (Continuation)new RestrictedContinuationImpl(paramContinuation)
        {
          private int label;
          
          protected Object invokeSuspend(Object paramAnonymousObject)
          {
            int i = this.label;
            if (i != 0)
            {
              if (i == 1)
              {
                this.label = 2;
                ResultKt.throwOnFailure(paramAnonymousObject);
                return paramAnonymousObject;
              }
              throw ((Throwable)new IllegalStateException("This coroutine had already completed".toString()));
            }
            this.label = 1;
            ResultKt.throwOnFailure(paramAnonymousObject);
            paramAnonymousObject = (Continuation)this;
            Function1 localFunction1 = paramFunction1;
            if (localFunction1 != null) {
              return ((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(localFunction1, 1)).invoke(paramAnonymousObject);
            }
            throw new TypeCastException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
          }
        };
      } else {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
      }
    }
    else
    {
      if (paramContinuation == null) {
        break label100;
      }
      paramFunction1 = (Continuation)new ContinuationImpl(paramContinuation, localCoroutineContext)
      {
        private int label;
        
        protected Object invokeSuspend(Object paramAnonymousObject)
        {
          int i = this.label;
          if (i != 0)
          {
            if (i == 1)
            {
              this.label = 2;
              ResultKt.throwOnFailure(paramAnonymousObject);
              return paramAnonymousObject;
            }
            throw ((Throwable)new IllegalStateException("This coroutine had already completed".toString()));
          }
          this.label = 1;
          ResultKt.throwOnFailure(paramAnonymousObject);
          paramAnonymousObject = (Continuation)this;
          Function1 localFunction1 = paramFunction1;
          if (localFunction1 != null) {
            return ((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(localFunction1, 1)).invoke(paramAnonymousObject);
          }
          throw new TypeCastException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
      };
    }
    return paramFunction1;
    label100:
    throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
  }
  
  public static final <R, T> Continuation<Unit> createCoroutineUnintercepted(final Function2<? super R, ? super Continuation<? super T>, ? extends Object> paramFunction2, final R paramR, Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "$this$createCoroutineUnintercepted");
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = DebugProbesKt.probeCoroutineCreated(paramContinuation);
    if ((paramFunction2 instanceof BaseContinuationImpl)) {
      return ((BaseContinuationImpl)paramFunction2).create(paramR, paramContinuation);
    }
    final CoroutineContext localCoroutineContext = paramContinuation.getContext();
    if (localCoroutineContext == EmptyCoroutineContext.INSTANCE)
    {
      if (paramContinuation != null) {
        paramFunction2 = (Continuation)new RestrictedContinuationImpl(paramContinuation)
        {
          private int label;
          
          protected Object invokeSuspend(Object paramAnonymousObject)
          {
            int i = this.label;
            if (i != 0)
            {
              if (i == 1)
              {
                this.label = 2;
                ResultKt.throwOnFailure(paramAnonymousObject);
                return paramAnonymousObject;
              }
              throw ((Throwable)new IllegalStateException("This coroutine had already completed".toString()));
            }
            this.label = 1;
            ResultKt.throwOnFailure(paramAnonymousObject);
            paramAnonymousObject = (Continuation)this;
            Function2 localFunction2 = paramFunction2;
            if (localFunction2 != null) {
              return ((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(localFunction2, 2)).invoke(paramR, paramAnonymousObject);
            }
            throw new TypeCastException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
          }
        };
      } else {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
      }
    }
    else
    {
      if (paramContinuation == null) {
        break label103;
      }
      paramFunction2 = (Continuation)new ContinuationImpl(paramContinuation, localCoroutineContext)
      {
        private int label;
        
        protected Object invokeSuspend(Object paramAnonymousObject)
        {
          int i = this.label;
          if (i != 0)
          {
            if (i == 1)
            {
              this.label = 2;
              ResultKt.throwOnFailure(paramAnonymousObject);
              return paramAnonymousObject;
            }
            throw ((Throwable)new IllegalStateException("This coroutine had already completed".toString()));
          }
          this.label = 1;
          ResultKt.throwOnFailure(paramAnonymousObject);
          paramAnonymousObject = (Continuation)this;
          Function2 localFunction2 = paramFunction2;
          if (localFunction2 != null) {
            return ((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(localFunction2, 2)).invoke(paramR, paramAnonymousObject);
          }
          throw new TypeCastException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
      };
    }
    return paramFunction2;
    label103:
    throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
  }
  
  public static final <T> Continuation<T> intercepted(Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "$this$intercepted");
    if (!(paramContinuation instanceof ContinuationImpl)) {
      localObject1 = null;
    } else {
      localObject1 = paramContinuation;
    }
    Object localObject2 = (ContinuationImpl)localObject1;
    Object localObject1 = paramContinuation;
    if (localObject2 != null)
    {
      localObject2 = ((ContinuationImpl)localObject2).intercepted();
      localObject1 = paramContinuation;
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
    }
    return (Continuation<T>)localObject1;
  }
  
  private static final <T> Object startCoroutineUninterceptedOrReturn(Function1<? super Continuation<? super T>, ? extends Object> paramFunction1, Continuation<? super T> paramContinuation)
  {
    if (paramFunction1 != null) {
      return ((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(paramFunction1, 1)).invoke(paramContinuation);
    }
    throw new TypeCastException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
  }
  
  private static final <R, T> Object startCoroutineUninterceptedOrReturn(Function2<? super R, ? super Continuation<? super T>, ? extends Object> paramFunction2, R paramR, Continuation<? super T> paramContinuation)
  {
    if (paramFunction2 != null) {
      return ((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(paramFunction2, 2)).invoke(paramR, paramContinuation);
    }
    throw new TypeCastException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\coroutines\intrinsics\IntrinsicsKt__IntrinsicsJvmKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */