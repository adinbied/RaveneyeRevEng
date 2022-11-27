package junit.textui;

import java.io.PrintStream;
import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestFailure;
import junit.framework.TestListener;
import junit.framework.TestResult;

public class ResultPrinter
  implements TestListener
{
  int fColumn = 0;
  PrintStream fWriter;
  
  public ResultPrinter(PrintStream paramPrintStream)
  {
    this.fWriter = paramPrintStream;
  }
  
  public void addError(Test paramTest, Throwable paramThrowable)
  {
    getWriter().print("E");
  }
  
  public void addFailure(Test paramTest, AssertionFailedError paramAssertionFailedError)
  {
    getWriter().print("F");
  }
  
  protected String elapsedTimeAsString(long paramLong)
  {
    return null;
  }
  
  public void endTest(Test paramTest) {}
  
  public PrintStream getWriter()
  {
    return this.fWriter;
  }
  
  void print(TestResult paramTestResult, long paramLong)
  {
    try
    {
      printHeader(paramLong);
      printErrors(paramTestResult);
      printFailures(paramTestResult);
      printFooter(paramTestResult);
      return;
    }
    finally
    {
      paramTestResult = finally;
      throw paramTestResult;
    }
  }
  
  public void printDefect(TestFailure paramTestFailure, int paramInt)
  {
    printDefectHeader(paramTestFailure, paramInt);
    printDefectTrace(paramTestFailure);
  }
  
  /* Error */
  protected void printDefectHeader(TestFailure arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void printDefectTrace(TestFailure arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void printDefects(java.util.Enumeration<TestFailure> arg1, int arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void printErrors(TestResult arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void printFailures(TestResult arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void printFooter(TestResult arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void printHeader(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void printWaitPrompt()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void startTest(Test arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\junit\textui\ResultPrinter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */