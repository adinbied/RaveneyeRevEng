package kotlin.coroutines.experimental.migration;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000:\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\003\n\002\020\000\n\002\030\002\n\002\030\002\n\000\032\036\020\000\032\b\022\004\022\002H\0020\001\"\004\b\000\020\002*\b\022\004\022\002H\0020\003H\007\032\f\020\004\032\0020\005*\0020\006H\007\032\f\020\007\032\0020\b*\0020\tH\007\032\036\020\n\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\001H\007\032\f\020\013\032\0020\006*\0020\005H\007\032\f\020\f\032\0020\t*\0020\bH\007\032^\020\r\032\"\022\004\022\002H\017\022\004\022\002H\020\022\n\022\b\022\004\022\002H\0210\003\022\006\022\004\030\0010\0220\016\"\004\b\000\020\017\"\004\b\001\020\020\"\004\b\002\020\021*\"\022\004\022\002H\017\022\004\022\002H\020\022\n\022\b\022\004\022\002H\0210\001\022\006\022\004\030\0010\0220\016H\000\032L\020\r\032\034\022\004\022\002H\017\022\n\022\b\022\004\022\002H\0210\003\022\006\022\004\030\0010\0220\023\"\004\b\000\020\017\"\004\b\001\020\021*\034\022\004\022\002H\017\022\n\022\b\022\004\022\002H\0210\001\022\006\022\004\030\0010\0220\023H\000\032:\020\r\032\026\022\n\022\b\022\004\022\002H\0210\003\022\006\022\004\030\0010\0220\024\"\004\b\000\020\021*\026\022\n\022\b\022\004\022\002H\0210\001\022\006\022\004\030\0010\0220\024H\000¨\006\025"}, d2={"toContinuation", "Lkotlin/coroutines/Continuation;", "T", "Lkotlin/coroutines/experimental/Continuation;", "toContinuationInterceptor", "Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlin/coroutines/experimental/ContinuationInterceptor;", "toCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/experimental/CoroutineContext;", "toExperimentalContinuation", "toExperimentalContinuationInterceptor", "toExperimentalCoroutineContext", "toExperimentalSuspendFunction", "Lkotlin/Function3;", "T1", "T2", "R", "", "Lkotlin/Function2;", "Lkotlin/Function1;", "kotlin-stdlib-coroutines"}, k=2, mv={1, 1, 15})
public final class CoroutinesMigrationKt
{
  public static final <T> kotlin.coroutines.Continuation<T> toContinuation(kotlin.coroutines.experimental.Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "$this$toContinuation");
    if (!(paramContinuation instanceof ExperimentalContinuationMigration)) {
      localObject = null;
    } else {
      localObject = paramContinuation;
    }
    Object localObject = (ExperimentalContinuationMigration)localObject;
    if (localObject != null)
    {
      localObject = ((ExperimentalContinuationMigration)localObject).getContinuation();
      if (localObject != null) {
        return (kotlin.coroutines.Continuation<T>)localObject;
      }
    }
    return (kotlin.coroutines.Continuation)new ContinuationMigration(paramContinuation);
  }
  
  public static final kotlin.coroutines.ContinuationInterceptor toContinuationInterceptor(kotlin.coroutines.experimental.ContinuationInterceptor paramContinuationInterceptor)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuationInterceptor, "$this$toContinuationInterceptor");
    if (!(paramContinuationInterceptor instanceof ExperimentalContinuationInterceptorMigration)) {
      localObject = null;
    } else {
      localObject = paramContinuationInterceptor;
    }
    Object localObject = (ExperimentalContinuationInterceptorMigration)localObject;
    if (localObject != null)
    {
      localObject = ((ExperimentalContinuationInterceptorMigration)localObject).getInterceptor();
      if (localObject != null) {
        return (kotlin.coroutines.ContinuationInterceptor)localObject;
      }
    }
    return (kotlin.coroutines.ContinuationInterceptor)new ContinuationInterceptorMigration(paramContinuationInterceptor);
  }
  
  public static final kotlin.coroutines.CoroutineContext toCoroutineContext(kotlin.coroutines.experimental.CoroutineContext paramCoroutineContext)
  {
    Intrinsics.checkParameterIsNotNull(paramCoroutineContext, "$this$toCoroutineContext");
    kotlin.coroutines.experimental.ContinuationInterceptor localContinuationInterceptor = (kotlin.coroutines.experimental.ContinuationInterceptor)paramCoroutineContext.get((kotlin.coroutines.experimental.CoroutineContext.Key)kotlin.coroutines.experimental.ContinuationInterceptor.Key);
    ExperimentalContextMigration localExperimentalContextMigration = (ExperimentalContextMigration)paramCoroutineContext.get((kotlin.coroutines.experimental.CoroutineContext.Key)ExperimentalContextMigration.Key);
    kotlin.coroutines.experimental.CoroutineContext localCoroutineContext = paramCoroutineContext.minusKey((kotlin.coroutines.experimental.CoroutineContext.Key)kotlin.coroutines.experimental.ContinuationInterceptor.Key).minusKey((kotlin.coroutines.experimental.CoroutineContext.Key)ExperimentalContextMigration.Key);
    if (localExperimentalContextMigration != null)
    {
      paramCoroutineContext = localExperimentalContextMigration.getContext();
      if (paramCoroutineContext != null) {}
    }
    else
    {
      paramCoroutineContext = (kotlin.coroutines.CoroutineContext)kotlin.coroutines.EmptyCoroutineContext.INSTANCE;
    }
    if (localCoroutineContext != kotlin.coroutines.experimental.EmptyCoroutineContext.INSTANCE) {
      paramCoroutineContext = paramCoroutineContext.plus((kotlin.coroutines.CoroutineContext)new ContextMigration(localCoroutineContext));
    }
    if (localContinuationInterceptor == null) {
      return paramCoroutineContext;
    }
    return paramCoroutineContext.plus((kotlin.coroutines.CoroutineContext)toContinuationInterceptor(localContinuationInterceptor));
  }
  
  public static final <T> kotlin.coroutines.experimental.Continuation<T> toExperimentalContinuation(kotlin.coroutines.Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "$this$toExperimentalContinuation");
    if (!(paramContinuation instanceof ContinuationMigration)) {
      localObject = null;
    } else {
      localObject = paramContinuation;
    }
    Object localObject = (ContinuationMigration)localObject;
    if (localObject != null)
    {
      localObject = ((ContinuationMigration)localObject).getContinuation();
      if (localObject != null) {
        return (kotlin.coroutines.experimental.Continuation<T>)localObject;
      }
    }
    return (kotlin.coroutines.experimental.Continuation)new ExperimentalContinuationMigration(paramContinuation);
  }
  
  public static final kotlin.coroutines.experimental.ContinuationInterceptor toExperimentalContinuationInterceptor(kotlin.coroutines.ContinuationInterceptor paramContinuationInterceptor)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuationInterceptor, "$this$toExperimentalContinuationInterceptor");
    if (!(paramContinuationInterceptor instanceof ContinuationInterceptorMigration)) {
      localObject = null;
    } else {
      localObject = paramContinuationInterceptor;
    }
    Object localObject = (ContinuationInterceptorMigration)localObject;
    if (localObject != null)
    {
      localObject = ((ContinuationInterceptorMigration)localObject).getInterceptor();
      if (localObject != null) {
        return (kotlin.coroutines.experimental.ContinuationInterceptor)localObject;
      }
    }
    return (kotlin.coroutines.experimental.ContinuationInterceptor)new ExperimentalContinuationInterceptorMigration(paramContinuationInterceptor);
  }
  
  public static final kotlin.coroutines.experimental.CoroutineContext toExperimentalCoroutineContext(kotlin.coroutines.CoroutineContext paramCoroutineContext)
  {
    Intrinsics.checkParameterIsNotNull(paramCoroutineContext, "$this$toExperimentalCoroutineContext");
    kotlin.coroutines.ContinuationInterceptor localContinuationInterceptor = (kotlin.coroutines.ContinuationInterceptor)paramCoroutineContext.get((kotlin.coroutines.CoroutineContext.Key)kotlin.coroutines.ContinuationInterceptor.Key);
    ContextMigration localContextMigration = (ContextMigration)paramCoroutineContext.get((kotlin.coroutines.CoroutineContext.Key)ContextMigration.Key);
    kotlin.coroutines.CoroutineContext localCoroutineContext = paramCoroutineContext.minusKey((kotlin.coroutines.CoroutineContext.Key)kotlin.coroutines.ContinuationInterceptor.Key).minusKey((kotlin.coroutines.CoroutineContext.Key)ContextMigration.Key);
    if (localContextMigration != null)
    {
      paramCoroutineContext = localContextMigration.getContext();
      if (paramCoroutineContext != null) {}
    }
    else
    {
      paramCoroutineContext = (kotlin.coroutines.experimental.CoroutineContext)kotlin.coroutines.experimental.EmptyCoroutineContext.INSTANCE;
    }
    if (localCoroutineContext != kotlin.coroutines.EmptyCoroutineContext.INSTANCE) {
      paramCoroutineContext = paramCoroutineContext.plus((kotlin.coroutines.experimental.CoroutineContext)new ExperimentalContextMigration(localCoroutineContext));
    }
    if (localContinuationInterceptor == null) {
      return paramCoroutineContext;
    }
    return paramCoroutineContext.plus((kotlin.coroutines.experimental.CoroutineContext)toExperimentalContinuationInterceptor(localContinuationInterceptor));
  }
  
  public static final <R> Function1<kotlin.coroutines.experimental.Continuation<? super R>, Object> toExperimentalSuspendFunction(Function1<? super kotlin.coroutines.Continuation<? super R>, ? extends Object> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "$this$toExperimentalSuspendFunction");
    return (Function1)new ExperimentalSuspendFunction0Migration(paramFunction1);
  }
  
  public static final <T1, R> Function2<T1, kotlin.coroutines.experimental.Continuation<? super R>, Object> toExperimentalSuspendFunction(Function2<? super T1, ? super kotlin.coroutines.Continuation<? super R>, ? extends Object> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "$this$toExperimentalSuspendFunction");
    return (Function2)new ExperimentalSuspendFunction1Migration(paramFunction2);
  }
  
  public static final <T1, T2, R> Function3<T1, T2, kotlin.coroutines.experimental.Continuation<? super R>, Object> toExperimentalSuspendFunction(Function3<? super T1, ? super T2, ? super kotlin.coroutines.Continuation<? super R>, ? extends Object> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction3, "$this$toExperimentalSuspendFunction");
    return (Function3)new ExperimentalSuspendFunction2Migration(paramFunction3);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\coroutines\experimental\migration\CoroutinesMigrationKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */