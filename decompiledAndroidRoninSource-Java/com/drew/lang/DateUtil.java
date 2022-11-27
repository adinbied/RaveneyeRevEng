package com.drew.lang;

public class DateUtil
{
  private static int[] _daysInMonth365 = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
  
  public static boolean isValidDate(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 >= 1)
    {
      bool1 = bool2;
      if (paramInt1 <= 9999)
      {
        bool1 = bool2;
        if (paramInt2 >= 0)
        {
          if (paramInt2 > 11) {
            return false;
          }
          int j = _daysInMonth365[paramInt2];
          int i = j;
          if (paramInt2 == 1)
          {
            if ((paramInt1 % 4 == 0) && ((paramInt1 % 100 != 0) || (paramInt1 % 400 == 0))) {
              paramInt1 = 1;
            } else {
              paramInt1 = 0;
            }
            i = j;
            if (paramInt1 != 0) {
              i = j + 1;
            }
          }
          bool1 = bool2;
          if (paramInt3 >= 1)
          {
            bool1 = bool2;
            if (paramInt3 <= i) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean isValidTime(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 >= 0) && (paramInt1 < 24) && (paramInt2 >= 0) && (paramInt2 < 60) && (paramInt3 >= 0) && (paramInt3 < 60);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\lang\DateUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */