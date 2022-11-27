package org.bouncycastle.util;

public class IPAddress
{
  private static boolean isMaskValue(String paramString, int paramInt)
  {
    boolean bool2 = false;
    try
    {
      int i = Integer.parseInt(paramString);
      boolean bool1 = bool2;
      if (i >= 0)
      {
        bool1 = bool2;
        if (i <= paramInt) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (NumberFormatException paramString) {}
    return false;
  }
  
  public static boolean isValid(String paramString)
  {
    return (isValidIPv4(paramString)) || (isValidIPv6(paramString));
  }
  
  public static boolean isValidIPv4(String paramString)
  {
    int i = paramString.length();
    boolean bool = false;
    if (i == 0) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".");
    paramString = localStringBuilder.toString();
    int j = 0;
    i = 0;
    for (;;)
    {
      int k;
      if (j < paramString.length())
      {
        k = paramString.indexOf('.', j);
        if (k > j) {
          if (i == 4) {
            return false;
          }
        }
      }
      try
      {
        j = Integer.parseInt(paramString.substring(j, k));
        if (j >= 0)
        {
          if (j > 255) {
            return false;
          }
          j = k + 1;
          i += 1;
        }
        else
        {
          return false;
        }
      }
      catch (NumberFormatException paramString) {}
    }
    if (i == 4) {
      bool = true;
    }
    return bool;
    return false;
  }
  
  public static boolean isValidIPv4WithNetmask(String paramString)
  {
    int i = paramString.indexOf("/");
    String str = paramString.substring(i + 1);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i > 0)
    {
      bool1 = bool2;
      if (isValidIPv4(paramString.substring(0, i))) {
        if (!isValidIPv4(str))
        {
          bool1 = bool2;
          if (!isMaskValue(str, 32)) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean isValidIPv6(String paramString)
  {
    int i = paramString.length();
    boolean bool = false;
    if (i == 0) {
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(":");
    paramString = ((StringBuilder)localObject).toString();
    int k = 0;
    i = 0;
    int j = 0;
    for (;;)
    {
      int m;
      if (k < paramString.length())
      {
        m = paramString.indexOf(':', k);
        if (m >= k)
        {
          if (i == 8) {
            return false;
          }
          if (k != m)
          {
            localObject = paramString.substring(k, m);
            if ((m == paramString.length() - 1) && (((String)localObject).indexOf('.') > 0))
            {
              if (!isValidIPv4((String)localObject)) {
                return false;
              }
              i += 1;
              break label184;
            }
          }
        }
      }
      try
      {
        k = Integer.parseInt(paramString.substring(k, m), 16);
        if ((k < 0) || (k > 65535))
        {
          return false;
          if ((m != 1) && (m != paramString.length() - 1) && (j != 0)) {
            return false;
          }
          j = 1;
        }
        label184:
        k = m + 1;
        i += 1;
      }
      catch (NumberFormatException paramString) {}
    }
    if ((i == 8) || (j != 0)) {
      bool = true;
    }
    return bool;
    return false;
  }
  
  public static boolean isValidIPv6WithNetmask(String paramString)
  {
    int i = paramString.indexOf("/");
    String str = paramString.substring(i + 1);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i > 0)
    {
      bool1 = bool2;
      if (isValidIPv6(paramString.substring(0, i))) {
        if (!isValidIPv6(str))
        {
          bool1 = bool2;
          if (!isMaskValue(str, 128)) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean isValidWithNetMask(String paramString)
  {
    return (isValidIPv4WithNetmask(paramString)) || (isValidIPv6WithNetmask(paramString));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\IPAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */