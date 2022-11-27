package com.google.android.datatransport.cct;

public final class zzd
{
  static String zza(String paramString1, String paramString2)
  {
    int i = paramString1.length() - paramString2.length();
    if ((i >= 0) && (i <= 1))
    {
      i = paramString1.length();
      StringBuilder localStringBuilder = new StringBuilder(paramString2.length() + i);
      i = 0;
      while (i < paramString1.length())
      {
        localStringBuilder.append(paramString1.charAt(i));
        if (paramString2.length() > i) {
          localStringBuilder.append(paramString2.charAt(i));
        }
        i += 1;
      }
      return localStringBuilder.toString();
    }
    throw new IllegalArgumentException("Invalid input received");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\cct\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */