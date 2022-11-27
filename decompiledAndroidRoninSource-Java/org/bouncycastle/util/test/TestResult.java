package org.bouncycastle.util.test;

public abstract interface TestResult
{
  public abstract Throwable getException();
  
  public abstract boolean isSuccessful();
  
  public abstract String toString();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\test\TestResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */