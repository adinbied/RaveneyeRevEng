package org.junit.internal.builders;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

public class AnnotatedBuilder
  extends RunnerBuilder
{
  private static final String CONSTRUCTOR_ERROR_FORMAT = "Custom runner class %s should have a public constructor with signature %s(Class testClass)";
  private final RunnerBuilder suiteBuilder;
  
  public AnnotatedBuilder(RunnerBuilder paramRunnerBuilder)
  {
    this.suiteBuilder = paramRunnerBuilder;
  }
  
  private Class<?> getEnclosingClassForNonStaticMemberClass(Class<?> paramClass)
  {
    if ((paramClass.isMemberClass()) && (!Modifier.isStatic(paramClass.getModifiers()))) {
      return paramClass.getEnclosingClass();
    }
    return null;
  }
  
  public Runner buildRunner(Class<? extends Runner> paramClass, Class<?> paramClass1)
    throws Exception
  {
    try
    {
      Runner localRunner = (Runner)paramClass.getConstructor(new Class[] { Class.class }).newInstance(new Object[] { paramClass1 });
      return localRunner;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label72:
      for (;;) {}
    }
    try
    {
      paramClass1 = (Runner)paramClass.getConstructor(new Class[] { Class.class, RunnerBuilder.class }).newInstance(new Object[] { paramClass1, this.suiteBuilder });
      return paramClass1;
    }
    catch (NoSuchMethodException paramClass1)
    {
      break label72;
    }
    paramClass = paramClass.getSimpleName();
    throw new InitializationError(String.format("Custom runner class %s should have a public constructor with signature %s(Class testClass)", new Object[] { paramClass, paramClass }));
  }
  
  public Runner runnerForClass(Class<?> paramClass)
    throws Exception
  {
    for (Object localObject = paramClass; localObject != null; localObject = getEnclosingClassForNonStaticMemberClass((Class)localObject))
    {
      RunWith localRunWith = (RunWith)((Class)localObject).getAnnotation(RunWith.class);
      if (localRunWith != null) {
        return buildRunner(localRunWith.value(), paramClass);
      }
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\internal\builders\AnnotatedBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */