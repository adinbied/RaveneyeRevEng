package com.huawei.hms.support.api.entity.sns;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class Friend
  implements IMessageEntity
{
  @a
  private String displayName;
  @a
  private String imageUrl;
  @a
  private String phoneDigest;
  @a
  private long userId;
  
  public String getDisplayName()
  {
    return this.displayName;
  }
  
  public String getImageUrl()
  {
    return this.imageUrl;
  }
  
  public String getPhoneDigest()
  {
    return this.phoneDigest;
  }
  
  public long getUserId()
  {
    return this.userId;
  }
  
  public void setDisplayName(String paramString)
  {
    this.displayName = paramString;
  }
  
  public void setImageUrl(String paramString)
  {
    this.imageUrl = paramString;
  }
  
  public void setPhoneDigest(String paramString)
  {
    this.phoneDigest = paramString;
  }
  
  public void setUserId(long paramLong)
  {
    this.userId = paramLong;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\sns\Friend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */