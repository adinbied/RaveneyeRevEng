package com.google.firebase.crashlytics.internal.common;

public class ResponseParser
{
  public static final int ResponseActionDiscard = 0;
  public static final int ResponseActionRetry = 1;
  
  public static int parse(int paramInt)
  {
    if ((paramInt >= 200) && (paramInt <= 299)) {
      return 0;
    }
    if ((paramInt >= 300) && (paramInt <= 399)) {
      return 1;
    }
    if ((paramInt >= 400) && (paramInt <= 499)) {
      return 0;
    }
    if (paramInt >= 500) {}
    return 1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\common\ResponseParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */