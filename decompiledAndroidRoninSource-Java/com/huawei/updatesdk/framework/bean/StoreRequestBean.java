package com.huawei.updatesdk.framework.bean;

import android.content.Context;
import com.huawei.updatesdk.sdk.service.storekit.bean.RequestBean;
import com.huawei.updatesdk.service.a.a.a;

public class StoreRequestBean
  extends RequestBean
{
  public static final String TLS_API = "tlsApis";
  private String clientPackage_ = null;
  private String cno_ = null;
  private String code_ = null;
  private boolean isSerial = false;
  private String iv_ = null;
  private String locale_ = null;
  private boolean needSign = true;
  private String net_ = null;
  private String salt_ = null;
  private int serviceType_ = 0;
  private String sign_ = null;
  private String thirdId_ = null;
  private String ts_ = null;
  
  public StoreRequestBean()
  {
    setUrl(a.a.b());
    setStoreApi("tlsApis");
    setSign_(com.huawei.updatesdk.service.a.b.a().b());
    setClientPackage_(com.huawei.updatesdk.sdk.service.a.a.a().b().getPackageName());
    setSalt_(com.huawei.updatesdk.sdk.a.d.a.b.b());
    setIv_(com.huawei.updatesdk.sdk.a.d.a.a(com.huawei.updatesdk.sdk.a.d.a.b.c()));
  }
  
  public String genBody()
    throws IllegalAccessException, IllegalArgumentException
  {
    return null;
  }
  
  public String getClientPackage_()
  {
    return this.clientPackage_;
  }
  
  public String getCno_()
  {
    return this.cno_;
  }
  
  public String getCode_()
  {
    return this.code_;
  }
  
  public String getIv_()
  {
    return this.iv_;
  }
  
  public String getLocale_()
  {
    return this.locale_;
  }
  
  public String getNet_()
  {
    return this.net_;
  }
  
  public String getSalt_()
  {
    return this.salt_;
  }
  
  public int getServiceType_()
  {
    return this.serviceType_;
  }
  
  public String getSign()
  {
    return getSign_();
  }
  
  public String getSign_()
  {
    return this.sign_;
  }
  
  public String getThirdId_()
  {
    return this.thirdId_;
  }
  
  public String getTs_()
  {
    return this.ts_;
  }
  
  public boolean isNeedSign()
  {
    return this.needSign;
  }
  
  public boolean isSerial()
  {
    return this.isSerial;
  }
  
  /* Error */
  protected void onSetValue()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setClientPackage_(String paramString)
  {
    this.clientPackage_ = paramString;
  }
  
  public void setCno_(String paramString)
  {
    this.cno_ = paramString;
  }
  
  public void setCode_(String paramString)
  {
    this.code_ = paramString;
  }
  
  public void setIv_(String paramString)
  {
    this.iv_ = paramString;
  }
  
  public void setLocale_(String paramString)
  {
    this.locale_ = paramString;
  }
  
  public void setNeedSign(boolean paramBoolean)
  {
    this.needSign = paramBoolean;
  }
  
  public void setNet_(String paramString)
  {
    this.net_ = paramString;
  }
  
  public void setSalt_(String paramString)
  {
    this.salt_ = paramString;
  }
  
  public void setSerial(boolean paramBoolean)
  {
    this.isSerial = paramBoolean;
  }
  
  public void setServiceType_(int paramInt)
  {
    this.serviceType_ = paramInt;
  }
  
  public void setSign(String paramString)
  {
    setSign_(paramString);
  }
  
  public void setSign_(String paramString)
  {
    this.sign_ = paramString;
  }
  
  public void setThirdId_(String paramString)
  {
    this.thirdId_ = paramString;
  }
  
  public void setTs_(String paramString)
  {
    this.ts_ = paramString;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\framework\bean\StoreRequestBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */