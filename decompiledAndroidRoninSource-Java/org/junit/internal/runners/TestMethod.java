package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Test.None;

@Deprecated
public class TestMethod
{
  private final Method method;
  private TestClass testClass;
  
  public TestMethod(Method paramMethod, TestClass paramTestClass)
  {
    this.method = paramMethod;
    this.testClass = paramTestClass;
  }
  
  boolean expectsException()
  {
    return getExpectedException() != null;
  }
  
  List<Method> getAfters()
  {
    return this.testClass.getAnnotatedMethods(After.class);
  }
  
  List<Method> getBefores()
  {
    return this.testClass.getAnnotatedMethods(Before.class);
  }
  
  protected Class<? extends Throwable> getExpectedException()
  {
    Test localTest = (Test)this.method.getAnnotation(Test.class);
    if ((localTest != null) && (localTest.expected() != Test.None.class)) {
      return localTest.expected();
    }
    return null;
  }
  
  public long getTimeout()
  {
    Test localTest = (Test)this.method.getAnnotation(Test.class);
    if (localTest == null) {
      return 0L;
    }
    return localTest.timeout();
  }
  
  public void invoke(Object paramObject)
    throws IllegalArgumentException, IllegalAccessException, InvocationTargetException
  {
    this.method.invoke(paramObject, new Object[0]);
  }
  
  public boolean isIgnored()
  {
    return this.method.getAnnotation(Ignore.class) != null;
  }
  
  boolean isUnexpected(Throwable paramThrowable)
  {
    return getExpectedException().isAssignableFrom(paramThrowable.getClass()) ^ true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\internal\runners\TestMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */