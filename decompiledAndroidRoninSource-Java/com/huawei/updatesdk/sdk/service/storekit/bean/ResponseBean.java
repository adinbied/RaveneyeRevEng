package com.huawei.updatesdk.sdk.service.storekit.bean;

public class ResponseBean
  extends JsonBean
{
  public static final int ERROR = 1;
  public static final int NETWORK_ERROR = 3;
  public static final int OK = 0;
  public static final int PARSE_ERROR = 4;
  public static final int PROGUARD_ERROR = 6;
  public static final int REQ_PARAM_ERROR = 5;
  public static final int RTN_CODE_OK = 0;
  public static final int TIMEOUT = 2;
  private a errCause = a.a;
  private String reason;
  private int responseCode = 1;
  private int rtnCode_ = 0;
  
  public a getErrCause()
  {
    return this.errCause;
  }
  
  public String getReason()
  {
    return this.reason;
  }
  
  public int getResponseCode()
  {
    return this.responseCode;
  }
  
  public int getRtnCode_()
  {
    return this.rtnCode_;
  }
  
  public void setErrCause(a parama)
  {
    this.errCause = parama;
  }
  
  public void setReason(String paramString)
  {
    this.reason = paramString;
  }
  
  public void setResponseCode(int paramInt)
  {
    this.responseCode = paramInt;
  }
  
  public void setRtnCode_(int paramInt)
  {
    this.rtnCode_ = paramInt;
  }
  
  public String toString()
  {
    return null;
  }
  
  public static enum a
  {
    static
    {
      a locala = new a("NO_PROGUARD", 7);
      h = locala;
      i = new a[] { a, b, c, d, e, f, g, locala };
    }
    
    private a() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\sdk\service\storekit\bean\ResponseBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */