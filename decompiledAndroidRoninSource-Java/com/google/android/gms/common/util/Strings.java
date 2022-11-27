package com.google.android.gms.common.util;

import android.text.TextUtils;
import java.util.regex.Pattern;

public class Strings
{
  private static final Pattern zzhh = Pattern.compile("\\$\\{(.*?)\\}");
  
  public static String emptyToNull(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = null;
    }
    return str;
  }
  
  public static boolean isEmptyOrWhitespace(String paramString)
  {
    return (paramString == null) || (paramString.trim().isEmpty());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\commo\\util\Strings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */