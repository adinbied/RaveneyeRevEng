package com.xiaomi.push;

import java.net.InetSocketAddress;

public final class cz
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  
  public cz(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static cz a(String paramString, int paramInt)
  {
    int j = paramString.lastIndexOf(":");
    String str = paramString;
    int i = paramInt;
    if (j != -1) {
      str = paramString.substring(0, j);
    }
    try
    {
      i = Integer.parseInt(paramString.substring(j + 1));
      if (i > 0) {
        paramInt = i;
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;) {}
    }
    i = paramInt;
    return new cz(str, i);
  }
  
  public static InetSocketAddress a(String paramString, int paramInt)
  {
    paramString = a(paramString, paramInt);
    return new InetSocketAddress(paramString.a(), paramString.a());
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */