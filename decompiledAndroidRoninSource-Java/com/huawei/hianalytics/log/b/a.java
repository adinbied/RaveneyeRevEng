package com.huawei.hianalytics.log.b;

import java.io.File;

public class a
  extends com.huawei.hianalytics.global.a
{
  public static class a
  {
    public static final String a;
    public static final String b;
    public static final String c;
    public static final String d;
    
    static
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(File.separator);
      localStringBuilder.append("hianalytics");
      localStringBuilder.append(File.separator);
      localStringBuilder.append("applog");
      a = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(a);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("logs");
      b = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(a);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("logzips");
      c = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(a);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("bigzip");
      d = localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\log\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */