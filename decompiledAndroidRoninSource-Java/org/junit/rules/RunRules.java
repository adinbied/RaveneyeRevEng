package org.junit.rules;

import java.util.Iterator;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RunRules
  extends Statement
{
  private final Statement statement;
  
  public RunRules(Statement paramStatement, Iterable<TestRule> paramIterable, Description paramDescription)
  {
    this.statement = applyAll(paramStatement, paramIterable, paramDescription);
  }
  
  private static Statement applyAll(Statement paramStatement, Iterable<TestRule> paramIterable, Description paramDescription)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      paramStatement = ((TestRule)paramIterable.next()).apply(paramStatement, paramDescription);
    }
    return paramStatement;
  }
  
  public void evaluate()
    throws Throwable
  {
    this.statement.evaluate();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\rules\RunRules.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */