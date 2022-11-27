package com.drew.lang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

public final class StringUtil
{
  public static int compare(String paramString1, String paramString2)
  {
    int i;
    if (paramString1 == null) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (paramString2 == null) {
      j = 1;
    } else {
      j = 0;
    }
    if ((i != 0) && (j != 0)) {
      return 0;
    }
    if (i != 0) {
      return -1;
    }
    if (j != 0) {
      return 1;
    }
    return paramString1.compareTo(paramString2);
  }
  
  public static String fromStream(InputStream paramInputStream)
    throws IOException
  {
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      String str = paramInputStream.readLine();
      if (str == null) {
        break;
      }
      localStringBuilder.append(str);
    }
    return localStringBuilder.toString();
  }
  
  public static String join(Iterable<? extends CharSequence> paramIterable, String paramString)
  {
    int j = paramString.length();
    Object localObject = paramIterable.iterator();
    boolean bool = ((Iterator)localObject).hasNext();
    int i = 0;
    if (bool) {
      i = 0 + (((CharSequence)((Iterator)localObject).next()).length() + j);
    }
    localObject = new StringBuilder(i);
    paramIterable = paramIterable.iterator();
    if (paramIterable.hasNext())
    {
      ((StringBuilder)localObject).append((CharSequence)paramIterable.next());
      while (paramIterable.hasNext())
      {
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append((CharSequence)paramIterable.next());
      }
    }
    return ((StringBuilder)localObject).toString();
  }
  
  public static <T extends CharSequence> String join(T[] paramArrayOfT, String paramString)
  {
    int k = paramString.length();
    int m = paramArrayOfT.length;
    int i = 0;
    int j = 0;
    while (i < m)
    {
      j += paramArrayOfT[i].length() + k;
      i += 1;
    }
    StringBuilder localStringBuilder = new StringBuilder(j);
    k = paramArrayOfT.length;
    j = 1;
    i = 0;
    while (i < k)
    {
      T ? = paramArrayOfT[i];
      if (j == 0) {
        localStringBuilder.append(paramString);
      } else {
        j = 0;
      }
      localStringBuilder.append(?);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String urlEncode(String paramString)
  {
    return paramString.replace(" ", "%20");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\lang\StringUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */