package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;

public class FunctionReference
  extends CallableReference
  implements FunctionBase, KFunction
{
  private final int arity;
  
  public FunctionReference(int paramInt)
  {
    this.arity = paramInt;
  }
  
  public FunctionReference(int paramInt, Object paramObject)
  {
    super(paramObject);
    this.arity = paramInt;
  }
  
  protected KCallable computeReflected()
  {
    return Reflection.function(this);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof FunctionReference))
    {
      paramObject = (FunctionReference)paramObject;
      return (getOwner() == null ? ((FunctionReference)paramObject).getOwner() == null : getOwner().equals(((FunctionReference)paramObject).getOwner())) && (getName().equals(((FunctionReference)paramObject).getName())) && (getSignature().equals(((FunctionReference)paramObject).getSignature())) && (Intrinsics.areEqual(getBoundReceiver(), ((FunctionReference)paramObject).getBoundReceiver()));
    }
    if ((paramObject instanceof KFunction)) {
      return paramObject.equals(compute());
    }
    return false;
  }
  
  public int getArity()
  {
    return this.arity;
  }
  
  protected KFunction getReflected()
  {
    return (KFunction)super.getReflected();
  }
  
  public int hashCode()
  {
    int i;
    if (getOwner() == null) {
      i = 0;
    } else {
      i = getOwner().hashCode() * 31;
    }
    return (i + getName().hashCode()) * 31 + getSignature().hashCode();
  }
  
  public boolean isExternal()
  {
    return getReflected().isExternal();
  }
  
  public boolean isInfix()
  {
    return getReflected().isInfix();
  }
  
  public boolean isInline()
  {
    return getReflected().isInline();
  }
  
  public boolean isOperator()
  {
    return getReflected().isOperator();
  }
  
  public boolean isSuspend()
  {
    return getReflected().isSuspend();
  }
  
  public String toString()
  {
    Object localObject = compute();
    if (localObject != this) {
      return localObject.toString();
    }
    if ("<init>".equals(getName())) {
      return "constructor (Kotlin reflection is not available)";
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("function ");
    ((StringBuilder)localObject).append(getName());
    ((StringBuilder)localObject).append(" (Kotlin reflection is not available)");
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\jvm\internal\FunctionReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */