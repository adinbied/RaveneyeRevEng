package com.huawei.updatesdk.framework.bean.startup;

import com.huawei.updatesdk.framework.bean.StoreResponseBean;
import com.huawei.updatesdk.sdk.service.storekit.bean.JsonBean;
import java.util.List;

public class StartupResponse
  extends StoreResponseBean
{
  public static final int SUCCESS = 0;
  private List<IPInfo> backips_;
  private String sign_;
  private int siteID_;
  
  public StartupResponse()
  {
    setRtnCode_(1);
  }
  
  public List<IPInfo> getBackips_()
  {
    return this.backips_;
  }
  
  public String getSign_()
  {
    return this.sign_;
  }
  
  public int getSiteID_()
  {
    return this.siteID_;
  }
  
  /* Error */
  public void saveBackupUrl()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void saveIpInfo(android.content.Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void saveParams()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setBackips_(List<IPInfo> paramList)
  {
    this.backips_ = paramList;
  }
  
  public void setSign_(String paramString)
  {
    this.sign_ = paramString;
  }
  
  public void setSiteID_(int paramInt)
  {
    this.siteID_ = paramInt;
  }
  
  public static class IPInfo
    extends JsonBean
  {
    private String uri_;
    private int use_;
    
    public String getUri_()
    {
      return this.uri_;
    }
    
    public int getUse_()
    {
      return this.use_;
    }
    
    public void setUri_(String paramString)
    {
      this.uri_ = paramString;
    }
    
    public void setUse_(int paramInt)
    {
      this.use_ = paramInt;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\framework\bean\startup\StartupResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */