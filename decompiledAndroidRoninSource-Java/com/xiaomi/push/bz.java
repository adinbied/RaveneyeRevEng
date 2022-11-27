package com.xiaomi.push;

public class bz
  extends cd.d
{
  protected String a = "MessageDeleteJob";
  
  public bz(String paramString1, String paramString2, String[] paramArrayOfString, String paramString3)
  {
    super(paramString1, paramString2, paramArrayOfString);
    this.a = paramString3;
  }
  
  public static bz a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("status = ?");
    return new bz(paramString, localStringBuilder.toString(), new String[] { String.valueOf(2) }, "a job build to delete uploaded job");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */