package com.google.firebase.crashlytics.internal.ndk;

import com.google.firebase.crashlytics.internal.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class ProcMapEntryParser
{
  private static final Pattern MAP_REGEX = Pattern.compile("\\s*(\\p{XDigit}+)-\\s*(\\p{XDigit}+)\\s+(.{4})\\s+\\p{XDigit}+\\s+.+\\s+\\d+\\s+(.*)");
  
  static ProcMapEntry parse(String paramString)
  {
    Object localObject = MAP_REGEX.matcher(paramString);
    if (!((Matcher)localObject).matches()) {
      return null;
    }
    try
    {
      long l = Long.valueOf(((Matcher)localObject).group(1), 16).longValue();
      localObject = new ProcMapEntry(l, Long.valueOf(((Matcher)localObject).group(2), 16).longValue() - l, ((Matcher)localObject).group(3), ((Matcher)localObject).group(4));
      return (ProcMapEntry)localObject;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder;
      for (;;) {}
    }
    localObject = Logger.getLogger();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Could not parse map entry: ");
    localStringBuilder.append(paramString);
    ((Logger)localObject).d(localStringBuilder.toString());
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\ndk\ProcMapEntryParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */