package kotlin.coroutines.experimental;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000.\n\002\030\002\n\002\030\002\n\002\b\005\n\002\030\002\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\004\n\002\020\016\n\000\bÇ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J5\020\003\032\002H\004\"\004\b\000\020\0042\006\020\005\032\002H\0042\030\020\006\032\024\022\004\022\002H\004\022\004\022\0020\b\022\004\022\002H\0040\007H\026¢\006\002\020\tJ(\020\n\032\004\030\001H\013\"\b\b\000\020\013*\0020\b2\f\020\f\032\b\022\004\022\002H\0130\rH\002¢\006\002\020\016J\b\020\017\032\0020\020H\026J\024\020\021\032\0020\0012\n\020\f\032\006\022\002\b\0030\rH\026J\021\020\022\032\0020\0012\006\020\023\032\0020\001H\002J\b\020\024\032\0020\025H\026¨\006\026"}, d2={"Lkotlin/coroutines/experimental/EmptyCoroutineContext;", "Lkotlin/coroutines/experimental/CoroutineContext;", "()V", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/experimental/CoroutineContext$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/experimental/CoroutineContext$Key;", "(Lkotlin/coroutines/experimental/CoroutineContext$Key;)Lkotlin/coroutines/experimental/CoroutineContext$Element;", "hashCode", "", "minusKey", "plus", "context", "toString", "", "kotlin-stdlib-coroutines"}, k=1, mv={1, 1, 15})
public final class EmptyCoroutineContext
  implements CoroutineContext
{
  public static final EmptyCoroutineContext INSTANCE = new EmptyCoroutineContext();
  
  public <R> R fold(R paramR, Function2<? super R, ? super CoroutineContext.Element, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    return paramR;
  }
  
  public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> paramKey)
  {
    Intrinsics.checkParameterIsNotNull(paramKey, "key");
    return null;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public CoroutineContext minusKey(CoroutineContext.Key<?> paramKey)
  {
    Intrinsics.checkParameterIsNotNull(paramKey, "key");
    return (CoroutineContext)this;
  }
  
  public CoroutineContext plus(CoroutineContext paramCoroutineContext)
  {
    Intrinsics.checkParameterIsNotNull(paramCoroutineContext, "context");
    return paramCoroutineContext;
  }
  
  public String toString()
  {
    return "EmptyCoroutineContext";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\coroutines\experimental\EmptyCoroutineContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */