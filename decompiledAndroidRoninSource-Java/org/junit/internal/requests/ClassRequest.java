package org.junit.internal.requests;

import org.junit.internal.builders.AllDefaultPossibilitiesBuilder;
import org.junit.runner.Request;
import org.junit.runner.Runner;

public class ClassRequest
  extends Request
{
  private final boolean canUseSuiteMethod;
  private final Class<?> fTestClass;
  private volatile Runner runner;
  private final Object runnerLock = new Object();
  
  public ClassRequest(Class<?> paramClass)
  {
    this(paramClass, true);
  }
  
  public ClassRequest(Class<?> paramClass, boolean paramBoolean)
  {
    this.fTestClass = paramClass;
    this.canUseSuiteMethod = paramBoolean;
  }
  
  public Runner getRunner()
  {
    if (this.runner == null) {
      synchronized (this.runnerLock)
      {
        if (this.runner == null) {
          this.runner = new AllDefaultPossibilitiesBuilder(this.canUseSuiteMethod).safeRunnerForClass(this.fTestClass);
        }
      }
    }
    return this.runner;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\internal\requests\ClassRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */