package com.huawei.hms.support.api.entity.sns.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;
import com.huawei.hms.support.api.entity.sns.Group;
import java.util.List;

public class GetGroupListResp
  implements IMessageEntity
{
  @a
  private List<Group> groups;
  
  public List<Group> getGroups()
  {
    return this.groups;
  }
  
  public void setGroups(List<Group> paramList)
  {
    this.groups = paramList;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\sns\internal\GetGroupListResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */