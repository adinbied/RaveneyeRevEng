package junit.framework;

public class TestFailure
{
  protected Test fFailedTest;
  protected Throwable fThrownException;
  
  public TestFailure(Test paramTest, Throwable paramThrowable)
  {
    this.fFailedTest = paramTest;
    this.fThrownException = paramThrowable;
  }
  
  public String exceptionMessage()
  {
    return null;
  }
  
  public Test failedTest()
  {
    return this.fFailedTest;
  }
  
  public boolean isFailure()
  {
    return thrownException() instanceof AssertionFailedError;
  }
  
  public Throwable thrownException()
  {
    return this.fThrownException;
  }
  
  public String toString()
  {
    return null;
  }
  
  public String trace()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\junit\framework\TestFailure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */