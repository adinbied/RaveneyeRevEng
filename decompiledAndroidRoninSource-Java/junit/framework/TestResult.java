package junit.framework;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class TestResult
{
  protected List<TestFailure> fErrors = new ArrayList();
  protected List<TestFailure> fFailures = new ArrayList();
  protected List<TestListener> fListeners = new ArrayList();
  protected int fRunTests = 0;
  private boolean fStop = false;
  
  private List<TestListener> cloneListeners()
  {
    return null;
  }
  
  /* Error */
  public void addError(Test arg1, Throwable arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void addFailure(Test arg1, AssertionFailedError arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void addListener(TestListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void endTest(Test arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int errorCount()
  {
    return 0;
  }
  
  public Enumeration<TestFailure> errors()
  {
    return null;
  }
  
  public int failureCount()
  {
    return 0;
  }
  
  public Enumeration<TestFailure> failures()
  {
    return null;
  }
  
  /* Error */
  public void removeListener(TestListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  protected void run(TestCase arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int runCount()
  {
    try
    {
      int i = this.fRunTests;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void runProtected(Test paramTest, Protectable paramProtectable)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokeinterface 68 1 0
    //   6: return
    //   7: astore_2
    //   8: aload_0
    //   9: aload_1
    //   10: aload_2
    //   11: invokevirtual 70	junit/framework/TestResult:addError	(Ljunit/framework/Test;Ljava/lang/Throwable;)V
    //   14: return
    //   15: astore_1
    //   16: aload_1
    //   17: athrow
    //   18: astore_2
    //   19: aload_0
    //   20: aload_1
    //   21: aload_2
    //   22: invokevirtual 72	junit/framework/TestResult:addFailure	(Ljunit/framework/Test;Ljunit/framework/AssertionFailedError;)V
    //   25: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	26	0	this	TestResult
    //   0	26	1	paramTest	Test
    //   0	26	2	paramProtectable	Protectable
    // Exception table:
    //   from	to	target	type
    //   0	6	7	finally
    //   0	6	15	java/lang/ThreadDeath
    //   0	6	18	junit/framework/AssertionFailedError
  }
  
  public boolean shouldStop()
  {
    try
    {
      boolean bool = this.fStop;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void startTest(Test arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public boolean wasSuccessful()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\junit\framework\TestResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */