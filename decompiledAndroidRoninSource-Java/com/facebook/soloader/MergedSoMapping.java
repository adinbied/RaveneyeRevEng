package com.facebook.soloader;

import javax.annotation.Nullable;

class MergedSoMapping
{
  static void invokeJniOnload(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unknown library: ");
    localStringBuilder.append(paramString);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  @Nullable
  static String mapLibName(String paramString)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\soloader\MergedSoMapping.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */