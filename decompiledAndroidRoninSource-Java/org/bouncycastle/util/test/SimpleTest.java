package org.bouncycastle.util.test;

import java.io.PrintStream;
import org.bouncycastle.util.Arrays;

public abstract class SimpleTest
  implements Test
{
  protected static void runTest(Test paramTest)
  {
    runTest(paramTest, System.out);
  }
  
  protected static void runTest(Test paramTest, PrintStream paramPrintStream)
  {
    paramTest = paramTest.perform();
    paramPrintStream.println(paramTest.toString());
    if (paramTest.getException() != null) {
      paramTest.getException().printStackTrace(paramPrintStream);
    }
  }
  
  private TestResult success()
  {
    return SimpleTestResult.successful(this, "Okay");
  }
  
  protected boolean areEqual(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return Arrays.areEqual(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  protected boolean areEqual(byte[][] paramArrayOfByte1, byte[][] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) && (paramArrayOfByte2 == null)) {
      return true;
    }
    if (paramArrayOfByte1 != null)
    {
      if (paramArrayOfByte2 == null) {
        return false;
      }
      if (paramArrayOfByte1.length != paramArrayOfByte2.length) {
        return false;
      }
      int i = 0;
      while (i < paramArrayOfByte1.length) {
        if (areEqual(paramArrayOfByte1[i], paramArrayOfByte2[i])) {
          i += 1;
        } else {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  protected void fail(String paramString)
  {
    throw new TestFailedException(SimpleTestResult.failed(this, paramString));
  }
  
  protected void fail(String paramString, Object paramObject1, Object paramObject2)
  {
    throw new TestFailedException(SimpleTestResult.failed(this, paramString, paramObject1, paramObject2));
  }
  
  protected void fail(String paramString, Throwable paramThrowable)
  {
    throw new TestFailedException(SimpleTestResult.failed(this, paramString, paramThrowable));
  }
  
  public abstract String getName();
  
  protected void isEquals(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    throw new TestFailedException(SimpleTestResult.failed(this, "no message"));
  }
  
  protected void isEquals(Object paramObject1, Object paramObject2)
  {
    if (paramObject1.equals(paramObject2)) {
      return;
    }
    throw new TestFailedException(SimpleTestResult.failed(this, "no message"));
  }
  
  protected void isEquals(String paramString, long paramLong1, long paramLong2)
  {
    if (paramLong1 == paramLong2) {
      return;
    }
    throw new TestFailedException(SimpleTestResult.failed(this, paramString));
  }
  
  protected void isEquals(String paramString, Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) && (paramObject2 == null)) {
      return;
    }
    if (paramObject1 != null)
    {
      if (paramObject2 != null)
      {
        if (paramObject1.equals(paramObject2)) {
          return;
        }
        throw new TestFailedException(SimpleTestResult.failed(this, paramString));
      }
      throw new TestFailedException(SimpleTestResult.failed(this, paramString));
    }
    throw new TestFailedException(SimpleTestResult.failed(this, paramString));
  }
  
  protected void isEquals(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1 == paramBoolean2) {
      return;
    }
    throw new TestFailedException(SimpleTestResult.failed(this, paramString));
  }
  
  protected void isTrue(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new TestFailedException(SimpleTestResult.failed(this, paramString));
  }
  
  protected void isTrue(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new TestFailedException(SimpleTestResult.failed(this, "no message"));
  }
  
  public TestResult perform()
  {
    try
    {
      performTest();
      TestResult localTestResult = success();
      return localTestResult;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Exception: ");
      localStringBuilder.append(localException);
      return SimpleTestResult.failed(this, localStringBuilder.toString(), localException);
    }
    catch (TestFailedException localTestFailedException)
    {
      return localTestFailedException.getResult();
    }
  }
  
  public abstract void performTest()
    throws Exception;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\test\SimpleTest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */