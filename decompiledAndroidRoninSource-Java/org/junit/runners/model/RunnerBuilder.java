package org.junit.runners.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.internal.runners.ErrorReportingRunner;
import org.junit.runner.Runner;

public abstract class RunnerBuilder
{
  private final Set<Class<?>> parents = new HashSet();
  
  private List<Runner> runners(Class<?>[] paramArrayOfClass)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      Runner localRunner = safeRunnerForClass(paramArrayOfClass[i]);
      if (localRunner != null) {
        localArrayList.add(localRunner);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  Class<?> addParent(Class<?> paramClass)
    throws InitializationError
  {
    if (this.parents.add(paramClass)) {
      return paramClass;
    }
    throw new InitializationError(String.format("class '%s' (possibly indirectly) contains itself as a SuiteClass", new Object[] { paramClass.getName() }));
  }
  
  void removeParent(Class<?> paramClass)
  {
    this.parents.remove(paramClass);
  }
  
  public abstract Runner runnerForClass(Class<?> paramClass)
    throws Throwable;
  
  public List<Runner> runners(Class<?> paramClass, List<Class<?>> paramList)
    throws InitializationError
  {
    return runners(paramClass, (Class[])paramList.toArray(new Class[0]));
  }
  
  public List<Runner> runners(Class<?> paramClass, Class<?>[] paramArrayOfClass)
    throws InitializationError
  {
    addParent(paramClass);
    try
    {
      paramArrayOfClass = runners(paramArrayOfClass);
      return paramArrayOfClass;
    }
    finally
    {
      removeParent(paramClass);
    }
  }
  
  public Runner safeRunnerForClass(Class<?> paramClass)
  {
    try
    {
      localRunner = runnerForClass(paramClass);
    }
    finally
    {
      Runner localRunner;
      return new ErrorReportingRunner(paramClass, localThrowable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\runners\model\RunnerBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */