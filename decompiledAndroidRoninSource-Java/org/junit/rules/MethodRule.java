package org.junit.rules;

import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

public abstract interface MethodRule
{
  public abstract Statement apply(Statement paramStatement, FrameworkMethod paramFrameworkMethod, Object paramObject);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\rules\MethodRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */