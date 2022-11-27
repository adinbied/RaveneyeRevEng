package com.google.android.gms.common.util;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzd
{
  private static final Pattern zzhi = Pattern.compile("\\\\u[0-9a-fA-F]{4}");
  
  public static String unescape(String paramString)
  {
    Object localObject1 = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      Matcher localMatcher = zzhi.matcher(paramString);
      Object localObject2;
      for (localObject1 = null; localMatcher.find(); localObject1 = localObject2)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new StringBuffer();
        }
        localMatcher.appendReplacement((StringBuffer)localObject2, new String(Character.toChars(Integer.parseInt(localMatcher.group().substring(2), 16))));
      }
      if (localObject1 == null) {
        return paramString;
      }
      localMatcher.appendTail((StringBuffer)localObject1);
      localObject1 = ((StringBuffer)localObject1).toString();
    }
    return (String)localObject1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\commo\\util\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */