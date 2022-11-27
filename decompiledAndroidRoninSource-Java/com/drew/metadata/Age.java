package com.drew.metadata;

public class Age
{
  private final int _days;
  private final int _hours;
  private final int _minutes;
  private final int _months;
  private final int _seconds;
  private final int _years;
  
  public Age(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this._years = paramInt1;
    this._months = paramInt2;
    this._days = paramInt3;
    this._hours = paramInt4;
    this._minutes = paramInt5;
    this._seconds = paramInt6;
  }
  
  private static void appendAgePart(StringBuilder paramStringBuilder, int paramInt, String paramString)
  {
    if (paramInt == 0) {
      return;
    }
    if (paramStringBuilder.length() != 0) {
      paramStringBuilder.append(' ');
    }
    paramStringBuilder.append(paramInt);
    paramStringBuilder.append(' ');
    paramStringBuilder.append(paramString);
    if (paramInt != 1) {
      paramStringBuilder.append('s');
    }
  }
  
  public static Age fromPanasonicString(String paramString)
  {
    if (paramString.length() == 19) {
      if (paramString.startsWith("9999:99:99")) {
        return null;
      }
    }
    try
    {
      paramString = new Age(Integer.parseInt(paramString.substring(0, 4)), Integer.parseInt(paramString.substring(5, 7)), Integer.parseInt(paramString.substring(8, 10)), Integer.parseInt(paramString.substring(11, 13)), Integer.parseInt(paramString.substring(14, 16)), Integer.parseInt(paramString.substring(17, 19)));
      return paramString;
    }
    catch (NumberFormatException paramString) {}
    return null;
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int getDays()
  {
    return this._days;
  }
  
  public int getHours()
  {
    return this._hours;
  }
  
  public int getMinutes()
  {
    return this._minutes;
  }
  
  public int getMonths()
  {
    return this._months;
  }
  
  public int getSeconds()
  {
    return this._seconds;
  }
  
  public int getYears()
  {
    return this._years;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toFriendlyString()
  {
    return null;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\Age.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */