package org.junit.internal.runners.statements;

import java.util.Iterator;
import java.util.List;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

public class RunBefores
  extends Statement
{
  private final List<FrameworkMethod> befores;
  private final Statement next;
  private final Object target;
  
  public RunBefores(Statement paramStatement, List<FrameworkMethod> paramList, Object paramObject)
  {
    this.next = paramStatement;
    this.befores = paramList;
    this.target = paramObject;
  }
  
  public void evaluate()
    throws Throwable
  {
    Iterator localIterator = this.befores.iterator();
    while (localIterator.hasNext()) {
      ((FrameworkMethod)localIterator.next()).invokeExplosively(this.target, new Object[0]);
    }
    this.next.evaluate();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\internal\runners\statements\RunBefores.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */