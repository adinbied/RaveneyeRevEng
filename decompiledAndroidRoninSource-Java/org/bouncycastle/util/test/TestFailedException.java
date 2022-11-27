package org.bouncycastle.util.test;

public class TestFailedException
  extends RuntimeException
{
  private TestResult _result;
  
  public TestFailedException(TestResult paramTestResult)
  {
    this._result = paramTestResult;
  }
  
  public TestResult getResult()
  {
    return this._result;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\test\TestFailedException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */