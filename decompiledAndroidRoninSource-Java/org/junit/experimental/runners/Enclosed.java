package org.junit.experimental.runners;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import org.junit.runners.Suite;
import org.junit.runners.model.RunnerBuilder;

public class Enclosed
  extends Suite
{
  public Enclosed(Class<?> paramClass, RunnerBuilder paramRunnerBuilder)
    throws Throwable
  {
    super(paramRunnerBuilder, paramClass, filterAbstractClasses(paramClass.getClasses()));
  }
  
  private static Class<?>[] filterAbstractClasses(Class<?>[] paramArrayOfClass)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfClass.length);
    int j = paramArrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      Class<?> localClass = paramArrayOfClass[i];
      if (!Modifier.isAbstract(localClass.getModifiers())) {
        localArrayList.add(localClass);
      }
      i += 1;
    }
    return (Class[])localArrayList.toArray(new Class[localArrayList.size()]);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\experimental\runners\Enclosed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */