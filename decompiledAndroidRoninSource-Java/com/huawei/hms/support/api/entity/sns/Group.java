package com.huawei.hms.support.api.entity.sns;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class Group
  implements IMessageEntity
{
  @a
  private long groupId;
  @a
  private int groupType;
  @a
  private String imagePath;
  @a
  private long managerUid;
  @a
  private String name;
  
  public long getGroupId()
  {
    return this.groupId;
  }
  
  public int getGroupType()
  {
    return this.groupType;
  }
  
  public String getImagePath()
  {
    return this.imagePath;
  }
  
  public long getManagerUid()
  {
    return this.managerUid;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setGroupId(long paramLong)
  {
    this.groupId = paramLong;
  }
  
  public void setGroupType(int paramInt)
  {
    this.groupType = paramInt;
  }
  
  public void setImagePath(String paramString)
  {
    this.imagePath = paramString;
  }
  
  public void setManagerUid(long paramLong)
  {
    this.managerUid = paramLong;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\sns\Group.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */