package junit.framework;

public abstract interface TestListener
{
  public abstract void addError(Test paramTest, Throwable paramThrowable);
  
  public abstract void addFailure(Test paramTest, AssertionFailedError paramAssertionFailedError);
  
  public abstract void endTest(Test paramTest);
  
  public abstract void startTest(Test paramTest);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\junit\framework\TestListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */