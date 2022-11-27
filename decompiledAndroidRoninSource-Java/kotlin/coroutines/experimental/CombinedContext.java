package kotlin.coroutines.experimental;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={"\000B\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\006\n\002\020\013\n\002\b\004\n\002\020\000\n\002\b\004\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\003\n\002\020\016\n\000\b\000\030\0002\0020\001B\025\022\006\020\002\032\0020\001\022\006\020\003\032\0020\004¢\006\002\020\005J\020\020\n\032\0020\0132\006\020\003\032\0020\004H\002J\020\020\f\032\0020\0132\006\020\r\032\0020\000H\002J\023\020\016\032\0020\0132\b\020\017\032\004\030\0010\020H\002J5\020\021\032\002H\022\"\004\b\000\020\0222\006\020\023\032\002H\0222\030\020\024\032\024\022\004\022\002H\022\022\004\022\0020\004\022\004\022\002H\0220\025H\026¢\006\002\020\026J(\020\027\032\004\030\001H\030\"\b\b\000\020\030*\0020\0042\f\020\031\032\b\022\004\022\002H\0300\032H\002¢\006\002\020\033J\b\020\034\032\0020\035H\026J\024\020\036\032\0020\0012\n\020\031\032\006\022\002\b\0030\032H\026J\b\020\037\032\0020\035H\002J\b\020 \032\0020!H\026R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\006\020\007R\021\020\002\032\0020\001¢\006\b\n\000\032\004\b\b\020\t¨\006\""}, d2={"Lkotlin/coroutines/experimental/CombinedContext;", "Lkotlin/coroutines/experimental/CoroutineContext;", "left", "element", "Lkotlin/coroutines/experimental/CoroutineContext$Element;", "(Lkotlin/coroutines/experimental/CoroutineContext;Lkotlin/coroutines/experimental/CoroutineContext$Element;)V", "getElement", "()Lkotlin/coroutines/experimental/CoroutineContext$Element;", "getLeft", "()Lkotlin/coroutines/experimental/CoroutineContext;", "contains", "", "containsAll", "context", "equals", "other", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/experimental/CoroutineContext$Key;", "(Lkotlin/coroutines/experimental/CoroutineContext$Key;)Lkotlin/coroutines/experimental/CoroutineContext$Element;", "hashCode", "", "minusKey", "size", "toString", "", "kotlin-stdlib-coroutines"}, k=1, mv={1, 1, 15})
public final class CombinedContext
  implements CoroutineContext
{
  private final CoroutineContext.Element element;
  private final CoroutineContext left;
  
  public CombinedContext(CoroutineContext paramCoroutineContext, CoroutineContext.Element paramElement)
  {
    this.left = paramCoroutineContext;
    this.element = paramElement;
  }
  
  private final boolean contains(CoroutineContext.Element paramElement)
  {
    return Intrinsics.areEqual(get(paramElement.getKey()), paramElement);
  }
  
  private final boolean containsAll(CombinedContext paramCombinedContext)
  {
    for (;;)
    {
      if (!contains(paramCombinedContext.element)) {
        return false;
      }
      paramCombinedContext = paramCombinedContext.left;
      if (!(paramCombinedContext instanceof CombinedContext)) {
        break;
      }
      paramCombinedContext = (CombinedContext)paramCombinedContext;
    }
    if (paramCombinedContext != null) {
      return contains((CoroutineContext.Element)paramCombinedContext);
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.CoroutineContext.Element");
  }
  
  private final int size()
  {
    CoroutineContext localCoroutineContext = this.left;
    if ((localCoroutineContext instanceof CombinedContext)) {
      return ((CombinedContext)localCoroutineContext).size() + 1;
    }
    return 2;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((CombinedContext)this != paramObject) {
      if ((paramObject instanceof CombinedContext))
      {
        paramObject = (CombinedContext)paramObject;
        if ((((CombinedContext)paramObject).size() == size()) && (((CombinedContext)paramObject).containsAll(this))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public <R> R fold(R paramR, Function2<? super R, ? super CoroutineContext.Element, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    return (R)paramFunction2.invoke(this.left.fold(paramR, paramFunction2), this.element);
  }
  
  public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> paramKey)
  {
    Intrinsics.checkParameterIsNotNull(paramKey, "key");
    for (Object localObject = (CombinedContext)this;; localObject = (CombinedContext)localObject)
    {
      CoroutineContext.Element localElement = ((CombinedContext)localObject).element.get(paramKey);
      if (localElement != null) {
        return localElement;
      }
      localObject = ((CombinedContext)localObject).left;
      if (!(localObject instanceof CombinedContext)) {
        break;
      }
    }
    return ((CoroutineContext)localObject).get(paramKey);
  }
  
  public final CoroutineContext.Element getElement()
  {
    return this.element;
  }
  
  public final CoroutineContext getLeft()
  {
    return this.left;
  }
  
  public int hashCode()
  {
    return this.left.hashCode() + this.element.hashCode();
  }
  
  public CoroutineContext minusKey(CoroutineContext.Key<?> paramKey)
  {
    Intrinsics.checkParameterIsNotNull(paramKey, "key");
    if (this.element.get(paramKey) != null) {
      return this.left;
    }
    paramKey = this.left.minusKey(paramKey);
    if (paramKey == this.left) {
      return (CoroutineContext)this;
    }
    if (paramKey == EmptyCoroutineContext.INSTANCE) {
      return (CoroutineContext)this.element;
    }
    return (CoroutineContext)new CombinedContext(paramKey, this.element);
  }
  
  public CoroutineContext plus(CoroutineContext paramCoroutineContext)
  {
    Intrinsics.checkParameterIsNotNull(paramCoroutineContext, "context");
    return CoroutineContext.DefaultImpls.plus(this, paramCoroutineContext);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append((String)fold("", (Function2)toString.1.INSTANCE));
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\coroutines\experimental\CombinedContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */