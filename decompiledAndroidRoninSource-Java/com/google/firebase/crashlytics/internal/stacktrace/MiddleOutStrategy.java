package com.google.firebase.crashlytics.internal.stacktrace;

public class MiddleOutStrategy
  implements StackTraceTrimmingStrategy
{
  private final int trimmedSize;
  
  public MiddleOutStrategy(int paramInt)
  {
    this.trimmedSize = paramInt;
  }
  
  public StackTraceElement[] getTrimmedStackTrace(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    int j = paramArrayOfStackTraceElement.length;
    int i = this.trimmedSize;
    if (j <= i) {
      return paramArrayOfStackTraceElement;
    }
    j = i / 2;
    int k = i - j;
    StackTraceElement[] arrayOfStackTraceElement = new StackTraceElement[i];
    System.arraycopy(paramArrayOfStackTraceElement, 0, arrayOfStackTraceElement, 0, k);
    System.arraycopy(paramArrayOfStackTraceElement, paramArrayOfStackTraceElement.length - j, arrayOfStackTraceElement, k, j);
    return arrayOfStackTraceElement;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\stacktrace\MiddleOutStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */