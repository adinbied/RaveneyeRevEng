package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000>\n\000\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\003\n\002\030\002\n\002\030\002\n\002\020\002\n\002\b\004\n\002\020\000\n\002\b\003\n\002\030\002\n\002\030\002\n\002\b\007\n\002\020\003\n\002\b\004\032<\020\006\032\b\022\004\022\002H\b0\007\"\004\b\000\020\b2\006\020\t\032\0020\0012\032\b\004\020\n\032\024\022\n\022\b\022\004\022\002H\b0\f\022\004\022\0020\r0\013H\bø\001\000\0323\020\016\032\002H\b\"\004\b\000\020\b2\032\b\004\020\017\032\024\022\n\022\b\022\004\022\002H\b0\007\022\004\022\0020\r0\013HHø\001\000¢\006\002\020\020\032D\020\021\032\b\022\004\022\0020\r0\007\"\004\b\000\020\b*\030\b\001\022\n\022\b\022\004\022\002H\b0\007\022\006\022\004\030\0010\0220\0132\f\020\023\032\b\022\004\022\002H\b0\007H\007ø\001\000¢\006\002\020\024\032]\020\021\032\b\022\004\022\0020\r0\007\"\004\b\000\020\025\"\004\b\001\020\b*#\b\001\022\004\022\002H\025\022\n\022\b\022\004\022\002H\b0\007\022\006\022\004\030\0010\0220\026¢\006\002\b\0272\006\020\030\032\002H\0252\f\020\023\032\b\022\004\022\002H\b0\007H\007ø\001\000¢\006\002\020\031\032&\020\032\032\0020\r\"\004\b\000\020\b*\b\022\004\022\002H\b0\0072\006\020\033\032\002H\bH\b¢\006\002\020\034\032!\020\035\032\0020\r\"\004\b\000\020\b*\b\022\004\022\002H\b0\0072\006\020\036\032\0020\037H\b\032>\020 \032\0020\r\"\004\b\000\020\b*\030\b\001\022\n\022\b\022\004\022\002H\b0\007\022\006\022\004\030\0010\0220\0132\f\020\023\032\b\022\004\022\002H\b0\007H\007ø\001\000¢\006\002\020!\032W\020 \032\0020\r\"\004\b\000\020\025\"\004\b\001\020\b*#\b\001\022\004\022\002H\025\022\n\022\b\022\004\022\002H\b0\007\022\006\022\004\030\0010\0220\026¢\006\002\b\0272\006\020\030\032\002H\0252\f\020\023\032\b\022\004\022\002H\b0\007H\007ø\001\000¢\006\002\020\"\"\033\020\000\032\0020\0018Æ\002X\004¢\006\f\022\004\b\002\020\003\032\004\b\004\020\005\002\004\n\002\b\031¨\006#"}, d2={"coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext$annotations", "()V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Continuation", "Lkotlin/coroutines/Continuation;", "T", "context", "resumeWith", "Lkotlin/Function1;", "Lkotlin/Result;", "", "suspendCoroutine", "block", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createCoroutine", "", "completion", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "resume", "value", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "resumeWithException", "exception", "", "startCoroutine", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "kotlin-stdlib"}, k=2, mv={1, 1, 15})
public final class ContinuationKt
{
  private static final <T> Continuation<T> Continuation(CoroutineContext paramCoroutineContext, final Function1<? super Result<? extends T>, Unit> paramFunction1)
  {
    (Continuation)new Continuation()
    {
      public CoroutineContext getContext()
      {
        return this.$context;
      }
      
      public void resumeWith(Object paramAnonymousObject)
      {
        paramFunction1.invoke(Result.box-impl(paramAnonymousObject));
      }
    };
  }
  
  public static final <T> Continuation<Unit> createCoroutine(Function1<? super Continuation<? super T>, ? extends Object> paramFunction1, Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "$this$createCoroutine");
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    return (Continuation)new SafeContinuation(IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(paramFunction1, paramContinuation)), IntrinsicsKt.getCOROUTINE_SUSPENDED());
  }
  
  public static final <R, T> Continuation<Unit> createCoroutine(Function2<? super R, ? super Continuation<? super T>, ? extends Object> paramFunction2, R paramR, Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "$this$createCoroutine");
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    return (Continuation)new SafeContinuation(IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(paramFunction2, paramR, paramContinuation)), IntrinsicsKt.getCOROUTINE_SUSPENDED());
  }
  
  private static final CoroutineContext getCoroutineContext()
  {
    throw ((Throwable)new NotImplementedError("Implemented as intrinsic"));
  }
  
  private static final <T> void resume(Continuation<? super T> paramContinuation, T paramT)
  {
    Result.Companion localCompanion = Result.Companion;
    paramContinuation.resumeWith(Result.constructor-impl(paramT));
  }
  
  private static final <T> void resumeWithException(Continuation<? super T> paramContinuation, Throwable paramThrowable)
  {
    Result.Companion localCompanion = Result.Companion;
    paramContinuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramThrowable)));
  }
  
  public static final <T> void startCoroutine(Function1<? super Continuation<? super T>, ? extends Object> paramFunction1, Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "$this$startCoroutine");
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramFunction1 = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(paramFunction1, paramContinuation));
    paramContinuation = Unit.INSTANCE;
    Result.Companion localCompanion = Result.Companion;
    paramFunction1.resumeWith(Result.constructor-impl(paramContinuation));
  }
  
  public static final <R, T> void startCoroutine(Function2<? super R, ? super Continuation<? super T>, ? extends Object> paramFunction2, R paramR, Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "$this$startCoroutine");
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramFunction2 = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(paramFunction2, paramR, paramContinuation));
    paramR = Unit.INSTANCE;
    paramContinuation = Result.Companion;
    paramFunction2.resumeWith(Result.constructor-impl(paramR));
  }
  
  private static final <T> Object suspendCoroutine(Function1<? super Continuation<? super T>, Unit> paramFunction1, Continuation<? super T> paramContinuation)
  {
    InlineMarker.mark(0);
    SafeContinuation localSafeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(paramContinuation));
    paramFunction1.invoke(localSafeContinuation);
    paramFunction1 = localSafeContinuation.getOrThrow();
    if (paramFunction1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    InlineMarker.mark(1);
    return paramFunction1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\coroutines\ContinuationKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */