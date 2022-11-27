package com.xiaomi.push;

import java.util.Comparator;
import org.apache.http.NameValuePair;

final class cu
  implements Comparator<NameValuePair>
{
  public int a(NameValuePair paramNameValuePair1, NameValuePair paramNameValuePair2)
  {
    return paramNameValuePair1.getName().compareTo(paramNameValuePair2.getName());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\cu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */