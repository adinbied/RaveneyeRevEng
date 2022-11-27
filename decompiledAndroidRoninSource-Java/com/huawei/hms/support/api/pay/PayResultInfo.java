package com.huawei.hms.support.api.pay;

public class PayResultInfo
{
  private int a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  
  public String getAmount()
  {
    return this.d;
  }
  
  public String getCountry()
  {
    return this.f;
  }
  
  public String getCurrency()
  {
    return this.e;
  }
  
  public String getErrMsg()
  {
    return this.b;
  }
  
  public String getOrderID()
  {
    return this.c;
  }
  
  public String getRequestId()
  {
    return this.i;
  }
  
  public int getReturnCode()
  {
    return this.a;
  }
  
  public String getSign()
  {
    return this.k;
  }
  
  public String getTime()
  {
    return this.g;
  }
  
  public String getUserName()
  {
    return this.j;
  }
  
  public String getWithholdID()
  {
    return this.h;
  }
  
  public void setAmount(String paramString)
  {
    this.d = paramString;
  }
  
  public void setCountry(String paramString)
  {
    this.f = paramString;
  }
  
  public void setCurrency(String paramString)
  {
    this.e = paramString;
  }
  
  public void setErrMsg(String paramString)
  {
    this.b = paramString;
  }
  
  public void setOrderID(String paramString)
  {
    this.c = paramString;
  }
  
  public void setRequestId(String paramString)
  {
    this.i = paramString;
  }
  
  public void setReturnCode(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setSign(String paramString)
  {
    this.k = paramString;
  }
  
  public void setTime(String paramString)
  {
    this.g = paramString;
  }
  
  public void setUserName(String paramString)
  {
    this.j = paramString;
  }
  
  public void setWithholdID(String paramString)
  {
    this.h = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\pay\PayResultInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */