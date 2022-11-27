package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv={1, 0, 3}, d1={"\000,\n\002\030\002\n\002\030\002\n\002\030\002\n\002\020\000\n\002\030\002\n\000\n\002\020\b\n\002\b\002\n\002\030\002\n\002\b\004\n\002\020\016\n\000\b!\030\0002\0020\0012\n\022\006\022\004\030\0010\0030\0022\0020\004B\017\b\026\022\006\020\005\032\0020\006¢\006\002\020\007B\037\022\006\020\005\032\0020\006\022\020\020\b\032\f\022\006\022\004\030\0010\003\030\0010\t¢\006\002\020\nJ\b\020\r\032\0020\016H\026R\024\020\005\032\0020\006X\004¢\006\b\n\000\032\004\b\013\020\f¨\006\017"}, d2={"Lkotlin/coroutines/jvm/internal/RestrictedSuspendLambda;", "Lkotlin/coroutines/jvm/internal/RestrictedContinuationImpl;", "Lkotlin/jvm/internal/FunctionBase;", "", "Lkotlin/coroutines/jvm/internal/SuspendFunction;", "arity", "", "(I)V", "completion", "Lkotlin/coroutines/Continuation;", "(ILkotlin/coroutines/Continuation;)V", "getArity", "()I", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public abstract class RestrictedSuspendLambda
  extends RestrictedContinuationImpl
  implements FunctionBase<Object>, SuspendFunction
{
  private final int arity;
  
  public RestrictedSuspendLambda(int paramInt)
  {
    this(paramInt, null);
  }
  
  public RestrictedSuspendLambda(int paramInt, Continuation<Object> paramContinuation)
  {
    super(paramContinuation);
    this.arity = paramInt;
  }
  
  public int getArity()
  {
    return this.arity;
  }
  
  public String toString()
  {
    if (getCompletion() == null)
    {
      String str = Reflection.renderLambdaToString((FunctionBase)this);
      Intrinsics.checkExpressionValueIsNotNull(str, "Reflection.renderLambdaToString(this)");
      return str;
    }
    return super.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\coroutines\jvm\internal\RestrictedSuspendLambda.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */