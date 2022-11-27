package com.google.gson.internal;

public final class JavaVersion
{
  private static final int majorJavaVersion = ;
  
  private static int determineMajorJavaVersion()
  {
    return getMajorJavaVersion(System.getProperty("java.version"));
  }
  
  private static int extractBeginningInt(String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < paramString.length())
      {
        char c = paramString.charAt(i);
        if (!Character.isDigit(c)) {
          break;
        }
        localStringBuilder.append(c);
        i += 1;
      }
      i = Integer.parseInt(localStringBuilder.toString());
      return i;
    }
    catch (NumberFormatException paramString)
    {
      for (;;) {}
    }
    return -1;
  }
  
  public static int getMajorJavaVersion()
  {
    return majorJavaVersion;
  }
  
  static int getMajorJavaVersion(String paramString)
  {
    int j = parseDotted(paramString);
    int i = j;
    if (j == -1) {
      i = extractBeginningInt(paramString);
    }
    if (i == -1) {
      return 6;
    }
    return i;
  }
  
  public static boolean isJava9OrLater()
  {
    return majorJavaVersion >= 9;
  }
  
  private static int parseDotted(String paramString)
  {
    try
    {
      paramString = paramString.split("[._]");
      int i = Integer.parseInt(paramString[0]);
      if ((i == 1) && (paramString.length > 1))
      {
        i = Integer.parseInt(paramString[1]);
        return i;
      }
      return i;
    }
    catch (NumberFormatException paramString)
    {
      for (;;) {}
    }
    return -1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\gson\internal\JavaVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */