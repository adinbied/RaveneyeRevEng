package org.junit.internal.builders;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

public class IgnoredClassRunner
  extends Runner
{
  private final Class<?> clazz;
  
  public IgnoredClassRunner(Class<?> paramClass)
  {
    this.clazz = paramClass;
  }
  
  public Description getDescription()
  {
    return Description.createSuiteDescription(this.clazz);
  }
  
  public void run(RunNotifier paramRunNotifier)
  {
    paramRunNotifier.fireTestIgnored(getDescription());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\internal\builders\IgnoredClassRunner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */