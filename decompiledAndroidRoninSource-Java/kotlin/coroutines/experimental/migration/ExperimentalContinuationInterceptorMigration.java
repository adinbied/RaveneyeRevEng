package kotlin.coroutines.experimental.migration;

import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.ContinuationInterceptor.DefaultImpls;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.CoroutineContext.Element;
import kotlin.coroutines.experimental.CoroutineContext.Key;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000\"\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\b\002\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\"\020\013\032\b\022\004\022\002H\r0\f\"\004\b\000\020\r2\f\020\016\032\b\022\004\022\002H\r0\fH\026R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006R\030\020\007\032\006\022\002\b\0030\b8VX\004¢\006\006\032\004\b\t\020\n¨\006\017"}, d2={"Lkotlin/coroutines/experimental/migration/ExperimentalContinuationInterceptorMigration;", "Lkotlin/coroutines/experimental/ContinuationInterceptor;", "interceptor", "Lkotlin/coroutines/ContinuationInterceptor;", "(Lkotlin/coroutines/ContinuationInterceptor;)V", "getInterceptor", "()Lkotlin/coroutines/ContinuationInterceptor;", "key", "Lkotlin/coroutines/experimental/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/experimental/CoroutineContext$Key;", "interceptContinuation", "Lkotlin/coroutines/experimental/Continuation;", "T", "continuation", "kotlin-stdlib-coroutines"}, k=1, mv={1, 1, 15})
final class ExperimentalContinuationInterceptorMigration
  implements kotlin.coroutines.experimental.ContinuationInterceptor
{
  private final kotlin.coroutines.ContinuationInterceptor interceptor;
  
  public ExperimentalContinuationInterceptorMigration(kotlin.coroutines.ContinuationInterceptor paramContinuationInterceptor)
  {
    this.interceptor = paramContinuationInterceptor;
  }
  
  public <R> R fold(R paramR, Function2<? super R, ? super CoroutineContext.Element, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    return (R)ContinuationInterceptor.DefaultImpls.fold(this, paramR, paramFunction2);
  }
  
  public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> paramKey)
  {
    Intrinsics.checkParameterIsNotNull(paramKey, "key");
    return ContinuationInterceptor.DefaultImpls.get(this, paramKey);
  }
  
  public final kotlin.coroutines.ContinuationInterceptor getInterceptor()
  {
    return this.interceptor;
  }
  
  public CoroutineContext.Key<?> getKey()
  {
    return (CoroutineContext.Key)kotlin.coroutines.experimental.ContinuationInterceptor.Key;
  }
  
  public <T> Continuation<T> interceptContinuation(Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "continuation");
    return CoroutinesMigrationKt.toExperimentalContinuation(this.interceptor.interceptContinuation(CoroutinesMigrationKt.toContinuation(paramContinuation)));
  }
  
  public CoroutineContext minusKey(CoroutineContext.Key<?> paramKey)
  {
    Intrinsics.checkParameterIsNotNull(paramKey, "key");
    return ContinuationInterceptor.DefaultImpls.minusKey(this, paramKey);
  }
  
  public CoroutineContext plus(CoroutineContext paramCoroutineContext)
  {
    Intrinsics.checkParameterIsNotNull(paramCoroutineContext, "context");
    return ContinuationInterceptor.DefaultImpls.plus(this, paramCoroutineContext);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\coroutines\experimental\migration\ExperimentalContinuationInterceptorMigration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */