package com.facebook.soloader;

import android.os.Trace;
import javax.annotation.Nullable;

class Api18TraceUtils
{
  private static final int MAX_SECTION_NAME_LENGTH = 127;
  
  public static void beginTraceSection(String paramString1, @Nullable String paramString2, String paramString3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(paramString3);
    String str = ((StringBuilder)localObject).toString();
    localObject = str;
    if (str.length() > 127)
    {
      localObject = str;
      if (paramString2 != null)
      {
        int i = paramString1.length();
        int j = paramString3.length();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(paramString2.substring(0, 127 - i - j));
        ((StringBuilder)localObject).append(paramString3);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    Trace.beginSection((String)localObject);
  }
  
  public static void endSection() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\soloader\Api18TraceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */