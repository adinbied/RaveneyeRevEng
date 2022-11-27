package com.huawei.updatesdk.sdk.service.storekit.bean;

import java.lang.reflect.Field;
import java.util.Map;

public class RequestBean
{
  public static final String END_FLAG = "_";
  private String method_;
  private String sessionID;
  private String storeApi;
  private String url;
  private String ver_ = "1.1";
  
  public String genBody()
    throws IllegalAccessException, IllegalArgumentException, ArrayIndexOutOfBoundsException
  {
    return null;
  }
  
  public String getMethod_()
  {
    return this.method_;
  }
  
  protected Map<String, Field> getParam()
  {
    return null;
  }
  
  public String getReqUrl()
  {
    return null;
  }
  
  public String getStoreApi()
  {
    return this.storeApi;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  protected String getValue(Field paramField)
    throws IllegalAccessException, IllegalArgumentException
  {
    return null;
  }
  
  public String getVer_()
  {
    return this.ver_;
  }
  
  protected void onSetValue() {}
  
  public void setMethod_(String paramString)
  {
    this.method_ = paramString;
  }
  
  public void setStoreApi(String paramString)
  {
    this.storeApi = paramString;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void setVer_(String paramString)
  {
    this.ver_ = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\sdk\service\storekit\bean\RequestBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */