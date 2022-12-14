package org.junit.rules;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class DisableOnDebug
  implements TestRule
{
  private final boolean debugging;
  private final TestRule rule;
  
  public DisableOnDebug(TestRule paramTestRule)
  {
    this(paramTestRule, ManagementFactory.getRuntimeMXBean().getInputArguments());
  }
  
  DisableOnDebug(TestRule paramTestRule, List<String> paramList)
  {
    this.rule = paramTestRule;
    this.debugging = isDebugging(paramList);
  }
  
  private static boolean isDebugging(List<String> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ("-Xdebug".equals(str)) {
        return true;
      }
      if (str.startsWith("-agentlib:jdwp")) {
        return true;
      }
    }
    return false;
  }
  
  public Statement apply(Statement paramStatement, Description paramDescription)
  {
    if (this.debugging) {
      return paramStatement;
    }
    return this.rule.apply(paramStatement, paramDescription);
  }
  
  public boolean isDebugging()
  {
    return this.debugging;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\rules\DisableOnDebug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */