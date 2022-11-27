package org.junit.runner;

import org.junit.runner.notification.RunNotifier;

public abstract class Runner
  implements Describable
{
  public abstract Description getDescription();
  
  public abstract void run(RunNotifier paramRunNotifier);
  
  public int testCount()
  {
    return getDescription().testCount();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\runner\Runner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */