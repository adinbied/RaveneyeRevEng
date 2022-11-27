package junit.textui;

import java.io.InputStream;
import java.io.PrintStream;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import junit.runner.BaseTestRunner;

public class TestRunner
  extends BaseTestRunner
{
  public static final int EXCEPTION_EXIT = 2;
  public static final int FAILURE_EXIT = 1;
  public static final int SUCCESS_EXIT = 0;
  private ResultPrinter fPrinter;
  
  public TestRunner()
  {
    this(System.out);
  }
  
  public TestRunner(PrintStream paramPrintStream)
  {
    this(new ResultPrinter(paramPrintStream));
  }
  
  public TestRunner(ResultPrinter paramResultPrinter)
  {
    this.fPrinter = paramResultPrinter;
  }
  
  public static void main(String[] paramArrayOfString)
  {
    TestRunner localTestRunner = new TestRunner();
    try
    {
      if (!localTestRunner.start(paramArrayOfString).wasSuccessful()) {
        System.exit(1);
      }
      System.exit(0);
      return;
    }
    catch (Exception paramArrayOfString)
    {
      System.err.println(paramArrayOfString.getMessage());
      System.exit(2);
    }
  }
  
  public static TestResult run(Test paramTest)
  {
    return new TestRunner().doRun(paramTest);
  }
  
  public static void run(Class<? extends TestCase> paramClass)
  {
    run(new TestSuite(paramClass));
  }
  
  public static void runAndWait(Test paramTest)
  {
    new TestRunner().doRun(paramTest, true);
  }
  
  protected TestResult createTestResult()
  {
    return new TestResult();
  }
  
  public TestResult doRun(Test paramTest)
  {
    return doRun(paramTest, false);
  }
  
  public TestResult doRun(Test paramTest, boolean paramBoolean)
  {
    return null;
  }
  
  protected void pause(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.fPrinter.printWaitPrompt();
    try
    {
      System.in.read();
      return;
    }
    catch (Exception localException) {}
  }
  
  /* Error */
  protected void runFailed(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected TestResult runSingleMethod(String paramString1, String paramString2, boolean paramBoolean)
    throws Exception
  {
    return null;
  }
  
  public void setPrinter(ResultPrinter paramResultPrinter)
  {
    this.fPrinter = paramResultPrinter;
  }
  
  public TestResult start(String[] paramArrayOfString)
    throws Exception
  {
    return null;
  }
  
  public void testEnded(String paramString) {}
  
  public void testFailed(int paramInt, Test paramTest, Throwable paramThrowable) {}
  
  public void testStarted(String paramString) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\junit\textui\TestRunner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */