package com.huawei.hms.support.api.entity.sns;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class SnsMsg
  implements IMessageEntity
{
  @a
  private byte[] appIconData;
  @a
  private String appName;
  @a
  private boolean checkTargetApp;
  @a
  private String description;
  @a
  private byte[] linkIconData;
  @a
  private String targetAppMarketId;
  @a
  private String targetAppPackageName;
  @a
  private int targetAppVersionCode;
  @a
  private String title;
  @a
  private String url;
  @a
  private int urlType = 0;
  
  public byte[] getAppIconData()
  {
    return null;
  }
  
  public String getAppName()
  {
    return this.appName;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public byte[] getLinkIconData()
  {
    return null;
  }
  
  public String getTargetAppMarketId()
  {
    return this.targetAppMarketId;
  }
  
  public String getTargetAppPackageName()
  {
    return this.targetAppPackageName;
  }
  
  public int getTargetAppVersionCode()
  {
    return this.targetAppVersionCode;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public int getUrlType()
  {
    return this.urlType;
  }
  
  public boolean isCheckTargetApp()
  {
    return this.checkTargetApp;
  }
  
  public void setAppIconData(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    this.appIconData = ((byte[])paramArrayOfByte.clone());
  }
  
  public void setAppName(String paramString)
  {
    this.appName = paramString;
  }
  
  public void setCheckTargetApp(boolean paramBoolean)
  {
    this.checkTargetApp = paramBoolean;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
  }
  
  public void setLinkIconData(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    this.linkIconData = ((byte[])paramArrayOfByte.clone());
  }
  
  public void setTargetAppMarketId(String paramString)
  {
    this.targetAppMarketId = paramString;
  }
  
  public void setTargetAppPackageName(String paramString)
  {
    this.targetAppPackageName = paramString;
  }
  
  public void setTargetAppVersionCode(int paramInt)
  {
    this.targetAppVersionCode = paramInt;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void setUrlType(int paramInt)
  {
    this.urlType = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\sns\SnsMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */