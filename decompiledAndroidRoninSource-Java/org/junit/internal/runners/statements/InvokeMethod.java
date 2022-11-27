package org.junit.internal.runners.statements;

import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

public class InvokeMethod
  extends Statement
{
  private final Object target;
  private final FrameworkMethod testMethod;
  
  public InvokeMethod(FrameworkMethod paramFrameworkMethod, Object paramObject)
  {
    this.testMethod = paramFrameworkMethod;
    this.target = paramObject;
  }
  
  public void evaluate()
    throws Throwable
  {
    this.testMethod.invokeExplosively(this.target, new Object[0]);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\internal\runners\statements\InvokeMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */