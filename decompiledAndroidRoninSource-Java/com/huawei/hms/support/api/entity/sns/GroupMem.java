package com.huawei.hms.support.api.entity.sns;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class GroupMem
  implements IMessageEntity
{
  @a
  private String displayName;
  @a
  private String imagePath;
  @a
  private String joinTime;
  @a
  private long userId;
  
  public String getDisplayName()
  {
    return this.displayName;
  }
  
  public String getImagePath()
  {
    return this.imagePath;
  }
  
  public String getJoinTime()
  {
    return this.joinTime;
  }
  
  public long getUserId()
  {
    return this.userId;
  }
  
  public void setDisplayName(String paramString)
  {
    this.displayName = paramString;
  }
  
  public void setImagePath(String paramString)
  {
    this.imagePath = paramString;
  }
  
  public void setJoinTime(String paramString)
  {
    this.joinTime = paramString;
  }
  
  public void setUserId(long paramLong)
  {
    this.userId = paramLong;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\sns\GroupMem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */