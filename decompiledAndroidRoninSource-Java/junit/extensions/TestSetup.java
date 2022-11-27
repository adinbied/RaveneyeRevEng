package junit.extensions;

import junit.framework.Protectable;
import junit.framework.Test;
import junit.framework.TestResult;

public class TestSetup
  extends TestDecorator
{
  public TestSetup(Test paramTest)
  {
    super(paramTest);
  }
  
  /* Error */
  public void run(TestResult arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void setUp()
    throws Exception
  {}
  
  protected void tearDown()
    throws Exception
  {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\junit\extensions\TestSetup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */