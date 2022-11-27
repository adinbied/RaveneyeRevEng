package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import junit.framework.Test;

public class SuiteMethod
  extends JUnit38ClassRunner
{
  public SuiteMethod(Class<?> paramClass)
    throws Throwable
  {
    super(testFromSuiteMethod(paramClass));
  }
  
  public static Test testFromSuiteMethod(Class<?> paramClass)
    throws Throwable
  {
    try
    {
      Object localObject = paramClass.getMethod("suite", new Class[0]);
      if (Modifier.isStatic(((Method)localObject).getModifiers())) {
        return (Test)((Method)localObject).invoke(null, new Object[0]);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramClass.getName());
      ((StringBuilder)localObject).append(".suite() must be static");
      throw new Exception(((StringBuilder)localObject).toString());
    }
    catch (InvocationTargetException paramClass)
    {
      throw paramClass.getCause();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\internal\runners\SuiteMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */