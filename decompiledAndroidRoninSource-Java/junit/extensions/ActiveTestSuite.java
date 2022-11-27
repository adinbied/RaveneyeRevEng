package junit.extensions;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;

public class ActiveTestSuite
  extends TestSuite
{
  private volatile int fActiveTestDeathCount;
  
  public ActiveTestSuite() {}
  
  public ActiveTestSuite(Class<? extends TestCase> paramClass)
  {
    super(paramClass);
  }
  
  public ActiveTestSuite(Class<? extends TestCase> paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public ActiveTestSuite(String paramString)
  {
    super(paramString);
  }
  
  /* Error */
  public void run(TestResult arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void runFinished()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void runTest(Test arg1, TestResult arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void waitUntilFinished()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\junit\extensions\ActiveTestSuite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */