package com.huawei.updatesdk.sdk.service.download;

public class c
  extends Exception
{
  private String a;
  private int b;
  
  public c() {}
  
  public c(int paramInt, String paramString)
  {
    this(paramString);
    this.b = paramInt;
  }
  
  public c(String paramString)
  {
    super(paramString);
    this.a = paramString;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\sdk\service\download\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */