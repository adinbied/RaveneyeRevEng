package com.huawei.hms.support.api.pay;

import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.entity.pay.OrderResp;

public class OrderResult
  extends Result
{
  private int a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  
  public OrderResult() {}
  
  public OrderResult(OrderResp paramOrderResp)
  {
    a(paramOrderResp.getReturnCode());
    a(paramOrderResp.getReturnDesc());
    b(paramOrderResp.getRequestId());
    c(paramOrderResp.getOrderID());
    d(paramOrderResp.getOrderTime());
    e(paramOrderResp.getTradeTime());
    f(paramOrderResp.getStatus());
    g(paramOrderResp.getSign());
  }
  
  private static <T> T a(T paramT)
  {
    return paramT;
  }
  
  private void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  private void a(String paramString)
  {
    this.b = paramString;
  }
  
  private void b(String paramString)
  {
    this.c = paramString;
  }
  
  private void c(String paramString)
  {
    this.d = paramString;
  }
  
  private void d(String paramString)
  {
    this.e = paramString;
  }
  
  private void e(String paramString)
  {
    this.f = paramString;
  }
  
  private void f(String paramString)
  {
    this.g = paramString;
  }
  
  private void g(String paramString)
  {
    this.h = paramString;
  }
  
  public String getOrderID()
  {
    return null;
  }
  
  public String getOrderStatus()
  {
    return null;
  }
  
  public String getOrderTime()
  {
    return null;
  }
  
  public String getRequestId()
  {
    return null;
  }
  
  public int getReturnCode()
  {
    return 0;
  }
  
  public String getReturnDesc()
  {
    return null;
  }
  
  public String getSign()
  {
    return null;
  }
  
  public String getTradeTime()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\pay\OrderResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */