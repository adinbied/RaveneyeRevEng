package org.bouncycastle.util.test;

import org.bouncycastle.util.Strings;

public class SimpleTestResult
  implements TestResult
{
  private static final String SEPARATOR = ;
  private Throwable exception;
  private String message;
  private boolean success;
  
  public SimpleTestResult(boolean paramBoolean, String paramString)
  {
    this.success = paramBoolean;
    this.message = paramString;
  }
  
  public SimpleTestResult(boolean paramBoolean, String paramString, Throwable paramThrowable)
  {
    this.success = paramBoolean;
    this.message = paramString;
    this.exception = paramThrowable;
  }
  
  public static TestResult failed(Test paramTest, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramTest.getName());
    localStringBuilder.append(": ");
    localStringBuilder.append(paramString);
    return new SimpleTestResult(false, localStringBuilder.toString());
  }
  
  public static TestResult failed(Test paramTest, String paramString, Object paramObject1, Object paramObject2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(SEPARATOR);
    localStringBuilder.append("Expected: ");
    localStringBuilder.append(paramObject1);
    localStringBuilder.append(SEPARATOR);
    localStringBuilder.append("Found   : ");
    localStringBuilder.append(paramObject2);
    return failed(paramTest, localStringBuilder.toString());
  }
  
  public static TestResult failed(Test paramTest, String paramString, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramTest.getName());
    localStringBuilder.append(": ");
    localStringBuilder.append(paramString);
    return new SimpleTestResult(false, localStringBuilder.toString(), paramThrowable);
  }
  
  public static String failedMessage(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = new StringBuffer(paramString1);
    paramString1.append(" failing ");
    paramString1.append(paramString2);
    paramString1.append(SEPARATOR);
    paramString1.append("    expected: ");
    paramString1.append(paramString3);
    paramString1.append(SEPARATOR);
    paramString1.append("    got     : ");
    paramString1.append(paramString4);
    return paramString1.toString();
  }
  
  public static TestResult successful(Test paramTest, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramTest.getName());
    localStringBuilder.append(": ");
    localStringBuilder.append(paramString);
    return new SimpleTestResult(true, localStringBuilder.toString());
  }
  
  public Throwable getException()
  {
    return this.exception;
  }
  
  public boolean isSuccessful()
  {
    return this.success;
  }
  
  public String toString()
  {
    return this.message;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\test\SimpleTestResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */