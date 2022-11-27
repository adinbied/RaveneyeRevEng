package com.google.firebase.crashlytics.internal.stacktrace;

import java.util.HashMap;
import java.util.Map;

public class RemoveRepeatsStrategy
  implements StackTraceTrimmingStrategy
{
  private final int maxRepetitions;
  
  public RemoveRepeatsStrategy()
  {
    this(1);
  }
  
  public RemoveRepeatsStrategy(int paramInt)
  {
    this.maxRepetitions = paramInt;
  }
  
  private static boolean isRepeatingSequence(StackTraceElement[] paramArrayOfStackTraceElement, int paramInt1, int paramInt2)
  {
    int j = paramInt2 - paramInt1;
    if (paramInt2 + j > paramArrayOfStackTraceElement.length) {
      return false;
    }
    int i = 0;
    while (i < j)
    {
      if (!paramArrayOfStackTraceElement[(paramInt1 + i)].equals(paramArrayOfStackTraceElement[(paramInt2 + i)])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static StackTraceElement[] trimRepeats(StackTraceElement[] paramArrayOfStackTraceElement, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    StackTraceElement[] arrayOfStackTraceElement = new StackTraceElement[paramArrayOfStackTraceElement.length];
    int i = 0;
    int m = 0;
    int j = 1;
    while (i < paramArrayOfStackTraceElement.length)
    {
      StackTraceElement localStackTraceElement = paramArrayOfStackTraceElement[i];
      Integer localInteger = (Integer)localHashMap.get(localStackTraceElement);
      int k;
      if ((localInteger != null) && (isRepeatingSequence(paramArrayOfStackTraceElement, localInteger.intValue(), i)))
      {
        int i1 = i - localInteger.intValue();
        int n = m;
        k = j;
        if (j < paramInt)
        {
          System.arraycopy(paramArrayOfStackTraceElement, i, arrayOfStackTraceElement, m, i1);
          n = m + i1;
          k = j + 1;
        }
        i1 = i1 - 1 + i;
        m = n;
        j = k;
        k = i1;
      }
      else
      {
        arrayOfStackTraceElement[m] = paramArrayOfStackTraceElement[i];
        m += 1;
        k = i;
        j = 1;
      }
      localHashMap.put(localStackTraceElement, Integer.valueOf(i));
      i = k + 1;
    }
    paramArrayOfStackTraceElement = new StackTraceElement[m];
    System.arraycopy(arrayOfStackTraceElement, 0, paramArrayOfStackTraceElement, 0, m);
    return paramArrayOfStackTraceElement;
  }
  
  public StackTraceElement[] getTrimmedStackTrace(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    StackTraceElement[] arrayOfStackTraceElement = trimRepeats(paramArrayOfStackTraceElement, this.maxRepetitions);
    if (arrayOfStackTraceElement.length < paramArrayOfStackTraceElement.length) {
      return arrayOfStackTraceElement;
    }
    return paramArrayOfStackTraceElement;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\stacktrace\RemoveRepeatsStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */