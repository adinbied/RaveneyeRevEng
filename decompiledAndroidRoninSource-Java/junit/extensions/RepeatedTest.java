package junit.extensions;

import junit.framework.Test;

public class RepeatedTest
  extends TestDecorator
{
  private int fTimesRepeat;
  
  public RepeatedTest(Test paramTest, int paramInt)
  {
    super(paramTest);
    if (paramInt >= 0)
    {
      this.fTimesRepeat = paramInt;
      return;
    }
    throw new IllegalArgumentException("Repetition count must be >= 0");
  }
  
  public int countTestCases()
  {
    return 0;
  }
  
  /* Error */
  public void run(junit.framework.TestResult arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\junit\extensions\RepeatedTest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */