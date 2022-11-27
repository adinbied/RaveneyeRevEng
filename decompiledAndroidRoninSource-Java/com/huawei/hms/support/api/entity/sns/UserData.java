package com.huawei.hms.support.api.entity.sns;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class UserData
  implements IMessageEntity
{
  @a
  private String account;
  @a
  private String displayName;
  @a
  private int gender;
  @a
  private String imageURL;
  @a
  private String region;
  @a
  private String signature;
  @a
  private long userId;
  
  public String getAccount()
  {
    return this.account;
  }
  
  public String getDisplayName()
  {
    return this.displayName;
  }
  
  public int getGender()
  {
    return this.gender;
  }
  
  public String getImageUrl()
  {
    return this.imageURL;
  }
  
  public String getRegion()
  {
    return this.region;
  }
  
  public String getSignature()
  {
    return this.signature;
  }
  
  public long getUserId()
  {
    return this.userId;
  }
  
  public void setAccount(String paramString)
  {
    this.account = paramString;
  }
  
  public void setDisplayName(String paramString)
  {
    this.displayName = paramString;
  }
  
  public void setGender(int paramInt)
  {
    this.gender = paramInt;
  }
  
  public void setImageUrl(String paramString)
  {
    this.imageURL = paramString;
  }
  
  public void setRegion(String paramString)
  {
    this.region = paramString;
  }
  
  public void setSignature(String paramString)
  {
    this.signature = paramString;
  }
  
  public void setUserId(long paramLong)
  {
    this.userId = paramLong;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\sns\UserData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */