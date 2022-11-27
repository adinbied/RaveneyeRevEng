package org.junit.runners.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import org.junit.internal.runners.model.ReflectiveCallable;

public class FrameworkMethod
  extends FrameworkMember<FrameworkMethod>
{
  private final Method method;
  
  public FrameworkMethod(Method paramMethod)
  {
    if (paramMethod != null)
    {
      this.method = paramMethod;
      return;
    }
    throw new NullPointerException("FrameworkMethod cannot be created without an underlying method.");
  }
  
  private Class<?>[] getParameterTypes()
  {
    return this.method.getParameterTypes();
  }
  
  public boolean equals(Object paramObject)
  {
    if (!FrameworkMethod.class.isInstance(paramObject)) {
      return false;
    }
    return ((FrameworkMethod)paramObject).method.equals(this.method);
  }
  
  public <T extends Annotation> T getAnnotation(Class<T> paramClass)
  {
    return this.method.getAnnotation(paramClass);
  }
  
  public Annotation[] getAnnotations()
  {
    return this.method.getAnnotations();
  }
  
  public Class<?> getDeclaringClass()
  {
    return this.method.getDeclaringClass();
  }
  
  public Method getMethod()
  {
    return this.method;
  }
  
  protected int getModifiers()
  {
    return this.method.getModifiers();
  }
  
  public String getName()
  {
    return this.method.getName();
  }
  
  public Class<?> getReturnType()
  {
    return this.method.getReturnType();
  }
  
  public Class<?> getType()
  {
    return getReturnType();
  }
  
  public int hashCode()
  {
    return this.method.hashCode();
  }
  
  public Object invokeExplosively(final Object paramObject, final Object... paramVarArgs)
    throws Throwable
  {
    new ReflectiveCallable()
    {
      protected Object runReflectiveCall()
        throws Throwable
      {
        return FrameworkMethod.this.method.invoke(paramObject, paramVarArgs);
      }
    }.run();
  }
  
  public boolean isShadowedBy(FrameworkMethod paramFrameworkMethod)
  {
    if (!paramFrameworkMethod.getName().equals(getName())) {
      return false;
    }
    if (paramFrameworkMethod.getParameterTypes().length != getParameterTypes().length) {
      return false;
    }
    int i = 0;
    while (i < paramFrameworkMethod.getParameterTypes().length)
    {
      if (!paramFrameworkMethod.getParameterTypes()[i].equals(getParameterTypes()[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  @Deprecated
  public boolean producesType(Type paramType)
  {
    return (getParameterTypes().length == 0) && ((paramType instanceof Class)) && (((Class)paramType).isAssignableFrom(this.method.getReturnType()));
  }
  
  public String toString()
  {
    return this.method.toString();
  }
  
  public void validateNoTypeParametersOnArgs(List<Throwable> paramList)
  {
    new NoGenericTypeParametersValidator(this.method).validate(paramList);
  }
  
  public void validatePublicVoid(boolean paramBoolean, List<Throwable> paramList)
  {
    Object localObject;
    if (isStatic() != paramBoolean)
    {
      if (paramBoolean) {
        localObject = "should";
      } else {
        localObject = "should not";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Method ");
      localStringBuilder.append(this.method.getName());
      localStringBuilder.append("() ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" be static");
      paramList.add(new Exception(localStringBuilder.toString()));
    }
    if (!isPublic())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Method ");
      ((StringBuilder)localObject).append(this.method.getName());
      ((StringBuilder)localObject).append("() should be public");
      paramList.add(new Exception(((StringBuilder)localObject).toString()));
    }
    if (this.method.getReturnType() != Void.TYPE)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Method ");
      ((StringBuilder)localObject).append(this.method.getName());
      ((StringBuilder)localObject).append("() should be void");
      paramList.add(new Exception(((StringBuilder)localObject).toString()));
    }
  }
  
  public void validatePublicVoidNoArg(boolean paramBoolean, List<Throwable> paramList)
  {
    validatePublicVoid(paramBoolean, paramList);
    if (this.method.getParameterTypes().length != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Method ");
      localStringBuilder.append(this.method.getName());
      localStringBuilder.append(" should have no parameters");
      paramList.add(new Exception(localStringBuilder.toString()));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\runners\model\FrameworkMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */