package com.facebook.common.internal;

public class Ints
{
  public static int max(int... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 1;
    boolean bool;
    if (j > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    int k;
    for (j = paramVarArgs[0]; i < paramVarArgs.length; j = k)
    {
      k = j;
      if (paramVarArgs[i] > j) {
        k = paramVarArgs[i];
      }
      i += 1;
    }
    return j;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\internal\Ints.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */