package com.huawei.hms.support.api.entity.sns.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;
import com.huawei.hms.support.api.entity.sns.GroupMem;
import java.util.List;

public class GetGroupMemListResp
  implements IMessageEntity
{
  @a
  private List<GroupMem> groupMemList;
  
  public List<GroupMem> getGroupMemList()
  {
    return this.groupMemList;
  }
  
  public void setGroupMemList(List<GroupMem> paramList)
  {
    this.groupMemList = paramList;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\sns\internal\GetGroupMemListResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */