package com.google.firebase.crashlytics.internal.stacktrace;

public class MiddleOutFallbackStrategy
  implements StackTraceTrimmingStrategy
{
  private final int maximumStackSize;
  private final MiddleOutStrategy middleOutStrategy;
  private final StackTraceTrimmingStrategy[] trimmingStrategies;
  
  public MiddleOutFallbackStrategy(int paramInt, StackTraceTrimmingStrategy... paramVarArgs)
  {
    this.maximumStackSize = paramInt;
    this.trimmingStrategies = paramVarArgs;
    this.middleOutStrategy = new MiddleOutStrategy(paramInt);
  }
  
  public StackTraceElement[] getTrimmedStackTrace(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    if (paramArrayOfStackTraceElement.length <= this.maximumStackSize) {
      return paramArrayOfStackTraceElement;
    }
    StackTraceTrimmingStrategy[] arrayOfStackTraceTrimmingStrategy = this.trimmingStrategies;
    int j = arrayOfStackTraceTrimmingStrategy.length;
    int i = 0;
    StackTraceElement[] arrayOfStackTraceElement = paramArrayOfStackTraceElement;
    while (i < j)
    {
      StackTraceTrimmingStrategy localStackTraceTrimmingStrategy = arrayOfStackTraceTrimmingStrategy[i];
      if (arrayOfStackTraceElement.length <= this.maximumStackSize) {
        break;
      }
      arrayOfStackTraceElement = localStackTraceTrimmingStrategy.getTrimmedStackTrace(paramArrayOfStackTraceElement);
      i += 1;
    }
    paramArrayOfStackTraceElement = arrayOfStackTraceElement;
    if (arrayOfStackTraceElement.length > this.maximumStackSize) {
      paramArrayOfStackTraceElement = this.middleOutStrategy.getTrimmedStackTrace(arrayOfStackTraceElement);
    }
    return paramArrayOfStackTraceElement;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\stacktrace\MiddleOutFallbackStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */